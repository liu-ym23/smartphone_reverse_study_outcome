package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.v0;
import androidx.appcompat.widget.y;
import com.google.android.material.internal.CheckableImageButton;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class m extends LinearLayout {
    public final y A;
    public boolean B;
    public EditText C;
    public final AccessibilityManager D;
    public k0.d E;
    public final a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f5049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f5050b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CheckableImageButton f5051m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f5052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PorterDuff.Mode f5053o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnLongClickListener f5054p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CheckableImageButton f5055q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f5056r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5057s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LinkedHashSet<TextInputLayout.g> f5058t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ColorStateList f5059u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PorterDuff.Mode f5060v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5061w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView.ScaleType f5062x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View.OnLongClickListener f5063y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f5064z;

    public class a extends com.google.android.material.internal.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f5065a;

        public a(m r8) {
            this.f5065a = r8;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r8) {
            this.f5065a.b().a();
        }

        @Override // com.google.android.material.internal.k, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r8, int r10, int r11, int r12) {
            this.f5065a.b().b();
        }
    }

    public class b implements TextInputLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f5066a;

        public b(m r8) {
            this.f5066a = r8;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public final void a(TextInputLayout r8) {
            m r10 = this.f5066a;
            if (r10.C != r8.getEditText()) goto L5;
            return;
        L5:
            EditText r11 = r10.C;
            a r12 = r10.F;
            if (r11 == null) goto L10;
            r11.removeTextChangedListener(r12);
            if (r10.C.getOnFocusChangeListener() != r10.b().e()) goto L10;
            r10.C.setOnFocusChangeListener(null);
        L10:
            EditText r13 = r8.getEditText();
            r10.C = r13;
            if (r13 == null) goto L13;
            r13.addTextChangedListener(r12);
        L13:
            r10.b().m(r10.C);
            r10.j(r10.b());
        }
    }

    public class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f5067a;

        public c(m r8) {
            this.f5067a = r8;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r8) {
            m r10 = this.f5067a;
            if (r10.E == null) goto L10;
            AccessibilityManager r11 = r10.D;
            if (r11 == null) goto L11;
            WeakHashMap<View, h0> r12 = w.f8437a;
            if (w.g.b(r10) == false) goto L12;
            k0.c.a(r11, r10.E);
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r8) {
            m r10 = this.f5067a;
            k0.d r11 = r10.E;
            if (r11 == null) goto L8;
            AccessibilityManager r12 = r10.D;
            if (r12 == null) goto L9;
            k0.c.b(r12, r11);
            return;
        L9:
            return;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<n> f5068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m f5069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5071d;

        public d(m r8, v0 r10) {
            this.f5068a = new SparseArray();
            this.f5069b = r8;
            this.f5070c = r10.i(28, 0);
            this.f5071d = r10.i(52, 0);
        }
    }

    public m(TextInputLayout r14, v0 r15) {
        super(r14.getContext());
        this.f5057s = 0;
        this.f5058t = new LinkedHashSet();
        this.F = new a(this);
        b r8 = new b(this);
        this.D = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f5049a = r14;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout r10 = new FrameLayout(getContext());
        this.f5050b = r10;
        r10.setVisibility(8);
        r10.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater r11 = LayoutInflater.from(getContext());
        CheckableImageButton r12 = a(this, r11, R.id.text_input_error_icon);
        this.f5051m = r12;
        CheckableImageButton r13 = a(r10, r11, R.id.text_input_end_icon);
        this.f5055q = r13;
        this.f5056r = new d(this, r15);
        CharSequence r16 = null;
        y r17 = new y(getContext(), null);
        this.A = r17;
        if (r15.l(38) == false) goto L6;
        this.f5052n = x9.c.b(getContext(), r15, 38);
    L6:
        if (r15.l(39) == false) goto L9;
        this.f5053o = com.google.android.material.internal.q.b(r15.h(39, -1), null);
    L9:
        if (r15.l(37) == false) goto L11;
        i(r15.e(37));
    L11:
        r12.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap<View, h0> r18 = w.f8437a;
        w.d.s(r12, 2);
        r12.setClickable(false);
        r12.setPressable(false);
        r12.setFocusable(false);
        if (r15.l(53) == true) goto L20;
        if (r15.l(32) == false) goto L17;
        this.f5059u = x9.c.b(getContext(), r15, 32);
    L17:
        if (r15.l(33) == false) goto L20;
        this.f5060v = com.google.android.material.internal.q.b(r15.h(33, -1), null);
    L20:
        if (r15.l(30) == false) goto L28;
        g(r15.h(30, 0));
        if (r15.l(27) == false) goto L26;
        CharSequence r19 = r15.k(27);
        if (r13.getContentDescription() == r19) goto L26;
        r13.setContentDescription(r19);
    L26:
        r13.setCheckable(r15.a(26, true));
    L38:
        int r20 = r15.d(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (r20 < 0) goto L59;
        if (r20 == this.f5061w) goto L44;
        this.f5061w = r20;
        r13.setMinimumWidth(r20);
        r13.setMinimumHeight(r20);
        r12.setMinimumWidth(r20);
        r12.setMinimumHeight(r20);
    L44:
        if (r15.l(31) == false) goto L46;
        ImageView.ScaleType r21 = o.b(r15.h(31, -1));
        this.f5062x = r21;
        r13.setScaleType(r21);
        r12.setScaleType(r21);
    L46:
        r17.setVisibility(8);
        r17.setId(R.id.textinput_suffix_text);
        r17.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        w.g.f(r17, 1);
        r17.setTextAppearance(r15.i(72, 0));
        if (r15.l(73) == false) goto L49;
        r17.setTextColor(r15.b(73));
    L49:
        CharSequence r110 = r15.k(71);
        if (TextUtils.isEmpty(r110) == true) goto L53;
        r16 = r110;
    L53:
        this.f5064z = r16;
        r17.setText(r110);
        n();
        r10.addView(r13);
        addView(r17);
        addView(r10);
        addView(r12);
        r14.f4981l0.add(r8);
        if (r14.f4984n == null) goto L56;
        r8.a(r14);
    L56:
        addOnAttachStateChangeListener(new c(this));
        return;
    L59:
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    L28:
        if (r15.l(53) == false) goto L38;
        if (r15.l(54) == false) goto L33;
        this.f5059u = x9.c.b(getContext(), r15, 54);
    L33:
        if (r15.l(55) == false) goto L35;
        this.f5060v = com.google.android.material.internal.q.b(r15.h(55, -1), null);
    L35:
        g(r15.a(53, false) ? 1 : 0);
        CharSequence r22 = r15.k(51);
        if (r13.getContentDescription() == r22) goto L38;
        r13.setContentDescription(r22);
        goto L38
    }

    public final CheckableImageButton a(ViewGroup r8, LayoutInflater r10, int r11) {
        CheckableImageButton r12 = (CheckableImageButton) r10.inflate(R.layout.design_text_input_end_icon, r8, false);
        r12.setId(r11);
        if (x9.c.d(getContext()) == false) goto L5;
        j0.f.h((ViewGroup.MarginLayoutParams) r12.getLayoutParams(), 0);
    L5:
        return r12;
    }

    public final n b() {
        int r8 = this.f5057s;
        d r10 = this.f5056r;
        SparseArray<n> r11 = r10.f5068a;
        n r12 = r11.get(r8);
        if (r12 != null) goto L22;
        m r13 = r10.f5069b;
        if (r8 == (-1)) goto L19;
        if (r8 != 0) goto L8;
        n r14 = new t(r13);
    L20:
        r12 = r14;
    L21:
        r11.append(r8, r12);
        goto L22
    L8:
        if (r8 != 1) goto L10;
        r12 = new u(r13, r10.f5071d);
        goto L21
    L10:
        if (r8 != 2) goto L12;
        r14 = new f(r13);
        goto L20
    L12:
        if (r8 != 3) goto L15;
        r14 = new l(r13);
        goto L20
    L15:
        throw new IllegalArgumentException(defpackage.a.d("Invalid end icon mode: ", r8));
    L19:
        r14 = new g(r13);
    L22:
        return r12;
    }

    public final int c() {
        if (d() == false) goto L5;
    L8:
        CheckableImageButton r8 = this.f5055q;
        int r10 = r8.getMeasuredWidth();
        int r11 = j0.f.c((ViewGroup.MarginLayoutParams) r8.getLayoutParams()) + r10;
    L9:
        WeakHashMap<View, h0> r12 = w.f8437a;
        int r13 = w.e.e(this);
        return (w.e.e(this.A) + r13) + r11;
    L5:
        if (e() == true) goto L8;
        r11 = 0;
        goto L9
    }

    public final boolean d() {
        if (this.f5050b.getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f5055q.getVisibility() != 0) goto L7;
        return true;
    }

    public final boolean e() {
        if (this.f5051m.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f(boolean r8) {
        n r10 = b();
        boolean r11 = r10.k();
        CheckableImageButton r12 = this.f5055q;
        boolean r13 = true;
        if (r11 == false) goto L7;
        boolean r14 = r12.isChecked();
        if (r14 == r10.l()) goto L7;
        r12.setChecked(!r14);
        boolean r15 = true;
    L9:
        if ((r10 instanceof l) == false) goto L13;
        boolean r16 = r12.isActivated();
        if (r16 == r10.j()) goto L13;
        r12.setActivated(!r16);
    L14:
        if (r8 == true) goto L16;
        if (r13 == true) goto L16;
        return;
    L16:
        o.c(this.f5049a, r12, this.f5059u);
        return;
    L13:
        r13 = r15;
    L7:
        r15 = false;
        goto L9
    }

    public final void g(int r10) {
        if (this.f5057s != r10) goto L5;
        return;
    L5:
        n r8 = b();
        k0.d r11 = this.E;
        AccessibilityManager r12 = this.D;
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        k0.c.b(r12, r11);
    L9:
        CharSequence r13 = null;
        this.E = null;
        r8.s();
        this.f5057s = r10;
        Iterator<TextInputLayout.g> r14 = this.f5058t.iterator();
    L11:
        if (r14.hasNext() == false) goto L14;
        r14.next().a();
        goto L11
    L14:
        if (r10 == 0) goto L16;
        boolean r15 = true;
    L17:
        h(r15);
        n r16 = b();
        int r17 = this.f5056r.f5070c;
        if (r17 != 0) goto L20;
        r17 = r16.d();
    L20:
        if (r17 == 0) goto L22;
        Drawable r18 = d.a.a(getContext(), r17);
    L23:
        CheckableImageButton r19 = this.f5055q;
        r19.setImageDrawable(r18);
        TextInputLayout r20 = this.f5049a;
        if (r18 == null) goto L26;
        o.a(r20, r19, this.f5059u, this.f5060v);
        o.c(r20, r19, this.f5059u);
    L26:
        int r21 = r16.c();
        if (r21 == 0) goto L30;
        r13 = getResources().getText(r21);
    L30:
        if (r19.getContentDescription() == r13) goto L32;
        r19.setContentDescription(r13);
    L32:
        r19.setCheckable(r16.k());
        if (r16.i(r20.getBoxBackgroundMode()) == false) goto L46;
        r16.r();
        k0.d r22 = r16.h();
        this.E = r22;
        if (r22 == null) goto L40;
        if (r12 == null) goto L40;
        WeakHashMap<View, h0> r23 = w.f8437a;
        if (w.g.b(this) == false) goto L40;
        k0.c.a(r12, this.E);
    L40:
        View.OnClickListener r24 = r16.f();
        View.OnLongClickListener r25 = this.f5063y;
        r19.setOnClickListener(r24);
        o.d(r19, r25);
        EditText r26 = this.C;
        if (r26 == null) goto L43;
        r16.m(r26);
        j(r16);
    L43:
        o.a(r20, r19, this.f5059u, this.f5060v);
        f(true);
        return;
    L46:
        throw new IllegalStateException("The current box background mode " + r20.getBoxBackgroundMode() + " is not supported by the end icon mode " + r10);
    L22:
        r18 = null;
        goto L23
    L16:
        r15 = false;
        goto L17
    }

    public final void h(boolean r8) {
        if (d() == r8) goto L9;
        if (r8 == false) goto L6;
        int r10 = 0;
    L7:
        this.f5055q.setVisibility(r10);
        k();
        m();
        this.f5049a.r();
        return;
    L6:
        r10 = 8;
        goto L7
    }

    public final void i(Drawable r8) {
        CheckableImageButton r10 = this.f5051m;
        r10.setImageDrawable(r8);
        l();
        ColorStateList r11 = this.f5052n;
        PorterDuff.Mode r12 = this.f5053o;
        o.a(this.f5049a, r10, r11, r12);
    }

    public final void j(n r8) {
        if (this.C != null) goto L6;
        return;
    L6:
        if (r8.e() == null) goto L9;
        this.C.setOnFocusChangeListener(r8.e());
    L9:
        if (r8.g() == null) goto L12;
        this.f5055q.setOnFocusChangeListener(r8.g());
        return;
    }

    public final void k() {
        int r8 = 8;
        if (this.f5055q.getVisibility() == 0) goto L5;
    L7:
        int r10 = 8;
    L8:
        this.f5050b.setVisibility(r10);
        if (this.f5064z != null) goto L11;
    L13:
        char r11 = '\b';
    L15:
        if (d() == false) goto L17;
    L21:
        boolean r12 = true;
    L22:
        if (r12 == false) goto L24;
        r8 = 0;
    L24:
        setVisibility(r8);
        return;
    L17:
        if (e() == true) goto L21;
        if (r11 == 0) goto L21;
        r12 = false;
        goto L22
    L11:
        if (this.B == true) goto L13;
        r11 = 0;
        goto L15
    L5:
        if (e() == true) goto L7;
        r10 = 0;
        goto L8
    }

    public final void l() {
        CheckableImageButton r8 = this.f5051m;
        Drawable r10 = r8.getDrawable();
        boolean r11 = true;
        TextInputLayout r12 = this.f5049a;
        if (r10 != null) goto L5;
    L9:
        boolean r13 = false;
    L10:
        if (r13 == false) goto L12;
        int r14 = 0;
    L13:
        r8.setVisibility(r14);
        k();
        m();
        if (this.f5057s != 0) goto L17;
        r11 = false;
    L17:
        if (r11 == true) goto L20;
        r12.r();
        return;
    L20:
        return;
    L12:
        r14 = 8;
        goto L13
    L5:
        if (r12.f4996t.f5092q == false) goto L9;
        if (r12.n() == false) goto L9;
        r13 = true;
        goto L10
    }

    public final void m() {
        TextInputLayout r8 = this.f5049a;
        if (r8.f4984n != null) goto L6;
        return;
    L6:
        if (d() == false) goto L8;
    L11:
        int r10 = 0;
    L12:
        int r11 = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int r12 = r8.f4984n.getPaddingTop();
        int r13 = r8.f4984n.getPaddingBottom();
        WeakHashMap<View, h0> r14 = w.f8437a;
        w.e.k(this.A, r11, r12, r10, r13);
        return;
    L8:
        if (e() == true) goto L11;
        EditText r15 = r8.f4984n;
        WeakHashMap<View, h0> r16 = w.f8437a;
        r10 = w.e.e(r15);
        goto L12
    }

    public final void n() {
        y r8 = this.A;
        int r10 = r8.getVisibility();
        boolean r11 = false;
        if (this.f5064z != null) goto L5;
    L7:
        int r12 = 8;
    L8:
        if (r10 == r12) goto L13;
        n r13 = b();
        if (r12 != 0) goto L12;
        r11 = true;
    L12:
        r13.p(r11);
    L13:
        k();
        r8.setVisibility(r12);
        this.f5049a.r();
        return;
    L5:
        if (this.B == true) goto L7;
        r12 = 0;
        goto L8
    }
}
