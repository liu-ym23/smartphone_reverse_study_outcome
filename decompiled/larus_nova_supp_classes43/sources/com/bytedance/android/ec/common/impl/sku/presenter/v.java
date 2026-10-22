package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v {
    public static final boolean a(SkuItemInfoVO r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$hitSkuNewStyle");
        Integer r10 = r1.getDelayDescStyle();
        if (r10 != null) goto L6;
    L8:
        return false;
    L6:
        if (r10.intValue() != 1) goto L8;
        return true;
    }
}
