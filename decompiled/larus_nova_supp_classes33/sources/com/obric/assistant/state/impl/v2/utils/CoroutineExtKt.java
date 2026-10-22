package com.obric.assistant.state.impl.v2.utils;

import android.os.SystemClock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CoroutineExtKt {
    public static final Object a(long r8, Continuation<? super Unit> r10) {
        if ((r10 instanceof CoroutineExtKt$delayAwareOfSleep$1) == false) goto L7;
        CoroutineExtKt$delayAwareOfSleep$1 r0 = (CoroutineExtKt$delayAwareOfSleep$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r9 = r0.J$1;
        long r4 = r0.J$0;
        ResultKt.throwOnFailure(r11);
        long r5 = r4;
    L20:
        if (JobKt.isActive(r0.getContext()) == false) goto L28;
        long r6 = SystemClock.elapsedRealtime() - r9;
        if (r6 >= r5) goto L28;
        long r7 = Math.min(2000, r5 - r6);
        r0.J$0 = r5;
        r0.J$1 = r9;
        r0.label = 1;
        if (DelayKt.delay(r7, r0) != r2) goto L20;
        return r2;
    L28:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (r8 <= 0) goto L17;
        r5 = r8;
        r9 = SystemClock.elapsedRealtime();
        goto L20
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new CoroutineExtKt$delayAwareOfSleep$1(r10);
        goto L8
    }
}
