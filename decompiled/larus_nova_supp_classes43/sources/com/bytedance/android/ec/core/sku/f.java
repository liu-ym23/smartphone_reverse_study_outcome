package com.bytedance.android.ec.core.sku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final List<Map<String, Object>> a = null;

    static {
        List r0 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("sku_specs", 1), TuplesKt.to("sku_count_stepper", 1), TuplesKt.to("sku_bottom_button", 1), TuplesKt.to("sku_base_info", 1), TuplesKt.to("sku_empty_line", 3), TuplesKt.to("sku_hint_bar", 1), TuplesKt.to("sku_poi_store", 1), TuplesKt.to("sku_top_banner", 1), TuplesKt.to("sku_car_adapter", 1), TuplesKt.to("sku_trade_mode", 1), TuplesKt.to("sku_dou_installment", 1)});
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Pair r11 = (Pair) r1.next();
        r10.add(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r11.getFirst()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_sku_pannel_template/" + ((String) r11.getFirst()) + "/main.json"), TuplesKt.to("num", r11.getSecond())}));
        goto L4
    L6:
        a = r10;
    }
}
