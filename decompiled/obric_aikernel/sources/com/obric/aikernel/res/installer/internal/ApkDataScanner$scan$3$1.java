package com.obric.aikernel.res.installer.internal;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.installer.internal.ApkDataScanner$scan$3$1", f = "ApkDataScanner.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
final class ApkDataScanner$scan$3$1 extends SuspendLambda implements Function2<l0, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ List<r0<Unit>> $it;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ApkDataScanner$scan$3$1(List<? extends r0<Unit>> r10, Continuation<? super ApkDataScanner$scan$3$1> r11) {
        this.$it = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ApkDataScanner$scan$3$1(this.$it, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super List<? extends Unit>> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super List<Unit>> r11) {
        return ((ApkDataScanner$scan$3$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        List<r0<Unit>> r13 = this.$it;
        this.label = 1;
        r10 = AwaitKt.a(r13, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
