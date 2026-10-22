package com.larus.business.floatchat.impl.component;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "vmState", "Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateVMState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.component.AIFloatChatWindowStateComponent$bindState$1", f = "AIFloatChatWindowStateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIFloatChatWindowStateComponent$bindState$1 extends SuspendLambda implements Function2<AIFloatChatWindowStateVMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIFloatChatWindowStateComponent this$0;

    public AIFloatChatWindowStateComponent$bindState$1(AIFloatChatWindowStateComponent r1, Continuation<? super AIFloatChatWindowStateComponent$bindState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AIFloatChatWindowStateComponent$bindState$1 r0 = new AIFloatChatWindowStateComponent$bindState$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(AIFloatChatWindowStateVMState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((AIFloatChatWindowStateVMState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r4);
        AIFloatChatWindowStateVMState r5 = (AIFloatChatWindowStateVMState) this.L$0;
        if (r5.isDragging() == false) goto L9;
        return Unit.INSTANCE;
    L9:
        if (r5.isDynamicHeightSync() == false) goto L12;
        FLogger.a.d("AIFloatChatWindowStateComponent", "skip applyWindowState for dynamic height sync, state=" + r5.getState() + ", height=" + r5.getHeightPx());
        return Unit.INSTANCE;
    L12:
        AIFloatChatWindowStateComponent r0 = this.this$0;
        int r1 = AIFloatChatWindowStateComponent.S1;
        va8.h r2 = r0.D3(r5);
        this.this$0.p4(r2, r5.getAnchorMessage());
        Iterator<T> r6 = this.this$0.v.iterator();
    L14:
        if (r6.hasNext() == false) goto L17;
        ((va8.i) r6.next()).am(r2);
        goto L14
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
