package bw0;

import android.os.Build;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.platform.service.y;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.revenue.common.q;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.wallet.platform.api.IWalletApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wp2.m;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements yv0.a, o {
    public static final /* synthetic */ int f = 0;
    public final CompositeDisposable a;
    public final ConcurrentHashMap<String, b> b;
    public long c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: bw0.a$a, reason: collision with other inner class name */
    public static final class C0007a {
    }

    public static final class b {
        public final long a;
        public final Map<String, Object> b;
        public final Observable<com.bytedance.android.live.recharge.model.c> c;

        public b(long r2, Map r4, BehaviorSubject r5) {
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "observable");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ a a;
        public final /* synthetic */ yv0.b b;

        public c(a r1, yv0.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final JSONObject call() {
            a r0 = this.a;
            int r1 = a.f;
            r0.getClass();
            j.a r2 = j.C0;
            k r3 = (k) com.bytedance.android.live.revenue.core.util.f.d(r2.a(), k.class);
            String r4 = null;
            if (r3 == null) goto L5;
            IRoom r5 = r3.getRoom();
        L6:
            this.a.getClass();
            k r6 = (k) com.bytedance.android.live.revenue.core.util.f.d(r2.a(), k.class);
            if (r6 == null) goto L9;
            IBaseUser r7 = r6.getUser();
        L10:
            yv0.b r8 = this.b;
            r8.getClass();
            JSONObject r9 = new JSONObject();
            j01.d.b(r9, "balance", Long.valueOf(r8.b));
            j01.d.b(r9, "charge_gap", Long.valueOf(r8.a.d));
            j01.d.b(r9, "charge_reason", r8.a.b);
            j01.d.b(r9, "session_id", r8.a.n);
            j01.d.b(r9, "diamond_list", new JSONArray(r8.c));
            j01.d.b(r9, "is_cached_diamond_list", Boolean.valueOf(r8.d));
            if (r5 == null) goto L17;
            IBaseUser r10 = r5.getOwner();
            if (r10 == null) goto L17;
            boolean r12 = true;
            if (r10.isFollowing() != true) goto L17;
        L18:
            d60.b.a(r9, "is_fans", Boolean.valueOf(r12));
            if (r7 == null) goto L21;
            Integer r13 = Integer.valueOf(r7.getAgeRange());
        L22:
            d60.b.a(r9, "age_range", r13);
            if (r7 == null) goto L25;
            Integer r14 = Integer.valueOf(r7.getGender());
        L26:
            d60.b.a(r9, "gender", r14);
            d60.b.a(r9, "device_type", Build.MODEL);
            if (r7 == null) goto L29;
            r4 = r7.getCity();
        L29:
            d60.b.a(r9, "city", r4);
            d60.b.a(r9, "city_level", "");
            d60.b.a(r9, "edu_level", "");
            return r9;
        L25:
            r14 = null;
            goto L26
        L21:
            r13 = null;
        L17:
            r12 = false;
            goto L18
        L9:
            r7 = null;
            goto L10
        L5:
            r5 = null;
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ long b;

        public d(a r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            JSONObject r6 = (JSONObject) r5;
            a.E1(this.a, "livesdk_charge_preorder_runtask", MapsKt.emptyMap(), r6);
            jy0.b.d("Recharge/RechargeClientAiService", "run pre order predict task, params: " + r6);
            vh6.c.b(rq2.a.class).yc(new m(q.b(new Pair[]{TuplesKt.to("custom_feat_dict", r6)}), new bw0.b(this)));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            jy0.b.b("Recharge/RechargeClientAiService", "recharge pre order task error", r7);
            a.J1(this.a);
            a.E1(this.a, "livesdk_charge_preorder_runtask_result", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("success", DataType.FALSE), TuplesKt.to("errorDesc", ExceptionsKt.stackTraceToString(r7)), TuplesKt.to("should_preorder", DataType.FALSE), TuplesKt.to("should_preload", DataType.FALSE)}), null);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BehaviorSubject a;

        public f(BehaviorSubject r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            jy0.b.d("Recharge/RechargeClientAiService", "pre order success");
            BehaviorSubject r0 = this.a;
            r0.onNext((com.bytedance.android.live.wallet.model.d) r3);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ BehaviorSubject a;

        public g(BehaviorSubject r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            jy0.b.b("Recharge/RechargeClientAiService", "pre order failed", r4);
            this.a.onError(r4);
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.a.clear();
    }

    public a() {
        this.a = new CompositeDisposable();
        this.b = new ConcurrentHashMap();
    }

    public static final void J1(a r1) {
        r1.e = false;
        r1.d = false;
    }

    public static Map V1(String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L32;
        JSONObject r5 = new JSONObject();
    L30:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
        Iterator<String> r3 = r5.keys();     // Catch: Throwable -> L27
    L21:
        if (r3.hasNext() == false) goto L25;
        String r6 = r3.next();     // Catch: Throwable -> L27
        Object r7 = r5.opt(r6);     // Catch: Throwable -> L27
        if (r7 == null) goto L21;
        r0.put(r6, r7);     // Catch: Throwable -> L27
        goto L21
    L25:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        return r0;
    L27:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L32:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L13
        Object r10 = Result.constructor-impl(new JSONObject(r4));     // Catch: Throwable -> L13
    L15:
        JSONObject r12 = new JSONObject();
        if (Result.isFailure-impl(r10) == false) goto L18;
        r10 = r12;
    L18:
        r5 = (JSONObject) r10;
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // yv0.a
    public final void S0(yv0.b r4) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        if (com.bytedance.android.live.recharge.utils.j.a() == true) goto L5;
        return;
    L5:
        this.b.clear();
        this.e = true;
        this.d = false;
        long r0 = System.currentTimeMillis();
        RxUtilKt.c(Single.fromCallable(new c(this, r4)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r0), new e(this)), this.a);
    }

    public final void d2(Map<String, String> r7) {
        dw0.c r0 = dw0.c.b;
        Pair[] r1 = new Pair[3];
        boolean r2 = this.d;
        String r3 = DataType.TRUE;
        if (r2 == false) goto L5;
        Object r4 = DataType.TRUE;
    L6:
        r1[0] = TuplesKt.to("should_preorder", r4);
        if (this.e == false) goto L9;
        Object r5 = DataType.TRUE;
    L10:
        r1[1] = TuplesKt.to("is_predicting", r5);
        if (com.bytedance.android.live.recharge.utils.j.a() == true) goto L14;
        r3 = DataType.FALSE;
    L14:
        r1[2] = TuplesKt.to("enable_preorder", r3);
        r0.c("livesdk_charge_preorder_cache_miss", MapsKt.plus(r7, MapsKt.mapOf(r1)), CollectionsKt.emptyList());
        return;
    L9:
        r5 = DataType.FALSE;
        goto L10
    L5:
        r4 = DataType.FALSE;
        goto L6
    }

    public static Pair K1(Map r9, Map r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r9 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L47;
        if (r10.isEmpty() == false) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L47;
        Iterator r5 = SetsKt.plus(r9.keySet(), r10.keySet()).iterator();
        boolean r6 = true;
    L18:
        if (r5.hasNext() == false) goto L45;
        String r7 = (String) r5.next();
        if (r10.containsKey(r7) == false) goto L21;
        if (r9.containsKey(r7) == false) goto L24;
        if ((!Intrinsics.areEqual(r9.get(r7), r10.get(r7))) == false) goto L18;
        if (Intrinsics.areEqual(r7, "extra") == false) goto L42;
        Object r8 = r9.get(r7);
        Object r12 = null;
        if ((r8 instanceof String) == true) goto L32;
        r8 = null;
    L32:
        Map r13 = V1((String) r8);
        Object r14 = r10.get(r7);
        if ((r14 instanceof String) == false) goto L36;
        r12 = r14;
    L36:
        Pair r15 = K1(r13, V1((String) r12));
        boolean r16 = ((Boolean) r15.component1()).booleanValue();
        Map r17 = (Map) r15.component2();
        if (r6 == false) goto L40;
        if (r16 == false) goto L40;
        r6 = true;
    L41:
        r0.putAll(r17);
    L40:
        r6 = false;
        goto L41
    L42:
        r0.put(r7, 2);
    L43:
        r6 = false;
        goto L18
    L24:
        r0.put(r7, 1);
        goto L43
    L21:
        r0.put(r7, 0);
        goto L43
    L45:
        return TuplesKt.to(Boolean.valueOf(r6), r0);
    L13:
        r4 = false;
    L47:
        return TuplesKt.to(Boolean.FALSE, r0);
    L5:
        if (r9.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // yv0.a
    public final void S(com.bytedance.android.live.recharge.deal.f r18, com.bytedance.android.live.recharge.order.k r19) {
        Intrinsics.checkNotNullParameter(r18, "deal");
        Intrinsics.checkNotNullParameter(r19, "orderOptions");
        if (com.bytedance.android.live.recharge.utils.j.a() == true) goto L5;
        return;
    L5:
        String r5 = "price=" + ((int) r18.g()) + "&deal_id=" + r18.b();
        boolean r6 = r18 instanceof u;
        if (r6 == true) goto L8;
    L10:
        boolean r8 = false;
    L11:
        if (r8 == false) goto L169;
        long r9 = System.currentTimeMillis();
        long r10 = r9 - this.c;
        this.c = r9;
        if (r10 >= 500) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == true) goto L170;
        b r13 = this.b.get(r5);
        if (r13 != null) goto L21;
    L23:
        boolean r14 = false;
    L24:
        if (r14 == false) goto L27;
        return;
    L27:
        if (this.e == false) goto L31;
        jy0.b.d("Recharge/RechargeClientAiService", "is predicting");
        TuplesKt.to(r18, r19);
        return;
    L31:
        if (this.d == true) goto L34;
        jy0.b.d("Recharge/RechargeClientAiService", "pre order not allow");
        return;
    L34:
        bd1.c.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "deal");
        Intrinsics.checkNotNullParameter(r19, "orderOptions");
        com.bytedance.android.live.recharge.order.j r4 = r19.a;
        int r0 = r19.h;
        if (r0 != (-1)) goto L38;
        r0 = 0;
    L38:
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("diamond_id", Long.valueOf(r18.b()));
        if (r19.g <= 0) goto L41;
        int r16 = 3;
    L42:
        r15.put("way", Integer.valueOf(r16));
        String r17 = (String) r4.get("pk_pay_method");
        if (r17 != null) goto L45;
    L48:
        boolean r110 = true;
    L49:
        if (r110 == true) goto L51;
        r15.put("way", r17);
    L51:
        Intrinsics.checkNotNullParameter(r18, "$this$isIap");
        if (com.bytedance.android.live.wallet.pay.iap.f.a() == true) goto L54;
    L59:
        boolean r20 = false;
    L60:
        if (r20 == false) goto L62;
        r15.put("way", 4);
    L62:
        r15.put("source", Integer.valueOf(r0));
        r15.put("currency", "cny");
        com.bytedance.android.live.recharge.core.f.e(RechargeServices.b()).getClass();
        k r1 = (k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        if (r1 == null) goto L67;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L67;
        long r22 = r2.getRoomId();
    L68:
        r15.put("room_id", Long.valueOf(r22));
        Intrinsics.checkNotNullParameter(r18, "$this$getCustomPrice");
        if ((r18 instanceof com.bytedance.android.live.recharge.deal.d) == true) goto L75;
        if (r6 == true) goto L72;
    L74:
        long r23 = 0;
    L76:
        r15.put("customized_price", Long.valueOf(r23));
        r15.put("trade_type", 0);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L82
        com.bytedance.android.live.recharge.order.j r24 = r19.a;     // Catch: Throwable -> L82
        if (r24 == null) goto L81;
        Object r7 = Result.constructor-impl(new JSONObject(r24));     // Catch: Throwable -> L82
    L84:
        JSONObject r25 = new JSONObject();
        if (Result.isFailure-impl(r7) == false) goto L87;
        r7 = r25;
    L87:
        JSONObject r26 = (JSONObject) r7;
        long r111 = r19.g;
        if (r111 > 0) goto L90;
    L96:
        y r112 = com.bytedance.android.live.recharge.core.f.e(RechargeServices.b());
        com.bytedance.android.live.recharge.order.j r27 = r19.a;
        r112.getClass();     // Catch: JSONException -> L124
        r26.put("authorid", y.E1());     // Catch: JSONException -> L122
        com.bytedance.android.livesdk.revenue.service.interact.d r28 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);     // Catch: JSONException -> L122
        r26.put("live_type", r28.getLiveTypeForLog());     // Catch: JSONException -> L122
        r26.put("function_type", r28.getFunctionTypeForLog());     // Catch: JSONException -> L122
        r26.put("promotion_source", r27.get("promotion_source"));     // Catch: JSONException -> L122
        r26.put("promotion_id", r27.get("promotion_id"));     // Catch: JSONException -> L122
        r26.put("create_pay_type", r27.get("create_pay_type"));     // Catch: JSONException -> L122
        r26.put("caijing_pay_params", r27.get("caijing_pay_params"));     // Catch: JSONException -> L122
        r26.put("sdk_version", r27.get("sdk_version"));     // Catch: JSONException -> L122
        String r29 = (String) r27.get("live_pk");     // Catch: JSONException -> L122
        if (r29 == null) goto L102;
        r26.put("live_pk", CastIntegerProtector.parseInt(r29));     // Catch: JSONException -> L122
    L102:
        String r30 = (String) r27.get("roomid");     // Catch: JSONException -> L122
        if (r30 == null) goto L105;
        r26.put("roomid", r30);     // Catch: JSONException -> L122
    L105:
        com.bytedance.android.live.recharge.order.k r32 = r19;
        int r33 = r32.i;     // Catch: JSONException -> L120
        if (r33 == (-1)) goto L109;
        r26.put("business_scene", r33);     // Catch: JSONException -> L120
    L109:
        String r34 = (String) r27.get("accept_recharge_agreement");     // Catch: JSONException -> L120
        if (r34 == null) goto L112;
        r26.put("accept_recharge_agreement", CastIntegerProtector.parseInt(r34));     // Catch: JSONException -> L120
    L112:
        String r35 = (String) r27.get("cj_extra");     // Catch: JSONException -> L120
        if (r35 == null) goto L115;
        r26.put("cj_extra", r35);     // Catch: JSONException -> L120
    L115:
        Iterator<Map.Entry<String, String>> r36 = r32.m.entrySet().iterator();     // Catch: JSONException -> L120
    L116:
        if (r36.hasNext() == false) goto L127;
        Map.Entry<String, String> r37 = r36.next();     // Catch: JSONException -> L120
        r26.put(r37.getKey(), r37.getValue());     // Catch: JSONException -> L120
    L127:
        r15.put("extra", r26.toString());
        r15.put("biz_extra", r32.j.toString());
        String r38 = (String) r4.get("two_factory_auth_verify_info");
        if (r38 == null) goto L130;
        r15.put("two_factory_auth_verify_info", r38);
    L130:
        String r39 = (String) r4.get("anchor_id");
        if (r39 == null) goto L133;
        r15.put("anchor_id", r39);
    L133:
        String r40 = (String) r4.get("diamond_info");
        if (r40 == null) goto L136;
        r15.put("diamond_info", r40);
    L136:
        String r42 = (String) r4.get("diamond_safe");
        if (r42 == null) goto L139;
        r15.put("diamond_safe", r42);
    L139:
        String r43 = (String) r4.get("diamond_extra_safe");
        if (r43 == null) goto L142;
        r15.put("diamond_extra_safe", r43);
    L142:
        String r44 = (String) r4.get("room_type");
        if (r44 == null) goto L145;
        r15.put("room_type", r44);
    L145:
        String r45 = (String) r4.get("continue_pay_info");
        if (r45 == null) goto L148;
        r15.put("continue_pay_info", r45);
    L148:
        String r46 = (String) r4.get("coupon_info");
        if (r46 == null) goto L151;
        r15.put("coupon_info", r46);
    L151:
        String r47 = (String) r4.get("pre_calc_info");
        if (r47 == null) goto L154;
        r15.put("pre_calc_info", r47);
    L154:
        String r48 = (String) r4.get("guide_source");
        if (r48 == null) goto L157;
        r15.put("guide_source", r48);
    L157:
        r15.putAll(r32.l);
        BehaviorSubject r49 = BehaviorSubject.create();
        this.b.put(r5, new b(System.currentTimeMillis(), MapsKt.toMap(r15), r49));
        bd1.c r50 = bd1.c.a;
        Map r52 = MapsKt.toMutableMap(r15);
        r52.put("recharge_scene", 1);
        Unit r53 = Unit.INSTANCE;
        r50.getClass();
        Intrinsics.checkNotNullParameter(r52, "params");
        com.bytedance.android.live.recharge.trace.g r54 = com.bytedance.android.live.recharge.trace.f.a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_DIAMOND_BUY_PRE, r52);
        RxUtilKt.c(((IWalletApi) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.network.a.class).getService(IWalletApi.class)).createPreOrder(r52).doOnNext(bd1.a.a).map(bd1.b.a).subscribe(new f(r49), new g(r49)), this.a);
        return;
    L120:
        e = e;
    L126:
        int r55 = v.a;
        v.b("wallet_pay_alog_tag", "putCommonParamsIntoExtra", e);
    L122:
        e = e;
        r32 = r19;
    L124:
        e = e;
        r32 = r19;
        goto L126
    L90:
        if (r111 >= r18.g()) goto L96;
        JSONArray r56 = new JSONArray();
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L94
        r113.put("combineMethod", 18);     // Catch: Throwable -> L94
        r113.put("combineAmount", r19.g);     // Catch: Throwable -> L94
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L94
        r114.put("combineMethod", 200);     // Catch: Throwable -> L94
        r114.put("combineAmount", r18.g() - r19.g);     // Catch: Throwable -> L94
        r56.put(0, r113);     // Catch: Throwable -> L94
        r56.put(1, r114);     // Catch: Throwable -> L94
        Result.constructor-impl(r26.put("combineStruct", r56.toString()));     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L96
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L84
    L72:
        if (((u) r18).h == false) goto L74;
    L75:
        r23 = r18.g();
    L67:
        r22 = 0;
        goto L68
    L54:
        if (r18.f().length() <= 0) goto L56;
        boolean r59 = true;
    L57:
        if (r59 == false) goto L59;
        r20 = true;
        goto L60
    L56:
        r59 = false;
        goto L57
    L45:
        if (r17.length() == 0) goto L48;
        r110 = false;
        goto L49
    L41:
        r16 = 0;
        goto L42
    L21:
        if ((System.currentTimeMillis() - r13.a) >= 3600000) goto L23;
        r14 = true;
        goto L24
    L170:
        return;
    L15:
        r12 = false;
        goto L16
    L169:
        return;
    L8:
        if (com.bytedance.android.live.recharge.platform.business.model.diamond.j.a(com.bytedance.android.live.recharge.deal.g.c(r18)) == true) goto L10;
        r8 = true;
        goto L11
    }

    @Override // yv0.a
    public final Observable<com.bytedance.android.live.recharge.model.c> N0(int r7, long r8, Map<String, ? extends Object> r10) {
        String r9 = "price=" + r7 + "&deal_id=" + r8;
        b r12 = this.b.remove(r9);
        if (r12 != null) goto L5;
        d2(MapsKt.emptyMap());
    L23:
        jy0.b.d("Recharge/RechargeClientAiService", "get pre order result is null, key=" + r9);
        return null;
    L5:
        if ((System.currentTimeMillis() - r12.a) >= 3600000) goto L7;
        boolean r0 = true;
    L8:
        Pair r13 = K1(r12.b, r10);
        boolean r1 = ((Boolean) r13.component1()).booleanValue();
        Map r14 = (Map) r13.component2();
        if (r0 == false) goto L13;
        if (r1 == false) goto L13;
        return r12.c;
    L13:
        Pair[] r15 = new Pair[3];
        String r2 = DataType.TRUE;
        if (r0 == false) goto L16;
        Object r3 = DataType.TRUE;
    L17:
        r15[0] = TuplesKt.to("is_timeout", r3);
        if (r1 == true) goto L21;
        r2 = DataType.FALSE;
    L21:
        r15[1] = TuplesKt.to("is_params_all_match", r2);
        r15[2] = TuplesKt.to("different_keys", r14.toString());
        d2(MapsKt.mapOf(r15));
        goto L23
    L16:
        r3 = DataType.FALSE;
        goto L17
    L7:
        r0 = false;
        goto L8
    }

    public static final void E1(a r0, String r1, Map r2, JSONObject r3) {
        r0.getClass();
        if (r3 == null) goto L6;
        Map<String, String> r4 = q.a(r3);
        if (r4 == null) goto L6;
    L7:
        dw0.c.b.c(r1, MapsKt.plus(r2, r4), CollectionsKt.emptyList());
        return;
    L6:
        r4 = MapsKt.emptyMap();
        goto L7
    }
}
