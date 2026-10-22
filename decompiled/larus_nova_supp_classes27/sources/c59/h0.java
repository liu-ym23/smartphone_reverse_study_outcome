package c59;

import com.bytedance.keva.Keva;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0 {
    public static final ConcurrentHashMap<String, String> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        g49.d.a("DslUrlRepo", "save dsl url ");
        Iterator r6 = r5.entrySet().iterator();
        boolean r0 = false;
    L4:
        if (r6.hasNext() == false) goto L16;
        Map.Entry r1 = (Map.Entry) r6.next();
        ConcurrentHashMap<String, String> r2 = a;
        if (Intrinsics.areEqual(r2.get(r1.getKey()), r1.getValue()) == true) goto L11;
        if (r1.getValue() == null) goto L11;
        r0 = true;
    L11:
        if (r1.getValue() == null) goto L4;
        Object r3 = r1.getKey();
        String r4 = (String) r1.getValue();
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        r2.put((String) r3, r4);
        goto L4
    L16:
        if (r0 == false) goto L26;
        Lazy r7 = s.a;
        String r8 = s.d(a);
        if (r8 == null) goto L27;
        Keva r9 = g49.c.a;
        Intrinsics.checkNotNullParameter(r8, "value");
        g49.c.a.storeString("key_dora_kv_starling", r8);
        return;
    L27:
        return;
    }
}
