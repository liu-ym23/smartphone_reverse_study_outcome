package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.d0;
import eu0.e0;
import eu0.f0;
import eu0.g0;
import eu0.i0;
import eu0.q;
import eu0.q0;
import eu0.r0;
import eu0.s0;
import eu0.u;
import eu0.y;
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
public final class RightVipMVIViewModel extends com.bytedance.android.anya.f<eu0.f, i0, eu0.h> implements o {
    public static final du0.c x = null;
    public final CompositeDisposable u;
    public int v;
    public final com.bytedance.android.live.revenue.core.a w;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RightVipMVIViewModel a;
        public final /* synthetic */ eu0.i b;

        public b(RightVipMVIViewModel r1, eu0.i r2) {
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

    public RightVipMVIViewModel(com.bytedance.android.live.revenue.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        this.w = r2;
        this.u = new CompositeDisposable();
        this.v = -1;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new i0();
    }

    public final void d(com.bytedance.android.anya.dsl.h<eu0.f, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        RightVipMVIViewModel$bindToParent$1 r0 = RightVipMVIViewModel$bindToParent$1.INSTANCE;
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

    public final void t1(eu0.i r4) {
        RxUtilKt.c(Observable.timer(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r4)), this.u);
    }

    public final void u1(l0<i0> r12, i0 r13, DataCenter r14) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(r14);
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
        String r6 = h1(r1, r4, e1(r14), r0.A());
        if (r6 != null) goto L16;
    L19:
        int r8 = 2131253213;
        if (r0.A() == true) goto L33;
        r r7 = r13.a;
        KProperty[] r9 = i0.g;
        KProperty r10 = r9[0];
        r7.getClass();
        Boolean r15 = Boolean.TRUE;
        r12.getClass();
        l0.h(r7, r15);
        r r16 = r13.c();
        if (r5 == true) goto L24;
        int r17 = -1;
    L25:
        l0.h(r16, Integer.valueOf(r17));
        r r18 = r13.c;
        KProperty r19 = r9[2];
        r18.getClass();
        l0.h(r18, r15);
        r r110 = r13.b();
        boolean r111 = e1(r14);
        if (r1 != 2) goto L29;
        if (r111 == false) goto L29;
        r8 = 2131253214;
    L29:
        l0.h(r110, Integer.valueOf(r8));
        l0.h(r13.a(), EntranceAnimState.NONE);
        if (r5 == true) goto L41;
        r r112 = r13.f;
        KProperty r113 = r9[5];
        r112.getClass();
        py.k r114 = vh7.f.c(py.k.class);
        r114.setUrls(CollectionsKt.listOfNotNull(r6));
        Unit r115 = Unit.INSTANCE;
        l0.h(r112, r114);
        return;
    L41:
        return;
    L24:
        r17 = s1(r1, r4, e1(r14));
        goto L25
    L33:
        if (r0.N() == true) goto L39;
        r r116 = r13.c();
        if (com.bytedance.android.live.profit.fansclub.i.b() == false) goto L37;
        int r20 = 2131253215;
    L38:
        Integer r22 = Integer.valueOf(r20);
        r12.getClass();
        l0.h(r116, r22);
        l0.h(r13.b(), 2131253214);
        return;
    L37:
        r20 = 2131253205;
        goto L38
    L39:
        r r117 = r13.c();
        r12.getClass();
        l0.h(r117, 2131253212);
        l0.h(r13.b(), 2131253213);
        return;
    L16:
        if (r6.length() == 0) goto L19;
        r5 = false;
        goto L19
    L12:
        r4 = false;
        goto L13
    L8:
        r3 = 0;
        goto L9
    }

    public final void y0(l0 r19, MVIState r20, p r22) {
        i0 r2 = (i0) r20;
        eu0.h r3 = (eu0.h) r22;
        Intrinsics.checkNotNullParameter(r19, "$this$reduce");
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "action");
        if ((r3 instanceof eu0.k) == false) goto L18;
        DataCenter r4 = r3.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r6 = fu0.b.a(r4);
        if (r6 == null) goto L18;
        if (r6.A() == false) goto L17;
        r r5 = r2.a;
        KProperty r7 = i0.g[0];
        r5.getClass();
        Boolean r8 = Boolean.TRUE;
        r19.getClass();
        l0.h(r5, r8);
        if (r6.N() == true) goto L16;
        r r9 = r2.c();
        if (com.bytedance.android.live.profit.fansclub.i.b() == false) goto L14;
        int r10 = 2131253215;
    L15:
        l0.h(r9, Integer.valueOf(r10));
        l0.h(r2.b(), 2131253214);
        goto L18
    L14:
        r10 = 2131253205;
        goto L15
    L16:
        l0.h(r2.c(), 2131253212);
        l0.h(r2.b(), 2131253213);
        goto L18
    L17:
        u1(r19, r2, r4);
    L18:
        boolean r12 = true;
        if ((r3 instanceof y) == false) goto L21;
    L26:
        DataCenter r13 = r3.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r14 = fu0.b.a(r13);
        if (r14 != null) goto L30;
    L52:
        if ((r3 instanceof u) == false) goto L55;
        fu0.b.a(r3.a);
        r r15 = r2.c;
        KProperty r16 = i0.g[2];
        r15.getClass();
        Boolean r17 = Boolean.FALSE;
        r19.getClass();
        l0.h(r15, r17);
        l0.h(r2.a(), EntranceAnimState.FOLLOWED_SHOWING);
    L55:
        if ((r3 instanceof g0) == false) goto L62;
        u1(r19, r2, r3.a);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r18 = fu0.b.a(r3.a);
        if (r18 != null) goto L59;
    L60:
        t1(new q0());
        goto L62
    L59:
        if (r18.s() != 1) goto L60;
    L62:
        if ((r3 instanceof eu0.e) == false) goto L74;
        if (com.bytedance.android.live.profit.fansclub.i.a() == false) goto L66;
        FansClubEntranceParams.Page r23 = FansClubEntranceParams.Page.VIP;
    L67:
        FansClubEntranceParams.Page r24 = r23;
        com.bytedance.android.live.profit.fansclub.o r25 = yt0.d.a(this.w).a();
        if (r25 == null) goto L72;
        com.bytedance.android.live.profit.fansclub.p r26 = r25.Z8(new FansClubEntranceParams(r24, false, "icon", null, null, true, null, 442));
        if (r26 == null) goto L72;
        r26.show();
    L72:
        int r27 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.l(r3.a);
        goto L74
    L66:
        r23 = FansClubEntranceParams.Page.Default;
    L74:
        if ((r3 instanceof d0) == false) goto L102;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r28 = fu0.b.a(r3.a);
        if (r28 == null) goto L106;
        boolean r29 = r28.A();
        int r30 = r28.s();
        com.bytedance.android.live.profit.vip.h r32 = r28.q();
        if (r32 == null) goto L81;
        int r33 = r32.i;
    L82:
        if (r33 != 2) goto L84;
        boolean r34 = true;
    L85:
        if (r29 == false) goto L87;
        r r35 = r2.c();
        Integer r36 = Integer.valueOf(s1(r30, r34, e1(r3.a)));
        r19.getClass();
        l0.h(r35, r36);
    L100:
        r r37 = r2.a();
        EntranceAnimState r38 = EntranceAnimState.ACTIVATED_SHOWING;
        r19.getClass();
        l0.h(r37, r38);
        goto L102
    L87:
        String r39 = h1(r30, r34, e1(r3.a), r29);
        if (r39 != null) goto L90;
    L93:
        r r40 = r2.c();
        if (r12 == true) goto L96;
        int r42 = -1;
    L97:
        Integer r43 = Integer.valueOf(r42);
        r19.getClass();
        l0.h(r40, r43);
        if (r12 == true) goto L100;
        r r44 = r2.f;
        KProperty r45 = i0.g[5];
        r44.getClass();
        py.k r46 = vh7.f.c(py.k.class);
        r46.setUrls(CollectionsKt.listOfNotNull(r39));
        Unit r47 = Unit.INSTANCE;
        l0.h(r44, r46);
        goto L100
    L96:
        r42 = s1(r30, r34, e1(r3.a));
        goto L97
    L90:
        if (r39.length() == 0) goto L93;
        r12 = false;
        goto L93
    L84:
        r34 = false;
        goto L85
    L81:
        r33 = 0;
        goto L82
    L106:
        return;
    L102:
        if ((r3 instanceof e0) == false) goto L105;
        u1(r19, r2, r3.a);
        return;
    L105:
        return;
    L30:
        if (r14.s() == 1) goto L32;
        u1(r19, r2, r13);
        t1(new q0());
        goto L52
    L32:
        int r48 = this.v;
        if (r48 != 0) goto L35;
        r r49 = r2.a();
        EntranceAnimState r50 = EntranceAnimState.ACTIVATED_HIDING;
        r19.getClass();
        l0.h(r49, r50);
        goto L52
    L35:
        if (r48 != 2) goto L37;
        r r52 = r2.a();
        EntranceAnimState r53 = EntranceAnimState.ACTIVATED_HIDING;
        r19.getClass();
        l0.h(r52, r53);
        K0(new r0());
        goto L52
    L37:
        u1(r19, r2, r13);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r54 = fu0.b.a(r13);
        if (r54 == null) goto L47;
        long r55 = r54.o() - (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN));
        IntRange r56 = RangesKt.until(1, 86400);
        IntRange r110 = RangesKt.until(172801, 259200);
        IntRange r111 = RangesKt.until(518401, 604800);
        if (RangesKt.intRangeContains(r56, r55) == false) goto L43;
    L48:
        boolean r57 = true;
    L49:
        if (r57 == false) goto L52;
        t1(new s0());
        goto L52
    L43:
        if (RangesKt.intRangeContains(r110, r55) == true) goto L48;
        if (RangesKt.intRangeContains(r111, r55) == true) goto L48;
    L47:
        r57 = false;
        goto L49
    L21:
        if ((r3 instanceof eu0.r) == true) goto L26;
        if ((r3 instanceof f0) == true) goto L26;
        if ((r3 instanceof q) == false) goto L52;
        goto L26
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
