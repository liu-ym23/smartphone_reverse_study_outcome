package com.bytedance.android.annie.resource;

import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.Annie;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static AnnieGeckoClient a;

    static {
    }

    public static WebResourceResponse a(String r10) {
        AnnieGeckoClient r0 = a;
        if (r0 == null) goto L7;
        WebResourceResponse r1 = r0.d.a(null, r10);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return ((f9.b) Annie.getService$default(f9.b.class, null, 2, null)).interceptRequest(r10);
    }
}
