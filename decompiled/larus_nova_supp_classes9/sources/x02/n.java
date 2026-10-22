package x02;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends d0 {

    public static final class a {
    }

    static {
    }

    public n() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y a(com.bytedance.android.livesdk.gift.platform.core.model.t r29, y r30, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r31, Function1<? super y, Unit> r33) {
        Intrinsics.checkNotNullParameter(r29, "info");
        Intrinsics.checkNotNullParameter(r30, "response");
        Intrinsics.checkNotNullParameter(r31, "listener");
        Intrinsics.checkNotNullParameter(r33, "nextPlugin");
        ReadOnlyProperty r1 = com.bytedance.android.livesdk.gift.platform.business.b.d;
        KProperty[] r3 = com.bytedance.android.livesdk.gift.platform.business.b.a;
        if (((Boolean) r1.getValue(null, r3[2])).booleanValue() == false) goto L11;
        if ((r30 instanceof y.c.a.h) == false) goto L11;
        if (r29.i().r == true) goto L11;
        String r2 = r29.a().d;
        jy0.b.c("GiftSendTimeoutReportPlugin", "send gift timeout, traceId = " + r2, null, 4);
        tz0.b r13 = tz0.b.a;
        uz0.e r14 = new uz0.e();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "$this$beforeConfigureRequest");
        Intrinsics.checkNotNullParameter("rpc-persist-webcast-trace-id", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        ((uz0.a) r14).a.put("rpc-persist-webcast-trace-id", r2);
        Intrinsics.checkNotNullParameter(r14, "$this$afterConfigureRequest");
        com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/gift/report/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, ((uz0.a) r14).d, ((uz0.a) r14).a, ((uz0.a) r14).b, ((uz0.a) r14).c, r14.e, r14.f, r14.g).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(r2), new p(r2));
    L11:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.e.getValue(null, r3[3])).booleanValue() == true) goto L13;
    L17:
        return r30;
    L13:
        if ((r30 instanceof y.c.a.h) == false) goto L17;
        if (r29.i().r == false) goto L17;
        String r4 = r29.a().d;
        jy0.b.c("GiftSendTimeoutReportPlugin", "send prop timeout, traceId = " + r4, null, 4);
        tz0.b r5 = tz0.b.a;
        uz0.e r6 = new uz0.e();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "$this$beforeConfigureRequest");
        Intrinsics.checkNotNullParameter("rpc-persist-webcast-trace-id", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        ((uz0.a) r6).a.put("rpc-persist-webcast-trace-id", r4);
        Intrinsics.checkNotNullParameter(r6, "$this$afterConfigureRequest");
        com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/props/report/", TypesJVMKt.getJavaType(Reflection.typeOf(Unit.class)), Extra.class, ((uz0.a) r6).d, ((uz0.a) r6).a, ((uz0.a) r6).b, ((uz0.a) r6).c, r6.e, r6.f, r6.g).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(r4), new r(r4));
        goto L17
    }
}
