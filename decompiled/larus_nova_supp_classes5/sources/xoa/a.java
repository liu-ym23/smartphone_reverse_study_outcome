package xoa;

import com.bytedance.services.apm.api.EnsureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static b a;

    static {
    }

    public static void a(Throwable r4, String r5, Map r6) {
        apa.a.c("AzerothPrivacyError", r5, r4);
        if (a != null) goto L6;
        return;
    L6:
        if (fpa.b.b(r4) == false) goto L8;
        return;
    L8:
        Map r0 = fpa.b.a(r4);
        if (r0 == null) goto L18;
        if (r6 != null) goto L12;
        r6 = r0;
        goto L18
    L12:
        Iterator r1 = r0.entrySet().iterator();
    L14:
        if (r1.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) r1.next();
        HashMap r3 = (HashMap) r6;
        if (r3.get(r2.getKey()) != null) goto L14;
        r3.put(r2.getKey(), r2.getValue());
    L18:
        if (r6 != null) goto L20;
        r6 = fpa.a.a();
    L20:
        a.getClass();
        EnsureManager.ensureNotReachHere(r4, r5, r6);
    }
}
