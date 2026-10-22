package com.obric.aikernel.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$5$syncNativeLib$1", f = "AIInferRuntime.kt", i = {}, l = {1604}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$5$syncNativeLib$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$5$syncNativeLib$1(AIInferRuntime r3, Continuation<? super AIInferRuntime$5$syncNativeLib$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$5$syncNativeLib$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AIInferRuntime$5$syncNativeLib$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$5$syncNativeLib$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        AIInferRuntime r4 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(this.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L22:
        if (r2.hasNext() == false) goto L27;
        String r12 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");
        this.L$0 = r4;
        this.L$1 = r2;
        this.label = 1;
        if (AIInferRuntime.a(r4, r12, this) != r0) goto L22;
        return r0;
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        Map<String, AIInferRuntime.d.e> r13 = this.this$0.a().m().c();
        if (r13 == null) goto L27;
        AIInferRuntime r3 = this.this$0;
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, AIInferRuntime.d.e>> r14 = r13.entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L20;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        AIInferRuntime.d.c r7 = r3.a().i();
        boolean r8 = false;
        if (r7 != null) goto L16;
    L18:
        if (r8 == false) goto L12;
        r5.put(r6.getKey(), r6.getValue());
        goto L12
    L16:
        if (r7.a((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin")) != true) goto L18;
        r8 = true;
        goto L18
    L20:
        AIInferRuntime r15 = this.this$0;
        r2 = r5.entrySet().iterator();
        r4 = r15;
        goto L22
    }
}
