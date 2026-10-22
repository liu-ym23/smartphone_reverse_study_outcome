package m12;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
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
    public static final ReadOnlyProperty t = null;

    public static final boolean a() {
        return ((Boolean) t.getValue(null, a[18])).booleanValue();
    }

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_HARMONY_GIFT_PANEL_CONFIG", "getLIVE_GIFT_HARMONY_GIFT_PANEL_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/core/setting/HarmonyGiftPanelSetting;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BUFF_PRE_CHECK", "getLIVE_GIFT_BUFF_PRE_CHECK()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SUPPORT_GIFT", "getLIVE_GIFT_SUPPORT_GIFT()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SUPPORT_GAME_GIFT", "getLIVE_GIFT_SUPPORT_GAME_GIFT()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SUPPORT_GIFT_BY_ID", "getLIVE_GIFT_SUPPORT_GIFT_BY_ID()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_GIFT_PANEL_NOT_SHOW_NOW_GIFT_ID", "getLIVE_HARMONY_GIFT_PANEL_NOT_SHOW_NOW_GIFT_ID()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_PREFETCH_GIFT_ASSETS_ID_LIST", "getLIVE_HARMONY_PREFETCH_GIFT_ASSETS_ID_LIST()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_SYNC_ALL_ASSETS", "getLIVE_HARMONY_SYNC_ALL_ASSETS()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "SEND_GIFT_NOTFANS_DIALOG_ISOPEN", "getSEND_GIFT_NOTFANS_DIALOG_ISOPEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_SEND_LYNX_RED_ENVELOPE_URL", "getLIVE_SEND_LYNX_RED_ENVELOPE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_ENABLE_PROP", "getLIVE_GIFT_ENABLE_PROP()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_ENABLE_STICKER_GIFT", "getLIVE_HARMONY_ENABLE_STICKER_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_ENABLE_PRIZE_MESSAGE", "getLIVE_HARMONY_ENABLE_PRIZE_MESSAGE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_ENABLE_TOP_EFFECT_MESSAGE", "getLIVE_HARMONY_ENABLE_TOP_EFFECT_MESSAGE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_ASSET_INTERCEPTOR_OPT", "getLIVE_HARMONY_ASSET_INTERCEPTOR_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_ASSET_INTERCEPTOR_MEMORY_FIXED", "getLIVE_HARMONY_ASSET_INTERCEPTOR_MEMORY_FIXED()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_HARMONY_ASSET_INTERCEPTOR_PENDING_LIMIT", "getLIVE_HARMONY_ASSET_INTERCEPTOR_PENDING_LIMIT()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_SETTING_HARMONY_ENABLE_GAME_EFFECT", "getLIVE_SETTING_HARMONY_ENABLE_GAME_EFFECT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_EFFECT_LOG_OPT", "getLIVE_GIFT_EFFECT_LOG_OPT()Z", 1))};
        a = r1;
        Class r14 = c.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r15 = vh7.b.a;
        Object r16 = r15.get(r14);
        if (r16 != null) goto L11;
        Constructor r13 = r14.getConstructor(new Class[0]);
        if (r13 == null) goto L10;
        r16 = r15.putIfAbsent(r14, r13);
        if (r16 != null) goto L11;
        r16 = r13;
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L11:
        Object r17 = ((SerializableObjectJsonAdapterBase) ((Constructor) r16).newInstance(new Object[0])).createInstance();
        if (r17 == null) goto L16;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_harmony_gift_panel_config", (c) r17, c.class, false);
        b = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r1[0]);
        Boolean r18 = Boolean.TRUE;
        Class r19 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_harmony_buff_pre_check", r18, r19, false);
        c = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r1[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_harmony_support_gift", CollectionsKt.listOf(new Integer[]{2, 1, 4, 15, 3}), on3.a.b, false);
        d = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r1[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_support_game_gift_ids", CollectionsKt.listOf(new Integer[]{12888, 12725}), on3.a.d, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r1[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_harmony_support_gift_by_id", CollectionsKt.emptyList(), on3.a.c, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r1[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_gift_panel_not_show_now_gift_id", CollectionsKt.listOf(4353), on3.a.e, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r1[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_prefetch_gift_assets_id_list", CollectionsKt.listOf(new Integer[]{2040, 2059, 2060, 2101, 2102, 2104, 2105, 2184, 2213, 4434, 4445, 4735, 4736, 4737, 4738, 4739, 4740, 4741, 5147}), on3.a.f, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r1[6]);
        Boolean r9 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_sync_all_assets", r9, r19, false);
        i = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_notfans_dialog_isopen", r18, r19, false);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r1[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r11 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_lynx_red_envelope_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_short_touch_lynx_douyin%2Fpages%2Fsend_lucky_box%2Ftemplate.js&rate_height=532&type=popup&gravity=bottom&horizontal_width=400&radius=8&web_bg_color=ff161823", String.class, true);
        k = UltraSettingsManager.a().a(r11.a, r11.b, r11.getType(), r11.d, r1[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_harmony_enable_prop", r9, r19, false);
        l = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r1[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r21 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_enable_sticker_gift", r18, r19, false);
        m = UltraSettingsManager.a().a(r21.a, r21.b, r21.getType(), r21.d, r1[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_enable_prize_message", r18, r19, false);
        n = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r1[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_enable_top_effect_message", r18, r19, false);
        o = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r1[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_asset_interceptor_opt", r9, r19, false);
        p = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r1[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_asset_interceptor_memory_fixed", r9, r19, false);
        q = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r1[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_harmony_asset_interceptor_pending_limit", 100, Integer.TYPE, false);
        r = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r1[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_setting_harmony_enable_game_effect", r9, r19, false);
        s = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r1[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_log_opt", r9, r19, false);
        t = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r1[18]);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.setting.HarmonyGiftPanelSetting");
    }
}
