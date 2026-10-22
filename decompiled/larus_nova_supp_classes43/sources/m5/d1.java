package m5;

import android.util.LruCache;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d1 {
    public static final z0 a(Map<String, z0> r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        z0 r0 = r1.get(r10);
        if (r0 != null) goto L6;
        z0 r11 = new z0();
        r1.put(r10, r11);
        return r11;
    L6:
        return r0;
    }

    public static final b1 b(Map<String, b1> r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        b1 r0 = r1.get(r10);
        if (r0 != null) goto L6;
        b1 r11 = new b1();
        r1.put(r10, r11);
        return r11;
    L6:
        return r0;
    }

    public static final h1 c(LruCache<String, h1> r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        h1 r0 = r1.get(r10);
        if (r0 != null) goto L6;
        h1 r11 = new h1();
        r1.put(r10, r11);
        return r11;
    L6:
        return r0;
    }

    public static final h1 d(Map<String, h1> r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r10, "traceId");
        h1 r0 = r1.get(r10);
        if (r0 != null) goto L6;
        h1 r11 = new h1();
        r1.put(r10, r11);
        return r11;
    L6:
        return r0;
    }
}
