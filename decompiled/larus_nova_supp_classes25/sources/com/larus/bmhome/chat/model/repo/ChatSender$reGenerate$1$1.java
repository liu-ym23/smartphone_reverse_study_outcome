package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$reGenerate$1$1", f = "ChatSender.kt", i = {1, 1}, l = {528, 547}, m = "invokeSuspend", n = {"questionMsg", "resolvedChatPageContext"}, s = {"L$0", "L$1"})
public final class ChatSender$reGenerate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $answer;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ String $regenInstruction;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatSender this$0;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ CompletableDeferred<Message> a;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public a(CompletableDeferred<Message> r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.complete(null);
        }

        public final void onSuccess(Object r2) {
            Message r3 = (Message) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.complete(r3);
        }
    }

    public ChatSender$reGenerate$1$1(Message r1, ChatPageContext r2, String r3, ChatSender r4, String r5, Continuation<? super ChatSender$reGenerate$1$1> r6) {
        this.$answer = r1;
        this.$chatPageContext = r2;
        this.$cvsId = r3;
        this.this$0 = r4;
        this.$regenInstruction = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatSender$reGenerate$1$1(this.$answer, this.$chatPageContext, this.$cvsId, this.this$0, this.$regenInstruction, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r5 = null;
        boolean r6 = true;
        String r7 = "";
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ChatPageContext r3 = (ChatPageContext) this.L$1;
        Message r4 = (Message) this.L$0;
        ResultKt.throwOnFailure(r28);
        Object r8 = r28;
        ChatPageContext r13 = r3;
        Message r11 = r4;
    L72:
        wc9.e r9 = (wc9.e) r8;
        if (r9 == null) goto L86;
        Message r10 = this.$answer;
        String r12 = this.$cvsId;
        ChatSender r14 = this.this$0;
        String r15 = this.$regenInstruction;
        if (r9.h() == false) goto L82;
        yp9.d r16 = yp9.d.b;
        StringBuilder r17 = new StringBuilder();
        String r18 = r10.getMessageId();
        if (r18 == null) goto L80;
        r7 = r18;
    L80:
        r17.append(r7);
        r17.append(' ');
        r17.append(r12);
        r17.append(" conversation is disabled. Abort");
        r16.a("reGenerate", r17.toString());
        goto L86
    L82:
        if (com.larus.im.bean.message.a.c0(r10) == false) goto L84;
        int r19 = ChatSender.j;
        r14.A().o(r9, r10, r11, r15, r13);
        goto L86
    L84:
        int r20 = ChatSender.j;
        r14.D().l(r9, r10, r11, r15, r13);
    L86:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r28);
        Object r21 = r28;
    L19:
        Message r22 = (Message) r21;
        ChatPageContext r23 = this.$chatPageContext;
        if (r23 != null) goto L22;
    L24:
        r23 = null;
    L26:
        if (r22 == null) goto L36;
        String r110 = r22.getLocalMessageId();
        if (r110 == null) goto L36;
        if (r110.length() <= 0) goto L32;
        boolean r111 = true;
    L33:
        if (r111 == false) goto L35;
        r5 = r110;
    L35:
        if (r5 == null) goto L36;
    L39:
        String r112 = r5;
    L41:
        if (r112.length() > 0) goto L44;
        r6 = false;
    L44:
        if (r6 == false) goto L46;
        com.larus.bmhome.chat.trace.appreciable.f.l(com.larus.bmhome.chat.trace.appreciable.f.a, r112, this.$cvsId, "regen", this.$answer.getContentType(), null, null, null, null, 240);
    L46:
        if (r22 == null) goto L68;
        com.larus.bmhome.chat.trace.appreciable.y.c(r22);
        com.larus.bmhome.chat.trace.appreciable.f r24 = com.larus.bmhome.chat.trace.appreciable.f.a;
        String r25 = r22.getLocalMessageId();
        if (r25 != null) goto L50;
        r25 = "";
    L50:
        int r26 = this.$answer.getContentType();
        String r113 = this.$answer.getContent();
        com.larus.bmhome.instruction.c r114 = com.larus.bmhome.instruction.c.a;
        String r115 = this.$answer.getSenderId();
        if (r115 != null) goto L53;
        r115 = "";
    L53:
        ModelItemIdentity r116 = r114.a(r115, ActiveSwitchType.DEEPTHINK.getValue()).getModel();
        r24.getClass();
        com.larus.bmhome.chat.trace.appreciable.f.h(r25, r26, r113, "reGenerate", r116);
        String r27 = r22.getLocalMessageId();
        if (r27 != null) goto L56;
        String r29 = "";
    L57:
        String r30 = r22.getMessageId();
        if (r30 != null) goto L60;
        String r210 = "";
    L61:
        com.larus.bmhome.chat.trace.appreciable.f.f(r24, r29, r210, this.$answer.getContentType(), null, null, 16);
        String r31 = r22.getLocalMessageId();
        if (r31 != null) goto L64;
        r31 = "";
    L64:
        com.larus.bmhome.chat.trace.appreciable.f.j(r31, this.$answer.getContentType());
        ChatMessageCostTrace r32 = ChatMessageCostTrace.a;
        String r33 = r22.getLocalMessageId();
        if (r33 != null) goto L67;
        r33 = "";
    L67:
        int r117 = this.$answer.getContentType();
        r32.getClass();
        ChatMessageCostTrace.f(r33, r117);
        ObricChatSPIServiceDelegate.b.b(r22);
        goto L68
    L60:
        r210 = r30;
        goto L61
    L56:
        r29 = r27;
    L68:
        this.this$0.a.d.d.i6("reGenerate", false);
        ChatSender r34 = this.this$0;
        String r35 = this.$cvsId;
        this.L$0 = r22;
        this.L$1 = r23;
        this.label = 2;
        r8 = ChatSender.y(r34, r35, this);
        if (r8 != r1) goto L71;
        return r1;
    L71:
        r11 = r22;
        r13 = r23;
        goto L72
    L32:
        r111 = false;
    L36:
        r5 = this.$answer.getReplyId();
        if (r5 != null) goto L39;
        r112 = "";
        goto L41
    L22:
        if (r23.isNotEmpty() == false) goto L24;
    L10:
        ResultKt.throwOnFailure(r28);
        ChatControlTrace r36 = ChatControlTrace.b;
        String r37 = this.$answer.getMessageId();
        if (r37 != null) goto L13;
        r37 = "";
    L13:
        r36.Ma(r37, "regen");
        com.larus.bmhome.chat.trace.appreciable.f r38 = com.larus.bmhome.chat.trace.appreciable.f.a;
        Message r39 = this.$answer;
        r38.getClass();
        Intrinsics.checkNotNullParameter(r39, "msg");
        HashSet r40 = com.larus.bmhome.chat.trace.appreciable.f.b;
        TypeIntrinsics.asMutableCollection(r40).remove(r39.getMessageId());
        HashSet r41 = com.larus.bmhome.chat.trace.appreciable.f.c;
        TypeIntrinsics.asMutableCollection(r41).remove(r39.getMessageId());
        CompletableDeferred r42 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        NativeMessageServiceImpl r43 = com.larus.im.d.e();
        String r44 = this.$answer.getReplyId();
        if (r44 != null) goto L16;
        r44 = "";
    L16:
        r43.m(r44, new a(r42));
        this.label = 1;
        r21 = r42.await(this);
        if (r21 != r1) goto L19;
        return r1;
    }
}
