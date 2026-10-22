package p6;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l extends o6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m6.g f12347b;

    public l() {
    }

    @Override // o6.a
    public String f() {
        return "patch";
    }

    @Override // o6.a
    public boolean g(n6.a r10) {
        JSONObject r11 = new JSONObject(r10.c());
        if (this.f12347b != null) goto L7;
        return false;
    L7:
        if (e(r11, r10) == false) goto L9;
        return true;
    L9:
        String r12 = r11.optString("url");
        String r13 = r11.optString("md5");
        this.f12347b.a(r12, r13);
        n6.b r14 = this.f12347b.c();
        if (r14.d() == false) goto L12;
        l(r10);
    L13:
        return true;
    L12:
        j(r14.b(), r14.c(), r10);
        goto L13
    }

    public void m(m6.g r10) {
        this.f12347b = r10;
    }
}
