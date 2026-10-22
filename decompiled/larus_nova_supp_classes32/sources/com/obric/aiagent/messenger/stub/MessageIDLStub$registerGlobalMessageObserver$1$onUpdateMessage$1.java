package com.obric.aiagent.messenger.stub;

import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$registerGlobalMessageObserver$1$onUpdateMessage$1", f = "MessageIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$registerGlobalMessageObserver$1$onUpdateMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMMessage $imMsg;
    final /* synthetic */ MessageIDLStub$e $widgetSnapshot;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$registerGlobalMessageObserver$1$onUpdateMessage$1(MessageIDLStub$e r1, MessageIDLStub r2, IMMessage r3, Continuation<? super MessageIDLStub$registerGlobalMessageObserver$1$onUpdateMessage$1> r4) {
        this.$widgetSnapshot = r1;
        this.this$0 = r2;
        this.$imMsg = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageIDLStub$registerGlobalMessageObserver$1$onUpdateMessage$1(this.$widgetSnapshot, this.this$0, this.$imMsg, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        MessageIDLStub$e r4 = this.$widgetSnapshot;
        if (r4 == null) goto L8;
        MessageIDLStub.access$restoreOrBufferPendingWidgetUpdates(this.this$0, r4);
    L8:
        if (MessageIDLStub.access$shouldDispatchUpdate(this.this$0, this.$imMsg) == false) goto L10;
        MessageIDLStub r5 = this.this$0;
        final IMMessage r0 = this.$imMsg;
        MessageIDLStub.access$dispatchMessageEvent(r5, 4, new g1(r0));
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
