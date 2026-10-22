package com.bytedance.android.live.revlink.impl.behavior;

import android.text.TextUtils;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(o.class, "ANIM_GAP_MILLS", "getANIM_GAP_MILLS()J", 1)), Reflection.property0(new PropertyReference0Impl(o.class, "TOOLBAR_PK_LEAD_ANIM_FIX", "getTOOLBAR_PK_LEAD_ANIM_FIX()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("toolbar_pk_entrance_anim_gap_mills", 600L, Long.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("toolbar_pk_lead_anim_fix", Boolean.TRUE, Boolean.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }

    public static final b a(LottieAnimationView r4, String r5, c r6) {
        Intrinsics.checkNotNullParameter(r4, "view");
        final f r0 = new f();
        n r7 = new n(new m0(r6), r0);
        if (TextUtils.isEmpty(r5) == true) goto L9;
        if (ImageUtil.isActivityOK(r4.getContext()) == false) goto L9;
        FrescoLoader.with(r4.getContext()).load(r5).actualScaleType(ImageView.ScaleType.CENTER_CROP).autoPlayAnimations(false).controllerListener(new ImageLoader.e(null, r7, false)).into(r4);
    L9:
        return new b(new ToolbarButtonHelperKt$loadGiftImage$2(r0));
    }
}
