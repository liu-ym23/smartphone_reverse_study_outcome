package x2a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q {
    public long a;
    public double b;
    public double c;

    public q() {
    }

    public final double b() {
        long r0 = this.a;
        if (r0 > 0) goto L7;
        return 0.0d;
    L7:
        return this.b / r0;
    }

    public final void a(double r5) {
        if (Double.isInfinite(r5) == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        if (r5 < 0.0d) goto L15;
        this.a++;
        this.b += r5;
        this.c = Math.max(this.c, r5);
        return;
    L15:
        return;
    L5:
        if (Double.isNaN(r5) == true) goto L7;
        r0 = true;
        goto L8
    }
}
