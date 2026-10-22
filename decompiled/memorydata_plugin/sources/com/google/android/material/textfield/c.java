package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class c extends d {
    private static final boolean e = false;
    private final TextWatcher f;
    private final View.OnFocusChangeListener g;
    private final TextInputLayout.AccessibilityDelegate h;
    private final TextInputLayout.a i;
    private final TextInputLayout.b j;
    private final View.OnAttachStateChangeListener k;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener l;
    private boolean m;
    private boolean n;
    private long o;
    private StateListDrawable p;
    private MaterialShapeDrawable q;
    private AccessibilityManager r;
    private ValueAnimator s;
    private ValueAnimator t;

    static {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r0 = true;
    L6:
        e = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    c(TextInputLayout r1, int r2) {
        super(r1, r2);
        this.f = new AnonymousClass1(this);
        this.g = new AnonymousClass5(this);
        final TextInputLayout r3 = this.f4166a;
        this.h = new DropdownMenuEndIconDelegate$3(this, r3);
        this.i = new AnonymousClass6(this);
        this.j = new AnonymousClass7(this);
        this.k = new AnonymousClass8(this);
        this.l = new DropdownMenuEndIconDelegate$7(this);
        this.m = false;
        this.n = false;
        this.o = Long.MAX_VALUE;
    }

    private ValueAnimator a(int r3, float... r4) {
        ValueAnimator r5 = ValueAnimator.ofFloat(r4);
        r5.setInterpolator(com.google.android.material.a.a.f3741a);
        r5.setDuration(r3);
        r5.addUpdateListener(new AnonymousClass4(this));
        return r5;
    }

    static /* synthetic */ AccessibilityManager a(c r0) {
        return r0.r;
    }

    static /* synthetic */ AutoCompleteTextView a(EditText r0) {
        return c(r0);
    }

    private MaterialShapeDrawable a(float r2, float r3, float r4, int r5) {
        l r6 = l.a().b(r2).c(r2).e(r3).d(r3).a();
        MaterialShapeDrawable r1 = MaterialShapeDrawable.createWithElevationOverlay(this.f4167b, r4);
        r1.setShapeAppearanceModel(r6);
        r1.setPadding(0, r5, 0, r5);
        return r1;
    }

    private void a(AutoCompleteTextView r7, int r8, int[][] r9, MaterialShapeDrawable r10) {
        int r6 = com.google.android.material.c.a.a(r7, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(r10.getShapeAppearanceModel());
        int r11 = com.google.android.material.c.a.a(r8, r6, 0.1f);
        r0.setFillColor(new ColorStateList(r9, new int[]{r11, 0}));
        if (e == false) goto L5;
        r0.setTint(r6);
        ColorStateList r12 = new ColorStateList(r9, new int[]{r11, r6});
        MaterialShapeDrawable r13 = new MaterialShapeDrawable(r10.getShapeAppearanceModel());
        r13.setTint(-1);
        LayerDrawable r14 = new LayerDrawable(new Drawable[]{new RippleDrawable(r12, r0, r13), r10});
    L6:
        ViewCompat.setBackground(r7, r14);
        return;
    L5:
        r14 = new LayerDrawable(new Drawable[]{r0, r10});
        goto L6
    }

    static /* synthetic */ void a(c r0, AutoCompleteTextView r1) {
        r0.b(r1);
    }

    static /* synthetic */ void a(c r0, boolean r1) {
        r0.b(r1);
    }

    private void b(AutoCompleteTextView r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (d() == false) goto L8;
        this.m = false;
    L8:
        if (this.m == false) goto L10;
        this.m = false;
        return;
    L10:
        if (e == false) goto L12;
        b(!this.n);
    L14:
        if (this.n == false) goto L16;
        r3.requestFocus();
        r3.showDropDown();
        return;
    L16:
        r3.dismissDropDown();
        return;
    L12:
        this.n = !this.n;
        this.c.toggle();
        goto L14
    }

    private void b(AutoCompleteTextView r5, int r6, int[][] r7, MaterialShapeDrawable r8) {
        int r4 = this.f4166a.getBoxBackgroundColor();
        int[] r1 = {com.google.android.material.c.a.a(r6, r4, 0.1f), r4};
        if (e == false) goto L5;
        ViewCompat.setBackground(r5, new RippleDrawable(new ColorStateList(r7, r1), r8, r8));
        return;
    L5:
        MaterialShapeDrawable r9 = new MaterialShapeDrawable(r8.getShapeAppearanceModel());
        r9.setFillColor(new ColorStateList(r7, r1));
        LayerDrawable r10 = new LayerDrawable(new Drawable[]{r8, r9});
        int r11 = ViewCompat.getPaddingStart(r5);
        int r12 = r5.getPaddingTop();
        int r13 = ViewCompat.getPaddingEnd(r5);
        int r0 = r5.getPaddingBottom();
        ViewCompat.setBackground(r5, r10);
        ViewCompat.setPaddingRelative(r5, r11, r12, r13, r0);
    }

    static /* synthetic */ void b(c r0) {
        r0.e();
    }

    static /* synthetic */ void b(c r0, AutoCompleteTextView r1) {
        r0.c(r1);
    }

    private void b(boolean r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        this.t.cancel();
        this.s.start();
        return;
    }

    static /* synthetic */ boolean b(EditText r0) {
        return d(r0);
    }

    static /* synthetic */ boolean b(c r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ TextWatcher c(c r0) {
        return r0.f;
    }

    private static AutoCompleteTextView c(EditText r2) {
        if (ZeusTransformUtils.instanceOf(r2, AutoCompleteTextView.class) == false) goto L7;
        return (AutoCompleteTextView) ZeusTransformUtils.preCheckCast(r2, AutoCompleteTextView.class, "com.obric.memorydata.plugin");
    L7:
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private void c(AutoCompleteTextView r3) {
        if (e == false) goto L11;
        int r0 = this.f4166a.getBoxBackgroundMode();
        if (r0 != 2) goto L9;
        Drawable r2 = this.q;
    L7:
        r3.setDropDownBackgroundDrawable(r2);
        return;
    L9:
        if (r0 != 1) goto L13;
        r2 = this.p;
        goto L7
    L13:
        return;
    }

    static /* synthetic */ void c(c r0, AutoCompleteTextView r1) {
        r0.d(r1);
    }

    static /* synthetic */ boolean c() {
        return e;
    }

    static /* synthetic */ TextInputLayout.AccessibilityDelegate d(c r0) {
        return r0.h;
    }

    private void d(AutoCompleteTextView r10) {
        if (d(r10) == false) goto L5;
        return;
    L5:
        int r0 = this.f4166a.getBoxBackgroundMode();
        MaterialShapeDrawable r1 = this.f4166a.getBoxBackground();
        int r2 = com.google.android.material.c.a.a(r10, ZeusTransformUtils.mapRes(R.attr.colorControlHighlight, "attr", "colorControlHighlight"));
        int[][] r4 = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (r0 != 2) goto L8;
        a(r10, r2, r4, r1);
        return;
    L8:
        if (r0 != 1) goto L12;
        b(r10, r2, r4, r1);
        return;
    }

    static /* synthetic */ void d(c r0, AutoCompleteTextView r1) {
        r0.e(r1);
    }

    private boolean d() {
        long r0 = System.currentTimeMillis() - this.o;
        if (r0 >= 0) goto L5;
    L8:
        return true;
    L5:
        if (r0 > 300) goto L8;
        return false;
    }

    private static boolean d(EditText r0) {
        if (r0.getKeyListener() == null) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ View.OnFocusChangeListener e(c r0) {
        return r0.g;
    }

    private void e() {
        this.m = true;
        this.o = System.currentTimeMillis();
    }

    private void e(final AutoCompleteTextView r2) {
        r2.setOnTouchListener(new AnonymousClass10(this, r2));
        r2.setOnFocusChangeListener(this.g);
        if (e == false) goto L6;
        r2.setOnDismissListener(new AnonymousClass2(this));
        return;
    }

    static /* synthetic */ View.OnAttachStateChangeListener f(c r0) {
        return r0.k;
    }

    private void f() {
        this.t = a(67, new float[]{0.0f, 1.0f});
        ValueAnimator r0 = a(50, new float[]{1.0f, 0.0f});
        this.s = r0;
        r0.addListener(new AnonymousClass3(this));
    }

    private void g() {
        if (this.r != null) goto L5;
        return;
    L5:
        if (this.f4166a != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(this.f4166a) == false) goto L12;
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.r, this.l);
        return;
    }

    static /* synthetic */ void g(c r0) {
        r0.h();
    }

    private void h() {
        AccessibilityManager r0 = this.r;
        if (r0 == null) goto L6;
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(r0, this.l);
        return;
    }

    static /* synthetic */ void h(c r0) {
        r0.g();
    }

    static /* synthetic */ boolean i(c r0) {
        return r0.d();
    }

    static /* synthetic */ boolean j(c r0) {
        return r0.n;
    }

    static /* synthetic */ ValueAnimator k(c r0) {
        return r0.t;
    }

    @Override // com.google.android.material.textfield.d
    void a() {
        float r0 = ZeusTransformUtils.getResources(this.f4167b, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_shape_corner_size_small_component, "dimen", "mtrl_shape_corner_size_small_component"));
        float r2 = ZeusTransformUtils.getResources(this.f4167b, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation, "dimen", "mtrl_exposed_dropdown_menu_popup_elevation"));
        int r3 = ZeusTransformUtils.getResources(this.f4167b, "com.obric.memorydata.plugin").getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding, "dimen", "mtrl_exposed_dropdown_menu_popup_vertical_padding"));
        MaterialShapeDrawable r4 = a(r0, r0, r2, r3);
        MaterialShapeDrawable r1 = a(0.0f, r0, r2, r3);
        this.q = r4;
        StateListDrawable r5 = new StateListDrawable();
        this.p = r5;
        r5.addState(new int[]{android.R.attr.state_above_anchor}, r4);
        this.p.addState(new int[0], r1);
        if (this.d == 0) goto L5;
        int r6 = this.d;
    L10:
        this.f4166a.setEndIconDrawable(r6);
        this.f4166a.setEndIconContentDescription(ZeusTransformUtils.getResources(this.f4166a, "com.obric.memorydata.plugin").getText(ZeusTransformUtils.mapRes(R.string.exposed_dropdown_menu_content_description, TypedValues.Custom.S_STRING, "exposed_dropdown_menu_content_description")));
        this.f4166a.setEndIconOnClickListener(new AnonymousClass9(this));
        this.f4166a.a(this.i);
        this.f4166a.a(this.j);
        f();
        this.r = (AccessibilityManager) ZeusTransformUtils.preCheckCast(this.f4167b.getSystemService("accessibility"), AccessibilityManager.class, "com.obric.memorydata.plugin");
        this.f4166a.addOnAttachStateChangeListener(this.k);
        g();
        return;
    L5:
        if (e == false) goto L7;
        int r7 = R.drawable.mtrl_dropdown_arrow;
        String r8 = "mtrl_dropdown_arrow";
    L8:
        r6 = ZeusTransformUtils.mapRes(r7, "drawable", r8);
        goto L10
    L7:
        r7 = R.drawable.mtrl_ic_arrow_drop_down;
        r8 = "mtrl_ic_arrow_drop_down";
        goto L8
    }

    void a(AutoCompleteTextView r3) {
        if (d(r3) == false) goto L5;
        return;
    L5:
        if (this.f4166a.getBoxBackgroundMode() == 2) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r3.getBackground(), LayerDrawable.class) == false) goto L13;
        d(r3);
        return;
    }

    @Override // com.google.android.material.textfield.d
    boolean a(int r1) {
        if (r1 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.android.material.textfield.d
    boolean b() {
        return true;
    }
}
