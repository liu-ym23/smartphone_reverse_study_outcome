package tx9;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x3 {
    public static final ConcurrentHashMap<String, Boolean> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final void a(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "action");
        com.larus.platform.service.g r2 = com.larus.platform.service.g.a;     // Catch: Throwable -> L8
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L8
        r4.put("type", r5);     // Catch: Throwable -> L8
        r4.put("action", r6);     // Catch: Throwable -> L8
        if (r7 == null) goto L6;
        r4.put("extra", r7);     // Catch: Throwable -> L8
    L6:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r2.monitorEventForSlardar("unreachable_logic_monitor", r4, null, null);     // Catch: Throwable -> L8
        return;
    }
}
