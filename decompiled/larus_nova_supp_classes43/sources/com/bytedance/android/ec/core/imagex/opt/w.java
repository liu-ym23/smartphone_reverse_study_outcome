package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.ab.opt.JSONDefaultLocalConfig;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final w c = null;

    public static final class a implements ReadOnlyProperty<Object, com.bytedance.android.shopping.api.image.k> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public com.bytedance.android.shopping.api.image.k b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.k, java.lang.Object] */
        public final com.bytedance.android.shopping.api.image.k getValue(Object r10, KProperty<?> r11) {
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

        public a(final com.bytedance.android.shopping.api.image.k r10, b r11, Function0 r12, ImageXSettingKt$lazyImageXSettingsOrNull$2 r13) {
            final String r1 = "ec_image_host_replace_opt_config";
            this.c = "ec_image_host_replace_opt_config";
            this.d = r10;
            this.e = r12;
            this.f = r13;
            this.a = new LazyFastSDKSettings("ec_image_host_replace_opt_config", r10, r11, r12, r13, new HostReplaceConfig$$special$$inlined$lazyImageXSettingsOrNull$1$1(r1, r10));
        }
    }

    public static final class b extends JSONDefaultLocalConfig<com.bytedance.android.shopping.api.image.k> {
        public static final b e = null;

        static {
            e = new b();
        }

        public b() {
            super(com.bytedance.android.shopping.api.image.k.class);
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(w.class, "config", "getConfig()Lcom/bytedance/android/shopping/api/image/HostReplaceModel;", 0))};
        final w r0 = new w();
        c = r0;
        com.bytedance.android.shopping.api.image.k r1 = new com.bytedance.android.shopping.api.image.k(null);
        b r10 = b.e;     // Catch: Throwable -> L5
    L6:
        PropertyReference0Impl r11 = new HostReplaceConfig$config$2(r0);
        ImageXSettingKt$lazyImageXSettingsOrNull$2 r12 = new ImageXSettingKt$lazyImageXSettingsOrNull$2(null);
        if (z.b() == false) goto L9;
        ReadOnlyProperty r13 = new a(r1, r10, r11, r12);
    L10:
        b = r13;
        return;
    L9:
        r13 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_host_replace_opt_config", r1, r10, r11, r12);
    L5:
        r10 = null;
        goto L6
    }

    public w() {
    }

    public static boolean a() {
        ImageExperiments.G.getClass();
        return ((Boolean) ImageExperiments.h.getValue()).booleanValue();
    }
}
