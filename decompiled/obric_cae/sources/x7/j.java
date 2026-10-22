package x7;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f13614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f13615b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f13616m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f13617n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f13618o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f13619p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ JSONObject f13620q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ m f13621r;

    public j(m r8, long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
        this.f13621r = r8;
        this.f13614a = r10;
        this.f13615b = r11;
        this.f13616m = r12;
        this.f13617n = r13;
        this.f13618o = r14;
        this.f13619p = r15;
        this.f13620q = r16;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r10 = this.f13621r;
        long r8 = this.f13614a;
        long r11 = this.f13615b;
        String r12 = this.f13616m;
        String r13 = this.f13617n;
        String r14 = this.f13618o;
        int r15 = this.f13619p;
        JSONObject r16 = this.f13620q;
        if (m.q(r12, r10.f13652o, r10.f13653p) == false) goto L5;
        return;
    L5:
        if (e.d(r10.f13638a) == false) goto L20;
        JSONObject r17 = r10.t(r15, r8, r11, "api_all", r12, r13, r14);
        m.m(r17, r16);
        if (r17 == null) goto L12;
        if (m.q(r12, r10.f13654q, r10.f13655r) == false) goto L12;
    L16:
        r17.put("hit_rules", 1);     // Catch: JSONException -> L15
        r10.f13640c.b(r17, "api_all", "api_all");     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L12:
        if (r10.f13651n != 0) goto L16;
        return;
    }
}
