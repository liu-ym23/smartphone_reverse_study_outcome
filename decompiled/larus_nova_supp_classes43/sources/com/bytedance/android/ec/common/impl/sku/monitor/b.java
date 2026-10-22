package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public int a;
    public final SkuParams b;

    public b(SkuParams r10) {
        Intrinsics.checkNotNullParameter(r10, "skuParams");
        this.b = r10;
        Map<String, com.bytedance.android.ec.core.monitor.a> r0 = com.bytedance.android.ec.core.monitor.c.a;
        String r1 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_SKU_PANEL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r1, "sku_from", r10.getMethod());
        String r11 = r10.getRoomId();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        com.bytedance.android.ec.core.monitor.c.f(r1, com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r11);
        String r12 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r10.getMethod(), new String[]{"_"}, false, 0, 6, null));
        if (r12 == null) goto L10;
        String r13 = a2.d(r12);
        if (r13 == null) goto L10;
        com.bytedance.android.ec.core.monitor.c.e(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, r13);
    L10:
        r10.setMonitorId(r1);
    }

    public final void a(boolean r10) {
        this.a++;
        if (r10 == false) goto L6;
        Map<String, com.bytedance.android.ec.core.monitor.a> r11 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(this.b.getMonitorId(), MetricNames.API_DURATION);
        return;
    }
}
