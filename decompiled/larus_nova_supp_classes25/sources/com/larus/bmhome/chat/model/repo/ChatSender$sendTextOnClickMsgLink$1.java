package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$sendTextOnClickMsgLink$1", f = "ChatSender.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
final class ChatSender$sendTextOnClickMsgLink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ String $content;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ boolean $interruptTts;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$sendTextOnClickMsgLink$1(ChatSender r1, String r2, String r3, String r4, Map<String, String> r5, boolean r6, ChatPageContext r7, Continuation<? super ChatSender$sendTextOnClickMsgLink$1> r8) {
        this.this$0 = r1;
        this.$content = r2;
        this.$cvsId = r3;
        this.$scene = r4;
        this.$extras = r5;
        this.$interruptTts = r6;
        this.$chatPageContext = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatSender$sendTextOnClickMsgLink$1(this.this$0, this.$content, this.$cvsId, this.$scene, this.$extras, this.$interruptTts, this.$chatPageContext, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        int r1 = wf9.b.a;
        String r2 = com.flow.kmp.common.util.i.a();
        ChatSender r3 = this.this$0;
        String r4 = this.$content;
        String r5 = this.$cvsId;
        String r6 = this.$scene;
        Map<String, String> r7 = this.$extras;
        boolean r8 = this.$interruptTts;
        ChatPageContext r14 = this.$chatPageContext;
        if (r14 != null) goto L11;
    L13:
        r14 = null;
    L14:
        this.label = 1;
        if (ChatSender.L(r3, r2, r4, r5, r6, null, r7, r8, null, null, false, null, "sendTextOnClickMsgLink", r14, null, this, 10112) != r13) goto L18;
        return r13;
    L11:
        if (r14.isNotEmpty() == false) goto L13;
        goto L13
    }
}
