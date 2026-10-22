package mx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final int a;
    public final float b;
    public final float c;

    public e() {
        this(0.0f, 7);
    }

    public e(float r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        int r0 = 2131108573;
    L7:
        if ((r5 & 2) == 0) goto L9;
        float r1 = 0.5f;
    L11:
        if ((r5 & 4) == 0) goto L13;
        r4 = 0.0f;
    L13:
        this.a = r0;
        this.b = r1;
        this.c = r4;
        return;
    L9:
        r1 = 0.0f;
        goto L11
    L5:
        r0 = 0;
        goto L7
    }
}
