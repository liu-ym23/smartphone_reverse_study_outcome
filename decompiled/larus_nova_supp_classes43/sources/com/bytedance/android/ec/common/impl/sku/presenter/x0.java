package com.bytedance.android.ec.common.impl.sku.presenter;

import android.text.TextUtils;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x0<T> implements Observer {
    public final /* synthetic */ f1 a;

    public x0(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        String r11 = (String) r10;
        if (TextUtils.isEmpty(r11) == false) goto L9;
        GenericDraweeView r12 = this.a.Z().b(2131385283).f();
        SkuInfoVO r0 = (SkuInfoVO) f1.e0(this.a).getSkuInfo().a();
        if (r0 == null) goto L7;
        String r1 = r0.getCover();
    L8:
        com.bytedance.android.ec.core.utils.y.d(r12, r1);
        return;
    L7:
        r1 = null;
        goto L8
    L9:
        com.bytedance.android.ec.core.utils.y.d(this.a.Z().b(2131385283).f(), r11);
    }
}
