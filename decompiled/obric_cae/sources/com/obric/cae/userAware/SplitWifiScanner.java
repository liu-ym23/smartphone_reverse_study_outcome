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
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
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

        public AnonymousClass3(SplitWifiScanner r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass3 r8) {
            r8.lambda$onComplete$0();
        }

        private /* synthetic */ void lambda$onComplete$0() {
            SplitWifiScanner.access$102(this.this$0, ScanState.SCANNING_SECOND_PASS);
            SplitWifiScanner r8 = this.this$0;
            SplitWifiScanner.access$1100(r8, SplitWifiScanner.access$900(r8), SplitWifiScanner.access$1000(this.this$0));
        }

        @Override // com.obric.cae.userAware.SplitWifiScanner.ScanResultsConsumer
        public void onComplete(ScanResult[] r8) {
            CommSenseLog.d(SplitWifiScanner.TAG, "Strong channel scan results: " + r8.length);
            SplitWifiScanner.access$700(this.this$0).clear();
            SplitWifiScanner.access$700(this.this$0).addAll(Arrays.asList(r8));
            SplitWifiScanner.access$102(this.this$0, ScanState.WAITING_SECOND_PASS);
            SplitWifiScanner.access$800(this.this$0).post(new a(this, 2));
        }
    }

    public interface ScanResultCallback {
        void onScanCompleted(List<ScanResult> r8, boolean r10);
    }

    public interface ScanResultsConsumer {
        void onComplete(ScanResult[] r8);
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

        private ScanState(String r8, int r10) {
            super(r8, r10);
        }

        public static ScanState valueOf(String r8) {
            return (ScanState) Enum.valueOf(ScanState.class, r8);
        }

        public static ScanState[] values() {
            return (ScanState[]) $VALUES.clone();
        }
    }

    public SplitWifiScanner(Context r8) {
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
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mWifiManager = (WifiManager) r10.getSystemService("wifi");
        this.mWifiScanner = (WifiScanner) r10.getSystemService(WIFI_SCANNING_SERVICE);
        registerSystemScanReceiver();
        HandlerThread r11 = new HandlerThread("WifiSplitScanThread");
        this.mScanThread = r11;
        r11.start();
        this.mScanHandler = new Handler(r11.getLooper());
        this.mScanListener = new AnonymousClass1(this);
    }

    public static /* synthetic */ void a(SplitWifiScanner r8, Set r10) {
        r8.lambda$handlePostFullScan$1(r10);
    }

    public static /* synthetic */ ScanResultsConsumer access$000(SplitWifiScanner r8) {
        return r8.mPendingScanConsumer;
    }

    public static /* synthetic */ ScanResultsConsumer access$002(SplitWifiScanner r8, ScanResultsConsumer r10) {
        r8.mPendingScanConsumer = r10;
        return r10;
    }

    public static /* synthetic */ ScanResultsConsumer access$1000(SplitWifiScanner r8) {
        return r8.mRemainingFreqsConsumer;
    }

    public static /* synthetic */ ScanState access$102(SplitWifiScanner r8, ScanState r10) {
        r8.mScanState = r10;
        return r10;
    }

    public static /* synthetic */ void access$1100(SplitWifiScanner r8, Set r10, ScanResultsConsumer r11) {
        r8.startScanWithFrequencies(r10, r11);
    }

    public static /* synthetic */ ScanResultCallback access$1200(SplitWifiScanner r8) {
        return r8.mCurrentCallback;
    }

    public static /* synthetic */ WifiManager access$200(SplitWifiScanner r8) {
        return r8.mWifiManager;
    }

    public static /* synthetic */ boolean access$300(SplitWifiScanner r8) {
        return r8.mIsAfterFullScan;
    }

    public static /* synthetic */ boolean access$302(SplitWifiScanner r8, boolean r10) {
        r8.mIsAfterFullScan = r10;
        return r10;
    }

    public static /* synthetic */ void access$400(SplitWifiScanner r8, boolean r10, List r11) {
        r8.handlePostFullScan(r10, r11);
    }

    public static /* synthetic */ List access$500(SplitWifiScanner r8) {
        return r8.mLastFullScanResults;
    }

    public static /* synthetic */ List access$502(SplitWifiScanner r8, List r10) {
        r8.mLastFullScanResults = r10;
        return r10;
    }

    public static /* synthetic */ long access$602(SplitWifiScanner r8, long r10) {
        r8.mLastFullScanTime = r10;
        return r10;
    }

    public static /* synthetic */ List access$700(SplitWifiScanner r8) {
        return r8.mMergedResults;
    }

    public static /* synthetic */ Handler access$800(SplitWifiScanner r8) {
        return r8.mScanHandler;
    }

    public static /* synthetic */ Set access$900(SplitWifiScanner r8) {
        return r8.mPendingRemainingFreqs;
    }

    public static /* synthetic */ void b(SplitWifiScanner r8, Set r10) {
        r8.lambda$performSplitScan$0(r10);
    }

    private Set<Integer> getAllSupportedFrequencies() {
        Set<Integer> r8 = this.mCachedAllFreqs;
        if (r8 == null) goto L5;
        return r8;
    L5:
        HashSet r10 = new HashSet();
        int[] r11 = {1, 2};
        int r12 = 0;
    L6:
        if (r12 >= 2) goto L15;
        int r13 = r11[r12];
        List r14 = this.mWifiScanner.getAvailableChannels(r13);     // Catch: Exception -> L12
        if (r14 == null) goto L14;
        r10.addAll(r14);     // Catch: Exception -> L12
    L14:
        r12 = r12 + 1;
    L12:
        e = move-exception;
        Log.w(TAG, "getAvailableChannels failed for band: " + r13, e);
        goto L14
    L15:
        this.mCachedAllFreqs = r10;
        return r10;
    }

    private void handlePostFullScan(boolean r8, List<ScanResult> r10) {
        CommSenseLog.d(TAG, "Handling post full scan comparison: " + r8);
        if (r8 == true) goto L6;
        CommSenseLog.e(TAG, "Post full scan failed");
        this.mCurrentCallback.onScanCompleted(Collections.emptyList(), false);
        this.mScanState = ScanState.IDLE;
        return;
    L6:
        HashMap r11 = new HashMap();
        Iterator<ScanResult> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ScanResult r13 = r12.next();
        r11.put(r13.BSSID, r13);
        goto L8
    L10:
        HashSet r14 = new HashSet();
        if ((SystemClock.elapsedRealtime() - this.mLastFullScanTime) >= SCAN_TIMEOUT_MS) goto L22;
        Iterator<ScanResult> r15 = this.mLastFullScanResults.iterator();
    L14:
        if (r15.hasNext() == false) goto L23;
        ScanResult r16 = r15.next();
        if (r11.containsKey(r16.BSSID) == true) goto L14;
        if (r16.level <= SIGNAL_THRESHOLD_DBM) goto L14;
        if (TextUtils.isEmpty(r16.SSID) == true) goto L14;
        r14.add(Integer.valueOf(r16.frequency));
        CommSenseLog.d(TAG, "Missed AP: " + r16.SSID + " " + r16.BSSID + " freq=" + r16.frequency + " rssi=" + r16.level);
    L23:
        this.mPreviousFullScanResults = new ArrayList(this.mLastFullScanResults);
        this.mLastFullScanResults = r10;
        if (r14.isEmpty() == true) goto L26;
        CommSenseLog.d(TAG, "Starting scan for missed frequencies: " + r14);
        this.mScanHandler.post(new androidx.room.k(15, this, r14));
        return;
    L26:
        CommSenseLog.d(TAG, "No missed APs detected");
        this.mLastFullScanTime = SystemClock.elapsedRealtime();
        ScanResultCallback r17 = this.mCurrentCallback;
        if (r17 == null) goto L29;
        r17.onScanCompleted(r10, true);
    L29:
        this.mScanState = ScanState.IDLE;
        return;
    L22:
        CommSenseLog.d(TAG, "last full scan timeout, scanning all channels");
        goto L23
    }

    private /* synthetic */ void lambda$handlePostFullScan$1(Set r8) {
        this.mScanState = ScanState.SCANNING_SECOND_PASS;
        startScanWithFrequencies(r8, this.mMissedFreqsConsumer);
    }

    private /* synthetic */ void lambda$performSplitScan$0(Set r8) {
        startScanWithFrequencies(r8, this.mStrongFreqsConsumer);
    }

    private void performSplitScan(ScanResultCallback r8) {
        HashSet r10 = new HashSet();
        Iterator<ScanResult> r11 = this.mLastFullScanResults.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ScanResult r12 = r11.next();
        if (r12.level <= SIGNAL_THRESHOLD_DBM) goto L4;
        r10.add(Integer.valueOf(r12.frequency));
        goto L4
    L8:
        HashSet r13 = new HashSet(getAllSupportedFrequencies());
        r13.removeAll(r10);
        this.mCurrentCallback = r8;
        this.mPendingRemainingFreqs = r13;
        this.mScanState = ScanState.SCANNING_FIRST_PASS;
        this.mScanHandler.post(new androidx.appcompat.app.r(17, this, r10));
    }

    private void registerSystemScanReceiver() {
        IntentFilter r8 = new IntentFilter("android.net.wifi.SCAN_RESULTS");
        this.mContext.registerReceiver(new AnonymousClass2(this), r8);
    }

    private void startScanWithFrequencies(Set<Integer> r10, ScanResultsConsumer r11) {
        if (r10 != null) goto L5;
    L13:
        Log.d(TAG, "No frequencies to scan");
        r11.onComplete(new ScanResult[0]);
        return;
    L5:
        if (r10.isEmpty() == true) goto L13;
        WifiScanner.ChannelSpec[] r8 = new WifiScanner.ChannelSpec[r10.size()];
        Iterator<Integer> r12 = r10.iterator();
        int r13 = 0;
    L9:
        if (r12.hasNext() == false) goto L11;
        r8[r13] = new WifiScanner.ChannelSpec(r12.next().intValue());
        r13 = r13 + 1;
        goto L9
    L11:
        WifiScanner.ScanSettings r14 = new WifiScanner.ScanSettings();
        r14.band = 0;
        r14.channels = r8;
        r14.reportEvents = 1;
        this.mPendingScanConsumer = r11;
        Log.d(TAG, "Starting channel scan with frequencies: " + r10);
        this.mWifiScanner.startScan(r14, this.mScanListener);
    }

    private void startSystemFullScan(ScanResultCallback r8) {
        CommSenseLog.d(TAG, "startSystemFullScan start");
        if (this.mWifiManager.startScan() == true) goto L5;
        CommSenseLog.e(TAG, "startSystemFullScan failed");
        r8.onScanCompleted(Collections.emptyList(), false);
        return;
    L5:
        this.mMergedResults.clear();
        this.mScanState = ScanState.WAITING_SECOND_PASS;
        this.mCurrentCallback = r8;
        this.mIsAfterFullScan = true;
    }

    public void cleanup() {
        HandlerThread r8 = this.mScanThread;
        if (r8 == null) goto L6;
        r8.quitSafely();
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

    public void startSmartScan(ScanResultCallback r8) {
        startSystemFullScan(r8);
    }
}
