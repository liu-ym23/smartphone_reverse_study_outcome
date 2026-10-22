package wu8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public volatile boolean a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;

    public b() {
    }

    public final boolean a() {
        if (this.a == false) goto L5;
    L8:
        return true;
    L5:
        if (b() == true) goto L8;
        return false;
    }

    public final boolean b() {
        if (this.b == false) goto L5;
    L16:
        return true;
    L5:
        if (this.c == true) goto L16;
        if (this.e == true) goto L16;
        if (this.f == true) goto L16;
        if (this.g == true) goto L16;
        if (this.h == true) goto L16;
        return false;
    }
}
