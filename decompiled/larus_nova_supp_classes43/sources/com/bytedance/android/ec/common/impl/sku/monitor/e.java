package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.core.monitor.k;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public int a;
    public final SkuParams b;

    public e(SkuParams r10) {
        Intrinsics.checkNotNullParameter(r10, "skuParams");
        this.b = r10;
    }

    public final void a(boolean r10) {
        int r0 = this.a + 1;
        this.a = r0;
        if (r0 <= 1) goto L5;
        return;
    L5:
        if (r10 == true) goto L8;
        Map r11 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STATUS, "1")});
        r11.putAll(z1.j(this.b.asJsonDescription()));
        Map<String, String> r1 = k.a;
        k.c(com.bytedance.android.ec.hybrid.list.util.k.b(r11));
        return;
    }
}
