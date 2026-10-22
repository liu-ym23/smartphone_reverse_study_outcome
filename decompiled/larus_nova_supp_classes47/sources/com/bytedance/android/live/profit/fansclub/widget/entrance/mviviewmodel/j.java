package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.l0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.h0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final void a(l0 r3, h0 r4, DataCenter r5) {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r6 = fu0.b.a(r5);
        if (r6 == null) goto L13;
        com.bytedance.android.live.base.model.user.j r7 = r6.g();
        if (r7 == null) goto L8;
        py.k r8 = r7.getDoubleEntranceIcon();
    L9:
        if (r8 != null) goto L11;
        r8 = (py.k) vh7.f.c(py.k.class);
    L11:
        r r0 = r4.a;
        KProperty[] r1 = h0.c;
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
}
