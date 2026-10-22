package e8;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final ConcurrentHashMap<String, d8.b> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static d8.b a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "bizKey");
        ConcurrentHashMap<String, d8.b> r0 = a;
        d8.b r10 = r0.get(r1);
        if (r10 != null) goto L6;
        d8.b r11 = r0.get("host");
        Intrinsics.checkNotNull(r11);
        return r11;
    L6:
        return r10;
    }
}
