package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.a bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private BottomSheetBehavior.a edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    private static class a extends BottomSheetBehavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f3813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3814b;
        private final WindowInsetsCompat c;

        private a(View r3, WindowInsetsCompat r4) {
            this.c = r4;
            if (Build.VERSION.SDK_INT >= 23) goto L5;
        L7:
            boolean r5 = false;
        L8:
            this.f3814b = r5;
            MaterialShapeDrawable r0 = BottomSheetBehavior.from(r3).getMaterialShapeDrawable();
            if (r0 == null) goto L11;
            ColorStateList r1 = r0.getFillColor();
        L12:
            if (r1 == null) goto L16;
            int r6 = r1.getDefaultColor();
        L14:
            this.f3813a = com.google.android.material.c.a.a(r6);
            return;
        L16:
            if (ZeusTransformUtils.instanceOf(r3.getBackground(), ColorDrawable.class) == false) goto L18;
            r6 = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r3.getBackground(), ColorDrawable.class, "com.obric.memorydata.plugin")).getColor();
            goto L14
        L18:
            this.f3813a = r5;
            return;
        L11:
            r1 = ViewCompat.getBackgroundTintList(r3);
            goto L12
        L5:
            if ((r3.getSystemUiVisibility() & 8192) == 0) goto L7;
            r5 = true;
            goto L8
        }

        /* synthetic */ a(View r1, WindowInsetsCompat r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private void b(View r4) {
            if (r4.getTop() >= this.c.getSystemWindowInsetTop()) goto L6;
            BottomSheetDialog.setLightStatusBar(r4, this.f3813a);
            r4.setPadding(r4.getPaddingLeft(), this.c.getSystemWindowInsetTop() - r4.getTop(), r4.getPaddingRight(), r4.getPaddingBottom());
            return;
        L6:
            if (r4.getTop() == 0) goto L10;
            BottomSheetDialog.setLightStatusBar(r4, this.f3814b);
            r4.setPadding(r4.getPaddingLeft(), 0, r4.getPaddingRight(), r4.getPaddingBottom());
            return;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        void a(View r1) {
            b(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void a(View r1, float r2) {
            b(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void a(View r1, int r2) {
            b(r1);
        }
    }

    public BottomSheetDialog(Context r6) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), 0);
        this.edgeToEdgeEnabled = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(new int[]{ZeusTransformUtils.mapRes(R.attr.enableEdgeToEdge, "attr", "enableEdgeToEdge")}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r6, getThemeResId(r6, r5));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(new int[]{ZeusTransformUtils.mapRes(R.attr.enableEdgeToEdge, "attr", "enableEdgeToEdge")}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context r3, boolean r4, DialogInterface.OnCancelListener r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin"));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.cancelable = r4;
        this.edgeToEdgeEnabled = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(new int[]{ZeusTransformUtils.mapRes(R.attr.enableEdgeToEdge, "attr", "enableEdgeToEdge")}).getBoolean(0, false);
    }

    static /* synthetic */ BottomSheetBehavior.a access$000(BottomSheetDialog r0) {
        return r0.edgeToEdgeCallback;
    }

    static /* synthetic */ BottomSheetBehavior.a access$002(BottomSheetDialog r0, BottomSheetBehavior.a r1) {
        r0.edgeToEdgeCallback = r1;
        return r1;
    }

    static /* synthetic */ BottomSheetBehavior access$100(BottomSheetDialog r0) {
        return r0.behavior;
    }

    static /* synthetic */ FrameLayout access$200(BottomSheetDialog r0) {
        return r0.bottomSheet;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.design_bottom_sheet_dialog, "layout", "design_bottom_sheet_dialog"), null, "com.obric.memorydata.plugin"), FrameLayout.class, "com.obric.memorydata.plugin");
        this.container = r0;
        this.coordinator = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.coordinator, OaidModel.KEY_ID, "coordinator")), CoordinatorLayout.class, "com.obric.memorydata.plugin");
        FrameLayout r1 = (FrameLayout) ZeusTransformUtils.preCheckCast(this.container.findViewById(ZeusTransformUtils.mapRes(R.id.design_bottom_sheet, OaidModel.KEY_ID, "design_bottom_sheet")), FrameLayout.class, "com.obric.memorydata.plugin");
        this.bottomSheet = r1;
        BottomSheetBehavior<FrameLayout> r2 = BottomSheetBehavior.from(r1);
        this.behavior = r2;
        r2.addBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
    L6:
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

    public static void setLightStatusBar(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        int r0 = r2.getSystemUiVisibility();
        if (r3 == false) goto L7;
        int r4 = r0 | 8192;
    L8:
        r2.setSystemUiVisibility(r4);
        return;
    L7:
        r4 = r0 & (-8193);
        goto L8
    }

    private View wrapInBottomSheet(int r5, View r6, ViewGroup.LayoutParams r7) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) ZeusTransformUtils.preCheckCast(this.container.findViewById(ZeusTransformUtils.mapRes(R.id.coordinator, OaidModel.KEY_ID, "coordinator")), CoordinatorLayout.class, "com.obric.memorydata.plugin");
        if (r5 == 0) goto L7;
        if (r6 != null) goto L7;
        r6 = ZeusTransformUtils.inflate(getLayoutInflater(), r5, r0, false, "com.obric.memorydata.plugin");
    L7:
        if (this.edgeToEdgeEnabled == false) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new AnonymousClass1(this));
    L9:
        this.bottomSheet.removeAllViews();
        FrameLayout r8 = this.bottomSheet;
        if (r7 != null) goto L12;
        r8.addView(r6);
    L13:
        r0.findViewById(ZeusTransformUtils.mapRes(R.id.touch_outside, OaidModel.KEY_ID, "touch_outside")).setOnClickListener(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new AnonymousClass4(this));
        return this.container;
    L12:
        r8.addView(r6, r7);
        goto L13
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

    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        return;
    L7:
        if (this.edgeToEdgeEnabled == true) goto L9;
    L11:
        boolean r1 = false;
    L12:
        FrameLayout r2 = this.container;
        if (r2 == null) goto L15;
        r2.setFitsSystemWindows(!r1);
    L15:
        CoordinatorLayout r4 = this.coordinator;
        if (r4 == null) goto L18;
        r4.setFitsSystemWindows(!r1);
    L18:
        if (r1 == false) goto L23;
        r0.getDecorView().setSystemUiVisibility(768);
        return;
    L23:
        return;
    L9:
        if (Color.alpha(r0.getNavigationBarColor()) >= 255) goto L11;
        r1 = true;
        goto L12
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
        if (r0.getState() != 5) goto L9;
        this.behavior.setState(4);
        return;
    }

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
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
