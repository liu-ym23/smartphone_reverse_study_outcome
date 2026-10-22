package k7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final <K, V> Map<K, V> a(Map<K, ? extends V> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<K, ? extends V>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry<K, ? extends V> r1 = r11.next();
        V r12 = r1.getValue();
        if (r12 == null) goto L4;
        r0.put(r1.getKey(), r12);
        goto L4
    L8:
        return r0;
    }
}
