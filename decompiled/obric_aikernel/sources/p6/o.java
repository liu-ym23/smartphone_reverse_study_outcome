package p6;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o extends o6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m6.i f12350b;

    public o() {
        this.f12350b = null;
    }

    @Override // o6.a
    public String f() {
        return "route";
    }

    @Override // o6.a
    public boolean g(n6.a r10) {
        String r11 = new JSONObject(r10.c()).optString("schema");
        if (TextUtils.isEmpty(r11) == false) goto L6;
        k("路由scheme为空", r10);
        return true;
    L6:
        m6.i r12 = this.f12350b;
        if (r12 == null) goto L13;
        r12.d(r11);
        n6.b r13 = this.f12350b.c();
        if (r13.d() == false) goto L11;
        l(r10);
    L12:
        return true;
    L11:
        j(r13.b(), r13.c(), r10);
        goto L12
    L13:
        return false;
    }

    public void m(m6.i r10) {
        this.f12350b = r10;
    }
}
