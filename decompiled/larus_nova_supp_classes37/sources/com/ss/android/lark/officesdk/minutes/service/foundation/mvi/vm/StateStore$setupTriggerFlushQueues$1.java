package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.StateStore$setupTriggerFlushQueues$1", f = "StateStore.kt", i = {0}, l = {53}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class StateStore$setupTriggerFlushQueues$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ c<l> this$0;

    public StateStore$setupTriggerFlushQueues$1(c<l> r1, Continuation<? super StateStore$setupTriggerFlushQueues$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        StateStore$setupTriggerFlushQueues$1 r0 = new StateStore$setupTriggerFlushQueues$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r9);
    L11:
        if (CoroutineScopeKt.isActive(r2) == false) goto L19;
        c<l> r3 = this.this$0;
        this.L$0 = r2;
        this.label = 1;
        ExecutorCoroutineDispatcher r4 = c.g;
        r3.getClass();
        SelectImplementation r5 = new SelectImplementation(getContext());
        r5.d(r3.b.getOnReceive(), new StateStore$flushQueuesOnce$2$1(r3, null));
        r5.d(r3.c.getOnReceive(), new StateStore$flushQueuesOnce$2$2(r3, null));
        Object r6 = r5.h(this);
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        r6 = Unit.INSTANCE;
    L16:
        if (r6 != r0) goto L11;
        return r0;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r2 = (CoroutineScope) this.L$0;
        goto L11
    }
}
