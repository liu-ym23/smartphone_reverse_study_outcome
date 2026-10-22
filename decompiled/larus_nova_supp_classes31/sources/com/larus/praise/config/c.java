package com.larus.praise.config;

import com.bytedance.common.utility.NetworkClient;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements y57.d {
    public c() {
    }

    public final String a(String r8, Map r9) {
        if (r8 != null) goto L5;
        return null;
    L5:
        JSONObject r0 = new JSONObject();
        HashMap r10 = (HashMap) r9;
        Iterator r1 = r10.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) r1.next();
        r0.put(r2, r10.get(r2));
        goto L7
    L9:
        byte[] r3 = r0.toString().getBytes(Charset.forName("UTF-8"));
        return NetworkClient.getDefault().post(r8, r3, false, "application/json", true);
    }
}
