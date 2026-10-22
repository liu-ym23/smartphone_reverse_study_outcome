package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public final long a;
    public final HashMap<String, String> b;

    public h(HashMap<String, Object> r3) {
        m.d(r3, "category");
        this.a = m.c(r3, -1L).longValue();
        if (r3.get("detail") == null) goto L5;
        HashMap<String, String> r4 = (HashMap) r3.get("detail");
    L6:
        this.b = r4;
        return;
    L5:
        r4 = new HashMap();
        goto L6
    }
}
