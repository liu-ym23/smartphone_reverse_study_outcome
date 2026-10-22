package l5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z {
    public static void a(JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 == null) goto L11;
        Iterator<String> r0 = r11.keys();
    L6:
        if (r0.hasNext() == false) goto L17;
        String r1 = r0.next();
        if (r10.has(r1) == true) goto L6;
        r10.put(r1, r11.get(r1));
        goto L6
    L17:
        return;
    }

    public static final a0 b(Map<String, a0> r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        LinkedHashMap r11 = (LinkedHashMap) r1;
        a0 r0 = (a0) r11.get(r10);
        if (r0 != null) goto L6;
        a0 r12 = new a0();
        r11.put(r10, r12);
        return r12;
    L6:
        return r0;
    }
}
