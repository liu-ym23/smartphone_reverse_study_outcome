package com.bytedance.apm.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonUtils {

    private static class JsonWriter {

        static final enum Scope extends Enum<Scope> {
            private static final /* synthetic */ Scope[] $VALUES = null;
            public static final Scope DANGLING_KEY = null;
            public static final Scope EMPTY_ARRAY = null;
            public static final Scope EMPTY_OBJECT = null;
            public static final Scope NONEMPTY_ARRAY = null;
            public static final Scope NONEMPTY_OBJECT = null;
            public static final Scope NULL = null;

            static {
                Scope r0 = new Scope("EMPTY_ARRAY", 0);
                EMPTY_ARRAY = r0;
                Scope r1 = new Scope("NONEMPTY_ARRAY", 1);
                NONEMPTY_ARRAY = r1;
                Scope r3 = new Scope("EMPTY_OBJECT", 2);
                EMPTY_OBJECT = r3;
                Scope r5 = new Scope("DANGLING_KEY", 3);
                DANGLING_KEY = r5;
                Scope r7 = new Scope("NONEMPTY_OBJECT", 4);
                NONEMPTY_OBJECT = r7;
                Scope r9 = new Scope("NULL", 5);
                NULL = r9;
                $VALUES = new Scope[]{r0, r1, r3, r5, r7, r9};
            }

            private Scope(String r1, int r2) {
                super(r1, r2);
            }

            public static Scope valueOf(String r2) {
                return (Scope) ZeusTransformUtils.preCheckCast(Enum.valueOf(Scope.class, r2), Scope.class, "com.obric.memorydata.plugin");
            }

            public static Scope[] values() {
                return (Scope[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Scope[].class, "com.obric.memorydata.plugin");
            }
        }

        public String toString() {
            return "";
        }
    }

    public static int a(JSONObject r0, String r1, String r2, String r3) {
        JSONObject r4 = a(r0, r1, r2);
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.optInt(r3, 0);
    }

    public static JSONArray a(JSONArray r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        int r0 = r6.length();
        if (r0 != 0) goto L22;
        return r6;
    L22:
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L21
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L20;
        Object r3 = r6.get(r2);     // Catch: Throwable -> L21
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L16;
        r3 = e((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
    L14:
        r1.put(r3);     // Catch: Throwable -> L21
        r2 = r2 + 1;
        goto L9
    L16:
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == false) goto L14;
        r3 = a((JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
    L20:
        return r6;
    }

    public static JSONObject a(JSONObject r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkedList r1 = new LinkedList();
        Iterator<String> r2 = r4.keys();
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r2.hasNext() == false) goto L16;
        r1.add(r2.next());
        goto L9
    L16:
        return new JSONObject(r4, (String[]) ZeusTransformUtils.preCheckCast(r1.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));
    L13:
        e = move-exception;
        e.printStackTrace();
        return r4;
    }

    public static JSONObject a(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.optJSONObject(r3);
    }

    public static void a(JSONObject r4, JSONObject r5) {
        if (r4 == null) goto L19;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.length() <= 0) goto L21;
        Iterator<String> r0 = r5.keys();     // Catch: JSONException -> L12
    L9:
        if (r0.hasNext() == false) goto L22;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L12
        r4.put(r1, r5.get(r1));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    public static boolean a(JSONObject r0, String r1, String r2, boolean r3) {
        if (r0 != null) goto L4;
        return r3;
    L4:
        JSONObject r4 = r0.optJSONObject(r1);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4.optBoolean(r2, r3);
    }

    public static boolean b(JSONObject r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static JSONObject c(JSONObject r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r2.toString());
    L7:
        return r2;
    }

    public static JSONObject d(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r5.keys();
        if (r1 != null) goto L15;
        return null;
    L15:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L14
    L10:
        if (r1.hasNext() == false) goto L13;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        r0.put(r2, r5.opt(r2));     // Catch: Exception -> L14
        goto L10
    L13:
        return r0;
    L14:
        return r5;
    }

    public static JSONObject e(JSONObject r6) {
        if (r6 != null) goto L6;
        return null;
    L6:
        Iterator<String> r1 = r6.keys();
        if (r1 != null) goto L22;
        return r6;
    L22:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L21
    L10:
        if (r1.hasNext() == false) goto L20;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Object r4 = r6.opt(r3);     // Catch: Throwable -> L21
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L17;
        r4 = e((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
    L15:
        r2.put(r3, r4);     // Catch: Throwable -> L21
        goto L10
    L17:
        if (ZeusTransformUtils.instanceOf(r4, JSONArray.class) == false) goto L15;
        r4 = a((JSONArray) ZeusTransformUtils.preCheckCast(r4, JSONArray.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        goto L15
    L20:
        return r2;
    L21:
        return r6;
    }
}
