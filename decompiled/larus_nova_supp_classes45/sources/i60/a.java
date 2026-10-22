package i60;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static long a = -1;
    public static j60.a b;

    public static double b() {
        if (b != null) goto L5;
        b = new j60.a();
    L5:
        b.a();
        Logger.d("CommonMonitorUtil", "cpu Rate: " + b.b + ", cpu speed" + b.f);
        return b.b;
    }

    public static boolean c() {
        PolarisFileWrapper r0 = new PolarisFileWrapper("/proc/stat");
        if (r0.exists() == true) goto L5;
        return false;
    L5:
        if (r0.canRead() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static double d() {
        Process r1 = null;
        double r2 = 0.0d;
        r1 = a(Runtime.getRuntime());     // Catch: Throwable -> L37
        BufferedReader r4 = new BufferedReader(new InputStreamReader(r1.getInputStream()));     // Catch: Throwable -> L37
        int r6 = -1;
    L4:
        String r7 = r4.readLine();     // Catch: Throwable -> L37
        if (r7 == null) goto L40;
        String r8 = r7.trim();     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r8) == true) goto L4;
        if (r8.contains("CPU") == false) goto L19;
        String[] r9 = r8.split("\\s+");     // Catch: Throwable -> L37
        int r12 = 0;
    L14:
        if (r12 >= r9.length) goto L19;
        if (r9[r12].contains("CPU") == true) goto L20;
        r12 = r12 + 1;     // Catch: Throwable -> L37
    L20:
        if (r12 != (-1)) goto L21;
        if (r8.startsWith(String.valueOf(Process.myPid())) == false) goto L4;
        if (r6 == (-1)) goto L4;
        String[] r11 = r8.split("\\s+");     // Catch: Throwable -> L37
        if (r11.length <= r6) goto L4;
        String r13 = r11[r6];     // Catch: Throwable -> L37
        if (r13.endsWith("%") == false) goto L51;
        r13 = r13.substring(0, r13.lastIndexOf("%"));     // Catch: Throwable -> L37
    L51:
        if (Build.VERSION.SDK_INT >= 26) goto L34;
        r2 = Double.parseDouble(r13);     // Catch: NumberFormatException -> L46 Throwable -> L37
        goto L4
    L34:
        r2 = Double.parseDouble(r13) / ((double) Runtime.getRuntime().availableProcessors());     // Catch: NumberFormatException -> L46 Throwable -> L37
        goto L4
    L21:
        r6 = r12;
    L19:
        r12 = -1;
    L40:
        r1.destroy();
    L41:
        return r2;
    L37:
        th = move-exception;
        Logger.e("CommonMonitorUtil", "", th);     // Catch: Throwable -> L42
        if (r1 == null) goto L41;
    L42:
        th = move-exception;
        if (r1 == null) goto L45;
        r1.destroy();
    L45:
        throw th;
    }

    public static Process a(Runtime r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {"top -n 1"};
        f06.b r11 = new f06.b();
        f06.d r12 = r8.b(102900, "java/lang/Runtime", "exec", r13, r9, "java.lang.Process", r11);
        if (r12.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r13, r9, null, r11, false);
        return (Process) r12.b;
    L6:
        Process r14 = r13.exec("top -n 1");
        r8.a(102900, "java/lang/Runtime", "exec", r13, r9, r14, r11, true);
        return r14;
    }
}
