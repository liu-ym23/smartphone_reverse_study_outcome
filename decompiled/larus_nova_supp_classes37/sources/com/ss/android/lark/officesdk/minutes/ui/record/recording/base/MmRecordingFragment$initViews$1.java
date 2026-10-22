package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmRecordingFragment$initViews$1 extends FunctionReferenceImpl implements Function0<MmRecordingTopBarView> {
    public MmRecordingFragment$initViews$1(Object r8) {
        super(0, r8, MmRecordingFragment.class, "createDefaultTopSlotView", "createDefaultTopSlotView()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingTopBarView;", 0);
    }

    public final MmRecordingTopBarView invoke() {
        final MmRecordingFragment r0 = (MmRecordingFragment) ((CallableReference) this).receiver;
        int r1 = MmRecordingFragment.J;
        r0.getClass();
        MmRecordingTopBarView r2 = new MmRecordingTopBarView(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r0.requireContext(), r0.A), null, 6, 0);
        r2.setOnCloseClick(new MmRecordingFragment$createDefaultTopSlotView$1$1(r0));
        r2.R5(r0.ja0(), r0, (uub.b) r0.B.getValue(), r0);
        return r2;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m456invoke() {
        return invoke();
    }
}
