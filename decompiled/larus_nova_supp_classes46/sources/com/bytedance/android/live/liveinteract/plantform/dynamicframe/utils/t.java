package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements com.bytedance.android.livesdk.log.filter.v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final Map<String, Map<String, String>> b = null;
    public static final t c = null;

    public t() {
    }

    static {
        c = new t();
        a = new com.bytedance.android.livesdk.log.b("MultiLinkDynamicLogInjector", null);
        b = new LinkedHashMap();
    }

    public final void Rd() {
        a.a("added");
    }

    public final void onRemove() {
        a.a("removed");
    }

    public final void L9(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        Map<String, Map<String, String>> r0 = b;
        if (r0.containsKey(r3) == false) goto L10;
        Map r5 = (Map) ((LinkedHashMap) r0).get(r3);
        if (r5 == null) goto L12;
        Iterator r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r6.next();
        r4.put((String) r1.getKey(), (String) r1.getValue());
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
