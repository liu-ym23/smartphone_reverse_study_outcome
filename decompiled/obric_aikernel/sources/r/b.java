package r;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f12510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StackTraceElement[] f12513d;

    public b() {
    }

    String a() {
        StringBuilder r10 = new StringBuilder();
        int r11 = 9;
    L4:
        if (r11 >= this.f12513d.length) goto L7;
        r10.append("\tat ");
        r10.append(this.f12513d[r11].toString());
        r10.append("\n");
        r11 = r11 + 1;
        goto L4
    L7:
        return r10.toString();
    }
}
