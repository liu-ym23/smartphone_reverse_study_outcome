package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.agent.IObricSemanticApi;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.internal.ChatSender;
import com.obric.assistant.interaction.api.IWindowEffects;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$notifySemanticUserEditEventWithIdentifier$1", f = "MessageIDLStub.kt", i = {1, 1}, l = {791, 802, 851}, m = "invokeSuspend", n = {"message", "conversationId"}, s = {"L$0", "L$1"})
public final class MessageIDLStub$notifySemanticUserEditEventWithIdentifier$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowSemanticEditCallbackIDL $callback;
    final /* synthetic */ Map<Object, Object> $ext;
    final /* synthetic */ String $identifier;
    final /* synthetic */ String $messageId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public static final class a implements IIMCallback<List<? extends Message>> {
        public a() {
        }

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r4) {
            List r5 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger.a.i("IFlowMessageIDLSPI", "notifySemanticUserEditEventWithIdentifier, sendMessageCallback onSuccess");
            p1.b(r5);
        }
    }

    public MessageIDLStub$notifySemanticUserEditEventWithIdentifier$1(MessageIDLStub r1, String r2, IFlowSemanticEditCallbackIDL r3, String r4, Map<Object, Object> r5, Continuation<? super MessageIDLStub$notifySemanticUserEditEventWithIdentifier$1> r6) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$callback = r3;
        this.$identifier = r4;
        this.$ext = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MessageIDLStub$notifySemanticUserEditEventWithIdentifier$1(this.this$0, this.$messageId, this.$callback, this.$identifier, this.$ext, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L70:
        boolean r2 = ((Boolean) r1).booleanValue();
        FLogger.a.i("IFlowMessageIDLSPI", "notifySemanticUserEditEventWithIdentifier: called, origin message deleted = " + r2);
        MessageIDLStub.access$notifySemanticSuccess(this.this$0, this.$callback);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r3 = (String) this.L$1;
        Message r4 = (Message) this.L$0;
        ResultKt.throwOnFailure(r16);
        String r5 = r3;
        Message r6 = r4;
        Object r8 = r16;
    L26:
        if (((Boolean) r8).booleanValue() == true) goto L29;
        CoroutineScope r9 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.i(this.$messageId, "semantic_precheck_failed", "semantic preCheck failed, skip resend");
        MessageIDLStub.access$notifySemanticFail(this.this$0, this.$callback, "notifySemanticUserEditEventWithIdentifier, preCheck failed, skip resend");
        return Unit.INSTANCE;
    L29:
        CoroutineScope r10 = com.obric.assistant.chat.api.f.a;
        String r14 = com.obric.assistant.chat.api.f.g(r6, this.$identifier, 4);
        IWindowEffects r11 = (IWindowEffects) ServiceManager.get().getService(IWindowEffects.class);
        if (r11 == null) goto L32;
        r11.showScreenShotEffect();
    L32:
        int r12 = p1.a;
        Map<Object, Object> r13 = this.$ext;
        if (r13 == null) goto L35;
        Object r15 = r13.get("is_obric_continuous_talk");
    L37:
        if (Intrinsics.areEqual(r15, "1") == false) goto L45;
        a r17 = new a();
        Map r18 = r6.getExt();
        if (r18 == null) goto L43;
        Map r19 = MapsKt.toMutableMap(r18);
        if (r19 == null) goto L43;
        p1.a(r19);
        SemanticHelper r20 = SemanticHelper.a;
        SemanticHelper.a(r19);
    L44:
        Pair r21 = TuplesKt.to(r19, r17);
    L52:
        Map r22 = (Map) r21.component1();
        a r110 = (a) r21.component2();
        IObricChatService.a.getClass();
        IObricChatService r23 = IObricChatService.a.a();
        if (r23 == null) goto L64;
        ChatSender r24 = r23.getSender();
        if (r24 == null) goto L64;
        String r25 = MessageIDLStub.access$getPureTextAdaptBlock(this.this$0, r6);
        if (r25 != null) goto L59;
        r25 = NameKeys.UnloadStrategy_No_Strategy;
    L59:
        String r111 = r25;
        if (r22 != null) goto L62;
        Map r112 = new LinkedHashMap();
    L63:
        r24.c(r111, r112, this.$identifier, r110, r14);
        goto L64
    L62:
        r112 = r22;
    L64:
        SemanticHelper r26 = SemanticHelper.a;
        Intrinsics.checkNotNullParameter(r6, "message");
        IObricSemanticApi r27 = (IObricSemanticApi) ServiceManager.get().getService(IObricSemanticApi.class);
        if (r27 == null) goto L67;
        r27.a(r6);
    L67:
        MessageIDLStub r28 = this.this$0;
        ArrayList r113 = CollectionsKt.arrayListOf(new Message[]{r6});
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        r1 = MessageIDLStub.access$deleteMessage(r28, r5, true, false, r113, this);
        if (r1 != r7) goto L70;
        return r7;
    L43:
        r19 = null;
        goto L44
    L45:
        Map r29 = r6.getExt();
        if (r29 == null) goto L50;
        Map r30 = MapsKt.toMutableMap(r29);
        if (r30 == null) goto L50;
        SemanticHelper r31 = SemanticHelper.a;
        SemanticHelper.a(r30);
    L51:
        r21 = TuplesKt.to(r30, null);
    L50:
        r30 = null;
        goto L51
    L35:
        r15 = null;
        goto L37
    L11:
        ResultKt.throwOnFailure(r16);
        Object r32 = r16;
    L15:
        r6 = (Message) r32;
        if (r6 == null) goto L18;
        r5 = r6.getConversationId();
    L19:
        if (r6 == null) goto L72;
        if (r5 == null) goto L72;
        SemanticHelper r33 = SemanticHelper.a;
        this.L$0 = r6;
        this.L$1 = r5;
        this.label = 2;
        r8 = r33.c(r6, r5, this);
        if (r8 != r7) goto L26;
        return r7;
    L72:
        CoroutineScope r34 = com.obric.assistant.chat.api.f.a;
        String r35 = this.$messageId;
        if (r6 != null) goto L75;
        String r36 = "query_not_found";
    L76:
        if (r6 != null) goto L78;
        String r37 = "semantic query not found";
    L79:
        com.obric.assistant.chat.api.f.i(r35, r36, r37);
        MessageIDLStub.access$notifySemanticFail(this.this$0, this.$callback, "notifySemanticUserEditEventWithIdentifier, message or conversationId not found");
        return Unit.INSTANCE;
    L78:
        r37 = "semantic query conversation id empty";
        goto L79
    L75:
        r36 = "conversation_id_empty";
        goto L76
    L18:
        r5 = null;
        goto L19
    L12:
        ResultKt.throwOnFailure(r16);
        MessageIDLStub r38 = this.this$0;
        String r39 = this.$messageId;
        this.label = 1;
        r32 = MessageIDLStub.access$getMessageById(r38, r39, this);
        if (r32 != r7) goto L15;
        return r7;
    }
}
