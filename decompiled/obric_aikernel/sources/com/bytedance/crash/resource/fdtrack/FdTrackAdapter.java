package com.bytedance.crash.resource.fdtrack;

import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.GuardFile;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
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
        public FdTrackUploader(AppMonitor r10, @NonNull File r11) {
            super(r10, r11);
        }

        private static String getFdLeakCountRange(String r10) {
            int r11 = Integer.parseInt(r10);
            if (r11 >= 300) goto L7;
            return "0 ~ 200";
        L7:
            if (r11 >= 500) goto L11;
            return "200 ~ 500";
        L11:
            if (r11 >= 800) goto L15;
            return "500 ~ 800";
        L15:
            if (r11 >= 1024) goto L19;
            return "800 ~ 1000";
        L19:
            if (r11 >= 1500) goto L22;
            return "1000 ~ 1500";
        L22:
            return "> 1500";
        }

        public static boolean hasFdLeak(String r10) {
            return !"".equals(r10);
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected void packFilterData(Map<String, String> r10, ResourceMonitorAdapter.UploaderData r11) {
            super.packFilterData(r10, r11);
            if (GeneralInfoManager.isRoot() == false) goto L5;
            String r12 = "true";
        L6:
            r10.put("is_root", r12);
            r10.put(FdTrackAdapter.FD_LEAK_APP, Global.getContext().getPackageName());
            return;
        L5:
            r12 = "false";
            goto L6
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File r11, ResourceMonitorAdapter.UploaderData r12) {
            File r10 = new File(r11, "tombstone.txt");
            File r13 = new File(r11, "javastack.txt");
            File r14 = new File(r11, "fd_types.txt");
            if (r10.exists() == true) goto L55;
            return false;
        L55:
        L50:
            return false;
        L6:
            if (r13.exists() == false) goto L8;
            r12.mJavaStack = FileUtils.readFile(r13.getAbsolutePath());     // Catch: Throwable -> L50
        L8:
            JSONArray r15 = FileUtils.readFileArray(r10.getAbsolutePath());     // Catch: Throwable -> L50
            if (r15 != null) goto L12;
            NpthLog.i(FdTrackAdapter.TAG, "stack content is null");     // Catch: Throwable -> L50
            return false;
        L12:
            int r16 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r15, 0, "pid:");     // Catch: Throwable -> L50
            if (r16 < 0) goto L21;
            String[] r17 = r15.optString(r16, null).trim().split("\\s");     // Catch: Throwable -> L50
            int r18 = 0;
        L16:
            if (r18 >= r17.length) goto L21;
            if ("name:".equals(r17[r18]) == true) goto L19;
            r18 = r18 + 1;     // Catch: Throwable -> L50
            goto L16
        L19:
            int r19 = r18 + 1;     // Catch: Throwable -> L50
            r12.mThreadName = r17[r19].substring(0, r17[r19].length());     // Catch: Throwable -> L50
        L21:
            StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L50
            int r21 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r15, r16 + 1, "Signal ");     // Catch: Throwable -> L50
            if (r21 < 0) goto L24;
            r20.append(r15.optString(r21, null));     // Catch: Throwable -> L50
            r20.append('\n');     // Catch: Throwable -> L50
        L24:
            int r22 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r15, r21 + 1, "Abort message:");     // Catch: Throwable -> L50
            if (r22 < 0) goto L32;
            String r23 = r15.optString(r22, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L50
            r12.mAbortLine = r23;     // Catch: Throwable -> L50
            r20.append(r23);     // Catch: Throwable -> L50
            r20.append('\n');     // Catch: Throwable -> L50
            if (r12.mAbortLine.startsWith("abort message:") == false) goto L32;
            Matcher r110 = Pattern.compile("^.*:\\s+(\\S+):.*,.*,\\s+\\S+\\s+(\\S+)\\(.*$").matcher(r12.mAbortLine);     // Catch: Throwable -> L51
            if (r110.find() == false) goto L32;
            r12.filterData.put(FdTrackAdapter.FD_LEAK_LIB, r110.group(1));     // Catch: Throwable -> L51
            r12.filterData.put(FdTrackAdapter.FD_LEAK_REASON, r110.group(2));     // Catch: Throwable -> L51
        L32:
            int r111 = ResourceMonitorAdapter.ResourceMonitorUploader.getLineIndex(r15, r22 + 1, "backtrace:");
            if (r111 < 0) goto L53;
            int r112 = r111 + 1;
        L36:
            if (r112 >= r15.length()) goto L40;
            String r24 = r15.optString(r112, null);
            if (r24.startsWith("    #") == false) goto L40;
            r20.append(r24.trim());
            r20.append('\n');
            r112 = r112 + 1;
        L40:
            r12.mNativeStack = r20.toString();
        L53:
            JSONArray r113 = FileUtils.readFileArray(r14.getAbsolutePath());     // Catch: Throwable -> L52
            if (r113 == null) goto L48;
            String r114 = r113.optString(0, null);     // Catch: Throwable -> L52
            if (r114 == null) goto L48;
            if ("".equals(r114) == true) goto L48;
            r12.filterData.put(FdTrackAdapter.FD_LEAK_COUNT_RANGE, getFdLeakCountRange(r114.trim().split(" ")[1]));     // Catch: Throwable -> L52
        L48:
            r12.filterData.put(FdTrackAdapter.HAS_FD_TRACK, "true");     // Catch: Throwable -> L52
        L49:
            return true;
        }
    }

    public FdTrackAdapter() {
    }

    static /* synthetic */ FdTrackConfig access$000(FdTrackAdapter r10) {
        return r10.mConfig;
    }

    static /* synthetic */ int access$100(FdTrackAdapter r10) {
        return r10.mState;
    }

    static /* synthetic */ int access$102(FdTrackAdapter r10, int r11) {
        r10.mState = r11;
        return r11;
    }

    static /* synthetic */ int access$200(FdTrackAdapter r10) {
        return r10.getFdCount();
    }

    static /* synthetic */ int access$300(FdTrackAdapter r10) {
        return r10.nativeInit();
    }

    static /* synthetic */ int access$400(FdTrackAdapter r10) {
        return r10.nativeTrack();
    }

    static /* synthetic */ int access$500(FdTrackAdapter r10) {
        return r10.nativeWait();
    }

    static /* synthetic */ int access$600(FdTrackAdapter r10) {
        return r10.nativeDump();
    }

    static /* synthetic */ boolean access$702(FdTrackAdapter r10, boolean r11) {
        r10.mIsRunning = r11;
        return r11;
    }

    static /* synthetic */ GuardFile access$800(FdTrackAdapter r10) {
        return r10.mGuardFile;
    }

    static /* synthetic */ int access$900(FdTrackAdapter r10) {
        return r10.nativeExit();
    }

    public static int dumpNativeForCrash(File r10) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        return NativeResourceMonitor.fdTrackDumpNative(0, r10.getAbsolutePath());
    }

    private boolean executeSafetyCheck() {
        if (this.mIsRunning == false) goto L8;
        String r10 = "already is running";
    L5:
        NpthLog.i(TAG, r10);
        return false;
    L8:
        if (this.mState == 0) goto L10;
        r10 = "invalid state";
        goto L5
    L10:
        this.mState = 1;
        return true;
    }

    @NonNull
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
        int r10 = 0;
    L7:
        return NativeResourceMonitor.fdTrackGetFdCount(r10);
    L5:
        r10 = 1;
        goto L7
    }

    private int getFdTypeFromParam(String r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
    L17:
        return 0;
    L5:
        if (r10.length() == 0) goto L17;
        String[] r12 = r10.split(",");
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r11 >= r13) goto L15;
        int r15 = Integer.parseInt(r12[r11]);
        if (r15 < 0) goto L14;
        if (r15 >= 32) goto L14;
        r14 = r14 + (1 << r15);
    L14:
        r11 = r11 + 1;
        goto L8
    L15:
        NpthLog.i(TAG, "monitor type: " + r14);
        return r14;
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

    public static void updateConfig(FdTrackConfig r10) {
        FdTrackAdapter r11 = get();
        r11.mConfig = r10;
        r11.startMonitor(r10);
    }

    public static void upload(AppMonitor r10) {
        new FdTrackUploader(r10, LogPath.getFdTrackPath()).uploadAll();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.e(TAG, "upload exception:" + th);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected void executeMonitor() {
        NpthLog.i(TAG, "begin execute");
        if (executeSafetyCheck() == true) goto L5;
        return;
    L5:
        this.mIsRunning = true;
        final String r10 = "npthFdTracker";
        new AnonymousClass1(this, r10).start();
    }
}
