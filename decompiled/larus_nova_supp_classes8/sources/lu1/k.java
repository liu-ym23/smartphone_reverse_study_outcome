package lu1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.k0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("DynamicStrategy", r1);
    }

    public static void b(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "strategy");
        Intrinsics.checkNotNullParameter(r6, "info");
        h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "ast_strategy_parse_error"), TuplesKt.to("strategy", r5), TuplesKt.to("info", r6)}), null);
    }

    public static void g(String r1, Map r2) {
        k0.o().j(r1, r2);
    }

    public static void h(Map r2, Throwable r3) {
        k0.o().f("DynamicStrategy_error", r2);
        if (r3 == null) goto L6;
        k0.o().getClass();
        com.bytedance.android.live.core.log.g.e("DynamicStrategy_error", r3);
        return;
    }

    public static void c(ju1.c r2, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "factor");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
        if (((ku1.b) ku1.c.a.getValue()).d() == false) goto L6;
        g("DynamicStrategy_feature_change", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(LiveEndPageData.TAG_NAME, r2.a), TuplesKt.to("old_state", r3), TuplesKt.to("new_state", r4), TuplesKt.to("type", "feature")}));
        return;
    }

    public static void d(ju1.l r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        if (((ku1.b) ku1.c.a.getValue()).d() == false) goto L6;
        g("DynamicStrategy_feature_change", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(LiveEndPageData.TAG_NAME, r3.b()), TuplesKt.to("old_state", Boolean.valueOf(r4)), TuplesKt.to("new_state", Boolean.valueOf(r5)), TuplesKt.to("type", "scene")}));
        return;
    }

    public static void f(String r5, String r6, SimpleExpressException r7) {
        Intrinsics.checkNotNullParameter(r5, "strategy");
        Intrinsics.checkNotNullParameter(r6, "expression");
        h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "expression_execute_error"), TuplesKt.to("strategy", r5), TuplesKt.to("expression", r6)}), r7);
    }

    public static void e(ju1.h r3, ju1.n r4, ju1.n r5, Map r6) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        Intrinsics.checkNotNullParameter(r5, "newResult");
        Intrinsics.checkNotNullParameter(r6, "featureMap");
        Pair[] r0 = new Pair[6];
        r0[0] = TuplesKt.to(LiveEndPageData.TAG_NAME, r3.b());
        r0[1] = TuplesKt.to("type", r3.d());
        if (r4 == null) goto L6;
        Object r7 = r4.c();
        if (r7 == null) goto L6;
    L7:
        r0[2] = TuplesKt.to("old_result", r7);
        r0[3] = TuplesKt.to("new_result", r5.c());
        r0[4] = TuplesKt.to("is_default", Boolean.valueOf(r5.b));
        r0[5] = TuplesKt.to("feature_state", r6);
        g("DynamicStrategy_strategy_decide", MapsKt.mutableMapOf(r0));
        return;
    L6:
        r7 = "null";
        goto L7
    }

    public static void i(int r5, String r6, String r7, Throwable r8) {
        Intrinsics.checkNotNullParameter(r6, "version");
        Intrinsics.checkNotNullParameter(r7, "info");
        h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "strategy_fetch_error"), TuplesKt.to("request_scene", Integer.valueOf(r5)), TuplesKt.to("version", r6), TuplesKt.to("info", r7)}), r8);
    }
}
