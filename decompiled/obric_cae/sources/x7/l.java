package x7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f13630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13631b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ JSONObject f13632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ JSONObject f13633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ JSONObject f13634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ JSONObject f13635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ long f13636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ m f13637r;

    public l(m r8, String r10, JSONObject r11, JSONObject r12, JSONObject r13, long r14) {
        this.f13637r = r8;
        this.f13630a = r10;
        this.f13631b = 0;
        this.f13632m = null;
        this.f13633n = r11;
        this.f13634o = r12;
        this.f13635p = r13;
        this.f13636q = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13637r.s(this.f13630a, this.f13631b, this.f13632m, this.f13633n, this.f13634o, this.f13635p, this.f13636q);
    }
}
