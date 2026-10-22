package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Producer;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageBitmapPrepareToDraw {
    public static final /* synthetic */ KProperty[] a = null;
    public static final HashMap<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> b = null;
    public static HashMap<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> c;
    public static final Lazy d = null;
    public static final ReadOnlyProperty e = null;
    public static final ECImageBitmapPrepareToDraw f = null;

    public static final class a implements ReadOnlyProperty<Object, com.bytedance.android.shopping.api.image.a> {
        public static final /* synthetic */ KProperty[] g = null;
        public final LazyFastSDKSettings a;
        public com.bytedance.android.shopping.api.image.a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function2 f;

        static {
            g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.a, java.lang.Object] */
        public final com.bytedance.android.shopping.api.image.a getValue(Object r10, KProperty<?> r11) {
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

        public a(final com.bytedance.android.shopping.api.image.a r10, Function0 r11, ImageXSettingKt$lazyImageXSettingsOrNull$4 r12) {
            final String r1 = "ec_image_bitmap_prepare_to_draw_config";
            this.c = "ec_image_bitmap_prepare_to_draw_config";
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.a = new LazyFastSDKSettings("ec_image_bitmap_prepare_to_draw_config", r10, null, r11, r12, new ECImageBitmapPrepareToDraw$$special$$inlined$lazyImageXSettingsOrNull$1$1(r1, r10));
        }
    }

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ECImageBitmapPrepareToDraw.class, "config", "getConfig()Lcom/bytedance/android/shopping/api/image/ECImageBitmapPrepareToDrawModel;", 0))};
        f = new ECImageBitmapPrepareToDraw();
        b = new HashMap();
        c = new HashMap();
        d = LazyKt.lazy(ECImageBitmapPrepareToDraw$enable$2.INSTANCE);
        com.bytedance.android.shopping.api.image.a r0 = new com.bytedance.android.shopping.api.image.a(null);
        ECImageBitmapPrepareToDraw$config$2 r10 = ECImageBitmapPrepareToDraw$config$2.INSTANCE;
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r11 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L5;
        ReadOnlyProperty r1 = new a(r0, r10, r11);
    L6:
        e = r1;
        return;
    L5:
        r1 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_bitmap_prepare_to_draw_config", r0, null, r10, r11);
        goto L6
    }

    public ECImageBitmapPrepareToDraw() {
    }
}
