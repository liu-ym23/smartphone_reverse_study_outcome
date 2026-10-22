package com.larus.canvas.feature.component.instruction.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.view.FlowLayout;
import com.larus.canvas.impl.databinding.LarusDialogInstructionFeatureSelectorBinding;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.n0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import iy8.d;
import iy8.e;
import iy8.f;
import iy8.g;
import iy8.h;
import iy8.i;
import iy8.j;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0019\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u001e\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0002J\u001c\u0010.\u001a\u00020\u001c2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010/\u001a\u00020\u000fJ\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u000202H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u00064"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/canvas/impl/databinding/LarusDialogInstructionFeatureSelectorBinding;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "adapter", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorWidgetAdapter;", "featureData", "", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorOptionPanelItem;", "itemSelectorListener", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureItemSelectorCallback;", "reportSet", "", "", "rectPool", "Lcom/larus/utils/SimplePool;", "Landroid/graphics/Rect;", "initInputText", "", "behaviorCallback", "com/larus/canvas/feature/component/instruction/fragment/FeatureSelectorFragment$behaviorCallback$1", "Lcom/larus/canvas/feature/component/instruction/fragment/FeatureSelectorFragment$behaviorCallback$1;", "setCurrentInputText", "", "inputText", "tryDismiss", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "checkItemShow", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "setUp", "callback", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureSelectorFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public LarusDialogInstructionFeatureSelectorBinding d;
    public BottomSheetBehavior<View> e;
    public FeatureSelectorWidgetAdapter f;
    public List<j> g;
    public iy8.a h;
    public final Set<Object> i;
    public final n0<Rect> j;
    public String k;
    public final b l;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ FeatureSelectorFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(FeatureSelectorFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 5) goto L6;
            this.a.T90();
            return;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public FeatureSelectorFragment() {
        this.i = new LinkedHashSet();
        this.j = new n0(new d());
        this.k = "";
        this.l = new b(this);
    }

    public final void T90() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: IllegalStateException -> L9
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L9
        if (r0 == null) goto L15;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L9
        return;
    L15:
        return;
    L9:
        FLogger.a.e("FeatureSelectorFragment", "fallback by dismiss failed");
    }

    public final void S90(RecyclerView r17) {
        LinearLayoutManager r1 = r17.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r2 = r1;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        Rect r3 = (Rect) this.j.a();
        LarusDialogInstructionFeatureSelectorBinding r4 = this.d;
        if (r4 == null) goto L13;
        NestedScrollView r5 = r4.d;
        if (r5 == null) goto L13;
        boolean r6 = r5.getGlobalVisibleRect(r3);
    L14:
        if (r6 == true) goto L16;
        return;
    L16:
        Rect r7 = (Rect) this.j.a();
        FeatureSelectorWidgetAdapter r8 = this.f;
        if (r8 == null) goto L19;
        int r9 = r8.getItemCount();
    L20:
        int r10 = Math.min(0, r9);
        int r11 = Math.max(0, r9);
    L21:
        if (r10 >= r11) goto L73;
        View r12 = r2.findViewByPosition(r10);
        if (r12 == null) goto L72;
        RecyclerView.ViewHolder r13 = r17.getChildViewHolder(r12);
        if ((r13 instanceof FeatureSelectorHolder) == false) goto L27;
        FeatureSelectorHolder r14 = (FeatureSelectorHolder) r13;
    L28:
        if (r14 == null) goto L30;
        FlowLayout r15 = r14.d;
    L31:
        if (r15 == null) goto L72;
        Sequence r16 = ViewGroupKt.getChildren(r15);
        if (r16 == null) goto L72;
        Iterator r18 = r16.iterator();
        int r19 = 0;
    L36:
        if (r18.hasNext() == false) goto L72;
        Object r110 = r18.next();
        int r111 = r19 + 1;
        if (r19 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        if (((View) r110).getGlobalVisibleRect(r7) == false) goto L71;
        if (r7.top < r3.top) goto L71;
        if (r7.bottom > r3.bottom) goto L71;
        if (r7.left < r3.left) goto L71;
        if (r7.right > r3.right) goto L71;
        FeatureSelectorWidgetAdapter r112 = this.f;
        if (r112 == null) goto L55;
        List r113 = r112.getCurrentList();
        if (r113 == null) goto L55;
        j r114 = (j) CollectionsKt.getOrNull(r113, r10);
    L56:
        if (r114 == null) goto L71;
        Iterator<T> r115 = r114.c.iterator();
        int r116 = 0;
    L59:
        if (r115.hasNext() == false) goto L71;
        Object r117 = r115.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        i r119 = (i) r117;
        if (this.i.contains(r119) == true) goto L70;
        if (r116 != r19) goto L70;
        iy8.a r20 = this.h;
        if (r20 == null) goto L69;
        Long r21 = r119.a;
        r20.b(r116, r119);
    L69:
        this.i.add(r119);
    L70:
        r116 = r118;
    L55:
        r114 = null;
    L71:
        r19 = r111;
        goto L36
    L30:
        r15 = null;
        goto L31
    L27:
        r14 = null;
    L72:
        r10 = r10 + 1;
        goto L21
    L73:
        return;
    L19:
        r9 = 0;
    L13:
        r6 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        this.i.clear();     // Catch: Throwable -> L7
        iy8.a r3 = this.h;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.a();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        Resources r5 = getResources();
        final int r6 = (int) (((double) WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).heightPixels) * 0.8d);
        Dialog r7 = getDialog();
        if (r7 == null) goto L5;
        r7.setOnShowListener(new e(r6, this));
    L5:
        FeatureSelectorWidgetAdapter r8 = new FeatureSelectorWidgetAdapter(this.k, this.h);
        this.f = r8;
        LarusDialogInstructionFeatureSelectorBinding r9 = this.d;
        if (r9 == null) goto L10;
        RecyclerView r10 = r9.c;
        if (r10 == null) goto L10;
        r10.setAdapter(r8);
    L10:
        LarusDialogInstructionFeatureSelectorBinding r11 = this.d;
        if (r11 == null) goto L15;
        RecyclerView r12 = r11.c;
        if (r12 == null) goto L15;
        r12.addItemDecoration(new FeatureSelectorFragment$initView$1());
    L15:
        FeatureSelectorWidgetAdapter r13 = this.f;
        if (r13 == null) goto L18;
        r13.submitList(this.g);
    L18:
        LarusDialogInstructionFeatureSelectorBinding r14 = this.d;
        if (r14 == null) goto L21;
        RoundTextView r15 = r14.b;
    L22:
        e1.d(r15, new f(this));
        LarusDialogInstructionFeatureSelectorBinding r16 = this.d;
        if (r16 == null) goto L27;
        NestedScrollView r17 = r16.d;
        if (r17 == null) goto L27;
        r17.setOnScrollChangeListener(new g(this));
    L27:
        LarusDialogInstructionFeatureSelectorBinding r18 = this.d;
        if (r18 == null) goto L33;
        final RecyclerView r19 = r18.c;
        if (r19 == null) goto L34;
        SafeExtKt.c(this, new h(this, r19), 500);
        return;
    L34:
        return;
    L33:
        return;
    L21:
        r15 = null;
        goto L22
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131562082, r8, false);
        int r11 = 2131364404;
        if (ViewBindings.findChildViewById(r10, 2131364404) == null) goto L15;
        r11 = 2131364848;
        RoundTextView r2 = ViewBindings.findChildViewById(r10, 2131364848);
        if (r2 == null) goto L15;
        r11 = 2131372186;
        RecyclerView r3 = ViewBindings.findChildViewById(r10, 2131372186);
        if (r3 == null) goto L15;
        r11 = 2131385861;
        NestedScrollView r4 = ViewBindings.findChildViewById(r10, 2131385861);
        if (r4 == null) goto L15;
        r11 = 2131386176;
        View r5 = ViewBindings.findChildViewById(r10, 2131386176);
        if (r5 == null) goto L15;
        ConstraintLayout r12 = r10;
        this.d = new LarusDialogInstructionFeatureSelectorBinding(r12, r2, r3, r4, r5);
        return r12;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
