package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.a;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1", f = "AbsApi.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class AbsApi$callModelAsFlow$1 extends SuspendLambda implements Function2<l<? super Bundle>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ a $binder;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AbsApi this$0;

    AbsApi$callModelAsFlow$1(a r10, AbsApi r11, Bundle r12, Continuation<? super AbsApi$callModelAsFlow$1> r13) {
        this.$binder = r10;
        this.this$0 = r11;
        this.$args = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AbsApi$callModelAsFlow$1 r12 = new AbsApi$callModelAsFlow$1(this.$binder, this.this$0, this.$args, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<? super Bundle> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<? super Bundle> r10, Continuation<? super Unit> r11) {
        return ((AbsApi$callModelAsFlow$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        final l r13 = (l) this.L$0;
        AIKLog.INSTANCE.i("AbsApi", "start callModelAsFlow...");
        final v1 r14 = BinderMonitor.f4766a.b(r13.getCoroutineContext(), this.$binder, new AbsApi$callModelAsFlow$1$monitorTask$1(r13));
        if (AbsApi.a(this.this$0, this.$binder, this.$args, r13) == true) goto L12;
        if (r14 == null) goto L16;
        v1.a.a(r14, null, 1, null);
        goto L16
    L12:
        Function0<Unit> r15 = new AnonymousClass1(r14);
        this.label = 1;
        if (ProduceKt.a(r13, r15, this) != r11) goto L16;
        return r11;
    }
}
