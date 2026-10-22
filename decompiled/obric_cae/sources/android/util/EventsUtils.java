package android.util;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class EventsUtils {
    private static final int BUFFER_SIZE = 100000;
    public static final int FEAT_TYPE_ACTIVITY_PAUSED_TIMEOUT = 60;
    public static final int FEAT_TYPE_APP_START_EVENT = 56;
    public static final int FEAT_TYPE_BINDER_BLOCK_MONITOR_RESTORE = 53;
    public static final int FEAT_TYPE_BINDER_CALL_STAT = 37;
    public static final int FEAT_TYPE_BLUETOOTH_EVENT = 40;
    public static final int FEAT_TYPE_BSP_DATA_LIST = 10;
    public static final int FEAT_TYPE_CAMERA_TRACKER = 43;
    public static final int FEAT_TYPE_CGROUP_METRICS_INFO = 66;
    public static final int FEAT_TYPE_COMMON_PROTO_DATA = 0;
    public static final int FEAT_TYPE_DEVICE_POWER_DATA = 67;
    public static final int FEAT_TYPE_DISK_STATS = 32;
    public static final int FEAT_TYPE_FEAT_STATISTICS = 6;
    public static final int FEAT_TYPE_FREEZE_STATS = 63;
    public static final int FEAT_TYPE_GPU_MEM_SWAP_KEEP_ALIVE = 4;
    public static final int FEAT_TYPE_IOPRELOAD_DATA = 49;
    public static final int FEAT_TYPE_KEEP_ALIVE_PKG = 3;
    public static final int FEAT_TYPE_KILLING_STATS = 54;
    public static final int FEAT_TYPE_LOAD_INFO = 65;
    public static final int FEAT_TYPE_LOCATION_EVENTS = 18;
    public static final int FEAT_TYPE_NFC_EVENT = 90;
    public static final int FEAT_TYPE_OOM_AND_3RD = 62;
    public static final int FEAT_TYPE_PERF_APP_USAGE = 15;
    public static final int FEAT_TYPE_PERF_COMMON_DATA = 13;
    public static final int FEAT_TYPE_PERF_DALVIK_MEMLEAK = 14;
    public static final int FEAT_TYPE_PERF_DATA = 12;
    public static final int FEAT_TYPE_PERF_INPUT_HANG = 16;
    public static final int FEAT_TYPE_PERF_JANK_RECORD = 17;
    public static final int FEAT_TYPE_PERF_UID_CPU = 11;
    public static final int FEAT_TYPE_PREFETCH_STATS = 5;
    public static final int FEAT_TYPE_PROCESS_INTERCEPT_EVENT = 57;
    public static final int FEAT_TYPE_PROCLIFE_STATS = 61;
    public static final int FEAT_TYPE_PROC_FREQUENT_RESTART = 88;
    public static final int FEAT_TYPE_PROC_MEM_DETAIL = 76;
    public static final int FEAT_TYPE_PROC_STATS = 31;
    public static final int FEAT_TYPE_SCENE_EVENT = 51;
    public static final int FEAT_TYPE_SECURITY_CRYPTO_SDK_EVENT = 99;
    public static final int FEAT_TYPE_SHUT_DOWN = 1000;
    public static final int FEAT_TYPE_SINGLE3D = 55;
    public static final int FEAT_TYPE_STAB_EVENT = 36;
    public static final int FEAT_TYPE_STORAGE_ANTIAGING_EVENT = 48;
    public static final int FEAT_TYPE_SVP_SETTING = 47;
    public static final int FEAT_TYPE_SYS_EVENT_DATA = 2;
    public static final int FEAT_TYPE_SYS_PREFETCH = 38;
    public static final int FEAT_TYPE_TASK_DEEPCLEAN = 58;
    public static final int FEAT_TYPE_TOUCHCHAIN = 50;
    public static final int FEAT_TYPE_TRAIN_INFO_DATA = 1;
    public static final int FEAT_TYPE_UID_CPU_RUNNER = 59;
    public static final int FEAT_TYPE_ZEROD_PSGE_LIST_EVENT = 41;
    private static final int MAX_BUFFER_SIZE = 500000;
    private static final String TAG = "EventsUtils";

    public EventsUtils() {
    }

    public static ArrayList<byte[]> getEvents(int r8) {
        throw new RuntimeException("Stub!!");
    }

    public static int writeArgsEvent(long r8, int r10, Object... r11) {
        throw new RuntimeException("Stub!!");
    }

    public static int writeJsonEvent(long r8, int r10, JSONObject r11) {
        throw new RuntimeException("Stub!!");
    }

    public static int writePbEvent(long r8, int r10, byte[] r11) {
        throw new RuntimeException("Stub!!");
    }

    public static int writePbEventSinlgeFile(long r8, int r10, byte[] r11) {
        throw new RuntimeException("Stub!!");
    }
}
