package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l2<T> implements Observer {
    public final /* synthetic */ m2 a;

    public l2(m2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuInfoVO r11 = (SkuInfoVO) r10;
        int r12 = jg.f.a;
        if (jg.f.a(m2.d0(this.a)) == false) goto L7;
        m2.d0(this.a).getLoadStatus().b(ECQuickUtilKt.a(this.a.Y()), new k2(this));
        return;
    }
}
