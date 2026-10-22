package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v1<T> implements Observer {
    public final /* synthetic */ b2 a;

    public v1(b2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Long r11 = (Long) r10;
        if (r11 == null) goto L8;
        r11.longValue();
        SkuRestoreState r0 = b2.e0(this.a).getSkuPanelState();
        if (r0 == null) goto L9;
        r0.setProductCount(r11.longValue());
        return;
    L9:
        return;
    }
}
