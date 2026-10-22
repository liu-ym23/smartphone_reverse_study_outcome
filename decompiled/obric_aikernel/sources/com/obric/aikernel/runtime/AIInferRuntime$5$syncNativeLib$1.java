package com.obric.aikernel.runtime;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$5$syncNativeLib$1", f = "AIInferRuntime.kt", i = {}, l = {1565}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$5$syncNativeLib$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$5$syncNativeLib$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$5$syncNativeLib$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$5$syncNativeLib$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$5$syncNativeLib$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        Iterator r13 = (Iterator) this.L$1;
        AIInferRuntime r14 = (AIInferRuntime) this.L$0;
        ResultKt.throwOnFailure(r10);
    L22:
        if (r13.hasNext() == false) goto L27;
        String r15 = (String) ((Map.Entry) r13.next()).getKey();
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 1;
        if (AIInferRuntime.r(r14, r15, this) != r11) goto L22;
        return r11;
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Map<String, AIInferRuntime.d.C0119d> r16 = this.this$0.R().f().d();
        if (r16 == null) goto L27;
        AIInferRuntime r17 = this.this$0;
        LinkedHashMap r18 = new LinkedHashMap();
        Iterator<Map.Entry<String, AIInferRuntime.d.C0119d>> r19 = r16.entrySet().iterator();
    L12:
        if (r19.hasNext() == false) goto L20;
        Map.Entry<String, AIInferRuntime.d.C0119d> r20 = r19.next();
        AIInferRuntime.d.b r21 = r17.R().l();
        boolean r22 = false;
        if (r21 != null) goto L16;
    L18:
        if (r22 == false) goto L12;
        r18.put(r20.getKey(), r20.getValue());
        goto L12
    L16:
        if (r21.b(r20.getKey()) != true) goto L18;
        r22 = true;
        goto L18
    L20:
        AIInferRuntime r23 = this.this$0;
        r13 = r18.entrySet().iterator();
        r14 = r23;
        goto L22
    }
}
