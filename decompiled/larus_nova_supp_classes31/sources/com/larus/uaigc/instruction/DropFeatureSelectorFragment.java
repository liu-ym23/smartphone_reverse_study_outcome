package com.larus.uaigc.instruction;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.impl.databinding.LarusDialogInstructionDropFeatureSelectorBinding;
import com.larus.uaigc.instruction.widget.GifAnimPlayController;
import com.larus.uaigc.instruction.widget.ImageSelectorWithMoreWidgetAdapter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0002\u0012\u0015\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0018J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010&\u001a\u00020\u0018H\u0002J\u001e\u0010'\u001a\u00020\u00182\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\b\b\u0002\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020$J\b\u0010/\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u00061"}, d2 = {"Lcom/larus/uaigc/instruction/DropFeatureSelectorFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusDialogInstructionDropFeatureSelectorBinding;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "dropFeatureSelectorCallback", "Lcom/larus/uaigc/instruction/DropFeatureItemSelectorCallback;", "gifAnimController", "Lcom/larus/uaigc/instruction/widget/GifAnimPlayController;", "behaviorCallback", "com/larus/uaigc/instruction/DropFeatureSelectorFragment$behaviorCallback$1", "Lcom/larus/uaigc/instruction/DropFeatureSelectorFragment$behaviorCallback$1;", "itemClickCallback", "com/larus/uaigc/instruction/DropFeatureSelectorFragment$itemClickCallback$1", "Lcom/larus/uaigc/instruction/DropFeatureSelectorFragment$itemClickCallback$1;", "onStart", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "tryDismiss", "onViewCreated", "view", "getTheme", "", "setUp", "initView", "refreshData", "newStatusList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "calDiff", "", "scrollToPosition", "selectedPosition", "adaptAccessibility", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DropFeatureSelectorFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDialogInstructionDropFeatureSelectorBinding d;
    public BottomSheetBehavior<View> e;
    public ImageSelectorWithMoreWidgetAdapter f;
    public com.larus.bmhome.actionbar.model.h g;
    public p h;
    public final GifAnimPlayController i;
    public final b j;
    public final c k;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ DropFeatureSelectorFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(DropFeatureSelectorFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 5) goto L18;
            DropFeatureSelectorFragment r4 = this.a;
            r4.getClass();
            r4.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: IllegalStateException -> L12
            Throwable r5 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L12
            if (r5 == null) goto L19;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L12
            return;
        L19:
            return;
        L12:
            FLogger.a.e("DropFeatureSelectorFragment", "fallback by dismiss failed");
            return;
        }
    }

    public static final class c implements vz9.d {
        public final /* synthetic */ DropFeatureSelectorFragment a;

        public c(DropFeatureSelectorFragment r1) {
            this.a = r1;
        }

        @Override // vz9.d
        public final void a(com.larus.bmhome.actionbar.model.w r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "item");
            ArrayList r0 = new ArrayList();
            DropFeatureSelectorFragment r1 = this.a;
            com.larus.bmhome.actionbar.model.h r2 = r1.g;
            if (r2 == null) goto L26;
            List r3 = r2.e;
            if (r3 == null) goto L26;
            Iterator r4 = r3.iterator();
            int r5 = 0;
        L8:
            if (r4.hasNext() == false) goto L26;
            Object r6 = r4.next();
            int r7 = r5 + 1;
            if (r5 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            com.larus.bmhome.actionbar.model.w r8 = (com.larus.bmhome.actionbar.model.w) r6;
            if (Intrinsics.areEqual(r8.a, r10.a) == false) goto L24;
            Integer r9 = r8.s;
            if (r9 != null) goto L18;
        L20:
            r8.s = 1;
        L21:
            p r12 = r1.h;
            if (r12 == null) goto L25;
            r12.b(r10, r11);
        L25:
            r0.add(r8);
            r5 = r7;
            goto L8
        L18:
            if (r9.intValue() != 1) goto L20;
            r8.s = 0;
            goto L21
        L24:
            r8.s = 0;
        L26:
            ImageSelectorWithMoreWidgetAdapter r13 = this.a.f;
            if (r13 == null) goto L29;
            r13.y2(r0, true);
        L29:
            ImageSelectorWithMoreWidgetAdapter r14 = this.a.f;
            if (r14 == null) goto L32;
            r14.notifyDataSetChanged();
        L32:
            p r15 = this.a.h;
            if (r15 == null) goto L43;
            r15.a(r10);
        L43:
            this.a.dismiss();     // Catch: Exception -> L38
            return;
        L38:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r16 = DialogFragmentLancet.sLastShowStack;
            if (r16 == null) goto L49;
            com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // vz9.d
        public final void b(com.larus.bmhome.actionbar.model.w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            p r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.c(r2, r3);
            return;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public DropFeatureSelectorFragment() {
        this.i = new GifAnimPlayController();
        this.j = new b(this);
        this.k = new c(this);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        BottomSheetDialog r0 = getDialog();
        View r2 = null;
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.findViewById(2131389274);
    L8:
        if (r2 == null) goto L11;
        r2.setImportantForAccessibility(1);
        r2.setContentDescription(getString(2131898809));
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void S90(List<com.larus.bmhome.actionbar.model.w> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "newStatusList");
        ImageSelectorWithMoreWidgetAdapter r0 = this.f;
        if (r0 == null) goto L6;
        r0.y2(r2, r3);
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        Resources r9 = getResources();
        final int r10 = (int) (((double) WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).heightPixels) * 0.8d);
        x1a.a.a = false;
        Dialog r11 = getDialog();
        if (r11 == null) goto L5;
        r11.setOnShowListener(new r(r10, this));
    L5:
        LarusDialogInstructionDropFeatureSelectorBinding r12 = this.d;
        if (r12 == null) goto L24;
        ImageSelectorWithMoreWidgetAdapter r13 = new ImageSelectorWithMoreWidgetAdapter(this.k, null);
        this.f = r13;
        r12.b.setAdapter(r13);
        GridLayoutManager r14 = new GridLayoutManager(getContext(), 3);
        r12.b.setLayoutManager(r14);
        NestedScrollView r15 = r12.c;
        ViewGroup.LayoutParams r0 = r15.getLayoutParams();
        if (r0 == null) goto L23;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        r1.setMargins(((ViewGroup.MarginLayoutParams) r1).leftMargin, AppHost.a.getApplication().getResources().getDimensionPixelSize(v19.c.b(2130971480, null, 2131167331)), ((ViewGroup.MarginLayoutParams) r1).rightMargin, ((ViewGroup.MarginLayoutParams) r1).bottomMargin);
        r15.setLayoutParams(r1);
        r12.b.addItemDecoration(new DropFeatureSelectorFragment$initView$1$2(this));
        com.larus.bmhome.actionbar.model.h r16 = this.g;
        if (r16 == null) goto L16;
        List<com.larus.bmhome.actionbar.model.w> r17 = r16.e;
        if (r17 == null) goto L16;
        ImageSelectorWithMoreWidgetAdapter r2 = this.f;
        if (r2 == null) goto L16;
        r2.y2(r17, true);
    L16:
        GifAnimPlayController r18 = this.i;
        RecyclerView r19 = r12.b;
        RecyclerView r3 = r18.a;
        if (r3 == null) goto L19;
        r3.removeOnScrollListener(r18.c);
    L19:
        if (r19 == null) goto L21;
        r19.addOnScrollListener(r18.c);
    L21:
        r18.a = r19;
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562081, r4, false);
        int r7 = 2131364404;
        if (ViewBindings.findChildViewById(r6, 2131364404) == null) goto L15;
        r7 = 2131364848;
        if (ViewBindings.findChildViewById(r6, 2131364848) == null) goto L15;
        r7 = 2131372186;
        RecyclerView r8 = ViewBindings.findChildViewById(r6, 2131372186);
        if (r8 == null) goto L15;
        r7 = 2131385861;
        NestedScrollView r0 = ViewBindings.findChildViewById(r6, 2131385861);
        if (r0 == null) goto L15;
        r7 = 2131386176;
        View r1 = ViewBindings.findChildViewById(r6, 2131386176);
        if (r1 == null) goto L15;
        ConstraintLayout r9 = r6;
        this.d = new LarusDialogInstructionDropFeatureSelectorBinding(r9, r8, r0, r1);
        return r9;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
