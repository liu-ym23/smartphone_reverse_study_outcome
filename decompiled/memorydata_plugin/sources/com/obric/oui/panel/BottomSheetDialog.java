package com.obric.oui.panel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.a bottomSheetCallback;
    private final List<BottomSheetBehavior.a> callbacks;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private boolean is69Expandable;

    public BottomSheetDialog(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 0);
    }

    public BottomSheetDialog(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r5, getThemeResId(r5, r4));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.is69Expandable = false;
        this.callbacks = new ArrayList();
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
    }

    public BottomSheetDialog(Context r3, boolean r4, DialogInterface.OnCancelListener r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin"));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.is69Expandable = false;
        this.callbacks = new ArrayList();
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.cancelable = r4;
    }

    static /* synthetic */ List access$000(BottomSheetDialog r0) {
        return r0.callbacks;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L9;
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_bottom_sheet_dialog, "layout", "o_bottom_sheet_dialog"), null, "com.obric.memorydata.plugin"), FrameLayout.class, "com.obric.memorydata.plugin");
        this.container = r0;
        this.coordinator = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.coordinator, OaidModel.KEY_ID, "coordinator")), CoordinatorLayout.class, "com.obric.memorydata.plugin");
        this.bottomSheet = (FrameLayout) ZeusTransformUtils.preCheckCast(this.container.findViewById(ZeusTransformUtils.mapRes(R.id.design_bottom_sheet, OaidModel.KEY_ID, "design_bottom_sheet")), FrameLayout.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L7;
        this.bottomSheet.setAccessibilityPaneTitle("");
    L7:
        BottomSheetBehavior<FrameLayout> r1 = BottomSheetBehavior.from(this.bottomSheet);
        this.behavior = r1;
        r1.setBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
    L9:
        return this.container;
    }

    private static int getThemeResId(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != 0) goto L9;
        TypedValue r6 = new TypedValue();
        if (r5.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.bottomSheetDialogTheme, "attr", "bottomSheetDialogTheme"), r6, true) == false) goto L8;
        return r6.resourceId;
    L8:
        return ZeusTransformUtils.mapRes(R.style.Theme_Design_Light_BottomSheetDialog, "style", "Theme_Design_Light_BottomSheetDialog");
    L9:
        return r4;
    }

    private View wrapInBottomSheet(int r5, View r6, ViewGroup.LayoutParams r7) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(this.container.findViewById(ZeusTransformUtils.mapRes(R.id.coordinator, OaidModel.KEY_ID, "coordinator")), CoordinatorLayout.class, "com.obric.memorydata.plugin");
        if (r5 == 0) goto L6;
        if (r6 != null) goto L6;
        r6 = ZeusTransformUtils.inflate(getLayoutInflater(), r5, r0, false, "com.obric.memorydata.plugin");
    L6:
        this.bottomSheet.removeAllViews();
        if (this.is69Expandable == false) goto L10;
        if (r7 != null) goto L10;
        r7 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        FrameLayout r8 = this.bottomSheet;
        if (r7 != null) goto L13;
        r8.addView(r6);
    L14:
        r0.findViewById(ZeusTransformUtils.mapRes(R.id.touch_outside, OaidModel.KEY_ID, "touch_outside")).setOnClickListener(new AnonymousClass1(this));
        r0.findViewById(ZeusTransformUtils.mapRes(R.id.touch_outside, OaidModel.KEY_ID, "touch_outside")).setAccessibilityDelegate(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new AnonymousClass4(this));
        return this.container;
    L13:
        r8.addView(r6, r7);
        goto L14
    }

    public void adaptPortraitRLSlide(boolean r1) {
        getBehavior().setAdaptPortraitRLSlide(r1);
    }

    public void addBottomSheetCallback(BottomSheetBehavior.a r1) {
        this.callbacks.add(r1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r0 = getBehavior();
        if (this.dismissWithAnimation == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r0.getState() == 5) goto L8;
        r0.setState(5);
    }

    public void clearBottomSheetCallback() {
        this.callbacks.clear();
    }

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
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        Window r1 = getWindow();
        if (r1 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        r1.setStatusBarColor(0);
        r1.addFlags(Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        r1.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    L9:
        r1.setLayout(-1, -1);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r0 = this.behavior;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != 5) goto L13;
        boolean r1 = this.is69Expandable;
        BottomSheetBehavior<FrameLayout> r2 = this.behavior;
        if (r1 == false) goto L9;
        int r3 = 4;
    L10:
        r2.setState(r3);
        return;
    L9:
        r3 = 3;
        goto L10
    }

    public void removeBottomSheetCallback(BottomSheetBehavior.a r1) {
        this.callbacks.remove(r1);
    }

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public void setBottomSheetCallback(BottomSheetBehavior.a r1) {
        this.callbacks.add(r1);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r2) {
        super.setCancelable(r2);
        if (this.cancelable == r2) goto L8;
        this.cancelable = r2;
        BottomSheetBehavior<FrameLayout> r1 = this.behavior;
        if (r1 == null) goto L9;
        r1.setHideable(r2);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r3) {
        super.setCanceledOnTouchOutside(r3);
        if (r3 == true) goto L5;
    L7:
        this.canceledOnTouchOutside = r3;
        this.canceledOnTouchOutsideSet = true;
        return;
    L5:
        if (this.cancelable == true) goto L7;
        this.cancelable = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r3) {
        super.setContentView(wrapInBottomSheet(0, r3, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(wrapInBottomSheet(0, r2, r3));
    }

    public void setDismissWithAnimation(boolean r1) {
        this.dismissWithAnimation = r1;
    }

    public void setIs69Expandable(boolean r1) {
        this.is69Expandable = r1;
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r0.getBoolean(0, true);
        r0.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }
}
