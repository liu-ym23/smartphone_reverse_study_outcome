package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MaterialProgressDrawable extends Drawable implements Animatable {
    public static final Interpolator k = null;
    public static final FastOutSlowInInterpolator l = null;
    public static final int[] m = null;
    public final ArrayList<Animation> a;
    public final b b;
    public float c;
    public final Resources d;
    public final View e;
    public com.bytedance.android.livesdk.chatroom.ui.pullrefresh.a f;
    public float g;
    public double h;
    public double i;
    public boolean j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public class a implements Drawable.Callback {
        public final /* synthetic */ MaterialProgressDrawable a;

        public a(MaterialProgressDrawable r1) {
            this.a = r1;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r1) {
            this.a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r1, Runnable r2) {
            this.a.unscheduleSelf(r2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
            this.a.scheduleSelf(r2, r3);
        }
    }

    public static class b {
        public final RectF a;
        public final Paint b;
        public final Paint c;
        public final Drawable.Callback d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public int[] j;
        public int k;
        public float l;
        public float m;
        public float n;
        public boolean o;
        public Path p;
        public float q;
        public double r;
        public int s;
        public int t;
        public int u;
        public final Paint v;
        public int w;
        public int x;

        public final void a() {
            this.d.invalidateDrawable(null);
        }

        public b(a r5) {
            this.a = new RectF();
            Paint r0 = new Paint();
            this.b = r0;
            Paint r1 = new Paint();
            this.c = r1;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 5.0f;
            this.i = 2.5f;
            this.v = new Paint(1);
            this.d = r5;
            r0.setStrokeCap(Paint.Cap.SQUARE);
            r0.setAntiAlias(true);
            r0.setStyle(Paint.Style.STROKE);
            r1.setStyle(Paint.Style.FILL);
            r1.setAntiAlias(true);
        }

        public final void b(int r2) {
            this.k = r2;
            this.x = this.j[r2];
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    static {
        k = new LinearInterpolator();
        l = new FastOutSlowInInterpolator();
        m = new int[]{-16777216};
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.b.u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.h;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList<Animation> r0 = this.a;
        int r1 = r0.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        Animation r4 = (Animation) ListProtector.get(r0, r3);
        if (r4.hasStarted() == false) goto L10;
        if (r4.hasEnded() == true) goto L10;
        return true;
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f.reset();
        b r0 = this.b;
        float r1 = r0.e;
        r0.l = r1;
        float r2 = r0.f;
        r0.m = r2;
        r0.n = r0.g;
        if (r2 == r1) goto L5;
        this.j = true;
        this.f.setDuration(666);
        this.e.startAnimation(this.f);
        return;
    L5:
        r0.b(0);
        b r3 = this.b;
        r3.l = 0.0f;
        r3.m = 0.0f;
        r3.n = 0.0f;
        r3.e = 0.0f;
        r3.a();
        r3.f = 0.0f;
        r3.a();
        r3.g = 0.0f;
        r3.a();
        this.f.setDuration(1332);
        this.e.startAnimation(this.f);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.e.clearAnimation();
        this.c = 0.0f;
        invalidateSelf();
        b r1 = this.b;
        if (r1.o == false) goto L5;
        r1.o = false;
        r1.a();
    L5:
        this.b.b(0);
        b r2 = this.b;
        r2.l = 0.0f;
        r2.m = 0.0f;
        r2.n = 0.0f;
        r2.e = 0.0f;
        r2.a();
        r2.f = 0.0f;
        r2.a();
        r2.g = 0.0f;
        r2.a();
    }

    public final void a(float r3) {
        b r0 = this.b;
        if (r3 == r0.q) goto L6;
        r0.q = r3;
        r0.a();
        return;
    }

    public final void d(int r23) {
        if (r23 != 0) goto L4;
        b(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        return;
    L4:
        b(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r14) {
        Rect r0 = getBounds();
        int r1 = r14.save();
        r14.rotate(this.c, r0.exactCenterX(), r0.exactCenterY());
        b r2 = this.b;
        RectF r4 = r2.a;
        r4.set(r0);
        float r3 = r2.i;
        r4.inset(r3, r3);
        float r5 = r2.e;
        float r6 = r2.g;
        float r9 = (r5 + r6) * 360.0f;
        float r10 = ((r2.f + r6) * 360.0f) - r9;
        r2.b.setColor(r2.x);
        r14.drawArc(r4, r9, r10, false, r2.b);
        if (r2.o == false) goto L10;
        Path r7 = r2.p;
        if (r7 != null) goto L7;
        Path r8 = new Path();
        r2.p = r8;
        r8.setFillType(Path.FillType.EVEN_ODD);
    L8:
        float r11 = (((int) r2.i) / 2) * r2.q;
        float r12 = (float) ((r2.r * Math.cos(0.0d)) + ((double) r0.exactCenterX()));
        float r13 = (float) ((r2.r * Math.sin(0.0d)) + ((double) r0.exactCenterY()));
        r2.p.moveTo(0.0f, 0.0f);
        r2.p.lineTo(r2.s * r2.q, 0.0f);
        Path r15 = r2.p;
        float r16 = r2.s;
        float r17 = r2.q;
        r15.lineTo((r16 * r17) / 2.0f, r2.t * r17);
        r2.p.offset(r12 - r11, r13);
        r2.p.close();
        r2.c.setColor(r2.x);
        r14.rotate((r9 + r10) - 5.0f, r0.exactCenterX(), r0.exactCenterY());
        r14.drawPath(r2.p, r2.c);
        goto L10
    L7:
        r7.reset();
    L10:
        if (r2.u >= 255) goto L12;
        r2.v.setColor(r2.w);
        r2.v.setAlpha(255 - r2.u);
        r14.drawCircle(r0.exactCenterX(), r0.exactCenterY(), r0.width() / 2, r2.v);
    L12:
        r14.restoreToCount(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.b.u = r2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r3) {
        b r0 = this.b;
        r0.b.setColorFilter(r3);
        r0.a();
    }

    public MaterialProgressDrawable(Context r3, View r4) {
        this.a = new ArrayList();
        a r0 = new a(this);
        this.e = r4;
        this.d = r3.getResources();
        b r5 = new b(r0);
        this.b = r5;
        r5.j = m;
        r5.b(0);
        d(1);
        com.bytedance.android.livesdk.chatroom.ui.pullrefresh.a r1 = new com.bytedance.android.livesdk.chatroom.ui.pullrefresh.a(this, r5);
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(k);
        r1.setAnimationListener(new com.bytedance.android.livesdk.chatroom.ui.pullrefresh.b(this, r5));
        this.f = r1;
    }

    public static void c(float r8, b r9) {
        if (r8 <= 0.75f) goto L6;
        float r10 = (r8 - 0.75f) / 0.25f;
        int[] r0 = r9.j;
        int r1 = r9.k;
        int r2 = r0[r1];
        int r3 = r0[(r1 + 1) % r0.length];
        int r4 = (r2 >> 24) & 255;
        int r5 = (r2 >> 16) & 255;
        int r6 = (r2 >> 8) & 255;
        int r7 = r2 & 255;
        r9.x = ((((r4 + ((int) ((((r3 >> 24) & 255) - r4) * r10))) << 24) | ((r5 + ((int) ((((r3 >> 16) & 255) - r5) * r10))) << 16)) | ((r6 + ((int) ((((r3 >> 8) & 255) - r6) * r10))) << 8)) | (r7 + ((int) (r10 * ((r3 & 255) - r7))));
        return;
    }

    public final void b(double r5, double r7, double r9, double r11, float r13, float r14) {
        b r0 = this.b;
        Resources r1 = this.d;
        float r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        double r3 = r2;
        this.h = r5 * r3;
        this.i = r7 * r3;
        float r6 = ((float) r11) * r2;
        r0.h = r6;
        r0.b.setStrokeWidth(r6);
        r0.a();
        r0.r = r9 * r3;
        r0.b(0);
        r0.s = (int) (r13 * r2);
        r0.t = (int) (r14 * r2);
        float r8 = Math.min((int) this.h, (int) this.i);
        double r10 = r0.r;
        if (r10 > 0.0d) goto L5;
    L8:
        double r12 = Math.ceil(r0.h / 2.0f);
    L9:
        r0.i = (float) r12;
        return;
    L5:
        if (r8 < 0.0f) goto L8;
        r12 = ((double) (r8 / 2.0f)) - r10;
        goto L9
    }
}
