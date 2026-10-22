package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.ab.opt.LazyOptGetSettings;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ImageNetworkPriorityOpt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final LazyOptGetSettings c = null;
    public static final ImageNetworkPriorityOpt d = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ImageNetworkPriorityOpt.class, "config", "getConfig()Lcom/bytedance/android/shopping/api/image/NetworkPriorityModel;", 0))};
        d = new ImageNetworkPriorityOpt();
        b = LazyKt.lazy(ImageNetworkPriorityOpt$enable$2.INSTANCE);
        final String r10 = "ec_image_network_priority_config";
        final com.bytedance.android.shopping.api.image.e0 r11 = new com.bytedance.android.shopping.api.image.e0(null);
        ImageNetworkPriorityOpt$config$2 r12 = ImageNetworkPriorityOpt$config$2.INSTANCE;
        ImageXSettingKt$lazyImageXSettings$4 r13 = new ImageXSettingKt$lazyImageXSettings$4(null);
        if (z.b() == false) goto L5;
        LazyOptGetSettings r0 = new LazyFastSDKSettings("ec_image_network_priority_config", r11, null, r12, r13, new ImageNetworkPriorityOpt$$special$$inlined$lazyImageXSettings$1(r10, r11));
    L6:
        c = r0;
        return;
    L5:
        r0 = com.bytedance.android.ec.core.opt.ab.h.a("ec_image_network_priority_config", r11, null, r12, r13);
        goto L6
    }

    public ImageNetworkPriorityOpt() {
    }
}
