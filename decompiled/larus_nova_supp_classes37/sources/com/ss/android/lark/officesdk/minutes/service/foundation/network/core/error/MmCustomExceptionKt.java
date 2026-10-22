package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmCustomExceptionKt {
    public static final MmCustomException a = null;
    public static final MmCustomException b = null;

    static {
        a = new MmCustomException(10001, "network error");
        b = new MmCustomException(10002, "absent user network request skipped");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a1 -> B:17:0x0056). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b6 -> B:17:0x0056). Please report as a decompilation issue!!! */
    public static final <T> Object a(int r11, Function2<? super Integer, ? super Continuation<? super Result<? extends T>>, ? extends Object> r12, Continuation<? super Result<? extends T>> r13) {
        if ((r13 instanceof MmCustomExceptionKt$withRetry$1) == false) goto L7;
        MmCustomExceptionKt$withRetry$1 r0 = (MmCustomExceptionKt$withRetry$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r15 = r0.I$1;
        int r16 = r0.I$0;
        Throwable r4 = (Throwable) r0.L$1;
        Function2<? super Integer, ? super Continuation<? super Result<? extends T>>, ? extends Object> r6 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        if (r15 >= r16) goto L37;
        Integer r17 = Boxing.boxInt(r15);
        r0.L$0 = r6;
        r0.L$1 = null;
        r0.I$0 = r16;
        r0.I$1 = r15;
        r0.label = 1;
        r14 = r6.invoke(r17, r0);
        if (r14 != r2) goto L21;
        return r2;
    L21:
        Object r18 = ((Result) r14).unbox-impl();
        if (Result.isSuccess-impl(r18) == false) goto L24;
        return r18;
    L24:
        r4 = Result.exceptionOrNull-impl(r18);
        MmCustomException r19 = b;
        if (Intrinsics.areEqual(r4, r19) == false) goto L29;
        return Result.constructor-impl(ResultKt.createFailure(r19));
    L29:
        if (com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c.a() == true) goto L31;
        r15 = r15 + 1;
        if (r15 >= r16) goto L17;
        r0.L$0 = r6;
        r0.L$1 = r4;
        r0.I$0 = r16;
        r0.I$1 = r15;
        r0.label = 2;
        if (DelayKt.delay(((long) r15) * 2000, r0) != r2) goto L17;
        return r2;
    L31:
        return Result.constructor-impl(ResultKt.createFailure(a));
    L37:
        Result.Companion r110 = Result.Companion;
        if (r4 != null) goto L41;
        r4 = new Throwable("Unknown error after " + r16 + " attempts");
    L41:
        return Result.constructor-impl(ResultKt.createFailure(r4));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r15 = r0.I$1;
        r16 = r0.I$0;
        Function2<? super Integer, ? super Continuation<? super Result<? extends T>>, ? extends Object> r5 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r14);
        r6 = r5;
        goto L21
    L16:
        ResultKt.throwOnFailure(r14);
        r6 = r12;
        r4 = null;
        r16 = r11;
        r15 = 0;
    L7:
        r0 = new MmCustomExceptionKt$withRetry$1(r13);
        goto L8
    }
}
