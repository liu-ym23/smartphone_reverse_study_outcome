package wp9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public final long a;
    public long b;

    public /* synthetic */ g() {
        this(16);
    }

    public final boolean a() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.b) < this.a) goto L6;
        this.b = r0;
        return true;
    L6:
        return false;
    }

    public g(long r1) {
        this.a = r1;
    }
}
