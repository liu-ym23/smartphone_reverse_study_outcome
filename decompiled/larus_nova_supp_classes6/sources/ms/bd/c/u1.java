package ms.bd.c;

import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class u1 implements Cloneable {
    public long a;
    public long b;
    public long c;
    public long d;
    public final t1 e;
    public long f;

    static {
        String r0 = (String) p2.a(16777217, 0, 0, "ce6a42", new byte[0]);
    }

    public final String toString() {
        this.e.getClass();
        Locale r0 = Locale.US;
        String r1 = (String) p2.a(16777217, 0, 0, "607e6f", new byte[]{98, 54, 8, 84, 13, 61, 112, 21, 42, 112, 35, 126, 1, 2});
        Long r2 = Long.valueOf(this.a);
        Long r3 = Long.valueOf(this.b);
        Long r4 = Long.valueOf(this.c);
        long r5 = this.d;
        long r7 = 0;
        if (r5 == 0) goto L7;
        r7 = this.f - r5;
    L7:
        return String.format(r0, r1, new Object[]{r2, r3, r4, Long.valueOf(r7), this.e});
    }

    public u1() {
        this.e = new t1();
    }

    public final u1 a() {
        return (u1) super.clone();
    L5:
        throw new AssertionError();
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }
}
