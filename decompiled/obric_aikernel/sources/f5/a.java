package f5;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Integer> f8855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8864l;

    public a() {
        this.f8853a = false;
        this.f8854b = true;
        this.f8855c = null;
        this.f8856d = 10;
        this.f8857e = 3;
        this.f8858f = 3;
        this.f8859g = 10;
        this.f8860h = 3;
        this.f8861i = 3;
        this.f8862j = 900;
        this.f8863k = 120;
        this.f8864l = null;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(" localEnable: ");
        r10.append(this.f8853a);
        r10.append(" probeEnable: ");
        r10.append(this.f8854b);
        r10.append(" hostFilter: ");
        Map<String, Integer> r11 = this.f8855c;
        if (r11 == null) goto L5;
        int r12 = r11.size();
    L6:
        r10.append(r12);
        r10.append(" reqTo: ");
        r10.append(this.f8856d);
        r10.append("#");
        r10.append(this.f8857e);
        r10.append("#");
        r10.append(this.f8858f);
        r10.append(" reqErr: ");
        r10.append(this.f8859g);
        r10.append("#");
        r10.append(this.f8860h);
        r10.append("#");
        r10.append(this.f8861i);
        r10.append(" updateInterval: ");
        r10.append(this.f8862j);
        r10.append(" updateRandom: ");
        r10.append(this.f8863k);
        r10.append(" httpBlack: ");
        r10.append(this.f8864l);
        return r10.toString();
    L5:
        r12 = 0;
        goto L6
    }
}
