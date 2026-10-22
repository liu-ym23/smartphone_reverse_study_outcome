package com.larus.bot.impl.feature.edit.feature.quota;

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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.quota.BotCreateQuotaInterceptor$fetchQuotaInfo$1$delayLoadingJob$1", f = "BotCreateQuotaInterceptor.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
public final class BotCreateQuotaInterceptor$fetchQuotaInfo$1$delayLoadingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $curActivity;
    final /* synthetic */ Deferred<com.larus.network.http.a<BotCreateQuota>> $httpJob;
    final /* synthetic */ Ref.ObjectRef<l0> $loadingDialog;
    int label;

    public BotCreateQuotaInterceptor$fetchQuotaInfo$1$delayLoadingJob$1(Deferred<? extends com.larus.network.http.a<BotCreateQuota>> r1, Activity r2, Ref.ObjectRef<l0> r3, Continuation<? super BotCreateQuotaInterceptor$fetchQuotaInfo$1$delayLoadingJob$1> r4) {
        this.$httpJob = r1;
        this.$curActivity = r2;
        this.$loadingDialog = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotCreateQuotaInterceptor$fetchQuotaInfo$1$delayLoadingJob$1(this.$httpJob, this.$curActivity, this.$loadingDialog, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_quota_BotCreateQuotaInterceptor$fetchQuotaInfo$1$delayLoadingJob$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        if (this.$httpJob.isActive() == false) goto L19;
        if (this.$curActivity.isFinishing() == true) goto L19;
        Ref.ObjectRef<l0> r7 = this.$loadingDialog;
        r7.element = new l0(this.$curActivity, 0.0f, false, 6);
        l0 r8 = (l0) this.$loadingDialog.element;
        if (r8 == null) goto L19;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_quota_BotCreateQuotaInterceptor$fetchQuotaInfo$1$delayLoadingJob$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r8);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L12;
        return r0;
    }
}
