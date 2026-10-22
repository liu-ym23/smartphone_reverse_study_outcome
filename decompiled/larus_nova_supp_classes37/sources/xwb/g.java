package xwb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public g() {
    }

    public static void a(Object r6, String r7) {
        if ((r6 instanceof HashMap) == false) goto L22;
        Iterator r0 = ((HashMap) r6).keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L32;
        Object r2 = r0.next();
        Object r3 = ((Map) r6).get(r2);
        StringBuilder r4 = new StringBuilder();
        r4.append(r7);
        r4.append("key: ");
        r4.append(r2);
        r4.append("--value length: ");
        if (r3 != null) goto L10;
        int r5 = 0;
    L20:
        r4.append(r5);
        com.ss.android.lark.officesdk.utils.di.j.e("BridgeInfoPrinter", r4.toString());
        goto L6
    L10:
        if ((r3 instanceof String) == false) goto L13;
        r5 = ((String) r3).length();
        goto L20
    L13:
        if ((r3 instanceof JSONObject) == false) goto L16;
        r5 = ((JSONObject) r3).toString().length();
        goto L20
    L16:
        if ((r3 instanceof com.alibaba.fastjson.JSONObject) == false) goto L18;
        r5 = ((com.alibaba.fastjson.JSONObject) r3).toJSONString().length();
        goto L20
    L18:
        r5 = r3.toString().length();
        goto L20
    L32:
        return;
    L22:
        if ((r6 instanceof String) == false) goto L31;
        com.ss.android.lark.officesdk.utils.di.j.e("BridgeInfoPrinter", r7 + ((String) r6).length());
        return;
    }
}
