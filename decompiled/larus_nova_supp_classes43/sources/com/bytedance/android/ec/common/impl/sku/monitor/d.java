package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.core.monitor.k;
import com.bytedance.android.ec.model.sku.SkuParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public int a;

    public d(SkuParams r10) {
        Intrinsics.checkNotNullParameter(r10, "skuParams");
    }

    public final void a(boolean r10) {
        this.a++;
        if (r10 == false) goto L6;
        k.e("request_end");
        k.e("render_start");
        return;
    }
}
