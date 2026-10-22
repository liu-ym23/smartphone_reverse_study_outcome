package com.bytedance.crash.resource;

import androidx.annotation.NonNull;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    public static boolean appendResourceMonitorTags(JSONObject r10, File r11) {
        return parseTagInfoForCrash(r10, new File(r11, "ht_leak_tags.txt"));
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
        boolean r10 = true;
        if (r11.optInt(KEY_FD_TRACK_ALLOW_LOOP_MONITOR) == 1) goto L8;
        r10 = false;
    L8:
        FdTrackConfig r12 = new FdTrackConfig(true, r10, r11.optInt(KEY_FD_TRACK_WATER_LINE), r11.optInt(KEY_FD_TRACK_DUMP_LINE), r11.optInt(KEY_FD_TRACK_SLEEP_TIME), r11.optInt(KEY_FD_TRACK_BT_LIMIT));
        this.mFdTrackConfig = r12;
        FdTrackAdapter.updateConfig(r12);
    }

    private void parseGWPAsanConfig(JSONObject r10) {
        GwpAsanConfig r11 = new GwpAsanConfig(r10.optJSONArray(KEY_GWP_ASAN_CONFIG));
        this.mGwpAsanConfig = r11;
        GwpAsanAdapter.updateConfig(r11);
    }

    private void parseHeapTrackerConfig(JSONObject r10) {
        NativeHeapTrackerConfig r11 = new NativeHeapTrackerConfig(r10.optJSONArray(KEY_HEAP_TRACK_PARAMS));
        this.mNativeHeapTrackerConfig = r11;
        NativeHeapTrackAdapter.updateConfig(r11);
    }

    private void parseRefMonitorConfig(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.optInt(KEY_REF_MONITOR_TYPE);
        int r12 = r10.optInt(KEY_REF_MONITOR_BT_FLAG);
        JSONArray r13 = r10.optJSONArray(KEY_REF_MONITOR_LIMITS);
        if (r13 != null) goto L7;
    L8:
        r13 = new JSONArray();
        r13.put(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        r13.put(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        r13.put(500);
    L9:
        RefMonitorConfig r14 = new RefMonitorConfig(r11, r13, r12);
        this.mRefMonitorConfig = r14;
        RefMonitorAdapter.updateConfig(r14);
        return;
    L7:
        if (r13.length() >= 3) goto L9;
        goto L8
    }

    protected static boolean parseTagInfoForCrash(JSONObject r10, File r11) {
        if (r11.exists() == true) goto L23;
        return false;
    L23:
        NumRanges r12 = new NumRanges("MB");     // Catch: Throwable -> L19
        r12.set(new Long[]{0L, 1L, 128L, 256L, 384L, 512L, 768L, 1024L});     // Catch: Throwable -> L19
        String[] r13 = FileUtils.readFile(r11.getAbsolutePath()).split("\n");     // Catch: Throwable -> L19
        int r14 = r13.length;     // Catch: Throwable -> L19
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L18;
        String r16 = r13[r15];     // Catch: Throwable -> L19
        if (r16 == null) goto L17;
        if (r16.trim().isEmpty() == true) goto L17;
        String[] r17 = r16.split(":");     // Catch: Throwable -> L19
        if (r17.length != 2) goto L17;
        String r18 = r17[1].trim();     // Catch: Throwable -> L19
        r18 = r12.get(Long.parseLong(r18));     // Catch: NumberFormatException -> L20 Throwable -> L19
    L16:
        r10.put(r17[0].trim(), r18);     // Catch: Throwable -> L19
    L17:
        r15 = r15 + 1;
        goto L6
    L18:
        return true;
    L19:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private void parseVmMonitorConfig(boolean r10, boolean r11, JSONObject r12) {
        if (r11 == false) goto L4;
        ?? r13 = (r10 ? 1 : 0) | 2;
    L4:
        JSONArray r14 = r12.optJSONArray(KEY_VM_MONITOR_LINE);
        JSONArray r15 = r12.optJSONArray(KEY_VM_MONITOR_PARAMS);
        JSONArray r16 = r12.optJSONArray(KEY_MPROTECT_PROTS);
        JSONArray r17 = r12.optJSONArray(KEY_VMM_PHY_CONFIG);
        VmMonitorConfig r18 = new VmMonitorConfig(r13 == true ? 1 : 0, r14, r15, r16, r17);
        this.mVmMonitorConfig = r18;
        VmMonitorAdapter.updateConfig(r18);
    }

    public static void updateConfig(@NonNull JSONObject r10, @NonNull JSONObject r11) {
        ResourceMonitorHolder.instance.doUpdateConfig(r10, r11);
    }

    public static void upload(@NonNull AppMonitor r10) {
        GwpAsanAdapter.upload(r10);
        NativeHeapTrackAdapter.upload(r10);
        VmMonitorAdapter.upload(r10);
        FdTrackAdapter.upload(r10);
        RefMonitorAdapter.upload(r10);
    }

    public void doUpdateConfig(@NonNull JSONObject r11, @NonNull JSONObject r12) {
        boolean r10 = false;
        if (r11.optInt(KEY_ENABLE_NATIVE_HEAP_TRACK) != 1) goto L5;
        boolean r13 = true;
    L7:
        if (r11.optInt(KEY_APP_32_OR_64) != 1) goto L9;
        boolean r14 = true;
    L11:
        if (r11.optInt(KEY_ENABLE_GWP_ASAN) != 1) goto L13;
        boolean r15 = true;
    L15:
        if (r11.optInt(KEY_ENABLE_VM_MONITOR_MMAP) != 1) goto L17;
        boolean r16 = true;
    L19:
        if (r11.optInt(KEY_ENABLE_VM_MONITOR_MPROTECT) != 1) goto L21;
        boolean r17 = true;
    L23:
        if (r11.optInt(KEY_ENABLE_REF_MONITOR) != 1) goto L25;
        boolean r18 = true;
    L27:
        if (r12.optInt(KEY_FD_TRACK_ENABLE) != 1) goto L29;
        boolean r19 = true;
    L31:
        if (r11.optInt(KEY_ENABLE_TLS_MONITOR) != 1) goto L33;
        boolean r20 = true;
    L34:
        if (r16 == true) goto L36;
        if (r17 == true) goto L36;
    L37:
        if (r20 == false) goto L39;
        enableTlsKeyMonitor();
    L39:
        if (r13 == true) goto L41;
    L49:
        if (r15 == true) goto L51;
    L56:
        if (r10 == true) goto L58;
    L64:
        if (r19 == false) goto L71;
        if (mIsHeapTrackerEnabled == true) goto L71;
        if (mIsVmmEnabled == true) goto L71;
        mFdTrackerEnabled = true;
        parseFdTrackConfig(r12);
    L71:
        if (mIsVmmEnabled == true) goto L73;
    L76:
        if (r18 == false) goto L80;
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
        parseVmMonitorConfig(r16, r17, r11);
        goto L64
    L51:
        if (mIsHeapTrackerEnabled == true) goto L56;
        if (mIsVmmEnabled == true) goto L56;
        if (r10 == true) goto L56;
        mIsGwpAsanEnabled = true;
        parseGWPAsanConfig(r11);
        goto L56
    L41:
        if (mFdTrackerEnabled == true) goto L49;
        if (mIsGwpAsanEnabled == true) goto L49;
        if (mIsVmmEnabled == true) goto L49;
        mIsHeapTrackerEnabled = true;
        if (NativeBridge.is64BitRuntime() != r14) goto L49;
        parseHeapTrackerConfig(r11);
    L36:
        r10 = true;
        goto L37
    L33:
        r20 = false;
        goto L34
    L29:
        r19 = false;
        goto L31
    L25:
        r18 = false;
        goto L27
    L21:
        r17 = false;
        goto L23
    L17:
        r16 = false;
        goto L19
    L13:
        r15 = false;
        goto L15
    L9:
        r14 = false;
        goto L11
    L5:
        r13 = false;
        goto L7
    }

    protected void enableTlsKeyMonitor() {
        TLSMonitorConfig r10 = new TLSMonitorConfig();
        this.mTLSMonitorConfig = r10;
        TLSMonitorAdapter.updateConfig(r10);
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
