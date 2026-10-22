package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.sidesheet.SheetCallback;

/* JADX INFO: loaded from: classes2.dex */
abstract class SheetDialog<C extends SheetCallback> extends AppCompatDialog {
    private static final int COORDINATOR_LAYOUT_ID = 0;
    private static final int TOUCH_OUTSIDE_ID = 0;

    @Nullable
    private MaterialBackOrchestrator backOrchestrator;

    @Nullable
    private Sheet<C> behavior;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;

    @Nullable
    private FrameLayout container;
    boolean dismissWithAnimation;

    @Nullable
    private FrameLayout sheet;

    static {
        COORDINATOR_LAYOUT_ID = R.id.coordinator;
        TOUCH_OUTSIDE_ID = R.id.touch_outside;
    }

    public SheetDialog(@NonNull Context r5, @StyleRes int r10, @AttrRes int r11, @StyleRes int r12) {
        super(r5, getThemeResId(r5, r10, r11, r12));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        supportRequestWindowFeature(1);
    }

    public static /* synthetic */ void b(SheetDialog r5, View r10) {
        r5.lambda$wrapInSheet$0(r10);
    }

    private void ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r5 = (FrameLayout) View.inflate(getContext(), getLayoutResId(), null);
        this.container = r5;
        FrameLayout r10 = (FrameLayout) r5.findViewById(getDialogId());
        this.sheet = r10;
        Sheet<C> r11 = getBehaviorFromSheet(r10);
        this.behavior = r11;
        addSheetCancelOnHideCallback(r11);
        this.backOrchestrator = new MaterialBackOrchestrator(this.behavior, this.sheet);
        return;
    }

    @NonNull
    private FrameLayout getContainer() {
        if (this.container != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.container;
    }

    @NonNull
    private FrameLayout getSheet() {
        if (this.sheet != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.sheet;
    }

    private static int getThemeResId(@NonNull Context r5, @StyleRes int r10, @AttrRes int r11, @StyleRes int r12) {
        if (r10 != 0) goto L8;
        TypedValue r13 = new TypedValue();
        if (r5.getTheme().resolveAttribute(r11, r13, true) == false) goto L7;
        return r13.resourceId;
    L7:
        return r12;
    L8:
        return r10;
    }

    private /* synthetic */ void lambda$wrapInSheet$0(View r5) {
        if (this.cancelable == true) goto L5;
        return;
    L5:
        if (isShowing() == true) goto L7;
        return;
    L7:
        if (shouldWindowCloseOnTouchOutside() == false) goto L12;
        cancel();
        return;
    }

    private void maybeUpdateWindowAnimationsBasedOnLayoutDirection() {
        Window r5 = getWindow();
        if (r5 == null) goto L14;
        FrameLayout r10 = this.sheet;
        if (r10 != null) goto L7;
        return;
    L7:
        if ((r10.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L9;
        return;
    L9:
        if (GravityCompat.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) this.sheet.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this.sheet)) != 3) goto L11;
        int r11 = R.style.Animation_Material3_SideSheetDialog_Left;
    L12:
        r5.setWindowAnimations(r11);
        return;
    L11:
        r11 = R.style.Animation_Material3_SideSheetDialog_Right;
        goto L12
    }

    private boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r5 = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r5.getBoolean(0, true);
        r5.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    private void updateListeningForBackCallbacks() {
        MaterialBackOrchestrator r5 = this.backOrchestrator;
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.cancelable == false) goto L8;
        r5.startListeningForBackCallbacks();
        return;
    L8:
        r5.stopListeningForBackCallbacks();
    }

    private View wrapInSheet(int r5, @Nullable View r10, @Nullable ViewGroup.LayoutParams r11) {
        ensureContainerAndBehavior();
        CoordinatorLayout r12 = (CoordinatorLayout) getContainer().findViewById(COORDINATOR_LAYOUT_ID);
        if (r5 == 0) goto L6;
        if (r10 != null) goto L6;
        r10 = getLayoutInflater().inflate(r5, r12, false);
    L6:
        FrameLayout r13 = getSheet();
        r13.removeAllViews();
        if (r11 != null) goto L9;
        r13.addView(r10);
    L10:
        r12.findViewById(TOUCH_OUTSIDE_ID).setOnClickListener(new a(this));
        ViewCompat.setAccessibilityDelegate(getSheet(), new AnonymousClass1(this));
        return this.container;
    L9:
        r13.addView(r10, r11);
        goto L10
    }

    public abstract void addSheetCancelOnHideCallback(Sheet<C> r5);

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Sheet<C> r5 = getBehavior();
        if (this.dismissWithAnimation == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r5.getState() == 5) goto L8;
        r5.setState(5);
    }

    @NonNull
    public Sheet<C> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    @NonNull
    public abstract Sheet<C> getBehaviorFromSheet(@NonNull FrameLayout r5);

    @IdRes
    public abstract int getDialogId();

    @LayoutRes
    public abstract int getLayoutResId();

    public abstract int getStateOnStart();

    public boolean isDismissWithSheetAnimationEnabled() {
        return this.dismissWithAnimation;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeUpdateWindowAnimationsBasedOnLayoutDirection();
        updateListeningForBackCallbacks();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        Window r10 = getWindow();
        if (r10 == null) goto L6;
        r10.setStatusBarColor(0);
        r10.addFlags(Integer.MIN_VALUE);
        r10.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaterialBackOrchestrator r5 = this.backOrchestrator;
        if (r5 == null) goto L6;
        r5.stopListeningForBackCallbacks();
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        Sheet<C> r5 = this.behavior;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getState() != 5) goto L9;
        this.behavior.setState(getStateOnStart());
        return;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r5) {
        super.setCancelable(r5);
        if (this.cancelable == r5) goto L6;
        this.cancelable = r5;
    L6:
        if (getWindow() == null) goto L9;
        updateListeningForBackCallbacks();
        return;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r5) {
        super.setCanceledOnTouchOutside(r5);
        if (r5 == true) goto L5;
    L7:
        this.canceledOnTouchOutside = r5;
        this.canceledOnTouchOutsideSet = true;
        return;
    L5:
        if (this.cancelable == true) goto L7;
        this.cancelable = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@LayoutRes int r5) {
        super.setContentView(wrapInSheet(r5, null, null));
    }

    public void setDismissWithSheetAnimationEnabled(boolean r5) {
        this.dismissWithAnimation = r5;
    }

    public void setSheetEdge(@GravityInt int r5) {
        FrameLayout r10 = this.sheet;
        if (r10 == null) goto L13;
        if (ViewCompat.isLaidOut(r10) == true) goto L11;
        ViewGroup.LayoutParams r11 = this.sheet.getLayoutParams();
        if ((r11 instanceof CoordinatorLayout.LayoutParams) == false) goto L14;
        ((CoordinatorLayout.LayoutParams) r11).gravity = r5;
        maybeUpdateWindowAnimationsBasedOnLayoutDirection();
        return;
    L14:
        return;
    L11:
        throw new IllegalStateException("Sheet view has been laid out; sheet edge cannot be changed once the sheet has been laid out.");
    L13:
        throw new IllegalStateException("Sheet view reference is null; sheet edge cannot be changed if the sheet view is null.");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@Nullable View r5) {
        super.setContentView(wrapInSheet(0, r5, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@Nullable View r5, @Nullable ViewGroup.LayoutParams r10) {
        super.setContentView(wrapInSheet(0, r5, r10));
    }
}
