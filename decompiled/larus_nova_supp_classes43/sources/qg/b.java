package qg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final List<Map<String, Object>> a = null;
    public static final Map<String, Integer> b = null;

    static {
        int r12 = 3;
        List r0 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("collection_card", 6), TuplesKt.to("collection_footer", 1), TuplesKt.to("collection_header", 1), TuplesKt.to("collection_sort_panel", 1), TuplesKt.to("collection_empty", 0), TuplesKt.to("collection_max_notice", 0)});
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Pair r15 = (Pair) r1.next();
        Pair[] r10 = new Pair[r12];
        r10[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r15.getFirst());
        r10[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_collect_card_template/" + ((String) r15.getFirst()) + "/main.json");
        r10[2] = TuplesKt.to("num", r15.getSecond());
        r14.add(MapsKt.mapOf(r10));
        r12 = 3;
        goto L4
    L6:
        a = r14;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("collection_card", 6);
        r11.put("collection_footer", 1);
        r11.put("collection_header", 1);
        r11.put("collection_sort_panel", 1);
        r11.put("collection_empty", 0);
        r11.put("collection_max_notice", 0);
        b = MapsKt.toMap(r11);
    }
}
