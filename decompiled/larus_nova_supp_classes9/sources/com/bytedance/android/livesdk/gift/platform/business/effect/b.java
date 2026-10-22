package com.bytedance.android.livesdk.gift.platform.business.effect;

import com.bytedance.android.livesdk.gift.configmodel.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
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
public final class b {
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
    public static final ReadOnlyProperty r = null;
    public static final ReadOnlyProperty s = null;

    public static final boolean a() {
        return ((Boolean) d.getValue(null, a[2])).booleanValue();
    }

    public static final long b() {
        return ((Number) o.getValue(null, a[13])).longValue();
    }

    public static final long c() {
        return ((Number) r.getValue(null, a[16])).longValue();
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ASSETS_MANAGER_READ_SETTING_OPTIMIZE", "getLIVE_ASSETS_MANAGER_READ_SETTING_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_MULTI_ASSET_FAST_PLAY_ENABLE", "getLIVE_GIFT_MULTI_ASSET_FAST_PLAY_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_H265_RESOURCE_ENABLE", "getLIVE_GIFT_H265_RESOURCE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SUPER_IMAGE_RESOLUTION_ENABLE", "getLIVE_GIFT_SUPER_IMAGE_RESOLUTION_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ASSET_CANCEL_DOWNLOAD_STORAGE_POOL", "getLIVE_ASSET_CANCEL_DOWNLOAD_STORAGE_POOL()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_EFFECT_DURATION_OPT", "getLIVE_STICKER_EFFECT_DURATION_OPT()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_EFFECT_TRACE_OPT", "getLIVE_STICKER_EFFECT_TRACE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_EFFECT_CANCEL_CREATE_PNG", "getLIVE_STICKER_EFFECT_CANCEL_CREATE_PNG()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_ISSUE_REPORT_GIFT_INFO", "getLIVE_GIFT_ISSUE_REPORT_GIFT_INFO()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_EFFECT_FIRST_FRAME", "getLIVE_STICKER_EFFECT_FIRST_FRAME()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_STICKER_EFFECT_OPT_CONFIG", "getLIVE_GIFT_STICKER_EFFECT_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/core/sticker/GiftStickerSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_EFFECT_MESSAGE_LISTENER_ENABLE", "getLIVE_GIFT_EFFECT_MESSAGE_LISTENER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_DISABLE_GUEST_FACE_GIFT", "getLIVE_DISABLE_GUEST_FACE_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_STICKER_MESSAGE_EXPIRED_TIME_SECONDS", "getLIVE_GIFT_STICKER_MESSAGE_EXPIRED_TIME_SECONDS()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_GIFT_SUPPORT_RESET_TIME", "getLIVE_STICKER_GIFT_SUPPORT_RESET_TIME()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_TALK_LINK_VIEW_LEAK_OPT", "getLIVE_TALK_LINK_VIEW_LEAK_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_GIFT_EFFECT_PLAY_INTERVAL", "getLIVE_STICKER_GIFT_EFFECT_PLAY_INTERVAL()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SEND_TO_EFFECT_CONFIG", "getLIVE_GIFT_SEND_TO_EFFECT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LiveGiftEffectCommunicateConfig;", 1))};
        a = r0;
        Boolean r14 = Boolean.TRUE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_assets_manager_read_setting_optimize", r14, r15, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r13 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_multi_asset_fast_play_enable", r13, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_h265_resource_enable", r13, r15, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_265_super_resource_enable", r13, r15, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_cancel_download_storage_pool", -1, Integer.TYPE, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        Long r6 = Long.valueOf(IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        Class r7 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_effect_duration_opt", r6, r7, false);
        g = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_effect_trace_opt", r14, r15, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_effect_cancel_create_png", r14, r15, false);
        i = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r11 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_issue_report_gift_info", r14, r15, false);
        j = UltraSettingsManager.a().a(r11.a, r11.b, r11.getType(), r11.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_effect_first_frame_log", r14, r15, false);
        k = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[9]);
        Class r17 = com.bytedance.android.livesdk.gift.platform.core.sticker.a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r18 = vh7.b.a;
        Object r19 = r18.get(r17);
        if (r19 != null) goto L12;
        r19 = r17.getConstructor(new Class[0]);
        if (r19 == null) goto L11;
        Object r20 = r18.putIfAbsent(r17, r19);
        if (r20 == null) goto L12;
        r19 = r20;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r21 = ((SerializableObjectJsonAdapterBase) ((Constructor) r19).newInstance(new Object[0])).createInstance();
        if (r21 == null) goto L31;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sticker_effect_opt_config", (com.bytedance.android.livesdk.gift.platform.core.sticker.a) r21, com.bytedance.android.livesdk.gift.platform.core.sticker.a.class, false);
        l = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_message_listener_enable", r14, r15, false);
        m = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_guest_face_gift", r13, r15, false);
        n = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sticker_message_expired_time_seconds", Long.valueOf(300), r7, false);
        o = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_face_sticker_reset_time_enable", r13, r15, false);
        p = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_talk_link_view_leak_opt", r14, r15, false);
        q = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_gift_effect_play_interval", Long.valueOf(0), r7, false);
        r = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[16]);
        Class r30 = h1.class.getAnnotation(JsonAdapter.class).value();
        Object r31 = r18.get(r30);
        if (r31 != null) goto L24;
        r31 = r30.getConstructor(new Class[0]);
        if (r31 == null) goto L23;
        Object r33 = r18.putIfAbsent(r30, r31);
        if (r33 == null) goto L24;
        r31 = r33;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r34 = ((SerializableObjectJsonAdapterBase) ((Constructor) r31).newInstance(new Object[0])).createInstance();
        if (r34 == null) goto L29;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r35 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_communication_config", (h1) r34, h1.class, false);
        s = UltraSettingsManager.a().a(r35.a, r35.b, r35.getType(), r35.d, r0[17]);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.LiveGiftEffectCommunicateConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.sticker.GiftStickerSettingConfig");
    }
}
