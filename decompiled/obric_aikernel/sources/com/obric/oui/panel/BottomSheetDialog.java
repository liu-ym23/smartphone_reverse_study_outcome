package com.obric.oui.panel;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u8.f;
import u8.h;
import u8.k;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;

    @NonNull
    private BottomSheetBehavior.d bottomSheetCallback;
    private final List<BottomSheetBehavior.d> callbacks;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private boolean is69Expandable;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialog f6949c;

        a(BottomSheetDialog r10) {
            this.f6949c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            BottomSheetDialog r11 = this.f6949c;
            if (r11.cancelable == true) goto L5;
            return;
        L5:
            if (r11.isShowing() == true) goto L7;
            return;
        L7:
            if (this.f6949c.shouldWindowCloseOnTouchOutside() == false) goto L12;
            this.f6949c.cancel();
            return;
        }
    }

    class b implements View.OnTouchListener {
        b(BottomSheetDialog r10) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            return true;
        }
    }

    class c extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialog f6950a;

        c(BottomSheetDialog r10) {
            this.f6950a = r10;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void c(@NonNull View r10, float r11) {
            Iterator r12 = BottomSheetDialog.access$000(this.f6950a).iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ((BottomSheetBehavior.d) r12.next()).c(r10, r11);
            goto L4
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void d(@NonNull View r10, int r11) {
            Iterator r12 = BottomSheetDialog.access$000(this.f6950a).iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            ((BottomSheetBehavior.d) r12.next()).d(r10, r11);
            goto L4
        L7:
            if (r11 != 5) goto L11;
            this.f6950a.cancel();
            return;
        }
    }

    public BottomSheetDialog(@NonNull Context r10) {
        this(r10, 0);
    }

    public BottomSheetDialog(@NonNull Context r10, @StyleRes int r11) {
        super(r10, getThemeResId(r10, r11));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.is69Expandable = false;
        this.callbacks = new ArrayList();
        this.bottomSheetCallback = new c(this);
        supportRequestWindowFeature(1);
    }

    protected BottomSheetDialog(@NonNull Context r10, boolean r11, DialogInterface.OnCancelListener r12) {
        super(r10, r11, r12);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.is69Expandable = false;
        this.callbacks = new ArrayList();
        this.bottomSheetCallback = new c(this);
        supportRequestWindowFeature(1);
        this.cancelable = r11;
    }

    static /* synthetic */ List access$000(BottomSheetDialog r10) {
        return r10.callbacks;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L9;
        FrameLayout r10 = (FrameLayout) View.inflate(getContext(), h.o_bottom_sheet_dialog, null);
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
    L9:
        return this.container;
    }

    private static int getThemeResId(@NonNull Context r10, int r11) {
        if (r11 != 0) goto L8;
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(u8.b.bottomSheetDialogTheme, r12, true) == false) goto L7;
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

    public void adaptPortraitRLSlide(boolean r10) {
        getBehavior().setAdaptPortraitRLSlide(r10);
    }

    public void addBottomSheetCallback(BottomSheetBehavior.d r10) {
        this.callbacks.add(r10);
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

    public void clearBottomSheetCallback() {
        this.callbacks.clear();
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    public FrameLayout getBottomSheet() {
        if (this.bottomSheet != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.bottomSheet;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getIs69Expandable() {
        return this.is69Expandable;
    }

    public boolean isPadCompatEnabled() {
        return false;
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
        if (r10.getState() != 5) goto L13;
        boolean r11 = this.is69Expandable;
        BottomSheetBehavior<FrameLayout> r12 = this.behavior;
        if (r11 == false) goto L9;
        int r13 = 4;
    L10:
        r12.setState(r13);
        return;
    L9:
        r13 = 3;
        goto L10
    }

    public void removeBottomSheetCallback(BottomSheetBehavior.d r10) {
        this.callbacks.remove(r10);
    }

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public void setBottomSheetCallback(BottomSheetBehavior.d r10) {
        this.callbacks.add(r10);
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
