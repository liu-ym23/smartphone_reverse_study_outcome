package com.bytedance.android.live.profit.lottery;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.misc.KTExtendKt;
import com.bytedance.android.live.profit.lottery.plugin.RoomParamsLotteryPlugin;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m2 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public Disposable b;
    public zy0.d c;
    public final a d;
    public final LotteryContext e;
    public final LotteryPluginStore f;
    public final LotteryRepository g;
    public final yz0.k h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ m2 a;

        public a(m2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            KVData r2 = (KVData) r1;
            this.a.g.j();
        }
    }

    private final Context getContext() {
        return this.h.getContext();
    }

    public final LotteryState d() {
        Lottery r0 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(this.g.d);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getState();
    }

    public final void onStart() {
        LotteryPluginStore r0 = this.f;
        r0.a(new com.bytedance.android.live.profit.lottery.plugin.b());
        r0.a(new com.bytedance.android.live.profit.lottery.plugin.c(getContext()));
        r0.a(com.bytedance.android.live.profit.lottery.plugin.d.a);
        r0.a(new RoomParamsLotteryPlugin(this.h));
        LotteryContext r1 = this.e;
        RxUtilKt.c(r1.getOnSubmit().onEvent().subscribe(new n2(this)), this.a);
        RxUtilKt.c(r1.getOnDismissIcon().onEvent().subscribe(new o2(this)), this.a);
        RxUtilKt.c(r1.getOnToolbarButtonClick().onEvent().subscribe(new p2(this)), this.a);
        RxUtilKt.c(r1.getOnIconClick().onEvent().subscribe(new q2(this)), this.a);
        RxUtilKt.c(r1.getOnFinish().onEvent().subscribe(new r2(this)), this.a);
        RxUtilKt.c(r1.getLotteryInfoSyncData().onEvent().subscribe(new s2(this)), this.a);
        RxUtilKt.c(r1.getOnRefresh().onEvent().subscribe(new t2(this)), this.a);
        RxUtilKt.c(r1.getOnReject().onEvent().subscribe(new u2(this)), this.a);
        RxUtilKt.c(r1.getOnHidePanel().onEvent().subscribe(new v2(this)), this.a);
        this.h.getDataCenter().observe("cmd_refetch_broadcast_game_list", this.d);
        vr2.c r2 = vh6.c.b(vr2.c.class);
        if (r2.V4() == false) goto L6;
        Resources r3 = getContext().getResources();
        r2.A2(r3, new int[]{2131252298, 2131252297});
        return;
    }

    public final void onStop() {
        this.a.dispose();
        this.c = null;
        this.b.dispose();
        this.h.getDataCenter().removeObserver(this.d);
    }

    public static final /* synthetic */ Context a(m2 r0) {
        return r0.getContext();
    }

    public static b3 f(t r19) {
        ALogger.i("ttlive_lottery", "getLotteryUriConfig");
        x2 r1 = f3.a;
        if (r19 == null) goto L5;
        int r2 = r19.d;
    L7:
        if (f3.b(String.valueOf(r2)) == false) goto L44;
        x2 r3 = f3.a;
        if (r3 == null) goto L44;
        j3 r4 = r3.schema;
        if (r4 == null) goto L16;
        String r5 = r4.liveLotteryAnchorDetail;
        if (r5 == null) goto L16;
        String r6 = r5;
    L17:
        if (r4 == null) goto L22;
        String r7 = r4.liveLotteryAnchorResult;
        if (r7 == null) goto L22;
        String r8 = r7;
    L23:
        if (r4 == null) goto L28;
        String r9 = r4.liveLotteryAudienceHome;
        if (r9 == null) goto L28;
        String r10 = r9;
    L30:
        if (r4 == null) goto L35;
        String r12 = r4.liveLotteryAudienceResultWin;
        if (r12 == null) goto L35;
        String r13 = r12;
    L36:
        if (r4 == null) goto L41;
        String r14 = r4.liveLotteryAudienceResultFail;
        if (r14 == null) goto L41;
        String r15 = r14;
    L43:
        return new b3(r6, r8, r10, null, r13, r15, 17);
    L41:
        r15 = "";
    L35:
        r13 = "";
    L28:
        r10 = "";
    L22:
        r8 = "";
    L16:
        r6 = "";
    L44:
        if (r19 == null) goto L59;
        if (c1.a(r19) != true) goto L59;
        ReadOnlyProperty r16 = w2.d;
        KProperty[] r17 = w2.a;
        String r18 = ((m0.a) r16.getValue(null, r17[2])).anchorLotteryDetailUri;
        if (r18 != null) goto L50;
        r18 = "";
    L50:
        String r20 = ((m0.a) r16.getValue(null, r17[2])).audienceLotteryWaitUri;
        if (r20 != null) goto L53;
        r20 = "";
    L53:
        String r22 = ((m0.a) r16.getValue(null, r17[2])).audienceLotteryResultUri;
        if (r22 != null) goto L57;
        r22 = "";
    L57:
        return new b3(r18, null, r20, r22, null, null, 101);
    L59:
        return new b3(w2.e().anchorLotteryDetailUri, null, w2.e().audienceLotteryWaitUri, w2.e().audienceLotteryResultUri, null, null, 101);
    L5:
        r2 = 0;
        goto L7
    }

    public final zy0.d c(String r17, final LotteryState r18) {
        LinkedHashMap r3 = new LinkedHashMap();
        LotteryPluginStore r0 = this.f;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "extra");
        Iterator r1 = ((LinkedHashMap) r0.b).values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((n) r1.next()).b(r3);
        goto L4
    L6:
        com.bytedance.android.live.revenue.common.x0 r4 = new com.bytedance.android.live.revenue.common.x0(r17);
        String r5 = "";
        com.bytedance.android.live.revenue.common.x0 r6 = r4.d("url");
        IRoom r7 = this.h.getRoom();
        int r8 = 0;
        int r12 = 2;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L27
        String r14 = w2.e().anchorLotteryCreateUri;     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r14, "baseUriString");     // Catch: Throwable -> L27
        int r15 = com.bytedance.revenue.platform.api.core.e.a;     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r14, "schemeString");     // Catch: Throwable -> L27
        Uri r16 = UriProtector.parse(r14);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r16, "baseUri");     // Catch: Throwable -> L27
        LinkedHashMap r19 = new LinkedHashMap();     // Catch: Throwable -> L27
        if (r16.isHierarchical() == false) goto L13;
        Iterator r110 = UriProtector.getQueryParameterNames(r16).iterator();     // Catch: Throwable -> L27
    L11:
        if (r110.hasNext() == false) goto L13;
        String r111 = (String) r110.next();     // Catch: Throwable -> L27
        String r10 = UriProtector.getQueryParameter(r16, r111);     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L27
        r19.put(r111, r10);     // Catch: Throwable -> L27
    L13:
        Intrinsics.checkNotNullParameter("url", "key");     // Catch: Throwable -> L27
        Object r2 = r19.get("url");     // Catch: Throwable -> L27
        if ((r2 instanceof com.bytedance.android.live.revenue.common.x0) == false) goto L17;
        String r9 = ((com.bytedance.android.live.revenue.common.x0) r2).c().toString();     // Catch: Throwable -> L27
    L20:
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        Uri r112 = UriProtector.parse(r6.toString());     // Catch: Throwable -> L27
        Pair r113 = TuplesKt.to(r112.getHost(), r112.getPath());     // Catch: Throwable -> L27
        Uri r20 = UriProtector.parse(r9);     // Catch: Throwable -> L27
        if (Intrinsics.areEqual(r113, TuplesKt.to(r20.getHost(), r20.getPath())) == false) goto L25;
        r6.b("route", GsonHelper.get().toJson(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("previous_page", "function"), TuplesKt.to("previous_module", CollectionsKt.listOf("game_benefit_icon"))})));     // Catch: Throwable -> L27
    L25:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L30:
        if ((r18 instanceof LotteryState.b) == false) goto L39;
        LotteryState.b r22 = (LotteryState.b) r18;
        p0 r114 = r22.b;
        if (r114.b != true) goto L35;
        r12 = 3;
    L38:
        r6.b("candidate_state", String.valueOf(r12));
        r6.b("use_new_interaction", String.valueOf(r22.a.h ? 1 : 0));
        goto L39
    L35:
        if (r114.a == true) goto L38;
        r12 = 1;
    L39:
        if (r18 == null) goto L41;
        t r23 = l.a(r18);
    L42:
        Map<String, String> r24 = e3.b(r23, this.h);
        String r115 = r24.get("participate_way");
        if (r115 != null) goto L45;
        r115 = "";
    L45:
        r6.b("participate_way", r115);
        String r25 = r24.get("is_life");
        if (r25 != null) goto L48;
        r25 = "";
    L48:
        r6.b("is_life", r25);
        if (r18 == null) goto L56;
        t r26 = l.a(r18);
        if (r26 == null) goto L56;
        c r27 = r26.k;
        if (r27 == null) goto L56;
        String r28 = GsonProtectorUtils.toJson(GsonHelper.getDefault(), r27);
        if (r28 == null) goto L56;
    L57:
        r6.b("ecommerce_coupon_extra", r28);
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).getLocationPermissionParam() != 1) goto L60;
        boolean r29 = true;
    L61:
        r6.b("location_permission", String.valueOf(r29));
        if (r18 == null) goto L66;
        t r30 = l.a(r18);
        if (r30 == null) goto L66;
        Long r32 = Long.valueOf(r30.a);
    L67:
        if (r32 == null) goto L69;
        r6.b("lottery_id", String.valueOf(r32.longValue()));
    L69:
        if (r18 == null) goto L73;
        t r33 = l.a(r18);
        if (r33 == null) goto L73;
        int r34 = r33.d;
    L74:
        r6.b("lottery_type", String.valueOf(r34));
        if ((r7 instanceof Room) == true) goto L77;
        r7 = null;
    L77:
        Room r35 = (Room) r7;
        if (r35 == null) goto L80;
        Integer r36 = Integer.valueOf(r35.orientation);
    L81:
        r6.b("orientation", String.valueOf(r36));
        LiveMode r37 = this.h.getRoom().getStreamType();
        int r38 = com.bytedance.android.live.core.utils.h1.a;
        r6.b("live_type", com.bytedance.android.live.core.utils.i1.a(r37));
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r39 = ((mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class)).W2(LogCommon.ROOM);
        if (r39 == null) goto L84;
        Map<String, String> r40 = r39.getMap();
    L85:
        if (r40 == null) goto L94;
        String r116 = r40.get("log_pb");
        if (r116 != null) goto L89;
        r116 = "";
    L89:
        r6.b("log_pb", r116);
        String r42 = r40.get("request_id");
        if (r42 == null) goto L93;
        r5 = r42;
    L93:
        r6.b("request_id", r5);
    L94:
        r4.b("panel_scene", "lottery");
        Iterator r43 = r3.entrySet().iterator();
    L96:
        if (r43.hasNext() == false) goto L98;
        Map.Entry r44 = (Map.Entry) r43.next();
        r6.b((String) r44.getKey(), (String) r44.getValue());
        goto L96
    L98:
        Uri r45 = r4.c();
        HybridDialogImpl r46 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).mg(getContext(), r45, null);
        if (r46 != null) goto L106;
        com.bytedance.live.datacontext.k<JSONObject> r47 = this.e.getOnPopupSchemaFailed();
        JSONObject r48 = new JSONObject();
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L103
        r48.put("scene", r18);     // Catch: Throwable -> L103
        Result.constructor-impl(r48.put("schema", r45.toString()));     // Catch: Throwable -> L103
    L105:
        Unit r50 = Unit.INSTANCE;
        r47.post(r48);
    L103:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L106:
        if (r46 == null) goto L108;
        r46.l1(new LotteryService$createLotteryHybridComponent$2(this, r18));
    L108:
        x2 r53 = f3.a;
        if (r18 == null) goto L114;
        t r54 = l.a(r18);
        if (r54 == null) goto L114;
        r8 = r54.d;
    L114:
        if (f3.b(String.valueOf(r8)) != true) goto L117;
        if (r46 == null) goto L117;
        r46.l1(new LotteryService$createLotteryHybridComponent$3(this, r18));
    L117:
        LinkedHashMap<String, String> r55 = LotteryTraceMonitor.a;
        String r56 = LotteryTraceMonitor.EventName.lottery_draw_open_schema_final.name();
        StringBuilder r57 = new StringBuilder("state = ");
        if (r18 == null) goto L121;
        String r58 = r18.toString();
        if (r58 == null) goto L121;
    L122:
        r57.append(r58);
        r57.append(" finalUri = ");
        r57.append(r45);
        LotteryTraceMonitor.b(r56, r57.toString());
        return r46;
    L121:
        r58 = "state is null";
        goto L122
    L84:
        r40 = null;
        goto L85
    L80:
        r36 = null;
    L73:
        r34 = -1;
    L66:
        r32 = null;
        goto L67
    L60:
        r29 = false;
    L56:
        r28 = "";
        goto L57
    L41:
        r23 = null;
        goto L42
    L17:
        if ((r2 instanceof String) == false) goto L19;
        r9 = (String) r2;     // Catch: Throwable -> L27
        goto L20
    L19:
        r9 = null;
    L27:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public final void g(String r10, LotteryState r12, int r13) {
        LotteryState r0 = null;
        if (r12 != null) goto L5;
    L11:
        LinkedHashMap<String, String> r1 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.b(LotteryTraceMonitor.EventName.lottery_draw_finish_open_scheme.name(), "uri = " + r10);
        int r2 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_lottery", "openLotteryPanel uri=" + r10 + " state=" + r12);
        boolean r3 = true;
        if (((Boolean) j40.f2.a.getValue()).booleanValue() == false) goto L23;
        i.B0.getClass();
        if (r13 != 1) goto L23;
        LotteryState r14 = d();
        if (r14 == null) goto L23;
        t r4 = l.a(r14);
        if (r4 == null) goto L23;
        boolean r5 = this.h.isAnchor();
        ParticipateStatus r6 = (ParticipateStatus) this.e.getCurCandidateState().getValue();
        Lottery r15 = (Lottery) this.e.getCurrentLottery().getValue();
        if (r15 == null) goto L22;
        r0 = r15.getState();
    L22:
        e3.d(r5, r4, r6, r0, this.h, 1);
    L23:
        LotteryTraceMonitor.b(LotteryTraceMonitor.EventName.lottery_draw_open_cancel_last.name(), "lastPanelDisposable");
        this.b.dispose();
        if (r10.length() == 0) goto L27;
        r3 = false;
    L27:
        if (r3 == false) goto L35;
        LotteryTraceMonitor.b(LotteryTraceMonitor.EventName.lottery_draw_open_error_1.name(), "uri isEmpty");
        return;
    L35:
        this.c = c(r10, r12);     // Catch: Throwable -> L32
        this.b = KTExtendKt.a(this.c);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        LinkedHashMap<String, String> r16 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.b(LotteryTraceMonitor.EventName.lottery_draw_open_error_2.name(), "fail = " + th.toString());
        return;
    L5:
        if ((r12 instanceof LotteryState.b) == false) goto L11;
        mz0.n r7 = new mz0.n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        t r9 = ((LotteryState.b) r12).a;
        if (r9 == null) goto L9;
        Long r17 = Long.valueOf(r9.a);
    L10:
        String r18 = String.valueOf(r17.longValue());
        Intrinsics.checkNotNullParameter("lottery_id", "key");
        Intrinsics.checkNotNullParameter(r18, "value");
        r8.put("lottery_id", r18);
        Intrinsics.checkNotNullParameter("uri", "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        r8.put("uri", r10);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        r19.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r7.b).addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("lottery_open_lottery_panel", r7.a, r7.b);
        goto L11
    L9:
        r17 = null;
        goto L10
    }

    public m2(LotteryContext r2, LotteryPluginStore r3, LotteryRepository r4, yz0.k r5) {
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
        Intrinsics.checkNotNullParameter(r3, "lotteryPluginStore");
        Intrinsics.checkNotNullParameter(r4, "lotteryRepository");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = new CompositeDisposable();
        this.b = Disposables.disposed();
        this.d = new a(this);
    }
}
