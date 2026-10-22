package com.bytedance.android.ec.core.monitor;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "orderUrl");
        Intrinsics.checkNotNullParameter("enter_order_detail", "scene");
        Intrinsics.checkNotNullParameter(r11, "packLogId");
        Intrinsics.checkNotNullParameter(r12, "skuLogId");
        boolean r13 = false;
        JSONObject r14 = null;
        if (StringsKt.contains$default(r10, "fe_lynx_commerce_buynow", false, 2, null) == true) goto L10;
        if (StringsKt.contains$default(r10, "ecommerce_buynow_aweme", false, 2, null) == true) goto L10;
        if (StringsKt.contains$default(r10, "ecommerce_buynow_huoshan", false, 2, null) == true) goto L10;
        return;
    L10:
        if (a2.b(r10) == false) goto L39;
        Uri r0 = UriProtector.parse(r10);
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r0, "is_cart_order"), "1") == false) goto L14;
        return;
    L14:
        String r15 = UriProtector.getQueryParameter(r0, com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT);
        if (r15 == null) goto L18;
        HashMap<String, JSONObject> r16 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        r14 = com.bytedance.android.ec.core.hybrid.utils.j.i(r15);
    L18:
        if (r14 != null) goto L20;
    L21:
        UriProtector.getQueryParameter(r0, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L22:
        if (r14 == null) goto L25;
        String r17 = r14.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r17 == null) goto L25;
    L26:
        if (r14 == null) goto L29;
        String r18 = r14.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r18 == null) goto L29;
    L30:
        JSONObject r1 = new JSONObject();
        r1.put("pack_log_id", r11);
        r1.put("sku_log_id", r12);
        r1.put("order_schema", r10);
        int r19 = l.a;
        l.b(r10, "enter_order_detail", r1, CollectionsKt.listOf(new l.a[]{new l.a("id", "presence"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, "is_json_string"), new l.a(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, "presence"), new l.a("combo_num", "valid_number"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE, "presence"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID, "presence")}));
        if (a2.b(r17) == false) goto L40;
        if (r18 != null) goto L34;
    L35:
        r13 = true;
    L36:
        if (r13 == false) goto L41;
        int r20 = d.a;
        d.d("dependency_cid_log_extra", "extra", "cid非空时log_extra字段为空", "enter_order_detail", r1);
        return;
    L41:
        return;
    L34:
        if (r18.length() != 0) goto L36;
    L40:
        return;
    L29:
        r18 = UriProtector.getQueryParameter(r0, com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA);
    L25:
        r17 = UriProtector.getQueryParameter(r0, com.bytedance.android.ec.core.event.a.KEY_CID);
        goto L26
    L20:
        if (r14.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) != null) goto L22;
    }
}
