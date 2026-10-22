package com.obric.aikernel.runtime;

import com.obric.aee.ExecutionEngine;
import com.obric.aikernel.res.metadata.data.AIPackage;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$transferPackage$1$1", f = "AIInferRuntime.kt", i = {0}, l = {1098, 1103}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u242"}, s = {"L$1"})
final class AIInferRuntime$transferPackage$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIInferRuntime.PackageWrapper $oldPkg;
    final /* synthetic */ AIPackage $pkg;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    AIInferRuntime$transferPackage$1$1(AIInferRuntime.PackageWrapper r10, AIPackage r11, Continuation<? super AIInferRuntime$transferPackage$1$1> r12) {
        this.$oldPkg = r10;
        this.$pkg = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AIInferRuntime$transferPackage$1$1 r12 = new AIInferRuntime$transferPackage$1$1(this.$oldPkg, this.$pkg, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$transferPackage$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L13;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L35
    L33:
        Object r12 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L41;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "ExecutionEngine stopService error: " + ExceptionsKt.stackTraceToString(r13));
    L41:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        l0 r14 = (l0) this.L$1;
        AIPackage r15 = (AIPackage) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L35
    L27:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L35
        AIPackage r17 = r15;
    L29:
        if (r16 != null) goto L33;
        String r19 = r17.E();     // Catch: Throwable -> L35
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "transferPackage: stopService fake pkgInfo " + r17 + ' ' + r19);     // Catch: Throwable -> L35
        ExecutionEngine r20 = ExecutionEngine.f4305a;     // Catch: Throwable -> L35
        y6.b r21 = new y6.b(r17.w(), r19, "", "", CollectionsKt.emptyList(), CollectionsKt.emptyList(), "");     // Catch: Throwable -> L35
        this.L$0 = null;     // Catch: Throwable -> L35
        this.L$1 = null;     // Catch: Throwable -> L35
        this.label = 2;     // Catch: Throwable -> L35
        if (r20.i(r21, this) != r10) goto L33;
        return r10;
    L13:
        ResultKt.throwOnFailure(r18);
        l0 r22 = (l0) this.L$0;
        AIInferRuntime.PackageWrapper r23 = this.$oldPkg;
        r17 = this.$pkg;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L35
        if (r23 == null) goto L28;
        Result<y6.b> r25 = r23.e();     // Catch: Throwable -> L35
        if (r25 == null) goto L28;
        Object r26 = r25.m41unboximpl();     // Catch: Throwable -> L35
        if (Result.m38isFailureimpl(r26) == false) goto L21;
        r26 = null;
    L21:
        y6.b r27 = (y6.b) r26;     // Catch: Throwable -> L35
        if (r27 == null) goto L28;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "transferPackage: stopService " + r27);     // Catch: Throwable -> L35
        ExecutionEngine r28 = ExecutionEngine.f4305a;     // Catch: Throwable -> L35
        this.L$0 = r17;     // Catch: Throwable -> L35
        this.L$1 = r22;     // Catch: Throwable -> L35
        this.label = 1;     // Catch: Throwable -> L35
        if (r28.i(r27, this) != r10) goto L26;
        return r10;
    L26:
        r15 = r17;
    L28:
        r16 = null;
    L35:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L37
    }
}
