package com.bytedance.android.ec.common.impl.sku.view;

import android.view.View;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.model.sku.TradeModeSelection;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ j a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TradeModeSelection c;

    public i(j r1, int r10, TradeModeSelection r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        this.a.f.getCurrentTradeModeIndex().g(Integer.valueOf(this.b));
        com.bytedance.android.ec.common.impl.sku.utils.q.a r11 = com.bytedance.android.ec.common.impl.sku.utils.q.a;
        String r12 = this.a.f.getSkuParams().getPromotionId();
        int r0 = this.b;
        Intrinsics.checkNotNullParameter(r12, "promotionId");
        com.bytedance.android.ec.common.impl.sku.utils.q.a.put(r12, new com.bytedance.android.ec.common.impl.sku.utils.r(r0, System.currentTimeMillis()));
        Integer r13 = this.c.getType();
        if (r13 != null) goto L6;
        return;
    L6:
        if (r13.intValue() != 2) goto L9;
        SkuViewModel.doSkuEventAction$default(this.a.f, "click_product_trade_in", new Pair[]{TuplesKt.to("trade_in_page", "sku"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, this.a.f.getSkuParams().getProductId()), TuplesKt.to("trade_benefit_id", this.a.f.getTradeBenefitId()), TuplesKt.to("trade_benefit_text", this.a.f.getTradeBenefitText())}, null, null, null, 28, null);
        return;
    }
}
