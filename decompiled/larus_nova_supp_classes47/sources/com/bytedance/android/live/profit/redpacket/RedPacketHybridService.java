package com.bytedance.android.live.profit.redpacket;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.redpacket.rush.RedPacketLynxDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RedPacketHybridService implements com.bytedance.android.scope.o {
    public static final String f = null;
    public final List<String> a;
    public final Lazy b;
    public final yz0.k c;
    public final y0 d;
    public final r0 e;

    public static final class a {
    }

    public static final class b {
        public zy0.b a;
        public boolean b;
        public final CompositeDisposable c;
        public boolean d;
        public Function0<Unit> e;

        public b() {
            this.c = new CompositeDisposable();
        }
    }

    public final RedPacketLynxDialog c() {
        return (RedPacketLynxDialog) this.b.getValue();
    }

    public final void onStart() {
    }

    static {
        f = (String) i1.b.getValue(null, i1.a[0]);
    }

    public final void onStop() {
        ((ArrayList) this.a).clear();
    }

    public RedPacketHybridService(yz0.k r2, y0 r3, r0 r4) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "redPacketViewModel");
        Intrinsics.checkNotNullParameter(r4, "redPacketRepository");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new ArrayList();
        this.b = LazyKt.lazy(RedPacketHybridService$redPacketLynxDialog$2.INSTANCE);
    }

    public final b a(Uri r9, RedPacket r10, Context r12, final Function0 r13) {
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r0 = null;
        Object r1 = null;
        if (r10 == null) goto L7;
        RedPacketState r2 = r10.getState();
        if (r2 == null) goto L7;
        final n0 r3 = r2.getInfo();
    L8:
        Intrinsics.checkNotNullParameter(r9, "baseUri");
        LinkedHashMap r4 = new LinkedHashMap();
        if (r9.isHierarchical() == false) goto L14;
        Iterator r5 = UriProtector.getQueryParameterNames(r9).iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        String r6 = (String) r5.next();
        String r7 = UriProtector.getQueryParameter(r9, r6);
        Intrinsics.checkNotNull(r7);
        r4.put(r6, r7);
    L14:
        Intrinsics.checkNotNullParameter("fallback_url", "key");
        Object r8 = r4.get("fallback_url");
        if ((r8 instanceof com.bytedance.android.live.revenue.common.x0) == false) goto L18;
        com.bytedance.android.live.revenue.common.x0 r14 = (com.bytedance.android.live.revenue.common.x0) r8;
    L25:
        final String r15 = r14.toString();
        final b r16 = new b();
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r17 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r12, r9, new RedPacketHybridService$generateRedPacketHybridCard$hybridCard$1(r3, r15, r13, r16));
        if (r17 == null) goto L109;
        CompositeDisposable r18 = r16.c;
        if (r10 == null) goto L32;
        RedPacketState r19 = r10.getState();
        if (r19 == null) goto L32;
        n0 r110 = r19.getInfo();
    L34:
        if (i1.a() != 0) goto L50;
        if (r10 == null) goto L43;
        Observable<k1> r20 = r10.b;
        if (r20 == null) goto L43;
        Observable r22 = r20.map(u.a);
        if (r22 == null) goto L43;
        Observable r23 = r22.startWith(r10.getState());
        if (r23 == null) goto L43;
        com.bytedance.android.live.core.utils.rxutils.f r24 = RxCompatKt.a(r23);
    L44:
        if (r24 == null) goto L48;
        Disposable r111 = r24.subscribe(new p(r110, r17));
        if (r111 == null) goto L48;
        RxUtilKt.c(r111, r18);
    L48:
        if (r24 == null) goto L59;
        Disposable r112 = (Disposable) JavaCalls.callMethodOrThrow(r24.a, "connect", new Object[0]);
    L59:
        JSONObject r113 = new JSONObject();
        if (r10 == null) goto L64;
        RedPacketState r25 = r10.getState();
        if (r25 == null) goto L64;
        n0 r26 = r25.getInfo();
    L65:
        r113.put("eventName", "RedEnvelopeCountDownUpdate");
        if (r26 == null) goto L68;
        String r27 = r26.d;
    L69:
        r113.put("box_id", String.valueOf(r27));
        Ref.LongRef r28 = new Ref.LongRef();
        r28.element = 0;
        if (r10 == null) goto L80;
        RedPacketState r29 = r10.getState();
        if (r29 == null) goto L80;
        final n0 r30 = r29.getInfo();
        if (r30 == null) goto L80;
        Intrinsics.checkNotNullParameter(r30, "info");
        Completable r32 = Completable.create(new RedPacketUtilsKt$createSpecialRedPacketTimer$1(r30));
        if (r32 == null) goto L80;
        Disposable r33 = r32.subscribe(new v(r113, r17));
        if (r33 == null) goto L80;
        RxUtilKt.c(r33, r18);
    L80:
        if (r10 == null) goto L90;
        RedPacketState r34 = r10.getState();
        if (r34 == null) goto L90;
        n0 r35 = r34.getInfo();
        if (r35 == null) goto L90;
        Observable r114 = x0.b(r35).takeUntil(r10.b.filter(w.a));
        if (r114 == null) goto L90;
        Disposable r115 = r114.subscribe(new x(r28, r113, r17));
        if (r115 == null) goto L90;
        RxUtilKt.c(r115, r18);
    L90:
        List r116 = (List) this.e.e.d;
        JSONObject r117 = new JSONObject();
        Ref.IntRef r36 = new Ref.IntRef();
        r36.element = 0;
        Iterator r118 = r116.iterator();
        if (r118.hasNext() == false) goto L102;
        r1 = r118.next();
        if (r118.hasNext() == false) goto L102;
        com.bytedance.android.live.revenue.common.u0 r37 = ((RedPacket) r1).getState().getInfo().i;
    L97:
        Object r38 = r118.next();
        com.bytedance.android.live.revenue.common.u0 r39 = ((RedPacket) r38).getState().getInfo().i;
        if (r37.compareTo(r39) >= 0) goto L101;
        r1 = r38;
        r37 = r39;
    L101:
        if (r118.hasNext() == true) goto L97;
    L102:
        RedPacket r40 = (RedPacket) r1;
        r117.put("eventName", "RedEnvelopeHeartBeat");
        if (r40 == null) goto L105;
        com.bytedance.android.live.revenue.common.u0 r119 = r40.getState().getInfo().i.b(x0.d());
        com.bytedance.android.live.revenue.common.u0 r42 = com.bytedance.android.live.revenue.common.u0.f;
        RxUtilKt.c(com.bytedance.android.live.revenue.common.s0.a(r119.c(com.bytedance.android.live.revenue.common.u0.a.a(5)), com.bytedance.android.live.revenue.common.u0.g).subscribe(new y(r117, r36, r17)), r18);
    L105:
        Disposable r120 = this.e.q.subscribe(new t(this, r17));
        if (r120 == null) goto L108;
        RxUtilKt.c(r120, r18);
    L108:
        r0 = r17;
        goto L109
    L68:
        r27 = null;
    L64:
        r26 = null;
    L43:
        r24 = null;
        goto L44
    L50:
        Disposable r121 = this.e.m.subscribe(new q(r17));
        if (r121 == null) goto L53;
        RxUtilKt.c(r121, r18);
    L53:
        Disposable r122 = this.e.o.subscribe(new r(this, r17));
        if (r122 == null) goto L56;
        RxUtilKt.c(r122, r18);
    L56:
        Disposable r123 = this.e.s.subscribe(new s(this, r17));
        if (r123 == null) goto L59;
        RxUtilKt.c(r123, r18);
    L32:
        r110 = null;
    L109:
        r16.a = r0;
        return r16;
    L18:
        if ((r8 instanceof String) == false) goto L23;
        int r43 = com.bytedance.revenue.platform.api.core.e.a;
        Uri r44 = com.bytedance.revenue.platform.api.core.e.a((String) r8);
        if (r44.isHierarchical() == false) goto L22;
        r14 = new com.bytedance.android.live.revenue.common.x0(r44);
    L24:
        r4.put("fallback_url", r14);
        goto L25
    L22:
        r14 = new com.bytedance.android.live.revenue.common.x0(Uri.EMPTY);
        goto L24
    L23:
        int r45 = com.bytedance.revenue.platform.api.core.e.a;
        r14 = new com.bytedance.android.live.revenue.common.x0(Uri.EMPTY);
    L7:
        r3 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v8 */
    public final void d(zy0.b r27, String r28, List r29, RedPacketDialogShowFrom r30, l1 r32) {
        if (r30 == RedPacketDialogShowFrom.REWARD) goto L5;
        List r4 = (List) this.d.k.e.d;
        if ((!r4.isEmpty()) == true) goto L25;
        return;
    L25:
        if (r30 != RedPacketDialogShowFrom.RECEIVE) goto L45;
        List r5 = r29;
        ?? r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L28:
        if (r6.hasNext() == false) goto L57;
        com.bytedance.android.livesdk.chatroom.model.n1.e r7 = (com.bytedance.android.livesdk.chatroom.model.n1.e) r6.next();
        Iterator r9 = r4.iterator();
    L31:
        if (r9.hasNext() == false) goto L35;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((RedPacket) r10).getState().getInfo().d, r7.getBoxIdStr()) == false) goto L31;
    L36:
        RedPacket r12 = (RedPacket) r10;
        if (r12 == null) goto L43;
        RedPacketState r13 = r12.getState();
        if (r13 == null) goto L43;
        n0 r14 = r13.getInfo();
        if (r14 == null) goto L43;
        o0 r15 = x0.g(r14, r28, r7, r30);
    L44:
        r8.add(r15);
    L43:
        r15 = null;
        goto L44
    L35:
        r10 = null;
    L57:
        xy0.a<?> r0 = r27.g();
        if (r0 == null) goto L74;
        r0.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("redPackets", GsonProtectorUtils.toJson(GsonHelper.get(), CollectionsKt.filterNotNull((Iterable) r8)))));
        return;
    L74:
        return;
    L45:
        List r16 = r4;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L47:
        if (r18.hasNext() == false) goto L56;
        RedPacket r19 = (RedPacket) r18.next();
        Iterator r20 = r29.iterator();
    L50:
        if (r20.hasNext() == false) goto L54;
        Object r110 = r20.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.chatroom.model.n1.e) r110).getBoxIdStr(), r19.getState().getInfo().d) == false) goto L50;
    L55:
        r17.add(x0.g(r19.getState().getInfo(), r28, (com.bytedance.android.livesdk.chatroom.model.n1.e) r110, r30));
        goto L47
    L54:
        r110 = null;
        goto L55
    L56:
        r8 = CollectionsKt.take(r17, 10);
        goto L57
    L5:
        if (r32 == null) goto L10;
        String r2 = r32.b();
        if (r2 == null) goto L10;
        String r22 = r2;
    L11:
        j1 r3 = new j1("", "", "", "", "", false);
        List r111 = CollectionsKt.emptyList();
        if (r32 == null) goto L17;
        String r23 = r32.a();
        if (r23 == null) goto L17;
        String r24 = r23;
    L18:
        o0 r1 = new o0(r22, 0, 0, 0, r3, r111, "", 0, "", "", "", "", "", "", "", null, "false", "true", r24, "");
        xy0.a<?> r25 = r27.g();
        if (r25 == null) goto L72;
        r25.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("redPackets", GsonProtectorUtils.toJson(GsonHelper.get(), CollectionsKt.listOf(r1)))));
    L72:
        return;
    L17:
        r24 = "";
    L10:
        r22 = "";
        goto L11
    }

    public final void f(Context r17, RedPacket r18, Long r19, IRoom r20, List r22, RedPacketDialogShowFrom r23, l1 r24, final Function0 r25) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r22, "receiveResults");
        Intrinsics.checkNotNullParameter(r23, "showFrom");
        Intrinsics.checkNotNullParameter(r25, "fallback");
        String r3 = f;
        if (TextUtils.isEmpty(r3) == false) goto L7;
        r25.invoke();
        return;
    L7:
        if (r18 != null) goto L52;
    L11:
        final n0 r10 = null;
    L12:
        final String r12 = String.valueOf(System.currentTimeMillis());     // Catch: Exception -> L34
        Uri r13 = b0.a(r20, r10, r19, r12);     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r3, "baseUriString");     // Catch: Exception -> L34
        int r14 = com.bytedance.revenue.platform.api.core.e.a;     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r3, "schemeString");     // Catch: Exception -> L34
        Uri r4 = UriProtector.parse(r3);     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r4, "baseUri");     // Catch: Exception -> L34
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Exception -> L34
        if (r4.isHierarchical() == false) goto L18;
        Iterator r16 = UriProtector.getQueryParameterNames(r4).iterator();     // Catch: Exception -> L34
    L16:
        if (r16.hasNext() == false) goto L18;
        String r110 = (String) r16.next();     // Catch: Exception -> L34
        String r8 = UriProtector.getQueryParameter(r4, r110);     // Catch: Exception -> L34
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L34
        r15.put(r110, r8);     // Catch: Exception -> L34
    L18:
        Intrinsics.checkNotNullParameter("fallback_url", "key");     // Catch: Exception -> L34
        Object r9 = r15.get("fallback_url");     // Catch: Exception -> L34
        if ((r9 instanceof com.bytedance.android.live.revenue.common.x0) == false) goto L22;
        com.bytedance.android.live.revenue.common.x0 r26 = (com.bytedance.android.live.revenue.common.x0) r9;     // Catch: Exception -> L34
    L29:
        r26.toString();     // Catch: Exception -> L34
        if (((FragmentActivity) r17).getSupportFragmentManager().findFragmentByTag("RedPacketHybridService") != null) goto L55;
        Pair r27 = new Pair(a(r13, r18, r17, new RedPacketHybridService$showAnnieLynxRedPacketDialog$1(this, r25)), 0);     // Catch: Exception -> L34
        zy0.b r2 = ((b) r27.getFirst()).a;     // Catch: Exception -> L34
        if (r2 == null) goto L36;
        r2.l1(new RedPacketHybridService$hybridCardBindBridge$1(this, r17, true));     // Catch: Exception -> L34
        d(r2, String.valueOf(r19), r22, r23, r24);     // Catch: Exception -> L34
    L36:
        final b r1 = (b) r27.component1();     // Catch: Exception -> L34
        final int r5 = ((Number) r27.component2()).intValue();     // Catch: Exception -> L34
        if (r10 == null) goto L41;
        String r6 = r10.d;     // Catch: Exception -> L34
        if (r6 == null) goto L41;
        ((ArrayList) this.a).add(r6);     // Catch: Exception -> L34
    L41:
        final boolean r7 = r1.b;     // Catch: Exception -> L34
        c().T90(((FragmentActivity) r17).getSupportFragmentManager(), r1.a, new RedPacketHybridService$showAnnieLynxRedPacketDialog$4(this, r1, r10), new RedPacketHybridService$showAnnieLynxRedPacketDialog$5(r7, r1, r12, r5));     // Catch: Exception -> L34
        if (r7 == true) goto L56;
        String r0 = r13.toString();     // Catch: Exception -> L34
        Map<String, ? extends Object> r28 = MapsKt.mapOf(new Pair[]{TuplesKt.to("real_open_time", r12), TuplesKt.to("cached", Integer.valueOf(r5)), TuplesKt.to("live_red_envelope_lynx_optimize_strategy", Integer.valueOf(((Number) i1.c.getValue(null, i1.a[1])).intValue()))});     // Catch: Exception -> L34
        zy0.b r29 = r1.a;     // Catch: Exception -> L34
        if (r29 == null) goto L48;
        xy0.a<?> r30 = r29.g();     // Catch: Exception -> L34
        if (r30 == null) goto L48;
        r30.load(r0, r28);     // Catch: Exception -> L34
    L48:
        r1.b = true;     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        int r32 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("RedPacketHybridService", "redpacket lynx failed", e);
        return;
    L56:
        return;
    L55:
        return;
    L22:
        if ((r9 instanceof String) == false) goto L27;
        int r111 = com.bytedance.revenue.platform.api.core.e.a;     // Catch: Exception -> L34
        Uri r33 = com.bytedance.revenue.platform.api.core.e.a((String) r9);     // Catch: Exception -> L34
        if (r33.isHierarchical() == false) goto L26;
        r26 = new com.bytedance.android.live.revenue.common.x0(r33);     // Catch: Exception -> L34
    L28:
        r15.put("fallback_url", r26);     // Catch: Exception -> L34
        goto L29
    L26:
        r26 = new com.bytedance.android.live.revenue.common.x0(Uri.EMPTY);     // Catch: Exception -> L34
        goto L28
    L27:
        int r112 = com.bytedance.revenue.platform.api.core.e.a;     // Catch: Exception -> L34
        r26 = new com.bytedance.android.live.revenue.common.x0(Uri.EMPTY);     // Catch: Exception -> L34
        goto L28
    L52:
        RedPacketState r34 = r18.getState();     // Catch: Exception -> L34
        if (r34 == null) goto L11;
        r10 = r34.getInfo();     // Catch: Exception -> L34
        goto L12
    }
}
