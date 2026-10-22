package com.bytedance.android.bcm.impl2;

import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.util.f;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ScopedBcmRecorder {
    public static final Map<String, ScopedBcmContent> a = null;
    public static final Map<f<PageInfo>, ScopedBcmContent> b = null;

    static {
        LinkedHashMap<String, ScopedBcmContent> r0 = new ScopedBcmRecorder$btmMap$1();
        LinkedHashMap<f<PageInfo>, ScopedBcmContent> r1 = new ScopedBcmRecorder$pageInfoMap$1();
        a = Collections.synchronizedMap(r0);
        b = Collections.synchronizedMap(r1);
    }

    public static ScopedBcmContent a(PageInfo r10) {
        Map<f<PageInfo>, ScopedBcmContent> r0 = b;
        f<PageInfo> r1 = new f(r10);
        ScopedBcmContent r11 = r0.get(r1);
        if (r11 != null) goto L6;
        r11 = new ScopedBcmContent();
        r0.put(r1, r11);
    L6:
        return r11;
    }
}
