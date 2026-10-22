package com.larus.bmhome.chat.component.trace;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import bd8.d;
import by7.e;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.list.base.MessageCellHolder;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.list.arch.IFlowListCell;
import com.larus.platform.service.AccountService;
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
import org.json.JSONObject;
import s1a.a;
import tx9.h3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.trace.ChatScreenRecordTraceComponent$doMobScreenshotAsync$1", f = "ChatScreenRecordTraceComponent.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
final class ChatScreenRecordTraceComponent$doMobScreenshotAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $isLastMessage;
    final /* synthetic */ Message $message;
    final /* synthetic */ int $position;
    final /* synthetic */ String $shotId;
    int label;
    final /* synthetic */ ChatScreenRecordTraceComponent this$0;

    public ChatScreenRecordTraceComponent$doMobScreenshotAsync$1(Message r1, ChatScreenRecordTraceComponent r2, String r3, int r4, int r5, Continuation<? super ChatScreenRecordTraceComponent$doMobScreenshotAsync$1> r6) {
        this.$message = r1;
        this.this$0 = r2;
        this.$shotId = r3;
        this.$isLastMessage = r4;
        this.$position = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatScreenRecordTraceComponent$doMobScreenshotAsync$1(this.$message, this.this$0, this.$shotId, this.$isLastMessage, this.$position, r9);
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
        e r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r3 = r19;
    L11:
        String r5 = (String) r3;
        if (Intrinsics.areEqual(r5, "reply_completed") == false) goto L14;
        r5 = "others";
    L14:
        String r12 = r5;
        String r6 = this.$message.getMessageId();
        String r7 = this.$message.getReplyId();
        String r8 = this.$message.getConversationId();
        com.larus.bmhome.chat.component.cvs.y r9 = (com.larus.bmhome.chat.component.cvs.y) this.this$0.i.getValue();
        if (r9 == null) goto L17;
        String r10 = r9.getBotId();
    L18:
        ChatScreenRecordTraceComponent r11 = this.this$0;
        r11.getClass();
        ChatControlTrace r13 = ChatControlTrace.b;
        com.larus.bmhome.chat.component.cvs.y r14 = (com.larus.bmhome.chat.component.cvs.y) r11.i.getValue();
        if (r14 == null) goto L21;
        wc9.e r15 = r14.h();
    L22:
        if (r15 == null) goto L24;
        Integer r16 = r15.v;
    L25:
        com.larus.bmhome.chat.component.cvs.y r17 = (com.larus.bmhome.chat.component.cvs.y) r11.i.getValue();
        if (r17 == null) goto L28;
        BotModel r18 = r17.j0();
    L29:
        if (r18 == null) goto L31;
        Integer r20 = r18.getBotType();
    L32:
        com.larus.bmhome.chat.component.cvs.y r21 = (com.larus.bmhome.chat.component.cvs.y) r11.i.getValue();
        if (r21 == null) goto L35;
        BotModel r22 = r21.j0();
    L36:
        if (r22 == null) goto L40;
        BotCreatorInfo r23 = r22.getBotCreatorInfo();
        if (r23 == null) goto L40;
        String r24 = r23.getId();
    L41:
        String r25 = r13.g(r16, r20, Intrinsics.areEqual(r24, AccountService.a.getUserId()));
        String r110 = this.$shotId;
        Integer r111 = Boxing.boxInt(this.$isLastMessage);
        ChatScreenRecordTraceComponent r26 = this.this$0;
        Message r27 = this.$message;
        int r28 = this.$position;
        r26.getClass();
        RecyclerView r29 = r26.Xw();     // Catch: Exception -> L65
        if (r29 == null) goto L45;
        RecyclerView.ViewHolder r30 = r29.findViewHolderForAdapterPosition(r28);     // Catch: Exception -> L65
    L47:
        if ((r30 instanceof MessageCellHolder) == false) goto L49;
        MessageCellHolder r31 = (MessageCellHolder) r30;     // Catch: Exception -> L65
    L50:
        if (r31 == null) goto L52;
        IFlowListCell r32 = ((FlowListViewHolder) r31).b;     // Catch: Exception -> L65
    L54:
        if ((r32 instanceof BaseCompositeTextCell) == false) goto L56;
        BaseCompositeTextCell r33 = (BaseCompositeTextCell) r32;     // Catch: Exception -> L65
    L57:
        if (r33 == null) goto L63;
        d r34 = (d) r33.s(d.class);     // Catch: Exception -> L65
        if (r34 == null) goto L63;
        JSONObject r35 = r34.m(r27);     // Catch: Exception -> L65
        if (r35 == null) goto L63;
    L66:
        JSONObject r112 = r35;
        Fragment r36 = a.c(this.this$0);
        if ((r36 instanceof e) == false) goto L69;
        r4 = (e) r36;
    L69:
        h3.a(r6, r7, r8, r10, r25, r110, r111, r12, "chat", null, r112, r4, 512);
        return Unit.INSTANCE;
    L63:
        r35 = new JSONObject();     // Catch: Exception -> L65
        goto L66
    L56:
        r33 = null;
        goto L57
    L52:
        r32 = null;
        goto L54
    L49:
        r31 = null;
        goto L50
    L45:
        r30 = null;
    L65:
        r35 = new JSONObject();
    L40:
        r24 = null;
        goto L41
    L35:
        r22 = null;
        goto L36
    L31:
        r20 = null;
        goto L32
    L28:
        r18 = null;
        goto L29
    L24:
        r16 = null;
        goto L25
    L21:
        r15 = null;
        goto L22
    L17:
        r10 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        ChatControlTrace r37 = ChatControlTrace.b;
        Message r38 = this.$message;
        this.label = 1;
        r3 = r37.w(r38, null, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
