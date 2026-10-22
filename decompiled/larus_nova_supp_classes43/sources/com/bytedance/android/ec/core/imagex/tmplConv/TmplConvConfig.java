package com.bytedance.android.ec.core.imagex.tmplConv;

import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;
import com.bytedance.android.ec.core.imagex.opt.ImageXModifyConfig;
import com.bytedance.android.ec.core.imagex.opt.ImageXSettingKt$lazyImageXSettingsOrNull$4;
import com.bytedance.android.ec.core.imagex.opt.z;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.bytedance.android.shopping.api.image.h;
import com.bytedance.android.shopping.api.image.p0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class TmplConvConfig {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final TmplConvConfig k = null;

    public static final class a implements ReadOnlyProperty<Object, p0> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public p0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.p0, java.lang.Object] */
        public final p0 getValue(Object r10, KProperty<?> r11) {
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

        public a(final p0 r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_image_tmpl_convergence";
            this.c = "ec_image_tmpl_convergence";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_image_tmpl_convergence", r10, null, r11, r12, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$1$1(r1, r10));
        }
    }

    public static final class b implements ReadOnlyProperty<Object, p0> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public p0 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(b.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.p0, java.lang.Object] */
        public final p0 getValue(Object r10, KProperty<?> r11) {
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

        public b(final p0 r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_image_format_convergence";
            this.c = "ec_image_format_convergence";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_image_format_convergence", r10, null, r11, r12, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$2$1(r1, r10));
        }
    }

    public static final class c implements ReadOnlyProperty<Object, h> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public h b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(c.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.h, java.lang.Object] */
        public final h getValue(Object r10, KProperty<?> r11) {
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

        public c(final h r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_tmpl_conv_global_mather";
            this.c = "ec_tmpl_conv_global_mather";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_tmpl_conv_global_mather", r10, null, r11, r12, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$3$1(r1, r10));
        }
    }

    public static final class d implements ReadOnlyProperty<Object, h> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public h b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(d.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.h, java.lang.Object] */
        public final h getValue(Object r10, KProperty<?> r11) {
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

        public d(final h r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_edit_url_global_mather";
            this.c = "ec_edit_url_global_mather";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_edit_url_global_mather", r10, null, r11, r12, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$4$1(r1, r10));
        }
    }

    public static final class e implements ReadOnlyProperty<Object, h> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public h b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(e.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.h, java.lang.Object] */
        public final h getValue(Object r10, KProperty<?> r11) {
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

        public e(final h r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_big_image_cache_opt_config";
            this.c = "ec_big_image_cache_opt_config";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_big_image_cache_opt_config", r10, null, r11, r12, new TmplConvConfig$$special$$inlined$lazyImageXSettingsOrNull$5$1(r1, r10));
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "tmplConfig", "getTmplConfig()Lcom/bytedance/android/shopping/api/image/TmplConvModel;", 0)), Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "formatConfig", "getFormatConfig()Lcom/bytedance/android/shopping/api/image/TmplConvModel;", 0)), Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "globalMather", "getGlobalMather()Lcom/bytedance/android/shopping/api/image/GlobalMather;", 0)), Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "editUrlGlobalMather", "getEditUrlGlobalMather()Lcom/bytedance/android/shopping/api/image/GlobalMather;", 0)), Reflection.property1(new PropertyReference1Impl(TmplConvConfig.class, "bigImageCacheOptMather", "getBigImageCacheOptMather()Lcom/bytedance/android/shopping/api/image/GlobalMather;", 0))};
        final TmplConvConfig r0 = new TmplConvConfig();
        k = r0;
        p0 r1 = new p0(null);
        TmplConvConfig$tmplConfig$2 r10 = new TmplConvConfig$tmplConfig$2(r0);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r11 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L5;
        ReadOnlyProperty r12 = new a(r1, r10, r11);
    L6:
        b = r12;
        p0 r13 = new p0(null);
        PropertyReference0Impl r14 = new TmplConvConfig$formatConfig$2(r0);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r15 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L9;
        ReadOnlyProperty r16 = new b(r13, r14, r15);
    L10:
        c = r16;
        h r17 = new h(null);
        TmplConvConfig$globalMather$2 r18 = new TmplConvConfig$globalMather$2(r0);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r19 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L13;
        ReadOnlyProperty r20 = new c(r17, r18, r19);
    L14:
        d = r20;
        h r21 = new h(null);
        TmplConvConfig$editUrlGlobalMather$2 r22 = new TmplConvConfig$editUrlGlobalMather$2(r0);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r23 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L17;
        ReadOnlyProperty r24 = new d(r21, r22, r23);
    L18:
        e = r24;
        h r25 = new h(null);
        PropertyReference0Impl r26 = new TmplConvConfig$bigImageCacheOptMather$2(r0);
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r27 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L21;
        ReadOnlyProperty r28 = new e(r25, r26, r27);
    L22:
        f = r28;
        g = LazyKt.lazy(TmplConvConfig$tmplEnable$2.INSTANCE);
        h = LazyKt.lazy(TmplConvConfig$formatEnable$2.INSTANCE);
        i = LazyKt.lazy(TmplConvConfig$offlineUrlTransformEnable$2.INSTANCE);
        j = LazyKt.lazy(TmplConvConfig$bigImageCacheOptEnable$2.INSTANCE);
        return;
    L21:
        r28 = com.bytedance.android.ec.core.opt.ab.h.b("ec_big_image_cache_opt_config", r25, null, r26, r27);
        goto L22
    L17:
        r24 = com.bytedance.android.ec.core.opt.ab.h.b("ec_edit_url_global_mather", r21, null, r22, r23);
        goto L18
    L13:
        r20 = com.bytedance.android.ec.core.opt.ab.h.b("ec_tmpl_conv_global_mather", r17, null, r18, r19);
        goto L14
    L9:
        r16 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_format_convergence", r13, null, r14, r15);
        goto L10
    L5:
        r12 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_tmpl_convergence", r1, null, r10, r11);
        goto L6
    }

    public TmplConvConfig() {
    }

    public final p0 b() {
        return (p0) b.getValue(this, a[0]);
    }

    public static boolean a() {
        if (((Boolean) g.getValue()).booleanValue() == false) goto L5;
    L12:
        return true;
    L5:
        if (((Boolean) h.getValue()).booleanValue() == true) goto L12;
        ECImageMultiSizeReuseOpt.e.getClass();
        if (ECImageMultiSizeReuseOpt.g() == true) goto L12;
        ImageXModifyConfig.g.getClass();
        if (((Boolean) ImageXModifyConfig.a.getValue()).booleanValue() == true) goto L12;
        return false;
    }
}
