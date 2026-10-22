package com.bytedance.crash.resource.fdtrack;

import android.content.Context;
import com.bytedance.crash.Global;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.GuardFile;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class FdTrackAdapter extends ResourceMonitorAdapter {
    private static final int CMD_DUMP = 3;
    private static final int CMD_EXIT = 4;
    private static final int CMD_INIT = 0;
    private static final int CMD_TRACK = 1;
    private static final int CMD_WAIT = 2;
    private static final int CONFIG_SIZE = 6;
    private static final int CRASH_DUMP = 0;
    private static final String FD_LEAK_APP = "fd_leak_app";
    private static final String FD_LEAK_COUNT_RANGE = "fd_leak_count_range";
    private static final String FD_LEAK_LIB = "fd_leak_lib";
    private static final String FD_LEAK_REASON = "fd_leak_reason";
    private static final int GET_FD_COUNT_OBSERVE = 0;
    private static final int GET_FD_COUNT_TRACK = 1;
    private static final String HAS_FD_TRACK = "has_fd_track";
    private static final int PARAM_SIZE = 3;
    private static final int PRE_DUMP = 1;
    private static final int RET_OK = 0;
    private static final int SLEEPING_TIME_MIN = 1000;
    private static final int STATE_EXIT = 5;
    private static final int STATE_INIT = 0;
    private static final int STATE_OBSERV = 2;
    private static final int STATE_PREPARE = 1;
    private static final int STATE_TRACK = 3;
    private static final int STATE_WAIT = 4;
    public static final String TAG = "FdTracker: ";
    private static FdTrackAdapter mInstance;
    private FdTrackConfig mConfig;
    private boolean mIsRunning;
    private int mState;

    static class FdTrackUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        public FdTrackUploader(AppMonitor r1, File r2) {
            super(r1, r2);
        }

        private static String getFdLeakCountRange(String r1) {
            int r2 = Integer.parseInt(r1);
            if (r2 >= 300) goto L7;
            return "0 ~ 200";
        L7:
            if (r2 >= 500) goto L11;
            return "200 ~ 500";
        L11:
            if (r2 >= 800) goto L15;
            return "500 ~ 800";
        L15:
            if (r2 >= 1024) goto L19;
            return "800 ~ 1000";
        L19:
            if (r2 >= 1500) goto L22;
            return "1000 ~ 1500";
        L22:
            return "> 1500";
        }

        public static boolean hasFdLeak(String r1) {
            return !"".equals(r1);
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> r3, ResourceMonitorAdapter.UploaderData r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            super.packFilterData(r5, r4);
            if (GeneralInfoManager.isRoot() == false) goto L5;
            String r2 = "true";
        L6:
            r5.put("is_root", r2);
            r5.put(FdTrackAdapter.FD_LEAK_APP, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName());
            return;
        L5:
            r2 = "false";
            goto L6
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public boolean parseReport(File r11, ResourceMonitorAdapter.UploaderData r12) {
            File r1 = new File(r11, "tombstone.txt");
            File r2 = new File(r11, "javastack.txt");
            File r3 = new File(r11, "fd_types.txt");
            if (r1.exists() == true) goto L57;
            return false;
        L57:
        L50:
            return false;
        L6:
            if (r2.exists() == false) goto L8;
            r12.mJavaStack = FileUtils.readFile(r2.getAbsolutePath());     // Catch: Throwable -> L50
        L8:
            JSONArray r13 = FileUtils.readFileArray(r1.getAbsolutePath());     // Catch: Throwable -> L50
            if (r13 != null) goto L12;
            NpthLog.i(FdTrackAdapter.TAG, "stack content is null");     // Catch: Throwable -> L50
            return false;
        L12:
            int r4 = getLineIndex(r13, 0, "pid:");     // Catch: Throwable -> L50
            if (r4 < 0) goto L21;
            String[] r6 = r13.optString(r4, null).trim().split("\\s");     // Catch: Throwable -> L50
            int r7 = 0;
        L16:
            if (r7 >= r6.length) goto L21;
            if ("name:".equals(r6[r7]) == true) goto L19;
            r7 = r7 + 1;     // Catch: Throwable -> L50
            goto L16
        L19:
            int r8 = r7 + 1;     // Catch: Throwable -> L50
            r12.mThreadName = r6[r8].substring(0, r6[r8].length());     // Catch: Throwable -> L50
        L21:
            StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L50
            int r5 = getLineIndex(r13, r4 + 1, "Signal ");     // Catch: Throwable -> L50
            if (r5 < 0) goto L24;
            r9.append(r13.optString(r5, null)).append('\n');     // Catch: Throwable -> L50
        L24:
            int r10 = getLineIndex(r13, r5 + 1, "Abort message:");     // Catch: Throwable -> L50
            if (r10 < 0) goto L32;
            r12.mAbortLine = r13.optString(r10, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L50
            r9.append(r12.mAbortLine).append('\n');     // Catch: Throwable -> L50
            if (r12.mAbortLine.startsWith("abort message:") == false) goto L32;
            Matcher r14 = Pattern.compile("^.*:\\s+(\\S+):.*,.*,\\s+\\S+\\s+(\\S+)\\(.*$").matcher(r12.mAbortLine);     // Catch: Throwable -> L51
            if (r14.find() == false) goto L32;
            r12.filterData.put(FdTrackAdapter.FD_LEAK_LIB, r14.group(1));     // Catch: Throwable -> L51
            r12.filterData.put(FdTrackAdapter.FD_LEAK_REASON, r14.group(2));     // Catch: Throwable -> L51
        L32:
            int r15 = getLineIndex(r13, r10 + 1, "backtrace:");
            if (r15 < 0) goto L55;
            int r16 = r15 + 1;
        L36:
            if (r16 >= r13.length()) goto L40;
            String r0 = r13.optString(r16, null);
            if (r0.startsWith("    #") == false) goto L40;
            r9.append(r0.trim()).append('\n');
            r16 = r16 + 1;
        L40:
            r12.mNativeStack = r9.toString();
        L55:
            JSONArray r17 = FileUtils.readFileArray(r3.getAbsolutePath());     // Catch: Throwable -> L52
            if (r17 == null) goto L48;
            String r18 = r17.optString(0, null);     // Catch: Throwable -> L52
            if (r18 == null) goto L48;
            if ("".equals(r18) == true) goto L48;
            r12.filterData.put(FdTrackAdapter.FD_LEAK_COUNT_RANGE, getFdLeakCountRange(r18.trim().split(" ")[1]));     // Catch: Throwable -> L52
        L48:
            r12.filterData.put(FdTrackAdapter.HAS_FD_TRACK, "true");     // Catch: Throwable -> L52
        L49:
            return true;
        }
    }

    public FdTrackAdapter() {
    }

    static /* synthetic */ FdTrackConfig access$000(FdTrackAdapter r0) {
        return r0.mConfig;
    }

    static /* synthetic */ int access$100(FdTrackAdapter r0) {
        return r0.mState;
    }

    static /* synthetic */ int access$102(FdTrackAdapter r0, int r1) {
        r0.mState = r1;
        return r1;
    }

    static /* synthetic */ int access$200(FdTrackAdapter r0) {
        return r0.getFdCount();
    }

    static /* synthetic */ int access$300(FdTrackAdapter r0) {
        return r0.nativeInit();
    }

    static /* synthetic */ int access$400(FdTrackAdapter r0) {
        return r0.nativeTrack();
    }

    static /* synthetic */ int access$500(FdTrackAdapter r0) {
        return r0.nativeWait();
    }

    static /* synthetic */ int access$600(FdTrackAdapter r0) {
        return r0.nativeDump();
    }

    static /* synthetic */ boolean access$702(FdTrackAdapter r0, boolean r1) {
        r0.mIsRunning = r1;
        return r1;
    }

    static /* synthetic */ GuardFile access$800(FdTrackAdapter r0) {
        return r0.mGuardFile;
    }

    static /* synthetic */ int access$900(FdTrackAdapter r0) {
        return r0.nativeExit();
    }

    public static int dumpNativeForCrash(File r1) {
        if (r1 != null) goto L6;
        return -1;
    L6:
        return NativeResourceMonitor.fdTrackDumpNative(0, r1.getAbsolutePath());
    }

    private boolean executeSafetyCheck() {
        if (this.mIsRunning == false) goto L8;
        String r3 = "already is running";
    L5:
        NpthLog.i(TAG, r3);
        return false;
    L8:
        if (this.mState == 0) goto L10;
        r3 = "invalid state";
        goto L5
    L10:
        this.mState = 1;
        return true;
    }

    public static FdTrackAdapter get() {
        if (mInstance != null) goto L15;
        monitor-enter(FdTrackAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new FdTrackAdapter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FdTrackAdapter.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private int getFdCount() {
        if (this.mState > 2) goto L5;
        int r1 = 0;
    L7:
        return NativeResourceMonitor.fdTrackGetFdCount(r1);
    L5:
        r1 = 1;
        goto L7
    }

    private int getFdTypeFromParam(String r5) {
        int r4 = 0;
        if (r5 != null) goto L5;
    L17:
        return 0;
    L5:
        if (r5.length() == 0) goto L17;
        String[] r6 = r5.split(",");
        int r0 = r6.length;
        int r1 = 0;
    L8:
        if (r4 >= r0) goto L15;
        int r2 = Integer.parseInt(r6[r4]);
        if (r2 < 0) goto L14;
        if (r2 >= 32) goto L14;
        r1 = r1 + (1 << r2);
    L14:
        r4 = r4 + 1;
        goto L8
    L15:
        NpthLog.i(TAG, "monitor type: " + r1);
        return r1;
    }

    private int nativeDump() {
        return NativeResourceMonitor.fdTrackDoCommand(3);
    }

    private int nativeExit() {
        return NativeResourceMonitor.fdTrackDoCommand(4);
    }

    private int nativeInit() {
        return NativeResourceMonitor.fdTrackDoCommand(0);
    }

    private int nativeTrack() {
        return NativeResourceMonitor.fdTrackDoCommand(1);
    }

    private int nativeWait() {
        return NativeResourceMonitor.fdTrackDoCommand(2);
    }

    public static void updateConfig(FdTrackConfig r1) {
        FdTrackAdapter r0 = get();
        r0.mConfig = r1;
        r0.startMonitor(r1);
    }

    public static void upload(AppMonitor r2) {
        new FdTrackUploader(r2, LogPath.getFdTrackPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(TAG, "upload exception:" + th);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.crash.resource.fdtrack.FdTrackAdapter$1] */
    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    public void executeMonitor() {
        NpthLog.i(TAG, "begin execute");
        if (executeSafetyCheck() == true) goto L5;
        return;
    L5:
        this.mIsRunning = true;
        final String r1 = "npthFdTracker";
        new AnonymousClass1(this, r1).start();
    }
}
