package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.o;
import eu0.b0;
import eu0.c0;
import eu0.p0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TipMVIViewModel extends com.bytedance.android.anya.f<eu0.j, p0, eu0.h> implements o {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public TipMVIViewModel() {
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new p0();
    }

    public final void d(com.bytedance.android.anya.dsl.h<eu0.j, eu0.h> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        TipMVIViewModel$bindToParent$1 r0 = TipMVIViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, eu0.h.class));
    }

    public final void y0(l0 r5, MVIState r6, p r7) {
        p0 r8 = (p0) r6;
        eu0.h r9 = (eu0.h) r7;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r8, "state");
        Intrinsics.checkNotNullParameter(r9, "action");
        if ((r9 instanceof b0) == false) goto L6;
        r r0 = r8.a;
        KProperty[] r3 = p0.c;
        KProperty r2 = r3[0];
        r0.getClass();
        b0 r10 = (b0) r9;
        Boolean r4 = Boolean.valueOf(r10.b);
        r5.getClass();
        l0.h(r0, r4);
        r r12 = r8.b;
        KProperty r13 = r3[1];
        r12.getClass();
        l0.h(r12, r10.c);
        return;
    L6:
        if ((r9 instanceof c0) == false) goto L10;
        r r14 = r8.a;
        KProperty[] r1 = p0.c;
        KProperty r15 = r1[0];
        r14.getClass();
        Boolean r16 = Boolean.FALSE;
        r5.getClass();
        l0.h(r14, r16);
        r r17 = r8.b;
        KProperty r18 = r1[1];
        r17.getClass();
        l0.h(r17, new com.bytedance.android.live.profit.fansclub.widget.entrance.data.k("", ""));
        return;
    }
}
