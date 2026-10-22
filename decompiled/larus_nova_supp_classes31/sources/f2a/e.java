package f2a;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final Map<f, Object> a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.length() == 0) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r4.keys();
    L8:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        Intrinsics.checkNotNull(r2);
        r0.put(new f(r2), r4.get(r2));
        goto L8
    L10:
        return r0;
    L5:
        return MapsKt.emptyMap();
    }
}
