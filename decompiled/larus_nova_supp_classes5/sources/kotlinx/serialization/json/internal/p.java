package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p {
    public final Map<f, Map<a<Object>, Object>> a;

    public static final class a<T> {
        public a() {
        }
    }

    public p() {
        this.a = new ConcurrentHashMap(16);
    }

    public final <T> T a(f r2, a<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r3, "key");
        Map r4 = (Map) ((ConcurrentHashMap) this.a).get(r2);
        if (r4 == null) goto L5;
        Object r5 = r4.get(r3);
    L6:
        if (r5 != null) goto L9;
        return null;
    L9:
        return (T) r5;
    L5:
        r5 = null;
        goto L6
    }
}
