package com.bytedance.android.live.profit.scoreboard;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ScoreboardExternalServiceFacade implements com.bytedance.android.scope.o, h, j {
    public static final a e = null;
    public final HashMap<Long, ScoreboardExternalServiceImpl> a;
    public final PublishSubject<dv0.h> b;
    public final PublishSubject<dv0.h> c;
    public final PublishSubject<Pair<Long, j.a>> d;

    public static final class ScoreboardExternalServiceImpl implements com.bytedance.android.scope.o, h {
        public final CompositeDisposable a;
        public long b;
        public Long c;
        public final Lazy d;
        public final ScoreboardExternalServiceFacade e;
        public final yz0.k f;
        public final k g;
        public final i h;
        public final ScoreboardApiClient i;
        public final l j;

        public final void onStart() {
            long r0 = this.f.getRoom().getId();
            this.b = r0;
            ScoreboardExternalServiceFacade r2 = this.e;
            r2.getClass();
            Intrinsics.checkNotNullParameter(this, "impl");
            jy0.b.d("ScoreboardServiceFacade", "attachImpl " + r0 + ' ' + this);
            r2.a.put(Long.valueOf(r0), this);
            this.g.c().subscribe(new j0(r2));
            ((Observable) this.d.getValue()).subscribe(new k0(r2, r0));
        }

        public final void onStop() {
            ScoreboardExternalServiceFacade r0 = this.e;
            long r1 = this.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(this, "impl");
            jy0.b.d("ScoreboardServiceFacade", "detachImpl " + r1 + ' ' + this);
            if (r0.a.get(Long.valueOf(r1)) != this) goto L5;
            r0.a.remove(Long.valueOf(r1));
        L5:
            this.a.dispose();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void i(String r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.KEY_APP_ID);
            this.h.c();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void k2(String r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.KEY_APP_ID);
            this.h.w();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final ViewGroup G5(String r2, Context r3) {
            Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r3, "context");
            if (this.h.x() == true) goto L6;
            this.h.y();
        L6:
            return this.h.getContainer();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void H5(String r3, long r4, com.bytedance.android.live.broadcastgame.opengame.openapi.s.a r6) {
            Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r6, "configListener");
            ScoreboardApiClient r0 = this.i;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r3, "miniAppId");
            RxUtilKt.c(RxUtilKt.i(r0.a().getCounterConfig(r3, r4).map(new p(r0))).subscribe(new f0(this, r6)), this.a);
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void S3(String r1, long r2, com.bytedance.android.live.broadcastgame.opengame.sonicgame.l r4) {
            Intrinsics.checkNotNullParameter(r1, Constants.OperatorKey.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r4, "eventListener");
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void s1(String r8, String r9, com.bytedance.android.live.broadcastgame.opengame.openapi.r.a r10) {
            Intrinsics.checkNotNullParameter(r8, Constants.OperatorKey.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r9, "counterId");
            Intrinsics.checkNotNullParameter(r10, "getCounterInfoListener");
            ScoreboardApiClient r0 = this.i;
            long r5 = CastLongProtector.parseLong(r9);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r8, "miniAppId");
            RxUtilKt.c(RxUtilKt.i(r0.a().getCounterInfo(r8, r0.b.getRoom().getId(), r5).map(q.a)).subscribe(new g0(r10)), this.a);
        }

        public ScoreboardExternalServiceImpl(ScoreboardExternalServiceFacade r2, yz0.k r3, k r4, i r5, ScoreboardApiClient r6, l r7) {
            Intrinsics.checkNotNullParameter(r2, "facade");
            Intrinsics.checkNotNullParameter(r3, "roomDataService");
            Intrinsics.checkNotNullParameter(r4, "matchManager");
            Intrinsics.checkNotNullParameter(r5, "bannerController");
            Intrinsics.checkNotNullParameter(r6, "apiClient");
            Intrinsics.checkNotNullParameter(r7, "repository");
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
            this.j = r7;
            this.a = new CompositeDisposable();
            this.d = LazyKt.lazy(new ScoreboardExternalServiceFacade$ScoreboardExternalServiceImpl$bannerStateSubject$2(this));
        }

        @Override // com.bytedance.android.live.profit.scoreboard.h
        public final void S(String r15, LinkMode r16, int r17, com.bytedance.android.live.profit.scoreboard.c r18, String r19, com.bytedance.android.live.broadcastgame.opengame.openapi.b1.a r20) {
            Intrinsics.checkNotNullParameter(r15, Constants.OperatorKey.KEY_APP_ID);
            Intrinsics.checkNotNullParameter(r16, "linkMode");
            Intrinsics.checkNotNullParameter(r19, "prevCounterId");
            Intrinsics.checkNotNullParameter(r20, "startScoreCountingListener");
            Long r3 = StringsKt.toLongOrNull(r19);
            if (r3 == null) goto L5;
            long r10 = r3.longValue();
        L7:
            if (e0.a[r16.ordinal()] == 1) goto L9;
            Long r4 = 0L;
        L10:
            if (r4 != null) goto L14;
            r20.onFailed(-1, "no saved otherRoomId");
            return;
        L14:
            if (r4.longValue() == 0) goto L16;
            r4.longValue();
            dv0.n r5 = new dv0.c(r15, r10);
        L17:
            dv0.n r13 = r5;
            this.j.h().onNext(r13);
            ScoreboardApiClient r6 = this.i;
            long r7 = r4.longValue();
            long r8 = r17;
            if (r18 == null) goto L21;
            String r1 = GsonProtectorUtils.toJson(GsonHelper.get(), r18);
            if (r1 == null) goto L21;
        L22:
            String r9 = r1;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r15, "miniAppId");
            Intrinsics.checkNotNullParameter(r9, "counterSettings");
            RxUtilKt.c(RxUtilKt.i(r6.a().gameRoundStart(r15, r6.b.getRoom().getId(), r7, r8, r9, r10).map(u.a)).subscribe(new h0(r13, r20)), this.a);
            return;
        L21:
            r1 = "";
            goto L22
        L16:
            r5 = new dv0.m(r15, r10);
            goto L17
        L9:
            r4 = this.c;
            goto L10
        L5:
            r10 = 0;
            goto L7
        }
    }

    public static final class a {
        public a() {
        }

        public static n b(com.bytedance.android.live.profit.scoreboard.dto.f r12) {
            int r1 = (int) r12.getIndex();
            String r0 = r12.getName();
            String r2 = r12.getDescription();
            List<com.bytedance.android.live.profit.scoreboard.dto.c> r13 = r12.getGiftChoices();
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator<T> r14 = r13.iterator();
        L4:
            if (r14.hasNext() == false) goto L7;
            com.bytedance.android.live.profit.scoreboard.dto.c r4 = (com.bytedance.android.live.profit.scoreboard.dto.c) r14.next();
            ScoreboardExternalServiceFacade.e.getClass();
            r3.add(new g((int) r4.getIndex(), r4.getGiftName(), r4.getIcon(), (int) r4.getValue()));
            goto L4
        L7:
            return new n(r1, r0, r2, r3);
        }

        public static final o a(a r12, dv0.h r13) {
            r12.getClass();
            String r1 = String.valueOf(r13.getRoundId());
            Collection<dv0.d> r0 = r13.getPlayers();
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r3 = r0.iterator();
            int r4 = 0;
        L4:
            if (r3.hasNext() == false) goto L10;
            Object r5 = r3.next();
            int r6 = r4 + 1;
            if (r4 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            dv0.d r7 = (dv0.d) r5;
            r2.add(new m(r4, String.valueOf(r7.getRoomId()), r7.getScore(), Intrinsics.areEqual(r7, r13.getCreator())));
            r4 = r6;
            goto L4
        L10:
            return new o(r1, r2, r13.a(), r13.d(), r13.getActualFinishTime(), (int) r13.b(), 64);
        }
    }

    public static final class b<T> implements Predicate {
        public final /* synthetic */ long a;

        public b(long r1) {
            this.a = r1;
        }

        public final boolean test(Object r5) {
            Pair r6 = (Pair) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            if (((Number) r6.getFirst()).longValue() != this.a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            Pair r3 = (Pair) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (j.a) r3.getSecond();
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    static {
        e = new a();
    }

    public final ScoreboardExternalServiceImpl a() {
        return (ScoreboardExternalServiceImpl) CollectionsKt.firstOrNull(this.a.values());
    }

    public ScoreboardExternalServiceFacade() {
        this.a = new HashMap();
        this.b = PublishSubject.create();
        this.c = PublishSubject.create();
        this.d = PublishSubject.create();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void i(String r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.KEY_APP_ID);
        jy0.b.d("ScoreboardServiceFacade", "destroyCounterWindowView " + r3);
        ScoreboardExternalServiceImpl r0 = a();
        if (r0 == null) goto L6;
        r0.i(r3);
        return;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void k2(String r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.KEY_APP_ID);
        jy0.b.d("ScoreboardServiceFacade", "showCounterWindowView " + r3);
        ScoreboardExternalServiceImpl r0 = a();
        if (r0 == null) goto L6;
        r0.k2(r3);
        return;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.j
    public final Observable<j.a> l5(long r5) {
        Observable r0 = this.d;
        if (r5 == 0) goto L7;
        r0 = r0.filter(new b(r5));
    L7:
        return r0.map(c.a);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final ViewGroup G5(String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r4, "context");
        jy0.b.d("ScoreboardServiceFacade", "getCounterWindowView " + r3);
        ScoreboardExternalServiceImpl r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.G5(r3, r4);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void H5(String r3, long r4, com.bytedance.android.live.broadcastgame.opengame.openapi.s.a r6) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r6, "configListener");
        jy0.b.d("ScoreboardServiceFacade", "getConfig " + r3 + ' ' + r4);
        ScoreboardExternalServiceImpl r0 = this.a.get(Long.valueOf(r4));
        if (r0 != null) goto L6;
        r6.onFailed(-1, "impl not attached");
        return;
    L6:
        r0.H5(r3, r4, r6);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void S3(String r4, long r5, com.bytedance.android.live.broadcastgame.opengame.sonicgame.l r7) {
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r7, "eventListener");
        jy0.b.d("ScoreboardServiceFacade", "subscribeScoreCountingEvent " + r4 + ' ' + r5);
        CompositeDisposable r0 = new CompositeDisposable();
        r0.add(Disposables.fromAction(new l0(r4, r5)));
        r7.b(r0);
        RxUtilKt.c(this.b.filter(new m0(r5)).subscribe(new n0(r4, r5, r7)), r0);
        RxUtilKt.c(this.c.filter(new o0(r5)).subscribe(new p0(r4, r5, r7)), r0);
        ScoreboardExternalServiceImpl r6 = this.a.get(Long.valueOf(r5));
        if (r6 == null) goto L8;
        k r8 = r6.g;
        if (r8 == null) goto L9;
        r8.d(r4);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void s1(String r3, String r4, com.bytedance.android.live.broadcastgame.opengame.openapi.r.a r5) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r4, "counterId");
        Intrinsics.checkNotNullParameter(r5, "getCounterInfoListener");
        jy0.b.d("ScoreboardServiceFacade", "getCounterRank " + r3 + ' ' + r4);
        ScoreboardExternalServiceImpl r0 = a();
        if (r0 != null) goto L6;
        r5.onFailed(-1, "impl not attached");
        return;
    L6:
        r0.s1(r3, r4, r5);
    }

    @Override // com.bytedance.android.live.profit.scoreboard.h
    public final void S(String r10, LinkMode r12, int r13, com.bytedance.android.live.profit.scoreboard.c r14, String r15, com.bytedance.android.live.broadcastgame.opengame.openapi.b1.a r16) {
        Intrinsics.checkNotNullParameter(r10, Constants.OperatorKey.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r12, "linkMode");
        Intrinsics.checkNotNullParameter(r15, "prevCounterId");
        Intrinsics.checkNotNullParameter(r16, "startScoreCountingListener");
        jy0.b.d("ScoreboardServiceFacade", "startScoreCounting " + r10 + ' ' + r12 + ' ' + r13 + ' ' + r14 + ' ' + r15);
        ScoreboardExternalServiceImpl r2 = a();
        if (r2 != null) goto L6;
        r16.onFailed(-1, "impl not attached");
        return;
    L6:
        r2.S(r10, r12, r13, r14, r15, r16);
    }
}
