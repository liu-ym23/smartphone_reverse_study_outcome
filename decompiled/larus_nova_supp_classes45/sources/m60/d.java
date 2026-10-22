package m60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final Map<String, List<o60.c>> a;

    public static final class a {
        public static final d a = null;

        static {
            a = new d();
        }
    }

    public d() {
        this.a = new HashMap();
    }

    public final List<o60.c> a(String r3) {
        List<o60.c> r0 = (List) ((HashMap) this.a).get(r3);
        if (r0 != null) goto L6;
        ArrayList r1 = new ArrayList();
        ((HashMap) this.a).put(r3, r1);
        return r1;
    L6:
        return r0;
    }
}
