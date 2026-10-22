package gt8;

import android.graphics.PointF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements b0.b {
    public final /* synthetic */ d a;

    @Override // gt8.b0.b
    public final void b() {
    }

    @Override // gt8.b0.b
    public final void c() {
    }

    @Override // gt8.b0.b
    public final void d() {
    }

    @Override // gt8.b0.b
    public final void f() {
    }

    @Override // gt8.b0.b
    public final void g() {
    }

    @Override // gt8.b0.b
    public final void onTransformStart() {
    }

    @Override // gt8.b0.b
    public final void a() {
        d r0 = this.a;
        if (r0.i.a(r0.b.a(), this.a.c) == true) goto L6;
        this.a.d.b();
        return;
    }

    public c(d r1) {
        this.a = r1;
    }

    @Override // gt8.b0.b
    public final void e(PointF r6, float r7, float r8, float r9) {
        if (r6 == null) goto L10;
        int r0 = ht8.d.a;
        d r1 = this.a;
        float r2 = r1.m;
        float r3 = r1.l;
        float r4 = r1.b.e();
        float r5 = r4 * r7;
        Math.abs(r5 - r4);
        if (r5 <= r2) goto L7;
        r7 = r2 / r4;
    L9:
        this.a.b.c(r7, r7, r6.x, r6.y);
        goto L10
    L7:
        if (r5 >= r3) goto L9;
        r7 = r3 / r4;
    L10:
        this.a.b.c.offset(r8, r9);
        d r10 = this.a;
        r10.d.d(r10.b);
    }
}
