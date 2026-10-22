package swb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> String b(T r1) {
        if (r1 != 0) goto L6;
        return "";
    L6:
        if ((r1 instanceof JSONObject) == false) goto L10;
        return ((JSONObject) r1).toString();
    L10:
        if ((r1 instanceof org.json.JSONObject) == false) goto L14;
        return ((org.json.JSONObject) r1).toString();
    L14:
        return JSON.toJSONString(r1);
    }

    public static <T> String a(String r3, T r4) {
    L18:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("JsonUtils", "Combine requested contents fail : ", e);
        return null;
    L3:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        Object[] r1 = new Object[2];     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (r3.contains("(") == true) goto L13;
        if (r3.contains(")") == true) goto L13;
        r1[0] = r3;     // Catch: Exception -> L18
        r1[1] = b(r4);     // Catch: Exception -> L18
        return String.format("%s(%s)", r1).replace("\n", "\\n");
    L13:
        throw new IllegalArgumentException("function name can't contain brackets");     // Catch: Exception -> L18
    L15:
        throw new NullPointerException("function name must not be null");     // Catch: Exception -> L18
    L17:
        throw new IllegalArgumentException("js func empty !");     // Catch: Exception -> L18
    }
}
