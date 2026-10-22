package com.obric.aiagent.messenger.stub;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.api.a$a;
import com.obric.assistant.chat.impl.MessageApiImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$notifySemanticUserEditEvent$1", f = "MessageIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$notifySemanticUserEditEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowSemanticEditCallbackIDL $callback;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ String a;
        public final /* synthetic */ MessageIDLStub b;
        public final /* synthetic */ IFlowSemanticEditCallbackIDL c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.i("IFlowMessageIDLSPI", "notifySemanticUserEditEvent, getMessageById error: " + r4);
            CoroutineScope r5 = com.obric.assistant.chat.api.f.a;
            com.obric.assistant.chat.api.f.i(this.a, "query_not_found", "semantic query not found");
            MessageIDLStub.access$notifySemanticFail(this.b, this.c, "notifySemanticUserEditEvent, getMessageById failed");
        }

        public final void onSuccess(Object r11) {
            Message r12 = (Message) r11;
            Intrinsics.checkNotNullParameter(r12, "result");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("notifySemanticUserEditEvent, getMessageById success, msgId=");
            String r2 = r12.getMessageId();
            String r3 = NameKeys.UnloadStrategy_No_Strategy;
            if (r2 != null) goto L5;
            r2 = NameKeys.UnloadStrategy_No_Strategy;
        L5:
            r1.append(r2);
            r1.append(", localMsgId=");
            String r4 = r12.getLocalMessageId();
            if (r4 != null) goto L8;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L8:
            r1.append(r4);
            r1.append(", cvsId=");
            String r5 = r12.getConversationId();
            if (r5 != null) goto L11;
            r5 = NameKeys.UnloadStrategy_No_Strategy;
        L11:
            r1.append(r5);
            r0.i("IFlowMessageIDLSPI", r1.toString());
            String r6 = r12.getConversationId();
            if (r6 != null) goto L14;
            CoroutineScope r13 = com.obric.assistant.chat.api.f.a;
            com.obric.assistant.chat.api.f.i(this.a, "conversation_id_empty", "semantic query conversation id empty");
            MessageIDLStub.access$notifySemanticFail(this.b, this.c, "notifySemanticUserEditEvent, conversationId is null");
            return;
        L14:
            IObricChatService.a.getClass();
            IObricChatService r7 = IObricChatService.a.a();
            a$a r8 = null;
            if (r7 == null) goto L17;
            r7.g();
            Message r9 = MessageApiImpl.a.j(r6);
        L18:
            if (r9 == null) goto L21;
            String r10 = r9.getLocalMessageId();
            if (r10 == null) goto L21;
        L22:
            if (r9 == null) goto L27;
            String r14 = r9.getMessageId();
            if (r14 == null) goto L27;
            r3 = r14;
        L27:
            r0.i("IFlowMessageIDLSPI", "notifySemanticUserEditEvent, compare result to latestSendMessageInMainBot, msgId: (" + r3 + ", " + r12.getMessageId() + "), localMsgId: (" + r10 + ", " + r12.getLocalMessageId() + ')');
            if (com.larus.utils.o0.d(r12.getMessageId()) == false) goto L32;
            if (Intrinsics.areEqual(r3, r12.getMessageId()) == false) goto L32;
        L35:
            IObricChatService r15 = IObricChatService.a.a();
            if (r15 == null) goto L38;
            r15.g();
            r8 = MessageApiImpl.a.d(r6);
        L38:
            a$a r16 = r8;
            StringBuilder r17 = new StringBuilder("notifySemanticUserEditEvent, getScreenPicInfo success: ");
            if (r16 == null) goto L41;
            boolean r18 = true;
        L42:
            r17.append(r18);
            r0.i("IFlowMessageIDLSPI", r17.toString());
            IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r6, false, true, OmniBreakReason.OmniBreakReason_EDIT_MSG, 2);
            IObricChatService r19 = IObricChatService.a.a();
            if (r19 == null) goto L45;
            r19.g();
            MessageApiImpl.a.b(r12, r12.getContent(), r12.getExt(), r16);
        L45:
            MessageIDLStub.access$notifySemanticSuccess(this.b, this.c);
            return;
        L41:
            r18 = false;
        L32:
            if (com.larus.utils.o0.d(r12.getLocalMessageId()) == true) goto L34;
        L46:
            CoroutineScope r110 = com.obric.assistant.chat.api.f.a;
            com.obric.assistant.chat.api.f.i(this.a, "semantic_not_latest_query", "semantic query is not latest send message");
            MessageIDLStub.access$notifySemanticFail(this.b, this.c, "notifySemanticUserEditEvent, not latest send message, skip");
            return;
        L34:
            if (Intrinsics.areEqual(r10, r12.getLocalMessageId()) == false) goto L46;
        L21:
            r10 = NameKeys.UnloadStrategy_No_Strategy;
            goto L22
        L17:
            r9 = null;
            goto L18
        }

        public a(String r1, MessageIDLStub r2, IFlowSemanticEditCallbackIDL r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public MessageIDLStub$notifySemanticUserEditEvent$1(String r1, MessageIDLStub r2, IFlowSemanticEditCallbackIDL r3, Continuation<? super MessageIDLStub$notifySemanticUserEditEvent$1> r4) {
        this.$messageId = r1;
        this.this$0 = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageIDLStub$notifySemanticUserEditEvent$1(this.$messageId, this.this$0, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        NativeMessageServiceImpl r6 = com.larus.im.d.e();
        String r0 = this.$messageId;
        r6.m(r0, new a(r0, this.this$0, this.$callback));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
