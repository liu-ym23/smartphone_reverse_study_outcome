package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaUiState;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmSummaryFragment$applyQuotaCtaState$2 extends Lambda implements Function1<h, Unit> {
    final /* synthetic */ MmSummaryFragment this$0;

    public MmSummaryFragment$applyQuotaCtaState$2(MmSummaryFragment r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(h r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        MmSummaryFragment r0 = this.this$0;
        int r1 = MmSummaryFragment.F;
        r0.getClass();
        if ((r3 instanceof h.d) == false) goto L6;
        r0.ha0().dispatchEvent(b.j.a);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((h) r1);
        return Unit.INSTANCE;
    }
}
