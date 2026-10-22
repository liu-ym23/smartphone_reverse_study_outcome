package os0;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final Map<String, String> a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.a = new HashMap();
    }

    public final void a(JSONObject r3) {
        Map<String, String> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        r1.put("ad_extra_data", r3.toString());
    }

    public final void b(Map r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        ((HashMap) this.a).putAll(r2);
        return;
    }
}
