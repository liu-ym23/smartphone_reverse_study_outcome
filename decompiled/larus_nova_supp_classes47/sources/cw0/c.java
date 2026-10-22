package cw0;

import com.bytedance.android.live.recharge.deal.DealSetApiDataSource;
import com.bytedance.android.live.recharge.deal.m;
import com.bytedance.android.live.recharge.util.d;
import com.bytedance.android.live.recharge.utils.k;
import com.bytedance.live.kmp.core.KmpEnv;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements DealSetApiDataSource.b {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    @Override // com.bytedance.android.live.recharge.deal.DealSetApiDataSource.b
    public final void a(m r4) {
        Intrinsics.checkNotNullParameter(r4, "requestParams");
        Map<String, String> r5 = r4.a;
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.b() == false) goto L5;
        int r1 = k.a;
        HashMap r2 = (HashMap) r5;
        r2.put("use_ug_deduction", String.valueOf(d.a()));
    L5:
        HashMap r6 = (HashMap) r5;
        r6.put("lazy_init_cj_one_step", String.valueOf(com.bytedance.android.live.recharge.config.a.a.w4()));
    }
}
