package g59;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static final Lazy a = null;
    public static final ConcurrentHashMap<String, String> b = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/dora/impl/dynamic/repository/DoraStarlingRepository$loadStarlingFromCache$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    static {
        a = LazyKt.lazy(new e());
        b = new ConcurrentHashMap();
    }

    public static void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Keva r3 = g49.c.a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r5, "key");     // Catch: Throwable -> L9
        Map r6 = (Map) ((Gson) a.getValue()).fromJson(g49.c.a.getString("dora_key_http_response_starling".concat(r5), ""), new a().getType());     // Catch: Throwable -> L9
        Iterator r0 = r6.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r0.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) r0.next();     // Catch: Throwable -> L9
        b.put((String) r2.getKey(), (String) r2.getValue());     // Catch: Throwable -> L9
        goto L5
    L7:
        g49.d.a("DoraStarlingRepository", "loadStarlingFromCache: " + r6);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        g49.d.c("DoraStarlingRepository", "loadStarlingFromCache error: " + th.getMessage(), th);
    }
}
