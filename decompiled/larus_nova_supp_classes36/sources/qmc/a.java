package qmc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import omc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements b {
    public static final Map<String, Class<?>> a = null;

    /* JADX INFO: renamed from: qmc.a$a, reason: collision with other inner class name */
    public static final class C0316a {
        @JvmStatic
        public static void a(String r1, Class r2) {
            Intrinsics.checkNotNullParameter(r1, "method");
            Intrinsics.checkNotNullParameter(r2, "dataType");
            ((ConcurrentHashMap) a.a).put(r1, r2);
        }
    }

    static {
        a = new ConcurrentHashMap();
    }
}
