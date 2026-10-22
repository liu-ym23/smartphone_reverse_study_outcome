package com.bytedance.crash.resource.vmmonitor;

import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.GuardFile;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class VmMonitorAdapter extends ResourceMonitorAdapter {
    public static final int CMD_DUMP = 5;
    public static final int CMD_GET_LEAK_SIZE = 6;
    public static final int CMD_GET_RSS_SIZE = 8;
    public static final int CMD_GET_VM_SIZE = 7;
    public static final int CMD_HOOK = 1;
    public static final int CMD_RECOVER = 0;
    public static final int CMD_START_MONITOR = 3;
    public static final int CMD_STOP_MONITOR = 4;
    public static final int CMD_UNHOOK = 2;
    public static final int CRASH_DUMP = 0;
    public static final int MODE_1_STATE_EXIT = 4;
    public static final int MODE_1_STATE_MONITOR = 2;
    public static final int MODE_1_STATE_OBSERVE = 1;
    public static final int MODE_1_STATE_PREPARE = 0;
    public static final int MODE_1_STATE_RECOVERED = 5;
    public static final int MODE_1_STATE_WAIT = 3;
    public static final int MONITOR_MMAP = 0;
    public static final int MONITOR_MPROTECT = 1;
    public static final int RECOVER_ALL = 1;
    public static final int RECOVER_PARTIAL = 0;
    public static final int RET_OK = 0;
    public static final long SIZE_K = 1024;
    public static final int STATE_NATIVE_ERROR = -1;
    private static final String TAG = "VmMonitor: ";
    private static VmMonitorAdapter mInstance = null;
    private static long minRssKB = 512000;
    private static MonitorState mmapState = null;
    private static MonitorState mprotectState = null;
    private static long originVmSize = 819200;
    protected VmMonitorConfig mConfig;
    private int mMonitorType;

    static class MonitorState {
        boolean hasInit;
        boolean hookState;
        boolean isRunning;
        int monitorType;
        int nativeState;
        boolean unHookState;

        public MonitorState(int r10) {
            this.hasInit = false;
            this.hookState = false;
            this.unHookState = true;
            this.isRunning = false;
            this.nativeState = 0;
            this.monitorType = r10;
        }
    }

    static class VmMonitorUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        public VmMonitorUploader(AppMonitor r10, @NonNull File r11) {
            super(r10, r11);
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected void packFilterData(Map<String, String> r10, ResourceMonitorAdapter.UploaderData r11) {
            super.packFilterData(r10, r11);
            String r12 = "true";
            r10.put("mmap_monitor", "true");
            r10.put("has_mmap_leak", "true");
            if (GeneralInfoManager.isRoot() == true) goto L6;
            r12 = "false";
        L6:
            r10.put("is_root", r12);
            r10.put("mmap_leak_app", Global.getContext().getPackageName());
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File r11, ResourceMonitorAdapter.UploaderData r12) {
            File r10 = new File(r11, "tombstone.txt");
            File r13 = new File(r11, "javastack.txt");
            if (r10.exists() == true) goto L47;
            return false;
        L47:
        L43:
            return false;
        L6:
            if (r13.exists() == false) goto L8;
            r12.mJavaStack = FileUtils.readFile(r13.getAbsolutePath());     // Catch: Throwable -> L43
        L8:
            JSONArray r14 = FileUtils.readFileArray(r10.getAbsolutePath());     // Catch: Throwable -> L43
            if (r14 != null) goto L12;
            NpthLog.i(VmMonitorAdapter.TAG, "stack content is null");     // Catch: Throwable -> L43
            return false;
        L12:
            int r15 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r14, 0, "pid:");     // Catch: Throwable -> L43
            if (r15 < 0) goto L21;
            String[] r16 = r14.optString(r15, null).trim().split("\\s");     // Catch: Throwable -> L43
            int r17 = 0;
        L16:
            if (r17 >= r16.length) goto L21;
            if ("name:".equals(r16[r17]) == true) goto L19;
            r17 = r17 + 1;     // Catch: Throwable -> L43
            goto L16
        L19:
            r12.mThreadName = r16[r17 + 1];     // Catch: Throwable -> L43
        L21:
            StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L43
            int r19 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r14, r15 + 1, "Signal ");     // Catch: Throwable -> L43
            if (r19 < 0) goto L24;
            r18.append(r14.optString(r19, null));     // Catch: Throwable -> L43
            r18.append('\n');     // Catch: Throwable -> L43
        L24:
            int r20 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r14, r19 + 1, "Abort message:");     // Catch: Throwable -> L43
            if (r20 < 0) goto L33;
            String r21 = r14.optString(r20, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L43
            r12.mAbortLine = r21;     // Catch: Throwable -> L43
            r18.append(r21);     // Catch: Throwable -> L43
            r18.append('\n');     // Catch: Throwable -> L43
            if (r12.mAbortLine.startsWith("abort message:") == false) goto L33;
            Matcher r110 = Pattern.compile("^.*:\\s+(\\S+):.*,.*,.*:\\s+(\\S+)\\(.*:(\\S+)\\s+(\\S+)\\).*$").matcher(r12.mAbortLine);     // Catch: Throwable -> L44
            if (r110.find() == false) goto L33;
            r12.filterData.put("mmap_leak_lib", r110.group(1));     // Catch: Throwable -> L44
            r12.filterData.put("mmap_leak_reason", r110.group(2));     // Catch: Throwable -> L44
            r12.filterData.put("mmap_leak_size", ResourceMonitorAdapter.ResourceMonitorUploader.getSizeRange(r110.group(3), r110.group(4)));     // Catch: Throwable -> L44
        L33:
            int r111 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r14, r20 + 1, "backtrace:");     // Catch: Throwable -> L43
            if (r111 < 0) goto L42;
            int r112 = r111 + 1;     // Catch: Throwable -> L43
        L37:
            if (r112 >= r14.length()) goto L41;
            String r22 = r14.optString(r112, null);     // Catch: Throwable -> L43
            if (r22.startsWith("    #") == false) goto L41;
            r18.append(r22.trim());     // Catch: Throwable -> L43
            r18.append('\n');     // Catch: Throwable -> L43
            r112 = r112 + 1;     // Catch: Throwable -> L43
        L41:
            r12.mNativeStack = r18.toString();     // Catch: Throwable -> L43
        L42:
            return true;
        }
    }

    static {
    }

    public VmMonitorAdapter() {
    }

    static /* synthetic */ MonitorState access$000() {
        return mmapState;
    }

    static /* synthetic */ long access$100() {
        return originVmSize;
    }

    static /* synthetic */ void access$1000(int r10) {
        recoverNative(r10);
    }

    static /* synthetic */ long access$202(long r10) {
        minRssKB = r10;
        return r10;
    }

    static /* synthetic */ long access$300() {
        return getRssSize();
    }

    static /* synthetic */ void access$400(VmMonitorAdapter r10, int r11) {
        r10.startMonitorNative(r11);
    }

    static /* synthetic */ long access$500(boolean r10) {
        return getLeakSize(r10);
    }

    static /* synthetic */ void access$600(VmMonitorAdapter r10, int r11) {
        r10.stopMonitorNative(r11);
    }

    static /* synthetic */ void access$700(VmMonitorAdapter r10, int r11) {
        r10.unHook(r11);
    }

    static /* synthetic */ void access$800(VmMonitorAdapter r10, int r11) {
        r10.dumpNative(r11);
    }

    static /* synthetic */ GuardFile access$900(VmMonitorAdapter r10) {
        return r10.mGuardFile;
    }

    private boolean checkState(MonitorState r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = r10.nativeState;
        if (r11 != 4) goto L8;
        return false;
    L8:
        if (r11 != (-1)) goto L10;
        return false;
    L10:
        if (r11 == 5) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean checkStateAndHook(int r10) {
        MonitorState r11 = getState(r10);
        if (checkState(r11) == true) goto L7;
        return false;
    L7:
        if (r11.hookState == true) goto L12;
        if (r11.unHookState == false) goto L12;
        startHook(r10);
    L12:
        return r11.hookState;
    }

    private void dumpNative(int r10) {
        NativeResourceMonitor.vmMonitorDumpMaps(this.mLogDir);
        NativeResourceMonitor.vmMonitorDoCommand(5, 1);
        int r11 = NativeResourceMonitor.vmMonitorDoCommand(5, r10);
        setErrorState(r10, 5, r11);
        if (r11 == 0) goto L5;
        return;
    L5:
        DefaultWorkThread.postDelayed(new AnonymousClass2(this), VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);
        setState(r10);
    }

    private void executeVmMonitor() {
        if (checkStateAndHook(0) == true) goto L5;
        return;
    L5:
        MonitorState r10 = mmapState;
        if (r10.isRunning == false) goto L9;
        NpthLog.d("VmMonitor: execute water line mode Already running");
        return;
    L9:
        r10.isRunning = true;
        r10.nativeState = 0;
        final String r11 = "mmapWaterLineModeMonitor";
        new AnonymousClass1(this, r11).start();
    }

    @NonNull
    public static VmMonitorAdapter get() {
        if (mInstance != null) goto L15;
        monitor-enter(VmMonitorAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new VmMonitorAdapter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(VmMonitorAdapter.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private static long getAndRefreshRss() {
        long r10 = getRssSize();
        if (r10 >= minRssKB) goto L5;
        minRssKB = r10;
    L5:
        return r10;
    }

    private static String getCommandString(int r10) {
        if (r10 != 0) goto L4;
        return "recover";
    L4:
        if (r10 != 1) goto L6;
        return "hook";
    L6:
        if (r10 != 3) goto L8;
        return "start_monitor";
    L8:
        if (r10 != 4) goto L10;
        return "stop_monitor";
    L10:
        if (r10 != 5) goto L12;
        return "dump";
    L12:
        if (r10 != 6) goto L14;
        return "get_leak_size";
    L14:
        if (r10 == 7) goto L17;
        return "unknown command";
    L17:
        return "get_vm_size";
    }

    private static long getLeakSize(boolean r10) {
        if (r10 == false) goto L6;
        return getAndRefreshRss() - minRssKB;
    L6:
        return getVmLeakSize();
    }

    private static long getRssSize() {
        int r10 = NativeResourceMonitor.vmMonitorDoCommand(8, 0);
        if (r10 >= 0) goto L8;
        MonitorState r11 = mmapState;
        if (r11 == null) goto L8;
        r11.nativeState = -1;
    L8:
        return Math.max(0, r10);
    }

    private static MonitorState getState(int r10) {
        if (r10 != 0) goto L5;
        return mmapState;
    L5:
        return mprotectState;
    }

    private static long getVmLeakSize() {
        int r10 = NativeResourceMonitor.vmMonitorDoCommand(6, 0);
        if (r10 >= 0) goto L8;
        MonitorState r11 = mmapState;
        if (r11 == null) goto L8;
        r11.nativeState = -1;
    L8:
        return Math.max(0, r10);
    }

    public static long getVmSize() {
        return Math.max(0, NativeResourceMonitor.vmMonitorDoCommand(7, 0));
    }

    public static long getWaterSize(boolean r10) {
        if (r10 == false) goto L6;
        long r11 = getAndRefreshRss();
        long r12 = minRssKB;
    L5:
        return r11 - r12;
    L6:
        r11 = getVmSize();
        r12 = originVmSize;
        goto L5
    }

    private static void recoverNative(int r10) {
        NpthLog.d("VmMonitor: recover");
        if (r10 != 1) goto L5;
        mmapState.nativeState = 5;
    L5:
        setErrorState(0, 0, NativeResourceMonitor.vmMonitorDoCommand(0, r10));
    }

    private static void setErrorState(int r10, int r11, int r12) {
        if (r12 == 0) goto L5;
        getState(r10).nativeState = -1;
        NpthLog.d(TAG + getCommandString(r11) + ": " + r12);
        return;
    }

    private void setState(int r10) {
        getState(r10).isRunning = false;
    }

    private void startHook(int r10) {
        NpthLog.d("VmMonitor: start hook: " + r10);
        if (r10 != 0) goto L5;
        MonitorState r11 = mmapState;
    L7:
        if (r11.hookState == false) goto L9;
        return;
    L9:
        int r12 = NativeResourceMonitor.vmMonitorDoCommand(1, r10);
        if (r12 != 0) goto L12;
        boolean r13 = true;
    L13:
        r11.hookState = r13;
        r11.unHookState = false;
        setErrorState(r10, 1, r12);
        return;
    L12:
        r13 = false;
        goto L13
    L5:
        r11 = mprotectState;
        goto L7
    }

    private void startMonitorNative(int r10) {
        NpthLog.d("VmMonitor: start monitor native");
        if (checkStateAndHook(r10) == true) goto L5;
        return;
    L5:
        setErrorState(r10, 3, NativeResourceMonitor.vmMonitorDoCommand(3, r10));
    }

    private void stopMonitorNative(int r10) {
        NpthLog.d("VmMonitor: stop monitor native");
        setErrorState(r10, 4, NativeResourceMonitor.vmMonitorDoCommand(4, r10));
    }

    private void unHook(int r10) {
        NpthLog.d("VmMonitor: exit hook");
        if (r10 != 0) goto L5;
        MonitorState r11 = mmapState;
    L7:
        if (r11.hookState == true) goto L9;
        return;
    L9:
        int r12 = NativeResourceMonitor.vmMonitorDoCommand(2, r10);
        if (r12 != 0) goto L12;
        boolean r13 = true;
    L13:
        r11.unHookState = r13;
        r11.hookState = true ^ r13;
        setErrorState(r10, 2, r12);
        return;
    L12:
        r13 = false;
        goto L13
    L5:
        r11 = mprotectState;
        goto L7
    }

    public static void updateConfig(VmMonitorConfig r10) {
        VmMonitorAdapter r11 = get();
        r11.mConfig = r10;
        r11.startMonitor(r10);
    }

    public static void upload(AppMonitor r10) {
        new VmMonitorUploader(r10, LogPath.getVmMonitorPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(TAG, "upload exception:" + th);
    }

    public int doDumpNativeForce(String r10) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        return NativeResourceMonitor.vmMonitorDumpNative(this.mConfig.mMonitorType, 0, r10);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected void executeMonitor() {
        mmapState = new MonitorState(1);
        mprotectState = new MonitorState(2);
        if ((this.mConfig.mMonitorType & 1) == 0) goto L6;
        originVmSize = getVmSize();
        executeVmMonitor();
    L6:
        if ((this.mConfig.mMonitorType & 2) == 0) goto L9;
        startMonitorNative(1);
        return;
    }

    public void stopMprotectMonitor() {
        unHook(1);
    }
}
