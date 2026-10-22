package com.larus.bot.impl.feature.health;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$tryShowNoInteract$1", f = "ChatHealthTipFragmentManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatHealthTipFragmentManager$tryShowNoInteract$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ChatHealthTipFragmentManager$tryShowNoInteract$1(Continuation<? super ChatHealthTipFragmentManager$tryShowNoInteract$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ChatHealthTipFragmentManager$tryShowNoInteract$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_health_ChatHealthTipFragmentManager$tryShowNoInteract$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(m0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        Activity r3 = AppHost.a.a().getCurrentActivity();
        if (r3 == null) goto L8;
        g r0 = g.a;
        m0 r1 = new m0(r3);
        g.g = r1;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_health_ChatHealthTipFragmentManager$tryShowNoInteract$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r1);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
