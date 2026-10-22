package rw0;

import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.utils.LastCustomRechargeRecoder;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements a {
    public final f a;

    public e(f r2) {
        Intrinsics.checkNotNullParameter(r2, "packagesLog");
        this.a = r2;
    }

    @Override // rw0.a
    public final void a(HashMap<String, String> r7, com.bytedance.android.live.recharge.model.d r8) {
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r8, "entranceParams");
        r7.put("charge_packages", this.a.a);
        long r0 = this.a.b;
        if (r0 <= 0) goto L5;
        r7.put("recommend_package", String.valueOf(r0));
    L5:
        r7.put("discount_scores", String.valueOf(this.a.d));
        f r1 = this.a;
        long r4 = r1.b;
        if (r4 > 0) goto L8;
    L10:
        if (r4 > 0) goto L12;
    L23:
        String r9 = "default";
    L24:
        r7.put("recommend_package_source", r9);
        return;
    L12:
        if (r1.c == false) goto L23;
        boolean r10 = LastCustomRechargeRecoder.a;
        u r12 = r1.e;
        if (r12 == null) goto L20;
        String r13 = r12.f;
        if (r13 == null) goto L20;
        boolean r2 = true;
        if (r13.equals("上次使用") != true) goto L20;
    L21:
        if (r2 == false) goto L23;
        r9 = "last_recharge";
    L20:
        r2 = false;
        goto L21
    L8:
        if (r8.e == false) goto L10;
        r9 = "balance";
        goto L24
    }
}
