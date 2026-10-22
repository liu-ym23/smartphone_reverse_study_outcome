package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q0<T> implements Observer {
    public final /* synthetic */ s0 a;

    public q0(s0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Integer r11 = (Integer) r10;
        s0 r0 = this.a;
        r0.getClass();
        if (r11 != null) goto L6;
    L10:
        Integer r12 = com.bytedance.android.ec.core.utils.s.b("#FF3B52");
        if (r12 == null) goto L16;
        int r13 = r12.intValue();
        r0.j0(r13);
        r0.l0(r13);
        return;
    L16:
        return;
    L6:
        if (r11.intValue() != 2) goto L10;
        Integer r14 = com.bytedance.android.ec.core.utils.s.b("#9E2DF5");
        if (r14 == null) goto L14;
        int r15 = r14.intValue();
        r0.j0(r15);
        r0.l0(r15);
        return;
    }
}
