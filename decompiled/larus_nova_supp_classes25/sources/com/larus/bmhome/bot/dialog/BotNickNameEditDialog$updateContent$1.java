package com.larus.bmhome.bot.dialog;

import android.content.res.Resources;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.databinding.LarusDialogNicknameInputBottomBinding;
import com.larus.common.apphost.AppHost;
import java.util.Arrays;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$updateContent$1", f = "BotNickNameEditDialog.kt", i = {}, l = {283, 284}, m = "invokeSuspend", n = {}, s = {})
final class BotNickNameEditDialog$updateContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    int label;
    final /* synthetic */ BotNickNameEditDialog this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.bot.dialog.BotNickNameEditDialog$updateContent$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$updateContent$1$1", f = "BotNickNameEditDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ wc9.e $chatConversationInfo;
        int label;
        final /* synthetic */ BotNickNameEditDialog this$0;

        public AnonymousClass1(wc9.e r1, BotNickNameEditDialog r2, Continuation<? super AnonymousClass1> r3) {
            this.$chatConversationInfo = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$chatConversationInfo, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r11);
            Resources r12 = AppHost.a.getApplication().getResources();
            wc9.e r0 = this.$chatConversationInfo;
            if (r0 == null) goto L25;
            BotNickNameEditDialog r1 = this.this$0;
            LarusDialogNicknameInputBottomBinding r2 = r1.d;
            LarusDialogNicknameInputBottomBinding r3 = null;
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r2 = null;
        L9:
            TextView r4 = r2.f;
            if (com.larus.bmhome.utils.i.f(r0) == false) goto L12;
            StringCompanionObject r5 = StringCompanionObject.INSTANCE;
            String r6 = String.format(r12.getString(2131910910), Arrays.copyOf(new Object[]{r12.getString(2131894309)}, 1));
        L13:
            r4.setText(r6);
            LarusDialogNicknameInputBottomBinding r7 = r1.d;
            if (r7 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L17:
            TextView r8 = r3.g;
            StringCompanionObject r9 = StringCompanionObject.INSTANCE;
            String r13 = String.format(r12.getString(2131910909), Arrays.copyOf(new Object[]{r0.c}, 1));
            Matcher r10 = PatternProtector.compile("\\(.*\\)").matcher(r13);
            if (r10.find() == false) goto L20;
            r13 = StringsKt.trim(r10.replaceAll("")).toString();
        L23:
            r8.setText(r13);
            goto L25
        L20:
            Matcher r14 = PatternProtector.compile("（.*）").matcher(r13);
            if (r14.find() == false) goto L23;
            r13 = StringsKt.trim(r14.replaceAll("")).toString();
            goto L23
        L16:
            r3 = r7;
            goto L17
        L12:
            r6 = r12.getString(2131910912);
            Intrinsics.checkNotNull(r6);
        L25:
            return Unit.INSTANCE;
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BotNickNameEditDialog$updateContent$1(String r1, BotNickNameEditDialog r2, Continuation<? super BotNickNameEditDialog$updateContent$1> r3) {
        this.$botId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotNickNameEditDialog$updateContent$1(this.$botId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1((wc9.e) r7, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        RepoDispatcher.a.getClass();
        ConversationRepo r8 = RepoDispatcher.f;
        String r4 = this.$botId;
        this.label = 1;
        r7 = r8.a(r4, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
