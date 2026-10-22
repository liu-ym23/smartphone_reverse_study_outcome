package com.obric.aikernel.runtime;

import android.os.SystemClock;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$preInitApp$3$1$1$1", f = "AIInferRuntime.kt", i = {}, l = {864}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$preInitApp$3$1$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Boolean>, Object> {
    final /* synthetic */ y6.b $it;
    final /* synthetic */ AIInferRuntime.PackageWrapper $wrapper;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$preInitApp$3$1$1$1(y6.b r10, AIInferRuntime r11, AIInferRuntime.PackageWrapper r12, Continuation<? super AIInferRuntime$preInitApp$3$1$1$1> r13) {
        this.$it = r10;
        this.this$0 = r11;
        this.$wrapper = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$preInitApp$3$1$1$1(this.$it, this.this$0, this.$wrapper, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Boolean> r11) {
        return ((AIInferRuntime$preInitApp$3$1$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L17
    L15:
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "preInitApp: end");     // Catch: Throwable -> L17
        Object r15 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r12 = Result.m35exceptionOrNullimpl(r15);
        if (r12 == null) goto L22;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "preInitApp failed: " + ExceptionsKt.stackTraceToString(r12));
    L22:
        Boolean r16 = Boxing.boxBoolean(Result.m39isSuccessimpl(r15));
        AIInferRuntime r13 = this.this$0;
        r16.booleanValue();
        AIInferRuntime.y(r13, SystemClock.elapsedRealtime());
        return r16;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        y6.b r17 = this.$it;
        AIInferRuntime r18 = this.this$0;
        AIInferRuntime.PackageWrapper r19 = this.$wrapper;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L17
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "preInitApp: start " + r17);     // Catch: Throwable -> L17
        VmEngine r21 = AIInferRuntime.t(r18);     // Catch: Throwable -> L17
        if (r21 == null) goto L15;
        RequestParams r22 = new RequestParams(null, null, 3, null);     // Catch: Throwable -> L17
        this.label = 1;     // Catch: Throwable -> L17
        if (VmEngine.n(r21, r17, r22, null, r19, null, this, 20, null) != r10) goto L15;
        return r10;
    L17:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
