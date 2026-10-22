package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.d0;
import eu0.e0;
import eu0.f0;
import eu0.g0;
import eu0.m0;
import eu0.o0;
import eu0.q;
import eu0.q0;
import eu0.r0;
import eu0.s0;
import eu0.u;
import eu0.y;
import eu0.z;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SingleVipMVIViewModel extends com.bytedance.android.anya.f<m0, o0, eu0.h> implements o {
    public static final du0.c x = null;
    public final CompositeDisposable u;
    public int v;
    public final com.bytedance.android.live.revenue.core.a w;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SingleVipMVIViewModel a;
        public final /* synthetic */ eu0.i b;

        public b(SingleVipMVIViewModel r1, eu0.i r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.K0(this.b);
        }
    }

    public final void onStart() {
    }

    public final int s1(int r3, boolean r4, boolean r5) {
        if (r3 != 0) goto L5;
        return 2131253205;
    L5:
        if (r3 != 1) goto L7;
        if (r4 == false) goto L15;
        return 2131253190;
    L15:
        return 2131253212;
    L7:
        if (r3 != 2) goto L22;
        if (r5 == false) goto L18;
        if (r4 == false) goto L12;
        return 2131253191;
    L12:
        return 2131253215;
    L18:
        return 2131253205;
    L22:
        return 2131253205;
    }

    static {
        x = (du0.c) com.bytedance.android.live.profit.fansclub.i.s.getValue(null, com.bytedance.android.live.profit.fansclub.i.a[16]);
    }

    public final void onStop() {
        this.u.clear();
    }

    public final void t1() {
        if (com.bytedance.android.live.profit.fansclub.i.a() == false) goto L5;
        FansClubEntranceParams.Page r0 = FansClubEntranceParams.Page.VIP;
    L6:
        FansClubEntranceParams.Page r2 = r0;
        com.bytedance.android.live.profit.fansclub.o r1 = yt0.d.a(this.w).a();
        if (r1 == null) goto L12;
        p r3 = r1.Z8(new FansClubEntranceParams(r2, false, "icon", null, null, true, null, 442));
        if (r3 == null) goto L13;
        r3.show();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = FansClubEntranceParams.Page.Default;
        goto L6
    }

    public SingleVipMVIViewModel(com.bytedance.android.live.revenue.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        this.w = r2;
        this.u = new CompositeDisposable();
        this.v = -1;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new o0();
    }

    public final void d(com.bytedance.android.anya.dsl.h<m0, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleVipMVIViewModel$bindToParent$1 r0 = SingleVipMVIViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public final boolean e1(DataCenter r8) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r9 = fu0.b.a(r8);
        if (r9 != null) goto L5;
        return false;
    L5:
        long r1 = (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN)) - r9.o();
        long r3 = 1209600;
        if (1 <= r1) goto L9;
        return false;
    L9:
        if (r3 <= r1) goto L12;
        return true;
    L12:
        return false;
    }

    public final void u1(eu0.i r4) {
        RxUtilKt.c(Observable.timer(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r4)), this.u);
    }

    public final void w1(l0<o0> r10, o0 r12, DataCenter r13) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(r13);
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.s();
        this.v = r1;
        com.bytedance.android.live.profit.vip.h r2 = r0.q();
        if (r2 == null) goto L8;
        int r3 = r2.i;
    L9:
        boolean r5 = true;
        if (r3 != 2) goto L12;
        boolean r4 = true;
    L13:
        String r6 = h1(r1, r4, e1(r13), r0.A());
        if (r6 == null) goto L20;
        if (r6.length() == 0) goto L20;
        r5 = false;
    L20:
        if (r0.A() == true) goto L34;
        r r7 = r12.a;
        KProperty[] r8 = o0.g;
        KProperty r9 = r8[0];
        r7.getClass();
        Boolean r14 = Boolean.valueOf(r0.K());
        r10.getClass();
        l0.h(r7, r14);
        r r15 = r12.c();
        if (r5 == true) goto L24;
        int r16 = -1;
    L25:
        l0.h(r15, Integer.valueOf(r16));
        r r17 = r12.c;
        KProperty r18 = r8[2];
        r17.getClass();
        l0.h(r17, Boolean.TRUE);
        r r19 = r12.b();
        boolean r110 = e1(r13);
        if (r1 != 2) goto L29;
        if (r110 == false) goto L29;
        int r111 = 2131253209;
    L30:
        l0.h(r19, Integer.valueOf(r111));
        l0.h(r12.a(), EntranceAnimState.NONE);
        if (r5 == true) goto L42;
        r r112 = r12.f;
        KProperty r113 = r8[5];
        r112.getClass();
        py.k r114 = vh7.f.c(py.k.class);
        r114.setUrls(CollectionsKt.listOfNotNull(r6));
        Unit r115 = Unit.INSTANCE;
        l0.h(r112, r114);
        return;
    L42:
        return;
    L29:
        r111 = 2131253208;
        goto L30
    L24:
        r16 = s1(r1, r4, e1(r13));
        goto L25
    L34:
        if (r0.N() == true) goto L40;
        r r116 = r12.b();
        r10.getClass();
        l0.h(r116, 2131253214);
        r r117 = r12.c();
        if (com.bytedance.android.live.profit.fansclub.i.b() == false) goto L38;
        int r118 = 2131253215;
    L39:
        l0.h(r117, Integer.valueOf(r118));
        return;
    L38:
        r118 = 2131253205;
        goto L39
    L40:
        r r119 = r12.b();
        r10.getClass();
        l0.h(r119, 2131253213);
        l0.h(r12.c(), 2131253212);
        return;
    L12:
        r4 = false;
        goto L13
    L8:
        r3 = 0;
        goto L9
    }

    public final void y0(l0 r12, MVIState r13, com.bytedance.android.anya.p r14) {
        o0 r15 = (o0) r13;
        eu0.h r16 = (eu0.h) r14;
        Intrinsics.checkNotNullParameter(r12, "$this$reduce");
        Intrinsics.checkNotNullParameter(r15, "state");
        Intrinsics.checkNotNullParameter(r16, "action");
        if ((r16 instanceof eu0.k) == false) goto L8;
        DataCenter r0 = r16.a;
        if (fu0.b.a(r0) == null) goto L8;
        w1(r12, r15, r0);
    L8:
        boolean r2 = true;
        if ((r16 instanceof y) == false) goto L11;
    L16:
        DataCenter r1 = r16.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r4 = fu0.b.a(r1);
        if (r4 != null) goto L20;
    L42:
        if ((r16 instanceof u) == false) goto L45;
        fu0.b.a(r16.a);
        r r3 = r15.c;
        KProperty r5 = o0.g[2];
        r3.getClass();
        Boolean r6 = Boolean.FALSE;
        r12.getClass();
        l0.h(r3, r6);
        l0.h(r15.a(), EntranceAnimState.FOLLOWED_SHOWING);
    L45:
        if ((r16 instanceof g0) == false) goto L52;
        w1(r12, r15, r16.a);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r7 = fu0.b.a(r16.a);
        if (r7 != null) goto L49;
    L50:
        u1(new q0());
        goto L52
    L49:
        if (r7.s() != 1) goto L50;
    L52:
        if ((r16 instanceof z) == false) goto L57;
        r r8 = r15.a;
        KProperty r9 = o0.g[0];
        r8.getClass();
        r12.getClass();
        if (((Boolean) com.bytedance.android.anya.h.b(r8)).booleanValue() == false) goto L57;
        t1();
        int r10 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.l(r16.a);
    L57:
        if ((r16 instanceof eu0.e) == false) goto L60;
        t1();
        int r17 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.l(r16.a);
    L60:
        if ((r16 instanceof d0) == false) goto L88;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r18 = fu0.b.a(r16.a);
        if (r18 == null) goto L92;
        boolean r19 = r18.A();
        int r20 = r18.s();
        com.bytedance.android.live.profit.vip.h r22 = r18.q();
        if (r22 == null) goto L67;
        int r23 = r22.i;
    L68:
        if (r23 != 2) goto L70;
        boolean r24 = true;
    L71:
        if (r19 == false) goto L73;
        r r25 = r15.c();
        Integer r26 = Integer.valueOf(s1(r20, r24, e1(r16.a)));
        r12.getClass();
        l0.h(r25, r26);
    L86:
        r r27 = r15.a();
        EntranceAnimState r28 = EntranceAnimState.ACTIVATED_SHOWING;
        r12.getClass();
        l0.h(r27, r28);
        goto L88
    L73:
        String r29 = h1(r20, r24, e1(r16.a), r19);
        if (r29 != null) goto L76;
    L79:
        r r30 = r15.c();
        if (r2 == true) goto L82;
        int r32 = -1;
    L83:
        Integer r33 = Integer.valueOf(r32);
        r12.getClass();
        l0.h(r30, r33);
        if (r2 == true) goto L86;
        r r34 = r15.f;
        KProperty r35 = o0.g[5];
        r34.getClass();
        py.k r36 = vh7.f.c(py.k.class);
        r36.setUrls(CollectionsKt.listOfNotNull(r29));
        Unit r37 = Unit.INSTANCE;
        l0.h(r34, r36);
        goto L86
    L82:
        r32 = s1(r20, r24, e1(r16.a));
        goto L83
    L76:
        if (r29.length() == 0) goto L79;
        r2 = false;
        goto L79
    L70:
        r24 = false;
        goto L71
    L67:
        r23 = 0;
        goto L68
    L92:
        return;
    L88:
        if ((r16 instanceof e0) == false) goto L91;
        w1(r12, r15, r16.a);
        return;
    L91:
        return;
    L20:
        if (r4.s() == 1) goto L22;
        w1(r12, r15, r1);
        u1(new q0());
        goto L42
    L22:
        int r38 = this.v;
        if (r38 != 0) goto L25;
        r r39 = r15.a();
        EntranceAnimState r40 = EntranceAnimState.ACTIVATED_HIDING;
        r12.getClass();
        l0.h(r39, r40);
        goto L42
    L25:
        if (r38 != 2) goto L27;
        r r42 = r15.a();
        EntranceAnimState r43 = EntranceAnimState.ACTIVATED_HIDING;
        r12.getClass();
        l0.h(r42, r43);
        K0(new r0());
        goto L42
    L27:
        w1(r12, r15, r1);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r44 = fu0.b.a(r1);
        if (r44 == null) goto L37;
        long r45 = r44.o() - (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN));
        IntRange r46 = RangesKt.until(1, 86400);
        IntRange r47 = RangesKt.until(172801, 259200);
        IntRange r48 = RangesKt.until(518401, 604800);
        if (RangesKt.intRangeContains(r46, r45) == false) goto L33;
    L38:
        boolean r49 = true;
    L39:
        if (r49 == false) goto L42;
        u1(new s0());
        goto L42
    L33:
        if (RangesKt.intRangeContains(r47, r45) == true) goto L38;
        if (RangesKt.intRangeContains(r48, r45) == true) goto L38;
    L37:
        r49 = false;
        goto L39
    L11:
        if ((r16 instanceof eu0.r) == true) goto L16;
        if ((r16 instanceof f0) == true) goto L16;
        if ((r16 instanceof q) == false) goto L42;
        goto L16
    }

    public final String h1(int r5, boolean r6, boolean r7, boolean r8) {
        if (r8 == false) goto L5;
        return null;
    L5:
        du0.c r9 = x;
        if (r9 != null) goto L8;
        return null;
    L8:
        if (r9.a() != true) goto L69;
        boolean r1 = false;
        if (r5 == 0) goto L45;
        if (r5 != 1) goto L14;
        return null;
    L14:
        if (r5 == 2) goto L24;
        if (r9 == null) goto L57;
        String r10 = r9.c();
        if (r10 != null) goto L19;
        return null;
    L19:
        if (r10.length() != 0) goto L22;
        r1 = true;
    L22:
        if ((!r1) == true) goto L54;
        return null;
    L54:
        return r10;
    L57:
        return null;
    L24:
        if (r7 == false) goto L36;
        if (r6 == true) goto L70;
        if (r9 == null) goto L60;
        r10 = r9.b();
        if (r10 != null) goto L31;
        return null;
    L31:
        if (r10.length() != 0) goto L34;
        r1 = true;
    L34:
        if ((!r1) == true) goto L54;
        return null;
    L60:
        return null;
    L70:
        return null;
    L36:
        if (r9 == null) goto L63;
        r10 = r9.c();
        if (r10 != null) goto L40;
        return null;
    L40:
        if (r10.length() != 0) goto L43;
        r1 = true;
    L43:
        if ((!r1) == true) goto L54;
        return null;
    L63:
        return null;
    L45:
        if (r9 == null) goto L66;
        r10 = r9.c();
        if (r10 != null) goto L49;
        return null;
    L49:
        if (r10.length() != 0) goto L52;
        r1 = true;
    L52:
        if ((!r1) == true) goto L54;
        return null;
    L66:
        return null;
    L69:
        return null;
    }
}
