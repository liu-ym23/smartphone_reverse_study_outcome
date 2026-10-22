package com.bytedance.android.ec.core.monitor.param;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final void a(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$convertMegaObject");
        JSONObject r1 = r10.optJSONObject("mega_object");
        if (r1 == null) goto L9;
        Map<String, String> r11 = z1.j(r1);
        if ((!r11.isEmpty()) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L9;
    L10:
        if (r11 == null) goto L15;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, String> r13 = r12.next();
        KtSafeMethodExtensionKt.safePut(r10, "mega_object_" + r13.getKey(), r13.getValue());
    L15:
        r10.remove("mega_object");
        return;
    L9:
        r11 = k.z(r10.optString("mega_object"));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Map<String, String> b(Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$convertPassThrough");
        Map<String, String> r0 = MapsKt.toMutableMap(r10);
        String r11 = r10.get(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH);
        if ((r11 instanceof String) == true) goto L14;
    L6:
        JSONArray r12 = null;
    L7:
        Iterator r13 = ((LinkedHashMap) d(r12)).entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r14 = (Map.Entry) r13.next();
        r0.put(r14.getKey(), ((JSONObject) r14.getValue()).toString());
        goto L9
    L11:
        r0.remove(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH);
        return r0;
    L14:
        r12 = new JSONArray(r11);     // Catch: Exception -> L13
        goto L7
    }

    public static final void c(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$convertPassThrough");
        Object r1 = r10.opt(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH);
        if ((r1 instanceof JSONArray) == false) goto L6;
        JSONArray r11 = (JSONArray) r1;
    L10:
        Iterator r12 = ((LinkedHashMap) d(r11)).entrySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r12.next();
        KtSafeMethodExtensionKt.safePut(r10, (String) r13.getKey(), r13.getValue());
        goto L12
    L14:
        r10.remove(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH);
        return;
    L6:
        if ((r1 instanceof String) == true) goto L17;
    L9:
        r11 = null;
        goto L10
    L17:
        r11 = new JSONArray((String) r1);     // Catch: Exception -> L16
        goto L10
    }

    public static final Map<String, JSONObject> d(JSONArray r13) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r13 == null) goto L16;
        int r1 = r13.length();
        int r10 = 0;
    L5:
        if (r10 >= r1) goto L16;
        JSONObject r11 = JSONArrayProtectorUtils.getJSONObject(r13, r10);
        JSONArray r12 = r11.optJSONArray("to");
        if (r12 == null) goto L15;
        Iterator r14 = ((ArrayList) z1.h(r12)).iterator();
    L10:
        if (r14.hasNext() == false) goto L15;
        String r15 = StringsKt.replace$default(r14.next().toString(), '.', '_', false, 4, null);
        JSONObject r16 = (JSONObject) r0.get(r15);
        if (r16 != null) goto L14;
        r16 = new JSONObject();
    L14:
        x0.b(r16, z1.f(r11.optString("data")), false);
        r0.put(r15, r16);
    L15:
        r10 = r10 + 1;
    L16:
        return r0;
    }
}
