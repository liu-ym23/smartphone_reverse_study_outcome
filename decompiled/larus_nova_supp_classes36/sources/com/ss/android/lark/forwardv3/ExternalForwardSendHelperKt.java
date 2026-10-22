package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.image.api.Target;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ExternalForwardSendHelperKt {
    public static final Object a(long r4, Function2<? super CoroutineScope, ? super IExternalForwardExecutor.a, Unit> r6, Continuation<? super a> r7) {
        if ((r7 instanceof ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1) == false) goto L7;
        ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1 r0 = (ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1) r7;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        a r9 = (a) r8;
        if (r9 == null) goto L20;
        return r9;
    L20:
        return a.c.a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2 r10 = new ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2(r6, null);
        r0.label = 1;
        r8 = TimeoutKt.c(r4, r10, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1(r7);
        goto L8
    }
}
