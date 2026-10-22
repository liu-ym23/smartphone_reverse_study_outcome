package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaUiState;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmSubtitleFragment$bindQuotaCtaState$2 extends Lambda implements Function1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h, Unit> {
    final /* synthetic */ MmSubtitleFragment this$0;

    public MmSubtitleFragment$bindQuotaCtaState$2(MmSubtitleFragment r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        MmSubtitleFragment r0 = this.this$0;
        int r1 = MmSubtitleFragment.E;
        r0.getClass();
        if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r5;
        String r3 = r2.b.getBillUrl(r2.a, "minutes_recording_transcript_page");
        if (StringsKt.isBlank(r3) == true) goto L17;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r4 = r0.q;
        if (r4 == null) goto L10;
        r0.ea0().trackQuotaCtaClick(MmRecordingUITab.SUBTITLE, r4);
    L11:
        qub.f r6 = r0.ea0().hostBridge();
        if (r6 == null) goto L16;
        new qub.i.a(r0.requireContext(), r3);
        r6.C0();
        return;
    L16:
        return;
    L10:
        r0.ea0().trackQuotaCtaClick(r5);
        goto L11
    L17:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h) r1);
        return Unit.INSTANCE;
    }
}
