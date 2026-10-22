package y41;

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
public final class e {
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
    public static final e o = null;

    public e() {
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiAnchorLinkEnterRoomOptEnable", "getLiveMultiAnchorLinkEnterRoomOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiAnchorLinkEnterRoomOptConfig", "getLiveMultiAnchorLinkEnterRoomOptConfig()Lcom/bytedance/android/live/revlink/impl/config/AnchorLinkEnterRoomOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveAnchorLinkCompositeOptEnable", "getLiveAnchorLinkCompositeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveAnchorLinkCompositeOptConfig", "getLiveAnchorLinkCompositeOptConfig()Lcom/bytedance/android/live/revlink/impl/config/AnchorLinkOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveAnchorLinkAudienceCompositeOptEnable", "getLiveAnchorLinkAudienceCompositeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiBattleFinishOpt", "getLiveMultiBattleFinishOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiBattleFinishAudienceOpt", "getLiveMultiBattleFinishAudienceOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "multiRevenueAsyncXml", "getMultiRevenueAsyncXml()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiBattleCountDownBackup", "getLiveMultiBattleCountDownBackup()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiMeasureOpt", "getLiveMultiMeasureOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveMultiPersonPKBarBlockReport", "getLiveMultiPersonPKBarBlockReport()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveSilenceRequestMerge", "getLiveSilenceRequestMerge()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "liveDataLinkSwitchToPk", "getLiveDataLinkSwitchToPk()Z", 0))};
        a = r0;
        o = new e();
        Boolean r14 = Boolean.TRUE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_link_enter_room_opt_enable", r14, r15, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r12 = r11.a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r13 = vh7.b.a;
        Object r16 = r13.get(r12);
        if (r16 != null) goto L11;
        Constructor r10 = r12.getConstructor(new Class[0]);
        if (r10 == null) goto L10;
        r16 = r13.putIfAbsent(r12, r10);
        if (r16 != null) goto L11;
        r16 = r10;
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L11:
        Object r17 = ((SerializableObjectJsonAdapterBase) ((Constructor) r16).newInstance(new Object[0])).createInstance();
        if (r17 == null) goto L30;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_link_enter_room_opt_config", (r11.a) r17, r11.a.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_composite_opt_enable", r14, r15, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Class r4 = r11.b.class.getAnnotation(JsonAdapter.class).value();
        Object r5 = r13.get(r4);
        if (r5 != null) goto L23;
        r5 = r4.getConstructor(new Class[0]);
        if (r5 == null) goto L22;
        Object r6 = r13.putIfAbsent(r4, r5);
        if (r6 == null) goto L23;
        r5 = r6;
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L23:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r5).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L28;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_composite_opt_config", (r11.b) r7, r11.b.class, false);
        e = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_audience_composite_opt_enable", r14, r15, false);
        f = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_battle_finish_opt", r14, r15, false);
        g = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_battle_finish_audience_opt", r14, r15, false);
        h = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_async_xml", r14, r15, false);
        i = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_battle_count_down_back_up", r14, r15, false);
        j = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[8]);
        Boolean r23 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_measure_opt", r23, r15, false);
        k = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_person_pk_bar_block_report", r23, r15, false);
        l = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_silence_request_merge", r14, r15, false);
        m = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_data_link_switch_to_pk", r14, r15, false);
        n = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[12]);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.AnchorLinkOptConfig");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.AnchorLinkEnterRoomOptConfig");
    }
}
