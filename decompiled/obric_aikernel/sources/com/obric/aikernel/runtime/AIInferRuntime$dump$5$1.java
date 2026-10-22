package com.obric.aikernel.runtime;

import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.data.AIPackage;
import java.util.List;
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
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$dump$5$1", f = "AIInferRuntime.kt", i = {}, l = {339}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$dump$5$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $args;
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$dump$5$1(AIInferRuntime r10, String r11, List<String> r12, Continuation<? super AIInferRuntime$dump$5$1> r13) {
        this.this$0 = r10;
        this.$name = r11;
        this.$args = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$dump$5$1(this.this$0, this.$name, this.$args, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$dump$5$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        AIPackage r13 = (AIPackage) r10;
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        PackageResourceManager r14 = AIInferRuntime.f(this.this$0);
        if (r14 == null) goto L18;
        String r15 = this.$name;
        String r16 = (String) CollectionsKt.getOrNull(this.$args, 2);
        if (r16 != null) goto L13;
        r16 = "";
    L13:
        this.label = 1;
        r10 = r14.updateByForeground(r15, "com.obric.aikernel.dump", true, r16, this);
        if (r10 != r11) goto L16;
        return r11;
    }
}
