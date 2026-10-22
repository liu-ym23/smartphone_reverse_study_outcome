package com.obric.cae.userAware.NearElevator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.UserHandle;
import androidx.activity.d;
import androidx.activity.k;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.utils.WifiUtils;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.statusReport.network.NetworkReportUtil;
import com.obric.cae.userAware.WifiAwareInfoManager;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.cae.utils.AIKernelJavaBridge;
import defpackage.b;
import ha.j;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
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

/* JADX INFO: loaded from: classes2.dex */
public class NearElevator {
    private static final String ACTION_CAE_NEAR_ELEVATOR = "com.obric.cae.ACTION_CAE_NEAR_ELEVATOR";
    private static final String ACTION_CAE_NEAR_ELEVATOR_PERMISSION = "com.obric.cae.permission.ACTION_CAE_NEAR_ELEVATOR";
    private static final String ANCHOR_DATA_FILE_NAME = "elevator_anchor_data.json";
    private static final long ANCHOR_EXPIRE_TIME = 0;
    private static final String ANCHOR_LIST_KEY = "elevator_scan_anchor_list";
    private static final int ANCHOR_MATCH_MIN_COUNT = 2;
    private static final int ANCHOR_MATCH_ROUGH_PERCENTAGE_THRESHOLD = 40;
    private static final long ANCHOR_NO_CONFIRM_EXPIRE_TIME = 0;
    private static final long CAE_APP_ID = 123456;
    private static final long DONT_ANCHOR_MATCH_WHEN_OUT_ELEVATOR_THRESHOLD = 30000;
    private static final int ELEVATOR_ANCHOR_CONFIRM_UPDATE_CNT_THRESHOLD = 3;
    private static final int ELEVATOR_ANCHOR_MAX_ERROR_MATCH_CNT_THRESHOLD = 10;
    private static final int ELEVATOR_ANCHOR_MAX_MATCH_TIMES_ONE_DAY_THRESHOLD = 20;
    public static final String ELEVATOR_WIFI_MATCH_MODEL_NAME = "cae_elevator_wifi_match";
    private static final int MAX_ELEVATOR_ANCHOR_NUM = 20;
    private static final int MODEL_FEATURE_SIZE = 3;
    private static final int NEAR_ELEVATOR_DETECTED_AND_IN_ELEVATOR_GAP_THRESHOLD = 120000;
    private static final int NETWORK_HANDOVER_IN_RADICAL_MODEL_TIME = 60000;
    private static final int SCAN_RESULT_SIZE_THRESHOLD = 3;
    private static final int STATE_CHANGE_TIME_WHEN_OUT_ELEVATOR = 10000;
    private static final String TAG = "NearElevator";
    private static final int WIFI_SCAN_CALL_MIN_INTERVAL = 3000;
    private static final int WIFI_SCAN_INTERVAL_WHEN_NEAR_ELEVATOR = 2000;
    private static final int WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR = 1500;
    private static final long WIFI_SCAN_RESULT_PROCESS_INTERVAL_MS = 5000;
    private static final int WIFI_SCAN_TIMEOUT_WHEN_NEAR_ELEVATOR = 2000;
    private static final int WIFI_SCAN_TIMEOUT_WHEN_OUT_ELEVATOR = 6000;
    private static final int WIFI_SCAN_TIMES_WHEN_NEAR_ELEVATOR = 1;
    private static final int WIFI_SCAN_TIMES_WHEN_OUT_ELEVATOR = 3;
    private static volatile NearElevator mNearElevatorInstance;
    private final File mAnchorDataFilePath;
    private final AtomicBoolean mAsyncInitStarted;
    private final Context mContext;
    private int mElevatorIdCount;
    private int mElevatorMatchTimesOneDay;
    private long mElevatorMatchTimesOneDayTimer;
    private final ConcurrentLinkedDeque<AnchorData> mElevatorScanAnchorList;
    private final j mGson;
    public boolean mInferenceResult;
    public final AtomicBoolean mIsInferenceRunning;
    public final AtomicBoolean mIsScanning;
    private final boolean mIsUseAIKernel;
    private long mLastGetScanResultTime;
    public int mMatchAnchorElevatorId;
    private int mMatchedElevatorUpdateCnt;
    private final List<WifiDataPair> mMatchedWifiDataPairs;
    private long mNearElevatorDetectedTime;
    NearElevatorListener mNearElevatorListener;
    private int mOutElevatorScanCnt;
    private long mOutElevatorTime;
    private final AtomicReference<ScanReason> mScanReason;
    private long mStartScanTime;
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

        public /* synthetic */ AnchorData(AnonymousClass1 r8) {
            this();
        }
    }

    public static class InnerNearElevatorData {
        private final int elevatorId;
        private final int elevatorUpdateCnt;
        private final boolean isInElevator;
        private final List<WifiDataPair> wifiDataPairs;

        public InnerNearElevatorData(boolean r8, int r10, int r11, List<WifiDataPair> r12) {
            this.isInElevator = r8;
            this.elevatorId = r10;
            this.elevatorUpdateCnt = r11;
            if (r12 == null) goto L5;
            ArrayList r13 = new ArrayList(r12);
        L6:
            this.wifiDataPairs = r13;
            return;
        L5:
            r13 = new ArrayList();
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

        void nearElevatorEvent(int r8);

        void outElevatorAndAnchorUpdate(int r8, int r10);

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

        private ScanReason(String r8, int r10) {
            super(r8, r10);
        }

        public static ScanReason valueOf(String r8) {
            return (ScanReason) Enum.valueOf(ScanReason.class, r8);
        }

        public static ScanReason[] values() {
            return (ScanReason[]) $VALUES.clone();
        }
    }

    public static class WifiDataPair {
        private final WifiScanDataForAI anchorWifiData;
        private final WifiScanDataForAI newWifiData;

        public WifiDataPair(WifiScanDataForAI r8, WifiScanDataForAI r10) {
            this.newWifiData = r8;
            this.anchorWifiData = r10;
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

        public WifiScanDataForAI(String r8, int r10, int r11, int r12, long r13) {
            this.bssid = r8;
            this.rssi = r10;
            this.freq = r11;
            this.channelWidth = r12;
            this.timestamp = r13;
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
            return "WifiScanDataForAI{bssid=" + WifiUtils.maskMacAddress(this.bssid) + ", rssi=" + this.rssi + ", freq=" + this.freq + ", channelWidth=" + this.channelWidth + ", timestamp=" + this.timestamp + '}';
        }
    }

    static {
        TimeUnit r8 = TimeUnit.DAYS;
        ANCHOR_EXPIRE_TIME = r8.toMillis(30);
        ANCHOR_NO_CONFIRM_EXPIRE_TIME = r8.toMillis(7);
    }

    private NearElevator(Context r8) {
        this.mIsScanning = new AtomicBoolean(false);
        this.mIsInferenceRunning = new AtomicBoolean(false);
        this.mInferenceResult = false;
        this.mMatchAnchorElevatorId = 0;
        this.mIsUseAIKernel = true;
        this.mWifiScanResultQueue = new LinkedBlockingQueue();
        this.mElevatorScanAnchorList = new ConcurrentLinkedDeque();
        this.mGson = new j();
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
        CommSenseLog.i(TAG, "NearElevator constructor");
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mAnchorDataFilePath = r10.getFilesDir();
        scanResultAcceptThread();
        startAsyncInit();
    }

    public static /* synthetic */ boolean a(int r8, AnchorData r10) {
        return lambda$findAnchorById$1(r8, r10);
    }

    public static /* synthetic */ WifiManager access$000(NearElevator r8) {
        return r8.mWifiManager;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ Context access$200(NearElevator r8) {
        return r8.mContext;
    }

    private String anchorListIdString() {
        StringBuilder r8 = new StringBuilder();
        Iterator<AnchorData> r10 = this.mElevatorScanAnchorList.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        AnchorData r11 = r10.next();
        if (r8.length() <= 0) goto L8;
        r8.append(", ");
    L8:
        r8.append(r11.elevatorId);
        r8.append("(");
        r8.append(r11.updateTimestamp);
        r8.append(")");
        goto L4
    L10:
        return r8.toString();
    }

    private void anchorUpdate(List<WifiScanDataForAI> r8, Map<String, WifiScanDataForAI> r10) {
        AnchorData r11 = findMatchedAnchor(r8, true);     // Catch: IOException -> L16
        if (r11 == null) goto L7;
        int r12 = r11.anchorMap.size();
        mergeAnchorOldWithNew(r8, r11);
        this.mElevatorScanAnchorList.remove(r11);
        this.mElevatorScanAnchorList.addFirst(r11);
        String r13 = TAG;
        StringBuilder r14 = new StringBuilder("merge old anchor with new, elevatorId: ");
        b.q(r14, r11.elevatorId, " oldMatchAnchorSize: ", r12, " newAnchorSize: ");
        r14.append(r11.anchorMap.size());
        r14.append(" updateCnt: ");
        r14.append(r11.updateCnt);
        r14.append(" anchor list size: ");
        r14.append(this.mElevatorScanAnchorList.size());
        CommSenseLog.i(r13, r14.toString());
        int r15 = r11.elevatorId;
    L11:
        NearElevatorListener r16 = this.mNearElevatorListener;
        if (r16 == null) goto L14;
        r16.outElevatorAndAnchorUpdate(this.mElevatorScanAnchorList.size(), r15);
    L14:
        saveAnchorListToStorage();
        return;
    L7:
        AnchorData r17 = new AnchorData(null);
        int r18 = this.mElevatorIdCount;
        r17.elevatorId = r18;
        this.mElevatorIdCount = r18 + 1;
        r17.updateCnt = 1;
        r17.updateTimestamp = System.currentTimeMillis();
        r17.anchorMap = r10;
        this.mElevatorScanAnchorList.addFirst(r17);
        String r19 = TAG;
        CommSenseLog.i(r19, "add new wifi anchor, elevatorId: " + r17.elevatorId + " updateCnt: " + r17.updateCnt + ", anchor list size: " + this.mElevatorScanAnchorList.size());
        if (this.mElevatorScanAnchorList.size() <= 20) goto L10;
        AnchorData r20 = this.mElevatorScanAnchorList.removeLast();
        CommSenseLog.i(r19, "remove oldest anchor , elevatorId: " + r20.elevatorId + ", updateTimestamp: " + r20.updateTimestamp + ", now anchor list size: " + this.mElevatorScanAnchorList.size());
    L10:
        r15 = r17.elevatorId;
    L16:
        e = move-exception;
        CommSenseLog.e(TAG, "anchorUpdate, IOException", e);
    }

    public static /* synthetic */ void b(NearElevator r8) {
        r8.lambda$startAsyncInit$0();
    }

    public static /* synthetic */ void c(NearElevator r8) {
        r8.lambda$scanResultAcceptThread$2();
    }

    private void checkAnchorErrorMatchCnt() {
        AnchorData r8 = findAnchorById(this.mMatchAnchorElevatorId);
        if (r8 != null) goto L6;
        CommSenseLog.e(TAG, "checkAnchorErrorMatchCnt, not found anchor with elevatorId: " + this.mMatchAnchorElevatorId);
        return;
    L6:
        r8.errorMatchCnt++;
        String r10 = TAG;
        CommSenseLog.i(r10, "checkAnchorErrorMatchCnt, elevatorId: " + r8.elevatorId + ", errorMatchCnt: " + r8.errorMatchCnt);
        if (r8.errorMatchCnt < 10) goto L10;
        CommSenseLog.i(r10, "Remove anchor cause of errorMatchCnt over threshold, elevatorId: " + r8.elevatorId + ", errorCount: " + r8.errorMatchCnt + ", threshold: 10, isRemoved: " + this.mElevatorScanAnchorList.remove(r8));
        return;
    }

    private AnchorData findAnchorById(final int r8) {
        return (AnchorData) this.mElevatorScanAnchorList.stream().filter(new a(r8)).findFirst().orElse(null);
    }

    private synchronized AnchorData findMatchedAnchor(List<WifiScanDataForAI> r14, boolean r15) {
        monitor-enter(this);
        this.mWifiDataPairs.clear();     // Catch: Throwable -> L41
        int r8 = (r14.size() * 40) / 100;     // Catch: Throwable -> L41
        CommSenseLog.i(TAG, "new wifiScanData size: " + r14.size() + " threshold: " + r8 + " anchor list size: " + this.mElevatorScanAnchorList.size());     // Catch: Throwable -> L41
        this.mIsInferenceRunning.set(true);     // Catch: Throwable -> L41
        Iterator<AnchorData> r10 = this.mElevatorScanAnchorList.iterator();     // Catch: Throwable -> L41
    L6:
        if (r10.hasNext() == false) goto L37;
        AnchorData r11 = r10.next();     // Catch: Throwable -> L41
        Map<String, WifiScanDataForAI> r12 = r11.anchorMap;     // Catch: Throwable -> L41
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L41
        int r16 = r11.updateCnt;     // Catch: Throwable -> L41
        if (r16 < 3) goto L10;
        long r17 = ANCHOR_EXPIRE_TIME;     // Catch: Throwable -> L41
    L12:
        if ((r13 - r11.updateTimestamp) <= r17) goto L15;
        r10.remove();     // Catch: Throwable -> L41
        String r18 = TAG;     // Catch: Throwable -> L41
        String r19 = "remove expired wifi anchor id " + r11.elevatorId + ", updateCnt: " + r11.updateCnt + ", anchor list size: " + this.mElevatorScanAnchorList.size();     // Catch: Throwable -> L41
    L14:
        CommSenseLog.i(r18, r19);     // Catch: Throwable -> L41
        goto L6
    L15:
        if (r15 == true) goto L18;
        if (r16 >= 3) goto L18;
        r18 = TAG;     // Catch: Throwable -> L41
        r19 = "anchor updateCnt " + r11.updateCnt + " not reach threshold, don't match.";     // Catch: Throwable -> L41
    L18:
        Iterator<WifiScanDataForAI> r20 = r14.iterator();     // Catch: Throwable -> L41
        int r21 = 0;
    L20:
        if (r20.hasNext() == false) goto L36;
        WifiScanDataForAI r22 = r20.next();     // Catch: Throwable -> L41
        WifiScanDataForAI r23 = r12.get(r22.bssid);     // Catch: Throwable -> L41
        if (r23 == null) goto L20;
        float r24 = runInference(r22, r23);     // Catch: Throwable -> L41
        if (r24 < 0.0f) goto L34;
        this.mWifiDataPairs.add(new WifiDataPair(r22, r23));     // Catch: Throwable -> L41
        CommSenseLog.d(TAG, "Inference result: " + r24 + ", scanData: " + r22 + ", anchor: " + r23);     // Catch: Throwable -> L41
        if (r24 <= 0.5d) goto L20;
        r21 = r21 + 1;     // Catch: Throwable -> L41
        if (r21 < 2) goto L20;
        if (r21 < r8) goto L20;
        this.mIsInferenceRunning.set(false);     // Catch: Throwable -> L41
        monitor-exit(this);
        return r11;
    L34:
        CommSenseLog.e(TAG, "runInference failed, something wrong with AIKernel");     // Catch: Throwable -> L41
        throw new IOException("runInference exception");     // Catch: Throwable -> L41
    L36:
        r18 = TAG;     // Catch: Throwable -> L41
        r19 = "anchor id " + r11.elevatorId + " matchCount: " + r21 + " threshold: " + r8 + " anchorSize: " + r12.size();     // Catch: Throwable -> L41
        goto L14
    L10:
        r17 = ANCHOR_NO_CONFIRM_EXPIRE_TIME;     // Catch: Throwable -> L41
        goto L12
    L37:
        this.mIsInferenceRunning.set(false);     // Catch: Throwable -> L41
        monitor-exit(this);
        return null;
    L41:
        th = move-exception;
        throw th;
    }

    public static synchronized NearElevator getInstance(Context r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.obric.cae.userAware.NearElevator.NearElevator> r0 = com.obric.cae.userAware.NearElevator.NearElevator.class
            monitor-enter(r0)
            boolean r1 = com.obric.cae.userAware.utils.UserAwareUtil.isNearElevatorWifiMatchSupported(r3)     // Catch: java.lang.Throwable -> L35
            if (r1 != 0) goto L13
            java.lang.String r3 = com.obric.cae.userAware.NearElevator.NearElevator.TAG     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = "NearElevator not supported"
            com.obric.cae.log.CommSenseLog.i(r3, r1)     // Catch: java.lang.Throwable -> L35
            monitor-exit(r0)
            r3 = 0
            return r3
        L13:
            java.lang.String r1 = com.obric.cae.userAware.NearElevator.NearElevator.TAG     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "NearElevator supported"
            com.obric.cae.log.CommSenseLog.i(r1, r2)     // Catch: java.lang.Throwable -> L35
            com.obric.cae.userAware.NearElevator.NearElevator r1 = com.obric.cae.userAware.NearElevator.NearElevator.mNearElevatorInstance     // Catch: java.lang.Throwable -> L35
            if (r1 != 0) goto L31
            java.lang.Class<com.obric.cae.userAware.NearElevator.NearElevator> r1 = com.obric.cae.userAware.NearElevator.NearElevator.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L35
            com.obric.cae.userAware.NearElevator.NearElevator r2 = com.obric.cae.userAware.NearElevator.NearElevator.mNearElevatorInstance     // Catch: java.lang.Throwable -> L2e
            if (r2 != 0) goto L2c
            com.obric.cae.userAware.NearElevator.NearElevator r2 = new com.obric.cae.userAware.NearElevator.NearElevator     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2e
            com.obric.cae.userAware.NearElevator.NearElevator.mNearElevatorInstance = r2     // Catch: java.lang.Throwable -> L2e
        L2c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            goto L31
        L2e:
            r3 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            throw r3     // Catch: java.lang.Throwable -> L35
        L31:
            com.obric.cae.userAware.NearElevator.NearElevator r3 = com.obric.cae.userAware.NearElevator.NearElevator.mNearElevatorInstance     // Catch: java.lang.Throwable -> L35
            monitor-exit(r0)
            return r3
        L35:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.cae.userAware.NearElevator.NearElevator.getInstance(android.content.Context):com.obric.cae.userAware.NearElevator.NearElevator");
    }

    private static /* synthetic */ boolean lambda$findAnchorById$1(int r8, AnchorData r10) {
        if (r10.elevatorId != r8) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: Infinite loop detected, blocks: 62, insns: 0 */
    private /* synthetic */ void lambda$scanResultAcceptThread$2() {
    L40:
        List<ScanResult> r8 = this.mWifiScanResultQueue.take();     // Catch: InterruptedException -> L38
        long r10 = System.currentTimeMillis();     // Catch: InterruptedException -> L38
        ScanReason r11 = this.mScanReason.get();     // Catch: InterruptedException -> L38
        ScanReason r12 = ScanReason.ANCHOR_MATCH;     // Catch: InterruptedException -> L38
        if (r11 != r12) goto L7;
        if ((r10 - this.mLastGetScanResultTime) >= 5000) goto L7;
        CommSenseLog.i(TAG, "ignore scanResults because interval is too short, currentTime: " + r10 + ", mLastGetScanResultTime: " + this.mLastGetScanResultTime);     // Catch: InterruptedException -> L38
    L7:
        this.mLastGetScanResultTime = r10;     // Catch: InterruptedException -> L38
        this.mIsScanning.set(false);
        long r13 = this.mNearElevatorDetectedTime;
        if (r13 == 0) goto L17;
        if ((r10 - r13) <= 120000) goto L17;
        CaeUserAwareReportBase r14 = CaeUserAwareReportFactory.getReportInstance();
        if (r14 == null) goto L15;
        r14.reportNearElevatorData(new InnerNearElevatorData(false, this.mMatchAnchorElevatorId, this.mMatchedElevatorUpdateCnt, this.mMatchedWifiDataPairs));
    L15:
        this.mNearElevatorDetectedTime = 0;
        checkAnchorErrorMatchCnt();
    L17:
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR) goto L27;
        if ((r10 - this.mOutElevatorTime) >= 10000) goto L25;
        int r15 = this.mOutElevatorScanCnt + 1;
        this.mOutElevatorScanCnt = r15;
        if (r15 <= 1) goto L27;
        CommSenseLog.i(TAG, "scan for wifi connect, don't save anchor or match anchor, mOutElevatorScanCnt: " + this.mOutElevatorScanCnt);
        if (this.mOutElevatorScanCnt < 3) goto L40;
        this.mScanReason.set(r12);
        this.mOutElevatorScanCnt = 0;
        goto L40
    L25:
        CommSenseLog.i(TAG, "out elevator, scan 3 times not finish");
        this.mScanReason.set(r12);
        this.mOutElevatorScanCnt = 0;
    L27:
        if (this.mScanReason.get() != r12) goto L35;
        if ((r10 - this.mOutElevatorTime) < 30000) goto L30;
        if ((r10 - this.mNearElevatorDetectedTime) >= 60000) goto L35;
        String r16 = TAG;
        String r17 = "ignore scanResults because anchor match success in 60 seconds";
    L31:
        CommSenseLog.i(r16, r17);
        goto L40
    L30:
        r16 = TAG;
        r17 = "ignore scanResults because out elevator in 30 seconds";
    L35:
        CommSenseLog.i(TAG, "scanResults size: " + r8.size() + ", scanReason: " + this.mScanReason.get() + ", mOutElevatorScanCnt: " + this.mOutElevatorScanCnt);
        scanResultsProcess(r8);
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR_TEST) goto L40;
        this.mScanReason.set(r12);
    L38:
        e = move-exception;
        CommSenseLog.e(TAG, "scanResultAcceptThread: InterruptedException", e);
        goto L40
    }

    private /* synthetic */ void lambda$startAsyncInit$0() {
        regWifiBroadcastReceiver();
        loadAnchorListFromStorage();
        CommSenseLog.i(TAG, "use AI kernel model for production");
        AIKernelJavaBridge.initAndLoadModel(CAE_APP_ID, this.mContext, ELEVATOR_WIFI_MATCH_MODEL_NAME);
    }

    private void loadAnchorListFromStorage() {
        File r8 = new File(this.mAnchorDataFilePath, ANCHOR_DATA_FILE_NAME);     // Catch: Exception -> L45
        if (r8.exists() == true) goto L7;
        CommSenseLog.i(TAG, "Anchor data file not exists");     // Catch: Exception -> L45
        return;
    L7:
        BufferedReader r10 = new BufferedReader(new FileReader(r8));     // Catch: Exception -> L45
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L45
    L8:
        String r12 = r10.readLine();     // Catch: Exception -> L45
        if (r12 == null) goto L11;
        r11.append(r12);     // Catch: Exception -> L45
        goto L8
    L11:
        r10.close();     // Catch: Exception -> L45
        String r13 = r11.toString();     // Catch: Exception -> L45
        j r14 = this.mGson;     // Catch: Exception -> L45
        Type r15 = new AnonymousClass2(this).getType();     // Catch: Exception -> L45
        r14.getClass();     // Catch: Exception -> L45
        Map r16 = (Map) r14.d(r13, oa.a.get(r15));     // Catch: Exception -> L45
        if (r16 != null) goto L14;
        return;
    L14:
        if (r16.containsKey(ANCHOR_LIST_KEY) == false) goto L55;
        JSONArray r17 = new JSONArray(new j().j(r16.get(ANCHOR_LIST_KEY)));     // Catch: Exception -> L45
        this.mElevatorScanAnchorList.clear();     // Catch: Exception -> L45
        int r18 = 0;
    L17:
        if (r18 >= r17.length()) goto L41;
        JSONObject r19 = r17.getJSONObject(r18);     // Catch: Exception -> L45
        AnchorData r20 = new AnchorData(null);     // Catch: Exception -> L45
        if (r19.has("elevatorId") == false) goto L22;
        r20.elevatorId = r19.getInt("elevatorId");     // Catch: Exception -> L45
    L22:
        if (r19.has("updateCnt") == false) goto L25;
        r20.updateCnt = r19.getInt("updateCnt");     // Catch: Exception -> L45
    L25:
        if (r19.has("errorMatchCnt") == false) goto L28;
        r20.errorMatchCnt = r19.getInt("errorMatchCnt");     // Catch: Exception -> L45
    L28:
        if (r19.has("updateTimestamp") == false) goto L31;
        r20.updateTimestamp = r19.getLong("updateTimestamp");     // Catch: Exception -> L45
    L31:
        if (r19.has("anchorMap") == false) goto L37;
        JSONObject r21 = r19.getJSONObject("anchorMap");     // Catch: Exception -> L45
        Iterator<String> r22 = r21.keys();     // Catch: Exception -> L45
    L34:
        if (r22.hasNext() == false) goto L37;
        String r110 = r22.next();     // Catch: Exception -> L45
        r20.anchorMap.put(r110, (WifiScanDataForAI) this.mGson.c(WifiScanDataForAI.class, r21.getJSONObject(r110).toString()));     // Catch: Exception -> L45
    L37:
        if (r20.anchorMap.isEmpty() == true) goto L39;
        this.mElevatorScanAnchorList.add(r20);     // Catch: Exception -> L45
    L39:
        r18 = r18 + 1;     // Catch: Exception -> L45
        goto L17
    L41:
        if (this.mElevatorScanAnchorList.isEmpty() == true) goto L43;
        this.mElevatorIdCount = this.mElevatorScanAnchorList.getLast().elevatorId + 1;     // Catch: Exception -> L45
    L43:
        CommSenseLog.i(TAG, "Loaded elevator anchor list from storage, size: " + this.mElevatorScanAnchorList.size());     // Catch: Exception -> L45
        return;
    L55:
        return;
    L45:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to load elevator anchor list: " + e.getMessage());
    }

    private void mergeAnchorOldWithNew(List<WifiScanDataForAI> r8, AnchorData r10) {
        Iterator<WifiScanDataForAI> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        WifiScanDataForAI r12 = r11.next();
        r10.anchorMap.put(r12.bssid, r12);
        goto L4
    L6:
        long r13 = System.currentTimeMillis();
        r10.updateCnt++;
        r10.updateTimestamp = r13;
        Iterator<Map.Entry<String, WifiScanDataForAI>> r14 = r10.anchorMap.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L13;
        WifiScanDataForAI r15 = r14.next().getValue();
        if ((r13 - r15.timestamp) <= ANCHOR_EXPIRE_TIME) goto L8;
        r14.remove();
        CommSenseLog.d(TAG, "remove expired WifiScanData, bssid: " + r15.bssid);
        goto L8
    L13:
        if (r10.updateCnt < 3) goto L22;
        CommSenseLog.i(TAG, "matchedAnchor confirmed, id: " + r10.elevatorId + " updateCnt: " + r10.updateCnt + " updateTimestamp: " + r10.updateTimestamp + " anchorSize: " + r10.anchorMap.size());
        return;
    }

    private float[] prepareFeatures(WifiScanDataForAI r8, WifiScanDataForAI r10) {
        float[] r11 = new float[3];
        r11[0] = Math.abs(r10.rssi);
        r11[1] = Math.abs(r10.rssi - r8.rssi);
        if (CaelibUtils.is24GHz(r8.freq) == false) goto L5;
        float r12 = 0.0f;
    L6:
        r11[2] = r12;
        return r11;
    L5:
        r12 = 1.0f;
        goto L6
    }

    private void regWifiBroadcastReceiver() {
        if (this.mWifiReceiverRegistered.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.net.wifi.SCAN_RESULTS");
        BroadcastReceiver r10 = new AnonymousClass1(this);
        this.mContext.registerReceiver(r10, r8);
    }

    private float runInference(WifiScanDataForAI r8, WifiScanDataForAI r10) {
        Float r11 = AIKernelJavaBridge.runModelInferenceSync(ELEVATOR_WIFI_MATCH_MODEL_NAME, "wifi_scan_features", prepareFeatures(r8, r10));
        if (r11 != null) goto L7;
        CommSenseLog.e(TAG, "runModelInferenceSync failed");
        return -1.0f;
    L7:
        return r11.floatValue();
    }

    private void saveAnchorListToStorage() {
        HashMap r8 = new HashMap();     // Catch: Exception -> L5
        r8.put(ANCHOR_LIST_KEY, this.mElevatorScanAnchorList);     // Catch: Exception -> L5
        String r10 = this.mGson.j(r8);     // Catch: Exception -> L5
        BufferedWriter r11 = new BufferedWriter(new FileWriter(new File(this.mAnchorDataFilePath, ANCHOR_DATA_FILE_NAME)));     // Catch: Exception -> L5
        r11.write(r10);     // Catch: Exception -> L5
        r11.close();     // Catch: Exception -> L5
        CommSenseLog.i(TAG, "Saved elevator anchor list to storage, size: " + this.mElevatorScanAnchorList.size() + ", anchorListId: " + anchorListIdString());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to save elevator anchor list: " + e.getMessage());
    }

    private void scanDataAnchorMatch(List<WifiScanDataForAI> r8, long r10) {
        if ((r10 - this.mElevatorMatchTimesOneDayTimer) < TimeUnit.DAYS.toMillis(1)) goto L22;
        CommSenseLog.i(TAG, "reset mElevatorMatchTimesOneDay " + this.mElevatorMatchTimesOneDay + " to 0");
        this.mElevatorMatchTimesOneDay = 0;
        this.mElevatorMatchTimesOneDayTimer = r10;
    L22:
    L19:
        e = move-exception;
        CommSenseLog.e(TAG, "scanDataAnchorMatch, IOException", e);
        this.mInferenceResult = false;
        return;
    L6:
        if (this.mElevatorMatchTimesOneDay >= 20) goto L8;
        AnchorData r11 = findMatchedAnchor(r8, false);     // Catch: IOException -> L19
    L10:
        if (r11 == null) goto L17;
        CommSenseLog.i(TAG, "match anchor " + this.mElevatorMatchTimesOneDay + " times, updateCnt: " + r11.updateCnt + ", elevatorId: " + r11.elevatorId);
        this.mElevatorMatchTimesOneDay = this.mElevatorMatchTimesOneDay + 1;
        sendNearElevatorBroadcast(r11.elevatorId);
        if (this.mNearElevatorListener != null) goto L14;
    L16:
        this.mScanReason.set(ScanReason.ANCHOR_MATCH);
        this.mInferenceResult = true;
        this.mMatchAnchorElevatorId = r11.elevatorId;
        this.mNearElevatorDetectedTime = System.currentTimeMillis();
        this.mMatchedWifiDataPairs.clear();
        this.mMatchedWifiDataPairs.addAll(this.mWifiDataPairs);
        this.mMatchedElevatorUpdateCnt = r11.updateCnt;
        return;
    L14:
        if (this.mScanReason.get() != ScanReason.ANCHOR_MATCH) goto L16;
        this.mNearElevatorListener.nearElevatorEvent(r11.elevatorId);
        goto L16
    L17:
        CommSenseLog.i(TAG, "not match anchor");
        this.mInferenceResult = false;
        return;
    L8:
        CommSenseLog.i(TAG, "reach max match times, mElevatorMatchTimesOneDay: " + this.mElevatorMatchTimesOneDay);     // Catch: IOException -> L19
        r11 = null;
        goto L10
    }

    private void scanResultAcceptThread() {
        new Thread(new d(this, 27)).start();
    }

    private void scanResultsProcess(List<ScanResult> r13) {
        if (r13 != null) goto L4;
    L32:
        CommSenseLog.e(TAG, "scanResultsProcess: empty scanResults");
        return;
    L4:
        if (r13.isEmpty() == true) goto L32;
        if (r13.size() >= 3) goto L10;
        CommSenseLog.i(TAG, "scan results size is less than 3, skip this scan");
        return;
    L10:
        ConcurrentSkipListMap r8 = new ConcurrentSkipListMap();
        ArrayList r10 = new ArrayList();
        long r11 = System.currentTimeMillis();
        Iterator<ScanResult> r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L17;
        ScanResult r12 = r14.next();
        int r15 = r12.BSSID.length();
        WifiScanDataForAI r16 = new WifiScanDataForAI(r12.BSSID.substring(0, r15 - 1) + '0', r12.level, r12.frequency, r12.channelWidth, r11);
        if (r8.containsKey(r16.bssid) == true) goto L12;
        r8.put(r16.bssid, r16);
        r10.add(r16);
        goto L12
    L17:
        if (AIKernelJavaBridge.isModelLoadSuccess(ELEVATOR_WIFI_MATCH_MODEL_NAME) == true) goto L21;
        CommSenseLog.i(TAG, "AI model is not loaded, skip anchor update");
        updateModel(this.mContext);
        return;
    L21:
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR) goto L23;
    L30:
        anchorUpdate(r10, r8);
        return;
    L23:
        if (this.mScanReason.get() == ScanReason.OUT_ELEVATOR_TEST) goto L30;
        if (this.mScanReason.get() != ScanReason.ANCHOR_MATCH) goto L28;
    L29:
        scanDataAnchorMatch(r10, r11);
        return;
    L28:
        if (this.mScanReason.get() == ScanReason.ANCHOR_MATCH_TEST) goto L29;
    }

    private void sendInElevatorBroadcast(int r8) {
        CommSenseLog.i(TAG, "sendInElevatorBroadcast, elevatorId: " + r8);
        Intent r10 = new Intent("com.obric.cae.ACTION_CAE_NEAR_ELEVATOR");
        r10.putExtra("elevatorId", r8);
        if (this.mContext == null) goto L11;
        r10.setPackage("com.obric.cae");     // Catch: Exception -> L6
        this.mContext.sendBroadcastAsUser(r10, UserHandle.CURRENT, "com.obric.cae.permission.ACTION_CAE_NEAR_ELEVATOR");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        CommSenseLog.e(TAG, "sendInElevatorBroadcast, failed: " + e.getMessage());
        return;
    }

    private void sendNearElevatorBroadcast(int r8) {
        CommSenseLog.i(TAG, "sendNearElevatorBroadcast, elevatorId: " + r8);
        Intent r10 = new Intent("com.obric.cae.ACTION_CAE_NEAR_ELEVATOR");
        r10.putExtra("elevatorId", r8);
        if (this.mContext == null) goto L11;
        r10.setPackage("com.bytedance.radioservice");     // Catch: Exception -> L6
        this.mContext.sendBroadcastAsUser(r10, UserHandle.CURRENT, "com.obric.cae.permission.ACTION_CAE_NEAR_ELEVATOR");     // Catch: Exception -> L6
        r10.setPackage("com.obric.cae");     // Catch: Exception -> L6
        this.mContext.sendBroadcastAsUser(r10, UserHandle.CURRENT, "com.obric.cae.permission.ACTION_CAE_NEAR_ELEVATOR");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        CommSenseLog.e(TAG, "sendNearElevatorBroadcast, failed: " + e.getMessage());
        return;
    }

    private void startAsyncInit() {
        if (this.mAsyncInitStarted.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        new Thread(new k(this, 24), "NearElevatorInit").start();
    }

    public void clearAnchorList() {
        this.mElevatorScanAnchorList.clear();
    }

    public void inElevatorEvent() {
        NearElevatorListener r8 = this.mNearElevatorListener;
        if (r8 == null) goto L6;
        r8.inElevatorEvent();
    L6:
        if (this.mNearElevatorDetectedTime != 0) goto L8;
    L15:
        sendInElevatorBroadcast(this.mMatchAnchorElevatorId);
        return;
    L8:
        if ((System.currentTimeMillis() - this.mNearElevatorDetectedTime) > 120000) goto L15;
        CaeUserAwareReportBase r10 = CaeUserAwareReportFactory.getReportInstance();
        if (r10 == null) goto L12;
        r10.reportNearElevatorData(new InnerNearElevatorData(true, this.mMatchAnchorElevatorId, this.mMatchedElevatorUpdateCnt, this.mMatchedWifiDataPairs));
    L12:
        this.mNearElevatorDetectedTime = 0;
        AnchorData r11 = findAnchorById(this.mMatchAnchorElevatorId);
        if (r11 == null) goto L15;
        r11.errorMatchCnt = 0;
        goto L15
    }

    public void outElevatorEvent() {
        NearElevatorListener r8 = this.mNearElevatorListener;
        if (r8 == null) goto L5;
        r8.outElevatorEvent();
    L5:
        startWifiScan(ScanReason.OUT_ELEVATOR);
    }

    public void pushWifiScanResult(List<ScanResult> r8) {
        if (r8 != null) goto L4;
    L8:
        CommSenseLog.e(TAG, "pushWifiScanResult: empty scanResults");
        return;
    L4:
        if (r8.isEmpty() == true) goto L8;
        this.mWifiScanResultQueue.offer(r8);
    }

    public void regNearElevatorListener(NearElevatorListener r8) {
        if (this.mNearElevatorListener != null) goto L6;
        this.mNearElevatorListener = r8;
        return;
    }

    public synchronized void setWifiAwareInfoManager(WifiAwareInfoManager r8) {
        monitor-enter(this);
        this.mWifiAwareInfoManager = r8;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void startWifiScan(ScanReason r8) {
        String r10 = TAG;
        CommSenseLog.i(r10, "call startWifiScan");
        if (this.mIsScanning.get() == true) goto L5;
    L9:
        this.mStartScanTime = System.currentTimeMillis();
        this.mIsScanning.set(true);
        this.mScanReason.set(r8);
        ScanReason r11 = this.mScanReason.get();
        ScanReason r12 = ScanReason.OUT_ELEVATOR;
        if (r11 != r12) goto L12;
    L13:
        this.mOutElevatorTime = this.mStartScanTime;
    L14:
        if (r8 != r12) goto L16;
        int r13 = WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR;
        int r14 = WIFI_SCAN_TIMEOUT_WHEN_OUT_ELEVATOR;
    L17:
        WifiAwareInfoManager r15 = this.mWifiAwareInfoManager;
        if (r15 == null) goto L20;
        r15.startSingleHarDataCollection(r13, r14);
        return;
    L20:
        CommSenseLog.e(r10, "mWifiAwareInfoManager is null");
        return;
    L16:
        r13 = NetworkReportUtil.INTERVENTION_REPORT_EVENT_DELAY;
        r14 = 2000;
        goto L17
    L12:
        if (this.mScanReason.get() != ScanReason.OUT_ELEVATOR_TEST) goto L14;
    L5:
        if ((System.currentTimeMillis() - this.mStartScanTime) >= 3000) goto L8;
        CommSenseLog.d(r10, "startWifiScan is scanning");
        return;
    L8:
        this.mIsScanning.set(false);
        goto L9
    }

    public void unregNearElevatorListener() {
        this.mNearElevatorListener = null;
    }

    public void updateModel(Context r8) {
        if (AIKernelJavaBridge.isModelLoadSuccess(ELEVATOR_WIFI_MATCH_MODEL_NAME) == true) goto L6;
        CommSenseLog.i(TAG, "updateModel, model is not loaded, try to load");
        AIKernelJavaBridge.initAndLoadModel(CAE_APP_ID, r8, ELEVATOR_WIFI_MATCH_MODEL_NAME);
        return;
    }
}
