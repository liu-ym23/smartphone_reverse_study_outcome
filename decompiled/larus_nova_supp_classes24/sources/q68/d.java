package q68;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.a0;
import ouc.d0;
import ouc.e0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static final d0 c(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        Map.Entry<String, ? extends Object> r1 = r5.next();
        Object r2 = r1.getValue();
        if (r2 != null) goto L9;
        a0 r3 = a0.INSTANCE;
    L18:
        String r6 = r1.getKey();
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r3, "element");
        i r7 = (i) r0.put(r6, r3);
        goto L4
    L9:
        if ((r2 instanceof i) == false) goto L12;
        r3 = (i) r2;
        goto L18
    L12:
        if ((r2 instanceof Boolean) == false) goto L15;
        r3 = k.a((Boolean) r2);
        goto L18
    L15:
        if ((r2 instanceof Number) == false) goto L17;
        r3 = k.b((Number) r2);
        goto L18
    L17:
        r3 = k.c(r2.toString());
        goto L18
    L20:
        return new d0(r0);
    }

    public static final d0 a(d0 r6, d0 r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r7 != null) goto L5;
        return r6;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = r6.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) r1.next();
        if (StringsKt.isBlank(r2) == true) goto L7;
        i r5 = (i) r6.get(r2);
        if (r5 == null) goto L7;
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r5, "element");
        i r3 = (i) r0.put(r2, r5);
        goto L7
    L14:
        Iterator r8 = r7.keySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L24;
        String r4 = (String) r8.next();
        if (StringsKt.isBlank(r4) == true) goto L16;
        i r9 = (i) r7.get(r4);
        if (r9 == null) goto L16;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r9, "element");
        i r10 = (i) r0.put(r4, r9);
        goto L16
    L24:
        return new d0(r0);
    }

    public static final void b(e0 r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r1.b(r2, k.c(r3));
    }
}
