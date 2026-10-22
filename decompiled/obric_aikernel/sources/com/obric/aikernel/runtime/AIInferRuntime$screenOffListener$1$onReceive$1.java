package com.obric.aikernel.runtime;

import com.obric.aikernel.res.PackageResourceManager;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$screenOffListener$1$onReceive$1", f = "AIInferRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$screenOffListener$1$onReceive$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$screenOffListener$1$onReceive$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$screenOffListener$1$onReceive$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$screenOffListener$1$onReceive$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$screenOffListener$1$onReceive$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r10);
        PackageResourceManager r11 = AIInferRuntime.f(this.this$0);
        if (r11 == null) goto L7;
        r11.flushPackageUsage();
    L7:
        Iterator r12 = AIInferRuntime.g(this.this$0).values().iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        com.obric.aikernel.res.metadata.data.b.M(((AIInferRuntime.PackageWrapper) r12.next()).g(), 0, 1, null);
        goto L9
    L11:
        Iterator r13 = AIInferRuntime.m(this.this$0).values().iterator();
    L13:
        if (r13.hasNext() == false) goto L16;
        com.obric.aikernel.res.metadata.data.b.M(((AIInferRuntime.PackageWrapper) r13.next()).g(), 0, 1, null);
        goto L13
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
