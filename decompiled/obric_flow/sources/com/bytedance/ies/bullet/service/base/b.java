package com.bytedance.ies.bullet.service.base;

import android.os.Handler;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.ss.android.agilelogger.ALog;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f5957b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f5958c = false;
    public static boolean d;
    public static final Lazy e = null;

    static {
        f5957b = Executors.newSingleThreadExecutor();
        f5958c = true;
        e = LazyKt.lazy(BulletLogger$logHandler$2.f5908a);
    }

    public static /* synthetic */ void a(int r5, String r10, String r11) {
        LogLevel r12 = LogLevel.d;
        if ((r5 & 2) == 0) goto L6;
        r12 = LogLevel.f5954b;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r11 = "";
    L8:
        d(r10, r12, r11);
    }

    public static /* synthetic */ void b(int r5, String r10, String r11, String r12) {
        if ((r5 & 4) == 0) goto L5;
        r12 = "";
    L5:
        e(r10, r11, r12, LogLevel.f5954b);
    }

    public static void c(final LogLevel r5, final String r10) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r5, "level");
        if (d == true) goto L5;
    L11:
        Function0<Unit> r11 = new BulletLogger$onLog$1(r5, r10);
        if (f5958c == false) goto L15;
        ((Handler) e.getValue()).post(new com.bytedance.android.anniex.monitor.b(6, r11));
        return;
    L15:
        h.f.b(new com.bytedance.ies.bullet.lynx.g(1, r11), f5957b);
        return;
    L5:
        if (f5956a == true) goto L11;
        if (r5 == LogLevel.d) goto L11;
        if (r5 == LogLevel.f5955c) goto L11;
    }

    public static void d(String r5, LogLevel r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r10, "logLevel");
        Intrinsics.checkNotNullParameter(r11, "subModule");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        if (r11.length() <= 0) goto L8;
        r5 = "[" + r11 + "] " + r5;     // Catch: Throwable -> L6
    L8:
        c(r10, r5);     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static void e(String r5, String r10, String r11, LogLevel r12) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "subModule");
        Intrinsics.checkNotNullParameter(r12, "logLevel");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L6
        if (r11.length() <= 0) goto L8;
        r10 = "[" + r11 + "] " + r10;     // Catch: Throwable -> L6
    L8:
        if (r5 != null) goto L10;
    L13:
        String r14 = "[bulletSession-unknown]-[Core] " + r10;     // Catch: Throwable -> L6
    L14:
        c(r12, r14);     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L10:
        if (r5.length() == 0) goto L13;
        r14 = "[bulletSession-" + r5 + "]-[Core] " + r10;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static void f(String r10, String r11, String r12, Throwable r13, LogLevel r14) {
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r12, "subModule");
        Intrinsics.checkNotNullParameter(r13, "tr");
        Intrinsics.checkNotNullParameter(r14, "logLevel");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        if (r12.length() <= 0) goto L8;
        r11 = "[" + r12 + "] " + r11;     // Catch: Throwable -> L6
    L8:
        if (r10 != null) goto L10;
    L13:
        String r15 = "[bulletSession-unknown]-[Core] " + r11;     // Catch: Throwable -> L6
    L16:
        if (a.f5931a[r14.ordinal()] != 1) goto L18;
        Lazy r16 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter("BulletLog", "tag");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r15, "msg");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r13, "tr");     // Catch: Throwable -> L6
        ALog.e("BulletLog", r15, r13);     // Catch: Throwable -> L6
    L19:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L18:
        Lazy r17 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter("BulletLog", "tag");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r15, "msg");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r13, "tr");     // Catch: Throwable -> L6
        ALog.w("BulletLog", r15, r13);     // Catch: Throwable -> L6
        goto L19
    L10:
        if (r10.length() == 0) goto L13;
        r15 = "[bulletSession-" + r10 + "]-[Core] " + r11;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static void g(String r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r11, "e");
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r10, "subModule");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L6
        if (r10.length() <= 0) goto L8;
        r5 = "[" + r10 + "] " + r5;     // Catch: Throwable -> L6
    L8:
        i(r11, r5);     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static void h(String r5, Map r10, String r11, String r12, int r13) {
        LogLevel r14 = LogLevel.f5954b;
        JSONObject r15 = null;
        if ((r13 & 2) == 0) goto L5;
        r10 = null;
    L5:
        String r16 = "";
        if ((r13 & 8) == 0) goto L8;
        r11 = "";
    L8:
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r14, "logLevel");
        Intrinsics.checkNotNullParameter(r11, "subModule");
        Intrinsics.checkNotNullParameter("", "rlSessionId");
        Intrinsics.checkNotNullParameter("", "callId");
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L26
        if (r10 == null) goto L13;
        r15 = new JSONObject(r10);     // Catch: Throwable -> L26
    L13:
        if (r15 == null) goto L16;
        r16 = "xContent:" + r15;     // Catch: Throwable -> L26
    L16:
        String r18 = "xMsg:" + r5 + '|' + r16;     // Catch: Throwable -> L26
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L26
        if (r12 != null) goto L19;
    L22:
        r19.append("[bulletSession-unknown]");     // Catch: Throwable -> L26
    L23:
        String r20 = r19.toString();     // Catch: Throwable -> L26
        if (r11.length() <= 0) goto L28;
        String r21 = r20 + '[' + r11 + "] " + r18;     // Catch: Throwable -> L26
    L29:
        c(r14, r21);     // Catch: Throwable -> L26
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
        return;
    L28:
        r21 = r20 + r18;     // Catch: Throwable -> L26
        goto L29
    L19:
        if (r12.length() == 0) goto L22;
        r19.append("[bulletSession-" + r12 + ']');     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static void i(final Throwable r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "e");
        Intrinsics.checkNotNullParameter(r10, "extraMsg");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        Function0<Unit> r12 = new BulletLogger$onReject$1$1(r5, r10);     // Catch: Throwable -> L6
        if (f5958c == false) goto L8;
        ((Handler) e.getValue()).post(new com.bytedance.android.anniex.monitor.b(6, r12));     // Catch: Throwable -> L6
    L9:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L8:
        h.f.b(new com.bytedance.ies.bullet.lynx.g(1, r12), f5957b);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }
}
