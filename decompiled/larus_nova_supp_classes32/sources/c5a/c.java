package c5a;

import android.util.Log;
import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static void e() {
        a.a.booleanValue();
    }

    public static String a(String r1, Throwable r2) {
        String r3 = Log.getStackTraceString(r2);
        if (r3.isEmpty() == false) goto L6;
        return r1;
    L6:
        return r1 + '\n' + r3;
    }

    public static void c(String r1, String r2) {
        if (a.a.booleanValue() == false) goto L6;
        d(4, r1, r2);
        return;
    }

    public static void b(String r1, String r2, Throwable r3) {
        d(6, r1, a(r2, r3));
    }

    public static void d(int r3, String r4, String r5) {
        int r0 = 2;
        if (r3 > 2) goto L6;
        r0 = 0;
    L14:
        LynxLog.internalLog(r0, r4, r5);
        return;
    L6:
        if (r3 != 3) goto L8;
        r0 = 1;
        goto L14
    L8:
        if (r3 == 4) goto L14;
        if (r3 == 5) goto L12;
        r0 = 4;
        goto L14
    L12:
        r0 = 3;
        goto L14
    }

    public static void f(String r1, String r2, Throwable r3) {
        d(5, r1, a(r2, r3));
    }
}
