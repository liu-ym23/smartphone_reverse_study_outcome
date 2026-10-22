package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaUiState;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmSubtitleFragment$bindQuotaCtaState$1 extends Lambda implements Function1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h, Unit> {
    final /* synthetic */ MmSubtitleFragment this$0;

    public MmSubtitleFragment$bindQuotaCtaState$1(MmSubtitleFragment r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        MmSubtitleFragment r0 = this.this$0;
        int r1 = MmSubtitleFragment.E;
        r0.getClass();
        boolean r2 = r4 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d;
        if (r2 == false) goto L6;
        MmQuotaData r3 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r4).b;
    L8:
        if (r2 == false) goto L11;
        MmQuotaType r5 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r4).a;
    L13:
        String r6 = r3.getBenefitCenterUrl(r5);
        if (StringsKt.isBlank(r6) == false) goto L16;
        int r7 = bwb.b.a;
        bwb.b.h(MmUiLogScene.RECORDING, "quotaCtaBenefitCenter", "benefitCenterUrl is empty", r0.U90());
        return;
    L16:
        qub.f r8 = r0.ea0().hostBridge();
        if (r8 == null) goto L23;
        new qub.i.a(r0.requireContext(), r6);
        r8.C0();
        return;
    L23:
        return;
    L11:
        if ((r4 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) == false) goto L21;
        r5 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r4).a;
        goto L13
    L21:
        return;
    L6:
        if ((r4 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) == false) goto L20;
        r3 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r4).b;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h) r1);
        return Unit.INSTANCE;
    }
}
