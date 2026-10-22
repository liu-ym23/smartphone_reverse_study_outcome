package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DealSetApiDataSource {
    public static final List<b> a = null;

    public static final class a implements b {
        public static final a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @Override // com.bytedance.android.live.recharge.deal.DealSetApiDataSource.b
        public final void a(m r4) {
            Intrinsics.checkNotNullParameter(r4, "requestParams");
            Map<String, String> r0 = r4.a;
            HashMap r1 = (HashMap) r0;
            r1.put("entrance", String.valueOf(r4.d.getValue()));
            r1.put("need_recharge_price", String.valueOf(r4.c));
            r1.put("fetch_diamond_list_from", String.valueOf(r4.e.getValue()));
        }
    }

    public interface b {
        void a(m r1);
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;

        public c(long r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.live.kmp.util.c r6 = com.bytedance.live.kmp.util.c.a;
            long r0 = System.currentTimeMillis() - this.a;
            com.bytedance.android.live.recharge.utils.o.a(true, r0, null);
            jy0.b.d("Recharge/DealSetApiDataSource", "request finished in " + r0 + " ms");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;

        public d(long r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
            long r1 = System.currentTimeMillis() - this.a;
            int r2 = com.bytedance.android.live.recharge.utils.o.a;
            new LinkedHashMap();
            com.bytedance.android.live.recharge.utils.o.a(false, r1, r6);
            jy0.b.c("Recharge/DealSetApiDataSource", "request failed in " + r1 + " ms: " + r6, null, 4);
        }
    }

    public DealSetApiDataSource() {
    }

    static {
        a = new ArrayList();
        b(a.a);
        b(cw0.b.a);
        b(cw0.c.a);
    }

    public static void b(b r1) {
        Intrinsics.checkNotNullParameter(r1, "processor");
        a.add(r1);
    }

    public static String c(m r3) {
        return "lackingMoney = " + r3.c + ", entrance = " + r3.d + ", fetchFrom = " + r3.e;
    }

    public static Single d(final m r2) {
        Intrinsics.checkNotNullParameter(r2, "requestParams");
        jy0.b.a("Recharge/DealSetApiDataSource", "requestDealSetRawData, " + c(r2));
        return e(new DealSetApiDataSource$requestDealSetRawData$1(r2));
    }

    public static Single e(Function0 r3) {
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        long r1 = System.currentTimeMillis();
        Single r4 = (Single) r3.invoke();
        int r2 = com.bytedance.revenue.platform.api.core.rx.p.a;
        return r4.observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new c(r1)).doOnError(new d(r1));
    }

    public static final Single a(Map r10, Map r12) {
        JSONObject r0 = new JSONObject();
        Iterator r13 = ((HashMap) r12).entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r13.next();
        r0.put((String) r1.getKey(), r1.getValue());
        goto L4
    L6:
        tz0.b r14 = tz0.b.a;
        uz0.c r2 = new uz0.c();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Iterator r15 = ((HashMap) r10).entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Map.Entry r16 = (Map.Entry) r15.next();
        r2.query((String) r16.getKey(), (String) r16.getValue());
        goto L8
    L10:
        r2.query("extra", r0.toString());
        x.a(r2, false);
        r2.a(new zw0.b());
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/diamond/", TypesJVMKt.getJavaType(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(IChargeDeal.class)))), com.bytedance.android.live.recharge.model.diamond.a.class, r2.d, r2.a, r2.b, r2.c).singleOrError();
    }
}
