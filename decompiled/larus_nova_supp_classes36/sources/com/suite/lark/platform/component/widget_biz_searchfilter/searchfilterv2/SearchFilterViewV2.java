package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SearchFilterViewV2 extends View {
    public static final Rect U = null;
    public Rect A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public int I;
    public String J;
    public String K;
    public boolean L;
    public List<Bitmap> M;
    public int N;
    public float O;
    public float P;
    public float Q;
    public RectF R;
    public RectF S;
    public a T;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Paint i;
    public Paint j;
    public Paint k;
    public Paint l;
    public float m;
    public float n;
    public int o;
    public Paint p;
    public Paint q;
    public Paint r;
    public Paint s;
    public Paint t;
    public int u;
    public int v;
    public Drawable w;
    public Drawable x;
    public Drawable y;
    public Drawable z;

    public interface a {
        void onClick();
    }

    private int getContentHeight() {
        Rect r0 = this.A;
        int r1 = (r0.top + 0) + r0.bottom;
        if (TextUtils.isEmpty(this.J) == true) goto L5;
        Paint.FontMetrics r2 = this.q.getFontMetrics();
        float r3 = (r2.bottom - r2.top) + r2.leading;
    L7:
        if (CollectionUtils.isEmpty(this.M) == true) goto L10;
        r3 = Math.max(r3, this.E + (this.G * 2.0f));
    L10:
        return (int) (r1 + r3);
    L5:
        r3 = 0.0f;
        goto L7
    }

    private int getContentWidth() {
        Rect r0 = this.A;
        int r1 = (r0.left + 0) + r0.right;
        if (TextUtils.isEmpty(this.J) == true) goto L6;
        float r2 = this.q.measureText(this.J);
        this.P = r2;
        r1 = (int) (r1 + r2);
    L6:
        if (CollectionUtils.isEmpty(this.M) == true) goto L11;
        int r3 = this.N;
        if (r3 <= 0) goto L11;
        int r4 = (int) (r1 + this.C);
        int r5 = Math.min(r3, this.M.size());
        float r6 = ((this.E + (this.G * 2.0f)) * r5) - (this.F * (r5 - 1));
        this.Q = r6;
        r1 = (int) (r4 + r6);
    L11:
        if (TextUtils.isEmpty(this.K) == true) goto L14;
        r1 = (int) (((int) (r1 + this.C)) + this.q.measureText(this.K));
    L14:
        if (this.c == false) goto L21;
        float r7 = r1;
        if (this.a == false) goto L18;
        float r8 = this.D;
    L19:
        r1 = this.H + ((int) (r7 + r8));
        goto L21
    L18:
        r8 = this.C;
    L21:
        if (this.b == false) goto L23;
        int r9 = this.I;
        this.O = r9 + this.B;
        return r1 + r9;
    L23:
        this.O = 0.0f;
        return r1;
    }

    static {
        UIHelper.getColor(2131102130);
        UIHelper.getColor(2131102130);
        UIHelper.getColor(2131100559);
        UIHelper.getColor(2131100559);
        UIHelper.getColor(2131105548);
        UIHelper.getColor(2131106622);
        U = new Rect(12, 6, 12, 6);
    }

    public SearchFilterViewV2(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        super.onDraw(r14);
        if (this.a == false) goto L5;
        Paint r0 = this.l;
        Paint r1 = this.k;
    L6:
        float r3 = this.G;
        RectF r2 = new RectF(r3, r3, r14.getWidth() - this.G, r14.getHeight() - this.G);
        float r4 = this.m;
        r14.drawRoundRect(r2, r4, r4, r1);
        if (this.d == false) goto L10;
        float r5 = this.m;
        r14.drawRoundRect(r2, r5, r5, r0);
    L10:
        if (this.b == false) goto L14;
        int r6 = this.A.left;
        int r7 = r14.getHeight() / 2;
        int r8 = this.I;
        int r9 = r7 - (r8 / 2);
        this.z.setBounds(r6, r9, r6 + r8, r8 + r9);
        this.z.draw(r14);
    L14:
        if (TextUtils.isEmpty(this.J) == true) goto L22;
        if (this.a == false) goto L19;
        this.r = this.q;
    L20:
        Paint.FontMetrics r10 = this.r.getFontMetrics();
        float r11 = r14.getHeight() / 2;
        float r12 = r10.bottom;
        float r13 = (r11 + ((r12 - r10.top) / 2.0f)) - r12;
        r14.drawText(this.J, this.A.left + this.O, r13, this.r);
        goto L22
    L19:
        this.r = this.p;
    L22:
        if (CollectionUtils.isEmpty(this.M) == true) goto L32;
        float r15 = (this.A.left + this.P) + this.C;
        float r16 = (r14.getHeight() / 2) - ((this.E + this.G) / 2.0f);
        int r17 = Math.min(this.M.size(), 1) - 1;
    L25:
        if (r17 < 0) goto L32;
        int r18 = r14.saveLayer(0.0f, 0.0f, r14.getWidth(), r14.getHeight(), null, 31);
        Bitmap r19 = (Bitmap) ListProtector.get(this.M, r17);
        if (r19 == null) goto L30;
        float r20 = this.E + (this.G * 2.0f);
        this.R.set(r15, r16, r15 + r20, r20 + r16);
        this.t.setXfermode(null);
        r14.drawOval(this.R, this.t);
        this.t.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r14.drawBitmap(r19, null, this.R, this.t);
        this.t.setXfermode(null);
        r14.restoreToCount(r18);
        r14.drawOval(this.R, this.s);
        r15 = r15 + ((this.E + (this.G * 2.0f)) - this.F);
    L30:
        r17 = r17 - 1;
    L32:
        if (TextUtils.isEmpty(this.K) == true) goto L40;
        if (this.a == false) goto L37;
        this.r = this.q;
    L38:
        Paint.FontMetrics r21 = this.r.getFontMetrics();
        float r22 = r14.getHeight() / 2;
        float r23 = r21.bottom;
        float r24 = (r22 + ((r23 - r21.top) / 2.0f)) - r23;
        r14.drawText(this.K, (((this.A.left + this.O) + this.P) + (this.C * 2.0f)) + this.Q, r24, this.r);
        goto L40
    L37:
        this.r = this.p;
    L40:
        if (this.c == false) goto L51;
        int r25 = (r14.getWidth() - this.A.right) - this.H;
        int r26 = r14.getHeight() / 2;
        int r27 = this.H;
        int r28 = r26 - (r27 / 2);
        this.S.set(r25, r28, r25 + r27, r27 + r28);
        if (this.a == false) goto L45;
        this.y = this.w;
    L46:
        Drawable r29 = this.y;
        int r30 = this.H;
        r29.setBounds(r25, r28, r25 + r30, r30 + r28);
        this.y.draw(r14);
        return;
    L45:
        this.y = this.x;
        goto L46
    L51:
        return;
    L5:
        r0 = this.j;
        r1 = this.i;
        goto L6
    }

    public void setBgBorderVisibility(boolean r1) {
        this.d = r1;
    }

    public void setCancelClickListener(a r1) {
        this.T = r1;
    }

    public void setDisplayAvatarLimit(int r2) {
        this.N = Math.max(0, r2);
        requestLayout();
        invalidate();
    }

    public void setItemSelectedBgBorderColor(int r3) {
        this.l.setColor(UIUtils.getColor(getContext(), r3));
        invalidate();
    }

    public void setItemSelectedBgColor(int r3) {
        this.k.setColor(UIUtils.getColor(getContext(), r3));
        invalidate();
    }

    public void setItemUnSelectedBgBorderColor(int r3) {
        this.j.setColor(UIUtils.getColor(getContext(), r3));
        invalidate();
    }

    public void setItemUnSelectedBgColor(int r3) {
        this.i.setColor(UIUtils.getColor(getContext(), r3));
        invalidate();
    }

    public void setLogoAvatarDrawable(Drawable r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        this.b = r0;
        this.z = r2;
        requestLayout();
        invalidate();
        return;
    L4:
        r0 = false;
        goto L5
    }

    public void setLogoAvatarVisible(boolean r1) {
        this.b = r1;
    }

    public void setPaddingRect(Rect r1) {
        this.A = r1;
    }

    public void setRightArrowVisibility(boolean r1) {
        this.c = r1;
    }

    public void setSelectedArrowColor(int r3) {
        this.w = UDIconUtils.getIconDrawable(getContext(), 2131254119, UIUtils.getColor(getContext(), r3));
        invalidate();
    }

    public void setSelectedTextColor(int r3) {
        this.q.setColor(UIUtils.getColor(getContext(), r3));
        invalidate();
    }

    public void setSimpleMultiCount(boolean r1) {
        this.L = r1;
    }

    public void setUnSelectedArrowColor(int r3) {
        this.x = UDIconUtils.getIconDrawable(getContext(), 2131254256, UIUtils.getColor(getContext(), r3));
        invalidate();
    }

    public void setUnSelectedText(String r2) {
        this.a = false;
        this.J = r2;
        this.M = null;
        this.K = "";
        requestLayout();
        invalidate();
    }

    public void setUnSelectedTextColor(int r3) {
        this.p.setColor(UIUtils.getColor(getContext(), r3));
        invalidate();
    }

    public SearchFilterViewV2(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = getContentWidth();
        int r1 = getContentHeight();
        int r2 = View.MeasureSpec.getSize(r6);
        int r8 = View.MeasureSpec.getMode(r6);
        int r3 = View.MeasureSpec.getSize(r7);
        int r9 = View.MeasureSpec.getMode(r7);
        if (r8 == Integer.MIN_VALUE) goto L6;
        if (r8 == 0) goto L7;
        r0 = r2;
    L7:
        if (r9 == Integer.MIN_VALUE) goto L10;
        if (r9 == 0) goto L11;
        r1 = r3;
    L11:
        setMeasuredDimension(r0, r1);
        return;
    L10:
        r1 = Math.min(r1, r3);
        goto L11
    L6:
        r0 = Math.min(r0, r2);
        goto L7
    }

    public SearchFilterViewV2(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.a = false;
        this.b = false;
        this.c = true;
        this.d = false;
        this.e = UIHelper.getColor(2131100556);
        this.f = UIHelper.getColor(2131100556);
        this.g = UIHelper.getColor(2131105553);
        this.h = UIHelper.getColor(2131105553);
        this.o = UIHelper.getColor(2131106622);
        int r5 = UIHelper.getColor(2131105548);
        this.u = UIHelper.getColor(2131102419);
        this.v = UIHelper.getColor(2131105548);
        this.N = 1;
        TypedArray r13 = r10.obtainStyledAttributes(r11, new int[]{2130970055});
        this.m = r13.getDimensionPixelSize(0, 6);
        r13.recycle();
        UIUtils.getColor(r10, 2131100556);
        this.e = UIUtils.getColor(r10, 2131100556);
        this.f = UIUtils.getColor(r10, 2131100556);
        this.g = UIUtils.getColor(r10, 2131105553);
        this.h = UIUtils.getColor(r10, 2131105553);
        this.o = UIUtils.getColor(r10, 2131106622);
        this.v = UIUtils.getColor(r10, 2131105548);
        this.u = UIUtils.getColor(r10, 2131102419);
        this.v = UIUtils.getColor(r10, 2131105548);
        Context r14 = getContext();
        Rect r15 = U;
        this.A = new Rect(UIUtils.dp2px(r14, r15.left), UIUtils.dp2px(getContext(), r15.top), UIUtils.dp2px(getContext(), r15.right), UIUtils.dp2px(getContext(), r15.bottom));
        this.C = UIUtils.dp2px(getContext(), 4.0f);
        this.D = UIUtils.dp2px(getContext(), 8.0f);
        this.B = UIUtils.dp2px(getContext(), 4.0f);
        this.E = UIUtils.dp2px(getContext(), 16.0f);
        this.F = UIUtils.dp2px(getContext(), 6.0f);
        this.G = UIUtils.dp2px(getContext(), 1.0f);
        this.H = UIUtils.dp2px(getContext(), 10.0f);
        this.I = UIUtils.dp2px(getContext(), 16.0f);
        this.i = new Paint();
        this.j = new Paint();
        this.k = new Paint();
        this.l = new Paint();
        this.i.setAntiAlias(true);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setColor(this.e);
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(this.G);
        this.j.setColor(this.f);
        this.k.setAntiAlias(true);
        this.k.setStyle(Paint.Style.FILL);
        this.k.setColor(this.g);
        this.l.setAntiAlias(true);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setStrokeWidth(this.G);
        this.l.setColor(this.h);
        this.p = new Paint();
        this.q = new Paint();
        this.n = UIUtils.sp2px(getContext(), 14.0f);
        this.p.setAntiAlias(true);
        this.p.setTextSize(this.n);
        this.q.setAntiAlias(true);
        this.q.setTextSize(this.n);
        this.p.setColor(this.o);
        this.q.setColor(r5);
        this.s = new Paint();
        this.t = new Paint();
        this.s.setColor(this.h);
        this.s.setAntiAlias(true);
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(this.G);
        this.t.setAntiAlias(true);
        this.w = UDIconUtils.getIconDrawable(getContext(), 2131254119, this.v);
        this.x = UDIconUtils.getIconDrawable(getContext(), 2131254256, this.u);
        this.R = new RectF();
        this.S = new RectF();
        setOnTouchListener(new dpc.a(this));
    }
}
