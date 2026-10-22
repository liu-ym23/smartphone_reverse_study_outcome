package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n1<T> implements Observer {
    public final /* synthetic */ s1 a;

    public n1(s1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuInfoVO r11 = (SkuInfoVO) r10;
        s1 r0 = this.a;
        if (r11 == null) goto L5;
        SkuInstallmentItemInfo r12 = r11.getInstallmentInfo();
    L6:
        r0.h0(r12, true);
        return;
    L5:
        r12 = null;
        goto L6
    }
}
