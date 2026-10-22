package com.larus.dora.impl.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import g49.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q69.b;
import q69.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\u0016\u0010&\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/view/CircleWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint1", "Landroid/graphics/Paint;", "alpha1", "circleRadius1", "", "valueAnimator1", "Landroid/animation/ValueAnimator;", "paint2", "alpha2", "circleRadius2", "valueAnimator2", "paint3", "alpha3", "circleRadius3", "valueAnimator3", "paint", "circleColor", "isPlaying", "", "maxRadius", "minRadius", "icon", "Landroid/graphics/drawable/Drawable;", "iconSize", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setRadius", "start", "getState", "stop", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleWaveView extends View {
    public static final /* synthetic */ int p = 0;
    public final Paint a;
    public int b;
    public float c;
    public final Paint d;
    public int e;
    public float f;
    public final Paint g;
    public int h;
    public float i;
    public final Paint j;
    public final int k;
    public final int l;
    public final int m;
    public final Drawable n;
    public final int o;

    public static final class a {
    }

    static {
    }

    public CircleWaveView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CircleWaveView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final boolean getState() {
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super.onDraw(r7);
        this.a.setAlpha(this.b);
        this.d.setAlpha(this.e);
        this.g.setAlpha(this.h);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        r7.drawCircle(r0, r2, this.c, this.a);
        r7.drawCircle(r0, r2, this.f, this.d);
        r7.drawCircle(r0, r2, this.i, this.g);
        r7.drawCircle(r0, r2, this.m, this.j);
        Drawable r3 = this.n;
        if (r3 == null) goto L6;
        int r4 = this.o;
        r3.setBounds(0, 0, r4, r4);
        int r5 = this.o;
        r7.translate(r0 - (r5 / 2.0f), r2 - (r5 / 2.0f));
        r3.draw(r7);
        return;
    }

    public CircleWaveView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.a = new Paint();
        this.b = 255;
        this.d = new Paint();
        this.e = 255;
        this.g = new Paint();
        this.h = 255;
        this.j = new Paint();
        this.k = -16776961;
        this.l = 40;
        this.m = 20;
        TypedArray r5 = null;
        if (r12 != null) goto L19;
    L15:
        if (r5 != null) goto L10;
    L17:
        this.j.setColor(this.k);
        this.a.setColor(this.k);
        this.d.setColor(this.k);
        this.g.setColor(this.k);
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{this.m, this.l});
        r14.setDuration(3000);
        r14.setRepeatCount(-1);
        r14.setRepeatMode(1);
        r14.addUpdateListener(new q69.a(this));
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{this.m, this.l});
        r15.setDuration(3000);
        r15.setRepeatCount(-1);
        r15.setRepeatMode(1);
        r15.addUpdateListener(new b(this));
        ValueAnimator r16 = ValueAnimator.ofInt(new int[]{this.m, this.l});
        r16.setDuration(3000);
        r16.setRepeatCount(-1);
        r16.setRepeatMode(1);
        r16.addUpdateListener(new c(this));
        return;
    L10:
        r5.recycle();
        goto L17
    L19:
        r5 = r11.obtainStyledAttributes(r12, new int[]{2130970480, 2130970481, 2130970482, 2130970483, 2130970484});     // Catch: Throwable -> L7
        this.k = r5.getColor(0, -16776961);     // Catch: Throwable -> L7
        this.l = r5.getDimensionPixelSize(3, 40);     // Catch: Throwable -> L7
        this.m = r5.getDimensionPixelSize(4, 20);     // Catch: Throwable -> L7
        this.n = r5.getDrawable(1);     // Catch: Throwable -> L7
        this.o = r5.getDimensionPixelSize(2, 0);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        d.c("CircleWaveView", "init: exception", th);     // Catch: Throwable -> L11
        if (r5 == null) goto L17;
    L11:
        th = move-exception;
        if (r5 == null) goto L14;
        r5.recycle();
    L14:
        throw th;
    }

    public /* synthetic */ CircleWaveView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
