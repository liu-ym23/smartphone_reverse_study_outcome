package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RotateHeadView extends View {
    public Paint a;
    public final Paint b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Context g;
    public int h;
    public int i;
    public final int j;
    public int k;
    public RectF l;
    public a m;
    public a n;
    public PathEffect o;
    public float p;
    public float q;
    public float r;

    public class a {
        public float a;
        public float b;
        public final /* synthetic */ RotateHeadView c;

        public a(RotateHeadView r1) {
            this.c = r1;
            a(0);
        }

        public final void a(int r8) {
            RotateHeadView r0 = this.c;
            float r1 = (r0.c - UIUtils.dip2Px(r0.g, 2.0f)) / 2.0f;
            double r3 = (r8 * 3.141592653589793d) / 180.0d;
            this.a = (this.c.c / 2.0f) + (((float) Math.cos(r3)) * r1);
            this.b = (this.c.d / 2.0f) + (((float) Math.sin(r3)) * r1);
        }
    }

    public RotateHeadView(Context r2) {
        super(r2);
        this.b = new Paint();
        this.j = 12;
        a(r2);
    }

    public final void a(Context r3) {
        this.g = r3;
        this.e = 0;
        this.f = 0;
        this.l = new RectF();
        this.m = new a(this);
        this.n = new a(this);
        this.o = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        this.p = UIUtils.dip2Px(this.g, 1.9f);
        this.q = UIUtils.dip2Px(this.g, 2.0f);
        this.r = UIUtils.dip2Px(this.g, 2.0f) / 2.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        super.onDraw(r12);
        if (this.a != null) goto L5;
        Paint r0 = new Paint();
        this.a = r0;
        r0.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
    L5:
        this.a.setColor(this.k);
        this.a.setPathEffect(this.o);
        this.a.setStrokeWidth(this.p);
        r12.drawArc(this.l, this.e / 4.0f, 359.0f, false, this.a);
        this.a.setPathEffect(null);
        int r1 = this.e;
        int r2 = (int) ((Math.sin((((double) r1) * 3.141592653589793d) / 90.0d) * 345.0d) * (-1.0d));
        if (r1 < 0) goto L9;
        if (r1 >= 45) goto L9;
    L15:
        r2 = -r2;
    L17:
        if ((this.e % 90) != 45) goto L19;
        int r3 = this.f;
        int r4 = this.h;
        this.i = (r3 - r4) - 1;
        this.f = r4 + 1;
    L19:
        if (r2 != 0) goto L21;
        this.f += this.i;
    L21:
        this.a.setStrokeWidth(this.q);
        r12.drawArc(this.l, this.f - this.j, r2, false, this.a);
        this.m.a(this.f - this.j);
        this.n.a((this.f - this.j) + r2);
        this.b.setColor(this.k);
        a r5 = this.m;
        r12.drawCircle(r5.a, r5.b, this.r, this.b);
        a r6 = this.n;
        r12.drawCircle(r6.a, r6.b, this.r, this.b);
        int r13 = this.f;
        this.h = r2 + r13;
        this.e = (this.e + 1) % 360;
        this.f = (r13 + 1) % 360;
        postInvalidateDelayed(15);
        return;
    L9:
        if (135 > r1) goto L13;
        if (r1 < 225) goto L15;
    L13:
        if (315 > r1) goto L17;
        if (r1 >= 360) goto L17;
        goto L15
    }

    public void setColor(int r1) {
        this.k = r1;
    }

    public RotateHeadView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = new Paint();
        this.j = 12;
        a(r1);
    }

    @Override // android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        this.c = View.MeasureSpec.getSize(r3);
        this.d = View.MeasureSpec.getSize(r4);
        float r5 = UIUtils.dip2Px(this.g, 1.0f);
        this.l.set(r5, r5, this.c - r5, this.d - r5);
    }

    public RotateHeadView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = new Paint();
        this.j = 12;
        a(r1);
    }
}
