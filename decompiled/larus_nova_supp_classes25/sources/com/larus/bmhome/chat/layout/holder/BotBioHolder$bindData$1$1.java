package com.larus.bmhome.chat.layout.holder;

import com.larus.bmhome.chat.adapter.HeaderAreaAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.common_ui.widget.ExpandTextview;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.BotBioHolder$bindData$1$1", f = "BotBioHolder.kt", i = {1}, l = {MessageCellStateTransformerType.SEARCH_LIST, MessageCellStateTransformerType.RECORD_CARD, MessageCellStateTransformerType.EXPERT_CARD}, m = "invokeSuspend", n = {"conversation"}, s = {"L$0"})
public final class BotBioHolder$bindData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HeaderAreaAdapter $headerAreaAdapter;
    final /* synthetic */ String $it;
    Object L$0;
    int label;
    final /* synthetic */ BotBioHolder this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.holder.BotBioHolder$bindData$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.BotBioHolder$bindData$1$1$1", f = "BotBioHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $bot;
        final /* synthetic */ e $conversation;
        final /* synthetic */ HeaderAreaAdapter $headerAreaAdapter;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BotBioHolder this$0;

        public AnonymousClass1(e r1, BotBioHolder r2, BotModel r3, HeaderAreaAdapter r4, Continuation<? super AnonymousClass1> r5) {
            this.$conversation = r1;
            this.this$0 = r2;
            this.$bot = r3;
            this.$headerAreaAdapter = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$conversation, this.this$0, this.$bot, this.$headerAreaAdapter, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L34;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            if (this.$conversation == null) goto L30;
            BotBioHolder r9 = this.this$0;
            final BotModel r0 = this.$bot;
            HeaderAreaAdapter r1 = this.$headerAreaAdapter;
            final ExpandTextview r2 = r9.a.findViewById(2131388367);
            String r3 = null;
            if (r0 == null) goto L9;
            String r4 = r0.getBio();
        L10:
            if (r4 != null) goto L12;
        L15:
            boolean r5 = true;
        L16:
            if (r5 == false) goto L20;
            if (r0 == null) goto L19;
            r3 = r0.getBio();
        L19:
            r1.z2(r3);
        L29:
            if (r2 == null) goto L30;
        L32:
            return Unit.INSTANCE;
        L20:
            r2.setContentTextMaxLine(2);
            StringBuilder r6 = new StringBuilder();
            r6.append(r2.getContext().getString(2131900193));
            if (r0 == null) goto L23;
            String r10 = r0.getBio();
        L24:
            if (r10 != null) goto L26;
            r10 = "";
        L26:
            r6.append(r10);
            r2.a(r6.toString(), r2.getContext().getString(2131906831), null);
            if (r2.getExpandNow() == false) goto L29;
            e1.d(r9.a, new a(r2, r0));
            goto L29
        L23:
            r10 = null;
            goto L24
        L12:
            if (StringsKt.isBlank(r4) == true) goto L15;
            r5 = false;
            goto L16
        L9:
            r4 = null;
        L30:
            Unit r11 = Unit.INSTANCE;
            goto L32
        L34:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BotBioHolder$bindData$1$1(String r1, BotBioHolder r2, HeaderAreaAdapter r3, Continuation<? super BotBioHolder$bindData$1$1> r4) {
        this.$it = r1;
        this.this$0 = r2;
        this.$headerAreaAdapter = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotBioHolder$bindData$1$1(this.$it, this.this$0, this.$headerAreaAdapter, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r12);
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        e r2 = (e) this.L$0;
        ResultKt.throwOnFailure(r12);
    L18:
        BotModel r6 = (BotModel) r12;
        MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r3 = new AnonymousClass1(r2, this.this$0, r6, this.$headerAreaAdapter, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(r13, r3, this) != r0) goto L22;
        return r0;
    L11:
        ResultKt.throwOnFailure(r12);
    L15:
        r2 = (e) r12;
        RepoDispatcher.a.getClass();
        BotRepo r14 = RepoDispatcher.g;
        String r4 = this.$it;
        this.L$0 = r2;
        this.label = 2;
        r12 = r14.j1(r4, false, this);
        if (r12 != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r12);
        RepoDispatcher.a.getClass();
        ConversationRepo r5 = RepoDispatcher.f;
        String r7 = this.$it;
        this.label = 1;
        r12 = IConversationRepoService$a.c(r5, r7, false, null, this, 6);
        if (r12 != r0) goto L15;
        return r0;
    }
}
