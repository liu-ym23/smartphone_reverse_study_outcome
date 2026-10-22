package com.obric.aikernel.middleware.impl.obric;

import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4573a = null;

    static {
        f4573a = new c();
    }

    private c() {
    }

    private final void b(String r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L4
        AIKLog.INSTANCE.e(ProcessService.TAG, r10);     // Catch: Throwable -> L4
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    }

    private final void c(String r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L4
        AIKLog.INSTANCE.i(ProcessService.TAG, r10);     // Catch: Throwable -> L4
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    }

    private final void d(String r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L4
        AIKLog.INSTANCE.w(ProcessService.TAG, r10);     // Catch: Throwable -> L4
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    }

    public final boolean a(a r10, String r11, int r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r13, "processName");
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L5
        Object r16 = Result.m32constructorimpl(Boolean.valueOf(r10.c(r11, r14)));     // Catch: Throwable -> L5
    L7:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L10;
        f4573a.b("registerUnfreeze failed: " + r17);
    L10:
        Boolean r18 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r16) == false) goto L13;
        r16 = r18;
    L13:
        boolean r19 = ((Boolean) r16).booleanValue();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L16
        Object r21 = Result.m32constructorimpl(Boolean.valueOf(r10.b(r11, r12, r13, r14, "keep aikernel child process alive")));     // Catch: Throwable -> L16
    L18:
        Throwable r110 = Result.m35exceptionOrNullimpl(r21);
        if (r110 == null) goto L21;
        f4573a.b("registerKeepAlive failed: " + r110);
    L21:
        Boolean r111 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r21) == false) goto L24;
        r21 = r111;
    L24:
        boolean r22 = ((Boolean) r21).booleanValue();
        if (r19 == false) goto L28;
        if (r22 == false) goto L28;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L32;
        f4573a.c("ensureKeepAlive ok. pkgName=" + r11 + " process=" + r13);
    L33:
        return r112;
    L32:
        f4573a.d("ensureKeepAlive failed, pkgName=" + r11 + " process=" + r13 + " unfreeze=" + r19 + " keepAlive=" + r22 + ", retry later.");
    L28:
        r112 = false;
    L16:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r21 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
