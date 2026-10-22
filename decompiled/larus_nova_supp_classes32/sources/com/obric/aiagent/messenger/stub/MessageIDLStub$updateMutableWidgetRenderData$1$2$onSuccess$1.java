package com.obric.aiagent.messenger.stub;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$updateMutableWidgetRenderData$1$2$onSuccess$1", f = "MessageIDLStub.kt", i = {}, l = {1391}, m = "invokeSuspend", n = {}, s = {})
final class MessageIDLStub$updateMutableWidgetRenderData$1$2$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $blockId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ MessageIDLStub$c $pendingUpdate;
    final /* synthetic */ String $renderData;
    final /* synthetic */ Message $result;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$updateMutableWidgetRenderData$1$2$onSuccess$1(Message r1, MessageIDLStub$c r2, String r3, String r4, MessageIDLStub r5, String r6, String r7, Continuation<? super MessageIDLStub$updateMutableWidgetRenderData$1$2$onSuccess$1> r8) {
        this.$result = r1;
        this.$pendingUpdate = r2;
        this.$localMessageId = r3;
        this.$blockId = r4;
        this.this$0 = r5;
        this.$conversationId = r6;
        this.$renderData = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MessageIDLStub$updateMutableWidgetRenderData$1$2$onSuccess$1(this.$result, this.$pendingUpdate, this.$localMessageId, this.$blockId, this.this$0, this.$conversationId, this.$renderData, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L52:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        String r16 = this.$result.getMessageId();
        String r2 = null;
        if (r16 != null) goto L11;
    L13:
        String r6 = null;
    L14:
        if (r6 != null) goto L20;
        MessageIDLStub$c r17 = this.$pendingUpdate;
        if (r17 == null) goto L18;
        MessageIDLStub.access$removePendingWidgetUpdateIfCurrent(this.this$0, r17);
    L18:
        FLogger.a.e("IFlowMessageIDLSPI", "updateMutableWidgetRenderData remote sync skipped, localMessageId=" + this.$localMessageId + ", messageId=" + this.$result.getMessageId() + ", blockId=" + this.$blockId);
        return Unit.INSTANCE;
    L20:
        MessageIDLStub$c r18 = (MessageIDLStub$c) MessageIDLStub.access$getPendingWidgetUpdates$p(this.this$0).get(this.$localMessageId);
        if (r18 == null) goto L38;
        if (StringsKt.isBlank(r18.c) == false) goto L25;
        MessageIDLStub$c r7 = r18;
    L26:
        if (r7 == null) goto L38;
        MessageIDLStub r19 = this.this$0;
        String r3 = this.$localMessageId;
        Message r4 = this.$result;
        String r5 = this.$conversationId;
        LinkedHashMap r110 = MessageIDLStub.access$getPendingWidgetUpdates$p(r19);
        String r8 = r4.getConversationId();
        if (r8 != null) goto L30;
    L35:
        String r9 = r5;
    L36:
        r110.put(r3, MessageIDLStub$c.a(r7, null, r9, false, 0, 251));
        goto L38
    L30:
        if ((!StringsKt.isBlank(r8)) == true) goto L33;
        r8 = null;
    L33:
        if (r8 == null) goto L35;
        r9 = r8;
        goto L36
    L25:
        r7 = null;
    L38:
        if (MessageIDLStub.access$getPendingWidgetUpdates$p(this.this$0).get(this.$localMessageId) != null) goto L48;
        MessageIDLStub r10 = this.this$0;
        String r11 = this.$localMessageId;
        String r111 = this.$result.getConversationId();
        if (r111 != null) goto L42;
    L46:
        String r12 = this.$conversationId;
    L47:
        MessageIDLStub.access$enqueuePendingWidgetUpdate(r10, r11, r6, r12, this.$blockId, this.$renderData, AppHost.a.a().isAppBackground());
        goto L48
    L42:
        if ((!StringsKt.isBlank(r111)) == false) goto L44;
        r2 = r111;
    L44:
        if (r2 == null) goto L46;
        r12 = r2;
    L48:
        MessageIDLStub r112 = this.this$0;
        String r13 = this.$localMessageId;
        this.label = 1;
        if (MessageIDLStub.access$syncPendingWidgetUpdate(r112, r13, this) != r0) goto L52;
        return r0;
    L11:
        if ((!StringsKt.isBlank(r16)) == false) goto L13;
        r6 = r16;
        goto L14
    }
}
