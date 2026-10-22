package com.obric.oui.sheet;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anniex.container.l;
import com.bytedance.ies.xelement.overlay.i;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.oui.constraintlayout.motion.widget.e0;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class OBottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomSheetBehavior f14405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f14406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f14407c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f14408h;

    public OBottomSheetDialog(Context r5, int r10) {
        if (r10 != 0) goto L7;
        TypedValue r11 = new TypedValue();
        if (r5.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, r11, true) == false) goto L6;
        r10 = r11.resourceId;
        goto L7
    L6:
        r10 = R.style.Theme_Design_Light_BottomSheetDialog;
    L7:
        super(r5, r10);
        this.d = true;
        this.e = true;
        this.g = false;
        this.f14408h = new d(this);
        supportRequestWindowFeature(1);
    }

    public final void b() {
        if (this.f14406b != null) goto L8;
        FrameLayout r5 = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        this.f14406b = r5;
        CoordinatorLayout r10 = (CoordinatorLayout) r5.findViewById(R.id.coordinator);
        FrameLayout r11 = (FrameLayout) this.f14406b.findViewById(R.id.design_bottom_sheet);
        this.f14407c = r11;
        r11.setAccessibilityPaneTitle("");
        BottomSheetBehavior r12 = BottomSheetBehavior.from(this.f14407c);
        this.f14405a = r12;
        r12.setBottomSheetCallback(this.f14408h);
        this.f14405a.setHideable(this.d);
        if (this.g == false) goto L9;
        this.f14405a.setPeekHeight((int) (com.lynx.tasm.utils.a.w(getContext()) * 0.75f));
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.f14405a != null) goto L5;
        b();
    L5:
        super.cancel();
    }

    public final FrameLayout d(int r5, View r10, ViewGroup.LayoutParams r11) {
        b();
        CoordinatorLayout r12 = (CoordinatorLayout) this.f14406b.findViewById(R.id.coordinator);
        if (r5 == 0) goto L6;
        if (r10 != null) goto L6;
        r10 = getLayoutInflater().inflate(r5, r12, false);
    L6:
        this.f14407c.removeAllViews();
        if (this.g == false) goto L10;
        if (r11 != null) goto L10;
        r11 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r11 != null) goto L12;
        this.f14407c.addView(r10);
    L13:
        r12.findViewById(R.id.touch_outside).setOnClickListener(new l(this, 2));
        r12.findViewById(R.id.touch_outside).setAccessibilityDelegate(new i(this, 3));
        ViewCompat.setAccessibilityDelegate(this.f14407c, new com.obric.oui.panel.f(this, 1));
        this.f14407c.setOnTouchListener(new e0(2));
        return this.f14406b;
    L12:
        this.f14407c.addView(r10, r11);
        goto L13
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Window r10 = getWindow();
        if (r10 == null) goto L6;
        r10.setStatusBarColor(0);
        r10.addFlags(Integer.MIN_VALUE);
        r10.setLayout(-1, -1);
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior r5 = this.f14405a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getState() != 5) goto L9;
        this.f14405a.setState(4);
        return;
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r5) {
        super.setCancelable(r5);
        if (this.d == r5) goto L8;
        this.d = r5;
        BottomSheetBehavior r10 = this.f14405a;
        if (r10 == null) goto L9;
        r10.setHideable(r5);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r5) {
        super.setCanceledOnTouchOutside(r5);
        if (r5 == true) goto L5;
    L7:
        this.e = r5;
        this.f = true;
        return;
    L5:
        if (this.d == true) goto L7;
        this.d = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(int r5) {
        super.setContentView(d(r5, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5) {
        super.setContentView(d(0, r5, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View r5, ViewGroup.LayoutParams r10) {
        super.setContentView(d(0, r5, r10));
    }
}
