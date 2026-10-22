package rw0;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements a {
    public final c a;

    public d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "fastPayLog");
        this.a = r2;
    }

    @Override // rw0.a
    public final void a(HashMap<String, String> r3, com.bytedance.android.live.recharge.model.d r4) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        Intrinsics.checkNotNullParameter(r4, "entranceParams");
        c r5 = this.a;
        r3.put("is_fast_pay", r5.a);
        r3.put("open_fast_pay_opt", r5.b);
    }
}
