package com.bytedance.android.ec.common.impl.sku;

import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static SkuItemInfoVO a(SkuInfoVO r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "vo");
        Intrinsics.checkNotNullParameter(r11, "selectSkuId");
        Iterator<T> r12 = r10.getSkuList().values().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r0 = r12.next();
        if (Intrinsics.areEqual(((SkuItemInfoVO) r0).getId(), r11) == false) goto L4;
    L10:
        return (SkuItemInfoVO) r0;
    L8:
        r0 = null;
        goto L10
    }
}
