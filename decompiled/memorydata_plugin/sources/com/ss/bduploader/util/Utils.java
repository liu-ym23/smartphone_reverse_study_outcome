package com.ss.bduploader.util;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Utils {
    public Utils() {
    }

    public static String mapToString(Map<String, Object> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L15;
        return null;
    L15:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L14
        Iterator r3 = r8.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r3.hasNext() == false) goto L12;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        Object r5 = r8.get(r4);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r2.put(r4, r5);     // Catch: Exception -> L14
        goto L7
    L12:
        return r2.toString();
    L14:
        return null;
    }
}
