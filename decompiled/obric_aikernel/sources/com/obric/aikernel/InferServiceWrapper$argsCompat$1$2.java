package com.obric.aikernel;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.InferServiceWrapper$argsCompat$1$2", f = "InferServiceWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InferServiceWrapper$argsCompat$1$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InferServiceWrapper this$0;

    InferServiceWrapper$argsCompat$1$2(InferServiceWrapper r10, Continuation<? super InferServiceWrapper$argsCompat$1$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new InferServiceWrapper$argsCompat$1$2(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((InferServiceWrapper$argsCompat$1$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r10);
        ConcurrentHashMap r11 = InferServiceWrapper.k2(this.this$0);
        InferServiceWrapper r12 = this.this$0;
        Iterator r13 = r11.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        if (((WeakReference) r14.getValue()).get() != null) goto L6;
        InferServiceWrapper.k2(r12).remove(r15);
        goto L6
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
