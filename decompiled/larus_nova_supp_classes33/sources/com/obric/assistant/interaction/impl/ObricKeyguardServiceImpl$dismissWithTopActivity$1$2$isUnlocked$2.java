package com.obric.assistant.interaction.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2", f = "ObricKeyguardServiceImpl.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
public final class ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;

    public ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2(Continuation<? super ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2 r0 = new ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2(r3);
        r0.J$0 = ((Number) r2).longValue();
        return r0;
    }

    public final Object invoke(long r1, Continuation<? super Unit> r3) {
        return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (Continuation) r4);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r3 = this.J$0;
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L12;
        return r0;
    }
}
