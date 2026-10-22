package com.obric.aikernel.model.device;

import com.obric.aikernel.res.metadata.data.Lora;
import com.obric.aikernel.runtime.AIInferRuntime;
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
@DebugMetadata(c = "com.obric.aikernel.model.device.UnNamedExceptionStrategy$requestUpdateIfNeed$1", f = "UnNamedExceptionStrategy.kt", i = {}, l = {61, 62}, m = "invokeSuspend", n = {}, s = {})
final class UnNamedExceptionStrategy$requestUpdateIfNeed$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIInferRuntime.PackageWrapper $wrapper;
    int label;
    final /* synthetic */ UnNamedExceptionStrategy this$0;

    UnNamedExceptionStrategy$requestUpdateIfNeed$1(UnNamedExceptionStrategy r10, AIInferRuntime.PackageWrapper r11, Continuation<? super UnNamedExceptionStrategy$requestUpdateIfNeed$1> r12) {
        this.this$0 = r10;
        this.$wrapper = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UnNamedExceptionStrategy$requestUpdateIfNeed$1(this.this$0, this.$wrapper, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((UnNamedExceptionStrategy$requestUpdateIfNeed$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L17:
        long r13 = UnNamedExceptionStrategy.a();
        this.label = 2;
        if (DelayKt.b(r13, this) != r11) goto L21;
        return r11;
    L10:
        ResultKt.throwOnFailure(r10);
        AIInferRuntime r14 = UnNamedExceptionStrategy.b(this.this$0);
        String r15 = this.$wrapper.g().w();
        Lora r16 = this.$wrapper.d();
        if (r16 == null) goto L13;
        String r17 = r16.w();
    L14:
        this.label = 1;
        if (r14.I0(r15, "UnNamedExceptionStrategy", r17, this) != r11) goto L17;
        return r11;
    L13:
        r17 = null;
        goto L14
    }
}
