package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b1 {
    public final String a;
    public final Map<String, String> b;

    public b1() {
        this.a = "PreviewSourcePayLoadContent[" + hashCode() + ']';
        this.b = new LinkedHashMap();
    }

    public final Object a(Class r4) {
        Intrinsics.checkNotNullParameter("star_order_id", "key");
        Intrinsics.checkNotNullParameter(r4, "clazz");
        String r0 = (String) ((LinkedHashMap) this.b).get("star_order_id");
        if (r0 != null) goto L6;
        ALogger.d(this.a, "return default value for key:star_order_id, value:,caz null content");
        return "";
    L6:
        Object r5 = GsonProtectorUtils.fromJson(GsonHelper.get(), r0, r4);
        if (r5 != null) goto L10;
        ALogger.d(this.a, "return default value for key:star_order_id, value:,caz null value");
        return "";
    L10:
        return r5;
    }
}
