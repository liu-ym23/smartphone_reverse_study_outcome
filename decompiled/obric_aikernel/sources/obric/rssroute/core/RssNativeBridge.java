package obric.rssroute.core;

import obric.rssroute.model.RssSessionInferenceData;
import obric.rssroute.model.RssSessionPolicyData;
import obric.rssroute.model.RssSessionPolicyDatas;
import obric.rssroute.model.RssSessionQosListener;
import obric.rssroute.model.RssSessionUidStatusListener;

/* JADX INFO: loaded from: classes3.dex */
public final class RssNativeBridge {
    public static final int ENERGY_HIGH_EMPHASIS = 4;
    public static final int ENERGY_MODERATE_EMPHASIS = 3;
    public static final int ENERGY_NOT_CARE = 1;
    public static final int ENERGY_SLIGHT_EMPHASIS = 2;
    public static final int ENERGY_STRONG_EMPHASIS = 5;
    public static final int EVENT_AI_KERNEL = 13010;
    public static final int INFO_TYPE_BOOL = 4;
    public static final int INFO_TYPE_FLOAT = 3;
    public static final int INFO_TYPE_INT32 = 1;
    public static final int INFO_TYPE_INT64 = 2;
    public static final int INFO_TYPE_STRING = 5;
    public static final int NPU_GEAR_BALANCED = 6;
    public static final int NPU_GEAR_BALANCED_DWATL = 7;
    public static final int NPU_GEAR_BURST = 10;
    public static final int NPU_GEAR_EXTREME_POWER_SAVER = 1;
    public static final int NPU_GEAR_HIGH_PERFORMANCE = 8;
    public static final int NPU_GEAR_HIGH_POWER_SAVER = 4;
    public static final int NPU_GEAR_LOW_BALANCED = 5;
    public static final int NPU_GEAR_LOW_POWER_SAVER = 2;
    public static final int NPU_GEAR_POWER_SAVER = 3;
    public static final int NPU_GEAR_SUSTAINED_HIGH_PERFORMANCE = 9;
    public static final int SCENE_AUDIO_RECORDING = 3;
    public static final int SCENE_GALLERY_INDEXING = 1;
    public static final int SCENE_HIGH_PRIORITY_NOTIFICATION = 2;
    public static final int SCENE_MEMORY = 4;
    public static final int SCENE_NONE = 0;
    public static final int SESSION_CLIENT_STATE_BACKGROUND = 1;
    public static final int SESSION_CLIENT_STATE_DEFAULT = 0;
    public static final int SESSION_CLIENT_STATE_FOCUS = 3;
    public static final int SESSION_CLIENT_STATE_FOREGROUND = 2;
    public static final int SESSION_CLIENT_STATE_SYSTEM_SERVICE = 4;
    public static final int SESSION_FEAT_AFFINITY = 8;
    public static final int SESSION_FEAT_FIX_FREQ = 4;
    public static final int SESSION_FEAT_SCHED_ATTR = 1;
    public static final int SESSION_FEAT_WAKEUP_PRIO = 2;
    public static final int SESSION_QOS_BACKGROUND = 1;
    public static final int SESSION_QOS_DEFAULT = 0;
    public static final int SESSION_QOS_FOCUS = 3;
    public static final int SESSION_QOS_FOREGROUND = 2;
    public static final int SF_INFERENCE = 8;
    public static final int SF_MEM_POOL = 2;
    public static final int SF_SCHED_ATTR = 1;
    private static boolean sInitialized;
    private static final boolean sNativeAvailable = false;

    static {
        System.loadLibrary("obric_rss_route_sdk_jni");     // Catch: Throwable -> L4
        boolean r10 = true;
    L5:
        sNativeAvailable = r10;
        return;
    L4:
        r10 = false;
        goto L5
    }

    private RssNativeBridge() {
    }

    public static String getLastDebugString() {
        if (sNativeAvailable == true) goto L7;
        return "native library is unavailable";
    L7:
        return nativeGetLastDebugString();
    }

    public static int getProductType() {
        if (sNativeAvailable == true) goto L7;
        return 0;
    L7:
        return nativeGetProductType();
    }

    public static synchronized int init() {
        monitor-enter(RssNativeBridge.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sNativeAvailable == true) goto L10;
        int r10 = -1;
    L7:
        monitor-exit(RssNativeBridge.class);
        return r10;
    L10:
        if (sInitialized == false) goto L12;
        r10 = 0;
        goto L7
    L12:
        int r11 = nativeInit();     // Catch: Throwable -> L17
        if (r11 != 0) goto L15;
        sInitialized = true;     // Catch: Throwable -> L17
    L15:
        monitor-exit(RssNativeBridge.class);
        return r11;
    }

    public static boolean isNativeAvailable() {
        return sNativeAvailable;
    }

    private static boolean isValidInfoData(String[] r10, int[] r11, long[] r12, float[] r13, String[] r14) {
        if (r10 == null) goto L40;
        if (r11 == null) goto L40;
        if (r12 == null) goto L40;
        if (r13 == null) goto L40;
        if (r14 == null) goto L40;
        if (r10.length == 0) goto L40;
        if (r10.length != r11.length) goto L40;
        if (r10.length != r12.length) goto L40;
        if (r10.length != r13.length) goto L40;
        if (r10.length != r14.length) goto L40;
        int r15 = 0;
    L21:
        if (r15 >= r10.length) goto L39;
        String r16 = r10[r15];
        if (r16 == null) goto L38;
        if (r16.isEmpty() == true) goto L38;
        if (r11[r15] < 1) goto L38;
        if (r11[r15] > 5) goto L38;
        if (r11[r15] != 5) goto L37;
        if (r14[r15] != null) goto L37;
        return false;
    L37:
        r15 = r15 + 1;
    L38:
        return false;
    L39:
        return true;
    L40:
        return false;
    }

    private static native String nativeGetLastDebugString();

    private static native int nativeGetProductType();

    private static native int nativeInit();

    private static native int nativeReportDataInfo(int r10, String[] r11, int[] r12, long[] r13, float[] r14, String[] r15);

    private static native int nativeSessionAddProc(int r10, int r11);

    private static native int nativeSessionAddThread(int r10, int r11);

    private static native int[] nativeSessionCreateGrp(int r10);

    private static native int[] nativeSessionCreateMemPoolGrp();

    private static native int nativeSessionDeleteGrp(int r10);

    private static native int nativeSessionEnableNpuPowerModeAutoFit(int r10);

    private static native int[] nativeSessionGetNetlinkListenerPortId();

    private static native int[] nativeSessionGetNpuPowerGear(int r10);

    private static native int[] nativeSessionGetTaskQos(int r10);

    private static native int[] nativeSessionRegisterQosListener(RssSessionQosListener r10);

    private static native int[] nativeSessionRegisterUidStatusListener(RssSessionUidStatusListener r10);

    private static native int nativeSessionRemoveProc(int r10);

    private static native int nativeSessionRemoveThread(int r10);

    private static native int nativeSessionSetClientUid(int r10, int r11);

    private static native int nativeSessionSetInferenceInfo(int r10, String r11, int r12, int r13, int r14, int r15);

    private static native int nativeSessionSetNetlinkPortId(int r10);

    private static native int nativeSessionSetPolicy(int r10, int[] r11, int[] r12, int[] r13, int[] r14, int[] r15, int[] r16, int[] r17, int[] r18);

    private static native int nativeSessionSetQos(int r10, int r11);

    private static native int nativeSessionStartNetlinkListener();

    private static native void nativeSessionStopNetlinkListener();

    private static native int nativeSessionUnregisterQosListener(int r10);

    private static native int nativeSessionUnregisterUidStatusListener(int r10);

    private static native int nativeShutdown();

    public static int reportDataInfo(int r10, String[] r11, int[] r12, long[] r13, float[] r14, String[] r15) {
        if (r10 != 0) goto L6;
        return -3;
    L6:
        if (isValidInfoData(r11, r12, r13, r14, r15) == true) goto L9;
        return -3;
    L9:
        if (sNativeAvailable == true) goto L13;
        return -1;
    L13:
        return nativeReportDataInfo(r10, r11, r12, r13, r14, r15);
    }

    public static int resReportAiData(String r10, int r11) {
        return reportDataInfo(13010, new String[]{r10}, new int[]{1}, new long[]{r11}, new float[]{0.0f}, new String[]{null});
    }

    public static int sessionAddProc(int r10, int r11) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionAddProc(r10, r11);
    }

    public static int sessionAddThread(int r10, int r11) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionAddThread(r10, r11);
    }

    public static int[] sessionCreateGrp(int r10) {
        if (sNativeAvailable == true) goto L7;
        return new int[]{-1, 0};
    L7:
        return nativeSessionCreateGrp(r10);
    }

    public static int[] sessionCreateMemPoolGrp() {
        if (sNativeAvailable == true) goto L7;
        return new int[]{-1, 0};
    L7:
        return nativeSessionCreateMemPoolGrp();
    }

    public static int sessionDeleteGrp(int r10) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionDeleteGrp(r10);
    }

    public static int sessionEnableNpuPowerModeAutoFit(int r10) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionEnableNpuPowerModeAutoFit(r10);
    }

    public static int[] sessionGetNetlinkListenerPortId() {
        if (sNativeAvailable == true) goto L7;
        return new int[]{-1, 0};
    L7:
        return nativeSessionGetNetlinkListenerPortId();
    }

    public static int[] sessionGetNpuPowerGear(int r10) {
        if (sNativeAvailable == true) goto L7;
        return new int[]{-1, 0};
    L7:
        return nativeSessionGetNpuPowerGear(r10);
    }

    public static int[] sessionGetTaskQos(int r10) {
        if (sNativeAvailable == true) goto L7;
        return new int[]{-1, 0, 0};
    L7:
        return nativeSessionGetTaskQos(r10);
    }

    public static int[] sessionRegisterQosListener(RssSessionQosListener r10) {
        if (sNativeAvailable == false) goto L5;
        if (r10 != null) goto L10;
        return new int[]{-3, 0};
    L10:
        return nativeSessionRegisterQosListener(r10);
    L5:
        return new int[]{-1, 0};
    }

    public static int[] sessionRegisterUidStatusListener(RssSessionUidStatusListener r10) {
        if (sNativeAvailable == false) goto L5;
        if (r10 != null) goto L10;
        return new int[]{-3, 0};
    L10:
        return nativeSessionRegisterUidStatusListener(r10);
    L5:
        return new int[]{-1, 0};
    }

    public static int sessionRemoveProc(int r10) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionRemoveProc(r10);
    }

    public static int sessionRemoveThread(int r10) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionRemoveThread(r10);
    }

    public static int sessionSetClientUid(int r10, int r11) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionSetClientUid(r10, r11);
    }

    public static int sessionSetInferenceInfo(RssSessionInferenceData r10) {
        if (sNativeAvailable == true) goto L6;
        return -1;
    L6:
        if (r10 != null) goto L10;
        return -3;
    L10:
        return nativeSessionSetInferenceInfo(r10.sessionId, r10.modelStage, r10.energyTendency, r10.sceneIndex, r10.targetNpuPowerGear, r10.refinedNpuPowerGear);
    }

    public static int sessionSetNetlinkPortId(int r10) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionSetNetlinkPortId(r10);
    }

    public static int sessionSetPolicy(RssSessionPolicyDatas r13) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        if (r13 == null) goto L21;
        RssSessionPolicyData[] r10 = r13.policies;
        if (r10 == null) goto L21;
        if (r10.length != 4) goto L21;
        int[] r11 = new int[4];
        int[] r12 = new int[4];
        int[] r14 = new int[4];
        int[] r15 = new int[4];
        int[] r16 = new int[4];
        int[] r17 = new int[4];
        int[] r18 = new int[4];
        int[] r19 = new int[4];
        int r20 = 0;
    L14:
        if (r20 >= 4) goto L20;
        RssSessionPolicyData[] r21 = r13.policies;
        if (r21[r20] == null) goto L17;
        r11[r20] = r21[r20].nice;
        r12[r20] = r21[r20].latencyNice;
        r14[r20] = r21[r20].uclampMin;
        r15[r20] = r21[r20].uclampMax;
        r16[r20] = r21[r20].affinity;
        r17[r20] = r21[r20].fixFreq0;
        r18[r20] = r21[r20].fixFreq6;
        r19[r20] = r21[r20].wakeupPrio;
        r20 = r20 + 1;
        goto L14
    L17:
        return -3;
    L20:
        return nativeSessionSetPolicy(r13.featFlags, r11, r12, r14, r15, r16, r17, r18, r19);
    L21:
        return -3;
    }

    public static int sessionSetQos(int r10, int r11) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionSetQos(r10, r11);
    }

    public static int sessionStartNetlinkListener() {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionStartNetlinkListener();
    }

    public static void sessionStopNetlinkListener() {
        if (sNativeAvailable == false) goto L6;
        nativeSessionStopNetlinkListener();
        return;
    }

    public static int sessionUnregisterQosListener(int r10) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionUnregisterQosListener(r10);
    }

    public static int sessionUnregisterUidStatusListener(int r10) {
        if (sNativeAvailable == true) goto L7;
        return -1;
    L7:
        return nativeSessionUnregisterUidStatusListener(r10);
    }

    public static synchronized int shutdown() {
        monitor-enter(RssNativeBridge.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sNativeAvailable == true) goto L10;
        sInitialized = false;     // Catch: Throwable -> L13
        monitor-exit(RssNativeBridge.class);
        return -1;
    L10:
        int r10 = nativeShutdown();     // Catch: Throwable -> L13
        sInitialized = false;     // Catch: Throwable -> L13
        monitor-exit(RssNativeBridge.class);
        return r10;
    }
}
