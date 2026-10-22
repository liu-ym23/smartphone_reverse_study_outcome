package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;

/* JADX INFO: loaded from: classes.dex */
class DropdownMenuEndIconDelegate extends com.google.android.material.textfield.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final boolean f3874r = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextWatcher f3875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f3876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.AccessibilityDelegate f3877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextInputLayout.e f3878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SuppressLint({"ClickableViewAccessibility"})
    private final TextInputLayout.f f3879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f3882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private StateListDrawable f3883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MaterialShapeDrawable f3884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private AccessibilityManager f3885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueAnimator f3886p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f3887q;

    class a extends com.google.android.material.internal.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3888c;

        /* JADX INFO: renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$a$a, reason: collision with other inner class name */
        class RunnableC0086a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f3889c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ a f3890g;

            RunnableC0086a(a r10, AutoCompleteTextView r11) {
                this.f3890g = r10;
                this.f3889c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean r10 = this.f3889c.isPopupShowing();
                DropdownMenuEndIconDelegate.o(this.f3890g.f3888c, r10);
                DropdownMenuEndIconDelegate.p(this.f3890g.f3888c, r10);
            }
        }

        a(DropdownMenuEndIconDelegate r10) {
            this.f3888c = r10;
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            AutoCompleteTextView r11 = DropdownMenuEndIconDelegate.e(this.f3888c.f3973a.getEditText());
            if (DropdownMenuEndIconDelegate.f(this.f3888c).isTouchExplorationEnabled() == true) goto L5;
        L9:
            r11.post(new RunnableC0086a(this, r11));
            return;
        L5:
            if (DropdownMenuEndIconDelegate.n(r11) == false) goto L9;
            if (this.f3888c.f3975c.hasFocus() == true) goto L9;
            r11.dismissDropDown();
            goto L9
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3891c;

        b(DropdownMenuEndIconDelegate r10) {
            this.f3891c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            DropdownMenuEndIconDelegate r11 = this.f3891c;
            r11.f3975c.setChecked(DropdownMenuEndIconDelegate.l(r11));
            DropdownMenuEndIconDelegate.m(this.f3891c).start();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3892c;

        c(DropdownMenuEndIconDelegate r10) {
            this.f3892c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f3892c.f3975c.setAlpha(r11);
        }
    }

    class d implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3893c;

        d(DropdownMenuEndIconDelegate r10) {
            this.f3893c = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r10, boolean r11) {
            this.f3893c.f3973a.setEndIconActivated(r11);
            if (r11 == true) goto L6;
            DropdownMenuEndIconDelegate.o(this.f3893c, false);
            DropdownMenuEndIconDelegate.p(this.f3893c, false);
            return;
        }
    }

    class e implements TextInputLayout.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3894a;

        e(DropdownMenuEndIconDelegate r10) {
            this.f3894a = r10;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e
        public void a(@NonNull TextInputLayout r10) {
            AutoCompleteTextView r11 = DropdownMenuEndIconDelegate.e(r10.getEditText());
            DropdownMenuEndIconDelegate.s(this.f3894a, r11);
            DropdownMenuEndIconDelegate.t(this.f3894a, r11);
            DropdownMenuEndIconDelegate.u(this.f3894a, r11);
            r11.setThreshold(0);
            r11.removeTextChangedListener(DropdownMenuEndIconDelegate.g(this.f3894a));
            r11.addTextChangedListener(DropdownMenuEndIconDelegate.g(this.f3894a));
            r10.setEndIconCheckable(true);
            r10.setErrorIconDrawable(null);
            if (DropdownMenuEndIconDelegate.n(r11) == false) goto L5;
        L7:
            r10.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.h(this.f3894a));
            r10.setEndIconVisible(true);
            return;
        L5:
            if (DropdownMenuEndIconDelegate.f(this.f3894a).isTouchExplorationEnabled() == false) goto L7;
            ViewCompat.setImportantForAccessibility(this.f3894a.f3975c, 2);
            goto L7
        }
    }

    class f implements TextInputLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3895a;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f3896c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ f f3897g;

            a(f r10, AutoCompleteTextView r11) {
                this.f3897g = r10;
                this.f3896c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3896c.removeTextChangedListener(DropdownMenuEndIconDelegate.g(this.f3897g.f3895a));
            }
        }

        f(DropdownMenuEndIconDelegate r10) {
            this.f3895a = r10;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(@NonNull TextInputLayout r10, int r11) {
            AutoCompleteTextView r12 = (AutoCompleteTextView) r10.getEditText();
            if (r12 != null) goto L5;
            return;
        L5:
            if (r11 != 3) goto L14;
            r12.post(new a(this, r12));
            if (r12.getOnFocusChangeListener() != DropdownMenuEndIconDelegate.i(this.f3895a)) goto L9;
            r12.setOnFocusChangeListener(null);
        L9:
            r12.setOnTouchListener(null);
            if (DropdownMenuEndIconDelegate.j() == false) goto L15;
            r12.setOnDismissListener(null);
            return;
        L15:
            return;
        }
    }

    class g implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3898c;

        g(DropdownMenuEndIconDelegate r10) {
            this.f3898c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            AutoCompleteTextView r11 = (AutoCompleteTextView) this.f3898c.f3973a.getEditText();
            DropdownMenuEndIconDelegate.q(this.f3898c, r11);
        }
    }

    class h implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3899a;

        h(DropdownMenuEndIconDelegate r10) {
            this.f3899a = r10;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean r10) {
            if (this.f3899a.f3973a.getEditText() != null) goto L5;
            return;
        L5:
            if (DropdownMenuEndIconDelegate.n(this.f3899a.f3973a.getEditText()) == true) goto L13;
            CheckableImageButton r11 = this.f3899a.f3975c;
            if (r10 == false) goto L9;
            int r12 = 2;
        L10:
            ViewCompat.setImportantForAccessibility(r11, r12);
            return;
        L9:
            r12 = 1;
            goto L10
        }
    }

    class i implements View.OnTouchListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f3900c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3901g;

        i(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
            this.f3901g = r10;
            this.f3900c = r11;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NonNull View r10, @NonNull MotionEvent r11) {
            if (r11.getAction() == 1) goto L5;
        L8:
            return false;
        L5:
            if (DropdownMenuEndIconDelegate.k(this.f3901g) == false) goto L7;
            DropdownMenuEndIconDelegate.p(this.f3901g, false);
        L7:
            DropdownMenuEndIconDelegate.q(this.f3901g, this.f3900c);
            DropdownMenuEndIconDelegate.r(this.f3901g);
            goto L8
        }
    }

    class j implements AutoCompleteTextView.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DropdownMenuEndIconDelegate f3902a;

        j(DropdownMenuEndIconDelegate r10) {
            this.f3902a = r10;
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            DropdownMenuEndIconDelegate.r(this.f3902a);
            DropdownMenuEndIconDelegate.o(this.f3902a, false);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r10 = true;
    L6:
        f3874r = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    DropdownMenuEndIconDelegate(@NonNull TextInputLayout r10, @DrawableRes int r11) {
        super(r10, r11);
        this.f3875e = new a(this);
        this.f3876f = new d(this);
        final TextInputLayout r12 = this.f3973a;
        this.f3877g = new AnonymousClass3(this, r12);
        this.f3878h = new e(this);
        this.f3879i = new f(this);
        this.f3880j = false;
        this.f3881k = false;
        this.f3882l = Long.MAX_VALUE;
    }

    private MaterialShapeDrawable A(float r10, float r11, float r12, int r13) {
        l r14 = l.a().E(r10).I(r10).v(r11).z(r11).m();
        MaterialShapeDrawable r15 = MaterialShapeDrawable.createWithElevationOverlay(this.f3974b, r12);
        r15.setShapeAppearanceModel(r14);
        r15.setPadding(0, r13, 0, r13);
        return r15;
    }

    private void B() {
        this.f3887q = z(67, new float[]{0.0f, 1.0f});
        ValueAnimator r10 = z(50, new float[]{1.0f, 0.0f});
        this.f3886p = r10;
        r10.addListener(new b(this));
    }

    private boolean C() {
        long r10 = System.currentTimeMillis() - this.f3882l;
        if (r10 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r10 > 300) goto L8;
        return false;
    }

    private static boolean D(@NonNull EditText r10) {
        if (r10.getKeyListener() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void E(boolean r10) {
        if (this.f3881k == r10) goto L6;
        this.f3881k = r10;
        this.f3887q.cancel();
        this.f3886p.start();
        return;
    }

    private void F(@NonNull AutoCompleteTextView r10) {
        if (f3874r == false) goto L11;
        int r11 = this.f3973a.getBoxBackgroundMode();
        if (r11 != 2) goto L9;
        Drawable r12 = this.f3884n;
    L7:
        r10.setDropDownBackgroundDrawable(r12);
        return;
    L9:
        if (r11 != 1) goto L13;
        r12 = this.f3883m;
        goto L7
    L13:
        return;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void G(@NonNull AutoCompleteTextView r10) {
        r10.setOnTouchListener(new i(this, r10));
        r10.setOnFocusChangeListener(this.f3876f);
        if (f3874r == false) goto L6;
        r10.setOnDismissListener(new j(this));
        return;
    }

    private void H(@Nullable AutoCompleteTextView r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (C() == false) goto L8;
        this.f3880j = false;
    L8:
        if (this.f3880j == false) goto L10;
        this.f3880j = false;
        return;
    L10:
        if (f3874r == false) goto L12;
        E(!this.f3881k);
    L14:
        if (this.f3881k == false) goto L16;
        r10.requestFocus();
        r10.showDropDown();
        return;
    L16:
        r10.dismissDropDown();
        return;
    L12:
        this.f3881k = !this.f3881k;
        this.f3975c.toggle();
        goto L14
    }

    private void I() {
        this.f3880j = true;
        this.f3882l = System.currentTimeMillis();
    }

    static /* synthetic */ AutoCompleteTextView e(EditText r10) {
        return y(r10);
    }

    static /* synthetic */ AccessibilityManager f(DropdownMenuEndIconDelegate r10) {
        return r10.f3885o;
    }

    static /* synthetic */ TextWatcher g(DropdownMenuEndIconDelegate r10) {
        return r10.f3875e;
    }

    static /* synthetic */ TextInputLayout.AccessibilityDelegate h(DropdownMenuEndIconDelegate r10) {
        return r10.f3877g;
    }

    static /* synthetic */ View.OnFocusChangeListener i(DropdownMenuEndIconDelegate r10) {
        return r10.f3876f;
    }

    static /* synthetic */ boolean j() {
        return f3874r;
    }

    static /* synthetic */ boolean k(DropdownMenuEndIconDelegate r10) {
        return r10.C();
    }

    static /* synthetic */ boolean l(DropdownMenuEndIconDelegate r10) {
        return r10.f3881k;
    }

    static /* synthetic */ ValueAnimator m(DropdownMenuEndIconDelegate r10) {
        return r10.f3887q;
    }

    static /* synthetic */ boolean n(EditText r10) {
        return D(r10);
    }

    static /* synthetic */ void o(DropdownMenuEndIconDelegate r10, boolean r11) {
        r10.E(r11);
    }

    static /* synthetic */ boolean p(DropdownMenuEndIconDelegate r10, boolean r11) {
        r10.f3880j = r11;
        return r11;
    }

    static /* synthetic */ void q(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
        r10.H(r11);
    }

    static /* synthetic */ void r(DropdownMenuEndIconDelegate r10) {
        r10.I();
    }

    static /* synthetic */ void s(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
        r10.F(r11);
    }

    static /* synthetic */ void t(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
        r10.v(r11);
    }

    static /* synthetic */ void u(DropdownMenuEndIconDelegate r10, AutoCompleteTextView r11) {
        r10.G(r11);
    }

    private void v(@NonNull AutoCompleteTextView r10) {
        if (D(r10) == false) goto L5;
        return;
    L5:
        int r11 = this.f3973a.getBoxBackgroundMode();
        MaterialShapeDrawable r12 = this.f3973a.getBoxBackground();
        int r13 = t5.a.d(r10, q5.b.colorControlHighlight);
        int[][] r14 = {new int[]{R.attr.state_pressed}, new int[0]};
        if (r11 != 2) goto L8;
        x(r10, r13, r14, r12);
        return;
    L8:
        if (r11 != 1) goto L12;
        w(r10, r13, r14, r12);
        return;
    }

    private void w(@NonNull AutoCompleteTextView r10, int r11, int[][] r12, @NonNull MaterialShapeDrawable r13) {
        int r14 = this.f3973a.getBoxBackgroundColor();
        int[] r15 = {t5.a.h(r11, r14, 0.1f), r14};
        if (f3874r == false) goto L5;
        ViewCompat.setBackground(r10, new RippleDrawable(new ColorStateList(r12, r15), r13, r13));
        return;
    L5:
        MaterialShapeDrawable r16 = new MaterialShapeDrawable(r13.getShapeAppearanceModel());
        r16.setFillColor(new ColorStateList(r12, r15));
        LayerDrawable r17 = new LayerDrawable(new Drawable[]{r13, r16});
        int r18 = ViewCompat.getPaddingStart(r10);
        int r19 = r10.getPaddingTop();
        int r20 = ViewCompat.getPaddingEnd(r10);
        int r21 = r10.getPaddingBottom();
        ViewCompat.setBackground(r10, r17);
        ViewCompat.setPaddingRelative(r10, r18, r19, r20, r21);
    }

    private void x(@NonNull AutoCompleteTextView r10, int r11, int[][] r12, @NonNull MaterialShapeDrawable r13) {
        int r14 = t5.a.d(r10, q5.b.colorSurface);
        MaterialShapeDrawable r15 = new MaterialShapeDrawable(r13.getShapeAppearanceModel());
        int r16 = t5.a.h(r11, r14, 0.1f);
        r15.setFillColor(new ColorStateList(r12, new int[]{r16, 0}));
        if (f3874r == false) goto L5;
        r15.setTint(r14);
        ColorStateList r17 = new ColorStateList(r12, new int[]{r16, r14});
        MaterialShapeDrawable r18 = new MaterialShapeDrawable(r13.getShapeAppearanceModel());
        r18.setTint(-1);
        LayerDrawable r19 = new LayerDrawable(new Drawable[]{new RippleDrawable(r17, r15, r18), r13});
    L6:
        ViewCompat.setBackground(r10, r19);
        return;
    L5:
        r19 = new LayerDrawable(new Drawable[]{r15, r13});
        goto L6
    }

    @NonNull
    private static AutoCompleteTextView y(EditText r10) {
        if ((r10 instanceof AutoCompleteTextView) == false) goto L7;
        return (AutoCompleteTextView) r10;
    L7:
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int r10, float... r11) {
        ValueAnimator r12 = ValueAnimator.ofFloat(r11);
        r12.setInterpolator(r5.a.f12673a);
        r12.setDuration(r10);
        r12.addUpdateListener(new c(this));
        return r12;
    }

    void J(@NonNull AutoCompleteTextView r10) {
        if (D(r10) == false) goto L5;
        return;
    L5:
        if (this.f3973a.getBoxBackgroundMode() == 2) goto L7;
        return;
    L7:
        if ((r10.getBackground() instanceof LayerDrawable) == false) goto L13;
        v(r10);
        return;
    }

    @Override // com.google.android.material.textfield.c
    void a() {
        float r10 = this.f3974b.getResources().getDimensionPixelOffset(q5.d.mtrl_shape_corner_size_small_component);
        float r11 = this.f3974b.getResources().getDimensionPixelOffset(q5.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int r12 = this.f3974b.getResources().getDimensionPixelOffset(q5.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable r13 = A(r10, r10, r11, r12);
        MaterialShapeDrawable r14 = A(0.0f, r10, r11, r12);
        this.f3884n = r13;
        StateListDrawable r15 = new StateListDrawable();
        this.f3883m = r15;
        r15.addState(new int[]{R.attr.state_above_anchor}, r13);
        this.f3883m.addState(new int[0], r14);
        int r16 = this.f3976d;
        if (r16 == 0) goto L5;
    L8:
        this.f3973a.setEndIconDrawable(r16);
        TextInputLayout r17 = this.f3973a;
        r17.setEndIconContentDescription(r17.getResources().getText(q5.j.exposed_dropdown_menu_content_description));
        this.f3973a.setEndIconOnClickListener(new g(this));
        this.f3973a.g(this.f3878h);
        this.f3973a.h(this.f3879i);
        B();
        AccessibilityManager r18 = (AccessibilityManager) this.f3974b.getSystemService("accessibility");
        this.f3885o = r18;
        if (Build.VERSION.SDK_INT < 19) goto L12;
        r18.addTouchExplorationStateChangeListener(new h(this));
        return;
    L12:
        return;
    L5:
        if (f3874r == false) goto L7;
        r16 = q5.e.mtrl_dropdown_arrow;
        goto L8
    L7:
        r16 = q5.e.mtrl_ic_arrow_drop_down;
        goto L8
    }

    @Override // com.google.android.material.textfield.c
    boolean b(int r10) {
        if (r10 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.android.material.textfield.c
    boolean d() {
        return true;
    }
}
