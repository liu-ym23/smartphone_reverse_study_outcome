package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.IMCmd;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatReceiver$subscribeCmdTypeAudioTTSTrace$1", f = "ChatReceiver.kt", i = {}, l = {426}, m = "invokeSuspend", n = {}, s = {})
final class ChatReceiver$subscribeCmdTypeAudioTTSTrace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMCmd $cmd;
    final /* synthetic */ Ref.ObjectRef<String> $localSendMsgId;
    final /* synthetic */ JSONObject $params;
    final /* synthetic */ String $sendMsgId;
    int label;
    final /* synthetic */ n0 this$0;

    public ChatReceiver$subscribeCmdTypeAudioTTSTrace$1(Ref.ObjectRef<String> r1, String r2, n0 r3, IMCmd r4, JSONObject r5, Continuation<? super ChatReceiver$subscribeCmdTypeAudioTTSTrace$1> r6) {
        this.$localSendMsgId = r1;
        this.$sendMsgId = r2;
        this.this$0 = r3;
        this.$cmd = r4;
        this.$params = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatReceiver$subscribeCmdTypeAudioTTSTrace$1(this.$localSendMsgId, this.$sendMsgId, this.this$0, this.$cmd, this.$params, r9);
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
    L19:
        Message r5 = (Message) r4;
        Ref.ObjectRef<String> r2 = this.$localSendMsgId;
        if (r5 == null) goto L26;
        String r6 = r5.getLocalMessageId();
        if (r6 == null) goto L26;
        r2.element = r6;
    L27:
        n0 r7 = this.this$0;
        int r3 = n0.g;
        r7.getClass();
        n0.d().g(this.$cmd.getMessageId(), (String) this.$localSendMsgId.element);
        m58.u r8 = m58.h.l;
        if (r8 == null) goto L30;
        r8.f((String) this.$localSendMsgId.element, "tts_subscribe_cmd_to_chat_first_pkg", this.$params);
    L30:
        m58.u r9 = m58.h.l;
        if (r9 == null) goto L34;
        r9.f((String) this.$localSendMsgId.element, "tts_subscribe_cmd_to_session_finish", this.$params);
    L34:
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        CharSequence r10 = (CharSequence) this.$localSendMsgId.element;
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == false) goto L27;
        RepoDispatcher.a.getClass();
        ChatRepo r12 = RepoDispatcher.d;
        String r13 = this.$sendMsgId;
        this.label = 1;
        r4 = r12.E1(r13, this);
        if (r4 != r0) goto L19;
        return r0;
    L11:
        if (r10.length() == 0) goto L14;
        r11 = false;
        goto L15
    }
}
