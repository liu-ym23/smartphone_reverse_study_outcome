package k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d implements e, n, l.a, o.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j.a f18494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f18495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f18496c;
    public final Path d;
    public final RectF e;
    public final String f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f18497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w f18498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f18499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l.m f18500k;

    public d(w r10, r.c r11, q.l r12) {
        String r5 = r12.f21429a;
        List r13 = r12.f21430b;
        ArrayList r14 = new ArrayList(r13.size());
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r16 >= r13.size()) goto L10;
        c r17 = ((q.b) r13.get(r16)).a(r10, r11);
        if (r17 == null) goto L8;
        r14.add(r17);
    L8:
        r16 = r16 + 1;
    L10:
        if (r15 >= r13.size()) goto L15;
        q.b r18 = (q.b) r13.get(r15);
        if ((r18 instanceof p.d) == true) goto L13;
        r15 = r15 + 1;
        goto L10
    L13:
        p.d r19 = (p.d) r18;
    L16:
        this(r10, r11, r5, r12.f21431c, r14, r19);
        return;
    L15:
        r19 = null;
        goto L16
    }

    @Override // l.a
    public final void a() {
        this.f18498i.invalidateSelf();
    }

    @Override // k.c
    public final void b(List r5, List r10) {
        int r11 = r5.size();
        ArrayList r12 = this.f18497h;
        ArrayList r13 = new ArrayList(r12.size() + r11);
        r13.addAll(r5);
        int r14 = r12.size() - 1;
    L3:
        if (r14 < 0) goto L5;
        c r15 = (c) r12.get(r14);
        r15.b(r13, r12.subList(0, r14));
        r13.add(r15);
        r14 = r14 - 1;
        goto L3
    }

    @Override // o.f
    public final void c(ColorFilter r5, v.c r10) {
        l.m r11 = this.f18500k;
        if (r11 == null) goto L6;
        r11.c(r5, r10);
        return;
    }

    @Override // o.f
    public final void d(o.e r5, int r10, ArrayList r11, o.e r12) {
        String r13 = this.f;
        if (r5.c(r10, r13) == true) goto L6;
        return;
    L6:
        if ("__container".equals(r13) == true) goto L12;
        r12.getClass();
        o.e r14 = new o.e(r12);
        r14.f20373a.add(r13);
        if (r5.a(r10, r13) == false) goto L10;
        o.e r15 = new o.e(r14);
        r15.f20374b = this;
        r11.add(r15);
    L10:
        r12 = r14;
    L12:
        if (r5.d(r10, r13) == false) goto L20;
        int r16 = r5.b(r10, r13) + r10;
        int r17 = 0;
    L14:
        ArrayList r18 = this.f18497h;
        if (r17 >= r18.size()) goto L24;
        c r19 = (c) r18.get(r17);
        if ((r19 instanceof o.f) == false) goto L19;
        ((o.f) r19).d(r5, r16, r11, r12);
    L19:
        r17 = r17 + 1;
        goto L14
    L24:
        return;
    }

    @Override // k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        Matrix r12 = this.f18496c;
        r12.set(r10);
        l.m r13 = this.f18500k;
        if (r13 == null) goto L5;
        r12.preConcat(r13.e());
    L5:
        RectF r14 = this.e;
        r14.set(0.0f, 0.0f, 0.0f, 0.0f);
        ArrayList r15 = this.f18497h;
        int r16 = r15.size() - 1;
    L6:
        if (r16 < 0) goto L11;
        c r17 = (c) r15.get(r16);
        if ((r17 instanceof e) == false) goto L10;
        ((e) r17).e(r14, r12, r11);
        r5.union(r14);
    L10:
        r16 = r16 - 1;
        goto L6
    }

    public final List f() {
        if (this.f18499j != null) goto L12;
        this.f18499j = new ArrayList();
        int r5 = 0;
    L5:
        ArrayList r10 = this.f18497h;
        if (r5 >= r10.size()) goto L12;
        c r11 = (c) r10.get(r5);
        if ((r11 instanceof n) == false) goto L10;
        this.f18499j.add((n) r11);
    L10:
        r5 = r5 + 1;
    L12:
        return this.f18499j;
    }

    @Override // k.e
    public final void g(Canvas r10, Matrix r11, int r12) {
        if (this.g == false) goto L5;
        return;
    L5:
        Matrix r5 = this.f18496c;
        r5.set(r11);
        l.m r13 = this.f18500k;
        if (r13 == null) goto L12;
        r5.preConcat(r13.e());
        l.d r14 = r13.f19505j;
        if (r14 != null) goto L10;
        int r15 = 100;
    L11:
        r12 = (int) ((((r15 / 100.0f) * r12) / 255.0f) * 255.0f);
        goto L12
    L10:
        r15 = ((Integer) r14.f()).intValue();
    L12:
        boolean r16 = this.f18498i.f1350p;
        ArrayList r17 = this.f18497h;
        boolean r18 = false;
        if (r16 == false) goto L24;
        int r19 = 0;
        int r20 = 0;
    L16:
        if (r19 >= r17.size()) goto L24;
        if ((r17.get(r19) instanceof e) == false) goto L23;
        r20 = r20 + 1;
        if (r20 < 2) goto L23;
        if (r12 == 255) goto L24;
        r18 = true;
    L23:
        r19 = r19 + 1;
    L24:
        if (r18 == false) goto L26;
        RectF r21 = this.f18495b;
        r21.set(0.0f, 0.0f, 0.0f, 0.0f);
        e(r21, r5, true);
        j.a r22 = this.f18494a;
        r22.setAlpha(r12);
        u.f.e(r10, r21, r22);
    L26:
        if (r18 == false) goto L28;
        r12 = 255;
    L28:
        int r23 = r17.size() - 1;
    L29:
        if (r23 < 0) goto L34;
        Object r24 = r17.get(r23);
        if ((r24 instanceof e) == false) goto L33;
        ((e) r24).g(r10, r5, r12);
    L33:
        r23 = r23 - 1;
        goto L29
    L34:
        if (r18 == false) goto L44;
        r10.restore();
        return;
    }

    @Override // k.c
    public final String getName() {
        throw null;
    }

    @Override // k.n
    public final Path getPath() {
        Matrix r5 = this.f18496c;
        r5.reset();
        l.m r10 = this.f18500k;
        if (r10 == null) goto L5;
        r5.set(r10.e());
    L5:
        Path r11 = this.d;
        r11.reset();
        if (this.g == false) goto L8;
        return r11;
    L8:
        ArrayList r12 = this.f18497h;
        int r13 = r12.size() - 1;
    L9:
        if (r13 < 0) goto L14;
        c r14 = (c) r12.get(r13);
        if ((r14 instanceof n) == false) goto L13;
        r11.addPath(((n) r14).getPath(), r5);
    L13:
        r13 = r13 - 1;
        goto L9
    L14:
        return r11;
    }

    public d(w r5, r.c r10, String r11, boolean r12, ArrayList r13, p.d r14) {
        this.f18494a = new j.a();
        this.f18495b = new RectF();
        this.f18496c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = r11;
        this.f18498i = r5;
        this.g = r12;
        this.f18497h = r13;
        if (r14 == null) goto L5;
        l.m r15 = new l.m(r14);
        this.f18500k = r15;
        r15.a(r10);
        r15.b(this);
    L5:
        ArrayList r16 = new ArrayList();
        int r17 = r13.size() - 1;
    L6:
        if (r17 < 0) goto L11;
        c r18 = (c) r13.get(r17);
        if ((r18 instanceof j) == false) goto L10;
        r16.add((j) r18);
    L10:
        r17 = r17 - 1;
        goto L6
    L11:
        int r19 = r16.size() - 1;
    L12:
        if (r19 < 0) goto L14;
        ((j) r16.get(r19)).f(r13.listIterator(r13.size()));
        r19 = r19 - 1;
        goto L12
    }
}
