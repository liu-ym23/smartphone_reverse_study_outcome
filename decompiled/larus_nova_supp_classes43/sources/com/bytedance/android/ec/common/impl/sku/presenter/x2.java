package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x2<T> implements Observer {
    public final /* synthetic */ y2 a;

    public x2(y2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        ProductSelectPoiInfo r11 = (ProductSelectPoiInfo) r10;
        SkuViewModel r1 = this.a.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuViewModel.doSkuEventAction$default(r1, "change_offline_store", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "sku")}, null, null, null, 28, null);
        this.a.d0(r11);
    }
}
