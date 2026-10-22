package mf6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public boolean a;
    public float b;
    public final long c;

    public void c() {
    }

    public void e() {
        this.a = true;
    }

    public boolean b() {
        return this.a;
    }

    public a(long r1) {
        this.c = r1;
    }

    public void a(float r6) {
        if (this.c != 0) goto L5;
        return;
    L5:
        if (b() == true) goto L13;
        float r0 = this.b + Math.min(r6, this.c - this.b);
        this.b = r0;
        d(r0 / this.c);
        if (this.b < this.c) goto L12;
        e();
        c();
        return;
    L12:
        return;
    }

    public void d(float r1) {
        b();
    }
}
