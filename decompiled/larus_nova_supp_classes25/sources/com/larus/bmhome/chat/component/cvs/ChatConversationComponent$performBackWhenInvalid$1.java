package com.larus.bmhome.chat.component.cvs;

import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import gd8.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$performBackWhenInvalid$1", f = "ChatConversationComponent.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$performBackWhenInvalid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $delete;
    final /* synthetic */ String $expectedConversationId;
    final /* synthetic */ String $expectedSecUserId;
    int label;
    final /* synthetic */ ChatConversationComponent this$0;

    public ChatConversationComponent$performBackWhenInvalid$1(ChatConversationComponent r1, String r2, boolean r3, String r4, Continuation<? super ChatConversationComponent$performBackWhenInvalid$1> r5) {
        this.this$0 = r1;
        this.$expectedConversationId = r2;
        this.$delete = r3;
        this.$expectedSecUserId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatConversationComponent$performBackWhenInvalid$1(this.this$0, this.$expectedConversationId, this.$delete, this.$expectedSecUserId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        e r7 = (e) r6;
        if (s1a.a.c(this.this$0).isAdded() == false) goto L61;
        if (s1a.a.c(this.this$0).isDetached() == true) goto L61;
        if (s1a.a.c(this.this$0).isRemoving() == true) goto L61;
        ChatConversationComponent r2 = this.this$0;
        int r3 = ChatConversationComponent.r;
        if (Intrinsics.areEqual(r2.F2().getState().getConversationId(), this.$expectedConversationId) == false) goto L61;
        e r4 = (e) AuthModelDelegate.b.y().getValue();
        if (com.larus.platform.exp.o.a() == false) goto L58;
        if (r4 == null) goto L28;
        String r5 = r4.a;
        if (r5 == null) goto L28;
        if ((!StringsKt.isBlank(r5)) != true) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == true) goto L58;
        if (r7 == null) goto L33;
        String r9 = r7.a;
    L34:
        if (r9 != null) goto L37;
        r9 = "";
    L37:
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), this.$expectedSecUserId) == true) goto L39;
    L43:
        FLogger.a.i("ChatConversationComponent", "local main bot conversation unavailable, performBack");
        com.larus.bmhome.chat.component.immerse.a r10 = s1a.a.g(s1a.a.c(this.this$0)).getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        if (r10 == null) goto L46;
        ChatImmersFragment r11 = r10.Z5();
    L48:
        if ((r11 instanceof ChatImmersFragment) == true) goto L51;
        r11 = null;
    L51:
        if (r11 == null) goto L53;
        r11.D = true;
    L53:
        f r12 = (f) s1a.a.g(s1a.a.c(this.this$0)).getAbility(f.class);
        if (r12 == null) goto L57;
        r12.N9(null);
    L57:
        return Unit.INSTANCE;
    L46:
        r11 = null;
        goto L48
    L39:
        if (StringsKt.isBlank(r9) == true) goto L43;
        FLogger.a.i("ChatConversationComponent", "redirect to local main bot conversation");
        com.bytedance.router.i r13 = SmartRouter.buildRoute(this.this$0.getContext(), "//flow/chat_page");
        r13.c.putExtra("argConversationId", r9);
        r13.c.putExtra("is_create_sub_conversation", true);
        r13.d();
        return Unit.INSTANCE;
    L33:
        r9 = null;
    L28:
        r8 = false;
    L58:
        this.this$0.P2(this.$delete);
        return Unit.INSTANCE;
    L61:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r14 = Dispatchers.getIO();
        ChatConversationComponent$performBackWhenInvalid$1$localConversation$1 r15 = new ChatConversationComponent$performBackWhenInvalid$1$localConversation$1(this.$expectedSecUserId, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r14, r15, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
