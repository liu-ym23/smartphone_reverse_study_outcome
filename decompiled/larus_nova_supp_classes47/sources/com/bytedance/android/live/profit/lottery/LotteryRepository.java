package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.config.cf;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LotteryRepository implements com.bytedance.android.scope.o {
    public static final /* synthetic */ int s = 0;
    public final String a;
    public final CompositeDisposable b;
    public final PropertyOwner<sh6.b<Lottery>> c;
    public final PropertyOwner d;
    public final PropertyOwner<Boolean> e;
    public final PropertyOwner f;
    public final PropertyOwner<ParticipateStatus> g;
    public final PropertyOwner h;
    public final PropertyOwner<y2> i;
    public final PropertyOwner j;
    public final BehaviorSubject<e1> k;
    public final PublishSubject<ParticipateStatus> l;
    public Function1<? super Lottery, Boolean> m;
    public long n;
    public final LotteryContext o;
    public final yz0.l p;
    public final yz0.k q;
    public final com.bytedance.android.livesdk.revenue.service.message.g r;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LotteryRepository a;

        public b(LotteryRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            Lottery r7 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(this.a.d);
            ParticipateStatus r0 = null;
            if (r7 == null) goto L5;
            LotteryState r1 = r7.getState();
        L6:
            if (r1 == null) goto L19;
            boolean r2 = r1 instanceof LotteryState.d;
            if (r2 == false) goto L20;
            Intrinsics.checkNotNullParameter(r1, "$this$isRefreshState");
            if (r2 == false) goto L21;
            h1 r3 = ((LotteryState.d) r1).b;
            if (r3 == null) goto L15;
            r0 = r3.h;
        L15:
            if (r0 == ParticipateStatus.CHOOSEEND) goto L22;
            if (r7 == null) goto L23;
            r7.b(LotteryAction.c.a);
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
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

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LotteryRepository a;

        public d(LotteryRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            e1 r8 = (e1) r7;
            LotteryRepository r0 = this.a;
            if (r8 == null) goto L5;
            r0.k.onNext(r8);
        L6:
            mz0.n r1 = new mz0.n();
            Map<String, String> r2 = r1.a;
            Intrinsics.checkNotNullParameter(r2, "map");
            if (r8 == null) goto L9;
            long r3 = r8.a;
        L10:
            String r9 = String.valueOf(r3);
            Intrinsics.checkNotNullParameter("lottery_id", "key");
            Intrinsics.checkNotNullParameter(r9, "value");
            r2.put("lottery_id", r9);
            if (((ParticipateStatus) r0.g.a) != ParticipateStatus.PARTICIPATEINSUCCESS) goto L13;
            boolean r10 = true;
        L14:
            String r12 = String.valueOf(r10);
            Intrinsics.checkNotNullParameter("is_participate_success", "key");
            Intrinsics.checkNotNullParameter(r12, "value");
            r2.put("is_participate_success", r12);
            mz0.m r13 = new mz0.m();
            r13.b(LogCommon.ROOM);
            r13.b(LogCommon.PAGE_SOURCE_LOG);
            List<Object> r4 = r1.b;
            ArrayList r5 = (ArrayList) r4;
            r5.addAll(r13.a);
            cy0.e.a.getClass();
            cy0.j r14 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r15);
            ((mz0.i) ((f80.a) r15)).w3("lottery_draw_message", r1.a, r1.b);
            return;
        L13:
            r10 = false;
            goto L14
        L9:
            r3 = 0;
            goto L10
        L5:
            r0.getClass();
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LotteryRepository a;

        public e(LotteryRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            h1 r9 = (h1) r8;
            LotteryRepository r0 = this.a;
            Lottery r1 = (Lottery) com.bytedance.android.live.core.arch.mvvm.f.a(r0.d);
            if (r1 == null) goto L35;
            LotteryState r2 = r1.getState();
            if (r2 == null) goto L36;
            t r3 = com.bytedance.android.live.profit.lottery.l.a(r2);
            if (r3 == null) goto L37;
            long r4 = r3.a;
            if (r9 == null) goto L11;
            Long r5 = Long.valueOf(r9.a);
        L13:
            if (r4 != r5.longValue()) goto L38;
            LotteryState r6 = r1.getState();
            if ((r6 instanceof LotteryState.d) == false) goto L18;
            LotteryState.d r7 = (LotteryState.d) r6;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r7.b = r9;
        L18:
            String r10 = r9.c;
            if (r10 != null) goto L21;
            r10 = "";
        L21:
            String r12 = r9.d;
            if (r12 != null) goto L24;
            r12 = "";
        L24:
            String r13 = r9.e;
            if (r13 != null) goto L27;
            r13 = "";
        L27:
            String r14 = r9.g;
            if (r14 != null) goto L30;
            r14 = "";
        L30:
            ParticipateStatus r15 = r9.h;
            if (r15 != null) goto L33;
            r15 = ParticipateStatus.CHOOSEING;
        L33:
            r0.f(r1, r10, r12, r13, r14, r15);
            return;
        L38:
            return;
        L11:
            r5 = null;
            goto L13
        L37:
            return;
        L36:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LotteryRepository a;

        public f(LotteryRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            y2 r4 = (y2) r3;
            LotteryRepository r0 = this.a;
            if (r4 == null) goto L11;
            r0.i.a(r4);
            if (w2.b() == false) goto L13;
            LotteryContext r1 = r0.o;
            if (r1 == null) goto L14;
            com.bytedance.live.datacontext.k<Object> r2 = r1.getLotteryInfoSyncData();
            if (r2 == null) goto L15;
            r2.post(r4);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        L11:
            r0.getClass();
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LotteryRepository a;

        public g(LotteryRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            LotteryRepository r0 = this.a;
            Lottery r8 = (Lottery) sh6.c.b((sh6.b) r7);
            r0.getClass();
            if (r8 == null) goto L5;
            com.bytedance.android.live.core.utils.rxutils.f r1 = RxCompatKt.a(r8.b.map(d2.a).startWith(Observable.just(r8.getState())).doOnNext(new e2(r0, r8)));
            RxUtilKt.c(r1.filter(v1.a).take(1).subscribe(new y1(r0, r8)), r0.b);
            RxUtilKt.c(r1.ofType(LotteryState.g.class).take(1).subscribe(new b2(r0, r8)), r0.b);
            RxUtilKt.c(r1.ofType(LotteryState.a.class).take(1).subscribe(new c2(r0, r8)), r0.b);
            Disposable r9 = (Disposable) JavaCalls.callMethodOrThrow(r1.a, "connect", new Object[0]);
            return;
        L5:
            LinkedHashMap<String, String> r10 = LotteryTraceMonitor.a;
            LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_lottery_state_null, "onCurrentLotteryChanged lottery=null");
            int r12 = com.bytedance.android.live.revenue.common.v.a;
            com.bytedance.android.live.revenue.common.v.e("ttlive_lottery", "onCurrentLotteryChanged lottery=null");
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ LotteryRepository a;

        public h(LotteryRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            PropertyOwner<ParticipateStatus> r0 = this.a.g;
            r0.a((ParticipateStatus) r2);
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ LotteryRepository a;

        public i(LotteryRepository r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LotteryRepository.c(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final class j implements Consumer {
        public final /* synthetic */ Function1 a;

        public j(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ LotteryRepository a;

        public k(LotteryRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            this.a.e.a(r4);
            LotteryRepository r0 = this.a;
            boolean r5 = r4.booleanValue();
            Intrinsics.checkNotNullParameter(r0, "$this$monitorCheckLotteryPermissionSuccesss");
            JSONObject r1 = new JSONObject();
            d1.a(r0, r1);
            BaseMonitor.add(r1, "has_lottery_permission", String.valueOf(r5));
            d1.e("ttlive_lottery_checked_permission_status", r1);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ LotteryRepository a;

        public l(LotteryRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            LotteryRepository r0 = this.a;
            Intrinsics.checkNotNullParameter(r0, "$this$monitorCheckLotteryPermissionFail");
            Intrinsics.checkNotNullParameter(r4, "throwable");
            JSONObject r1 = new JSONObject();
            d1.a(r0, r1);
            d1.c("ttlive_lottery_checked_permission_status", r4, r1);
        }
    }

    static {
    }

    public final boolean g() {
        return this.q.isAnchor();
    }

    public final void onStart() {
        Observable r0 = this.o.getOnCleared().toObservable();
        this.d.takeUntil(r0).subscribe(new f2(this));
        this.f.takeUntil(r0).subscribe(new g2(this));
        this.h.takeUntil(r0).subscribe(new h2(this));
        ((LinkedHashMap) b1.a).clear();
        RxUtilKt.c(this.c.subscribe(new g(this)), this.b);
        LotteryIMDataSource r1 = new LotteryIMDataSource(this.p, this.b, this.r, this.q);
        RxUtilKt.c(r1.b.subscribe(new j(new LotteryRepository$onStart$2$1(this))), this.b);
        RxUtilKt.c(r1.d.subscribe(new j(new LotteryRepository$onStart$2$2(this))), this.b);
        RxUtilKt.c(r1.f.subscribe(new d(this)), this.b);
        RxUtilKt.c(r1.h.subscribe(new e(this)), this.b);
        RxUtilKt.c(r1.j.subscribe(new f(this)), this.b);
        RxUtilKt.c(this.l.subscribe(new h(this)), this.b);
        j();
        if (com.bytedance.android.live.revenue.common.l0.a("lottery") == false) goto L5;
        com.bytedance.android.livesdk.revenue.service.room.b.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class), this.q.getRoom().getRoomId(), com.bytedance.android.live.profit.lottery.f.class, new LotteryRepository$runWithBackendData$1(this), null, new LotteryRepository$runWithBackendData$2(this), null, this.b, 40);
        return;
    L5:
        i r2 = new i(this);
        if (((Boolean) cf.a.getValue()).booleanValue() == false) goto L8;
        com.bytedance.android.live.core.utils.i0.i(c50.b.b(this.q.getDataCenter()), r2);
        return;
    L8:
        r2.run();
    }

    public final void onStop() {
        this.b.dispose();
        ((LinkedHashMap) b1.a).clear();
    }

    public final void j() {
        if (g() == false) goto L12;
        String r0 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        v.c r1 = v.a;
        long r2 = this.q.getRoom().getId();
        Intrinsics.checkNotNullParameter(r0, "anchorId");
        com.bytedance.android.live.revenue.common.g r4 = new com.bytedance.android.live.revenue.common.g("ttlive_lottery", "checkLotteryPermission roomId=" + r2 + " anchorId=" + r0);
        r4.a("begin");
        int r5 = LotteryApi.a;
        Intrinsics.checkNotNullParameter(r0, "anchorId");
        tz0.b r3 = tz0.b.a;
        uz0.c r6 = new uz0.c();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "$this$beforeConfigureRequest");
        r6.a(qx0.a.a);
        Map<String, String> r7 = r6.b;
        Intrinsics.checkNotNullParameter(r7, "queriesMap");
        String r8 = Long.valueOf(r2).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r8 == null) goto L7;
        r7.put("room_id", r8);
    L7:
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");
        if (r0 == null) goto L10;
        r7.put("anchor_id", r0);
    L10:
        Intrinsics.checkNotNullParameter(r6, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.h(RxCompatKt.b(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/lottery/melon/lottery_config/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.lottery.model.c.class)), Extra.class, r6.d, r6.a, r6.b, r6.c), new com.bytedance.android.live.core.utils.rxutils.l(5, 3000, v.a)).map(z.a)).singleOrError().doOnEvent(new a0(r4)).onErrorReturnItem(Boolean.FALSE).subscribe(new k(this), new l(this)), this.b);
        return;
    }

    public static final void c(LotteryRepository r5) {
        r5.getClass();
        v.c r0 = v.a;
        RxUtilKt.c(v.a(r5.q.getRoom().getId(), true, LotteryApi.QueryFrom.ClientEnterRoom, 12).subscribe(new m1(r5), new n1(r5)), r5.b);
    }

    public final void h(Lottery r4) {
        x2 r0 = f3.a;
        LotteryState r1 = r4.getState();
        if (r1 == null) goto L5;
        t r2 = com.bytedance.android.live.profit.lottery.l.a(r1);
    L6:
        f3.a(r2);
        Function1<? super Lottery, Boolean> r3 = this.m;
        if (r3 != null) goto L9;
    L10:
        PropertyOwner<sh6.b<Lottery>> r5 = this.c;
        if ((r5.a instanceof sh6.a) == false) goto L14;
        r5.a(sh6.c.a(r4));
    L14:
        if (w2.a() == true) goto L16;
        return;
    L16:
        if (g() == true) goto L26;
        DataCenter r6 = this.q.getDataCenter();
        LotteryState r7 = r4.getState();
        if (r7 == null) goto L22;
        t r8 = com.bytedance.android.live.profit.lottery.l.a(r7);
        if (r8 == null) goto L22;
        long r9 = r8.e;
    L23:
        r6.put("data_lottery_interest_count", Long.valueOf(r9));
        return;
    L22:
        r9 = 0;
        goto L23
    L26:
        return;
    L9:
        if (((Boolean) r3.invoke(r4)).booleanValue() == true) goto L14;
    L5:
        r2 = null;
        goto L6
    }

    public static final void a(LotteryRepository r7, t r8) {
        Boolean r0 = (Boolean) r7.q.getDataCenter().get("click_lottery_from_preview", Boolean.FALSE);
        Long r1 = (Long) r7.q.getDataCenter().get("preview_lottery_id", -1L);
        ALogger.i(r7.a, "checkLotteryFromPreview ------ fromPreview is " + r0);
        ALogger.i(r7.a, "checkLotteryFromPreview ------ previewLotteryId is " + r1);
    L18:
        ALogger.e(r7.a, "CAST ERROR: live_click_lottery_from_preview is " + r0);
        ALogger.e(r7.a, "CAST ERROR: live_preview_lottery_id is " + r1);
        return;
    L4:
        if (r0.booleanValue() == false) goto L22;
        if (r1 != null) goto L8;
    L9:
        long r2 = r8.a;     // Catch: Exception -> L18
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.longValue() == r2) goto L15;
        return;
    L15:
        if (r8.b != 1) goto L26;
        ALogger.i(r7.a, "post(ILotteryContext.lotteryFromPreview)");     // Catch: Exception -> L18
        com.bytedance.live.datacontext.k<Integer> r9 = r7.o.getOnIconClick();     // Catch: Exception -> L18
        com.bytedance.android.live.profit.lottery.i.B0.getClass();     // Catch: Exception -> L18
        r9.post(1);     // Catch: Exception -> L18
        return;
    L26:
        return;
    L8:
        if (r1.longValue() != (-1)) goto L9;
        return;
    }

    public final void d(Lottery r12, p0 r13) {
        Long r2 = null;
        if (g() == false) goto L45;
        x2 r0 = f3.a;
        boolean r1 = false;
        if (r12 == null) goto L11;
        LotteryState r3 = r12.getState();
        if (r3 == null) goto L11;
        t r4 = com.bytedance.android.live.profit.lottery.l.a(r3);
        if (r4 == null) goto L11;
        int r5 = r4.d;
    L13:
        if (f3.b(String.valueOf(r5)) == false) goto L45;
        x2 r6 = f3.a;
        if (r6 == null) goto L19;
        u0 r7 = r6.iconConfig;
        if (r7 == null) goto L19;
        Boolean r8 = r7.anchorIconDismiss;
    L21:
        if (Intrinsics.areEqual(r8, Boolean.FALSE) == false) goto L45;
        PropertyOwner r9 = this.j;
        if (r9 == null) goto L30;
        Object r10 = r9.a;
        if (r10 == null) goto L30;
        if (((y2) r10).e <= 0) goto L30;
        r1 = true;
    L30:
        if (r1 == false) goto L45;
        LinkedHashMap<String, String> r14 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r15 = LotteryTraceMonitor.EventName.lottery_anchor_draw_refresh;
        StringBuilder r16 = new StringBuilder("lotteryid = ");
        if (r12 == null) goto L38;
        LotteryState r17 = r12.getState();
        if (r17 == null) goto L38;
        t r18 = com.bytedance.android.live.profit.lottery.l.a(r17);
        if (r18 == null) goto L38;
        Long r19 = Long.valueOf(r18.a);
    L39:
        r16.append(r19);
        LotteryTraceMonitor.a(r15, r16.toString());
        x2 r20 = f3.a;
        if (r20 == null) goto L44;
        u0 r22 = r20.iconConfig;
        if (r22 == null) goto L44;
        f(r12, r22.smallCardImage, r22.iconTxt, "", "", null);
        ReadOnlyProperty r110 = w2.g;
        KProperty[] r111 = w2.a;
        RxUtilKt.c(RxUtilKt.d(((Number) r110.getValue(null, r111[5])).longValue(), ((Number) r110.getValue(null, r111[5])).longValue()).filter(c.a).take(1).subscribe(new b(this)), this.b);
        return;
    L44:
        r12.b(new LotteryAction.e(r13));
        return;
    L38:
        r19 = null;
    L19:
        r8 = null;
    L11:
        r5 = 0;
    L45:
        ALogger.i("ttlive_lottery", "LotteryAction.Finish");
        LinkedHashMap<String, String> r23 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r24 = LotteryTraceMonitor.EventName.lottery_draw_finish;
        StringBuilder r25 = new StringBuilder("lotteryid = ");
        if (r12 == null) goto L52;
        LotteryState r26 = r12.getState();
        if (r26 == null) goto L52;
        t r27 = com.bytedance.android.live.profit.lottery.l.a(r26);
        if (r27 == null) goto L52;
        r2 = Long.valueOf(r27.a);
    L52:
        r25.append(r2);
        LotteryTraceMonitor.a(r24, r25.toString());
        r12.b(new LotteryAction.e(r13));
    }

    public LotteryRepository(LotteryContext r2, yz0.l r3, yz0.k r4, com.bytedance.android.livesdk.revenue.service.message.g r5) {
        Intrinsics.checkNotNullParameter(r2, "lotteryContext");
        Intrinsics.checkNotNullParameter(r3, "roomMessageService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        Intrinsics.checkNotNullParameter(r5, "wrdsService");
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
        this.a = "PreviewLotteryEncode";
        this.b = new CompositeDisposable();
        PropertyOwner<sh6.b<Lottery>> r6 = new PropertyOwner(sh6.a.a);
        this.c = r6;
        this.d = r6;
        PropertyOwner<Boolean> r7 = new PropertyOwner(Boolean.FALSE);
        this.e = r7;
        this.f = r7;
        PropertyOwner<ParticipateStatus> r8 = new PropertyOwner(ParticipateStatus.NOTPARTICIPATED);
        this.g = r8;
        this.h = r8;
        PropertyOwner<y2> r9 = new PropertyOwner(new y2(0));
        this.i = r9;
        this.j = r9;
        this.k = BehaviorSubject.create();
        this.l = PublishSubject.create();
    }

    public final void i(LotteryState.a r22, Lottery r23, int r24, e1 r25, com.bytedance.android.live.revenue.common.g r26) {
        Intrinsics.checkNotNullParameter(r22, "lotteryState");
        Intrinsics.checkNotNullParameter(r23, "lottery");
        Intrinsics.checkNotNullParameter(r26, "logCtx");
        if ((r22 instanceof LotteryState.a) == false) goto L14;
        Intrinsics.checkNotNullParameter(r22, "lotteryState");
        Intrinsics.checkNotNullParameter(r23, "lottery");
        Intrinsics.checkNotNullParameter(r26, "logCtx");
        t r1 = com.bytedance.android.live.profit.lottery.l.a(r22);
        if (r1 == null) goto L14;
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r2 = LotteryTraceMonitor.EventName.lottery_draw_compensate_request;
        StringBuilder r3 = new StringBuilder("lotteryid = ");
        LotteryState r4 = r23.getState();
        if (r4 == null) goto L11;
        t r5 = com.bytedance.android.live.profit.lottery.l.a(r4);
        if (r5 == null) goto L11;
        Long r6 = Long.valueOf(r5.a);
    L12:
        r3.append(r6);
        LotteryTraceMonitor.a(r2, r3.toString());
        v.c r7 = v.a;
        long r8 = r1.a;
        com.bytedance.android.live.revenue.common.g r9 = new com.bytedance.android.live.revenue.common.g("ttlive_lottery", "checkCandidadteState lotterId=" + r8);
        r9.a("begin");
        int r10 = LotteryApi.a;
        tz0.b r12 = tz0.b.a;
        uz0.c r13 = new uz0.c();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "$this$beforeConfigureRequest");
        r13.a(qx0.a.a);
        r13.query("lottery_id", String.valueOf(r8));
        Intrinsics.checkNotNullParameter(r13, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.h(RxCompatKt.b(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/lottery/melon/get_candidate_state/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.lottery.model.a.class)), Extra.class, r13.d, r13.a, r13.b, r13.c).map(w.a), new com.bytedance.android.live.core.utils.rxutils.l(r24, 1000, new x()))).singleOrError().doOnEvent(new y(r9, r8)).filter(new i2(this)).subscribe(new j2(r1, this, r23, r25, r26, r22), new k2(this, r23, r26, r22)), this.b);
    L11:
        r6 = null;
    L14:
        LinkedHashMap<String, String> r14 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_update_curcandidatestate, "lotteryState = " + r22.toString());
    }

    public final void f(Lottery r14, String r15, String r16, String r17, String r18, ParticipateStatus r19) {
        x2 r1 = f3.a;
        boolean r10 = g();
        long r2 = 0;
        if (r14 == null) goto L9;
        LotteryState r4 = r14.getState();
        if (r4 == null) goto L9;
        t r5 = com.bytedance.android.live.profit.lottery.l.a(r4);
        if (r5 == null) goto L9;
        long r6 = r5.a;
    L10:
        if (r14 == null) goto L16;
        LotteryState r7 = r14.getState();
        if (r7 == null) goto L16;
        t r8 = com.bytedance.android.live.profit.lottery.l.a(r7);
        if (r8 == null) goto L16;
        r2 = r8.d;
    L16:
        r14.b(new LotteryAction.f(new h1(r6, r2, r15, r16, r17, r10, r18, r19)));
        return;
    L9:
        r6 = 0;
        goto L10
    }
}
