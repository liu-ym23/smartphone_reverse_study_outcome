package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.ab.opt.LazyOptGetSettings;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/ImageXModifyConfig;", "Lcom/bytedance/android/ec/core/imagex/common/z;", "Lcom/bytedance/android/ec/core/imagex/opt/e0;", "format", "Lcom/bytedance/android/ec/core/imagex/opt/e0;", "d", "()Lcom/bytedance/android/ec/core/imagex/opt/e0;", "Lcom/bytedance/android/ec/core/imagex/opt/f0;", "quality", "Lcom/bytedance/android/ec/core/imagex/opt/f0;", "f", "()Lcom/bytedance/android/ec/core/imagex/opt/f0;", "Lcom/bytedance/android/ec/core/imagex/opt/g0;", "resize", "Lcom/bytedance/android/ec/core/imagex/opt/g0;", "h", "()Lcom/bytedance/android/ec/core/imagex/opt/g0;", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageXModifyConfig extends com.bytedance.android.ec.core.imagex.common.z {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final ReadOnlyProperty d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final c g = null;

    @SerializedName("format")
    private final e0 format;

    @SerializedName("quality")
    private final f0 quality;

    @SerializedName("resize")
    private final g0 resize;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0004"}, d2 = {"com/bytedance/android/ec/core/opt/ab/LazyFastSDKMultiSettingsKt$lazyFastSDKMultiSettingsOrNull$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/ec/core/imagex/common/r;", "ec-core_saasRelease", "com/bytedance/android/ec/core/imagex/opt/b0"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<com.bytedance.android.ec.core.imagex.common.r<ImageXModifyConfig>> {
        public a() {
        }
    }

    public static final class b implements ReadOnlyProperty<Object, com.bytedance.android.ec.core.imagex.common.p<ImageXModifyConfig>> {
        public static final /* synthetic */ KProperty[] g = null;
        public final Type a;
        public final LazyOptGetSettings b;
        public com.bytedance.android.ec.core.imagex.common.p<ImageXModifyConfig> c;
        public boolean d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Function0 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(b.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Lcom/google/gson/internal/LinkedTreeMap;", 0))};
        }

        public b(Function0 r10) {
            final String r1 = "ec_image_tmpl_modify_config";
            this.e = "ec_image_tmpl_modify_config";
            this.f = r10;
            this.a = new a0().getType();
            final LinkedTreeMap r11 = new LinkedTreeMap();
            ImageXModifyConfig$$special$$inlined$lazyImageXMultiSettingOrNull$2$2 r12 = new ImageXModifyConfig$$special$$inlined$lazyImageXMultiSettingOrNull$2$2(this);
            if (z.b() == false) goto L5;
            LazyOptGetSettings r13 = new LazyFastSDKSettings("ec_image_tmpl_modify_config", r11, null, r10, r12, new ImageXModifyConfig$$special$$inlined$lazyImageXMultiSettingOrNull$2$3(r1, r11));
        L6:
            this.b = r13;
            return;
        L5:
            r13 = com.bytedance.android.ec.core.opt.ab.h.a("ec_image_tmpl_modify_config", r11, null, r10, r12);
            goto L6
        }

        public final Object getValue(Object r10, KProperty r11) {
            Intrinsics.checkNotNullParameter(r10, "thisRef");
            Intrinsics.checkNotNullParameter(r11, "property");
            if (this.d == true) goto L5;
            LinkedTreeMap r12 = (LinkedTreeMap) this.b.getValue(this, g[0]);
        L9:
            return null;
        L5:
            if (ColdLaunchExpFilter.e.b(this.e) == true) goto L9;
            return this.c;
        }
    }

    public static final class c {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(c.class, "config", "getConfig()Lcom/bytedance/android/ec/core/imagex/common/MultiMapConfig;", 0))};
        }

        public c() {
        }

        public static float a() {
            return ((Number) ImageXModifyConfig.f.getValue()).floatValue();
        }
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ImageXModifyConfig) == false) goto L12;
        ImageXModifyConfig r11 = (ImageXModifyConfig) r10;
        if (Intrinsics.areEqual(this.format, r11.format) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.quality, r11.quality) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.resize, r11.resize) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        e0 r0 = this.format;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        f0 r12 = this.quality;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        g0 r15 = this.resize;
        if (r15 == null) goto L14;
        r1 = r15.hashCode();
    L14:
        return r14 + r1;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageXModifyConfig(format=" + this.format + ", quality=" + this.quality + ", resize=" + this.resize + ")";
    }

    static {
        g = new c();
        a = LazyKt.lazy(ImageXModifyConfig$Companion$enable$2.INSTANCE);
        b = LazyKt.lazy(ImageXModifyConfig$Companion$tmplResizeLevelEnableValue$2.INSTANCE);
        c = LazyKt.lazy(ImageXModifyConfig$Companion$tmplResizeLevelEnable$2.INSTANCE);
        ImageXModifyConfig$Companion$config$2 r0 = ImageXModifyConfig$Companion$config$2.INSTANCE;
        if (z.b() == false) goto L5;
        ReadOnlyProperty r1 = new com.bytedance.android.ec.core.opt.ab.e(r0, new a().getType());
    L6:
        d = r1;
        e = LazyKt.lazy(ImageXModifyConfig$Companion$deviceWidth$2.INSTANCE);
        f = LazyKt.lazy(ImageXModifyConfig$Companion$deviceDensity$2.INSTANCE);
        return;
    L5:
        r1 = new b(r0);
        goto L6
    }

    public ImageXModifyConfig() {
        this.format = null;
        this.quality = null;
        this.resize = null;
    }

    public final e0 d() {
        return this.format;
    }

    public final f0 f() {
        return this.quality;
    }

    public final g0 h() {
        return this.resize;
    }
}
