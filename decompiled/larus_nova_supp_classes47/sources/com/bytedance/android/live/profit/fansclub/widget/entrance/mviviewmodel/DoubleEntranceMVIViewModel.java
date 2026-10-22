package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.scope.o;
import eu0.c0;
import eu0.f0;
import eu0.q;
import eu0.s;
import eu0.u;
import eu0.w;
import eu0.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleEntranceMVIViewModel extends com.bytedance.android.anya.g<eu0.j, eu0.f, eu0.h> implements o {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new eu0.f();
    }

    public final boolean L0(p r2) {
        Intrinsics.checkNotNullParameter((eu0.h) r2, "action");
        return true;
    }

    public final void d(com.bytedance.android.anya.dsl.h<eu0.j, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        DoubleEntranceMVIViewModel$bindToParent$1 r0 = DoubleEntranceMVIViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public DoubleEntranceMVIViewModel(LeftLiveFansClubMVIViewModel r3, LeftEcomFansClubMVIViewModel r4, RightVipMVIViewModel r5, RightCommonVipViewModel r6) {
        Intrinsics.checkNotNullParameter(r3, "leftLiveFansClubVM");
        Intrinsics.checkNotNullParameter(r4, "leftEcomFansClubVM");
        Intrinsics.checkNotNullParameter(r5, "rightVipVM");
        Intrinsics.checkNotNullParameter(r6, "commonRightVipVM");
        super(CollectionsKt.listOf(new Object[]{r3, r4, r5, r6}));
    }

    public final void s1(final l0 r7, MVIState r8, p r9, Function1 r10) {
        final eu0.f r12 = (eu0.f) r8;
        eu0.h r13 = (eu0.h) r9;
        Intrinsics.checkNotNullParameter(r7, "$this$reduce");
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r13, "action");
        Intrinsics.checkNotNullParameter(r10, "dispatchReduce");
        boolean r0 = r13 instanceof eu0.k;
        if (r0 == false) goto L5;
    L14:
        final com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r2 = fu0.b.a(r13.a);
        if (r2 != null) goto L18;
    L28:
        if ((r13 instanceof c0) == false) goto L31;
        r0<eu0.f, Boolean> r3 = r12.getShow();
        Boolean r4 = Boolean.FALSE;
        r7.getClass();
        l0.h(r3, r4);
    L31:
        if ((r13 instanceof u) == false) goto L36;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r5 = fu0.b.a(r13.a);
        if (r5 == null) goto L45;
        r0<eu0.f, Boolean> r6 = r12.getShow();
        Boolean r14 = Boolean.valueOf(r5.E());
        r7.getClass();
        l0.h(r6, r14);
        goto L36
    L45:
        return;
    L36:
        r0<eu0.f, Boolean> r15 = r12.getShow();
        r7.getClass();
        if (((Boolean) com.bytedance.android.anya.h.b(r15)).booleanValue() == true) goto L39;
        if (r0 == true) goto L39;
    L41:
        if ((r13 instanceof s) == false) goto L44;
        r r16 = r12.b;
        KProperty r17 = eu0.f.g[1];
        r16.getClass();
        l0.h(r16, com.bytedance.android.anya.h.b(r12.getShow()));
        return;
    L44:
        return;
    L39:
        r10.invoke(r13);
        goto L41
    L18:
        if (com.bytedance.android.live.profit.fansclub.i.c() == false) goto L20;
        r2.J(r2.getRoom().getOwner(), "DoubleEntranceMVIViewModel", true, new DoubleEntranceMVIViewModel$initState$1(r7, r12, r2));
        goto L28
    L20:
        r0<eu0.f, Boolean> r18 = r12.getShow();
        if (r2.I() == true) goto L23;
    L25:
        boolean r19 = false;
    L26:
        Boolean r20 = Boolean.valueOf(r19);
        r7.getClass();
        l0.h(r18, r20);
        goto L28
    L23:
        if (r2.E() == false) goto L25;
        r19 = true;
        goto L26
    L5:
        if ((r13 instanceof w) == true) goto L14;
        if ((r13 instanceof y) == true) goto L14;
        if ((r13 instanceof eu0.r) == true) goto L14;
        if ((r13 instanceof f0) == true) goto L14;
        if ((r13 instanceof q) == false) goto L28;
        goto L14
    }
}
