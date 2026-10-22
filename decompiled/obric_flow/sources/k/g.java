package k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g implements e, l.a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f18505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j.a f18506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r.c f18507c;
    public final String d;
    public final boolean e;
    public final ArrayList f;
    public final l.e g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l.e f18508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l.n f18509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f18510j;

    public g(w r5, r.c r10, q.k r11) {
        Path r12 = new Path();
        this.f18505a = r12;
        this.f18506b = new j.a(1, 0);
        this.f = new ArrayList();
        this.f18507c = r10;
        this.d = r11.f21428c;
        this.e = r11.f;
        this.f18510j = r5;
        p.a r13 = r11.d;
        if (r13 == null) goto L9;
        p.a r14 = r11.e;
        if (r14 == null) goto L9;
        r12.setFillType(r11.f21427b);
        l.d r15 = r13.d();
        this.g = (l.e) r15;
        r15.a(this);
        r10.f(r15);
        l.d r16 = r14.d();
        this.f18508h = (l.e) r16;
        r16.a(this);
        r10.f(r16);
        return;
    L9:
        this.g = null;
        this.f18508h = null;
    }

    @Override // l.a
    public final void a() {
        this.f18510j.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r5, List r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L9;
        c r12 = (c) r10.get(r11);
        if ((r12 instanceof n) == false) goto L8;
        this.f.add((n) r12);
    L8:
        r11 = r11 + 1;
        goto L4
    }

    @Override // o.f
    public final void c(ColorFilter r5, v.c r10) {
        PointF r11 = z.f1356a;
        if (r5 != 1) goto L6;
        this.g.j(r10);
        return;
    L6:
        if (r5 != 4) goto L9;
        this.f18508h.j(r10);
        return;
    L9:
        if (r5 != z.f1375y) goto L14;
        l.n r12 = new l.n(r10, null);
        this.f18509i = r12;
        r12.a(this);
        this.f18507c.f(this.f18509i);
        return;
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        u.e.e(r5, r10, r11, r12, this);
    }

    @Override // k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        Path r12 = this.f18505a;
        r12.reset();
        int r13 = 0;
    L3:
        ArrayList r14 = this.f;
        if (r13 >= r14.size()) goto L6;
        r12.addPath(((n) r14.get(r13)).getPath(), r10);
        r13 = r13 + 1;
        goto L3
    L6:
        r12.computeBounds(r5, false);
        r5.set(r5.left - 1.0f, r5.top - 1.0f, r5.right + 1.0f, r5.bottom + 1.0f);
    }

    @Override // k.e
    public final void g(Canvas r5, Matrix r10, int r11) {
        if (this.e == false) goto L5;
        return;
    L5:
        l.e r12 = this.g;
        int r13 = r12.k(r12.b(), r12.d());
        j.a r14 = this.f18506b;
        r14.setColor(r13);
        int r15 = (int) ((((r11 / 255.0f) * ((Integer) this.f18508h.f()).intValue()) / 100.0f) * 255.0f);
        PointF r16 = u.e.f22190a;
        int r17 = 0;
        r14.setAlpha(Math.max(0, Math.min(255, r15)));
        l.n r18 = this.f18509i;
        if (r18 == null) goto L8;
        r14.setColorFilter((ColorFilter) r18.f());
    L8:
        Path r19 = this.f18505a;
        r19.reset();
    L9:
        ArrayList r20 = this.f;
        if (r17 >= r20.size()) goto L12;
        r19.addPath(((n) r20.get(r17)).getPath(), r10);
        r17 = r17 + 1;
        goto L9
    L12:
        r5.drawPath(r19, r14);
        com.airbnb.lottie.c.a();
    }

    @Override // k.c
    public final String getName() {
        return this.d;
    }
}
