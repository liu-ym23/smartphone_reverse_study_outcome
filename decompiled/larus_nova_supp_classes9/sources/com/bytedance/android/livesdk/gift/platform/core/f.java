package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.configmodel.g2;
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
public final class f {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;

    public static final g2 a() {
        return (g2) e.getValue(null, a[3]);
    }

    public static final boolean b() {
        return ((Boolean) b.getValue(null, a[0])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(f.class, "SEND_GIFT_TRACE_LOG_ENABLE", "getSEND_GIFT_TRACE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "SEND_GIFT_ACTION_TRACE_LOG_ENABLE", "getSEND_GIFT_ACTION_TRACE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "RECEIVE_GIFT_TRACE_LOG_ENABLE", "getRECEIVE_GIFT_TRACE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_SEND_PLAY_NOW_CONFIG", "getLIVE_GIFT_SEND_PLAY_NOW_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveSendGiftPlayNowConfig;", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_ENABLE_RECEIVER_ANR_OPT", "getLIVE_GIFT_ENABLE_RECEIVER_ANR_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_NEW_VIDEO_LINK_MODE_SUPPORT_ALLMIC", "getLIVE_GIFT_NEW_VIDEO_LINK_MODE_SUPPORT_ALLMIC()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_ALLMIC_RECEIVER_CHANGE_SUPPORT_CALLBACK", "getLIVE_GIFT_ALLMIC_RECEIVER_CHANGE_SUPPORT_CALLBACK()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_CHANGE_RECEIVER_LIST_SUPPORT_CALLBACK", "getLIVE_GIFT_CHANGE_RECEIVER_LIST_SUPPORT_CALLBACK()Z", 1))};
        a = r0;
        Boolean r10 = Boolean.TRUE;
        Class r11 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_gift_full_link_monitor", r10, r11, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_monitro_send_gift_action", r10, r11, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_receiver_full_link", r10, r11, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Class r4 = g2.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r5 = vh7.b.a;
        Object r13 = r5.get(r4);
        if (r13 != null) goto L12;
        r13 = r4.getConstructor(new Class[0]);
        if (r13 == null) goto L11;
        Object r6 = r5.putIfAbsent(r4, r13);
        if (r6 == null) goto L12;
        r13 = r6;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r13).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_send_play_now_config", (g2) r7, g2.class, false);
        e = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[3]);
        Boolean r9 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r14 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_receiver_anr_opt", r9, r11, false);
        f = UltraSettingsManager.a().a(r14.a, r14.b, r14.getType(), r14.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_social_video_link_allmic", r9, r11, false);
        g = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_allmic_receiver_change_support_callback", r10, r11, false);
        h = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_change_receiver_list_support_callback", r10, r11, false);
        i = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[7]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.RevLiveSendGiftPlayNowConfig");
    }
}
