package com.larus.dora.impl.dynamic.loader;

import android.app.Application;
import c59.d0;
import c59.s;
import c59.z;
import com.bytedance.keva.Keva;
import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.network.HttpConst;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final String b = null;
    public final DslLocalCache a;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.loader.d$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\r\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslBizData;", "", "starling", "", "", "dynamicData", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getStarling", "()Ljava/util/Map;", "getDynamicData", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0066a {

            @SerializedName("dynamic_data")
            private final Map<String, String> dynamicData;

            @SerializedName("starling")
            private final Map<String, String> starling;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0066a) == true) goto L8;
                return false;
            L8:
                C0066a r6 = (C0066a) r5;
                if (Intrinsics.areEqual(this.starling, r6.starling) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.dynamicData, r6.dynamicData) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                Map<String, String> r0 = this.starling;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                Map<String, String> r4 = this.dynamicData;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslBizData(starling=" + this.starling + ", dynamicData=" + this.dynamicData + ')';
            }

            public C0066a() {
                this.starling = null;
                this.dynamicData = null;
            }

            public final Map<String, String> a() {
                return this.dynamicData;
            }

            public final Map<String, String> b() {
                return this.starling;
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006("}, d2 = {"Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslPageConfig;", "", "pageId", "", "id", "name", "", "pageKey", "version", "config", "Lcom/larus/dora/impl/dynamic/dsl/DslNode;", "productModelCodes", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/dora/impl/dynamic/dsl/DslNode;Ljava/lang/String;)V", "getPageId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "getName", "()Ljava/lang/String;", "getPageKey", "getVersion", "getConfig", "()Lcom/larus/dora/impl/dynamic/dsl/DslNode;", "getProductModelCodes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/dora/impl/dynamic/dsl/DslNode;Ljava/lang/String;)Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslPageConfig;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b {

            @SerializedName("config")
            private final z config;

            @SerializedName("id")
            private final Long id;

            @SerializedName("name")
            private final String name;

            @SerializedName("page_id")
            private final Long pageId;

            @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY)
            private final String pageKey;

            @SerializedName("product_model_codes")
            private final String productModelCodes;

            @SerializedName("version")
            private final String version;

            public b() {
                this(null, null, 127);
            }

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (Intrinsics.areEqual(this.pageId, r6.pageId) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.name, r6.name) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.pageKey, r6.pageKey) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.version, r6.version) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.config, r6.config) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.productModelCodes, r6.productModelCodes) == true) goto L29;
                return false;
            L29:
                return true;
            }

            public final int hashCode() {
                Long r0 = this.pageId;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                Long r4 = this.id;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.name;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                String r10 = this.pageKey;
                if (r10 != null) goto L17;
                int r11 = 0;
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.version;
                if (r13 != null) goto L21;
                int r14 = 0;
            L22:
                int r15 = (r12 + r14) * 31;
                z r16 = this.config;
                if (r16 != null) goto L25;
                int r17 = 0;
            L26:
                int r18 = (r15 + r17) * 31;
                String r20 = this.productModelCodes;
                if (r20 == null) goto L31;
                r1 = r20.hashCode();
            L31:
                return r18 + r1;
            L25:
                r17 = r16.hashCode();
                goto L26
            L21:
                r14 = r13.hashCode();
                goto L22
            L17:
                r11 = r10.hashCode();
                goto L18
            L13:
                r8 = r7.hashCode();
                goto L14
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslPageConfig(pageId=" + this.pageId + ", id=" + this.id + ", name=" + this.name + ", pageKey=" + this.pageKey + ", version=" + this.version + ", config=" + this.config + ", productModelCodes=" + this.productModelCodes + ')';
            }

            public final z a() {
                return this.config;
            }

            public final String b() {
                return this.version;
            }

            public b(String r3, z r4, int r5) {
                if ((r5 & 16) == 0) goto L6;
                r3 = null;
            L6:
                if ((r5 & 32) == 0) goto L8;
                r4 = null;
            L8:
                this.pageId = null;
                this.id = null;
                this.name = null;
                this.pageKey = null;
                this.version = r3;
                this.config = r4;
                this.productModelCodes = null;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslPageData;", "", "pageConfig", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslPageConfig;", "bizData", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslBizData;", "<init>", "(Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslPageConfig;Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslBizData;)V", "getPageConfig", "()Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslPageConfig;", "getBizData", "()Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader$Companion$DslBizData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class c {

            @SerializedName("biz_data")
            private final C0066a bizData;

            @SerializedName("page_config")
            private final b pageConfig;

            public c() {
                this(null, null);
            }

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (Intrinsics.areEqual(this.pageConfig, r6.pageConfig) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.bizData, r6.bizData) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                b r0 = this.pageConfig;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                C0066a r4 = this.bizData;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslPageData(pageConfig=" + this.pageConfig + ", bizData=" + this.bizData + ')';
            }

            public final C0066a a() {
                return this.bizData;
            }

            public final b b() {
                return this.pageConfig;
            }

            public c(b r1, C0066a r2) {
                this.pageConfig = r1;
                this.bizData = r2;
            }
        }
    }

    public interface b {
        void a();

        void b(z r1);

        void onFail(String r1);
    }

    static {
        HttpConst.a.getClass();
        b = HttpConst.m;
    }

    public d() {
        this.a = new DslLocalCache();
    }

    public static boolean c(z r2) {
        List<z> r3 = r2.c();
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        g49.d.b("DSLDynamicDataLoader", "pageNode.nodes is null or empty");
        return false;
    L12:
        return true;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    public static final a.c a(d r7, String r8, Integer r9, Integer r10, String r11, b r12) {
        r7.getClass();
        g49.d.d("DSLDynamicDataLoader", "loadDataFromCache: key: " + r8 + ", vendorId: " + r9 + ", productId: " + r10 + ", pageKey: " + r11);
        Keva r4 = g49.c.a;     // Catch: Exception -> L40
        Intrinsics.checkNotNullParameter(r8, "key");     // Catch: Exception -> L40
        String r13 = g49.c.a.getString("key_http_response" + r8, "");     // Catch: Exception -> L40
        if (r13.length() <= 0) goto L6;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L31;
        Lazy r14 = s.a;     // Catch: Exception -> L40
        a.c r15 = (a.c) s.b(r13, a.c.class);     // Catch: Exception -> L40
        StringBuilder r16 = new StringBuilder("loadDataFromCache: load from kv cache, version: ");     // Catch: Exception -> L40
        if (r15 == null) goto L13;
        a.b r17 = r15.b();     // Catch: Exception -> L40
        if (r17 == null) goto L13;
        String r18 = r17.b();     // Catch: Exception -> L40
    L14:
        r16.append(r18);     // Catch: Exception -> L40
        g49.d.d("DSLDynamicDataLoader", r16.toString());     // Catch: Exception -> L40
        if (r15 == null) goto L29;
        a.b r20 = r15.b();     // Catch: Exception -> L40
        if (r20 == null) goto L29;
        z r21 = r20.a();     // Catch: Exception -> L40
        if (r21 == null) goto L29;
        if (c(r21) == false) goto L28;
        r12.b(r21);     // Catch: Exception -> L40
        ConcurrentHashMap<String, String> r22 = d0.a;     // Catch: Exception -> L40
        a.C0066a r23 = r15.a();     // Catch: Exception -> L40
        if (r23 == null) goto L26;
        Map<String, String> r24 = r23.b();     // Catch: Exception -> L40
        if (r24 == null) goto L26;
    L27:
        d0.c(r24);     // Catch: Exception -> L40
    L44:
        return r15;
    L26:
        r24 = MapsKt.emptyMap();     // Catch: Exception -> L40
        goto L27
    L28:
        r12.a();     // Catch: Exception -> L40
    L29:
        r12.a();     // Catch: Exception -> L40
    L13:
        r18 = null;
        goto L14
    L31:
        DslLocalCache r25 = r7.a;     // Catch: Exception -> L40
        Application r26 = AppHost.a.getApplication();     // Catch: Exception -> L40
        if (r11 != null) goto L34;
        r11 = "";
    L34:
        Set<String> r0 = DslLocalCache.a;     // Catch: Exception -> L40
        r25.getClass();     // Catch: Exception -> L40
        z r27 = DslLocalCache.a(r26, r9, r10, r11, null);     // Catch: Exception -> L40
        g49.d.d("DSLDynamicDataLoader", "loadDataFromCache: load from doraLocalCache");     // Catch: Exception -> L40
        if (r27 == null) goto L37;
        r12.b(r27);     // Catch: Exception -> L40
    L45:
        return new a.c(new a.b("0.0.0", r27, 79), null);
    L37:
        r12.a();     // Catch: Exception -> L40
        goto L45
    L6:
        r5 = false;
    L40:
        e = move-exception;
        g49.d.b("DSLDynamicDataLoader", "local fetchData error: " + e.getMessage());
        r12.onFail("local fetchData error: " + e.getMessage());
        return null;
    }

    public static void b(d r12, CoroutineScope r13, Integer r14, Integer r15, String r16, String r17, b r18) {
        Map r7 = MapsKt.emptyMap();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r7, "headers");
        Intrinsics.checkNotNullParameter(r18, "callback");
        g49.d.d("DSLDynamicDataLoader", "fetchData productId :" + r15 + ",model:" + r16 + ",pageKey:" + r17);
        if (r13 == null) goto L6;
        BuildersKt.launch$default(r13, Dispatchers.getIO(), null, new DslDynamicDataLoader$fetchData$1(r12, r17, r14, r15, r16, r18, r7, null), 2, null);
        return;
    }
}
