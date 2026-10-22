package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.DealSetApiDataSource;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import com.bytedance.android.livesdkapi.depend.model.OneStepRequestBody;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements com.bytedance.android.scope.o, zv0.c {

    public static final class a<V> implements Callable {
        public final /* synthetic */ String a;
        public final /* synthetic */ RechargeBizScene b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ Map f;

        /* JADX INFO: renamed from: com.bytedance.android.live.recharge.platform.service.h$a$a, reason: collision with other inner class name */
        public static final class C0073a<T, R> implements Function {
            public static final C0073a a = null;

            static {
                a = new C0073a();
            }

            public C0073a() {
            }

            public final Object apply(Object r2) {
                ExtraResponse r3 = (ExtraResponse) r2;
                Intrinsics.checkNotNullParameter(r3, "it");
                return (IQueryPrePayCashierData) r3.data;
            }
        }

        public a(String r1, RechargeBizScene r2, List r3, String r4, Map r5, Map r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // java.util.concurrent.Callable
        public final SingleSource<? extends IQueryPrePayCashierData> call() {
            LinkedHashMap r0 = new LinkedHashMap();
            String r1 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).getBioType();
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.put("bio_type", r1);
            JSONObject r3 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).f0();
            if (r3 == null) goto L9;
            String r4 = r3.toString();
            if (r4 == null) goto L9;
        L10:
            r0.put("caijing_pay_params", r4);
            String r5 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).Y0();
            if (r5 != null) goto L13;
            r5 = "";
        L13:
            r0.put("cj_sdk_version", r5);
            com.bytedance.android.livesdk.revenue.service.room.c r6 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
            if (r6 == null) goto L24;
            com.bytedance.android.livesdk.revenue.room.a r7 = r6.getRoomContext();
            if (r7 == null) goto L24;
            com.bytedance.live.datacontext.m r8 = r7.getRoom();
            if (r8 == null) goto L24;
            IRoom r9 = (IRoom) r8.getValue();
            if (r9 == null) goto L24;
            String r10 = r9.getAnchorId();
            if (r10 == null) goto L24;
            r2 = r10;
        L24:
            r0.put("anchor_id", r2);
            r0.put("charge_scene", this.a);
            if (((Boolean) com.bytedance.android.live.recharge.utils.t.k.getValue(null, com.bytedance.android.live.recharge.utils.t.a[9])).booleanValue() == false) goto L27;
            r0.put("cashier_show_scene", "style_8");
        L27:
            r0.put("biz_scene", String.valueOf(this.b.getScene()));
            OneStepRequestBody r12 = new OneStepRequestBody(com.bytedance.android.live.revenue.common.q.c(r0).toString(), this.c, this.d, this.e, this.f);
            tz0.b r13 = tz0.b.a;
            uz0.e r14 = new uz0.e();
            r13.getClass();
            Intrinsics.checkNotNullParameter(r14, "$this$beforeConfigureRequest");
            uz0.e.b(r14, r12);
            Map<String, String> r15 = r14.b;
            Intrinsics.checkNotNullParameter(r15, "queriesMap");
            Intrinsics.checkNotNullParameter("source", "$this$setTo");
            r15.put("source", DataType.FALSE);
            Intrinsics.checkNotNullParameter(r14, "$this$afterConfigureRequest");
            return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/wallet_api/query_pre_pay_cashier_info/", TypesJVMKt.getJavaType(Reflection.typeOf(IQueryPrePayCashierData.class)), Extra.class, r14.d, r14.a, r14.b, r14.c, r14.e, r14.f, r14.g).map(C0073a.a).singleOrError();
        L9:
            r4 = "";
            goto L10
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return new i(r3);
        }
    }

    public h() {
    }

    public final void onStop() {
    }

    public final void onStart() {
        List<DealSetApiDataSource.b> r0 = DealSetApiDataSource.a;
        DealSetApiDataSource.b(x.a);
    }

    @Override // zv0.c
    public final Single<com.bytedance.android.live.recharge.deal.p> y0(com.bytedance.android.live.recharge.deal.m r2) {
        Intrinsics.checkNotNullParameter(r2, "requestParams");
        List<DealSetApiDataSource.b> r0 = DealSetApiDataSource.a;
        return DealSetApiDataSource.d(r2).map(b.a);
    }

    public static Single E1(List r8, String r9, String r10, Map r12, Map r13, RechargeBizScene r14) {
        Intrinsics.checkNotNullParameter(r8, "priceList");
        Intrinsics.checkNotNullParameter(r9, "chargeScene");
        Intrinsics.checkNotNullParameter(r10, "couponInfo");
        Intrinsics.checkNotNullParameter(r14, "bizScene");
        return Single.defer(new a(r9, r14, r8, r10, r12, r13));
    }
}
