package do1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;

    public a() {
        int r0 = 0;
        this(r0, r0, 7, r0);
    }

    public a(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public /* synthetic */ a(int r3, int r4, int r5, int r6) {
        if ((r5 & 1) == 0) goto L5;
        int r7 = -1;
    L7:
        if ((r5 & 2) == 0) goto L10;
        r3 = -2;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = -1;
    L12:
        this(r7, r3, r4);
        return;
    L5:
        r7 = 0;
        goto L7
    }
}
