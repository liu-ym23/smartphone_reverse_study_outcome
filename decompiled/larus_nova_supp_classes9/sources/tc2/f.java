package tc2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements nf6.a {
    public final Float a;
    public final Integer b;
    public final Boolean c;
    public final Integer d;
    public final int e;

    public f() {
        this(null, null, null, null, 0, 31);
    }

    public f(Float r3, Integer r4, Boolean r5, Integer r6, int r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = Float.valueOf(1.0f);
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = Boolean.FALSE;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = -1;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = 0;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
