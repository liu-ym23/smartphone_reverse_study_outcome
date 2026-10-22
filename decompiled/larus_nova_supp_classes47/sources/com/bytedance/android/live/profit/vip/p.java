package com.bytedance.android.live.profit.vip;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final long b;
    public final String c;
    public final String d;
    public final com.bytedance.android.live.revenue.common.reactive.c e;
    public final com.bytedance.android.live.revenue.common.reactive.c f;
    public final com.bytedance.android.live.revenue.common.reactive.c g;
    public final com.bytedance.android.live.revenue.common.reactive.c h;
    public final yz0.g i;
    public final com.bytedance.android.livesdk.revenue.service.room.c j;
    public final com.bytedance.android.livesdk.revenue.service.vs.b k;

    public static final class a {
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
            return (com.bytedance.android.live.profit.vip.model.g) r3.data;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ p a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public c(p r1, long r2, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r10) {
            com.bytedance.android.live.profit.vip.model.g r12 = (com.bytedance.android.live.profit.vip.model.g) r10;
            com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
            long r1 = System.currentTimeMillis() - this.b;
            com.bytedance.android.live.profit.privilege.e r2 = com.bytedance.android.live.profit.privilege.e.a;
            p r3 = this.a;
            String r4 = r3.d;
            String r5 = r3.c;
            long r6 = r3.b;
            String r7 = this.c;
            Intrinsics.checkNotNullParameter(r4, "userId");
            Intrinsics.checkNotNullParameter(r5, "anchorId");
            Intrinsics.checkNotNullParameter(r7, "source");
            JSONObject r8 = com.bytedance.android.live.profit.privilege.e.k(true, null, null);
            JSONObject r9 = com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r1));
            JSONObject r13 = com.bytedance.android.live.profit.privilege.e.l(Long.valueOf(r6), r5);
            com.bytedance.android.live.profit.privilege.e.t(r13, "source", r7);
            com.bytedance.android.live.profit.privilege.e.p("ttlive_subscribe_info_status_all", r8, r9, r13);
            int r14 = w51.a.a;
            w51.a.C0337a.a("response emoji status: " + r12.getEmojiStatus());
            p.a(this.a, r12, this.c);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            int r15 = w51.a.a;
            w51.a.C0337a.b("VipRepository", "response emoji error: " + th);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ p a;
        public final /* synthetic */ String b;

        public d(p r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            Intrinsics.checkNotNullParameter(r10, "t");
            com.bytedance.android.live.profit.privilege.e r0 = com.bytedance.android.live.profit.privilege.e.a;
            p r1 = this.a;
            String r2 = r1.d;
            String r3 = r1.c;
            long r4 = r1.b;
            String r5 = q0.a(r10);
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            int r6 = r0.a(r10);
            String r7 = this.b;
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "anchorId");
            Intrinsics.checkNotNullParameter(r5, Constants.Keys.ERROR);
            Intrinsics.checkNotNullParameter(r7, "source");
            JSONObject r8 = com.bytedance.android.live.profit.privilege.e.k(false, r5, Integer.valueOf(r6));
            JSONObject r12 = com.bytedance.android.live.profit.privilege.e.n(null);
            JSONObject r13 = com.bytedance.android.live.profit.privilege.e.l(Long.valueOf(r4), r3);
            com.bytedance.android.live.profit.privilege.e.t(r13, "source", r7);
            com.bytedance.android.live.profit.privilege.e.p("ttlive_subscribe_info_status_all", r8, r12, r13);
            com.bytedance.android.live.profit.privilege.e.p("ttlive_subscribe_info_status_error", r8, r12, r13);
            int r14 = w51.a.a;
            w51.a.C0337a.a("query subscribe info failed: " + r10.getMessage());
            this.a.e.setValue(new h(1995));
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final com.bytedance.android.live.profit.vip.b c() {
        String r0 = this.c + this.d;
        HashMap r1 = (HashMap) jv0.a.b.getValue(null, jv0.a.a[0]);
        if (r1.containsKey(r0) == true) goto L5;
        return null;
    L5:
        return (com.bytedance.android.live.profit.vip.b) r1.get(r0);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public final void d(String r19) {
        Intrinsics.checkNotNullParameter(r19, "source");
        if (IRoomKt_androidKt.isMediaRoom(this.i.mo444getRoom()) == false) goto L5;
    L15:
        int r1 = w51.a.a;
        w51.a.C0337a.a("query condition not passed: isMediaRoom : " + IRoomKt_androidKt.isMediaRoom(this.i.mo444getRoom()) + "isReplayVideo:" + this.k.s8());
        return;
    L5:
        if (this.k.s8() == true) goto L15;
        com.bytedance.live.kmp.util.c r3 = com.bytedance.live.kmp.util.c.a;
        long r4 = System.currentTimeMillis();
        int r5 = iv0.a.a;
        long r6 = this.b;
        String r7 = this.c;
        Intrinsics.checkNotNullParameter(r7, "anchorId");
        Intrinsics.checkNotNullParameter(r19, "source");
        tz0.b r8 = tz0.b.a;
        uz0.c r9 = new uz0.c();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map<String, String> r10 = r9.b;
        Intrinsics.checkNotNullParameter(r10, "queriesMap");
        String r12 = Long.valueOf(r6).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r12 == null) goto L10;
        r10.put("room_id", r12);
    L10:
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");
        if (r7 == null) goto L13;
        r10.put("anchor_id", r7);
    L13:
        Intrinsics.checkNotNullParameter("source", "$this$setTo");
        r10.put("source", r19);
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        Observable r2 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/privilege/subscribe/info/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.vip.model.g.class)), Extra.class, r9.d, r9.a, r9.b, r9.c);
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r2.observeOn(AndroidSchedulers.mainThread()).map(b.a).subscribe(new c(this, r4, r19), new d(this, r19)), this.a);
    }

    public final void f(com.bytedance.android.live.profit.vip.b r5) {
        Intrinsics.checkNotNullParameter(r5, "cache");
        ((HashMap) jv0.a.b.getValue(null, jv0.a.a[0])).put(this.c + this.d, r5);
    }

    public p(yz0.g r2, com.bytedance.android.livesdk.revenue.service.room.c r3, com.bytedance.android.livesdk.revenue.service.vs.b r4) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "vsService");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.a = new CompositeDisposable();
        this.b = IRoomKtKt.getId(r2.mo444getRoom());
        IBaseUser r5 = r2.mo444getRoom().getOwnerKt();
        if (r5 == null) goto L6;
        String r6 = r5.getIdString();
        if (r6 == null) goto L6;
    L7:
        this.c = r6;
        String r7 = r2.getUser().getIdString();
        this.d = r7;
        Intrinsics.areEqual(r6, r7);
        com.bytedance.android.live.revenue.common.reactive.c r8 = new com.bytedance.android.live.revenue.common.reactive.c(new h(2047));
        this.e = r8;
        Intrinsics.checkNotNullParameter(r8, "$this$asReadonly");
        this.f = r8;
        com.bytedance.android.live.revenue.common.reactive.c r9 = new com.bytedance.android.live.revenue.common.reactive.c(Boolean.FALSE);
        this.g = r9;
        Intrinsics.checkNotNullParameter(r9, "$this$asReadonly");
        this.h = r9;
        return;
    L6:
        r6 = "";
        goto L7
    }

    public static final void a(p r32, com.bytedance.android.live.profit.vip.model.g r33, String r34) {
        if (r33 != null) goto L5;
        r32.getClass();
        return;
    L5:
        boolean r12 = r32.k.isVsRoom();
        Intrinsics.checkNotNullParameter(r33, "$this$toSubscribeInfo");
        if (((int) r33.getEmojiStatus()) != 2) goto L8;
        boolean r3 = true;
    L9:
        List<com.bytedance.android.live.profit.vip.model.a> r4 = r33.getEmojiList();
        if (r4 == null) goto L20;
        List<com.bytedance.android.live.profit.vip.model.a> r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L13:
        if (r7.hasNext() == false) goto L19;
        com.bytedance.android.live.profit.vip.model.a r8 = (com.bytedance.android.live.profit.vip.model.a) r7.next();
        Intrinsics.checkNotNullParameter(r8, "$this$toEmojiData");
        long r18 = r8.getId();
        py.k r20 = r8.getImg();
        long r22 = r8.getEmojiScaleType();
        com.bytedance.android.live.profit.vip.model.c r9 = r8.getLabel();
        if (r9 == null) goto L17;
        Intrinsics.checkNotNullParameter(r9, "$this$toEmojiLabel");
        com.bytedance.android.live.profit.vip.c r23 = new com.bytedance.android.live.profit.vip.c(r9.getImg());
    L18:
        r6.add(new l(r18, r20, r22, r23, r3, r8.getType(), r8.getStatus(), r8.getCanDelTime(), r8.getRejectReason()));
        goto L13
    L17:
        r23 = null;
        goto L18
    L19:
        List r10 = r6;
    L21:
        int r13 = (int) r33.getEmojiStatus();
        boolean r14 = r33.isMember();
        int r15 = r33.getMemberType();
        boolean r16 = r33.getEntrance();
        boolean r17 = r33.getEntranceTab();
        com.bytedance.android.live.profit.vip.model.d r19 = r33.getEmojiTabInfo();
        if (r19 == null) goto L24;
        Intrinsics.checkNotNullParameter(r19, "$this$toEmojiTabInfoData");
        m r110 = new m(r19.getDescribe(), r19.getBtnShow(), r19.getBtnText(), r19.getBtnSchema(), r19.getEmojiIconSelectUrl(), r19.getEmojiIconUnselectUrl(), r19.getEmojiTabName());
    L25:
        com.bytedance.android.live.profit.vip.d r24 = r33.getUserData();
        if (r24 == null) goto L28;
        int r111 = (int) r24.getLevel();
    L29:
        com.bytedance.android.live.profit.vip.d r2 = r33.getUserData();
        if (r2 == null) goto L32;
        long r25 = r2.getExpiredTime();
    L33:
        long r112 = r25;
        com.bytedance.android.live.profit.vip.model.h r26 = r33.getAnchorData();
        if (r26 == null) goto L36;
        int r27 = (int) r26.getStatus();
    L37:
        h r113 = new h(r10, r13, r14, r15, r16, r17, r110, r12, r111, r112, r27);
        if (r33.isMember() == true) goto L40;
    L64:
        p r0 = r32;
        int r28 = 1;
    L65:
        r0.e.setValue(r113);
        if (r0.i.isAnchor() == false) goto L82;
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = jv0.a.c;
        KProperty[] r29 = jv0.a.a;
        Map r30 = (Map) r1.getValue(null, r29[r28]);
        Pair[] r35 = new Pair[r28];
        r35[0] = TuplesKt.to(r0.c, Boolean.valueOf(r33.getEntrance()));
        Map r36 = MapsKt.plus(r30, MapsKt.hashMapOf(r35));
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r1.setValue(null, r29[r28], r36);
        return;
    L82:
        return;
    L40:
        if (Intrinsics.areEqual("emoji", r34) == false) goto L64;
        List<l> r37 = r113.a;
        if (r37.isEmpty() == true) goto L64;
        com.bytedance.android.live.profit.vip.b r38 = r32.c();
        if (r38 == null) goto L59;
        List<Long> r39 = r38.a;
        HashMap r40 = new HashMap();
        Iterator<Long> r42 = r39.iterator();
    L48:
        if (r42.hasNext() == false) goto L50;
        r40.put(Long.valueOf(r42.next().longValue()), Boolean.TRUE);
        goto L48
    L50:
        Iterator<T> r43 = r37.iterator();
        boolean r114 = false;
    L52:
        if (r43.hasNext() == false) goto L58;
        l r44 = (l) r43.next();
        long r45 = r44.i + 518400;
        com.bytedance.live.kmp.util.c r46 = com.bytedance.live.kmp.util.c.a;
        if (r45 < (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN))) goto L52;
        if (r40.containsKey(Long.valueOf(r44.a)) == true) goto L52;
        r44.f = true;
        r114 = true;
        goto L52
    L58:
        r0 = r32;
        r28 = 1;
        r0.g.setValue(Boolean.valueOf(r114));
        goto L65
    L59:
        r0 = r32;
        r28 = 1;
        ArrayList r47 = new ArrayList();
        Iterator<T> r48 = r37.iterator();
    L61:
        if (r48.hasNext() == false) goto L63;
        r47.add(Long.valueOf(((l) r48.next()).a));
        goto L61
    L63:
        r0.f(new com.bytedance.android.live.profit.vip.b(r47, 2));
        goto L65
    L36:
        r27 = 0;
        goto L37
    L32:
        r25 = 0;
        goto L33
    L28:
        r111 = 0;
        goto L29
    L24:
        r110 = null;
        goto L25
    L20:
        r10 = CollectionsKt.emptyList();
        goto L21
    L8:
        r3 = false;
        goto L9
    }
}
