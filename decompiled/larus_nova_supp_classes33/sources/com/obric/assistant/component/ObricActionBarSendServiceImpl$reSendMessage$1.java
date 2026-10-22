package com.obric.assistant.component;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.service.IMessageService;
import com.larus.platform.IFlowMessageService;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.spi.actionbar.ObricMessageBottomExtActionType;
import com.obric.capabilitykit.common.StopReason;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricActionBarSendServiceImpl$reSendMessage$1", f = "ObricActionBarSendServiceImpl.kt", i = {}, l = {511, 512}, m = "invokeSuspend", n = {}, s = {})
final class ObricActionBarSendServiceImpl$reSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $replyMessage;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricActionBarSendServiceImpl this$0;

    public ObricActionBarSendServiceImpl$reSendMessage$1(Message r1, ObricActionBarSendServiceImpl r2, Continuation<? super ObricActionBarSendServiceImpl$reSendMessage$1> r3) {
        this.$replyMessage = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricActionBarSendServiceImpl$reSendMessage$1(this.$replyMessage, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r19);
    L66:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Message r3 = (Message) this.L$1;
        ObricActionBarSendServiceImpl r5 = (ObricActionBarSendServiceImpl) this.L$0;
        ResultKt.throwOnFailure(r19);
        Message r6 = r3;
        Object r4 = r19;
    L17:
        Message r7 = (Message) r4;
        if (r7 == null) goto L66;
        Message r8 = null;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        r5.e.set(r7);
        String r9 = r7.getMessageId();
        if (r9 != null) goto L22;
    L26:
        IFlowMessageService r10 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r10 == null) goto L33;
        String r11 = r6.getMessageId();
        if (r11 != null) goto L31;
        r11 = "";
    L31:
        r10.g(r11, false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ObricMessageBottomExtActionType.KEY_DISABLE_OBRIC_DEEP_THINK, "1")}), ObricMessageBottomExtActionType.SCENE_OBRIC_DIRECT_SEND);
    L33:
        if (Intrinsics.areEqual(r7.getMessageId(), r6.getReplyId()) == true) goto L51;
        Message r12 = r5.f.get();
        if (r12 == null) goto L63;
        List r13 = CollectionsKt.mutableListOf(new Message[]{r12});
        List r14 = CollectionsKt.mutableListOf(new Message[]{r7});
        Message r15 = r5.g.get();
        if (r15 == null) goto L39;
        Boxing.boxBoolean(r14.add(r15));
    L39:
        Message r16 = r5.h.get();
        if (r16 != null) goto L42;
    L46:
        NativeMessageServiceImpl r17 = com.larus.im.d.e();
        String r18 = r7.getConversationId();
        if (r18 != null) goto L49;
        String r110 = "";
    L50:
        IMessageService.a.a(r17, r110, r13, false, false, false, new b(r7, r14), 16);
        goto L63
    L49:
        r110 = r18;
        goto L50
    L42:
        if (Intrinsics.areEqual(r16.getReplyId(), r7.getMessageId()) == false) goto L44;
        r8 = r16;
    L44:
        if (r8 == null) goto L46;
        Boxing.boxBoolean(r13.add(r8));
    L63:
        if (Unit.INSTANCE != r1) goto L66;
        return r1;
    L51:
        Message r20 = r5.h.get();
        if (r20 == null) goto L63;
        if (Intrinsics.areEqual(r20.getReplyId(), r7.getMessageId()) == false) goto L56;
        r8 = r20;
    L56:
        if (r8 == null) goto L63;
        NativeMessageServiceImpl r21 = com.larus.im.d.e();
        String r22 = r7.getConversationId();
        if (r22 != null) goto L60;
        String r111 = "";
    L61:
        IMessageService.a.a(r21, r111, CollectionsKt.listOf(r8), false, false, false, null, 48);
        goto L63
    L60:
        r111 = r22;
        goto L61
    L22:
        if ((!StringsKt.isBlank(r9)) == false) goto L26;
        IAgentAppIntentIDL r23 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r23 == null) goto L26;
        r23.notifyStopAutoAction(r9, StopReason.DIRECT_SEND_INTERRUPT);
        goto L26
    L10:
        ResultKt.throwOnFailure(r19);
        Map r24 = this.$replyMessage.getExt();
        if (r24 == null) goto L66;
        String r25 = (String) r24.get("o_reference_msg_id");
        if (r25 == null) goto L66;
        r5 = this.this$0;
        r6 = this.$replyMessage;
        IChatRepoService r26 = zh8.a.a;
        this.L$0 = r5;
        this.L$1 = r6;
        this.label = 1;
        r4 = r26.E1(r25, this);
        if (r4 != r1) goto L17;
        return r1;
    }
}
