package com.bytedance.android.ec.common.impl.sku.view;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u implements OnPageSelectedListener {
    public final /* synthetic */ SkuViewModel a;

    public u(SkuViewModel r1) {
        this.a = r1;
    }

    public final void onPageSelected(int r10) {
        SkuViewModel.doSkuEventAction$default(this.a, "slide_product_big_picture", new Pair[0], null, null, null, 28, null);
    }
}
