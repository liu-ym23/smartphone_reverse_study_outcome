package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.opt.ImageXSettingKt$lazyImageXSettingsOrNull$4;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ImageExperiments {
    public static final Lazy A = null;
    public static final Lazy B = null;
    public static final ReadOnlyProperty C = null;
    public static final Lazy D = null;
    public static final Lazy E = null;
    public static final Lazy F = null;
    public static final ImageExperiments G = null;
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public static final Lazy s = null;
    public static final Lazy t = null;
    public static final Lazy u = null;
    public static final Lazy v = null;
    public static final Lazy w = null;
    public static final Lazy x = null;
    public static final Lazy y = null;
    public static final Lazy z = null;

    public static final class a implements ReadOnlyProperty<Object, e> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public e b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.ec.core.imagex.e, java.lang.Object] */
        public final e getValue(Object r10, KProperty<?> r11) {
            Intrinsics.checkNotNullParameter(r10, "thisRef");
            Intrinsics.checkNotNullParameter(r11, "property");
            if (this.b != null) goto L5;
            LazyFastSDKSettings r12 = this.a;
            KProperty<?>[] r0 = g;
            if (r12.getValue(this, r0[0]) == this.d) goto L15;
            this.b = this.a.getValue(this, r0[0]);
            if (ColdLaunchExpFilter.e.b(this.c) == true) goto L15;
            return this.b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.e.b(this.c) == false) goto L8;
            return null;
        L8:
            return this.b;
        }

        public a(final e r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_image_decode_rgb_565_config";
            this.c = "ec_image_decode_rgb_565_config";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_image_decode_rgb_565_config", r10, null, r11, r12, new ImageExperiments$$special$$inlined$lazyImageXSettingsOrNull$1$1(r1, r10));
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ImageExperiments.class, "decodeRGB565Config", "getDecodeRGB565Config()Lcom/bytedance/android/ec/core/imagex/ECImageCustomDecodeRGBConfig;", 0))};
        G = new ImageExperiments();
        b = LazyKt.lazy(ImageExperiments$urlTransformEnable$2.INSTANCE);
        c = LazyKt.lazy(ImageExperiments$urlTransformConfigKeys$2.INSTANCE);
        d = LazyKt.lazy(ImageExperiments$imageRenderMonitorEnable$2.INSTANCE);
        e = LazyKt.lazy(ImageExperiments$ecImageMiddlewareUrlEditCacheEnable$2.INSTANCE);
        f = LazyKt.lazy(ImageExperiments$ecImageMiddlewareUrlEditCacheSize$2.INSTANCE);
        g = LazyKt.lazy(ImageExperiments$all$2.INSTANCE);
        h = LazyKt.lazy(ImageExperiments$ecImageHostReplaceOptEnable$2.INSTANCE);
        i = LazyKt.lazy(ImageExperiments$ecImageSlcLoaderHookerEnable$2.INSTANCE);
        j = LazyKt.lazy(ImageExperiments$ecImageSingleAsyncWorkerOpt$2.INSTANCE);
        k = LazyKt.lazy(ImageExperiments$ecImageAbSettingsGetOpt$2.INSTANCE);
        l = LazyKt.lazy(ImageExperiments$ecImagePreloadAsyncWorkerOpt$2.INSTANCE);
        m = LazyKt.lazy(ImageExperiments$ecImagePreloadAsyncPriority$2.INSTANCE);
        n = LazyKt.lazy(ImageExperiments$ecSliceImageRequestBuildCacheSize$2.INSTANCE);
        o = LazyKt.lazy(ImageExperiments$ecGoodsImagePlaceholderEnable$2.INSTANCE);
        p = LazyKt.lazy(ImageExperiments$ecGoodsImageDefaultResizeOptionsEnable$2.INSTANCE);
        q = LazyKt.lazy(ImageExperiments$ecLynxImagePreloadEnable$2.INSTANCE);
        r = LazyKt.lazy(ImageExperiments$ecLynxImageLoadUrlLogEnable$2.INSTANCE);
        s = LazyKt.lazy(ImageExperiments$ecLynxImageLoadUrlCacheEnable$2.INSTANCE);
        t = LazyKt.lazy(ImageExperiments$ecomImageBehaviorDefaultEnable$2.INSTANCE);
        u = LazyKt.lazy(ImageExperiments$ecImageDefaultUseEcomImage$2.INSTANCE);
        v = LazyKt.lazy(ImageExperiments$useOriginImageLoad$2.INSTANCE);
        w = LazyKt.lazy(ImageExperiments$ecSliceLocalDurationOpt$2.INSTANCE);
        x = LazyKt.lazy(ImageExperiments$useNewLynxImageConfig$2.INSTANCE);
        y = LazyKt.lazy(ImageExperiments$useNewLynxImageType$2.INSTANCE);
        z = LazyKt.lazy(ImageExperiments$decodeRGB565EnableConfig$2.INSTANCE);
        A = LazyKt.lazy(ImageExperiments$decodeRGB565Enable$2.INSTANCE);
        B = LazyKt.lazy(ImageExperiments$decodeRGB565EnableNew$2.INSTANCE);
        e r0 = new e(null);
        ImageExperiments$decodeRGB565Config$2 r10 = ImageExperiments$decodeRGB565Config$2.INSTANCE;
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r11 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L5;
        ReadOnlyProperty r1 = new a(r0, r10, r11);
    L6:
        C = r1;
        D = LazyKt.lazy(ImageExperiments$pdpDetailImageMemoryOptEnable$2.INSTANCE);
        E = LazyKt.lazy(ImageExperiments$immediatePriorityConfig$2.INSTANCE);
        F = LazyKt.lazy(ImageExperiments$imageDeferInvalidationConfig$2.INSTANCE);
        return;
    L5:
        r1 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_decode_rgb_565_config", r0, null, r10, r11);
        goto L6
    }

    public ImageExperiments() {
    }

    public static HashMap b() {
        return (HashMap) g.getValue();
    }

    public static boolean c() {
        return ((Boolean) u.getValue()).booleanValue();
    }

    public static final int a() {
        int r0 = com.bytedance.android.ec.core.imagex.opt.h0.a;
        Object r1 = 1;
        Object r10 = null;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L172;
        int r11 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L165
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L165
        SDKSettingsCacheManager r13 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L165
        r13.getClass();     // Catch: Throwable -> L55
        Object r14 = SDKSettingsCacheManager.b.get("ec_image_url_transform_enable");     // Catch: Throwable -> L55
        if (r14 != null) goto L10;
    L52:
        Object r15 = null;
    L53:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L55
    L57:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L165
        if (r17 == null) goto L61;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L165
    L61:
        if (Result.isFailure-impl(r16) == false) goto L64;
        r16 = null;
    L64:
        if ((r16 instanceof Integer) == true) goto L66;
        r16 = null;
    L66:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L165
        if (r18 != null) goto L73;
        r13.getClass();     // Catch: Throwable -> L165
        Object r19 = SDKSettingsCacheManager.a.get("ec_image_url_transform_enable");     // Catch: Throwable -> L165
        if ((r19 instanceof Integer) == true) goto L72;
        r19 = null;
    L72:
        r18 = (Integer) r19;     // Catch: Throwable -> L165
    L73:
        if (r18 != null) goto L338;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L165
    L152:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L165
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L155:
        if (Result.exceptionOrNull-impl(r22) != null) goto L354;
    L162:
        r18 = r22;
    L163:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L165
        SDKSettingsCacheManager.e("ec_image_url_transform_enable", r18);     // Catch: Throwable -> L165
        goto L338
    L354:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_image_url_transform_enable", Integer.class, r1);     // Catch: Throwable -> L159
    L160:
        if (r22 != null) goto L162;
        r18 = r1;
    L159:
        r22 = r1;
        goto L160
    L339:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L126
        Object r23 = SDKSettingsCacheManager.b.get("ec_image_url_transform_enable");     // Catch: Throwable -> L126
        if (r23 != null) goto L81;
    L123:
        Object r24 = null;
    L124:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L126
    L128:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L152
        if (r26 == null) goto L132;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L152
    L132:
        if (Result.isFailure-impl(r25) == false) goto L135;
        r25 = null;
    L135:
        if ((r25 instanceof Integer) == true) goto L137;
        r25 = null;
    L137:
        r22 = (Integer) r25;     // Catch: Throwable -> L152
        if (r22 != null) goto L162;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L152
        Object r28 = jj4.a.a("ec_image_url_transform_enable", Integer.class, r1, false);     // Catch: Throwable -> L152
        if (r28 != null) goto L144;
        Intrinsics.throwNpe();     // Catch: Throwable -> L152
    L144:
        if ((r28 instanceof Integer) == false) goto L147;
        r10 = r28;
    L147:
        Object r29 = (Integer) r10;     // Catch: Throwable -> L152
        if (r29 != null) goto L150;
        r29 = r1;
    L150:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L152
    L81:
        if ((r23 instanceof Integer) == true) goto L83;
        Object r30 = null;
    L84:
        r24 = (Integer) r30;     // Catch: Throwable -> L126
        if (r24 != null) goto L124;
        if ((r23 instanceof Number) == false) goto L111;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L126
        if ((r31 instanceof Integer) == true) goto L94;
        r31 = null;
    L94:
        r24 = (Integer) r31;     // Catch: Throwable -> L126
        goto L124
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L126
        if ((r32 instanceof Integer) == true) goto L100;
        r32 = null;
    L100:
        r24 = (Integer) r32;     // Catch: Throwable -> L126
        goto L124
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L105;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L126
        goto L124
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L111;
        Long r33 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L126
        if ((r33 instanceof Integer) == true) goto L109;
        r33 = null;
    L109:
        r24 = (Integer) r33;     // Catch: Throwable -> L126
    L111:
        if ((r23 instanceof JSONObject) == false) goto L113;
    L352:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L119
        if ((r34 instanceof Integer) == true) goto L117;
        r34 = null;
    L117:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L119
    L121:
        r24 = r35;
        if (Result.isFailure-impl(r24) == false) goto L124;
    L119:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L126
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L126
        goto L121
    L113:
        if ((r23 instanceof JSONArray) == false) goto L123;
    L83:
        r30 = r23;
    L126:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L152
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L152
    L338:
        return ((Number) r18).intValue();
    L10:
        if ((r14 instanceof Integer) == true) goto L12;
        Object r38 = null;
    L13:
        r15 = (Integer) r38;     // Catch: Throwable -> L55
        if (r15 != null) goto L53;
        if ((r14 instanceof Number) == false) goto L40;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r39 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L55
        if ((r39 instanceof Integer) == true) goto L23;
        r39 = null;
    L23:
        r15 = (Integer) r39;     // Catch: Throwable -> L55
        goto L53
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r40 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L55
        if ((r40 instanceof Integer) == true) goto L29;
        r40 = null;
    L29:
        r15 = (Integer) r40;     // Catch: Throwable -> L55
        goto L53
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L34;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L55
        goto L53
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L40;
        Long r41 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L55
        if ((r41 instanceof Integer) == true) goto L38;
        r41 = null;
    L38:
        r15 = (Integer) r41;     // Catch: Throwable -> L55
    L40:
        if ((r14 instanceof JSONObject) == false) goto L42;
    L350:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L48
        if ((r42 instanceof Integer) == true) goto L46;
        r42 = null;
    L46:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L48
    L50:
        r15 = r43;
        if (Result.isFailure-impl(r15) == false) goto L53;
    L48:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L55
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
        goto L50
    L42:
        if ((r14 instanceof JSONArray) == false) goto L52;
    L12:
        r38 = r14;
    L55:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L165
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L170;
        EnsureManager.ensureNotReachHere(r48);
    L170:
        if (Result.isFailure-impl(r47) == true) goto L336;
    L335:
        r1 = r47;
    L336:
        r18 = r1;
        goto L338
    L172:
        int r49 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r50 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L328
        Object r52 = com.bytedance.android.ec.base.settings.d.c.get("ec_image_url_transform_enable");     // Catch: Throwable -> L223
        if (r52 != null) goto L178;
    L220:
        Object r53 = null;
    L221:
        Object r54 = Result.constructor-impl(r53);     // Catch: Throwable -> L223
    L225:
        Throwable r55 = Result.exceptionOrNull-impl(r54);     // Catch: Throwable -> L328
        if (r55 == null) goto L229;
        EnsureManager.ensureNotReachHere(r55);     // Catch: Throwable -> L328
    L229:
        if (Result.isFailure-impl(r54) == false) goto L232;
        r54 = null;
    L232:
        if ((r54 instanceof Integer) == true) goto L234;
        r54 = null;
    L234:
        Object r56 = (Integer) r54;     // Catch: Throwable -> L328
        if (r56 != null) goto L241;
        Object r57 = com.bytedance.android.ec.base.settings.d.a.get("ec_image_url_transform_enable");     // Catch: Throwable -> L328
        if ((r57 instanceof Integer) == true) goto L240;
        r57 = null;
    L240:
        r56 = (Integer) r57;     // Catch: Throwable -> L328
    L241:
        if (r56 == null) goto L243;
    L242:
        r18 = r56;
        goto L338
    L243:
        int r58 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L328
        Object r59 = com.bytedance.android.ec.base.settings.d.c.get("ec_image_url_transform_enable");     // Catch: Throwable -> L293
        if (r59 != null) goto L248;
    L290:
        Object r60 = null;
    L291:
        Object r61 = Result.constructor-impl(r60);     // Catch: Throwable -> L293
    L295:
        Throwable r62 = Result.exceptionOrNull-impl(r61);     // Catch: Throwable -> L319
        if (r62 == null) goto L299;
        EnsureManager.ensureNotReachHere(r62);     // Catch: Throwable -> L319
    L299:
        if (Result.isFailure-impl(r61) == false) goto L302;
        r61 = null;
    L302:
        if ((r61 instanceof Integer) == true) goto L304;
        r61 = null;
    L304:
        r56 = (Integer) r61;     // Catch: Throwable -> L319
        if (r56 != null) goto L326;
        IHybridHostService r63 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L319
        if (r63 == null) goto L310;
        Object r64 = r63.getHostABValue("ec_image_url_transform_enable", r1);     // Catch: Throwable -> L319
    L311:
        if (r64 != null) goto L313;
    L325:
        r56 = r1;
        goto L326
    L313:
        if ((r64 instanceof Integer) == false) goto L316;
        r10 = r64;
    L316:
        r56 = (Integer) r10;     // Catch: Throwable -> L319
        if (r56 != null) goto L326;
    L310:
        r64 = null;
    L326:
        com.bytedance.android.ec.base.settings.d.d("ec_image_url_transform_enable", r56);     // Catch: Throwable -> L328
        goto L242
    L248:
        if ((r59 instanceof Integer) == true) goto L250;
        Object r65 = null;
    L251:
        r60 = (Integer) r65;     // Catch: Throwable -> L293
        if (r60 != null) goto L291;
        if ((r59 instanceof Number) == false) goto L278;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L263;
        Float r66 = Float.valueOf(((Number) r59).floatValue());     // Catch: Throwable -> L293
        if ((r66 instanceof Integer) == true) goto L261;
        r66 = null;
    L261:
        r60 = (Integer) r66;     // Catch: Throwable -> L293
        goto L291
    L263:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L269;
        Double r67 = Double.valueOf(((Number) r59).doubleValue());     // Catch: Throwable -> L293
        if ((r67 instanceof Integer) == true) goto L267;
        r67 = null;
    L267:
        r60 = (Integer) r67;     // Catch: Throwable -> L293
        goto L291
    L269:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L272;
        r60 = Integer.valueOf(((Number) r59).intValue());     // Catch: Throwable -> L293
        goto L291
    L272:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L278;
        Long r68 = Long.valueOf(((Number) r59).longValue());     // Catch: Throwable -> L293
        if ((r68 instanceof Integer) == true) goto L276;
        r68 = null;
    L276:
        r60 = (Integer) r68;     // Catch: Throwable -> L293
    L278:
        if ((r59 instanceof JSONObject) == false) goto L280;
    L358:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L286
        Object r69 = SDKSettingsCacheManager.a().fromJson(r59.toString(), Integer.class);     // Catch: Throwable -> L286
        if ((r69 instanceof Integer) == true) goto L284;
        r69 = null;
    L284:
        Object r70 = Result.constructor-impl((Integer) r69);     // Catch: Throwable -> L286
    L288:
        r60 = r70;
        if (Result.isFailure-impl(r60) == false) goto L291;
    L286:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L293
        r70 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L293
        goto L288
    L280:
        if ((r59 instanceof JSONArray) == false) goto L290;
    L250:
        r65 = r59;
    L319:
        th = move-exception;
        Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L328
        r56 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
        Throwable r73 = Result.exceptionOrNull-impl(r56);     // Catch: Throwable -> L328
        if (r73 == null) goto L324;
        EnsureManager.ensureNotReachHere(r73);     // Catch: Throwable -> L328
    L324:
        if (Result.isFailure-impl(r56) == false) goto L326;
    L293:
        th = move-exception;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L319
        r61 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L319
        goto L295
    L178:
        if ((r52 instanceof Integer) == true) goto L180;
        Object r75 = null;
    L181:
        r53 = (Integer) r75;     // Catch: Throwable -> L223
        if (r53 != null) goto L221;
        if ((r52 instanceof Number) == false) goto L208;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L193;
        Float r76 = Float.valueOf(((Number) r52).floatValue());     // Catch: Throwable -> L223
        if ((r76 instanceof Integer) == true) goto L191;
        r76 = null;
    L191:
        r53 = (Integer) r76;     // Catch: Throwable -> L223
        goto L221
    L193:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L199;
        Double r77 = Double.valueOf(((Number) r52).doubleValue());     // Catch: Throwable -> L223
        if ((r77 instanceof Integer) == true) goto L197;
        r77 = null;
    L197:
        r53 = (Integer) r77;     // Catch: Throwable -> L223
        goto L221
    L199:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L202;
        r53 = Integer.valueOf(((Number) r52).intValue());     // Catch: Throwable -> L223
        goto L221
    L202:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L208;
        Long r78 = Long.valueOf(((Number) r52).longValue());     // Catch: Throwable -> L223
        if ((r78 instanceof Integer) == true) goto L206;
        r78 = null;
    L206:
        r53 = (Integer) r78;     // Catch: Throwable -> L223
    L208:
        if ((r52 instanceof JSONObject) == false) goto L210;
    L356:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L216
        Object r79 = SDKSettingsCacheManager.a().fromJson(r52.toString(), Integer.class);     // Catch: Throwable -> L216
        if ((r79 instanceof Integer) == true) goto L214;
        r79 = null;
    L214:
        Object r80 = Result.constructor-impl((Integer) r79);     // Catch: Throwable -> L216
    L218:
        r53 = r80;
        if (Result.isFailure-impl(r53) == false) goto L221;
    L216:
        th = move-exception;
        Result.Companion r81 = Result.Companion;     // Catch: Throwable -> L223
        r80 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L223
        goto L218
    L210:
        if ((r52 instanceof JSONArray) == false) goto L220;
    L180:
        r75 = r52;
    L223:
        th = move-exception;
        Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L328
        r54 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
    L328:
        th = move-exception;
        Result.Companion r83 = Result.Companion;
        r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r84 = Result.exceptionOrNull-impl(r47);
        if (r84 == null) goto L333;
        EnsureManager.ensureNotReachHere(r84);
    L333:
        if (Result.isFailure-impl(r47) == false) goto L335;
        goto L335
    }
}
