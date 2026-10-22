package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online.MarkdownTextViewWidgetHandler$setMarkdownClickSpanListener$1$7", f = "MarkdownTextViewWidgetHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownTextViewWidgetHandler$setMarkdownClickSpanListener$1$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ lw8.l $currentNodeContent;
    final /* synthetic */ Message $data;
    final /* synthetic */ by7.e $trackNode;
    int label;
    final /* synthetic */ k this$0;

    public MarkdownTextViewWidgetHandler$setMarkdownClickSpanListener$1$7(lw8.l r1, BotModel r2, k r3, Message r4, by7.e r5, Continuation<? super MarkdownTextViewWidgetHandler$setMarkdownClickSpanListener$1$7> r6) {
        this.$currentNodeContent = r1;
        this.$bot = r2;
        this.this$0 = r3;
        this.$data = r4;
        this.$trackNode = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MarkdownTextViewWidgetHandler$setMarkdownClickSpanListener$1$7(this.$currentNodeContent, this.$bot, this.this$0, this.$data, this.$trackNode, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r57) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L41;
        ResultKt.throwOnFailure(r57);
        lw8.l r1 = this.$currentNodeContent;
        if (r1 == null) goto L19;
        List r2 = r1.f();
        if (r2 == null) goto L19;
        BotModel r3 = this.$bot;
        k r4 = this.this$0;
        Message r5 = this.$data;
        by7.e r15 = this.$trackNode;
        Iterator r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L19;
        lw8.f r7 = (lw8.f) r6.next();
        ri8.c r8 = ri8.c.a;
        String r17 = String.valueOf(r7.getCode().hashCode());
        String r27 = r7.a();
        String r9 = r3.getBotId();
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        String r28 = r9;
        String r10 = r4.a.d.e;
        String r18 = r5.getMessageId();
        String r19 = r5.getConversationId();
        q0 r11 = r4.a.f;
        if (r11 == null) goto L17;
        LruSet<String> r16 = r11.E7();
    L18:
        ri8.c.n(r16, r17, r18, r19, null, "chat", null, null, null, null, null, r27, r28, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r10, null, null, null, null, null, null, null, null, -536877104, 63);
        ChatParam r12 = r4.a.d;
        String r13 = r12.e;
        String r14 = r12.c;
        String r110 = r3.getBotId();
        String r111 = r5.getConversationId();
        String r112 = r5.getMessageId();
        String r113 = r5.getSectionId();
        String r114 = r7.a();
        by7.e r115 = r15;
        tx9.q.a("copy", "chat", r14, r13, r110, r111, r112, "answer", r113, Boxing.boxLong(1), r114, new JSONObject(), r115);
        r15 = r115;
        goto L10
    L17:
        r16 = null;
    L19:
        lw8.l r20 = this.$currentNodeContent;
        if (r20 == null) goto L39;
        List r21 = r20.c();
        if (r21 == null) goto L39;
        k r22 = this.this$0;
        Message r23 = this.$data;
        BotModel r24 = this.$bot;
        Iterator r25 = r21.iterator();
    L25:
        if (r25.hasNext() == false) goto L39;
        lw8.g r26 = (lw8.g) r25.next();
        k.a r29 = k.e(r22, r26);
        String r30 = r22.a.d.d;
        if (r30 != null) goto L29;
    L36:
        r30 = "chat";
    L37:
        String r31 = r30;
        String r116 = r22.a.d.c;
        String r117 = r23.getMessageId();
        String r118 = r23.getConversationId();
        String r119 = r24.getBotId();
        String r120 = r22.a.d.e;
        String r121 = r23.getReplyId();
        String r122 = r26.a();
        String r32 = r29.a;
        String r33 = r29.e;
        String r34 = r29.b;
        String r0 = r29.d;
        String r35 = r29.c;
        x1.c(r31, r116, r117, r118, r119, r120, r121, r122, r32, r33, r34, r0, com.larus.bmhome.chat.bean.d.u(r23), r35);
        goto L25
    L29:
        if (r30.length() <= 0) goto L31;
        boolean r36 = true;
    L32:
        if (r36 == true) goto L35;
        r30 = null;
    L35:
        if (r30 != null) goto L37;
    L31:
        r36 = false;
    L39:
        return Unit.INSTANCE;
    L41:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
