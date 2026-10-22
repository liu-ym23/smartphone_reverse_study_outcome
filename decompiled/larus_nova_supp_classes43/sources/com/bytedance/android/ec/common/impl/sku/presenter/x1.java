package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x1<T> implements Observer {
    public final /* synthetic */ b2 a;

    public x1(b2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Integer r11 = (Integer) r10;
        Iterator r12 = ((ArrayList) b2.d0(this.a).e).iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        com.bytedance.android.ec.common.impl.sku.view.s r0 = (com.bytedance.android.ec.common.impl.sku.view.s) r12.next();
        com.bytedance.android.ec.common.impl.sku.view.s.c r1 = r0.e;
        if (r1 == null) goto L4;
        r0.c(r1.c);
        goto L4
    }
}
