package tw0;

import com.bytedance.android.live.recharge.order.BusinessType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ b a;
    public final /* synthetic */ g b;

    public e(b r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        com.bytedance.android.live.recharge.deal.f r5 = (com.bytedance.android.live.recharge.deal.f) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        b r0 = this.a;
        com.bytedance.android.live.recharge.order.k r1 = b.J1(r0, this.b, r5, b.E1(r0));
        return this.a.e.u1(r5, r1, BusinessType.Generic);
    }
}
