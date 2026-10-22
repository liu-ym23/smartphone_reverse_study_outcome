package c2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3284b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f3286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f3287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f3288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3289q;

    public i(long r8, long r10, String r11, String r12, String r13, int r14, JSONObject r15) {
        this.f3283a = r8;
        this.f3284b = r10;
        this.f3285m = r11;
        this.f3286n = r12;
        this.f3287o = r13;
        this.f3288p = r14;
        this.f3289q = r15;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n2.b.a.f9429a.d(new o2.a("api_error", this.f3283a, this.f3284b, this.f3285m, this.f3286n, this.f3287o, this.f3288p, l6.a.E(this.f3289q)));
    }
}
