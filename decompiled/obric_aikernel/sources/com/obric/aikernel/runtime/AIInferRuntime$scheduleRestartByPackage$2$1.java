package com.obric.aikernel.runtime;

import java.util.List;
import java.util.Set;
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
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$scheduleRestartByPackage$2$1", f = "AIInferRuntime.kt", i = {}, l = {1292}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$scheduleRestartByPackage$2$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ List<String> $procs;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$scheduleRestartByPackage$2$1(String r10, AIInferRuntime r11, List<String> r12, Continuation<? super AIInferRuntime$scheduleRestartByPackage$2$1> r13) {
        this.$name = r10;
        this.this$0 = r11;
        this.$procs = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$scheduleRestartByPackage$2$1(this.$name, this.this$0, this.$procs, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$scheduleRestartByPackage$2$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "scheduleRestart by addPackage#" + this.$name);
        AIInferRuntime.d.a r13 = this.this$0.R().i();
        if (r13 == null) goto L14;
        Set<String> r14 = CollectionsKt.toSet(this.$procs);
        this.label = 1;
        if (r13.a(r14, this) != r11) goto L14;
        return r11;
    }
}
