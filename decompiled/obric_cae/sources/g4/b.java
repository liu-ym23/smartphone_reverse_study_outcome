package g4;

import android.os.Handler;
import android.util.Base64;
import c4.g;
import c4.m;
import j4.c;
import org.json.JSONException;
import org.json.JSONObject;
import x4.s0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f7634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f7639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f7640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f7641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f7642l;

    public b(c r8, String r10, String r11) {
        this.f7641k = r8;
        this.f7632b = r10;
        this.f7633c = r11;
        this.f7634d = System.currentTimeMillis();
    }

    @Override // g4.a
    public final void a() {
        this.f7636f = true;
    }

    @Override // g4.a
    public final void b(Throwable r8) {
        StringBuilder r10 = new StringBuilder();
        if ((r8 instanceof s0) == false) goto L9;
        s0 r11 = (s0) r8;
        this.f7638h = r11.f13548a;
        r10.append("rhe:");
        r10.append(r11.getMessage());
        r8 = r8.getCause();
        if (r8 != null) goto L7;
    L11:
        this.f7640j = r10.toString();
        return;
    L7:
        if (r8.getMessage() == null) goto L11;
        this.f7640j = r8.getMessage();
        String r12 = ",cause:";
    L10:
        r10.append(r12);
        r10.append(r8.getMessage());
        goto L11
    L9:
        r12 = "e:";
        goto L10
    }

    @Override // g4.a
    public final void c(String r8) {
        if (r8 == null) goto L5;
        this.f7639i = r8.length();
        return;
    }

    @Override // g4.a
    public final void d(int r8) {
        this.f7637g = r8;
    }

    @Override // g4.a
    public final void e(byte[] r8) {
        if (r8 == null) goto L5;
        this.f7635e = r8.length;
        this.f7642l = r8;
        return;
    }

    @Override // g4.a
    public final void end() {
        long r16 = System.currentTimeMillis() - this.f7634d;
        JSONObject r15 = new JSONObject();
        byte[] r8 = this.f7642l;
        if (r8 != null) goto L5;
    L10:
        String r13 = this.f7632b;
        String r11 = this.f7633c;
        long r10 = this.f7635e;
        boolean r12 = this.f7636f;
        int r14 = this.f7637g;
        int r17 = this.f7638h;
        long r18 = this.f7639i;
        String r19 = this.f7640j;
        c r20 = this.f7641k;
        if (r20.f8605a == false) goto L19;
        g r21 = m.u();
        Object[] r22 = {r13, r11, Long.valueOf(r10), Boolean.valueOf(r12), Integer.valueOf(r14), Integer.valueOf(r17), Long.valueOf(r18), r19, Long.valueOf(r16), r15};
        r21.l(8, c.f8604p, "onRequestFinished {} -> {}, {}, {}, {}, {}, {}, {}, {}", r22);
        c.a r23 = new c.a(r13, r11, r10, r12, r14, r17, r18, r19, r16, r15);
        Handler r24 = r20.f8606b;
        if (r24 == null) goto L16;
        r24.sendMessage(r24.obtainMessage(16, r23));
        goto L19
    L16:
        r20.f8607m.put(r13, r23);
        Handler r25 = r20.f8606b;
        if (r25 == null) goto L19;
        r25.removeMessages(8);
        r20.f8606b.sendEmptyMessageDelayed(8, 500);
    L19:
        this.f7642l = null;
        return;
    L5:
        if ("error data".equalsIgnoreCase(this.f7640j) == true) goto L22;
        if ("emptydata".equalsIgnoreCase(this.f7640j) == false) goto L10;
    L22:
        r15.put("req_body_first_100bytes", Base64.encodeToString(r8, 0, Math.min(r8.length, 100), 0));     // Catch: JSONException -> L21
        goto L10
    }

    @Override // g4.a
    public final void f(String r8) {
        this.f7640j = r8;
    }
}
