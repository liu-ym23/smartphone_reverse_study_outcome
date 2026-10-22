package m3;

import com.bytedance.lego.init.model.InitPeriod;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g implements Comparable<g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11028c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f11031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f11034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f11035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f11036n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f11037o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<String> f11038p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile InitPeriod f11039q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f11040r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f11041s;

    public g() {
        this.f11035m = 0.0f;
    }

    public g(String r10, boolean r11, boolean r12, float r13, List<String> r14, List<String> r15, List<String> r16, List<String> r17, String r18, InitPeriod r19) {
        this.f11035m = 0.0f;
        this.f11028c = r10;
        this.f11032j = r11;
        this.f11034l = r14;
        this.f11035m = r13;
        this.f11036n = r15;
        this.f11037o = r16;
        this.f11038p = r17;
        this.f11030h = r18;
        this.f11039q = r19;
        this.f11033k = r12;
    }

    public int a(g r10) {
        float r11 = r10.f11035m - this.f11035m;
        if (r11 <= 0.0f) goto L7;
        return 1;
    L7:
        if (r11 >= 0.0f) goto L11;
        return -1;
    L11:
        return this.f11030h.compareTo(r10.f11030h);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(g r10) {
        return a(r10);
    }

    public String toString() {
        return this.f11035m + "," + this.f11028c + "," + this.f11032j;
    }
}
