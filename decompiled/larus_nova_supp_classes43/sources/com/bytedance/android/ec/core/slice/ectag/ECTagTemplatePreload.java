package com.bytedance.android.ec.core.slice.ectag;

import android.content.Context;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.forest.Forest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECTagTemplatePreload {
    public static volatile boolean a;
    public static final List<Map<String, String>> b = null;

    static {
        List r0 = CollectionsKt.listOf(new String[]{"bgc_text", "border_image_text", "border_image_text_splitter_text", "border_image_text_splitter_text_v2", "border_splitter_text", "border_splitter_text_v2", "border_splitter_text_v3", "border_text", "border_text_v2", "image", "image_bgc_text", "image_bgc_text_v2", "image_bgc_text_v3", "image_bgc_text_v4", "image_only_text", "image_only_text_splitter", "image_text_splitter_border", "image_text_splitter_border_v2", "live_border_splitter_text", "live_image_only_text_splitter", "only_text", "only_text_splitter"});
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r10 = r0.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r11 = (String) r10.next();
        r1.add(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r11), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/etag_template/" + r11 + "/main.json")}));
        goto L4
    L6:
        b = r1;
    }

    public static void a(Context r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        dm.a.a("ECTagTemplatePreload").i("start preload,hasPreload:" + a);
        if (a == false) goto L5;
        return;
    L5:
        SlcGeckoTemplateMgr r0 = SlcGeckoTemplateMgr.l;
        Forest r12 = wh.a.b(r10);
        if (r11 == false) goto L8;
        ECTagTemplatePreload$preload$1 r13 = null;
    L9:
        SlcGeckoTemplateMgr.f(r0, "native_ectag", "etag_template", r12, r13);
        a = true;
        return;
    L8:
        r13 = ECTagTemplatePreload$preload$1.INSTANCE;
        goto L9
    }
}
