package com.obric.aikernel.api.impl.security;

import com.obric.aikernel.utils.d;
import com.obric.framework.ObricSecurityPartition;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.ObricFbeImpl$initAndGetRootDir$1$1", f = "ObricFbeImpl.kt", i = {}, l = {22, 23, 24}, m = "invokeSuspend", n = {}, s = {})
final class ObricFbeImpl$initAndGetRootDir$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ObricFbeImpl this$0;

    ObricFbeImpl$initAndGetRootDir$1$1(ObricFbeImpl r10, Continuation<? super ObricFbeImpl$initAndGetRootDir$1$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ObricFbeImpl$initAndGetRootDir$1$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ObricFbeImpl$initAndGetRootDir$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L9;
        d r13 = (d) this.L$0;
        ResultKt.throwOnFailure(r10);
    L22:
        r13.c((String) r10);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L18:
        d r14 = d.f5591a;
        ObricSecurityPartition r15 = ObricSecurityPartition.f5790a;
        this.L$0 = r14;
        this.label = 3;
        Object r16 = r15.d(this);
        if (r16 != r11) goto L21;
        return r11;
    L21:
        r10 = r16;
        r13 = r14;
        goto L22
    L11:
        ResultKt.throwOnFailure(r10);
    L15:
        ObricFbeImpl r17 = this.this$0;
        this.label = 2;
        if (ObricFbeImpl.b(r17, this) != r11) goto L18;
        return r11;
    L12:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.b(180000, this) != r11) goto L15;
        return r11;
    }
}
