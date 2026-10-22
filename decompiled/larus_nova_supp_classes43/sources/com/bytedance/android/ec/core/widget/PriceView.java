package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class PriceView extends com.bytedance.android.ec.core.widget.price.PriceView {
    public static final /* synthetic */ int J = 0;
    public float A;
    public int B;
    public Paint C;
    public float D;
    public boolean E;
    public Boolean F;
    public String G;
    public String H;
    public String I;
    public Paint c;
    public Paint d;
    public Paint e;
    public final Paint f;
    public int g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public float u;
    public String v;
    public float w;
    public Paint x;
    public final float y;
    public String z;

    public class a extends AccessibilityDelegateCompat {
        public final /* synthetic */ PriceView a;

        public a(PriceView r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            if (r11 != null) goto L5;
            return;
        L5:
            PriceView r12 = this.a;
            int r0 = PriceView.J;
            r11.setText(r12.D());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private float getCalculateViewWidth() {
        float r1 = 0.0f;
        if (TextUtils.isEmpty(this.j) == true) goto L12;
        float r0 = this.d.measureText(this.j);
        if (TextUtils.isEmpty(this.k) == true) goto L8;
        r0 = r0 + this.e.measureText(this.k);
    L8:
        if (TextUtils.isEmpty(this.H) == true) goto L14;
        r0 = r0 + this.d.measureText(this.H);
        if (TextUtils.isEmpty(this.I) == true) goto L14;
        r0 = r0 + this.e.measureText(this.I);
    L14:
        if (TextUtils.isEmpty(this.v) == true) goto L16;
        float r10 = this.x.measureText(this.v) + this.y;
    L18:
        if (this.i == true) goto L20;
        float r11 = this.u + this.o;
    L22:
        if (TextUtils.isEmpty(this.z) == true) goto L25;
        r1 = this.C.measureText(this.z);
    L25:
        return (((((r10 + r11) + r0) + r1) + getPaddingRight()) + getPaddingLeft()) + 0.5f;
    L20:
        r11 = 0.0f;
        goto L22
    L16:
        r10 = 0.0f;
        goto L18
    L12:
        r0 = 0.0f;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String D() {
        if (TextUtils.isEmpty(this.j) == false) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(this.G) == false) goto L13;
        Context r1 = getContext();
        if (this.s == false) goto L11;
        int r10 = 2131913940;
    L12:
        r0.append(r1.getString(r10));
    L14:
        r0.append(this.j);
        if (TextUtils.isEmpty(this.k) == true) goto L18;
        r0.append(this.k);
    L18:
        if (TextUtils.isEmpty(this.H) == true) goto L22;
        r0.append(this.H.replace("-", "至"));
        if (TextUtils.isEmpty(this.I) == true) goto L22;
        r0.append(this.I);
    L22:
        r0.append(getContext().getString(2131913847));
        if (TextUtils.isEmpty(this.z) == true) goto L26;
        r0.append(this.z);
    L26:
        return r0.toString();
    L11:
        r10 = 2131913848;
        goto L12
    L13:
        r0.append(this.G);
        goto L14
    }

    @Override // com.bytedance.android.ec.core.widget.price.PriceView
    public final boolean x() {
        if (this.F != null) goto L6;
        this.F = Boolean.valueOf(ECSettingKeys.J0());
    L6:
        return this.F.booleanValue();
    }

    public String getExtraText() {
        return this.z;
    }

    public String getMaxPriceDecimalText() {
        return this.I;
    }

    public String getMaxPriceIntegerText() {
        return this.H;
    }

    public String getPrefixText() {
        return this.v;
    }

    public String getPriceDecimalText() {
        return this.k;
    }

    public String getPriceIntegerText() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceView(Context r10) {
        super(r10);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        this.m = UIUtils.sp2px(getContext(), 20.0f);
        this.o = UIUtils.dip2Px(getContext(), 5.0f);
        this.p = UIUtils.sp2px(getContext(), 1.0f);
        this.u = 0.0f;
        this.y = UIUtils.sp2px(getContext(), 2.0f);
        this.A = UIUtils.sp2px(getContext(), 10.0f);
        this.B = -364470;
        this.D = 0.0f;
        this.E = false;
        this.F = null;
        E(r10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r13) {
        super/*android.widget.TextView*/.draw(r13);
        if (x() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.h) == true) goto L8;
    L9:
        float r0 = getHeight();
        Paint.FontMetrics r1 = this.c.getFontMetrics();
        Paint.FontMetrics r10 = this.d.getFontMetrics();
        if (this.l <= this.m) goto L12;
        float r11 = getPaddingTop();
        float r12 = r1.descent;
        float r14 = (r11 + (((r0 + r12) - r1.ascent) / 2.0f)) - r12;
    L13:
        float r15 = getPaddingLeft();
        if (TextUtils.isEmpty(this.v) == true) goto L17;
        float r16 = this.x.measureText(this.v);
        r13.drawText(this.v, r15, r14 - 2.0f, this.x);
        r15 = r15 + (r16 + this.y);
    L17:
        if (this.i == true) goto L22;
        if (TextUtils.isEmpty(this.h) == true) goto L22;
        r13.drawText(this.h, r15, r14, this.c);
        r15 = r15 + (this.u + this.o);
    L22:
        if (TextUtils.isEmpty(this.j) == true) goto L39;
        r13.drawText(this.j, r15, r14, this.d);
        float r17 = this.d.measureText(this.j);
        if (TextUtils.isEmpty(this.k) == true) goto L26;
        float r18 = this.e.measureText(this.k);
    L28:
        if (TextUtils.isEmpty(this.k) == true) goto L31;
        r13.drawText(this.k, r15 + r17, r14, this.e);
    L31:
        if (TextUtils.isEmpty(this.H) == true) goto L36;
        float r19 = (r15 + r18) + r17;
        r13.drawText(this.H, r19, r14, this.d);
        if (TextUtils.isEmpty(this.I) == true) goto L39;
        r13.drawText(this.I, r19 + this.d.measureText(this.H), r14, this.e);
        goto L39
    L36:
        if (TextUtils.isEmpty(this.z) == true) goto L39;
        r13.drawText(this.z, (r15 + r18) + r17, r14 - 2.0f, this.C);
        goto L39
    L26:
        r18 = 0.0f;
    L39:
        if (this.s == false) goto L43;
        this.f.setColor(this.g);
        this.f.setStrokeWidth(this.p);
        r13.drawLine(3.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth(), getMeasuredHeight() / 2.0f, this.f);
        return;
    L43:
        return;
    L12:
        float r20 = getPaddingTop();
        float r21 = r10.descent;
        r14 = (r20 + (((r0 + r21) - r10.ascent) / 2.0f)) - r21;
        goto L13
    L8:
        if (TextUtils.isEmpty(this.j) == false) goto L9;
    }

    public void setDeleteLineWidth(final float r10) {
        if (x() == false) goto L5;
        C(new b0(r10));
        return;
    L5:
        this.p = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setExtraText(final String r10) {
        if (x() == false) goto L5;
        C(new r(r10));
        return;
    L5:
        this.z = r10;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setExtraTextColor(final int r10) {
        if (x() == false) goto L5;
        C(new n(r10));
        return;
    L5:
        this.B = r10;
        this.C.setColor(r10);
        requestLayout();
        invalidate();
    }

    public void setExtraTextSize(float r1) {
        this.A = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setHideYang(final boolean r10) {
        if (x() == false) goto L5;
        C(new y(r10));
        return;
    L5:
        this.i = r10;
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxPriceText(final String r10) {
        if (x() == false) goto L6;
        C(new w(r10));
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        this.H = null;
    L15:
        requestLayout();
        invalidate();
        return;
    L8:
        if (this.t == true) goto L10;
    L12:
        this.H = r10;
        this.I = null;
    L13:
        this.H = "-" + this.H;
        goto L15
    L10:
        if (r10.contains(".") == false) goto L12;
        int r0 = r10.indexOf(".");
        this.H = r10.substring(0, r0);
        this.I = r10.substring(r0);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ec.core.widget.price.PriceView, com.bytedance.android.ec.core.widget.i
    public void setMaxWidth(float r10) {
        if (x() == true) goto L5;
        this.D = r10;
        requestLayout();
        invalidate();
        return;
    L5:
        if (r10 <= 0.0f) goto L7;
        super.setMaxWidth(r10);
    L8:
        C(new u());
        return;
    L7:
        super/*android.widget.TextView*/.setMaxWidth(Integer.MAX_VALUE);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPrefixText(final String r10) {
        if (x() == false) goto L5;
        C(new k(r10));
        return;
    L5:
        this.v = r10;
        requestLayout();
        invalidate();
    }

    public void setPrefixTextColor(final int r10) {
        if (x() == false) goto L6;
        C(new s(r10));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceBold(final boolean r10) {
        if (x() == false) goto L5;
        C(new l(r10));
        return;
    L5:
        this.q = r10;
        if (r10 == false) goto L8;
        this.d.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceDecimalTextSize(final float r10) {
        if (x() == false) goto L5;
        C(new o(this, r10));
        return;
    L5:
        this.t = true;
        this.n = r10;
        this.e.setTextSize(r10);
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceText(final String r10) {
        if (x() == false) goto L6;
        C(new x(r10));
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return;
    L8:
        if (this.t == true) goto L10;
    L12:
        this.j = r10;
        this.k = null;
    L13:
        requestLayout();
        invalidate();
        return;
    L10:
        if (r10.contains(".") == false) goto L12;
        int r0 = r10.indexOf(".");
        this.j = r10.substring(0, r0);
        this.k = r10.substring(r0);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceTextColor(final int r10) {
        if (x() == false) goto L5;
        C(new z(r10));
        return;
    L5:
        this.g = r10;
        this.c.setColor(r10);
        this.d.setColor(this.g);
        this.e.setColor(this.g);
        this.f.setColor(this.g);
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPriceTextSize(final float r10) {
        if (x() == false) goto L5;
        C(new a0(r10));
        return;
    L5:
        this.m = r10;
        this.d.setTextSize(r10);
        if (this.t == false) goto L8;
        this.e.setTextSize(r10 * 0.8f);
    L8:
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setShowDeleteLine(final boolean r10) {
        if (x() == false) goto L5;
        C(new c0(r10));
        return;
    L5:
        this.s = r10;
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSpaceSize(final float r10) {
        if (x() == false) goto L5;
        C(new p(r10));
        return;
    L5:
        this.o = r10;
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setThinDecimal(final boolean r10) {
        if (x() == false) goto L5;
        C(new t(this, r10));
        return;
    L5:
        this.t = r10;
        if (r10 == false) goto L8;
        this.n = this.m * 0.8f;
    L9:
        this.e.setTextSize(this.n);
        invalidate();
        requestLayout();
        return;
    L8:
        this.n = this.m;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setYangBold(final boolean r10) {
        if (x() == false) goto L5;
        C(new q(r10));
        return;
    L5:
        this.r = r10;
        if (r10 == false) goto L8;
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
    L8:
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setYangTextSize(final float r10) {
        if (x() == false) goto L5;
        C(new v(this, r10));
        return;
    L5:
        this.l = r10;
        this.c.setTextSize(r10);
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setupCustomPrefix4ContentDescription(String r1) {
        this.G = r1;
        setContentDescription(D());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        this.m = UIUtils.sp2px(getContext(), 20.0f);
        this.o = UIUtils.dip2Px(getContext(), 5.0f);
        this.p = UIUtils.sp2px(getContext(), 1.0f);
        this.u = 0.0f;
        this.y = UIUtils.sp2px(getContext(), 2.0f);
        this.A = UIUtils.sp2px(getContext(), 10.0f);
        this.B = -364470;
        this.D = 0.0f;
        this.E = false;
        this.F = null;
        E(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(final Context r10, AttributeSet r11) {
        if (r11 == null) goto L6;
        TypedArray r12 = getContext().obtainStyledAttributes(r11, new int[]{2130968874, 2130970016, 2130970017, 2130970018, 2130970211, 2130972703, 2130972759, 2130972819, 2130973590, 2130973591, 2130973592, 2130973593, 2130973594, 2130973600, 2130973601, 2130973602, 2130973603, 2130973604, 2130973605, 2130974058, 2130974116, 2130974336, 2130974556, 2130975167});
        this.j = r12.getString(15);
        this.g = r12.getColor(16, -364470);
        this.m = r12.getDimension(17, this.m);
        this.n = r12.getDimension(14, this.n);
        this.l = r12.getDimension(23, 0.0f);
        this.i = r12.getBoolean(4, false);
        this.o = r12.getDimension(20, this.o);
        this.q = r12.getBoolean(13, this.q);
        this.s = r12.getBoolean(19, this.s);
        this.t = r12.getBoolean(22, false);
        this.v = r12.getString(9);
        this.w = r12.getDimension(12, this.m);
        this.z = r12.getString(1);
        this.B = r12.getColor(2, -364470);
        this.A = r12.getDimension(3, this.A);
        this.D = r12.getDimension(18, this.D);
        this.E = r12.getBoolean(7, false);
        r12.recycle();
    L6:
        if (x() == false) goto L8;
        C(new m(this, r10));
        return;
    L8:
        setFocusable(true);
        ViewCompat.setAccessibilityDelegate(this, new a(this));
        setPriceText(this.j);
        setWillNotDraw(false);
        if (this.l != 0.0f) goto L11;
        this.l = this.m * 0.8f;
    L11:
        this.h = r10.getString(2131913569);
        Paint r13 = new Paint();
        this.c = r13;
        r13.setTextSize(this.l);
        this.c.setColor(this.g);
        this.c.setAntiAlias(true);
        if (this.r == false) goto L14;
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
    L14:
        Paint r14 = new Paint();
        this.d = r14;
        r14.setTextSize(this.m);
        this.d.setColor(this.g);
        this.d.setAntiAlias(true);
        if (this.q == false) goto L18;
        this.d.setTypeface(Typeface.DEFAULT_BOLD);
    L18:
        if (this.E == false) goto L20;
        this.d.setShadowLayer(2.0f, 0.0f, 2.0f, r10.getResources().getColor(2131105910));
    L20:
        Paint r15 = new Paint();
        this.e = r15;
        if (this.t == true) goto L23;
        this.n = this.m;
    L26:
        r15.setTextSize(this.n);
        this.e.setColor(this.g);
        this.e.setAntiAlias(true);
        if (this.q == false) goto L29;
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
    L29:
        Paint r16 = new Paint();
        this.x = r16;
        r16.setColor(this.g);
        this.x.setAntiAlias(true);
        this.x.setTextSize(this.w);
        if (this.q == false) goto L32;
        this.x.setTypeface(Typeface.DEFAULT_BOLD);
    L32:
        Paint r17 = new Paint();
        this.C = r17;
        r17.setColor(this.B);
        this.C.setAntiAlias(true);
        this.C.setTextSize(this.A);
        if (this.q == false) goto L37;
        this.C.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L37:
        return;
    L23:
        if (this.n != 0.0f) goto L26;
        this.n = this.m * 0.8f;
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ec.core.widget.price.PriceView
    public final void onMeasure(int r11, int r12) {
        if (x() == false) goto L6;
        super.onMeasure(r11, r12);
        return;
    L6:
        if (TextUtils.isEmpty(this.h) == true) goto L8;
        Rect r0 = new Rect();
        Paint r1 = this.c;
        String r10 = this.h;
        r1.getTextBounds(r10, 0, r10.length(), r0);
        this.u = r0.width();
    L8:
        int r13 = View.MeasureSpec.getMode(r11);
        int r14 = View.MeasureSpec.getSize(r11);
        if (r13 == 1073741824) goto L57;
        float r15 = this.m;
        if (this.t == false) goto L14;
        float r16 = this.n;
    L15:
        float r17 = this.l;
        float r18 = this.w;
        float r19 = this.A;
        float r20 = this.d.getTextSize();
        float r21 = this.m;
        if (r20 >= r21) goto L19;
        this.d.setTextSize(r21);
    L19:
        if (this.e.getTextSize() >= r16) goto L21;
        this.e.setTextSize(r16);
    L21:
        float r22 = this.c.getTextSize();
        float r23 = this.l;
        if (r22 >= r23) goto L24;
        this.c.setTextSize(r23);
    L24:
        float r24 = this.x.getTextSize();
        float r25 = this.w;
        if (r24 >= r25) goto L27;
        this.x.setTextSize(r25);
    L27:
        float r26 = this.C.getTextSize();
        float r27 = this.A;
        if (r26 >= r27) goto L30;
        this.C.setTextSize(r27);
    L30:
        float r28 = getCalculateViewWidth();
        float r29 = this.D;
        if (r29 > 0.0f) goto L33;
    L54:
        if (r14 != 0) goto L56;
        r14 = (int) r28;
        goto L57
    L56:
        r14 = (int) Math.min(r28, r14);
        goto L57
    L33:
        if (r28 <= r29) goto L54;
    L35:
        if (r28 <= this.D) goto L54;
        if (r15 <= 1.0f) goto L54;
        float r30 = r15 - 1.0f;
        if (r30 < 0.0f) goto L41;
        this.d.setTextSize(r30);
        r15 = r30;
    L41:
        float r31 = r16 - 1.0f;
        if (r31 < 0.0f) goto L44;
        this.e.setTextSize(r31);
        r16 = r31;
    L44:
        float r32 = r17 - 1.0f;
        if (r32 < 0.0f) goto L47;
        this.c.setTextSize(r32);
        r17 = r32;
    L47:
        float r33 = r18 - 1.0f;
        if (r33 < 0.0f) goto L50;
        this.x.setTextSize(r33);
        r18 = r33;
    L50:
        float r34 = r19 - 1.0f;
        if (r34 < 0.0f) goto L53;
        this.C.setTextSize(r34);
        r19 = r34;
    L53:
        r28 = getCalculateViewWidth();
        goto L35
    L14:
        r16 = r15;
    L57:
        int r35 = View.MeasureSpec.getMode(r12);
        int r110 = TextView.getDefaultSize(getMinimumHeight(), r12);
        if (r35 == 1073741824) goto L64;
        float r36 = ((this.m + getPaddingBottom()) + getPaddingTop()) + 0.5f;
        if (r110 != 0) goto L63;
        r110 = Math.round(r36);
        goto L64
    L63:
        r110 = Math.round(Math.min(r36, r110));
    L64:
        setMeasuredDimension(r14, r110);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f = new Paint();
        this.g = -364470;
        this.i = false;
        this.m = UIUtils.sp2px(getContext(), 20.0f);
        this.o = UIUtils.dip2Px(getContext(), 5.0f);
        this.p = UIUtils.sp2px(getContext(), 1.0f);
        this.u = 0.0f;
        this.y = UIUtils.sp2px(getContext(), 2.0f);
        this.A = UIUtils.sp2px(getContext(), 10.0f);
        this.B = -364470;
        this.D = 0.0f;
        this.E = false;
        this.F = null;
        E(r10, r11);
    }
}
