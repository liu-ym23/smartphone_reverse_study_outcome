package com.bytedance.android.ec.core.hybrid.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t {
    public static final /* synthetic */ int j = 0;
    public final String a;
    public final String b;
    public final Map<String, String> c;
    public final Map<String, String> d;
    public final Map<String, String> e;
    public final String f;
    public final boolean g;
    public final e h;
    public final String i;

    public static final class a {
        public static Map a(JSONObject r20, Uri r21, JSONObject r22, Map r23) {
            if (r20 == null) goto L5;
            String r0 = UriProtector.getQueryParameter(r21, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Exception -> L126
            if (r0 == null) goto L13;
            Uri r1 = UriProtector.parse(r0);     // Catch: Exception -> L126
            if (r1 != null) goto L12;
            r1 = null;
        L12:
            Uri r10 = r1;
        L14:
            LinkedHashMap r11 = new LinkedHashMap();
            Iterator<String> r12 = r20.keys();
        L16:
            if (r12.hasNext() == false) goto L123;
            String r13 = r12.next();
            JSONObject r14 = r20.optJSONObject(r13);
            if (r14 == null) goto L16;
            String r15 = r14.optString("type");
            if (r15 == null) goto L118;
            boolean r16 = true;
            switch(r15.hashCode()) {
                case -892481938: goto L116;
                case -577482631: goto L87;
                case -319903276: goto L78;
                case -214617395: goto L39;
                case 107944136: goto L27;
                default: goto L118;
            };
        L27:
            if (r15.equals("query") == false) goto L118;
            String r17 = r14.optString(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            if (r17 != null) goto L31;
            r17 = r13;
        L31:
            String r18 = UriProtector.getQueryParameter(r21, r17);
            if (r18 == null) goto L34;
            r11.put(r13, r18);
            goto L118
        L34:
            if (r10 == null) goto L118;
            String r19 = UriProtector.getQueryParameter(r10, r17);
            if (r19 == null) goto L118;
            r11.put(r13, r19);
            goto L118
        L39:
            if (r15.equals("query-json") == false) goto L118;
            String r110 = r14.optString(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            if (r110 == null) goto L118;
            List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
            if ((!r111.isEmpty()) == false) goto L118;
            if (r10 == null) goto L46;
            String r112 = UriProtector.getQueryParameter(r10, (String) CollectionsKt.first(r111));
        L47:
            if (r112 != null) goto L49;
            r112 = UriProtector.getQueryParameter(r21, (String) CollectionsKt.first(r111));
        L49:
            if (r112 == null) goto L118;
            String r113 = (String) CollectionsKt.last(r111);
            int r24 = t.j;
            Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L72
            if (1 < r111.size()) goto L54;
            String r26 = r112.toString();     // Catch: Throwable -> L72
        L74:
            if (r26 == null) goto L76;
            r11.put(CollectionsKt.last(r111), r26);
        L76:
            r13 = r113;
            goto L118
        L54:
            int r27 = r111.size();     // Catch: Throwable -> L72
            Object r114 = r112;
            String r115 = null;
            int r116 = 1;
        L55:
            if (r116 >= r27) goto L71;
            String r117 = (String) ListProtector.get(r111, r116);     // Catch: Throwable -> L72
            if ((r114 instanceof String) == true) goto L127;
        L62:
            int r118 = r27;
        L64:
            if ((r114 instanceof JSONObject) == false) goto L71;
            r114 = ((JSONObject) r114).opt(r117);     // Catch: Throwable -> L72
            if (r114 == null) goto L70;
            if (r116 != (r111.size() - 1)) goto L70;
            r115 = r114.toString();     // Catch: Throwable -> L72
        L70:
            r116 = r116 + 1;
            r27 = r118;
            goto L55
        L127:
            r118 = r27;
            r114 = new JSONObject((String) r114);     // Catch: JSONException -> L124 Throwable -> L72
        L71:
            r26 = r115;
        L72:
            th = move-exception;
            Result.Companion r28 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            r26 = null;
            goto L74
        L46:
            r112 = null;
            goto L47
        L78:
            if (r15.equals("global_props") == false) goto L118;
            String r29 = r14.optString(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            if (r29 != null) goto L82;
            r29 = r13;
        L82:
            if (r22 == null) goto L118;
            String r30 = r22.optString(r29);
            if (r30 == null) goto L118;
            r11.put(r13, r30);
            goto L118
        L87:
            if (r15.equals("ec_common_params") == false) goto L118;
            String r31 = r14.optString(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            if (r31 != null) goto L91;
            r31 = r13;
        L91:
            if (r23 == null) goto L94;
            String r119 = (String) ((LinkedHashMap) r23).get(r31);
            if (r119 == null) goto L94;
        L106:
            if (r119 != null) goto L108;
        L111:
            if (r16 == true) goto L118;
            if (r23 == null) goto L114;
            String r120 = (String) r23.put(r31, r119);
        L114:
            r11.put(r31, r119);
            goto L118
        L108:
            if (StringsKt.isBlank(r119) == true) goto L111;
            r16 = false;
        L94:
            ConcurrentHashMap<String, NativePrefetch> r121 = NativePrefetchUtil.a;
            if (r31 != null) goto L98;
        L105:
            r119 = null;
            goto L106
        L98:
            if (r31.hashCode() != (-503038523)) goto L105;
            if (r31.equals("webcast_gps_access") == false) goto L105;
            boolean r122 = ECServiceManager.a;
            Integer r123 = ((s83.g) ECServiceManager.c(s83.g.class)).getLocationPermissionParam();
            if (r123 == null) goto L105;
            r119 = String.valueOf(r123.intValue());
            goto L106
        L116:
            if (r15.equals("static") == false) goto L118;
            r11.put(r13, r14.optString(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE));
        L118:
            String r32 = r14.optString("default_value");
            if (r11.get(r13) != null) goto L16;
            if (TextUtils.isEmpty(r32) == true) goto L16;
            r11.put(r13, r32);
            goto L16
        L123:
            return r11;
        L13:
            r10 = null;
            goto L14
        L5:
            return MapsKt.emptyMap();
        }
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof t) == false) goto L24;
        t r11 = (t) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r11.g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v28 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Map<String, String> r15 = this.c;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Map<String, String> r18 = this.d;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        Map<String, String> r21 = this.e;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.f;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        boolean r27 = this.g;
        ?? r28 = r27;
        if (r27 == false) goto L29;
        r28 = 1;
    L29:
        int r29 = (r26 + r28) * 31;
        e r30 = this.h;
        if (r30 == null) goto L32;
        int r31 = r30.hashCode();
    L33:
        int r32 = (r29 + r31) * 31;
        String r33 = this.i;
        if (r33 == null) goto L37;
        r1 = r33.hashCode();
    L37:
        return r32 + r1;
    L32:
        r31 = 0;
        goto L33
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "NativeRequestConfig(apiUrl=" + this.a + ", method=" + this.b + ", headerMap=" + this.c + ", queryMap=" + this.d + ", bodyMap=" + this.e + ", interruptFlag=" + this.f + ", enableNetPerfTiming=" + this.g + ", imagePreloadConfig=" + this.h + ", apiKey=" + this.i + ")";
    }

    public t(String r10, String r11, Map<String, String> r12, Map<String, String> r13, Map<String, String> r14, String r15, boolean r16, e r17, String r18) {
        Intrinsics.checkNotNullParameter(r10, "apiUrl");
        Intrinsics.checkNotNullParameter(r11, "method");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
    }
}
