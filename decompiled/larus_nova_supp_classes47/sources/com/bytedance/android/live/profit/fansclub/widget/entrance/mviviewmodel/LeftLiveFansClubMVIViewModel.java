package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.GuardStatus;
import com.bytedance.android.live.profit.fansclub.widget.entrance.EntranceUtilsKt;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.f0;
import eu0.n;
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
public final class LeftLiveFansClubMVIViewModel extends com.bytedance.android.anya.f<eu0.f, n, eu0.h> implements o {
    public final CompositeDisposable u;
    public final com.bytedance.android.live.revenue.core.a v;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LeftLiveFansClubMVIViewModel a;
        public final /* synthetic */ DataCenter b;

        public a(LeftLiveFansClubMVIViewModel r1, DataCenter r2) {
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

    public final void onStart() {
    }

    public final void onStop() {
        this.u.clear();
    }

    public LeftLiveFansClubMVIViewModel(com.bytedance.android.live.revenue.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        this.v = r2;
        this.u = new CompositeDisposable();
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new n();
    }

    public final void d(com.bytedance.android.anya.dsl.h<eu0.f, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        LeftLiveFansClubMVIViewModel$bindToParent$1 r0 = LeftLiveFansClubMVIViewModel$bindToParent$1.INSTANCE;
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
        if (i.b[r2.ordinal()] == 1) goto L14;
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

    public final void h1(boolean r3, DataCenter r4) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L9;
        if (r0.d() == true) goto L9;
        return;
    L9:
        if (r0.j().a == FansClubUserStatus.Active) goto L13;
        RxUtilKt.c(Observable.timer(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r4)), this.u);
        return;
    }

    public final void s1(l0<n> r8, n r9, DataCenter r10) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(r10);
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.profit.fansclub.j r1 = r0.j();
        if (r0.A() == true) goto L40;
        r0<n, Boolean> r2 = r9.getShow();
        boolean r4 = true;
        Boolean r3 = Boolean.valueOf(!r0.F());
        r8.getClass();
        l0.h(r2, r3);
        r r12 = r9.b;
        KProperty[] r5 = n.h;
        KProperty r6 = r5[1];
        r12.getClass();
        GuardStatus r7 = r1.b;
        int r13 = i.a[r1.a.ordinal()];
        if (r13 == 1) goto L18;
        if (r13 == 2) goto L15;
        if (r7 != GuardStatus.ActiveGuard) goto L13;
        int r14 = e1(GuardStatus.InactiveGuard, r10);
    L22:
        l0.h(r12, Integer.valueOf(r14));
        r r15 = r9.c;
        KProperty r16 = r5[2];
        r15.getClass();
        l0.h(r15, Boolean.TRUE);
        r r17 = r9.d;
        KProperty r18 = r5[3];
        r17.getClass();
        FansClubUserStatus r19 = r1.a;
        if (r19 != FansClubUserStatus.Inactive) goto L25;
    L30:
        int r110 = 2131253203;
    L31:
        l0.h(r17, Integer.valueOf(r110));
        r r20 = r9.e;
        KProperty r111 = r5[4];
        r20.getClass();
        int r22 = 0;
        if (r1.a != FansClubUserStatus.Unknown) goto L35;
        r4 = false;
    L35:
        l0.h(r20, Boolean.valueOf(r4));
        r r23 = r9.f;
        KProperty r112 = r5[5];
        r23.getClass();
        com.bytedance.android.live.profit.fansclub.b r113 = r0.i();
        if (r113 == null) goto L38;
        r22 = r113.b;
    L38:
        l0.h(r23, Integer.valueOf(r22));
        r r24 = r9.g;
        KProperty r25 = r5[6];
        r24.getClass();
        l0.h(r24, EntranceAnimState.NONE);
        return;
    L25:
        if (r19 == FansClubUserStatus.Unknown) goto L27;
    L29:
        r110 = 2131253202;
        goto L31
    L27:
        if (r1.b != GuardStatus.ActiveGuard) goto L29;
    L13:
        r14 = 2131253207;
        goto L22
    L15:
        if (r1.b != GuardStatus.ActiveGuard) goto L17;
        r14 = e1(GuardStatus.InactiveGuard, r10);
        goto L22
    L17:
        r14 = 2131253184;
        goto L22
    L18:
        GuardStatus r26 = GuardStatus.ActiveGuard;
        if (r7 != r26) goto L21;
        r14 = e1(r26, r10);
        goto L22
    L21:
        r14 = 2131253201;
        goto L22
    }

    public final void y0(l0 r6, MVIState r7, p r8) {
        n r9 = (n) r7;
        eu0.h r10 = (eu0.h) r8;
        Intrinsics.checkNotNullParameter(r6, "$this$reduce");
        Intrinsics.checkNotNullParameter(r9, "state");
        Intrinsics.checkNotNullParameter(r10, "action");
        if ((r10 instanceof eu0.k) == false) goto L12;
        DataCenter r0 = r10.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r2 = fu0.b.a(r0);
        if (r2 == null) goto L12;
        if (r2.A() == false) goto L10;
        r0<n, Boolean> r1 = r9.getShow();
        Boolean r3 = Boolean.valueOf(!r2.F());
        r6.getClass();
        l0.h(r1, r3);
        r r4 = r9.b;
        KProperty[] r5 = n.h;
        KProperty r12 = r5[1];
        r4.getClass();
        l0.h(r4, 2131253181);
        r r13 = r9.d;
        KProperty r14 = r5[3];
        r13.getClass();
        l0.h(r13, 2131253203);
        goto L12
    L10:
        s1(r6, r9, r0);
    L12:
        if ((r10 instanceof y) == false) goto L14;
    L19:
        s1(r6, r9, r10.a);
        if ((r10 instanceof y) == false) goto L23;
        h1(false, r10.a);
    L23:
        if ((r10 instanceof u) == false) goto L31;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r15 = fu0.b.a(r10.a);
        if (r15 == null) goto L38;
        r0<n, Boolean> r16 = r9.getShow();
        Boolean r17 = Boolean.valueOf(!r15.F());
        r6.getClass();
        l0.h(r16, r17);
        r r18 = r9.c;
        KProperty[] r19 = n.h;
        KProperty r20 = r19[2];
        r18.getClass();
        Boolean r22 = Boolean.FALSE;
        l0.h(r18, r22);
        r r23 = r9.e;
        KProperty r24 = r19[4];
        r23.getClass();
        l0.h(r23, r22);
        if (((Boolean) com.bytedance.android.anya.h.b(r9.getShow())).booleanValue() == false) goto L31;
        r r25 = r9.g;
        KProperty r26 = r19[6];
        r25.getClass();
        l0.h(r25, EntranceAnimState.FOLLOWED_SHOWING);
        goto L31
    L38:
        return;
    L31:
        if ((r10 instanceof t) == false) goto L34;
        s1(r6, r9, r10.a);
        h1(true, r10.a);
    L34:
        if ((r10 instanceof eu0.d) == false) goto L37;
        EntranceUtilsKt.b(this.v, r10.a);
        int r27 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.i(r10.a);
        return;
    L37:
        return;
    L14:
        if ((r10 instanceof eu0.r) == true) goto L19;
        if ((r10 instanceof f0) == true) goto L19;
        if ((r10 instanceof q) == false) goto L23;
        goto L19
    }
}
