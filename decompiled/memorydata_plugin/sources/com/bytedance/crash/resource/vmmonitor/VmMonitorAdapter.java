package com.bytedance.crash.resource.vmmonitor;

import android.content.Context;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
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

        public MonitorState(int r3) {
            this.hasInit = false;
            this.hookState = false;
            this.unHookState = true;
            this.isRunning = false;
            this.nativeState = 0;
            this.monitorType = r3;
        }
    }

    static class VmMonitorUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        public VmMonitorUploader(AppMonitor r1, File r2) {
            super(r1, r2);
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> r3, ResourceMonitorAdapter.UploaderData r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            super.packFilterData(r5, r4);
            String r6 = "true";
            r5.put("mmap_monitor", "true");
            r5.put("has_mmap_leak", "true");
            if (GeneralInfoManager.isRoot() == true) goto L6;
            r6 = "false";
        L6:
            r5.put("is_root", r6);
            r5.put("mmap_leak_app", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName());
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public boolean parseReport(File r11, ResourceMonitorAdapter.UploaderData r12) {
            File r1 = new File(r11, "tombstone.txt");
            File r2 = new File(r11, "javastack.txt");
            if (r1.exists() == true) goto L47;
            return false;
        L47:
        L43:
            return false;
        L6:
            if (r2.exists() == false) goto L8;
            r12.mJavaStack = FileUtils.readFile(r2.getAbsolutePath());     // Catch: Throwable -> L43
        L8:
            JSONArray r13 = FileUtils.readFileArray(r1.getAbsolutePath());     // Catch: Throwable -> L43
            if (r13 != null) goto L12;
            NpthLog.i(VmMonitorAdapter.TAG, "stack content is null");     // Catch: Throwable -> L43
            return false;
        L12:
            int r3 = getLineIndex(r13, 0, "pid:");     // Catch: Throwable -> L43
            if (r3 < 0) goto L21;
            String[] r5 = r13.optString(r3, null).trim().split("\\s");     // Catch: Throwable -> L43
            int r6 = 0;
        L16:
            if (r6 >= r5.length) goto L21;
            if ("name:".equals(r5[r6]) == true) goto L19;
            r6 = r6 + 1;     // Catch: Throwable -> L43
            goto L16
        L19:
            r12.mThreadName = r5[r6 + 1];     // Catch: Throwable -> L43
        L21:
            StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L43
            int r4 = getLineIndex(r13, r3 + 1, "Signal ");     // Catch: Throwable -> L43
            if (r4 < 0) goto L24;
            r7.append(r13.optString(r4, null)).append('\n');     // Catch: Throwable -> L43
        L24:
            int r8 = getLineIndex(r13, r4 + 1, "Abort message:");     // Catch: Throwable -> L43
            if (r8 < 0) goto L33;
            r12.mAbortLine = r13.optString(r8, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L43
            r7.append(r12.mAbortLine).append('\n');     // Catch: Throwable -> L43
            if (r12.mAbortLine.startsWith("abort message:") == false) goto L33;
            Matcher r10 = Pattern.compile("^.*:\\s+(\\S+):.*,.*,.*:\\s+(\\S+)\\(.*:(\\S+)\\s+(\\S+)\\).*$").matcher(r12.mAbortLine);     // Catch: Throwable -> L44
            if (r10.find() == false) goto L33;
            r12.filterData.put("mmap_leak_lib", r10.group(1));     // Catch: Throwable -> L44
            r12.filterData.put("mmap_leak_reason", r10.group(2));     // Catch: Throwable -> L44
            r12.filterData.put("mmap_leak_size", getSizeRange(r10.group(3), r10.group(4)));     // Catch: Throwable -> L44
        L33:
            int r14 = getLineIndex(r13, r8 + 1, "backtrace:");     // Catch: Throwable -> L43
            if (r14 < 0) goto L42;
            int r15 = r14 + 1;     // Catch: Throwable -> L43
        L37:
            if (r15 >= r13.length()) goto L41;
            String r0 = r13.optString(r15, null);     // Catch: Throwable -> L43
            if (r0.startsWith("    #") == false) goto L41;
            r7.append(r0.trim()).append('\n');     // Catch: Throwable -> L43
            r15 = r15 + 1;     // Catch: Throwable -> L43
        L41:
            r12.mNativeStack = r7.toString();     // Catch: Throwable -> L43
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

    static /* synthetic */ void access$1000(int r0) {
        recoverNative(r0);
    }

    static /* synthetic */ long access$202(long r0) {
        minRssKB = r0;
        return r0;
    }

    static /* synthetic */ long access$300() {
        return getRssSize();
    }

    static /* synthetic */ void access$400(VmMonitorAdapter r0, int r1) {
        r0.startMonitorNative(r1);
    }

    static /* synthetic */ long access$500(boolean r2) {
        return getLeakSize(r2);
    }

    static /* synthetic */ void access$600(VmMonitorAdapter r0, int r1) {
        r0.stopMonitorNative(r1);
    }

    static /* synthetic */ void access$700(VmMonitorAdapter r0, int r1) {
        r0.unHook(r1);
    }

    static /* synthetic */ void access$800(VmMonitorAdapter r0, int r1) {
        r0.dumpNative(r1);
    }

    static /* synthetic */ GuardFile access$900(VmMonitorAdapter r0) {
        return r0.mGuardFile;
    }

    private boolean checkState(MonitorState r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.nativeState != 4) goto L8;
        return false;
    L8:
        if (r3.nativeState != (-1)) goto L10;
        return false;
    L10:
        if (r3.nativeState == 5) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean checkStateAndHook(int r3) {
        MonitorState r0 = getState(r3);
        if (checkState(r0) == true) goto L7;
        return false;
    L7:
        if (r0.hookState == true) goto L12;
        if (r0.unHookState == false) goto L12;
        startHook(r3);
    L12:
        return r0.hookState;
    }

    private void dumpNative(int r4) {
        NativeResourceMonitor.vmMonitorDumpMaps(this.mLogDir);
        NativeResourceMonitor.vmMonitorDoCommand(5, 1);
        int r1 = NativeResourceMonitor.vmMonitorDoCommand(5, r4);
        setErrorState(r4, 5, r1);
        if (r1 == 0) goto L5;
        return;
    L5:
        DefaultWorkThread.postDelayed(new AnonymousClass2(this), 60000);
        setState(r4);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.crash.resource.vmmonitor.VmMonitorAdapter$1] */
    private void executeVmMonitor() {
        if (checkStateAndHook(0) == true) goto L6;
        return;
    L6:
        if (mmapState.isRunning == false) goto L9;
        NpthLog.d("VmMonitor: execute water line mode Already running");
        return;
    L9:
        mmapState.isRunning = true;
        mmapState.nativeState = 0;
        final String r1 = "mmapWaterLineModeMonitor";
        new AnonymousClass1(this, r1).start();
    }

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
        long r0 = getRssSize();
        if (r0 >= minRssKB) goto L5;
        minRssKB = r0;
    L5:
        return r0;
    }

    private static String getCommandString(int r1) {
        if (r1 != 0) goto L4;
        return "recover";
    L4:
        if (r1 != 1) goto L6;
        return "hook";
    L6:
        if (r1 != 3) goto L8;
        return "start_monitor";
    L8:
        if (r1 != 4) goto L10;
        return "stop_monitor";
    L10:
        if (r1 != 5) goto L12;
        return "dump";
    L12:
        if (r1 != 6) goto L14;
        return "get_leak_size";
    L14:
        if (r1 == 7) goto L17;
        return "unknown command";
    L17:
        return "get_vm_size";
    }

    private static long getLeakSize(boolean r4) {
        if (r4 == false) goto L6;
        return getAndRefreshRss() - minRssKB;
    L6:
        return getVmLeakSize();
    }

    private static long getRssSize() {
        int r0 = NativeResourceMonitor.vmMonitorDoCommand(8, 0);
        if (r0 >= 0) goto L8;
        MonitorState r2 = mmapState;
        if (r2 == null) goto L8;
        r2.nativeState = -1;
    L8:
        return Math.max(0, r0);
    }

    private static MonitorState getState(int r0) {
        if (r0 != 0) goto L5;
        return mmapState;
    L5:
        return mprotectState;
    }

    private static long getVmLeakSize() {
        int r0 = NativeResourceMonitor.vmMonitorDoCommand(6, 0);
        if (r0 >= 0) goto L8;
        MonitorState r2 = mmapState;
        if (r2 == null) goto L8;
        r2.nativeState = -1;
    L8:
        return Math.max(0, r0);
    }

    public static long getVmSize() {
        return Math.max(0, NativeResourceMonitor.vmMonitorDoCommand(7, 0));
    }

    public static long getWaterSize(boolean r4) {
        if (r4 == false) goto L6;
        long r0 = getAndRefreshRss();
        long r2 = minRssKB;
    L5:
        return r0 - r2;
    L6:
        r0 = getVmSize();
        r2 = originVmSize;
        goto L5
    }

    private static void recoverNative(int r2) {
        NpthLog.d("VmMonitor: recover");
        if (r2 != 1) goto L5;
        mmapState.nativeState = 5;
    L5:
        setErrorState(0, 0, NativeResourceMonitor.vmMonitorDoCommand(0, r2));
    }

    private static void setErrorState(int r1, int r2, int r3) {
        if (r3 == 0) goto L5;
        getState(r1).nativeState = -1;
        NpthLog.d(TAG + getCommandString(r2) + ": " + r3);
        return;
    }

    private void setState(int r1) {
        getState(r1).isRunning = false;
    }

    private void startHook(int r5) {
        NpthLog.d("VmMonitor: start hook: " + r5);
        if (r5 != 0) goto L5;
        MonitorState r4 = mmapState;
    L7:
        if (r4.hookState == false) goto L9;
        return;
    L9:
        int r1 = NativeResourceMonitor.vmMonitorDoCommand(1, r5);
        if (r1 != 0) goto L12;
        boolean r3 = true;
    L13:
        r4.hookState = r3;
        r4.unHookState = false;
        setErrorState(r5, 1, r1);
        return;
    L12:
        r3 = false;
        goto L13
    L5:
        r4 = mprotectState;
        goto L7
    }

    private void startMonitorNative(int r2) {
        NpthLog.d("VmMonitor: start monitor native");
        if (checkStateAndHook(r2) == true) goto L5;
        return;
    L5:
        setErrorState(r2, 3, NativeResourceMonitor.vmMonitorDoCommand(3, r2));
    }

    private void stopMonitorNative(int r2) {
        NpthLog.d("VmMonitor: stop monitor native");
        setErrorState(r2, 4, NativeResourceMonitor.vmMonitorDoCommand(4, r2));
    }

    private void unHook(int r5) {
        NpthLog.d("VmMonitor: exit hook");
        if (r5 != 0) goto L5;
        MonitorState r4 = mmapState;
    L7:
        if (r4.hookState == true) goto L9;
        return;
    L9:
        int r1 = NativeResourceMonitor.vmMonitorDoCommand(2, r5);
        if (r1 != 0) goto L12;
        boolean r3 = true;
    L13:
        r4.unHookState = r3;
        r4.hookState = true ^ r4.unHookState;
        setErrorState(r5, 2, r1);
        return;
    L12:
        r3 = false;
        goto L13
    L5:
        r4 = mprotectState;
        goto L7
    }

    public static void updateConfig(VmMonitorConfig r1) {
        VmMonitorAdapter r0 = get();
        r0.mConfig = r1;
        r0.startMonitor(r1);
    }

    public static void upload(AppMonitor r2) {
        new VmMonitorUploader(r2, LogPath.getVmMonitorPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(TAG, "upload exception:" + th);
    }

    public int doDumpNativeForce(String r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return NativeResourceMonitor.vmMonitorDumpNative(this.mConfig.mMonitorType, 0, r2);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    public void executeMonitor() {
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
