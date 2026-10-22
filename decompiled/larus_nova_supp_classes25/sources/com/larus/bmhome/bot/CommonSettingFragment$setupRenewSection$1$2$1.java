package com.larus.bmhome.bot;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.ChatListComponent;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupRenewSection$1$2$1", f = "CommonSettingFragment.kt", i = {}, l = {4045}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$setupRenewSection$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$setupRenewSection$1$2$1(CommonSettingFragment r1, Continuation<? super CommonSettingFragment$setupRenewSection$1$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonSettingFragment$setupRenewSection$1$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        boolean r6 = ub8.d.a((ub8.b) r5);
        int r2 = ChatListComponent.W3;
        int r3 = ChatListComponent.a.a(r6);
        if (r6 == false) goto L17;
        t19.s r7 = t19.s.a;
        Context r4 = this.this$0.getContext();
        r7.getClass();
        t19.s.o(r4, r3, false);
    L19:
        return Unit.INSTANCE;
    L17:
        t19.s r8 = t19.s.a;
        Context r9 = this.this$0.getContext();
        r8.getClass();
        t19.s.b(r9, r3, false);
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        RepoDispatcher.a.getClass();
        ConversationRepo r10 = RepoDispatcher.f;
        String r11 = this.this$0.n;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r11 = null;
    L11:
        this.label = 1;
        r5 = r10.n(r11, 3, "chat_settings", this);
        if (r5 != r0) goto L14;
        return r0;
    }
}
