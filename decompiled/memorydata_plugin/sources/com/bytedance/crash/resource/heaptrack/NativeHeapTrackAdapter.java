package com.bytedance.crash.resource.heaptrack;

import android.content.Context;
import com.bytedance.crash.Global;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.GuardFile;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.tracker.ProcessTracker;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.NpthLog;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeHeapTrackAdapter extends ResourceMonitorAdapter {
    private static final String ALLOCATOR_TYPE = "ht_allocator_type";
    private static final int CMD_DUMP = 3;
    private static final int CMD_EXIT = 4;
    private static final int CMD_INIT = 0;
    private static final int CMD_STOP = 5;
    private static final int CMD_TRACK = 1;
    private static final int CMD_WAIT = 2;
    private static final String HAS_NATIVE_OOM = "has_native_oom";
    public static final String HAS_PROCESS_TRACK = "has_process_track";
    public static final String LOG_TAG = "NativeHeapTracker: ";
    private static final String NATIVE_OOM_APP = "native_oom_app";
    private static final String NATIVE_OOM_LIB = "native_oom_lib";
    private static final String NATIVE_OOM_MEM = "native_oom_mem";
    private static final String NATIVE_OOM_SIZE = "native_oom_size";
    private static final String NATIVE_OOM_THREAD = "native_oom_thread";
    private static final String NATIVE_OOM_THREAD_MEM = "native_oom_thread_mem";
    private static final String NATIVE_OOM_THREAD_SIZE = "native_oom_thread_size";
    private static final String NATIVE_SIG_CODE = "native_oom_sigcode";
    private static final int RET_OK = 0;
    private static final int STATE_EXIT = 6;
    private static final int STATE_INIT = 0;
    private static final int STATE_OBSERV = 2;
    private static final int STATE_PREPARE = 1;
    private static final int STATE_TRACING = 5;
    private static final int STATE_TRACK = 3;
    private static final int STATE_WAIT = 4;
    private static final String mHeapLocalTestConfig = "1#30#180#false#false#2#1#";
    private static NativeHeapTrackAdapter mInstance;
    private NativeHeapTrackerConfig mConfig;
    private boolean mDebug;
    private boolean mNativeError;
    private int mNativeState;
    private boolean mNeedDumpMemInfo;
    private boolean sIsRunning;

    static class HeapTrackerUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        public HeapTrackerUploader(AppMonitor r1, File r2) {
            super(r1, r2);
        }

        private void parseProcessTrack(File r4, ResourceMonitorAdapter.UploaderData r5) {
            File r3 = new File(r4, "process_track.txt");     // Catch: Throwable -> L26
            Map<String, String> r6 = r5.filterData;     // Catch: Throwable -> L26
            if (r3.exists() == false) goto L24;
            BufferedReader r7 = null;
            String r8 = null;
            r6.put("has_process_track", "true");     // Catch: Throwable -> L21
            BufferedReader r0 = new BufferedReader(new FileReader(r3));     // Catch: Throwable -> L21
        L30:
            String r9 = r0.readLine();     // Catch: Throwable -> L19
            if (r9 == null) goto L12;
            if (r9.contains("onResume") == false) goto L30;
            r8 = r9;
            goto L30
        L12:
            if (r8 == null) goto L18;
            String[] r10 = r8.split(" ", 3);     // Catch: Throwable -> L19
            if (r10.length <= 1) goto L18;
            String r11 = r10[1];     // Catch: Throwable -> L19
            int r12 = r11.indexOf(".onResume");     // Catch: Throwable -> L19
            if (r12 <= 0) goto L18;
            r6.put(MemoryInfoSectionEditActivity.KIND_SCENE, r11.substring(0, r12));     // Catch: Throwable -> L19
        L18:
            IoUtil.close(r0);     // Catch: Throwable -> L26
            return;
        L19:
            th = th;
            r7 = r0;
        L22:
            IoUtil.close(r7);     // Catch: Throwable -> L26
            throw th;     // Catch: Throwable -> L26
        L21:
            th = th;
            goto L22
        L24:
            r6.put("has_process_track", "false");     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            NpthMonitor.directReportInnerException("parseProcessTrack", th);
        }

        private void parseSoList(File r18, ResourceMonitorAdapter.UploaderData r19) {
            File r0 = new File(r18, "ht_so_list.txt");
            JSONArray r1 = new JSONArray();
            String[] r2 = FileUtils.readFile(r0.getAbsolutePath()).split("\n");     // Catch: Throwable -> L12
            int r3 = r2.length;     // Catch: Throwable -> L12
            int r4 = 0;
        L4:
            if (r4 >= r3) goto L10;
            String[] r5 = r2[r4].split("\\s+");     // Catch: Throwable -> L12
            if (r5.length < 6) goto L9;
            JSONObject r6 = new JSONObject();     // Catch: Throwable -> L12
            long r7 = Long.parseLong(r5[1]);     // Catch: Throwable -> L12
            long r9 = Long.parseLong(r5[2]);     // Catch: Throwable -> L12
            long r11 = Long.parseLong(r5[3]);     // Catch: Throwable -> L12
            long r13 = Long.parseLong(r5[4]);     // Catch: Throwable -> L12
            r6.put("so_name", r5[5]);     // Catch: Throwable -> L12
            r6.put("vm_size", Long.parseLong(r5[1]));     // Catch: Throwable -> L12
            long r10 = r9 + r11;     // Catch: Throwable -> L12
            r6.put("rss", r10);     // Catch: Throwable -> L12
            r6.put("avg_vm", r7 / r13);     // Catch: Throwable -> L12
            r6.put("avg_rss", r10 / r13);     // Catch: Throwable -> L12
            r1.put(r6);     // Catch: Throwable -> L12
        L9:
            r4 = r4 + 1;     // Catch: Throwable -> L12
            r3 = r3;
            goto L4
        L10:
            r19.extraDataInBody.put("leak_so_list", r1);     // Catch: Throwable -> L12
            return;
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> r5, ResourceMonitorAdapter.UploaderData r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            super.packFilterData(r7, r6);
            String r0 = "true";
            r7.put(Constants.HAS_DUMP, "true");
            if (GeneralInfoManager.isRoot() == false) goto L5;
            String r4 = "true";
        L6:
            r7.put("is_root", r4);
            if (r6.mNativeStack.isEmpty() == false) goto L10;
            r0 = "false";
        L10:
            r7.put(NativeHeapTrackAdapter.HAS_NATIVE_OOM, r0);
            r7.put(NativeHeapTrackAdapter.NATIVE_OOM_APP, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName());
            r7.put(NativeHeapTrackAdapter.ALLOCATOR_TYPE, NativeBridge.getMallocType());
            return;
        L5:
            r4 = "false";
            goto L6
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public boolean parseReport(File r21, ResourceMonitorAdapter.UploaderData r22) {
            boolean r6 = false;
            if (r21 != null) goto L6;
            NpthLog.e(NativeHeapTrackAdapter.LOG_TAG, "parseReport dir is null");
            return false;
        L6:
            parseSoList(r21, r22);
            parseProcessTrack(r21, r22);
            String r0 = "";
            JSONArray r7 = FileUtils.readFileArray(new File(r21, "tombstone.txt").getAbsolutePath());     // Catch: Throwable -> L102 IOException -> L104
            if (r7 != null) goto L10;
            return false;
        L10:
            int r8 = getLineIndex(r7, 0, "pid:");     // Catch: Throwable -> L102 IOException -> L104
            if (r8 >= 0) goto L13;
            return false;
        L13:
            String r9 = null;
            String[] r10 = r7.optString(r8, null).trim().split("\\s");     // Catch: Throwable -> L102 IOException -> L104
            int r11 = 0;
        L14:
            int r13 = 1;
            if (r11 >= r10.length) goto L26;
            String r12 = r10[r11];     // Catch: Throwable -> L102 IOException -> L104
            if ("pid:".equals(r12) == false) goto L20;
            int r14 = r11 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.mPid = Long.decode(r10[r14].substring(0, r10[r14].length() - 1)).longValue();     // Catch: Throwable -> L102 IOException -> L104
        L25:
            r11 = r11 + 1;     // Catch: Throwable -> L102 IOException -> L104
            goto L14
        L20:
            if ("tid:".equals(r12) == false) goto L23;
            int r15 = r11 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.mTid = Long.decode(r10[r15].substring(0, r10[r15].length() - 1)).longValue();     // Catch: Throwable -> L102 IOException -> L104
            goto L25
        L23:
            if ("name:".equals(r12) == false) goto L25;
            int r16 = r11 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.mThreadName = r10[r16].substring(0, r10[r16].length() - 1);     // Catch: Throwable -> L102 IOException -> L104
            goto L25
        L26:
            r22.mProcessName = r10[r10.length - 2];     // Catch: Throwable -> L102 IOException -> L104
            StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L102 IOException -> L104
            int r17 = getLineIndex(r7, r8 + 1, "Signal ");     // Catch: Throwable -> L102 IOException -> L104
            if (r17 >= 0) goto L29;
            return false;
        L29:
            String r18 = r7.optString(r17, null);     // Catch: Throwable -> L102 IOException -> L104
            r5.append(r18).append('\n');     // Catch: Throwable -> L102 IOException -> L104
            if (r18.startsWith("Signal 6(SIGABRT)") == false) goto L36;
            Matcher r19 = Pattern.compile("Code -\\d+\\(([^\\)]+)\\)").matcher(r18);     // Catch: Throwable -> L106
            if (r19.find() == false) goto L36;
            r0 = r19.group(1);     // Catch: Throwable -> L106
        L36:
            int r20 = getLineIndex(r7, r17 + 1, "Abort message:");     // Catch: Throwable -> L102 IOException -> L104
            if (r20 >= 0) goto L39;
            return false;
        L39:
            r22.mAbortLine = r7.optString(r20, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L102 IOException -> L104
            r5.append(r22.mAbortLine).append('\n');     // Catch: Throwable -> L102 IOException -> L104
        L60:
            String r3 = null;
            String r110 = null;
            String r111 = null;
        L61:
            String r112 = r111;
        L62:
            String r113 = r112;
        L63:
            String r2 = null;
        L65:
            int r23 = getLineIndex(r7, r20 + 1, "backtrace:");     // Catch: Throwable -> L102 IOException -> L104
            if (r23 >= 0) goto L68;
            return false;
        L68:
            int r24 = r23 + 1;     // Catch: Throwable -> L102 IOException -> L104
        L69:
            if (r24 >= r7.length()) goto L75;
            String r114 = r7.optString(r24, null);     // Catch: Throwable -> L102 IOException -> L104
        L101:
            return false;
        L100:
            return false;
        L73:
            if (r114.startsWith("    #") == false) goto L75;
            r5.append(r114.trim()).append('\n');     // Catch: Throwable -> L100 IOException -> L101
            r24 = r24 + 1;     // Catch: Throwable -> L100 IOException -> L101
            r6 = false;
        L75:
            r22.mNativeStack = r5.toString();     // Catch: Throwable -> L100 IOException -> L101
            int r25 = getLineIndex(r7, r24, "build id:");     // Catch: Throwable -> L100 IOException -> L101
            if (r25 <= 0) goto L97;
            int r26 = r25 + 1;     // Catch: Throwable -> L100 IOException -> L101
        L79:
            if (r26 >= r7.length()) goto L97;
            String r27 = r7.optString(r26, r9);     // Catch: Throwable -> L100 IOException -> L101
            if (r27.startsWith("    /") == false) goto L96;
            String[] r28 = r27.trim().split("\\s");     // Catch: Throwable -> L100 IOException -> L101
            if (r28.length < 3) goto L96;
        L122:
            r22.mSoUUID.put(new JSONObject().put(CrashBody.LIB_NAME, r28[0].substring(r28[0].lastIndexOf(47) + r13)).put(CrashBody.LIB_UUID, buildIDToUUID(r28[r28.length - r13].substring(0, r28[r28.length - r13].length() - r13))));     // Catch: Throwable -> L100 IOException -> L101
            goto L96
        L144:
            return false;
        L141:
            return false;
        L145:
            return false;
        L142:
            return false;
        L96:
            r26 = r26 + 1;     // Catch: Throwable -> L100 IOException -> L101
            r9 = null;
            r13 = 1;
        L97:
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_LIB, r110);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_SIZE, r111);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_MEM, r112);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD, r113);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD_SIZE, r3);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD_MEM, r2);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_SIG_CODE, r0);     // Catch: Throwable -> L100 IOException -> L101
            return true;
        L42:
            if (r22.mAbortLine.startsWith("abort message:") == false) goto L59;
            Matcher r4 = Pattern.compile("abort message: (\\S+):(\\d+)MB\\((\\d+)MB (\\d+)MB\\), (\\S+)\\(\\d+\\):(\\d+)MB\\((\\d+)MB (\\d+)MB\\)").matcher(r22.mAbortLine);     // Catch: Throwable -> L60
            if (r4.find() == false) goto L59;
            r110 = r4.group(1);     // Catch: Throwable -> L60
            r111 = getSizeRangeMB(Long.decode(r4.group(2)).longValue());     // Catch: Throwable -> L58
            r112 = getSizeRangeMB(Long.decode(r4.group(3)).longValue() + Long.decode(r4.group(4)).longValue());     // Catch: Throwable -> L57
            r113 = r4.group(5);     // Catch: Throwable -> L56
            r3 = getSizeRangeMB(Long.decode(r4.group(6)).longValue());     // Catch: Throwable -> L55
            r2 = getSizeRangeMB(Long.decode(r4.group(7)).longValue() + Long.decode(r4.group(8)).longValue());     // Catch: Throwable -> L107
        L55:
            r3 = null;
        L56:
            r3 = null;
            r113 = null;
        L57:
            r3 = null;
            r112 = null;
        L58:
            r3 = null;
            r111 = null;
        L59:
            r2 = null;
            r3 = null;
            r110 = null;
            r111 = null;
            r112 = null;
            r113 = null;
        L105:
            return r6;
        L103:
            return r6;
        }
    }

    static {
    }

    public NativeHeapTrackAdapter() {
        this.sIsRunning = false;
        this.mNeedDumpMemInfo = false;
        this.mDebug = true;
    }

    static /* synthetic */ int access$000(NativeHeapTrackAdapter r0) {
        return r0.mNativeState;
    }

    static /* synthetic */ int access$002(NativeHeapTrackAdapter r0, int r1) {
        r0.mNativeState = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(NativeHeapTrackAdapter r0) {
        return r0.mNativeError;
    }

    static /* synthetic */ NativeHeapTrackerConfig access$200(NativeHeapTrackAdapter r0) {
        return r0.mConfig;
    }

    static /* synthetic */ boolean access$300(NativeHeapTrackAdapter r0) {
        return r0.mDebug;
    }

    static /* synthetic */ String access$400(NativeHeapTrackAdapter r0) {
        return r0.getStateMsg();
    }

    static /* synthetic */ void access$500(NativeHeapTrackAdapter r0) {
        r0.trackNative();
    }

    static /* synthetic */ void access$600(NativeHeapTrackAdapter r0) {
        r0.waitNative();
    }

    static /* synthetic */ boolean access$702(NativeHeapTrackAdapter r0, boolean r1) {
        r0.sIsRunning = r1;
        return r1;
    }

    static /* synthetic */ void access$800(NativeHeapTrackAdapter r0) {
        r0.exitNative();
    }

    static /* synthetic */ GuardFile access$900(NativeHeapTrackAdapter r0) {
        return r0.mGuardFile;
    }

    private static void dumpActivityInfo(String r5) {
        File r0 = ProcessTracker.getInstance().getCurrentFile();     // Catch: Throwable -> L10
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.exists() == true) goto L7;
        return;
    L7:
        if (r0.length() <= 128) goto L17;
        FileUtils.copyAppend(r0, new File(r5, "process_track.txt"));     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L10:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpActivityInfo", th);
    }

    private void exitNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "exitNative");
    L5:
        int r0 = NativeResourceMonitor.nativeDoCommnad(4);
        if (r0 == 0) goto L9;
        NpthLog.i(LOG_TAG, "exitNative ret=" + r0);
        this.mNativeError = true;
        return;
    }

    public static NativeHeapTrackAdapter get() {
        if (mInstance != null) goto L15;
        monitor-enter(NativeHeapTrackAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new NativeHeapTrackAdapter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NativeHeapTrackAdapter.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private String getStateMsg() {
        switch(this.mNativeState) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return "[STATE_UNKNOWN]";
    L5:
        return "[STATE_EXIT]";
    L6:
        return "[STATE_TRACING]";
    L7:
        return "[STATE_WAIT]";
    L8:
        return "[STATE_TRACK]";
    L9:
        return "[STATE_OBSERV]";
    L10:
        return "[STATE_PREPARE]";
    L11:
        return "[STATE_INIT]";
    }

    private int initNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "initNative");
    L5:
        int r3 = NativeResourceMonitor.nativeDoCommnad(0);
        if (r3 == 0) goto L8;
        NpthLog.i(LOG_TAG, "initNative failed ret:" + r3);
    L8:
        return r3;
    }

    private void trackNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "trackNative");
    L5:
        int r2 = NativeResourceMonitor.nativeDoCommnad(1);
        if (r2 == 0) goto L9;
        NpthLog.i(LOG_TAG, "trackNative ret=" + r2);
        this.mNativeError = true;
        return;
    }

    public static void updateConfig(NativeHeapTrackerConfig r1) {
        NativeHeapTrackAdapter r0 = get();
        r0.mConfig = r1;
        r0.startMonitor(r1);
    }

    public static void upload(AppMonitor r2) {
        new HeapTrackerUploader(r2, LogPath.getNativeHeapTrackerPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(LOG_TAG, "upload exception:" + th);
    }

    private void waitNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "waitNative");
    L5:
        int r0 = NativeResourceMonitor.nativeDoCommnad(2);
        if (r0 == 0) goto L9;
        NpthLog.i(LOG_TAG, "waitNative ret=" + r0);
        this.mNativeError = true;
        return;
    }

    public void dumpNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "dumpNative");
    L5:
        int r0 = NativeResourceMonitor.nativeDoCommnad(3);
        if (r0 == 0) goto L8;
        NpthLog.i(LOG_TAG, "dumpNative ret=" + r0);
        this.mNativeError = true;
        return;
    L8:
        NativeResourceMonitor.dumpNativeInfoThreads(this.mLogDir);
        dumpActivityInfo(this.mLogDir);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.crash.resource.heaptrack.NativeHeapTrackAdapter$1] */
    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    public void executeMonitor() {
        if (this.sIsRunning == false) goto L7;
        NpthLog.i(LOG_TAG, "execute() Already running!");
        return;
    L7:
        if (this.mNativeState == 0) goto L10;
        NpthLog.e(LOG_TAG, "execute() Invalide state " + getStateMsg());
        return;
    L10:
        this.sIsRunning = true;
        if (initNative() == 0) goto L13;
        return;
    L13:
        this.mNativeState = 1;
        if (this.mNeedDumpMemInfo == false) goto L16;
        NativeResourceMonitor.nativeNeedDumpMemInfo(1);
    L16:
        final String r1 = "NativeHeapTracker";
        new AnonymousClass1(this, r1).start();
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    public boolean initBeforeSoLoad() {
        this.mNativeState = 0;
        this.mNativeError = false;
        return true;
    }

    public boolean shouldStopNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "trying stopNative");
    L5:
        int r3 = NativeResourceMonitor.nativeDoCommnad(5);
        if (r3 == 0) goto L8;
        NpthLog.i(LOG_TAG, "stopNative ret =" + r3);
    L8:
        if (r3 != 0) goto L10;
        return true;
    L10:
        return false;
    }
}
