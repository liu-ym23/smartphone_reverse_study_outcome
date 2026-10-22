package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.TradeModeSelection;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ ButtonOptimizePresenter a;

    public i(ButtonOptimizePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuInfoVO r11 = (SkuInfoVO) r10;
        ButtonOptimizePresenter r12 = this.a;
        SkuViewModel r0 = r12.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        Integer r1 = (Integer) r0.getCurrentTradeModeIndex().a();
        if (r1 == null) goto L8;
        int r13 = r1.intValue();
    L9:
        List<SkuBottomButtons> r14 = null;
        if (r13 <= 0) goto L18;
        SkuViewModel r15 = r12.f;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        TradeModeSelection r16 = (TradeModeSelection) r15.getCurrentTradeModeItem().a();
        if (r16 == null) goto L17;
        r14 = r16.getSkuBottomButtons();
    L17:
        r12.l0(r14);
    L25:
        this.a.r0();
        return;
    L18:
        SkuViewModel r17 = r12.f;
        if (r17 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        SkuInfoVO r18 = (SkuInfoVO) r17.getSkuInfo().a();
        if (r18 == null) goto L24;
        r14 = r18.getDefaultButtons();
    L24:
        r12.l0(r14);
        goto L25
    L8:
        r13 = 0;
        goto L9
    }
}
