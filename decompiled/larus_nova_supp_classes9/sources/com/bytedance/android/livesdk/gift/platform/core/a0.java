package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.configmodel.f1;
import com.bytedance.android.livesdk.gift.configmodel.j1;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final ReadOnlyProperty j = null;
    public static final ReadOnlyProperty k = null;
    public static final ReadOnlyProperty l = null;
    public static final ReadOnlyProperty m = null;
    public static final ReadOnlyProperty n = null;
    public static final ReadOnlyProperty o = null;
    public static final ReadOnlyProperty p = null;
    public static final ReadOnlyProperty q = null;

    public static final boolean a() {
        return ((Boolean) d.getValue(null, a[2])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) p.getValue(null, a[14])).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) n.getValue(null, a[12])).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) q.getValue(null, a[15])).booleanValue();
    }

    public static final j1 e() {
        return (j1) c.getValue(null, a[1]);
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_ENABLE_ASSETS_DOWNLOAD_CACHE_KEY", "getLIVE_GIFT_ENABLE_ASSETS_DOWNLOAD_CACHE_KEY()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_PANEL_STUTTER_OPT", "getLIVE_GIFT_PANEL_STUTTER_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/LiveGiftPanelStutterOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_EFFECTS_UPDATE_INCREMENT", "getLIVE_EFFECTS_UPDATE_INCREMENT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GET_ASSET_FILE_SIZE_OPT", "getLIVE_GET_ASSET_FILE_SIZE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_IMAGE_FORMAT_WEBP_OPT", "getLIVE_GIFT_IMAGE_FORMAT_WEBP_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_RESOURCE_CHECK_ANR_OPT", "getLIVE_GIFT_RESOURCE_CHECK_ANR_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_SUPPORT_PK_EFFECT_GIFT", "getLIVE_SUPPORT_PK_EFFECT_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_ASSET_CACHE_DELETE_NEW_STRATEGY", "getLIVE_ASSET_CACHE_DELETE_NEW_STRATEGY()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_ASSET_ENTERROOM_DOWNLOAD_STATUS", "getLIVE_ASSET_ENTERROOM_DOWNLOAD_STATUS()I", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_GUEST_PRE_DOWNLOAD_ENABLE", "getLIVE_GIFT_GUEST_PRE_DOWNLOAD_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "ENABLE_ASSETS_DELETE_TIME_LIMIT", "getENABLE_ASSETS_DELETE_TIME_LIMIT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GET_DISK_AVAILABLE_SIZE_OPT", "getLIVE_GET_DISK_AVAILABLE_SIZE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_BUFF_SHOW_NOW", "getLIVE_GIFT_BUFF_SHOW_NOW()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_ASSET_RESPONSE_OPT", "getLIVE_GIFT_ASSET_RESPONSE_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/LiveEffectListOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_ASSET_FIND_FAIL_REPORT", "getLIVE_GIFT_ASSET_FIND_FAIL_REPORT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_EFFECT_JSB_FORCE_RENDER_FILTER", "getLIVE_GIFT_EFFECT_JSB_FORCE_RENDER_FILTER()Z", 1))};
        a = r0;
        Boolean r14 = Boolean.FALSE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_assets_download_cache_key", r14, r15, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r13 = j1.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r16 = vh7.b.a;
        Object r17 = r16.get(r13);
        if (r17 != null) goto L11;
        Constructor r10 = r13.getConstructor(new Class[0]);
        if (r10 == null) goto L10;
        r17 = r16.putIfAbsent(r13, r10);
        if (r17 != null) goto L11;
        r17 = r10;
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L11:
        Object r11 = ((SerializableObjectJsonAdapterBase) ((Constructor) r17).newInstance(new Object[0])).createInstance();
        if (r11 == null) goto L30;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_stutter_opt_config", (j1) r11, j1.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r5 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_effects_update_increment", r5, r15, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_get_asset_file_size_opt", r14, r15, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_image_format_use_webp", r14, r15, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_check_anr_opt", r14, r15, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_support_pk_effect_gift", r14, r15, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_cache_detele_new_strategy", r5, r15, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_enterroom_download_status", 0, Integer.TYPE, false);
        j = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_guest_pre_download_enable", r5, r15, false);
        k = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_assets_delete_time_limit", r5, r15, false);
        l = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r21 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_get_disk_available_size_opt", r14, r15, false);
        m = UltraSettingsManager.a().a(r21.a, r21.b, r21.getType(), r21.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_buff_show_now", r14, r15, false);
        n = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[12]);
        Class r24 = f1.class.getAnnotation(JsonAdapter.class).value();
        Object r25 = r16.get(r24);
        if (r25 != null) goto L23;
        r25 = r24.getConstructor(new Class[0]);
        if (r25 == null) goto L22;
        Object r26 = r16.putIfAbsent(r24, r25);
        if (r26 == null) goto L23;
        r25 = r26;
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L23:
        Object r27 = ((SerializableObjectJsonAdapterBase) ((Constructor) r25).newInstance(new Object[0])).createInstance();
        if (r27 == null) goto L28;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_effect_list_api_opt_config", (f1) r27, f1.class, false);
        o = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_asset_find_fail_report", r14, r15, false);
        p = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_jsb_force_render_filter", r14, r15, false);
        q = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[15]);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.LiveEffectListOptConfig");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.LiveGiftPanelStutterOptConfig");
    }
}
