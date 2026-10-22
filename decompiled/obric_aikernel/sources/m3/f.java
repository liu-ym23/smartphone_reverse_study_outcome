package m3;

/* JADX INFO: loaded from: classes.dex */
public class f implements Comparable<f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11024c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f11027i;

    public int a(f r10) {
        if (r10 == null) goto L15;
        b r11 = this.f11027i;
        if (r11 == null) goto L17;
        int r12 = this.f11026h;
        int r13 = r10.f11026h;
        if (r12 <= r13) goto L10;
        return -1;
    L10:
        if (r12 >= r13) goto L14;
        return 1;
    L14:
        return r11.getClass().getSimpleName().compareTo(r10.f11027i.getClass().getSimpleName());
    L17:
        return 0;
    L15:
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(f r10) {
        return a(r10);
    }

    public String toString() {
        return "priority:" + this.f11026h + " taskClassName:" + this.f11027i.getClass().getSimpleName() + " mustRunInMainThread:" + this.f11025g;
    }
}
