package w38;

import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static void a(String r3) {
        SaasTracking r0 = SaasTracking.a;
        JSONObject r1 = new JSONObject();
        r1.put("path", r3);
        Unit r4 = Unit.INSTANCE;
        r0.reportEvent("doubao_account_network_request", r1);
    }

    public static void b(String r4, b r5) {
        b.C0134b r1 = null;
        if ((r5 instanceof b.a) == false) goto L5;
        b.a r0 = (b.a) r5;
    L6:
        if (r0 == null) goto L8;
        r1 = r0.a;
    L8:
        SaasTracking r2 = SaasTracking.a;
        JSONObject r3 = new JSONObject();
        r3.put("path", r4);
        r3.put("success", r5 instanceof b.d ? 1 : 0);
        if (r1 == null) goto L11;
        r3.put("err_code", r1.a);
        r3.put("err_msg", r1.b);
    L11:
        Unit r6 = Unit.INSTANCE;
        r2.reportEvent("doubao_account_network_result", r3);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
