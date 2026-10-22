package com.obric.aikernel.utils;

import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final boolean a(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(Boolean.valueOf(r10.canRead()));     // Catch: Throwable -> L5
    L7:
        Boolean r13 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r12) == false) goto L11;
        r12 = r13;
    L11:
        return ((Boolean) r12).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final boolean b(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(Boolean.valueOf(r10.exists()));     // Catch: Throwable -> L5
    L7:
        Boolean r13 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r12) == false) goto L11;
        r12 = r13;
    L11:
        return ((Boolean) r12).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final boolean c(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(Boolean.valueOf(r10.mkdirs()));     // Catch: Throwable -> L5
    L7:
        Boolean r13 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r12) == false) goto L11;
        r12 = r13;
    L11:
        return ((Boolean) r12).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
