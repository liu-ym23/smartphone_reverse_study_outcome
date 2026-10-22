package l0;

/* JADX INFO: loaded from: classes.dex */
public class i implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10820c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10824j;

    public i(String r10, long r11, String r12) {
        this.f10820c = r10;
        this.f10822h = r11;
        this.f10824j = System.currentTimeMillis();
        this.f10823i = 1;
        this.f10821g = r12;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r10) {
        long r11 = this.f10822h;
        long r12 = ((i) r10).f10822h;
        if (r11 != r12) goto L7;
        return 0;
    L7:
        if (r11 <= r12) goto L10;
        return 1;
    L10:
        return -1;
    }
}
