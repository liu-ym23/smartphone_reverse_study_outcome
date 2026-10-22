package n4a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 extends d0 {
    public c0(e0 r1) {
        super(r1);
    }

    @Override // n4a.d0
    public final byte[] a(byte[] r1) {
        String r2 = y4.g(r1);     // Catch: Throwable -> L4
    L7:
        return f5.j(r2);
    L4:
        th = move-exception;
        th.printStackTrace();
        r2 = null;
        goto L7
    }
}
