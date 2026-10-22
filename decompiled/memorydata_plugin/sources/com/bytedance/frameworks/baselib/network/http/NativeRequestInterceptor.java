package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeRequestInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f2351a;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2352a = null;

        static {
            int[] r0 = new int[RequestModified.values().length];
            f2352a = r0;
            r0[RequestModified.URL_MODIFIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f2352a[RequestModified.HEADER_MODIFIED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f2352a[RequestModified.BOTH_MODIFIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum RequestModified extends Enum<RequestModified> {
        private static final /* synthetic */ RequestModified[] $VALUES = null;
        public static final RequestModified BOTH_MODIFIED = null;
        public static final RequestModified HEADER_MODIFIED = null;
        public static final RequestModified NOT_MODIFIED = null;
        public static final RequestModified URL_MODIFIED = null;
        public final int mValue;

        static {
            RequestModified r0 = new RequestModified("NOT_MODIFIED", 0, 0);
            NOT_MODIFIED = r0;
            RequestModified r1 = new RequestModified("URL_MODIFIED", 1, 1);
            URL_MODIFIED = r1;
            RequestModified r3 = new RequestModified("HEADER_MODIFIED", 2, 2);
            HEADER_MODIFIED = r3;
            RequestModified r5 = new RequestModified("BOTH_MODIFIED", 3, 3);
            BOTH_MODIFIED = r5;
            $VALUES = new RequestModified[]{r0, r1, r3, r5};
        }

        private RequestModified(String r1, int r2, int r3) {
            super(r1, r2);
            this.mValue = r3;
        }

        public static RequestModified valueOf(String r2) {
            return (RequestModified) ZeusTransformUtils.preCheckCast(Enum.valueOf(RequestModified.class, r2), RequestModified.class, "com.obric.memorydata.plugin");
        }

        public static RequestModified[] values() {
            return (RequestModified[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RequestModified[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public interface a {
        b a(String r1, Map<String, String> r2, List<String> r3);

        c a(String r1, Map<String, List<String>> r2, int r3);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RequestModified f2353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2354b;
        private Map<String, String> c;
        private Set<String> d;

        private static void a(JSONObject r1, String r2) {
            if (TextUtils.isEmpty(r2) == false) goto L8;
            return;
        L8:
            new URI(r2);     // Catch: Exception -> L7
            r1.put("new_url", r2);     // Catch: Exception -> L7
            return;
        }

        private static void a(JSONObject r4, Map<String, String> r5, Set<String> r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L9;
            JSONArray r0 = new JSONArray();
            Iterator r9 = r8.iterator();
        L6:
            if (r9.hasNext() == false) goto L8;
            r0.put((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"));
            goto L6
        L8:
            r4.put("removed_headers", r0);
        L9:
            if (r7 != null) goto L11;
            return;
        L11:
            JSONObject r10 = new JSONObject();
            Iterator r11 = r7.entrySet().iterator();
        L13:
            if (r11.hasNext() == false) goto L18;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L13;
            r10.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r1.getValue());
            goto L13
        L18:
            r4.put("new_headers", r10);
        }

        public String a() {
            JSONObject r0 = new JSONObject();
            int r1 = AnonymousClass1.f2352a[this.f2353a.ordinal()];     // Catch: JSONException -> L17
            if (r1 != 1) goto L7;
            r0.put("modified", RequestModified.URL_MODIFIED.getValue());     // Catch: JSONException -> L17
            a(r0, this.f2354b);     // Catch: JSONException -> L17
            goto L16
        L7:
            if (r1 != 2) goto L9;
            r0.put("modified", RequestModified.HEADER_MODIFIED.getValue());     // Catch: JSONException -> L17
            Map<String, String> r2 = this.c;     // Catch: JSONException -> L17
        L12:
            a(r0, r2, this.d);     // Catch: JSONException -> L17
            goto L16
        L9:
            if (r1 != 3) goto L16;
            r0.put("modified", RequestModified.BOTH_MODIFIED.getValue());     // Catch: JSONException -> L17
            a(r0, this.f2354b);     // Catch: JSONException -> L17
            r2 = this.c;     // Catch: JSONException -> L17
        L16:
            return r0.toString();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RequestModified f2355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<String> f2356b;
        private Map<String, List<String>> c;

        private static JSONObject a(Map<String, List<String>> r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L5;
            return null;
        L5:
            if (r8.isEmpty() == true) goto L26;
            JSONObject r0 = new JSONObject();
            Iterator r9 = r8.entrySet().iterator();
        L9:
            if (r9.hasNext() == false) goto L17;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            JSONArray r3 = new JSONArray();
            Iterator r4 = ((List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
        L12:
            if (r4.hasNext() == false) goto L16;
            String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
            if (TextUtils.isEmpty(r5) == true) goto L12;
            r3.put(r5);
            goto L12
        L16:
            r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r3);
            goto L9
        L17:
            return r0;
        L26:
            return null;
        }

        public String a() {
            if (this.f2355a == RequestModified.HEADER_MODIFIED) goto L7;
            if (this.f2355a == RequestModified.BOTH_MODIFIED) goto L7;
            return null;
        L7:
            if (this.c == null) goto L9;
        L12:
            JSONObject r0 = new JSONObject();
            r0.put("modified", this.f2355a.getValue());     // Catch: JSONException -> L25
            Map<String, List<String>> r1 = this.c;     // Catch: JSONException -> L25
            if (r1 == null) goto L17;
            r0.put("new_headers", a(r1));     // Catch: JSONException -> L25
        L17:
            if (this.f2356b == null) goto L24;
            JSONArray r2 = new JSONArray();     // Catch: JSONException -> L25
            Iterator<String> r5 = this.f2356b.iterator();     // Catch: JSONException -> L25
        L20:
            if (r5.hasNext() == false) goto L22;
            r2.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: JSONException -> L25
            goto L20
        L22:
            r0.put("removed_headers", r2);     // Catch: JSONException -> L25
        L24:
            return r0.toString();
        L9:
            if (this.f2356b != null) goto L12;
            return null;
        }
    }

    public static String a(String r4, Map<String, List<String>> r5, int r6) {
        Map<String, List<String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (f2351a != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("NativeRequestInterceptor", "response url:" + r4 + " headers:" + r7.toString() + " code:" + r6);
    L8:
        c r8 = f2351a.a(r4, r7, r6);
        if (r8 != null) goto L11;
        return null;
    L11:
        String r9 = r8.a();
        if (Logger.debug() == false) goto L14;
        Logger.d("NativeRequestInterceptor", "response json:" + r9);
    L14:
        return r9;
    }

    public static String a(String r4, Map<String, String> r5, List<String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (f2351a != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("NativeRequestInterceptor", "request url:" + r4 + " headers:" + r7.toString() + " domains:" + r8);
    L8:
        b r9 = f2351a.a(r4, r7, r8);
        if (r9 != null) goto L11;
        return null;
    L11:
        String r10 = r9.a();
        if (Logger.debug() == false) goto L14;
        Logger.d("NativeRequestInterceptor", "request json:" + r10);
    L14:
        return r10;
    }
}
