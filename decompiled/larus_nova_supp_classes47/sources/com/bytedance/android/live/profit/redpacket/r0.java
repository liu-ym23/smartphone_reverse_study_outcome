package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.profit.redpacket.api.LuckyBoxApi;
import com.bytedance.android.live.profit.redpacket.trace.RedPacketTraceMonitor;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.model.o1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0 implements com.bytedance.android.scope.o {
    public static final com.bytedance.android.live.revenue.common.u0 y = null;
    public final CompositeDisposable a;
    public final Map<String, RedPacketDrawStatus> b;
    public final List<RedPacket> c;
    public final com.bytedance.revenue.platform.api.core.rx.n<List<RedPacket>> d;
    public final com.bytedance.revenue.platform.api.core.rx.n e;
    public final PropertyOwner<Unit> f;
    public final PropertyOwner g;
    public final PropertyOwner<Integer> h;
    public final PropertyOwner i;
    public final PropertyOwner<Boolean> j;
    public final PropertyOwner k;
    public final PropertyOwner<String> l;
    public final PropertyOwner m;
    public final PropertyOwner<List<com.bytedance.android.livesdk.chatroom.model.n1.e>> n;
    public final PropertyOwner o;
    public final PropertyOwner<l1> p;
    public final PropertyOwner q;
    public final PropertyOwner<String> r;
    public final PropertyOwner s;
    public final PublishSubject<n0> t;
    public final PublishSubject u;
    public final w0 v;
    public final yz0.k w;
    public final yz0.l x;

    public static final class a {
    }

    public static final class b implements Comparator<RedPacket> {
        public static final b a = null;

        public b() {
        }

        static {
            a = new b();
        }

        @Override // java.util.Comparator
        public final int compare(RedPacket r2, RedPacket r3) {
            RedPacket r4 = r2;
            RedPacket r5 = r3;
            Intrinsics.checkNotNullParameter(r4, "a");
            Intrinsics.checkNotNullParameter(r5, "b");
            int r0 = c.a;
            return c.a(r4.getState().getInfo(), r5.getState().getInfo());
        }
    }

    public static final class c implements Comparator<n0> {
        public static final /* synthetic */ int a = 0;

        static {
        }

        public static int a(n0 r2, n0 r3) {
            Intrinsics.checkNotNullParameter(r2, "a");
            Intrinsics.checkNotNullParameter(r3, "b");
            if (i1.a() == 0) goto L15;
            if ((!Intrinsics.areEqual(r2.g, r3.g)) == true) goto L19;
            int r0 = r2.b;
            int r1 = r3.b;
            if (r0 == r1) goto L11;
            return Intrinsics.compare(r0, r1);
        L11:
            if ((!Intrinsics.areEqual(r2.h, r3.h)) == false) goto L22;
            return r2.h.a(r3.h);
        L22:
            return Intrinsics.compare(r2.m, r3.m);
        L19:
            return r2.g.a(r3.g);
        L15:
            if ((!Intrinsics.areEqual(r2.h, r3.h)) == false) goto L18;
            return r2.h.a(r3.h);
        L18:
            return Intrinsics.compare(r2.m, r3.m);
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(n0 r1, n0 r2) {
            return a(r1, r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public d(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            this.a.n.a(r4);
            int r0 = com.bytedance.android.live.revenue.common.v.a;
            com.bytedance.android.live.revenue.common.v.e("RedPacketRepository", "receive request success, result list: " + r4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ r0 a;
        public final /* synthetic */ List b;

        public e(r0 r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Iterator<T> r0 = this.b.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            String r1 = (String) r0.next();
            this.a.r.a(r1);
            goto L4
        L6:
            int r2 = com.bytedance.android.live.revenue.common.v.a;
            com.bytedance.android.live.revenue.common.v.b("RedPacketRepository", "receive failed", r5);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public f(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            r0.a(this.a, r3);
            q0.f(this.a, r3);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public g(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ALogger.e("RedPacketRepository", r4);
            r0 r0 = this.a;
            Intrinsics.checkNotNullParameter(r0, "$this$monitorRedPacketFetchedFail");
            Intrinsics.checkNotNullParameter(r4, "throwable");
            JSONObject r1 = new JSONObject();
            q0.a(r0, r1);
            q0.e("ttlive_redpacket_fetched_status", r4, r1);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public h(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            n0 r8 = (n0) r7;
            this.a.h.a(Integer.valueOf(r8.m));
            r0 r0 = this.a;
            List<RedPacket> r1 = r0.c;
            if ((r1 instanceof Collection) == true) goto L5;
        L7:
            Iterator r2 = ((ArrayList) r1).iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            if (Intrinsics.areEqual(((RedPacket) r2.next()).getState().getInfo().d, r8.d) == false) goto L9;
            boolean r3 = true;
        L14:
            String r4 = "";
            if (r3 == false) goto L21;
            LinkedHashMap r5 = new LinkedHashMap();
            String r6 = r8.d;
            if (r6 == null) goto L20;
            r4 = r6;
        L20:
            r5.put("boxId", r4);
            r5.put(Constants.OperatorKey.MSG, "repeated boxid");
            int r9 = RedPacketTraceMonitor.a;
            RedPacketTraceMonitor.a(RedPacketTraceMonitor.EventName.TTLIVE_PUBLISH_RED_PACKET.getEventName(), RedPacketTraceMonitor.Step.IM_INSERT.getStep(), r5);
        L29:
            q0.g(this.a, r8, RedPacketFromIMStatus.RED_PACKET_RECEIVED.getStatusMsg());
            return;
        L21:
            RedPacket r10 = r0.d(r8);
            ((ArrayList) r0.c).add(r10);
            r0.j(r10);
            r0.i();
            LinkedHashMap r12 = new LinkedHashMap();
            Object r13 = r10.getState().getInfo().d;
            if (r13 != null) goto L24;
            r13 = 0L;
        L24:
            r12.put("luckymoney_id", r13);
            boolean r14 = com.bytedance.android.live.revenue.core.util.h.a;
            ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.SHORT_TOUCH_SELF_LUCKYMONEY, r12, null);
            LinkedHashMap r15 = new LinkedHashMap();
            String r16 = r8.d;
            if (r16 == null) goto L28;
            r4 = r16;
        L28:
            r15.put("boxId", r4);
            int r17 = RedPacketTraceMonitor.a;
            RedPacketTraceMonitor.a(RedPacketTraceMonitor.EventName.TTLIVE_PUBLISH_RED_PACKET.getEventName(), RedPacketTraceMonitor.Step.IM_INSERT.getStep(), r15);
        L13:
            r3 = false;
            goto L14
        L5:
            if (((ArrayList) r1).isEmpty() == false) goto L7;
            goto L7
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public i(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            String r6 = (String) r5;
            PropertyOwner<String> r0 = this.a.l;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "t");
            r0.a(r6);
            Iterator<T> r1 = CollectionsKt.toMutableList(this.a.c).iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            RedPacket r2 = (RedPacket) r1.next();
            if (Intrinsics.areEqual(r2.getState().getInfo().d, r6) == false) goto L4;
            r2.b(RedPacketAction.MarkEmpty.INSTANCE);
            q0.g(this.a, r2.getState().getInfo(), RedPacketFromIMStatus.RED_PACKET_EMPTY.getStatusMsg());
            goto L4
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public j(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            this.a.f.onNext(Unit.INSTANCE);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public k(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Pair r4 = (Pair) r3;
            if (this.a.b.containsKey(r4.getFirst()) == true) goto L5;
            return;
        L5:
            if (((List) r4.getSecond()).contains(this.a.w.getUser().getIdString()) == false) goto L7;
            Map<String, RedPacketDrawStatus> r0 = this.a.b;
            Object r5 = r4.getFirst();
            String r6 = (String) r5;
            r0.put(r6, RedPacketDrawStatus.REWARDED);
            return;
        L7:
            Map<String, RedPacketDrawStatus> r1 = this.a.b;
            Object r7 = r4.getFirst();
            String r8 = (String) r7;
            r1.put(r8, RedPacketDrawStatus.UNREWARDED);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public l(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            PropertyOwner<l1> r0 = this.a.p;
            r0.a((l1) r2);
        }
    }

    public static final class m<T> implements Predicate {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final boolean test(Object r2) {
            RedPacketState r3 = (RedPacketState) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return com.bytedance.android.live.profit.redpacket.f.a(r3);
        }
    }

    public static final class n<T> implements Predicate {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final boolean test(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            if (r6.longValue() != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ RedPacket a;

        public o(RedPacket r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.b(RedPacketAction.MarkExpired.INSTANCE);
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ r0 a;
        public final /* synthetic */ RedPacket b;

        public p(r0 r1, RedPacket r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r24) {
            RedPacketState r1 = (RedPacketState) r24;
            if ((r1 instanceof RedPacketState.Waiting) == false) goto L6;
            x0.b(this.b.getState().getInfo()).takeUntil(this.b.b.filter(s0.a)).subscribe(new t0(this));
        L36:
            if (com.bytedance.android.live.profit.redpacket.f.a(r1) == false) goto L41;
            r0 r2 = this.a;
            RedPacket r3 = this.b;
            if (((ArrayList) r2.c).remove(r3) == false) goto L42;
            int r4 = com.bytedance.android.live.revenue.common.v.a;
            com.bytedance.android.live.revenue.common.v.e("ttlive_red_packet", "removeRedPacket " + r3);
            r2.i();
            return;
        L42:
            return;
        L41:
            return;
        L6:
            if ((r1 instanceof RedPacketState.Rushing) == false) goto L30;
            int r5 = com.bytedance.android.live.profit.redpacket.h.a;
            n0 r6 = r1.getInfo();
            IRoom r7 = this.a.w.getRoom();
            Intrinsics.checkNotNullParameter(r6, "info");
            Intrinsics.checkNotNullParameter(r7, "room");
            int r8 = LuckyBoxApi.a;
            String r9 = r6.d;
            long r10 = r7.getId();
            int r12 = r6.getType();
            long r13 = r6.f.a;
            int r14 = (int) (r6.g.a / com.bytedance.android.live.revenue.common.u0.b);
            IMainRoom r15 = iy0.e.a(r7);
            if (r15 == null) goto L10;
            String r16 = r15.getLabels();
        L11:
            Intrinsics.checkNotNullParameter(r9, "magicBoxId");
            tz0.b r17 = tz0.b.a;
            uz0.e r18 = new uz0.e();
            r17.getClass();
            Intrinsics.checkNotNullParameter(r18, "$this$beforeConfigureRequest");
            Map<String, String> r19 = r18.e;
            Intrinsics.checkNotNullParameter(r19, "fieldsMap");
            Intrinsics.checkNotNullParameter("box_id", "$this$setTo");
            if (r9 == null) goto L14;
            r19.put("box_id", r9);
        L14:
            String r20 = Long.valueOf(r10).toString();
            Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
            if (r20 == null) goto L17;
            r19.put("room_id", r20);
        L17:
            String r22 = Integer.valueOf(r12).toString();
            Intrinsics.checkNotNullParameter("box_type", "$this$setTo");
            if (r22 == null) goto L20;
            r19.put("box_type", r22);
        L20:
            String r23 = Long.valueOf(r13).toString();
            Intrinsics.checkNotNullParameter("send_time", "$this$setTo");
            if (r23 == null) goto L23;
            r19.put("send_time", r23);
        L23:
            String r25 = Integer.valueOf(r14).toString();
            Intrinsics.checkNotNullParameter("delay_time", "$this$setTo");
            if (r25 == null) goto L26;
            r19.put("delay_time", r25);
        L26:
            if (r16 != null) goto L28;
            r16 = "";
        L28:
            Intrinsics.checkNotNullParameter("common_label_list", "$this$setTo");
            r19.put("common_label_list", r16);
            Intrinsics.checkNotNullParameter(r18, "$this$afterConfigureRequest");
            RxUtilKt.h(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/luckybox/rush/", TypesJVMKt.getJavaType(Reflection.typeOf(o1.class)), Extra.class, r18.d, r18.a, r18.b, r18.c, r18.e, r18.f, r18.g).map(com.bytedance.android.live.profit.redpacket.j.a)).singleOrError().subscribe(new u0(this, r1), new v0(this, r1));
            goto L36
        L10:
            r16 = null;
            goto L11
        L30:
            if ((r1 instanceof RedPacketState.Empty) == false) goto L33;
            com.bytedance.android.live.profit.redpacket.o.e(this.b.getState().getInfo(), this.a.w.isAnchor(), RedPacketMissReason.Empty);
            goto L36
        L33:
            if ((r1 instanceof RedPacketState.Expired) == false) goto L36;
            com.bytedance.android.live.profit.redpacket.o.e(this.b.getState().getInfo(), this.a.w.isAnchor(), RedPacketMissReason.Expired);
            goto L36
        }
    }

    public static final class q<T, R> implements Function {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final Object apply(Object r2) {
            k1 r3 = (k1) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.c;
        }
    }

    static {
        com.bytedance.android.live.revenue.common.u0 r0 = com.bytedance.android.live.revenue.common.u0.f;
        y = new com.bytedance.android.live.revenue.common.u0(500);
    }

    public final void c() {
        Iterator r0 = CollectionsKt.toMutableList(this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((RedPacket) r0.next()).b(RedPacketAction.Dispose.INSTANCE);
        goto L4
    L6:
        ((ArrayList) this.c).clear();
        ((LinkedHashMap) this.b).clear();
    }

    public final void g() {
        int r0 = com.bytedance.android.live.profit.redpacket.h.a;
        RxUtilKt.c(com.bytedance.android.live.profit.redpacket.h.b(this.w.getRoom().getId()).subscribe(new f(this), new g(this)), this.a);
    }

    public final void i() {
        CollectionsKt.sortWith(this.c, b.a);
        this.d.a(CollectionsKt.toMutableList(this.c));
    }

    public final void onStart() {
        if (this.v.p().a == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.live.revenue.common.l0.a("luckybox") == false) goto L8;
        com.bytedance.android.livesdk.revenue.service.room.b.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class), this.w.getRoom().getRoomId(), com.bytedance.android.live.profit.redpacket.model.b.class, new RedPacketRepository$runWithBackendData$1(this), null, null, new RedPacketRepository$runWithBackendData$2(this), this.a, 24);
    L9:
        RedPacketIMDataSource r0 = new RedPacketIMDataSource(this.x, this.a);
        RxUtilKt.c(r0.b.subscribe(new h(this)), this.a);
        RxUtilKt.c(r0.f.subscribe(new i(this)), this.a);
        RxUtilKt.c(r0.h.subscribe(new j(this)), this.a);
        RxUtilKt.c(r0.j.subscribe(new k(this)), this.a);
        RxUtilKt.c(r0.l.subscribe(new l(this)), this.a);
        return;
    L8:
        g();
        goto L9
    }

    public final void onStop() {
        this.a.dispose();
        c();
    }

    public final RedPacket d(n0 r5) {
        com.bytedance.android.live.revenue.common.u0 r0 = x0.d();
        if (r5.e != 2) goto L6;
        this.b.put(r5.d, RedPacketDrawStatus.JOINED);
    L6:
        if (r0.a(r5.h) >= 0) goto L9;
        RedPacket r1 = new RedPacket(new RedPacketState.Waiting(r5));
    L12:
        int r6 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_red_packet", "createRedPacket " + r1);
        return r1;
    L9:
        if (r0.a(r5.i) >= 0) goto L11;
        r1 = new RedPacket(new RedPacketState.Available(r5));
        goto L12
    L11:
        r1 = new RedPacket(new RedPacketState.Expired(r5));
        goto L12
    }

    public final void h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "redPacketId");
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        RedPacket r1 = (RedPacket) r0.next();
        if (Intrinsics.areEqual(r1.getState().getInfo().d, r5) == false) goto L4;
        r1.b(new RedPacketAction.MarkRushed(RedPacketRushResult.a.a));
        goto L4
    L8:
        i();
    }

    public final void j(RedPacket r5) {
        com.bytedance.android.live.core.utils.rxutils.f r0 = RxCompatKt.a(r5.b.map(q.a).startWith(r5.getState()));
        com.bytedance.android.live.revenue.common.s0.a(r5.getState().getInfo().i.b(x0.d()), y).takeUntil(r0.filter(m.a)).filter(n.a).take(1).subscribe(new o(r5));
        r0.subscribe(new p(this, r5));
        Disposable r6 = (Disposable) JavaCalls.callMethodOrThrow(r0.a, "connect", new Object[0]);
    }

    public static final void a(r0 r6, List r7) {
        r6.c();
        List r8 = r7;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r2 = r8.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(r6.d((n0) r2.next()));
        goto L4
    L6:
        ((ArrayList) r6.c).addAll(r0);
        Iterator r3 = r0.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r6.j((RedPacket) r3.next());
        goto L8
    L10:
        r6.i();
        r6.f(r0, LuckyBoxApi.ReceiveReqType.REQ_TYPE_NORMAL.getValue());
        DataCenter r1 = r6.w.getDataCenter();
        Boolean r4 = Boolean.FALSE;
        Boolean r5 = (Boolean) r1.get("click_red_packet_from_preview", r4);
        ALogger.i("RedPacketRepository", "check red packet from preview: " + r5);
        if (r5.booleanValue() == false) goto L13;
        r6.w.getDataCenter().put("click_red_packet_from_preview", r4);
        r6.j.onNext(Boolean.TRUE);
        r6.j.onComplete();
    L13:
        PropertyOwner<Integer> r9 = r6.h;
        Iterator r10 = r8.iterator();
        if (r10.hasNext() == true) goto L16;
        Object r12 = null;
    L26:
        n0 r13 = (n0) r12;
        if (r13 == null) goto L29;
        int r14 = r13.m;
    L30:
        r9.a(Integer.valueOf(r14));
        LinkedHashMap r15 = new LinkedHashMap();
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r17 = r8.iterator();
    L32:
        if (r17.hasNext() == false) goto L34;
        r16.add(((n0) r17.next()).d);
        goto L32
    L34:
        r15.put("boxId", r16);
        int r18 = RedPacketTraceMonitor.a;
        RedPacketTraceMonitor.a(RedPacketTraceMonitor.EventName.TTLIVE_PUBLISH_RED_PACKET.getEventName(), RedPacketTraceMonitor.Step.BOX_LIST_UPDATE.getStep(), r15);
        return;
    L29:
        r14 = 0;
        goto L30
    L16:
        Object r19 = r10.next();
        if (r10.hasNext() == true) goto L19;
    L18:
        r12 = r19;
        goto L26
    L19:
        int r20 = ((n0) r19).m;
    L20:
        Object r22 = r10.next();
        int r23 = ((n0) r22).m;
        if (r20 >= r23) goto L24;
        r19 = r22;
        r20 = r23;
    L24:
        if (r10.hasNext() == true) goto L20;
        goto L18
    }

    public final void f(List<RedPacket> r17, int r18) {
        if (i1.a() != 0) goto L5;
        return;
    L5:
        if (i1.a() == 2) goto L62;
        com.bytedance.android.live.revenue.common.u0 r1 = x0.d();
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r17.iterator();
    L8:
        boolean r5 = false;
        if (r2.hasNext() == false) goto L20;
        Object r4 = r2.next();
        RedPacket r7 = (RedPacket) r4;
        if (this.b.containsKey(r7.getState().getInfo().d) == true) goto L13;
    L17:
        if (r5 == false) goto L8;
        r3.add(r4);
        goto L8
    L13:
        if (r7.getState().getInfo().g.a(com.bytedance.android.live.revenue.common.u0.f) <= 0) goto L17;
        if (r1.a(r7.getState().getInfo().h) < 0) goto L17;
        r5 = true;
        goto L17
    L20:
        if (r3.isEmpty() == false) goto L23;
        int r6 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("RedPacketRepository", "receive request: no awarded red packets");
        return;
    L23:
        ArrayList r8 = new ArrayList();
        Iterator r9 = r3.iterator();
    L25:
        if (r9.hasNext() == false) goto L35;
        Object r10 = r9.next();
        RedPacket r12 = (RedPacket) r10;
        if (((RedPacketDrawStatus) ((LinkedHashMap) this.b).get(r12.getState().getInfo().d)) == RedPacketDrawStatus.UNREWARDED) goto L29;
    L32:
        boolean r13 = true;
    L33:
        if (r13 == false) goto L25;
        r8.add(r10);
        goto L25
    L29:
        if (r12.getState().getInfo().c == true) goto L32;
        r13 = false;
        goto L33
    L35:
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r15 = r8.iterator();
    L37:
        if (r15.hasNext() == false) goto L40;
        r14.add(((RedPacket) r15.next()).getState().getInfo().d);
        goto L37
    L40:
        if ((!r14.isEmpty()) == false) goto L61;
        int r16 = com.bytedance.android.live.profit.redpacket.h.a;
        Intrinsics.checkNotNullParameter(r14, "ids");
        int r19 = LuckyBoxApi.a;
        Intrinsics.checkNotNullParameter(r14, "magicBoxId");
        tz0.b r20 = tz0.b.a;
        uz0.e r22 = new uz0.e();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r22, "$this$beforeConfigureRequest");
        Map<String, String> r23 = r22.e;
        Intrinsics.checkNotNullParameter(r23, "fieldsMap");
        String r24 = CollectionsKt.joinToString$default(r14, ",", null, null, 0, null, null, 62, null);
        Intrinsics.checkNotNullParameter("box_id_str", "$this$setTo");
        if (r24 == null) goto L44;
        r23.put("box_id_str", r24);
    L44:
        String r25 = Integer.valueOf(r18).toString();
        Intrinsics.checkNotNullParameter("req_type", "$this$setTo");
        if (r25 == null) goto L47;
        r23.put("req_type", r25);
    L47:
        Intrinsics.checkNotNullParameter(r22, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.h(RxCompatKt.b(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/luckybox/receive/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.chatroom.model.n1.class)), Extra.class, r22.d, r22.a, r22.b, r22.c, r22.e, r22.f, r22.g).map(com.bytedance.android.live.profit.redpacket.i.a), RxUtil.rxRetryHelper(3, 1000))).singleOrError().subscribe(new d(this), new e(this, r14)), this.a);
        return;
    L61:
        return;
    }

    public r0(w0 r2, yz0.k r3, yz0.l r4) {
        Intrinsics.checkNotNullParameter(r2, "redPacketScope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "messageService");
        this.v = r2;
        this.w = r3;
        this.x = r4;
        this.a = new CompositeDisposable();
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
        com.bytedance.revenue.platform.api.core.rx.n<List<RedPacket>> r5 = PropertyOwnersKt.b(CollectionsKt.emptyList());
        this.d = r5;
        this.e = r5;
        PropertyOwner<Unit> r6 = new PropertyOwner(Unit.INSTANCE);
        this.f = r6;
        this.g = r6;
        PropertyOwner<Integer> r7 = new PropertyOwner(0);
        this.h = r7;
        this.i = r7;
        PropertyOwner<Boolean> r8 = new PropertyOwner(Boolean.FALSE);
        this.j = r8;
        this.k = r8;
        PropertyOwner<String> r9 = new PropertyOwner("");
        this.l = r9;
        this.m = r9;
        PropertyOwner<List<com.bytedance.android.livesdk.chatroom.model.n1.e>> r10 = new PropertyOwner(CollectionsKt.emptyList());
        this.n = r10;
        this.o = r10;
        PropertyOwner<l1> r12 = new PropertyOwner(new l1(null, null, null));
        this.p = r12;
        this.q = r12;
        PropertyOwner<String> r13 = new PropertyOwner("");
        this.r = r13;
        this.s = r13;
        PublishSubject<n0> r14 = PublishSubject.create();
        this.t = r14;
        this.u = r14;
    }
}
