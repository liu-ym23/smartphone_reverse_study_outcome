package com.bytedance.android.live.revlink.impl.plantform;

import android.util.LruCache;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenuelink.usercenter.ListUpdateType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.bridge.j;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.d3;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.q;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.s5;
import com.bytedance.android.livesdk.link.model.t6;
import com.bytedance.android.livesdk.link.model.z;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorLinkUserCenterV2 implements i11.b {
    public static final /* synthetic */ int u = 0;
    public final List<p> a;
    public final List<p> b;
    public final CopyOnWriteArrayList<i11.d> c;
    public final CopyOnWriteArrayList<IBaseUser> d;
    public final ArrayList<p> e;
    public final LruCache<String, p> f;
    public final CompositeDisposable g;
    public final CopyOnWriteArrayList<i11.c.b> h;
    public final CopyOnWriteArrayList<Function1<r, Unit>> i;
    public i11.f j;
    public t6 k;
    public final CompositeDisposable l;
    public final boolean m;
    public final List<Integer> n;
    public b o;
    public String p;
    public final ld.a q;
    public final com.bytedance.android.livesdk.revenue.service.room.c r;
    public final com.bytedance.android.live.revlink.impl.global.c s;
    public final yz0.f t;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final ListUpdateType a;
        public final String b;
        public final int c;
        public final String d;
        public final String e;
        public final long f;
        public final long g;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L20;
            b r7 = (b) r6;
            if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
            return false;
        L16:
            if (this.f == r7.f) goto L18;
            return false;
        L18:
            if (this.g == r7.g) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            ListUpdateType r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (((r3 + r5) * 31) + this.c) * 31;
            String r7 = this.d;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.e;
            if (r10 == null) goto L17;
            r1 = r10.hashCode();
        L17:
            int r12 = (r9 + r1) * 31;
            long r13 = this.f;
            int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
            long r15 = this.g;
            return r14 + ((int) (r15 ^ (r15 >>> 32)));
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "RefreshInfo(type=" + this.a + ", extra=" + this.b + ", scene=" + this.c + ", linkType=" + this.d + ", logId=" + this.e + ", version=" + this.f + ", timestamp=" + this.g + ")";
        }

        public final ListUpdateType getType() {
            return this.a;
        }

        public b(ListUpdateType r4, String r5, int r6, String r7, String r8, long r9, int r12) {
            if ((r12 & 2) == 0) goto L6;
            r5 = "";
        L6:
            if ((r12 & 4) == 0) goto L9;
            r6 = 0;
        L9:
            if ((r12 & 16) == 0) goto L11;
            r8 = "";
        L11:
            long r1 = 0;
            if ((r12 & 32) == 0) goto L15;
            r9 = 0;
        L15:
            if ((r12 & 64) == 0) goto L17;
            i97.a r13 = i97.a.a;
            r1 = System.currentTimeMillis();
        L17:
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "extra");
            Intrinsics.checkNotNullParameter(r7, "linkType");
            Intrinsics.checkNotNullParameter(r8, "logId");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorLinkUserCenterV2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public c(AnchorLinkUserCenterV2 r1, String r2, long r3, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r8) {
            AnchorLinkUserCenterV2 r0 = this.a;
            String r1 = this.b;
            AnchorLinkUserCenterV2.P(r0, r1, (ExtraResponse) r8, t.a(this.c), this.d, this.e);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AnchorLinkUserCenterV2 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public d(AnchorLinkUserCenterV2 r1, long r2, String r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            long r5 = t.a(this.b);
            MultiEnterRoomTracer r0 = this.a.I();
            if (r0 == null) goto L5;
            r0.b(this.c, this.a.m, r5);
        L5:
            v r1 = this.a.J();
            if (r1 == null) goto L8;
            r1.z(this.d, this.a.E(), this.c, r5, r10);
        L8:
            this.a.j = null;
            if (Intrinsics.areEqual(this.c, "multi_anchor_link_widget_create") == false) goto L11;
        L12:
            AnchorLinkOptUtils r2 = this.a.C();
            if (r2 == null) goto L26;
            this.a.H();
            if (r2.e() == true) goto L17;
            return;
        L17:
            if ((r10 instanceof ApiServerException) == true) goto L19;
            r10 = null;
        L19:
            ApiServerException r12 = (ApiServerException) r10;
            if (r12 != null) goto L22;
        L23:
            this.a.b(this.e, "request_failed_retry");
            return;
        L22:
            if (r12.getErrorCode() != 31001) goto L23;
            return;
        L26:
            return;
        L11:
            if (Intrinsics.areEqual(this.c, "enter_room_preload") == true) goto L12;
        }
    }

    public static final class e extends i11.c.a {
        public final /* synthetic */ Function2 a;

        public e(Function2 r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void d(int r3, List<? extends p> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            this.a.invoke(r4, Integer.valueOf(r3));
            Intrinsics.checkNotNullParameter(r4, "list");
        }

        @Override // i11.c.a, i11.c.b
        public final void h(int r2, List<? extends p> r3) {
            Function2 r0 = this.a;
            if (r3 != null) goto L5;
            r3 = CollectionsKt.emptyList();
        L5:
            r0.invoke(r3, Integer.valueOf(r2));
        }
    }

    static {
        new a();
    }

    public final com.bytedance.android.live.revlink.impl.utils.a B() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.B8();
    }

    public final AnchorLinkOptUtils C() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.vk();
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.utils.d D() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.of();
    }

    public final long E() {
        LinkCrossRoomDataHolder r1 = G();
        if (r1 != null) goto L5;
    L87:
        LinkCrossRoomDataHolder r2 = G();
        if (r2 != null) goto L90;
        return 0;
    L90:
        return r2.c();
    L5:
        if (r1.c() != 0) goto L87;
        w r3 = K();
        if (r3 != null) goto L9;
    L10:
        w r4 = K();
        if (r4 == null) goto L87;
        if (r4.d() != true) goto L87;
    L15:
        if (this.m == false) goto L19;
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r5 = D();
        if (r5 == null) goto L19;
        r5.b("");
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r6 = null;
        String r7 = " fixed";
        if (this.m == true) goto L57;
        if (C() == null) goto L57;
        H();
        com.bytedance.android.live.revlink.impl.global.c r8 = this.s;
        if (r8 == null) goto L26;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r9 = r8.rb();
    L27:
        if (r9 == null) goto L57;
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r10 = D();
        if (r10 == null) goto L50;
        Intrinsics.checkNotNullParameter("list", "reqFrom");
        i97.a r12 = i97.a.a;
        if ((System.currentTimeMillis() - r10.a) < 300) goto L50;
        r10.a = System.currentTimeMillis();
        LinkedHashMap r13 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r14 = r10.d;
        if (r14 == null) goto L36;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r15 = r14.getMultiAnchorLinkContextObj();
    L37:
        if (r15 == null) goto L39;
        Long r16 = Long.valueOf(r15.a());
    L40:
        if (r16 != null) goto L42;
        Object r17 = "null";
    L43:
        r13.put("audience_channel_id", r17);
        if (r16 != null) goto L46;
    L48:
        StringBuilder r18 = new StringBuilder();
        r18.append("list");
        StringBuilder r19 = r18;
        r7 = " exception";
    L49:
        r19.append(r7);
        r13.put("error_msg", r19.toString());
        r10.c("audience_use_link_context_channel_id", r13);
        goto L50
    L46:
        if (r16.longValue() == 0) goto L48;
        r19 = new StringBuilder();
        r19.append("list");
        goto L49
    L42:
        r17 = r16;
        goto L43
    L39:
        r16 = null;
        goto L40
    L36:
        r15 = null;
    L50:
        com.bytedance.android.live.revlink.impl.global.c r20 = this.s;
        if (r20 == null) goto L53;
        r6 = r20.getMultiAnchorLinkContextObj();
    L53:
        if (r6 != null) goto L55;
        return 0;
    L55:
        return r6.a();
    L26:
        r9 = null;
    L57:
        if (this.m == false) goto L87;
        w r22 = K();
        if (r22 == null) goto L87;
        if (r22.d() != true) goto L87;
        if (C() == null) goto L87;
        H();
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r23 = D();
        if (r23 == null) goto L81;
        Intrinsics.checkNotNullParameter("list", "reqFrom");
        i97.a r24 = i97.a.a;
        if ((System.currentTimeMillis() - r23.a) < 300) goto L81;
        r23.a = System.currentTimeMillis();
        LinkedHashMap r25 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r26 = r23.d;
        if (r26 == null) goto L72;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r27 = r26.getMultiAnchorLinkContextObj();
    L73:
        if (r27 == null) goto L75;
        long r28 = r27.a();
    L76:
        r25.put("anchor_channel_id", Long.valueOf(r28));
        if (r28 == 0) goto L79;
        StringBuilder r29 = new StringBuilder();
        r29.append("list");
    L80:
        r29.append(r7);
        r25.put("error_msg", r29.toString());
        r23.c("anchor_use_link_context_channel_id", r25);
        goto L81
    L79:
        StringBuilder r30 = new StringBuilder();
        r30.append("list");
        r29 = r30;
        r7 = " exception";
        goto L80
    L75:
        r28 = 0;
        goto L76
    L72:
        r27 = null;
    L81:
        com.bytedance.android.live.revlink.impl.global.c r32 = this.s;
        if (r32 == null) goto L84;
        r6 = r32.getMultiAnchorLinkContextObj();
    L84:
        if (r6 != null) goto L86;
        return 0;
    L86:
        return r6.a();
    L9:
        if (r3.e() == true) goto L15;
        goto L10
    }

    public final int F() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.g r1 = r0.getAnchorConnectUtils();
    L6:
        if (r1 != null) goto L8;
    L10:
        return 7;
    L8:
        if (r1.v1() != true) goto L10;
        return 1;
    L5:
        r1 = null;
        goto L6
    }

    public final LinkCrossRoomDataHolder G() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public final IRoom H() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.r;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L7;
        IRoomBase r2 = r1.getCommonRoom();
    L9:
        return (IRoom) r2;
    L7:
        r2 = null;
        goto L9
    }

    public final MultiEnterRoomTracer I() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i7();
    }

    public final v J() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkMonitor();
    }

    public final w K() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    @Override // i11.b
    public final int c() {
        if ((!this.a.isEmpty()) == true) goto L5;
        return 1;
    L5:
        return ((CopyOnWriteArrayList) this.a).size();
    }

    @Override // i11.b
    public final List<p> d() {
        return CollectionsKt.toList(this.e);
    }

    @Override // i11.c
    public final Map<String, String> g() {
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, p> r1 = this.f.snapshot();
        ArrayList r2 = new ArrayList(r1.size());
        Iterator<Map.Entry<String, p>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(r3.next().getValue());
        goto L4
    L6:
        Iterator r4 = r2.iterator();
    L7:
        String r5 = null;
        if (r4.hasNext() == false) goto L16;
        p r6 = (p) r4.next();
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L12;
        r5 = r7.getIdString();
    L12:
        String r8 = r6.getInteractId();
        if (r5 == null) goto L7;
        if (r8 == null) goto L7;
        r0.put(r5, r8);
        goto L7
    L16:
        Iterator r9 = CollectionsKt.plus(this.a, this.b).iterator();
    L18:
        if (r9.hasNext() == false) goto L27;
        p r10 = (p) r9.next();
        IBaseUser r12 = r10.getUser();
        if (r12 == null) goto L22;
        String r13 = r12.getIdString();
    L23:
        String r14 = r10.getInteractId();
        if (r13 == null) goto L18;
        if (r14 == null) goto L18;
        r0.put(r13, r14);
        goto L18
    L22:
        r13 = null;
        goto L23
    L27:
        return r0;
    }

    @Override // i11.b
    public final List<IBaseUser> getInviteeList() {
        CopyOnWriteArrayList<i11.d> r0 = this.c;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(((i11.d) r2.next()).a);
        goto L4
    L7:
        return CollectionsKt.toMutableList(r1);
    }

    @Override // i11.b
    public final List<i11.d> s() {
        return CollectionsKt.toList(this.c);
    }

    public final void z() {
        yz0.f r0 = this.t;
        if (r0 == null) goto L10;
        Observable r1 = h.a.a(r0, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r1 == null) goto L11;
        final AnchorLinkUserCenterV2$attach$1 r2 = new AnchorLinkUserCenterV2$attach$1(this);
        Disposable r3 = r1.subscribe(new f(r2));
        if (r3 == null) goto L12;
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, this.l);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // i11.c
    public final List<p> a() {
        return this.b;
    }

    @Override // i11.c
    public final List<p> getOnlineUserList() {
        return this.a;
    }

    @Override // i11.b
    public final t6 j() {
        return this.k;
    }

    @Override // i11.b
    public final List<IBaseUser> n() {
        return this.d;
    }

    @Override // i11.b
    public final String w() {
        return this.p;
    }

    public final boolean L(int r6) {
        if (this.m == true) goto L5;
    L13:
        return false;
    L5:
        if (r6 != 7) goto L13;
        w r7 = K();
        if (r7 == null) goto L11;
        if (r7.d() == true) goto L13;
    L11:
        if (E() != 0) goto L13;
        return true;
    }

    @Override // i11.b
    public final boolean N(String r2) {
        p r0 = i11.a.b(this.a);
        if (r0 == null) goto L7;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L7;
        String r3 = r1.getIdString();
    L9:
        return Intrinsics.areEqual(r2, r3);
    L7:
        r3 = null;
        goto L9
    }

    public final Disposable Q(final Function1<? super r, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onChange");
        this.i.add(r2);
        int r0 = com.bytedance.revenue.platform.api.core.rx.h.a;
        return com.bytedance.revenue.platform.api.core.rx.h.a(new AnchorLinkUserCenterV2$registerMetaDataListener$1(this, r2));
    }

    public final Disposable R(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onChange");
        return m(new AnchorLinkUserCenterV2$registerOnlineListChangeObserverUnit$1(r2));
    }

    @Override // i11.b
    public final void clear(boolean r12) {
        M(this, "CLEAR and callback");
        if (r12 == false) goto L5;
        int r13 = 1;
    L6:
        ListUpdateType r2 = ListUpdateType.CLEAR;
        com.bytedance.android.live.revlink.impl.utils.a r1 = B();
        if (r1 == null) goto L10;
        String r3 = r1.b();
        if (r3 == null) goto L10;
    L11:
        int r4 = r13;
        this.o = new b(r2, "clear", r4, r3, null, 0, 112);
        ((CopyOnWriteArrayList) this.b).clear();
        ((CopyOnWriteArrayList) this.a).clear();
        this.e.clear();
        Iterator<i11.c.b> r5 = this.h.iterator();
    L13:
        if (r5.hasNext() == false) goto L18;
        i11.c.b r6 = r5.next();
        if (r13 == 1) goto L16;
        r6.a(r13, this.b);
        r6.d(r13, this.a);
        r6.b(r13, this.e);
        goto L13
    L16:
        r6.h(r13, this.a);
        r6.i(r13);
        goto L13
    L18:
        return;
    L10:
        r3 = "";
        goto L11
    L5:
        r13 = 7;
        goto L6
    }

    @Override // i11.b
    public final void e(i11.d r7) {
        Intrinsics.checkNotNullParameter(r7, "user");
        Iterator<i11.d> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        i11.d r1 = r0.next();
        if (o.a(r7.a) == null) goto L11;
        if (Intrinsics.areEqual(o.a(r1.a), o.a(r7.a)) == false) goto L11;
        return;
    L11:
        if (r7.a.getIdString() == null) goto L4;
        if (Intrinsics.areEqual(r1.a.getIdString(), r7.a.getIdString()) == false) goto L4;
        return;
    L15:
        this.c.add(r7);
        StringBuilder r2 = new StringBuilder("scene=");
        r2.append(F());
        r2.append(" addInvitee ");
        r2.append(r7.a.getIdString());
        r2.append(' ');
        CopyOnWriteArrayList<i11.d> r8 = this.c;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<i11.d> r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        r3.add(r9.next().a.getIdString());
        goto L17
    L19:
        r2.append(r3);
        jy0.b.d("ttlive_anchor_link_users_v2", r2.toString());
        Iterator<i11.c.b> r10 = this.h.iterator();
    L21:
        if (r10.hasNext() == false) goto L27;
        i11.c.b r4 = r10.next();
        int r5 = F();
        CopyOnWriteArrayList<i11.d> r6 = this.c;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<i11.d> r13 = r6.iterator();
    L24:
        if (r13.hasNext() == false) goto L26;
        r12.add(r13.next().a);
        goto L24
    L26:
        r4.c(r5, r12);
        goto L21
    }

    @Override // i11.b
    public final void f(boolean r10) {
        M(this, "CLEAR List");
        if (r10 == false) goto L5;
        int r3 = 1;
    L6:
        ListUpdateType r1 = ListUpdateType.CLEAR;
        com.bytedance.android.live.revlink.impl.utils.a r0 = B();
        if (r0 == null) goto L10;
        String r2 = r0.b();
        if (r2 == null) goto L10;
    L11:
        this.o = new b(r1, "clearList", r3, r2, null, 0, 112);
        this.e.clear();
        this.d.clear();
        ((CopyOnWriteArrayList) this.a).clear();
        this.c.clear();
        return;
    L10:
        r2 = "";
        goto L11
    L5:
        r3 = 7;
        goto L6
    }

    @Override // i11.c
    public final void i(i11.c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.h.add(r2);
    }

    @Override // i11.c
    public final void l(i11.c.b r2) {
        this.h.remove(r2);
    }

    @Override // i11.c
    public final Disposable m(Function2<? super List<? extends p>, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onChange");
        final e r0 = new e(r2);
        i(r0);
        int r3 = com.bytedance.revenue.platform.api.core.rx.h.a;
        return com.bytedance.revenue.platform.api.core.rx.h.a(new AnchorLinkUserCenterV2$registerOnlineListChangeObserver$1(this, r0));
    }

    @Override // i11.b
    public final void o(Function1 r17) {
        Intrinsics.checkNotNullParameter("enter_room_backup", "reqSrc");
        if (this.m == false) goto L5;
    L7:
        i11.f r1 = null;
    L8:
        this.j = r1;
        i97.a r2 = i97.a.a;
        long r12 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r3 = this.s;
        if (r3 == null) goto L11;
        r31.a r4 = r3.getLinkNetwork();
    L12:
        if (r4 == null) goto L33;
        long r5 = E();
        long r9 = 4;
        boolean r7 = !this.m;
        IRoomBase r6 = H();
        if (r6 == null) goto L16;
        long r14 = IRoomKtKt.getId(r6);
    L17:
        IRoom r8 = H();
        if (r8 == null) goto L22;
        IBaseUser r10 = r8.getOwnerKt();
        if (r10 == null) goto L22;
        String r13 = r10.getIdString();
    L23:
        Observable r15 = r4.O(r5, r9, 7, r7, "enter_room_backup", r14, r13);
        if (r15 == null) goto L34;
        int r16 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r18 = r15.subscribeOn(Schedulers.io());
        if (r18 == null) goto L35;
        Observable r19 = r18.observeOn(AndroidSchedulers.mainThread());
        if (r19 == null) goto L36;
        Disposable r20 = r19.subscribe(new com.bytedance.android.live.revlink.impl.plantform.e(this, r12, r17), new com.bytedance.android.live.revlink.impl.plantform.f(this, r12));
        if (r20 == null) goto L37;
        this.g.add(r20);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L22:
        r13 = null;
        goto L23
    L16:
        r14 = 0;
        goto L17
    L33:
        return;
    L11:
        r4 = null;
        goto L12
    L5:
        if (Intrinsics.areEqual("enter_room_backup", "enter_room_preload") == false) goto L7;
        r1 = new i11.f(null, true, 5);
        goto L8
    }

    @Override // i11.b
    public final void q(IBaseUser r7) {
        Intrinsics.checkNotNullParameter(r7, "user");
        Iterator<IBaseUser> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        IBaseUser r1 = r0.next();
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        String r3 = r7.getCastSecUid();
        boolean r4 = false;
        if (r3 == null) goto L16;
        if (r3.length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 != true) goto L16;
        String r6 = o.a(r1);
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        if (Intrinsics.areEqual(r6, r7.getCastSecUid()) == false) goto L16;
        return;
    L10:
        r5 = false;
    L16:
        if (r7.getIdString().length() <= 0) goto L18;
        r4 = true;
    L18:
        if (r4 == false) goto L4;
        if (Intrinsics.areEqual(r1.getIdString(), r7.getIdString()) == false) goto L4;
        return;
    L22:
        this.d.add(r7);
        Iterator<i11.c.b> r8 = this.h.iterator();
    L24:
        if (r8.hasNext() == false) goto L28;
        i11.c.b r2 = r8.next();
        if (r2 == null) goto L24;
        r2.g();
        goto L24
    }

    @Override // i11.b
    public final void r(IBaseUser r10) {
        Intrinsics.checkNotNullParameter(r10, "user");
        Iterator<i11.d> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        i11.d r1 = r0.next();
        if (Intrinsics.areEqual(r10.getIdString(), r1.a.getIdString()) == false) goto L4;
        this.c.remove(r1);
        StringBuilder r2 = new StringBuilder("scene=");
        r2.append(F());
        r2.append(" removeInvitee ");
        r2.append(r10.getIdString());
        r2.append(' ');
        CopyOnWriteArrayList<i11.d> r3 = this.c;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<i11.d> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        r7.add(r4.next().a.getIdString());
        goto L9
    L11:
        r2.append(r7);
        jy0.b.d("ttlive_anchor_link_users_v2", r2.toString());
    L12:
        StringBuilder r5 = new StringBuilder("scene=");
        r5.append(F());
        r5.append(" removeInvitee ");
        r5.append(r10.getIdString());
        r5.append(' ');
        CopyOnWriteArrayList<i11.d> r12 = this.c;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<i11.d> r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        r6.add(r13.next().a.getIdString());
        goto L14
    L16:
        r5.append(r6);
        jy0.b.d("ttlive_anchor_link_users_v2", r5.toString());
        Iterator<i11.c.b> r14 = this.h.iterator();
    L18:
        if (r14.hasNext() == false) goto L24;
        i11.c.b r8 = r14.next();
        int r9 = F();
        CopyOnWriteArrayList<i11.d> r15 = this.c;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<i11.d> r17 = r15.iterator();
    L21:
        if (r17.hasNext() == false) goto L23;
        r16.add(r17.next().a);
        goto L21
    L23:
        r8.c(r9, r16);
        goto L18
    }

    @Override // i11.b
    public final void t(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        this.d.remove(r2);
        Iterator<i11.c.b> r3 = this.h.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        i11.c.b r0 = r3.next();
        if (r0 == null) goto L4;
        r0.g();
        goto L4
    }

    @Override // i11.b
    public final void u(String r3) {
        this.p = r3;
        Iterator<i11.c.b> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().e(r3);
        goto L4
    }

    @Override // i11.b
    public final p v(String r7) {
        Iterator r0 = ((CopyOnWriteArrayList) this.a).iterator();
    L3:
        boolean r2 = true;
        String r4 = null;
        if (r0.hasNext() == false) goto L28;
        p r1 = (p) r0.next();
        if (Intrinsics.areEqual(r7, r1.getInteractId()) == true) goto L7;
        if (q.b(r1) == null) goto L3;
        if (r7 != null) goto L12;
    L15:
        if (r2 == true) goto L3;
        j r3 = q.b(r1);
        if (r3 == null) goto L19;
        String r5 = r3.getMainLinkMicId();
    L21:
        if (Intrinsics.areEqual(r7, r5) == true) goto L27;
        j r6 = q.b(r1);
        if (r6 == null) goto L26;
        r4 = r6.getBackupLinkMicId();
    L26:
        if (Intrinsics.areEqual(r7, r4) == false) goto L3;
    L27:
        return r1;
    L19:
        r5 = null;
        goto L21
    L12:
        if (r7.length() == 0) goto L15;
        r2 = false;
        goto L15
    L7:
        return r1;
    L28:
        Iterator r8 = ((CopyOnWriteArrayList) this.b).iterator();
    L30:
        if (r8.hasNext() == false) goto L62;
        p r9 = (p) r8.next();
        if (Intrinsics.areEqual(r7, r9.getInteractId()) == true) goto L33;
        if (q.b(r9) == null) goto L30;
        if (r7 != null) goto L38;
    L41:
        boolean r10 = true;
    L42:
        if (r10 == true) goto L30;
        j r12 = q.b(r9);
        if (r12 == null) goto L46;
        String r13 = r12.getMainLinkMicId();
    L48:
        if (Intrinsics.areEqual(r7, r13) == true) goto L55;
        j r14 = q.b(r9);
        if (r14 == null) goto L52;
        String r15 = r14.getBackupLinkMicId();
    L54:
        if (Intrinsics.areEqual(r7, r15) == false) goto L30;
    L52:
        r15 = null;
    L55:
        jy0.b.c("ttlive_anchor_link_users_v2", "getLinkUserByInteractId from waitingList " + r9.toSimpleString(), null, 4);
        v r16 = J();
        if (r16 == null) goto L61;
        String r17 = r9.toSimpleString();
        Intrinsics.checkNotNullParameter(r17, "linkUserInfo");
        LinkedHashMap r18 = new LinkedHashMap();
        if (r7 != null) goto L60;
        r7 = "null";
    L60:
        r18.put("link_mic_id", r7);
        r18.put("link_user", r17);
        r16.b(r18);
        r16.f(r18);
        r16.H("get_link_user_from_waiting_list_link_mic_id", r18);
    L61:
        return r9;
    L46:
        r13 = null;
        goto L48
    L38:
        if (r7.length() == 0) goto L41;
        r10 = false;
        goto L42
    L33:
        return r9;
    L62:
        return null;
    }

    @Override // i11.b
    public final void x(r r3) {
        Iterator<T> r0 = this.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) r0.next()).invoke(r3);
        goto L4
    }

    @Override // i11.b
    public final void y(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        e(new i11.d(r3, null));
    }

    public static void M(AnchorLinkUserCenterV2 r6, String r7) {
        r6.getClass();
        StringBuilder r0 = new StringBuilder();
        r0.append(r7);
        r0.append("");
        r0.append(" current:");
        com.bytedance.android.live.revlink.impl.global.c r1 = r6.s;
        if (r1 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.utils.f r2 = r1.uc();
    L6:
        if (r2 == null) goto L22;
        StringBuilder r3 = new StringBuilder("local_channel_id=");
        com.bytedance.android.live.revlink.impl.global.c r4 = r2.a;
        if (r4 == null) goto L10;
        LinkCrossRoomDataHolder r5 = r4.getLinkCrossRoomDataHolder();
    L11:
        if (r5 == null) goto L13;
        Long r8 = Long.valueOf(r5.c());
    L14:
        r3.append(r8);
        r3.append(",linkType=");
        com.bytedance.android.live.revlink.impl.global.c r9 = r2.a;
        if (r9 == null) goto L17;
        com.bytedance.android.live.revlink.impl.utils.a r10 = r9.B8();
    L18:
        if (r10 == null) goto L20;
        String r12 = r10.b();
    L21:
        r3.append(r12);
        String r13 = r3.toString();
    L23:
        r0.append(r13);
        r0.append(' ');
        r0.append("");
        r0.append(" last:");
        r0.append(r6.o);
        jy0.b.f("ttlive_anchor_link_users_v2", r0.toString(), null, 4);
        return;
    L20:
        r12 = null;
        goto L21
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L10:
        r5 = null;
        goto L11
    L22:
        r13 = null;
        goto L23
    L5:
        r2 = null;
        goto L6
    }

    @Override // i11.c
    public final void b(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqSrc");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.s;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.g r1 = r0.getAnchorConnectUtils();
    L6:
        if (r1 == null) goto L10;
        int r2 = 1;
        if (r1.v1() != true) goto L10;
    L11:
        h(r2, r3, r4);
        return;
    L10:
        r2 = 7;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // i11.c
    public final p getGuestInfo(String r7, String r8) {
        Iterator r0 = ((CopyOnWriteArrayList) this.a).iterator();
    L3:
        boolean r2 = false;
        String r3 = null;
        if (r0.hasNext() == false) goto L21;
        p r1 = (p) r0.next();
        if (r8 != null) goto L8;
    L14:
        if (r1 == null) goto L19;
        IBaseUser r4 = r1.getUser();
        if (r4 == null) goto L19;
        r3 = r4.getIdString();
    L19:
        if (Intrinsics.areEqual(r7, r3) == false) goto L3;
        return r1;
    L8:
        if (r8.length() <= 0) goto L10;
        r2 = true;
    L10:
        if (r2 != true) goto L14;
        if (Intrinsics.areEqual(r8, r1.getInteractId()) == false) goto L14;
        return r1;
    L21:
        Iterator r5 = ((CopyOnWriteArrayList) this.b).iterator();
    L23:
        if (r5.hasNext() == false) goto L42;
        p r6 = (p) r5.next();
        if (r8 != null) goto L27;
    L34:
        if (r6 == null) goto L38;
        IBaseUser r9 = r6.getUser();
        if (r9 == null) goto L38;
        String r10 = r9.getIdString();
    L40:
        if (Intrinsics.areEqual(r7, r10) == false) goto L23;
        return r6;
    L38:
        r10 = null;
        goto L40
    L27:
        if (r8.length() <= 0) goto L29;
        boolean r12 = true;
    L30:
        if (r12 != true) goto L34;
        if (Intrinsics.areEqual(r8, r6.getInteractId()) == false) goto L34;
        return r6;
    L29:
        r12 = false;
        goto L30
    L42:
        Map<String, p> r13 = this.f.snapshot();
        if (r13 == null) goto L48;
        List r14 = new ArrayList(r13.size());
        Iterator<Map.Entry<String, p>> r15 = r13.entrySet().iterator();
    L46:
        if (r15.hasNext() == false) goto L49;
        r14.add(r15.next().getValue());
    L49:
        Iterator r16 = r14.iterator();
    L51:
        if (r16.hasNext() == false) goto L70;
        p r17 = (p) r16.next();
        if (r8 != null) goto L55;
    L62:
        if (r17 == null) goto L66;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L66;
        String r19 = r18.getIdString();
    L68:
        if (Intrinsics.areEqual(r7, r19) == false) goto L51;
        return r17;
    L66:
        r19 = null;
        goto L68
    L55:
        if (r8.length() <= 0) goto L57;
        boolean r20 = true;
    L58:
        if (r20 != true) goto L62;
        if (Intrinsics.areEqual(r8, r17.getInteractId()) == false) goto L62;
        return r17;
    L57:
        r20 = false;
        goto L58
    L70:
        return null;
    L48:
        r14 = CollectionsKt.emptyList();
        goto L49
    }

    @Override // i11.b
    public final void h(int r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "reqSrc");
        k(r8, r9, r10, 0);
    }

    @Override // i11.b
    public final void p(List<? extends p> r13, String r14, Long r15) {
        Intrinsics.checkNotNullParameter(r14, "from");
        if (r13 != null) goto L6;
        return;
    L6:
        if (r15 != null) goto L8;
    L19:
        S(r13, 7, r14, null);
        return;
    L8:
        if (r15.longValue() == 0) goto L19;
        if (A(r15, r13, null, r14) == true) goto L13;
        jy0.b.f("ttlive_anchor_link_users_v2", "intercept refresh with version=" + r15 + " from=" + r14 + ' ' + this.o, null, 4);
        return;
    L13:
        ListUpdateType r3 = ListUpdateType.REFRESH_WITH_VERSION;
        com.bytedance.android.live.revlink.impl.utils.a r2 = B();
        if (r2 == null) goto L17;
        String r4 = r2.b();
        if (r4 == null) goto L17;
    L18:
        this.o = new b(r3, r14, 7, r4, null, r15.longValue(), 80);
        S(r13, 7, r14, null);
        return;
    L17:
        r4 = "";
        goto L18
    }

    public AnchorLinkUserCenterV2(ld.a r10, com.bytedance.android.livesdk.revenue.service.room.c r12, com.bytedance.android.live.revlink.impl.global.c r13, yz0.f r14) {
        this.q = r10;
        this.r = r12;
        this.s = r13;
        this.t = r14;
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.e = new ArrayList();
        this.f = new LruCache(15);
        this.g = new CompositeDisposable();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.l = new CompositeDisposable();
        if (r12 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r15 = r12.getRoomContext();
        if (r15 == null) goto L7;
        boolean r16 = r15.getCommonIsAnchor();
    L8:
        this.m = r16;
        this.n = CollectionsKt.listOf(new Integer[]{7, 1, 2});
        ListUpdateType r1 = ListUpdateType.NONE;
        com.bytedance.android.live.revlink.impl.utils.a r17 = B();
        if (r17 == null) goto L12;
        String r18 = r17.b();
        if (r18 == null) goto L12;
    L13:
        this.o = new b(r1, null, 0, r18, null, 0, 118);
        return;
    L12:
        r18 = "";
    L7:
        r16 = false;
        goto L8
    }

    public final boolean A(Long r9, List<? extends p> r10, i6 r12, String r13) {
        if (this.m == false) goto L41;
        if (r9 == null) goto L41;
        if (r9.longValue() == 0) goto L41;
        if (this.o.getType().isVersionMsgV2() == false) goto L41;
        if (this.o.f <= r9.longValue()) goto L41;
        StringBuilder r0 = new StringBuilder();
        r0.append(this.o.getType());
        r0.append('_');
        r0.append(((CopyOnWriteArrayList) this.a).size());
        r0.append("->");
        r0.append(r13);
        r0.append('_');
        if (r10 == null) goto L15;
        Integer r2 = Integer.valueOf(r10.size());
    L16:
        r0.append(r2);
        String r1 = r0.toString();
        String r14 = this.o.f + "->" + r9;
        if (r10 != null) goto L19;
    L22:
        boolean r15 = true;
    L23:
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r3 = D();
        if (r3 == null) goto L29;
        String r4 = i11.a.c(this.a);
        String r5 = this.o.toString();
        Intrinsics.checkNotNullParameter(r14, "versionInfo");
        Intrinsics.checkNotNullParameter(r1, "listSizeInfo");
        Intrinsics.checkNotNullParameter(r4, "localOnlineListInfo");
        Intrinsics.checkNotNullParameter(r5, "refreshInfo");
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("version_info", r14);
        r6.put("list_size_info", r1);
        r6.put("error_msg", r1);
        r6.put("intercept_msg", Boolean.valueOf(r15));
        r6.put("local_onlineList", r4);
        r6.put("refresh_info", r5);
        if (r12 == null) goto L28;
        r6.put("msg_id", String.valueOf(qj.a(r12)));
        Intrinsics.checkNotNullParameter(r12, "$this$sceneExt");
        r6.put("msg_scene", Long.valueOf(r12.getScene()));
        Intrinsics.checkNotNullParameter(r12, "$this$typeExt");
        r6.put("msg_type", Long.valueOf(r12.getType2()));
    L28:
        r3.c("anchor_link_list_version_rollback", r6);
    L29:
        AnchorLinkOptUtils r16 = C();
        if (r16 == null) goto L41;
        if (r16.c() == true) goto L34;
    L36:
        boolean r17 = false;
    L37:
        if (r17 != true) goto L41;
        if (r15 == false) goto L41;
        jy0.b.c("ttlive_anchor_link_users_v2", "not consume old version list " + r1, null, 4);
        return false;
    L34:
        if (r16.b().W1() == false) goto L36;
        r17 = true;
        goto L37
    L19:
        if (r10.size() != ((CopyOnWriteArrayList) this.a).size()) goto L22;
        r15 = false;
        goto L23
    L15:
        r2 = null;
    L41:
        return true;
    }

    public final void S(List<? extends p> r17, int r18, String r19, i6 r20) {
        ArrayList r0 = new ArrayList(this.a);
        ((CopyOnWriteArrayList) this.a).clear();
        if (r17 == null) goto L5;
        ((CopyOnWriteArrayList) this.a).addAll(r17);
    L5:
        Iterator r5 = ((ArrayList) g.a(r0, this.a)).iterator();
    L6:
        boolean r6 = false;
        String r9 = null;
        if (r5.hasNext() == false) goto L36;
        p r1 = (p) r5.next();
        IBaseUser r10 = r1.getUser();
        if (r10 == null) goto L11;
        r9 = r10.getIdString();
    L11:
        if (r9 != null) goto L13;
    L14:
        r6 = true;
    L15:
        if (r6 == true) goto L6;
        String r7 = "";
        if (y41.f.N.b() == false) goto L29;
        LruCache<String, p> r8 = this.f;     // Catch: Throwable -> L27
        IBaseUser r12 = r1.getUser();     // Catch: Throwable -> L27
        if (r12 == null) goto L25;
        String r13 = r12.getIdString();     // Catch: Throwable -> L27
        if (r13 == null) goto L25;
        r7 = r13;
    L25:
        r8.put(r7, r1);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        jy0.b.b("ttlive_anchor_link_users_v2", "AnchorLinkUserCenterV2 leaveUserCache put error", th);
        goto L6
    L29:
        LruCache<String, p> r14 = this.f;
        IBaseUser r15 = r1.getUser();
        if (r15 == null) goto L35;
        String r16 = r15.getIdString();
        if (r16 == null) goto L35;
        r7 = r16;
    L35:
        r14.put(r7, r1);
        goto L6
    L13:
        if (r9.length() != 0) goto L15;
    L36:
        Iterator<i11.c.b> r2 = this.h.iterator();
    L38:
        if (r2.hasNext() == false) goto L43;
        i11.c.b r22 = r2.next();
        if (r18 == 1) goto L41;
        r22.d(r18, this.a);
        goto L38
    L41:
        r22.h(r18, this.a);
        goto L38
    L43:
        List<p> r3 = this.b;
        ArrayList r23 = new ArrayList();
        Iterator r4 = ((CopyOnWriteArrayList) r3).iterator();
    L45:
        if (r4.hasNext() == false) goto L71;
        Object r110 = r4.next();
        p r111 = (p) r110;
        if (r17 == null) goto L64;
        Iterator<T> r112 = r17.iterator();
    L50:
        if (r112.hasNext() == false) goto L62;
        Object r113 = r112.next();
        IBaseUser r114 = ((p) r113).getUser();
        if (r114 == null) goto L54;
        String r115 = r114.getIdString();
    L55:
        IBaseUser r116 = r111.getUser();
        if (r116 == null) goto L58;
        String r117 = r116.getIdString();
    L60:
        if (Intrinsics.areEqual(r115, r117) == false) goto L50;
    L63:
        p r118 = (p) r113;
    L65:
        if (r118 == null) goto L67;
        boolean r119 = true;
    L68:
        if (r119 == false) goto L45;
        r23.add(r110);
        goto L45
    L67:
        r119 = false;
        goto L68
    L58:
        r117 = null;
        goto L60
    L54:
        r115 = null;
        goto L55
    L62:
        r113 = null;
        goto L63
    L64:
        r118 = null;
        goto L65
    L71:
        if ((!r23.isEmpty()) == false) goto L77;
        ((CopyOnWriteArrayList) this.b).removeAll(r23);
        Iterator<i11.c.b> r24 = this.h.iterator();
    L74:
        if (r24.hasNext() == false) goto L76;
        i11.c.b r25 = r24.next();
        int r120 = F();
        List<p> r121 = this.b;
        ((CopyOnWriteArrayList) r121).size();
        r25.a(r120, r121);
        goto L74
    L76:
        jy0.b.f("ttlive_anchor_link_users_v2", r19 + " ALREADY linkedUserInWaitingList: " + i11.a.c(r23), null, 4);
    L77:
        this.e.clear();
        this.e.addAll(this.a);
        this.e.addAll(this.b);
        jy0.b.f("ttlive_anchor_link_users_v2", "updateList " + r19 + " waiting: " + i11.a.c(this.b) + " online:" + i11.a.c(this.a), null, 4);
        v r26 = J();
        if (r26 == null) goto L92;
        List<p> r27 = this.a;
        Intrinsics.checkNotNullParameter(r19, "source");
        if (r26.k() == false) goto L92;
        if (r27 == null) goto L92;
        if (((CopyOnWriteArrayList) r27).isEmpty() == true) goto L92;
        if (i11.a.b(r27) != null) goto L92;
        LinkedHashMap r28 = new LinkedHashMap();
        r28.put("source", r19);
        r28.put("online_list", i11.a.c(r27));
        if (r20 == null) goto L91;
        r28.put("msg_id", String.valueOf(qj.a(r20)));
        Intrinsics.checkNotNullParameter(r20, "$this$linkerIdExt");
        r28.put("msg_linker_id", Long.valueOf(r20.getLinkerId()));
    L91:
        r26.H("miss_multi_anchor_organizer", r28);
    L92:
        Iterator<i11.c.b> r29 = this.h.iterator();
    L94:
        if (r29.hasNext() == false) goto L96;
        r29.next().b(r18, this.e);
        goto L94
    }

    @Override // i11.b
    public final void k(int r23, int r24, String r25, long r26) {
        Intrinsics.checkNotNullParameter(r25, "reqSrc");
        long r0 = 0;
        if (r26 == 0) goto L5;
        long r10 = r26;
    L6:
        jy0.b.f("ttlive_anchor_link_users_v2", "queryLinkList channelId:" + r10 + " status:" + r24 + " reqSrc:" + r25 + " scene=" + r23, null, 4);
        if (r10 != 0) goto L10;
        return;
    L10:
        if (this.m == false) goto L12;
    L14:
        i11.f r2 = null;
    L15:
        this.j = r2;
        i97.a r3 = i97.a.a;
        long r20 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r4 = this.s;
        if (r4 == null) goto L18;
        r31.a r5 = r4.getLinkNetwork();
    L19:
        if (r5 == null) goto L39;
        long r12 = r24;
        boolean r15 = !this.m;
        IRoomBase r6 = H();
        if (r6 == null) goto L23;
        r0 = IRoomKtKt.getId(r6);
    L23:
        long r17 = r0;
        IRoom r1 = H();
        if (r1 == null) goto L28;
        IBaseUser r7 = r1.getOwnerKt();
        if (r7 == null) goto L28;
        String r19 = r7.getIdString();
    L29:
        Observable r8 = r5.O(r10, r12, r23, r15, r25, r17, r19);
        if (r8 == null) goto L40;
        int r9 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r13 = r8.subscribeOn(Schedulers.io());
        if (r13 == null) goto L41;
        Observable r14 = r13.observeOn(AndroidSchedulers.mainThread());
        if (r14 == null) goto L42;
        Disposable r16 = r14.subscribe(new c(this, r25, r20, r24, r23), new d(this, r20, r25, r23, r24));
        if (r16 == null) goto L43;
        this.g.add(r16);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L28:
        r19 = null;
        goto L29
    L39:
        return;
    L18:
        r5 = null;
        goto L19
    L12:
        if (Intrinsics.areEqual(r25, "enter_room_preload") == false) goto L14;
        r2 = new i11.f(null, true, 5);
        goto L15
    L5:
        r10 = E();
        goto L6
    }

    public static /* synthetic */ void P(AnchorLinkUserCenterV2 r8, String r9, ExtraResponse r10, long r12, int r13, int r14) {
        r8.O(r9, r10, r12, r13, r14, false);
    }

    public final void O(String r38, ExtraResponse<r, Extra> r39, long r40, int r42, int r43, boolean r44) {
        Intrinsics.checkNotNullParameter(r38, "reqSrc");
        Intrinsics.checkNotNullParameter(r39, "it");
        i97.a r0 = i97.a.a;
        long r16 = System.currentTimeMillis();
        MultiEnterRoomTracer r1 = I();
        if (r1 == null) goto L5;
        r1.j = r40;
        jy0.b.f("MultiEnterRoomTracer", "linkListResponse source=" + r1.a, null, 4);
    L5:
        v r2 = J();
        String r6 = "log_id";
        if (r2 == null) goto L84;
        long r22 = E();
        r r3 = (r) r39.data;
        String r7 = this.o.toString();
        String r5 = r39.logId;
        Intrinsics.checkNotNullParameter(r38, "reqSrc");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("req_channel_id", Long.valueOf(r22));
        r4.put("req_from", r38);
        r4.put("log_id", String.valueOf(r5));
        if (r3 == null) goto L52;
        r4.put("list_version", Long.valueOf(r3.getVersion()));
        List r8 = r3.getLinkUsers();
        String r9 = "null";
        if (r8 == null) goto L13;
        String r10 = i11.a.d(r8);
        if (r10 == null) goto L13;
    L14:
        r4.put("list_data", r10);
        List r12 = r3.getLinkUsers();
        if (r12 == null) goto L27;
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L18:
        if (r14.hasNext() == false) goto L26;
        String r26 = r9;
        Object r15 = r14.next();
        Iterator r28 = r14;
        String r27 = r6;
        if (((p) r15).getStatus() != 2) goto L22;
        boolean r17 = true;
    L23:
        if (r17 == false) goto L25;
        r13.add(r15);
    L25:
        r9 = r26;
        r6 = r27;
        r14 = r28;
        goto L18
    L22:
        r17 = false;
        goto L23
    L26:
        String r29 = r9;
        String r210 = r6;
        Integer r18 = Integer.valueOf(r13.size());
    L28:
        r4.put("online_size", String.valueOf(r18));
        List r19 = r3.getLinkUsers();
        if (r19 == null) goto L41;
        ArrayList r20 = new ArrayList();
        Iterator r23 = r19.iterator();
    L32:
        if (r23.hasNext() == false) goto L40;
        Object r24 = r23.next();
        Iterator r211 = r23;
        if (((p) r24).getStatus() != 1) goto L36;
        boolean r25 = true;
    L37:
        if (r25 == false) goto L39;
        r20.add(r24);
    L39:
        r23 = r211;
        goto L32
    L36:
        r25 = false;
        goto L37
    L40:
        Integer r30 = Integer.valueOf(r20.size());
    L42:
        r4.put("waiting_size", String.valueOf(r30));
        c3 r32 = r3.getBattleStatsMeta();
        if (r32 == null) goto L46;
        String r33 = d3.a(r32);
        if (r33 == null) goto L46;
    L47:
        r4.put("battle_data", r33);
        List r34 = r3.getLinkUsers();
        if (r34 == null) goto L50;
        List r35 = CollectionsKt.toList(r34);
    L51:
        v.y(r4, r35);
    L53:
        if (r7 == null) goto L55;
        r4.put("last_refresh", r7);
    L55:
        r2.b(r4);
        if (r2.k() == false) goto L58;
        r2.D("query_list_success", r40, r4);
    L60:
        if (Intrinsics.areEqual(r38, "request_failed_retry") == false) goto L63;
        r2.D("retry_query_list_success", r40, r4);
    L65:
        if (r3 == null) goto L69;
        List r36 = r3.getLinkUsers();
        if (r36 == null) goto L69;
        int r37 = r36.size();
    L71:
        if (r37 >= 2) goto L74;
        r2.D("query_list_data_invalid", r40, r4);
    L74:
        if (r2.k() == false) goto L76;
    L80:
        v.h++;
        d31.f r45 = r2.s();
        if (r45 == null) goto L83;
        String r310 = r210;
        String r311 = "reqSrc";
        r45.e("linkmic/list", new d31.a(0, 0, 0, r43, r38, 0, 0, null, Long.valueOf(r22), null, null, 3559), r40);
    L85:
        com.bytedance.android.live.revlink.impl.global.c r46 = this.s;
        if (r46 == null) goto L88;
        MultiAnchorPkLaunchContext r47 = r46.Ib();
    L89:
        if (r47 == null) goto L97;
        r r48 = (r) r39.data;
        if (r48 == null) goto L95;
        s5 r49 = r48.getLinkStatsMeta();
        if (r49 == null) goto L95;
        e7 r50 = r49.getMultiPKModeInfo();
    L96:
        MultiAnchorPkLaunchContext.updateMultiPkModeInfo$default(r47, r50, null, "linkmicList", null, 8, null);
    L95:
        r50 = null;
    L97:
        r r52 = (r) r14.data;
        if (r52 == null) goto L234;
        List r53 = r52.getLinkUsers();
        if (r53 == null) goto L234;
        List<? extends p> r110 = CollectionsKt.toList(r53);
        if (r110 == null) goto L234;
        String r111 = r38;
        ExtraResponse r112 = r14;
        if (Intrinsics.areEqual(r111, "enter_room_preload") == false) goto L107;
        this.j = new i11.f((r) r112.data, false, 6);
    L107:
        v r54 = J();
        if (r54 == null) goto L120;
        String r55 = r112.logId;
        Intrinsics.checkNotNullParameter(r111, "source");
        Intrinsics.checkNotNullParameter(r55, "logID");
        if (r54.k() == false) goto L120;
        if (r110.isEmpty() == true) goto L120;
        if (i11.a.b(r110) != null) goto L120;
        boolean r56 = r54.f.contains(r111);
        LinkedHashMap r57 = new LinkedHashMap();
        r57.put("source", r111);
        r57.put("online_list", i11.a.c(r110));
        r57.put(r310, r55);
        i6 r58 = null;
        int r113 = 4;
        jy0.b.c("ttlive_anchor_link", "miss_multi_anchor_organizer : " + r57, null, 4);
        if (r56 == false) goto L122;
        r54.H("miss_multi_anchor_organizer", r57);
    L122:
        if (r42 == 1) goto L126;
        if (r42 == r113) goto L126;
    L143:
        if (L(r43) == false) goto L154;
        jy0.b.c("ttlive_anchor_link_users_v2", "intercept queryLinkList onlineUserList callback", r58, r113);
        ListUpdateType r59 = ListUpdateType.CLEAR;
        com.bytedance.android.live.revlink.impl.utils.a r60 = B();
        if (r60 == null) goto L150;
        String r62 = r60.b();
        if (r62 == null) goto L150;
        String r63 = r62;
    L151:
        this.o = new b(r59, "interceptListResp", r43, r63, null, 0, 112);
        ((CopyOnWriteArrayList) this.a).clear();
        return;
    L150:
        r63 = "";
        goto L151
    L154:
        if (r42 == 2) goto L159;
        if (r42 == r113) goto L159;
        int r64 = r43;
        i6 r65 = r58;
        int r66 = r42;
        int r67 = 4;
        boolean r68 = true;
        int r114 = 2;
    L215:
        if (r66 != r67) goto L235;
        this.e.clear();
        ArrayList<p> r69 = this.e;
        ArrayList r70 = new ArrayList();
        Iterator<T> r72 = r110.iterator();
    L218:
        if (r72.hasNext() == false) goto L228;
        Object r73 = r72.next();
        p r115 = (p) r73;
        if (r115.getStatus() != r114) goto L222;
    L225:
        boolean r116 = true;
    L226:
        if (r116 == false) goto L218;
        r70.add(r73);
        goto L218
    L222:
        if (r115.getStatus() == r68) goto L225;
        r116 = false;
        goto L226
    L228:
        r69.addAll(r70);
        Iterator<i11.c.b> r74 = this.h.iterator();
    L230:
        if (r74.hasNext() == false) goto L235;
        i11.c.b r75 = r74.next();
        if (r75 == null) goto L230;
        r75.b(r64, this.e);
    L235:
        com.bytedance.android.live.revlink.impl.global.c r76 = this.s;
        if (r76 == null) goto L238;
        i6 r77 = r76.Q1();
    L239:
        if (r77 == null) goto L256;
        com.bytedance.android.live.revlink.impl.global.c r78 = this.s;
        if (r78 == null) goto L243;
        i6 r79 = r78.Q1();
    L244:
        if (r79 == null) goto L246;
        r79.notifyPkContext((r) r112.data, r44);
    L246:
        r r80 = (r) r112.data;
        if (r80 == null) goto L256;
        z r82 = r80.getAudioPunishInfo();
        if (r82 == null) goto L256;
        com.bytedance.android.live.revlink.impl.global.c r83 = this.s;
        if (r83 == null) goto L253;
        i6 r84 = r83.Q1();
    L254:
        if (r84 == null) goto L256;
        r84.updateAudioPunishInfo(r82);
        goto L256
    L253:
        r84 = r65;
        goto L254
    L243:
        r79 = r65;
    L256:
        x((r) r112.data);
        com.bytedance.android.live.revlink.impl.global.c r85 = this.s;
        if (r85 == null) goto L259;
        i6 r86 = r85.ua();
    L260:
        if (r86 == null) goto L267;
        r r87 = (r) r112.data;
        if (r87 == null) goto L264;
        i6 r88 = r87.getLinkStatsMeta();
    L265:
        r86.updateLinkStatsMeta(r88);
        goto L267
    L264:
        r88 = r65;
    L267:
        if (y41.f.N.g() == false) goto L306;
        r r89 = (r) r112.data;
        if (r89 == null) goto L273;
        s5 r90 = r89.getLinkStatsMeta();
        if (r90 == null) goto L273;
        i6 r92 = r90.getUiConfig();
    L274:
        this.k = r92;
        ld.a r93 = this.q;
        if (r93 == null) goto L306;
        NextLiveData r94 = r93.Ed();
        if (r94 == null) goto L306;
        t6 r95 = this.k;
        if (r95 == null) goto L286;
        k r96 = r95.getRoomBgTopImage();
        if (r96 == null) goto L286;
        List r97 = r96.getUrls();
        if (r97 == null) goto L286;
        String r98 = (String) ListProtector.get(r97, 0);
        if (r98 == null) goto L286;
    L287:
        t6 r99 = this.k;
        if (r99 == null) goto L297;
        k r100 = r99.getRoomBgBottomImage();
        if (r100 == null) goto L297;
        List r101 = r100.getUrls();
        if (r101 == null) goto L297;
        String r102 = (String) ListProtector.get(r101, 0);
        if (r102 == null) goto L297;
    L298:
        t6 r117 = this.k;
        if (r117 == null) goto L303;
        k r118 = r117.getRoomBgTopImage();
        if (r118 == null) goto L303;
        boolean r119 = r118.isAnimated();
    L304:
        r94.setValue(new oq2.a(r98, r102, r119));
    L303:
        r119 = false;
    L297:
        r102 = d51.c.A0.j();
    L286:
        r98 = d51.c.A0.k();
    L273:
        r92 = r65;
    L306:
        MultiEnterRoomTracer r103 = I();
        if (r103 == null) goto L332;
        r r104 = (r) r112.data;
        if (r104 == null) goto L311;
        i6 r105 = r104.getBattleStatsMeta();
    L312:
        if (r105 == null) goto L314;
        boolean r106 = true;
    L315:
        boolean r107 = this.m;
        long r108 = t.a(r16);
        Intrinsics.checkNotNullParameter(r111, r311);
        jy0.b.f("MultiEnterRoomTracer", "linkListDone source=" + r103.a + ' ' + r111 + " multiLinkCreated=" + r103.h + " seiUpdateDone=" + r103.m + " responseDuration=" + r108, r65, 4);
        Object r109 = "multi_anchor_link_widget_create";
        if ((Intrinsics.areEqual(r111, r109) ^ r68) == true) goto L318;
    L321:
        if (r107 == false) goto L324;
    L334:
        if (Intrinsics.areEqual(r111, "show_link_list_dialog") == false) goto L339;
        Iterator<i11.c.b> r120 = this.h.iterator();
    L337:
        if (r120.hasNext() == false) goto L339;
        r120.next().f();
    L339:
        r r121 = (r) r112.data;
        if (r121 == null) goto L344;
        List r122 = r121.getLinkUsers();
        if (r122 == null) goto L344;
        int r123 = r122.size();
    L346:
        if (r123 < 2) goto L348;
        return;
    L348:
        if (this.m == false) goto L350;
        return;
    L350:
        if (Intrinsics.areEqual(r111, r109) == false) goto L352;
    L353:
        AnchorLinkOptUtils r124 = C();
        if (r124 != null) goto L356;
        return;
    L356:
        if (((Boolean) r124.c.getValue()).booleanValue() == true) goto L358;
    L360:
        boolean r125 = false;
    L361:
        if (r125 != r68) goto L413;
        b(r42, "response_invalid_retry");
        return;
    L413:
        return;
    L358:
        if (r124.b().j3() == false) goto L360;
        r125 = true;
        goto L361
    L352:
        if (Intrinsics.areEqual(r111, "enter_room_preload") == true) goto L353;
        return;
    L344:
        r123 = 0;
        goto L346
    L324:
        if (r103.i != 0) goto L334;
        i97.a r126 = i97.a.a;
        r103.i = System.currentTimeMillis();
        r103.k = r108;
        com.bytedance.android.live.revlink.impl.global.c r127 = r103.C;
        if (r127 == null) goto L328;
        MultiEnterRoomTracer r128 = r127.i7();
    L329:
        if (r128 == null) goto L331;
        r128.t = r106;
    L331:
        r103.g();
        goto L334
    L328:
        r128 = null;
        goto L329
    L318:
        if ((Intrinsics.areEqual(r111, "enter_room_preload") ^ r68) == false) goto L321;
        if ((Intrinsics.areEqual(r111, "request_failed_retry") ^ r68) == true) goto L334;
    L314:
        r106 = false;
        goto L315
    L311:
        r105 = r65;
        goto L312
    L332:
        r109 = "multi_anchor_link_widget_create";
        goto L334
    L259:
        r86 = r65;
        goto L260
    L238:
        r77 = r65;
    L159:
        if (y41.f.N.b() == true) goto L364;
        Iterator r129 = ((CopyOnWriteArrayList) this.a).iterator();
    L176:
        if (r129.hasNext() == false) goto L184;
        p r130 = (p) r129.next();
        LruCache<String, p> r131 = this.f;
        IBaseUser r132 = r130.getUser();
        if (r132 == null) goto L181;
        String r133 = r132.getIdString();
        if (r133 == null) goto L181;
    L182:
        r131.put(r133, r130);
    L181:
        r133 = "";
    L184:
        if (A(Long.valueOf(((r) r112.data).getVersion()), r110, r58, "LIST_API") == false) goto L213;
        ListUpdateType r134 = ListUpdateType.LIST_API;
        String r135 = r112.logId;
        if (r135 != null) goto L188;
        String r136 = "";
    L189:
        long r212 = ((r) r112.data).getVersion();
        com.bytedance.android.live.revlink.impl.utils.a r137 = B();
        if (r137 == null) goto L195;
        String r138 = r137.b();
        if (r138 == null) goto L195;
        String r213 = r138;
    L196:
        r114 = 2;
        this.o = new b(r134, r38, r43, r213, r136, r212, 64);
        ((CopyOnWriteArrayList) this.a).clear();
        ArrayList r139 = new ArrayList();
        Iterator<T> r140 = r110.iterator();
    L198:
        if (r140.hasNext() == false) goto L205;
        Object r141 = r140.next();
        if (((p) r141).getStatus() != 2) goto L202;
        boolean r142 = true;
    L203:
        if (r142 == false) goto L198;
        r139.add(r141);
        goto L198
    L202:
        r142 = false;
        goto L203
    L205:
        List r143 = CollectionsKt.toMutableList(r139);
        ((CopyOnWriteArrayList) this.a).addAll(r143);
        Iterator<i11.c.b> r144 = this.h.iterator();
    L207:
        if (r144.hasNext() == false) goto L212;
        i11.c.b r145 = r144.next();
        if (r43 == 1) goto L210;
        r145.d(r43, this.a);
        goto L207
    L210:
        r145.h(r43, this.a);
        goto L207
    L212:
        r64 = r43;
        r68 = true;
        r67 = 4;
        r65 = null;
        jy0.b.f("ttlive_anchor_link_users_v2", "updateList listApi waiting: " + i11.a.c(this.b) + " online:" + i11.a.c(this.a), null, 4);
    L214:
        r66 = r42;
    L195:
        r213 = "";
        goto L196
    L188:
        r136 = r135;
        goto L189
    L213:
        r64 = r43;
        r67 = 4;
        r68 = true;
        r114 = 2;
        r65 = r58;
        jy0.b.c("ttlive_anchor_link_users_v2", "intercept onlineList change since version rollback", r65, 4);
        goto L214
    L364:
        Iterator r146 = ((CopyOnWriteArrayList) this.a).iterator();     // Catch: Throwable -> L172
    L161:
        if (r146.hasNext() == false) goto L184;
        p r147 = (p) r146.next();     // Catch: Throwable -> L172
        LruCache<String, p> r148 = this.f;     // Catch: Throwable -> L172
        IBaseUser r214 = r147.getUser();     // Catch: Throwable -> L172
        if (r214 == null) goto L169;
        String r215 = r214.getIdString();     // Catch: Throwable -> L172
        if (r215 == null) goto L169;
        String r149 = r215;
    L170:
        r148.put(r149, r147);     // Catch: Throwable -> L172
    L169:
        r149 = "";
    L172:
        th = move-exception;
        jy0.b.b("ttlive_anchor_link_users_v2", "AnchorLinkUserCenterV2 leaveUserCache put error", th);
    L126:
        ((CopyOnWriteArrayList) this.b).clear();
        List<p> r150 = this.b;
        ArrayList r151 = new ArrayList();
        Iterator<T> r152 = r110.iterator();
    L128:
        if (r152.hasNext() == false) goto L135;
        Object r153 = r152.next();
        if (((p) r153).getStatus() != 1) goto L132;
        boolean r154 = true;
    L133:
        if (r154 == false) goto L128;
        r151.add(r153);
        goto L128
    L132:
        r154 = false;
        goto L133
    L135:
        ((CopyOnWriteArrayList) r150).addAll(r151);
        Iterator<i11.c.b> r155 = this.h.iterator();
    L137:
        if (r155.hasNext() == false) goto L143;
        i11.c.b r156 = r155.next();
        if (r43 == 1) goto L140;
        List<p> r157 = this.b;
        r110.size();
        r156.a(r43, r157);
        goto L137
    L140:
        r110.size();
        r156.i(r43);
    L120:
        r58 = null;
        r113 = 4;
    L234:
        r111 = r38;
        r112 = r14;
        r68 = true;
        r65 = null;
        goto L235
    L88:
        r47 = null;
    L83:
        r311 = "reqSrc";
        r310 = r210;
        goto L85
    L76:
        if (d51.c.A0.h() == false) goto L80;
        if ((v.h % ((long) 10)) == 0) goto L80;
    L69:
        r37 = 0;
        goto L71
    L63:
        if (Intrinsics.areEqual(r38, "show_in_link_invite_dialog") == false) goto L65;
        r2.D("link_invite_panel_query_list_success", r40, r4);
        goto L65
    L58:
        r2.f(r4);
        int r158 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link", "query_list_success duration=" + r40 + ' ' + r4, null);
        goto L60
    L50:
        r35 = null;
    L46:
        r33 = r29;
        goto L47
    L41:
        r30 = null;
        goto L42
    L27:
        r29 = "null";
        r210 = "log_id";
        r18 = null;
    L13:
        r10 = "null";
        goto L14
    L52:
        r210 = "log_id";
        goto L53
    L84:
        r310 = "log_id";
        r311 = "reqSrc";
        goto L85
    }
}
