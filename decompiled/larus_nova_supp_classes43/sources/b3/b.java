package b3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;
    public static final Map<String, a> b = null;

    public b() {
    }

    static {
        a = new b();
        b = new LinkedHashMap();
    }

    public final synchronized a a(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "appletId");     // Catch: Throwable -> L6
        a r11 = (a) ((LinkedHashMap) b).get(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }
}
