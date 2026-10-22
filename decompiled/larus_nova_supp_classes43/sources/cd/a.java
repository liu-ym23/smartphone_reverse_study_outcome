package cd;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final <K, V> JSONObject a(Map<K, ? extends V> r1) {
        return new JSONObject(r1);
    L5:
        return new JSONObject();
    }

    public static final String b(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == false) goto L12;
        return null;
    L12:
        List r12 = StringsKt.split$default(r10, new String[]{"."}, false, 0, 6, null);
        if (r12.size() >= 2) goto L16;
        return null;
    L16:
        return ((String) ListProtector.get(r12, 0)) + "." + ((String) ListProtector.get(r12, 1)) + ".c0.d0";
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L10
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "DO NOT USE", replaceWith = @ReplaceWith(expression = "buildJSONObject", imports = {}))
    public static final <K, V> JSONObject c(Map<K, ? extends V> r10) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<K, ? extends V>> r11 = r10.entrySet().iterator();     // Catch: Throwable -> L14
    L5:
        if (r11.hasNext() == false) goto L13;
        Map.Entry<K, ? extends V> r1 = r11.next();     // Catch: Throwable -> L14
        K r12 = r1.getKey();     // Catch: Throwable -> L14
        if ((r12 instanceof String) == true) goto L9;
        r12 = (K) null;
    L9:
        String r13 = r12;     // Catch: Throwable -> L14
        if (r13 == null) goto L5;
        r0.put(r13, r1.getValue());     // Catch: Throwable -> L14
    L13:
        return r0;
    }

    public static final List<Object> d(JSONArray r10) {
        ArrayList r0 = new ArrayList();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L12;
        Object r12 = r10.get(r11);     // Catch: Exception -> L13
        if ((r12 instanceof JSONArray) == false) goto L8;
        r12 = d((JSONArray) r12);     // Catch: Exception -> L13
    L10:
        r0.add(r12);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r12 instanceof JSONObject) == false) goto L10;
        r12 = e((JSONObject) r12);     // Catch: Exception -> L13
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        return r0;
    }

    public static final Map<String, Object> e(JSONObject r10) {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L14;
        String r11 = r1.next();     // Catch: Exception -> L13
        Object r12 = r10.get(r11);     // Catch: Exception -> L13
        if ((r12 instanceof JSONArray) == false) goto L9;
        r12 = d((JSONArray) r12);     // Catch: Exception -> L13
    L11:
        r0.put(r11, r12);     // Catch: Exception -> L13
        goto L4
    L9:
        if ((r12 instanceof JSONObject) == false) goto L11;
        r12 = e((JSONObject) r12);     // Catch: Exception -> L13
        goto L11
    L14:
        return r0;
    }
}
