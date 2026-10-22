package com.larus.bot.impl.feature.health;

import android.app.Application;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
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
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragment$reportUserHaveAgree$1$2$1", f = "ChatHealthTipFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatHealthTipFragment$reportUserHaveAgree$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdateSafetyStateResponse $it;
    int label;
    final /* synthetic */ ChatHealthTipFragment this$0;

    public ChatHealthTipFragment$reportUserHaveAgree$1$2$1(ChatHealthTipFragment r1, UpdateSafetyStateResponse r2, Continuation<? super ChatHealthTipFragment$reportUserHaveAgree$1$2$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatHealthTipFragment$reportUserHaveAgree$1$2$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_health_ChatHealthTipFragment$reportUserHaveAgree$1$2$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(ChatHealthTipFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        ChatHealthTipFragment.S90(this.this$0);
        if (Intrinsics.areEqual(this.$it.getSuccess(), Boxing.boxBoolean(true)) == false) goto L7;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_health_ChatHealthTipFragment$reportUserHaveAgree$1$2$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this.this$0);
        Keva r5 = h.a;
        String r6 = AccountService.a.getUserId();
        Intrinsics.checkNotNullParameter(r6, "uid");
        h.a.storeBoolean("have_agree_health".concat(r6), true);
    L9:
        return Unit.INSTANCE;
    L7:
        s r7 = s.a;
        Application r0 = AppHost.a.getApplication();
        r7.getClass();
        s.b(r0, 2131907052, false);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
