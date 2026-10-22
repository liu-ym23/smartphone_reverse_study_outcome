package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a2<T> implements Observer {
    public final /* synthetic */ b2 a;

    public a2(b2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SpecItemOptimizeGroupLayout r0 = b2.d0(this.a);
        int r11 = ((Integer) r10).intValue();
        com.bytedance.android.ec.common.impl.sku.view.s r1 = (com.bytedance.android.ec.common.impl.sku.view.s) CollectionsKt.firstOrNull(r0.e);
        if (r1 == null) goto L6;
        r1.b(r11);
        return;
    }
}
