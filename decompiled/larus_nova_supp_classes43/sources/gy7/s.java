package gy7;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s {
    public static final Map<q, q> a = null;

    static {
        LinkedHashMap r0 = new LinkedHashMap();
        q r1 = r.a;
        r0.put(r1, r1);
        a = r0;
    }

    public static q a(q r1) {
        Intrinsics.checkNotNullParameter(r1, "userSession");
        return (q) ((LinkedHashMap) a).get(r1);
    }
}
