package com.bytedance.android.livesdk.feed.ui;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.CycleInterpolator;
import com.bytedance.common.utility.UIUtils;
import zw1.b;
import zw1.c;
import zw1.d;
import zw1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class XiguaLivingTagView extends View {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public AnimatorSet f;
    public Paint g;
    public RectF h;
    public RectF i;
    public RectF j;

    public XiguaLivingTagView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        super.onDraw(r5);
        int r0 = ((getRight() - getLeft()) - ((this.c * 3) + (this.d * 2))) >> 1;
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        r5.save();
        r5.translate(r0, 0.0f);
        a(r5, this.h, this.g);
        r5.restore();
        r5.save();
        r5.translate((this.c + this.d) + r0, 0.0f);
        a(r5, this.i, this.g);
        r5.restore();
        r5.save();
        r5.translate(r0 + ((this.c + this.d) * 2), 0.0f);
        a(r5, this.j, this.g);
        r5.restore();
    }

    public XiguaLivingTagView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getSize(r6);
        int r1 = (this.c * 3) + (this.d * 2);
        int r2 = View.MeasureSpec.getSize(r7);
        int r3 = this.a;
        if (View.MeasureSpec.getMode(r6) == Integer.MIN_VALUE) goto L10;
        if (r0 > r1) goto L8;
        r0 = r1;
    L8:
        r1 = r0;
    L10:
        if (View.MeasureSpec.getMode(r7) == Integer.MIN_VALUE) goto L16;
        if (r2 > r3) goto L15;
        r2 = r3;
    L15:
        r3 = r2;
    L16:
        setMeasuredDimension(r1, r3);
    }

    public XiguaLivingTagView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.a = (int) UIUtils.dip2Px(r7, 10.0f);
        this.b = (int) UIUtils.dip2Px(r7, 3.0f);
        this.c = (int) UIUtils.dip2Px(r7, 2.0f);
        this.d = (int) UIUtils.dip2Px(r7, 2.0f);
        this.e = 2;
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        Paint r10 = new Paint();
        this.g = r10;
        r10.setColor(-1);
        this.g.setAntiAlias(true);
        ValueAnimator r11 = ValueAnimator.ofInt(new int[]{this.b, this.a});
        r11.setInterpolator(new CycleInterpolator(0.5f));
        r11.setDuration(400);
        r11.addUpdateListener(new b(this));
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{this.b, this.a});
        r0.setInterpolator(new CycleInterpolator(0.5f));
        r0.setDuration(400);
        r0.addUpdateListener(new c(this));
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{this.b, this.a});
        r12.setInterpolator(new CycleInterpolator(0.5f));
        r12.setDuration(400);
        r12.addUpdateListener(new d(this));
        AnimatorSet r13 = new AnimatorSet();
        this.f = r13;
        r13.play(r11).after(220);
        this.f.play(r0).after(150);
        this.f.play(r12).after(0);
        this.f.addListener(new e());
    }

    public final void a(Canvas r5, RectF r6, Paint r7) {
        int r0 = (getBottom() - getTop()) >> 1;
        int r1 = ((int) (r6.bottom - r6.top)) >> 1;
        r6.set(r6.left, r0 - r1, r6.right, r0 + r1);
        int r2 = this.e;
        r5.drawRoundRect(r6, r2, r2, r7);
    }
}
