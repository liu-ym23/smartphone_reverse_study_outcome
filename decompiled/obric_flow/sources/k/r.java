package k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class r implements e, n, j, l.a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f18556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f18557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f18558c;
    public final r.c d;
    public final String e;
    public final boolean f;
    public final l.f g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l.f f18559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l.m f18560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f18561j;

    public r(w r5, r.c r10, q.i r11) {
        this.f18556a = new Matrix();
        this.f18557b = new Path();
        this.f18558c = r5;
        this.d = r10;
        this.e = (String) r11.f21421b;
        this.f = r11.d;
        l.d r12 = r11.f21422c.d();
        this.g = (l.f) r12;
        r10.f(r12);
        r12.a(this);
        l.d r13 = ((p.b) r11.e).d();
        this.f18559h = (l.f) r13;
        r10.f(r13);
        r13.a(this);
        p.d r14 = (p.d) r11.f;
        r14.getClass();
        l.m r15 = new l.m(r14);
        this.f18560i = r15;
        r15.a(r10);
        r15.b(this);
    }

    @Override // l.a
    public final void a() {
        this.f18558c.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r5, List r10) {
        this.f18561j.b(r5, r10);
    }

    @Override // o.f
    public final void c(ColorFilter r5, v.c r10) {
        if (this.f18560i.c(r5, r10) == false) goto L6;
        return;
    L6:
        if (r5 != z.f1364m) goto L9;
        this.g.j(r10);
        return;
    L9:
        if (r5 != z.f1365n) goto L13;
        this.f18559h.j(r10);
        return;
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        u.e.e(r5, r10, r11, r12, this);
    }

    @Override // k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        this.f18561j.e(r5, r10, r11);
    }

    @Override // k.j
    public final void f(ListIterator r10) {
        if (this.f18561j == null) goto L6;
        return;
    L6:
        if (r10.hasPrevious() == false) goto L10;
        if (r10.previous() != this) goto L6;
    L10:
        ArrayList r11 = new ArrayList();
    L12:
        if (r10.hasPrevious() == false) goto L14;
        r11.add(r10.previous());
        r10.remove();
        goto L12
    L14:
        Collections.reverse(r11);
        r.c r5 = this.d;
        this.f18561j = new d(this.f18558c, r5, "Repeater", this.f, r11, null);
    }

    @Override // k.e
    public final void g(Canvas r10, Matrix r11, int r12) {
        float r5 = ((Float) this.g.f()).floatValue();
        float r13 = ((Float) this.f18559h.f()).floatValue();
        l.m r14 = this.f18560i;
        float r15 = ((Float) r14.f19508m.f()).floatValue() / 100.0f;
        float r16 = ((Float) r14.f19509n.f()).floatValue() / 100.0f;
        int r17 = ((int) r5) - 1;
    L3:
        if (r17 < 0) goto L5;
        Matrix r18 = this.f18556a;
        r18.set(r11);
        float r19 = r17;
        r18.preConcat(r14.f(r19 + r13));
        this.f18561j.g(r10, r18, (int) (u.e.d(r15, r16, r19 / r5) * r12));
        r17 = r17 - 1;
        goto L3
    }

    @Override // k.c
    public final String getName() {
        return this.e;
    }

    @Override // k.n
    public final Path getPath() {
        Path r5 = this.f18561j.getPath();
        Path r10 = this.f18557b;
        r10.reset();
        float r11 = ((Float) this.g.f()).floatValue();
        float r12 = ((Float) this.f18559h.f()).floatValue();
        int r13 = ((int) r11) - 1;
    L3:
        if (r13 < 0) goto L5;
        Matrix r14 = this.f18556a;
        r14.set(this.f18560i.f(r13 + r12));
        r10.addPath(r5, r14);
        r13 = r13 - 1;
        goto L3
    L5:
        return r10;
    }
}
