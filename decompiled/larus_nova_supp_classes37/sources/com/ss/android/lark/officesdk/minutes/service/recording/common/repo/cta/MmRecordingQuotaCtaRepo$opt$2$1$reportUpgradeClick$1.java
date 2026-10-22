package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo$opt$2$1$reportUpgradeClick$1", f = "MmRecordingQuotaCtaRepo.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingQuotaCtaRepo$opt$2$1$reportUpgradeClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmQuotaData $quotaData;
    final /* synthetic */ MmQuotaType $quotaType;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ MmRecordingQuotaCtaRepo this$0;

    public MmRecordingQuotaCtaRepo$opt$2$1$reportUpgradeClick$1(MmRecordingQuotaCtaRepo r1, String r2, MmQuotaType r3, MmQuotaData r4, Continuation<? super MmRecordingQuotaCtaRepo$opt$2$1$reportUpgradeClick$1> r5) {
        this.this$0 = r1;
        this.$token = r2;
        this.$quotaType = r3;
        this.$quotaData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingQuotaCtaRepo$opt$2$1$reportUpgradeClick$1(this.this$0, this.$token, this.$quotaType, this.$quotaData, r8);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
        Object r16 = ((Result) r15).unbox-impl();
    L48:
        MmRecordingQuotaCtaRepo r2 = this.this$0;
        MmQuotaType r3 = this.$quotaType;
        if (Result.isSuccess-impl(r16) == false) goto L51;
        Unit r4 = (Unit) r16;
        lvb.a.e(r2.l, "[reportUpgradeClick] success, quotaType=" + r3);
    L51:
        MmRecordingQuotaCtaRepo r5 = this.this$0;
        MmQuotaType r6 = this.$quotaType;
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L55;
        lvb.a.b(r5.l, "[reportUpgradeClick] failed, quotaType=" + r6 + ", error=" + r17);
    L55:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        MmRecordingNetHelper r7 = this.this$0.j.G();
        String r8 = this.$token;
        MmQuotaType r9 = this.$quotaType;
        MmQuotaData r18 = this.$quotaData;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r9, "quotaType");
        int[] r10 = e.a;
        int r11 = r10[r9.ordinal()];
        String r12 = null;
        if (r11 == 1) goto L21;
        if (r11 == 2) goto L15;
        if (r11 != 3) goto L14;
    L26:
        String r19 = "";
    L27:
        MmQuotaData r13 = this.$quotaData;
        MmQuotaType r14 = this.$quotaType;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r14, "quotaType");
        int r20 = r10[r14.ordinal()];
        if (r20 == 1) goto L39;
        if (r20 == 2) goto L34;
        if (r20 != 3) goto L33;
    L43:
        String r21 = "";
    L45:
        MmRecordingSource r22 = this.this$0.k;
        this.label = 1;
        r16 = r7.u(r8, r9, r19, r21, r22, this);
        if (r16 != r0) goto L48;
        return r0;
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        MmASRQuotaData r23 = r13.getAsrQuota();
        if (r23 == null) goto L37;
        r12 = r23.getLicensePlanKey();
    L37:
        if (r12 == null) goto L43;
    L44:
        r21 = r12;
        goto L45
    L39:
        MmAISummaryQuotaData r24 = r13.getAiQuota();
        if (r24 == null) goto L42;
        r12 = r24.getLicensePlanKey();
    L42:
        if (r12 != null) goto L44;
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        MmASRQuotaData r110 = r18.getAsrQuota();
        if (r110 == null) goto L18;
        r19 = r110.getBillFeatureKey();
    L19:
        if (r19 != null) goto L27;
    L18:
        r19 = null;
        goto L19
    L21:
        MmAISummaryQuotaData r111 = r18.getAiQuota();
        if (r111 == null) goto L24;
        r19 = r111.getBillFeatureKey();
    L25:
        if (r19 != null) goto L27;
    L24:
        r19 = null;
        goto L25
    }
}
