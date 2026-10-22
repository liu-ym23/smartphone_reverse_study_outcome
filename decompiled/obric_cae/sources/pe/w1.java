package pe;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class w1<U, T extends U> extends ue.t<T> implements Runnable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f10083o;

    public w1(long r8, x1.a r10) {
        super(r10, r10.getContext());
        this.f10083o = r8;
    }

    @Override // pe.a, pe.j1
    public final String M() {
        return super.M() + "(timeMillis=" + this.f10083o + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 r8 = j0.b(this.f9991m);
        if ((r8 instanceof k0) == false) goto L5;
        k0 r10 = (k0) r8;
    L6:
        long r11 = this.f10083o;
        if (r10 == null) goto L19;
        int r12 = oe.a.f9785a;
        oe.c r13 = oe.c.f9788m;
        he.i.f(r13, "unit");
        oe.c r14 = oe.c.f9787b;
        he.i.f(r14, "sourceUnit");
        TimeUnit r15 = r14.f9790a;
        TimeUnit r16 = r13.f9790a;
        long r17 = r16.convert(4611686018426999999L, r15);
        long r18 = -r17;
        ke.f r19 = new ke.f(r18, r17);
        if (r18 <= r11) goto L11;
    L13:
        boolean r20 = false;
    L14:
        if (r20 == false) goto L16;
        r14.f9790a.convert(r11, r16);
        int r21 = oe.b.f9786a;
    L17:
        String r22 = r10.n();
        if (r22 == null) goto L19;
    L20:
        g(new v1(r22, this));
        return;
    L16:
        l6.a.y(r16.convert(r11, r16), -4611686018427387903L, 4611686018427387903L);
        int r23 = oe.b.f9786a;
        goto L17
    L11:
        if (r11 > r19.f9118b) goto L13;
        r20 = true;
    L19:
        r22 = "Timed out waiting for " + r11 + " ms";
        goto L20
    L5:
        r10 = null;
        goto L6
    }
}
