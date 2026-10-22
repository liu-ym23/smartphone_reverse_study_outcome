package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
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
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {

    @Nullable
    private MaterialBackOrchestrator backOrchestrator;
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;

    @NonNull
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private EdgeToEdgeCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    public static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {

        @NonNull
        private final WindowInsetsCompat insetsCompat;

        @Nullable
        private final Boolean lightBottomSheet;
        private boolean lightStatusBar;

        @Nullable
        private Window window;

        public /* synthetic */ EdgeToEdgeCallback(View r5, WindowInsetsCompat r10, AnonymousClass1 r11) {
            this(r5, r10);
        }

        private void setPaddingForPosition(View r5) {
            if (r5.getTop() >= this.insetsCompat.getSystemWindowInsetTop()) goto L13;
            Window r10 = this.window;
            if (r10 == null) goto L11;
            Boolean r11 = this.lightBottomSheet;
            if (r11 != null) goto L9;
            boolean r12 = this.lightStatusBar;
        L10:
            EdgeToEdgeUtils.setLightStatusBar(r10, r12);
            goto L11
        L9:
            r12 = r11.booleanValue();
        L11:
            r5.setPadding(r5.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - r5.getTop(), r5.getPaddingRight(), r5.getPaddingBottom());
            return;
        L13:
            if (r5.getTop() == 0) goto L20;
            Window r13 = this.window;
            if (r13 == null) goto L17;
            EdgeToEdgeUtils.setLightStatusBar(r13, this.lightStatusBar);
        L17:
            r5.setPadding(r5.getPaddingLeft(), 0, r5.getPaddingRight(), r5.getPaddingBottom());
            return;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onLayout(@NonNull View r5) {
            setPaddingForPosition(r5);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View r5, float r10) {
            setPaddingForPosition(r5);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View r5, int r10) {
            setPaddingForPosition(r5);
        }

        public void setWindow(@Nullable Window r5) {
            if (this.window != r5) goto L5;
            return;
        L5:
            this.window = r5;
            if (r5 == null) goto L9;
            this.lightStatusBar = WindowCompat.getInsetsController(r5, r5.getDecorView()).isAppearanceLightStatusBars();
            return;
        }

        private EdgeToEdgeCallback(@NonNull View r5, @NonNull WindowInsetsCompat r10) {
            this.insetsCompat = r10;
            MaterialShapeDrawable r11 = BottomSheetBehavior.from(r5).getMaterialShapeDrawable();
            if (r11 == null) goto L5;
            ColorStateList r12 = r11.getFillColor();
        L6:
            if (r12 == null) goto L8;
            this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(r12.getDefaultColor()));
            return;
        L8:
            Integer r13 = ViewUtils.getBackgroundColor(r5);
            if (r13 == null) goto L11;
            this.lightBottomSheet = Boolean.valueOf(MaterialColors.isColorLight(r13.intValue()));
            return;
        L11:
            this.lightBottomSheet = null;
            return;
        L5:
            r12 = ViewCompat.getBackgroundTintList(r5);
            goto L6
        }
    }

    public BottomSheetDialog(@NonNull Context r5) {
        this(r5, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public static /* synthetic */ EdgeToEdgeCallback access$000(BottomSheetDialog r5) {
        return r5.edgeToEdgeCallback;
    }

    public static /* synthetic */ EdgeToEdgeCallback access$002(BottomSheetDialog r5, EdgeToEdgeCallback r10) {
        r5.edgeToEdgeCallback = r10;
        return r10;
    }

    public static /* synthetic */ BottomSheetBehavior access$100(BottomSheetDialog r5) {
        return r5.behavior;
    }

    public static /* synthetic */ FrameLayout access$200(BottomSheetDialog r5) {
        return r5.bottomSheet;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r5 = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        this.container = r5;
        this.coordinator = (CoordinatorLayout) r5.findViewById(R.id.coordinator);
        FrameLayout r10 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
        this.bottomSheet = r10;
        BottomSheetBehavior<FrameLayout> r11 = BottomSheetBehavior.from(r10);
        this.behavior = r11;
        r11.addBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
        this.backOrchestrator = new MaterialBackOrchestrator(this.behavior, this.bottomSheet);
    L6:
        return this.container;
    }

    private static int getThemeResId(@NonNull Context r5, int r10) {
        if (r10 != 0) goto L8;
        TypedValue r11 = new TypedValue();
        if (r5.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, r11, true) == false) goto L7;
        return r11.resourceId;
    L7:
        return R.style.Theme_Design_Light_BottomSheetDialog;
    L8:
        return r10;
    }

    @Deprecated
    public static void setLightStatusBar(@NonNull View r5, boolean r10) {
        int r11 = r5.getSystemUiVisibility();
        if (r10 == false) goto L5;
        int r12 = r11 | 8192;
    L6:
        r5.setSystemUiVisibility(r12);
        return;
    L5:
        r12 = r11 & (-8193);
        goto L6
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

    private View wrapInBottomSheet(int r5, @Nullable View r10, @Nullable ViewGroup.LayoutParams r11) {
        ensureContainerAndBehavior();
        CoordinatorLayout r12 = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (r5 == 0) goto L7;
        if (r10 != null) goto L7;
        r10 = getLayoutInflater().inflate(r5, r12, false);
    L7:
        if (this.edgeToEdgeEnabled == false) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new AnonymousClass1(this));
    L9:
        this.bottomSheet.removeAllViews();
        if (r11 != null) goto L12;
        this.bottomSheet.addView(r10);
    L13:
        r12.findViewById(R.id.touch_outside).setOnClickListener(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new AnonymousClass4(this));
        return this.container;
    L12:
        this.bottomSheet.addView(r10, r11);
        goto L13
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r5 = getBehavior();
        if (this.dismissWithAnimation == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r5.getState() == 5) goto L8;
        r5.setState(5);
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

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window r5 = getWindow();
        if (r5 != null) goto L5;
    L19:
        updateListeningForBackCallbacks();
        return;
    L5:
        if (this.edgeToEdgeEnabled == true) goto L7;
    L9:
        boolean r10 = false;
    L10:
        FrameLayout r11 = this.container;
        if (r11 == null) goto L13;
        r11.setFitsSystemWindows(!r10);
    L13:
        CoordinatorLayout r12 = this.coordinator;
        if (r12 == null) goto L16;
        r12.setFitsSystemWindows(!r10);
    L16:
        WindowCompat.setDecorFitsSystemWindows(r5, !r10);
        EdgeToEdgeCallback r13 = this.edgeToEdgeCallback;
        if (r13 == null) goto L19;
        r13.setWindow(r5);
        goto L19
    L7:
        if (Color.alpha(r5.getNavigationBarColor()) >= 255) goto L9;
        r10 = true;
        goto L10
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

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        EdgeToEdgeCallback r5 = this.edgeToEdgeCallback;
        if (r5 == null) goto L5;
        r5.setWindow(null);
    L5:
        MaterialBackOrchestrator r10 = this.backOrchestrator;
        if (r10 == null) goto L9;
        r10.stopListeningForBackCallbacks();
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r5 = this.behavior;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getState() != 5) goto L9;
        this.behavior.setState(4);
        return;
    }

    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r5) {
        super.setCancelable(r5);
        if (this.cancelable == r5) goto L11;
        this.cancelable = r5;
        BottomSheetBehavior<FrameLayout> r10 = this.behavior;
        if (r10 == null) goto L8;
        r10.setHideable(r5);
    L8:
        if (getWindow() == null) goto L12;
        updateListeningForBackCallbacks();
        return;
    L12:
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
        super.setContentView(wrapInBottomSheet(r5, null, null));
    }

    public void setDismissWithAnimation(boolean r5) {
        this.dismissWithAnimation = r5;
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r5 = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r5.getBoolean(0, true);
        r5.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r5) {
        super.setContentView(wrapInBottomSheet(0, r5, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r5, ViewGroup.LayoutParams r10) {
        super.setContentView(wrapInBottomSheet(0, r5, r10));
    }

    public BottomSheetDialog(@NonNull Context r5, @StyleRes int r10) {
        super(r5, getThemeResId(r5, r10));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(@NonNull Context r5, boolean r10, DialogInterface.OnCancelListener r11) {
        super(r5, r10, r11);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.cancelable = r10;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
