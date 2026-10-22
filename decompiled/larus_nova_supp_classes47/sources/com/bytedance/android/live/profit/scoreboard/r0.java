package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.message.model.k7;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r0 implements com.bytedance.android.scope.o {
    public static final /* synthetic */ int g = 0;
    public final CompositeDisposable a;
    public final yz0.k b;
    public final l c;
    public final com.bytedance.android.livesdk.revenue.service.broadcast.a d;
    public final ScoreboardApiClient e;
    public final ScoreboardEventTracker f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public b(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            final r0 r0 = this.a;
            Object r8 = sh6.c.b((sh6.b) r7);
            if (r8 == null) goto L13;
            final dv0.f r9 = (dv0.f) r8;
            r0.getClass();
            jy0.b.d("ScoreboardInvitationHandler", "processInvitation invitation = " + r9);
            Single r1 = Single.create(new h1(r0, r9.c, r9.d)).takeUntil(r0.c.k().take(1).ignoreElements()).doOnSuccess(new x0(r0, r9));
            if (r9.b == true) goto L7;
            Single r3 = Single.just(Boolean.TRUE);
        L11:
            RxUtilKt.c(RxUtilKt.q(Single.concat(r1, r3).all(y0.a).doOnError(new z0(r0, r9)).doFinally(new a1(r0, r9)), "ScoreboardInvitationHandler", new ScoreboardInvitationHandler$processInvitation$5(r0, r9)), r0.a);
            return;
        L7:
            jy0.b.d("ScoreboardInvitationHandler", "showAuthDialog roundId = " + r9.getRoundId());
            k7 r4 = r9.getEntranceInfo();
            if (r4 != null) goto L10;
            r3 = Single.error(new IllegalArgumentException("missing entrance info"));
            goto L11
        L10:
            r3 = Single.defer(new g1(r0, r4));
            goto L11
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public c(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            dv0.b r6 = (dv0.b) r5;
            r0 r0 = this.a;
            String r1 = r6.c;
            r0.getClass();
            if (r1.length() <= 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            ToastUtil.b(r1, 0);
        L9:
            this.a.f.i(r6.a, r6.b, ScoreboardEventTracker.ToastContent.InvitationDeclined);
            return;
        L8:
            ToastUtil.a(2131922337, 0);
            goto L9
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public d(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            dv0.j r6 = (dv0.j) r5;
            if (r6.getExtra().c() == false) goto L5;
            return;
        L5:
            if (r6.getExtra().b() != 0) goto L9;
            this.a.getClass();
            ToastUtil.a(2131922340, 0);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ r0 a;

        public e(r0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            dv0.n r4 = (dv0.n) r3;
            RxUtilKt.c(r4.b.subscribe(new v0(this, r4), new w0(this)), this.a.a);
        }
    }

    static {
    }

    public final void onStop() {
    }

    public final void onStart() {
        RxUtilKt.c(this.c.k().subscribe(new b(this)), this.a);
        RxUtilKt.c(this.c.i().subscribe(new c(this)), this.a);
        RxUtilKt.c(this.c.g().subscribe(new d(this)), this.a);
        RxUtilKt.c(this.c.h().subscribe(new e(this)), this.a);
    }

    public static final void a(r0 r9, dv0.f r10, boolean r12) {
        r9.getClass();
        jy0.b.d("ScoreboardInvitationHandler", "respondToInvitation roundId = " + r10.getRoundId() + ", accept = " + r12);
        ScoreboardApiClient r0 = r9.e;
        String r2 = r10.getMiniAppId();
        long r5 = r10.getRoundId();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "miniAppId");
        Completable r1 = r0.a().gameRoundAccept(r2, r0.b.getRoom().getId(), r5, r12).ignoreElement();
        Intrinsics.checkNotNullParameter(r1, "$this$observeOnUi");
        RxUtilKt.c(r1.observeOn(AndroidSchedulers.mainThread()).subscribe(b1.a, c1.a), r9.a);
        if (r12 == false) goto L6;
        r9.d.hidePlugin(true);
        Completable r13 = Completable.create(new s0(r9, r10));
        ScoreboardApiClient r3 = r9.e;
        String r4 = r10.getMiniAppId();
        long r6 = r10.getRoundId();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "miniAppId");
        Completable r14 = r3.a().gameRoundReady(r4, r3.b.getRoom().getId(), r6).ignoreElement();
        Intrinsics.checkNotNullParameter(r14, "$this$observeOnUi");
        RxUtilKt.c(r13.andThen(r14.observeOn(AndroidSchedulers.mainThread())).doOnError(d1.a).subscribe(e1.a, f1.a), r9.a);
        return;
    }

    public r0(yz0.k r2, l r3, com.bytedance.android.livesdk.revenue.service.broadcast.a r4, ScoreboardApiClient r5, ScoreboardEventTracker r6) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "repository");
        Intrinsics.checkNotNullParameter(r4, "gameService");
        Intrinsics.checkNotNullParameter(r5, "apiClient");
        Intrinsics.checkNotNullParameter(r6, "eventTracker");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.a = new CompositeDisposable();
    }
}
