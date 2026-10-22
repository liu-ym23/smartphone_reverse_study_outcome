package qa;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends d0 {
    public c0(a0 r8) {
        super(r8);
    }

    @Override // qa.d0
    public final byte[] a(byte[] r8) {
        String r10 = l4.g(r8);     // Catch: Throwable -> L4
    L7:
        return t4.i(r10);
    L4:
        th = move-exception;
        th.printStackTrace();
        r10 = null;
        goto L7
    }
}
