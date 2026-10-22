package com.larus.bot.impl.feature.edit.feature.quota;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.d;
import com.larus.common_ui.dialog.l0;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.quota.BotCreateQuotaInterceptor$fetchQuotaInfo$1", f = "BotCreateQuotaInterceptor.kt", i = {0, 0, 0, 0}, l = {138, 147}, m = "invokeSuspend", n = {"$this$launch", "loadingDialog", "httpJob", "delayLoadingJob"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class BotCreateQuotaInterceptor$fetchQuotaInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $curActivity;
    final /* synthetic */ Function0<Unit> $failure;
    final /* synthetic */ Function1<BotCreateQuota, Unit> $success;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.quota.BotCreateQuotaInterceptor$fetchQuotaInfo$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.quota.BotCreateQuotaInterceptor$fetchQuotaInfo$1$1", f = "BotCreateQuotaInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $failure;
        final /* synthetic */ Ref.ObjectRef<l0> $loadingDialog;
        final /* synthetic */ com.larus.network.http.a<BotCreateQuota> $resp;
        final /* synthetic */ Function1<BotCreateQuota, Unit> $success;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.ObjectRef<l0> r1, com.larus.network.http.a<BotCreateQuota> r2, Function1<? super BotCreateQuota, Unit> r3, Function0<Unit> r4, Continuation<? super AnonymousClass1> r5) {
            this.$loadingDialog = r1;
            this.$resp = r2;
            this.$success = r3;
            this.$failure = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$loadingDialog, this.$resp, this.$success, this.$failure, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_quota_BotCreateQuotaInterceptor$fetchQuotaInfo$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r5);
            l0 r6 = (l0) this.$loadingDialog.element;
            if (r6 != null) goto L7;
        L12:
            com.larus.network.http.a<BotCreateQuota> r7 = this.$resp;
            if ((r7 instanceof y) == false) goto L19;
            FLogger.a.i("BotCreateQuotaInterceptor", "[fetchQuotaInfo] success, " + this.$resp);
            BotCreateQuota r8 = (BotCreateQuota) ((com.larus.network.http.a) this.$resp).b;
            if (r8 == null) goto L17;
            this.$success.invoke(r8);
        L23:
            return Unit.INSTANCE;
        L17:
            this.$failure.invoke();
            goto L23
        L19:
            if ((r7 instanceof f) == false) goto L21;
            FLogger.a.e("BotCreateQuotaInterceptor", "[fetchQuotaInfo] failed, " + this.$resp.d);
            this.$failure.invoke();
            goto L23
        L21:
            FLogger.a.e("BotCreateQuotaInterceptor", "[fetchQuotaInfo] unexpected status, " + this.$resp);
            this.$failure.invoke();
            goto L23
        L7:
            if (r6.isShowing() == false) goto L12;
            INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_quota_BotCreateQuotaInterceptor$fetchQuotaInfo$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r6);     // Catch: IllegalArgumentException -> L10
        L10:
            e = move-exception;
            FLogger.a.e("BotCreateQuotaInterceptor", "[fetchQuotaInfo] Error dismissing dialog: " + e);
            goto L12
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BotCreateQuotaInterceptor$fetchQuotaInfo$1(Activity r1, Function1<? super BotCreateQuota, Unit> r2, Function0<Unit> r3, Continuation<? super BotCreateQuotaInterceptor$fetchQuotaInfo$1> r4) {
        this.$curActivity = r1;
        this.$success = r2;
        this.$failure = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        BotCreateQuotaInterceptor$fetchQuotaInfo$1 r0 = new BotCreateQuotaInterceptor$fetchQuotaInfo$1(this.$curActivity, this.$success, this.$failure, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Job r2 = (Job) this.L$3;
        Deferred r5 = (Deferred) this.L$2;
        Ref.ObjectRef r6 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
        Ref.ObjectRef r8 = r6;
    L14:
        f r16 = (com.larus.network.http.a) r15;
        if (r16 != null) goto L17;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
        r16 = new f(a.a, null);
    L17:
        f r9 = r16;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(r8, r9, this.$success, this.$failure, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (BuildersKt.withContext(r17, r3, this) != r0) goto L21;
        return r0;
    L10:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        Deferred r13 = BuildersKt.async$default(r18, Dispatchers.getIO(), null, new BotCreateQuotaInterceptor$fetchQuotaInfo$1$httpJob$1(null), 2, null);
        Job r10 = BuildersKt.launch$default(r18, null, null, new BotCreateQuotaInterceptor$fetchQuotaInfo$1$delayLoadingJob$1(r13, this.$curActivity, r4, null), 3, null);
        BotCreateQuotaInterceptor$fetchQuotaInfo$1$resp$1 r11 = new BotCreateQuotaInterceptor$fetchQuotaInfo$1$resp$1(r13, null);
        this.L$0 = r18;
        this.L$1 = r4;
        this.L$2 = r13;
        this.L$3 = r10;
        this.label = 1;
        r15 = TimeoutKt.c(5000, r11, this);
        if (r15 != r0) goto L13;
        return r0;
    L13:
        r8 = r4;
        r2 = r10;
        r5 = r13;
        goto L14
    }
}
