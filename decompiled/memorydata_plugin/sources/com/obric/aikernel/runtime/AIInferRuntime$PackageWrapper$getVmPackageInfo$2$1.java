package com.obric.aikernel.runtime;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
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
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/obric/aee/res/PackageInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1", f = "AIInferRuntime.kt", i = {}, l = {1491}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Result<? extends com.obric.aee.res.b>>, Object> {
    final /* synthetic */ Function1<Continuation<? super com.obric.aee.res.b>, Object> $getter;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime.g this$0;

    AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1(Function1<? super Continuation<? super com.obric.aee.res.b>, ? extends Object> r3, AIInferRuntime.g r4, Continuation<? super AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1> r5) {
        Function1<Continuation<? super com.obric.aee.res.b>, Object> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$getter = r6;
        this.this$0 = r4;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1 r0 = new AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1(this.$getter, this.this$0, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Result<? extends com.obric.aee.res.b>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Result<com.obric.aee.res.b>> r4) {
        return ((AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.m1421constructorimpl((com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aee.res.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    L17:
        AIInferRuntime.g r2 = this.this$0;
        Throwable r3 = Result.m1424exceptionOrNullimpl(r8);
        if (r3 == null) goto L20;
        AIInferRuntime.g.a(r2).a(r2);
        com.obric.aikernel.runtime.utils.d.f6216a.f("AIInferRuntime", "getVmPackageInfo init " + r2.a() + '|' + r2.c() + " failed: " + r3);
    L20:
        Result r9 = Result.m1420boximpl(r8);
        AIInferRuntime.g r6 = this.this$0;
        Object r4 = r9.m1430unboximpl();
        Long r5 = AIInferRuntime.g.b(r6);
        if (r5 == null) goto L23;
        ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue();
        AIInferRuntime.g.a(r6, Boxing.boxLong(SystemClock.elapsedRealtime() + AIInferRuntime.g.b(r6).longValue()));
    L23:
        r6.a(Result.m1420boximpl(r4));
        if (Intrinsics.areEqual(r6.a().s(), "vlm_local") == false) goto L33;
        Result<com.obric.aee.res.b> r10 = r6.d();
        if (r10 == null) goto L33;
        Object r11 = r10.m1430unboximpl();
        if (Result.m1427isFailureimpl(r11) == false) goto L31;
        r11 = null;
    L31:
        if (((com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r11, com.obric.aee.res.b.class, "com.obric.memorydata.plugin")) == null) goto L33;
        com.obric.aikernel.res.metadata.c.f6058a.a(r6.a());
    L33:
        return r9;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        al r12 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        Function1<Continuation<? super com.obric.aee.res.b>, Object> r13 = this.$getter;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r7 = r13.invoke(this);     // Catch: Throwable -> L15
        if (r7 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
