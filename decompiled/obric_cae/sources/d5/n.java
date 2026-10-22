package d5;

import org.json.JSONObject;
import x4.j0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class n extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f6821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x4.s f6822f;

    public n(x4.s r8, j0 r10) {
        super(false, true);
        this.f6821e = r10;
        this.f6822f = r8;
    }

    @Override // d5.d
    public final boolean a(JSONObject r8) {
        k5.k.a r10 = k5.k.f8943a;
        j0 r11 = this.f6821e;
        x0.h(r8, "carrier", r11.H.f7907c.I.getNetworkOperatorName());
        x0.h(r8, "mcc_mnc", r11.H.f7907c.I.getNetworkOperator());
        i5.a r12 = (i5.a) i5.d.a(i5.a.class, String.valueOf(r11.f13463a));
        x0.h(r8, "clientudid", r12.b());
        if (this.f6822f.f13378a == true) goto L7;
        x0.h(r8, "openudid", r12.getOpenUdid());
        return true;
    L7:
        return true;
    }

    @Override // d5.d
    public final void b(JSONObject r8) {
        r8.remove("carrier");
        r8.remove("mcc_mnc");
        r8.remove("clientudid");
        r8.remove("openudid");
    }
}
