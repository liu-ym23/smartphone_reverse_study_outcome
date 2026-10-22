package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowMessageService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$messageObserver$1$onSendMessage$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$messageObserver$1$onSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $sendTraceId;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public ChatMessageReceiverModel$messageObserver$1$onSendMessage$1(ChatMessageReceiverModel r1, Message r2, String r3, Continuation<? super ChatMessageReceiverModel$messageObserver$1$onSendMessage$1> r4) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$sendTraceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatMessageReceiverModel$messageObserver$1$onSendMessage$1(this.this$0, this.$msg, this.$sendTraceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r6);
        IFlowMessageService r7 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r7 == null) goto L18;
        String r8 = r7.e();
        if (r8 == null) goto L18;
        ChatMessageReceiverModel r0 = this.this$0;
        String r1 = this.$sendTraceId;
        Iterator<T> r2 = r0.n.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((Message) r3).getLocalMessageId(), r8) == false) goto L10;
    L15:
        Message r4 = (Message) r3;
        if (r4 == null) goto L18;
        Boxing.boxBoolean(r0.A(r4, RefreshTraceSource.SEND, r1));
        goto L18
    L14:
        r3 = null;
    L18:
        ChatMessageReceiverModel.f(this.this$0, this.$msg, "onSendMessage", RefreshTraceSource.SEND, this.$sendTraceId);
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
