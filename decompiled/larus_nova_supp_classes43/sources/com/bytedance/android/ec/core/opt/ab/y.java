package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.u0;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@OptSetting(business = "商城")
public final class y {
    public static final Map<String, b> a = null;
    public static a b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/opt/ab/y$a;", "", "", "", "pathList", "Ljava/util/List;", "a", "()Ljava/util/List;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("path_list")
        private final List<String> pathList;

        public a() {
            this(null);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.pathList, ((a) r10).pathList) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<String> r0 = this.pathList;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "LynxPopupNativePrefetchWhiteList(pathList=" + this.pathList + ")";
        }

        public final List<String> a() {
            return this.pathList;
        }

        public a(Object r1) {
            this.pathList = null;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final Boolean g;
        public final Boolean h;
        public final String i;
        public final Map<String, c> j;
        public final boolean k;
        public final String l;

        public b() {
            this(null, null, null, null, null, null, Boolean.FALSE, Boolean.TRUE, null, null, false, null);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof b) == false) goto L30;
            b r11 = (b) r10;
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
            if (Intrinsics.areEqual(this.g, r11.g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.h, r11.h) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.i, r11.i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.j, r11.j) == true) goto L26;
            return false;
        L26:
            if (this.k == r11.k) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.l, r11.l) == true) goto L46;
            return false;
        L46:
            return true;
        L30:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v22, types: [int] */
        /* JADX WARN: Type inference failed for: r2v28, types: [int] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v40 */
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
            String r15 = this.c;
            if (r15 == null) goto L13;
            int r16 = r15.hashCode();
        L14:
            int r17 = (r14 + r16) * 31;
            String r18 = this.d;
            if (r18 == null) goto L17;
            int r19 = r18.hashCode();
        L18:
            int r20 = (r17 + r19) * 31;
            String r21 = this.e;
            if (r21 == null) goto L21;
            int r22 = r21.hashCode();
        L22:
            int r23 = (r20 + r22) * 31;
            String r24 = this.f;
            if (r24 == null) goto L25;
            int r25 = r24.hashCode();
        L26:
            int r26 = (r23 + r25) * 31;
            Boolean r27 = this.g;
            if (r27 == null) goto L29;
            int r28 = r27.hashCode();
        L30:
            int r29 = (r26 + r28) * 31;
            Boolean r30 = this.h;
            if (r30 == null) goto L33;
            int r31 = r30.hashCode();
        L34:
            int r32 = (r29 + r31) * 31;
            String r33 = this.i;
            if (r33 == null) goto L37;
            int r34 = r33.hashCode();
        L38:
            int r35 = (r32 + r34) * 31;
            Map<String, c> r36 = this.j;
            if (r36 == null) goto L41;
            int r37 = r36.hashCode();
        L42:
            int r38 = (r35 + r37) * 31;
            boolean r39 = this.k;
            ?? r40 = r39;
            if (r39 == false) goto L45;
            r40 = 1;
        L45:
            int r41 = (r38 + r40) * 31;
            String r42 = this.l;
            if (r42 == null) goto L49;
            r1 = r42.hashCode();
        L49:
            return r41 + r1;
        L41:
            r37 = 0;
            goto L42
        L37:
            r34 = 0;
            goto L38
        L33:
            r31 = 0;
            goto L34
        L29:
            r28 = 0;
            goto L30
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
            return "NativePrefetchSettingConfig(path=" + this.a + ", channel=" + this.b + ", bundle=" + this.c + ", prefetchAB=" + this.d + ", abKey=" + this.e + ", handleThreadKey=" + this.f + ", handleOnIOThread=" + this.g + ", useForest=" + this.h + ", useConfigTag=" + this.i + ", geckoConfigs=" + this.j + ", allowPopup=" + this.k + ", setting=" + this.l + ")";
        }

        public b(String r1, String r10, String r11, String r12, String r13, String r14, Boolean r15, Boolean r16, String r17, Map<String, c> r18, boolean r19, String r110) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.h = r16;
            this.i = r17;
            this.j = r18;
            this.k = r19;
            this.l = r110;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/opt/ab/y$c;", "", "", "configUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "prefetchAB", "c", "abKey", "a", "setting", "d", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("ab_key")
        private final String abKey;

        @SerializedName("config_url")
        private final String configUrl;

        @SerializedName("prefetch_ab")
        private final String prefetchAB;

        @SerializedName("setting")
        private final String setting;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof c) == false) goto L14;
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.configUrl, r11.configUrl) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.prefetchAB, r11.prefetchAB) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.abKey, r11.abKey) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.setting, r11.setting) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.configUrl;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            String r12 = this.prefetchAB;
            if (r12 == null) goto L9;
            int r13 = r12.hashCode();
        L10:
            int r14 = (r11 + r13) * 31;
            String r15 = this.abKey;
            if (r15 == null) goto L13;
            int r16 = r15.hashCode();
        L14:
            int r17 = (r14 + r16) * 31;
            String r18 = this.setting;
            if (r18 == null) goto L18;
            r1 = r18.hashCode();
        L18:
            return r17 + r1;
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
            return "PrefetchGeckoConfig(configUrl=" + this.configUrl + ", prefetchAB=" + this.prefetchAB + ", abKey=" + this.abKey + ", setting=" + this.setting + ")";
        }

        public final String a() {
            return this.abKey;
        }

        public final String b() {
            return this.configUrl;
        }

        public final String c() {
            return this.prefetchAB;
        }

        public final String d() {
            return this.setting;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/opt/ab/y$d;", "", "Lcom/google/gson/JsonObject;", "content", "Lcom/google/gson/JsonObject;", "a", "()Lcom/google/gson/JsonObject;", "", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("content")
        private final JsonObject content;

        @SerializedName("version")
        private final String version;

        public d() {
            this(0);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof d) == false) goto L10;
            d r11 = (d) r10;
            if (Intrinsics.areEqual(this.content, r11.content) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.version, r11.version) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            JsonObject r0 = this.content;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            String r12 = this.version;
            if (r12 == null) goto L10;
            r1 = r12.hashCode();
        L10:
            return r11 + r1;
        L5:
            r10 = 0;
            goto L6
        }

        public final String toString() {
            return "PrefetchSettingConfig(content=" + this.content + ", version=" + this.version + ")";
        }

        public final JsonObject a() {
            return this.content;
        }

        public d(int r1) {
            this.content = null;
            this.version = null;
        }
    }

    static {
        a = new LinkedHashMap();
    }

    public static a a() {
        a r0 = b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Lazy r1 = ECSettingKeys.a;
        int r10 = p.a;
        Object r11 = "";
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L10
        jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L10
        Object r14 = jj4.a.a("lynx_popup_native_prefetch_config", String.class, "", false);     // Catch: Throwable -> L10
        if (r14 != null) goto L29;
        Intrinsics.throwNpe();     // Catch: Throwable -> L10
    L29:
        Object r15 = Result.constructor-impl((a) u0.b((String) r14, a.class));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r15) == false) goto L24;
        r15 = null;
    L24:
        a r16 = (a) r15;
        if (r16 != null) goto L27;
        r16 = new a(null);
    L27:
        b = r16;
        return r16;
    L19:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Object r19 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r19) == true) goto L15;
        r11 = r19;
    L15:
        r14 = r11;
        goto L29
    }

    public static Map b() {
        Map<String, b> r0 = a;
        if ((!r0.isEmpty()) == false) goto L5;
        return r0;
    L5:
        boolean r1 = ECServiceManager.a;
        s83.a r10 = ((s83.g) ECServiceManager.c(s83.g.class)).q();
        if (r10 == null) goto L8;
        JsonObject r11 = r10.a();
    L81:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L76
        if (r11 == null) goto L74;
        Iterator r13 = r11.entrySet().iterator();     // Catch: Throwable -> L76
    L13:
        if (r13.hasNext() == false) goto L74;
        String r14 = (String) ((Map.Entry) r13.next()).getKey();     // Catch: Throwable -> L76
        JsonObject r15 = r11.getAsJsonObject(r14);     // Catch: Throwable -> L76
        if (r15 == null) goto L13;
        JsonElement r16 = r15.get("config_tags");     // Catch: Throwable -> L76
        if (r16 == null) goto L31;
        JsonObject r17 = r16.getAsJsonObject();     // Catch: Throwable -> L76
        if (r17 == null) goto L31;
        LinkedHashMap r18 = new LinkedHashMap();     // Catch: Throwable -> L76
        Iterator r19 = r17.keySet().iterator();     // Catch: Throwable -> L76
    L22:
        if (r19.hasNext() == false) goto L30;
        String r20 = (String) r19.next();     // Catch: Throwable -> L76
        JsonElement r110 = r17.get(r20);     // Catch: Throwable -> L76
        if (r110 == null) goto L22;
        Object r111 = u0.c().fromJson(r110, c.class);     // Catch: Throwable -> L28
    L29:
        r18.put(r20, r111);     // Catch: Throwable -> L76
    L28:
        r111 = null;
        goto L29
    L30:
        LinkedHashMap r112 = r18;
    L32:
        Map<String, b> r113 = a;     // Catch: Throwable -> L76
        JsonElement r21 = r15.get("channel");     // Catch: Throwable -> L76
        if (r21 == null) goto L35;
        String r22 = r21.getAsString();     // Catch: Throwable -> L76
    L36:
        JsonElement r23 = r15.get("bundle");     // Catch: Throwable -> L76
        if (r23 == null) goto L39;
        String r24 = r23.getAsString();     // Catch: Throwable -> L76
    L40:
        JsonElement r25 = r15.get("prefetch_ab");     // Catch: Throwable -> L76
        if (r25 == null) goto L43;
        String r26 = r25.getAsString();     // Catch: Throwable -> L76
    L44:
        JsonElement r27 = r15.get("ab_key");     // Catch: Throwable -> L76
        if (r27 == null) goto L47;
        String r114 = r27.getAsString();     // Catch: Throwable -> L76
    L48:
        JsonElement r28 = r15.get("handle_thread_key");     // Catch: Throwable -> L76
        if (r28 == null) goto L51;
        String r115 = r28.getAsString();     // Catch: Throwable -> L76
    L52:
        JsonElement r29 = r15.get("handle_on_io_thread");     // Catch: Throwable -> L76
        if (r29 == null) goto L55;
        boolean r30 = r29.getAsBoolean();     // Catch: Throwable -> L76
    L56:
        Boolean r116 = Boolean.valueOf(r30);     // Catch: Throwable -> L76
        JsonElement r31 = r15.get("use_forest");     // Catch: Throwable -> L76
        if (r31 == null) goto L59;
        boolean r32 = r31.getAsBoolean();     // Catch: Throwable -> L76
    L60:
        Boolean r117 = Boolean.valueOf(r32);     // Catch: Throwable -> L76
        JsonElement r33 = r15.get("use_config_tag");     // Catch: Throwable -> L76
        if (r33 == null) goto L63;
        String r118 = r33.getAsString();     // Catch: Throwable -> L76
    L64:
        JsonElement r34 = r15.get("allow_popup");     // Catch: Throwable -> L76
        if (r34 == null) goto L67;
        boolean r119 = r34.getAsBoolean();     // Catch: Throwable -> L76
    L68:
        JsonElement r35 = r15.get("setting");     // Catch: Throwable -> L76
        if (r35 == null) goto L71;
        String r210 = r35.getAsString();     // Catch: Throwable -> L76
    L72:
        r113.put(r14, new b(r14, r22, r24, r26, r114, r115, r116, r117, r118, r112, r119, r210));     // Catch: Throwable -> L76
        goto L13
    L71:
        r210 = null;
        goto L72
    L67:
        r119 = false;
        goto L68
    L63:
        r118 = null;
        goto L64
    L59:
        r32 = true;
        goto L60
    L55:
        r30 = false;
        goto L56
    L51:
        r115 = null;
        goto L52
    L47:
        r114 = null;
        goto L48
    L43:
        r26 = null;
        goto L44
    L39:
        r24 = null;
        goto L40
    L35:
        r22 = null;
    L31:
        r112 = null;
    L74:
        return a;
    L76:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return a;
    L8:
        r11 = null;
        goto L81
    }
}
