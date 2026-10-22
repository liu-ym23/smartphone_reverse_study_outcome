package com.obric.aee.impl;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aee.impl.EngineBridge$getServiceInner$2$ret$1", f = "EngineBridge.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
final class EngineBridge$getServiceInner$2$ret$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $fd;
    final /* synthetic */ AtomicLong $lastVisitRef;
    final /* synthetic */ y6.b $pkg;
    int label;

    EngineBridge$getServiceInner$2$ret$1(y6.b r10, AtomicLong r11, int r12, Continuation<? super EngineBridge$getServiceInner$2$ret$1> r13) {
        this.$pkg = r10;
        this.$lastVisitRef = r11;
        this.$fd = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new EngineBridge$getServiceInner$2$ret$1(this.$pkg, this.$lastVisitRef, this.$fd, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((EngineBridge$getServiceInner$2$ret$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        EngineBridge r13 = EngineBridge.INSTANCE;
        y6.b r14 = this.$pkg;
        AtomicLong r15 = this.$lastVisitRef;
        int r16 = this.$fd;
        this.label = 1;
        if (EngineBridge.access$watchPackageLife(r13, r14, r15, r16, this) != r11) goto L12;
        return r11;
    }
}
