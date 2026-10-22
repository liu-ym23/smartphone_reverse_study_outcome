package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_res.common_ui.databinding.LarusAutoAddCreationDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/dialog/AutoAddCreationBSDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusAutoAddCreationDialogBinding;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "behaviorCallback", "com/larus/common_ui/dialog/AutoAddCreationBSDialog$behaviorCallback$1", "Lcom/larus/common_ui/dialog/AutoAddCreationBSDialog$behaviorCallback$1;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onViewCreated", "", "view", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoAddCreationBSDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int g = 0;
    public LarusAutoAddCreationDialogBinding d;
    public BottomSheetBehavior<View> e;
    public final b f;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ AutoAddCreationBSDialog a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(AutoAddCreationBSDialog r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.e;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public AutoAddCreationBSDialog() {
        this.f = new b(this);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L5;
        r5.setOnShowListener(new p(this));
    L5:
        LarusAutoAddCreationDialogBinding r6 = this.d;
        if (r6 == null) goto L8;
        com.larus.utils.e1.d(r6.c, new q(this));
        com.larus.utils.e1.d(r6.b, new r(this));
    L8:
        tx9.m0.c("pop_up_info", "0", "chat", "");
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131561814, r4, false);
        int r7 = 2131367638;
        AppCompatTextView r8 = ViewBindings.findChildViewById(r6, 2131367638);
        if (r8 == null) goto L35;
        r7 = 2131374775;
        if (((ImageView) ViewBindings.findChildViewById(r6, 2131374775)) == null) goto L35;
        r7 = 2131374785;
        if (((ImageView) ViewBindings.findChildViewById(r6, 2131374785)) == null) goto L35;
        r7 = 2131374795;
        if (((ImageView) ViewBindings.findChildViewById(r6, 2131374795)) == null) goto L35;
        r7 = 2131376107;
        AppCompatImageView r0 = ViewBindings.findChildViewById(r6, 2131376107);
        if (r0 == null) goto L35;
        r7 = 2131379166;
        if (ViewBindings.findChildViewById(r6, 2131379166) == null) goto L35;
        r7 = 2131379168;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131379168)) == null) goto L35;
        r7 = 2131379169;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131379169)) == null) goto L35;
        r7 = 2131383424;
        if (ViewBindings.findChildViewById(r6, 2131383424) == null) goto L35;
        r7 = 2131383433;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131383433)) == null) goto L35;
        r7 = 2131383434;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131383434)) == null) goto L35;
        r7 = 2131387191;
        if (ViewBindings.findChildViewById(r6, 2131387191) == null) goto L35;
        r7 = 2131387195;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131387195)) == null) goto L35;
        r7 = 2131387196;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131387196)) == null) goto L35;
        r7 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131388772)) == null) goto L35;
        ConstraintLayout r9 = r6;
        this.d = new LarusAutoAddCreationDialogBinding(r9, r8, r0);
        return r9;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
