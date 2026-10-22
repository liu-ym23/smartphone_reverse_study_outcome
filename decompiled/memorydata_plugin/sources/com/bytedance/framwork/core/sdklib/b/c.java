package com.bytedance.framwork.core.sdklib.b;

import android.text.TextUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    public interface a<A, B> {
        boolean a(A r1, B r2);
    }

    public static List<String> a(JSONObject r4, String r5) {
        JSONArray r6 = r4.optJSONArray(r5);     // Catch: Exception -> L15
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.length() <= 0) goto L21;
        int r7 = r6.length();     // Catch: Exception -> L15
        ArrayList r0 = new ArrayList(r7);     // Catch: Exception -> L15
        int r1 = 0;
    L7:
        if (r1 >= r7) goto L12;
        String r2 = r6.getString(r1);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r0.add(r2);     // Catch: Exception -> L15
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        return r0;
    L21:
        return null;
    L22:
        return null;
    }

    public static <L, O> boolean a(Collection<L> r2, O r3, a<? super L, O> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
        boolean r0 = false;
    L4:
        if (r7.hasNext() == false) goto L8;
        if (r6.a(r7.next(), r3) == false) goto L4;
        r7.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static boolean a(List<?> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.size() == 0) goto L8;
        return false;
    }

    public static List<Pattern> b(JSONObject r4, String r5) {
        JSONArray r6 = r4.optJSONArray(r5);     // Catch: Exception -> L15
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.length() <= 0) goto L21;
        int r7 = r6.length();     // Catch: Exception -> L15
        ArrayList r0 = new ArrayList(r7);     // Catch: Exception -> L15
        int r1 = 0;
    L7:
        if (r1 >= r7) goto L12;
        String r2 = r6.getString(r1);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r0.add(Pattern.compile(r2));     // Catch: Exception -> L15
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        return r0;
    L21:
        return null;
    L22:
        return null;
    }

    public static List<String> c(JSONObject r5, String r6) {
        JSONObject r7 = r5.optJSONObject(r6);     // Catch: Exception -> L14
        if (JsonUtils.isEmpty(r7) == false) goto L6;
        return null;
    L6:
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r1 = r7.keys();     // Catch: Exception -> L14
    L8:
        if (r1.hasNext() == false) goto L13;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        if (r7.optInt(r2) != 1) goto L8;
        r8.add(r2);     // Catch: Exception -> L14
        goto L8
    L13:
        return r8;
    L14:
        return null;
    }

    public static List<Pattern> d(JSONObject r5, String r6) {
        JSONObject r7 = r5.optJSONObject(r6);     // Catch: Exception -> L14
        if (JsonUtils.isEmpty(r7) == false) goto L6;
        return null;
    L6:
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r1 = r7.keys();     // Catch: Exception -> L14
    L8:
        if (r1.hasNext() == false) goto L13;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        if (r7.optInt(r2) != 1) goto L8;
        r8.add(Pattern.compile(r2));     // Catch: Exception -> L14
        goto L8
    L13:
        return r8;
    L14:
        return null;
    }
}
