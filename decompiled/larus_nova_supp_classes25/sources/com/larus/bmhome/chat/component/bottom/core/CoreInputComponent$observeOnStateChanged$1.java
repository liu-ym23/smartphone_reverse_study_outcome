package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vb8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/chat/component/bottom/core/CoreInputComponentState;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$observeOnStateChanged$1", f = "CoreInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputComponent$observeOnStateChanged$1 extends SuspendLambda implements Function2<CoreInputComponentState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    public CoreInputComponent$observeOnStateChanged$1(CoreInputComponent r1, Continuation<? super CoreInputComponent$observeOnStateChanged$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CoreInputComponent$observeOnStateChanged$1 r0 = new CoreInputComponent$observeOnStateChanged$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(CoreInputComponentState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoreInputComponentState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        CoreInputComponentState r5 = (CoreInputComponentState) this.L$0;
        if (a.c(r5.getBotModel()) == false) goto L7;
        CoreInputComponent r6 = this.this$0;
        int r0 = CoreInputComponent.d3;
        r6.U5(false, "bot_vm_state_changed");
    L13:
        return Unit.INSTANCE;
    L7:
        CoreInputComponent r1 = this.this$0;
        int r2 = CoreInputComponent.d3;
        if (Intrinsics.areEqual(r1.w6(), "") == false) goto L10;
        boolean r7 = true;
    L11:
        r1.U5(r7, "vm_state_changed");
        goto L13
    L10:
        r7 = r5.getEnableRealtimeCall();
        goto L11
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
