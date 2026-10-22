package pa0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements f {
    public static final com.bytedance.android.live.revenue.common.reactive.c a = null;
    public static final com.bytedance.android.live.revenue.common.reactive.c b = null;
    public static final o c = null;

    public o() {
    }

    static {
        c = new o();
        com.bytedance.android.live.revenue.common.reactive.c r1 = new com.bytedance.android.live.revenue.common.reactive.c(h.a);
        a = r1;
        b = r1;
    }

    @Override // pa0.f
    public final BehaviorSubject b() {
        jy0.b.a("Incentive/UserIncomeRepository", "updateIncomeInfo begin");
        boolean r0 = va0.a.a;
        int r1 = j.a;
        tz0.b r2 = tz0.b.a;
        uz0.c r3 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        Map r4 = ((uz0.a) r3).b;
        Intrinsics.checkNotNullParameter(r4, "queriesMap");
        if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L5;
        int r5 = 1;
    L6:
        String r6 = Integer.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("exchange_type", "$this$setTo");
        if (r6 == null) goto L9;
        r4.put("exchange_type", r6);
    L9:
        x.a(r3, false);
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        Observable r7 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/wallet/get_user_income/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.platform.business.model.income.b.class)), com.bytedance.android.live.recharge.platform.business.model.income.d.class, ((uz0.a) r3).d, ((uz0.a) r3).a, ((uz0.a) r3).b, ((uz0.a) r3).c).map(i.a).map(n.a);
        BehaviorSubject r8 = BehaviorSubject.create();
        RxUtilKt.h(r7).doOnEach(new m()).subscribe(r8);
        return r8;
    L5:
        r5 = 0;
        goto L6
    }

    @Override // pa0.f
    public final com.bytedance.android.live.revenue.common.reactive.c a() {
        return b;
    }
}
