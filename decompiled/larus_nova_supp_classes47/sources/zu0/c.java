package zu0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.profit.privilege.ProfitCheckConfig;
import com.bytedance.android.live.profit.profitCheck.jsbridge.GetProfitReportConfigResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends a<d, GetProfitReportConfigResultModel> {
    public c() {
    }

    public final void invoke(Object r6, CallContext r7) {
        d r8 = (d) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8.a() != null) goto L9;
        finishWithFailure();
        Unit r9 = Unit.INSTANCE;
    L9:
        ProfitCheckConfig r10 = (ProfitCheckConfig) GsonHelper.get().fromJson(r8.a(), ProfitCheckConfig.class);     // Catch: Exception -> L7
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Exception -> L7
        r12.put("trace_id", String.valueOf(System.currentTimeMillis() + Random.Default.nextLong()));     // Catch: Exception -> L7
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: Exception -> L7
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).w(r12, r10);     // Catch: Exception -> L7
        finishWithSuccess();     // Catch: Exception -> L7
        return;
    L7:
        finishWithFailure();
    }
}
