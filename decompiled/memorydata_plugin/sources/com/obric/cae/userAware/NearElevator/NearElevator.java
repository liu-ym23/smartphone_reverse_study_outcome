package com.obric.cae.userAware.NearElevator;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.UserHandle;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.google.gson.Gson;
import com.obric.cae.libs.statemachine.e;
import com.obric.cae.libs.utils.f;
import com.obric.cae.location.cell.g;
import com.obric.cae.log.a;
import com.obric.cae.userAware.StepMovementGate;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.WifiScanConfigProvider;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.cae.utils.b;
import com.obric.livecard.api.utils.LiveCardConstant;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NearElevator {
    private static final String ACTION_CAE_NEAR_ELEVATOR = "com.obric.cae.ACTION_CAE_NEAR_ELEVATOR";
    private static final String ACTION_CAE_NEAR_ELEVATOR_PERMISSION = "com.obric.cae.permission.ACTION_CAE_NEAR_ELEVATOR";
    private static final String ANCHOR_DATA_FILE_NAME = "elevator_anchor_data.json";
    private static final long ANCHOR_EXPIRE_TIME = 0;
    private static final String ANCHOR_LIST_KEY = "elevator_scan_anchor_list";
    private static final int ANCHOR_MATCH_MIN_COUNT = 2;
    private static final int ANCHOR_MATCH_ROUGH_PERCENTAGE_THRESHOLD = 40;
    private static final long ANCHOR_MATCH_STEP_MOVEMENT_WINDOW_MS = 0;
    private static final long ANCHOR_NO_CONFIRM_EXPIRE_TIME = 0;
    private static final long CAE_APP_ID = 123456;
    private static final long DONT_ANCHOR_MATCH_WHEN_OUT_ELEVATOR_THRESHOLD = 30000;
    private static final int ELEVATOR_ANCHOR_CONFIRM_UPDATE_CNT_THRESHOLD = 3;
    private static final int ELEVATOR_ANCHOR_MAX_ERROR_MATCH_CNT_THRESHOLD = 10;
    private static final int ELEVATOR_ANCHOR_MAX_MATCH_TIMES_ONE_DAY_THRESHOLD = 20;
    private static final long ELEVATOR_MODEL_LOAD_RETRY_INTERVAL_MS = 0;
    public static final String ELEVATOR_WIFI_MATCH_MODEL_NAME = "cae_elevator_wifi_match";
    private static final int MAX_ELEVATOR_ANCHOR_NUM = 20;
    private static final int MODEL_FEATURE_SIZE = 3;
    private static final int NEAR_ELEVATOR_DETECTED_AND_IN_ELEVATOR_GAP_THRESHOLD = 120000;
    private static final int NETWORK_HANDOVER_IN_RADICAL_MODEL_TIME = 60000;
    private static final int SCAN_RESULT_SIZE_THRESHOLD = 3;
    private static final int STATE_CHANGE_TIME_WHEN_OUT_ELEVATOR = 10000;
    private static final String TAG = "NearElevator";
    public static final int WIFI_SCAN_CALL_MIN_INTERVAL = 3000;
    public static final int WIFI_SCAN_INTERVAL_WHEN_NEAR_ELEVATOR = 2000;
    public static final int WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR = 1500;
    private static final long WIFI_SCAN_RESULT_PROCESS_INTERVAL_MS = 5000;
    public static final int WIFI_SCAN_TIMEOUT_WHEN_NEAR_ELEVATOR = 2000;
    public static final int WIFI_SCAN_TIMEOUT_WHEN_OUT_ELEVATOR = 6000;
    public static final int WIFI_SCAN_TIMES_WHEN_NEAR_ELEVATOR = 1;
    public static final int WIFI_SCAN_TIMES_WHEN_OUT_ELEVATOR = 3;
    private static volatile NearElevator mNearElevatorInstance;
    private final File mAnchorDataFilePath;
    private final AtomicBoolean mAsyncInitStarted;
    private final Context mContext;
    private int mElevatorIdCount;
    private int mElevatorMatchTimesOneDay;
    private long mElevatorMatchTimesOneDayTimer;
    private final ConcurrentLinkedDeque<AnchorData> mElevatorScanAnchorList;
    private final Gson mGson;
    public boolean mInferenceResult;
    public final AtomicBoolean mIsInferenceRunning;
    public final AtomicBoolean mIsScanning;
    private final boolean mIsUseAIKernel;
    private long mLastElevatorModelLoadTime;
    private long mLastGetScanResultTime;
    public int mMatchAnchorElevatorId;
    private int mMatchedElevatorUpdateCnt;
    private final List<WifiDataPair> mMatchedWifiDataPairs;
    private long mNearElevatorDetectedTime;
    NearElevatorListener mNearElevatorListener;
    private int mOutElevatorScanCnt;
    private long mOutElevatorTime;
    private WifiScanConfigProvider mScanConfigProvider;
    private final AtomicReference<ScanReason> mScanReason;
    private long mStartScanTime;
    private final StepMovementGate mStepMovementGate;
    private WifiAwareInfoManager mWifiAwareInfoManager;
    private final List<WifiDataPair> mWifiDataPairs;
    private WifiManager mWifiManager;
    private final AtomicBoolean mWifiReceiverRegistered;
    private final LinkedBlockingQueue<List<ScanResult>> mWifiScanResultQueue;

    public static class AnchorData {
        Map<String, WifiScanDataForAI> anchorMap;
        int elevatorId;
        int errorMatchCnt;
        int updateCnt;
        long updateTimestamp;

        private AnchorData() {
            this.anchorMap = new ConcurrentSkipListMap();
        }

        public /* synthetic */ AnchorData(AnonymousClass1 r1) {
            this();
        }
    }

    public static class InnerNearElevatorData {
        private final int elevatorId;
        private final int elevatorUpdateCnt;
        private final boolean isInElevator;
        private final List<WifiDataPair> wifiDataPairs;

        public InnerNearElevatorData(boolean r3, int r4, int r5, List<WifiDataPair> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            this.isInElevator = r3;
            this.elevatorId = r4;
            this.elevatorUpdateCnt = r5;
            if (r7 == null) goto L5;
            ArrayList r8 = new ArrayList(r7);
        L6:
            this.wifiDataPairs = r8;
            return;
        L5:
            r8 = new ArrayList();
            goto L6
        }

        public int getElevatorId() {
            return this.elevatorId;
        }

        public int getElevatorUpdateCnt() {
            return this.elevatorUpdateCnt;
        }

        public List<WifiDataPair> getWifiDataPairs() {
            return this.wifiDataPairs;
        }

        public boolean isInElevator() {
            return this.isInElevator;
        }
    }

    public interface NearElevatorListener {
        void inElevatorEvent();

        void nearElevatorEvent(int r1);

        void outElevatorAndAnchorUpdate(int r1, int r2);

        void outElevatorEvent();
    }

    public static final enum ScanReason extends Enum<ScanReason> {
        private static final /* synthetic */ ScanReason[] $VALUES = null;
        public static final ScanReason ANCHOR_MATCH = null;
        public static final ScanReason ANCHOR_MATCH_TEST = null;
        public static final ScanReason CONNECT_WIFI = null;
        public static final ScanReason OUT_ELEVATOR = null;
        public static final ScanReason OUT_ELEVATOR_TEST = null;

        private static /* synthetic */ ScanReason[] $values() {
            return new ScanReason[]{OUT_ELEVATOR, OUT_ELEVATOR_TEST, CONNECT_WIFI, ANCHOR_MATCH, ANCHOR_MATCH_TEST};
        }

        static {
            OUT_ELEVATOR = new ScanReason("OUT_ELEVATOR", 0);
            OUT_ELEVATOR_TEST = new ScanReason("OUT_ELEVATOR_TEST", 1);
            CONNECT_WIFI = new ScanReason("CONNECT_WIFI", 2);
            ANCHOR_MATCH = new ScanReason("ANCHOR_MATCH", 3);
            ANCHOR_MATCH_TEST = new ScanReason("ANCHOR_MATCH_TEST", 4);
            $VALUES = $values();
        }

        private ScanReason(String r1, int r2) {
            super(r1, r2);
        }

        public static ScanReason valueOf(String r2) {
            return (ScanReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScanReason.class, r2), ScanReason.class, "com.obric.memorydata.plugin");
        }

        public static ScanReason[] values() {
            return (ScanReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScanReason[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class WifiDataPair {
        private final WifiScanDataForAI anchorWifiData;
        private final WifiScanDataForAI newWifiData;

        public WifiDataPair(WifiScanDataForAI r1, WifiScanDataForAI r2) {
            this.newWifiData = r1;
            this.anchorWifiData = r2;
        }

        public WifiScanDataForAI getAnchorWifiData() {
            return this.anchorWifiData;
        }

        public WifiScanDataForAI getNewWifiData() {
            return this.newWifiData;
        }
    }

    public static class WifiScanDataForAI {
        String bssid;
        int channelWidth;
        int freq;
        int rssi;
        long timestamp;

        public WifiScanDataForAI(String r1, int r2, int r3, int r4, long r5) {
            this.bssid = r1;
            this.rssi = r2;
            this.freq = r3;
            this.channelWidth = r4;
            this.timestamp = r5;
        }

        public String getBssid() {
            return this.bssid;
        }

        public int getChannelWidth() {
            return this.channelWidth;
        }

        public int getFreq() {
            return this.freq;
        }

        public int getRssi() {
            return this.rssi;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public String toString() {
            return "WifiScanDataForAI{bssid=" + f.a(this.bssid) + ", rssi=" + this.rssi + ", freq=" + this.freq + ", channelWidth=" + this.channelWidth + ", timestamp=" + this.timestamp + '}';
        }
    }

    static {
        TimeUnit r0 = TimeUnit.DAYS;
        ANCHOR_EXPIRE_TIME = r0.toMillis(30);
        ANCHOR_NO_CONFIRM_EXPIRE_TIME = r0.toMillis(7);
        ANCHOR_MATCH_STEP_MOVEMENT_WINDOW_MS = TimeUnit.MINUTES.toMillis(5);
        ELEVATOR_MODEL_LOAD_RETRY_INTERVAL_MS = TimeUnit.HOURS.toMillis(1);
    }

    private NearElevator(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.mIsScanning = new AtomicBoolean(false);
        this.mIsInferenceRunning = new AtomicBoolean(false);
        this.mInferenceResult = false;
        this.mMatchAnchorElevatorId = 0;
        this.mIsUseAIKernel = true;
        this.mWifiScanResultQueue = new LinkedBlockingQueue();
        this.mElevatorScanAnchorList = new ConcurrentLinkedDeque();
        this.mGson = new Gson();
        this.mElevatorIdCount = 1;
        this.mWifiDataPairs = new ArrayList();
        this.mMatchedWifiDataPairs = new ArrayList();
        this.mMatchedElevatorUpdateCnt = 0;
        this.mElevatorMatchTimesOneDay = 0;
        this.mElevatorMatchTimesOneDayTimer = 0;
        this.mScanReason = new AtomicReference(ScanReason.ANCHOR_MATCH);
        this.mAsyncInitStarted = new AtomicBoolean(false);
        this.mWifiReceiverRegistered = new AtomicBoolean(false);
        this.mLastGetScanResultTime = 0;
        a.e(TAG, "NearElevator constructor");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.mStepMovementGate = new StepMovementGate(r9);
        this.mAnchorDataFilePath = r9.getFilesDir();
        scanResultAcceptThread();
        startAsyncInit();
    }

    public static /* synthetic */ WifiManager access$000(NearElevator r0) {
        return r0.mWifiManager;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ Context access$200(NearElevator r0) {
        return r0.mContext;
    }

    private String anchorListIdString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<AnchorData> r5 = this.mElevatorScanAnchorList.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        AnchorData r1 = (AnchorData) ZeusTransformUtils.preCheckCast(r5.next(), AnchorData.class, "com.obric.memorydata.plugin");
        if (r0.length() <= 0) goto L8;
        r0.append(", ");
    L8:
        r0.append(r1.elevatorId).append("(").append(r1.updateTimestamp).append(")");
        goto L4
    L10:
        return r0.toString();
    }

    private void anchorUpdate(List<WifiScanDataForAI> r7, Map<String, WifiScanDataForAI> r8) {
        List<WifiScanDataForAI> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Map<String, WifiScanDataForAI> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        AnchorData r2 = findMatchedAnchor(r9, true);     // Catch: IOException -> L16
        if (r2 == null) goto L7;
        int r11 = r2.anchorMap.size();
        mergeAnchorOldWithNew(r9, r2);
        this.mElevatorScanAnchorList.remove(r2);
        this.mElevatorScanAnchorList.addFirst(r2);
        a.e(TAG, e.a(new StringBuilder("merge old anchor with new, elevatorId: "), r2.elevatorId, " oldMatchAnchorSize: ", r11, " newAnchorSize: ").append(r2.anchorMap.size()).append(" updateCnt: ").append(r2.updateCnt).append(" anchor list size: ").append(this.mElevatorScanAnchorList.size()).toString());
        int r12 = r2.elevatorId;
    L11:
        NearElevatorListener r13 = this.mNearElevatorListener;
        if (r13 == null) goto L14;
        r13.outElevatorAndAnchorUpdate(this.mElevatorScanAnchorList.size(), r12);
    L14:
        saveAnchorListToStorage();
        return;
    L7:
        AnchorData r14 = new AnchorData(null);
        int r3 = this.mElevatorIdCount;
        r14.elevatorId = r3;
        this.mElevatorIdCount = r3 + 1;
        r14.updateCnt = 1;
        r14.updateTimestamp = System.currentTimeMillis();
        r14.anchorMap = r10;
        this.mElevatorScanAnchorList.addFirst(r14);
        String r15 = TAG;
        a.e(r15, "add new wifi anchor, elevatorId: " + r14.elevatorId + " updateCnt: " + r14.updateCnt + ", anchor list size: " + this.mElevatorScanAnchorList.size());
        if (this.mElevatorScanAnchorList.size() <= 20) goto L10;
        AnchorData r0 = (AnchorData) ZeusTransformUtils.preCheckCast(this.mElevatorScanAnchorList.removeLast(), AnchorData.class, "com.obric.memorydata.plugin");
        a.e(r15, "remove oldest anchor , elevatorId: " + r0.elevatorId + ", updateTimestamp: " + r0.updateTimestamp + ", now anchor list size: " + this.mElevatorScanAnchorList.size());
    L10:
        r12 = r14.elevatorId;
    L16:
        e = move-exception;
        a.a(TAG, "anchorUpdate, IOException", e);
    }

    private void checkAnchorErrorMatchCnt() {
        AnchorData r0 = findAnchorById(this.mMatchAnchorElevatorId);
        if (r0 != null) goto L6;
        a.i(TAG, "checkAnchorErrorMatchCnt, not found anchor with elevatorId: " + this.mMatchAnchorElevatorId);
        return;
    L6:
        r0.errorMatchCnt++;
        String r1 = TAG;
        g.a(new StringBuilder("checkAnchorErrorMatchCnt, elevatorId: ").append(r0.elevatorId).append(", errorMatchCnt: "), r0.errorMatchCnt, r1);
        if (r0.errorMatchCnt < 10) goto L10;
        a.e(r1, "Remove anchor cause of errorMatchCnt over threshold, elevatorId: " + r0.elevatorId + ", errorCount: " + r0.errorMatchCnt + ", threshold: 10, isRemoved: " + this.mElevatorScanAnchorList.remove(r0));
        return;
    }

    private boolean checkAndMarkElevatorModelLoadCooldown() {
        long r0 = System.currentTimeMillis();
        long r2 = this.mLastElevatorModelLoadTime;
        long r4 = r0 - r2;
        if (r2 > 0) goto L5;
    L8:
        this.mLastElevatorModelLoadTime = r0;
        return false;
    L5:
        if (r4 >= ELEVATOR_MODEL_LOAD_RETRY_INTERVAL_MS) goto L8;
        a.e(TAG, "skip elevator model load in cooldown, elapsed=" + r4);
        return true;
    }

    private AnchorData findAnchorById(final int r2) {
        return (AnchorData) ZeusTransformUtils.preCheckCast(this.mElevatorScanAnchorList.stream().filter(new $$Lambda$NearElevator$CGZkQWVBQD9RIfUnByShci4b5M(r2)).findFirst().orElse(null), AnchorData.class, "com.obric.memorydata.plugin");
    }

    private synchronized AnchorData findMatchedAnchor(List<WifiScanDataForAI> r14, boolean r15) {
        monitor-enter(this);
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        this.mWifiDataPairs.clear();     // Catch: Throwable -> L40
        int r0 = (r16.size() * 40) / 100;     // Catch: Throwable -> L40
        a.e(TAG, "new wifiScanData size: " + r16.size() + " threshold: " + r0 + " anchor list size: " + this.mElevatorScanAnchorList.size());     // Catch: Throwable -> L40
        this.mIsInferenceRunning.set(true);     // Catch: Throwable -> L40
        Iterator<AnchorData> r1 = this.mElevatorScanAnchorList.iterator();     // Catch: Throwable -> L40
    L5:
        if (r1.hasNext() == false) goto L36;
        AnchorData r2 = (AnchorData) ZeusTransformUtils.preCheckCast(r1.next(), AnchorData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        Map<String, WifiScanDataForAI> r4 = r2.anchorMap;     // Catch: Throwable -> L40
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L40
        int r7 = r2.updateCnt;     // Catch: Throwable -> L40
        if (r7 < 3) goto L9;
        long r9 = ANCHOR_EXPIRE_TIME;     // Catch: Throwable -> L40
    L11:
        if ((r5 - r2.updateTimestamp) <= r9) goto L14;
        r1.remove();     // Catch: Throwable -> L40
        String r3 = TAG;     // Catch: Throwable -> L40
        String r6 = "remove expired wifi anchor id " + r2.elevatorId + ", updateCnt: " + r2.updateCnt + ", anchor list size: " + this.mElevatorScanAnchorList.size();     // Catch: Throwable -> L40
    L13:
        a.e(r3, r6);     // Catch: Throwable -> L40
        goto L5
    L14:
        if (r15 == true) goto L17;
        if (r7 >= 3) goto L17;
        r3 = TAG;     // Catch: Throwable -> L40
        r6 = "anchor updateCnt " + r2.updateCnt + " not reach threshold, don't match.";     // Catch: Throwable -> L40
    L17:
        Iterator r8 = r16.iterator();     // Catch: Throwable -> L40
        int r10 = 0;
    L19:
        if (r8.hasNext() == false) goto L35;
        WifiScanDataForAI r11 = (WifiScanDataForAI) ZeusTransformUtils.preCheckCast(r8.next(), WifiScanDataForAI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        WifiScanDataForAI r12 = (WifiScanDataForAI) ZeusTransformUtils.preCheckCast(r4.get(r11.bssid), WifiScanDataForAI.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (r12 == null) goto L19;
        float r13 = runInference(r11, r12);     // Catch: Throwable -> L40
        if (r13 < 0.0f) goto L33;
        this.mWifiDataPairs.add(new WifiDataPair(r11, r12));     // Catch: Throwable -> L40
        a.c(TAG, "Inference result: " + r13 + ", scanData: " + r11 + ", anchor: " + r12);     // Catch: Throwable -> L40
        if (r13 <= 0.5d) goto L19;
        r10 = r10 + 1;     // Catch: Throwable -> L40
        if (r10 < 2) goto L19;
        if (r10 < r0) goto L19;
        this.mIsInferenceRunning.set(false);     // Catch: Throwable -> L40
        monitor-exit(this);
        return r2;
    L33:
        a.i(TAG, "runInference failed, something wrong with AIKernel");     // Catch: Throwable -> L40
        throw new IOException("runInference exception");     // Catch: Throwable -> L40
    L35:
        r3 = TAG;     // Catch: Throwable -> L40
        r6 = e.a(new StringBuilder("anchor id "), r2.elevatorId, " matchCount: ", r10, " threshold: ").append(r0).append(" anchorSize: ").append(r4.size()).toString();     // Catch: Throwable -> L40
        goto L13
    L9:
        r9 = ANCHOR_NO_CONFIRM_EXPIRE_TIME;     // Catch: Throwable -> L40
        goto L11
    L36:
        this.mIsInferenceRunning.set(false);     // Catch: Throwable -> L40
        monitor-exit(this);
        return null;
    L40:
        th = move-exception;
        throw th;
    }

    private int getElevatorInterval(int r3, int r4) {
        long r2 = getScanConfigProvider().getActiveConfigSnapshot().getSceneIntervalMs(r3);
        if (r2 > 0) goto L5;
        return r4;
    L5:
        return (int) Math.min(r2, 2147483647L);
    }

    private int getElevatorInterval(WifiScanConfigProvider.ActiveConfigSnapshot r3, int r4, int r5) {
        long r2 = r3.getSceneIntervalMs(r4);
        if (r2 > 0) goto L5;
        return r5;
    L5:
        return (int) Math.min(r2, 2147483647L);
    }

    private int getElevatorScanTimes(int r1, int r2) {
        int r0 = getScanConfigProvider().getActiveConfigSnapshot().getSceneScanTimes(r1);
        if (r0 > 0) goto L5;
        return r2;
    L5:
        return r0;
    }

    private int getElevatorTotalTimeout(int r3, int r4) {
        long r2 = getScanConfigProvider().getActiveConfigSnapshot().getSceneTotalTimeoutMs(r3);
        if (r2 > 0) goto L5;
        return r4;
    L5:
        return (int) Math.min(r2, 2147483647L);
    }

    private int getElevatorTotalTimeout(WifiScanConfigProvider.ActiveConfigSnapshot r3, int r4, int r5) {
        long r2 = r3.getSceneTotalTimeoutMs(r4);
        if (r2 > 0) goto L5;
        return r5;
    L5:
        return (int) Math.min(r2, 2147483647L);
    }

    public static synchronized NearElevator getInstance(Context r3) {
        monitor-enter(NearElevator.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (UserAwareUtil.isNearElevatorWifiMatchSupported(r4) == true) goto L10;
        a.e(TAG, "NearElevator not supported");     // Catch: Throwable -> L24
        monitor-exit(NearElevator.class);
        return null;
    L10:
        a.e(TAG, "NearElevator supported");     // Catch: Throwable -> L24
        if (mNearElevatorInstance != null) goto L21;
        monitor-enter(NearElevator.class);     // Catch: Throwable -> L24
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L14:
        if (mNearElevatorInstance != null) goto L16;
        mNearElevatorInstance = new NearElevator(r4);     // Catch: Throwable -> L18
    L16:
        monitor-exit(NearElevator.class);     // Catch: Throwable -> L18
    L21:
        NearElevator r5 = mNearElevatorInstance;     // Catch: Throwable -> L24
        monitor-exit(NearElevator.class);
        return r5;
    L24:
        th = move-exception;
        throw th;
    }

    private WifiScanConfigProvider getScanConfigProvider() {
        if (this.mScanConfigProvider != null) goto L6;
        this.mScanConfigProvider = WifiScanConfigProvider.getInstance(this.mContext);
    L6:
        return this.mScanConfigProvider;
    }

    private boolean hasRecentStepMovement() {
        this.mStepMovementGate.ensureStarted();
        return this.mStepMovementGate.allowScanNow(ANCHOR_MATCH_STEP_MOVEMENT_WINDOW_MS);
    }

    static /* synthetic */ boolean lambda$findAnchorById$1(int r0, AnchorData r1) {
        if (r1.elevatorId != r0) goto L5;
        return true;
    L5:
        return false;
    }

    private void loadAnchorListFromStorage() {
        File r7 = new File(this.mAnchorDataFilePath, ANCHOR_DATA_FILE_NAME);     // Catch: Exception -> L45
        if (r7.exists() == true) goto L7;
        a.e(TAG, "Anchor data file not exists");     // Catch: Exception -> L45
        return;
    L7:
        BufferedReader r8 = new BufferedReader(new FileReader(r7));     // Catch: Exception -> L45
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L45
    L8:
        String r10 = r8.readLine();     // Catch: Exception -> L45
        if (r10 == null) goto L11;
        r9.append(r10);     // Catch: Exception -> L45
        goto L8
    L11:
        r8.close();     // Catch: Exception -> L45
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(this.mGson.fromJson(r9.toString(), new AnonymousClass2(this).getType()), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L45
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.containsKey(ANCHOR_LIST_KEY) == false) goto L55;
        JSONArray r12 = new JSONArray(new Gson().toJson(r11.get(ANCHOR_LIST_KEY)));     // Catch: Exception -> L45
        this.mElevatorScanAnchorList.clear();     // Catch: Exception -> L45
        int r5 = 0;
    L17:
        if (r5 >= r12.length()) goto L41;
        JSONObject r13 = r12.getJSONObject(r5);     // Catch: Exception -> L45
        AnchorData r14 = new AnchorData(null);     // Catch: Exception -> L45
        if (r13.has("elevatorId") == false) goto L22;
        r14.elevatorId = r13.getInt("elevatorId");     // Catch: Exception -> L45
    L22:
        if (r13.has("updateCnt") == false) goto L25;
        r14.updateCnt = r13.getInt("updateCnt");     // Catch: Exception -> L45
    L25:
        if (r13.has("errorMatchCnt") == false) goto L28;
        r14.errorMatchCnt = r13.getInt("errorMatchCnt");     // Catch: Exception -> L45
    L28:
        if (r13.has(LiveCardConstant.ISLAND_EXT_KEY_UPDATE_TIMESTAMP) == false) goto L31;
        r14.updateTimestamp = r13.getLong(LiveCardConstant.ISLAND_EXT_KEY_UPDATE_TIMESTAMP);     // Catch: Exception -> L45
    L31:
        if (r13.has("anchorMap") == false) goto L37;
        JSONObject r15 = r13.getJSONObject("anchorMap");     // Catch: Exception -> L45
        Iterator<String> r16 = r15.keys();     // Catch: Exception -> L45
    L34:
        if (r16.hasNext() == false) goto L37;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L45
        r14.anchorMap.put(r17, (WifiScanDataForAI) ZeusTransformUtils.preCheckCast(this.mGson.fromJson(r15.getJSONObject(r17).toString(), WifiScanDataForAI.class), WifiScanDataForAI.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L45
    L37:
        if (r14.anchorMap.isEmpty() == true) goto L39;
        this.mElevatorScanAnchorList.add(r14);     // Catch: Exception -> L45
    L39:
        r5 = r5 + 1;     // Catch: Exception -> L45
        goto L17
    L41:
        if (this.mElevatorScanAnchorList.isEmpty() == true) goto L43;
        this.mElevatorIdCount = ((AnchorData) ZeusTransformUtils.preCheckCast(this.mElevatorScanAnchorList.getLast(), AnchorData.class, "com.obric.memorydata.plugin")).elevatorId + 1;     // Catch: Exception -> L45
    L43:
        a.e(TAG, "Loaded elevator anchor list from storage, size: " + this.mElevatorScanAnchorList.size());     // Catch: Exception -> L45
        return;
    L55:
        return;
    L45:
        e = move-exception;
        a.i(TAG, "Failed to load elevator anchor list: " + e.getMessage());
    }

    private void mergeAnchorOldWithNew(List<WifiScanDataForAI> r8, AnchorData r9) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        WifiScanDataForAI r10 = (WifiScanDataForAI) ZeusTransformUtils.preCheckCast(r7.next(), WifiScanDataForAI.class, "com.obric.memorydata.plugin");
        r9.anchorMap.put(r10.bssid, r10);
        goto L4
    L6:
        long r11 = System.currentTimeMillis();
        r9.updateCnt++;
        r9.updateTimestamp = r11;
        Iterator<Map.Entry<String, WifiScanDataForAI>> r1 = r9.anchorMap.entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        WifiScanDataForAI r2 = (WifiScanDataForAI) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), WifiScanDataForAI.class, "com.obric.memorydata.plugin");
        if ((r11 - r2.timestamp) <= ANCHOR_EXPIRE_TIME) goto L8;
        r1.remove();
        a.c(TAG, "remove expired WifiScanData, bssid: " + r2.bssid);
        goto L8
    L13:
        if (r9.updateCnt < 3) goto L22;
        a.e(TAG, "matchedAnchor confirmed, id: " + r9.elevatorId + " updateCnt: " + r9.updateCnt + " updateTimestamp: " + r9.updateTimestamp + " anchorSize: " + r9.anchorMap.size());
        return;
    }

    private float[] prepareFeatures(WifiScanDataForAI r3, WifiScanDataForAI r4) {
        float[] r2 = new float[3];
        r2[0] = Math.abs(r4.rssi);
        r2[1] = Math.abs(r4.rssi - r3.rssi);
        if (com.obric.cae.libs.utils.a.a(r3.freq) == false) goto L5;
        float r5 = 0.0f;
    L6:
        r2[2] = r5;
        return r2;
    L5:
        r5 = 1.0f;
        goto L6
    }

    private void regWifiBroadcastReceiver() {
        if (this.mWifiReceiverRegistered.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.mWifiManager = (WifiManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.wifi.SCAN_RESULTS");
        PluginBroadcastReceiver r1 = new AnonymousClass1(this);
        ZeusTransformUtils.registerReceiver(this.mContext, r1, r0, "com.obric.memorydata.plugin");
    }

    private float runInference(WifiScanDataForAI r1, WifiScanDataForAI r2) {
        Float r0 = b.a(ELEVATOR_WIFI_MATCH_MODEL_NAME, "wifi_scan_features", prepareFeatures(r1, r2));
        if (r0 != null) goto L7;
        a.i(TAG, "runModelInferenceSync failed");
        return -1.0f;
    L7:
        return r0.floatValue();
    }

    private void saveAnchorListToStorage() {
        HashMap r1 = new HashMap();     // Catch: Exception -> L5
        r1.put(ANCHOR_LIST_KEY, this.mElevatorScanAnchorList);     // Catch: Exception -> L5
        String r2 = this.mGson.toJson(r1);     // Catch: Exception -> L5
        BufferedWriter r3 = new BufferedWriter(new FileWriter(new File(this.mAnchorDataFilePath, ANCHOR_DATA_FILE_NAME)));     // Catch: Exception -> L5
        r3.write(r2);     // Catch: Exception -> L5
        r3.close();     // Catch: Exception -> L5
        a.e(TAG, "Saved elevator anchor list to storage, size: " + this.mElevatorScanAnchorList.size() + ", anchorListId: " + anchorListIdString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a.i(TAG, "Failed to save elevator anchor list: " + e.getMessage());
    }

    private void scanDataAnchorMatch(List<WifiScanDataForAI> r7, long r8) {
        List<WifiScanDataForAI> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if ((r8 - this.mElevatorMatchTimesOneDayTimer) < TimeUnit.DAYS.toMillis(1)) goto L5;
        a.e(TAG, "reset mElevatorMatchTimesOneDay " + this.mElevatorMatchTimesOneDay + " to 0");
        this.mElevatorMatchTimesOneDay = 0;
        this.mElevatorMatchTimesOneDayTimer = r8;
    L5:
        AnchorData r10 = null;
    L20:
        e = move-exception;
        a.a(TAG, "scanDataAnchorMatch, IOException", e);
        this.mInferenceResult = false;
        return;
    L7:
        if (this.mElevatorMatchTimesOneDay >= 20) goto L9;
        r10 = findMatchedAnchor(r9, false);     // Catch: IOException -> L20
    L10:
        String r11 = TAG;
        if (r10 == null) goto L18;
        g.a(new StringBuilder("match anchor ").append(this.mElevatorMatchTimesOneDay).append(" times, updateCnt: ").append(r10.updateCnt).append(", elevatorId: "), r10.elevatorId, r11);
        this.mElevatorMatchTimesOneDay++;
        sendNearElevatorBroadcast(r10.elevatorId);
        if (this.mNearElevatorListener != null) goto L15;
    L17:
        this.mScanReason.set(ScanReason.ANCHOR_MATCH);
        this.mInferenceResult = true;
        this.mMatchAnchorElevatorId = r10.elevatorId;
        this.mNearElevatorDetectedTime = System.currentTimeMillis();
        this.mMatchedWifiDataPairs.clear();
        this.mMatchedWifiDataPairs.addAll(this.mWifiDataPairs);
        this.mMatchedElevatorUpdateCnt = r10.updateCnt;
        return;
    L15:
        if (this.mScanReason.get() != ScanReason.ANCHOR_MATCH) goto L17;
        this.mNearElevatorListener.nearElevatorEvent(r10.elevatorId);
        goto L17
    L18:
        a.e(r11, "not match anchor");
        this.mInferenceResult = false;
        return;
    L9:
        a.e(TAG, "reach max match times, mElevatorMatchTimesOneDay: " + this.mElevatorMatchTimesOneDay);     // Catch: IOException -> L20
        goto L10
    }

    private void scanResultAcceptThread() {
        new Thread(new $$Lambda$NearElevator$mG1XbszFahyIrYu8UTvDb05XUg(this)).start();
    }

    private void scanResultsProcess(List<ScanResult> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L5;
    L36:
        a.i(TAG, "scanResultsProcess: empty scanResults");
        return;
    L5:
        if (r15.isEmpty() == true) goto L36;
        if (r15.size() >= 3) goto L11;
        a.e(TAG, "scan results size is less than 3, skip this scan");
        return;
    L11:
        ConcurrentSkipListMap r0 = new ConcurrentSkipListMap();
        ArrayList r2 = new ArrayList();
        long r10 = System.currentTimeMillis();
        Iterator r16 = r15.iterator();
    L13:
        if (r16.hasNext() == false) goto L18;
        ScanResult r3 = (ScanResult) ZeusTransformUtils.preCheckCast(r16.next(), ScanResult.class, "com.obric.memorydata.plugin");
        int r4 = r3.BSSID.length();
        WifiScanDataForAI r12 = new WifiScanDataForAI(r3.BSSID.substring(0, r4 - 1) + '0', r3.level, r3.frequency, r3.channelWidth, r10);
        if (r0.containsKey(r12.bssid) == true) goto L13;
        r0.put(r12.bssid, r12);
        r2.add(r12);
        goto L13
    L18:
        if (b.a(ELEVATOR_WIFI_MATCH_MODEL_NAME) == true) goto L25;
        a.e(TAG, "AI model is not loaded, skip anchor update");
        if (checkAndMarkElevatorModelLoadCooldown() == false) goto L22;
        return;
    L22:
        updateModel(this.mContext);
        return;
    L25:
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR) goto L27;
    L34:
        anchorUpdate(r2, r0);
        return;
    L27:
        if (this.mScanReason.get() == ScanReason.OUT_ELEVATOR_TEST) goto L34;
        if (this.mScanReason.get() != ScanReason.ANCHOR_MATCH) goto L32;
    L33:
        scanDataAnchorMatch(r2, r10);
        return;
    L32:
        if (this.mScanReason.get() == ScanReason.ANCHOR_MATCH_TEST) goto L33;
    }

    private int sceneIdOfScanReason(ScanReason r1) {
        if (r1 != ScanReason.OUT_ELEVATOR) goto L5;
    L8:
        return 201;
    L5:
        if (r1 == ScanReason.OUT_ELEVATOR_TEST) goto L8;
        return 202;
    }

    private void sendInElevatorBroadcast(int r4) {
        a.e(TAG, "sendInElevatorBroadcast, elevatorId: " + r4);
        Intent r0 = new Intent(ACTION_CAE_NEAR_ELEVATOR);
        r0.putExtra("elevatorId", r4);
        if (this.mContext == null) goto L11;
        r0.setPackage(UserAwareUtil.PACKAGE_NAME_CAE);     // Catch: Exception -> L6
        this.mContext.sendBroadcastAsUser(r0, UserHandle.CURRENT, ACTION_CAE_NEAR_ELEVATOR_PERMISSION);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        a.i(TAG, "sendInElevatorBroadcast, failed: " + e.getMessage());
        return;
    }

    private void sendNearElevatorBroadcast(int r5) {
        a.e(TAG, "sendNearElevatorBroadcast, elevatorId: " + r5);
        Intent r1 = new Intent(ACTION_CAE_NEAR_ELEVATOR);
        r1.putExtra("elevatorId", r5);
        if (this.mContext == null) goto L11;
        r1.setPackage("com.bytedance.radioservice");     // Catch: Exception -> L6
        this.mContext.sendBroadcastAsUser(r1, UserHandle.CURRENT, ACTION_CAE_NEAR_ELEVATOR_PERMISSION);     // Catch: Exception -> L6
        r1.setPackage(UserAwareUtil.PACKAGE_NAME_CAE);     // Catch: Exception -> L6
        this.mContext.sendBroadcastAsUser(r1, UserHandle.CURRENT, ACTION_CAE_NEAR_ELEVATOR_PERMISSION);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        a.i(TAG, "sendNearElevatorBroadcast, failed: " + e.getMessage());
        return;
    }

    private void startAsyncInit() {
        if (this.mAsyncInitStarted.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        new Thread(new $$Lambda$NearElevator$Cy6qzChQv4SB4eufpF2PKr088I(this), "NearElevatorInit").start();
    }

    public void clearAnchorList() {
        this.mElevatorScanAnchorList.clear();
    }

    public void inElevatorEvent() {
        NearElevatorListener r0 = this.mNearElevatorListener;
        if (r0 == null) goto L6;
        r0.inElevatorEvent();
    L6:
        if (this.mNearElevatorDetectedTime != 0) goto L8;
    L15:
        sendInElevatorBroadcast(this.mMatchAnchorElevatorId);
        return;
    L8:
        if ((System.currentTimeMillis() - this.mNearElevatorDetectedTime) > 120000) goto L15;
        CaeUserAwareReportBase r1 = CaeUserAwareReportFactory.getReportInstance();
        if (r1 == null) goto L12;
        r1.reportNearElevatorData(new InnerNearElevatorData(true, this.mMatchAnchorElevatorId, this.mMatchedElevatorUpdateCnt, this.mMatchedWifiDataPairs));
    L12:
        this.mNearElevatorDetectedTime = 0;
        AnchorData r2 = findAnchorById(this.mMatchAnchorElevatorId);
        if (r2 == null) goto L15;
        r2.errorMatchCnt = 0;
        goto L15
    }

    /* JADX INFO: Infinite loop detected, blocks: 66, insns: 0 */
    public /* synthetic */ void lambda$scanResultAcceptThread$2$NearElevator() {
    L43:
        List<ScanResult> r0 = (List) ZeusTransformUtils.preCheckCast(this.mWifiScanResultQueue.take(), List.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L41
        long r1 = System.currentTimeMillis();     // Catch: InterruptedException -> L41
        ScanReason r3 = this.mScanReason.get();     // Catch: InterruptedException -> L41
        ScanReason r4 = ScanReason.ANCHOR_MATCH;     // Catch: InterruptedException -> L41
        if (r3 != r4) goto L7;
        if ((r1 - this.mLastGetScanResultTime) >= 5000) goto L7;
        a.e(TAG, "ignore scanResults because interval is too short, currentTime: " + r1 + ", mLastGetScanResultTime: " + this.mLastGetScanResultTime);     // Catch: InterruptedException -> L41
    L7:
        this.mLastGetScanResultTime = r1;     // Catch: InterruptedException -> L41
        this.mIsScanning.set(false);
        long r6 = this.mNearElevatorDetectedTime;
        if (r6 == 0) goto L17;
        if ((r1 - r6) <= 120000) goto L17;
        CaeUserAwareReportBase r5 = CaeUserAwareReportFactory.getReportInstance();
        if (r5 == null) goto L15;
        r5.reportNearElevatorData(new InnerNearElevatorData(false, this.mMatchAnchorElevatorId, this.mMatchedElevatorUpdateCnt, this.mMatchedWifiDataPairs));
    L15:
        this.mNearElevatorDetectedTime = 0;
        checkAnchorErrorMatchCnt();
    L17:
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR) goto L27;
        if ((r1 - this.mOutElevatorTime) >= 10000) goto L25;
        int r7 = this.mOutElevatorScanCnt + 1;
        this.mOutElevatorScanCnt = r7;
        if (r7 <= 1) goto L27;
        g.a(new StringBuilder("scan for wifi connect, don't save anchor or match anchor, mOutElevatorScanCnt: "), this.mOutElevatorScanCnt, TAG);
        if (this.mOutElevatorScanCnt < getElevatorScanTimes(201, 3)) goto L43;
        this.mScanReason.set(r4);
        this.mOutElevatorScanCnt = 0;
        goto L43
    L25:
        a.e(TAG, "out elevator, scan 3 times not finish");
        this.mScanReason.set(r4);
        this.mOutElevatorScanCnt = 0;
    L27:
        if (this.mScanReason.get() != r4) goto L38;
        if ((r1 - this.mOutElevatorTime) < DONT_ANCHOR_MATCH_WHEN_OUT_ELEVATOR_THRESHOLD) goto L30;
        if ((r1 - this.mNearElevatorDetectedTime) < 60000) goto L34;
        if (hasRecentStepMovement() == true) goto L38;
        String r2 = TAG;
        String r8 = "ignore scanResults because no step movement in 5 minutes, lastStepDeltaMs: " + this.mStepMovementGate.getLastStepDeltaMs();
    L31:
        a.e(r2, r8);
        goto L43
    L34:
        r2 = TAG;
        r8 = "ignore scanResults because anchor match success in 60 seconds";
        goto L31
    L30:
        r2 = TAG;
        r8 = "ignore scanResults because out elevator in 30 seconds";
    L38:
        g.a(new StringBuilder("scanResults size: ").append(r0.size()).append(", scanReason: ").append(this.mScanReason.get()).append(", mOutElevatorScanCnt: "), this.mOutElevatorScanCnt, TAG);
        scanResultsProcess(r0);
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR_TEST) goto L43;
        this.mScanReason.set(r4);
    L41:
        e = move-exception;
        a.a(TAG, "scanResultAcceptThread: InterruptedException", e);
        goto L43
    }

    public /* synthetic */ void lambda$startAsyncInit$0$NearElevator() {
        regWifiBroadcastReceiver();
        this.mStepMovementGate.ensureStarted();
        loadAnchorListFromStorage();
        a.e(TAG, "use AI kernel model for production");
        b.a(CAE_APP_ID, this.mContext, ELEVATOR_WIFI_MATCH_MODEL_NAME);
    }

    public void outElevatorEvent() {
        NearElevatorListener r0 = this.mNearElevatorListener;
        if (r0 == null) goto L5;
        r0.outElevatorEvent();
    L5:
        startWifiScan(ScanReason.OUT_ELEVATOR);
    }

    public void pushWifiScanResult(List<ScanResult> r3) {
        List<ScanResult> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L9:
        a.i(TAG, "pushWifiScanResult: empty scanResults");
        return;
    L5:
        if (r4.isEmpty() == true) goto L9;
        this.mWifiScanResultQueue.offer(r4);
    }

    public void regNearElevatorListener(NearElevatorListener r3) {
        NearElevatorListener r4 = (NearElevatorListener) ZeusTransformUtils.wrapperContextForParams(r3, NearElevatorListener.class, "com.obric.memorydata.plugin");
        if (this.mNearElevatorListener != null) goto L6;
        this.mNearElevatorListener = r4;
        return;
    }

    public synchronized void setWifiAwareInfoManager(WifiAwareInfoManager r1) {
        monitor-enter(this);
        this.mWifiAwareInfoManager = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void startWifiScan(ScanReason r7) {
        String r0 = TAG;
        a.e(r0, "call startWifiScan");
        if (this.mIsScanning.get() == false) goto L13;
        long r1 = getScanConfigProvider().getActiveConfigSnapshot().getElevatorScanCallMinIntervalMs();
        if (r1 <= 0) goto L7;
        int r2 = (int) Math.min(r1, 2147483647L);
    L9:
        if ((System.currentTimeMillis() - this.mStartScanTime) >= r2) goto L12;
        a.c(r0, "startWifiScan is scanning");
        return;
    L12:
        this.mIsScanning.set(false);
        goto L13
    L7:
        r2 = 3000;
    L13:
        this.mStartScanTime = System.currentTimeMillis();
        this.mIsScanning.set(true);
        this.mScanReason.set(r7);
        WifiScanConfigProvider.ActiveConfigSnapshot r3 = getScanConfigProvider().getActiveConfigSnapshot();
        int r8 = sceneIdOfScanReason(r7);
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR) goto L16;
    L17:
        this.mOutElevatorTime = this.mStartScanTime;
    L19:
        if (r8 != 201) goto L21;
        int r4 = getElevatorInterval(r3, r8, WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR);
        int r5 = getElevatorTotalTimeout(r3, r8, WIFI_SCAN_TIMEOUT_WHEN_OUT_ELEVATOR);
    L22:
        WifiAwareInfoManager r6 = this.mWifiAwareInfoManager;
        if (r6 == null) goto L25;
        r6.startElevatorWifiDataCollection(r8, r4, r5);
        return;
    L25:
        a.i(r0, "mWifiAwareInfoManager is null");
        return;
    L21:
        int r9 = getElevatorInterval(r3, r8, 2000);
        r5 = getElevatorTotalTimeout(r3, r8, 2000);
        r4 = r9;
        goto L22
    L16:
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR_TEST) goto L19;
        goto L17
    }

    public void unregNearElevatorListener() {
        this.mNearElevatorListener = null;
    }

    public void updateModel(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (b.a(ELEVATOR_WIFI_MATCH_MODEL_NAME) == true) goto L6;
        a.e(TAG, "updateModel, model is not loaded, try to load");
        b.a(CAE_APP_ID, r2, ELEVATOR_WIFI_MATCH_MODEL_NAME);
        return;
    }
}
