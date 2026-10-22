package com.larus.bot.impl.interceptor;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.core.os.BundleKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.d;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.j;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.interceptor.BotUpdateRouterInterceptor$handleBotUpdate$1", f = "BotUpdateRouterInterceptor.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"delayShowLoadingJob"}, s = {"L$0"})
final class BotUpdateRouterInterceptor$handleBotUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Activity $curActivity;
    final /* synthetic */ l0 $loadingDialog;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b this$0;

    public BotUpdateRouterInterceptor$handleBotUpdate$1(b r1, String r2, Activity r3, l0 r4, Continuation<? super BotUpdateRouterInterceptor$handleBotUpdate$1> r5) {
        this.this$0 = r1;
        this.$botId = r2;
        this.$curActivity = r3;
        this.$loadingDialog = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        BotUpdateRouterInterceptor$handleBotUpdate$1 r6 = new BotUpdateRouterInterceptor$handleBotUpdate$1(this.this$0, this.$botId, this.$curActivity, this.$loadingDialog, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_interceptor_BotUpdateRouterInterceptor$handleBotUpdate$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Job r2 = (Job) this.L$0;
        ResultKt.throwOnFailure(r12);
    L21:
        BotModel r13 = (BotModel) r12;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        if (this.$curActivity.isFinishing() == true) goto L25;
        INVOKEVIRTUAL_com_larus_bot_impl_interceptor_BotUpdateRouterInterceptor$handleBotUpdate$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.$loadingDialog);
    L25:
        if (r13 != null) goto L30;
        FLogger.a.d("BotUpdateRouterInterceptor", "handleBotUpdate, bot not find}");
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L29;
        s r14 = s.a;
        Activity r3 = this.$curActivity;
        r14.getClass();
        s.b(r3, 2131908210, false);
    L32:
        return Unit.INSTANCE;
    L29:
        s r15 = s.a;
        Activity r4 = this.$curActivity;
        r15.getClass();
        s.b(r4, 2131906741, false);
        goto L32
    L30:
        i r5 = SmartRouter.buildRoute(this.$curActivity, "//flow/bot_update");
        r5.c.addFlags(536870912);
        r5.c.putExtras(BundleKt.bundleOf(new Pair[]{TuplesKt.to("bot_update_bot_argument", r13), TuplesKt.to("previous_page", "notify"), TuplesKt.to("show_image_guide", Boxing.boxBoolean(true))}));
        r5.d = 2130772400;
        r5.e = 2130772399;
        r5.e(100);
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        Job r16 = BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new BotUpdateRouterInterceptor$handleBotUpdate$1$delayShowLoadingJob$1(this.$curActivity, this.$loadingDialog, null), 3, null);
        b r6 = this.this$0;
        String r7 = this.$botId;
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        String r8 = r7;
        this.L$0 = r16;
        this.label = 1;
        int r9 = b.a;
        r6.getClass();
        j r10 = new j(IntrinsicsKt.intercepted(this), 1);
        r10.C();
        com.larus.im.d.a().getBot(r8, false, "default", true, new c(r10));
        Object r11 = r10.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        r11 = (BotModel) r11;
    L18:
        if (r11 != r0) goto L20;
        return r0;
    L20:
        r2 = r16;
        r12 = r11;
        goto L21
    }
}
