package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.utils.LiveEmptyObserverKt;
import com.bytedance.android.livesdk.gift.model.t2;
import com.bytedance.android.livesdk.gift.model.u2;
import com.bytedance.android.livesdk.gift.model.w0;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListChangedByChangeReceiver;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.message.model.w7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftReceiverRepoService implements com.bytedance.android.scope.o {
    public static final boolean q = false;
    public static boolean r;
    public final CompositeDisposable a;
    public final Map<Integer, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j> b;
    public final h c;
    public final g d;
    public final List<c0> e;
    public boolean f;
    public final d g;
    public boolean h;
    public final i12.e i;
    public final DataCenter j;
    public final yz0.g k;
    public final yz0.f l;
    public final GroupLiveReceiverService m;
    public final xc6.c n;
    public final xc6.e o;
    public final ILinkService p;

    public static final class a {
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r4;
            Intrinsics.checkNotNullParameter(r6, "$this$userPositionKt");
            Integer r7 = Integer.valueOf(r6.getUserPositionFlex());
            ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r5;
            Intrinsics.checkNotNullParameter(r8, "$this$userPositionKt");
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r8.getUserPositionFlex()));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r5;
            Intrinsics.checkNotNullParameter(r6, "$this$userPositionKt");
            Integer r7 = Integer.valueOf(r6.getUserPositionFlex());
            ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r4;
            Intrinsics.checkNotNullParameter(r8, "$this$userPositionKt");
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r8.getUserPositionFlex()));
        }
    }

    public static final class d implements dq2.b.a {
        public final /* synthetic */ GiftReceiverRepoService a;

        public d(GiftReceiverRepoService r1) {
            this.a = r1;
        }

        public final void a(List<? extends ILinkPlayerInfoBridge> r3) {
            GiftReceiverRepoService r0 = this.a;
            r0.getClass();
            r0.b0(GiftReceiverRepoService.i(r3), "changeListener");
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ GiftReceiverRepoService a;

        public e(GiftReceiverRepoService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            GiftReceiverRepoService.a(this.a, CollectionsKt.toList(((u2) ((ExtraResponse) r2).data).getGroupMemberList()));
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r4) {
            String r5 = ((Throwable) r4).getMessage();
            if (r5 != null) goto L5;
            r5 = BuildConfig.FLAVOR;
        L5:
            jy0.b.c("GiftReceiverRepoService", r5, null, 4);
        }
    }

    public static final class g implements p11.f {
        public final /* synthetic */ GiftReceiverRepoService a;

        public g(GiftReceiverRepoService r1) {
            this.a = r1;
        }

        public final void onOnlineListChanged(List r3) {
            StringBuilder r0 = new StringBuilder("MultiAnchorLink onOnlineListChanged ");
            if (r3 == null) goto L5;
            Integer r1 = Integer.valueOf(((CopyOnWriteArrayList) r3).size());
        L6:
            r0.append(r1);
            r0.append(' ');
            jy0.b.d("GiftReceiver", r0.toString());
            GiftReceiverRepoService r2 = this.a;
            r2.Y(r2.c(r3), 3);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ GiftReceiverRepoService a;

        public h(GiftReceiverRepoService r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            IBaseUser r4 = (IBaseUser) r3;
            jy0.b.d("GiftReceiver", "PkGuestUserObserver getListener " + r4);
            this.a.Y(this.a.S(r4), 2);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ GiftReceiverRepoService a;

        public i(GiftReceiverRepoService r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            List r7 = CollectionsKt.toList(((w7) r6).getGroupMemberList());
            GiftReceiverRepoService.a(this.a, r7);
            Intrinsics.checkNotNullParameter(r7, "members");
            com.bytedance.android.live.profit.fansclub.o r0 = yt0.c.c();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m r1 = r0.getFansGroupInfo();
            if (r1 == null) goto L9;
            com.bytedance.android.live.profit.fansclub.l r2 = (com.bytedance.android.live.profit.fansclub.l) r1.getValue();
            if (r2 == null) goto L9;
            String r3 = r2.b;
        L10:
            List r8 = r7;
            boolean r4 = false;
            if ((r8 instanceof Collection) == true) goto L13;
        L15:
            Iterator<T> r9 = r8.iterator();
        L17:
            if (r9.hasNext() == false) goto L25;
            IBaseUser r5 = ((t2) r9.next()).getUser();
            if (r5 == null) goto L21;
            String r10 = r5.getIdString();
        L23:
            if (StringsKt.equals$default(r3, r10, false, 2, null) == false) goto L17;
            r4 = true;
            goto L25
        L21:
            r10 = null;
        L25:
            if (r4 == true) goto L33;
            com.bytedance.android.live.profit.fansclub.o r11 = yt0.c.c();
            if (r11 == null) goto L34;
            r11.Gd(9);
            return;
        L34:
            return;
        L33:
            return;
        L13:
            if (r8.isEmpty() == false) goto L15;
        L9:
            r3 = null;
            goto L10
        }
    }

    public static final class j extends ca0.w {
        public j() {
        }

        public final void b(List<? extends w1> r2) {
            Intrinsics.checkNotNullParameter(r2, "giftPages");
            Intrinsics.checkNotNullParameter(r2, "giftPages");
            uz1.a r3 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
            if (r3 == null) goto L6;
            r3.a(new GiftListChangedByChangeReceiver());
            return;
        }
    }

    static {
        q = ((Boolean) com.bytedance.android.livesdk.gift.platform.core.f.f.getValue(null, com.bytedance.android.livesdk.gift.platform.core.f.a[4])).booleanValue();
    }

    public final void E() {
        List<? extends ILinkPlayerInfoBridge> r0 = v.b(this.i, this.j);
        int r1 = v.a(this.i, this.j);
        gq2.b r2 = Qc();
        r2.c();
        if (r2.d(r1, 4) == true) goto L5;
    L22:
        Y(d(r0), 1);
        Y(w(r0), 5);
        Y(c(this.p.getMultiAnchorService().j()), 3);
        Y(S(this.p.getPkService().C()), 2);
        dq2.b r3 = Yn();
        Disposable r4 = null;
        if (r3 == null) goto L25;
        List r5 = r3.L4();
    L26:
        b0(i(r5), "init");
        if (this.h == true) goto L44;
        this.h = true;
        i12.e r6 = this.i;
        final DataCenter r7 = this.j;
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        int r8 = com.bytedance.revenue.platform.api.core.rx.c.a;
        BehaviorSubject r9 = BehaviorSubject.create();
        final u r10 = new u(r9);
        r7.observe("data_online_changed_list", r10, true);
        b0 r11 = new b0(r9, new GiftReceiverRepoService_androidKt$observeDataOnlineChangedList$1(r7, r10));
        Observable<T> r13 = r11.a;
        if (r13 == 0) goto L36;
        int r14 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r15 = r13.subscribeOn(AndroidSchedulers.mainThread());
        if (r15 == null) goto L36;
        Disposable r16 = r15.subscribe(new l(this));
        if (r16 == null) goto L36;
        com.bytedance.revenue.platform.api.core.rx.f.a(r16, this.a);
    L36:
        i12.e r17 = this.i;
        final DataCenter r18 = this.j;
        Intrinsics.checkNotNullParameter(r17, "scope");
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        BehaviorSubject r19 = BehaviorSubject.create();
        final t r20 = new t(r19, r17, r18);
        r18.observe("data_link_state", r20, true);
        b0 r21 = new b0(r19, new GiftReceiverRepoService_androidKt$observeDataLinkState$1(r18, r20));
        Observable<T> r23 = r21.a;
        if (r23 == 0) goto L43;
        int r24 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r25 = r23.subscribeOn(AndroidSchedulers.mainThread());
        if (r25 == null) goto L43;
        Disposable r26 = r25.subscribe(new m(this));
        if (r26 == null) goto L43;
        com.bytedance.revenue.platform.api.core.rx.f.a(r26, this.a);
    L43:
        this.a.add(new n(r11, r21));
    L44:
        I();
        p11.h r27 = this.p.getPkService();
        r27.j(this.c);
        r27.l(this.c);
        cy0.e.a.getClass();
        cy0.j r28 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r29 = com.bytedance.android.scope.m.b(r28).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r29);
        dq2.w r30 = ((com.bytedance.live.kmp.core.c) r29).M1();
        if (r30 == null) goto L49;
        Observable r31 = r30.q();
        if (r31 == null) goto L49;
        r4 = r31.subscribe(new p(this));
    L49:
        if (r4 == null) goto L51;
        this.a.add(r4);
    L51:
        F();
        A("init");
        return;
    L25:
        r5 = null;
        goto L26
    L5:
        if (vh6.c.b(qr2.c.class) == null) goto L7;
        boolean r33 = true;
    L8:
        if (r33 == false) goto L22;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r0.iterator();
    L11:
        if (r35.hasNext() == false) goto L21;
        Object r36 = r35.next();
        ILinkPlayerInfoBridge r37 = (ILinkPlayerInfoBridge) r36;
        Intrinsics.checkNotNullParameter(r37, "$this$interactIdKt");
        String r38 = r37.getInteractId();
        qr2.c r39 = vh6.c.b(qr2.c.class);
        if (r39 != null) goto L15;
    L17:
        boolean r40 = false;
    L19:
        if ((!r40) == false) goto L11;
        r34.add(r36);
        goto L11
    L15:
        if (r39.pm(r38) != true) goto L17;
        r40 = true;
        goto L19
    L21:
        r0 = r34;
        goto L22
    L7:
        r33 = false;
        goto L8
    }

    public final void F() {
        if (this.k.getRoom() != null) goto L6;
        return;
    L6:
        if (x12.a.b(this.k.getRoom()) == false) goto L15;
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = this.k.getRoom().getIdStr();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r3 == null) goto L10;
        r2.put("room_id", r3);
    L10:
        Integer r4 = 1;
        String r5 = r4.toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r5 == null) goto L13;
        r2.put("scene", r5);
    L13:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        Observable r6 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/anchor/group_live/query_group_member_infos/", TypesJVMKt.getJavaType(Reflection.typeOf(u2.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c);
        int r7 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r8 = r6.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), f.a);
        this.a.add(r8);
        return;
    }

    public final void I() {
        p11.e r0 = this.p.getMultiAnchorService();
        r0.o(this.d);
        r0.l(this.d);
    }

    public final gq2.b Qc() {
        zc6.a r0 = zc6.a.a;
        i12.e r1 = this.i;
        Intrinsics.checkNotNullParameter(zc6.a.a, "$this$modeUtils");
        Intrinsics.checkNotNullParameter(r1, "scope");
        return vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
    }

    public final void U() {
        if (q == false) goto L5;
        boolean r0 = r;
    L6:
        if (r0 == false) goto L8;
        int r1 = com.bytedance.revenue.platform.api.core.rx.q.a;
        final Function0<Unit> r2 = new GiftReceiverRepoService$onReceiverListerChange$1(this);
        Single r3 = Single.fromCallable(new q(r2));
        int r4 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r3.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
    L8:
        Iterator r5 = ((ArrayList) this.e).iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ((c0) r5.next()).a();
        goto L10
    L12:
        return;
    L5:
        r0 = this.f;
        goto L6
    }

    public final dq2.b Yn() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r0);
        return ((com.bytedance.live.kmp.core.c) r0).Yn();
    }

    public final IBaseUser j() {
        IBaseUser r0 = this.k.getRoom().getOwnerKt();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return vh7.f.c(IBaseUser.class);
    }

    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j k() {
        List r0 = new ArrayList();
        Iterator r1 = ((LinkedHashMap) this.b).entrySet().iterator();
        Object r2 = null;
        List<t2> r3 = null;
        w0 r4 = null;
    L4:
        if (r1.hasNext() == false) goto L15;
        Map.Entry r5 = (Map.Entry) r1.next();
        if (q(((Number) r5.getKey()).intValue()) == false) goto L9;
        r0 = CollectionsKt.plus(r0, ((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) r5.getValue()).a);
    L9:
        if (((Number) r5.getKey()).intValue() != 4) goto L12;
        r4 = ((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) r5.getValue()).b;
    L12:
        if (((Number) r5.getKey()).intValue() != 7) goto L4;
        r3 = ((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) r5.getValue()).c;
        goto L4
    L15:
        if (this.m.i() == false) goto L80;
        GroupLiveReceiverService r6 = this.m;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "originList");
        IBaseUser r7 = r6.f();
        boolean r8 = true;
        if (r7 == null) goto L43;
        List r9 = CollectionsKt.toMutableList(r0);
        List r10 = r0;
        Iterator r11 = r10.iterator();
    L21:
        if (r11.hasNext() == false) goto L25;
        Object r13 = r11.next();
        if (Intrinsics.areEqual(((IBaseUser) r13).getIdString(), r6.d().getIdString()) == false) goto L21;
    L27:
        if (((IBaseUser) r13) != null) goto L29;
        IBaseUser r14 = r6.d();
        jy0.b.a(r6.c, "GroupLiveUserList doesn't contain anchor. NewGroupMemberList: " + r0);
        ListProtector.add(r9, 0, r14);
    L29:
        Iterator r15 = r10.iterator();
    L31:
        if (r15.hasNext() == false) goto L35;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((IBaseUser) r16).getIdString(), r7.getIdString()) == false) goto L31;
    L36:
        if (r16 == null) goto L38;
        boolean r17 = true;
    L39:
        r6.b = r17;
        if (r17 == true) goto L42;
        ListProtector.add(r9, 1, r7);
    L42:
        r0 = r9;
        goto L43
    L38:
        r17 = false;
        goto L39
    L35:
        r16 = null;
        goto L36
    L25:
        r13 = null;
    L43:
        if (r3 == null) goto L80;
        GroupLiveReceiverService r18 = this.m;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r3, "originList");
        IBaseUser r19 = r18.f();
        if (r19 == null) goto L80;
        List<t2> r20 = CollectionsKt.toMutableList(r3);
        List<t2> r21 = r3;
        Iterator<T> r110 = r21.iterator();
    L49:
        if (r110.hasNext() == false) goto L58;
        Object r111 = r110.next();
        IBaseUser r112 = ((t2) r111).getUser();
        if (r112 == null) goto L54;
        String r113 = r112.getIdString();
        if (r113 == null) goto L54;
    L56:
        if (Intrinsics.areEqual(r113, r18.d().getIdString()) == false) goto L49;
    L60:
        if (((t2) r111) != null) goto L62;
        t2 r114 = (t2) vh7.f.c(t2.class);
        jy0.b.a(r18.c, "NewGroupMemberList doesn't contain anchor. NewGroupMemberList: " + r3);
        r114.setUser(r18.d());
        ListProtector.add(r20, 0, r114);
    L62:
        Iterator<T> r23 = r21.iterator();
    L64:
        if (r23.hasNext() == false) goto L73;
        Object r24 = r23.next();
        IBaseUser r115 = ((t2) r24).getUser();
        if (r115 == null) goto L69;
        String r116 = r115.getIdString();
        if (r116 == null) goto L69;
    L71:
        if (Intrinsics.areEqual(r116, r19.getIdString()) == false) goto L64;
        r2 = r24;
    L69:
        r116 = BuildConfig.FLAVOR;
    L73:
        if (r2 != null) goto L76;
        r8 = false;
    L76:
        r18.b = r8;
        if (r8 == true) goto L79;
        t2 r25 = (t2) vh7.f.c(t2.class);
        r25.setUser(r19);
        ListProtector.add(r20, 0, r25);
    L79:
        r3 = r20;
    L54:
        r113 = BuildConfig.FLAVOR;
        goto L56
    L58:
        r111 = null;
    L80:
        HashSet r26 = new HashSet();
        ArrayList r27 = new ArrayList();
        Iterator r28 = r0.iterator();
    L82:
        if (r28.hasNext() == false) goto L87;
        Object r29 = r28.next();
        if (r26.add(((IBaseUser) r29).getIdString()) == false) goto L82;
        r27.add(r29);
        goto L82
    L87:
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(r27, r4, r3);
    }

    public final void onStart() {
        yz0.f r0 = this.l;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$GROUP_UPDATE_MESSAGE");
        com.bytedance.revenue.platform.api.core.rx.f.a(yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.W.getValue(), false, 6).subscribe(new i(this)), this.a);
        if (q == true) goto L5;
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.livesdk.gift.platform.core.utils.w.a("select_guest_list_page_life_cycle", new AnonymousClass2(this)), this.a);
    L5:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k.a r3 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k.f;
        r3.getClass();
        ((LinkedHashMap) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k.e).clear();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k.d = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k.c.getValue(r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k.a.a[0])).booleanValue();
    }

    public final void onStop() {
        this.a.clear();
        this.p.getPkService().j(this.c);
        this.p.getMultiAnchorService().o(this.d);
        dq2.b r0 = Yn();
        if (r0 == null) goto L6;
        r0.R4(this.g);
        return;
    }

    public final w0 s() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r0 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) ((LinkedHashMap) this.b).get(4);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final boolean f() {
        gq2.b r0 = Qc();
        int r1 = v.a(this.i, this.j);
        r0.a();
        boolean r2 = r0.d(r1, 512);
        jy0.b.d("GiftReceiverRepo", "checkIsNewViewLinkMode, " + r2 + ' ' + r1);
        return r2;
    }

    public final List<com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h> x() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r0 = k();
        List<t2> r1 = r0.c;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L16;
        List<IBaseUser> r3 = r0.a;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        r4.add(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h((IBaseUser) r5.next(), null));
        goto L13
    L15:
        return r4;
    L16:
        List<t2> r6 = r0.c;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L18:
        if (r8.hasNext() == false) goto L25;
        Object r9 = r8.next();
        if (((t2) r9).getUser() == null) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L18;
        r7.add(r9);
        goto L18
    L22:
        r10 = false;
        goto L23
    L25:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r13 = r7.iterator();
    L27:
        if (r13.hasNext() == false) goto L32;
        t2 r14 = (t2) r13.next();
        IBaseUser r15 = r14.getUser();
        if (r15 != null) goto L31;
        r15 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L31:
        r11.add(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h(r15, r14));
        goto L27
    L32:
        return r11;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }

    public static List i(List r2) {
        ArrayList r0 = new ArrayList();
        if (r2 == null) goto L10;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        IBaseUser r1 = com.bytedance.android.live.liveinteract.plantform.model.n.d((ILinkPlayerInfoBridge) r3.next());
        if (r1 == null) goto L6;
        r0.add(r1);
    L10:
        return r0;
    }

    public final void A(String r2) {
        jy0.b.d("GiftReceiverRepo", "initGiftUsersList ".concat(r2));
        dq2.b r3 = Yn();
        if (r3 == null) goto L6;
        r3.R4(this.g);
        r3.M4(this.g);
        return;
    }

    public final boolean J(String r6) {
        Intrinsics.checkNotNullParameter(r6, "receiverUserId");
        DataCenter r0 = this.j;
        Intrinsics.checkNotNullParameter(r0, "dataCenter");
        String r2 = null;
        List r1 = (List) r0.get("data_guest_link_changed_list", null);
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r4 = com.bytedance.android.scope.m.b(r3).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r4);
        IBaseUser r5 = ((com.bytedance.live.kmp.core.c) r4).b();
        if (r5 == null) goto L5;
        r2 = com.bytedance.android.live.base.model.user.m.a(r5);
    L5:
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.contains(r6) == true) goto L9;
        return false;
    L9:
        if (CollectionsKt.contains(r1, r2) != true) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean L(String r4) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        List<IBaseUser> r0 = k().a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(((IBaseUser) r2.next()).getIdString());
        goto L4
    L7:
        return r1.contains(r4);
    }

    public final ReceiverType R(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        if (h(8) == true) goto L30;
        if (x12.a.b(this.k.getRoom()) == true) goto L30;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.e() == false) goto L12;
        return ReceiverType.Anchor;
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.c.b(r2) == false) goto L16;
        return ReceiverType.Anchor;
    L16:
        if (K(r2, 4) == false) goto L20;
        return ReceiverType.OtherAnchor;
    L20:
        if (K(r2, 2) == false) goto L24;
        return ReceiverType.Guest;
    L24:
        if (K(r2, 1024) == false) goto L28;
        return ReceiverType.Audience;
    L28:
        return ReceiverType.Audience;
    L30:
        if (Intrinsics.areEqual(r2.getIdString(), j().getIdString()) == false) goto L34;
        return ReceiverType.Anchor;
    L34:
        return ReceiverType.GroupLive;
    }

    public final List<IBaseUser> S(IBaseUser r4) {
        if (r4 != null) goto L6;
        jy0.b.d("GiftReceiverRepo", "PkList is null");
        return new ArrayList();
    L6:
        IBaseUser r1 = this.k.getRoom().getOwnerKt();
        if (r1 == null) goto L9;
        ArrayList r2 = new ArrayList();
        r2.add(r1);
        r2.add(r4);
        jy0.b.d("GiftReceiverRepo", "PkList size = " + r2.size());
        return r2;
    L9:
        return new ArrayList();
    }

    public final List<IBaseUser> c(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r10) {
        if (r10 != null) goto L6;
        jy0.b.d("GiftReceiverRepo", "anchorList is null");
        return new ArrayList();
    L6:
        List r1 = this.p.getRevenueLinkDataHolder().b();
        ArrayList r2 = new ArrayList();
        Integer r3 = null;
        if (r1 == null) goto L25;
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L25;
        String r5 = (String) r4.next();
        Iterator<? extends com.bytedance.android.livesdk.link.model.bridge.k> r6 = r10.iterator();
    L13:
        if (r6.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.link.model.bridge.k r7 = r6.next();
        if (r7 == null) goto L17;
        String r8 = r7.getInteractId();
    L19:
        if (Intrinsics.areEqual(r5, r8) == false) goto L13;
        if (r7 == null) goto L23;
        IBaseUser r9 = r7.getUser();
        if (r9 == null) goto L23;
    L24:
        r2.add(r9);
    L23:
        r9 = vh7.f.c(IBaseUser.class);
        goto L24
    L17:
        r8 = null;
    L25:
        Iterator<? extends com.bytedance.android.livesdk.link.model.bridge.k> r11 = r10.iterator();
    L27:
        if (r11.hasNext() == false) goto L37;
        com.bytedance.android.livesdk.link.model.bridge.k r13 = r11.next();
        if (r13 == null) goto L32;
        IBaseUser r14 = r13.getUser();
        if (r14 == null) goto L32;
    L34:
        if (r2.contains(r14) == true) goto L27;
        r2.add(r14);
    L32:
        r14 = vh7.f.c(IBaseUser.class);
        goto L34
    L37:
        if (r2.size() != 4) goto L39;
        IBaseUser r15 = (IBaseUser) ListProtector.get(r2, 2);
        ListProtector.set(r2, 2, ListProtector.get(r2, 3));
        ListProtector.set(r2, 3, r15);
    L39:
        StringBuilder r16 = new StringBuilder("anchorList size = ");
        r16.append(r10.size());
        r16.append(", regionList size = ");
        if (r1 == null) goto L42;
        r3 = Integer.valueOf(r1.size());
    L42:
        r16.append(r3);
        r16.append(", userInfoList size = ");
        r16.append(r2.size());
        jy0.b.d("GiftReceiverRepo", r16.toString());
        return r2;
    }

    public final List<IBaseUser> d(List<? extends ILinkPlayerInfoBridge> r9) {
        gq2.b r0 = Qc();
        int r1 = v.a(this.i, this.j);
        r0.e();
        boolean r2 = r0.d(r1, 2);
        ArrayList r3 = new ArrayList();
        if (r2 == true) goto L5;
        Iterator r4 = CollectionsKt.sortedWith(r9, new b()).iterator();
    L24:
        if (r4.hasNext() == false) goto L30;
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) r4.next();
        Intrinsics.checkNotNullParameter(r5, "$this$isAIGuestKmp");
        if (com.bytedance.android.live.liveinteract.plantform.a.a(r5) == true) goto L24;
        Intrinsics.checkNotNullParameter(r5, "$this$userKt");
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L24;
        r3.add(r6);
    L30:
        List<IBaseUser> r7 = w(r9);
        jy0.b.d("GiftReceiverRepo", "linkMicList size = " + r9.size() + ", micHostList size = " + ((ArrayList) r7).size());
        return CollectionsKt.minus(r3, r7);
    L5:
        if (r9.size() > 1) goto L8;
        jy0.b.d("GiftReceiverRepo", "no one on LinkAudience, return empty list");
        return new ArrayList();
    L8:
        List r8 = CollectionsKt.sortedWith(r9, new c());
        ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) ListProtector.get(r8, r8.size() - 1);
        Intrinsics.checkNotNullParameter(r10, "$this$isAIGuestKmp");
        if (com.bytedance.android.live.liveinteract.plantform.a.a(r10) == true) goto L13;
        Intrinsics.checkNotNullParameter(r10, "$this$userKt");
        IBaseUser r11 = r10.getUser();
        if (r11 == null) goto L13;
        r3.add(r11);
    L13:
        Iterator r13 = r8.iterator();
    L15:
        if (r13.hasNext() == false) goto L21;
        ILinkPlayerInfoBridge r14 = (ILinkPlayerInfoBridge) r13.next();
        Intrinsics.checkNotNullParameter(r14, "$this$isAIGuestKmp");
        if (com.bytedance.android.live.liveinteract.plantform.a.a(r14) == true) goto L15;
        Intrinsics.checkNotNullParameter(r14, "$this$userKt");
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L15;
        r3.add(r15);
        goto L15
    L21:
        ListProtector.remove(r3, r3.size() - 1);
        goto L30
    }

    public final boolean h(int r1) {
        return !o(r1).a.isEmpty();
    }

    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j n(int r4) {
        Boolean r0 = Boolean.valueOf(q(r4));
        if (r0.booleanValue() == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L12;
        r0.booleanValue();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r5 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) ((LinkedHashMap) this.b).get(Integer.valueOf(r4));
        if (r5 == null) goto L10;
        return r5;
    L10:
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(new ArrayList(), null, null);
    L12:
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(new ArrayList(), null, null);
    }

    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j o(int r6) {
        if (r6 != 2) goto L5;
        List r7 = CollectionsKt.plus(CollectionsKt.plus(n(1).a, n(5).a), n(8).a);
        HashSet r0 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator r8 = r7.iterator();
    L27:
        if (r8.hasNext() == false) goto L32;
        Object r3 = r8.next();
        if (r0.add(((IBaseUser) r3).getIdString()) == false) goto L27;
        r1.add(r3);
        goto L27
    L32:
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(r1, null, null);
    L5:
        if (r6 == 4) goto L18;
        if (r6 == 8) goto L50;
        if (r6 != 1024) goto L48;
        List<IBaseUser> r9 = n(6).a;
        HashSet r2 = new HashSet();
        ArrayList r4 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L49;
        Object r5 = r10.next();
        if (r2.add(((IBaseUser) r5).getIdString()) == false) goto L12;
        r4.add(r5);
        goto L12
    L49:
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(r4, null, null);
    L48:
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(new ArrayList(), null, null);
    L50:
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(n(7).a, null, n(7).c);
    L18:
        List r11 = CollectionsKt.plus(n(2).a, n(3).a);
        HashSet r13 = new HashSet();
        ArrayList r14 = new ArrayList();
        Iterator r15 = r11.iterator();
    L20:
        if (r15.hasNext() == false) goto L51;
        Object r16 = r15.next();
        if (r13.add(((IBaseUser) r16).getIdString()) == false) goto L20;
        r14.add(r16);
        goto L20
    L51:
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(r14, null, null);
    }

    public final boolean q(int r4) {
        switch(r4) {
            case 1: goto L11;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L4;
            case 5: goto L6;
            case 6: goto L4;
            case 7: goto L13;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        boolean r5 = com.bytedance.android.livesdk.gift.platform.core.manager.s.a;
        return com.bytedance.android.livesdk.gift.platform.core.manager.s.a;
    L6:
        DataCenter r6 = this.j;
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Boolean r7 = (Boolean) r6.get("data_support_send_gift_to_official_channel_host", Boolean.TRUE);
        if (r7 != null) goto L17;
        return true;
    L17:
        return r7.booleanValue();
    L11:
        boolean r8 = com.bytedance.android.livesdk.gift.platform.core.manager.s.a;
        return com.bytedance.android.livesdk.gift.platform.core.manager.s.a;
    L13:
        return true;
    L18:
        return this.p.getMultiAnchorService().h();
    L19:
        return this.p.getPkService().h();
    }

    public final List<IBaseUser> w(List<? extends ILinkPlayerInfoBridge> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<? extends ILinkPlayerInfoBridge> r1 = r8.iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        ILinkPlayerInfoBridge r2 = r1.next();
        r0.add(j());
        IBaseUser r3 = com.bytedance.android.live.liveinteract.plantform.model.n.d(r2);
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
        if (r4 == null) goto L10;
        zc6.a r5 = zc6.a.a;
        i12.e r6 = this.i;
        Intrinsics.checkNotNullParameter(r5, "$this$isMicRoomHost");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r4, "uid");
        Boolean r7 = Boolean.valueOf(vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).isMicRoomHost(r4));
    L12:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L4;
        Intrinsics.checkNotNullParameter(r2, "$this$userKt");
        IBaseUser r9 = r2.getUser();
        if (r9 == null) goto L4;
        r0.add(r9);
    L10:
        r7 = null;
        goto L12
    L17:
        if (r8.size() > 1) goto L20;
        jy0.b.d("GiftReceiverRepo", "no one on LinkAudience, return empty list");
        return new ArrayList();
    L20:
        return r0;
    }

    public final List<com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h> y(IBaseUser r10) {
        Intrinsics.checkNotNullParameter(r10, "currentReceiver");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r0 = k();
        if (w.a() == false) goto L5;
        List<t2> r1 = r0.c;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        int r6 = -1;
        if (r2 == false) goto L30;
        List r3 = CollectionsKt.toMutableList(r0.a);
        Iterator r4 = r3.iterator();
        int r5 = 0;
    L17:
        if (r4.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((IBaseUser) r4.next()).getIdString(), r10.getIdString()) == true) goto L20;
        r5 = r5 + 1;
        goto L17
    L20:
        r6 = r5;
    L22:
        if (r6 < 0) goto L24;
        ListProtector.add(r3, 0, (IBaseUser) ListProtector.remove(r3, r6));
    L25:
        List r7 = r3;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L27:
        if (r8.hasNext() == false) goto L29;
        r11.add(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h((IBaseUser) r8.next(), null));
        goto L27
    L29:
        return r11;
    L24:
        ListProtector.add(r3, 0, r10);
        goto L25
    L30:
        List<t2> r9 = r0.c;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r9.iterator();
    L32:
        if (r14.hasNext() == false) goto L39;
        Object r15 = r14.next();
        if (((t2) r15).getUser() == null) goto L36;
        boolean r16 = true;
    L37:
        if (r16 == false) goto L32;
        r13.add(r15);
        goto L32
    L36:
        r16 = false;
        goto L37
    L39:
        List r17 = CollectionsKt.toMutableList(r13);
        Iterator r18 = r17.iterator();
        int r19 = 0;
    L41:
        if (r18.hasNext() == false) goto L50;
        IBaseUser r20 = ((t2) r18.next()).getUser();
        if (r20 == null) goto L45;
        String r21 = r20.getIdString();
    L47:
        if (Intrinsics.areEqual(r21, r10.getIdString()) == true) goto L48;
        r19 = r19 + 1;
        goto L41
    L48:
        r6 = r19;
        goto L50
    L45:
        r21 = null;
    L50:
        if (r6 < 0) goto L52;
        ListProtector.add(r17, 0, (t2) ListProtector.remove(r17, r6));
    L53:
        List r23 = r17;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r24 = r23.iterator();
    L55:
        if (r24.hasNext() == false) goto L60;
        t2 r25 = (t2) r24.next();
        IBaseUser r26 = r25.getUser();
        if (r26 != null) goto L59;
        r26 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L59:
        r110.add(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h(r26, r25));
        goto L55
    L60:
        return r110;
    L52:
        vh7.c r27 = vh7.f.c(t2.class);
        ((t2) r27).setUser(r10);
        Unit r111 = Unit.INSTANCE;
        ListProtector.add(r17, 0, r27);
        goto L53
    L9:
        if (r1.isEmpty() == true) goto L12;
        r2 = false;
        goto L13
    L5:
        return x();
    }

    public static final void a(GiftReceiverRepoService r3, List r4) {
        r3.getClass();
        ArrayList r0 = new ArrayList();
        Iterator r1 = r4.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        IBaseUser r2 = ((t2) r1.next()).getUser();
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r5 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(r0, null, r4);
        r3.b.put(7, r5);
        r3.U();
    }

    public final boolean K(IBaseUser r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "receiver");
        if (r5 == 2) goto L5;
    L7:
        Iterator<IBaseUser> r6 = o(r5).a.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r6.next().getIdString(), r4.getIdString()) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (J(r4.getIdString()) == false) goto L7;
        return true;
    }

    public final boolean N(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        if (r3 == 2) goto L5;
        Iterator<IBaseUser> r4 = o(r3).a.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r4.next().getIdString(), r2) == false) goto L8;
        return true;
    L13:
        return false;
    L5:
        return J(r2);
    }

    public final void X(IBaseUser r11, ReceiverType r13) {
        Intrinsics.checkNotNullParameter(r11, "user");
        Intrinsics.checkNotNullParameter(r13, "receiverType");
        IRoomBase r0 = this.k.getRoom();
        boolean r7 = this.k.isAnchor();
        j r3 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.i.v.getValue(null, com.bytedance.android.livesdk.gift.platform.business.i.a[20])).booleanValue() == false) goto L5;
        r3 = new j();
    L5:
        ReceiverType r1 = ReceiverType.OtherAnchor;
        String r4 = BuildConfig.FLAVOR;
        if (r13 != r1) goto L13;
        this.o.a(r0.getIdStr(), r11.getIdString(), 4, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.c.a(r11));
        xc6.c r14 = this.n;
        String r2 = r0.getIdStr();
        String r5 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.c.a(r11);
        if (r0.getOwnerKt() == null) goto L10;
        IBaseUser r6 = r0.getOwnerKt();
        Intrinsics.checkNotNull(r6);
        String r8 = com.bytedance.android.live.base.model.user.o.a(r6);
    L11:
        Intrinsics.checkNotNullParameter(r11, "$this$secUidExt");
        r14.x4(r3, r2, r5, 4, r7, r8, r11.getCastSecUid());
        return;
    L10:
        r8 = BuildConfig.FLAVOR;
        goto L11
    L13:
        if (r0.getOwnerKt() == null) goto L15;
        IBaseUser r9 = r0.getOwnerKt();
        Intrinsics.checkNotNull(r9);
        String r10 = com.bytedance.android.live.base.model.user.o.a(r9);
    L16:
        int r15 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.g.a(r13);
        if (r15 != 512) goto L19;
    L28:
        xc6.c r16 = this.n;
        String r17 = r0.getIdStr();
        String r18 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.c.a(r11);
        Intrinsics.checkNotNullParameter(r11, "$this$secUidExt");
        String r19 = r11.getCastSecUid();
        if (r19 != null) goto L31;
        String r20 = r10;
    L32:
        r16.x4(r3, r17, r18, r15, r7, r10, r20);
        return;
    L31:
        r20 = r19;
        goto L32
    L19:
        if (r15 == 1024) goto L28;
        xc6.e r110 = this.o;
        String r21 = r0.getIdStr();
        if (com.bytedance.android.livesdk.gift.platform.business.i.g() == false) goto L23;
        r4 = com.bytedance.android.live.base.model.user.m.a(r11);
    L27:
        r110.a(r21, r4, r15, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.c.a(r11));
        goto L28
    L23:
        String r23 = IRoomKtKt.getAnchorIdStr(r0);
        if (r23 == null) goto L27;
        r4 = r23;
        goto L27
    L15:
        r10 = BuildConfig.FLAVOR;
        goto L16
    }

    public final void Y(List<? extends IBaseUser> r3, int r4) {
        jy0.b.d("GiftReceiver", "transitionReceiverList " + r4 + ' ' + r3.size());
        this.b.put(Integer.valueOf(r4), new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j(r3, null, null));
        U();
    }

    public final void b0(List<? extends IBaseUser> r3, String r4) {
        jy0.b.d("GiftReceiverRepo", "updateGiftUsersList, " + r4 + ' ' + ((ArrayList) r3).size());
        if (f() == false) goto L6;
        Y(r3, 8);
        return;
    }

    public static IBaseUser g(GiftReceiverRepoService r9, String r10, String r11, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if (r9.f() == false) goto L63;
        boolean r14 = false;
        if (r10 != null) goto L13;
    L16:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
    L35:
        if (r11 != null) goto L37;
    L38:
        r14 = true;
    L39:
        if (r14 == false) goto L41;
        return null;
    L41:
        if ((!Intrinsics.areEqual(r11, r9.j().getIdString())) == false) goto L66;
        List<IBaseUser> r15 = r9.n(8).a;
        if ((!r15.isEmpty()) == false) goto L67;
        Iterator<T> r16 = r15.iterator();
    L46:
        if (r16.hasNext() == false) goto L50;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((IBaseUser) r17).getIdString(), r11) == false) goto L46;
    L51:
        IBaseUser r18 = (IBaseUser) r17;
        if (r18 != null) goto L54;
        return null;
    L54:
        if (com.bytedance.android.live.base.model.user.n.a(r18) > 0) goto L56;
        return null;
    L56:
        return r18;
    L50:
        r17 = null;
        goto L51
    L67:
        return null;
    L66:
        return null;
    L37:
        if (r11.length() != 0) goto L39;
    L20:
        if ((!Intrinsics.areEqual(r10, com.bytedance.android.live.base.model.user.o.a(r9.j()))) == false) goto L35;
        List<IBaseUser> r3 = r9.n(8).a;
        if ((!r3.isEmpty()) == false) goto L35;
        Iterator<T> r4 = r3.iterator();
    L25:
        if (r4.hasNext() == false) goto L29;
        Object r6 = r4.next();
        if (Intrinsics.areEqual(com.bytedance.android.live.base.model.user.o.a((IBaseUser) r6), r10) == false) goto L25;
    L30:
        IBaseUser r7 = (IBaseUser) r6;
        if (r7 == null) goto L35;
        if (com.bytedance.android.live.base.model.user.n.a(r7) <= 0) goto L35;
        return r7;
    L29:
        r6 = null;
        goto L30
    L13:
        if (r10.length() == 0) goto L16;
        r2 = false;
        goto L18
    L63:
        return null;
    }

    public GiftReceiverRepoService(i12.e r2, DataCenter r3, yz0.g r4, yz0.f r5, GroupLiveReceiverService r6, xc6.c r7, xc6.e r8, ILinkService r9) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        Intrinsics.checkNotNullParameter(r5, "roomMessageService");
        Intrinsics.checkNotNullParameter(r6, "groupLiveReceiverService");
        Intrinsics.checkNotNullParameter(r7, "giftListRemoteDataSource");
        Intrinsics.checkNotNullParameter(r8, "propListRemoteDataSource");
        Intrinsics.checkNotNullParameter(r9, "revlinkService");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.o = r8;
        this.p = r9;
        this.a = new CompositeDisposable();
        this.b = new LinkedHashMap();
        this.c = new h(this);
        this.d = new g(this);
        this.e = new ArrayList();
        this.g = new d(this);
    }
}
