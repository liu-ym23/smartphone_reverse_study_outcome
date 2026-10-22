package byb;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b implements d {
    public b() {
    }

    public static void b(HashMap r2, HashMap r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 != null) goto L5;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        if ((!r3.isEmpty()) == false) goto L13;
        r0.putAll(r3);
        return;
    L13:
        return;
    L5:
        if ((!r2.isEmpty()) == false) goto L7;
        r0.putAll(r2);
        goto L7
    }

    @Override // byb.d
    public final void a(String r1, HashMap<String, Object> r2, HashMap<String, Object> r3) {
        b(r2, r3);
    }
}
