package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f5037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f5038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.material.datepicker.q f5039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.android.material.datepicker.e f5040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.core.app.b f5041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5042l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5043m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5044n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f5045o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AccessibilityManager f5046p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f5047q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f5048r;

    public l(m r8) {
        super(r8);
        int r10 = 1;
        this.f5039i = new com.google.android.material.datepicker.q(this, r10);
        this.f5040j = new com.google.android.material.datepicker.e(this, r10);
        this.f5041k = new androidx.core.app.b(this);
        this.f5045o = Long.MAX_VALUE;
        this.f5036f = v9.d.c(r8.getContext(), R.attr.motionDurationShort3, 67);
        this.f5035e = v9.d.c(r8.getContext(), R.attr.motionDurationShort3, 50);
        this.f5037g = v9.d.d(r8.getContext(), R.attr.motionEasingLinearInterpolator, h9.a.f7943a);
    }

    @Override // com.google.android.material.textfield.n
    public final void a() {
        if (this.f5046p.isTouchExplorationEnabled() == true) goto L5;
    L12:
        this.f5038h.post(new androidx.activity.k(this, 11));
        return;
    L5:
        if (this.f5038h.getInputType() == 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L12;
        if (this.f5075d.hasFocus() == true) goto L12;
        this.f5038h.dismissDropDown();
        goto L12
    L7:
        r8 = false;
        goto L8
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener e() {
        return this.f5040j;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.f5039i;
    }

    @Override // com.google.android.material.textfield.n
    public final k0.d h() {
        return this.f5041k;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean i(int r8) {
        if (r8 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean j() {
        return this.f5042l;
    }

    @Override // com.google.android.material.textfield.n
    public final boolean l() {
        return this.f5044n;
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText r8) {
        if ((r8 instanceof AutoCompleteTextView) == false) goto L14;
        AutoCompleteTextView r10 = (AutoCompleteTextView) r8;
        this.f5038h = r10;
        r10.setOnTouchListener(new i(this));
        this.f5038h.setOnDismissListener(new j(this));
        boolean r11 = false;
        this.f5038h.setThreshold(0);
        TextInputLayout r12 = this.f5072a;
        r12.setErrorIconDrawable(null);
        if (r8.getInputType() == 0) goto L7;
        r11 = true;
    L7:
        if (r11 == false) goto L9;
    L11:
        r12.setEndIconVisible(true);
        return;
    L9:
        if (this.f5046p.isTouchExplorationEnabled() == false) goto L11;
        WeakHashMap<View, h0> r13 = w.f8437a;
        w.d.s(this.f5075d, 2);
        goto L11
    L14:
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    @Override // com.google.android.material.textfield.n
    public final void n(k0.f r8) {
        if (this.f5038h.getInputType() == 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        r8.f(Spinner.class.getName());
    L8:
        AccessibilityNodeInfo r11 = r8.f8890a;
        if (r11.isShowingHintText() == false) goto L12;
        r11.setHintText(null);
        return;
    L12:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.google.android.material.textfield.n
    @SuppressLint({"WrongConstant"})
    public final void o(AccessibilityEvent r8) {
        if (this.f5046p.isEnabled() == false) goto L22;
        boolean r10 = false;
        if (this.f5038h.getInputType() == 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L11;
        return;
    L11:
        if (r8.getEventType() != 32768) goto L18;
        if (this.f5044n == false) goto L18;
        if (this.f5038h.isPopupShowing() == true) goto L18;
        r10 = true;
    L18:
        if (r8.getEventType() == 1) goto L20;
        if (r10 == true) goto L20;
        return;
    L20:
        u();
        this.f5043m = true;
        this.f5045o = System.currentTimeMillis();
        return;
    L7:
        r11 = false;
        goto L8
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        TimeInterpolator r10 = this.f5037g;
        r8.setInterpolator(r10);
        r8.setDuration(this.f5036f);
        int r11 = 1;
        r8.addUpdateListener(new b(this, r11));
        this.f5048r = r8;
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r12.setInterpolator(r10);
        r12.setDuration(this.f5035e);
        r12.addUpdateListener(new b(this, r11));
        this.f5047q = r12;
        r12.addListener(new k(this));
        this.f5046p = (AccessibilityManager) this.f5074c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.n
    @SuppressLint({"ClickableViewAccessibility"})
    public final void s() {
        AutoCompleteTextView r8 = this.f5038h;
        if (r8 == null) goto L6;
        r8.setOnTouchListener(null);
        this.f5038h.setOnDismissListener(null);
        return;
    }

    public final void t(boolean r8) {
        if (this.f5044n == r8) goto L6;
        this.f5044n = r8;
        this.f5048r.cancel();
        this.f5047q.start();
        return;
    }

    public final void u() {
        if (this.f5038h != null) goto L5;
        return;
    L5:
        long r8 = System.currentTimeMillis() - this.f5045o;
        if (r8 >= 0) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == false) goto L15;
        this.f5043m = false;
    L15:
        if (this.f5043m == true) goto L20;
        t(!this.f5044n);
        if (this.f5044n == false) goto L19;
        this.f5038h.requestFocus();
        this.f5038h.showDropDown();
        return;
    L19:
        this.f5038h.dismissDropDown();
        return;
    L20:
        this.f5043m = false;
        return;
    L8:
        if (r8 > 300) goto L11;
        r10 = false;
        goto L12
    }
}
