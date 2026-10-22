package com.obric.oui.panel;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anniex.container.l;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.oui.constraintlayout.motion.widget.e0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomSheetBehavior f13975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f13976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f13977c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f13978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f13979i;

    public BottomSheetDialog(Context r5, int r10) {
        if (r10 != 0) goto L7;
        TypedValue r11 = new TypedValue();
        if (r5.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, r11, true) == false) goto L6;
        r10 = r11.resourceId;
        goto L7
    L6:
        r10 = R$style.Theme_Design_Light_BottomSheetDialog;
    L7:
        super(r5, r10);
        this.d = true;
        this.e = true;
        this.g = false;
        this.f13978h = new ArrayList();
        this.f13979i = new g((OBasePanelDialog) this);
        supportRequestWindowFeature(1);
    }

    public final void b() {
        if (this.f13976b != null) goto L16;
        FrameLayout r5 = (FrameLayout) View.inflate(getContext(), R$layout.o_bottom_sheet_dialog, null);
        this.f13976b = r5;
        CoordinatorLayout r10 = (CoordinatorLayout) r5.findViewById(R$id.coordinator);
        FrameLayout r11 = (FrameLayout) this.f13976b.findViewById(R$id.design_bottom_sheet);
        this.f13977c = r11;
        r11.setAccessibilityPaneTitle("");
        ViewGroup.LayoutParams r12 = this.f13977c.getLayoutParams();
        if ((r12 instanceof CoordinatorLayout.LayoutParams) == false) goto L15;
        CoordinatorLayout.Behavior r13 = ((CoordinatorLayout.LayoutParams) r12).getBehavior();
        if ((r13 instanceof BottomSheetBehavior) == false) goto L13;
        BottomSheetBehavior r14 = (BottomSheetBehavior) r13;
        this.f13975a = r14;
        g r15 = this.f13979i;
        r14.getClass();
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        ArrayList r16 = r14.f13970w;
        r16.clear();
        if (r15 == null) goto L11;
        r16.add(r15);
    L11:
        BottomSheetBehavior r17 = this.f13975a;
        r17.f13959k = this.d;
        return;
    L13:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L15:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        d();
        super.cancel();
    }

    public final BottomSheetBehavior d() {
        if (this.f13975a != null) goto L6;
        b();
    L6:
        return this.f13975a;
    }

    public final FrameLayout e(int r5, View r10, ViewGroup.LayoutParams r11) {
        b();
        CoordinatorLayout r12 = (CoordinatorLayout) this.f13976b.findViewById(R$id.coordinator);
        if (r5 == 0) goto L6;
        if (r10 != null) goto L6;
        r10 = getLayoutInflater().inflate(r5, r12, false);
    L6:
        this.f13977c.removeAllViews();
        if (this.g == false) goto L10;
        if (r11 != null) goto L10;
        r11 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r11 != null) goto L12;
        this.f13977c.addView(r10);
    L13:
        r12.findViewById(R$id.touch_outside).setOnClickListener(new l(this, 1));
        r12.findViewById(R$id.touch_outside).setAccessibilityDelegate(new com.bytedance.ies.xelement.overlay.i(this, 2));
        ViewCompat.setAccessibilityDelegate(this.f13977c, new f(this, 0));
        this.f13977c.setOnTouchListener(new e0(1));
        return this.f13976b;
    L12:
        this.f13977c.addView(r10, r11);
        goto L13
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        Window r10 = getWindow();
        if (r10 == null) goto L6;
        r10.setStatusBarColor(0);
        r10.addFlags(Integer.MIN_VALUE);
        r10.setLayout(-1, -1);
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior r5 = this.f13975a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.f13962n == 5) goto L7;
        return;
    L7:
        if (this.g == false) goto L9;
        r5.setState(4);
        return;
    L9:
        r5.setState(3);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r5) {
        super.setCancelable(r5);
        if (this.d == r5) goto L8;
        this.d = r5;
        BottomSheetBehavior r10 = this.f13975a;
        if (r10 == null) goto L9;
        r10.f13959k = r5;
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
    public void setContentView(int r5) {
        super.setContentView(e(r5, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r5) {
        super.setContentView(e(0, r5, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r5, ViewGroup.LayoutParams r10) {
        super.setContentView(e(0, r5, r10));
    }
}
