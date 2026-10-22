package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import android.content.Context;
import android.widget.FrameLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingToolBarView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmRecordingFragment$initViews$4 extends FunctionReferenceImpl implements Function0<Unit> {
    public MmRecordingFragment$initViews$4(Object r8) {
        super(0, r8, MmRecordingFragment.class, "bindBottomBarView", "bindBottomBarView()V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m459invoke() {
        MmRecordingFragment r0 = (MmRecordingFragment) ((CallableReference) this).receiver;
        int r1 = MmRecordingFragment.J;
        Context r2 = com.ss.android.lark.officesdk.minutes.ui.style.c.c(r0.requireContext(), r0.A);
        if (((Boolean) r0.y.getValue()).booleanValue() == false) goto L5;
        MmRecordingAINoteToolBarView r3 = new MmRecordingAINoteToolBarView(r2, null, 6, 0);
        r0.w = r3;
        r3.V5(r0.ja0(), r0, new MmRecordingFragment$bindBottomBarView$bottomBarView$1$1(r0));
        ?? r4 = r3;
    L6:
        r0.ia0().g.removeAllViews();
        r0.ia0().g.addView(r4, new FrameLayout.LayoutParams(-1, -2));
        return;
    L5:
        r0.w = null;
        MmRecordingToolBarView r5 = new MmRecordingToolBarView(r2, null, 6, 0);
        r5.S5(r0.ja0(), r0);
        r4 = r5;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m459invoke();
        return Unit.INSTANCE;
    }
}
