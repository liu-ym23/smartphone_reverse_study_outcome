package com.bytedance.android.ec.common.impl.sku.view;

import android.view.View;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.model.sku.SkuParams;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ GroupTitleOptimizeLayout a;

    public a(GroupTitleOptimizeLayout r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        GroupTitleOptimizeLayout r12 = this.a;
        boolean r0 = !r12.l;
        r12.l = r0;
        if (r12.n != 0) goto L7;
        SkuViewModel r13 = r12.o;
        if (r13 == null) goto L7;
        r13.setCurrentSpecShowBigPicMode(r0);
    L7:
        this.a.b();
        GroupTitleOptimizeLayout r14 = this.a;
        s.b r1 = r14.k;
        if (r1 == null) goto L10;
        r1.a(r14.l);
    L10:
        GroupTitleOptimizeLayout r15 = this.a;
        if (r15.n != 0) goto L23;
        SkuViewModel r16 = r15.o;
        if (r16 == null) goto L19;
        SkuParams r17 = r16.getSkuParams();
        if (r17 == null) goto L19;
        String r18 = r17.getPromotionId();
        if (r18 == null) goto L19;
        com.bytedance.android.ec.common.impl.sku.utils.k.a r10 = com.bytedance.android.ec.common.impl.sku.utils.k.a;
        boolean r19 = this.a.l;
        Intrinsics.checkNotNullParameter(r18, "promotionId");
        com.bytedance.android.ec.common.impl.sku.utils.k.a.put(r18, new com.bytedance.android.ec.common.impl.sku.utils.l(r19, System.currentTimeMillis()));
    L19:
        SkuViewModel r20 = this.a.o;
        if (r20 == null) goto L24;
        SkuViewModel.doSkuEventAction$default(r20, "sku_panel_module_click", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "size_map_switch")}, null, null, null, 28, null);
        return;
    L24:
        return;
    }
}
