package com.obric.cae.userAware;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiScanner;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class SplitWifiScanner {
    private static final long SCAN_TIMEOUT_MS = 7000;
    private static final int SIGNAL_THRESHOLD_DBM = -75;
    private static final String TAG = "SplitWifiScanner";
    private static final String WIFI_SCANNING_SERVICE = "wifiscanner";
    private Set<Integer> mCachedAllFreqs;
    private final Context mContext;
    private ScanResultCallback mCurrentCallback;
    private boolean mIsAfterFullScan;
    private List<ScanResult> mLastFullScanResults;
    private long mLastFullScanTime;
    private final List<ScanResult> mMergedResults;
    private final ScanResultsConsumer mMissedFreqsConsumer;
    private Set<Integer> mPendingRemainingFreqs;
    private ScanResultsConsumer mPendingScanConsumer;
    private List<ScanResult> mPreviousFullScanResults;
    private ScanResultsConsumer mRemainingFreqsConsumer;
    private final Handler mScanHandler;
    private final WifiScanner.ScanListener mScanListener;
    private volatile ScanState mScanState;
    private final HandlerThread mScanThread;
    private ScanResultsConsumer mStrongFreqsConsumer;
    private final WifiManager mWifiManager;
    private final WifiScanner mWifiScanner;

    /* JADX INFO: renamed from: com.obric.cae.userAware.SplitWifiScanner$3, reason: invalid class name */
    public class AnonymousClass3 implements ScanResultsConsumer {
        final /* synthetic */ SplitWifiScanner this$0;

        public AnonymousClass3(SplitWifiScanner r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ void lambda$onComplete$0$SplitWifiScanner$3() {
            SplitWifiScanner.access$102(this.this$0, ScanState.SCANNING_SECOND_PASS);
            SplitWifiScanner r0 = this.this$0;
            SplitWifiScanner.access$1100(r0, SplitWifiScanner.access$900(r0), SplitWifiScanner.access$1000(this.this$0));
        }

        @Override // com.obric.cae.userAware.SplitWifiScanner.ScanResultsConsumer
        public void onComplete(ScanResult[] r3) {
            a.c(SplitWifiScanner.TAG, "Strong channel scan results: " + r3.length);
            SplitWifiScanner.access$700(this.this$0).clear();
            SplitWifiScanner.access$700(this.this$0).addAll(Arrays.asList(r3));
            SplitWifiScanner.access$102(this.this$0, ScanState.WAITING_SECOND_PASS);
            SplitWifiScanner.access$800(this.this$0).post(new $$Lambda$SplitWifiScanner$3$9AnoBnPpQ734qFKOoPRYXwH3mk8(this));
        }
    }

    public interface ScanResultCallback {
        void onScanCompleted(List<ScanResult> r1, boolean r2);
    }

    public interface ScanResultsConsumer {
        void onComplete(ScanResult[] r1);
    }

    public static final enum ScanState extends Enum<ScanState> {
        private static final /* synthetic */ ScanState[] $VALUES = null;
        public static final ScanState IDLE = null;
        public static final ScanState SCANNING_FIRST_PASS = null;
        public static final ScanState SCANNING_SECOND_PASS = null;
        public static final ScanState WAITING_SECOND_PASS = null;

        private static /* synthetic */ ScanState[] $values() {
            return new ScanState[]{IDLE, SCANNING_FIRST_PASS, WAITING_SECOND_PASS, SCANNING_SECOND_PASS};
        }

        static {
            IDLE = new ScanState("IDLE", 0);
            SCANNING_FIRST_PASS = new ScanState("SCANNING_FIRST_PASS", 1);
            WAITING_SECOND_PASS = new ScanState("WAITING_SECOND_PASS", 2);
            SCANNING_SECOND_PASS = new ScanState("SCANNING_SECOND_PASS", 3);
            $VALUES = $values();
        }

        private ScanState(String r1, int r2) {
            super(r1, r2);
        }

        public static ScanState valueOf(String r2) {
            return (ScanState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScanState.class, r2), ScanState.class, "com.obric.memorydata.plugin");
        }

        public static ScanState[] values() {
            return (ScanState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScanState[].class, "com.obric.memorydata.plugin");
        }
    }

    public SplitWifiScanner(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.mLastFullScanTime = 0;
        this.mLastFullScanResults = new ArrayList();
        this.mCachedAllFreqs = null;
        this.mMergedResults = new ArrayList();
        this.mPendingScanConsumer = null;
        this.mScanState = ScanState.IDLE;
        this.mPreviousFullScanResults = new ArrayList();
        this.mIsAfterFullScan = false;
        this.mStrongFreqsConsumer = new AnonymousClass3(this);
        this.mRemainingFreqsConsumer = new AnonymousClass4(this);
        this.mMissedFreqsConsumer = new AnonymousClass5(this);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mWifiManager = (WifiManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        this.mWifiScanner = (WifiScanner) ZeusTransformUtils.preCheckCast(r7.getSystemService(WIFI_SCANNING_SERVICE), WifiScanner.class, "com.obric.memorydata.plugin");
        registerSystemScanReceiver();
        HandlerThread r8 = new HandlerThread("WifiSplitScanThread");
        this.mScanThread = r8;
        r8.start();
        this.mScanHandler = new Handler(r8.getLooper());
        this.mScanListener = new AnonymousClass1(this);
    }

    public static /* synthetic */ ScanResultsConsumer access$000(SplitWifiScanner r0) {
        return r0.mPendingScanConsumer;
    }

    public static /* synthetic */ ScanResultsConsumer access$002(SplitWifiScanner r2, ScanResultsConsumer r3) {
        ScanResultsConsumer r4 = (ScanResultsConsumer) ZeusTransformUtils.wrapperContextForParams(r3, ScanResultsConsumer.class, "com.obric.memorydata.plugin");
        r2.mPendingScanConsumer = r4;
        return r4;
    }

    public static /* synthetic */ ScanResultsConsumer access$1000(SplitWifiScanner r0) {
        return r0.mRemainingFreqsConsumer;
    }

    public static /* synthetic */ ScanState access$102(SplitWifiScanner r0, ScanState r1) {
        r0.mScanState = r1;
        return r1;
    }

    public static /* synthetic */ void access$1100(SplitWifiScanner r2, Set r3, ScanResultsConsumer r4) {
        r2.startScanWithFrequencies((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), (ScanResultsConsumer) ZeusTransformUtils.wrapperContextForParams(r4, ScanResultsConsumer.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ ScanResultCallback access$1200(SplitWifiScanner r0) {
        return r0.mCurrentCallback;
    }

    public static /* synthetic */ WifiManager access$200(SplitWifiScanner r0) {
        return r0.mWifiManager;
    }

    public static /* synthetic */ boolean access$300(SplitWifiScanner r0) {
        return r0.mIsAfterFullScan;
    }

    public static /* synthetic */ boolean access$302(SplitWifiScanner r0, boolean r1) {
        r0.mIsAfterFullScan = r1;
        return r1;
    }

    public static /* synthetic */ void access$400(SplitWifiScanner r2, boolean r3, List r4) {
        r2.handlePostFullScan(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ List access$500(SplitWifiScanner r0) {
        return r0.mLastFullScanResults;
    }

    public static /* synthetic */ List access$502(SplitWifiScanner r2, List r3) {
        List<ScanResult> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.mLastFullScanResults = r4;
        return r4;
    }

    public static /* synthetic */ long access$602(SplitWifiScanner r0, long r1) {
        r0.mLastFullScanTime = r1;
        return r1;
    }

    public static /* synthetic */ List access$700(SplitWifiScanner r0) {
        return r0.mMergedResults;
    }

    public static /* synthetic */ Handler access$800(SplitWifiScanner r0) {
        return r0.mScanHandler;
    }

    public static /* synthetic */ Set access$900(SplitWifiScanner r0) {
        return r0.mPendingRemainingFreqs;
    }

    private Set<Integer> getAllSupportedFrequencies() {
        Set<Integer> r0 = this.mCachedAllFreqs;
        if (r0 == null) goto L5;
        return r0;
    L5:
        HashSet r1 = new HashSet();
        int[] r2 = {1, 2};
        int r3 = 0;
    L6:
        if (r3 >= 2) goto L15;
        int r4 = r2[r3];
        List r5 = this.mWifiScanner.getAvailableChannels(r4);     // Catch: Exception -> L12
        if (r5 == null) goto L14;
        r1.addAll(r5);     // Catch: Exception -> L12
    L14:
        r3 = r3 + 1;
    L12:
        e = move-exception;
        Log.w(TAG, "getAvailableChannels failed for band: " + r4, e);
        goto L14
    L15:
        this.mCachedAllFreqs = r1;
        return r1;
    }

    private void handlePostFullScan(boolean r8, List<ScanResult> r9) {
        List<ScanResult> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        a.c(TAG, "Handling post full scan comparison: " + r8);
        if (r8 == true) goto L6;
        a.i(TAG, "Post full scan failed");
        this.mCurrentCallback.onScanCompleted(Collections.emptyList(), false);
        this.mScanState = ScanState.IDLE;
        return;
    L6:
        HashMap r11 = new HashMap();
        Iterator<ScanResult> r0 = r10.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ScanResult r3 = (ScanResult) ZeusTransformUtils.preCheckCast(r0.next(), ScanResult.class, "com.obric.memorydata.plugin");
        r11.put(r3.BSSID, r3);
        goto L8
    L10:
        final HashSet r1 = new HashSet();
        if ((SystemClock.elapsedRealtime() - this.mLastFullScanTime) >= SCAN_TIMEOUT_MS) goto L22;
        Iterator<ScanResult> r4 = this.mLastFullScanResults.iterator();
    L14:
        if (r4.hasNext() == false) goto L23;
        ScanResult r5 = (ScanResult) ZeusTransformUtils.preCheckCast(r4.next(), ScanResult.class, "com.obric.memorydata.plugin");
        if (r11.containsKey(r5.BSSID) == true) goto L14;
        if (r5.level <= SIGNAL_THRESHOLD_DBM) goto L14;
        if (TextUtils.isEmpty(r5.SSID) == true) goto L14;
        r1.add(Integer.valueOf(r5.frequency));
        a.c(TAG, "Missed AP: " + r5.SSID + " " + r5.BSSID + " freq=" + r5.frequency + " rssi=" + r5.level);
    L23:
        this.mPreviousFullScanResults = new ArrayList(this.mLastFullScanResults);
        this.mLastFullScanResults = r10;
        if (r1.isEmpty() == true) goto L26;
        a.c(TAG, "Starting scan for missed frequencies: " + r1);
        this.mScanHandler.post(new $$Lambda$SplitWifiScanner$UVZsVjluRX6MiH8zYgwH_hSWXnM(this, r1));
        return;
    L26:
        a.c(TAG, "No missed APs detected");
        this.mLastFullScanTime = SystemClock.elapsedRealtime();
        ScanResultCallback r12 = this.mCurrentCallback;
        if (r12 == null) goto L29;
        r12.onScanCompleted(r10, true);
    L29:
        this.mScanState = ScanState.IDLE;
        return;
    L22:
        a.c(TAG, "last full scan timeout, scanning all channels");
        goto L23
    }

    private void performSplitScan(ScanResultCallback r7) {
        ScanResultCallback r8 = (ScanResultCallback) ZeusTransformUtils.wrapperContextForParams(r7, ScanResultCallback.class, "com.obric.memorydata.plugin");
        final HashSet r0 = new HashSet();
        Iterator<ScanResult> r2 = this.mLastFullScanResults.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ScanResult r3 = (ScanResult) ZeusTransformUtils.preCheckCast(r2.next(), ScanResult.class, "com.obric.memorydata.plugin");
        if (r3.level <= SIGNAL_THRESHOLD_DBM) goto L4;
        r0.add(Integer.valueOf(r3.frequency));
        goto L4
    L8:
        HashSet r4 = new HashSet(getAllSupportedFrequencies());
        r4.removeAll(r0);
        this.mCurrentCallback = r8;
        this.mPendingRemainingFreqs = r4;
        this.mScanState = ScanState.SCANNING_FIRST_PASS;
        this.mScanHandler.post(new $$Lambda$SplitWifiScanner$W9WfRwvZkt9X5hIi7D2nM7CZe_o(this, r0));
    }

    private void registerSystemScanReceiver() {
        IntentFilter r0 = new IntentFilter("android.net.wifi.SCAN_RESULTS");
        ZeusTransformUtils.registerReceiver(this.mContext, new AnonymousClass2(this), r0, "com.obric.memorydata.plugin");
    }

    private void startScanWithFrequencies(Set<Integer> r10, ScanResultsConsumer r11) {
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        ScanResultsConsumer r13 = (ScanResultsConsumer) ZeusTransformUtils.wrapperContextForParams(r11, ScanResultsConsumer.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
    L13:
        Log.d(TAG, "No frequencies to scan");
        r13.onComplete(new ScanResult[0]);
        return;
    L5:
        if (r12.isEmpty() == true) goto L13;
        WifiScanner.ChannelSpec[] r3 = new WifiScanner.ChannelSpec[r12.size()];
        Iterator r4 = r12.iterator();
        int r5 = 0;
    L9:
        if (r4.hasNext() == false) goto L11;
        r3[r5] = new WifiScanner.ChannelSpec(((Integer) ZeusTransformUtils.preCheckCast(r4.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r5 = r5 + 1;
        goto L9
    L11:
        WifiScanner.ScanSettings r1 = new WifiScanner.ScanSettings();
        r1.band = 0;
        r1.channels = r3;
        r1.reportEvents = 1;
        this.mPendingScanConsumer = r13;
        Log.d(TAG, "Starting channel scan with frequencies: " + r12);
        this.mWifiScanner.startScan(r1, this.mScanListener);
    }

    private void startSystemFullScan(ScanResultCallback r3) {
        ScanResultCallback r4 = (ScanResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ScanResultCallback.class, "com.obric.memorydata.plugin");
        a.c(TAG, "startSystemFullScan start");
        if (this.mWifiManager.startScan() == true) goto L5;
        a.i(TAG, "startSystemFullScan failed");
        r4.onScanCompleted(Collections.emptyList(), false);
        return;
    L5:
        this.mMergedResults.clear();
        this.mScanState = ScanState.WAITING_SECOND_PASS;
        this.mCurrentCallback = r4;
        this.mIsAfterFullScan = true;
    }

    public void cleanup() {
        HandlerThread r0 = this.mScanThread;
        if (r0 == null) goto L6;
        r0.quitSafely();
        return;
    }

    public boolean isScanning() {
        if (this.mScanState == ScanState.IDLE) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isWaitingSecondScan() {
        if (this.mScanState != ScanState.WAITING_SECOND_PASS) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ void lambda$handlePostFullScan$1$SplitWifiScanner(Set r3) {
        Set<Integer> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        this.mScanState = ScanState.SCANNING_SECOND_PASS;
        startScanWithFrequencies(r4, this.mMissedFreqsConsumer);
    }

    public /* synthetic */ void lambda$performSplitScan$0$SplitWifiScanner(Set r3) {
        startScanWithFrequencies((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), this.mStrongFreqsConsumer);
    }

    public void startSmartScan(ScanResultCallback r3) {
        startSystemFullScan((ScanResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ScanResultCallback.class, "com.obric.memorydata.plugin"));
    }
}
