package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$resendFileAndTxt$3", f = "ChatSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$resendFileAndTxt$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ List<Message> $messageList;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $traceScene;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$resendFileAndTxt$3(ChatPageContext r1, List<Message> r2, ChatSender r3, String r4, String r5, String r6, wc9.e r7, Continuation<? super ChatSender$resendFileAndTxt$3> r8) {
        this.$chatPageContext = r1;
        this.$messageList = r2;
        this.this$0 = r3;
        this.$cvsId = r4;
        this.$traceScene = r5;
        this.$scene = r6;
        this.$conversation = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatSender$resendFileAndTxt$3(this.$chatPageContext, this.$messageList, this.this$0, this.$cvsId, this.$traceScene, this.$scene, this.$conversation, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L49;
        ResultKt.throwOnFailure(r20);
        ChatPageContext r1 = this.$chatPageContext;
        String r2 = null;
        if (r1 != null) goto L7;
    L9:
        r1 = null;
    L10:
        String r3 = UUID.randomUUID().toString();
        Iterator<T> r4 = this.$messageList.iterator();
    L11:
        int r12 = 0;
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();
        if (((Message) r5).getContentType() != 1) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L11;
    L20:
        Message r7 = (Message) r5;
        if (r7 == null) goto L23;
        r2 = r7.getMessageId();
    L23:
        List<Message> r14 = this.$messageList;
        String r15 = this.$scene;
        wc9.e r11 = this.$conversation;
        ArrayList r10 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L25:
        if (r16.hasNext() == false) goto L46;
        Message r8 = (Message) r16.next();
        ChatSendUtils.a.getClass();
        Map r9 = MapsKt.toMutableMap(ChatSendUtils.p(new Pair[r12]));
        if (Intrinsics.areEqual(r15, "nested_file_parse_regen") == false) goto L29;
        String r13 = (String) r9.put("parse_retry", "1");
    L37:
        if (r14.size() <= 1) goto L40;
        r9.put("collection_id", r3);
    L40:
        if (r11.i == false) goto L42;
        r9.put("tts", "1");
    L42:
        Pair[] r17 = new Pair[1];
        r17[r12] = TuplesKt.to("send_loading", "1");
        Map r18 = MapsKt.mutableMapOf(r17);
        com.larus.bmhome.chat.model.strategy.block.d0 r19 = com.larus.bmhome.chat.model.strategy.block.d0.a;
        int r110 = wf9.b.a;
        String r111 = com.flow.kmp.common.util.i.a();
        r19.getClass();
        ArrayList r112 = r10;
        wc9.e r113 = r11;
        ic8.w r21 = com.larus.bmhome.chat.model.strategy.block.d0.p(r8, false, false, null, r111, r9, r18, r1);
        if (r21 == null) goto L45;
        r112.add(r21);
    L45:
        r10 = r112;
        r11 = r113;
        r12 = 0;
        goto L25
    L29:
        r9.put("regen_resend", r15);
        if (r2 != null) goto L34;
        String r22 = r8.getMessageId();
        if (r22 != null) goto L35;
        r22 = "";
    L35:
        String r23 = (String) r9.put("regen_resend_previous_id", r22);
        goto L37
    L34:
        r22 = r2;
        goto L35
    L46:
        u1$a.a(this.this$0, this.$cvsId, r10, this.$traceScene, "resendFileAndTxt");
        return Unit.INSTANCE;
    L16:
        r6 = false;
        goto L17
    L19:
        r5 = null;
        goto L20
    L7:
        if (r1.isNotEmpty() == false) goto L9;
    L49:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
