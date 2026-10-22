package com.obric.aiagent.messenger.stub;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.IObricChatService;
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
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$updateMutableWidgetRenderData$1", f = "MessageIDLStub.kt", i = {}, l = {1314}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$updateMutableWidgetRenderData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $blockId;
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ String $renderData;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$updateMutableWidgetRenderData$1(MessageIDLStub r1, String r2, String r3, String r4, Continuation<? super MessageIDLStub$updateMutableWidgetRenderData$1> r5) {
        this.this$0 = r1;
        this.$localMessageId = r2;
        this.$blockId = r3;
        this.$renderData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MessageIDLStub$updateMutableWidgetRenderData$1(this.this$0, this.$localMessageId, this.$blockId, this.$renderData, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        Message r13 = (Message) r12;
        if (r13 != null) goto L14;
    L41:
        FLogger.a.e("IFlowMessageIDLSPI", "updateMutableWidgetRenderData ignored: widget block not found, localMessageId=" + this.$localMessageId + ", blockId=" + this.$blockId);
        return Unit.INSTANCE;
    L14:
        if (MessageIDLStub.access$replaceWidgetRenderData(this.this$0, r13, this.$blockId, this.$renderData) == null) goto L41;
        String r2 = r13.getMessageId();
        String r14 = r13.getConversationId();
        MessageIDLStub$c r3 = null;
        if (r14 != null) goto L19;
    L24:
        IObricChatService.a.getClass();
        IObricChatService r15 = IObricChatService.a.a();
        if (r15 == null) goto L29;
        wc9.e r16 = r15.h();
        if (r16 == null) goto L29;
        r14 = r16.a;
    L30:
        if (r14 != null) goto L32;
        r14 = NameKeys.UnloadStrategy_No_Strategy;
    L32:
        if (r2 != null) goto L34;
    L39:
        final MessageIDLStub$c r7 = r3;
        NativeMessageServiceImpl r4 = com.larus.im.d.e();
        final String r5 = this.$localMessageId;
        final MessageIDLStub r6 = this.this$0;
        final String r8 = this.$blockId;
        final String r9 = this.$renderData;
        final String r10 = r14;
        r4.x(r5, new k1(r6, r8, r9), new AnonymousClass2(r5, r8, r6, r7, r10, r9));
        return Unit.INSTANCE;
    L34:
        if ((true ^ StringsKt.isBlank(r2)) == false) goto L36;
        String r11 = r2;
    L37:
        if (r11 == null) goto L39;
        r3 = MessageIDLStub.access$enqueuePendingWidgetUpdate(this.this$0, this.$localMessageId, r11, r14, this.$blockId, this.$renderData, AppHost.a.a().isAppBackground());
        goto L39
    L36:
        r11 = null;
    L29:
        r14 = null;
        goto L30
    L19:
        if ((!StringsKt.isBlank(r14)) == true) goto L22;
        r14 = null;
    L22:
        if (r14 == null) goto L24;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        MessageIDLStub r17 = this.this$0;
        String r18 = this.$localMessageId;
        this.label = 1;
        r12 = MessageIDLStub.access$getMessageById(r17, r18, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
