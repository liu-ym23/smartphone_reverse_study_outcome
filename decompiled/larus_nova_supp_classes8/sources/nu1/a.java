package nu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements b {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    @Override // nu1.b
    public final Object a(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "expression");
        Intrinsics.checkNotNullParameter(r4, "args");
        return qu1.b.a(r3, r4);
    L5:
        e = move-exception;
        int r0 = k.a;
        k.f("unknown_strategy", r3, e);
        int r1 = DynamicStrategyMonitor.a;
        String r5 = e.getMessage();
        if (r5 != null) goto L9;
        r5 = "express error";
    L9:
        DynamicStrategyMonitor.d("unknown_strategy", "unknown", r3, r5);
        return Boolean.FALSE;
    }
}
