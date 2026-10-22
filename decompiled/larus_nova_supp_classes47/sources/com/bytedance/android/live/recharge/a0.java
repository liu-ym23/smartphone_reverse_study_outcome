package com.bytedance.android.live.recharge;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.r;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.recharge.platform.model.DiamondExtraListResult;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.ReplaySubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 {
    public final PropertyOwner A;
    public final PropertyOwner<com.bytedance.android.live.recharge.deal.i> B;
    public final PropertyOwner C;
    public final ReplaySubject<Throwable> D;
    public final ReplaySubject E;
    public final ReplaySubject F;
    public final ReplaySubject G;
    public final ReplaySubject H;
    public final ReplaySubject I;
    public final PropertyOwner<Boolean> J;
    public final PropertyOwner<Boolean> K;
    public final PropertyOwner L;
    public final PropertyOwner<Map<Long, com.bytedance.android.live.recharge.model.diamond.e>> M;
    public final PropertyOwner<Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g>> N;
    public final PropertyOwner<Map<Long, String>> O;
    public final PropertyOwner<com.bytedance.android.live.recharge.platform.model.f> P;
    public final PropertyOwner Q;
    public final ReplaySubject<Integer> R;
    public boolean S;
    public boolean T;
    public final CompositeDisposable a;
    public final PropertyOwner<Long> b;
    public final PropertyOwner c;
    public final PropertyOwner<Boolean> d;
    public final PropertyOwner e;
    public final PropertyOwner<List<com.bytedance.android.live.recharge.deal.d>> f;
    public final PropertyOwner g;
    public final PropertyOwner<List<Long>> h;
    public final PropertyOwner i;
    public final PropertyOwner<List<com.bytedance.android.live.recharge.deal.f>> j;
    public final PropertyOwner k;
    public final PropertyOwner<ExchangeInfo> l;
    public final PropertyOwner m;
    public final PropertyOwner<Long> n;
    public final PropertyOwner o;
    public final PropertyOwner<Boolean> p;
    public final PropertyOwner q;
    public final PropertyOwner<Map<Long, IRenderDataInfoBase>> r;
    public final PropertyOwner s;
    public final PropertyOwner<Boolean> t;
    public final PropertyOwner u;
    public final PropertyOwner<Boolean> v;
    public final PropertyOwner w;
    public final PropertyOwner<Boolean> x;
    public final PropertyOwner y;
    public final PropertyOwner<Boolean> z;

    public static final class a {
    }

    static {
    }

    public a0() {
        this.a = new CompositeDisposable();
        PropertyOwner<Long> r1 = new PropertyOwner(0L);
        this.b = r1;
        this.c = r1;
        Boolean r3 = Boolean.FALSE;
        PropertyOwner<Boolean> r2 = new PropertyOwner(r3);
        this.d = r2;
        this.e = r2;
        PropertyOwner<List<com.bytedance.android.live.recharge.deal.d>> r4 = new PropertyOwner(CollectionsKt.emptyList());
        this.f = r4;
        this.g = r4;
        PropertyOwner<List<Long>> r5 = new PropertyOwner(CollectionsKt.emptyList());
        this.h = r5;
        this.i = r5;
        PropertyOwner<List<com.bytedance.android.live.recharge.deal.f>> r6 = new PropertyOwner(CollectionsKt.emptyList());
        this.j = r6;
        this.k = r6;
        PropertyOwner<ExchangeInfo> r7 = new PropertyOwner(new ExchangeInfo(-1, -1, false, null, 0, 0, 0, 0, 0, 0, false, false, 0, false, 0, 32764, null));
        this.l = r7;
        this.m = r7;
        PropertyOwner<Long> r8 = new PropertyOwner(0L);
        this.n = r8;
        this.o = r8;
        PropertyOwner<Boolean> r9 = new PropertyOwner(r3);
        this.p = r9;
        this.q = r9;
        PropertyOwner<Map<Long, IRenderDataInfoBase>> r10 = new PropertyOwner(new LinkedHashMap());
        this.r = r10;
        this.s = r10;
        PropertyOwner<Boolean> r12 = new PropertyOwner(r3);
        this.t = r12;
        this.u = r12;
        PropertyOwner<Boolean> r13 = new PropertyOwner(r3);
        this.v = r13;
        this.w = r13;
        PropertyOwner<Boolean> r14 = new PropertyOwner(r3);
        this.x = r14;
        this.y = r14;
        PropertyOwner<Boolean> r15 = new PropertyOwner(r3);
        this.z = r15;
        this.A = r15;
        PropertyOwner<com.bytedance.android.live.recharge.deal.i> r16 = new PropertyOwner(r.b);
        this.B = r16;
        this.C = r16;
        this.D = ReplaySubject.a();
        this.E = ReplaySubject.a();
        this.F = ReplaySubject.a();
        this.G = ReplaySubject.a();
        this.H = ReplaySubject.a();
        this.I = ReplaySubject.a();
        this.J = new PropertyOwner(r3);
        PropertyOwner<Boolean> r17 = new PropertyOwner(r3);
        this.K = r17;
        this.L = r17;
        this.M = new PropertyOwner(MapsKt.emptyMap());
        this.N = new PropertyOwner(MapsKt.emptyMap());
        this.O = new PropertyOwner(new LinkedHashMap());
        PropertyOwner<com.bytedance.android.live.recharge.platform.model.f> r18 = new PropertyOwner(new com.bytedance.android.live.recharge.platform.model.f(0));
        this.P = r18;
        this.Q = r18;
        this.R = ReplaySubject.a();
    }

    public final void a() {
        this.J.a(Boolean.TRUE);
        PropertyOwner<Boolean> r0 = this.t;
        Boolean r1 = Boolean.FALSE;
        r0.a(r1);
        this.v.a(r1);
    }

    public final boolean d() {
        Iterator r0 = ((Iterable) this.k.a).iterator();
    L3:
        boolean r1 = false;
    L5:
        if (r0.hasNext() == false) goto L9;
        if (((com.bytedance.android.live.recharge.deal.f) r0.next()).h() <= 0) goto L3;
        r1 = true;
        goto L5
    L9:
        return r1;
    }

    public final void b() {
        com.bytedance.android.live.recharge.core.f.d(RechargeServices.b()).getClass();
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        Integer r3 = 2;
        String r4 = r3.toString();
        Intrinsics.checkNotNullParameter("entrance", "$this$setTo");
        if (r4 == null) goto L5;
        r2.put("entrance", r4);
    L5:
        Integer r5 = 1;
        String r6 = r5.toString();
        Intrinsics.checkNotNullParameter("type", "$this$setTo");
        if (r6 == null) goto L8;
        r2.put("type", r6);
    L8:
        com.bytedance.android.live.revenue.common.x.a(r1, false);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        RxUtilKt.c(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/diamond/extra/", TypesJVMKt.getJavaType(Reflection.typeOf(DiamondExtraListResult.class)), Extra.class, r1.d, r1.a, r1.b, r1.c).map(com.bytedance.android.live.recharge.platform.service.f.a).compose(RxUtil.rxSchedulerHelper()).singleOrError().subscribe(new f0(this), new g0(this)), this.a);
    }

    public final void e(com.bytedance.android.live.recharge.deal.i r13, boolean r14) {
        boolean r0 = com.bytedance.android.live.recharge.utils.j.d().enableCacheWithStrategy();
        String r1 = DataType.FALSE;
        boolean r3 = false;
        if (r0 == true) goto L5;
    L39:
        this.f.a(r13.k());
        this.h.a(r13.a());
        this.j.a(r13.c());
        PropertyOwner<Boolean> r2 = this.d;
        if (r13.b() == true) goto L42;
    L44:
        boolean r5 = false;
    L45:
        r2.a(Boolean.valueOf(r5));
        this.b.a(Long.valueOf(r13.d()));
        this.B.a(r13);
        PropertyOwner<Boolean> r4 = this.p;
        IOneKeyPay r6 = r13.f();
        if (r6 == null) goto L48;
        boolean r7 = r6.getSupportOneKeyPay();
    L49:
        r4.a(Boolean.valueOf(r7));
        this.x.a(Boolean.valueOf(r13.m()));
        PropertyOwner<Boolean> r8 = this.t;
        IPrePayCashierInfo r9 = r13.n();
        if (r9 != null) goto L52;
    L54:
        boolean r10 = false;
    L55:
        r8.a(Boolean.valueOf(r10));
        PropertyOwner<Boolean> r12 = this.v;
        IPrePayCashierInfo r15 = r13.n();
        if (r15 != null) goto L58;
    L60:
        boolean r16 = false;
    L61:
        r12.a(Boolean.valueOf(r16));
        PropertyOwner<Map<Long, IRenderDataInfoBase>> r17 = this.r;
        IPrePayCashierInfo r18 = r13.n();
        if (r18 == null) goto L67;
        Map r19 = r18.getRenderDataMap();
        if (r19 == null) goto L67;
        Object r20 = MapsKt.toMutableMap(r19);
        if (r20 == null) goto L67;
    L68:
        r17.a(r20);
        this.z.a(Boolean.valueOf(r14));
        PropertyOwner<Boolean> r110 = this.K;
        if (r13.e() != 1) goto L71;
        r3 = true;
    L71:
        r110.a(Boolean.valueOf(r3));
        qw0.a r111 = (qw0.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), qw0.a.class);
        if (r111 == null) goto L89;
        r111.Ue(rw0.f.class, new rw0.e(new rw0.f(r13)));
        if (((Boolean) this.p.a).booleanValue() == false) goto L76;
        String r22 = DataType.TRUE;
    L78:
        if (((Boolean) this.p.a).booleanValue() == true) goto L80;
    L82:
        r111.Ue(rw0.c.class, new rw0.d(new rw0.c(r22, r1)));
        return;
    L80:
        if (com.bytedance.android.live.recharge.util.g.a().a() == false) goto L82;
        r1 = DataType.TRUE;
        goto L82
    L76:
        r22 = DataType.FALSE;
        goto L78
    L89:
        return;
    L67:
        r20 = new LinkedHashMap();
        goto L68
    L58:
        if (r15.getBatchQueryInfo() != 1) goto L60;
        r16 = true;
        goto L61
    L52:
        if (r9.getOneStepPay() != 1) goto L54;
        r10 = true;
        goto L55
    L48:
        r7 = false;
        goto L49
    L42:
        if (com.bytedance.android.live.recharge.utils.j.c() == true) goto L44;
        r5 = true;
        goto L45
    L5:
        if (this.S == false) goto L39;
        if (r14 == true) goto L39;
        if (((com.bytedance.android.live.recharge.deal.i) this.B.a).c().isEmpty() == true) goto L39;
        if (r13.c().isEmpty() == true) goto L39;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L37
        List<com.bytedance.android.live.recharge.deal.u> r24 = ((com.bytedance.android.live.recharge.deal.i) this.B.a).c();     // Catch: Throwable -> L37
        if (r24.size() != r13.c().size()) goto L15;
        boolean r25 = true;
    L16:
        if (r25 == true) goto L19;
        r24 = null;
    L19:
        if (r24 == null) goto L30;
        Iterator<T> r26 = r24.iterator();     // Catch: Throwable -> L37
        boolean r27 = false;
        int r28 = 0;
    L22:
        if (r26.hasNext() == false) goto L31;
        Object r29 = r26.next();     // Catch: Throwable -> L37
        int r30 = r28 + 1;     // Catch: Throwable -> L37
        if (r28 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L37
    L27:
        if (((com.bytedance.android.live.recharge.deal.u) ListProtector.get(r13.c(), r28)).b == ((com.bytedance.android.live.recharge.deal.u) r29).b) goto L29;
        r27 = true;
    L29:
        r28 = r30;
    L31:
        int r32 = com.bytedance.android.live.recharge.utils.m.a;     // Catch: Throwable -> L37
        HashMap r33 = new HashMap();     // Catch: Throwable -> L37
        if (r27 == false) goto L34;
        Object r34 = DataType.FALSE;
    L35:
        r33.put("ui_change", r34);     // Catch: Throwable -> L37
        com.bytedance.android.live.recharge.utils.f.c("livesdk_rd_recharge_ui_change", r33);     // Catch: Throwable -> L37
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
        goto L39
    L34:
        r34 = DataType.TRUE;
        goto L35
    L30:
        r27 = true;
        goto L31
    L15:
        r25 = false;
    L37:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }

    public final Single<IQueryPrePayCashierData> c(long r8, List<Long> r10, com.bytedance.android.live.recharge.model.d r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "priceList");
        Intrinsics.checkNotNullParameter(r12, "entranceParams");
        com.bytedance.android.live.recharge.model.diamond.e r9 = (com.bytedance.android.live.recharge.model.diamond.e) ((Map) this.M.a).get(Long.valueOf(r8));
        if (r9 == null) goto L8;
        String r14 = r9.getCouponInfo();
        if (r14 == null) goto L8;
        String r3 = r14;
    L9:
        Map r4 = (Map) this.O.a;
        Map r15 = (Map) this.N.a;
        LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r15.size()));
        Iterator r16 = r15.entrySet().iterator();
    L11:
        if (r16.hasNext() == false) goto L16;
        Map.Entry r1 = (Map.Entry) r16.next();
        Object r2 = r1.getKey();
        String r6 = ((com.bytedance.android.live.recharge.platform.business.model.diamond.g) r1.getValue()).getPreCalcInfo();
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r5.put(r2, r6);
        goto L11
    L16:
        RechargeBizScene r7 = com.bytedance.android.live.recharge.panel.b.a(r12);
        com.bytedance.android.live.recharge.platform.service.h r17 = com.bytedance.android.live.recharge.core.f.d(RechargeServices.b());
        String r18 = r12.h;
        r17.getClass();
        Single r19 = com.bytedance.android.live.recharge.platform.service.h.E1(r10, r18, r3, r4, r5, r7);
        int r20 = qw0.c.a;
        Intrinsics.checkNotNullParameter(r10, "priceList");
        return r19.compose(new qw0.b(r10, r13));
    L8:
        r3 = "";
        goto L9
    }
}
