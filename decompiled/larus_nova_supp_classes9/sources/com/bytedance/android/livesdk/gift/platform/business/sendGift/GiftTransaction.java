package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.MinorExtra;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profit.privilege.ProfitCheckConfig;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.h3;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.p1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.v2;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.ai.AiStrategyInsertErrorCode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshPropList;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.GiftTransactionReqCount;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSourceValue;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.p;
import com.bytedance.android.livesdk.gift.platform.core.model.r;
import com.bytedance.android.livesdk.gift.platform.core.model.s;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.gift.platform.core.model.x;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelTraceService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.q0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.s0;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftFrequencyUtils;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.message.model.cb;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonParseException;
import i12.o;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftTransaction implements t {
    public static final /* synthetic */ int B = 0;
    public final boolean A;
    public final d a;
    public boolean b;
    public boolean c;
    public y d;
    public final PublishSubject<ExtraResponse<p2, ? extends Extra>> e;
    public final PublishSubject<ExtraResponse<m2, Extra>> f;
    public final List<s> g;
    public final List<s> h;
    public final List<s> i;
    public final List<r> j;
    public b k;
    public final List<x> l;
    public boolean m;
    public p2 n;
    public int o;
    public int p;
    public int q;
    public final Map<Integer, Disposable> r;
    public int s;
    public int t;
    public String u;
    public boolean v;
    public String w;
    public final b0 x;
    public final IRoom y;
    public final DataCenter z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final p a() {
        return new p(GiftManagerKt.l(this.x.b), this.p, this.z, this.u);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final List<x> c() {
        jy0.b.c("GiftTransaction", "Get plugin custom result called, current plugin custom results are " + CollectionsKt.joinToString$default(this.l, null, null, null, 0, null, GiftTransaction$getPluginCustomResult$1.INSTANCE, 31, null), null, 4);
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final p2 f() {
        jy0.b.c("GiftTransaction", "Get final result called, final result is " + this.n + '.', null, 4);
        return this.n;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final void finish() {
        o(y.d.c, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final Observable<ExtraResponse<p2, ? extends Extra>> getObservable() {
        y r1 = null;
        if (this.c == false) goto L17;
        y r0 = this.d;
        if ((r0 instanceof y.c.a.C0067a) == false) goto L8;
        r1 = r0;
    L8:
        y.c.a.C0067a r2 = (y.c.a.C0067a) r1;
        if (r2 == null) goto L13;
        ApiException r3 = r2.d;
        if (r3 == null) goto L13;
    L15:
        return Observable.error(r3);
    L13:
        r3 = new IllegalStateException(this.d.toString());
        goto L15
    L17:
        if (this.b == false) goto L21;
        jy0.b.c("GiftTransaction", "get observable when transaction disposed, count = " + this.p, null, 4);
        return Observable.error(new IllegalStateException(this.d.toString()));
    L21:
        return this.e;
    }

    public final void l() {
        jy0.b.c("GiftTransaction", "Start Create Transaction, params is " + this.x, null, 4);
        this.k = new b(((ArrayList) this.g).iterator(), 1);
        this.m = true;
        n(y.d.c, new GiftTransaction$beforeCreate$1(this));
    }

    public final long p() {
        List<k3> r0 = this.x.z;
        if (r0 == null) goto L15;
        Iterator<k3> r1 = r0.iterator();
        long r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L13;
        h2 r5 = GiftManagerKt.l(r1.next().getGiftId());
        if (r5 == null) goto L10;
        int r6 = r5.getDiamondCount();
    L11:
        r3 = r3 + ((long) r6);
        goto L6
    L10:
        r6 = 0;
        goto L11
    L13:
        if (r3 == 0) goto L15;
        return r3;
    L15:
        int r2 = this.x.l;
        i12.e r4 = o.b();
        Object r7 = null;
        if (r4 == null) goto L18;
        Object r8 = com.bytedance.android.scope.m.e.d(r4, GiftExtraRepo.class);
    L19:
        GiftExtraRepo r9 = (GiftExtraRepo) r8;
        if (r9 == null) goto L24;
        l1 r10 = r9.o(r2, this.x.b);
        if (r10 == null) goto L24;
        long r11 = r10.getBuffDiamondCount();
    L25:
        h2 r13 = a().a;
        if (r13 == null) goto L28;
        long r14 = r13.getDiamondCount();
    L29:
        i12.e r15 = o.b();
        if (r15 == null) goto L32;
        r7 = com.bytedance.android.scope.m.e.d(r15, GiftExtraRepo.class);
    L32:
        GiftExtraRepo r16 = (GiftExtraRepo) r7;
        if (r16 == null) goto L35;
        b0 r17 = this.x;
        long r18 = r16.y(r17.b, r14, r17.n);
    L37:
        if (r18 <= 0) goto L40;
        return r18;
    L40:
        return r14 + r11;
    L35:
        r18 = 0;
        goto L37
    L28:
        r14 = 0;
    L24:
        r11 = 0;
        goto L25
    L18:
        r8 = null;
        goto L19
    }

    public final void r() {
        b0 r0 = this.x;
        int r1 = r0.q;
        if (r1 == 1) goto L5;
    L7:
        jy0.b.d("GiftTransaction", "start reorder, needSendNum = " + r1 + ", needOrderNum = " + this.q);
        int r2 = this.q;
        if (1 > r1) goto L13;
        if (r2 < r1) goto L13;
        this.q = r2 - r1;
        s(r1, true);
    L13:
        if (this.b == false) goto L16;
        o(this.d, 0);
        return;
    L16:
        return;
    L5:
        if (r0.p == SendGiftStrategy.ONE_SEND_ONE_REQUEST) goto L7;
        r1 = this.q;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final boolean b() {
        return this.A;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final boolean e() {
        return this.v;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final b0 i() {
        return this.x;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final boolean isDisposed() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final int d(int r2) {
        this.o += r2;
        return s(r2, false);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final void g(x02.d r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginCustomResult");
        if (this.k.b != 3) goto L6;
        jy0.b.c("GiftTransaction", "Invalid use of addPluginCustomResult, do not use it when timing comes to after transaction finish. ", null, 4);
        return;
    L6:
        ((ArrayList) this.l).add(r4);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.t
    public final void h(r r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.c == false) goto L5;
        r2.b(this, this.d);
        return;
    L5:
        ((ArrayList) this.j).add(r2);
    }

    public final void m(y r5) {
        jy0.b.c("GiftTransaction", "Start beforeFinish", null, 4);
        this.k = new b(((ArrayList) this.h).iterator(), 2);
        this.m = true;
        n(r5, new GiftTransaction$beforeFinish$1(this));
    }

    public final void n(y r4, Function1<? super y, Unit> r5) {
        if ((r4 instanceof y.b) == false) goto L6;
        return;
    L6:
        if ((r4 instanceof y.c.b) == false) goto L10;
        this.b = false;
        this.m = false;
        r();
        this.k = new b(null, 0);
        this.d = y.d.c;
        return;
    L10:
        if ((r4 instanceof y.c.a) == false) goto L16;
        if (this.k.b != 1) goto L14;
        this.m = false;
        r();
        o(r4, 0);
        return;
    L14:
        q(r4, r5);
        return;
    L16:
        if ((r4 instanceof y.d) == false) goto L21;
        q(r4, r5);
        return;
    }

    public final void o(y r5, int r6) {
        jy0.b.c("GiftTransaction", "finish with reason: " + r5 + ", sendCount = " + this.p + ", needOrderNum = " + this.q + ", requireSendCount = " + this.o, null, 4);
        if (this.c == false) goto L5;
        return;
    L5:
        this.b = true;
        if ((this.d instanceof y.d) == false) goto L9;
        this.d = r5;
    L9:
        if ((r5 instanceof y.c.a) == false) goto L12;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.Q(((y.c.a) r5).c, this.x.b, r6);
    L12:
        if ((r5 instanceof y.c.a.i) == false) goto L15;
        m(r5);
        return;
    L15:
        if ((!((HashMap) this.r).isEmpty()) == false) goto L17;
        return;
    L17:
        if (this.m == true) goto L22;
        m(r5);
        return;
    }

    public final void q(y r8, final Function1<? super y, Unit> r9) {
        b r0 = this.k;
        Iterator<s> r1 = r0.a;
        if (r1 != null) goto L5;
    L22:
        jy0.b.c("GiftTransaction", "next plugin when pipeline idle", null, 4);
        return;
    L5:
        if (r0.b == 0) goto L22;
        if (r1.hasNext() == false) goto L20;
        jy0.b.c("GiftTransaction", "ChangeTask currentPipeline is " + this.k.b, null, 4);
        int r2 = this.k.b;
        if (r2 != 1) goto L12;
        r8 = r1.next().b(this, this.j, new GiftTransaction$nextPlugin$1(this, r9));
    L19:
        n(r8, r9);
        return;
    L12:
        if (r2 != 2) goto L14;
        r8 = r1.next().a(this, r8, this.j, new GiftTransaction$nextPlugin$2(this, r9));
        goto L19
    L14:
        if (r2 == 3) goto L16;
        this.k = new b(null, 0);
        goto L19
    L16:
        r1.next().c(this, this.n, this.j, GiftTransaction$nextPlugin$3.INSTANCE);
        goto L19
    L20:
        this.k = new b(null, 0);
        r9.invoke(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r3v163 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v90 */
    /* JADX WARN: Type inference failed for: r3v92 */
    /* JADX WARN: Type inference failed for: r3v93, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28, types: [java.util.ArrayList<com.bytedance.android.livesdk.gift.model.e3>] */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v63 */
    /* JADX WARN: Type inference failed for: r6v64 */
    /* JADX WARN: Type inference failed for: r6v65 */
    /* JADX WARN: Type inference failed for: r6v66 */
    /* JADX WARN: Type inference failed for: r6v67 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v20, types: [java.lang.String] */
    public final int s(int r58, boolean r59) {
        int r0 = r58;
        jy0.b.d("GiftTransaction", "send gift count = " + r0 + ", requireSendCount = " + this.o + ", isReOrder = " + r59 + ", reqIndex= " + this.s);
        if (r0 > 0) goto L7;
        return GiftTransactionReqCount.TransactionBlock.getValue();
    L7:
        if (this.b == false) goto L12;
        if (r59 == true) goto L12;
        this.q += r0;
        return GiftTransactionReqCount.TransactionBlock.getValue();
    L12:
        if (this.m == false) goto L14;
        this.q += r0;
    L23:
        boolean r2 = false;
    L26:
        if (r2 == true) goto L29;
    L52:
        boolean r3 = false;
    L54:
        if (r3 == true) goto L58;
        return GiftTransactionReqCount.TransactionBlock.getValue();
    L58:
        if (this.x.r == false) goto L82;
        i12.e r4 = o.b();
        if (r4 == null) goto L62;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, PropListService.class);
    L63:
        PropListService r6 = (PropListService) r5;
        if (r6 == null) goto L77;
        long r13 = this.x.b;
        List<l2> r7 = r6.a;
        ArrayList r14 = new ArrayList();
        Iterator r8 = ((ArrayList) r7).iterator();
    L67:
        if (r8.hasNext() == false) goto L74;
        Object r15 = r8.next();
        if (((l2) r15).getId() != r13) goto L71;
        boolean r16 = true;
    L72:
        if (r16 == false) goto L67;
        r14.add(r15);
        goto L67
    L71:
        r16 = false;
        goto L72
    L74:
        l2 r9 = (l2) CollectionsKt.firstOrNull(r14);
        if (r9 == null) goto L77;
        int r10 = r9.getCount();
    L78:
        if (r0 == 1) goto L88;
        if (r10 == (-1)) goto L88;
        r0 = RangesKt.coerceAtMost(r0, r10);
    L88:
        int r11 = r0;
        jy0.b.d("GiftTransaction", "real send count = " + r11 + ", isReOrder = " + r59 + ", reqIndex = " + this.s);
        int r17 = this.s;
        String r1 = v12.f.f();
        this.u = r1;
        b0 r18 = this.x;
        i12.e r19 = o.b();
        if (r19 == null) goto L91;
        Object r20 = com.bytedance.android.scope.m.e.d(r19, com.bytedance.android.livesdk.gift.platform.core.ui.configuration.d.class);
    L92:
        com.bytedance.android.livesdk.gift.platform.core.ui.configuration.d r21 = (com.bytedance.android.livesdk.gift.platform.core.ui.configuration.d) r20;
        if (r21 != null) goto L95;
    L97:
        boolean r23 = false;
    L98:
        Map r24 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sticker_effect_closed", Boolean.valueOf(r23))});
        if (r23 != true) goto L101;
        r24.put("sticker_effect_closed_notice_enable", Boolean.valueOf(((Boolean) com.bytedance.android.livesdk.gift.platform.core.ui.configuration.e.b.getValue(null, com.bytedance.android.livesdk.gift.platform.core.ui.configuration.e.a[0])).booleanValue()));
    L101:
        long r110 = r18.b;
        SendGiftSource r25 = r18.c;
        String r111 = r18.g();
        String r112 = String.valueOf(r18.e());
        int r113 = r18.f;
        int r26 = r18.l;
        boolean r114 = r18.o;
        SendGiftStrategy r27 = r18.p;
        int r28 = r18.q;
        boolean r29 = r18.r;
        long r115 = r18.I;
        int r30 = r18.J;
        boolean r31 = r18.v;
        String r33 = r18.k;
        List<IBaseUser> r34 = r18.w;
        h1 r35 = GiftManagerKt.k(r18.b);
        i12.m.a r36 = i12.m.e2;
        i12.d r37 = r36.a();
        if (r37 == null) goto L104;
        Object r38 = com.bytedance.android.scope.m.e.d(r37, GiftPanelTraceService.class);
    L105:
        GiftPanelTraceService r39 = (GiftPanelTraceService) r38;
        if (r39 == null) goto L111;
        String r40 = r39.a.toString();
        if (r40 == null) goto L111;
        String r310 = r40;
    L112:
        i12.d r41 = r36.a();
        if (r41 == null) goto L115;
        Object r43 = com.bytedance.android.scope.m.e.d(r41, GiftPanelTraceService.class);
    L116:
        GiftPanelTraceService r44 = (GiftPanelTraceService) r43;
        if (r44 == null) goto L122;
        JSONObject r45 = r44.c;
        if (r45 == null) goto L122;
        JSONObject r311 = r45;
    L123:
        v12.f.P(r1, new v12.g(r110, r25, r111, r112, r113, r26, r114, r27, r28, r29, r115, r30, r31, r33, r34, r35, r310, r311, r24));
        SendGiftSource r46 = this.x.c;
        SendGiftSource r47 = SendGiftSource.GiftDialog;
        if (r46 == r47) goto L126;
    L153:
        ConcurrentHashMap<String, Map<String, Long>> r48 = v12.e.a;
        SendGiftSource r49 = this.x.c;
        Intrinsics.checkNotNullParameter(r49, "giftSource");
        if (r49 != SendGiftSource.FastGift) goto L156;
        SendGiftSourceValue r50 = SendGiftSourceValue.FastGift;
    L177:
        v12.e.b(r1, "send_source", r50.getValue());
        v12.e.b(r1, "page_type", this.x.y);
        com.bytedance.android.livesdk.gift.platform.core.model.k r51 = this.x.Q;
        if (r51 == null) goto L181;
        v12.e.b(r1, "absolute_index", r51.a);
    L181:
        if (this.x.r == false) goto L194;
        String r53 = this.u;
        long r210 = com.bytedance.live.kmp.util.e.b();
        int r211 = e.a;
        this.w = e.a(this.y, this.z, this, r11).toString();
        tz0.b r54 = tz0.b.a;
        uz0.e r55 = new uz0.e();
        r54.getClass();
        Intrinsics.checkNotNullParameter(r55, "$this$beforeConfigureRequest");
        Map r56 = ((uz0.a) r55).b;
        Intrinsics.checkNotNullParameter(r56, "queriesMap");
        String r116 = Long.valueOf(this.x.d()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r116 == null) goto L185;
        r56.put("room_id", r116);
    L185:
        uz0.b r57 = new uz0.b(r55.e);
        r57.a("prop_def_id", Long.valueOf(this.x.b).toString());
        r57.a("count", Integer.valueOf(r11).toString());
        r57.a("to_open_id", this.x.g());
        r57.a("send_type", Integer.valueOf(this.x.f).toString());
        r57.a("send_prop_scene", Integer.valueOf(this.x.J).toString());
        r57.a("to_room_id", Long.valueOf(this.x.e()).toString());
        r57.a("is_aweme_free_gift", Long.valueOf(this.x.t).toString());
        String r60 = this.w;
        if (r60 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("extraSourceString");
    L188:
        r57.a("tags_extra", r60);
        r57.a("room_anchor_id", this.x.c());
        r57.a("ref_id", this.x.s);
        Long r61 = this.x.d0;
        if (r61 == null) goto L192;
        String r63 = String.valueOf(r61.longValue());
        if (r63 == null) goto L192;
    L193:
        r57.a("video_linkmic_room_id", r63);
        Map r64 = ((uz0.a) r55).a;
        Intrinsics.checkNotNullParameter(r64, "headersMap");
        Intrinsics.checkNotNullParameter("rpc-persist-webcast-trace-id", "$this$setTo");
        Intrinsics.checkNotNullParameter(r53, "value");
        r64.put("rpc-persist-webcast-trace-id", r53);
        Intrinsics.checkNotNullParameter(r55, "$this$afterConfigureRequest");
        Disposable r65 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(r54.b(), "/webcast/props/consume/", TypesJVMKt.getJavaType(Reflection.typeOf(m2.class)), Extra.class, ((uz0.a) r55).d, ((uz0.a) r55).a, ((uz0.a) r55).b, ((uz0.a) r55).c, r55.e, r55.f, r55.g).compose(RxUtil.rxSchedulerHelper()).doOnSubscribe(new k(this, r53, r11)).subscribe(new l(this, r17, r11, r210, r53), new m(this, r53, r11, r17, r210));
        Map<Integer, Disposable> r66 = this.r;
        int r67 = this.s;
        Intrinsics.checkNotNullParameter(r65, "$this$bind");
        Intrinsics.checkNotNullParameter(r66, "reqMap");
        ((HashMap) r66).put(Integer.valueOf(r67), r65);
        GiftTransaction r117 = this;
    L455:
        int r68 = r117.s;
        r117.s = r68 + 1;
        return r68;
    L192:
        r63 = BuildConfig.FLAVOR;
        goto L193
    L194:
        int r69 = r11;
        String r70 = this.u;
        this.t += r69;
        int r71 = e.a;
        this.w = e.a(this.y, this.z, this, r69).toString();
        Lazy r73 = GiftFrequencyUtils.a;
        int r74 = this.t;
        String r75 = this.x.k;
        Intrinsics.checkNotNullParameter(this, "$this$getExtraWithComboCount");
        Intrinsics.checkNotNullParameter(r75, "extra");
        Result.Companion r212 = Result.Companion;     // Catch: Throwable -> L201
        String r213 = "tags_extra";
        Object r76 = Result.constructor-impl(new JSONObject(r75));     // Catch: Throwable -> L199
    L205:
        if (Result.isFailure-impl(r76) == false) goto L207;
        r76 = null;
    L207:
        JSONObject r77 = (JSONObject) r76;
        if (r77 != null) goto L210;
        r77 = new JSONObject();
    L210:
        r77.put("total_count", String.valueOf(r74));
        r77.put("ds_alert_controller", 1);
        String r78 = r77.toString();
        Lazy r79 = GiftFrequencyUtils.a;
        long r80 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).S6();
        long r118 = this.x.d();
        Intrinsics.checkNotNullParameter(this, "$this$getExtraWithCameraGroupId");
        Intrinsics.checkNotNullParameter(r78, "extra");
        Object r81 = Result.constructor-impl(new JSONObject(r78));     // Catch: Throwable -> L213
    L216:
        if (Result.isFailure-impl(r81) == false) goto L218;
        r81 = null;
    L218:
        JSONObject r83 = (JSONObject) r81;
        if (r83 != null) goto L221;
        r83 = new JSONObject();
    L221:
        JSONObject r119 = r83;
        String r84 = r119.optString("vs");
        if (r84 != null) goto L224;
        String r214 = "count";
    L471:
        Object r85 = null;
    L269:
        th = th;
    L273:
        Result.Companion r86 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L274:
        String r87 = r119.toString();
        if (this.x.y != 2) goto L309;
        Lazy r88 = GiftFrequencyUtils.a;
        Intrinsics.checkNotNullParameter(this, "$this$getExtraWithFansClub");
        Intrinsics.checkNotNullParameter(r87, "extra");
        Object r89 = Result.constructor-impl(new JSONObject(r87));     // Catch: Throwable -> L279
    L282:
        if (Result.isFailure-impl(r89) == false) goto L284;
        r89 = r85;
    L284:
        JSONObject r90 = (JSONObject) r89;
        if (r90 != null) goto L287;
        r90 = new JSONObject();
    L287:
        JSONObject r91 = r90;
        com.bytedance.android.live.profit.fansclub.o r93 = yt0.c.c();     // Catch: JSONException -> L306
        if (r93 == null) goto L308;
        com.bytedance.live.datacontext.m r94 = r93.getExtra();     // Catch: JSONException -> L306
        if (r94 == null) goto L308;
        Map r95 = (Map) r94.getValue();     // Catch: JSONException -> L306
        if (r95 == null) goto L308;
        String r96 = (String) r95.get("fansclub_send_gift");     // Catch: JSONException -> L306
        if (r96 == null) goto L308;
        if (r96.length() <= 0) goto L299;
        boolean r120 = true;
    L300:
        if (r120 == false) goto L302;
        Object r97 = r96;
    L303:
        if (r97 == null) goto L308;
        r91.put("fansclub_send_gift", r97);     // Catch: JSONException -> L306
        goto L308
    L302:
        r97 = r85;
        goto L303
    L299:
        r120 = false;
    L308:
        r87 = r91.toString();
    L306:
        e = move-exception;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("getExtraWithComboCount", "fansclub_send_gift error = " + e);
    L279:
        th = move-exception;
        Result.Companion r98 = Result.Companion;
        r89 = Result.constructor-impl(ResultKt.createFailure(th));
    L309:
        b0 r99 = this.x;
        Object r100 = r99.w;
        if (r99.v == false) goto L312;
    L315:
        boolean r101 = true;
    L316:
        if (r101 == true) goto L319;
        r100 = r85;
    L319:
        if (r100 == null) goto L328;
        Iterable r102 = (Iterable) r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L322:
        if (r104.hasNext() == false) goto L465;
        r103.add(((IBaseUser) r104.next()).getIdString());
        goto L322
    L465:
        String r105 = GsonProtectorUtils.toJson(GsonHelper.get(), r103);     // Catch: JsonParseException -> L326
    L327:
        Object r121 = r105;
    L329:
        p2 r106 = this.n;
        if (r106 == null) goto L385;
        v2 r107 = r106.getNextSendParams();
        if (r107 == null) goto L334;
        int r108 = r107.a();
    L335:
        if (r108 <= 0) goto L345;
        v2 r109 = r106.getNextSendParams();
        if (r109 != null) goto L339;
    L340:
        b0 r122 = this.x;
        v2 r123 = r106.getNextSendParams();
        if (r123 == null) goto L343;
        int r124 = r123.a();
    L344:
        r122.l = r124;
        this.v = true;
        goto L385
    L343:
        r124 = 0;
        goto L344
    L339:
        if (r109.a() != this.x.l) goto L340;
    L345:
        v2 r125 = r106.getNextSendParams();
        if (r125 == null) goto L348;
        ?? r126 = r125.c();
    L350:
        if (TextUtils.isEmpty(r126) == false) goto L457;
    L368:
        v2 r127 = r106.getNextSendParams();
        if (r127 == null) goto L371;
        ?? r128 = r127.b();
    L373:
        if (TextUtils.isEmpty(r128) == true) goto L385;
        v2 r129 = r106.getNextSendParams();
        if (r129 == null) goto L377;
        ?? r130 = r129.b();
    L379:
        if (TextUtils.equals(r130, this.x.M) == true) goto L385;
        b0 r131 = this.x;
        v2 r132 = r106.getNextSendParams();
        if (r132 == null) goto L383;
        ?? r133 = r132.b();
    L384:
        r131.M = r133;
        this.v = true;
        goto L385
    L383:
        r133 = r85;
        goto L384
    L377:
        r130 = r85;
        goto L379
    L371:
        r128 = r85;
        goto L373
    L457:
        v2 r134 = r106.getNextSendParams();     // Catch: JSONException -> L367
        if (r134 == null) goto L354;
        ?? r135 = r134.c();     // Catch: JSONException -> L367
    L355:
        ArrayList<e3> r136 = gz1.c.d(new JSONArray(r135));     // Catch: JSONException -> L367
        if ((!r136.isEmpty()) == true) goto L358;
    L360:
        boolean r137 = false;
    L361:
        if (r137 == false) goto L363;
        ?? r138 = r136;
    L364:
        if (r138 == 0) goto L368;
        this.x.n = r138;     // Catch: JSONException -> L367
        this.v = true;     // Catch: JSONException -> L367
        goto L368
    L363:
        r138 = r85;
        goto L364
    L358:
        if (gz1.c.h(r136, this.x.n) == true) goto L360;
        r137 = true;
        goto L361
    L354:
        r135 = r85;
        goto L355
    L348:
        r126 = r85;
        goto L350
    L334:
        r108 = 0;
    L385:
        b0 r139 = this.x;
        r139.getClass();
        LinkedHashMap r140 = new LinkedHashMap();
        b0.a(r140, "error_room_id", r139.D);
        SendGiftSource r141 = r139.c;
        if (r141 != SendGiftSource.JsbPage) goto L388;
    L389:
        IBaseUser r142 = r139.d;
        if (r142 == null) goto L392;
        Intrinsics.checkNotNullParameter(r142, "$this$secUidExt");
        Object r143 = r142.getCastSecUid();
    L393:
        b0.a(r140, "error_sec_uid", r143);
        IBaseUser r144 = r139.d;
        if (r144 == null) goto L396;
        Object r145 = r144.getIdString();
    L397:
        b0.a(r140, "error_to_user_id", r145);
    L398:
        b0.a(r140, "error_to_room_id", r139.e);
        b0.a(r140, "error_gift_id", Long.valueOf(r139.b));
        boolean r146 = !r140.isEmpty();
        ?? r147 = r140;
        if (r146 == true) goto L403;
        r147 = r85;
    L403:
        if (r147 == 0) goto L418;
        i12.e r148 = o.b();
        if (r148 == null) goto L407;
        r85 = com.bytedance.android.scope.m.e.d(r148, n.class);
    L407:
        n r149 = (n) r85;
        if (r149 == null) goto L418;
        Long r150 = Long.valueOf(this.x.b);
        String r151 = this.x.g();
        SendGiftSource r152 = this.x.c;
        Intrinsics.checkNotNullParameter(r147, "errorMap");
        Intrinsics.checkNotNullParameter(r151, "toUserId");
        Intrinsics.checkNotNullParameter(r152, "sendGiftSource");
        long r312 = r149.d.getRoom().getId();
        String r153 = r149.d.getUser().getIdString();
        if (v.a() == false) goto L413;
        f2.c("GiftTransaction param error: " + CollectionsKt.joinToString$default(r147.keySet(), ",", null, null, 0, null, GiftTransactionMonitor$reportGiftParamsError$1.INSTANCE, 30, null), 0);
    L413:
        String r154 = r149.a;
        mz0.n r155 = new mz0.n();
        mz0.o r156 = new mz0.o(r155.a);
        r156.a("error_param", CollectionsKt.joinToString$default(r147.keySet(), ",", null, null, 0, null, GiftTransactionMonitor$reportGiftParamsError$2$1$1.INSTANCE, 30, null));
        r156.a("room_id", String.valueOf(r312));
        r156.a("user_id", r153);
        r156.a("gift_id", String.valueOf(r150));
        r156.a("to_user_id", r151);
        r156.a("send_gift_source", r152.toString());
        r156.b(r147);
        cy0.e.a.getClass();
        cy0.j r157 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r158 = com.bytedance.android.scope.m.b(r157).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r158);
        ((f80.a) r158).w3(r154, r155.a, r155.b);
        String r159 = r149.b;
        JSONObject r160 = new JSONObject();
        JSONObject r161 = new JSONObject();
        JSONObject r162 = new JSONObject();
        Intrinsics.checkNotNullParameter(r162, "extra");
        Intrinsics.checkNotNullParameter(r161, "metric");
        EventModule r163 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r163, "eventModule");
        String r410 = r163.getValue();
        r161.put("status", String.valueOf(r149.c));
        Intrinsics.checkNotNullParameter(r160, "map");
        String r164 = CollectionsKt.joinToString$default(r147.keySet(), ",", null, null, 0, null, GiftTransactionMonitor$reportGiftParamsError$3$2$1.INSTANCE, 30, null);
        Intrinsics.checkNotNullParameter("error_param", "key");
        Intrinsics.checkNotNullParameter(r164, "value");
        r160.put("error_param", r164);
        Intrinsics.checkNotNullParameter(r162, "map");
        Long r165 = Long.valueOf(r312);
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r165, "value");
        r162.put("room_id", r165);
        Intrinsics.checkNotNullParameter("user_id", "key");
        Intrinsics.checkNotNullParameter(r153, "value");
        r162.put("user_id", r153);
        String r166 = String.valueOf(r150);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r166, "value");
        r162.put("gift_id", r166);
        Intrinsics.checkNotNullParameter("to_user_id", "key");
        Intrinsics.checkNotNullParameter(r151, "value");
        r162.put("to_user_id", r151);
        String r167 = r152.toString();
        Intrinsics.checkNotNullParameter("send_gift_source", "key");
        Intrinsics.checkNotNullParameter(r167, "value");
        r162.put("send_gift_source", r167);
        Intrinsics.checkNotNullParameter(r147, "value");
        Iterator r168 = r147.entrySet().iterator();
    L415:
        if (r168.hasNext() == false) goto L417;
        Map.Entry r169 = (Map.Entry) r168.next();
        r162.put((String) r169.getKey(), r169.getValue());
        goto L415
    L417:
        Object r170 = com.bytedance.android.scope.m.b(r157).b(n97.a.class);
        Intrinsics.checkNotNull(r170);
        ((com.bytedance.live.kmp.core.c) r170).g(r159, r410, "bussiness_api_call", r160, r161, r162);
    L419:
        long r171 = com.bytedance.live.kmp.util.e.b();
        tz0.b r172 = tz0.b.a;
        uz0.e r173 = new uz0.e();
        r172.getClass();
        Intrinsics.checkNotNullParameter(r173, "$this$beforeConfigureRequest");
        Map r174 = ((uz0.a) r173).b;
        Intrinsics.checkNotNullParameter(r174, "queriesMap");
        r117 = this;
        String r175 = Long.valueOf(r117.x.d()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r175 == null) goto L422;
        r174.put("room_id", r175);
    L422:
        uz0.b r176 = new uz0.b(r173.e);
        r176.a("gift_id", Long.valueOf(r117.x.b).toString());
        r176.a(r214, Integer.valueOf(r69).toString());
        r176.a("to_open_id", r117.x.g());
        if (r121 != null) goto L425;
        ?? r177 = BuildConfig.FLAVOR;
    L426:
        r176.a("to_user_ids", r177);
        r176.a("send_type", Integer.valueOf(r117.x.f).toString());
        r176.a("send_scene", Integer.valueOf(r117.x.J).toString());
        r176.a("to_room_id", Long.valueOf(r117.x.e()).toString());
        r176.a("gift_source", Integer.valueOf(r117.x.g).toString());
        r176.a("trigger_word", r117.x.j);
        r176.a("extra", r87);
        r176.a("buff_level", Integer.valueOf(r117.x.l).toString());
        if (r117.s != 0) goto L429;
        boolean r178 = true;
    L430:
        r176.a("is_first_combo", String.valueOf(r178));
        r176.a("to_episode_id", Long.valueOf(r117.x.I).toString());
        String r179 = r117.w;
        if (r179 != null) goto L433;
        Intrinsics.throwUninitializedPropertyAccessException("extraSourceString");
    L433:
        r176.a(r213, r179);
        r176.a("plugin_info", gz1.c.b(r117.x.n));
        r176.a("room_anchor_id", r117.x.c());
        Long r180 = r117.x.d0;
        if (r180 == null) goto L437;
        String r181 = String.valueOf(r180.longValue());
        if (r181 == null) goto L437;
    L438:
        r176.a("video_linkmic_room_id", r181);
        r176.a("send_time", Long.valueOf(com.bytedance.live.kmp.util.e.b()).toString());
        r176.a("config_id", Long.valueOf(r117.x.K).toString());
        String r182 = r117.x.M;
        if (r182 != null) goto L441;
        r182 = BuildConfig.FLAVOR;
    L441:
        r176.a("toolbar_card_name", r182);
        List<k3> r183 = r117.x.z;
        if (r183 == null) goto L444;
        String r184 = GsonProtectorUtils.toJson(GsonHelper.get(), r183);
    L445:
        r176.a("series_gift_list", r184);
        String r185 = r117.x.a;
        if (r185 != null) goto L448;
    L451:
        boolean r186 = true;
    L452:
        if (r186 == true) goto L454;
        String r187 = r117.x.a;
        Intrinsics.checkNotNull(r187);
        r176.a("gift_combo_id", r187);
    L454:
        Map r188 = ((uz0.a) r173).a;
        Intrinsics.checkNotNullParameter(r188, "headersMap");
        Intrinsics.checkNotNullParameter("rpc-persist-webcast-trace-id", "$this$setTo");
        Intrinsics.checkNotNullParameter(r70, "value");
        r188.put("rpc-persist-webcast-trace-id", r70);
        r173.a(new com.bytedance.android.livesdk.gift.platform.core.interceptor.a());
        Intrinsics.checkNotNullParameter(r173, "$this$afterConfigureRequest");
        int r189 = r69;
        Disposable r190 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(r172.b(), "/webcast/gift/send/", TypesJVMKt.getJavaType(Reflection.typeOf(p2.class)), MinorExtra.class, ((uz0.a) r173).d, ((uz0.a) r173).a, ((uz0.a) r173).b, ((uz0.a) r173).c, r173.e, r173.f, r173.g).compose(RxUtil.rxSchedulerHelper()).doOnSubscribe(new h(this, r189, r171, r70, r121)).subscribe(new i(this, r70, r17, r189, r171), new j(this, r70, r189, r17, r171));
        Map<Integer, Disposable> r191 = r117.r;
        Intrinsics.checkNotNullParameter(r190, "$this$bind");
        Intrinsics.checkNotNullParameter(r191, "reqMap");
        ((HashMap) r191).put(Integer.valueOf(r17), r190);
        goto L455
    L448:
        if (StringsKt.isBlank(r185) == true) goto L451;
        r186 = false;
        goto L452
    L444:
        r184 = BuildConfig.FLAVOR;
    L437:
        r181 = BuildConfig.FLAVOR;
        goto L438
    L429:
        r178 = false;
        goto L430
    L425:
        r177 = r121;
    L418:
        r69 = r69;
        r121 = r121;
        goto L419
    L396:
        r145 = r85;
        goto L397
    L392:
        r143 = r85;
        goto L393
    L388:
        if (r141 != SendGiftSource.GiftDialog) goto L398;
    L326:
        r105 = BuildConfig.FLAVOR;
        goto L327
    L328:
        r121 = r85;
        goto L329
    L312:
        if (r99.x == true) goto L315;
        r101 = false;
        goto L316
    L248:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.g.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[5])).booleanValue() == false) goto L274;
        IGroupLiveService r192 = (IGroupLiveService) jc1.k.f(IGroupLiveService.class);     // Catch: Throwable -> L269
        if (r192 == null) goto L253;
        Map<String, String> r193 = r192.getCloudCollaborateExtraParams(r118);     // Catch: Throwable -> L269
    L254:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftFrequencyUtils", "fillCloudDirectorExtraParams = " + r118 + ", extraMap is " + r193);     // Catch: Throwable -> L269
        if (r193 != null) goto L257;
    L260:
        boolean r194 = true;
    L261:
        if (r194 == true) goto L267;
        JSONObject r195 = new JSONObject();     // Catch: Throwable -> L269
        Iterator<Map.Entry<String, String>> r196 = r193.entrySet().iterator();     // Catch: Throwable -> L269
    L264:
        if (r196.hasNext() == false) goto L266;
        Map.Entry<String, String> r197 = r196.next();     // Catch: Throwable -> L269
        r195.put(r197.getKey(), r197.getValue());     // Catch: Throwable -> L269
        goto L264
    L266:
        r119.put("cloud_director_v2", r195.toString());     // Catch: Throwable -> L269
    L267:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L269
        goto L274
    L257:
        if (r193.isEmpty() == true) goto L260;
        r194 = false;
        goto L261
    L253:
        r193 = null;
    L271:
        th = th;
        r85 = null;
        goto L273
    L224:
        if (r84.length() != 0) goto L226;
        boolean r313 = true;
    L227:
        r214 = "count";
        if ((!r313) == false) goto L230;
        String r198 = r84;
    L231:
        if (r198 == null) goto L471;
        Object r199 = Result.constructor-impl(new JSONObject(r198));     // Catch: Throwable -> L234
    L237:
        if (Result.isFailure-impl(r199) == false) goto L239;
        r199 = null;
    L239:
        JSONObject r200 = (JSONObject) r199;
        if (r200 == null) goto L242;
        r200.put("group_id", r80);
        r198 = r200.toString();
    L242:
        r119.put("vs", r198);
    L234:
        th = move-exception;
        Result.Companion r215 = Result.Companion;
        r199 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L237
    L230:
        r198 = null;
        goto L231
    L226:
        r313 = false;
    L213:
        th = move-exception;
        Result.Companion r1100 = Result.Companion;
        r81 = Result.constructor-impl(ResultKt.createFailure(th));
    L199:
        th = th;
    L203:
        Result.Companion r1101 = Result.Companion;
        r76 = Result.constructor-impl(ResultKt.createFailure(th));
    L201:
        th = th;
        r213 = "tags_extra";
        goto L203
    L156:
        if (r49 != r47) goto L159;
        r50 = SendGiftSourceValue.GiftDialog;
        goto L177
    L159:
        if (r49 != SendGiftSource.Guide) goto L162;
        r50 = SendGiftSourceValue.Guide;
        goto L177
    L162:
        if (r49 != SendGiftSource.JsbPage) goto L165;
        r50 = SendGiftSourceValue.JsbPage;
        goto L177
    L165:
        if (r49 != SendGiftSource.RedPacketGiftGuide) goto L168;
        r50 = SendGiftSourceValue.RedPacketGiftGuide;
        goto L177
    L168:
        if (r49 != SendGiftSource.Schema) goto L171;
        r50 = SendGiftSourceValue.Schema;
        goto L177
    L171:
        if (r49 != SendGiftSource.Comment) goto L174;
        r50 = SendGiftSourceValue.Comment;
        goto L177
    L174:
        if (r49 != SendGiftSource.MessageBoard) goto L176;
        r50 = SendGiftSourceValue.MessageBoard;
        goto L177
    L176:
        r50 = SendGiftSourceValue.UnKnow;
        goto L177
    L126:
        if (this.s != 0) goto L153;
        ConcurrentHashMap<String, Map<String, Long>> r201 = v12.e.a;
        Intrinsics.checkNotNullParameter(r1, "transactionId");
        if (com.bytedance.android.livesdk.gift.platform.core.h.p() == false) goto L153;
        if (u.r() == true) goto L143;
        i12.e r202 = o.b();
        if (r202 == null) goto L135;
        Object r203 = com.bytedance.android.scope.m.e.d(r202, g1.class);
    L136:
        g1 r204 = (g1) r203;
        if (r204 == null) goto L141;
        s0 r205 = r204.e;
        if (r205 == null) goto L141;
        long r206 = r205.a;
    L142:
        v12.e.b(r1, "open_dialog", r206);
    L141:
        r206 = 0;
        goto L142
    L135:
        r203 = null;
        goto L136
    L143:
        GiftContext r207 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r207 == null) goto L148;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r208 = r207.getLastEventTimeStamp();
        if (r208 == null) goto L148;
        com.bytedance.android.livesdk.gift.platform.core.i r209 = (com.bytedance.android.livesdk.gift.platform.core.i) r208.getValue();
    L149:
        if (r209 == null) goto L151;
        long r216 = r209.a;
    L152:
        v12.e.b(r1, "open_dialog", r216);
        goto L153
    L151:
        r216 = 0;
    L148:
        r209 = null;
    L122:
        r311 = null;
        goto L123
    L115:
        r43 = null;
    L111:
        r310 = BuildConfig.FLAVOR;
        goto L112
    L104:
        r38 = null;
        goto L105
    L95:
        if (r21.b == null) goto L97;
        r23 = true;
        goto L98
    L91:
        r20 = null;
    L77:
        r10 = -1;
        goto L78
    L62:
        r5 = null;
        goto L63
    L82:
        if (com.bytedance.android.livesdk.gift.platform.business.b.g() == false) goto L88;
        if (r59 == false) goto L88;
        long r1102 = RangesKt.coerceAtLeast(jc1.k.n(IRechargeService.class).rechargeCenter().getAvailableDiamonds() / p(), this.x.q);
        long r1103 = r0;
        if (r1103 == r1102) goto L87;
        jy0.b.c("GiftTransaction", "count = " + r0 + ", maxCount = " + r1102, null, 4);
    L87:
        r0 = (int) RangesKt.coerceAtMost(r1103, r1102);
        goto L88
    L29:
        if (this.x.b <= 0) goto L52;
        d r217 = this.a;
        Disposable r218 = r217.a;
        if (r218 == null) goto L34;
        r218.dispose();
    L34:
        com.bytedance.android.live.core.utils.rxutils.j.a r219 = com.bytedance.android.live.core.utils.rxutils.j.a;
        r217.a = com.bytedance.android.live.core.utils.rxutils.j.c(30, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r217));
        if (this.x.r == false) goto L38;
    L49:
        boolean r220 = false;
    L50:
        if (r220 == false) goto L53;
        o(new y.c.a.g(new ApiException(40001), r0), 0);
        goto L52
    L53:
        r3 = true;
        goto L54
    L38:
        if (jc1.k.n(IRechargeService.class).rechargeCenter().isSyncWalletInfoSuccess() == false) goto L49;
        if (jc1.k.n(IRechargeService.class).rechargeCenter().isDiamondAvailable(p() * ((long) this.x.q)) == true) goto L49;
        h2 r221 = a().a;
        if (r221 == null) goto L48;
        k0 r222 = r221.getGiftPreviewInfo();
        if (r222 == null) goto L48;
        if (r222.getClientCheckLeftDiamond() == false) goto L49;
    L48:
        r220 = true;
        goto L50
    L14:
        b0 r223 = this.x;
        if ((r0 % r223.q) == 0) goto L18;
        o(new y.c.a.f(), 0);
        goto L23
    L18:
        if (g.a[r223.p.ordinal()] == 1) goto L21;
    L24:
        r2 = true;
        goto L26
    L21:
        if ((!((HashMap) this.r).isEmpty()) == false) goto L24;
        this.q += r0;
        goto L23
    }

    public GiftTransaction(b0 r2, IRoom r3, DataCenter r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "giftParams");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.x = r2;
        this.y = r3;
        this.z = r4;
        this.A = r5;
        this.a = new d(new GiftTransaction$timer$1(this));
        this.d = y.d.c;
        this.e = PublishSubject.create();
        this.f = PublishSubject.create();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new b(null, 0);
        this.l = new ArrayList();
        this.r = new HashMap();
        this.u = BuildConfig.FLAVOR;
    }

    public static final void j(GiftTransaction r17, Throwable r18, int r19, int r20, String r21) {
        r17.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("count", r19);
        r2.put("requestIndex", r20);
        r2.put("throwable", r18.getMessage());
        String r3 = v12.f.a;
        if (r21 != null) goto L5;
        String r4 = "0";
    L6:
        v12.f.Q(r4, r2);
        if (r21 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        v12.e.f(r21);
    L15:
        i12.e r6 = o.b();
        if (r6 == null) goto L18;
        Object r7 = com.bytedance.android.scope.m.e.d(r6, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
    L19:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.n r8 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r7;
        if (r8 == null) goto L22;
        r8.a();
    L22:
        i12.e r9 = o.b();
        if (r9 == null) goto L25;
        Object r10 = com.bytedance.android.scope.m.e.d(r9, d0.class);
    L26:
        d0 r11 = (d0) r10;
        if (r11 == null) goto L29;
        r11.c();
        r11.a();
    L29:
        Throwable r13 = r18;
        if ((r13 instanceof Exception) == true) goto L32;
        r13 = null;
    L32:
        ApiException r14 = (Exception) r13;
        if (r14 == null) goto L93;
        Intrinsics.checkNotNullParameter(r17, "info");
        Intrinsics.checkNotNullParameter(r14, "exception");
        long r15 = r17.x.b;
        GiftContext r16 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r16 == null) goto L40;
        HashSet r110 = new HashSet(1);
        r110.add(Long.valueOf(r15));
        Iterator r23 = ((Set) r16.getGiftSendResultListeners().getValue()).iterator();
    L38:
        if (r23.hasNext() == false) goto L40;
        ((ca0.s) r23.next()).j(new f(r110, 0, false, r14, null));
    L40:
        b0 r24 = r17.x;
        if (r24.r == false) goto L46;
        c0 r25 = c0.a;
        long r26 = r24.b;
        long r27 = r24.d();
        Intrinsics.checkNotNullParameter(r14, "error");
        JSONObject r28 = new JSONObject();
        c0.r(r28, "room_id", Long.valueOf(r27));
        c0.r(r28, "prop_id", Long.valueOf(r26));
        c0.r(r28, "error_code", Integer.valueOf(r0.a(r14)));
        String r29 = r14.getMessage();
        if (r29 != null) goto L45;
        r29 = BuildConfig.FLAVOR;
    L45:
        c0.r(r28, "error_msg", r29);
        r25.p("ttlive_prop_send_status", r28);
    L47:
        Disposable r30 = (Disposable) ((HashMap) r17.r).remove(Integer.valueOf(r20));
        if (r30 == null) goto L50;
        r30.dispose();
    L50:
        Intrinsics.checkNotNullParameter(r17, "info");
        Intrinsics.checkNotNullParameter(r14, "e");
        com.bytedance.android.livesdk.gift.platform.business.g r31 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r31 != null) goto L53;
    L89:
        Object r33 = null;
        y r34 = new y.c.a.e(AiStrategyInsertErrorCode.RECEIVER_IS_NOT_ANCHOR, "context null");
    L90:
        r17.o(r34, r0.a(r14));
        if (com.bytedance.android.livesdk.gift.platform.business.b.g() == false) goto L99;
        r17.r();
    L99:
        long r0 = com.bytedance.live.kmp.util.e.b();
        i12.e r35 = o.b();
        if (r35 == null) goto L102;
        Object r36 = com.bytedance.android.scope.m.e.d(r35, d1.class);
    L103:
        d1 r37 = (d1) r36;
        if (r37 == null) goto L108;
        r37.b = r0;
        return;
    L108:
        return;
    L102:
        r36 = r33;
        goto L103
    L53:
        if (r31.getContext() == null) goto L89;
        if ((r14 instanceof ApiServerException) == false) goto L73;
        ApiServerException r38 = (ApiServerException) r14;
        if (r38.getErrorCode() != 40001) goto L62;
        r34 = new y.c.a.g(r14, r19);
    L60:
        r33 = null;
        goto L90
    L62:
        if (r38.getErrorCode() != 4006080) goto L64;
    L72:
        r34 = new y.c.a.b(r14);
        goto L60
    L64:
        if (r38.getErrorCode() == 4006081) goto L72;
        if (r38.getErrorCode() == 4006082) goto L72;
        if (r38.getErrorCode() != 4006085) goto L71;
        r34 = new y.c.a.d(r14);
        goto L60
    L71:
        r34 = new y.c.a.C0067a(r14, false, AiStrategyInsertErrorCode.NOT_FIND_GIFT);
        goto L60
    L73:
        jy0.b.c("giftException", "gift exception" + r14.getStackTrace(), null, 4);
        if (r17.x.r == true) goto L81;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.d.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[2])).booleanValue() == false) goto L81;
        if ((r14 instanceof IOException) == false) goto L81;
        r34 = y.c.a.h.d;
    L81:
        if (r17.x.r == false) goto L87;
        r33 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.e.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[3])).booleanValue() == true) goto L85;
    L88:
        ToastUtil.a(2131922449, 0);
        r34 = new y.c.a.e(AiStrategyInsertErrorCode.SCENE_MISMATCH, "other failure");
        goto L90
    L85:
        if ((r14 instanceof IOException) == false) goto L88;
        r34 = y.c.a.h.d;
        goto L90
    L87:
        r33 = null;
        goto L88
    L46:
        c0.a.k(r24.b, r24.d(), r14, r17.x.f());
        goto L47
    L93:
        r33 = null;
        Disposable r1 = (Disposable) ((HashMap) r17.r).remove(Integer.valueOf(r20));
        if (r1 == null) goto L96;
        r1.dispose();
    L96:
        r17.o(new y.c.a.e(AiStrategyInsertErrorCode.SCENE_NOT_SUPPORT_INSERT, "unknown reason"), -1);
        if (com.bytedance.android.livesdk.gift.platform.business.b.g() == false) goto L99;
        r17.r();
        goto L99
    L25:
        r10 = null;
        goto L26
    L18:
        r7 = null;
        goto L19
    L9:
        if (r21.length() == 0) goto L12;
        r5 = false;
        goto L13
    L5:
        r4 = r21;
        goto L6
    }

    public static final void k(GiftTransaction r38, p2 r39, int r40, int r41, long r43, long r44) {
        r38.n = r39;
        String r1 = v12.f.a;
        String r2 = r39.getTraceId();
        if (r2 != null) goto L5;
        String r3 = "0";
    L6:
        String r4 = r39.getLogId();
        if (r4 != null) goto L9;
        String r5 = "0";
    L10:
        v12.f.R(r39, r3, r5, r43, r44);
        ConcurrentHashMap<String, Map<String, Long>> r6 = v12.e.a;
        v12.e.b(r39.getTraceId(), "send_success", com.bytedance.live.kmp.util.e.b());
        p2 r7 = r38.n;
        b0 r8 = r38.x;
        if (r8.v == true) goto L13;
        int r9 = r40;
    L26:
        r38.p += r9;
        h2 r10 = GiftManagerKt.l(r38.x.b);
        if (r10 == null) goto L31;
        p2 r11 = r38.n;
        if (r11 == null) goto L31;
        r11.setConsumeDiamonds(r10.getDiamondCount() * r9);
    L31:
        long r13 = r9;
        long r14 = r38.p() * r13;
        Intrinsics.checkNotNullParameter(r38, "info");
        Intrinsics.checkNotNullParameter(r39, "result");
        b0 r15 = r38.x;
        IBaseUser r16 = r15.f();
        List<IBaseUser> r17 = r15.w;
        if (r17 == null) goto L45;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L35:
        if (r19.hasNext() == false) goto L40;
        Object r110 = r19.next();
        if (Intrinsics.areEqual(((IBaseUser) r110).getIdString(), r39.getMultiSendToUserId().toString()) == false) goto L35;
        r18.add(r110);
        goto L35
    L40:
        if ((!r18.isEmpty()) == true) goto L43;
        r18 = null;
    L43:
        if (r18 == null) goto L45;
        r16 = (IBaseUser) ListProtector.get(r18, 0);
    L45:
        ProfitCheckConfig r20 = r39.getProfitCheckConfig();
        String r21 = "room_id";
        String r111 = "log_id";
        if (r20 == null) goto L63;
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("log_id", r39.getLogId());
        String r113 = "result";
        r112.put("trace_id", r39.getTraceId());
        r112.put("to_user_id", r16.getIdString());
        boolean r23 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class).w(r112, r20);
        LinkedHashMap r24 = new LinkedHashMap();
        yz0.k r25 = u.h();
        if (r25 == null) goto L64;
        IRoom r26 = r25.getRoom();
        if (r26 == null) goto L64;
        r24.put("from_user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString());
        r24.put("to_user_id", r15.f().getIdString());
        String r114 = r26.getAnchorId();
        if (r114 != null) goto L55;
        r114 = BuildConfig.FLAVOR;
    L55:
        r24.put("anchor_id", r114);
        r24.put("gift_id", Long.valueOf(r15.b));
        r24.put("room_id", Long.valueOf(r26.getRoomId()));
        r24.put("to_room_id", Long.valueOf(r15.f().getLiveRoomId()));
        r24.put("price", Long.valueOf(r14));
        r24.put("buff_level", Integer.valueOf(r15.l));
        r24.put("plugin_info", gz1.c.a(r15.n, 0));
        com.bytedance.android.livesdk.gift.platform.core.model.n r27 = r15.C;
        if (r27 == null) goto L62;
        py.k r28 = r27.a;
        if (r28 == null) goto L62;
        String r29 = r28.getUri();
        if (r29 == null) goto L62;
        r24.put("gift_icon", r29);
    L62:
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class).B1(ProfitCheckType.CONSUME_REQUEST, r24, null);
    L64:
        DataCenter r30 = r38.a().c;
        b0 r31 = r38.x;
        IRoom r33 = r31.H;
        IBaseUser r34 = r31.f();
        List<IBaseUser> r35 = r38.x.w;
        if (r33 != null) goto L67;
        JSONObject r36 = new JSONObject();
        r36.put("error", "room is null");
        r36.put("toUser", r34.getIdString());
        String r37 = v12.f.a;
        v12.f.q(r39.getTraceId(), r36);
        String r210 = "room_id";
        long r211 = r13;
        String r212 = "log_id";
    L146:
        r38.a();
        jc1.k.n(IRechargeService.class).rechargeCenter().setAvailableDiamonds(r39.getLeftDiamonds());
        h2 r45 = GiftManagerKt.l(r39.getGiftId());
        if (r39.getComboHint() != null) goto L149;
    L163:
        if (r45 != null) goto L165;
    L167:
        List<y1> r46 = r39.getGifts();
        ArrayList r47 = new ArrayList();
        Iterator<y1> r48 = r46.iterator();
    L169:
        if (r48.hasNext() == false) goto L178;
        y1 r49 = r48.next();
        GiftContext r50 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r50 == null) goto L177;
        com.bytedance.live.datacontext.i<Map<Long, com.bytedance.android.livesdk.gift.platform.core.l>> r51 = r50.getGiftIdMapToInfo();
        if (r51 == null) goto L177;
        Map r53 = (Map) r51.getValue();
        if (r53 == null) goto L177;
        com.bytedance.android.livesdk.gift.platform.core.l r54 = (com.bytedance.android.livesdk.gift.platform.core.l) r53.put(Long.valueOf(r49.getGiftId()), new com.bytedance.android.livesdk.gift.platform.core.l(r49.getGiftTip()));
    L177:
        r47.add(Long.valueOf(r49.getGiftId()));
        goto L169
    L178:
        GiftContext r55 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r55 == null) goto L183;
        com.bytedance.live.datacontext.k<List<Long>> r56 = r55.getGiftStructChangeEvent();
        if (r56 == null) goto L183;
        r56.post(r47);
    L183:
        Iterator<y1> r57 = r39.getGifts().iterator();
    L185:
        if (r57.hasNext() == false) goto L198;
        y1 r58 = r57.next();
        p1 r59 = r58.getGiftExtra();
        if (r59 == null) goto L185;
        if (r59.getDecoded().getGiftId() != r58.getGiftId()) goto L185;
        i12.e r60 = o.b();
        if (r60 == null) goto L193;
        Object r61 = com.bytedance.android.scope.m.e.d(r60, GiftExtraRepo.class);
    L194:
        GiftExtraRepo r63 = (GiftExtraRepo) r61;
        if (r63 == null) goto L185;
        r63.b0(r58.getGiftId(), r59, false);
        goto L185
    L193:
        r61 = null;
        goto L194
    L198:
        if (r39.getPropId() <= 0) goto L206;
        i12.e r64 = o.b();
        if (r64 == null) goto L202;
        Object r65 = com.bytedance.android.scope.m.e.d(r64, PropListService.class);
    L203:
        PropListService r66 = (PropListService) r65;
        if (r66 == null) goto L206;
        r66.f(Long.valueOf(r39.getPropId()));
        goto L206
    L202:
        r65 = null;
    L206:
        List<l2> r67 = r39.getProps();
        if (r67 == null) goto L235;
        i12.e r68 = o.b();
        if (r68 == null) goto L211;
        Object r69 = com.bytedance.android.scope.m.e.d(r68, PropListService.class);
    L212:
        PropListService r70 = (PropListService) r69;
        if (r70 == null) goto L235;
        Intrinsics.checkNotNullParameter(r67, "props");
        if (r67.isEmpty() == true) goto L235;
        Iterator<l2> r71 = r67.iterator();
    L219:
        if (r71.hasNext() == false) goto L224;
        l2 r73 = r71.next();
        l2 r74 = r70.f(Long.valueOf(r73.getId()));
        if (r74 == null) goto L219;
        List<l2> r75 = r70.a;
        ListProtector.set(r75, ((ArrayList) r75).indexOf(r74), r73);
        goto L219
    L224:
        List<l2> r76 = r70.a;
        uz1.a r77 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r77 == null) goto L227;
        r77.a(new RefreshPropList(r76, true));
    L227:
        Iterator r78 = ((ArrayList) r70.a).iterator();
    L229:
        if (r78.hasNext() == false) goto L235;
        l2 r79 = (l2) r78.next();
        if (r79.getCount() > 0) goto L234;
        if (r79.getPropType() != 4) goto L229;
    L234:
        r79.isDisplayedOnPanel();
        goto L229
    L211:
        r69 = null;
    L235:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).markAsOutOfDate(true);
        b0 r80 = r38.x;
        if (r80.r == false) goto L241;
        c0 r81 = c0.a;
        long r83 = r80.b;
        long r84 = r80.d();
        String r85 = r39.getLogId();
        long r115 = r43;
        long r116 = 1;
        long r117 = com.bytedance.live.kmp.util.e.b() - r115;
        JSONObject r86 = new JSONObject();
        c0.r(r86, r210, Long.valueOf(r84));
        c0.r(r86, "prop_id", Long.valueOf(r83));
        if (r85 != null) goto L240;
        r85 = BuildConfig.FLAVOR;
    L240:
        c0.r(r86, r212, r85);
        c0.r(r86, "duration", Long.valueOf(r117));
        c0.n(r81, z.a("ttlive_prop_send_status"), r86, 0);
    L242:
        String r87 = r39.getLogId();
        if (r87 == null) goto L258;
        i12.e r88 = o.b();
        if (r88 == null) goto L247;
        Object r89 = com.bytedance.android.scope.m.e.d(r88, q0.class);
    L248:
        q0 r90 = (q0) r89;
        if (r90 == null) goto L251;
        r90.a(r87, 0, r115);
    L251:
        i12.e r91 = o.b();
        if (r91 == null) goto L254;
        Object r93 = com.bytedance.android.scope.m.e.d(r91, q0.class);
    L255:
        q0 r94 = (q0) r93;
        if (r94 == null) goto L258;
        r94.a(r87, 1, r44);
        goto L258
    L254:
        r93 = null;
        goto L255
    L247:
        r89 = null;
    L258:
        long r95 = r39.getGiftId();
        DataCenter r96 = r38.a().c;
        IRoom r97 = r38.x.H;
        GiftContext r98 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r98 == null) goto L267;
        HashSet r99 = new HashSet(1);
        r99.add(Long.valueOf(r95));
        Iterator r100 = ((Set) r98.getGiftSendResultListeners().getValue()).iterator();
    L262:
        if (r100.hasNext() == false) goto L267;
        ca0.s r101 = (ca0.s) r100.next();
        Intrinsics.checkNotNullParameter(r39, "$this$toSendGiftInfo");
        long r102 = r39.getConsumeDiamonds();
        a5 r118 = r39.getDisplayText();
        if (r118 != null) goto L266;
        r118 = (a5) vh7.f.c(a5.class);
    L266:
        r101.j(new f(r99, r211, true, null, new h3(r102, r118, r39.getLogId())));
        r116 = 1;
    L267:
        long r213 = r116;
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_DIALOG_NEED_PROMOTION_AD, Boolean.FALSE)).booleanValue() == false) goto L273;
        h2 r103 = GiftManagerKt.l(r39.getGiftId());
        if (r103 == null) goto L273;
        if (r97 == null) goto L273;
        qq2.a r104 = vh6.c.b(qq2.a.class);
        Context r105 = s1.getContext();
        long r106 = r97.getRoomId();
        JSONObject r107 = new JSONObject();
        JSONObject r119 = new JSONObject();
        r119.put("gift_value", r103.getDiamondCount());
        Unit r108 = Unit.INSTANCE;
        r107.put("ad_extra_data", r119);
        r104.oj(r105, r106, r107);
    L273:
        com.bytedance.android.live.profit.privilege.a r109 = yt0.c.i();
        if (r109 == null) goto L276;
        r109.k0(2);
    L276:
        r96.put("data_gift_send_success", Boolean.TRUE);
        com.bytedance.android.livesdk.gift.platform.business.g r120 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r120 == null) goto L287;
        List<com.bytedance.android.livesdk.gift.platform.business.f> r121 = r120.c();
        if (r121 == null) goto L287;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.f> r122 = r121.iterator();
    L283:
        if (r122.hasNext() == false) goto L287;
        com.bytedance.android.livesdk.gift.platform.business.f r123 = r122.next();
        if (r123 == null) goto L283;
        r123.y(r39);
    L287:
        if (r41 != 0) goto L372;
        b0 r124 = r38.x;
        long r125 = r124.b;
        boolean r126 = !r124.r;
        DataCenter r127 = r38.a().c;
        String r128 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Pair[] r129 = new Pair[2];
        r129[0] = TuplesKt.to("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString().toString());
        GiftContext r130 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r130 == null) goto L294;
        com.bytedance.live.datacontext.m<String> r131 = r130.getGiftListResultLogId();
        if (r131 == null) goto L294;
        String r132 = (String) r131.getValue();
        if (r132 == null) goto L294;
    L295:
        r129[1] = TuplesKt.to("gift_dialog_request_id", r132);
        LinkedHashMap r133 = new LinkedHashMap();
        MapsKt.putAll(r133, r129);
        if (u.r() == true) goto L304;
        i12.e r134 = o.b();
        if (r134 == null) goto L300;
        Object r135 = com.bytedance.android.scope.m.e.d(r134, g1.class);
    L301:
        g1 r136 = (g1) r135;
        if (r136 == null) goto L306;
        r136.d(r133);
    L306:
        if (u.r() == true) goto L334;
        StringCompanionObject r137 = StringCompanionObject.INSTANCE;
        Object[] r138 = new Object[1];
        i12.e r139 = o.b();
        if (r139 == null) goto L310;
        Object r140 = com.bytedance.android.scope.m.e.d(r139, g1.class);
    L311:
        g1 r141 = (g1) r140;
        if (r141 == null) goto L332;
        Long r142 = Long.valueOf(r141.e.d);
        if (r142.longValue() == 0) goto L316;
        boolean r143 = true;
    L317:
        if (r143 == true) goto L320;
        r142 = null;
    L320:
        if (r142 != null) goto L328;
        r142 = Long.valueOf(r141.e.a);
        if (r142.longValue() == 0) goto L324;
        boolean r144 = true;
    L325:
        if (r144 == true) goto L328;
        r142 = null;
        goto L328
    L324:
        r144 = false;
    L328:
        if (r142 == null) goto L330;
        long r145 = r142.longValue();
    L331:
        long r0 = System.currentTimeMillis();
        r141.e.d = r0;
        Object r146 = Double.valueOf(((r0 - r145) * 1.0d) / ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
    L333:
        r138[0] = r146;
        r133.put("send_time", String.format("%.1f", Arrays.copyOf(r138, 1)));
        long r214 = 0;
    L371:
        r133.put("send_gift_scene", com.bytedance.android.livesdk.gift.platform.core.utils.i.a(r127));
        String r147 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.b0(r126, r133, r125);
        mz0.n r148 = new mz0.n();
        Map r149 = r148.a;
        Intrinsics.checkNotNullParameter(r149, "map");
        Intrinsics.checkNotNullParameter(r133, "map");
        r149.putAll(r133);
        mz0.m r150 = new mz0.m();
        r150.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r151 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r151, "pageSourceLog");
        ((ArrayList) r150.a).add(r151.a);
        ((ArrayList) r148.b).addAll(r150.a);
        cy0.e.a.getClass();
        cy0.j r152 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r153 = com.bytedance.android.scope.m.b(r152).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r153);
        ((f80.a) r153).w3("livesdk_send_time", r148.a, r148.b);
    L373:
        cb r154 = r39.getPetEffectInfo();
        if (r154 == null) goto L378;
        com.bytedance.android.live.profit.livepet.b r155 = yt0.c.e();
        if (r155 == null) goto L378;
        r155.E1(r154);
    L378:
        Disposable r156 = (Disposable) ((HashMap) r38.r).remove(Integer.valueOf(r41));
        if (r156 == null) goto L381;
        r156.dispose();
    L381:
        r38.r();
        Intrinsics.checkNotNullParameter(r39, r113);
        if (((y1) ListProtector.get(r39.getGifts(), 0)).getBuffLevel() > 0) goto L384;
    L386:
        y.c.a.C0068c r157 = null;
    L387:
        if (r157 == null) goto L389;
        r38.o(r157, 0);
    L389:
        GiftContext r158 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r158 == null) goto L396;
        com.bytedance.live.datacontext.m<Long> r159 = r158.getSendGiftTime();
        if (r159 == null) goto L396;
        Long r160 = (Long) r159.getValue();
        if (r160 == null) goto L396;
        long r161 = r160.longValue();
    L397:
        GiftContext r162 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r162 == null) goto L404;
        com.bytedance.live.datacontext.m<Long> r163 = r162.getSendGiftMoney();
        if (r163 == null) goto L404;
        Long r164 = (Long) r163.getValue();
        if (r164 == null) goto L404;
        long r165 = r164.longValue();
    L405:
        GiftContext r166 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r166 == null) goto L410;
        com.bytedance.live.datacontext.m<Long> r167 = r166.getSendGiftTime();
        if (r167 == null) goto L410;
        r167.setValue(Long.valueOf(r161 + r213));
    L410:
        GiftContext r168 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r168 == null) goto L415;
        com.bytedance.live.datacontext.m<Long> r169 = r168.getSendGiftMoney();
        if (r169 == null) goto L415;
        r169.setValue(Long.valueOf(r165 + (r38.p() * r211)));
    L415:
        b0 r170 = r38.x;
        if (r170.v == true) goto L434;
        List<IBaseUser> r171 = r170.w;
        if (r171 == null) goto L420;
        int r172 = r171.size();
    L422:
        if (r172 <= 1) goto L434;
        List<IBaseUser> r173 = r38.x.w;
        if (r173 == null) goto L426;
        Integer r174 = Integer.valueOf(r173.size());
    L427:
        p2 r175 = r38.n;
        if (r175 == null) goto L430;
        Integer r176 = Integer.valueOf(r175.getMultiSendSuccessCount());
    L432:
        if ((!Intrinsics.areEqual(r174, r176)) == false) goto L434;
        ToastUtil.a(2131919968, 0);
        return;
    L430:
        r176 = null;
        goto L432
    L426:
        r174 = null;
        goto L427
    L420:
        r172 = 0;
    L434:
        b0 r177 = r38.x;
        if (r177.v == false) goto L447;
        List<IBaseUser> r178 = r177.w;
        if (r178 == null) goto L439;
        Integer r179 = Integer.valueOf(r178.size());
    L440:
        p2 r180 = r38.n;
        if (r180 == null) goto L443;
        Integer r181 = Integer.valueOf(r180.getMultiSendSuccessCount());
    L445:
        if ((!Intrinsics.areEqual(r179, r181)) == false) goto L447;
        ToastUtil.a(2131919968, 0);
        goto L447
    L443:
        r181 = null;
        goto L445
    L439:
        r179 = null;
    L447:
        i12.e r182 = o.b();
        if (r182 == null) goto L450;
        Object r183 = com.bytedance.android.scope.m.e.d(r182, d1.class);
    L451:
        d1 r184 = (d1) r183;
        if (r184 == null) goto L509;
        r184.a = r43;
        return;
    L509:
        return;
    L450:
        r183 = null;
    L404:
        r165 = r214;
    L396:
        r161 = r214;
        goto L397
    L384:
        if (((y1) ListProtector.get(r39.getGifts(), 0)).getOriginGiftId() != r39.getGiftId()) goto L386;
        r157 = y.c.a.C0068c.d;
        goto L387
    L330:
        r145 = System.currentTimeMillis();
        goto L331
    L316:
        r143 = false;
        goto L317
    L332:
        r146 = Float.valueOf(0.0f);
        goto L333
    L310:
        r140 = null;
        goto L311
    L334:
        r126 = r126;
        StringCompanionObject r185 = StringCompanionObject.INSTANCE;
        Object[] r186 = new Object[1];
        GiftContext r187 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r187 == null) goto L339;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r188 = r187.getLastEventTimeStamp();
        if (r188 == null) goto L339;
        com.bytedance.android.livesdk.gift.platform.core.i r189 = (com.bytedance.android.livesdk.gift.platform.core.i) r188.getValue();
    L340:
        if (r189 == null) goto L351;
        Long r190 = Long.valueOf(r189.d);
        if (r190.longValue() == 0) goto L344;
        boolean r191 = true;
    L345:
        if (r191 == true) goto L348;
        r190 = null;
    L348:
        if (r190 == null) goto L351;
        r214 = 0;
    L360:
        if (r190 == null) goto L362;
        long r192 = r190.longValue();
    L363:
        long r310 = System.currentTimeMillis();
        if (r189 == null) goto L370;
        com.bytedance.android.livesdk.gift.platform.core.i r193 = com.bytedance.android.livesdk.gift.platform.core.i.a(r189, 0, 0, r310, 0, 23);
        GiftContext r194 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r194 == null) goto L370;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r195 = r194.getLastEventTimeStamp();
        if (r195 == null) goto L370;
        r195.setValue(r193);
    L370:
        r186[0] = Double.valueOf(((r310 - r192) * 1.0d) / ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        r133.put("send_time", String.format("%.1f", Arrays.copyOf(r186, 1)));
        goto L371
    L362:
        r192 = System.currentTimeMillis();
        goto L363
    L344:
        r191 = false;
    L351:
        if (r189 == null) goto L358;
        r190 = Long.valueOf(r189.a);
        r214 = 0;
        if (r190.longValue() == 0) goto L355;
        boolean r196 = true;
    L356:
        if (r196 == true) goto L360;
    L359:
        r190 = null;
        goto L360
    L355:
        r196 = false;
        goto L356
    L358:
        r214 = 0;
    L339:
        r189 = null;
        goto L340
    L300:
        r135 = null;
        goto L301
    L304:
        r133.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
        r133.put("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
    L294:
        r132 = BuildConfig.FLAVOR;
        goto L295
    L372:
        r214 = 0;
        goto L373
    L241:
        r115 = r43;
        r116 = 1;
        c0 r197 = c0.a;
        c0.l(r80.b, r80.d(), r39.getLogId(), com.bytedance.live.kmp.util.e.b() - r115, r38.x.f());
        goto L242
    L165:
        if (r45.isForFirstRecharge() != true) goto L167;
        GiftManagerKt.z.getClass();
        GiftManagerKt.d.clear();
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c(GiftManagerKt.p(), 4));
        goto L167
    L149:
        if (u.p() == true) goto L163;
        com.bytedance.android.livesdk.gift.model.l r198 = r39.getComboHint();
        if (r198 == null) goto L155;
        List<com.bytedance.android.livesdk.gift.model.m> r199 = r198.dataList;
        if (r199 == null) goto L155;
        CollectionsKt.sortWith(r199, com.bytedance.android.livesdk.gift.platform.business.sendGift.a.a);
    L155:
        if (r45 == null) goto L163;
        com.bytedance.android.livesdk.gift.model.l r200 = r39.getComboHint();
        Intrinsics.checkNotNullParameter(r45, "$this$comboHint");
        if ((r45 instanceof h1) == true) goto L159;
        h2 r201 = null;
    L160:
        h1 r202 = (h1) r201;
        if (r202 == null) goto L163;
        r202.setComboHint(r200);
        goto L163
    L159:
        r201 = r45;
        goto L160
    L67:
        yz0.l r1100 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        r211 = r13;
        IBaseUser r203 = (IBaseUser) r30.get("data_user_in_room", null);
        if (r35 == null) goto L82;
        ArrayList r204 = new ArrayList();
        Iterator r205 = r35.iterator();
    L71:
        if (r205.hasNext() == false) goto L77;
        Object r1101 = r205.next();
        Iterator r1102 = r205;
        if (Intrinsics.areEqual(((IBaseUser) r1101).getIdString(), r39.getMultiSendToUserId().toString()) == false) goto L75;
        r204.add(r1101);
    L75:
        r205 = r1102;
        goto L71
    L77:
        if ((!r204.isEmpty()) == false) goto L79;
        ArrayList r206 = r204;
    L80:
        if (r206 == null) goto L82;
        IBaseUser r207 = (IBaseUser) ListProtector.get(r206, 0);
    L83:
        long r208 = r33.getRoomId();
        int r1103 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a;
        ArrayList r1104 = new ArrayList();
        List<y1> r1105 = r39.getGifts();
        if (r1105 != null) goto L86;
    L85:
        r210 = r21;
        r212 = r111;
        if (r1100 != null) goto L139;
        JSONObject r209 = new JSONObject();
        r209.put("error", "messageManager is null");
        r209.put("toUser", r34.getIdString());
        String r215 = v12.f.a;
        v12.f.q(r39.getTraceId(), r209);
        goto L146
    L139:
        if (Lists.isEmpty(r1104) == false) goto L141;
        o7 r216 = com.bytedance.android.livesdk.gift.platform.core.utils.m.e(r33.getRoomId(), r39, r207, r203);
        v12.f.p(r216);
        r1100.insert(r216, false);
        goto L146
    L141:
        Iterator r217 = r1104.iterator();
    L143:
        if (r217.hasNext() == false) goto L146;
        o7 r218 = (o7) r217.next();
        v12.f.p(r218);
        r1100.insert(r218, false);
        goto L143
    L86:
        Iterator<y1> r1106 = r1105.iterator();
    L88:
        if (r1106.hasNext() == false) goto L85;
        y1 r1107 = r1106.next();
        String r219 = r111;
        o7 r1108 = vh7.f.c(o7.class);
        String r220 = r21;
        m0 r221 = vh7.f.c(m0.class);
        r221.setRoomId(r208);
        long r222 = r208;
        r221.setMessageId(r1107.getMsgId());
        r221.setShowMsg(true);
        r221.setDescribe(r1107.getDescribe());
        r221.setDisplayText(r1107.getDisplayText());
        r1108.setCommonData(r221);
        a5 r223 = r1107.getDisplayText();
        if (r223 == null) goto L120;
        List r224 = r223.getPieces();
        if (r224 == null) goto L120;
        if ((!r224.isEmpty()) == true) goto L97;
        r224 = null;
    L97:
        if (r224 == null) goto L120;
        Iterator r225 = r224.iterator();
    L100:
        if (r225.hasNext() == false) goto L120;
        c5 r226 = (c5) r225.next();
        i5 r227 = r226.getUserValue();
        if (r227 == null) goto L104;
        IBaseUser r228 = r227.getUser();
    L105:
        if (r228 == null) goto L100;
        int r229 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a;
        i5 r230 = r226.getUserValue();
        if (r230 == null) goto L109;
        IBaseUser r231 = r230.getUser();
    L110:
        Iterator r232 = r225;
        String r233 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        if (r231 == null) goto L113;
        String r234 = r231.getIdString();
    L115:
        if (Intrinsics.areEqual(r234, r233) == true) goto L116;
        r225 = r232;
        goto L100
    L116:
        i5 r235 = r226.getUserValue();
        if (r235 == null) goto L120;
        IBaseUser r236 = r235.getUser();
    L121:
        if (r236 == null) goto L123;
        r1108.setFromUser(r236);
    L126:
        r1108.setRepeatCount(r1107.getRepeatCount());
        r1108.setFanTicketCount(r39.getFanTicketCount());
        r1108.setRoomFanTicketCount(r39.getRoomFanTicketCount());
        r1108.setGiftId(r1107.getGiftId());
        r1108.setToUser(r207);
        r1108.setComboCount(r1107.getComboCount());
        r1108.setGroupCount(r1107.getGroupCount());
        r1108.setGroupId(r39.getGroupId());
        r1108.setLocal(true);
        r1108.setLocal(true);
        r1108.setLogId(r39.getLogId());
        r1108.setTrayDisplayText(r1107.getTrayDisplayText());
        r1108.setAssetEffectMixInfo(r1107.getAssetEffectMixInfo());
        r1108.setTrayInfo(r1107.getGiftTrayInfo());
        r1108.setTraceId(r39.getTraceId());
        r1108.setDiyItemInfoList(r39.getDiyItemInfo());
        r1108.setToUserIdString(r39.getToUserIds());
        r1108.setSendGiftTime(r39.getSendGiftTime());
        r1108.setForceDisplayEffects(r39.getForceDisplayEffects());
        r1108.setGift(r39.getGift());
        r1108.setClientGiftSource(r39.getClientGiftSource());
        r1108.setCount(r39.getCount());
        r1108.setAnchorGift(r39.getAnchorGift());
        r1108.setSendTogetherInfo(r39.getSendTogetherInfo());
        r1108.setExtraEffectInfo(r39.getExtraEffectInfo());
        r1108.setMultiSendEffectLevel(r39.getMultiSendEffectLevel());
        r1108.setSeriesGiftData(r39.getSeriesGiftData());
        if (r1108.getCount() <= 1) goto L135;
        Iterator r237 = r39.getMsgIdList().iterator();
    L130:
        if (r237.hasNext() == false) goto L136;
        long r238 = ((Number) r237.next()).longValue();
        Iterator r1109 = r237;
        o7 r239 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a(r1108);
        r239.setCount(1);
        m0 r240 = r239.getCommonData();
        if (r240 == null) goto L134;
        r240.setMessageId(r238);
    L134:
        r1104.add(r239);
        r237 = r1109;
    L136:
        r111 = r219;
        r21 = r220;
        r208 = r222;
        goto L88
    L135:
        r1104.add(r1108);
        goto L136
    L123:
        if (r203 == null) goto L125;
        r1108.setFromUser(r203);
        goto L126
    L125:
        r1108.setFromUser(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b());
        goto L126
    L113:
        r234 = null;
        goto L115
    L109:
        r231 = null;
        goto L110
    L104:
        r228 = null;
    L120:
        r236 = null;
        goto L121
    L79:
        r206 = null;
    L82:
        r207 = r34;
        goto L83
    L63:
        r113 = "result";
        goto L64
    L13:
        List<IBaseUser> r241 = r8.w;
        if (r241 != null) goto L16;
    L19:
        boolean r242 = true;
    L20:
        if (r242 == false) goto L22;
        r9 = 0;
        goto L26
    L22:
        if (r7 == null) goto L24;
        int r243 = r7.getMultiSendSuccessCount();
    L25:
        r9 = r243 * r40;
        goto L26
    L24:
        r243 = 0;
        goto L25
    L16:
        if (r241.isEmpty() == true) goto L19;
        r242 = false;
        goto L20
    L9:
        r5 = r4;
        goto L10
    L5:
        r3 = r2;
        goto L6
    }
}
