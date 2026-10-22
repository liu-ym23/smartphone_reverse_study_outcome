package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.im.bean.message.Message;
import java.util.Map;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$resendFileOrImg$1", f = "ChatSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$resendFileOrImg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $traceScene;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$resendFileOrImg$1(ChatPageContext r1, wc9.e r2, Message r3, ChatSender r4, String r5, String r6, Continuation<? super ChatSender$resendFileOrImg$1> r7) {
        this.$chatPageContext = r1;
        this.$conversation = r2;
        this.$message = r3;
        this.this$0 = r4;
        this.$traceScene = r5;
        this.$scene = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatSender$resendFileOrImg$1(this.$chatPageContext, this.$conversation, this.$message, this.this$0, this.$traceScene, this.$scene, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r22);
        ChatPageContext r1 = this.$chatPageContext;
        String r2 = null;
        if (r1 != null) goto L7;
    L9:
        ChatPageContext r11 = null;
    L10:
        ChatSendUtils r3 = ChatSendUtils.a;
        Pair[] r4 = new Pair[1];
        wc9.e r5 = this.$conversation;
        if (r5 != null) goto L13;
    L15:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L19;
        Object r7 = "1";
    L20:
        r4[0] = TuplesKt.to("tts", r7);
        r3.getClass();
        Map r9 = MapsKt.toMutableMap(ChatSendUtils.p(r4));
        String r8 = this.$scene;
        Message r10 = this.$message;
        if (Intrinsics.areEqual(r8, "nested_file_parse_regen") == false) goto L23;
        String r12 = (String) r9.put("parse_retry", "1");
    L27:
        Map r13 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("send_loading", "1"), TuplesKt.to("loading", "0"), TuplesKt.to("progress", "0")});
        com.larus.bmhome.chat.model.strategy.block.d0 r14 = com.larus.bmhome.chat.model.strategy.block.d0.a;
        Message r15 = this.$message;
        int r16 = wf9.b.a;
        String r17 = com.flow.kmp.common.util.i.a();
        r14.getClass();
        ic8.w r18 = com.larus.bmhome.chat.model.strategy.block.d0.p(r15, false, false, null, r17, r9, r13, r11);
        if (r18 == null) goto L36;
        ChatSender r19 = this.this$0;
        wc9.e r20 = this.$conversation;
        if (r20 == null) goto L32;
        r2 = r20.a;
    L32:
        if (r2 != null) goto L34;
        r2 = "";
    L34:
        String r110 = this.$traceScene;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r18, "strategy");
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter("resendFileOrImg", "sendFuncChannel");
        BuildersKt.launch$default(r19.b, null, null, new ChatSender$sendMessage$1(r18, r110, r2, r19, null, "resendFileOrImg", null), 3, null);
    L36:
        return Unit.INSTANCE;
    L23:
        r9.put("regen_resend", r8);
        String r21 = r10.getMessageId();
        if (r21 != null) goto L26;
        r21 = "";
    L26:
        String r23 = (String) r9.put("regen_resend_previous_id", r21);
        goto L27
    L19:
        r7 = "0";
        goto L20
    L13:
        if (r5.i != true) goto L15;
        r6 = true;
        goto L17
    L7:
        if (r1.isNotEmpty() == false) goto L9;
        r11 = r1;
        goto L10
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
