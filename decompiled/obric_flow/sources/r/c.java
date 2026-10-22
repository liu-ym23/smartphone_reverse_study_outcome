package r;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.d0;
import com.airbnb.lottie.model.content.Mask$MaskMode;
import com.airbnb.lottie.model.layer.Layer$MatteType;
import com.airbnb.lottie.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import l.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements k.e, l.a, o.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f21580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f21581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.a f21582c;
    public final j.a d;
    public final j.a e;
    public final j.a f;
    public final j.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f21583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f21584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f21585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f21586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f21587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w f21588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g f21589n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i4.a f21590o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f21591p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f21592q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f21593r;
    public final ArrayList s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final m f21594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f21595u;

    public c(w r10, g r11) {
        this.f21580a = new Path();
        this.f21581b = new Matrix();
        boolean r5 = true;
        this.f21582c = new j.a(1, 0);
        PorterDuff.Mode r12 = PorterDuff.Mode.DST_IN;
        this.d = new j.a(r12);
        PorterDuff.Mode r13 = PorterDuff.Mode.DST_OUT;
        this.e = new j.a(r13);
        j.a r14 = new j.a(1, 0);
        this.f = r14;
        PorterDuff.Mode r15 = PorterDuff.Mode.CLEAR;
        j.a r16 = new j.a();
        r16.setXfermode(new PorterDuffXfermode(r15));
        this.g = r16;
        this.f21583h = new RectF();
        this.f21584i = new RectF();
        this.f21585j = new RectF();
        this.f21586k = new RectF();
        this.f21587l = new Matrix();
        this.s = new ArrayList();
        this.f21595u = true;
        this.f21588m = r10;
        this.f21589n = r11;
        r11.f21608c.concat("#draw");
        Layer$MatteType r17 = Layer$MatteType.INVERT;
        if (r11.f21621u != r17) goto L5;
        r14.setXfermode(new PorterDuffXfermode(r13));
    L6:
        p.d r18 = r11.f21610i;
        r18.getClass();
        m r19 = new m(r18);
        this.f21594t = r19;
        r19.b(this);
        List r20 = r11.f21609h;
        if (r20 != null) goto L9;
    L18:
        g r21 = this.f21589n;
        if (r21.f21620t.isEmpty() == true) goto L29;
        l.f r22 = new l.f(r21.f21620t);
        r22.f19483b = true;
        r22.a(new a(this, r22));
        if (((Float) r22.f()).floatValue() == 1.0f) goto L25;
        r5 = false;
    L25:
        if (r5 == this.f21595u) goto L27;
        this.f21595u = r5;
        this.f21588m.invalidateSelf();
    L27:
        f(r22);
        return;
    L29:
        if (true == this.f21595u) goto L35;
        this.f21595u = true;
        this.f21588m.invalidateSelf();
        return;
    L35:
        return;
    L9:
        if (r20.isEmpty() == true) goto L18;
        i4.a r23 = new i4.a(r20, 7);
        this.f21590o = r23;
        Iterator r24 = ((ArrayList) r23.f17502b).iterator();
    L12:
        if (r24.hasNext() == false) goto L14;
        ((l.d) r24.next()).a(this);
        goto L12
    L14:
        Iterator r25 = ((ArrayList) this.f21590o.f17503c).iterator();
    L16:
        if (r25.hasNext() == false) goto L18;
        l.d r26 = (l.d) r25.next();
        f(r26);
        r26.a(this);
        goto L16
    L5:
        r14.setXfermode(new PorterDuffXfermode(r12));
        goto L6
    }

    @Override // l.a
    public final void a() {
        this.f21588m.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r5, List r10) {
    }

    @Override // o.f
    public void c(ColorFilter r5, v.c r10) {
        this.f21594t.c(r5, r10);
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        g r13 = this.f21589n;
        if (r5.c(r10, r13.f21608c) == true) goto L5;
        return;
    L5:
        String r14 = r13.f21608c;
        if ("__container".equals(r14) == true) goto L12;
        r12.getClass();
        o.e r15 = new o.e(r12);
        r15.f20373a.add(r14);
        if (r5.a(r10, r14) == false) goto L10;
        o.e r16 = new o.e(r15);
        r16.f20374b = this;
        r11.add(r16);
    L10:
        r12 = r15;
    L12:
        if (r5.d(r10, r14) == false) goto L15;
        m(r5, r5.b(r10, r14) + r10, r11, r12);
        return;
    }

    @Override // k.e
    public void e(RectF r5, Matrix r10, boolean r11) {
        this.f21583h.set(0.0f, 0.0f, 0.0f, 0.0f);
        h();
        Matrix r12 = this.f21587l;
        r12.set(r10);
        if (r11 == false) goto L12;
        List r13 = this.f21593r;
        if (r13 == null) goto L9;
        int r14 = r13.size() - 1;
    L7:
        if (r14 < 0) goto L12;
        r12.preConcat(((c) this.f21593r.get(r14)).f21594t.e());
        r14 = r14 - 1;
        goto L7
    L9:
        c r15 = this.f21592q;
        if (r15 == null) goto L12;
        r12.preConcat(r15.f21594t.e());
    L12:
        r12.preConcat(this.f21594t.e());
    }

    public final void f(l.d r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.s.add(r5);
    }

    @Override // k.e
    public final void g(Canvas r19, Matrix r20, int r21) {
        int r5 = 1;
        if (this.f21595u == false) goto L108;
        g r10 = this.f21589n;
        if (r10.f21622v == true) goto L108;
        h();
        Matrix r11 = this.f21581b;
        r11.reset();
        r11.set(r20);
        int r12 = this.f21593r.size() - 1;
    L8:
        if (r12 < 0) goto L10;
        r11.preConcat(((c) this.f21593r.get(r12)).f21594t.e());
        r12 = r12 - 1;
        goto L8
    L10:
        com.airbnb.lottie.c.a();
        m r13 = this.f21594t;
        l.d r14 = r13.f19505j;
        if (r14 != null) goto L14;
        int r15 = 100;
    L15:
        int r16 = (int) ((((r21 / 255.0f) * r15) / 100.0f) * 255.0f);
        if (this.f21591p == null) goto L18;
        boolean r17 = true;
    L19:
        if (r17 == false) goto L21;
    L24:
        RectF r18 = this.f21583h;
        e(r18, r11, false);
        if (this.f21591p != null) goto L27;
    L32:
        r11.preConcat(r13.e());
        RectF r22 = this.f21584i;
        r22.set(0.0f, 0.0f, 0.0f, 0.0f);
        boolean r23 = k();
        Path r110 = this.f21580a;
        i4.a r111 = this.f21590o;
        int r112 = 2;
        if (r23 == true) goto L35;
        float r24 = 0.0f;
    L57:
        if (r18.intersect(r24, r24, r19.getWidth(), r19.getHeight()) == true) goto L59;
        r18.set(r24, r24, r24, r24);
    L59:
        com.airbnb.lottie.c.a();
        if (r18.isEmpty() == true) goto L106;
        j.a r25 = this.f21582c;
        r25.setAlpha(255);
        PathMeasure r26 = u.f.f22191a;
        r19.saveLayer(r18, r25);
        com.airbnb.lottie.c.a();
        com.airbnb.lottie.c.a();
        i(r19);
        j(r19, r11, r16);
        com.airbnb.lottie.c.a();
        if (k() == false) goto L103;
        j.a r27 = this.d;
        r19.saveLayer(r18, r27);
        com.airbnb.lottie.c.a();
        com.airbnb.lottie.c.a();
        int r28 = 0;
    L65:
        if (r28 >= ((List) r111.d).size()) goto L101;
        List r113 = (List) r111.d;
        q.f r114 = (q.f) r113.get(r28);
        ArrayList r115 = (ArrayList) r111.f17502b;
        l.d r116 = (l.d) r115.get(r28);
        l.d r29 = (l.d) ((ArrayList) r111.f17503c).get(r28);
        i4.a r117 = r111;
        int r118 = b.f21579b[r114.f21409a.ordinal()];
        if (r118 == 1) goto L90;
        j.a r30 = this.e;
        boolean r119 = r114.d;
        if (r118 == 2) goto L84;
        if (r118 == 3) goto L80;
        if (r118 != 4) goto L75;
        if (r119 == false) goto L78;
        r19.saveLayer(r18, r25);
        com.airbnb.lottie.c.a();
        r19.drawRect(r18, r25);
        r110.set((Path) r116.f());
        r110.transform(r11);
        r25.setAlpha((int) (((Integer) r29.f()).intValue() * 2.55f));
        r19.drawPath(r110, r30);
        r19.restore();
        goto L75
    L78:
        r110.set((Path) r116.f());
        r110.transform(r11);
        r25.setAlpha((int) (((Integer) r29.f()).intValue() * 2.55f));
        r19.drawPath(r110, r25);
    L75:
        char r120 = 255;
        int r121 = 1;
    L100:
        r28 = r28 + r121;
        r111 = r117;
        goto L65
    L80:
        if (r119 == false) goto L82;
        r19.saveLayer(r18, r27);
        com.airbnb.lottie.c.a();
        r19.drawRect(r18, r25);
        r30.setAlpha((int) (((Integer) r29.f()).intValue() * 2.55f));
        r110.set((Path) r116.f());
        r110.transform(r11);
        r19.drawPath(r110, r30);
        r19.restore();
        goto L75
    L82:
        r19.saveLayer(r18, r27);
        com.airbnb.lottie.c.a();
        r110.set((Path) r116.f());
        r110.transform(r11);
        r25.setAlpha((int) (((Integer) r29.f()).intValue() * 2.55f));
        r19.drawPath(r110, r25);
        r19.restore();
        goto L75
    L84:
        if (r28 != 0) goto L86;
        r25.setColor(ViewCompat.MEASURED_STATE_MASK);
        r25.setAlpha(255);
        r19.drawRect(r18, r25);
    L86:
        if (r119 == false) goto L88;
        r19.saveLayer(r18, r30);
        com.airbnb.lottie.c.a();
        r19.drawRect(r18, r25);
        r30.setAlpha((int) (((Integer) r29.f()).intValue() * 2.55f));
        r110.set((Path) r116.f());
        r110.transform(r11);
        r19.drawPath(r110, r30);
        r19.restore();
        goto L75
    L88:
        r110.set((Path) r116.f());
        r110.transform(r11);
        r19.drawPath(r110, r30);
        goto L75
    L90:
        if (r115.isEmpty() == true) goto L75;
        int r122 = 0;
    L94:
        if (r122 >= r113.size()) goto L99;
        if (((q.f) r113.get(r122)).f21409a != Mask$MaskMode.MASK_MODE_NONE) goto L75;
        r122 = r122 + 1;
        goto L94
    L99:
        r120 = 255;
        r121 = 1;
        r25.setAlpha(255);
        r19.drawRect(r18, r25);
        goto L100
    L101:
        r19.restore();
        com.airbnb.lottie.c.a();
    L103:
        if (this.f21591p == null) goto L105;
        r19.saveLayer(r18, this.f);
        com.airbnb.lottie.c.a();
        com.airbnb.lottie.c.a();
        i(r19);
        this.f21591p.g(r19, r20, r16);
        r19.restore();
        com.airbnb.lottie.c.a();
        com.airbnb.lottie.c.a();
    L105:
        r19.restore();
        com.airbnb.lottie.c.a();
    L106:
        com.airbnb.lottie.c.a();
        l();
        return;
    L35:
        int r31 = ((List) r111.d).size();
        int r123 = 0;
    L36:
        if (r123 >= r31) goto L54;
        q.f r32 = (q.f) ((List) r111.d).get(r123);
        r110.set((Path) ((l.d) ((ArrayList) r111.f17502b).get(r123)).f());
        r110.transform(r11);
        int r124 = b.f21579b[r32.f21409a.ordinal()];
        if (r124 == r5) goto L47;
        if (r124 == r112) goto L47;
        if (r124 == 3) goto L46;
        if (r124 == 4) goto L46;
    L48:
        RectF r33 = this.f21586k;
        r110.computeBounds(r33, false);
        if (r123 != 0) goto L51;
        r22.set(r33);
    L52:
        r123 = r123 + r5;
        r112 = 2;
        goto L36
    L51:
        r22.set(Math.min(r22.left, r33.left), Math.min(r22.top, r33.top), Math.max(r22.right, r33.right), Math.max(r22.bottom, r33.bottom));
        r5 = 1;
    L46:
        if (r32.d == false) goto L48;
    L47:
        r24 = 0.0f;
        goto L57
    L54:
        if (r18.intersect(r22) == true) goto L47;
        r24 = 0.0f;
        r18.set(0.0f, 0.0f, 0.0f, 0.0f);
        goto L57
    L27:
        if (r10.f21621u == Layer$MatteType.INVERT) goto L32;
        RectF r34 = this.f21585j;
        r34.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.f21591p.e(r34, r20, true);
        if (r18.intersect(r34) == true) goto L32;
        r18.set(0.0f, 0.0f, 0.0f, 0.0f);
        goto L32
    L21:
        if (k() == true) goto L24;
        r11.preConcat(r13.e());
        j(r19, r11, r16);
        com.airbnb.lottie.c.a();
        com.airbnb.lottie.c.a();
        l();
        return;
    L18:
        r17 = false;
        goto L19
    L14:
        r15 = ((Integer) r14.f()).intValue();
    L108:
        com.airbnb.lottie.c.a();
    }

    public final void h() {
        if (this.f21593r == null) goto L6;
        return;
    L6:
        if (this.f21592q != null) goto L9;
        this.f21593r = Collections.emptyList();
        return;
    L9:
        this.f21593r = new ArrayList();
        c r5 = this.f21592q;
    L10:
        if (r5 == null) goto L12;
        this.f21593r.add(r5);
        r5 = r5.f21592q;
        goto L10
    }

    public final void i(Canvas r10) {
        RectF r5 = this.f21583h;
        r10.drawRect(r5.left - 1.0f, r5.top - 1.0f, r5.right + 1.0f, r5.bottom + 1.0f, this.g);
        com.airbnb.lottie.c.a();
    }

    public abstract void j(Canvas r5, Matrix r10, int r11);

    public final boolean k() {
        i4.a r5 = this.f21590o;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (((ArrayList) r5.f17502b).isEmpty() == true) goto L7;
        return true;
    }

    public final void l() {
        d0 r5 = this.f21588m.f1340b.f1260a;
        String r10 = this.f21589n.f21608c;
        if (r5.f1254a == false) goto L19;
        HashMap r11 = r5.f1256c;
        u.d r12 = (u.d) r11.get(r10);
        if (r12 != null) goto L8;
        r12 = new u.d();
        r11.put(r10, r12);
    L8:
        int r13 = r12.f22189a + 1;
        r12.f22189a = r13;
        if (r13 != Integer.MAX_VALUE) goto L12;
        r12.f22189a = r13 / 2;
    L12:
        if (r10.equals("__container") == false) goto L18;
        Iterator<E> r14 = r5.f1255b.iterator();
        if (r14.hasNext() == true) goto L17;
        return;
    L17:
        throw androidx.constraintlayout.motion.widget.a.g(r14);
    L18:
        return;
    }

    public void m(o.e r5, int r10, ArrayList r11, o.e r12) {
    }

    public void n(float r10) {
        m r5 = this.f21594t;
        l.d r11 = r5.f19505j;
        if (r11 == null) goto L5;
        r11.i(r10);
    L5:
        l.d r12 = r5.f19508m;
        if (r12 == null) goto L8;
        r12.i(r10);
    L8:
        l.d r13 = r5.f19509n;
        if (r13 == null) goto L11;
        r13.i(r10);
    L11:
        l.d r14 = r5.f;
        if (r14 == null) goto L14;
        r14.i(r10);
    L14:
        l.d r15 = r5.g;
        if (r15 == null) goto L17;
        r15.i(r10);
    L17:
        l.d r16 = r5.f19503h;
        if (r16 == null) goto L20;
        r16.i(r10);
    L20:
        l.d r17 = r5.f19504i;
        if (r17 == null) goto L23;
        r17.i(r10);
    L23:
        l.f r18 = r5.f19506k;
        if (r18 == null) goto L26;
        r18.i(r10);
    L26:
        l.f r19 = r5.f19507l;
        if (r19 == null) goto L29;
        r19.i(r10);
    L29:
        i4.a r20 = this.f21590o;
        int r21 = 0;
        if (r20 == null) goto L35;
        int r22 = 0;
    L32:
        ArrayList r23 = (ArrayList) r20.f17502b;
        if (r22 >= r23.size()) goto L35;
        ((l.d) r23.get(r22)).i(r10);
        r22 = r22 + 1;
    L35:
        float r24 = this.f21589n.f21614m;
        if (r24 == 0.0f) goto L38;
        r10 = r10 / r24;
    L38:
        c r25 = this.f21591p;
        if (r25 == null) goto L41;
        r25.n(r25.f21589n.f21614m * r10);
    L41:
        ArrayList r26 = this.s;
        if (r21 >= r26.size()) goto L44;
        ((l.d) r26.get(r21)).i(r10);
        r21 = r21 + 1;
        goto L41
    }
}
