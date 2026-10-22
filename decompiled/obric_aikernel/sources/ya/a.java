package ya;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.g;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13727a;

    static {
    }

    public static String a(Context r10) {
        String r11 = f13727a;
        if (g.b(r11) == true) goto L19;
        return r11;
    L19:
        int r12 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r13.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L15
        if (r14.pid != r12) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r14.processName);     // Catch: Exception -> L15
    L13:
        String r15 = r14.processName;     // Catch: Exception -> L15
        f13727a = r15;     // Catch: Exception -> L15
        return r15;
    L17:
        String r16 = b();
        f13727a = r16;
        return r16;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String b() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L19
        if (r12 <= 0) goto L9;
        r11.append((char) r12);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r11.toString());     // Catch: Throwable -> L19
    L11:
        String r13 = r11.toString();     // Catch: Throwable -> L19
        r10.close();     // Catch: Exception -> L18
    L13:
        return r13;
    L15:
        if (r10 != null) goto L25;
    L17:
        return null;
    L25:
        r10.close();     // Catch: Exception -> L20
    L14:
        r10 = null;
        goto L15
    }

    public static String c(Context r10, String r11) {
        if (r10 != null) goto L5;
    L14:
        return null;
    L5:
        if (g.b(r11) == true) goto L14;
        ProviderInfo[] r12 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r13 = r12.length;     // Catch: Exception -> L15
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L14;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L15
        if (r11.equals(r15.name) == true) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        return r15.authority;
    }
}
