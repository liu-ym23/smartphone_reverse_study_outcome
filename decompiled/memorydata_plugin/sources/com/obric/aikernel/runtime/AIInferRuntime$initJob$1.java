package com.obric.aikernel.runtime;

import android.content.Context;
import com.bytedance.crash.constants.Constants;
import com.obric.aikernel.runtime.utils.CommonExtension;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$initJob$1", f = "AIInferRuntime.kt", i = {}, l = {Constants.UPLOAD_DISASTER_ESCAPE, 215, 228, 230}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$initJob$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$initJob$1(AIInferRuntime r3, Continuation<? super AIInferRuntime$initJob$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        AIInferRuntime$initJob$1 r0 = new AIInferRuntime$initJob$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AIInferRuntime$initJob$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$initJob$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r12);
    L53:
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "init job finished");
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r12);
    L50:
        AIInferRuntime r13 = this.this$0;
        Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.label = 4;
        if (AIInferRuntime.b(r13, r2) != r0) goto L53;
        return r0;
    L12:
        AIInferRuntime r3 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(this.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L18
    L33:
        List<Pair<String, Object>> r14 = r3.a().c();     // Catch: Throwable -> L18
        if (r14 == null) goto L39;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L18
    L37:
        if (r15.hasNext() == false) goto L39;
        Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(r15.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.component1(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        com.obric.aee.b.f5869a.a(r5.component2(), r6);     // Catch: Throwable -> L18
    L39:
        com.obric.aikernel.runtime.utils.b.f6214a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AIInferRuntime.j(r3).getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
        com.obric.aee.b.f5869a.a(r3, "aik");     // Catch: Throwable -> L18
        com.obric.aee.b.f5869a.a(new CommonExtension(), "common");     // Catch: Throwable -> L18
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "vm init finished");     // Catch: Throwable -> L18
        Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L42:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L45;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "vm init failed " + ExceptionsKt.stackTraceToString(r17));
    L45:
        AIInferRuntime.b r18 = this.this$0.a().d();
        if (r18 == null) goto L50;
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.label = 3;
        if (r18.b(r4) != r0) goto L50;
        return r0;
    L15:
        r3 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(this.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L18
    L30:
        com.obric.aee.b r19 = com.obric.aee.b.f5869a;     // Catch: Throwable -> L18
        com.obric.aee.a r7 = (com.obric.aee.a) ZeusTransformUtils.preCheckCast(AIInferRuntime.j(r3), com.obric.aee.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        this.L$0 = r3;     // Catch: Throwable -> L18
        this.label = 2;     // Catch: Throwable -> L18
        if (r19.a(r7, this) != r0) goto L33;
        return r0;
    L20:
        ResultKt.throwOnFailure(r12);
        al r110 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        if (this.this$0.a().m().c() != null) goto L23;
        r3 = this.this$0;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L18
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "vm init start root = " + AIInferRuntime.j(r3).a());     // Catch: Throwable -> L18
        AIInferRuntime.b r112 = r3.a().d();     // Catch: Throwable -> L18
        if (r112 == null) goto L30;
        this.L$0 = r3;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        if (r112.c(this) != r0) goto L30;
        return r0;
    L23:
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L42
    }
}
