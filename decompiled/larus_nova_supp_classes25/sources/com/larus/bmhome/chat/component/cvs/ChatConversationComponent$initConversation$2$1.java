package com.larus.bmhome.chat.component.cvs;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatDoubleTabFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$initConversation$2$1", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$initConversation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newCvsId;
    int label;
    final /* synthetic */ ChatConversationComponent this$0;

    public ChatConversationComponent$initConversation$2$1(ChatConversationComponent r1, String r2, Continuation<? super ChatConversationComponent$initConversation$2$1> r3) {
        this.this$0 = r1;
        this.$newCvsId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatConversationComponent$initConversation$2$1(this.this$0, this.$newCvsId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r5);
        ChatConversationComponent r6 = this.this$0;
        int r0 = ChatConversationComponent.r;
        de8.c r7 = r6.f1();
        int r1 = 1;
        boolean r2 = false;
        if (r7 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == true) goto L30;
        if (com.larus.bmhome.b0.b(s1a.a.c(this.this$0)) == false) goto L30;
        if (this.$newCvsId.length() <= 0) goto L16;
        r2 = true;
    L16:
        if (r2 == false) goto L30;
        FLogger.a.i("ChatConversationComponent", "selectSideBarConversation after create " + this.$newCvsId);
        Fragment r9 = s1a.a.c(this.this$0).getParentFragment();
        if ((r9 instanceof ChatImmersFragment) == false) goto L21;
        r1 = 8;
    L26:
        com.larus.bmhome.a0 r10 = com.larus.bmhome.b0.a(s1a.a.c(this.this$0));
        if (r10 == null) goto L30;
        r10.J90(r1, null, this.$newCvsId, "chat_conversation");
        goto L30
    L21:
        if ((r9 instanceof ChatDoubleTabFragment) == false) goto L24;
        r1 = 10;
        goto L26
    L24:
        if ((r9 instanceof ci8.d) == false) goto L26;
        r1 = 15;
    L30:
        return Unit.INSTANCE;
    L7:
        if (r7.o == true) goto L9;
        r8 = true;
        goto L10
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
