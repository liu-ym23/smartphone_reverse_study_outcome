package com.obric.aikernel;

import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.InitTracker$startWatch$1", f = "InitTracker.kt", i = {}, l = {14}, m = "invokeSuspend", n = {}, s = {})
final class InitTracker$startWatch$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;

    InitTracker$startWatch$1(Continuation<? super InitTracker$startWatch$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new InitTracker$startWatch$1(r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((InitTracker$startWatch$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        Map<String, String> r13 = j7.a.f9776a.a();
        if (r13.isEmpty() == true) goto L14;
        u7.c.b(u7.c.f13139a, "InitTaskTimeout", StringsKt.trimIndent("\n                taskNames=" + CollectionsKt.joinToString$default(r13.entrySet(), ", ", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null) + "}\n            "), null, null, 12, null);
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        long r14 = InitTracker.f4402a.a();
        this.label = 1;
        if (DelayKt.b(r14, this) != r10) goto L11;
        return r10;
    }
}
