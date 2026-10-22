package com.larus.bmhome.bot.dialog;

import android.text.TextUtils;
import android.widget.EditText;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.databinding.LarusDialogNicknameInputBottomBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import ic8.n;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$updateHintText$1", f = "BotNickNameEditDialog.kt", i = {1}, l = {250, 251, 252}, m = "invokeSuspend", n = {"chatConversationInfo"}, s = {"L$0"})
final class BotNickNameEditDialog$updateHintText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    Object L$0;
    int label;
    final /* synthetic */ BotNickNameEditDialog this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.bot.dialog.BotNickNameEditDialog$updateHintText$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$updateHintText$1$1", f = "BotNickNameEditDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $botInfo;
        final /* synthetic */ wc9.e $chatConversationInfo;
        int label;
        final /* synthetic */ BotNickNameEditDialog this$0;

        public AnonymousClass1(BotModel r1, wc9.e r2, BotNickNameEditDialog r3, Continuation<? super AnonymousClass1> r4) {
            this.$botInfo = r1;
            this.$chatConversationInfo = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$botInfo, this.$chatConversationInfo, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L63;
            ResultKt.throwOnFailure(r5);
            BotModel r6 = this.$botInfo;
            LarusDialogNicknameInputBottomBinding r0 = null;
            if (r6 == null) goto L7;
            String r7 = r6.getCallerName();
        L8:
            wc9.e r1 = this.$chatConversationInfo;
            if (r1 == null) goto L11;
            Boolean r2 = Boxing.boxBoolean(n.u(r1));
        L13:
            if (TextUtils.isEmpty(this.this$0.f) == true) goto L19;
            LarusDialogNicknameInputBottomBinding r8 = this.this$0.d;
            if (r8 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r8 = null;
        L17:
            r8.e.setText(this.this$0.f);
        L50:
            BotNickNameEditDialog r9 = this.this$0;
            LarusDialogNicknameInputBottomBinding r3 = r9.d;
            if (r3 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r3 = null;
        L53:
            r3.e.getText().toString();
            r9.getClass();
            LarusDialogNicknameInputBottomBinding r10 = this.this$0.d;
            if (r10 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r10 = null;
        L56:
            EditText r11 = r10.e;
            LarusDialogNicknameInputBottomBinding r4 = this.this$0.d;
            if (r4 != null) goto L59;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L60:
            r11.setSelection(r0.e.getText().length());
            return Unit.INSTANCE;
        L59:
            r0 = r4;
            goto L60
        L19:
            if (Intrinsics.areEqual(r2, Boxing.boxBoolean(true)) == false) goto L33;
            com.larus.bmhome.bot.utils.b r12 = com.larus.bmhome.bot.utils.b.a;
            if (TextUtils.isEmpty(com.larus.bmhome.bot.utils.b.b) == true) goto L26;
            LarusDialogNicknameInputBottomBinding r13 = this.this$0.d;
            if (r13 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r13 = null;
        L25:
            r13.e.setText(com.larus.bmhome.bot.utils.b.b);
            goto L50
        L26:
            AccountService r14 = AccountService.a;
            if (r14.w() == true) goto L50;
            LarusDialogNicknameInputBottomBinding r15 = this.this$0.d;
            if (r15 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r15 = null;
        L31:
            r15.e.setText(r14.getNickname());
            goto L50
        L33:
            if (TextUtils.isEmpty(r7) == true) goto L38;
            LarusDialogNicknameInputBottomBinding r16 = this.this$0.d;
            if (r16 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r16 = null;
        L37:
            r16.e.setText(r7);
            goto L50
        L38:
            com.larus.bmhome.bot.utils.b r17 = com.larus.bmhome.bot.utils.b.a;
            if (TextUtils.isEmpty(com.larus.bmhome.bot.utils.b.b) == true) goto L44;
            LarusDialogNicknameInputBottomBinding r18 = this.this$0.d;
            if (r18 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r18 = null;
        L43:
            r18.e.setText(com.larus.bmhome.bot.utils.b.b);
            goto L50
        L44:
            AccountService r19 = AccountService.a;
            if (r19.w() == true) goto L50;
            LarusDialogNicknameInputBottomBinding r20 = this.this$0.d;
            if (r20 != null) goto L49;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r20 = null;
        L49:
            r20.e.setText(r19.getNickname());
            goto L50
        L11:
            r2 = null;
            goto L13
        L7:
            r7 = null;
            goto L8
        L63:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BotNickNameEditDialog$updateHintText$1(String r1, String r2, BotNickNameEditDialog r3, Continuation<? super BotNickNameEditDialog$updateHintText$1> r4) {
        this.$conversationId = r1;
        this.$botId = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotNickNameEditDialog$updateHintText$1(this.$conversationId, this.$botId, this.this$0, r5);
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
        wc9.e r2 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r12);
    L18:
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1((BotModel) r12, r2, this.this$0, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(r3, r4, this) != r0) goto L22;
        return r0;
    L11:
        ResultKt.throwOnFailure(r12);
    L15:
        r2 = (wc9.e) r12;
        RepoDispatcher.a.getClass();
        BotRepo r5 = RepoDispatcher.g;
        String r6 = this.$botId;
        this.L$0 = r2;
        this.label = 2;
        r12 = IBotRepoService.b.a(r5, r6, false, null, false, this, 30);
        if (r12 != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r12);
        RepoDispatcher.a.getClass();
        ConversationRepo r7 = RepoDispatcher.f;
        String r8 = this.$conversationId;
        this.label = 1;
        r12 = IConversationRepoService$a.c(r7, r8, false, null, this, 6);
        if (r12 != r0) goto L15;
        return r0;
    }
}
