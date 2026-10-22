package com.bytedance.ttnet.config;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f3243a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f3244b = false;
    private static volatile a c;

    public interface a {
        String a(String r1, String[] r2);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f3246b;

        public b(String r1, JSONObject r2) {
            this.f3245a = r1;
            this.f3246b = r2;
        }

        public String a() {
            if (TextUtils.isEmpty(this.f3245a) == false) goto L6;
            this.f3245a = this.f3246b.toString();
        L6:
            return this.f3245a;
        }

        public JSONObject b() {
            if (this.f3246b != null) goto L6;
            this.f3246b = new JSONObject(this.f3245a);
        L6:
            return this.f3246b;
        }

        public boolean c() {
            if (TextUtils.isEmpty(this.f3245a) == false) goto L10;
            JSONObject r1 = this.f3246b;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.length() <= 0) goto L9;
        L10:
            return true;
        }
    }

    static {
    }

    public static String a(Object r4, JSONObject r5, String[] r6) {
        if (r6 != null) goto L5;
    L7:
        String r1 = null;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return null;
    L12:
        if (c == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L18;
        return c.a(((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin")).a(), r6);
    L18:
        return r5.optString(r1);
    L5:
        if (r6.length <= 0) goto L7;
        r1 = r6[r6.length - 1];
        goto L9
    }

    public static boolean a() {
        return f3243a;
    }

    public static boolean a(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L10;
        if (((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L17;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin")).length() <= 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L19;
        return false;
    L19:
        return ((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin")).c();
    }

    public static JSONObject b(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L7;
        return new JSONObject((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L11;
        return (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L13;
        return null;
    L13:
        return ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).b();
    }

    public static boolean b() {
        return f3244b;
    }

    public static JSONObject c(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L7;
        return (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L13;
        return ((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).b().optJSONObject("data");
    L10:
        th = move-exception;
        th.printStackTrace();
    L13:
        return new JSONObject();
    }
}
