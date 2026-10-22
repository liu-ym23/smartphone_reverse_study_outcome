package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.core.data.LoadingStatus;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k2<T> implements Observer {
    public final /* synthetic */ l2 a;

    public k2(l2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        if (((rg.b) r10).a != LoadingStatus.SUCCESS) goto L6;
        int r11 = com.bytedance.android.ec.common.impl.sku.utils.p.a;
        com.bytedance.android.ec.common.impl.sku.utils.p.d(m2.d0(this.a.a), this.a.a.Y());
        return;
    }
}
