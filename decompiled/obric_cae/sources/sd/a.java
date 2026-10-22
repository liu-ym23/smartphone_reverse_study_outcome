package sd;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import r5.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f12108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f12109b;

    public static void a(Application r8) {
        f12108a = r8;
        if (f12109b == false) goto L5;
        return;
    L5:
        boolean r10 = true;
        f12109b = true;
        String r11 = ud.a.f12587a;
        if (f.b(r11) == true) goto L62;
    L35:
        boolean r12 = false;
        if (r11 != null) goto L38;
    L40:
        if (r11 != null) goto L42;
    L44:
        r10 = false;
    L45:
        r12 = r10;
    L46:
        if (r12 == true) goto L48;
        return;
    L48:
        Application r13 = f12108a;
        q5.a r14 = q5.a.f10161o;
        monitor-enter(q5.a.class);
    L57:
        th = move-exception;
        throw th;
    L51:
        if (q5.a.f10161o != null) goto L53;
        q5.a.f10161o = new q5.a();     // Catch: Throwable -> L57
    L53:
        q5.a r15 = q5.a.f10161o;     // Catch: Throwable -> L57
        monitor-exit(q5.a.class);
        r13.registerActivityLifecycleCallbacks(r15);
        return;
    L42:
        if (r11.equals(r8.getPackageName()) == false) goto L44;
    L38:
        if (r11.contains(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L40;
    L62:
        int r16 = Process.myPid();     // Catch: Exception -> L18
        Iterator<ActivityManager.RunningAppProcessInfo> r17 = ((ActivityManager) r8.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L18
    L10:
        if (r17.hasNext() == false) goto L20;
        ActivityManager.RunningAppProcessInfo r18 = r17.next();     // Catch: Exception -> L18
        if (r18.pid != r16) goto L10;
        if (Logger.debug() == false) goto L16;
        Logger.d("Process", "processName = " + r18.processName);     // Catch: Exception -> L18
    L16:
        r11 = r18.processName;     // Catch: Exception -> L18
        ud.a.f12587a = r11;     // Catch: Exception -> L18
    L20:
        String r19 = null;
        BufferedReader r20 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L31
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L61
    L23:
        int r22 = r20.read();     // Catch: Throwable -> L61
        if (r22 <= 0) goto L27;
        r21.append((char) r22);     // Catch: Throwable -> L61
        goto L23
    L27:
        if (Logger.debug() == false) goto L29;
        Logger.d("Process", "get processName = " + r21.toString());     // Catch: Throwable -> L61
    L29:
        r19 = r21.toString();     // Catch: Throwable -> L61
    L70:
        r20.close();     // Catch: Exception -> L60
    L34:
        r11 = r19;
        ud.a.f12587a = r11;
    L32:
        if (r20 == null) goto L34;
    L31:
        r20 = null;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }
}
