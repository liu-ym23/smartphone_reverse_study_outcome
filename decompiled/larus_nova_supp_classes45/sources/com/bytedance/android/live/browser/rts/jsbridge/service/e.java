package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.annie.param.UtilsKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        public static Map a(Object r1) {
            if ((r1 instanceof JSONObject) == false) goto L7;
            int r0 = mm0.c.a;
            return MapsKt.toMutableMap(mm0.c.e((JSONObject) r1));
        L7:
            if ((r1 instanceof JsonObject) == true) goto L9;
            return null;
        L9:
            return MapsKt.toMutableMap(UtilsKt.i((JsonObject) r1));
        }

        public static List b(JsonArray r4) {
            Intrinsics.checkNotNullParameter(r4, "jsonArray");
            ArrayList r0 = new ArrayList();
            Iterator r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L25;
            JsonObject r1 = (JsonElement) r5.next();
            if ((r1 instanceof JsonObject) == false) goto L9;
            e.a.getClass();
            Object r2 = c(r1);
        L24:
            r0.add(r2);
            goto L4
        L9:
            if ((r1 instanceof JsonArray) == false) goto L12;
            e.a.getClass();
            r2 = b((JsonArray) r1);
            goto L24
        L12:
            if ((r1 instanceof JsonPrimitive) == false) goto L23;
            JsonPrimitive r3 = (JsonPrimitive) r1;
            if (r3.isString() == false) goto L17;
            r2 = r3.getAsString();
            goto L24
        L17:
            if (r3.isBoolean() == false) goto L20;
            r2 = Boolean.valueOf(r3.getAsBoolean());
            goto L24
        L20:
            if (r3.isNumber() == false) goto L22;
            r2 = r3.getAsNumber();
            goto L24
        L22:
            r2 = r1.toString();
            goto L24
        L23:
            r2 = r1.toString();
            goto L24
        L25:
            return r0;
        }

        public static Map c(JsonObject r5) {
            Intrinsics.checkNotNullParameter(r5, "jsonObj");
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator r6 = r5.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L25;
            Map.Entry r1 = (Map.Entry) r6.next();
            String r2 = (String) r1.getKey();
            JsonObject r3 = (JsonElement) r1.getValue();
            if ((r3 instanceof JsonObject) == false) goto L9;
            Object r4 = c(r3);
        L24:
            r0.put(r2, r4);
            goto L4
        L9:
            if ((r3 instanceof JsonArray) == false) goto L12;
            r4 = b((JsonArray) r3);
            goto L24
        L12:
            if ((r3 instanceof JsonPrimitive) == false) goto L23;
            JsonPrimitive r7 = (JsonPrimitive) r3;
            if (r7.isString() == false) goto L17;
            r4 = r7.getAsString();
            goto L24
        L17:
            if (r7.isBoolean() == false) goto L20;
            r4 = Boolean.valueOf(r7.getAsBoolean());
            goto L24
        L20:
            if (r7.isNumber() == false) goto L22;
            r4 = r7.getAsNumber();
            goto L24
        L22:
            r4 = r3.toString();
            goto L24
        L23:
            r4 = r3.toString();
            goto L24
        L25:
            return r0;
        }
    }

    static {
        a = new a();
    }
}
