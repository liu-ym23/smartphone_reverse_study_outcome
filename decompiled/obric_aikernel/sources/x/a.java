package x;

import e0.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends w.a<w.b> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile a f13456m;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private b f13457l;

    private a() {
    }

    public static a p() {
        if (f13456m != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13456m != null) goto L9;
        f13456m = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f13456m;
    }

    @Override // w.a
    protected void f(w.b r10) {
        JSONObject r11 = r10.c();
        boolean r12 = r10.b(r11);
        if (com.bytedance.apm.d.D() == true) goto L16;
    L8:
        if (r12 == false) goto L10;
    L12:
        l(r10.e(), r10.a(), r11, r12, false);
        b r13 = this.f13457l;
        if (r13 == null) goto L18;
        r13.a(r10.e(), r10.a(), r11);
        return;
    L18:
        return;
    L10:
        if (r10.d() == true) goto L12;
        return;
    L16:
        e.e(e0.b.f8550d, new Object[]{"logType: " + r10.e() + ", subType: " + r10.a() + "data: " + r11, " ,sample: " + r12});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void q(b r10) {
        this.f13457l = r10;
    }
}
