package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.s;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.m;
import eu0.t;
import eu0.u;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LeftEcomFansClubMVIViewModel extends com.bytedance.android.anya.f<eu0.f, m, eu0.h> implements o {
    public final CompositeDisposable u;
    public final com.bytedance.android.live.revenue.core.a v;

    public final void onStart() {
    }

    public final void onStop() {
        this.u.clear();
    }

    public LeftEcomFansClubMVIViewModel(com.bytedance.android.live.revenue.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        this.v = r2;
        this.u = new CompositeDisposable();
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new m();
    }

    public final void d(com.bytedance.android.anya.dsl.h<eu0.f, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        LeftEcomFansClubMVIViewModel$bindToParent$1 r0 = LeftEcomFansClubMVIViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public static void e1(l0 r2, m r3, DataCenter r4) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r5 = fu0.b.a(r4);
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.A() == true) goto L24;
        r0<m, Boolean> r0 = r3.getShow();
        Boolean r1 = Boolean.valueOf(r5.F());
        r2.getClass();
        l0.h(r0, r1);
        r r6 = r3.b;
        KProperty[] r7 = m.h;
        KProperty r8 = r7[1];
        r6.getClass();
        if (r5.w() == false) goto L10;
        int r9 = 2131253216;
    L11:
        l0.h(r6, Integer.valueOf(r9));
        r r10 = r3.c;
        KProperty r12 = r7[2];
        r10.getClass();
        l0.h(r10, Boolean.TRUE);
        r r13 = r3.d;
        KProperty r14 = r7[3];
        r13.getClass();
        l0.h(r13, 2131253179);
        r r15 = r3.e;
        KProperty r16 = r7[4];
        r15.getClass();
        l0.h(r15, Boolean.valueOf(r5.w()));
        r r17 = r3.f;
        KProperty r18 = r7[5];
        r17.getClass();
        com.bytedance.android.live.profit.fansclub.o r19 = yt0.d.a(r5.f).a();
        if (r19 == null) goto L16;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.fansclub.r> r20 = r19.getShopFansClubData();
        if (r20 == null) goto L16;
        com.bytedance.android.live.profit.fansclub.r r22 = (com.bytedance.android.live.profit.fansclub.r) r20.getValue();
    L17:
        if (r22 == null) goto L21;
        s r23 = r22.userData;
        if (r23 == null) goto L21;
        int r24 = r23.level;
    L22:
        l0.h(r17, Integer.valueOf(r24));
        r r25 = r3.g;
        KProperty r26 = r7[6];
        r25.getClass();
        l0.h(r25, EntranceAnimState.NONE);
        return;
    L21:
        r24 = 0;
    L16:
        r22 = null;
        goto L17
    L10:
        r9 = 2131253217;
        goto L11
    }

    public final void y0(l0 r10, MVIState r12, p r13) {
        m r14 = (m) r12;
        eu0.h r15 = (eu0.h) r13;
        Intrinsics.checkNotNullParameter(r10, "$this$reduce");
        Intrinsics.checkNotNullParameter(r14, "state");
        Intrinsics.checkNotNullParameter(r15, "action");
        boolean r1 = true;
        if ((r15 instanceof eu0.k) == false) goto L12;
        DataCenter r0 = r15.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r2 = fu0.b.a(r0);
        if (r2 == null) goto L12;
        if (r2.A() == false) goto L10;
        r0<m, Boolean> r3 = r14.getShow();
        Boolean r4 = Boolean.valueOf(r2.F());
        r10.getClass();
        l0.h(r3, r4);
        r r5 = r14.b;
        KProperty[] r6 = m.h;
        KProperty r7 = r6[1];
        r5.getClass();
        l0.h(r5, 2131253216);
        r r8 = r14.d;
        KProperty r9 = r6[3];
        r8.getClass();
        l0.h(r8, 2131253203);
        goto L12
    L10:
        e1(r10, r14, r0);
    L12:
        if ((r15 instanceof eu0.r) == false) goto L15;
        e1(r10, r14, r15.a);
    L15:
        if ((r15 instanceof u) == false) goto L23;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r16 = fu0.b.a(r15.a);
        if (r16 == null) goto L63;
        r0<m, Boolean> r17 = r14.getShow();
        Boolean r18 = Boolean.valueOf(r16.F());
        r10.getClass();
        l0.h(r17, r18);
        r r19 = r14.c;
        KProperty[] r20 = m.h;
        KProperty r22 = r20[2];
        r19.getClass();
        Boolean r23 = Boolean.FALSE;
        l0.h(r19, r23);
        r r24 = r14.e;
        KProperty r25 = r20[4];
        r24.getClass();
        l0.h(r24, r23);
        if (((Boolean) com.bytedance.android.anya.h.b(r14.getShow())).booleanValue() == false) goto L23;
        r r26 = r14.g;
        KProperty r27 = r20[6];
        r26.getClass();
        l0.h(r26, EntranceAnimState.FOLLOWED_SHOWING);
        goto L23
    L63:
        return;
    L23:
        if ((r15 instanceof t) == false) goto L31;
        e1(r10, r14, r15.a);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r110 = fu0.b.a(r15.a);
        if (r110 == null) goto L31;
        if (r110.w() == true) goto L31;
        RxUtilKt.c(Observable.timer(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this)), this.u);
    L31:
        if ((r15 instanceof eu0.b) == false) goto L62;
        DataCenter r111 = r15.a;
        boolean r28 = false;
        if (com.bytedance.android.live.profit.fansclub.i.a() == false) goto L48;
        com.bytedance.android.live.profit.fansclub.o r112 = yt0.d.a(this.v).a();
        if (r112 == null) goto L60;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.fansclub.r> r113 = r112.getShopFansClubData();
        if (r113 == null) goto L60;
        com.bytedance.android.live.profit.fansclub.r r114 = (com.bytedance.android.live.profit.fansclub.r) r113.getValue();
        if (r114 == null) goto L60;
        String r115 = r114.fansClubSchema;
        if (r115 == null) goto L60;
        if (r115.length() > 0) goto L46;
        r1 = false;
    L46:
        if (r1 == false) goto L60;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(s1.getContext(), r115);
    L60:
        int r116 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.f(r15.a);
        return;
    L48:
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r117 = fu0.b.a(r111);
        if (r117 == null) goto L51;
        r28 = r117.A();
    L51:
        if (r28 == false) goto L55;
        if (r28 == false) goto L60;
        if (((Boolean) com.bytedance.android.live.profit.fansclub.i.f.getValue(null, com.bytedance.android.live.profit.fansclub.i.a[4])).booleanValue() == false) goto L60;
    L55:
        FansClubEntranceParams r118 = new FansClubEntranceParams(FansClubEntranceParams.Page.Default, false, null, null, FansClubEntranceParams.Entrance.UserInfoEcomFansClubWidget, false, null, 414);
        com.bytedance.android.live.profit.fansclub.o r119 = yt0.d.a(this.v).a();
        if (r119 == null) goto L60;
        com.bytedance.android.live.profit.fansclub.p r120 = r119.Z8(r118);
        if (r120 == null) goto L60;
        r120.show();
        goto L60
    }
}
