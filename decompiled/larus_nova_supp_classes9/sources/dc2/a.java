package dc2;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final Map<String, Class<?>> a = null;

    static {
        a = new HashMap();
    }

    @JvmStatic
    public static final void a(String r1, Class<?> r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "valueType");
        ((HashMap) a).put(r1, r2);
    }
}
