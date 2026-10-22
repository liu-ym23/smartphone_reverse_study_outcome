package b8a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g extends l {
    public final long e;
    public final HashMap<String, h> f;

    public g(HashMap<String, Object> r5) {
        super(r5);
        this.e = m.c(r5, -1L).longValue();
        if (r5.get("detail") == null) goto L5;
        HashMap r6 = (HashMap) r5.get("detail");
    L6:
        this.f = new HashMap();
        Iterator r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) r7.next();
        HashMap<String, h> r1 = this.f;
        Object r2 = r0.getKey();
        String r3 = (String) r2;
        r1.put(r3, new h((HashMap) r0.getValue()));
        goto L8
    L10:
        return;
    L5:
        r6 = new HashMap();
        goto L6
    }
}
