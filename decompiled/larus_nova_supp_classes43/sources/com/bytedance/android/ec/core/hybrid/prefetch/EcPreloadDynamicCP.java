package com.bytedance.android.ec.core.hybrid.prefetch;

import android.net.Uri;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EcPreloadDynamicCP {
    public static final Lazy a = null;
    public static final Lazy b = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/EcPreloadDynamicCP$a;", "", "", "lynxCommonDynamicUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "h5CommonDynamicUrl", "getH5CommonDynamicUrl", "generalTitle", "a", "recommendTitle", "d", "", "Lcom/bytedance/android/ec/core/hybrid/prefetch/EcPreloadDynamicCP$b;", "path", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("general_title")
        private final String generalTitle;

        @SerializedName("h5_dynamic_url")
        private final String h5CommonDynamicUrl;

        @SerializedName("lynx_dynamic_url")
        private final String lynxCommonDynamicUrl;

        @SerializedName("path")
        private final Map<String, b> path;

        @SerializedName("recommend_title")
        private final String recommendTitle;

        public a() {
            this(null);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L16;
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.lynxCommonDynamicUrl, r11.lynxCommonDynamicUrl) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.h5CommonDynamicUrl, r11.h5CommonDynamicUrl) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.generalTitle, r11.generalTitle) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.recommendTitle, r11.recommendTitle) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.path, r11.path) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r0 = this.lynxCommonDynamicUrl;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            String r12 = this.h5CommonDynamicUrl;
            if (r12 == null) goto L9;
            int r13 = r12.hashCode();
        L10:
            int r14 = (r11 + r13) * 31;
            String r15 = this.generalTitle;
            if (r15 == null) goto L13;
            int r16 = r15.hashCode();
        L14:
            int r17 = (r14 + r16) * 31;
            String r18 = this.recommendTitle;
            if (r18 == null) goto L17;
            int r19 = r18.hashCode();
        L18:
            int r20 = (r17 + r19) * 31;
            Map<String, b> r21 = this.path;
            if (r21 == null) goto L22;
            r1 = r21.hashCode();
        L22:
            return r20 + r1;
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
            return "EcPreloadDynamicABConfig(lynxCommonDynamicUrl=" + this.lynxCommonDynamicUrl + ", h5CommonDynamicUrl=" + this.h5CommonDynamicUrl + ", generalTitle=" + this.generalTitle + ", recommendTitle=" + this.recommendTitle + ", path=" + this.path + ")";
        }

        public final String a() {
            return this.generalTitle;
        }

        public final String b() {
            return this.lynxCommonDynamicUrl;
        }

        public final Map<String, b> c() {
            return this.path;
        }

        public final String d() {
            return this.recommendTitle;
        }

        public a(Object r1) {
            this.lynxCommonDynamicUrl = null;
            this.h5CommonDynamicUrl = null;
            this.generalTitle = null;
            this.recommendTitle = null;
            this.path = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/EcPreloadDynamicCP$b;", "", "", "dynamicUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "", "preload", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "addUrlToSchema", "a", "useNaGyl", "f", "disablePrefetch", "b", "pageName", "d", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("add_url_to_schema")
        private final Integer addUrlToSchema;

        @SerializedName("disable_prefetch")
        private final Integer disablePrefetch;

        @SerializedName("dynamic_url")
        private String dynamicUrl;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME)
        private final String pageName;

        @SerializedName("preload")
        private final Integer preload;

        @SerializedName("use_na_gyl")
        private final Integer useNaGyl;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof b) == false) goto L18;
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.dynamicUrl, r11.dynamicUrl) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.preload, r11.preload) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.addUrlToSchema, r11.addUrlToSchema) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.useNaGyl, r11.useNaGyl) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.disablePrefetch, r11.disablePrefetch) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.pageName, r11.pageName) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r0 = this.dynamicUrl;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            Integer r12 = this.preload;
            if (r12 == null) goto L9;
            int r13 = r12.hashCode();
        L10:
            int r14 = (r11 + r13) * 31;
            Integer r15 = this.addUrlToSchema;
            if (r15 == null) goto L13;
            int r16 = r15.hashCode();
        L14:
            int r17 = (r14 + r16) * 31;
            Integer r18 = this.useNaGyl;
            if (r18 == null) goto L17;
            int r19 = r18.hashCode();
        L18:
            int r20 = (r17 + r19) * 31;
            Integer r21 = this.disablePrefetch;
            if (r21 == null) goto L21;
            int r22 = r21.hashCode();
        L22:
            int r23 = (r20 + r22) * 31;
            String r24 = this.pageName;
            if (r24 == null) goto L26;
            r1 = r24.hashCode();
        L26:
            return r23 + r1;
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
            return "EcPreloadDynamicPath(dynamicUrl=" + this.dynamicUrl + ", preload=" + this.preload + ", addUrlToSchema=" + this.addUrlToSchema + ", useNaGyl=" + this.useNaGyl + ", disablePrefetch=" + this.disablePrefetch + ", pageName=" + this.pageName + ")";
        }

        public b() {
            this.dynamicUrl = null;
            this.preload = null;
            this.addUrlToSchema = null;
            this.useNaGyl = null;
            this.disablePrefetch = null;
            this.pageName = null;
        }

        public final Integer a() {
            return this.addUrlToSchema;
        }

        public final Integer b() {
            return this.disablePrefetch;
        }

        public final String c() {
            return this.dynamicUrl;
        }

        public final String d() {
            return this.pageName;
        }

        public final Integer e() {
            return this.preload;
        }

        public final Integer f() {
            return this.useNaGyl;
        }

        public final void g(String r1) {
            this.dynamicUrl = r1;
        }
    }

    public static a b() {
        return (a) a.getValue();
    }

    static {
        a = LazyKt.lazy(EcPreloadDynamicCP$ecPreloadDynamicComponent$2.INSTANCE);
        b = LazyKt.lazy(EcPreloadDynamicCP$checkBehavior$2.INSTANCE);
    }

    public static String c(String r10) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        Uri r11 = UriProtector.parse(r10);     // Catch: Throwable -> L27
        String r12 = UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L27
        String r13 = UriProtector.getQueryParameter(r11, "surl");     // Catch: Throwable -> L27
        boolean r14 = false;
        if (StringsKt.startsWith$default(r10, "http", false, 2, null) == false) goto L7;
    L22:
        if (r11 == null) goto L24;
        String r15 = r11.getPath();     // Catch: Throwable -> L27
    L25:
        return a2.d(r15);
    L24:
        r15 = null;
        goto L25
    L7:
        if (r12 != null) goto L9;
    L12:
        boolean r16 = true;
    L13:
        if (r16 == true) goto L15;
        r11 = UriProtector.parse(r12);     // Catch: Throwable -> L27
        goto L22
    L15:
        if (r13 != null) goto L17;
    L18:
        r14 = true;
    L19:
        if (r14 == true) goto L21;
        r11 = UriProtector.parse(r13);     // Catch: Throwable -> L27
        goto L22
    L21:
        r11 = null;
        goto L22
    L17:
        if (r13.length() != 0) goto L19;
    L9:
        if (r12.length() == 0) goto L12;
        r16 = false;
    L27:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    public static String a(String r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_URL);
        boolean r1 = false;
        if (r14.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r14;
    L8:
        String r10 = c(r14);
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == false) goto L17;
        return r14;
    L17:
        Map<String, b> r12 = b().c();
        if (r12 == null) goto L108;
        b r13 = r12.get(r10);
        if (r13 == null) goto L110;
        Integer r16 = r13.f();
        if (r16 != null) goto L26;
    L66:
        Integer r17 = r13.e();
        if (r17 != null) goto L70;
    L71:
        return r14;
    L70:
        if (r17.intValue() != 1) goto L71;
        String r18 = r13.c();
        if (r18 != null) goto L75;
        r18 = b().b();
    L75:
        r13.g(r18);
        String r19 = r13.c();
        if (r19 == null) goto L109;
        Uri.Builder r110 = UriProtector.parse(r14).buildUpon();
        Integer r111 = r13.a();
        if (r111 != null) goto L81;
    L90:
        String r112 = UUID.randomUUID().toString();
        r110.appendQueryParameter("ec_register_lynx_lifecycle", r112);
        EcRegisterDynamicCP r20 = new EcRegisterDynamicCP();
        int r21 = ECSdk.a;
        IAdapterService r22 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r22 == null) goto L93;
        r22.ecAnnieLifeCallback(r112, r20);
    L93:
        ConcurrentHashMap<String, NativePrefetch> r113 = NativePrefetchUtil.a;
        NativePrefetchUtil.k("ECPreloadDynamic", "start get resource url is ".concat(r19));
        if (r19.length() != 0) goto L96;
        r1 = true;
    L96:
        if (r1 == false) goto L98;
        r20.a(r19, -1);
    L100:
        return r110.build().toString();
    L98:
        NativePrefetchUtil.c.postDelayed(new com.bytedance.android.ec.core.hybrid.prefetch.b(BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new EcPreloadDynamicCP$getResourceAndDecode$job$1(r19, r20, System.currentTimeMillis(), null), 2, null)), 3000);
        goto L100
    L81:
        if (r111.intValue() != 1) goto L90;
        String r114 = r13.c();
        if (r114 == null) goto L90;
        if (r114.length() <= 0) goto L87;
        boolean r23 = true;
    L88:
        if (r23 == false) goto L90;
        r110.appendQueryParameter("dynamic_url", r114);
        goto L90
    L87:
        r23 = false;
        goto L88
    L109:
        return r14;
    L26:
        if (r16.intValue() != 1) goto L66;
        if (((Boolean) b.getValue()).booleanValue() == false) goto L42;
        ArrayList r24 = new ArrayList();
        int r25 = ECSdk.a;
        IECHostService r26 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r26 == null) goto L32;
        r26.getMallInjectBehavior(r24);
    L32:
        Iterator r27 = r24.iterator();
    L34:
        if (r27.hasNext() == false) goto L40;
        Object r28 = r27.next();
        if ((r28 instanceof com.lynx.tasm.behavior.a) == false) goto L34;
        if (Intrinsics.areEqual(((com.lynx.tasm.behavior.a) r28).getName(), "ecom-foldview-ng") == false) goto L34;
        r1 = true;
        goto L34
    L40:
        if (r1 == true) goto L42;
        return r14;
    L42:
        Uri.Builder r29 = UriProtector.parse(r14).buildUpon().appendQueryParameter("use_na_gyl", "1");
        Integer r30 = r13.b();
        Boolean r31 = null;
        if (r30 != null) goto L46;
    L47:
        String r32 = r13.d();
        if (r32 == null) goto L52;
        int r33 = ECSdk.a;
        s83.g r34 = (s83.g) ECSdk.a(s83.g.class);
        if (r34 == null) goto L52;
        String r115 = r34.e(r14, r32, r15);
    L53:
        if (r115 == null) goto L55;
        r29.appendQueryParameter("gyl_request_id", r115);
    L55:
        int r116 = ECSdk.a;
        IECHostService r117 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r117 == null) goto L59;
        r31 = Boolean.valueOf(r117.getRecommendStatus());
    L59:
        if (Intrinsics.areEqual(r31, Boolean.TRUE) == false) goto L61;
        String r118 = b().d();
    L62:
        if (r118 == null) goto L65;
        r29.appendQueryParameter("gyl_title", r118);
    L65:
        return r29.build().toString();
    L61:
        r118 = b().a();
    L52:
        r115 = null;
        goto L53
    L46:
        if (r30.intValue() == 1) goto L55;
    L110:
        return r14;
    L108:
        return r14;
    L11:
        if (r10.length() == 0) goto L14;
        r11 = false;
        goto L15
    L5:
        r0 = false;
        goto L6
    }
}
