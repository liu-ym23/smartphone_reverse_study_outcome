package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a3<T> implements Observer {
    public final /* synthetic */ d3 a;

    public a3(d3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        rg.a r11 = (rg.a) r10;
        SkuViewModel r12 = this.a.f;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r13 = (SkuInfoVO) r12.getSkuInfo().a();
        SkuViewModel r1 = this.a.f;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        rg.a r0 = (rg.a) r1.getOnItemChange().a();
        Boolean r14 = null;
        if (r0 == null) goto L11;
        String r15 = (String) r0.b;
    L12:
        if (r13 == null) goto L16;
        Map<String, SkuItemInfoVO> r16 = r13.getSkuList();
        if (r16 == null) goto L16;
        SkuItemInfoVO r17 = r16.get(r15);
    L17:
        if (r17 == null) goto L20;
        r14 = r17.getHideTradeIn();
    L20:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L22;
        this.a.Y().d().q(dg.u.class, 8);
        return;
    L22:
        this.a.Y().d().q(dg.u.class, 0);
        return;
    L16:
        r17 = null;
        goto L17
    L11:
        r15 = null;
        goto L12
    }
}
