package sda;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.larus.im.FlowRuntime;
import com.larus.jato.api.IJato;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final b a = null;
    public static final Handler b = null;
    public static a c;

    public b() {
    }

    static {
        a = new b();
        b = new Handler(Looper.getMainLooper());
    }

    public static void a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "source");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        b(r4, r5);     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L13;
        FLogger.a.w("ObricPerformanceBoostCoordinator", "boost failed, source=" + r4 + ", tid=" + r5, r2);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(String r7, int r8) {
        long r3 = SystemClock.elapsedRealtime();
        Application r5 = FlowRuntime.a().getApplication();     // Catch: Throwable -> L6
        c(r5, r7);     // Catch: Throwable -> L6
        d(r5, r7);     // Catch: Throwable -> L6
        e(r7, r8);     // Catch: Throwable -> L6
        FLogger.a.i("ObricPerformanceBoostCoordinator", "boostInternal finished, source=" + r7 + ", costMs=" + (SystemClock.elapsedRealtime() - r3));
        return;
    L6:
        th = move-exception;
        FLogger.a.i("ObricPerformanceBoostCoordinator", "boostInternal finished, source=" + r7 + ", costMs=" + (SystemClock.elapsedRealtime() - r3));
        throw th;
    }

    public static void c(Application r8, String r9) {
        m.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "source");
        Object r0 = m.m;
        if (r0 != null) goto L36;
        Class r1 = m.b();
        if (r1 != null) goto L44;
    L30:
        Object r3 = null;
    L31:
        if (r3 == null) goto L33;
        m.m = r3;
        r0 = r3;
    L34:
        if (r0 != null) goto L36;
        FLogger.a.w("VendorLaunchBoostHelper", "requestLaunchBoost skipped, source=" + r9 + ", boostFrameworkObj is null");
        return;
    L33:
        r0 = null;
        goto L34
    L44:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Constructor r5 = m.d(r1, new Class[]{Context.class});     // Catch: Throwable -> L14
        if (r5 == null) goto L11;
        Object r6 = r5.newInstance(new Object[]{r8});     // Catch: Throwable -> L14
    L12:
        r3 = Result.constructor-impl(r6);     // Catch: Throwable -> L14
    L17:
        if (Result.exceptionOrNull-impl(r3) == null) goto L31;
        m.a.getClass();     // Catch: Throwable -> L26
        Constructor r2 = m.d(r1, new Class[0]);     // Catch: Throwable -> L26
        if (r2 == null) goto L23;
        Object r7 = r2.newInstance(new Object[0]);     // Catch: Throwable -> L26
    L24:
        Object r10 = Result.constructor-impl(r7);     // Catch: Throwable -> L26
    L28:
        r3 = r10;
        if (Result.isFailure-impl(r3) == false) goto L31;
    L23:
        r7 = null;
    L26:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L11:
        r6 = null;
    L14:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        Integer r13 = (Integer) m.k.getValue();
        m.g(r0, r8, r9, "first_launch", (Integer) m.g.getValue(), r13);
        Integer r14 = (Integer) m.h.getValue();
        Integer r15 = (Integer) m.l.getValue();
        if (r15 != null) goto L39;
        Integer r16 = r13;
    L40:
        m.g(r0, r8, r9, "subseq_launch", r14, r16);
        m.g(r0, r8, r9, "anim_boost", (Integer) m.i.getValue(), r13);
        m.g(r0, r8, r9, "activity_boost", (Integer) m.j.getValue(), r13);
        return;
    L39:
        r16 = r15;
        goto L40
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Runnable, sda.a] */
    public static void d(Application r10, String r11) {
        final IJato r6 = (IJato) ServiceManager.get().getService(IJato.class);
        if (r6 != null) goto L51;
        FLogger.a.w("ObricPerformanceBoostCoordinator", "boostWithJato skipped, source=" + r11 + ", IJato service is null");
        return;
    L51:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L8
        r6.k(false, r10);     // Catch: Throwable -> L8
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r12 = Result.exceptionOrNull-impl(r9);
        if (r12 == null) goto L49;
        FLogger.a.w("ObricPerformanceBoostCoordinator", "initJato failed, source=".concat(r11), r12);
        return;
    L49:
        r6.bindBigCore();     // Catch: Throwable -> L16
        FLogger.a.i("ObricPerformanceBoostCoordinator", "bindBigCore success, source=" + r11 + ", durationMs=500");     // Catch: Throwable -> L16
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r7 = Result.exceptionOrNull-impl(r5);
        if (r7 == null) goto L57;
        FLogger.a.w("ObricPerformanceBoostCoordinator", "bindBigCore failed, source=".concat(r11), r7);
    L57:
        r6.t(-20);     // Catch: Throwable -> L24
        FLogger.a.i("ObricPerformanceBoostCoordinator", "setThreadPriority success, source=" + r11 + ", priority=-20, durationMs=500");     // Catch: Throwable -> L24
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r13 = Result.exceptionOrNull-impl(r4);
        if (r13 == null) goto L55;
        FLogger.a.w("ObricPerformanceBoostCoordinator", "setThreadPriority failed, source=".concat(r11), r13);
    L55:
        r6.u(r10);     // Catch: Throwable -> L31
        FLogger.a.i("ObricPerformanceBoostCoordinator", "boostRenderThread success, source=" + r11 + ", priority=-20, durationMs=500");     // Catch: Throwable -> L31
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L53;
        FLogger.a.w("ObricPerformanceBoostCoordinator", "boostRenderThread failed, source=".concat(r11), r15);
    L53:
        r6.b(500);     // Catch: Throwable -> L39
        FLogger.a.i("ObricPerformanceBoostCoordinator", "blockGc success, source=" + r11 + ", durationMs=500");     // Catch: Throwable -> L39
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L44;
        FLogger.a.w("ObricPerformanceBoostCoordinator", "blockGc failed, source=".concat(r11), r17);
    L44:
        a r18 = c;
        if (r18 == null) goto L47;
        b.removeCallbacks(r18);
    L47:
        ?? r19 = new a(r6);
        c = r19;
        b.postDelayed(r19, 500);
        return;
    L39:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static void e(String r3, int r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        com.obric.assistant.common.utils.g r1 = com.obric.assistant.common.utils.g.a;     // Catch: Throwable -> L4
        int r2 = Process.myPid();     // Catch: Throwable -> L4
        r1.getClass();     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Boolean.valueOf(com.obric.assistant.common.utils.g.b(r2, r4, 500, false)));     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        FLogger.a.w("ObricPerformanceBoostCoordinator", "startPerformanceSchedMode failed, source=".concat(r3), r6);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
