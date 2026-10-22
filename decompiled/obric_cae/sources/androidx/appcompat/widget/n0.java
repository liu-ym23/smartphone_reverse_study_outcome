package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1229h;

    public n0() {
        this.f1222a = 0;
        this.f1223b = 0;
        this.f1224c = Integer.MIN_VALUE;
        this.f1225d = Integer.MIN_VALUE;
        this.f1226e = 0;
        this.f1227f = 0;
        this.f1228g = false;
        this.f1229h = false;
    }

    public final void a(int r8, int r10) {
        this.f1224c = r8;
        this.f1225d = r10;
        this.f1229h = true;
        if (this.f1228g == false) goto L8;
        if (r10 == Integer.MIN_VALUE) goto L6;
        this.f1222a = r10;
    L6:
        if (r8 == Integer.MIN_VALUE) goto L13;
        this.f1223b = r8;
        return;
    L13:
        return;
    L8:
        if (r8 == Integer.MIN_VALUE) goto L10;
        this.f1222a = r8;
    L10:
        if (r10 == Integer.MIN_VALUE) goto L15;
        this.f1223b = r10;
        return;
    }
}
