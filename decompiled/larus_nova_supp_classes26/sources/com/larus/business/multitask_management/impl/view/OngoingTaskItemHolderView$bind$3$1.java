package com.larus.business.multitask_management.impl.view;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.view.OngoingTaskItemHolderView$bind$3$1", f = "OngoingTaskItemHolderView.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
final class OngoingTaskItemHolderView$bind$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kl9.u $item;
    final /* synthetic */ kl9.p $targetAction;
    int label;

    public OngoingTaskItemHolderView$bind$3$1(kl9.p r1, kl9.u r2, Continuation<? super OngoingTaskItemHolderView$bind$3$1> r3) {
        this.$targetAction = r1;
        this.$item = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OngoingTaskItemHolderView$bind$3$1(this.$targetAction, this.$item, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        Boolean r7 = (Boolean) r6;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        kl9.p r8 = this.$targetAction;
        if (r8 == null) goto L17;
        kl9.u r2 = this.$item;
        il9.a r3 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r3 == null) goto L17;
        String r4 = r2.a;
        this.label = 1;
        r6 = r3.h1(r4, r8, false, this);
        if (r6 != r0) goto L15;
        return r0;
    }
}
