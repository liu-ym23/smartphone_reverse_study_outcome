package com.bytedance.crash.resource;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.fdtrack.FdTrackAdapter;
import com.bytedance.crash.resource.fdtrack.FdTrackConfig;
import com.bytedance.crash.resource.gwpasan.GwpAsanAdapter;
import com.bytedance.crash.resource.gwpasan.GwpAsanConfig;
import com.bytedance.crash.resource.heaptrack.NativeHeapTrackAdapter;
import com.bytedance.crash.resource.heaptrack.NativeHeapTrackerConfig;
import com.bytedance.crash.resource.refmonitor.RefMonitorAdapter;
import com.bytedance.crash.resource.refmonitor.RefMonitorConfig;
import com.bytedance.crash.resource.tlsmonitor.TLSMonitorAdapter;
import com.bytedance.crash.resource.tlsmonitor.TLSMonitorConfig;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.resource.vmmonitor.VmMonitorAdapter;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NumRanges;
import java.io.File;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceMonitor {
    private static final int BIT_MMAP = 0;
    private static final int BIT_MPROTECT = 1;
    protected static final String KEY_APP_32_OR_64 = "app_32_or_64";
    protected static final String KEY_ENABLE_GWP_ASAN = "enable_gwp_asan";
    protected static final String KEY_ENABLE_NATIVE_HEAP_TRACK = "enable_native_heap_track";
    protected static final String KEY_ENABLE_PRIO_MONITOR = "enable_setpriority_monitor";
    protected static final String KEY_ENABLE_REF_MONITOR = "enable_monitor_reference";
    protected static final String KEY_ENABLE_TLS_MONITOR = "enable_pthread_key_monitor";
    protected static final String KEY_ENABLE_VM_MONITOR_MMAP = "enable_mmap_monitor";
    protected static final String KEY_ENABLE_VM_MONITOR_MPROTECT = "enable_mprotect_monitor";
    protected static final String KEY_FD_TRACK_ALLOW_LOOP_MONITOR = "allow_loop_monitor";
    protected static final String KEY_FD_TRACK_BT_LIMIT = "backtrace_limit";
    protected static final String KEY_FD_TRACK_DUMP_LINE = "track_dump_line";
    protected static final String KEY_FD_TRACK_ENABLE = "enable_fd_track";
    protected static final String KEY_FD_TRACK_SLEEP_TIME = "track_sleep_time";
    protected static final String KEY_FD_TRACK_WATER_LINE = "track_water_line";
    protected static final String KEY_GWP_ASAN_CONFIG = "gwp_asan_set_init_param";
    protected static final String KEY_HEAP_TRACK_PARAMS = "native_heap_params";
    protected static final String KEY_MPROTECT_PROTS = "mprotect_monitor_prots";
    protected static final String KEY_PRIO_POLICY_CONFIG = "priority_policy_config";
    protected static final String KEY_REF_MONITOR_BT_FLAG = "ref_monitor_bt_flag";
    protected static final String KEY_REF_MONITOR_LIMITS = "ref_monitor_limits";
    protected static final String KEY_REF_MONITOR_TYPE = "ref_monitor_type";
    protected static final String KEY_VMM_PHY_CONFIG = "mmap_phy_config";
    protected static final String KEY_VM_MONITOR_LINE = "mmap_water_config";
    protected static final String KEY_VM_MONITOR_PARAMS = "mmap_monitor_params";
    protected static boolean mFdTrackerEnabled = false;
    protected static boolean mIsGwpAsanEnabled = false;
    protected static boolean mIsHeapTrackerEnabled = false;
    protected static boolean mIsVmmEnabled = false;
    protected FdTrackConfig mFdTrackConfig;
    protected GwpAsanConfig mGwpAsanConfig;
    protected NativeHeapTrackerConfig mNativeHeapTrackerConfig;
    protected RefMonitorConfig mRefMonitorConfig;
    protected TLSMonitorConfig mTLSMonitorConfig;
    protected VmMonitorConfig mVmMonitorConfig;

    private static class ResourceMonitorHolder {
        public static final ResourceMonitor instance = null;

        static {
            instance = new ResourceMonitor();
        }

        private ResourceMonitorHolder() {
        }
    }

    static {
    }

    public ResourceMonitor() {
    }

    public static boolean appendResourceMonitorTags(JSONObject r2, File r3) {
        return parseTagInfoForCrash(r2, new File(r3, "ht_leak_tags.txt"));
    }

    public static void deleteCrashLog() {
        FileUtils.deleteFile(LogPath.getVmMonitorPath());     // Catch: Throwable -> L4
        FileUtils.deleteFile(LogPath.getGwpAsanLogPath());     // Catch: Throwable -> L4
        FileUtils.deleteFile(LogPath.getFdTrackPath());     // Catch: Throwable -> L4
        FileUtils.deleteFile(LogPath.getNativeHeapTrackerPath());     // Catch: Throwable -> L4
        FileUtils.deleteFile(LogPath.getRefMonitorPath());     // Catch: Throwable -> L4
        FileUtils.deleteFile(LogPath.getTLSMonitorPath());     // Catch: Throwable -> L4
        FileUtils.deleteFile(LogPath.getPriorityMonitorPath());     // Catch: Throwable -> L4
        return;
    }

    private void parseFdTrackConfig(JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        boolean r1 = true;
        if (r11.optInt(KEY_FD_TRACK_ALLOW_LOOP_MONITOR) == 1) goto L8;
        r1 = false;
    L8:
        FdTrackConfig r12 = new FdTrackConfig(true, r1, r11.optInt(KEY_FD_TRACK_WATER_LINE), r11.optInt(KEY_FD_TRACK_DUMP_LINE), r11.optInt(KEY_FD_TRACK_SLEEP_TIME), r11.optInt(KEY_FD_TRACK_BT_LIMIT));
        this.mFdTrackConfig = r12;
        FdTrackAdapter.updateConfig(r12);
    }

    private void parseGWPAsanConfig(JSONObject r2) {
        GwpAsanConfig r0 = new GwpAsanConfig(r2.optJSONArray(KEY_GWP_ASAN_CONFIG));
        this.mGwpAsanConfig = r0;
        GwpAsanAdapter.updateConfig(r0);
    }

    private void parseHeapTrackerConfig(JSONObject r2) {
        NativeHeapTrackerConfig r0 = new NativeHeapTrackerConfig(r2.optJSONArray(KEY_HEAP_TRACK_PARAMS));
        this.mNativeHeapTrackerConfig = r0;
        NativeHeapTrackAdapter.updateConfig(r0);
    }

    private void parseRefMonitorConfig(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = r5.optInt(KEY_REF_MONITOR_TYPE);
        int r1 = r5.optInt(KEY_REF_MONITOR_BT_FLAG);
        JSONArray r6 = r5.optJSONArray(KEY_REF_MONITOR_LIMITS);
        if (r6 != null) goto L7;
    L8:
        r6 = new JSONArray();
        r6.put(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        r6.put(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        r6.put(500);
    L9:
        RefMonitorConfig r2 = new RefMonitorConfig(r0, r6, r1);
        this.mRefMonitorConfig = r2;
        RefMonitorAdapter.updateConfig(r2);
        return;
    L7:
        if (r6.length() >= 3) goto L9;
        goto L8
    }

    public static boolean parseTagInfoForCrash(JSONObject r10, File r11) {
        if (r11.exists() == true) goto L23;
        return false;
    L23:
        NumRanges r0 = new NumRanges("MB");     // Catch: Throwable -> L19
        r0.set(new Long[]{0L, 1L, 128L, 256L, 384L, 512L, 768L, 1024L});     // Catch: Throwable -> L19
        String[] r12 = FileUtils.readFile(r11.getAbsolutePath()).split("\n");     // Catch: Throwable -> L19
        int r2 = r12.length;     // Catch: Throwable -> L19
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L18;
        String r6 = r12[r3];     // Catch: Throwable -> L19
        if (r6 == null) goto L17;
        if (r6.trim().isEmpty() == true) goto L17;
        String[] r7 = r6.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);     // Catch: Throwable -> L19
        if (r7.length != 2) goto L17;
        String r8 = r7[1].trim();     // Catch: Throwable -> L19
        r8 = r0.get(Long.parseLong(r8));     // Catch: NumberFormatException -> L20 Throwable -> L19
    L16:
        r10.put(r7[0].trim(), r8);     // Catch: Throwable -> L19
    L17:
        r3 = r3 + 1;
        goto L6
    L18:
        return true;
    L19:
        return false;
    }

    private void parseVmMonitorConfig(boolean r7, boolean r8, JSONObject r9) {
        if (r7 == false) goto L4;
        int r10 = 1;
    L5:
        if (r8 == false) goto L7;
        r10 = r10 | 2;
    L7:
        VmMonitorConfig r11 = new VmMonitorConfig(r10, r9.optJSONArray(KEY_VM_MONITOR_LINE), r9.optJSONArray(KEY_VM_MONITOR_PARAMS), r9.optJSONArray(KEY_MPROTECT_PROTS), r9.optJSONArray(KEY_VMM_PHY_CONFIG));
        this.mVmMonitorConfig = r11;
        VmMonitorAdapter.updateConfig(r11);
        return;
    L4:
        r10 = 0;
        goto L5
    }

    public static void updateConfig(JSONObject r1, JSONObject r2) {
        ResourceMonitorHolder.instance.doUpdateConfig(r1, r2);
    }

    public static void upload(AppMonitor r0) {
        GwpAsanAdapter.upload(r0);
        NativeHeapTrackAdapter.upload(r0);
        VmMonitorAdapter.upload(r0);
        FdTrackAdapter.upload(r0);
        RefMonitorAdapter.upload(r0);
    }

    public void doUpdateConfig(JSONObject r11, JSONObject r12) {
        boolean r1 = false;
        if (r11.optInt(KEY_ENABLE_NATIVE_HEAP_TRACK) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (r11.optInt(KEY_APP_32_OR_64) != 1) goto L9;
        boolean r3 = true;
    L11:
        if (r11.optInt(KEY_ENABLE_GWP_ASAN) != 1) goto L13;
        boolean r4 = true;
    L15:
        if (r11.optInt(KEY_ENABLE_VM_MONITOR_MMAP) != 1) goto L17;
        boolean r5 = true;
    L19:
        if (r11.optInt(KEY_ENABLE_VM_MONITOR_MPROTECT) != 1) goto L21;
        boolean r6 = true;
    L23:
        if (r11.optInt(KEY_ENABLE_REF_MONITOR) != 1) goto L25;
        boolean r7 = true;
    L27:
        if (r12.optInt(KEY_FD_TRACK_ENABLE) != 1) goto L29;
        boolean r8 = true;
    L31:
        if (r11.optInt(KEY_ENABLE_TLS_MONITOR) != 1) goto L33;
        boolean r9 = true;
    L34:
        if (r5 == true) goto L36;
        if (r6 == true) goto L36;
    L37:
        if (r9 == false) goto L39;
        enableTlsKeyMonitor();
    L39:
        if (r0 == true) goto L41;
    L49:
        if (r4 == true) goto L51;
    L56:
        if (r1 == true) goto L58;
    L64:
        if (r8 == false) goto L71;
        if (mIsHeapTrackerEnabled == true) goto L71;
        if (mIsVmmEnabled == true) goto L71;
        mFdTrackerEnabled = true;
        parseFdTrackConfig(r12);
    L71:
        if (mIsVmmEnabled == true) goto L73;
    L76:
        if (r7 == false) goto L80;
        parseRefMonitorConfig(r11);
        return;
    L80:
        return;
    L73:
        if (mIsHeapTrackerEnabled == true) goto L76;
        if (mIsGwpAsanEnabled == true) goto L76;
        return;
    L58:
        if (mIsHeapTrackerEnabled == true) goto L64;
        if (mIsGwpAsanEnabled == true) goto L64;
        if (mFdTrackerEnabled == true) goto L64;
        mIsVmmEnabled = true;
        parseVmMonitorConfig(r5, r6, r11);
        goto L64
    L51:
        if (mIsHeapTrackerEnabled == true) goto L56;
        if (mIsVmmEnabled == true) goto L56;
        if (r1 == true) goto L56;
        mIsGwpAsanEnabled = true;
        parseGWPAsanConfig(r11);
        goto L56
    L41:
        if (mFdTrackerEnabled == true) goto L49;
        if (mIsGwpAsanEnabled == true) goto L49;
        if (mIsVmmEnabled == true) goto L49;
        mIsHeapTrackerEnabled = true;
        if (NativeBridge.is64BitRuntime() != r3) goto L49;
        parseHeapTrackerConfig(r11);
    L36:
        r1 = true;
        goto L37
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L31
    L25:
        r7 = false;
        goto L27
    L21:
        r6 = false;
        goto L23
    L17:
        r5 = false;
        goto L19
    L13:
        r4 = false;
        goto L15
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public void enableTlsKeyMonitor() {
        TLSMonitorConfig r0 = new TLSMonitorConfig();
        this.mTLSMonitorConfig = r0;
        TLSMonitorAdapter.updateConfig(r0);
    }

    public FdTrackConfig getFdTrackConfig() {
        return this.mFdTrackConfig;
    }

    public GwpAsanConfig getGwpAsanConfig() {
        return this.mGwpAsanConfig;
    }

    public RefMonitorConfig getRefMonitorConfig() {
        return this.mRefMonitorConfig;
    }

    public VmMonitorConfig getVmMonitorConfig() {
        return this.mVmMonitorConfig;
    }
}
