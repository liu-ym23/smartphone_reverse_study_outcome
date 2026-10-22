package com.airbnb.lottie;

import ai.j0;
import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Choreographer;
import android.widget.ImageView;
import com.airbnb.lottie.model.layer.Layer$LayerType;
import com.airbnb.lottie.model.layer.Layer$MatteType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class w extends Drawable implements Drawable.Callback, Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f1339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f1340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u.c f1341c;
    public float d;
    public boolean e;
    public boolean f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView.ScaleType f1342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n.a f1343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z4.a f1345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1346l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public r.e f1347m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1348n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1349o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1350p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f1351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1352r;

    public w() {
        this.f1339a = new Matrix();
        u.c r5 = new u.c();
        this.f1341c = r5;
        this.d = 1.0f;
        this.e = true;
        this.f = false;
        new HashSet();
        this.g = new ArrayList();
        t r10 = new t(this, 0);
        this.f1348n = 255;
        this.f1351q = true;
        this.f1352r = false;
        r5.addUpdateListener(r10);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, o.f] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, o.f] */
    public final void a(o.e r10, ColorFilter r11, v.c r12) {
        if (this.f1347m != null) goto L6;
        this.g.add(new s(this, r10, r11, r12));
        return;
    L6:
        ?? r5 = r10.f20374b;
        boolean r13 = true;
        if (r5 == 0) goto L9;
        r5.c(r11, r12);
    L14:
        if (r13 == false) goto L20;
        invalidateSelf();
        if (r11 != z.f1373w) goto L21;
        m(this.f1341c.a());
        return;
    L21:
        return;
    L20:
        return;
    L9:
        ArrayList r14 = new ArrayList();
        int r15 = 0;
        this.f1347m.d(r10, 0, r14, new o.e(new String[0]));
    L11:
        if (r15 >= r14.size()) goto L13;
        ((o.e) r14.get(r15)).f20374b.c(r11, r12);
        r15 = r15 + 1;
        goto L11
    L13:
        r13 = true ^ r14.isEmpty();
        goto L14
    }

    public final void b() {
        h r5 = this.f1340b;
        ko.r r10 = t.p.f22041a;
        Rect r11 = r5.f1265j;
        r.g r13 = new r.g(Collections.emptyList(), r5, "__container", -1, Layer$LayerType.PRE_COMP, -1, null, Collections.emptyList(), new p.d(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, r11.width(), r11.height(), null, null, Collections.emptyList(), Layer$MatteType.NONE, null, false);
        h r12 = this.f1340b;
        this.f1347m = new r.e(this, r13, r12.f1264i, r12);
    }

    public final void c() {
        u.c r5 = this.f1341c;
        if (r5.f22188k == false) goto L5;
        r5.cancel();
    L5:
        this.f1340b = null;
        this.f1347m = null;
        this.f1343i = null;
        r5.f22187j = null;
        r5.f22185h = -2.1474836E9f;
        r5.f22186i = 2.1474836E9f;
        invalidateSelf();
    }

    public final void d(Canvas r10) {
        ImageView.ScaleType r5 = ImageView.ScaleType.FIT_XY;
        ImageView.ScaleType r11 = this.f1342h;
        Matrix r12 = this.f1339a;
        int r13 = -1;
        if (r5 != r11) goto L20;
        if (this.f1347m == null) goto L36;
        Rect r14 = getBounds();
        float r15 = r14.width() / this.f1340b.f1265j.width();
        float r16 = r14.height() / this.f1340b.f1265j.height();
        if (this.f1351q == false) goto L16;
        float r17 = Math.min(r15, r16);
        if (r17 >= 1.0f) goto L12;
        float r18 = 1.0f / r17;
        r15 = r15 / r18;
        r16 = r16 / r18;
    L14:
        if (r18 <= 1.0f) goto L16;
        r13 = r10.save();
        float r19 = r14.width() / 2.0f;
        float r20 = r14.height() / 2.0f;
        float r21 = r19 * r17;
        float r22 = r17 * r20;
        r10.translate(r19 - r21, r20 - r22);
        r10.scale(r18, r18, r21, r22);
        goto L16
    L12:
        r18 = 1.0f;
    L16:
        r12.reset();
        r12.preScale(r15, r16);
        this.f1347m.g(r10, r12, this.f1348n);
        if (r13 <= 0) goto L33;
        r10.restoreToCount(r13);
        return;
    L33:
        return;
    L36:
        return;
    L20:
        if (this.f1347m == null) goto L37;
        float r23 = this.d;
        float r24 = Math.min(r10.getWidth() / this.f1340b.f1265j.width(), r10.getHeight() / this.f1340b.f1265j.height());
        if (r23 <= r24) goto L25;
        float r25 = this.d / r24;
    L27:
        if (r25 <= 1.0f) goto L29;
        r13 = r10.save();
        float r26 = this.f1340b.f1265j.width() / 2.0f;
        float r27 = this.f1340b.f1265j.height() / 2.0f;
        float r28 = r26 * r24;
        float r29 = r27 * r24;
        float r30 = this.d;
        r10.translate((r26 * r30) - r28, (r30 * r27) - r29);
        r10.scale(r25, r25, r28, r29);
    L29:
        r12.reset();
        r12.preScale(r24, r24);
        this.f1347m.g(r10, r12, this.f1348n);
        if (r13 <= 0) goto L35;
        r10.restoreToCount(r13);
        return;
    L35:
        return;
    L25:
        r24 = r23;
        r25 = 1.0f;
        goto L27
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        this.f1352r = false;
        if (this.f == true) goto L10;
        d(r5);
    L8:
        c.a();
        return;
    L10:
        d(r5);     // Catch: Throwable -> L6
    L6:
        u.b.f22181a.getClass();
        goto L8
    }

    public final void e() {
        if (this.f1347m != null) goto L6;
        this.g.add(new u(this, 0));
        return;
    L6:
        boolean r5 = this.e;
        u.c r10 = this.f1341c;
        if (r5 == false) goto L9;
    L10:
        r10.f22188k = true;
        boolean r11 = r10.e();
        Iterator r12 = r10.f22183b.iterator();
    L12:
        if (r12.hasNext() == false) goto L15;
        ((Animator.AnimatorListener) r12.next()).onAnimationStart(r10, r11);
        goto L12
    L15:
        if (r10.e() == false) goto L17;
        float r13 = r10.b();
    L18:
        r10.g((int) r13);
        r10.e = 0;
        r10.g = 0;
        if (r10.f22188k == false) goto L22;
        r10.f(false);
        Choreographer.getInstance().postFrameCallback(r10);
    L22:
        if (this.e == false) goto L24;
        return;
    L24:
        if (r10.f22184c >= 0.0f) goto L26;
        float r14 = r10.c();
    L27:
        g((int) r14);
        r10.f(true);
        boolean r15 = r10.e();
        Iterator r16 = r10.f22183b.iterator();
    L29:
        if (r16.hasNext() == false) goto L34;
        ((Animator.AnimatorListener) r16.next()).onAnimationEnd(r10, r15);
        goto L29
    L34:
        return;
    L26:
        r14 = r10.b();
        goto L27
    L17:
        r13 = r10.c();
        goto L18
    L9:
        if (r10.getRepeatCount() != 0) goto L22;
        goto L10
    }

    public final void f() {
        if (this.f1347m != null) goto L6;
        this.g.add(new u(this, 1));
        return;
    L6:
        boolean r5 = this.e;
        u.c r10 = this.f1341c;
        if (r5 == false) goto L9;
    L10:
        r10.f22188k = true;
        r10.f(false);
        Choreographer.getInstance().postFrameCallback(r10);
        r10.e = 0;
        if (r10.e() == false) goto L16;
        if (r10.f != r10.c()) goto L16;
        r10.f = r10.b();
    L21:
        if (this.e == false) goto L23;
        return;
    L23:
        if (r10.f22184c >= 0.0f) goto L25;
        float r11 = r10.c();
    L26:
        g((int) r11);
        r10.f(true);
        boolean r12 = r10.e();
        Iterator r13 = r10.f22183b.iterator();
    L28:
        if (r13.hasNext() == false) goto L32;
        ((Animator.AnimatorListener) r13.next()).onAnimationEnd(r10, r12);
        goto L28
    L32:
        return;
    L25:
        r11 = r10.b();
    L16:
        if (r10.e() == true) goto L21;
        if (r10.f != r10.b()) goto L21;
        r10.f = r10.c();
        goto L21
    L9:
        if (r10.getRepeatCount() != 0) goto L21;
        goto L10
    }

    public final void g(int r5) {
        if (this.f1340b != null) goto L6;
        this.g.add(new q(this, r5, 0));
        return;
    L6:
        this.f1341c.g(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f1348n;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        h r5 = this.f1340b;
        if (r5 != null) goto L6;
        return -1;
    L6:
        return (int) (r5.f1265j.height() * this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        h r5 = this.f1340b;
        if (r5 != null) goto L6;
        return -1;
    L6:
        return (int) (r5.f1265j.width() * this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h(int r5) {
        if (this.f1340b != null) goto L6;
        this.g.add(new q(this, r5, 2));
        return;
    L6:
        u.c r10 = this.f1341c;
        r10.h(r10.f22185h, r5 + 0.99f);
    }

    public final void i(String r5) {
        h r10 = this.f1340b;
        if (r10 != null) goto L6;
        this.g.add(new o(this, r5, 2));
        return;
    L6:
        o.h r11 = r10.c(r5);
        if (r11 == null) goto L11;
        h((int) (r11.f20378b + r11.f20379c));
        return;
    L11:
        throw new IllegalArgumentException(j0.k("Cannot find marker with name ", r5, "."));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        Drawable.Callback r10 = getCallback();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        if (this.f1352r == false) goto L5;
        return;
    L5:
        this.f1352r = true;
        Drawable.Callback r5 = getCallback();
        if (r5 == null) goto L9;
        r5.invalidateDrawable(this);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        u.c r5 = this.f1341c;
        if (r5 != null) goto L6;
        return false;
    L6:
        return r5.f22188k;
    }

    public final void j(String r5) {
        h r10 = this.f1340b;
        ArrayList r11 = this.g;
        if (r10 != null) goto L6;
        r11.add(new o(this, r5, 0));
        return;
    L6:
        o.h r12 = r10.c(r5);
        if (r12 == null) goto L14;
        int r13 = (int) r12.f20378b;
        int r14 = ((int) r12.f20379c) + r13;
        if (this.f1340b != null) goto L11;
        r11.add(new p(this, r13, r14));
        return;
    L11:
        this.f1341c.h(r13, r14 + 0.99f);
        return;
    L14:
        throw new IllegalArgumentException(j0.k("Cannot find marker with name ", r5, "."));
    }

    public final void k(int r5) {
        if (this.f1340b != null) goto L6;
        this.g.add(new q(this, r5, 1));
        return;
    L6:
        u.c r10 = this.f1341c;
        r10.h(r5, (int) r10.f22186i);
    }

    public final void l(String r5) {
        h r10 = this.f1340b;
        if (r10 != null) goto L6;
        this.g.add(new o(this, r5, 1));
        return;
    L6:
        o.h r11 = r10.c(r5);
        if (r11 == null) goto L11;
        k((int) r11.f20378b);
        return;
    L11:
        throw new IllegalArgumentException(j0.k("Cannot find marker with name ", r5, "."));
    }

    public final void m(float r5) {
        h r10 = this.f1340b;
        if (r10 != null) goto L6;
        this.g.add(new r(this, r5, 0));
        return;
    L6:
        float r11 = u.e.d(r10.f1266k, r10.f1267l, r5);
        this.f1341c.g(r11);
        c.a();
    }

    public final void n() {
        h r5 = this.f1340b;
        if (r5 != null) goto L5;
        return;
    L5:
        float r10 = this.d;
        setBounds(0, 0, (int) (r5.f1265j.width() * r10), (int) (this.f1340b.f1265j.height() * r10));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
        Drawable.Callback r12 = getCallback();
        if (r12 != null) goto L5;
        return;
    L5:
        r12.scheduleDrawable(this, r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        this.f1348n = r5;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        u.b.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        e();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.g.clear();
        u.c r5 = this.f1341c;
        r5.f(true);
        boolean r10 = r5.e();
        Iterator r11 = r5.f22183b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((Animator.AnimatorListener) r11.next()).onAnimationEnd(r5, r10);
        goto L4
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r5, Runnable r10) {
        Drawable.Callback r11 = getCallback();
        if (r11 != null) goto L5;
        return;
    L5:
        r11.unscheduleDrawable(this, r10);
    }
}
