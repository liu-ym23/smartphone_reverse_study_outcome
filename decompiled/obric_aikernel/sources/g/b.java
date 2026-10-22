package g;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f8905g;

    public b(String r10, long r11) {
        this.f8899a = r10;
        this.f8900b = r11;
    }

    public boolean a() {
        if (this.f8900b > 0) goto L5;
    L11:
        return false;
    L5:
        if (this.f8901c <= 0) goto L11;
        if (this.f8902d <= 0) goto L11;
        if (this.f8903e <= 0) goto L11;
        return true;
    }
}
