package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.a0;
import eu0.c0;
import eu0.f0;
import eu0.m0;
import eu0.q;
import eu0.s;
import eu0.u;
import eu0.w;
import eu0.y;
import j40.k0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SingleEntranceMVIViewModel extends com.bytedance.android.anya.g<eu0.j, m0, eu0.h> implements o {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new m0();
    }

    public final boolean L0(p r2) {
        Intrinsics.checkNotNullParameter((eu0.h) r2, "action");
        return true;
    }

    public final void d(com.bytedance.android.anya.dsl.h<eu0.j, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleEntranceMVIViewModel$bindToParent$1 r0 = SingleEntranceMVIViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public SingleEntranceMVIViewModel(SingleLiveFansClubMVIViewModel r3, SingleEcomFansClubMVIViewModel r4, SingleVipMVIViewModel r5, SingleCommonVipViewModel r6) {
        Intrinsics.checkNotNullParameter(r3, "liveFansClubVM");
        Intrinsics.checkNotNullParameter(r4, "ecomFansClubVM");
        Intrinsics.checkNotNullParameter(r5, "vipVM");
        Intrinsics.checkNotNullParameter(r6, "commonVipVM");
        super(CollectionsKt.listOf(new Object[]{r3, r4, r5, r6}));
    }

    public final void s1(final l0 r8, MVIState r9, p r10, Function1 r12) {
        final m0 r13 = (m0) r9;
        eu0.h r14 = (eu0.h) r10;
        Intrinsics.checkNotNullParameter(r8, "$this$reduce");
        Intrinsics.checkNotNullParameter(r13, "state");
        Intrinsics.checkNotNullParameter(r14, "action");
        Intrinsics.checkNotNullParameter(r12, "dispatchReduce");
        boolean r0 = r14 instanceof eu0.k;
        if (r0 == false) goto L5;
    L14:
        final com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r2 = fu0.b.a(r14.a);
        if (r2 != null) goto L18;
    L35:
        if ((r14 instanceof c0) == false) goto L38;
        r0<m0, Boolean> r3 = r13.getShow();
        Boolean r4 = Boolean.FALSE;
        r8.getClass();
        l0.h(r3, r4);
    L38:
        if ((r14 instanceof a0) == false) goto L48;
        DataCenter r5 = r14.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r6 = fu0.b.a(r5);
        if (r6 == null) goto L48;
        if (r6.c() == true) goto L48;
        if (r6.x() == true) goto L48;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).Sc(r5);
    L48:
        if ((r14 instanceof u) == false) goto L53;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r7 = fu0.b.a(r14.a);
        if (r7 == null) goto L62;
        r0<m0, Boolean> r15 = r13.getShow();
        Boolean r16 = Boolean.valueOf(!r7.E());
        r8.getClass();
        l0.h(r15, r16);
        goto L53
    L62:
        return;
    L53:
        r0<m0, Boolean> r17 = r13.getShow();
        r8.getClass();
        if (((Boolean) com.bytedance.android.anya.h.b(r17)).booleanValue() == true) goto L56;
        if (r0 == true) goto L56;
    L58:
        if ((r14 instanceof s) == false) goto L61;
        r r18 = r13.b;
        KProperty r19 = m0.g[1];
        r18.getClass();
        l0.h(r18, com.bytedance.android.anya.h.b(r13.getShow()));
        return;
    L61:
        return;
    L56:
        r12.invoke(r14);
        goto L58
    L18:
        if (com.bytedance.android.live.profit.fansclub.i.c() == false) goto L20;
        r2.J(r2.getRoom().getOwner(), "SingleEntranceMVIViewModel", true, new SingleEntranceMVIViewModel$initState$1(r8, r2, r13));
        goto L35
    L20:
        boolean r20 = false;
        if (r2.I() == true) goto L23;
    L25:
        boolean r22 = false;
    L26:
        r0<m0, Boolean> r23 = r13.getShow();
        if (((Boolean) k0.a.getValue()).booleanValue() == true) goto L30;
        r20 = r22;
    L33:
        Boolean r24 = Boolean.valueOf(r20);
        r8.getClass();
        l0.h(r23, r24);
        goto L35
    L30:
        if (r2.A() == true) goto L33;
        if (r22 == false) goto L33;
        r20 = true;
        goto L33
    L23:
        if (r2.E() == true) goto L25;
        r22 = true;
        goto L26
    L5:
        if ((r14 instanceof w) == true) goto L14;
        if ((r14 instanceof y) == true) goto L14;
        if ((r14 instanceof eu0.r) == true) goto L14;
        if ((r14 instanceof f0) == true) goto L14;
        if ((r14 instanceof q) == false) goto L35;
        goto L14
    }
}
