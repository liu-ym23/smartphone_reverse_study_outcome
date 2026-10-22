package hq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s0 {
    public final Integer a;
    public final String b;

    public s0() {
        this(null, null);
    }

    public final boolean a() {
        Integer r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        if (r1 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = 0;
        goto L6
    }

    public s0(Integer r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
