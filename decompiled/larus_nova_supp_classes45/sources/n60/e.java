package n60;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements d {
    public Map<String, d> a;
    public c b;

    public static final class a {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public e() {
        HashMap r0 = new HashMap();
        this.a = r0;
        r0.put("android.permission.CAMERA", new b());
        Map<String, d> r1 = this.a;
        HashMap r2 = (HashMap) r1;
        r2.put("android.permission.RECORD_AUDIO", new n60.a());
        this.b = new c();
    }

    @Override // n60.d
    public final boolean a(Context r2, String r3) {
        if (((HashMap) this.a).containsKey(r3) == false) goto L6;
        return ((d) ((HashMap) this.a).get(r3)).a(r2, r3);
    L6:
        return this.b.a(r2, r3);
    }

    public final boolean b(Context r5, String[] r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (a(r5, r6[r2]) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
