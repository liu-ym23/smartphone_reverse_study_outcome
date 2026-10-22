package com.larus.bot.impl.interceptor;

import android.app.Activity;
import com.larus.common_ui.dialog.l0;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.interceptor.BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1", f = "BotUpdateRouterInterceptor.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $curActivity;
    final /* synthetic */ l0 $loadingDialog;
    int label;

    public BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1(Activity r1, l0 r2, Continuation<? super BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1> r3) {
        this.$curActivity = r1;
        this.$loadingDialog = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1(this.$curActivity, this.$loadingDialog, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_interceptor_BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (this.$curActivity.isFinishing() == true) goto L15;
        INVOKEVIRTUAL_com_larus_bot_impl_interceptor_BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.$loadingDialog);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(400, this) != r0) goto L12;
        return r0;
    }
}
