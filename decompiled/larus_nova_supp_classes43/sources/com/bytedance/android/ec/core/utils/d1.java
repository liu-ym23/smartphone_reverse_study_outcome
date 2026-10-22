package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d1 {
    public static ProductSelectPoiInfo a;
    public static SkuPoiInfo b;
    public static final a c = null;

    public static final class a implements ti.j {
        public a() {
        }

        public final void a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            if (a2.b(r10.optString("poi_name")) == true) goto L5;
            return;
        L5:
            if (a2.b(r10.optString("address")) == false) goto L9;
            ProductSelectPoiInfo r11 = new ProductSelectPoiInfo();
            r11.setPoiId(r10.optString("poi_id"));
            r11.setPoiName(r10.optString("poi_name"));
            r11.setDistance(Double.valueOf(r10.optDouble("distance")));
            r11.setDistanceDesc(r10.optString("distance_desc"));
            r11.setAddress(r10.optString("address"));
            r11.setPoiPhone(r10.optString("poi_phone"));
            r11.setParamsObj(z1.k(r10));
            d1.a = r11;
            s0.a(new hl.n(r11));
            return;
        }
    }

    static {
        c = new a();
    }
}
