package mu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.LinkedHashMap;
import java.util.Map;
import ju1.h;
import ju1.j;
import ju1.n;
import ju1.q;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import nu1.c;
import nu1.f;
import ou1.d;
import ou1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final Map<Object, h> a = null;
    public static final pu1.b b = null;
    public static final pu1.a c = null;
    public static final Map<Class<? extends h>, f<? extends h>> d = null;
    public static final Map<Class<? extends g>, c<? extends g>> e = null;

    static {
        a = new LinkedHashMap();
        b = new pu1.b();
        c = pu1.a.a;
        nu1.a r3 = nu1.a.a;
        d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(j.class, new e()), TuplesKt.to(q.class, new ou1.g()), TuplesKt.to(ju1.f.class, new d()), TuplesKt.to(com.bytedance.android.livesdk.dynamicstrategy.api.entity.b.class, new ou1.a())});
        e = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e.class, new ou1.b())});
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.dynamicstrategy.api.entity.b c(a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "strategyRule");
        c.getClass();
        Intrinsics.checkNotNullParameter(r3, "source");
        String r0 = r3.strategyName;
        if (r0 != null) goto L6;
        k.b("unknown_strategy", "strategy name is null");
    L11:
        return null;
    L6:
        if (r3.defaultResult != null) goto L9;
        k.b(r0, "strategy default result is null");
        goto L11
    L9:
        if (r3.ruleType == 1) goto L13;
        int r1 = k.a;
        k.b(r0, "strategy rule type is " + r3.ruleType);
        goto L11
    L13:
        return new com.bytedance.android.livesdk.dynamicstrategy.api.entity.b(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v10, types: [ju1.a, ju1.j] */
    /* JADX WARN: Type inference failed for: r1v13, types: [ju1.a, ju1.q] */
    /* JADX WARN: Type inference failed for: r1v16, types: [ju1.a, ju1.f] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, ju1.h] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v7, types: [kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [kotlin.Pair[]] */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlin.Pair[]] */
    @JvmStatic
    public static final h d(String r11) {
        Intrinsics.checkNotNullParameter(r11, "strategyStr");
        h r1 = (h) ((LinkedHashMap) a).get(r11);
        if (r1 == null) goto L5;
        return r1;
    L5:
        pu1.b r2 = b;
        r2.getClass();
        ?? r3 = "type";
        Intrinsics.checkNotNullParameter(r11, "strategyStr");
        ?? r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        r0 = 1;
        JsonObject r5 = new JsonParser().parse(r11).getAsJsonObject();     // Catch: Exception -> L50
        if (r5 == null) goto L55;
        JsonElement r6 = r5.get("type");     // Catch: Exception -> L50
        if (r6 == null) goto L55;
        String r7 = r6.getAsString();     // Catch: Exception -> L50
        if (r7 == null) goto L55;
        int r8 = r7.hashCode();     // Catch: Exception -> L50
        if (r8 == (-1039745817)) goto L41;
        if (r8 == (-791592328)) goto L31;
        if (r8 != (-256720530)) goto L55;
        if (r7.equals("speed_formula") == false) goto L55;
        ?? r4 = (ju1.f) GsonProtectorUtils.fromJson(r2.a, r11, ju1.f.class);     // Catch: Exception -> L50
        if (r4 == null) goto L55;
        r3 = r4.h().length();     // Catch: Exception -> L50
        if (r3 == 0) goto L28;
        r0 = 0;
    L28:
        if (r0 != 0) goto L55;
    L56:
        if (r4 == null) goto L59;
        a.put(r11, (h) r4);
        return r4;
    L59:
        return null;
    L31:
        if (r7.equals("weight") == false) goto L55;
        r4 = (q) GsonProtectorUtils.fromJson(r2.a, r11, q.class);     // Catch: Exception -> L50
        if (r4 == null) goto L55;
        r3 = r4.h().length();     // Catch: Exception -> L50
        if (r3 == 0) goto L38;
        r0 = 0;
    L38:
        if (r0 == 0) goto L56;
    L41:
        if (r7.equals("normal") == false) goto L55;
        r4 = (j) GsonProtectorUtils.fromJson(r2.a, r11, j.class);     // Catch: Exception -> L50
        if (r4 == null) goto L55;
        r3 = r4.h().length();     // Catch: Exception -> L50
        if (r3 == 0) goto L48;
        r0 = 0;
    L48:
        if (r0 == 0) goto L56;
    L55:
        r4 = null;
    L50:
        e = move-exception;
        int r9 = k.a;
        String r10 = e.getMessage();
        if (r10 != null) goto L54;
        Intrinsics.checkNotNullParameter("unknown_strategy", "strategy");
        Intrinsics.checkNotNullParameter(r10, "info");
        ?? r12 = new Pair[3];
        r12[0] = TuplesKt.to(r3, "json_strategy_parse_error");
        r12[r0] = TuplesKt.to("strategy", "unknown_strategy");
        r3 = TuplesKt.to("info", r10);
        r12[2] = r3;
        r0 = MapsKt.mutableMapOf(r12);
        k.h(r0, e);
        goto L55
    L54:
        Intrinsics.checkNotNullParameter("unknown_strategy", "strategy");
        Intrinsics.checkNotNullParameter("unknown", "info");
        ?? r13 = new Pair[3];
        r13[0] = TuplesKt.to(r3, "json_strategy_parse_error");
        r13[r0] = TuplesKt.to("strategy", "unknown_strategy");
        r3 = TuplesKt.to("info", "unknown");
        r13[2] = r3;
        r0 = MapsKt.mutableMapOf(r13);
        k.h(r0, e);
        goto L55
    }

    @JvmStatic
    public static final n b(h r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "stateMap");
        f<? extends h> r0 = d.get(r2.getClass());
        if ((r0 instanceof f) == true) goto L5;
        r0 = null;
    L5:
        f<? extends h> r1 = r0;
        if (r1 == null) goto L10;
        n r4 = r1.a(r2, r3);
        if (r4 == null) goto L10;
        return r4;
    L10:
        return new n(r2.a(), true);
    }

    @JvmStatic
    public static final void a(g r2, String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "nfa");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "eventParams");
        c<? extends g> r0 = e.get(r2.getClass());
        if ((r0 instanceof c) == true) goto L5;
        r0 = null;
    L5:
        c<? extends g> r1 = r0;
        if (r1 == null) goto L9;
        r1.a(r2, r3, r4);
        return;
    }
}
