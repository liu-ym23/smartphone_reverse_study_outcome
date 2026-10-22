package com.obric.aikernel.runtime;

import android.os.SystemClock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1", f = "AIInferRuntime.kt", i = {}, l = {1452}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1 extends SuspendLambda implements Function2<l0, Continuation<? super Result<? extends y6.b>>, Object> {
    final /* synthetic */ Function1<Continuation<? super y6.b>, Object> $getter;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime.PackageWrapper this$0;

    /* JADX WARN: Multi-variable type inference failed */
    AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1(Function1<? super Continuation<? super y6.b>, ? extends Object> r10, AIInferRuntime.PackageWrapper r11, Continuation<? super AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1> r12) {
        this.$getter = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1 r12 = new AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1(this.$getter, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Result<? extends y6.b>> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Result<y6.b>> r11) {
        return ((AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L9;
        if (r12 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Object r13 = Result.m32constructorimpl((y6.b) r10);     // Catch: Throwable -> L15
    L17:
        AIInferRuntime.PackageWrapper r14 = this.this$0;
        Throwable r15 = Result.m35exceptionOrNullimpl(r13);
        if (r15 == null) goto L20;
        AIInferRuntime.PackageWrapper.b(r14).c(r14);
        com.obric.aikernel.runtime.utils.d.f5417a.l("AIInferRuntime", "getVmPackageInfo init " + r14.g() + '|' + r14.d() + " failed: " + r15);
    L20:
        Result r16 = Result.m31boximpl(r13);
        AIInferRuntime.PackageWrapper r17 = this.this$0;
        Object r18 = r16.m41unboximpl();
        Long r19 = AIInferRuntime.PackageWrapper.a(r17);
        if (r19 == null) goto L23;
        r19.longValue();
        AIInferRuntime.PackageWrapper.c(r17, Boxing.boxLong(SystemClock.elapsedRealtime() + AIInferRuntime.PackageWrapper.a(r17).longValue()));
    L23:
        r17.j(Result.m31boximpl(r18));
        if (Intrinsics.areEqual(r17.g().w(), "vlm_local") == false) goto L33;
        Result<y6.b> r20 = r17.e();
        if (r20 == null) goto L33;
        Object r21 = r20.m41unboximpl();
        if (Result.m38isFailureimpl(r21) == false) goto L31;
        r21 = null;
    L31:
        if (((y6.b) r21) == null) goto L33;
        com.obric.aikernel.res.metadata.d.f5055a.c(r17.g());
    L33:
        return r16;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        l0 r22 = (l0) this.L$0;
        Function1<Continuation<? super y6.b>, Object> r23 = this.$getter;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r10 = r23.invoke(this);     // Catch: Throwable -> L15
        if (r10 != r11) goto L13;
        return r11;
    L15:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
