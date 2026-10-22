package c2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3291b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f3292m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f3293n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f3294o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f3295p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3296q;

    public j(long r8, long r10, String r11, String r12, String r13, int r14, JSONObject r15) {
        this.f3290a = r8;
        this.f3291b = r10;
        this.f3292m = r11;
        this.f3293n = r12;
        this.f3294o = r13;
        this.f3295p = r14;
        this.f3296q = r15;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r12 = new o2.a("api_error", this.f3290a, this.f3291b, this.f3292m, this.f3293n, this.f3294o, this.f3295p, this.f3296q).c();
        if (r12 == null) goto L6;
        e.f("monitorApiError", r12.toString());
        return;
    }
}
