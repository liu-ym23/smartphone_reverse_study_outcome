package pqb;

import com.ss.android.agilelogger.ALog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final a a = null;
    public static volatile b b;
    public static volatile com.ss.android.lark.log.f c;
    public static volatile List<String> d;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static String a(String r2, String r3, Integer r4) {
            if (r3 == null) goto L15;
            StringBuilder r0 = new StringBuilder();
            r0.append(r3);
            r0.append('#');
            r0.append(r2);
            if (r4 != null) goto L7;
        L8:
            String r5 = ":" + r4;
        L10:
            r0.append(r5);
            String r6 = r0.toString();
            if (r6 != null) goto L14;
            return r2;
        L14:
            return r6;
        L7:
            if (r4.intValue() != 0) goto L8;
            r5 = "";
            goto L10
        L15:
            return r2;
        }
    }

    public b() {
    }

    static {
        a = new a();
        d = new ArrayList();
    }

    public static String e(String r5) {
        com.ss.android.lark.log.f r0 = c;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.h != true) goto L7;
    L8:
        if (r1 == true) goto L10;
        return r5;
    L10:
        ThreadLocal r2 = knc.c.a;
        knc.c.a r3 = (knc.c.a) r2.get();
        if (r3 == null) goto L13;
        String r4 = r3.b;
    L14:
        knc.c.a r6 = (knc.c.a) r2.get();
        if (r6 == null) goto L17;
        Integer r7 = Integer.valueOf(r6.c);
    L18:
        knc.c.a r8 = (knc.c.a) r2.get();
        if (r8 != null) goto L21;
        r8 = new knc.c.a();
    L21:
        r8.a = null;
        r8.b = null;
        r8.c = -1;
        r2.set(r8);
        return a.a(r5, r4, r7);
    L17:
        r7 = null;
        goto L18
    L13:
        r4 = null;
    L7:
        r1 = false;
        goto L8
    }

    public static void a(String r1, String r2) {
        if (c(r1, r2, 3) == false) goto L6;
        ALog.d(e(r1), r2);
        return;
    }

    public static void b(String r1, String r2) {
        if (c(r1, r2, 6) == false) goto L6;
        ALog.e(e(r1), r2);
        return;
    }

    public static void d(String r1, String r2) {
        if (c(r1, r2, 4) == false) goto L6;
        ALog.i(e(r1), r2);
        return;
    }

    public static void f(String r1, String r2) {
        if (c(r1, r2, 2) == false) goto L6;
        ALog.v(e(r1), r2);
        return;
    }

    public static boolean c(String r0, String r1, Integer r2) {
        if (r0 == null) goto L14;
        if (r1 == null) goto L14;
        if (r2 == null) goto L8;
        if (r2.intValue() < 2) goto L14;
    L8:
        if (((ArrayList) d).size() != 0) goto L10;
    L13:
        return true;
    L10:
        if (((ArrayList) d).contains(r0) == false) goto L13;
        if (((ArrayList) d).contains(r0) == true) goto L13;
    L14:
        return false;
    }
}
