package rh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final List<Map<String, Object>> a = null;

    static {
        List r0 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("product_line", 3), TuplesKt.to("extend_line_normal", 3), TuplesKt.to("product_line_fold_status_desc", 3), TuplesKt.to("order_list_head_bg", 1), TuplesKt.to("people_line", 3), TuplesKt.to("price_line", 3), TuplesKt.to("guess_you_like_title", 1), TuplesKt.to("button_line", 3), TuplesKt.to("product_line_more", 3), TuplesKt.to("order_list_tabbar", 1), TuplesKt.to("often_buy_shop", 1), TuplesKt.to("order_list_node_empty", 1), TuplesKt.to("newer_coupon", 0), TuplesKt.to("default_empty", 1), TuplesKt.to("shop_line", 3), TuplesKt.to("order_list_head_search", 1)});
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Pair r11 = (Pair) r1.next();
        r10.add(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r11.getFirst()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecommerce_order_list_component/" + ((String) r11.getFirst()) + "/main.json"), TuplesKt.to("num", r11.getSecond())}));
        goto L4
    L6:
        a = r10;
    }
}
