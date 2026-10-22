package com.obric.aikernel.runtime;

import android.os.Bundle;
import com.obric.aee.ExecutionEngine;
import com.obric.aikernel.core.data.IdlKeys;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$runAsFlow$2$job$1", f = "VmEngine.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
final class VmEngine$runAsFlow$2$job$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ n<Bundle> $cont;
    final /* synthetic */ Bundle $contextExtra;
    final /* synthetic */ String $event;
    final /* synthetic */ y6.b $pkg;
    final /* synthetic */ Function2<Bundle, Boolean, Unit> $vmCallback;
    final /* synthetic */ Bundle $vmContext;
    int label;
    final /* synthetic */ VmEngine this$0;

    /* JADX WARN: Multi-variable type inference failed */
    VmEngine$runAsFlow$2$job$1(y6.b r10, Bundle r11, Function2<? super Bundle, ? super Boolean, Unit> r12, String r13, Bundle r14, n<? super Bundle> r15, VmEngine r16, Bundle r17, Continuation<? super VmEngine$runAsFlow$2$job$1> r18) {
        this.$pkg = r10;
        this.$args = r11;
        this.$vmCallback = r12;
        this.$event = r13;
        this.$vmContext = r14;
        this.$cont = r15;
        this.this$0 = r16;
        this.$contextExtra = r17;
        super(2, r18);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new VmEngine$runAsFlow$2$job$1(this.$pkg, this.$args, this.$vmCallback, this.$event, this.$vmContext, this.$cont, this.this$0, this.$contextExtra, r12);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((VmEngine$runAsFlow$2$job$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 != 1) goto L10;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
        VmEngine$runAsFlow$2$job$1 this = this;
    L18:
    L17:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);
        ExecutionEngine r13 = ExecutionEngine.f4305a;     // Catch: Throwable -> L7
        y6.b r14 = this.$pkg;     // Catch: Throwable -> L7
        Bundle r15 = this.$args;     // Catch: Throwable -> L7
        Function2<Bundle, Boolean, Unit> r16 = this.$vmCallback;     // Catch: Throwable -> L7
        String r17 = this.$event;     // Catch: Throwable -> L7
        Bundle r18 = this.$vmContext;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        Object r19 = r13.h(r14, r15, r16, r17, r18, this);     // Catch: Throwable -> L7
        this = r19;
        if (r19 != r11) goto L18;
        return r11;
    L7:
        th = move-exception;
        n<Bundle> r20 = this.$cont;
        VmEngine r21 = this.this$0;
        Bundle r22 = this.$contextExtra;
        y6.b r23 = this.$pkg;
        String r24 = this.$vmContext.getString(IdlKeys.Args_PackageName, "");
        Intrinsics.checkNotNullExpressionValue(r24, "vmContext.getString(IdlKeys.Args_PackageName, \"\")");
        com.obric.aikernel.sdk.a.a(r20, VmEngine.d(r21, th, r22, "runPackageStreaming", r23, r24));
        goto L17
    }
}
