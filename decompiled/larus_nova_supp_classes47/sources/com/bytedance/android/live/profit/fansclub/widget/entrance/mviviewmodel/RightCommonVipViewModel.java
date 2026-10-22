package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.o;
import eu0.f0;
import eu0.h0;
import eu0.q;
import eu0.r;
import eu0.u;
import eu0.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RightCommonVipViewModel extends com.bytedance.android.anya.f<eu0.f, h0, eu0.h> implements o {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public RightCommonVipViewModel() {
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new h0();
    }

    public final void d(com.bytedance.android.anya.dsl.h<eu0.f, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        RightCommonVipViewModel$bindToParent$1 r0 = RightCommonVipViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public final void y0(l0 r2, MVIState r3, p r4) {
        h0 r5 = (h0) r3;
        eu0.h r6 = (eu0.h) r4;
        Intrinsics.checkNotNullParameter(r2, "$this$reduce");
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r6, "action");
        if ((r6 instanceof eu0.k) == false) goto L6;
        j.a(r2, r5, r6.a);
    L6:
        if ((r6 instanceof u) == false) goto L9;
        j.a(r2, r5, r6.a);
    L9:
        if ((r6 instanceof y) == false) goto L11;
    L16:
        j.a(r2, r5, r6.a);
    L18:
        if ((r6 instanceof eu0.a) == false) goto L33;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r7 = fu0.b.a(r6.a);
        if (r7 == null) goto L34;
        com.bytedance.android.live.base.model.user.j r8 = r7.g();
        if (r8 == null) goto L25;
        String r9 = r8.getSchema();
        if (r9 == null) goto L25;
    L27:
        if ((!StringsKt.isBlank(r9)) == true) goto L30;
        r9 = null;
    L30:
        if (r9 == null) goto L35;
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(r7.getContext(), r9);
        return;
    L35:
        return;
    L25:
        r9 = "";
        goto L27
    L34:
        return;
    L33:
        return;
    L11:
        if ((r6 instanceof r) == true) goto L16;
        if ((r6 instanceof f0) == true) goto L16;
        if ((r6 instanceof q) == false) goto L18;
        goto L16
    }
}
