package com.obric.aikernel.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$transferPackage$1$1", f = "AIInferRuntime.kt", i = {0}, l = {1124, 1129}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u242"}, s = {"L$1"})
final class AIInferRuntime$transferPackage$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIInferRuntime.g $oldPkg;
    final /* synthetic */ com.obric.aikernel.res.metadata.data.b $pkg;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    AIInferRuntime$transferPackage$1$1(AIInferRuntime.g r3, com.obric.aikernel.res.metadata.data.b r4, Continuation<? super AIInferRuntime$transferPackage$1$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$oldPkg = r3;
        this.$pkg = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        AIInferRuntime$transferPackage$1$1 r0 = new AIInferRuntime$transferPackage$1$1(this.$oldPkg, this.$pkg, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AIInferRuntime$transferPackage$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$transferPackage$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L35
    L33:
        Object r0 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r0);
        if (r3 == null) goto L41;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "ExecutionEngine stopService error: " + ExceptionsKt.stackTraceToString(r3));
    L41:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        al r4 = (al) ZeusTransformUtils.preCheckCast(this.L$1, al.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.data.b r5 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L35
    L27:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L35
        com.obric.aikernel.res.metadata.data.b r9 = r5;
    L29:
        if (r6 != null) goto L33;
        String r12 = r9.M();     // Catch: Throwable -> L35
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "transferPackage: stopService fake pkgInfo " + r9 + ' ' + r12);     // Catch: Throwable -> L35
        com.obric.aee.b r7 = com.obric.aee.b.f5869a;     // Catch: Throwable -> L35
        com.obric.aee.res.b r8 = new com.obric.aee.res.b(r9.s(), r12, "", "", CollectionsKt.emptyList(), CollectionsKt.emptyList(), "");     // Catch: Throwable -> L35
        this.L$0 = null;     // Catch: Throwable -> L35
        this.L$1 = null;     // Catch: Throwable -> L35
        this.label = 2;     // Catch: Throwable -> L35
        if (r7.stopService(r8, this) != r1) goto L33;
        return r1;
    L13:
        ResultKt.throwOnFailure(r19);
        al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        AIInferRuntime.g r11 = this.$oldPkg;
        r9 = this.$pkg;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L35
        if (r11 == null) goto L28;
        Result<com.obric.aee.res.b> r14 = r11.d();     // Catch: Throwable -> L35
        if (r14 == null) goto L28;
        Object r15 = r14.m1430unboximpl();     // Catch: Throwable -> L35
        if (Result.m1427isFailureimpl(r15) == false) goto L21;
        r15 = null;
    L21:
        com.obric.aee.res.b r16 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r15, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (r16 == null) goto L28;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "transferPackage: stopService " + r16);     // Catch: Throwable -> L35
        com.obric.aee.b r17 = com.obric.aee.b.f5869a;     // Catch: Throwable -> L35
        this.L$0 = r9;     // Catch: Throwable -> L35
        this.L$1 = r10;     // Catch: Throwable -> L35
        this.label = 1;     // Catch: Throwable -> L35
        if (r17.stopService(r16, this) != r1) goto L26;
        return r1;
    L26:
        r5 = r9;
    L28:
        r6 = null;
    L35:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L37
    }
}
