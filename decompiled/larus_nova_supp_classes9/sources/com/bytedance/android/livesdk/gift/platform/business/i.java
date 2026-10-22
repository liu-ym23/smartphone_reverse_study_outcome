package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.livesdk.config.e0;
import com.bytedance.android.livesdk.config.v31;
import com.bytedance.android.livesdk.gift.configmodel.i0;
import com.bytedance.android.livesdk.gift.configmodel.m;
import com.bytedance.android.livesdk.gift.configmodel.s0;
import com.bytedance.android.livesdk.gift.configmodel.t1;
import com.bytedance.android.livesdk.gift.configmodel.v1;
import com.bytedance.android.livesdk.gift.configmodel.z;
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
public final class i {
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
    public static final ReadOnlyProperty u = null;
    public static final ReadOnlyProperty v = null;
    public static final ReadOnlyProperty w = null;
    public static final ReadOnlyProperty x = null;

    public static final com.bytedance.android.livesdk.gift.configmodel.f a() {
        return (com.bytedance.android.livesdk.gift.configmodel.f) c.getValue(null, a[1]);
    }

    public static final v31 b() {
        return (v31) d.getValue(null, a[2]);
    }

    public static final com.bytedance.android.livesdk.gift.configmodel.e c() {
        return (com.bytedance.android.livesdk.gift.configmodel.e) s.getValue(null, a[17]);
    }

    public static final e0 d() {
        return (e0) f.getValue(null, a[4]);
    }

    public static final com.bytedance.android.livesdk.gift.configmodel.h e() {
        return (com.bytedance.android.livesdk.gift.configmodel.h) q.getValue(null, a[15]);
    }

    public static final com.bytedance.android.livesdk.gift.configmodel.d f() {
        return (com.bytedance.android.livesdk.gift.configmodel.d) o.getValue(null, a[13]);
    }

    public static final boolean g() {
        return ((Boolean) w.getValue(null, a[21])).booleanValue();
    }

    public static final i0 h() {
        return (i0) n.getValue(null, a[12]);
    }

    public static final m i() {
        return (m) e.getValue(null, a[3]);
    }

    public static final boolean j() {
        return ((Boolean) g.getValue(null, a[5])).booleanValue();
    }

    public static final boolean k() {
        return ((Boolean) l.getValue(null, a[10])).booleanValue();
    }

    public static final s0 l() {
        return (s0) t.getValue(null, a[18]);
    }

    public static final v1 m() {
        return (v1) r.getValue(null, a[16]);
    }

    public static final t1 n() {
        return (t1) x.getValue(null, a[22]);
    }

    public static final z o() {
        return (z) b.getValue(null, a[0]);
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_NEW_GIFT_RESOURCE_DOWNLOADER", "getLIVE_NEW_GIFT_RESOURCE_DOWNLOADER()Lcom/bytedance/android/livesdk/gift/configmodel/GiftDownloadManagerOpt;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "GIFT_RESOURCE_FIND_OPT", "getGIFT_RESOURCE_FIND_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/AssetFindOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ASSET_DELETE_OPTIMIZE_CONFIG", "getLIVE_ASSET_DELETE_OPTIMIZE_CONFIG()Lcom/bytedance/android/livesdk/config/LiveGiftCleanOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_CLEAN_STRATEGY_CONFIG", "getLIVE_GIFT_CLEAN_STRATEGY_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/CleanStrategyConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ASSET_MANUAL_CLEAN_GIFT_CACHE", "getLIVE_ASSET_MANUAL_CLEAN_GIFT_CACHE()Lcom/bytedance/android/livesdk/config/AssetManualCleanCacheConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_DOWNLOAD_MAIN_THREAD_ENABLE", "getLIVE_GIFT_DOWNLOAD_MAIN_THREAD_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_RESOURCE_MANAGER_ON_FAIL_ANR_OPT", "getLIVE_GIFT_RESOURCE_MANAGER_ON_FAIL_ANR_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_EFFECT_DOWNLOAD_SUPPORT_DYNAMIC", "getLIVE_EFFECT_DOWNLOAD_SUPPORT_DYNAMIC()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_CANCEL_ASSET_DOWNLOAD_EXIST_ROOM", "getLIVE_CANCEL_ASSET_DOWNLOAD_EXIST_ROOM()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_CLEAR_DOWNLOAD_LISTENER_EXIST_ROOM", "getLIVE_CLEAR_DOWNLOAD_LISTENER_EXIST_ROOM()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_LIST_AND_ASSET_ADD_HEADER", "getLIVE_GIFT_LIST_AND_ASSET_ADD_HEADER()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ASSET_CLEAN_ENABLE", "getLIVE_ASSET_CLEAN_ENABLE()Lcom/bytedance/android/livesdk/gift/configmodel/AssetCleanEnableConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_ASSET_CDN_OPT", "getLIVE_GIFT_ASSET_CDN_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/GiftImageCdnOpt;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_DOWNLOAD_ASSET_CONFIG", "getLIVE_DOWNLOAD_ASSET_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/AssetDownloadConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_DEEP_CLEAN_DOWNLOAD_DOWNGRADE_ENABLE", "getLIVE_GIFT_DEEP_CLEAN_DOWNLOAD_DOWNGRADE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ASSET_SERVICE_OPT_CONFIG", "getLIVE_ASSET_SERVICE_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/AssetServiceOpt;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_SHOW_NOW_CONFIG", "getLIVE_GIFT_SHOW_NOW_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/NewGiftShowNowConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ASSET_DOWNLOAD_QUEUE_OPT", "getLIVE_ASSET_DOWNLOAD_QUEUE_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/AssetDownloadQueueConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_PANEL_GIFT_JUMP_OPT", "getLIVE_GIFT_PANEL_GIFT_JUMP_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelJumpOpt;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_ENABLE_MOCK_GIFT_MESSAGE_AND_TRACE", "getLIVE_GIFT_ENABLE_MOCK_GIFT_MESSAGE_AND_TRACE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GIFT_GIFT_LIST_CHANGED_BY_SELECT_USER", "getLIVE_GIFT_GIFT_LIST_CHANGED_BY_SELECT_USER()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_FETCH_PROP_USE_TO_USER_ID", "getLIVE_FETCH_PROP_USE_TO_USER_ID()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MOSTLY_USED_OPT", "getLIVE_MOSTLY_USED_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/MostlyUsedGiftConfig;", 1))};
        a = r0;
        Class r14 = z.class.getAnnotation(JsonAdapter.class).value();
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
        if (r17 == null) goto L184;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_downloader_enable", (z) r17, z.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r11 = com.bytedance.android.livesdk.gift.configmodel.f.class.getAnnotation(JsonAdapter.class).value();
        Object r18 = r15.get(r11);
        if (r18 != null) goto L23;
        r18 = r11.getConstructor(new Class[0]);
        if (r18 == null) goto L22;
        Object r19 = r15.putIfAbsent(r11, r18);
        if (r19 == null) goto L23;
        r18 = r19;
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L23:
        Object r110 = ((SerializableObjectJsonAdapterBase) ((Constructor) r18).newInstance(new Object[0])).createInstance();
        if (r110 == null) goto L182;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_resource_find_opt", (com.bytedance.android.livesdk.gift.configmodel.f) r110, com.bytedance.android.livesdk.gift.configmodel.f.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Class r5 = v31.class.getAnnotation(JsonAdapter.class).value();
        Object r111 = r15.get(r5);
        if (r111 != null) goto L35;
        r111 = r5.getConstructor(new Class[0]);
        if (r111 == null) goto L34;
        Object r6 = r15.putIfAbsent(r5, r111);
        if (r6 == null) goto L35;
        r111 = r6;
        goto L35
    L34:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L35:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r111).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L180;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_asset_delete_optimize_config", (v31) r7, v31.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Class r4 = m.class.getAnnotation(JsonAdapter.class).value();
        Object r8 = r15.get(r4);
        if (r8 != null) goto L47;
        r8 = r4.getConstructor(new Class[0]);
        if (r8 == null) goto L46;
        Object r9 = r15.putIfAbsent(r4, r8);
        if (r9 == null) goto L47;
        r8 = r9;
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L47:
        Object r10 = ((SerializableObjectJsonAdapterBase) ((Constructor) r8).newInstance(new Object[0])).createInstance();
        if (r10 == null) goto L178;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_clean_strategy_config", (m) r10, m.class, false);
        e = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[3]);
        Class r21 = e0.class.getAnnotation(JsonAdapter.class).value();
        Object r23 = r15.get(r21);
        if (r23 != null) goto L59;
        r23 = r21.getConstructor(new Class[0]);
        if (r23 == null) goto L58;
        Object r24 = r15.putIfAbsent(r21, r23);
        if (r24 == null) goto L59;
        r23 = r24;
        goto L59
    L58:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L59:
        Object r25 = ((SerializableObjectJsonAdapterBase) ((Constructor) r23).newInstance(new Object[0])).createInstance();
        if (r25 == null) goto L176;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_asset_clean_in_room_config", (e0) r25, e0.class, false);
        f = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[4]);
        Boolean r27 = Boolean.FALSE;
        Class r28 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_download_main_thread_enable", r27, r28, false);
        g = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_manager_on_fail_anr_opt", r27, r28, false);
        h = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[6]);
        Boolean r31 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r33 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_effect_download_logic_support_dynamic", r31, r28, false);
        i = UltraSettingsManager.a().a(r33.a, r33.b, r33.getType(), r33.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r34 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_cancel_asset_download_exist_room", r27, r28, false);
        j = UltraSettingsManager.a().a(r34.a, r34.b, r34.getType(), r34.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r35 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_clear_download_listener_exist_room", r27, r28, false);
        k = UltraSettingsManager.a().a(r35.a, r35.b, r35.getType(), r35.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r36 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_and_asset_add_header", r27, r28, false);
        l = UltraSettingsManager.a().a(r36.a, r36.b, r36.getType(), r36.d, r0[10]);
        Class r37 = com.bytedance.android.livesdk.gift.configmodel.c.class.getAnnotation(JsonAdapter.class).value();
        Object r38 = r15.get(r37);
        if (r38 != null) goto L71;
        r38 = r37.getConstructor(new Class[0]);
        if (r38 == null) goto L70;
        Object r39 = r15.putIfAbsent(r37, r38);
        if (r39 == null) goto L71;
        r38 = r39;
        goto L71
    L70:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L71:
        Object r40 = ((SerializableObjectJsonAdapterBase) ((Constructor) r38).newInstance(new Object[0])).createInstance();
        if (r40 == null) goto L174;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r41 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_clean_config_enable", (com.bytedance.android.livesdk.gift.configmodel.c) r40, com.bytedance.android.livesdk.gift.configmodel.c.class, false);
        m = UltraSettingsManager.a().a(r41.a, r41.b, r41.getType(), r41.d, r0[11]);
        Class r43 = i0.class.getAnnotation(JsonAdapter.class).value();
        Object r44 = r15.get(r43);
        if (r44 != null) goto L83;
        r44 = r43.getConstructor(new Class[0]);
        if (r44 == null) goto L82;
        Object r45 = r15.putIfAbsent(r43, r44);
        if (r45 == null) goto L83;
        r44 = r45;
        goto L83
    L82:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L83:
        Object r46 = ((SerializableObjectJsonAdapterBase) ((Constructor) r44).newInstance(new Object[0])).createInstance();
        if (r46 == null) goto L172;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r47 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_asset_cdn_opt", (i0) r46, i0.class, false);
        n = UltraSettingsManager.a().a(r47.a, r47.b, r47.getType(), r47.d, r0[12]);
        Class r48 = com.bytedance.android.livesdk.gift.configmodel.d.class.getAnnotation(JsonAdapter.class).value();
        Object r49 = r15.get(r48);
        if (r49 != null) goto L95;
        r49 = r48.getConstructor(new Class[0]);
        if (r49 == null) goto L94;
        Object r50 = r15.putIfAbsent(r48, r49);
        if (r50 == null) goto L95;
        r49 = r50;
        goto L95
    L94:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L95:
        Object r51 = ((SerializableObjectJsonAdapterBase) ((Constructor) r49).newInstance(new Object[0])).createInstance();
        if (r51 == null) goto L170;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r53 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_download_asset_config", (com.bytedance.android.livesdk.gift.configmodel.d) r51, com.bytedance.android.livesdk.gift.configmodel.d.class, false);
        o = UltraSettingsManager.a().a(r53.a, r53.b, r53.getType(), r53.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r54 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_deep_clean_download_downgrade_enable", r31, r28, false);
        p = UltraSettingsManager.a().a(r54.a, r54.b, r54.getType(), r54.d, r0[14]);
        Class r55 = com.bytedance.android.livesdk.gift.configmodel.h.class.getAnnotation(JsonAdapter.class).value();
        Object r56 = r15.get(r55);
        if (r56 != null) goto L107;
        r56 = r55.getConstructor(new Class[0]);
        if (r56 == null) goto L106;
        Object r57 = r15.putIfAbsent(r55, r56);
        if (r57 == null) goto L107;
        r56 = r57;
        goto L107
    L106:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L107:
        Object r58 = ((SerializableObjectJsonAdapterBase) ((Constructor) r56).newInstance(new Object[0])).createInstance();
        if (r58 == null) goto L168;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r59 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_service_opt_config", (com.bytedance.android.livesdk.gift.configmodel.h) r58, com.bytedance.android.livesdk.gift.configmodel.h.class, false);
        q = UltraSettingsManager.a().a(r59.a, r59.b, r59.getType(), r59.d, r0[15]);
        Class r60 = v1.class.getAnnotation(JsonAdapter.class).value();
        Object r61 = r15.get(r60);
        if (r61 != null) goto L119;
        r61 = r60.getConstructor(new Class[0]);
        if (r61 == null) goto L118;
        Object r63 = r15.putIfAbsent(r60, r61);
        if (r63 == null) goto L119;
        r61 = r63;
        goto L119
    L118:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L119:
        Object r64 = ((SerializableObjectJsonAdapterBase) ((Constructor) r61).newInstance(new Object[0])).createInstance();
        if (r64 == null) goto L166;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r65 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_show_now_config", (v1) r64, v1.class, false);
        r = UltraSettingsManager.a().a(r65.a, r65.b, r65.getType(), r65.d, r0[16]);
        Class r66 = com.bytedance.android.livesdk.gift.configmodel.e.class.getAnnotation(JsonAdapter.class).value();
        Object r67 = r15.get(r66);
        if (r67 != null) goto L131;
        r67 = r66.getConstructor(new Class[0]);
        if (r67 == null) goto L130;
        Object r68 = r15.putIfAbsent(r66, r67);
        if (r68 == null) goto L131;
        r67 = r68;
        goto L131
    L130:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L131:
        Object r69 = ((SerializableObjectJsonAdapterBase) ((Constructor) r67).newInstance(new Object[0])).createInstance();
        if (r69 == null) goto L164;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r70 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_download_queue_opt", (com.bytedance.android.livesdk.gift.configmodel.e) r69, com.bytedance.android.livesdk.gift.configmodel.e.class, false);
        s = UltraSettingsManager.a().a(r70.a, r70.b, r70.getType(), r70.d, r0[17]);
        Class r71 = s0.class.getAnnotation(JsonAdapter.class).value();
        Object r73 = r15.get(r71);
        if (r73 != null) goto L143;
        r73 = r71.getConstructor(new Class[0]);
        if (r73 == null) goto L142;
        Object r74 = r15.putIfAbsent(r71, r73);
        if (r74 == null) goto L143;
        r73 = r74;
        goto L143
    L142:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L143:
        Object r75 = ((SerializableObjectJsonAdapterBase) ((Constructor) r73).newInstance(new Object[0])).createInstance();
        if (r75 == null) goto L162;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r76 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_gift_jump_opt", (s0) r75, s0.class, false);
        t = UltraSettingsManager.a().a(r76.a, r76.b, r76.getType(), r76.d, r0[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r77 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_mock_gift_message_and_trace", r31, r28, false);
        u = UltraSettingsManager.a().a(r77.a, r77.b, r77.getType(), r77.d, r0[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r78 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_changed_by_select_user", r31, r28, false);
        v = UltraSettingsManager.a().a(r78.a, r78.b, r78.getType(), r78.d, r0[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r79 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fetch_prop_use_to_user_id", r31, r28, false);
        w = UltraSettingsManager.a().a(r79.a, r79.b, r79.getType(), r79.d, r0[21]);
        Class r80 = t1.class.getAnnotation(JsonAdapter.class).value();
        Object r81 = r15.get(r80);
        if (r81 != null) goto L155;
        r81 = r80.getConstructor(new Class[0]);
        if (r81 == null) goto L154;
        Object r83 = r15.putIfAbsent(r80, r81);
        if (r83 == null) goto L155;
        r81 = r83;
        goto L155
    L154:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L155:
        Object r84 = ((SerializableObjectJsonAdapterBase) ((Constructor) r81).newInstance(new Object[0])).createInstance();
        if (r84 == null) goto L160;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r85 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_edit_mostly_used_gift_config", (t1) r84, t1.class, false);
        x = UltraSettingsManager.a().a(r85.a, r85.b, r85.getType(), r85.d, r0[22]);
        return;
    L160:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.MostlyUsedGiftConfig");
    L162:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.GiftPanelJumpOpt");
    L164:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.AssetDownloadQueueConfig");
    L166:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.NewGiftShowNowConfig");
    L168:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.AssetServiceOpt");
    L170:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.AssetDownloadConfig");
    L172:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.GiftImageCdnOpt");
    L174:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.AssetCleanEnableConfig");
    L176:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.AssetManualCleanCacheConfig");
    L178:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.CleanStrategyConfig");
    L180:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.LiveGiftCleanOptConfig");
    L182:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.AssetFindOptConfig");
    L184:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.GiftDownloadManagerOpt");
    }
}
