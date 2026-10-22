package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.fansclub.s;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import eu0.l0;
import eu0.m0;
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
public final class SingleEcomFansClubMVIViewModel extends com.bytedance.android.anya.f<m0, l0, eu0.h> implements o {
    public final CompositeDisposable u;
    public final com.bytedance.android.live.revenue.core.a v;

    public final void onStart() {
    }

    public final void onStop() {
        this.u.clear();
    }

    public SingleEcomFansClubMVIViewModel(com.bytedance.android.live.revenue.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        this.v = r2;
        this.u = new CompositeDisposable();
    }

    public final MVIState F(com.bytedance.android.anya.l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new l0();
    }

    public final void d(com.bytedance.android.anya.dsl.h<m0, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleEcomFansClubMVIViewModel$bindToParent$1 r0 = SingleEcomFansClubMVIViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public static void e1(com.bytedance.android.anya.l0 r5, l0 r6, DataCenter r7) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r8 = fu0.b.a(r7);
        if (r8 != null) goto L5;
        return;
    L5:
        boolean r0 = r8.w();
        if (r8.A() == true) goto L29;
        r0<l0, Boolean> r1 = r6.getShow();
        int r4 = 0;
        if (r8.F() == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        Boolean r3 = Boolean.valueOf(r2);
        r5.getClass();
        com.bytedance.android.anya.l0.h(r1, r3);
        r r9 = r6.b;
        KProperty[] r10 = l0.h;
        KProperty r12 = r10[1];
        r9.getClass();
        if (r0 == false) goto L16;
        int r13 = 2131253176;
    L17:
        com.bytedance.android.anya.l0.h(r9, Integer.valueOf(r13));
        r r14 = r6.c;
        KProperty r15 = r10[2];
        r14.getClass();
        com.bytedance.android.anya.l0.h(r14, Boolean.TRUE);
        r r16 = r6.d;
        KProperty r17 = r10[3];
        r16.getClass();
        com.bytedance.android.anya.l0.h(r16, 2131253177);
        r r18 = r6.e;
        KProperty r19 = r10[4];
        r18.getClass();
        com.bytedance.android.anya.l0.h(r18, Boolean.valueOf(r0));
        r r20 = r6.f;
        KProperty r22 = r10[5];
        r20.getClass();
        com.bytedance.android.live.profit.fansclub.o r23 = yt0.d.a(r8.f).a();
        if (r23 == null) goto L22;
        m<? extends com.bytedance.android.live.profit.fansclub.r> r24 = r23.getShopFansClubData();
        if (r24 == null) goto L22;
        com.bytedance.android.live.profit.fansclub.r r25 = (com.bytedance.android.live.profit.fansclub.r) r24.getValue();
    L23:
        if (r25 == null) goto L27;
        s r26 = r25.userData;
        if (r26 == null) goto L27;
        r4 = r26.level;
    L27:
        com.bytedance.android.anya.l0.h(r20, Integer.valueOf(r4));
        r r27 = r6.g;
        KProperty r28 = r10[6];
        r27.getClass();
        com.bytedance.android.anya.l0.h(r27, EntranceAnimState.NONE);
        return;
    L22:
        r25 = null;
        goto L23
    L16:
        r13 = 2131253180;
        goto L17
    L10:
        if (r8.K() == true) goto L12;
        r2 = true;
        goto L13
    }

    public final void y0(com.bytedance.android.anya.l0 r7, MVIState r8, p r9) {
        l0 r10 = (l0) r8;
        eu0.h r12 = (eu0.h) r9;
        Intrinsics.checkNotNullParameter(r7, "$this$reduce");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r12, "action");
        boolean r1 = true;
        if ((r12 instanceof eu0.k) == false) goto L12;
        DataCenter r0 = r12.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r2 = fu0.b.a(r0);
        if (r2 == null) goto L12;
        if (r2.A() == false) goto L10;
        r0<l0, Boolean> r3 = r10.getShow();
        Boolean r4 = Boolean.valueOf(r2.F());
        r7.getClass();
        com.bytedance.android.anya.l0.h(r3, r4);
        r r5 = r10.b;
        KProperty[] r6 = l0.h;
        KProperty r13 = r6[1];
        r5.getClass();
        com.bytedance.android.anya.l0.h(r5, 2131253176);
        r r14 = r10.d;
        KProperty r15 = r6[3];
        r14.getClass();
        com.bytedance.android.anya.l0.h(r14, 2131253178);
        goto L12
    L10:
        e1(r7, r10, r0);
    L12:
        if ((r12 instanceof eu0.r) == false) goto L15;
        e1(r7, r10, r12.a);
    L15:
        if ((r12 instanceof u) == false) goto L29;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r16 = fu0.b.a(r12.a);
        if (r16 == null) goto L55;
        r0<l0, Boolean> r17 = r10.getShow();
        if (r16.F() == true) goto L22;
    L24:
        boolean r18 = false;
    L25:
        Boolean r19 = Boolean.valueOf(r18);
        r7.getClass();
        com.bytedance.android.anya.l0.h(r17, r19);
        r r20 = r10.c;
        KProperty[] r22 = l0.h;
        KProperty r23 = r22[2];
        r20.getClass();
        Boolean r24 = Boolean.FALSE;
        com.bytedance.android.anya.l0.h(r20, r24);
        r r25 = r10.e;
        KProperty r26 = r22[4];
        r25.getClass();
        com.bytedance.android.anya.l0.h(r25, r24);
        if (((Boolean) com.bytedance.android.anya.h.b(r10.getShow())).booleanValue() == false) goto L29;
        r r27 = r10.g;
        KProperty r28 = r22[6];
        r27.getClass();
        com.bytedance.android.anya.l0.h(r27, EntranceAnimState.FOLLOWED_SHOWING);
        goto L29
    L22:
        if (r16.K() == true) goto L24;
        r18 = true;
        goto L25
    L55:
        return;
    L29:
        if ((r12 instanceof t) == false) goto L37;
        e1(r7, r10, r12.a);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r29 = fu0.b.a(r12.a);
        if (r29 == null) goto L37;
        if (r29.w() == true) goto L37;
        RxUtilKt.c(Observable.timer(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this)), this.u);
    L37:
        if ((r12 instanceof eu0.b) == false) goto L54;
        com.bytedance.android.live.profit.fansclub.o r30 = yt0.d.a(this.v).a();
        if (r30 == null) goto L52;
        m<? extends com.bytedance.android.live.profit.fansclub.r> r32 = r30.getShopFansClubData();
        if (r32 == null) goto L52;
        com.bytedance.android.live.profit.fansclub.r r33 = (com.bytedance.android.live.profit.fansclub.r) r32.getValue();
        if (r33 == null) goto L52;
        String r34 = r33.fansClubSchema;
        if (r34 == null) goto L52;
        if (r34.length() > 0) goto L50;
        r1 = false;
    L50:
        if (r1 == false) goto L52;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(s1.getContext(), r34);
    L52:
        int r35 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.f(r12.a);
        return;
    }
}
