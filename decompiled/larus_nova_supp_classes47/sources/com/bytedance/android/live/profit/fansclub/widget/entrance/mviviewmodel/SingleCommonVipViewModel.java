package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.f0;
import eu0.k0;
import eu0.m0;
import eu0.q;
import eu0.u;
import eu0.y;
import eu0.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SingleCommonVipViewModel extends com.bytedance.android.anya.f<m0, k0, eu0.h> implements o {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public SingleCommonVipViewModel() {
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new k0();
    }

    public final void d(com.bytedance.android.anya.dsl.h<m0, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleCommonVipViewModel$bindToParent$1 r0 = SingleCommonVipViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public static void e1(l0 r3, k0 r4, DataCenter r5) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r6 = fu0.b.a(r5);
        if (r6 != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.base.model.user.j r7 = r6.g();
        if (r7 == null) goto L8;
        py.k r8 = r7.getSingleEntranceIcon();
    L9:
        if (r8 != null) goto L11;
        r8 = (py.k) vh7.f.c(py.k.class);
    L11:
        r r0 = r4.a;
        KProperty[] r1 = k0.c;
        KProperty r2 = r1[0];
        r0.getClass();
        Boolean r9 = Boolean.FALSE;
        r3.getClass();
        l0.h(r0, r9);
        r r10 = r4.b;
        KProperty r12 = r1[1];
        r10.getClass();
        l0.h(r10, r8);
        return;
    L8:
        r8 = null;
        goto L9
    }

    public final void y0(l0 r5, MVIState r6, p r7) {
        k0 r8 = (k0) r6;
        eu0.h r9 = (eu0.h) r7;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r8, "state");
        Intrinsics.checkNotNullParameter(r9, "action");
        if ((r9 instanceof eu0.k) == false) goto L6;
        e1(r5, r8, r9.a);
    L6:
        if ((r9 instanceof u) == false) goto L9;
        e1(r5, r8, r9.a);
    L9:
        if ((r9 instanceof y) == false) goto L11;
    L16:
        e1(r5, r8, r9.a);
    L17:
        String r1 = "";
        String r2 = null;
        if ((r9 instanceof z) == false) goto L35;
        r r10 = r8.a;
        KProperty r0 = k0.c[0];
        r10.getClass();
        r5.getClass();
        if (((Boolean) com.bytedance.android.anya.h.b(r10)).booleanValue() == false) goto L35;
        int r12 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.e(r9.a);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r13 = fu0.b.a(r9.a);
        if (r13 == null) goto L35;
        com.bytedance.android.live.base.model.user.j r14 = r13.g();
        if (r14 == null) goto L27;
        String r15 = r14.getSchema();
        if (r15 == null) goto L27;
    L29:
        if ((!StringsKt.isBlank(r15)) == true) goto L32;
        r15 = null;
    L32:
        if (r15 == null) goto L35;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(r13.getContext(), r15);
    L27:
        r15 = "";
    L35:
        if ((r9 instanceof eu0.a) == false) goto L50;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r16 = fu0.b.a(r9.a);
        if (r16 == null) goto L51;
        com.bytedance.android.live.base.model.user.j r17 = r16.g();
        if (r17 == null) goto L45;
        String r18 = r17.getSchema();
        if (r18 == null) goto L45;
        r1 = r18;
    L45:
        if ((!StringsKt.isBlank(r1)) == false) goto L47;
        r2 = r1;
    L47:
        if (r2 == null) goto L52;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(r16.getContext(), r2);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L11:
        if ((r9 instanceof eu0.r) == true) goto L16;
        if ((r9 instanceof f0) == true) goto L16;
        if ((r9 instanceof q) == false) goto L17;
        goto L16
    }
}
