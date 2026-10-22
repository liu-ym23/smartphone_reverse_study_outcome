package com.bytedance.android.ec.core.mall;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MallGylUtil {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(MallGylUtil$config$2.INSTANCE);
    }

    public static String a() {
        String r0 = ((a) a.getValue()).b();
        if (r0 != null) goto L6;
        return "hybrid://lynxview?enable_code_cache=1&enable_js_runtime=true&surl=https%3A%2F%2Flf-ecom-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fecom%2Flynx%2Fecom_mall_cards_saas%2Fcards%2Fpage_card%2Ftemplate.js";
    L6:
        return r0;
    }

    public static String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        boolean r1 = true;
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        String r11 = ((a) a.getValue()).a();
        if (r11 != null) goto L12;
    L15:
        if (r1 == false) goto L17;
        r11 = "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/ecom/lynx/ecom_mall_cards_saas/config.json";
    L17:
        String r12 = r11;
        if (StringsKt.contains$default(r12, "config.json", false, 2, null) == true) goto L20;
        return null;
    L20:
        return StringsKt.replace$default(r12, "config.json", r10.concat("_config.json"), false, 4, null);
    L12:
        if (r11.length() == 0) goto L15;
        r1 = false;
        goto L15
    L5:
        r0 = false;
        goto L7
    }
}
