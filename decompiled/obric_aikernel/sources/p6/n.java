package p6;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n extends o6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m6.h f12349b;

    public n() {
    }

    @Override // o6.a
    public String f() {
        return "plugin";
    }

    @Override // o6.a
    public boolean g(n6.a r10) {
        JSONObject r11 = new JSONObject(r10.c());
        if (this.f12349b != null) goto L5;
        return false;
    L5:
        String r12 = r11.optString("packageName");
        int r13 = r11.optInt("versionCode");
        String r14 = r11.optString("url");
        String r15 = r11.optString("md5");
        boolean r16 = r11.optBoolean("wifiOnly", false);
        this.f12349b.f(r12, r13, r14, r15, r16);
        n6.b r17 = this.f12349b.c();
        if (r17.d() == false) goto L8;
        l(r10);
        return true;
    L8:
        j(r17.b(), r17.c(), r10);
        return true;
    }

    public void m(m6.h r10) {
        this.f12349b = r10;
    }
}
