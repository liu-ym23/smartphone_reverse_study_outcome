package com.bytedance.android.ec.core.arch.state;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\b\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/arch/state/b;", "S", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "reducer", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/ec/core/arch/state/CoroutinesStateStore$flushQueuesOnce$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.arch.state.CoroutinesStateStore$flushQueuesOnce$2$1", f = "CoroutinesStateStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1 extends SuspendLambda implements Function2<Function1<b, b>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1(Continuation r1, a r10) {
        this.this$0 = r10;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1 r0 = new CoroutinesStateStore$flushQueuesOnce$$inlined$select$lambda$1(r11, this.this$0);
        r0.L$0 = r10;
        return r0;
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        S r11 = (S) ((Function1) this.L$0).invoke(this.this$0.d);
        if ((!Intrinsics.areEqual(r11, this.this$0.d)) == false) goto L8;
        a r0 = this.this$0;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.d = r11;
        this.this$0.c.postValue(r11);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
