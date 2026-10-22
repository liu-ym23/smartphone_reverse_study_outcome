package com.larus.bmhome.share.network;

import androidx.fragment.app.DialogFragment;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.share.network.SharePanelShowHelper$interceptItemClick$1", f = "SharePanelShowHelper.kt", i = {1}, l = {121, 133}, m = "invokeSuspend", n = {"loadingDeferred"}, s = {"L$0"})
final class SharePanelShowHelper$interceptItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<i, Unit> $continueShareCallback;
    final /* synthetic */ com.larus.bmhome.share.panel.b $flowShareContent;
    final /* synthetic */ j $loadingAbility;
    final /* synthetic */ DialogFragment $shareDialog;
    final /* synthetic */ jr9.a $shareItemConfig;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SharePanelShowHelper this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SharePanelShowHelper$interceptItemClick$1(SharePanelShowHelper r1, Function1<? super i, Unit> r2, jr9.a r3, com.larus.bmhome.share.panel.b r4, DialogFragment r5, j r6, Continuation<? super SharePanelShowHelper$interceptItemClick$1> r7) {
        this.this$0 = r1;
        this.$continueShareCallback = r2;
        this.$shareItemConfig = r3;
        this.$flowShareContent = r4;
        this.$shareDialog = r5;
        this.$loadingAbility = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        SharePanelShowHelper$interceptItemClick$1 r8 = new SharePanelShowHelper$interceptItemClick$1(this.this$0, this.$continueShareCallback, this.$shareItemConfig, this.$flowShareContent, this.$shareDialog, this.$loadingAbility, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r6 = false;
        Long r7 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        Deferred r3 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r4 = r19;
    L31:
        BizResponse r5 = (BizResponse) r4;
        if (r5 == null) goto L34;
        j r8 = this.$loadingAbility;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        r8.dismissLoading();
        FLogger.a.i("SharePanelShowHelper", "messageShareApiDeferred is not Completed, successful = " + r5.isSuccess() + ", code = " + r5.getCode());
    L36:
        if (r5 != null) goto L38;
    L40:
        if (r6 == false) goto L42;
        this.$continueShareCallback.invoke(new i("/alice/message/share/save", Boxing.boxLong(0), this.$shareItemConfig, (SaveMessageShareInfo) r5.getData(), null, this.$flowShareContent, this.$shareDialog, 16));
    L47:
        return Unit.INSTANCE;
    L42:
        Function1<i, Unit> r9 = this.$continueShareCallback;
        if (r5 == null) goto L45;
        r7 = Boxing.boxLong(r5.getCode());
    L45:
        r9.invoke(new i("/alice/message/share/save", r7, this.$shareItemConfig, null, null, this.$flowShareContent, this.$shareDialog, 16));
        goto L47
    L38:
        if (r5.isSuccess() != true) goto L40;
        r6 = true;
    L34:
        r5 = null;
        goto L36
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
        Object r10 = r19;
    L22:
        r5 = (BizResponse) r10;
        if (r5 == null) goto L34;
        FLogger.a.i("SharePanelShowHelper", "messageShareApiDeferred is Completed, successful = " + r5.isSuccess() + ", code = " + r5.getCode());
        goto L36
    L10:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Deferred<BizResponse<SaveMessageShareInfo>> r12 = this.this$0.b;
        if (r12 != null) goto L13;
    L15:
        boolean r13 = false;
    L16:
        if (r13 == false) goto L25;
        Deferred<BizResponse<SaveMessageShareInfo>> r14 = this.this$0.b;
        if (r14 == null) goto L34;
        this.label = 1;
        r10 = r14.await(this);
        if (r10 != r1) goto L22;
        return r1;
    L25:
        FLogger.a.i("SharePanelShowHelper", "messageShareApiDeferred is not Completed");
        Deferred r15 = BuildersKt.async$default(r11, null, null, new SharePanelShowHelper$interceptItemClick$1$response$loadingDeferred$1(this.this$0, this.$loadingAbility, null), 3, null);
        Deferred<BizResponse<SaveMessageShareInfo>> r16 = this.this$0.b;
        if (r16 == null) goto L34;
        this.L$0 = r15;
        this.label = 2;
        r4 = r16.await(this);
        if (r4 != r1) goto L30;
        return r1;
    L30:
        r3 = r15;
        goto L31
    L13:
        if (r12.isCompleted() != true) goto L15;
        r13 = true;
        goto L16
    }
}
