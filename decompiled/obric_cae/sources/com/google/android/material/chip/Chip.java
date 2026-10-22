package com.google.android.material.chip;

import aa.j;
import aa.n;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.android.material.internal.l;
import com.obric.cae.R;
import com.obric.cae.libs.useraware.ApWakeEvent;
import h9.g;
import j0.h0;
import j0.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;
import x9.c;
import x9.d;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends f implements com.google.android.material.chip.a.InterfaceC0050a, n {
    public static final Rect G = null;
    public static final int[] H = null;
    public static final int[] I = null;
    public CharSequence A;
    public final b B;
    public boolean C;
    public final Rect D;
    public final RectF E;
    public final a F;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.google.android.material.chip.a f4560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public InsetDrawable f4561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RippleDrawable f4562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View.OnClickListener f4563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f4564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4568w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4569x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4570y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4571z;

    public class a extends android.support.v4.media.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Chip f4572c;

        public a(Chip r8) {
            this.f4572c = r8;
        }

        @Override // android.support.v4.media.a
        public final void q(int r8) {
        }

        @Override // android.support.v4.media.a
        public final void r(Typeface r8, boolean r10) {
            Chip r11 = this.f4572c;
            com.google.android.material.chip.a r12 = r11.f4560o;
            if (r12.O0 == false) goto L5;
            CharSequence r13 = r12.P;
        L6:
            r11.setText(r13);
            r11.requestLayout();
            r11.invalidate();
            return;
        L5:
            r13 = r11.getText();
            goto L6
        }
    }

    public class b extends o0.a {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ Chip f4573q;

        public b(Chip r8, Chip r10) {
            this.f4573q = r8;
            super(r10);
        }

        @Override // o0.a
        public final void l(ArrayList r8) {
            boolean r10 = false;
            r8.add(0);
            Rect r11 = Chip.G;
            Chip r12 = this.f4573q;
            if (r12.d() == false) goto L14;
            com.google.android.material.chip.a r13 = r12.f4560o;
            if (r13 != null) goto L7;
        L9:
            if (r10 == true) goto L11;
            return;
        L11:
            if (r12.f4563r == null) goto L16;
            r8.add(1);
            return;
        L16:
            return;
        L7:
            if (r13.V == false) goto L9;
            r10 = true;
            goto L9
        }

        @Override // o0.a
        public final void o(int r8, k0.f r10) {
            AccessibilityNodeInfo r11 = r10.f8890a;
            CharSequence r12 = "";
            if (r8 != 1) goto L12;
            Chip r13 = this.f4573q;
            CharSequence r14 = r13.getCloseIconContentDescription();
            if (r14 != null) goto L11;
            CharSequence r15 = r13.getText();
            Context r16 = r13.getContext();
            Object[] r17 = new Object[1];
            if (TextUtils.isEmpty(r15) == true) goto L10;
            r12 = r15;
        L10:
            r17[0] = r12;
            r14 = r16.getString(R.string.mtrl_chip_close_icon_content_description, r17).trim();
        L11:
            r10.i(r14);
            r11.setBoundsInParent(Chip.b(r13));
            r10.b(k0.f.a.f8893e);
            r11.setEnabled(r13.isEnabled());
            return;
        L12:
            r10.i("");
            r11.setBoundsInParent(Chip.G);
        }
    }

    static {
        G = new Rect();
        H = new int[]{android.R.attr.state_selected};
        I = new int[]{android.R.attr.state_checkable};
    }

    public Chip(Context r18, AttributeSet r19) {
        super(ea.a.a(r18, r19, R.attr.chipStyle, R.style.Widget_MaterialComponents_Chip_Action), r19, R.attr.chipStyle);
        this.D = new Rect();
        this.E = new RectF();
        this.F = new a(this);
        Context r8 = getContext();
        if (r19 != null) goto L6;
    L27:
        com.google.android.material.chip.a r11 = new com.google.android.material.chip.a(r8, r19);
        Context r10 = r11.f4588p0;
        int[] r12 = g9.a.f7763d;
        TypedArray r13 = l.d(r10, r19, r12, R.attr.chipStyle, R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        r11.Q0 = r13.hasValue(37);
        Context r14 = r11.f4588p0;
        ColorStateList r15 = c.a(r14, r13, 24);
        if (r11.I == r15) goto L30;
        r11.I = r15;
        r11.onStateChange(r11.getState());
    L30:
        ColorStateList r16 = c.a(r14, r13, 11);
        if (r11.J == r16) goto L33;
        r11.J = r16;
        r11.onStateChange(r11.getState());
    L33:
        float r17 = r13.getDimension(19, 0.0f);
        if (r11.K == r17) goto L37;
        r11.K = r17;
        r11.invalidateSelf();
        r11.w();
    L37:
        if (r13.hasValue(12) == false) goto L39;
        r11.C(r13.getDimension(12, 0.0f));
    L39:
        r11.H(c.a(r14, r13, 22));
        r11.I(r13.getDimension(23, 0.0f));
        r11.R(c.a(r14, r13, 36));
        CharSequence r20 = r13.getText(5);
        if (r20 != null) goto L43;
        r20 = "";
    L43:
        if (TextUtils.equals(r11.P, r20) == true) goto L45;
        r11.P = r20;
        r11.f4594v0.f4882d = true;
        r11.invalidateSelf();
        r11.w();
    L45:
        g r21 = null;
        if (r13.hasValue(0) == false) goto L50;
        int r22 = r13.getResourceId(0, 0);
        if (r22 == 0) goto L50;
        d r23 = new d(r14, r22);
    L51:
        r23.f13754k = r13.getDimension(1, r23.f13754k);
        r11.S(r23);
        int r24 = r13.getInt(3, 0);
        if (r24 != 1) goto L54;
        TextUtils.TruncateAt r25 = TextUtils.TruncateAt.START;
    L60:
        r11.N0 = r25;
    L61:
        r11.G(r13.getBoolean(18, false));
        if (r19 != null) goto L64;
    L68:
        r11.D(c.c(r14, r13, 14));
        if (r13.hasValue(17) == false) goto L71;
        r11.F(c.a(r14, r13, 17));
    L71:
        r11.E(r13.getDimension(16, -1.0f));
        r11.O(r13.getBoolean(31, false));
        if (r19 != null) goto L74;
    L78:
        r11.J(c.c(r14, r13, 25));
        r11.N(c.a(r14, r13, 30));
        r11.L(r13.getDimension(28, 0.0f));
        r11.y(r13.getBoolean(6, false));
        r11.B(r13.getBoolean(10, false));
        if (r19 != null) goto L81;
    L85:
        r11.z(c.c(r14, r13, 7));
        if (r13.hasValue(9) == false) goto L89;
        r11.A(c.a(r14, r13, 9));
    L89:
        if (r13.hasValue(39) == false) goto L93;
        int r26 = r13.getResourceId(39, 0);
        if (r26 == 0) goto L93;
        g r27 = g.a(r14, r26);
    L94:
        r11.f4578f0 = r27;
        if (r13.hasValue(33) == false) goto L99;
        int r28 = r13.getResourceId(33, 0);
        if (r28 == 0) goto L99;
        r21 = g.a(r14, r28);
    L99:
        r11.f4579g0 = r21;
        float r29 = r13.getDimension(21, 0.0f);
        if (r11.f4580h0 == r29) goto L102;
        r11.f4580h0 = r29;
        r11.invalidateSelf();
        r11.w();
    L102:
        r11.Q(r13.getDimension(35, 0.0f));
        r11.P(r13.getDimension(34, 0.0f));
        float r30 = r13.getDimension(41, 0.0f);
        if (r11.f4583k0 == r30) goto L105;
        r11.f4583k0 = r30;
        r11.invalidateSelf();
        r11.w();
    L105:
        float r31 = r13.getDimension(40, 0.0f);
        if (r11.f4584l0 == r31) goto L108;
        r11.f4584l0 = r31;
        r11.invalidateSelf();
        r11.w();
    L108:
        r11.M(r13.getDimension(29, 0.0f));
        r11.K(r13.getDimension(27, 0.0f));
        float r32 = r13.getDimension(13, 0.0f);
        if (r11.f4587o0 == r32) goto L111;
        r11.f4587o0 = r32;
        r11.invalidateSelf();
        r11.w();
    L111:
        r11.P0 = r13.getDimensionPixelSize(4, Integer.MAX_VALUE);
        r13.recycle();
        TypedArray r33 = l.d(r8, r19, r12, R.attr.chipStyle, R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        this.f4569x = r33.getBoolean(32, false);
        this.f4571z = (int) Math.ceil(r33.getDimension(20, (float) Math.ceil(TypedValue.applyDimension(1, 48, getContext().getResources().getDisplayMetrics()))));
        r33.recycle();
        setChipDrawable(r11);
        WeakHashMap<View, h0> r34 = w.f8437a;
        r11.j(w.i.i(this));
        TypedArray r35 = l.d(r8, r19, r12, R.attr.chipStyle, R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        boolean r36 = r35.hasValue(37);
        r35.recycle();
        this.B = new b(this, this);
        e();
        if (r36 == true) goto L114;
        setOutlineProvider(new n9.b(this));
    L114:
        setChecked(this.f4565t);
        setText(r11.P);
        setEllipsize(r11.N0);
        h();
        if (this.f4560o.O0 == true) goto L117;
        setLines(1);
        setHorizontallyScrolling(true);
    L117:
        setGravity(8388627);
        g();
        if (this.f4569x == false) goto L120;
        setMinHeight(this.f4571z);
    L120:
        this.f4570y = w.e.d(this);
        super.setOnCheckedChangeListener(new n9.a(this));
        return;
    L93:
        r27 = null;
        goto L94
    L81:
        if (r19.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null) goto L85;
        if (r19.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null) goto L85;
        r11.B(r13.getBoolean(8, false));
        goto L85
    L74:
        if (r19.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null) goto L78;
        if (r19.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null) goto L78;
        r11.O(r13.getBoolean(26, false));
        goto L78
    L64:
        if (r19.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null) goto L68;
        if (r19.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null) goto L68;
        r11.G(r13.getBoolean(15, false));
        goto L68
    L54:
        if (r24 == 2) goto L58;
        if (r24 != 3) goto L61;
        r25 = TextUtils.TruncateAt.END;
        goto L60
    L58:
        r25 = TextUtils.TruncateAt.MIDDLE;
    L50:
        r23 = null;
        goto L51
    L6:
        if (r19.getAttributeValue("http://schemas.android.com/apk/res/android", TraceCons.METRIC_BACKGROUND) == null) goto L9;
        Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
    L9:
        if (r19.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) goto L131;
        if (r19.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) goto L129;
        if (r19.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) goto L127;
        if (r19.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) goto L125;
        if (r19.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) == false) goto L123;
        if (r19.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1) goto L123;
        if (r19.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1) goto L123;
        if (r19.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) goto L123;
        if (r19.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) == 8388627) goto L27;
        Log.w("Chip", "Chip text must be vertically center and start aligned");
    L123:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    L125:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L127:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L129:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    L131:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    public static /* synthetic */ Rect b(Chip r8) {
        return r8.getCloseIconTouchBoundsInt();
    }

    private RectF getCloseIconTouchBounds() {
        RectF r8 = this.E;
        r8.setEmpty();
        if (d() == true) goto L5;
    L13:
        return r8;
    L5:
        if (this.f4563r == null) goto L13;
        com.google.android.material.chip.a r10 = this.f4560o;
        Rect r11 = r10.getBounds();
        r8.setEmpty();
        if (r10.V() == false) goto L13;
        float r12 = (((r10.f4587o0 + r10.f4586n0) + r10.Z) + r10.f4585m0) + r10.f4584l0;
        if (b0.a.c.a(r10) != 0) goto L11;
        float r13 = r11.right;
        r8.right = r13;
        r8.left = r13 - r12;
    L12:
        r8.top = r11.top;
        r8.bottom = r11.bottom;
        goto L13
    L11:
        float r14 = r11.left;
        r8.left = r14;
        r8.right = r14 + r12;
        goto L12
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF r8 = getCloseIconTouchBounds();
        int r10 = (int) r8.left;
        int r11 = (int) r8.top;
        int r12 = (int) r8.right;
        int r13 = (int) r8.bottom;
        Rect r14 = this.D;
        r14.set(r10, r11, r12, r13);
        return r14;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f4594v0.f4884f;
    }

    private void setCloseIconHovered(boolean r8) {
        if (this.f4567v == r8) goto L6;
        this.f4567v = r8;
        refreshDrawableState();
        return;
    }

    private void setCloseIconPressed(boolean r8) {
        if (this.f4566u == r8) goto L6;
        this.f4566u = r8;
        refreshDrawableState();
        return;
    }

    @Override // com.google.android.material.chip.a.InterfaceC0050a
    public final void a() {
        c(this.f4571z);
        requestLayout();
        invalidateOutline();
    }

    public final void c(int r11) {
        this.f4571z = r11;
        int r8 = 0;
        if (this.f4569x == true) goto L10;
        InsetDrawable r12 = this.f4561p;
        if (r12 == null) goto L8;
        if (r12 == null) goto L44;
        this.f4561p = null;
        setMinWidth(0);
        setMinHeight((int) getChipMinHeight());
        f();
        return;
    L44:
        return;
    L8:
        f();
        return;
    L10:
        int r10 = Math.max(0, r11 - ((int) this.f4560o.K));
        int r13 = Math.max(0, r11 - this.f4560o.getIntrinsicWidth());
        if (r13 > 0) goto L19;
        if (r10 > 0) goto L19;
        InsetDrawable r14 = this.f4561p;
        if (r14 == null) goto L17;
        if (r14 == null) goto L46;
        this.f4561p = null;
        setMinWidth(0);
        setMinHeight((int) getChipMinHeight());
        f();
        return;
    L46:
        return;
    L17:
        f();
        return;
    L19:
        if (r13 <= 0) goto L21;
        int r15 = r13 / 2;
    L22:
        if (r10 <= 0) goto L24;
        r8 = r10 / 2;
    L24:
        int r16 = r8;
        if (this.f4561p == null) goto L37;
        Rect r17 = new Rect();
        this.f4561p.getPadding(r17);
        if (r17.top != r16) goto L37;
        if (r17.bottom != r16) goto L37;
        if (r17.left != r15) goto L37;
        if (r17.right != r15) goto L37;
        f();
        return;
    L37:
        if (getMinHeight() == r11) goto L40;
        setMinHeight(r11);
    L40:
        if (getMinWidth() == r11) goto L42;
        setMinWidth(r11);
    L42:
        this.f4561p = new InsetDrawable(this.f4560o, r15, r16, r15, r16);
        f();
        return;
    L21:
        r15 = 0;
        goto L22
    }

    public final boolean d() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 == null) goto L12;
        Object r10 = r8.W;
        if (r10 != null) goto L7;
        r10 = null;
    L10:
        if (r10 == null) goto L12;
        return true;
    L7:
        if ((r10 instanceof b0.b) == false) goto L10;
        r10 = ((b0.b) r10).a();
    L12:
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r11) {
        if (this.C == false) goto L5;
        b r8 = this.B;
        AccessibilityManager r10 = r8.f9576h;
        if (r10.isEnabled() == true) goto L9;
    L35:
        boolean r12 = false;
    L36:
        if (r12 == false) goto L38;
        return true;
    L38:
        if (super.dispatchHoverEvent(r11) == false) goto L41;
        return true;
    L41:
        return false;
    L9:
        if (r10.isTouchExplorationEnabled() == false) goto L35;
        int r13 = r11.getAction();
        if (r13 != 7) goto L14;
    L23:
        float r14 = r11.getX();
        float r15 = r11.getY();
        Chip r16 = r8.f4573q;
        if (r16.d() == true) goto L26;
    L28:
        int r17 = 0;
    L29:
        int r18 = r8.f9581m;
        if (r18 == r17) goto L33;
        r8.f9581m = r17;
        r8.q(r17, 128);
        r8.q(r18, 256);
    L33:
        if (r17 == Integer.MIN_VALUE) goto L35;
    L34:
        r12 = true;
        goto L36
    L26:
        if (r16.getCloseIconTouchBounds().contains(r14, r15) == false) goto L28;
        r17 = 1;
        goto L29
    L14:
        if (r13 == 9) goto L23;
        if (r13 != 10) goto L35;
        int r19 = r8.f9581m;
        if (r19 == Integer.MIN_VALUE) goto L35;
        if (r19 == Integer.MIN_VALUE) goto L34;
        r8.f9581m = Integer.MIN_VALUE;
        r8.q(Integer.MIN_VALUE, 128);
        r8.q(r19, 256);
        goto L34
    L5:
        return super.dispatchHoverEvent(r11);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r10) {
        if (this.C == false) goto L5;
        b r8 = this.B;
        r8.getClass();
        boolean r11 = false;
        int r12 = 0;
        r11 = false;
        r11 = false;
        r11 = false;
        r11 = false;
        r11 = false;
        if (r10.getAction() == 1) goto L54;
        int r13 = r10.getKeyCode();
        if (r13 == 61) goto L49;
        int r14 = 66;
        if (r13 == 66) goto L32;
        switch(r13) {
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L15;
            case 22: goto L15;
            case 23: goto L32;
            default: goto L54;
        };
    L15:
        if (r10.hasNoModifiers() == false) goto L54;
        if (r13 != 19) goto L19;
        r14 = 33;
    L25:
        int r15 = r10.getRepeatCount() + 1;
        boolean r16 = false;
    L26:
        if (r12 >= r15) goto L30;
        if (r8.m(r14, null) == false) goto L30;
        r12 = r12 + 1;
        r16 = true;
    L30:
        r11 = r16;
        goto L54
    L19:
        if (r13 != 21) goto L21;
        r14 = 17;
        goto L25
    L21:
        if (r13 == 22) goto L25;
        r14 = ApWakeEvent.ACCELERATING_START;
    L32:
        if (r10.hasNoModifiers() == false) goto L54;
        if (r10.getRepeatCount() != 0) goto L54;
        int r17 = r8.f9580l;
        if (r17 == Integer.MIN_VALUE) goto L47;
        Chip r18 = r8.f4573q;
        if (r17 != 0) goto L40;
        r18.performClick();
        goto L47
    L40:
        if (r17 != 1) goto L47;
        r18.playSoundEffect(0);
        View.OnClickListener r19 = r18.f4563r;
        if (r19 == null) goto L45;
        r19.onClick(r18);
    L45:
        if (r18.C == false) goto L47;
        r18.B.q(1, 1);
    L47:
        r11 = true;
        goto L54
    L49:
        if (r10.hasNoModifiers() == false) goto L52;
        r11 = r8.m(2, null);
        goto L54
    L52:
        if (r10.hasModifiers(1) == false) goto L54;
        r11 = r8.m(1, null);
    L54:
        if (r11 == false) goto L59;
        if (r8.f9580l == Integer.MIN_VALUE) goto L59;
        return true;
    L59:
        return super.dispatchKeyEvent(r10);
    L5:
        return super.dispatchKeyEvent(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a r8 = this.f4560o;
        boolean r10 = false;
        if (r8 != null) goto L5;
    L39:
        if (r10 == false) goto L42;
        invalidate();
        return;
    L42:
        return;
    L5:
        if (com.google.android.material.chip.a.v(r8.W) == false) goto L39;
        com.google.android.material.chip.a r11 = this.f4560o;
        ?? r12 = isEnabled();
        int r13 = r12;
        if (this.f4568w == false) goto L9;
        r13 = r12 + 1;
    L9:
        int r14 = r13;
        if (this.f4567v == false) goto L12;
        r14 = r13 + 1;
    L12:
        int r15 = r14;
        if (this.f4566u == false) goto L15;
        r15 = r14 + 1;
    L15:
        int r16 = r15;
        if (isChecked() == false) goto L18;
        r16 = r15 + 1;
    L18:
        int[] r17 = new int[r16];
        if (isEnabled() == false) goto L21;
        r17[0] = 16842910;
        int r18 = 1;
    L23:
        if (this.f4568w == false) goto L26;
        r17[r18] = 16842908;
        r18 = r18 + 1;
    L26:
        if (this.f4567v == false) goto L29;
        r17[r18] = 16843623;
        r18 = r18 + 1;
    L29:
        if (this.f4566u == false) goto L32;
        r17[r18] = 16842919;
        r18 = r18 + 1;
    L32:
        if (isChecked() == false) goto L35;
        r17[r18] = 16842913;
    L35:
        if (Arrays.equals(r11.J0, r17) == true) goto L39;
        r11.J0 = r17;
        if (r11.V() == false) goto L39;
        r10 = r11.x(r11.getState(), r17);
        goto L39
    L21:
        r18 = 0;
        goto L23
    }

    public final void e() {
        boolean r8 = false;
        if (d() == false) goto L14;
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L14;
        if (this.f4563r == null) goto L14;
        w.m(this, this.B);
        r8 = true;
    L15:
        this.C = r8;
        return;
    L7:
        if (r10.V == false) goto L9;
        r11 = true;
    L14:
        w.m(this, null);
        goto L15
    }

    public final void f() {
        ColorStateList r8 = this.f4560o.O;
        if (r8 != null) goto L6;
        r8 = ColorStateList.valueOf(0);
    L6:
        this.f4562q = new RippleDrawable(r8, getBackgroundDrawable(), null);
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10.K0 == false) goto L9;
        r10.K0 = false;
        r10.L0 = null;
        r10.onStateChange(r10.getState());
    L9:
        RippleDrawable r11 = this.f4562q;
        WeakHashMap<View, h0> r12 = w.f8437a;
        w.d.q(this, r11);
        g();
    }

    public final void g() {
        if (TextUtils.isEmpty(getText()) == true) goto L12;
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 == null) goto L13;
        float r10 = r8.f4587o0 + r8.f4584l0;
        int r11 = (int) (r8.r() + r10);
        com.google.android.material.chip.a r12 = this.f4560o;
        float r13 = r12.f4580h0 + r12.f4583k0;
        int r14 = (int) (r12.q() + r13);
        if (this.f4561p == null) goto L10;
        Rect r15 = new Rect();
        this.f4561p.getPadding(r15);
        r14 = r14 + r15.left;
        r11 = r11 + r15.right;
    L10:
        int r16 = getPaddingTop();
        int r17 = getPaddingBottom();
        WeakHashMap<View, h0> r18 = w.f8437a;
        w.e.k(this, r14, r16, r11, r17);
        return;
    L13:
        return;
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (TextUtils.isEmpty(this.A) == false) goto L5;
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L9;
    L11:
        boolean r10 = false;
    L13:
        if (r10 == false) goto L20;
        ViewParent r11 = getParent();
        if ((r11 instanceof n9.c) == true) goto L17;
        return "android.widget.Button";
    L17:
        ((n9.c) r11).getClass();
        throw null;
    L20:
        if (isClickable() == false) goto L22;
        return "android.widget.Button";
    L22:
        return "android.view.View";
    L9:
        if (r8.f4575b0 == false) goto L11;
        r10 = true;
        goto L13
    L5:
        return this.A;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable r8 = this.f4561p;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return this.f4560o;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.d0;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f4577e0;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.J;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L5;
        return 0.0f;
    L5:
        return Math.max(0.0f, r8.s());
    }

    public Drawable getChipDrawable() {
        return this.f4560o;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.f4587o0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    public Drawable getChipIcon() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 == null) goto L11;
        Object r10 = r8.R;
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10 instanceof b0.b) == false) goto L10;
        r10 = ((b0.b) r10).a();
    L10:
        return r10;
    L11:
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.T;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.S;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.K;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.f4580h0;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.M;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.N;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    public Drawable getCloseIcon() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 == null) goto L11;
        Object r10 = r8.W;
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10 instanceof b0.b) == false) goto L10;
        r10 = ((b0.b) r10).a();
    L10:
        return r10;
    L11:
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f4574a0;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.f4586n0;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.Z;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.f4585m0;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.Y;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.N0;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect r8) {
        if (this.C == false) goto L9;
        b r10 = this.B;
        if (r10.f9580l != 1) goto L7;
    L8:
        r8.set(getCloseIconTouchBoundsInt());
        return;
    L7:
        if (r10.f9579k == 1) goto L8;
    L9:
        super.getFocusedRect(r8);
    }

    public g getHideMotionSpec() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f4579g0;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.f4582j0;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.f4581i0;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.O;
    }

    public j getShapeAppearanceModel() {
        return this.f4560o.f139a.f156a;
    }

    public g getShowMotionSpec() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f4578f0;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.f4584l0;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return r8.f4583k0;
    }

    public final void h() {
        TextPaint r8 = getPaint();
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L5;
        r8.drawableState = r10.getState();
    L5:
        d r11 = getTextAppearance();
        if (r11 == null) goto L9;
        r11.e(getContext(), r8, this.F);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        defpackage.c.i0(this, this.f4560o);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        int[] r10 = super.onCreateDrawableState(r8 + 2);
        if (isChecked() == false) goto L5;
        CheckBox.mergeDrawableStates(r10, H);
    L5:
        com.google.android.material.chip.a r11 = this.f4560o;
        if (r11 != null) goto L8;
    L10:
        boolean r12 = false;
    L11:
        if (r12 == false) goto L13;
        CheckBox.mergeDrawableStates(r10, I);
    L13:
        return r10;
    L8:
        if (r11.f4575b0 == false) goto L10;
        r12 = true;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean r8, int r10, Rect r11) {
        super.onFocusChanged(r8, r10, r11);
        if (this.C == false) goto L10;
        b r12 = this.B;
        int r13 = r12.f9580l;
        if (r13 == Integer.MIN_VALUE) goto L7;
        r12.j(r13);
    L7:
        if (r8 == false) goto L11;
        r12.m(r10, r11);
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent r8) {
        int r10 = r8.getActionMasked();
        if (r10 != 7) goto L5;
        boolean r11 = getCloseIconTouchBounds().contains(r8.getX(), r8.getY());
    L9:
        setCloseIconHovered(r11);
    L11:
        return super.onHoverEvent(r8);
    L5:
        if (r10 != 10) goto L11;
        r11 = false;
        goto L9
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(getAccessibilityClassName());
        com.google.android.material.chip.a r8 = this.f4560o;
        if (r8 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        r10.setCheckable(r11);
        r10.setClickable(isClickable());
        if ((getParent() instanceof n9.c) == false) goto L39;
        n9.c r12 = (n9.c) getParent();
        k0.f r13 = new k0.f(r10);
        int r14 = -1;
        if (r12.f4860m == false) goto L27;
        int r15 = 0;
        int r16 = 0;
    L14:
        if (r15 >= r12.getChildCount()) goto L27;
        View r17 = r12.getChildAt(r15);
        if ((r17 instanceof Chip) == false) goto L26;
        if (r12.getChildAt(r15).getVisibility() != 0) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == false) goto L26;
        if (((Chip) r17) == this) goto L28;
        r16 = r16 + 1;
    L28:
        Object r19 = getTag(R.id.row_index_key);
        if ((r19 instanceof Integer) == false) goto L32;
        r14 = ((Integer) r19).intValue();
    L32:
        r13.h(k0.f.c.a(r14, 1, r16, 1, isChecked()));
        return;
    L20:
        r18 = false;
    L26:
        r15 = r15 + 1;
    L27:
        r16 = -1;
        goto L28
    L39:
        return;
    L5:
        if (r8.f4575b0 == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public final PointerIcon onResolvePointerIcon(MotionEvent r8, int r10) {
        if (getCloseIconTouchBounds().contains(r8.getX(), r8.getY()) == false) goto L9;
        if (isEnabled() == false) goto L9;
        return PointerIcon.getSystemIcon(getContext(), 1002);
    L9:
        return super.onResolvePointerIcon(r8, r10);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public final void onRtlPropertiesChanged(int r8) {
        super.onRtlPropertiesChanged(r8);
        if (this.f4570y == r8) goto L6;
        this.f4570y = r8;
        g();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent r8) {
        int r10 = r8.getActionMasked();
        boolean r11 = getCloseIconTouchBounds().contains(r8.getX(), r8.getY());
        if (r10 == 0) goto L25;
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L11;
        if (r10 != 3) goto L28;
    L23:
        boolean r12 = false;
    L24:
        setCloseIconPressed(false);
    L29:
        if (r12 == false) goto L31;
        return true;
    L31:
        if (super.onTouchEvent(r8) == false) goto L34;
        return true;
    L34:
        return false;
    L28:
        r12 = false;
        goto L29
    L11:
        if (this.f4566u == false) goto L28;
        if (r11 == true) goto L27;
        setCloseIconPressed(false);
    L27:
        r12 = true;
        goto L29
    L15:
        if (this.f4566u == false) goto L23;
        playSoundEffect(0);
        View.OnClickListener r13 = this.f4563r;
        if (r13 == null) goto L20;
        r13.onClick(this);
    L20:
        if (this.C == false) goto L22;
        this.B.q(1, 1);
    L22:
        r12 = true;
        goto L24
    L25:
        if (r11 == false) goto L28;
        setCloseIconPressed(true);
        goto L27
    }

    public void setAccessibilityClassName(CharSequence r8) {
        this.A = r8;
    }

    @Override // android.view.View
    public void setBackground(Drawable r8) {
        if (r8 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackground(r8);
        return;
    L5:
        if (r8 == this.f4562q) goto L7;
        Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r8) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        if (r8 != getBackgroundDrawable()) goto L5;
    L7:
        super.setBackgroundDrawable(r8);
        return;
    L5:
        if (r8 == this.f4562q) goto L7;
        Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int r8) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r8) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r8) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.y(r8);
        return;
    }

    public void setCheckableResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.y(r10.f4588p0.getResources().getBoolean(r8));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L6;
        this.f4565t = r8;
        return;
    L6:
        if (r10.f4575b0 == false) goto L10;
        super.setChecked(r8);
        return;
    }

    public void setCheckedIcon(Drawable r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.z(r8);
        return;
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean r8) {
        setCheckedIconVisible(r8);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int r8) {
        setCheckedIconVisible(r8);
    }

    public void setCheckedIconResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.z(d.a.a(r10.f4588p0, r8));
        return;
    }

    public void setCheckedIconTint(ColorStateList r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.A(r8);
        return;
    }

    public void setCheckedIconTintResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.A(androidx.core.content.a.b(r10.f4588p0, r8));
        return;
    }

    public void setCheckedIconVisible(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.B(r10.f4588p0.getResources().getBoolean(r8));
        return;
    }

    public void setChipBackgroundColor(ColorStateList r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.J == r8) goto L9;
        r10.J = r8;
        r10.onStateChange(r10.getState());
        return;
    }

    public void setChipBackgroundColorResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L8;
        ColorStateList r11 = androidx.core.content.a.b(r10.f4588p0, r8);
        if (r10.J == r11) goto L9;
        r10.J = r11;
        r10.onStateChange(r10.getState());
        return;
    L9:
        return;
    }

    @Deprecated
    public void setChipCornerRadius(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.C(r8);
        return;
    }

    @Deprecated
    public void setChipCornerRadiusResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.C(r10.f4588p0.getResources().getDimension(r8));
        return;
    }

    public void setChipDrawable(com.google.android.material.chip.a r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == r8) goto L8;
        if (r10 == null) goto L6;
        r10.M0 = new WeakReference(null);
    L6:
        this.f4560o = r8;
        r8.O0 = false;
        r8.M0 = new WeakReference(this);
        c(this.f4571z);
        return;
    }

    public void setChipEndPadding(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f4587o0 == r8) goto L9;
        r10.f4587o0 = r8;
        r10.invalidateSelf();
        r10.w();
        return;
    }

    public void setChipEndPaddingResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L8;
        float r11 = r10.f4588p0.getResources().getDimension(r8);
        if (r10.f4587o0 == r11) goto L9;
        r10.f4587o0 = r11;
        r10.invalidateSelf();
        r10.w();
        return;
    L9:
        return;
    }

    public void setChipIcon(Drawable r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.D(r8);
        return;
    }

    @Deprecated
    public void setChipIconEnabled(boolean r8) {
        setChipIconVisible(r8);
    }

    @Deprecated
    public void setChipIconEnabledResource(int r8) {
        setChipIconVisible(r8);
    }

    public void setChipIconResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.D(d.a.a(r10.f4588p0, r8));
        return;
    }

    public void setChipIconSize(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.E(r8);
        return;
    }

    public void setChipIconSizeResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.E(r10.f4588p0.getResources().getDimension(r8));
        return;
    }

    public void setChipIconTint(ColorStateList r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.F(r8);
        return;
    }

    public void setChipIconTintResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.F(androidx.core.content.a.b(r10.f4588p0, r8));
        return;
    }

    public void setChipIconVisible(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.G(r10.f4588p0.getResources().getBoolean(r8));
        return;
    }

    public void setChipMinHeight(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.K == r8) goto L9;
        r10.K = r8;
        r10.invalidateSelf();
        r10.w();
        return;
    }

    public void setChipMinHeightResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L8;
        float r11 = r10.f4588p0.getResources().getDimension(r8);
        if (r10.K == r11) goto L9;
        r10.K = r11;
        r10.invalidateSelf();
        r10.w();
        return;
    L9:
        return;
    }

    public void setChipStartPadding(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f4580h0 == r8) goto L9;
        r10.f4580h0 = r8;
        r10.invalidateSelf();
        r10.w();
        return;
    }

    public void setChipStartPaddingResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L8;
        float r11 = r10.f4588p0.getResources().getDimension(r8);
        if (r10.f4580h0 == r11) goto L9;
        r10.f4580h0 = r11;
        r10.invalidateSelf();
        r10.w();
        return;
    L9:
        return;
    }

    public void setChipStrokeColor(ColorStateList r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.H(r8);
        return;
    }

    public void setChipStrokeColorResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.H(androidx.core.content.a.b(r10.f4588p0, r8));
        return;
    }

    public void setChipStrokeWidth(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.I(r8);
        return;
    }

    public void setChipStrokeWidthResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.I(r10.f4588p0.getResources().getDimension(r8));
        return;
    }

    @Deprecated
    public void setChipText(CharSequence r8) {
        setText(r8);
    }

    @Deprecated
    public void setChipTextResource(int r8) {
        setText(getResources().getString(r8));
    }

    public void setCloseIcon(Drawable r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L5;
        r10.J(r8);
    L5:
        e();
    }

    public void setCloseIconContentDescription(CharSequence r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f4574a0 == r8) goto L9;
        h0.a r11 = h0.a.c();
        r10.f4574a0 = r11.d(r8, r11.f7871c);
        r10.invalidateSelf();
        return;
    }

    @Deprecated
    public void setCloseIconEnabled(boolean r8) {
        setCloseIconVisible(r8);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int r8) {
        setCloseIconVisible(r8);
    }

    public void setCloseIconEndPadding(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.K(r8);
        return;
    }

    public void setCloseIconEndPaddingResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.K(r10.f4588p0.getResources().getDimension(r8));
        return;
    }

    public void setCloseIconResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L5;
        r10.J(d.a.a(r10.f4588p0, r8));
    L5:
        e();
    }

    public void setCloseIconSize(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.L(r8);
        return;
    }

    public void setCloseIconSizeResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.L(r10.f4588p0.getResources().getDimension(r8));
        return;
    }

    public void setCloseIconStartPadding(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.M(r8);
        return;
    }

    public void setCloseIconStartPaddingResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.M(r10.f4588p0.getResources().getDimension(r8));
        return;
    }

    public void setCloseIconTint(ColorStateList r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.N(r8);
        return;
    }

    public void setCloseIconTintResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.N(androidx.core.content.a.b(r10.f4588p0, r8));
        return;
    }

    public void setCloseIconVisible(int r8) {
        setCloseIconVisible(getResources().getBoolean(r8));
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        if (r8 != null) goto L9;
        if (r11 != null) goto L7;
        super.setCompoundDrawables(r8, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        if (r8 != null) goto L9;
        if (r11 != null) goto L7;
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int r8, int r10, int r11, int r12) {
        if (r8 != 0) goto L9;
        if (r11 != 0) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r8, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int r8, int r10, int r11, int r12) {
        if (r8 != 0) goto L9;
        if (r11 != 0) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r8, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        super.setElevation(r8);
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.j(r8);
        return;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt r8) {
        if (this.f4560o != null) goto L6;
        return;
    L6:
        if (r8 == TextUtils.TruncateAt.MARQUEE) goto L12;
        super.setEllipsize(r8);
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L13;
        r10.N0 = r8;
        return;
    L13:
        return;
    L12:
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean r8) {
        this.f4569x = r8;
        c(this.f4571z);
    }

    @Override // android.widget.TextView
    public void setGravity(int r8) {
        if (r8 == 8388627) goto L5;
        Log.w("Chip", "Chip text must be vertically center and start aligned");
        return;
    L5:
        super.setGravity(r8);
    }

    public void setHideMotionSpec(g r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.f4579g0 = r8;
        return;
    }

    public void setHideMotionSpecResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.f4579g0 = g.a(r10.f4588p0, r8);
        return;
    }

    public void setIconEndPadding(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.P(r8);
        return;
    }

    public void setIconEndPaddingResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.P(r10.f4588p0.getResources().getDimension(r8));
        return;
    }

    public void setIconStartPadding(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.Q(r8);
        return;
    }

    public void setIconStartPaddingResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.Q(r10.f4588p0.getResources().getDimension(r8));
        return;
    }

    public void setInternalOnCheckedChangeListener(com.google.android.material.internal.g<Chip> r8) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int r8) {
        if (this.f4560o != null) goto L5;
        return;
    L5:
        super.setLayoutDirection(r8);
    }

    @Override // android.widget.TextView
    public void setLines(int r8) {
        if (r8 > 1) goto L7;
        super.setLines(r8);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int r8) {
        if (r8 > 1) goto L7;
        super.setMaxLines(r8);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r8) {
        super.setMaxWidth(r8);
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.P0 = r8;
        return;
    }

    @Override // android.widget.TextView
    public void setMinLines(int r8) {
        if (r8 > 1) goto L7;
        super.setMinLines(r8);
        return;
    L7:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r8) {
        this.f4564s = r8;
    }

    public void setOnCloseIconClickListener(View.OnClickListener r8) {
        this.f4563r = r8;
        e();
    }

    public void setRippleColor(ColorStateList r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.R(r8);
    L6:
        if (this.f4560o.K0 == true) goto L9;
        f();
        return;
    }

    public void setRippleColorResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L8;
        r10.R(androidx.core.content.a.b(r10.f4588p0, r8));
        if (this.f4560o.K0 == true) goto L9;
        f();
        return;
    L9:
        return;
    }

    @Override // aa.n
    public void setShapeAppearanceModel(j r8) {
        this.f4560o.setShapeAppearanceModel(r8);
    }

    public void setShowMotionSpec(g r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.f4578f0 = r8;
        return;
    }

    public void setShowMotionSpecResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.f4578f0 = g.a(r10.f4588p0, r8);
        return;
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean r8) {
        if (r8 == false) goto L6;
        super.setSingleLine(r8);
        return;
    L6:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r8, TextView.BufferType r10) {
        com.google.android.material.chip.a r11 = this.f4560o;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        if (r11.O0 == false) goto L10;
        CharSequence r12 = null;
    L11:
        super.setText(r12, r10);
        com.google.android.material.chip.a r13 = this.f4560o;
        if (r13 != null) goto L14;
        return;
    L14:
        if (TextUtils.equals(r13.P, r8) == true) goto L18;
        r13.P = r8;
        r13.f4594v0.f4882d = true;
        r13.invalidateSelf();
        r13.w();
        return;
    L18:
        return;
    L10:
        r12 = r8;
        goto L11
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int r8) {
        super.setTextAppearance(r8);
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L5;
        r10.S(new d(r10.f4588p0, r8));
    L5:
        h();
    }

    public void setTextAppearanceResource(int r8) {
        setTextAppearance(getContext(), r8);
    }

    public void setTextEndPadding(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f4584l0 == r8) goto L9;
        r10.f4584l0 = r8;
        r10.invalidateSelf();
        r10.w();
        return;
    }

    public void setTextEndPaddingResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L8;
        float r11 = r10.f4588p0.getResources().getDimension(r8);
        if (r10.f4584l0 == r11) goto L9;
        r10.f4584l0 = r11;
        r10.invalidateSelf();
        r10.w();
        return;
    L9:
        return;
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r8, float r10) {
        super.setTextSize(r8, r10);
        com.google.android.material.chip.a r11 = this.f4560o;
        if (r11 == null) goto L7;
        float r12 = TypedValue.applyDimension(r8, r10, getResources().getDisplayMetrics());
        com.google.android.material.internal.j r13 = r11.f4594v0;
        d r14 = r13.f4884f;
        if (r14 == null) goto L7;
        r14.f13754k = r12;
        r13.f4879a.setTextSize(r12);
        r11.a();
    L7:
        h();
    }

    public void setTextStartPadding(float r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f4583k0 == r8) goto L9;
        r10.f4583k0 = r8;
        r10.invalidateSelf();
        r10.w();
        return;
    }

    public void setTextStartPaddingResource(int r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L8;
        float r11 = r10.f4588p0.getResources().getDimension(r8);
        if (r10.f4583k0 == r11) goto L9;
        r10.f4583k0 = r11;
        r10.invalidateSelf();
        r10.w();
        return;
    L9:
        return;
    }

    public void setCloseIconVisible(boolean r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L5;
        r10.O(r8);
    L5:
        e();
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        if (r8 != null) goto L9;
        if (r11 != null) goto L7;
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r8, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        if (r8 != null) goto L9;
        if (r11 != null) goto L7;
        super.setCompoundDrawablesWithIntrinsicBounds(r8, r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    L9:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    public void setCheckedIconVisible(boolean r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.B(r8);
        return;
    }

    public void setChipIconVisible(boolean r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L6;
        r10.G(r8);
        return;
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context r8, int r10) {
        super.setTextAppearance(r8, r10);
        com.google.android.material.chip.a r11 = this.f4560o;
        if (r11 == null) goto L5;
        r11.S(new d(r11.f4588p0, r10));
    L5:
        h();
    }

    public void setTextAppearance(d r8) {
        com.google.android.material.chip.a r10 = this.f4560o;
        if (r10 == null) goto L5;
        r10.S(r8);
    L5:
        h();
    }
}
