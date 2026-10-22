package com.bytedance.android.livesdk.gift.util;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.livesdk.gift.configmodel.GiftPanelOptConfig;
import com.bytedance.android.livesdk.r3;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftImageLoader {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static int j;
    public static final GiftImageLoader k = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(GiftImageLoader.class, "LIVE_GIFT_PANEL_ICON_FADE_DURATION", "getLIVE_GIFT_PANEL_ICON_FADE_DURATION()I", 0)), Reflection.property1(new PropertyReference1Impl(GiftImageLoader.class, "LIVE_GIFT_PANEL_SELECT_ICON_FADE_DURATION", "getLIVE_GIFT_PANEL_SELECT_ICON_FADE_DURATION()I", 0)), Reflection.property1(new PropertyReference1Impl(GiftImageLoader.class, "DISABLE_IMAGE_MONITOR", "getDISABLE_IMAGE_MONITOR()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftImageLoader.class, "LIVE_GIFT_TRAY_IMAGE_SIZE_UNIFORM", "getLIVE_GIFT_TRAY_IMAGE_SIZE_UNIFORM()Z", 0))};
        a = r0;
        k = new GiftImageLoader();
        Class r7 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_icon_fade_duration", 300, r7, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_select_icon_fade_duration", 300, r7, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r3 = Boolean.FALSE;
        Class r6 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_image_monitor_helper", r3, r6, false);
        d = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_image_size_uniform", r3, r6, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        f = LazyKt.lazy(GiftImageLoader$disableImageMonitor$2.INSTANCE);
        g = LazyKt.lazy(GiftImageLoader$fadeDuration$2.INSTANCE);
        h = LazyKt.lazy(GiftImageLoader$selectFadeDuration$2.INSTANCE);
        i = LazyKt.lazy(GiftImageLoader$giftTrayImageSizeUniform$2.INSTANCE);
        j = -1;
    }

    public GiftImageLoader() {
    }

    public static /* synthetic */ List d(GiftImageLoader r0, k r1, ResizeOptions r2) {
        r0.getClass();
        return c(r1, r2, null, null);
    }

    public static List c(k r7, ResizeOptions r8, Postprocessor r9, String r10) {
        if (r7 == null) goto L37;
        List r0 = r7.getUrls();
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L37;
        ArrayList r2 = new ArrayList();
        Iterator r11 = r7.getUrls().iterator();
    L14:
        if (r11.hasNext() == false) goto L35;
        String r3 = (String) r11.next();
        if (r3.length() != 0) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == true) goto L14;
        ImageRequestBuilder r5 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3));
        GiftPanelOptConfig r6 = (GiftPanelOptConfig) com.bytedance.android.livesdk.gift.platform.business.b.k.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[9]);
        if (r6.a() == true) goto L24;
    L26:
        if (r9 == null) goto L28;
        r5.setPostprocessor(r9);
    L28:
        if (r8 == null) goto L30;
        r5.setResizeOptions(r8);
    L30:
        k.getClass();
        if (((Boolean) f.getValue()).booleanValue() == false) goto L33;
        r5.setRequestListener(new f(r10));
    L34:
        r2.add(r5.build());
        goto L14
    L33:
        new ImageNetworkRequestsMonitor().monitor(r5);
        goto L34
    L24:
        if (((Boolean) r6.a.getValue()).booleanValue() == false) goto L26;
        r5.setCacheChoice(ImageRequest.CacheChoice.CUSTOM).setCustomCacheName("live_gift_fresco_cache");
        goto L26
    L18:
        r4 = false;
        goto L19
    L35:
        return r2;
    L6:
        if (r0.isEmpty() == true) goto L9;
        r1 = false;
    L37:
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ void b(GiftImageLoader r13, SimpleDraweeView r14, k r15, int r16, int r17, int r18, com.bytedance.android.live.core.utils.fresco.b r19, p0 r110, String r20, String r21, int r23) {
        if ((r23 & 8) == 0) goto L5;
        int r3 = 300;
    L7:
        if ((r23 & 64) == 0) goto L9;
        com.bytedance.android.live.core.utils.fresco.b r6 = null;
    L11:
        if ((r23 & 128) == 0) goto L13;
        p0 r7 = null;
    L15:
        if ((r23 & 1024) == 0) goto L17;
        boolean r9 = true;
    L19:
        if ((r23 & 2048) == 0) goto L21;
        String r10 = BuildConfig.FLAVOR;
    L23:
        if ((r23 & 4096) == 0) goto L25;
        String r11 = null;
    L26:
        r13.getClass();
        a(r14, r15, null, r3, r17, r18, r6, r7, false, r9, r10, r11);
        return;
    L25:
        r11 = r21;
        goto L26
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = false;
        goto L19
    L13:
        r7 = r110;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r3 = r16;
        goto L7
    }

    public static void a(SimpleDraweeView r3, k r4, Drawable r5, int r6, int r7, int r8, Postprocessor r9, p0 r10, boolean r11, boolean r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "callerContext");
        if (r3 == null) goto L56;
        if (r4 == null) goto L58;
        List r0 = r4.getUrls();
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L59;
        if (r13 == false) goto L18;
        if (r7 < 0) goto L17;
        if (r8 >= 0) goto L18;
    L17:
        r7 = r3.getMeasuredWidth();
        r8 = r3.getMeasuredHeight();
    L18:
        String r16 = null;
        if (r7 <= 0) goto L22;
        if (r8 <= 0) goto L22;
        ResizeOptions r2 = new ResizeOptions(r7, r8);
    L23:
        List r17 = c(r4, r2, r9, r15);
        if (r17.isEmpty() == false) goto L26;
        return;
    L26:
        PipelineDraweeControllerBuilder r18 = Fresco.newDraweeControllerBuilder().setOldController(r3.getController());
        Object[] r19 = r17.toArray(new ImageRequest[0]);
        if (r19 == null) goto L55;
        PipelineDraweeControllerBuilder r20 = r18.setFirstAvailableImageRequests(r19).setCallerContext(r14);
        if (r11 == false) goto L31;
        r20.setAutoPlayAnimations(true);
    L31:
        if (r5 == null) goto L37;
        if (r3.getHierarchy() != null) goto L35;
        r3.setHierarchy(new GenericDraweeHierarchyBuilder(r3.getContext().getResources()).setFadeDuration(r6).setPlaceholderImage(r5).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
    L40:
        r20.setControllerListener(new ImageLoader.e(r4, r10, false));
        r3.setController(r20.build());
        if (r4.getImageContent() == null) goto L52;
        k.b r21 = r4.getImageContent();
        if (r21 == null) goto L45;
        String r23 = r21.getAccessibilityText();
    L47:
        if (TextUtils.isEmpty(r23) == true) goto L52;
        r3.setFocusable(true);
        r3.setImportantForAccessibility(1);
        k.b r24 = r4.getImageContent();
        if (r24 == null) goto L51;
        r16 = r24.getAccessibilityText();
    L51:
        r3.a(r3, r16);
        return;
    L45:
        r23 = null;
    L52:
        r3.setImportantForAccessibility(2);
        return;
    L35:
        GenericDraweeHierarchy r25 = r3.getHierarchy();
        r25.setFadeDuration(r6);
        r25.setPlaceholderImage(r5);
        r3.setHierarchy(r25);
        goto L40
    L37:
        if (r3.getHierarchy() != null) goto L39;
        r3.setHierarchy(new GenericDraweeHierarchyBuilder(r3.getContext().getResources()).setFadeDuration(r6).build());
        goto L40
    L39:
        GenericDraweeHierarchy r26 = r3.getHierarchy();
        r26.setFadeDuration(r6);
        r3.setHierarchy(r26);
        goto L40
    L55:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L22:
        r2 = null;
        goto L23
    L59:
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    L58:
        return;
    }
}
