package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import q5.f;
import q5.h;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDialog extends AppCompatDialog {
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
    private BottomSheetBehavior.d edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialog f3056c;

        a(BottomSheetDialog r10) {
            this.f3056c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            BottomSheetDialog r11 = this.f3056c;
            if (r11.cancelable == true) goto L5;
            return;
        L5:
            if (r11.isShowing() == true) goto L7;
            return;
        L7:
            if (this.f3056c.shouldWindowCloseOnTouchOutside() == false) goto L12;
            this.f3056c.cancel();
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
        final /* synthetic */ BottomSheetDialog f3057a;

        c(BottomSheetDialog r10) {
            this.f3057a = r10;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void b(@NonNull View r10, float r11) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void c(@NonNull View r10, int r11) {
            if (r11 != 5) goto L6;
            this.f3057a.cancel();
            return;
        }
    }

    private static class d extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f3058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WindowInsetsCompat f3060c;

        private d(@NonNull View r10, @NonNull WindowInsetsCompat r11) {
            this.f3060c = r11;
            if (Build.VERSION.SDK_INT >= 23) goto L5;
        L7:
            boolean r12 = false;
        L8:
            this.f3059b = r12;
            MaterialShapeDrawable r13 = BottomSheetBehavior.from(r10).getMaterialShapeDrawable();
            if (r13 == null) goto L11;
            ColorStateList r14 = r13.getFillColor();
        L12:
            if (r14 == null) goto L16;
            int r15 = r14.getDefaultColor();
        L14:
            this.f3058a = t5.a.f(r15);
            return;
        L16:
            if ((r10.getBackground() instanceof ColorDrawable) == false) goto L18;
            r15 = ((ColorDrawable) r10.getBackground()).getColor();
            goto L14
        L18:
            this.f3058a = r12;
            return;
        L11:
            r14 = ViewCompat.getBackgroundTintList(r10);
            goto L12
        L5:
            if ((r10.getSystemUiVisibility() & 8192) == 0) goto L7;
            r12 = true;
            goto L8
        }

        /* synthetic */ d(View r10, WindowInsetsCompat r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private void d(View r10) {
            if (r10.getTop() >= this.f3060c.getSystemWindowInsetTop()) goto L6;
            BottomSheetDialog.setLightStatusBar(r10, this.f3058a);
            r10.setPadding(r10.getPaddingLeft(), this.f3060c.getSystemWindowInsetTop() - r10.getTop(), r10.getPaddingRight(), r10.getPaddingBottom());
            return;
        L6:
            if (r10.getTop() == 0) goto L10;
            BottomSheetDialog.setLightStatusBar(r10, this.f3059b);
            r10.setPadding(r10.getPaddingLeft(), 0, r10.getPaddingRight(), r10.getPaddingBottom());
            return;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        void a(@NonNull View r10) {
            d(r10);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void b(@NonNull View r10, float r11) {
            d(r10);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void c(@NonNull View r10, int r11) {
            d(r10);
        }
    }

    public BottomSheetDialog(@NonNull Context r10) {
        this(r10, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{q5.b.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(@NonNull Context r10, @StyleRes int r11) {
        super(r10, getThemeResId(r10, r11));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new c(this);
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{q5.b.enableEdgeToEdge}).getBoolean(0, false);
    }

    protected BottomSheetDialog(@NonNull Context r10, boolean r11, DialogInterface.OnCancelListener r12) {
        super(r10, r11, r12);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new c(this);
        supportRequestWindowFeature(1);
        this.cancelable = r11;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{q5.b.enableEdgeToEdge}).getBoolean(0, false);
    }

    static /* synthetic */ BottomSheetBehavior.d access$000(BottomSheetDialog r10) {
        return r10.edgeToEdgeCallback;
    }

    static /* synthetic */ BottomSheetBehavior.d access$002(BottomSheetDialog r10, BottomSheetBehavior.d r11) {
        r10.edgeToEdgeCallback = r11;
        return r11;
    }

    static /* synthetic */ BottomSheetBehavior access$100(BottomSheetDialog r10) {
        return r10.behavior;
    }

    static /* synthetic */ FrameLayout access$200(BottomSheetDialog r10) {
        return r10.bottomSheet;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r10 = (FrameLayout) View.inflate(getContext(), h.design_bottom_sheet_dialog, null);
        this.container = r10;
        this.coordinator = (CoordinatorLayout) r10.findViewById(f.coordinator);
        FrameLayout r11 = (FrameLayout) this.container.findViewById(f.design_bottom_sheet);
        this.bottomSheet = r11;
        BottomSheetBehavior<FrameLayout> r12 = BottomSheetBehavior.from(r11);
        this.behavior = r12;
        r12.addBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
    L6:
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

    public static void setLightStatusBar(@NonNull View r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        int r12 = r10.getSystemUiVisibility();
        if (r11 == false) goto L7;
        int r13 = r12 | 8192;
    L8:
        r10.setSystemUiVisibility(r13);
        return;
    L7:
        r13 = r12 & (-8193);
        goto L8
    }

    private View wrapInBottomSheet(int r10, @Nullable View r11, @Nullable ViewGroup.LayoutParams r12) {
        ensureContainerAndBehavior();
        CoordinatorLayout r13 = (CoordinatorLayout) this.container.findViewById(f.coordinator);
        if (r10 == 0) goto L7;
        if (r11 != null) goto L7;
        r11 = getLayoutInflater().inflate(r10, r13, false);
    L7:
        if (this.edgeToEdgeEnabled == false) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new AnonymousClass1(this));
    L9:
        this.bottomSheet.removeAllViews();
        FrameLayout r14 = this.bottomSheet;
        if (r12 != null) goto L12;
        r14.addView(r11);
    L13:
        r13.findViewById(f.touch_outside).setOnClickListener(new a(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new b(this));
        return this.container;
    L12:
        r14.addView(r11, r12);
        goto L13
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

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window r10 = getWindow();
        if (r10 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        return;
    L7:
        if (this.edgeToEdgeEnabled == true) goto L9;
    L11:
        boolean r11 = false;
    L12:
        FrameLayout r12 = this.container;
        if (r12 == null) goto L15;
        r12.setFitsSystemWindows(!r11);
    L15:
        CoordinatorLayout r13 = this.coordinator;
        if (r13 == null) goto L18;
        r13.setFitsSystemWindows(!r11);
    L18:
        if (r11 == false) goto L23;
        r10.getDecorView().setSystemUiVisibility(768);
        return;
    L23:
        return;
    L9:
        if (Color.alpha(r10.getNavigationBarColor()) >= 255) goto L11;
        r11 = true;
        goto L12
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

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
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
