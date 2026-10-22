package com.bytedance.crash.terminate;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Global;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AppExitInfoUtils {
    public static final String APP_EXIT = "app_exit";
    private static volatile Object LOCK = null;
    public static final int MB_1 = 1024;
    private static final int REASON_ANR = 6;
    private static final int REASON_CRASH = 4;
    private static final int REASON_CRASH_NATIVE = 5;
    private static final int REASON_DEPENDENCY_DIED = 12;
    private static final int REASON_EXCESSIVE_RESOURCE_USAGE = 9;
    private static final int REASON_EXIT_SELF = 1;
    private static final int REASON_FREEZER = 14;
    private static final int REASON_INITIALIZATION_FAILURE = 7;
    private static final int REASON_LOW_MEMORY = 3;
    private static final int REASON_OTHER = 13;
    private static final int REASON_PERMISSION_CHANGE = 8;
    private static final int REASON_SIGNALED = 2;
    private static final int REASON_UNKNOWN = 0;
    private static final int REASON_USER_REQUESTED = 10;
    private static final int REASON_USER_STOPPED = 11;
    private static final int SUBREASON_CACHED_IDLE_FORCED_APP_STANDBY = 18;
    private static final int SUBREASON_EXCESSIVE_CPU = 7;
    private static final int SUBREASON_FORCE_STOP = 21;
    private static final int SUBREASON_FREEZER_BINDER_IOCTL = 19;
    private static final int SUBREASON_FREEZER_BINDER_TRANSACTION = 20;
    private static final int SUBREASON_IMPERCEPTIBLE = 15;
    private static final int SUBREASON_INVALID_START = 13;
    private static final int SUBREASON_INVALID_STATE = 14;
    private static final int SUBREASON_ISOLATED_NOT_NEEDED = 17;
    private static final int SUBREASON_KILL_ALL_BG_EXCEPT = 10;
    private static final int SUBREASON_KILL_ALL_FG = 9;
    private static final int SUBREASON_KILL_BACKGROUND = 24;
    private static final int SUBREASON_KILL_PID = 12;
    private static final int SUBREASON_KILL_UID = 11;
    private static final int SUBREASON_LARGE_CACHED = 5;
    private static final int SUBREASON_MEMORY_PRESSURE = 6;
    private static final int SUBREASON_PACKAGE_UPDATE = 25;
    private static final int SUBREASON_REMOVE_LRU = 16;
    private static final int SUBREASON_REMOVE_TASK = 22;
    private static final int SUBREASON_STOP_APP = 23;
    private static final int SUBREASON_SYSTEM_UPDATE_DONE = 8;
    private static final int SUBREASON_TOO_MANY_CACHED = 2;
    private static final int SUBREASON_TOO_MANY_EMPTY = 3;
    private static final int SUBREASON_TRIM_EMPTY = 4;
    private static final int SUBREASON_UNKNOWN = 0;
    private static final int SUBREASON_WAIT_FOR_DEBUGGER = 1;
    private static volatile boolean isLoaded = false;
    private static List<ApplicationExitInfo> sHistoryList;

    static {
        LOCK = new Object();
    }

    public AppExitInfoUtils() {
    }

    public static boolean enableProcessExitReason() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public static List<ApplicationExitInfo> getProcessExitReasons() {
        List<ApplicationExitInfo> r10 = realGetProcessExitReasons();
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10;
    }

    static String memValueToRange(long r10) {
        long r11 = r10 / 1024;     // Catch: Throwable -> L63
        if (r11 >= 1) goto L6;
        return "<1MB";
    L6:
        if (r11 > 30) goto L9;
        return "[1~30MB]";
    L9:
        if (r11 > 60) goto L12;
        return "(30~100MB]";
    L12:
        if (r11 > 100) goto L15;
        return "(60~100MB]";
    L15:
        if (r11 > 200) goto L18;
        return "(100~150MB]";
    L18:
        if (r11 > 300) goto L21;
        return "(200~300MB]";
    L21:
        if (r11 > 400) goto L24;
        return "(300~400MB]";
    L24:
        if (r11 > 500) goto L27;
        return "(400~500MB]";
    L27:
        if (r11 <= 600) goto L74;
        if (r11 <= 600) goto L34;
        if (r11 > 700) goto L34;
        return "(600~700MB]";
    L34:
        if (r11 > 800) goto L37;
        return "(700~800MB]";
    L37:
        if (r11 > 900) goto L40;
        return "(800~900MB]";
    L40:
        if (r11 > 1000) goto L43;
        return "(900~1000MB]";
    L43:
        if (r11 > 1500) goto L46;
        return "(1GB~1.5GB]";
    L46:
        if (r11 > 2000) goto L49;
        return "(1.5GB~2GB]";
    L49:
        if (r11 > WsConstants.EXIT_DELAY_TIME) goto L52;
        return "(2GB~3GB]";
    L52:
        if (r11 > 4000) goto L55;
        return "(3GB~4GB]";
    L55:
        if (r11 > 6000) goto L58;
        return "(4GB~6GB]";
    L58:
        if (r11 > 8000) goto L85;
        return "(6GB~8GB]";
    L85:
        return ">8G";
    L74:
        return "(500~600MB]";
    L63:
        return "invalid";
    }

    static String memValueToRange(String r10) {
        if (r10 != null) goto L70;
        return "not obtained";
    L70:
    L68:
        return "invalid";
    L4:
        if ("0.00".equals(r10) == false) goto L6;
        return "not obtained";
    L6:
        if (NetConst.NOT_ENCRYPT_VERISON_CODE.equals(r10) == true) goto L93;
        Long r11 = Long.valueOf(Long.parseLong(r10.substring(0, r10.indexOf("MB"))));     // Catch: Throwable -> L68
        if (r11.longValue() < 1) goto L91;
        if (r11.longValue() > 30) goto L14;
        return "[1~30MB]";
    L14:
        if (r11.longValue() > 60) goto L17;
        return "(30~100MB]";
    L17:
        if (r11.longValue() > 100) goto L20;
        return "(60~100MB]";
    L20:
        if (r11.longValue() > 200) goto L23;
        return "(100~150MB]";
    L23:
        if (r11.longValue() > 300) goto L26;
        return "(200~300MB]";
    L26:
        if (r11.longValue() > 400) goto L29;
        return "(300~400MB]";
    L29:
        if (r11.longValue() > 500) goto L32;
        return "(400~500MB]";
    L32:
        if (r11.longValue() > 600) goto L35;
        return "(500~600MB]";
    L35:
        if (r11.longValue() > 700) goto L38;
        return "(600~700MB]";
    L38:
        if (r11.longValue() > 800) goto L41;
        return "(700~800MB]";
    L41:
        if (r11.longValue() > 900) goto L44;
        return "(800~900MB]";
    L44:
        if (r11.longValue() > 1000) goto L47;
        return "(900~1000MB]";
    L47:
        if (r11.longValue() > 1500) goto L50;
        return "(1GB~1.5GB]";
    L50:
        if (r11.longValue() > 2000) goto L53;
        return "(1.5GB~2GB]";
    L53:
        if (r11.longValue() > WsConstants.EXIT_DELAY_TIME) goto L56;
        return "(2GB~3GB]";
    L56:
        if (r11.longValue() > 4000) goto L59;
        return "(3GB~4GB]";
    L59:
        if (r11.longValue() <= 6000) goto L88;
        if (r11.longValue() > 8000) goto L90;
        return "(6GB~8GB]";
    L90:
        return ">8G";
    L88:
        return "(4GB~6GB]";
    L91:
        return "< 1MB";
    L93:
        return "not obtained";
    }

    @Nullable
    public static List<ApplicationExitInfo> realGetProcessExitReasons() {
        if (enableProcessExitReason() == true) goto L5;
        return null;
    L5:
        Context r10 = Global.getContext();
        if (r10 != null) goto L8;
        return null;
    L8:
        ActivityManager r11 = (ActivityManager) r10.getSystemService("activity");
        if (r11 != null) goto L12;
        return null;
    L12:
        if (isLoaded == true) goto L14;
        Object r12 = LOCK;
        monitor-enter(r12);
    L24:
        th = move-exception;
        throw th;
    L18:
        if (isLoaded == true) goto L20;
        List<ApplicationExitInfo> r13 = r11.getHistoricalProcessExitReasons(r10.getPackageName(), 0, 0);     // Catch: Throwable -> L24
        sHistoryList = r13;     // Catch: Throwable -> L24
        r13.sort(new AnonymousClass1());     // Catch: Throwable -> L24
    L20:
        isLoaded = true;     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return sHistoryList;
    L14:
        return sHistoryList;
    }

    public static String reasonCodeToString(int r10) {
        switch(r10) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            case 13: goto L7;
            case 14: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "FREEZER";
    L7:
        return "OTHER KILLS BY SYSTEM";
    L9:
        return "DEPENDENCY DIED";
    L11:
        return "USER STOPPED";
    L13:
        return "USER REQUESTED";
    L15:
        return "EXCESSIVE RESOURCE USAGE";
    L17:
        return "PERMISSION CHANGE";
    L19:
        return "INITIALIZATION FAILURE";
    L21:
        return "ANR";
    L23:
        return "APP CRASH(NATIVE)";
    L25:
        return "APP CRASH(EXCEPTION)";
    L27:
        return "LOW_MEMORY";
    L29:
        return "SIGNALED";
    L31:
        return "EXIT_SELF";
    }

    public static String subreasonToString(int r10) {
        switch(r10) {
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L49;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L43;
            case 7: goto L41;
            case 8: goto L39;
            case 9: goto L37;
            case 10: goto L35;
            case 11: goto L33;
            case 12: goto L31;
            case 13: goto L29;
            case 14: goto L27;
            case 15: goto L25;
            case 16: goto L23;
            case 17: goto L21;
            case 18: goto L19;
            case 19: goto L17;
            case 20: goto L15;
            case 21: goto L13;
            case 22: goto L11;
            case 23: goto L9;
            case 24: goto L7;
            case 25: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "PACKAGE UPDATE";
    L7:
        return "KILL BACKGROUND";
    L9:
        return "STOP APP";
    L11:
        return "REMOVE TASK";
    L13:
        return "FORCE STOP";
    L15:
        return "FREEZER BINDER TRANSACTION";
    L17:
        return "FREEZER BINDER IOCTL";
    L19:
        return "CACHED IDLE FORCED APP STANDBY";
    L21:
        return "ISOLATED NOT NEEDED";
    L23:
        return "REMOVE LRU";
    L25:
        return "IMPERCEPTIBLE";
    L27:
        return "INVALID STATE";
    L29:
        return "INVALID START";
    L31:
        return "KILL PID";
    L33:
        return "KILL UID";
    L35:
        return "KILL ALL BG EXCEPT";
    L37:
        return "KILL ALL FG";
    L39:
        return "SYSTEM UPDATE_DONE";
    L41:
        return "EXCESSIVE CPU USAGE";
    L43:
        return "MEMORY PRESSURE";
    L45:
        return "LARGE CACHED";
    L47:
        return "TRIM EMPTY";
    L49:
        return "TOO MANY EMPTY PROCS";
    L51:
        return "TOO MANY CACHED PROCS";
    L53:
        return "WAIT FOR DEBUGGER";
    }
}
