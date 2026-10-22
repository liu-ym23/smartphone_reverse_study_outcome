package com.bytedance.android.live.revlink.impl.settings.dynamic;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
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
    public static final b m = null;

    public b() {
    }

    public final c a() {
        return (c) b.getValue(this, a[0]);
    }

    public final boolean b() {
        return ((Boolean) f.getValue(this, a[4])).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) h.getValue(this, a[6])).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) k.getValue(this, a[9])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "config", "getConfig()Lcom/bytedance/android/live/revlink/impl/settings/dynamic/MultiDynamicConfig;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiDelayWidget", "getLiveMultiDelayWidget()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiLoadPVEBar", "getLiveMultiLoadPVEBar()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiDynamicMeasureOpt", "getLiveMultiDynamicMeasureOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiDynamicMeasureOptV2", "getLiveMultiDynamicMeasureOptV2()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiFeedMeasureOpt", "getLiveMultiFeedMeasureOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiEventOpt", "getLiveMultiEventOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiEmptyEventOpt", "getLiveMultiEmptyEventOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkTimeEventOpt", "getLiveLinkTimeEventOpt()I", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiFeedJsbOpt", "getLiveMultiFeedJsbOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiDynamicHarmonyUrl", "getLiveMultiDynamicHarmonyUrl()Ljava/lang/String;", 0))};
        a = r0;
        m = new b();
        Class r13 = c.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r14 = vh7.b.a;
        Object r15 = r14.get(r13);
        if (r15 != null) goto L12;
        r15 = r13.getConstructor(new Class[0]);
        if (r15 == null) goto L11;
        Object r16 = r14.putIfAbsent(r13, r15);
        if (r16 == null) goto L12;
        r15 = r16;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r17 = ((SerializableObjectJsonAdapterBase) ((Constructor) r15).newInstance(new Object[0])).createInstance();
        if (r17 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_dynamic_config", (c) r17, c.class, true);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r18 = Boolean.FALSE;
        Class r19 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_delay_widget", r18, r19, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r3 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_load_pve_bar", r3, r19, false);
        d = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_dynamic_measure_opt", r18, r19, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_dynamic_measure_opt_v2", r18, r19, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_feed_measure_opt", r18, r19, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_event_opt", r3, r19, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_empty_event_opt", r3, r19, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_time_event_opt", 0, Integer.TYPE, false);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_feed_event_opt", r18, r19, false);
        k = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_dynamic_harmony_url", LinkMultiDynamicSettingsKt.c, String.class, false);
        l = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[10]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.dynamic.MultiDynamicConfig");
    }

    public static String e(boolean r4) {
        a r0 = a.H;
        r0.getClass();
        ReadOnlyProperty r1 = a.D;
        KProperty[] r2 = a.a;
        if (((Boolean) r1.getValue(r0, r2[28])).booleanValue() == false) goto L7;
        if (r4 == true) goto L7;
        return (String) a.E.getValue(r0, r2[29]);
    L7:
        return (String) a.d.getValue(r0, r2[2]);
    }
}
