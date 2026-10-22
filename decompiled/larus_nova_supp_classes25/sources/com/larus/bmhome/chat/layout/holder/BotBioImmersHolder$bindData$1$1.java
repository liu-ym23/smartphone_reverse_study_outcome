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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.BotBioImmersHolder$bindData$1$1", f = "BotBioImmersHolder.kt", i = {1}, l = {MessageCellStateTransformerType.NESTED_FILE, MessageCellStateTransformerType.SEARCH_LIST, MessageCellStateTransformerType.RECORD_CARD}, m = "invokeSuspend", n = {"conversation"}, s = {"L$0"})
public final class BotBioImmersHolder$bindData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HeaderAreaAdapter $adapter;
    final /* synthetic */ Integer $immerseBgColor;
    final /* synthetic */ String $it;
    Object L$0;
    int label;
    final /* synthetic */ BotBioImmersHolder this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.holder.BotBioImmersHolder$bindData$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.BotBioImmersHolder$bindData$1$1$1", f = "BotBioImmersHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HeaderAreaAdapter $adapter;
        final /* synthetic */ String $bio;
        final /* synthetic */ e $conversation;
        final /* synthetic */ Integer $immerseBgColor;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BotBioImmersHolder this$0;

        public AnonymousClass1(e r1, BotBioImmersHolder r2, String r3, HeaderAreaAdapter r4, Integer r5, Continuation<? super AnonymousClass1> r6) {
            this.$conversation = r1;
            this.this$0 = r2;
            this.$bio = r3;
            this.$adapter = r4;
            this.$immerseBgColor = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.$conversation, this.this$0, this.$bio, this.$adapter, this.$immerseBgColor, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L24;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            if (this.$conversation == null) goto L20;
            BotBioImmersHolder r9 = this.this$0;
            final String r0 = this.$bio;
            HeaderAreaAdapter r1 = this.$adapter;
            final Integer r2 = this.$immerseBgColor;
            final ExpandTextview r3 = r9.a.findViewById(2131388367);
            if (r0.length() != 0) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == false) goto L12;
            r1.z2(r0);
        L19:
            if (r3 == null) goto L20;
        L22:
            return Unit.INSTANCE;
        L12:
            r3.setContentTextMaxLine(3);
            StringBuilder r5 = new StringBuilder();
            r5.append(r3.getContext().getString(2131900193));
            if (r0 != null) goto L15;
            String r6 = "";
        L16:
            r5.append(r6);
            r3.a(r5.toString(), r3.getContext().getString(2131906831), r2);
            if (r3.getExpandNow() == false) goto L19;
            e1.d(r9.a, new b(r3, r0, r2));
            goto L19
        L15:
            r6 = r0;
            goto L16
        L9:
            r4 = false;
        L20:
            Unit r10 = Unit.INSTANCE;
            goto L22
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BotBioImmersHolder$bindData$1$1(String r1, BotBioImmersHolder r2, HeaderAreaAdapter r3, Integer r4, Continuation<? super BotBioImmersHolder$bindData$1$1> r5) {
        this.$it = r1;
        this.this$0 = r2;
        this.$adapter = r3;
        this.$immerseBgColor = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BotBioImmersHolder$bindData$1$1(this.$it, this.this$0, this.$adapter, this.$immerseBgColor, r8);
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
    L27:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        e r2 = (e) this.L$0;
        ResultKt.throwOnFailure(r12);
    L18:
        e r4 = r2;
        BotModel r13 = (BotModel) r12;
        if (r13 == null) goto L22;
        String r14 = r13.getBio();
        if (r14 == null) goto L22;
    L23:
        String r6 = r14;
        MainCoroutineDispatcher r15 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r3 = new AnonymousClass1(r4, this.this$0, r6, this.$adapter, this.$immerseBgColor, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(r15, r3, this) != r0) goto L27;
        return r0;
    L22:
        r14 = "";
        goto L23
    L11:
        ResultKt.throwOnFailure(r12);
    L15:
        r2 = (e) r12;
        RepoDispatcher.a.getClass();
        BotRepo r16 = RepoDispatcher.g;
        String r5 = this.$it;
        this.L$0 = r2;
        this.label = 2;
        r12 = r16.j1(r5, false, this);
        if (r12 != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r12);
        RepoDispatcher.a.getClass();
        ConversationRepo r7 = RepoDispatcher.f;
        String r8 = this.$it;
        this.label = 1;
        r12 = IConversationRepoService$a.c(r7, r8, false, null, this, 6);
        if (r12 != r0) goto L15;
        return r0;
    }
}
