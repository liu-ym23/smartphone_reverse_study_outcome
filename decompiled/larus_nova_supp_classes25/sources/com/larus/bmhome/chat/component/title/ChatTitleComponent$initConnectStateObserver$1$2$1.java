package com.larus.bmhome.chat.component.title;

import androidx.lifecycle.LiveData;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.IMConnectState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$initConnectStateObserver$1$2$1", f = "ChatTitleComponent.kt", i = {}, l = {2074}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleComponent$initConnectStateObserver$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Runnable $task;
    int label;
    final /* synthetic */ ChatTitleComponent this$0;

    public ChatTitleComponent$initConnectStateObserver$1$2$1(ChatTitleComponent r1, Runnable r2, Continuation<? super ChatTitleComponent$initConnectStateObserver$1$2$1> r3) {
        this.this$0 = r1;
        this.$task = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTitleComponent$initConnectStateObserver$1$2$1(this.this$0, this.$task, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        ChatTitleComponent r5 = this.this$0;
        int r2 = ChatTitleComponent.P1;
        LiveData r6 = (LiveData) r5.V.getValue();
        if (r6 == null) goto L14;
        IMConnectState r7 = (IMConnectState) r6.getValue();
    L16:
        if (r7 != IMConnectState.CONNECTING) goto L19;
        this.$task.run();
    L19:
        return Unit.INSTANCE;
    L14:
        r7 = null;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L11;
        return r0;
    }
}
