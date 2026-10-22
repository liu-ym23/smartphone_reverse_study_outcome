package qa;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l3 extends m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10792b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ m3 f10793m;

    public l3(m3 r8, int r10) {
        this.f10793m = r8;
        this.f10792b = r10;
    }

    @Override // qa.m1
    public final void a() {
        m3 r8 = this.f10793m;
        StringBuilder r10 = new StringBuilder("http://");
        r10.append(t4.n(s3.B));
        r10.append("?host=dualstack-a.apilocate.amap.com&query=");
        if (this.f10792b != 2) goto L5;
        int r11 = 6;
    L6:
        r10.append(r11);
        String r12 = r10.toString();
        n3 r13 = new n3();
        r13.f10860l = r12;
        r13.f10862n = r12;
        r13.f10805i = m0.a.f10810n;
        r13.b(m0.c.f10821a);
        h0.c();     // Catch: Throwable -> L27
        JSONObject r14 = new JSONObject(new String(h0.a(r13).f10842a));     // Catch: Throwable -> L27
        String[] r15 = m3.e(r14.optJSONArray("ips"), 1);     // Catch: Throwable -> L27
        if (r15.length > 0) goto L10;
    L12:
        String[] r16 = m3.e(r14.optJSONArray("ipsv6"), 2);     // Catch: Throwable -> L27
        if (r16.length <= 0) goto L18;
        if (m3.d(r16, r8.f(2).f11158a) == true) goto L18;
        r8.f(2).f11158a = r16;     // Catch: Throwable -> L27
        m3.h(r8, 2);     // Catch: Throwable -> L27
    L18:
        if (r14.has("ips") == true) goto L22;
        if (r14.has("ipsv6") == true) goto L22;
        return;
    L22:
        if (r14.has("ttl") == false) goto L38;
        int r17 = r14.getInt("ttl");     // Catch: Throwable -> L27
        if (r17 <= 30) goto L39;
        r8.f10832e = r17 * 1000;     // Catch: Throwable -> L27
        return;
    L39:
        return;
    L38:
        return;
    L10:
        if (m3.d(r15, r8.f(1).f11158a) == true) goto L12;
        r8.f(1).f11158a = r15;     // Catch: Throwable -> L27
        m3.h(r8, 1);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        JSONObject r18 = new JSONObject();
        r18.put("key", "dnsError");     // Catch: Throwable -> L32
        r18.put("reason", th.getMessage());     // Catch: Throwable -> L32
    L30:
        w3.j(r8.f10833f, "O018", r18);
        return;
    L5:
        r11 = 4;
        goto L6
    }
}
