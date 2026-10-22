package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SearchFilterView extends View {
    public static final Rect z = null;
    public boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public Paint f;
    public Paint g;
    public Paint h;
    public Paint i;
    public float j;
    public float k;
    public final int l;
    public final int m;
    public Paint n;
    public Paint o;
    public Paint p;
    public Paint q;
    public Rect r;
    public float s;
    public float t;
    public float u;
    public float v;
    public String w;
    public List<Bitmap> x;
    public int y;

    private int getContentHeight() {
        Rect r0 = this.r;
        int r1 = (r0.top + 0) + r0.bottom;
        if (TextUtils.isEmpty(this.w) == true) goto L5;
        Paint.FontMetrics r2 = this.o.getFontMetrics();
        float r3 = (r2.bottom - r2.top) + r2.leading;
    L7:
        if (CollectionUtils.isEmpty(this.x) == true) goto L10;
        r3 = Math.max(r3, this.t + (this.v * 2.0f));
    L10:
        return (int) (r1 + r3);
    L5:
        r3 = 0.0f;
        goto L7
    }

    private int getContentWidth() {
        Rect r0 = this.r;
        int r1 = (r0.left + 0) + r0.right;
        if (TextUtils.isEmpty(this.w) == true) goto L6;
        r1 = (int) (r1 + this.o.measureText(this.w));
    L6:
        if (CollectionUtils.isEmpty(this.x) == true) goto L11;
        int r2 = this.y;
        if (r2 <= 0) goto L12;
        int r3 = (int) (r1 + this.s);
        int r4 = Math.min(r2, this.x.size());
        return (int) (r3 + (((this.t + (this.v * 2.0f)) * r4) - (this.u * (r4 - 1))));
    L12:
        return r1;
    L11:
        return r1;
    }

    public final void a() {
        Context r1 = getContext();
        Rect r2 = z;
        this.r = new Rect(UIUtils.dp2px(r1, r2.left), UIUtils.dp2px(getContext(), r2.top), UIUtils.dp2px(getContext(), r2.right), UIUtils.dp2px(getContext(), r2.bottom));
        this.s = UIUtils.dp2px(getContext(), 2.0f);
        this.t = UIUtils.dp2px(getContext(), 16.0f);
        this.u = UIUtils.dp2px(getContext(), 6.0f);
        this.v = UIUtils.dp2px(getContext(), 1.0f);
        this.j = UIUtils.dp2px(getContext(), 6.0f);
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.i = new Paint();
        this.f.setAntiAlias(true);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(this.b);
        this.g.setAntiAlias(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(this.v);
        this.g.setColor(this.c);
        this.h.setAntiAlias(true);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(this.d);
        this.i.setAntiAlias(true);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(this.v);
        this.i.setColor(this.e);
        this.n = new Paint();
        this.o = new Paint();
        this.k = UIUtils.sp2px(getContext(), 14.0f);
        this.n.setAntiAlias(true);
        this.n.setTextSize(this.k);
        this.o.setAntiAlias(true);
        this.o.setTextSize(this.k);
        this.n.setColor(this.l);
        this.o.setColor(this.m);
        this.p = new Paint();
        this.q = new Paint();
        this.p.setColor(this.e);
        this.p.setAntiAlias(true);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth(this.v);
        this.q.setAntiAlias(true);
    }

    static {
        UIHelper.getColor(2131102130);
        UIHelper.getColor(2131102130);
        UIHelper.getColor(2131100559);
        UIHelper.getColor(2131100559);
        UIHelper.getColor(2131105548);
        UIHelper.getColor(2131106622);
        z = new Rect(16, 6, 16, 6);
    }

    public SearchFilterView(Context r2) {
        super(r2);
        this.a = false;
        this.b = UIHelper.getColor(2131100559);
        this.c = UIHelper.getColor(2131100559);
        this.d = UIHelper.getColor(2131102130);
        this.e = UIHelper.getColor(2131102130);
        this.l = UIHelper.getColor(2131106622);
        this.m = UIHelper.getColor(2131105548);
        this.y = 3;
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        super.onDraw(r14);
        if (this.a == false) goto L5;
        Paint r0 = this.i;
        Paint r1 = this.h;
    L6:
        float r3 = this.v;
        RectF r2 = new RectF(r3, r3, r14.getWidth() - this.v, r14.getHeight() - this.v);
        float r4 = this.j;
        r14.drawRoundRect(r2, r4, r4, r1);
        float r5 = this.j;
        r14.drawRoundRect(r2, r5, r5, r0);
        if (TextUtils.isEmpty(this.w) == true) goto L15;
        if (this.a == false) goto L12;
        Paint r6 = this.o;
    L13:
        Paint.FontMetrics r7 = r6.getFontMetrics();
        float r8 = r14.getHeight() / 2;
        float r9 = r7.bottom;
        r14.drawText(this.w, this.r.left, (r8 + ((r9 - r7.top) / 2.0f)) - r9, r6);
        goto L15
    L12:
        r6 = this.n;
    L15:
        if (CollectionUtils.isEmpty(this.x) == true) goto L25;
        float r10 = ((r14.getWidth() - this.r.right) - this.t) - (this.v * 2.0f);
        float r11 = (r14.getHeight() / 2) - ((this.t + this.v) / 2.0f);
        int r12 = Math.min(this.x.size(), 3);
    L18:
        r12 = r12 - 1;
        if (r12 < 0) goto L29;
        int r13 = r14.saveLayer(0.0f, 0.0f, r14.getWidth(), r14.getHeight(), null, 31);
        Bitmap r15 = (Bitmap) ListProtector.get(this.x, r12);
        if (r15 != null) goto L23;
        float r16 = this.t + (this.v * 2.0f);
        float r17 = this.u;
    L24:
        r10 = r10 - (r16 - r17);
        goto L18
    L23:
        float r18 = this.t + (this.v * 2.0f);
        RectF r19 = new RectF(r10, r11, r10 + r18, r18 + r11);
        this.q.setXfermode(null);
        r14.drawOval(r19, this.q);
        this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r14.drawBitmap(r15, null, r19, this.q);
        this.q.setXfermode(null);
        r14.restoreToCount(r13);
        r14.drawOval(r19, this.p);
        r16 = this.t + (this.v * 2.0f);
        r17 = this.u;
        goto L24
    L29:
        return;
    L25:
        return;
    L5:
        r0 = this.g;
        r1 = this.f;
        goto L6
    }

    public void setDisplayIconLimit(int r2) {
        this.y = Math.max(0, r2);
        requestLayout();
    }

    public void setItemUnSelectedBgBorderColor(int r2) {
        this.g.setColor(UIHelper.getColor(r2));
        invalidate();
    }

    public void setItemUnSelectedBgColor(int r2) {
        this.f.setColor(UIHelper.getColor(r2));
        invalidate();
    }

    public void setPaddingRect(Rect r1) {
        this.r = r1;
    }

    public void setUnSelectedText(String r2) {
        this.a = false;
        this.w = r2;
        this.x = null;
        requestLayout();
    }

    public SearchFilterView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
        this.b = UIHelper.getColor(2131100559);
        this.c = UIHelper.getColor(2131100559);
        this.d = UIHelper.getColor(2131102130);
        this.e = UIHelper.getColor(2131102130);
        this.l = UIHelper.getColor(2131106622);
        this.m = UIHelper.getColor(2131105548);
        this.y = 3;
        a();
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

    public SearchFilterView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = false;
        this.b = UIHelper.getColor(2131100559);
        this.c = UIHelper.getColor(2131100559);
        this.d = UIHelper.getColor(2131102130);
        this.e = UIHelper.getColor(2131102130);
        this.l = UIHelper.getColor(2131106622);
        this.m = UIHelper.getColor(2131105548);
        this.y = 3;
        a();
    }
}
