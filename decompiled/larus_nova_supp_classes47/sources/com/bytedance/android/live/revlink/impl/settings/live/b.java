package com.bytedance.android.live.revlink.impl.settings.live;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.e;
import r11.g;
import r11.h;

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
    public static final ReadOnlyProperty m = null;
    public static final ReadOnlyProperty n = null;
    public static final ReadOnlyProperty o = null;
    public static final b p = null;

    public b() {
    }

    public final h a() {
        return (h) j.getValue(this, a[8]);
    }

    public final e b() {
        return (e) e.getValue(this, a[3]);
    }

    public final double c() {
        return ((Number) m.getValue(this, a[11])).doubleValue();
    }

    public final w41.e d() {
        return (w41.e) o.getValue(this, a[13]);
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "livePkMixTypeDegradeEnable", "getLivePkMixTypeDegradeEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkPushStreamOptEnable", "getPkPushStreamOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiAnchorDebugEnable", "getMultiAnchorDebugEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkDegradeSetting", "getLiveLinkDegradeSetting()Lcom/bytedance/android/live/revlink/impl/config/LinkPerformanceSetting;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkSingleViewEnable", "getPkSingleViewEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultilinkerDoubleResolutionOptimize", "getLiveMultilinkerDoubleResolutionOptimize()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiAnchorSingleView", "getLiveMultiAnchorSingleView()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "anchorDataHandoverByPkIsStopEngine", "getAnchorDataHandoverByPkIsStopEngine()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "linkParamsDegrade", "getLinkParamsDegrade()Lcom/bytedance/android/live/revlink/impl/config/LinkPushDegradeSetting;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "linkParamsAdjust", "getLinkParamsAdjust()Lcom/bytedance/android/live/revlink/impl/config/LinkPushAdjustSetting;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkEndEnableStreamMixerAnchorSelf", "getLivePkEndEnableStreamMixerAnchorSelf()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkRecordBigSmallRadio", "getLiveLinkRecordBigSmallRadio()D", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkRecordBigSmallOpt", "getLiveLinkRecordBigSmallOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveRevlinkAudioAbnormalOpt", "getLiveRevlinkAudioAbnormalOpt()Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevlinkAudioAbnormalCheckOptConfig;", 0))};
        a = r0;
        p = new b();
        Boolean r14 = Boolean.TRUE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_mix_type_degrade_enable", r14, r15, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r12 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_push_stream_opt_enable", r12, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_debug_enable", r12, r15, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Class r4 = e.class.getAnnotation(JsonAdapter.class).value();
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
        if (r7 == null) goto L59;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_degrade_setting", (e) r7, e.class, false);
        e = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_single_view_enable", r14, r15, false);
        f = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multilinker_double_resolution_optimize", r12, r15, false);
        g = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_single_view", r14, r15, false);
        h = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_data_handover_by_pk_is_stopengine", r14, r15, false);
        i = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[7]);
        Class r18 = h.class.getAnnotation(JsonAdapter.class).value();
        Object r19 = r5.get(r18);
        if (r19 != null) goto L24;
        r19 = r18.getConstructor(new Class[0]);
        if (r19 == null) goto L23;
        Object r20 = r5.putIfAbsent(r18, r19);
        if (r20 == null) goto L24;
        r19 = r20;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r22 = ((SerializableObjectJsonAdapterBase) ((Constructor) r19).newInstance(new Object[0])).createInstance();
        if (r22 == null) goto L57;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_params_degrade", (h) r22, h.class, false);
        j = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[8]);
        Class r24 = g.class.getAnnotation(JsonAdapter.class).value();
        Object r25 = r5.get(r24);
        if (r25 != null) goto L36;
        r25 = r24.getConstructor(new Class[0]);
        if (r25 == null) goto L35;
        Object r26 = r5.putIfAbsent(r24, r25);
        if (r26 == null) goto L36;
        r25 = r26;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r27 = ((SerializableObjectJsonAdapterBase) ((Constructor) r25).newInstance(new Object[0])).createInstance();
        if (r27 == null) goto L55;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_params_adjust", (g) r27, g.class, false);
        k = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_end_enable_stream_mixer_anchor_self", r14, r15, false);
        l = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_record_big_small_radio", Double.valueOf(0.24d), Double.TYPE, false);
        m = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r32 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_record_big_small_opt", r14, r15, false);
        n = UltraSettingsManager.a().a(r32.a, r32.b, r32.getType(), r32.d, r0[12]);
        Class r33 = w41.e.class.getAnnotation(JsonAdapter.class).value();
        Object r34 = r5.get(r33);
        if (r34 != null) goto L48;
        r34 = r33.getConstructor(new Class[0]);
        if (r34 == null) goto L47;
        Object r35 = r5.putIfAbsent(r33, r34);
        if (r35 == null) goto L48;
        r34 = r35;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r36 = ((SerializableObjectJsonAdapterBase) ((Constructor) r34).newInstance(new Object[0])).createInstance();
        if (r36 == null) goto L53;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r37 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_audio_abnormal_opt", (w41.e) r36, w41.e.class, false);
        o = UltraSettingsManager.a().a(r37.a, r37.b, r37.getType(), r37.d, r0[13]);
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.live.model.RevlinkAudioAbnormalCheckOptConfig");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LinkPushAdjustSetting");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LinkPushDegradeSetting");
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LinkPerformanceSetting");
    }
}
