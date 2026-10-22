package c61;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final Map<String, Object> a;
    public final String b;

    public final a a() {
        String r0 = this.b;
        HashMap r1 = (HashMap) this.a;
        LinkedHashMap r2 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
        Iterator r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) r3.next();
        Object r5 = r4.getKey();
        Object r6 = r4.getValue();
        if (r6 == null) goto L9;
        String r7 = r6.toString();
        if (r7 == null) goto L9;
    L10:
        r2.put(r5, r7);
    L9:
        r7 = "";
        goto L10
    L12:
        return new a(r0, r2);
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        this.b = r2;
        this.a = new HashMap();
    }

    public final void b(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        ((HashMap) this.a).put(r2, r3);
    }
}
