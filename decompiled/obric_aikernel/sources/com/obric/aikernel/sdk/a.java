package com.obric.aikernel.sdk;

import com.obric.aikernel.core.log.AIKLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final <T> void a(Continuation<? super T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        r10.resumeWith(Result.m32constructorimpl(r11));     // Catch: Throwable -> L5
        Object r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r14 = Result.m35exceptionOrNullimpl(r13);
        if (r14 == null) goto L13;
        AIKLog.INSTANCE.w("Continuation", "resume failed, " + r14);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
