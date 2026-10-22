package w79;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    public a(boolean r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = true;
    L8:
        this.a = r3;
        this.b = false;
        this.c = r4;
    }
}
