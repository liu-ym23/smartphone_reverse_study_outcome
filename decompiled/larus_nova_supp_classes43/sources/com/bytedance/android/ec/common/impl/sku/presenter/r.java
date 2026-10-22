package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ ButtonPresenter a;

    public r(ButtonPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuInfoVO r11 = (SkuInfoVO) r10;
        ButtonPresenter r12 = this.a;
        SkuViewModel r0 = r12.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r1 = (SkuInfoVO) r0.getSkuInfo().a();
        if (r1 == null) goto L8;
        List<SkuBottomButtons> r13 = r1.getDefaultButtons();
    L9:
        r12.n0(r13);
        ButtonPresenter.i0(this.a);
        return;
    L8:
        r13 = null;
        goto L9
    }
}
