package com.bytedance.android.annie.xbridge.mix;

import android.text.TextUtils;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.ResultCodeEnumSerializer;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import e7.j0;
import e7.k0;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final a a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.q {
        public final com.bytedance.ies.web.jsbridge2.q a;
        public final Gson b;

        public a() {
            this.a = ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).n1();
            this.b = new Gson().newBuilder().registerTypeHierarchyAdapter(j0.class, new ResultCodeEnumSerializer()).create();
        }

        public final <T> String a(T r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            Class<?> r0 = r10.getClass();
            if (Intrinsics.areEqual(r0, JsonObject.class) == false) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L9;
            return r10.toString();
        L9:
            if (Intrinsics.areEqual(r0, String.class) == false) goto L12;
            return r10.toString();
        L12:
            if ((r10 instanceof k0) == false) goto L15;
            return GsonProtectorUtils.toJson(this.b, r10);
        L15:
            return this.a.a(r10);
        L5:
            r1 = Intrinsics.areEqual(r0, JsonArray.class);
            goto L6
        }

        public final <T> T b(String r10, Type r11) {
            Intrinsics.checkNotNullParameter(r10, "data");
            Intrinsics.checkNotNullParameter(r11, "type");
            return (T) GsonProtectorUtils.fromJson(this.b, r10, r11);
        }
    }

    static {
        a = new a();
    }

    public static void a(String r10) {
        if (StringsKt.startsWith$default(r10, "{", false, 2, null) == true) goto L5;
    L7:
        IllegalArgumentException r0 = new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + r10);
        Intrinsics.checkNotNull(r0);
        throw r0;
    L5:
        if (StringsKt.endsWith$default(r10, "}", false, 2, null) == false) goto L7;
    }

    public static JSONObject c(Object r10) {
        if (r10 != null) goto L5;
        String r11 = "{}";
    L12:
        boolean r1 = true;
        if (TextUtils.isEmpty(r11) == false) goto L16;
        JSONObject r12 = new JSONObject();
        r12.put("code", 1);
        return r12;
    L16:
        String r0 = r11.substring(1, r11.length() - 1);
        String r13 = "{\"code\":1,\"__data\":".concat(r11);
        StringBuilder r14 = new StringBuilder();
        r14.append(r13);
        if (r0.length() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == true) goto L22;
        String r15 = "," + r0 + '}';
    L23:
        r14.append(r15);
        return new JSONObject(r14.toString());
    L22:
        r15 = "}";
        goto L23
    L5:
        if ((r10 instanceof JSONObject) == false) goto L7;
    L10:
        r11 = r10.toString();
    L11:
        a(r11);
        goto L12
    L7:
        if ((r10 instanceof JSONArray) == true) goto L10;
        r11 = a.a(r10);
        goto L11
    }

    public static Object b(JSONObject r10, Type r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "type");
        s26.d r1 = s26.d.c;
        m0 r12 = s26.d.c.c(m0.class);
        if (r12 == null) goto L5;
        r12.a0();
    L5:
        String r13 = r10.toString();
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r11, "type");
        a(r13);
        if (Intrinsics.areEqual(r11, JSONObject.class) == true) goto L14;
        if ((r11 instanceof Class) == false) goto L15;
        if (JSONObject.class.isAssignableFrom((Class) r11) == true) goto L14;
    L15:
        return a.b(r13, r11);
    L14:
        return new JSONObject(r13);
    }
}
