package com.larus.dispatcher.askhuman.handler;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public static final f b(JSONObject r6) {
        JSONObject r0 = r6.optJSONObject("vm_takeover_params");
        Object r1 = r6.opt("is_vm");
        if ((r1 instanceof Boolean) == false) goto L6;
        boolean r2 = ((Boolean) r1).booleanValue();
    L9:
        String r3 = a(r6, "vm_take_over_url");
        String r4 = a(r6, "activePageId");
        if (r4 != null) goto L21;
        String r7 = a(r6, "active_page_id");
        if (r7 != null) goto L20;
        if (r0 == null) goto L15;
        r7 = a(r0, "activePageId");
    L16:
        if (r7 != null) goto L20;
        if (r0 == null) goto L19;
        r4 = a(r0, "active_page_id");
        goto L21
    L19:
        r4 = null;
        goto L21
    L15:
        r7 = null;
    L20:
        r4 = r7;
    L21:
        if (r2 == true) goto L26;
        if (r3 != null) goto L26;
        if (r4 != null) goto L26;
        return null;
    L26:
        return new f(r2, r3, r4);
    L6:
        if ((r1 instanceof String) == false) goto L8;
        r2 = StringsKt.equals(StringsKt.trim((String) r1).toString(), "true", true);
        goto L9
    L8:
        r2 = false;
        goto L9
    }

    public static final Object c(Object r4) {
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == false) goto L6;
        return null;
    L6:
        if ((r4 instanceof JSONObject) == false) goto L9;
        return e((JSONObject) r4);
    L9:
        if ((r4 instanceof JSONArray) == false) goto L18;
        JSONArray r5 = (JSONArray) r4;
        List r0 = CollectionsKt.createListBuilder(r5.length());
        int r1 = r5.length();
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L14;
        r0.add(c(r5.opt(r2)));
        r2 = r2 + 1;
        goto L11
    L14:
        return CollectionsKt.build(r0);
    L18:
        return r4;
    }

    public static final List<String> d(JSONArray r5) {
        List r0 = CollectionsKt.createListBuilder(r5.length());
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        String r3 = r5.optString(r2);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        r0.add(r3);
    L10:
        r2 = r2 + 1;
        goto L3
    L12:
        return CollectionsKt.build(r0);
    }

    public static final Map<String, Object> e(JSONObject r4) {
        Map r0 = MapsKt.createMapBuilder();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L7;
        String r2 = r1.next();
        Intrinsics.checkNotNull(r2);
        r0.put(r2, c(r4.opt(r2)));
        goto L4
    L7:
        return MapsKt.build(r0);
    }

    public static final t f(k r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        String r13 = r12.b.getSchemaPayload();
        if (r13 == null) goto L5;
        JSONObject r1 = new JSONObject(r13);     // Catch: Exception -> L43
        JSONObject r14 = r1.optJSONObject("server_option");     // Catch: Exception -> L43
        String r2 = r1.optString("tool_call_id");     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L43
        Map<String, Object> r4 = null;
        if ((!StringsKt.isBlank(r2)) == false) goto L9;
        String r6 = r2;
    L10:
        String r3 = r1.optString("sandbox_id");     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L43
        if ((!StringsKt.isBlank(r3)) == false) goto L13;
        String r7 = r3;
    L14:
        String r5 = r1.optString("command");     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L43
        if ((!StringsKt.isBlank(r5)) == false) goto L17;
        String r8 = r5;
    L18:
        JSONArray r9 = r1.optJSONArray("folders");     // Catch: Exception -> L43
        if (r9 == null) goto L24;
        List<String> r10 = d(r9);     // Catch: Exception -> L43
        if (r10 == null) goto L24;
        List<String> r11 = r10;
    L35:
        if (r14 == null) goto L40;
        String r15 = r14.optString("callback_id");     // Catch: Exception -> L43
        Integer r16 = Integer.valueOf(r14.optInt("scene"));     // Catch: Exception -> L43
        JSONObject r17 = r14.optJSONObject("params");     // Catch: Exception -> L43
        if (r17 == null) goto L39;
        r4 = e(r17);     // Catch: Exception -> L43
    L39:
        u r18 = new u(r15, r16, r4);     // Catch: Exception -> L43
    L41:
        return new t(r6, r7, r8, r11, r18, b(r1));
    L40:
        r18 = null;
    L24:
        String r0 = r1.optString("folders");     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L43
        if ((!StringsKt.isBlank(r0)) == true) goto L29;
        r0 = null;
    L29:
        if (r0 != null) goto L46;
        r11 = null;
        goto L35
    L46:
        List<String> r20 = d(new JSONArray(r0));     // Catch: Exception -> L32
    L33:
        r11 = r20;
        goto L35
    L32:
        r20 = CollectionsKt.listOf(r0);     // Catch: Exception -> L43
        goto L33
    L17:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r6 = null;
    L43:
        e = move-exception;
        FLogger.a.e("QuickReplyClickInterceptorManager", "[transformSchemaPayload] parse schemaPayload failed, errorType=".concat(e.getClass().getSimpleName()));
        return new t();
    L5:
        return new t();
    }

    public static final String a(JSONObject r1, String r2) {
        Object r3 = r1.opt(r2);
        if ((r3 instanceof String) == false) goto L5;
        String r4 = (String) r3;
    L6:
        if (r4 == null) goto L16;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 != null) goto L10;
        return null;
    L10:
        if (r5.length() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        return null;
    L15:
        return r5;
    L12:
        r6 = false;
        goto L13
    L16:
        return null;
    L5:
        r4 = null;
        goto L6
    }
}
