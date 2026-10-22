package x7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f13622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f13623b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f13624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f13625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f13626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f13627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ JSONObject f13628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ m f13629r;

    public k(m r8, long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
        this.f13629r = r8;
        this.f13622a = r10;
        this.f13623b = r11;
        this.f13624m = r12;
        this.f13625n = r13;
        this.f13626o = r14;
        this.f13627p = r15;
        this.f13628q = r16;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r10 = this.f13629r;
        long r8 = this.f13622a;
        long r11 = this.f13623b;
        String r12 = this.f13624m;
        String r13 = this.f13625n;
        String r14 = this.f13626o;
        int r15 = this.f13627p;
        JSONObject r16 = this.f13628q;
        if (r10.f13650m != 1) goto L5;
        return;
    L5:
        if (m.q(r12, r10.f13652o, r10.f13653p) == true) goto L19;
        JSONObject r17 = r10.t(r15, r8, r11, "api_error", r12, r13, r14);
        m.m(r17, r16);
        if (r17 != null) goto L10;
        return;
    L10:
        if (r17.length() <= 0) goto L17;
        q7.d r18 = r10.f13640c;
        if (r18 == null) goto L18;
        r18.b(r17, "api_error", "api_error");
        return;
    L18:
        return;
    L17:
        return;
    }
}
