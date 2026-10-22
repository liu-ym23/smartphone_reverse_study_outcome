package ms.bd.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class p2 {
    public static native Object a(int r0, int r1, long r2, String r4, Object r5);

    public p2() {
    }

    public static Object b(int r0, int r1, long r2, String r4, Object r5) {
        return i2.a(r0, r1, r2, r4, r5);
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }
}
