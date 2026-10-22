package com.bytedance.android.live.recharge.exchange.repo;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.exchange.model.h;
import com.bytedance.android.live.recharge.exchange.model.i;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import tz0.b;
import uz0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/repo/SaaSDiamondExchangeRepo;", "Landroidx/lifecycle/ViewModel;", "", "userId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/recharge/exchange/model/h;", "Lcom/bytedance/revenue/platform/api/core/rx/Observable;", "fetchXiguaExchangeInfo", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SaaSDiamondExchangeRepo extends ViewModel {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            ExtraResponse r4 = (ExtraResponse) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            boolean r1 = true;
            if (((i) r4.data).a() == 1) goto L7;
            r1 = false;
        L7:
            return new h(r1);
        }
    }

    public SaaSDiamondExchangeRepo() {
    }

    public final Observable<h> fetchXiguaExchangeInfo(String r12) {
        Intrinsics.checkNotNullParameter(r12, "userId");
        b r0 = b.a;
        c r1 = new c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        x.a(r1, false);
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        Intrinsics.checkNotNullParameter("open_id", "$this$setTo");
        if (r12 == null) goto L5;
        r2.put("open_id", r12);
    L5:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/openapi/user/xigua_wallet_info/", TypesJVMKt.getJavaType(Reflection.typeOf(i.class)), Extra.class, r1.d, r1.a, r1.b, r1.c).compose(RxUtil.rxSchedulerHelper()).map(a.a);
    }
}
