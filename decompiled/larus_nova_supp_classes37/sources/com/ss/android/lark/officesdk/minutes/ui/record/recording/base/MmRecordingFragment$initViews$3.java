package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import android.view.LayoutInflater;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmRecordingFragment$initViews$3 extends FunctionReferenceImpl implements Function0<mwb.d> {
    public MmRecordingFragment$initViews$3(Object r8) {
        super(0, r8, MmRecordingFragment.class, "createDefaultMiddleSlotView", "createDefaultMiddleSlotView()Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingDefaultMiddleView;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final mwb.d m458invoke() {
        MmRecordingFragment r0 = (MmRecordingFragment) ((CallableReference) this).receiver;
        int r1 = MmRecordingFragment.J;
        r0.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.e r2 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r3 = r0.A;
        r2.getClass();
        return com.ss.android.lark.officesdk.minutes.ui.style.e.b(r3).getLayout().a(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r0.requireContext(), r0.A)), r0.ia0().f);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m458invoke();
    }
}
