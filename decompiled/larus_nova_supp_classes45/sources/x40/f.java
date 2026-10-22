package x40;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final Map<String, i> a = null;
    public static final List<String> b = null;

    static {
        a = new LinkedHashMap();
        int r0 = b.a;
        b = CollectionsKt.listOf(new String[]{"top_right_banner", "bottom_banner", "short_touch"});
    }

    public static void b(Long r3) {
        if (h.a().booleanValue() == true) goto L5;
        return;
    L5:
        Iterator<T> r0 = b.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        a((String) r0.next(), r3, "OPEN_LIVE_SCHEMA_END");
        goto L7
    }

    public static Map c(String r4, Long r5) {
        Intrinsics.checkNotNullParameter(r4, "activityType");
        if (h.a().booleanValue() == true) goto L19;
        return null;
    L19:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        Map<String, i> r1 = a;     // Catch: Throwable -> L16
        i r2 = (i) ((LinkedHashMap) r1).get(r4);     // Catch: Throwable -> L16
        if (r2 == null) goto L8;
        Long r3 = r2.a;     // Catch: Throwable -> L16
    L9:
        if (r3 != null) goto L11;
    L14:
        r1.put(r4, null);     // Catch: Throwable -> L16
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        return null;
    L11:
        if (Intrinsics.areEqual(r2.a, r5) == false) goto L14;
        return r2.b;
    L8:
        r3 = null;
    L16:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public static void a(String r5, Long r6, String r7) {
        if (h.a().booleanValue() == true) goto L26;
        return;
    L26:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.longValue() <= 0) goto L28;
        Map<String, i> r1 = a;     // Catch: Throwable -> L23
        i r2 = (i) ((LinkedHashMap) r1).get(r5);     // Catch: Throwable -> L23
        if (r2 == null) goto L13;
        Long r3 = r2.a;     // Catch: Throwable -> L23
    L15:
        if (Intrinsics.areEqual(r3, r6) == false) goto L19;
        Map<String, Long> r4 = r2.b;     // Catch: Throwable -> L23
        if (r4 == null) goto L19;
        r4.put(r7, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L23
    L20:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L19:
        r1.put(r5, new i(r6, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r7, Long.valueOf(System.currentTimeMillis()))})));     // Catch: Throwable -> L23
        goto L20
    L13:
        r3 = null;
        goto L15
    L28:
        return;
    L23:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
