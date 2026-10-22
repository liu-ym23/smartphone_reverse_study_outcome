package c59;

import com.bytedance.keva.Keva;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d0 {
    public static final ConcurrentHashMap<String, String> a = null;
    public static final Object b = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/dora/impl/dynamic/dsl/DslStarlingRepo$loadStarlingFromCache$1$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    static {
        a = new ConcurrentHashMap();
        b = new Object();
    }

    public static Map a() {
        return MapsKt.toMap(a);
    }

    public static void b() {
        Object r3 = b;
        monitor-enter(r3);
        String r4 = g49.c.a.getString("key_dora_kv_starling", "");     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        if (r4.length() != 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L12;
        g49.d.d("DslStarlingRepo", "loadStarlingFromCache: empty cache, no need to load");     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        monitor-exit(r3);
        return;
    L12:
        Map<? extends String, ? extends String> r6 = (Map) s.a(r4, new a());     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        if (r6 != null) goto L15;
        r6 = MapsKt.emptyMap();     // Catch: JsonSyntaxException -> L17 Throwable -> L19
    L15:
        ConcurrentHashMap<String, String> r7 = a;     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        r7.clear();     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        r7.putAll(r6);     // Catch: JsonSyntaxException -> L17 Throwable -> L19
        g49.d.d("DslStarlingRepo", "loadStarlingFromCache: load starling map from cache, size=" + r6.size());     // Catch: JsonSyntaxException -> L17 Throwable -> L19
    L22:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r3);
        return;
    L7:
        r5 = false;
    L25:
        th = move-exception;
        throw th;
    L17:
        e = move-exception;
        g49.d.c("DslStarlingRepo", "loadStarlingFromCache JsonSyntaxException error: " + e.getMessage(), e);     // Catch: Throwable -> L25
        Keva r1 = g49.c.a;     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter("", "value");     // Catch: Throwable -> L25
        g49.c.a.storeString("key_dora_kv_starling", "");     // Catch: Throwable -> L25
    L19:
        th = move-exception;
        g49.d.c("DslStarlingRepo", "loadStarlingFromCache error: " + th.getMessage(), th);     // Catch: Throwable -> L25
        goto L22
    }

    public static void c(Map r6) {
        Intrinsics.checkNotNullParameter(r6, "map");
        if (r6.isEmpty() == false) goto L6;
        g49.d.d("DslStarlingRepo", "updateStarling: empty map，no need to update");
        return;
    L6:
        Object r0 = b;
        monitor-enter(r0);
        g49.d.d("DslStarlingRepo", "updateStaring: begin update starling map");     // Catch: Throwable -> L25
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L25
        boolean r1 = false;
    L10:
        if (r7.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) r7.next();     // Catch: Throwable -> L25
        String r3 = (String) r2.getKey();     // Catch: Throwable -> L25
        String r4 = (String) r2.getValue();     // Catch: Throwable -> L25
        ConcurrentHashMap<String, String> r5 = a;     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r5.get(r3), r4) == true) goto L10;
        if (o0.d(r4) == false) goto L10;
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        r5.put(r3, r4);     // Catch: Throwable -> L25
        r1 = true;
        goto L10
    L18:
        if (r1 == false) goto L22;
        g49.d.d("DslStarlingRepo", "updateStaring: starling map changed, save to cache");     // Catch: Throwable -> L25
        Lazy r8 = s.a;     // Catch: Throwable -> L25
        String r9 = s.d(a());     // Catch: Throwable -> L25
        if (r9 == null) goto L22;
        Keva r10 = g49.c.a;     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r9, "value");     // Catch: Throwable -> L25
        g49.c.a.storeString("key_dora_kv_starling", r9);     // Catch: Throwable -> L25
    L22:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r0);
        return;
    L25:
        th = move-exception;
        throw th;
    }
}
