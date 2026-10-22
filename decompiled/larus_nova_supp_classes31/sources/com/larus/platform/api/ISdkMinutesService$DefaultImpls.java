package com.larus.platform.api;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ISdkMinutesService$DefaultImpls {
    public static Object a(final ISdkMinutesService r4, Continuation<? super Flow<Boolean>> r5) {
        if ((r5 instanceof ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1) == false) goto L7;
        ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1 r0 = (ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r4 = (ISdkMinutesService) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L17:
        final kotlinx.coroutines.flow.i1 r7 = (kotlinx.coroutines.flow.i1) r6;
        if (r7 != null) goto L22;
        return null;
    L22:
        return new ISdkMinutesService$DefaultImpls$getRecordingOrInterpretationInProgressFlow$$inlined$map$1(r7, r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r0.L$0 = r4;
        r0.label = 1;
        r6 = r4.b(r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new ISdkMinutesService$getRecordingOrInterpretationInProgressFlow$1(r5);
        goto L8
    }
}
