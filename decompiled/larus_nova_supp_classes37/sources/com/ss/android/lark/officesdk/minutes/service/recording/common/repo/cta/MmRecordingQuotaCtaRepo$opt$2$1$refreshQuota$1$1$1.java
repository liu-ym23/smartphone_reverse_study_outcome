package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$1$1", f = "MmRecordingQuotaCtaRepo.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MmQuotaData $data;
    final /* synthetic */ boolean $isMeetingCtaEnable;
    int label;
    final /* synthetic */ MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$1$1(MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 r1, MmQuotaData r2, boolean r3, Continuation<? super MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$1$1> r4) {
        this.this$0 = r1;
        this.$data = r2;
        this.$isMeetingCtaEnable = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$1$1(this.this$0, this.$data, this.$isMeetingCtaEnable, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L99:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 r3 = this.this$0;
        int r4 = g.a;
        MmQuotaData r5 = this.$data;
        boolean r6 = this.$isMeetingCtaEnable;
        Intrinsics.checkNotNullParameter(r5, "quotaData");
        Intrinsics.checkNotNullParameter(r5, "quotaData");
        MmASRQuotaData r8 = r5.getAsrQuota();
        if (r8 != null) goto L11;
        h r9 = h.b.a;
    L25:
        Intrinsics.checkNotNullParameter(r5, "quotaData");
        MmAISummaryQuotaData r7 = r5.getAiQuota();
        if (r7 == null) goto L28;
        boolean r10 = Intrinsics.areEqual(r7.getIgnoreUpgrade(), Boolean.TRUE);
    L29:
        if (r10 == false) goto L31;
        h r11 = h.b.a;
    L95:
        c r12 = new c(r9, r11, r5);
        this.label = 1;
        if (MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1.T0(r3, r12, this) != r1) goto L99;
        return r1;
    L31:
        MmASRQuotaData r13 = r5.getAsrQuota();
        MmQuotaType r14 = null;
        if (r7 == null) goto L34;
        MmUnavailableReason r15 = r7.getUnavailableReason();
    L35:
        MmRecordingQuotaCtaRenderType r16 = b.a(r15);
        if (r13 == null) goto L38;
        MmUnavailableReason r17 = r13.getUnavailableReason();
    L39:
        MmRecordingQuotaCtaRenderType r19 = b.a(r17);
        MmRecordingQuotaCtaRenderType r110 = MmRecordingQuotaCtaRenderType.Default;
        if (r16 == r110) goto L42;
        r14 = MmQuotaType.AI_SUMMARY;
    L66:
        if (r14 != null) goto L68;
        r11 = h.b.a;
        goto L95
    L68:
        int[] r20 = g.a.a;
        int r111 = r20[r14.ordinal()];
        if (r111 == 1) goto L77;
        if (r111 == 2) goto L76;
        int r112 = 3;
        if (r111 != 3) goto L75;
    L78:
        int r21 = r20[r14.ordinal()];
        if (r21 != 1) goto L81;
        if (r7 == null) goto L90;
        boolean r22 = Intrinsics.areEqual(r7.getCanBuy(), Boolean.TRUE);
    L91:
        if (r6 == false) goto L94;
        if (r22 == false) goto L94;
        r11 = new h.d(r14, r5, MmRecordingQuotaCtaScene.SUMMARY, r110);
    L94:
        r11 = new h.c(r14, r5, MmRecordingQuotaCtaScene.SUMMARY, r110);
    L90:
        r22 = false;
        goto L91
    L81:
        if (r21 == 2) goto L86;
        if (r21 == r112) goto L90;
        throw new NoWhenBranchMatchedException();
    L86:
        if (r13 == null) goto L90;
        r22 = Intrinsics.areEqual(r13.getCanBuy(), Boolean.TRUE);
        goto L91
    L75:
        throw new NoWhenBranchMatchedException();
    L76:
        r112 = 3;
        r110 = r19;
        goto L78
    L77:
        r112 = 3;
        r110 = r16;
        goto L78
    L42:
        if (r7 != null) goto L44;
    L46:
        boolean r113 = false;
    L47:
        if (r113 == false) goto L49;
        r14 = MmQuotaType.AI_SUMMARY;
        goto L66
    L49:
        if (r13 == null) goto L51;
        boolean r23 = Intrinsics.areEqual(r13.getIgnoreUpgrade(), Boolean.TRUE);
    L52:
        if (r23 == true) goto L55;
        if (r19 == r110) goto L55;
        r14 = MmQuotaType.ASR;
    L55:
        if (r13 == null) goto L57;
        boolean r24 = Intrinsics.areEqual(r13.getIgnoreUpgrade(), Boolean.TRUE);
    L58:
        if (r24 == true) goto L66;
        if (r13 != null) goto L61;
    L63:
        boolean r25 = false;
    L64:
        if (r25 == false) goto L66;
        r14 = MmQuotaType.ASR;
        goto L66
    L61:
        if (r13.isExceed() != true) goto L63;
        r25 = true;
        goto L64
    L57:
        r24 = false;
        goto L58
    L51:
        r23 = false;
        goto L52
    L44:
        if (r7.isExceed() != true) goto L46;
        r113 = true;
        goto L47
    L38:
        r17 = null;
        goto L39
    L34:
        r15 = null;
        goto L35
    L28:
        r10 = false;
        goto L29
    L11:
        Boolean r26 = r8.getIgnoreUpgrade();
        Boolean r114 = Boolean.TRUE;
        if (Intrinsics.areEqual(r26, r114) == false) goto L14;
        r9 = h.b.a;
        goto L25
    L14:
        MmRecordingQuotaCtaRenderType r27 = b.a(r8.getUnavailableReason());
        if (r8.isExceed() == false) goto L17;
    L20:
        if (r6 == true) goto L22;
    L24:
        r9 = new h.c(MmQuotaType.ASR, r5, MmRecordingQuotaCtaScene.SUBTITLE, r27);
        goto L25
    L22:
        if (Intrinsics.areEqual(r8.getCanBuy(), r114) == false) goto L24;
        r9 = new h.d(MmQuotaType.ASR, r5, MmRecordingQuotaCtaScene.SUBTITLE, r27);
        goto L25
    L17:
        if (r27 != MmRecordingQuotaCtaRenderType.Default) goto L20;
        r9 = h.b.a;
        goto L25
    }
}
