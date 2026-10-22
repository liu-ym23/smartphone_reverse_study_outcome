package ou1;

import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner;
import java.util.Map;
import ju1.h;
import ju1.n;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements nu1.f<com.bytedance.android.livesdk.dynamicstrategy.api.entity.b> {
    public a() {
    }

    @Override // nu1.f
    public final n a(h r10, Map r11) {
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.b r12 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.b) r10;
        Intrinsics.checkNotNullParameter(r12, "strategy");
        Intrinsics.checkNotNullParameter(r11, "stateMap");
        boolean r1 = true;
        boolean r2 = false;
        Map<String, ASTRunner.b0> r3 = ASTRunner.a;     // Catch: Exception -> L5
        Object r13 = ASTRunner.c(r12, r11);     // Catch: Exception -> L5
    L13:
        if (r13 != null) goto L15;
        r13 = r12.b;
    L17:
        return new n(r13, r1);
    L15:
        r1 = r2;
    L5:
        e = move-exception;
        int r4 = k.a;
        String r5 = r12.a;
        String r6 = e.getMessage();
        if (r6 != null) goto L9;
        r6 = "unknown";
    L9:
        Intrinsics.checkNotNullParameter(r5, "strategy");
        Intrinsics.checkNotNullParameter(r6, "info");
        k.h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "ast_execute_error"), TuplesKt.to("strategy", r5), TuplesKt.to("info", r6)}), e);
        int r0 = DynamicStrategyMonitor.a;
        String r7 = r12.a;
        String r14 = e.getMessage();
        if (r14 != null) goto L12;
        r14 = "ast execute error";
    L12:
        DynamicStrategyMonitor.d(r7, "ASTRuleStrategy", "", r14);
        r13 = null;
        r2 = true;
        goto L13
    }
}
