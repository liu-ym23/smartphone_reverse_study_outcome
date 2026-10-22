package com.larus.agents.impl.ui;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0004J\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/larus/agents/impl/ui/ExpandedTaskBottomSheetFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "paneAwareController", "Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "getPaneAwareController", "()Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "paneAwareController$delegate", "Lkotlin/Lazy;", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "wrapContent", "Landroid/view/View;", "content", "onSheetViewCreated", "", "onRoundedBottomSheetReady", "bottomSheet", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class ExpandedTaskBottomSheetFragment extends RoundedBottomSheetDialogFragment {
    public static final /* synthetic */ int e = 0;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    public int S90() {
        return 2131239798;
    }

    public void onDestroyView() {
        ((PaneAwareBottomSheetController) this.d.getValue()).e();
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public ExpandedTaskBottomSheetFragment() {
        this.d = LazyKt.lazy(new com.larus.agents.impl.ui.a(this));
    }

    public final View W90(View r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        return ((PaneAwareBottomSheetController) this.d.getValue()).f(requireContext(), r3);
    }

    public final Dialog onCreateDialog(Bundle r1) {
        return ((PaneAwareBottomSheetController) this.d.getValue()).b();
    }

    public final void V90(View r5, BottomSheetBehavior<View> r6) {
        Intrinsics.checkNotNullParameter(r5, "bottomSheet");
        Intrinsics.checkNotNullParameter(r6, "behavior");
        Object r0 = r5.getParent();
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L7:
        if (r1 == null) goto L17;
        Integer r3 = Integer.valueOf(r1.getHeight());
        if (r3.intValue() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L17;
        int r7 = r3.intValue();
    L18:
        int r8 = MathKt.roundToInt(r7 * 0.95f);
        ViewGroup.LayoutParams r9 = r5.getLayoutParams();
        if (r9 == null) goto L21;
        r9.height = r8;
        r2 = r9;
    L21:
        r5.setLayoutParams(r2);
        r5.requestLayout();
        r6.setPeekHeight(r8);
        r6.setSkipCollapsed(true);
        r6.setState(3);
        return;
    L11:
        r4 = false;
    L17:
        Resources r10 = getResources();
        r7 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).heightPixels;
        goto L18
    L5:
        r1 = null;
        goto L7
    }
}
