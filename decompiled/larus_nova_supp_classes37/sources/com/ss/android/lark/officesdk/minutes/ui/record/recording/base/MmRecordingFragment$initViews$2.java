package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTitleNameView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmRecordingFragment$initViews$2 extends FunctionReferenceImpl implements Function0<MmRecordingTitleNameView> {
    public MmRecordingFragment$initViews$2(Object r8) {
        super(0, r8, MmRecordingFragment.class, "createDefaultTitleSlotView", "createDefaultTitleSlotView()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingTitleNameView;", 0);
    }

    public final MmRecordingTitleNameView invoke() {
        MmRecordingFragment r0 = (MmRecordingFragment) ((CallableReference) this).receiver;
        int r1 = MmRecordingFragment.J;
        r0.getClass();
        MmRecordingTitleNameView r2 = new MmRecordingTitleNameView(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r0.requireContext(), r0.A), null, 6, 0);
        r2.T5(r0.ja0(), r0, r0, ((Boolean) r0.z.getValue()).booleanValue());
        return r2;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m457invoke() {
        return invoke();
    }
}
