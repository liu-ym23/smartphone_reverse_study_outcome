package bytekn.foundation.io.file;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class j extends e {
    public long b;
    public final e c;

    public final void a() {
        this.c.a();
    }

    public final void close() {
        this.c.close();
    }

    public j(e r1) {
        this.c = r1;
    }

    public final void b(byte[] r3, int r4) {
        this.c.b(r3, r4);
        this.b += (long) r4;
    }
}
