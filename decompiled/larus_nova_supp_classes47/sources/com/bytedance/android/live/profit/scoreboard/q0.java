package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.message.model.k7;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q0 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final l b;
    public final yz0.l c;
    public final yz0.k d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ q0 a;

        public b(q0 r1) {
            this.a = r1;
        }

        public final void accept(Object r20) {
            com.bytedance.android.live.profit.scoreboard.dto.o r0 = (com.bytedance.android.live.profit.scoreboard.dto.o) r20;
            q0 r2 = this.a;
            r2.getClass();
            jy0.b.d("ScoreboardImClient", "process round message: type = " + r0.getMessageType() + ", roundId = " + r0.getRoundId());
            int r3 = r0.getMessageType();
            if (r3 != 1) goto L5;
            dv0.i r5 = q0.a(r0);
            List<com.bytedance.android.live.profit.scoreboard.dto.k> r4 = r0.getPlayers();
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<T> r6 = r4.iterator();
        L16:
            if (r6.hasNext() == false) goto L18;
            r12.add(new dv0.g(((com.bytedance.android.live.profit.scoreboard.dto.k) r6.next()).getRoomId(), DataType.FALSE));
            goto L16
        L18:
            long r7 = r0.getStartTime();
            long r8 = r0.getStartTime();
            long r10 = r0.getExpectFinishTime();
            long r13 = r2.d.getRoom().getId();
            if (r5.e.c() == true) goto L35;
            Iterator r1 = r12.iterator();
        L23:
            if (r1.hasNext() == false) goto L30;
            Object r15 = r1.next();
            if (((dv0.d) r15).getRoomId() == r13) goto L27;
            boolean r16 = true;
        L28:
            if (r16 == false) goto L23;
        L31:
            dv0.d r17 = (dv0.d) r15;
            if (r17 == null) goto L34;
            r13 = r17.getRoomId();
            goto L35
        L34:
            r13 = 0;
            goto L35
        L27:
            r16 = false;
            goto L28
        L30:
            r15 = null;
        L35:
            r2.b.q().onNext(new dv0.k(r5, r7, r8, r10, r12, r13));
            return;
        L5:
            if (r3 != 2) goto L7;
            r2.b.g().onNext(new dv0.j(q0.a(r0)));
            return;
        L7:
            if (r3 != 3) goto L9;
            r2.b.k().a(sh6.c.a(new dv0.f(q0.a(r0), r0.getShouldShowAuth(), r0.getNoticeTitle(), r0.getNoticeSubtitle())));
            return;
        L9:
            if (r3 != 4) goto L46;
            r2.b.i().onNext(new dv0.b(r0.getMiniAppId(), r0.getRoundId(), r0.getNoticeSubtitle()));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ q0 a;

        public c(q0 r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            com.bytedance.android.live.profit.scoreboard.dto.n r13 = (com.bytedance.android.live.profit.scoreboard.dto.n) r12;
            q0 r0 = this.a;
            r0.getClass();
            jy0.b.d("ScoreboardImClient", "process counter message: roundId = " + r13.getRoundId());
            String r4 = r13.getMiniAppId();
            long r5 = r13.getRoundId();
            List<com.bytedance.android.live.profit.scoreboard.dto.i> r1 = r13.getPlayers();
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r2 = r1.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            com.bytedance.android.live.profit.scoreboard.dto.i r3 = (com.bytedance.android.live.profit.scoreboard.dto.i) r2.next();
            r7.add(new dv0.g(r3.getRoomId(), r3.getPoint()));
            goto L4
        L6:
            long r8 = r13.getUpdateTime();
            r13.getStartTime();
            r13.getExpectFinishTime();
            r0.b.c().onNext(new dv0.l(r4, r5, r7, r8));
        }
    }

    static {
    }

    public final void onStart() {
        yz0.l r0 = this.c;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.L, false, 6).subscribe(new b(this)), this.a);
        RxUtilKt.c(yz0.h.a.a(this.c, com.bytedance.android.live.revenue.common.message.b.M, false, 6).subscribe(new c(this)), this.a);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public static dv0.i a(com.bytedance.android.live.profit.scoreboard.dto.o r7) {
        String r1 = r7.getMiniAppId();
        long r2 = r7.getRoundId();
        k7 r4 = r7.getEntrance();
        String r5 = r7.getCreatorId();
        String r8 = r7.getExtra();
        if ((!StringsKt.isBlank(r8)) == true) goto L6;
        r8 = null;
    L6:
        if (r8 == null) goto L9;
        com.bytedance.android.live.profit.scoreboard.dto.r r9 = (com.bytedance.android.live.profit.scoreboard.dto.r) GsonProtectorUtils.fromJson(GsonHelper.get(), r8, com.bytedance.android.live.profit.scoreboard.dto.r.class);
        if (r9 == null) goto L9;
    L11:
        return new dv0.i(r1, r2, r4, r5, r9);
    L9:
        r9 = new com.bytedance.android.live.profit.scoreboard.dto.r(false, 7);
        goto L11
    }

    public q0(l r2, yz0.l r3, yz0.k r4) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "roomMessageService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new CompositeDisposable();
    }
}
