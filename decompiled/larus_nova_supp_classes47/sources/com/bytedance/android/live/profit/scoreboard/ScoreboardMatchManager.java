package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ScoreboardMatchManager implements com.bytedance.android.scope.o, k {
    public final CompositeDisposable a;
    public boolean b;
    public c c;
    public final PublishSubject<sh6.b<dv0.h>> d;
    public final PublishSubject e;
    public final l f;
    public final ScoreboardApiClient g;
    public final yz0.k h;

    public static final class a {
    }

    public static final class b implements dv0.d {
        public final long a;
        public String b;

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r1 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public final String toString() {
            return "MutablePlayer(roomId=" + this.a + ", score=" + this.b + ")";
        }

        @Override // dv0.d
        public final long getRoomId() {
            return this.a;
        }

        @Override // dv0.d
        public final String getScore() {
            return this.b;
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L10;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public b(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "score");
            this.a = r2;
            this.b = r4;
        }
    }

    public final class c implements dv0.h {
        public final PublishSubject<dv0.h> a;
        public boolean b;
        public final Map<Long, b> c;
        public final b d;
        public long e;
        public long f;
        public long g;
        public final String h;
        public final long i;
        public final long j;
        public final long k;
        public final long l;
        public final /* synthetic */ ScoreboardMatchManager m;

        @Override // dv0.h
        public final Observable<dv0.h> c() {
            PublishSubject<dv0.h> r0 = this.a;
            Completable r1 = this.m.d.ignoreElements();
            Intrinsics.checkNotNullParameter(r0, "$this$takeUntil");
            Intrinsics.checkNotNullParameter(r1, "completable");
            return r0.takeUntil(r1.toObservable());
        }

        @Override // dv0.h
        public final Collection<dv0.d> getPlayers() {
            return ((LinkedHashMap) this.c).values();
        }

        public final String toString() {
            return "Round(roundId = " + this.i + ", miniAppId = " + this.h + ", roomId = " + this.j + ", startTime = " + this.k + ", isFinished = " + this.b + ')';
        }

        @Override // dv0.h
        public final long a() {
            return this.e;
        }

        @Override // dv0.h
        public final long b() {
            return this.g;
        }

        @Override // dv0.h
        public final long d() {
            return this.l;
        }

        @Override // dv0.h
        public final long getActualFinishTime() {
            return this.f;
        }

        @Override // dv0.h
        public final b getCreator() {
            return this.d;
        }

        @Override // dv0.h
        public final String getMiniAppId() {
            return this.h;
        }

        @Override // dv0.h
        public final long getRoomId() {
            return this.j;
        }

        @Override // dv0.h
        public final long getRoundId() {
            return this.i;
        }

        @Override // dv0.h
        public final long getStartTime() {
            return this.k;
        }

        @Override // dv0.h
        public final boolean isFinished() {
            return this.b;
        }

        public final void e(long r4, long r6) {
            jy0.b.d("ScoreboardMatchManager", "finish round " + this.i + ", resetTimeout = " + r4 + ", actualFinishTime = " + r6);
            this.b = true;
            this.g = r4;
            this.f = r6;
            this.a.onNext(this);
            this.a.onComplete();
        }

        public final void update(List<? extends dv0.d> r5, long r6) {
            Intrinsics.checkNotNullParameter(r5, "players");
            Iterator<T> r7 = r5.iterator();
        L4:
            if (r7.hasNext() == false) goto L8;
            dv0.d r0 = (dv0.d) r7.next();
            Map<Long, b> r1 = this.c;
            LinkedHashMap r2 = (LinkedHashMap) r1;
            b r3 = (b) r2.get(Long.valueOf(r0.getRoomId()));
            if (r3 == null) goto L4;
            String r4 = r0.getScore();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r3.b = r4;
            goto L4
        L8:
            this.e = r6;
            com.bytedance.android.live.revenue.common.u0 r8 = com.bytedance.android.live.revenue.common.u0.f;
            long r9 = com.bytedance.android.live.revenue.common.t0.b().a / com.bytedance.android.live.revenue.common.u0.b;
            this.a.onNext(this);
        }

        public c(ScoreboardMatchManager r9, String r10, long r12, long r13, long r15, long r17, long r19, List<? extends dv0.d> r22, long r23) {
            Intrinsics.checkNotNullParameter(r10, "miniAppId");
            Intrinsics.checkNotNullParameter(r22, "players");
            this.m = r9;
            this.h = r10;
            this.i = r12;
            this.j = r13;
            this.k = r15;
            this.l = r19;
            this.a = PublishSubject.create();
            List<? extends dv0.d> r1 = r22;
            LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
            Iterator<T> r2 = r1.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            dv0.d r4 = (dv0.d) r2.next();
            Pair r5 = TuplesKt.to(Long.valueOf(r4.getRoomId()), new b(r4.getRoomId(), r4.getScore()));
            r3.put(r5.getFirst(), r5.getSecond());
            goto L4
        L6:
            this.c = r3;
            Iterator r6 = r3.values().iterator();
        L8:
            if (r6.hasNext() == false) goto L15;
            Object r7 = r6.next();
            if (((b) r7).a != r23) goto L12;
            boolean r8 = true;
        L13:
            if (r8 == false) goto L8;
        L16:
            this.d = (b) r7;
            this.e = r17;
            com.bytedance.android.live.revenue.common.u0 r14 = com.bytedance.android.live.revenue.common.u0.f;
            long r16 = com.bytedance.android.live.revenue.common.t0.b().a / com.bytedance.android.live.revenue.common.u0.b;
            return;
        L12:
            r8 = false;
            goto L13
        L15:
            r7 = null;
            goto L16
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ScoreboardMatchManager a;

        public d(ScoreboardMatchManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ScoreboardMatchManager r0 = this.a;
            ScoreboardMatchManager.f(r0, (dv0.k) r2);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ScoreboardMatchManager a;

        public e(ScoreboardMatchManager r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            dv0.j r9 = (dv0.j) r8;
            ScoreboardMatchManager r0 = this.a;
            r0.b = true;
            c r1 = r0.c;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.i != r9.getRoundId()) goto L9;
            r1.e(r9.getExtra().b(), r9.getExtra().a());
            r0.g(null);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ScoreboardMatchManager a;

        public f(ScoreboardMatchManager r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            dv0.l r8 = (dv0.l) r7;
            c r0 = this.a.c;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.i == r8.a) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == true) goto L13;
            r0 = null;
        L13:
            if (r0 == null) goto L17;
            r0.update(r8.b, r8.c);
            return;
        L17:
            return;
        L7:
            if (r8.c < r0.e) goto L9;
            r1 = true;
            goto L10
        }
    }

    static {
    }

    public final void onStart() {
        RxUtilKt.c(this.f.q().subscribe(new d(this)), this.a);
        RxUtilKt.c(this.f.g().subscribe(new e(this)), this.a);
        RxUtilKt.c(this.f.c().subscribe(new f(this)), this.a);
    }

    public final void onStop() {
        this.d.onComplete();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.k
    public final c a() {
        return this.c;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.k
    public final PublishSubject c() {
        return this.e;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.k
    public final void d(String r9) {
        Intrinsics.checkNotNullParameter(r9, "miniAppId");
        if (this.b == true) goto L6;
        ScoreboardApiClient r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "miniAppId");
        Maybe r10 = RxUtilKt.i(r1.a().getCounterInfo(r9, r1.b.getRoom().getId(), 0)).filter(r.a).filter(s.a).map(new t(r1, r9));
        Function1<dv0.k, Unit> r0 = new ScoreboardMatchManager$initData$1(this);
        Intrinsics.checkNotNullParameter(r10, "$this$subscribeOnErrorTrace");
        Intrinsics.checkNotNullParameter("ScoreboardMatchManager", "tag");
        Intrinsics.checkNotNullParameter(r0, "onNext");
        RxUtilKt.c(r10.subscribe(new com.bytedance.android.live.core.utils.rxutils.u(r0), new com.bytedance.android.live.core.utils.rxutils.u(RxUtilKt.f("ScoreboardMatchManager"))), this.a);
        return;
    }

    public final void g(c r3) {
        this.c = r3;
        jy0.b.d("ScoreboardMatchManager", "current round is " + r3);
        this.d.onNext(sh6.c.a(r3));
    }

    public static final void f(ScoreboardMatchManager r19, dv0.k r20) {
        r19.b = true;
        c r1 = r19.c;
        if (r1 != null) goto L5;
    L7:
        dv0.e r2 = r20.a;
        r19.g(new c(r19, r2.getMiniAppId(), r2.getRoundId(), r19.h.getRoom().getId(), r20.b, r20.c, r20.d, r20.e, r20.f));
        return;
    L5:
        if (r1.b == true) goto L7;
        jy0.b.d("ScoreboardMatchManager", "finish previous round " + r1);
        r1.e(-1, r20.c);
        r19.g(null);
        goto L7
    }

    public ScoreboardMatchManager(l r2, ScoreboardApiClient r3, yz0.k r4) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "apiClient");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new CompositeDisposable();
        PublishSubject<sh6.b<dv0.h>> r5 = PublishSubject.create();
        this.d = r5;
        this.e = r5;
    }
}
