package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o0<T> implements Observer {
    public final /* synthetic */ s0 a;

    public o0(s0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r19) {
        SkuInfoVO r1 = (SkuInfoVO) r19;
        DisplayConfig r10 = r1.getDisplayConfig();
        if (r10 == null) goto L5;
        Boolean r11 = r10.getShowPrice();
    L7:
        if (Intrinsics.areEqual(r11, Boolean.FALSE) == false) goto L9;
        this.a.Z().b(2131384715).f().setVisibility(4);
    L10:
        final s0 r12 = this.a;
        DisplayConfig r13 = r1.getDisplayConfig();
        if (r13 == null) goto L13;
        Boolean r14 = r13.getShowDetailEnter();
    L15:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L32;
        SkuViewModel r15 = r12.f;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        if (cg4.a.a(r15.getSkuParams().getDetailUrl()) == false) goto L32;
        if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L24;
    L27:
        final View r16 = r12.Z().b(2131376614).f();
    L28:
        r16.setVisibility(0);
        com.bytedance.android.ec.core.widget.f.c(r16, null, null, new HeaderOptimizePresenter$showDetailEnter$$inlined$apply$lambda$1(r16, r12), 3);
        SkuViewModel r17 = r12.f;
        if (r17 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        SkuViewModel.doSkuEventAction$default(r17, "sku_panel_module_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "product_detail_entrance")}, null, null, null, 28, null);
    L33:
        r12.k0();
        int r18 = qf.a.a;
        if (qf.a.e.a(s0.e0(this.a).getSkuParams()) == true) goto L37;
        s0.h0(this.a);
        com.bytedance.android.ec.core.utils.y.d(this.a.Z().b(2131385283).f(), r1.getCover());
        return;
    L37:
        return;
    L24:
        if (com.bytedance.android.ec.core.abtest.d.F() == 2) goto L27;
        r16 = r12.Z().b(2131378870).f();
    L32:
        r12.Z().b(2131376614).f().setVisibility(8);
        r12.Z().b(2131378870).f().setVisibility(8);
        goto L33
    L13:
        r14 = null;
        goto L15
    L9:
        this.a.Z().b(2131384715).f().setVisibility(0);
        goto L10
    L5:
        r11 = null;
        goto L7
    }
}
