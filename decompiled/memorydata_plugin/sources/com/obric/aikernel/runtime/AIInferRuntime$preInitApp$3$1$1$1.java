package com.obric.aikernel.runtime;

import android.os.SystemClock;
import com.obric.aikernel.sdk.config.RequestParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$preInitApp$3$1$1$1", f = "AIInferRuntime.kt", i = {}, l = {890}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$preInitApp$3$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ com.obric.aee.res.b $it;
    final /* synthetic */ AIInferRuntime.g $wrapper;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$preInitApp$3$1$1$1(com.obric.aee.res.b r3, AIInferRuntime r4, AIInferRuntime.g r5, Continuation<? super AIInferRuntime$preInitApp$3$1$1$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$it = r3;
        this.this$0 = r4;
        this.$wrapper = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$preInitApp$3$1$1$1(this.$it, this.this$0, this.$wrapper, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
        return ((AIInferRuntime$preInitApp$3$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$preInitApp$3$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L17
    L15:
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "preInitApp: end");     // Catch: Throwable -> L17
        Object r15 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r15);
        if (r2 == null) goto L22;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "preInitApp failed: " + ExceptionsKt.stackTraceToString(r2));
    L22:
        Boolean r16 = Boxing.boxBoolean(Result.m1428isSuccessimpl(r15));
        AIInferRuntime r13 = this.this$0;
        r16.booleanValue();
        AIInferRuntime.a(r13, SystemClock.elapsedRealtime());
        return r16;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        com.obric.aee.res.b r5 = this.$it;
        AIInferRuntime r17 = this.this$0;
        AIInferRuntime.g r8 = this.$wrapper;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "preInitApp: start " + r5);     // Catch: Throwable -> L17
        e r4 = AIInferRuntime.e(r17);     // Catch: Throwable -> L17
        if (r4 == null) goto L15;
        RequestParams r6 = new RequestParams(null, null, 3, null);     // Catch: Throwable -> L17
        this.label = 1;     // Catch: Throwable -> L17
        if (e.a(r4, r5, r6, null, r8, null, this, 20, null) != r0) goto L15;
        return r0;
    L17:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
