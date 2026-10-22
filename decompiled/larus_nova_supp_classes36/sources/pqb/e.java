package pqb;

import android.text.TextUtils;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.lark.log.LogLevel;
import com.suite.lark.component.logger.dynamic.DynamicLogFilterProvider;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends com.ss.android.lark.log.a {
    public static e a;

    public static final class a {
    }

    static {
    }

    public e(com.ss.android.lark.log.f r7) {
        Intrinsics.checkNotNullParameter(r7, "logConfig");
        b.a r0 = b.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r7, "logConfig");     // Catch: Throwable -> L24
        if (b.b == null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        b.b = new b();     // Catch: Throwable -> L24
        b.c = r7;     // Catch: Throwable -> L24
        if (r7.k == true) goto L12;
        monitor-exit(r0);
        return;
    L12:
        boolean r1 = r7.d;     // Catch: Throwable -> L24
        if (r1 == true) goto L18;
        int r3 = c.b;     // Catch: Throwable -> L24
        c r4 = c.b.a;     // Catch: Throwable -> L24
        r4.getClass();     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r7, "logConfig");     // Catch: Throwable -> L24
        if (r4.a == true) goto L18;
        Lazy r5 = DynamicLogFilterProvider.a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r7, "logConfig");     // Catch: Throwable -> L24
        r4.a = true;     // Catch: Throwable -> L24
    L18:
        String r6 = d.a(r7);     // Catch: Throwable -> L24
        ALogConfig.b r8 = new ALogConfig.b(r7.a);     // Catch: Throwable -> L24
        r8.d = r6;     // Catch: Throwable -> L24
        r8.b = 251658240;     // Catch: Throwable -> L24
        r8.c = 2097152;     // Catch: Throwable -> L24
        r8.e = true;     // Catch: Throwable -> L24
        r8.f = true;     // Catch: Throwable -> L24
        r8.g = true;     // Catch: Throwable -> L24
        ALogConfig r2 = r8.a();     // Catch: Throwable -> L24
        ALog.setDebug(r1);     // Catch: Throwable -> L24
        if (r7.b != 4) goto L21;
        ALog.setILogCacheCallback(pqb.a.a);     // Catch: Throwable -> L24
    L21:
        ALog.init(r2);     // Catch: Throwable -> L24
        monitor-exit(r0);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public final void d(String r2, String r3) {
        b.a r0 = b.a;
        if (b.b == null) goto L6;
        b.a(r2, r3);
        return;
    }

    public final void e(String r2, String r3) {
        b.a r0 = b.a;
        if (b.b == null) goto L6;
        b.b(r2, r3);
        return;
    }

    public final void i(String r2, String r3) {
        b.a r0 = b.a;
        if (b.b == null) goto L6;
        b.d(r2, r3);
        return;
    }

    public final void v(String r2, String r3) {
        b.a r0 = b.a;
        if (b.b == null) goto L6;
        b.f(r2, r3);
        return;
    }

    public final void w(String r2, String r3) {
        b.a r0 = b.a;
        if (b.b != null) goto L5;
        return;
    L5:
        if (b.c(r2, r3, 5) == false) goto L9;
        ALog.w(b.e(r2), r3);
        return;
    }

    public final void wtf(String r2, String r3) {
        b.a r0 = b.a;
        if (b.b == null) goto L6;
        b.b(r2, r3);
        return;
    }

    public final void a(String r3, String r4, String r5) {
        String r6 = "msg: " + r4 + ", jsonContent: " + r5;
        b.a r7 = b.a;
        if (b.b == null) goto L6;
        b.d(r3, r6);
        return;
    }

    public final void c(String r3, String r4, String r5) {
        String r6 = "msg: " + r4 + ", xmlContent: " + r5;
        b.a r7 = b.a;
        if (b.b == null) goto L6;
        b.d(r3, r6);
        return;
    }

    public final void d(String r3, String r4, Throwable r5) {
        String r6 = "msg: " + r4 + ", tr: " + r5;
        b.a r7 = b.a;
        if (b.b == null) goto L6;
        b.a(r3, r6);
        return;
    }

    public final void e(String r2, String r3, Throwable r4) {
        b.a r0 = b.a;
        if (b.b != null) goto L5;
        return;
    L5:
        if (b.c(r2, r3, 6) == false) goto L9;
        ALog.e(b.e(r2), r3, r4);
        return;
    }

    public final void i(String r3, String r4, Throwable r5) {
        String r6 = "msg: " + r4 + ", tr: " + r5;
        b.a r7 = b.a;
        if (b.b == null) goto L6;
        b.d(r3, r6);
        return;
    }

    public final void v(String r3, String r4, Throwable r5) {
        String r6 = "msg: " + r4 + ", tr: " + r5;
        b.a r7 = b.a;
        if (b.b == null) goto L6;
        b.f(r3, r6);
        return;
    }

    public final void w(String r2, String r3, Throwable r4) {
        b.a r0 = b.a;
        if (b.b != null) goto L5;
        return;
    L5:
        if (b.c(r2, r3, 5) == false) goto L9;
        ALog.w(b.e(r2), r3, r4);
        return;
    }

    public final void wtf(String r2, String r3, Throwable r4) {
        b.a r0 = b.a;
        if (b.b != null) goto L5;
        return;
    L5:
        if (b.c(r2, r3, 6) == false) goto L9;
        ALog.e(b.e(r2), r3, r4);
        return;
    }

    public final void b(int r3, String r4, String[] r5, String r6, Map<String, String> r7) {
        if (r5 != null) goto L4;
        String r8 = "";
    L5:
        String r9 = "logId: " + r4 + ", msg: " + r6 + ", extras: ";
        if (r7 == null) goto L12;
        Iterator<Map.Entry<String, String>> r10 = r7.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L12;
        Map.Entry<String, String> r11 = r10.next();
        r9 = r9 + ' ' + r11.getKey() + ": " + r11.getValue();
    L12:
        if (r3 != LogLevel.VERBOSE.getNumber()) goto L17;
        b.a r12 = b.a;
        if (b.b == null) goto L40;
        b.f(r8, r9);
        return;
    L40:
        return;
    L17:
        if (r3 != LogLevel.DEBUG.getNumber()) goto L22;
        b.a r13 = b.a;
        if (b.b == null) goto L42;
        b.a(r8, r9);
        return;
    L42:
        return;
    L22:
        if (r3 != LogLevel.INFO.getNumber()) goto L27;
        b.a r14 = b.a;
        if (b.b == null) goto L44;
        b.d(r8, r9);
        return;
    L44:
        return;
    L27:
        if (r3 != LogLevel.WARN.getNumber()) goto L34;
        b.a r15 = b.a;
        if (b.b != null) goto L31;
        return;
    L31:
        if (b.c(r8, r9, 5) == false) goto L47;
        ALog.w(b.e(r8), r9);
        return;
    L47:
        return;
    L34:
        if (r3 != LogLevel.ERROR.getNumber()) goto L49;
        b.a r16 = b.a;
        if (b.b == null) goto L50;
        b.b(r8, r9);
        return;
    L50:
        return;
    L49:
        return;
    L4:
        r8 = TextUtils.join(",", r5);
        goto L5
    }
}
