package n4a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class h1 {
    public final h1 a;

    public h1() {
    }

    public h1(h1 r1) {
        this.a = r1;
    }

    public void a() {
        h1 r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void b(int r2) {
        h1 r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public abstract boolean c();

    public int d() {
        h1 r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.d();
    L7:
        return Math.min(Integer.MAX_VALUE, r1);
    L5:
        r1 = Integer.MAX_VALUE;
        goto L7
    }

    public final boolean e() {
        h1 r0 = this.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.e();
    L6:
        if (r1 == true) goto L10;
        return false;
    L10:
        return c();
    L5:
        r1 = true;
        goto L6
    }
}
