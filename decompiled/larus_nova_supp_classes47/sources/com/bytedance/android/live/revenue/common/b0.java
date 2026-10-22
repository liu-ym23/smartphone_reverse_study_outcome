package com.bytedance.android.live.revenue.common;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b0.class, "LIVE_MEDIA_SPILT_MODE_ENABLE", "getLIVE_MEDIA_SPILT_MODE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "LOCAL_TEST_USE_ONLINE_GECKO", "getLOCAL_TEST_USE_ONLINE_GECKO()Z", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "LIVE_ANCHOR_DEVICE_RECORD_SCORE", "getLIVE_ANCHOR_DEVICE_RECORD_SCORE()F", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "LIVE_AUDIENCE_DEVICE_OVERALL_SCORE", "getLIVE_AUDIENCE_DEVICE_OVERALL_SCORE()F", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "LIVE_REVENUE_MIGRATE_ANNIEX", "getLIVE_REVENUE_MIGRATE_ANNIEX()Lcom/bytedance/android/live/revenue/common/settings/LiveRevenueAnnieXConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "REVENUE_LUCKY_BOX_SERVICE_SCHEMA", "getREVENUE_LUCKY_BOX_SERVICE_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "REVENUE_DYNAMIC_SWITCHES", "getREVENUE_DYNAMIC_SWITCHES()Lcom/bytedance/android/live/revenue/common/settings/RevenueDynamicSwitches;", 1))};
        a = r0;
        Boolean r9 = Boolean.TRUE;
        Class r10 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_media_spilt_mode_enable", r9, r10, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("local_test_use_online_gecko", Boolean.FALSE, r10, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Float r5 = Float.valueOf(7.5f);
        Class r12 = Float.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_device_model_record_score", r5, r12, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_device_model_overall_score", r5, r12, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_migrate_anniex", new ay0.b(), ay0.b.class, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_lucky_box_service_schema", "https://10.79.163.16:8787/services/main.js", String.class, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        Class r8 = ay0.d.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r13 = vh7.b.a;
        Object r14 = r13.get(r8);
        if (r14 != null) goto L12;
        r14 = r8.getConstructor(new Class[0]);
        if (r14 == null) goto L11;
        Object r15 = r13.putIfAbsent(r8, r14);
        if (r15 == null) goto L12;
        r14 = r15;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r16 = ((SerializableObjectJsonAdapterBase) ((Constructor) r14).newInstance(new Object[0])).createInstance();
        if (r16 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_dynamic_switches", (ay0.d) r16, ay0.d.class, false);
        h = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[6]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.common.settings.RevenueDynamicSwitches");
    }

    public static final ay0.b a() {
        return (ay0.b) f.getValue(null, a[4]);
    }

    public static final ay0.d b() {
        return (ay0.d) h.getValue(null, a[6]);
    }
}
