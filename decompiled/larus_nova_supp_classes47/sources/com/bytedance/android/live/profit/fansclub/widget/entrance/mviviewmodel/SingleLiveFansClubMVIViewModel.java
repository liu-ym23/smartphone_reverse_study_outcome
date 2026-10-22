package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.GuardStatus;
import com.bytedance.android.live.profit.fansclub.widget.entrance.EntranceUtilsKt;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.f0;
import eu0.m0;
import eu0.n0;
import eu0.p;
import eu0.q;
import eu0.t;
import eu0.u;
import eu0.y;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SingleLiveFansClubMVIViewModel extends com.bytedance.android.anya.f<m0, n0, eu0.h> implements o {
    public final CompositeDisposable u;
    public final com.bytedance.android.live.revenue.core.a v;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SingleLiveFansClubMVIViewModel a;
        public final /* synthetic */ DataCenter b;

        public a(SingleLiveFansClubMVIViewModel r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.K0(new eu0.o());
            int r4 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
            com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.j(this.b);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SingleLiveFansClubMVIViewModel a;

        public b(SingleLiveFansClubMVIViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.K0(new p());
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.u.clear();
    }

    public SingleLiveFansClubMVIViewModel(com.bytedance.android.live.revenue.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        this.v = r2;
        this.u = new CompositeDisposable();
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new n0();
    }

    public final void d(com.bytedance.android.anya.dsl.h<m0, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleLiveFansClubMVIViewModel$bindToParent$1 r0 = SingleLiveFansClubMVIViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public final int e1(GuardStatus r2, DataCenter r3) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r4 = fu0.b.a(r3);
        int r0 = 0;
        if (r4 == null) goto L8;
        com.bytedance.android.live.profit.fansclub.b r5 = r4.i();
        if (r5 == null) goto L8;
        r0 = r5.b;
    L8:
        if (l.b[r2.ordinal()] == 1) goto L14;
        if (r0 > com.bytedance.android.live.profit.fansclub.i.e()) goto L12;
        return 2131250755;
    L12:
        return 2131250753;
    L14:
        if (r0 > com.bytedance.android.live.profit.fansclub.i.e()) goto L16;
        return 2131250754;
    L16:
        return 2131250752;
    }

    public final void h1(boolean r5, DataCenter r6) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(r6);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 == true) goto L9;
        if (r0.d() == true) goto L9;
        return;
    L9:
        if (r0.j().a != FansClubUserStatus.Unknown) goto L12;
        RxUtilKt.c(Observable.timer(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r6)), this.u);
        return;
    L12:
        if (r0.j().a != FansClubUserStatus.Inactive) goto L17;
        RxUtilKt.c(Observable.timer(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.u);
        return;
    }

    public final void s1(l0<n0> r9, n0 r10, DataCenter r12) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(r12);
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.profit.fansclub.j r1 = r0.j();
        r0.L();
        if (r0.A() == true) goto L46;
        r0<n0, Boolean> r2 = r10.getShow();
        int r4 = 0;
        boolean r5 = true;
        if (r0.F() == false) goto L10;
    L12:
        boolean r3 = false;
    L13:
        Boolean r6 = Boolean.valueOf(r3);
        r9.getClass();
        l0.h(r2, r6);
        r r13 = r10.b;
        KProperty[] r7 = n0.h;
        KProperty r8 = r7[1];
        r13.getClass();
        GuardStatus r14 = r1.b;
        FansClubUserStatus r15 = r1.a;
        int r16 = l.a[r15.ordinal()];
        if (r16 == 1) goto L24;
        if (r16 == 2) goto L21;
        if (r14 != GuardStatus.ActiveGuard) goto L19;
        int r17 = e1(GuardStatus.InactiveGuard, r12);
    L28:
        l0.h(r13, Integer.valueOf(r17));
        r r18 = r10.c;
        KProperty r19 = r7[2];
        r18.getClass();
        l0.h(r18, Boolean.TRUE);
        r r20 = r10.d;
        KProperty r110 = r7[3];
        r20.getClass();
        FansClubUserStatus r111 = r1.a;
        if (r111 != FansClubUserStatus.Inactive) goto L31;
    L36:
        int r112 = 2131253192;
    L37:
        l0.h(r20, Integer.valueOf(r112));
        r r22 = r10.e;
        KProperty r113 = r7[4];
        r22.getClass();
        if (r1.a != FansClubUserStatus.Unknown) goto L41;
        r5 = false;
    L41:
        l0.h(r22, Boolean.valueOf(r5));
        r r23 = r10.f;
        KProperty r114 = r7[5];
        r23.getClass();
        com.bytedance.android.live.profit.fansclub.b r115 = r0.i();
        if (r115 == null) goto L44;
        r4 = r115.b;
    L44:
        l0.h(r23, Integer.valueOf(r4));
        r r24 = r10.g;
        KProperty r116 = r7[6];
        r24.getClass();
        l0.h(r24, EntranceAnimState.NONE);
        return;
    L31:
        if (r111 == FansClubUserStatus.Unknown) goto L33;
    L35:
        r112 = 2131253196;
        goto L37
    L33:
        if (r1.b != GuardStatus.ActiveGuard) goto L35;
    L19:
        r17 = 2131253206;
        goto L28
    L21:
        if (r1.b != GuardStatus.ActiveGuard) goto L23;
        r17 = e1(GuardStatus.InactiveGuard, r12);
        goto L28
    L23:
        r17 = 2131253183;
        goto L28
    L24:
        GuardStatus r25 = GuardStatus.ActiveGuard;
        if (r14 != r25) goto L27;
        r17 = e1(r25, r12);
        goto L28
    L27:
        r17 = 2131253200;
        goto L28
    L10:
        if (r0.K() == true) goto L12;
        r3 = true;
        goto L13
    }

    public final void y0(l0 r6, MVIState r7, com.bytedance.android.anya.p r8) {
        n0 r9 = (n0) r7;
        eu0.h r10 = (eu0.h) r8;
        Intrinsics.checkNotNullParameter(r6, "$this$reduce");
        Intrinsics.checkNotNullParameter(r9, "state");
        Intrinsics.checkNotNullParameter(r10, "action");
        if ((r10 instanceof eu0.k) == false) goto L11;
        DataCenter r0 = r10.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r2 = fu0.b.a(r0);
        if (r2 == null) goto L11;
        if (r2.A() == false) goto L10;
        r0<n0, Boolean> r1 = r9.getShow();
        Boolean r3 = Boolean.valueOf(!r2.F());
        r6.getClass();
        l0.h(r1, r3);
        r r4 = r9.b;
        KProperty[] r5 = n0.h;
        KProperty r12 = r5[1];
        r4.getClass();
        l0.h(r4, 2131253181);
        r r13 = r9.d;
        KProperty r14 = r5[3];
        r13.getClass();
        l0.h(r13, 2131253194);
        goto L11
    L10:
        s1(r6, r9, r0);
    L11:
        boolean r15 = false;
        if ((r10 instanceof y) == false) goto L14;
    L19:
        s1(r6, r9, r10.a);
        if ((r10 instanceof y) == false) goto L23;
        h1(false, r10.a);
    L23:
        if ((r10 instanceof u) == false) goto L36;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r16 = fu0.b.a(r10.a);
        if (r16 == null) goto L43;
        r0<n0, Boolean> r17 = r9.getShow();
        if (r16.F() == false) goto L30;
    L32:
        Boolean r18 = Boolean.valueOf(r15);
        r6.getClass();
        l0.h(r17, r18);
        r r19 = r9.c;
        KProperty[] r20 = n0.h;
        KProperty r22 = r20[2];
        r19.getClass();
        Boolean r23 = Boolean.FALSE;
        l0.h(r19, r23);
        r r24 = r9.e;
        KProperty r25 = r20[4];
        r24.getClass();
        l0.h(r24, r23);
        if (((Boolean) com.bytedance.android.anya.h.b(r9.getShow())).booleanValue() == false) goto L36;
        r r26 = r9.g;
        KProperty r27 = r20[6];
        r26.getClass();
        l0.h(r26, EntranceAnimState.FOLLOWED_SHOWING);
        goto L36
    L30:
        if (r16.K() == true) goto L32;
        r15 = true;
        goto L32
    L43:
        return;
    L36:
        if ((r10 instanceof t) == false) goto L39;
        s1(r6, r9, r10.a);
        h1(true, r10.a);
    L39:
        if ((r10 instanceof eu0.d) == false) goto L42;
        EntranceUtilsKt.b(this.v, r10.a);
        int r28 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.i(r10.a);
        return;
    L42:
        return;
    L14:
        if ((r10 instanceof eu0.r) == true) goto L19;
        if ((r10 instanceof f0) == true) goto L19;
        if ((r10 instanceof q) == false) goto L23;
        goto L19
    }
}
