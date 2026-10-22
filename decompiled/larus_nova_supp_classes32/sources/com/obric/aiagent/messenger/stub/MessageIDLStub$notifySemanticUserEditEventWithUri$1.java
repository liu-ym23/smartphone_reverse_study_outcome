package com.obric.aiagent.messenger.stub;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
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
import com.obric.assistant.upload.Scene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$notifySemanticUserEditEventWithUri$1", f = "MessageIDLStub.kt", i = {1, 1}, l = {892, 903, 964}, m = "invokeSuspend", n = {"message", "conversationId"}, s = {"L$0", "L$1"})
public final class MessageIDLStub$notifySemanticUserEditEventWithUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowSemanticEditCallbackIDL $callback;
    final /* synthetic */ Map<Object, Object> $ext;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $uri;
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
            FLogger.a.i("IFlowMessageIDLSPI", "notifySemanticUserEditEventWithUri, sendMessageCallback onSuccess");
            p1.b(r5);
        }
    }

    public MessageIDLStub$notifySemanticUserEditEventWithUri$1(MessageIDLStub r1, String r2, IFlowSemanticEditCallbackIDL r3, String r4, Map<Object, Object> r5, Continuation<? super MessageIDLStub$notifySemanticUserEditEventWithUri$1> r6) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$callback = r3;
        this.$uri = r4;
        this.$ext = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MessageIDLStub$notifySemanticUserEditEventWithUri$1(this.this$0, this.$messageId, this.$callback, this.$uri, this.$ext, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r17);
        Object r1 = r17;
    L73:
        boolean r2 = ((Boolean) r1).booleanValue();
        FLogger.a.i("IFlowMessageIDLSPI", "notifySemanticUserEditEventWithUri: called, origin message deleted = " + r2);
        MessageIDLStub.access$notifySemanticSuccess(this.this$0, this.$callback);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r3 = (String) this.L$1;
        Message r4 = (Message) this.L$0;
        ResultKt.throwOnFailure(r17);
        String r5 = r3;
        Message r6 = r4;
        Object r8 = r17;
    L26:
        if (((Boolean) r8).booleanValue() == true) goto L29;
        CoroutineScope r9 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.i(this.$messageId, "semantic_precheck_failed", "semantic preCheck failed, skip resend");
        MessageIDLStub.access$notifySemanticFail(this.this$0, this.$callback, "notifySemanticUserEditEventWithUri, preCheck failed, skip resend");
        return Unit.INSTANCE;
    L29:
        String r15 = com.obric.assistant.chat.api.f.g(r6, null, 6);
        long r10 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        AppHost.Companion r11 = AppHost.a;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r11.getApplication().getFilesDir(), r10 + '_' + MessageIDLStub.access$queryDisplayName(this.this$0, this.$uri));
        if (MessageIDLStub.access$saveFileProviderUriToFile(this.this$0, r11.getApplication(), UriProtector.parse(this.$uri), r12) == true) goto L33;
        com.obric.assistant.chat.api.f.h(r15, this.$messageId, "semantic_uri_copy_failed", "copy semantic image uri failed", 16);
        MessageIDLStub.access$notifySemanticFail(this.this$0, this.$callback, "notifySemanticUserEditEventWithUri, save uri to file failed");
        return Unit.INSTANCE;
    L33:
        IWindowEffects r13 = (IWindowEffects) ServiceManager.get().getService(IWindowEffects.class);
        if (r13 == null) goto L36;
        r13.showScreenShotEffect();
    L36:
        int r14 = p1.a;
        Map<Object, Object> r16 = this.$ext;
        if (r16 == null) goto L39;
        Object r18 = r16.get("is_obric_continuous_talk");
    L41:
        if (Intrinsics.areEqual(r18, "1") == false) goto L49;
        a r19 = new a();
        Map r20 = r6.getExt();
        if (r20 == null) goto L47;
        Map r21 = MapsKt.toMutableMap(r20);
        if (r21 == null) goto L47;
        p1.a(r21);
        SemanticHelper r22 = SemanticHelper.a;
        SemanticHelper.a(r21);
    L48:
        Pair r23 = TuplesKt.to(r21, r19);
    L56:
        Map r24 = (Map) r23.component1();
        a r110 = (a) r23.component2();
        IObricChatService.a.getClass();
        IObricChatService r25 = IObricChatService.a.a();
        if (r25 == null) goto L67;
        ChatSender r26 = r25.getSender();
        if (r26 == null) goto L67;
        String r27 = MessageIDLStub.access$getPureTextAdaptBlock(this.this$0, r6);
        if (r27 != null) goto L64;
        r27 = NameKeys.UnloadStrategy_No_Strategy;
    L64:
        if (r24 != null) goto L66;
        r24 = new LinkedHashMap();
    L66:
        r26.a(r27, "obric_semantic", r24, r12, Scene.SCREEN_SEMANTIC, r110, r15);
    L67:
        SemanticHelper r28 = SemanticHelper.a;
        Intrinsics.checkNotNullParameter(r6, "message");
        IObricSemanticApi r29 = (IObricSemanticApi) ServiceManager.get().getService(IObricSemanticApi.class);
        if (r29 == null) goto L70;
        r29.a(r6);
    L70:
        MessageIDLStub r30 = this.this$0;
        ArrayList r111 = CollectionsKt.arrayListOf(new Message[]{r6});
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        r1 = MessageIDLStub.access$deleteMessage(r30, r5, true, false, r111, this);
        if (r1 != r7) goto L73;
        return r7;
    L47:
        r21 = null;
        goto L48
    L49:
        Map r31 = r6.getExt();
        if (r31 == null) goto L54;
        Map r32 = MapsKt.toMutableMap(r31);
        if (r32 == null) goto L54;
        SemanticHelper r33 = SemanticHelper.a;
        SemanticHelper.a(r32);
    L55:
        r23 = TuplesKt.to(r32, null);
    L54:
        r32 = null;
        goto L55
    L39:
        r18 = null;
        goto L41
    L11:
        ResultKt.throwOnFailure(r17);
        Object r34 = r17;
    L15:
        r6 = (Message) r34;
        if (r6 == null) goto L18;
        r5 = r6.getConversationId();
    L19:
        if (r6 == null) goto L75;
        if (r5 == null) goto L75;
        SemanticHelper r35 = SemanticHelper.a;
        this.L$0 = r6;
        this.L$1 = r5;
        this.label = 2;
        r8 = r35.c(r6, r5, this);
        if (r8 != r7) goto L26;
        return r7;
    L75:
        CoroutineScope r36 = com.obric.assistant.chat.api.f.a;
        String r37 = this.$messageId;
        if (r6 != null) goto L78;
        String r38 = "query_not_found";
    L79:
        if (r6 != null) goto L81;
        String r39 = "semantic query not found";
    L82:
        com.obric.assistant.chat.api.f.i(r37, r38, r39);
        MessageIDLStub.access$notifySemanticFail(this.this$0, this.$callback, "notifySemanticUserEditEventWithUri, message or conversationId not found");
        return Unit.INSTANCE;
    L81:
        r39 = "semantic query conversation id empty";
        goto L82
    L78:
        r38 = "conversation_id_empty";
        goto L79
    L18:
        r5 = null;
        goto L19
    L12:
        ResultKt.throwOnFailure(r17);
        MessageIDLStub r40 = this.this$0;
        String r41 = this.$messageId;
        this.label = 1;
        r34 = MessageIDLStub.access$getMessageById(r40, r41, this);
        if (r34 != r7) goto L15;
        return r7;
    }
}
