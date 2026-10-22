package d58;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final a d = null;
    public final long a;
    public final long b;
    public final long c;

    /* JADX INFO: renamed from: d58.a$a, reason: collision with other inner class name */
    public static final class C0099a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        return r2 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "AsrDurationConfig(handsfreeMaxMs=" + this.a + ", longPressMaxMs=" + this.b + ", longPressMinMs=" + this.c + ')';
    }

    static {
        d = new a(0);
    }

    public /* synthetic */ a(int r8) {
        this(0, 0, 500);
    }

    public a(long r1, long r3, long r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }
}
