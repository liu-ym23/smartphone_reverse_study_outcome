package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.message.model.na;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LotteryIMDataSource implements Disposable {
    public final PublishSubject<b> a;
    public final PublishSubject b;
    public final PublishSubject<f1> c;
    public final PublishSubject d;
    public final PublishSubject<e1> e;
    public final PublishSubject f;
    public final PublishSubject<h1> g;
    public final PublishSubject h;
    public final BehaviorSubject<y2> i;
    public final BehaviorSubject j;
    public final Function1<yh6.c, Unit> k;
    public final CompositeDisposable l;
    public final com.bytedance.android.livesdk.revenue.service.message.g m;
    public final yz0.k n;

    public static final class a implements Action {
        public final /* synthetic */ LotteryIMDataSource a;

        public a(LotteryIMDataSource r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.e.onComplete();
            this.a.c.onComplete();
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final t a;

            public final int hashCode() {
                t r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "LotteryCanceled(info=" + this.a + ")";
            }

            @Override // com.bytedance.android.live.profit.lottery.LotteryIMDataSource.b
            public final t a() {
                return this.a;
            }

            public a(t r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                this.a = r2;
            }

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.lottery.LotteryIMDataSource$b$b, reason: collision with other inner class name */
        public static final class C0032b extends b {
            public final t a;

            public final int hashCode() {
                t r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "LotteryFinished(info=" + this.a + ")";
            }

            @Override // com.bytedance.android.live.profit.lottery.LotteryIMDataSource.b
            public final t a() {
                return this.a;
            }

            public C0032b(t r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                this.a = r2;
            }

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof C0032b) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((C0032b) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public static final class c extends b {
            public final t a;

            public final int hashCode() {
                t r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "LotteryOngoing(info=" + this.a + ")";
            }

            @Override // com.bytedance.android.live.profit.lottery.LotteryIMDataSource.b
            public final t a() {
                return this.a;
            }

            public c(t r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                this.a = r2;
            }

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof c) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public static final class d extends b {
            public final t a;
            public final i1 b;

            public final int hashCode() {
                t r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                i1 r4 = this.b;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "LotteryRejected(info=" + this.a + ", rejectInfo=" + this.b + ")";
            }

            @Override // com.bytedance.android.live.profit.lottery.LotteryIMDataSource.b
            public final t a() {
                return this.a;
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof d) == false) goto L10;
                d r4 = (d) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public d(t r2, i1 r3) {
                Intrinsics.checkNotNullParameter(r2, "info");
                Intrinsics.checkNotNullParameter(r3, "rejectInfo");
                this.a = r2;
                this.b = r3;
            }
        }

        public b() {
        }

        public abstract t a();
    }

    public final class c implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final void dispose() {
        this.l.dispose();
    }

    public final boolean isDisposed() {
        return this.l.isDisposed();
    }

    public final void b(na r6, long r7) {
        ALogger.i("HOT_LOTTERY", "time = " + System.currentTimeMillis());
        LinkedHashMap<String, String> r0 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.EventName r1 = LotteryTraceMonitor.EventName.lottery_init_im;
        StringBuilder r2 = new StringBuilder("lotterystatus = ");
        Object r3 = null;
        if (r6 == null) goto L5;
        Integer r4 = Integer.valueOf(r6.getLotteryStatus());
    L6:
        r2.append(Integer.valueOf(r4.intValue()));
        r2.append(" starttime = ");
        if (r6 == null) goto L9;
        Long r5 = Long.valueOf(r6.getLotteryStartTime());
    L10:
        r2.append(Long.valueOf(r5.longValue()));
        r2.append(" CurrentTime = ");
        if (r6 == null) goto L13;
        Long r8 = Long.valueOf(r6.getLotteryCurrentTime());
    L14:
        r2.append(Long.valueOf(r8.longValue()));
        r2.append(" drawtime = ");
        if (r6 == null) goto L17;
        Long r9 = Long.valueOf(r6.getLotteryDrawTime());
    L18:
        r2.append(Long.valueOf(r9.longValue()));
        r2.append(" lotteryid = ");
        if (r6 == null) goto L21;
        Long r10 = Long.valueOf(r6.getLotteryId());
    L22:
        r2.append(Long.valueOf(r10.longValue()));
        LotteryTraceMonitor.a(r1, r2.toString());
        int r12 = r6.getLotteryStatus();
        if (r12 != 1) goto L25;
        r3 = new b.c(t0.a(r6, r7, this.n));
    L42:
        if (r3 == null) goto L45;
        this.a.onNext(r3);
        return;
    L45:
        return;
    L25:
        if (r12 != 2) goto L27;
        r3 = new b.C0032b(t0.a(r6, r7, this.n));
        goto L42
    L27:
        if (r12 != 3) goto L29;
        r3 = new b.a(t0.a(r6, r7, this.n));
        goto L42
    L29:
        if (r12 != 5) goto L42;
        t r13 = t0.a(r6, r7, this.n);
        Intrinsics.checkNotNullParameter(r6, "$this$toLotteryRejectInfo");
        String r14 = r6.getLotteryRulePageScheme();
        String r15 = "";
        if (r14 != null) goto L34;
        r14 = "";
    L34:
        String r16 = r6.getLotteryAuditFailureReason();
        if (r16 == null) goto L38;
        r15 = r16;
    L38:
        r3 = new b.d(r13, new i1(r14, r15));
        goto L42
    L21:
        r10 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public LotteryIMDataSource(yz0.l r5, CompositeDisposable r6, com.bytedance.android.livesdk.revenue.service.message.g r7, yz0.k r8) {
        Intrinsics.checkNotNullParameter(r5, "messageService");
        Intrinsics.checkNotNullParameter(r6, "cd");
        Intrinsics.checkNotNullParameter(r7, "wrdsService");
        Intrinsics.checkNotNullParameter(r8, "roomDataService");
        this.l = r6;
        this.m = r7;
        this.n = r8;
        PublishSubject<b> r9 = PublishSubject.create();
        this.a = r9;
        this.b = r9;
        PublishSubject<f1> r10 = PublishSubject.create();
        this.c = r10;
        this.d = r10;
        PublishSubject<e1> r12 = PublishSubject.create();
        this.e = r12;
        this.f = r12;
        PublishSubject<h1> r13 = PublishSubject.create();
        this.g = r13;
        this.h = r13;
        BehaviorSubject<y2> r14 = BehaviorSubject.create();
        this.i = r14;
        this.j = r14;
        Function1<yh6.c, Unit> r15 = new LotteryIMDataSource$messageListener$1(this);
        this.k = r15;
        r5.h(new o0());
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r5, com.bytedance.android.live.revenue.common.message.b.v, false, 6).subscribe(new c(r15)), r6);
        RxUtilKt.c(yz0.h.a.a(r5, com.bytedance.android.live.revenue.common.message.b.w, false, 6).subscribe(new c(r15)), r6);
        RxUtilKt.c(yz0.h.a.a(r5, com.bytedance.android.live.revenue.common.message.b.x, false, 6).subscribe(new c(r15)), r6);
        RxUtilKt.c(yz0.h.a.a(r5, com.bytedance.android.live.revenue.common.message.b.y, false, 6).subscribe(new c(r15)), r6);
        r6.add(Disposables.fromAction(new a(this)));
        com.bytedance.android.live.profit.lottery.model.d r16 = (com.bytedance.android.live.profit.lottery.model.d) r7.ga(LotteryIMDataSource$subscribeTempStatusInfoMessage$roomDataSyncModel$1.INSTANCE);
        com.bytedance.android.livesdk.revenue.message.k.b r17 = r16.d;
        KProperty r18 = com.bytedance.android.live.profit.lottery.model.d.e[0];
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "thisRef");
        Intrinsics.checkNotNullParameter(r18, "property");
        RxUtilKt.c(r17.a().a().subscribe(new s0(this)), r6);
    }
}
