package com.obric.oui.sheet;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import q5.f;
import q5.h;
import q5.k;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OBottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;

    @NonNull
    private BottomSheetBehavior.d bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private boolean is69Expandable;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBottomSheetDialog f7379c;

        a(OBottomSheetDialog r10) {
            this.f7379c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            OBottomSheetDialog r11 = this.f7379c;
            if (r11.cancelable == true) goto L5;
            return;
        L5:
            if (r11.isShowing() == true) goto L7;
            return;
        L7:
            if (this.f7379c.shouldWindowCloseOnTouchOutside() == false) goto L12;
            this.f7379c.cancel();
            return;
        }
    }

    class b implements View.OnTouchListener {
        b(OBottomSheetDialog r10) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            return true;
        }
    }

    class c extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomSheetDialog f7380a;

        c(OBottomSheetDialog r10) {
            this.f7380a = r10;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void b(@NonNull View r10, float r11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void c(@NonNull View r10, int r11) {
            if (r11 != 5) goto L6;
            this.f7380a.cancel();
            return;
        }
    }

    public OBottomSheetDialog(@NonNull Context r10) {
        this(r10, 0);
    }

    public OBottomSheetDialog(@NonNull Context r10, @StyleRes int r11) {
        super(r10, getThemeResId(r10, r11));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.is69Expandable = false;
        this.bottomSheetCallback = new c(this);
        supportRequestWindowFeature(1);
    }

    protected OBottomSheetDialog(@NonNull Context r10, boolean r11, DialogInterface.OnCancelListener r12) {
        super(r10, r11, r12);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.is69Expandable = false;
        this.bottomSheetCallback = new c(this);
        supportRequestWindowFeature(1);
        this.cancelable = r11;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L11;
        FrameLayout r10 = (FrameLayout) View.inflate(getContext(), h.design_bottom_sheet_dialog, null);
        this.container = r10;
        this.coordinator = (CoordinatorLayout) r10.findViewById(f.coordinator);
        FrameLayout r11 = (FrameLayout) this.container.findViewById(f.design_bottom_sheet);
        this.bottomSheet = r11;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r11.setAccessibilityPaneTitle("");
    L7:
        BottomSheetBehavior<FrameLayout> r12 = BottomSheetBehavior.from(this.bottomSheet);
        this.behavior = r12;
        r12.setBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
        if (this.is69Expandable == false) goto L11;
        this.behavior.setPeekHeight((int) (com.obric.oui.common.util.f.d(getContext()) * 0.75f));
    L11:
        return this.container;
    }

    private static int getThemeResId(@NonNull Context r10, int r11) {
        if (r11 != 0) goto L8;
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(q5.b.bottomSheetDialogTheme, r12, true) == false) goto L7;
        return r12.resourceId;
    L7:
        return k.Theme_Design_Light_BottomSheetDialog;
    L8:
        return r11;
    }

    private View wrapInBottomSheet(int r10, @Nullable View r11, @Nullable ViewGroup.LayoutParams r12) {
        ensureContainerAndBehavior();
        CoordinatorLayout r13 = (CoordinatorLayout) this.container.findViewById(f.coordinator);
        if (r10 == 0) goto L6;
        if (r11 != null) goto L6;
        r11 = getLayoutInflater().inflate(r10, r13, false);
    L6:
        this.bottomSheet.removeAllViews();
        if (this.is69Expandable == false) goto L10;
        if (r12 != null) goto L10;
        r12 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        FrameLayout r14 = this.bottomSheet;
        if (r12 != null) goto L13;
        r14.addView(r11);
    L14:
        int r15 = f.touch_outside;
        r13.findViewById(r15).setOnClickListener(new a(this));
        r13.findViewById(r15).setAccessibilityDelegate(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new b(this));
        return this.container;
    L13:
        r14.addView(r11, r12);
        goto L14
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r10 = getBehavior();
        if (this.dismissWithAnimation == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r10.getState() == 5) goto L8;
        r10.setState(5);
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getIs69Expandable() {
        return this.is69Expandable;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        Window r11 = getWindow();
        if (r11 == null) goto L11;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L9;
        r11.setStatusBarColor(0);
        r11.addFlags(Integer.MIN_VALUE);
        if (r12 >= 23) goto L9;
        r11.addFlags(67108864);
    L9:
        r11.setLayout(-1, -1);
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r10 = this.behavior;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getState() != 5) goto L9;
        this.behavior.setState(4);
        return;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r10) {
        super.setCancelable(r10);
        if (this.cancelable == r10) goto L8;
        this.cancelable = r10;
        BottomSheetBehavior<FrameLayout> r11 = this.behavior;
        if (r11 == null) goto L9;
        r11.setHideable(r10);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r10) {
        super.setCanceledOnTouchOutside(r10);
        if (r10 == true) goto L5;
    L7:
        this.canceledOnTouchOutside = r10;
        this.canceledOnTouchOutsideSet = true;
        return;
    L5:
        if (this.cancelable == true) goto L7;
        this.cancelable = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@LayoutRes int r10) {
        super.setContentView(wrapInBottomSheet(r10, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10) {
        super.setContentView(wrapInBottomSheet(0, r10, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        super.setContentView(wrapInBottomSheet(0, r10, r11));
    }

    public void setDismissWithAnimation(boolean r10) {
        this.dismissWithAnimation = r10;
    }

    public void setIs69Expandable(boolean r10) {
        this.is69Expandable = r10;
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r10 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r10.getBoolean(0, true);
        r10.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }
}
