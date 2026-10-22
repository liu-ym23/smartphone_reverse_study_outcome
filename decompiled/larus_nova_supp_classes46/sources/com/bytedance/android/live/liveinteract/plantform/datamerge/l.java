package com.bytedance.android.live.liveinteract.plantform.datamerge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkLastEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPaidViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSelfDisciplineEndViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.h1;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.kk;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class l extends com.bytedance.android.live.liveinteract.plantform.datamerge.a {
    public static final Integer o = null;
    public ih0.b j;
    public final HashMap<String, Disposable> k;
    public final IRoom l;
    public final boolean m;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ch0.i r4 = (ch0.i) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "seatExtraObjectObservable change, " + r4);
            this.a.u();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ l a;

        public c(l r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            wg0.a r3 = (wg0.a) r2;
            l r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ l a;

        public d(l r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ch0.l r3 = (ch0.l) r2;
            l r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ l a;

        public e(l r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ch0.c r3 = (ch0.c) r2;
            l r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ l a;

        public f(l r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            if ((!((List) r8).isEmpty()) == false) goto L18;
            int r9 = MultiSceneEnterRoomStatisticsUtils.u;
            l r10 = this.a;
            DataCenter r0 = r10.e;
            IRoom r11 = r10.l;
            long r1 = 0;
            if (r11 == null) goto L7;
            long r3 = r11.getId();
        L8:
            MultiSceneEnterRoomStatisticsUtils r12 = MultiSceneEnterRoomStatisticsUtils.a.a(r0, Long.valueOf(r3));
            if (r12 == null) goto L11;
            r12.c();
        L11:
            System.currentTimeMillis();
            l r13 = this.a;
            DataCenter r2 = r13.e;
            IRoom r14 = r13.l;
            if (r14 == null) goto L14;
            r1 = r14.getId();
        L14:
            MultiSceneEnterRoomStatisticsUtils r4 = MultiSceneEnterRoomStatisticsUtils.a.a(r2, Long.valueOf(r1));
            if (r4 == null) goto L19;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r4, "data_center_receive_guest_list", 0, 2, null);
            return;
        L19:
            return;
        L7:
            r3 = 0;
            goto L8
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ l a;

        public g(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "specialStubListObservable change, size: " + r4.size());
            this.a.u();
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ l a;

        public h(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "leavedPaidUserObservable change, size: " + r4.size());
            this.a.u();
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ l a;

        public i(l r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ch0.k r3 = (ch0.k) r2;
            l r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ l a;

        public j(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "isPaidLinkOnObservable change, " + r4);
            this.a.u();
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ l a;

        public k(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "isGuestBattleShowingObservable change, " + r4);
            this.a.u();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.datamerge.l$l, reason: collision with other inner class name */
    public static final class C0055l<T> implements Consumer {
        public final /* synthetic */ l a;

        public C0055l(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "isThemedCompetitionOnObservable change, " + r4);
            this.a.u();
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ l a;

        public m(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IVoiceLiveTheme r4 = (IVoiceLiveTheme) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "themeObservable change, " + r4);
            this.a.u();
            return;
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ l a;

        public n(l r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ch0.b r3 = (ch0.b) r2;
            l r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ l a;

        public o(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "linkedUserMergeDataListObservable change, size: " + r4.size() + ", it = " + this.a);
            this.a.u();
            return;
        }
    }

    static {
        o = (Integer) kk.a.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void b() {
        if (this.a == false) goto L6;
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.e, "WindowListHelper", "already attach, hasInited: " + this.a);
        return;
    L6:
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.e, "WindowListHelper", "call attach");
        int r2 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r3 = this.e;
        IRoom r4 = this.l;
        if (r4 == null) goto L9;
        long r5 = r4.getId();
    L10:
        MultiSceneEnterRoomStatisticsUtils r6 = MultiSceneEnterRoomStatisticsUtils.a.a(r3, Long.valueOf(r5));
        if (r6 == null) goto L13;
        r6.c();
    L13:
        System.currentTimeMillis();
        x();
        RxUtilKt.c(this.n.N0().subscribe(new f(this)), this.c);
        RxUtilKt.c(this.n.g().subscribe(new g(this)), this.c);
        RxUtilKt.c(this.n.u0().subscribe(new h(this)), this.c);
        RxUtilKt.c(this.n.e1().subscribe(new i(this)), this.c);
        RxUtilKt.c(this.n.F0().subscribe(new j(this)), this.c);
        RxUtilKt.c(this.n.H0().subscribe(new k(this)), this.c);
        RxUtilKt.c(this.n.f1().subscribe(new C0055l(this)), this.c);
        RxUtilKt.c(this.n.G0().subscribe(new m(this)), this.c);
        RxUtilKt.c(this.n.o1().subscribe(new n(this)), this.c);
        RxUtilKt.c(this.n.I0().subscribe(new b(this)), this.c);
        RxUtilKt.c(this.n.b().subscribe(new c(this)), this.c);
        RxUtilKt.c(this.n.w0().subscribe(new d(this)), this.c);
        RxUtilKt.c(this.n.x0().subscribe(new e(this)), this.c);
        u();
        this.a = true;
        this.j = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.e);
        return;
    L9:
        r5 = 0;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public void u() {
        int r1 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r2 = this.e;
        IRoom r3 = this.l;
        if (r3 == null) goto L5;
        long r5 = r3.getId();
    L6:
        MultiSceneEnterRoomStatisticsUtils r4 = MultiSceneEnterRoomStatisticsUtils.a.a(r2, Long.valueOf(r5));
        if (r4 == null) goto L9;
        r4.c();
    L9:
        System.currentTimeMillis();
        if (this.g.getUiLayout() != 2) goto L13;
        Integer r6 = 9;
    L16:
        ArrayList r7 = new ArrayList(r6.intValue());
        int r8 = r6.intValue();
        int r9 = 0;
    L17:
        if (r9 >= r8) goto L19;
        r7.add(g(r9));
        r9 = r9 + 1;
        goto L17
    L19:
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.e, null, 2).getRoom();
        if (r10 == null) goto L25;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L25;
        String r12 = r11.getOwnerUserIdString();
        if (r12 == null) goto L25;
    L26:
        List<ch0.e> r13 = (List) this.n.f().getValue();
        if (r13 != null) goto L29;
        r13 = new ArrayList();
    L29:
        i(r12, r7, r13, r6.intValue());
        int r14 = r7.size();
        int r15 = 0;
    L30:
        if (r15 >= r14) goto L32;
        ((tf0.e) ListProtector.get(r7, r15)).b = r15;
        r15 = r15 + 1;
        goto L30
    L32:
        IRoom r16 = this.d;
        if (r16 != null) goto L35;
    L36:
        int r17 = r6.intValue();
        if (j() == true) goto L39;
    L70:
        int r18 = 6;
        if (((Boolean) vm2.d.F6.getValue(null, vm2.d.a[393(0x189, float:5.51E-43)])).booleanValue() == false) goto L73;
    L81:
        Iterator r19 = r7.iterator();
    L83:
        if (r19.hasNext() == false) goto L99;
        Object r110 = r19.next();
        tf0.e r111 = (tf0.e) r110;
        if ((r111 instanceof MultiLinkGuestViewBinder.a) == true) goto L87;
        r111 = null;
    L87:
        MultiLinkGuestViewBinder.a r112 = (MultiLinkGuestViewBinder.a) r111;
        if (r112 == null) goto L96;
        ch0.e r113 = r112.k;
        if (r113 == null) goto L96;
        ILinkPlayerInfoBridge r114 = r113.a;
        if (r114 == null) goto L96;
        if (r114.isEnlarged() != true) goto L96;
        boolean r115 = true;
    L97:
        if (r115 == false) goto L83;
    L100:
        if (r110 == null) goto L102;
        boolean r20 = true;
    L103:
        if (r20 == true) goto L106;
    L126:
        int r21 = r6.intValue();
        IRoom r116 = this.d;
        if (r116 == null) goto L132;
        if (r116.isLiveTypeAudio() != true) goto L132;
    L166:
        ch0.k r22 = (ch0.k) this.n.e1().getValue();
        if (r22 == null) goto L175;
        ILinkPlayerInfoBridge r23 = r22.a;
        if (r23 == null) goto L175;
        if (r22.b == false) goto L175;
        if (r7.size() <= r23.getUserPosition()) goto L175;
        ListProtector.set(r7, r23.getUserPosition(), new MultiLinkSelfDisciplineEndViewBinder.a(r23, r23.getUserPosition()));
    L175:
        o(r12, r7);
        n(r12, r7);
        p(r7);
        ch0.l r24 = (ch0.l) this.n.w0().getValue();
        if (r24 != null) goto L178;
        r24 = new ch0.l(0, null);
    L178:
        m(r12, r7, r24);
        boolean r25 = Intrinsics.areEqual((Boolean) this.n.F0().getValue(), Boolean.TRUE);
        if (this.g.getUiLayout() != 2) goto L219;
        Iterator r26 = r7.iterator();
        boolean r27 = true;
    L182:
        if (r26.hasNext() == false) goto L202;
        tf0.e r28 = (tf0.e) r26.next();
        if ((r28 instanceof MultiLinkGuestViewBinder.a) == false) goto L182;
        IBaseUser r29 = ((MultiLinkGuestViewBinder.a) r28).k.a.getUser();
        if (r29 == null) goto L189;
        String r30 = r29.getIdString();
        if (r30 == null) goto L189;
    L190:
        com.bytedance.live.datacontext.m r117 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.e, null, 2).getRoom();
        if (r117 == null) goto L196;
        IRoom r118 = (IRoom) r117.getValue();
        if (r118 == null) goto L196;
        String r119 = r118.getOwnerUserIdString();
        if (r119 == null) goto L196;
    L198:
        if ((!Intrinsics.areEqual(r30, r119)) == false) goto L182;
        if (r2.a(r119) == false) goto L182;
        r27 = false;
    L196:
        r119 = "";
    L189:
        r30 = "";
        goto L190
    L202:
        boolean r31 = j();
        List r32 = (List) this.n.N0().getValue();
        if (r32 == null) goto L205;
        int r33 = r32.size();
    L206:
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a r34 = (com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a) this.n.p1().getValue();
        if (r34 == null) goto L209;
        int r35 = r34.c;
    L210:
        if (r31 == false) goto L213;
        if (r35 > r33) goto L217;
    L216:
        int r36 = 0;
    L218:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a.q(r7, r36);
    L217:
        r36 = 1;
        goto L218
    L213:
        if (r25 == true) goto L217;
        if (r27 == false) goto L216;
    L209:
        r35 = 0;
        goto L210
    L205:
        r33 = 0;
    L219:
        l(r7, r13, r6.intValue(), r12);
        A(r7);
        z(r7);
        B(r7);
        v((IVoiceLiveTheme) this.n.G0().getValue(), r7);
        if (this.m == true) goto L319;
        IRoom r37 = this.d;
        if (r37 == null) goto L319;
        if (r37.isLiveTypeAudio() == false) goto L319;
        IRoom r38 = this.d;
        if (r38 == null) goto L231;
        IRoomBasisData r39 = r38.getBasisRoomData();
        if (r39 == null) goto L231;
        Boolean r40 = r39.isCustomizeAudioRoom();
    L233:
        if (Intrinsics.areEqual(r40, Boolean.TRUE) == true) goto L319;
        if (this.g.getUiLayout() == 24) goto L319;
        if (this.g.getUiLayout() == 29) goto L319;
        IBaseUser r41 = jc1.k.n(IMiddlewareUserService.class).user().b();
        if (v.a(r41.getIdString()) == false) goto L319;
        if (r41.getSecret() == 1) goto L319;
        Iterator r42 = r7.iterator();
    L249:
        if (r42.hasNext() == false) goto L266;
        Object r43 = r42.next();
        tf0.e r44 = (tf0.e) r43;
        if ((r44 instanceof MultiLinkGuestViewBinder.a) == true) goto L253;
        r44 = null;
    L253:
        MultiLinkGuestViewBinder.a r45 = (MultiLinkGuestViewBinder.a) r44;
        if (r45 == null) goto L262;
        ch0.e r46 = r45.k;
        if (r46 == null) goto L262;
        ILinkPlayerInfoBridge r47 = r46.a;
        if (r47 == null) goto L262;
        IBaseUser r48 = r47.getUser();
        if (r48 == null) goto L262;
        String r49 = r48.getIdString();
    L264:
        if (Intrinsics.areEqual(r49, r41.getIdString()) == false) goto L249;
    L268:
        if (((tf0.e) r43) != null) goto L319;
        if (h1.d() == false) goto L276;
        if (li0.d.g(null) == false) goto L319;
    L276:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L294;
        MiddlewareRoomContext r50 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.e, 0, 2);
        if (r50 == null) goto L282;
        com.bytedance.live.datacontext.n r51 = r50.isRoomVisible();
        if (r51 == null) goto L282;
        Boolean r52 = (Boolean) r51.getValue();
    L284:
        if (Intrinsics.areEqual(r52, Boolean.FALSE) == false) goto L294;
        Lazy r53 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r54 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", this.l, false, 4, null);
        if (r54 == null) goto L294;
        ClientUIInfo r55 = r54.clientUIInfo;
        if (r55 == null) goto L294;
        List r56 = r55.getUiFeatureList();
        if (r56 == null) goto L294;
        if (r56.contains(4) != true) goto L294;
    L282:
        r52 = null;
    L294:
        Iterator r57 = r7.iterator();
    L296:
        if (r57.hasNext() == false) goto L309;
        Object r58 = r57.next();
        tf0.e r59 = (tf0.e) r58;
        if (this.g.getUiLayout() == 26) goto L300;
        boolean r60 = r59 instanceof MultiLinkNormalEmptyViewBinder.a;
    L307:
        if (r60 == false) goto L296;
    L311:
        if ((r58 instanceof MultiLinkNormalEmptyViewBinder.a) == true) goto L313;
        Object r61 = null;
    L314:
        MultiLinkNormalEmptyViewBinder.a r62 = (MultiLinkNormalEmptyViewBinder.a) r61;
        if (r62 == null) goto L319;
        if (r62.b() == 0) goto L319;
        ListProtector.set(r7, r7.indexOf(r62), new MultiLinkPreOnlineViewBinder.a(r41, ((Integer) ((ge1.a) hd0.c.f()).b).intValue(), r62.b(), r62.c()));
        goto L319
    L313:
        r61 = r58;
        goto L314
    L300:
        if ((r59 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L305;
        if (((MultiLinkNormalEmptyViewBinder.a) r59).b() == 1) goto L305;
        r60 = true;
    L305:
        r60 = false;
        goto L307
    L309:
        r58 = null;
    L262:
        r49 = null;
        goto L264
    L266:
        r43 = null;
    L231:
        r40 = null;
    L319:
        y(r7);
        ch0.c r63 = (ch0.c) this.n.x0().getValue();
        if (r63 == null) goto L328;
        Iterator r65 = r7.iterator();
    L324:
        if (r65.hasNext() == false) goto L328;
        tf0.e r66 = (tf0.e) r65.next();
        if ((r66 instanceof MultiLinkGuestViewBinder.a) == false) goto L324;
        ((MultiLinkGuestViewBinder.a) r66).p = r63;
    L328:
        System.currentTimeMillis();
        this.b.onNext(r7);
        return;
    L132:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L142;
        MiddlewareRoomContext r120 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.e, 0, 2);
        if (r120 == null) goto L138;
        com.bytedance.live.datacontext.n r121 = r120.isRoomVisible();
        if (r121 == null) goto L138;
        Boolean r122 = (Boolean) r121.getValue();
    L140:
        if (Intrinsics.areEqual(r122, Boolean.FALSE) == false) goto L142;
    L138:
        r122 = null;
    L142:
        List r123 = (List) this.n.u0().getValue();
        if (r123 != null) goto L145;
        r123 = new ArrayList();
    L145:
        ArrayList r124 = new ArrayList();
        Iterator r125 = r123.iterator();
    L147:
        if (r125.hasNext() == false) goto L165;
        ILinkPlayerInfoBridge r67 = (ILinkPlayerInfoBridge) r125.next();
        int r68 = r67.getUserPosition();
        if (r68 < 0) goto L163;
        if (r21 <= r68) goto L163;
        ListProtector.set(r7, r67.getUserPosition(), new MultiLinkPaidViewBinder.a(r67, r67.getUserPosition()));
        String r69 = r67.getInteractId();
        boolean r70 = r.a;
        if (r.j(Integer.valueOf(this.g.getUiLayout()), 0, r18) == false) goto L164;
        if (r69 == null) goto L164;
        Disposable r71 = this.k.get(r69);
        if (r71 != null) goto L160;
    L162:
        Disposable r72 = Observable.just(0).delay(3, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.plantform.datamerge.m(r69), com.bytedance.android.live.liveinteract.plantform.datamerge.n.a);
        RxUtilKt.c(r72, this.c);
        this.k.put(r69, r72);
        goto L164
    L160:
        if (r71.isDisposed() == true) goto L162;
    L164:
        r18 = 6;
    L163:
        r124.add(r67);
        goto L164
    L165:
        r123.removeAll(r124);
        goto L166
    L106:
        if (j() == true) goto L126;
        Iterator r73 = r7.iterator();
    L110:
        if (r73.hasNext() == false) goto L123;
        Object r126 = r73.next();
        if ((r126 instanceof MultiLinkGuestViewBinder.a) == true) goto L114;
        r126 = null;
    L114:
        MultiLinkGuestViewBinder.a r127 = (MultiLinkGuestViewBinder.a) r126;
        if (r127 == null) goto L110;
        ch0.e r128 = r127.k;
        if (r128 == null) goto L110;
        ILinkPlayerInfoBridge r129 = r128.a;
        if (r129 == null) goto L110;
        if (r129.isEnlarged() != true) goto L110;
        r73.remove();
    L124:
        if (r127 == null) goto L126;
        ListProtector.add(r7, 0, r127);
        goto L126
    L123:
        r127 = null;
        goto L124
    L102:
        r20 = false;
    L96:
        r115 = false;
        goto L97
    L99:
        r110 = null;
        goto L100
    L73:
        if (this.g.getUiLayout() == 3) goto L81;
        if (this.g.getUiLayout() == 6) goto L81;
        if (this.g.getUiLayout() == 11) goto L81;
        if (this.g.getUiLayout() == 12) goto L81;
    L39:
        if (aj0.b.c(this.g.getUiLayout()) == true) goto L70;
        ArrayList r130 = new ArrayList(r17);
        int r131 = 0;
    L41:
        if (r131 >= r17) goto L43;
        r130.add(g(r131));
        r131 = r131 + 1;
        goto L41
    L43:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a.t(r130, r13, r17);
        int r132 = r130.size();
        int r133 = 0;
    L44:
        if (r133 >= r132) goto L46;
        ((tf0.e) ListProtector.get(r130, r133)).b = r133;
        r133 = r133 + 1;
        goto L44
    L46:
        Iterator r134 = r130.iterator();
    L48:
        if (r134.hasNext() == false) goto L61;
        Object r135 = r134.next();
        if ((r135 instanceof MultiLinkGuestViewBinder.a) == true) goto L52;
        r135 = null;
    L52:
        MultiLinkGuestViewBinder.a r136 = (MultiLinkGuestViewBinder.a) r135;
        if (r136 == null) goto L48;
        ch0.e r137 = r136.k;
        if (r137 == null) goto L48;
        ILinkPlayerInfoBridge r138 = r137.a;
        if (r138 == null) goto L48;
        if (r138.isEnlarged() != true) goto L48;
        r134.remove();
    L62:
        if (r136 == null) goto L64;
        ListProtector.add(r130, 0, r136);
    L64:
        int r139 = r130.size();
        int r140 = 0;
    L65:
        if (r140 >= r139) goto L70;
        if (r7.size() <= r140) goto L69;
        ((tf0.e) ListProtector.get(r7, r140)).b = ((tf0.e) ListProtector.get(r130, r140)).b;
    L69:
        r140 = r140 + 1;
        goto L65
    L61:
        r136 = null;
        goto L62
    L35:
        if (r16.isLiveTypeAudio() == true) goto L70;
    L25:
        r12 = "";
        goto L26
    L13:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(Integer.valueOf(this.g.getUiLayout())) == false) goto L15;
        r6 = o;
        goto L16
    L15:
        r6 = Integer.valueOf(this.h.a);
        goto L16
    L5:
        r5 = 0;
        goto L6
    }

    public void x() {
        RxUtilKt.c(this.n.f().subscribe(new o(this)), this.c);
    }

    public final void A(List<tf0.e> r13) {
        Intrinsics.checkNotNullParameter(r13, "windowList");
        List r0 = (List) this.n.g().getValue();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L39;
        LinkmicPositionItem r2 = (LinkmicPositionItem) r1.next();
        Iterator<T> r3 = r13.iterator();
        int r4 = 0;
    L10:
        if (r3.hasNext() == false) goto L7;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        tf0.e r7 = (tf0.e) r5;
        if ((r7 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L34;
        if (aj0.b.c(this.g.getUiLayout()) == false) goto L19;
        int r8 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        int r9 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.e((int) r2.getPosition(), this.g.getUiLayout());
    L20:
        MultiLinkNormalEmptyViewBinder.a r10 = (MultiLinkNormalEmptyViewBinder.a) r7;
        if (r10.b() != r9) goto L38;
        int r11 = r2.getStatus();
        LinkmicPositionItem.LinkmicPositionStatus r12 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED;
        if (r11 != r12.ordinal()) goto L32;
        int r14 = r10.b();
        int r15 = r12.ordinal();
        LinkmicPositionItem r16 = com.bytedance.android.live.liveinteract.multianchor.model.h.a(r2);
        Integer r17 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r17 != null) goto L28;
    L30:
        boolean r18 = false;
    L31:
        ListProtector.set(r13, r4, new MultiLinkSpecialViewBinder.a(r14, r15, r16, r18));
        goto L38
    L28:
        if (2 != r17.intValue()) goto L30;
        r18 = true;
        goto L31
    L32:
        r10.l(com.bytedance.android.live.liveinteract.multianchor.model.h.a(r2));
    L38:
        r4 = r6;
        goto L10
    L19:
        r9 = (int) r2.getPosition();
        goto L20
    L34:
        if ((r7 instanceof MultiLinkGuestViewBinder.a) == false) goto L38;
        MultiLinkGuestViewBinder.a r19 = (MultiLinkGuestViewBinder.a) r7;
        if (r19.k.a.getUserPosition() != ((int) r2.getPosition())) goto L38;
        r19.l = com.bytedance.android.live.liveinteract.multianchor.model.h.a(r2);
        b0.a(r19.k.a, r2);
        goto L38
    }

    public final void B(List<tf0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "windowList");
        wg0.a r0 = (wg0.a) this.n.b().getValue();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        tf0.e r1 = (tf0.e) r5.next();
        if ((r1 instanceof MultiLinkGuestViewBinder.a) == false) goto L4;
        ((MultiLinkGuestViewBinder.a) r1).n = r0;
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final MultiLinkNormalEmptyViewBinder.a g(int r14) {
        Boolean r0 = (Boolean) this.n.F0().getValue();
        Boolean r1 = Boolean.TRUE;
        return new MultiLinkNormalEmptyViewBinder.a(r14, null, null, Intrinsics.areEqual(r0, r1), Intrinsics.areEqual((Boolean) this.n.H0().getValue(), r1), k(), false, false, Intrinsics.areEqual((Boolean) this.n.f1().getValue(), r1), 704);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final MultiLinkLastEmptyViewBinder.a h(int r11) {
        Boolean r0 = (Boolean) this.n.F0().getValue();
        Boolean r1 = Boolean.TRUE;
        return new MultiLinkLastEmptyViewBinder.a(r11, Intrinsics.areEqual(r0, r1), Intrinsics.areEqual((Boolean) this.n.H0().getValue(), r1), k(), false, Intrinsics.areEqual((Boolean) this.n.f1().getValue(), r1), 192);
    }

    public final void y(List<tf0.e> r9) {
        Intrinsics.checkNotNullParameter(r9, "windowList");
        ch0.i r0 = (ch0.i) this.n.I0().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<T> r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L44;
        tf0.e r1 = (tf0.e) r10.next();
        Iterator<T> r2 = r0.d.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        tf0.d r3 = (tf0.d) r2.next();
        r1.i.put(r3.a().name(), r3);
        goto L10
    L12:
        Iterator<T> r4 = r0.c.iterator();
    L14:
        if (r4.hasNext() == false) goto L19;
        tf0.d r5 = (tf0.d) r4.next();
        if (r5.b() != r1.b) goto L14;
        r1.i.put(r5.a().name(), r5);
        goto L14
    L19:
        if ((r1 instanceof MultiLinkGuestViewBinder.a) == false) goto L7;
        MultiLinkGuestViewBinder.a r6 = (MultiLinkGuestViewBinder.a) r1;
        IBaseUser r7 = r6.k.a.getUser();
        if (r7 == null) goto L34;
        String r8 = r7.getIdString();
        if (r8 == null) goto L34;
        ih0.b r11 = this.j;
        if (r11 == null) goto L27;
        Object r12 = r11.ql(r8);
    L29:
        if ((r12 instanceof tf0.d) == true) goto L31;
        r12 = null;
    L31:
        tf0.d r13 = (tf0.d) r12;
        if (r13 == null) goto L34;
        r1.i.put(r13.a().name(), r13);
        goto L34
    L27:
        r12 = null;
    L34:
        Iterator<T> r14 = r0.b.iterator();
    L36:
        if (r14.hasNext() == false) goto L7;
        tf0.d r15 = (tf0.d) r14.next();
        String r16 = r15.c();
        IBaseUser r17 = r6.k.a.getUser();
        if (r17 == null) goto L40;
        String r18 = r17.getIdString();
    L42:
        if (Intrinsics.areEqual(r16, r18) == false) goto L36;
        r1.i.put(r15.a().name(), r15);
        goto L36
    L40:
        r18 = null;
        goto L42
    }

    public final void z(List<tf0.e> r9) {
        Intrinsics.checkNotNullParameter(r9, "windowList");
        boolean r0 = Intrinsics.areEqual((Boolean) this.n.V0().getValue(), Boolean.TRUE);
        ch0.b r1 = (ch0.b) this.n.o1().getValue();
        if (r1 == null) goto L5;
        IBaseUser r2 = r1.a;
    L7:
        if (r2 == null) goto L9;
        boolean r3 = true;
    L10:
        Iterator<T> r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L54;
        tf0.e r5 = (tf0.e) r10.next();
        if (aj0.b.c(this.g.getUiLayout()) == false) goto L21;
        int r6 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.c(Integer.valueOf(r5.a), this.g.getUiLayout()) == true) goto L18;
    L29:
        boolean r7 = false;
    L31:
        if (r7 == false) goto L12;
        if ((r5 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L12;
        MultiLinkNormalEmptyViewBinder.a r8 = (MultiLinkNormalEmptyViewBinder.a) r5;
        r8.m(k());
        if (r3 == true) goto L36;
        if (r0 == false) goto L12;
        r8.k();
        this.n.E0(false);
        return;
    L36:
        ch0.b r11 = (ch0.b) this.n.o1().getValue();
        if (r11 == null) goto L39;
        ch0.b r4 = new ch0.b(r11.a, r11.b);
    L40:
        r8.j(r4);
        this.n.O0(new ch0.b(null, false));
        return;
    L39:
        r4 = null;
        goto L40
    L18:
        if ((r5 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L29;
    L28:
        r7 = true;
        goto L31
    L21:
        if (this.g.getUiLayout() == 26) goto L23;
    L30:
        r7 = r5 instanceof MultiLinkNormalEmptyViewBinder.a;
        goto L31
    L23:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout() != 26) goto L30;
        if ((r5 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L29;
        if (((MultiLinkNormalEmptyViewBinder.a) r5).b() == 1) goto L29;
    L54:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void v(IVoiceLiveTheme r3, List<tf0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "windowList");
        super.v(r3, r4);
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L19;
        tf0.e r6 = (tf0.e) r5.next();
        r6.h = this.d;
        r6.d = this.n.getShowFrom();
        r6.e = je0.d.f();
        Integer r0 = je0.d.h();
        if (r0 == null) goto L8;
        int r1 = r0.intValue();
    L9:
        r6.f = r1;
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r7 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r8 = r7.t();
        if (r8 == null) goto L17;
        List<Integer> r9 = r8.b;
        if (r9 == null) goto L17;
    L18:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r6.g = r9;
    L17:
        r9 = CollectionsKt.emptyList();
        goto L18
    L8:
        r1 = 0;
        goto L9
    }

    public l(IRoom r9, DataCenter r10, boolean r11, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r12, com.bytedance.android.live.liveinteract.plantform.datamerge.k r13, com.bytedance.android.live.liveinteract.plantform.datamerge.d r14) {
        Intrinsics.checkNotNullParameter(r12, "layoutConfig");
        Intrinsics.checkNotNullParameter(r13, "windowConfig");
        Intrinsics.checkNotNullParameter(r14, "linkUserDataMergeCenter");
        super(r9, r10, r11, r12, r13, 0);
        this.l = r9;
        this.m = r11;
        this.n = r14;
        this.k = new HashMap();
    }
}
