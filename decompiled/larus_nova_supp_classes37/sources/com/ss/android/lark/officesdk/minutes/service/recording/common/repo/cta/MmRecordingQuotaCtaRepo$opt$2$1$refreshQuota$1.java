package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1", f = "MmRecordingQuotaCtaRepo.kt", i = {0, 0, 1}, l = {79, 80}, m = "invokeSuspend", n = {"aiQuotaDeferred", "isMeetingCtaEnable", "isMeetingCtaEnable"}, s = {"L$0", "Z$0", "Z$0"})
public final class MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingQuotaCtaRepo this$0;
    final /* synthetic */ MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1(MmRecordingQuotaCtaRepo r1, String r2, String r3, MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 r4, Continuation<? super MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1> r5) {
        this.this$0 = r1;
        this.$from = r2;
        this.$token = r3;
        this.this$1 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1 r6 = new MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1(this.this$0, this.$from, this.$token, this.this$1, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        boolean r3 = this.Z$0;
        Object r4 = this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r5 = r18;
    L18:
        Object r6 = ((Result) r5).unbox-impl();
        if (Result.isFailure-impl(r4) == false) goto L21;
        Object r7 = null;
    L22:
        MmQuotaData r8 = (MmQuotaData) r7;
        if (Result.isFailure-impl(r6) == false) goto L25;
        Object r9 = null;
    L26:
        MmQuotaData r10 = (MmQuotaData) r9;
        if (r8 != null) goto L36;
        if (r10 != null) goto L36;
        Throwable r11 = Result.exceptionOrNull-impl(r6);
        if (r11 != null) goto L34;
        r11 = Result.exceptionOrNull-impl(r4);
        if (r11 != null) goto L34;
        r11 = new IllegalStateException("quota data is empty");
    L34:
        Object r12 = Result.constructor-impl(ResultKt.createFailure(r11));
    L55:
        MmRecordingQuotaCtaRepo r13 = this.this$0;
        MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 r14 = this.this$1;
        if (Result.isSuccess-impl(r12) == false) goto L82;
        MmQuotaData r15 = (MmQuotaData) r12;
        String r16 = r13.l;
        StringBuilder r17 = new StringBuilder("[refreshQuota] success, asrUsage=");
        MmASRQuotaData r19 = r15.getAsrQuota();
        if (r19 == null) goto L60;
        Long r20 = r19.getUsage();
    L61:
        r17.append(r20);
        r17.append(", asrAmount=");
        MmASRQuotaData r21 = r15.getAsrQuota();
        if (r21 == null) goto L64;
        Long r22 = r21.getAmount();
    L65:
        r17.append(r22);
        r17.append(", aiUsage=");
        MmAISummaryQuotaData r23 = r15.getAiQuota();
        if (r23 == null) goto L68;
        Long r24 = r23.getUsage();
    L69:
        r17.append(r24);
        r17.append(", aiAmount=");
        MmAISummaryQuotaData r25 = r15.getAiQuota();
        if (r25 == null) goto L72;
        Long r26 = r25.getAmount();
    L73:
        r17.append(r26);
        r17.append(", AIUnavailableReason=");
        MmAISummaryQuotaData r27 = r15.getAiQuota();
        if (r27 == null) goto L76;
        MmUnavailableReason r28 = r27.getUnavailableReason();
    L77:
        r17.append(r28);
        r17.append(", ASRUnavailableReason=");
        MmASRQuotaData r29 = r15.getAsrQuota();
        if (r29 == null) goto L80;
        MmUnavailableReason r30 = r29.getUnavailableReason();
    L81:
        r17.append(r30);
        lvb.a.e(r16, r17.toString());
        r13.j(new MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$1$1(r14, r15, r3, null));
        goto L82
    L80:
        r30 = null;
        goto L81
    L76:
        r28 = null;
        goto L77
    L72:
        r26 = null;
        goto L73
    L68:
        r24 = null;
        goto L69
    L64:
        r22 = null;
        goto L65
    L60:
        r20 = null;
    L82:
        MmRecordingQuotaCtaRepo r31 = this.this$0;
        Throwable r32 = Result.exceptionOrNull-impl(r12);
        if (r32 == null) goto L86;
        lvb.a.b(r31.l, "[refreshQuota] failed: " + r32);
    L86:
        return Unit.INSTANCE;
    L36:
        if (r10 == null) goto L38;
        MmAISummaryQuotaData r33 = r10.getAiQuota();
    L39:
        if (r8 == null) goto L41;
        MmASRQuotaData r34 = r8.getAsrQuota();
    L42:
        if (r10 == null) goto L45;
        MmDisplayQuotaData r35 = r10.getDisplayQuota();
        if (r35 == null) goto L45;
    L48:
        if (r10 == null) goto L51;
        MmMempopeDeviceBonusPopup r36 = r10.getMempopeDeviceBonusPopup();
        if (r36 == null) goto L51;
    L54:
        r12 = Result.constructor-impl(new MmQuotaData(r33, r34, r35, r36));
    L51:
        if (r8 == null) goto L53;
        r36 = r8.getMempopeDeviceBonusPopup();
        goto L54
    L53:
        r36 = null;
    L45:
        if (r8 == null) goto L47;
        r35 = r8.getDisplayQuota();
        goto L48
    L47:
        r35 = null;
        goto L48
    L41:
        r34 = null;
        goto L42
    L38:
        r33 = null;
        goto L39
    L25:
        r9 = r6;
        goto L26
    L21:
        r7 = r4;
        goto L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        boolean r37 = this.Z$0;
        Deferred r38 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r18);
        boolean r110 = r37;
        Object r39 = r18;
    L14:
        r4 = ((Result) r39).unbox-impl();
        this.L$0 = r4;
        this.Z$0 = r110;
        this.label = 2;
        r5 = r38.await(this);
        if (r5 != r1) goto L17;
        return r1;
    L17:
        r3 = r110;
        goto L18
    L10:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r40 = (CoroutineScope) this.L$0;
        lvb.a.e(this.this$0.l, "[refreshQuota] start, from=" + this.$from);
        int r41 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r42 = this.this$0.j.getFeatureService();
        Intrinsics.checkNotNullParameter(r42, "featureService");
        r110 = r42.h(MmOfficeSdkFeature.RecordingMeetingCta);
        MmRecordingNetHelper r111 = this.this$0.j.G();
        Deferred r112 = BuildersKt.async$default(r40, null, null, new MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$asrQuotaDeferred$1(r111, this.$token, this.this$0, null), 3, null);
        Deferred r43 = BuildersKt.async$default(r40, null, null, new MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1(r111, this.$token, this.this$0, null), 3, null);
        this.L$0 = r43;
        this.Z$0 = r110;
        this.label = 1;
        r39 = r112.await(this);
        if (r39 != r1) goto L13;
        return r1;
    L13:
        r38 = r43;
        goto L14
    }
}
