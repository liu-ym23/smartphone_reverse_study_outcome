package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.cvs.ChatConversationVM;
import com.larus.bmhome.chat.component.cvs.ChatConversationVMState;
import com.larus.bmhome.chat.f5;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Lazy;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.TemplateTabRepo$updateRuleForTemplateLastTab$1", f = "TemplateTabRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TemplateTabRepo$updateRuleForTemplateLastTab$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatConversationVM $chatConversationVM;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.repo.TemplateTabRepo$updateRuleForTemplateLastTab$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/chat/component/cvs/ChatConversationVMState;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.repo.TemplateTabRepo$updateRuleForTemplateLastTab$1$1", f = "TemplateTabRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ChatConversationVMState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.L$0 = r2;
            return r0;
        }

        public final Object invoke(ChatConversationVMState r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ChatConversationVMState) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r2);
            ChatConversationVMState r3 = (ChatConversationVMState) this.L$0;
            int r0 = f5.a;
            BotModel r4 = r3.getBot();
            if (r4 == null) goto L9;
            ConversationPage r5 = r4.getConversationPage();
            if (r5 == null) goto L9;
            Integer r6 = r5.getDefaultStatus();
        L11:
            if (f5.a(r6) != 1) goto L14;
            Lazy r7 = j2.a;
            j2.c = Boxing.boxBoolean(true);
        L14:
            return Unit.INSTANCE;
        L9:
            r6 = null;
            goto L11
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public TemplateTabRepo$updateRuleForTemplateLastTab$1(ChatConversationVM r1, Continuation<? super TemplateTabRepo$updateRuleForTemplateLastTab$1> r2) {
        this.$chatConversationVM = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TemplateTabRepo$updateRuleForTemplateLastTab$1(this.$chatConversationVM, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        ComponentViewModel.onEach$default(this.$chatConversationVM, null, null, new AnonymousClass1(null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
