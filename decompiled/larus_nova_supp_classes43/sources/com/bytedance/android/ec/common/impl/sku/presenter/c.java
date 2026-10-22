package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuBannerStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        SkuInfoVO r12 = (SkuInfoVO) r11;
        if (r12 == null) goto L11;
        SkuBannerStruct r13 = r12.getSkuBanner();
        if (r13 == null) goto L12;
        SkuViewModel r1 = this.a.f;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        SkuViewModel.doSkuEventAction$default(r1, "comment_key_word_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, "product_params_detail"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WORD_NAME, r13.getTitle())}, null, null, null, 28, null);
        this.a.a0().setVisibility(0);
        com.bytedance.android.ec.core.utils.y.a(this.a.Z().b(2131386830).f(), r13.getIcon());
        ((TextView) this.a.Z().b(2131386831).f()).setText(r13.getTitle());
        ((TextView) this.a.Z().b(2131386829).f()).setText(r13.getDesc());
        this.a.a0().setOnClickListener(new b(r13, this));
        return;
    L12:
        return;
    }
}
