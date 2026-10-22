package com.ss.android.lark.keyboard.plugin.tool.voice.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AudioCircleView extends View {
    public static final int s = 0;
    public static final int t = 0;
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public float d;
    public float e;
    public float f;
    public final float g;
    public final float h;
    public Drawable i;
    public float j;
    public int k;
    public int l;
    public final RectF m;
    public final int n;
    public final int o;
    public final float[] p;
    public float q;
    public ValueAnimator r;

    static {
        s = UIHelper.getColor(2131105566);
        t = UIHelper.getColor(2131105542);
        UIHelper.getColor(2131108780);
        UIHelper.getColor(2131108785);
    }

    public RectF getInnerBound() {
        return this.m;
    }

    public float getScale() {
        return this.j;
    }

    public AudioCircleView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        int r0 = getMeasuredWidth() / 2;
        int r1 = getMeasuredHeight() - r0;
        float r2 = this.f;
        if (r2 <= this.d) goto L5;
        r9.drawCircle(r0, r1, r2, this.c);
    L5:
        float r3 = this.e;
        if (r3 <= this.d) goto L8;
        r9.drawCircle(r0, r1, r3, this.b);
    L8:
        float r4 = r0;
        float r5 = r1;
        r9.drawCircle(r4, r5, this.d * this.j, this.a);
        Drawable r6 = this.i;
        r6.setBounds(r0 - (r6.getIntrinsicWidth() / 2), r1 - (this.i.getIntrinsicHeight() / 2), r0 + (this.i.getIntrinsicWidth() / 2), r1 + (this.i.getIntrinsicHeight() / 2));
        this.i.draw(r9);
        RectF r10 = this.m;
        float r7 = this.d;
        r10.set(r4 - r7, r5 - r7, r4 + r7, r5 + r7);
    }

    public void setAmplitudeAnimate(final int r2) {
        post(new vob.a(this, r2));
    }

    public void setIcon(int r4) {
        Drawable r5 = UIUtils.getDrawable(getContext(), r4);
        this.i = r5;
        r5.setColorFilter(new PorterDuffColorFilter(getResources().getColor(2131106521), PorterDuff.Mode.SRC_ATOP));
        invalidate();
    }

    @Override // android.view.View
    public void setPressed(boolean r4) {
        Paint r0 = this.a;
        Resources r2 = getResources();
        if (r4 == false) goto L5;
        int r5 = 2131102129;
    L6:
        r0.setColorFilter(new PorterDuffColorFilter(r2.getColor(r5), PorterDuff.Mode.SRC_ATOP));
        return;
    L5:
        r5 = 2131103546;
        goto L6
    }

    public void setRadius(int r1) {
        this.d = r1;
        invalidate();
    }

    public void setScale(float r1) {
        this.j = r1;
        invalidate();
    }

    public AudioCircleView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AudioCircleView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.a = new Paint(1);
        this.b = new Paint(1);
        this.c = new Paint(1);
        this.d = UIHelper.dp2px(60.0f);
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = UIHelper.dp2px(40.0f);
        this.h = UIHelper.dp2px(0.0f);
        this.j = 1.0f;
        this.m = new RectF();
        this.n = s;
        this.o = t;
        this.p = new float[]{0.0f, 1.0f};
        this.q = 0.0f;
        Drawable r5 = UIUtils.getDrawable(getContext(), 2131256166);
        this.i = r5;
        r5.setColorFilter(new PorterDuffColorFilter(getResources().getColor(2131106521), PorterDuff.Mode.SRC_ATOP));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        int r14 = r10 / 2;
        this.k = r14;
        int r15 = r11 - r14;
        this.l = r15;
        int r16 = this.n;
        int r8 = this.o;
        this.a.setShader(new RadialGradient(this.k, this.l, this.d, new int[]{r16, r8}, this.p, Shader.TileMode.CLAMP));
        float r17 = r14;
        float r0 = this.e;
        float r2 = this.g;
        float r18 = r15;
        this.b.setShader(new LinearGradient((r17 - r0) - r2, (r18 + r0) + r2, (r17 + r0) + r2, (r18 - r0) - r2, r16, r8, Shader.TileMode.CLAMP));
        this.b.setAlpha(25);
        float r1 = this.f;
        float r3 = this.h;
        this.c.setShader(new LinearGradient((r17 - r1) - r3, (r18 + r1) + r3, (r17 + r1) + r3, (r18 - r1) - r3, r16, r8, Shader.TileMode.CLAMP));
        this.c.setAlpha(51);
    }
}
