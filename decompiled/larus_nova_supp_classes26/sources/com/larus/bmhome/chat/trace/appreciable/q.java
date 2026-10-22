package com.larus.bmhome.chat.trace.appreciable;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public static final void a(JSONObject r3, CommonParamManager.CommonParam r4) {
        if (r4 == null) goto L16;
        Map<String, String> r5 = r4.getMessageTrackCommonTags();
        if (r5 == null) goto L22;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L23;
        Map.Entry<String, String> r0 = r6.next();
        String r1 = r0.getKey();
        String r2 = r0.getValue();
        if (r3 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == false) goto L7;
        r3.put(r1, r2);
        goto L7
    L11:
        if (r3.has(r1) == true) goto L13;
        r7 = true;
        goto L14
    L23:
        return;
    L22:
        return;
    }
}
