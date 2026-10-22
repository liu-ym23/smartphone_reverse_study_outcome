package com.bytedance.crash.resource.heaptrack;

import androidx.annotation.NonNull;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
        protected HeapTrackerUploader(AppMonitor r10, @NonNull File r11) {
            super(r10, r11);
        }

        private void parseProcessTrack(File r10, ResourceMonitorAdapter.UploaderData r11) {
            File r12 = new File(r10, "process_track.txt");     // Catch: Throwable -> L26
            Map<String, String> r13 = r11.filterData;     // Catch: Throwable -> L26
            if (r12.exists() == false) goto L24;
            BufferedReader r14 = null;
            String r15 = null;
            r13.put("has_process_track", "true");     // Catch: Throwable -> L21
            BufferedReader r16 = new BufferedReader(new FileReader(r12));     // Catch: Throwable -> L21
        L30:
            String r17 = r16.readLine();     // Catch: Throwable -> L19
            if (r17 == null) goto L12;
            if (r17.contains("onResume") == false) goto L30;
            r15 = r17;
            goto L30
        L12:
            if (r15 == null) goto L18;
            String[] r18 = r15.split(" ", 3);     // Catch: Throwable -> L19
            if (r18.length <= 1) goto L18;
            String r19 = r18[1];     // Catch: Throwable -> L19
            int r20 = r19.indexOf(".onResume");     // Catch: Throwable -> L19
            if (r20 <= 0) goto L18;
            r13.put("scene", r19.substring(0, r20));     // Catch: Throwable -> L19
        L18:
            IoUtil.close(r16);     // Catch: Throwable -> L26
            return;
        L19:
            th = th;
            r14 = r16;
        L22:
            IoUtil.close(r14);     // Catch: Throwable -> L26
            throw th;     // Catch: Throwable -> L26
        L21:
            th = th;
            goto L22
        L24:
            r13.put("has_process_track", "false");     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            NpthMonitor.directReportInnerException("parseProcessTrack", th);
        }

        private void parseSoList(File r18, ResourceMonitorAdapter.UploaderData r19) {
            File r10 = new File(r18, "ht_so_list.txt");
            JSONArray r11 = new JSONArray();
            String[] r12 = FileUtils.readFile(r10.getAbsolutePath()).split("\n");     // Catch: Throwable -> L12
            int r13 = r12.length;     // Catch: Throwable -> L12
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L10;
            String[] r15 = r12[r14].split("\\s+");     // Catch: Throwable -> L12
            if (r15.length < 6) goto L9;
            JSONObject r16 = new JSONObject();     // Catch: Throwable -> L12
            long r17 = Long.parseLong(r15[1]);     // Catch: Throwable -> L12
            long r20 = Long.parseLong(r15[2]);     // Catch: Throwable -> L12
            long r110 = Long.parseLong(r15[3]);     // Catch: Throwable -> L12
            long r111 = Long.parseLong(r15[4]);     // Catch: Throwable -> L12
            r16.put("so_name", r15[5]);     // Catch: Throwable -> L12
            r16.put("vm_size", Long.parseLong(r15[1]));     // Catch: Throwable -> L12
            long r21 = r20 + r110;     // Catch: Throwable -> L12
            r16.put("rss", r21);     // Catch: Throwable -> L12
            r16.put("avg_vm", r17 / r111);     // Catch: Throwable -> L12
            r16.put("avg_rss", r21 / r111);     // Catch: Throwable -> L12
            r11.put(r16);     // Catch: Throwable -> L12
        L9:
            r14 = r14 + 1;     // Catch: Throwable -> L12
            r13 = r13;
            goto L4
        L10:
            r19.extraDataInBody.put("leak_so_list", r11);     // Catch: Throwable -> L12
            return;
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected void packFilterData(Map<String, String> r10, ResourceMonitorAdapter.UploaderData r11) {
            super.packFilterData(r10, r11);
            String r12 = "true";
            r10.put(Constants.HAS_DUMP, "true");
            if (GeneralInfoManager.isRoot() == false) goto L5;
            String r13 = "true";
        L6:
            r10.put("is_root", r13);
            if (r11.mNativeStack.isEmpty() == false) goto L10;
            r12 = "false";
        L10:
            r10.put(NativeHeapTrackAdapter.HAS_NATIVE_OOM, r12);
            r10.put(NativeHeapTrackAdapter.NATIVE_OOM_APP, Global.getContext().getPackageName());
            r10.put(NativeHeapTrackAdapter.ALLOCATOR_TYPE, NativeBridge.getMallocType());
            return;
        L5:
            r13 = "false";
            goto L6
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File r21, ResourceMonitorAdapter.UploaderData r22) {
            boolean r10 = false;
            if (r21 != null) goto L6;
            NpthLog.e(NativeHeapTrackAdapter.LOG_TAG, "parseReport dir is null");
            return false;
        L6:
            parseSoList(r21, r22);
            parseProcessTrack(r21, r22);
            String r11 = "";
            JSONArray r12 = FileUtils.readFileArray(new File(r21, "tombstone.txt").getAbsolutePath());     // Catch: Throwable -> L102 IOException -> L104
            if (r12 != null) goto L10;
            return false;
        L10:
            int r13 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r12, 0, "pid:");     // Catch: Throwable -> L102 IOException -> L104
            if (r13 >= 0) goto L13;
            return false;
        L13:
            String r14 = null;
            String[] r15 = r12.optString(r13, null).trim().split("\\s");     // Catch: Throwable -> L102 IOException -> L104
            int r16 = 0;
        L14:
            int r17 = 1;
            if (r16 >= r15.length) goto L26;
            String r18 = r15[r16];     // Catch: Throwable -> L102 IOException -> L104
            if ("pid:".equals(r18) == false) goto L20;
            int r19 = r16 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.mPid = Long.decode(r15[r19].substring(0, r15[r19].length() - 1)).longValue();     // Catch: Throwable -> L102 IOException -> L104
        L25:
            r16 = r16 + 1;     // Catch: Throwable -> L102 IOException -> L104
            goto L14
        L20:
            if ("tid:".equals(r18) == false) goto L23;
            int r110 = r16 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.mTid = Long.decode(r15[r110].substring(0, r15[r110].length() - 1)).longValue();     // Catch: Throwable -> L102 IOException -> L104
            goto L25
        L23:
            if ("name:".equals(r18) == false) goto L25;
            int r111 = r16 + 1;     // Catch: Throwable -> L102 IOException -> L104
            r22.mThreadName = r15[r111].substring(0, r15[r111].length() - 1);     // Catch: Throwable -> L102 IOException -> L104
            goto L25
        L26:
            r22.mProcessName = r15[r15.length - 2];     // Catch: Throwable -> L102 IOException -> L104
            StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L102 IOException -> L104
            int r23 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r12, r13 + 1, "Signal ");     // Catch: Throwable -> L102 IOException -> L104
            if (r23 >= 0) goto L29;
            return false;
        L29:
            String r112 = r12.optString(r23, null);     // Catch: Throwable -> L102 IOException -> L104
            r20.append(r112);     // Catch: Throwable -> L102 IOException -> L104
            r20.append('\n');     // Catch: Throwable -> L102 IOException -> L104
            if (r112.startsWith("Signal 6(SIGABRT)") == false) goto L36;
            Matcher r113 = Pattern.compile("Code -\\d+\\(([^\\)]+)\\)").matcher(r112);     // Catch: Throwable -> L106
            if (r113.find() == false) goto L36;
            r11 = r113.group(1);     // Catch: Throwable -> L106
        L36:
            int r24 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r12, r23 + 1, "Abort message:");     // Catch: Throwable -> L102 IOException -> L104
            if (r24 >= 0) goto L39;
            return false;
        L39:
            String r25 = r12.optString(r24, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L102 IOException -> L104
            r22.mAbortLine = r25;     // Catch: Throwable -> L102 IOException -> L104
            r20.append(r25);     // Catch: Throwable -> L102 IOException -> L104
            r20.append('\n');     // Catch: Throwable -> L102 IOException -> L104
        L60:
            String r26 = null;
            String r114 = null;
            String r115 = null;
        L61:
            String r116 = r115;
        L62:
            String r117 = r116;
        L63:
            String r27 = null;
        L65:
            int r28 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r12, r24 + 1, "backtrace:");     // Catch: Throwable -> L102 IOException -> L104
            if (r28 >= 0) goto L68;
            return false;
        L68:
            int r29 = r28 + 1;     // Catch: Throwable -> L102 IOException -> L104
        L69:
            if (r29 >= r12.length()) goto L75;
            String r118 = r12.optString(r29, null);     // Catch: Throwable -> L102 IOException -> L104
        L101:
            return false;
        L100:
            return false;
        L73:
            if (r118.startsWith("    #") == false) goto L75;
            r20.append(r118.trim());     // Catch: Throwable -> L100 IOException -> L101
            r20.append('\n');     // Catch: Throwable -> L100 IOException -> L101
            r29 = r29 + 1;     // Catch: Throwable -> L100 IOException -> L101
            r10 = false;
        L75:
            r22.mNativeStack = r20.toString();     // Catch: Throwable -> L100 IOException -> L101
            int r30 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r12, r29, "build id:");     // Catch: Throwable -> L100 IOException -> L101
            if (r30 <= 0) goto L97;
            int r31 = r30 + 1;     // Catch: Throwable -> L100 IOException -> L101
        L79:
            if (r31 >= r12.length()) goto L97;
            String r32 = r12.optString(r31, r14);     // Catch: Throwable -> L100 IOException -> L101
            if (r32.startsWith("    /") == false) goto L96;
            String[] r33 = r32.trim().split("\\s");     // Catch: Throwable -> L100 IOException -> L101
            if (r33.length < 3) goto L96;
        L126:
            r22.mSoUUID.put(new JSONObject().put(CrashBody.LIB_NAME, r33[0].substring(r33[0].lastIndexOf(47) + r17)).put(CrashBody.LIB_UUID, ResourceMonitorAdapter.ResourceMonitorUploader.buildIDToUUID(r33[r33.length - r17].substring(0, r33[r33.length - r17].length() - r17))));     // Catch: Throwable -> L100 IOException -> L101
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
            r31 = r31 + 1;     // Catch: Throwable -> L100 IOException -> L101
            r14 = null;
            r17 = 1;
        L97:
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_LIB, r114);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_SIZE, r115);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_MEM, r26);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD, r116);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD_SIZE, r117);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_OOM_THREAD_MEM, r27);     // Catch: Throwable -> L100 IOException -> L101
            r22.filterData.put(NativeHeapTrackAdapter.NATIVE_SIG_CODE, r11);     // Catch: Throwable -> L100 IOException -> L101
            return true;
        L42:
            if (r22.mAbortLine.startsWith("abort message:") == false) goto L59;
            Matcher r34 = Pattern.compile("abort message: (\\S+):(\\d+)MB\\((\\d+)MB (\\d+)MB\\), (\\S+)\\(\\d+\\):(\\d+)MB\\((\\d+)MB (\\d+)MB\\)").matcher(r22.mAbortLine);     // Catch: Throwable -> L60
            if (r34.find() == false) goto L59;
            r114 = r34.group(1);     // Catch: Throwable -> L60
            r115 = ResourceMonitorAdapter.ResourceMonitorUploader.getSizeRangeMB(Long.decode(r34.group(2)).longValue());     // Catch: Throwable -> L58
            r26 = ResourceMonitorAdapter.ResourceMonitorUploader.getSizeRangeMB(Long.decode(r34.group(3)).longValue() + Long.decode(r34.group(4)).longValue());     // Catch: Throwable -> L57
            r116 = r34.group(5);     // Catch: Throwable -> L56
            r117 = ResourceMonitorAdapter.ResourceMonitorUploader.getSizeRangeMB(Long.decode(r34.group(6)).longValue());     // Catch: Throwable -> L55
            r27 = ResourceMonitorAdapter.ResourceMonitorUploader.getSizeRangeMB(Long.decode(r34.group(7)).longValue() + Long.decode(r34.group(8)).longValue());     // Catch: Throwable -> L107
        L55:
            r117 = null;
        L56:
            r116 = null;
        L57:
            r26 = null;
            r116 = null;
        L58:
            r26 = null;
            r115 = null;
        L59:
            r27 = null;
            r26 = null;
            r114 = null;
            r115 = null;
            r116 = null;
            r117 = null;
        L105:
            return r10;
        L103:
            return r10;
        }
    }

    static {
    }

    public NativeHeapTrackAdapter() {
        this.sIsRunning = false;
        this.mNeedDumpMemInfo = false;
        this.mDebug = true;
    }

    static /* synthetic */ int access$000(NativeHeapTrackAdapter r10) {
        return r10.mNativeState;
    }

    static /* synthetic */ int access$002(NativeHeapTrackAdapter r10, int r11) {
        r10.mNativeState = r11;
        return r11;
    }

    static /* synthetic */ boolean access$100(NativeHeapTrackAdapter r10) {
        return r10.mNativeError;
    }

    static /* synthetic */ NativeHeapTrackerConfig access$200(NativeHeapTrackAdapter r10) {
        return r10.mConfig;
    }

    static /* synthetic */ boolean access$300(NativeHeapTrackAdapter r10) {
        return r10.mDebug;
    }

    static /* synthetic */ String access$400(NativeHeapTrackAdapter r10) {
        return r10.getStateMsg();
    }

    static /* synthetic */ void access$500(NativeHeapTrackAdapter r10) {
        r10.trackNative();
    }

    static /* synthetic */ void access$600(NativeHeapTrackAdapter r10) {
        r10.waitNative();
    }

    static /* synthetic */ boolean access$702(NativeHeapTrackAdapter r10, boolean r11) {
        r10.sIsRunning = r11;
        return r11;
    }

    static /* synthetic */ void access$800(NativeHeapTrackAdapter r10) {
        r10.exitNative();
    }

    static /* synthetic */ GuardFile access$900(NativeHeapTrackAdapter r10) {
        return r10.mGuardFile;
    }

    private static void dumpActivityInfo(String r10) {
        File r11 = ProcessTracker.getInstance().getCurrentFile();     // Catch: Throwable -> L10
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.exists() == true) goto L7;
        return;
    L7:
        if (r11.length() <= 128) goto L17;
        FileUtils.copyAppend(r11, new File(r10, "process_track.txt"));     // Catch: Throwable -> L10
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
        int r10 = NativeResourceMonitor.nativeDoCommnad(4);
        if (r10 == 0) goto L9;
        NpthLog.i(LOG_TAG, "exitNative ret=" + r10);
        this.mNativeError = true;
        return;
    }

    @NonNull
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
        int r10 = NativeResourceMonitor.nativeDoCommnad(0);
        if (r10 == 0) goto L8;
        NpthLog.i(LOG_TAG, "initNative failed ret:" + r10);
    L8:
        return r10;
    }

    private void trackNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "trackNative");
    L5:
        int r10 = NativeResourceMonitor.nativeDoCommnad(1);
        if (r10 == 0) goto L9;
        NpthLog.i(LOG_TAG, "trackNative ret=" + r10);
        this.mNativeError = true;
        return;
    }

    public static void updateConfig(NativeHeapTrackerConfig r10) {
        NativeHeapTrackAdapter r11 = get();
        r11.mConfig = r10;
        r11.startMonitor(r10);
    }

    public static void upload(AppMonitor r10) {
        new HeapTrackerUploader(r10, LogPath.getNativeHeapTrackerPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(LOG_TAG, "upload exception:" + th);
    }

    private void waitNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "waitNative");
    L5:
        int r10 = NativeResourceMonitor.nativeDoCommnad(2);
        if (r10 == 0) goto L9;
        NpthLog.i(LOG_TAG, "waitNative ret=" + r10);
        this.mNativeError = true;
        return;
    }

    public void dumpNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "dumpNative");
    L5:
        int r10 = NativeResourceMonitor.nativeDoCommnad(3);
        if (r10 == 0) goto L8;
        NpthLog.i(LOG_TAG, "dumpNative ret=" + r10);
        this.mNativeError = true;
        return;
    L8:
        NativeResourceMonitor.dumpNativeInfoThreads(this.mLogDir);
        dumpActivityInfo(this.mLogDir);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected void executeMonitor() {
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
        final String r10 = "NativeHeapTracker";
        new AnonymousClass1(this, r10).start();
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected boolean initBeforeSoLoad() {
        this.mNativeState = 0;
        this.mNativeError = false;
        return true;
    }

    public boolean shouldStopNative() {
        if (this.mDebug == false) goto L5;
        NpthLog.i(LOG_TAG, "trying stopNative");
    L5:
        int r10 = NativeResourceMonitor.nativeDoCommnad(5);
        if (r10 == 0) goto L8;
        NpthLog.i(LOG_TAG, "stopNative ret =" + r10);
    L8:
        if (r10 != 0) goto L10;
        return true;
    L10:
        return false;
    }
}
