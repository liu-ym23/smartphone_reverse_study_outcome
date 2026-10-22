package com.obric.aikernel.runtime;

import com.google.gson.k;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$dump$11", f = "AIInferRuntime.kt", i = {0}, l = {385}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AIInferRuntime$dump$11 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $args;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$dump$11(List<String> r10, AIInferRuntime r11, Continuation<? super AIInferRuntime$dump$11> r12) {
        this.$args = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AIInferRuntime$dump$11 r12 = new AIInferRuntime$dump$11(this.$args, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$dump$11) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        l0 r13 = (l0) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        Unit r14 = Unit.INSTANCE;
    L15:
        if (r14 != null) goto L18;
        com.obric.aikernel.runtime.utils.d.f5417a.l("AIInferRuntime", "push_debug_package error info is null!");
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        l0 r15 = (l0) this.L$0;
        String r16 = (String) CollectionsKt.getOrNull(this.$args, 1);
        if (r16 == null) goto L14;
        AIInferRuntime r17 = this.this$0;
        Object r18 = new com.google.gson.d().k(r16, k.class);
        Intrinsics.checkNotNullExpressionValue(r18, "Gson().fromJson(it, JsonObject::class.java)");
        this.L$0 = r15;
        this.label = 1;
        if (r17.p0((k) r18, this) != r11) goto L13;
        return r11;
    L14:
        r14 = null;
        goto L15
    }
}
