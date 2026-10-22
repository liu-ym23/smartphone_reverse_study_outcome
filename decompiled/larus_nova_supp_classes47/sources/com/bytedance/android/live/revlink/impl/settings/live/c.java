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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final c D = null;
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
    public static final ReadOnlyProperty y = null;
    public static final ReadOnlyProperty z = null;

    public c() {
    }

    public final boolean a() {
        return ((Boolean) y.getValue(this, a[23])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(c.class, "livePkMixStreamOpt", "getLivePkMixStreamOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "anchorSeiDeDuplicationOptEnable", "getAnchorSeiDeDuplicationOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveMultiAnchorSeiLoadBackupEnable", "getLiveMultiAnchorSeiLoadBackupEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveSeiCloseLoadEnable", "getLiveSeiCloseLoadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "anchorSeiUpdateEnable", "getAnchorSeiUpdateEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "ignorePkMixStreamCheck", "getIgnorePkMixStreamCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "anchorPkCloseSei", "getAnchorPkCloseSei()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "seiDuplicateRemoveEnable", "getSeiDuplicateRemoveEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveRevenuePlayerDuplicateCheck", "getLiveRevenuePlayerDuplicateCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveRevPlayerBlockMultiEvent", "getLiveRevPlayerBlockMultiEvent()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "checkSeiValidByString", "getCheckSeiValidByString()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveMultiAnchorSeiUpdate", "getLiveMultiAnchorSeiUpdate()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveMultiAnchorSortSeiGuest", "getLiveMultiAnchorSortSeiGuest()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkHandleRevSeiAfterReply", "getLivePkHandleRevSeiAfterReply()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkReplyRtcSeiTimerRepeatInterval", "getLivePkReplyRtcSeiTimerRepeatInterval()I", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkReplyRtcSeiTimeDuration", "getLivePkReplyRtcSeiTimeDuration()J", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "multiAnchorFirstFrameThreshold", "getMultiAnchorFirstFrameThreshold()J", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "multiLinkSelfAnchorPauseFixDisable", "getMultiLinkSelfAnchorPauseFixDisable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveCheckJsonSwitch", "getLiveCheckJsonSwitch()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkGetExtraFirstSEI", "getLivePkGetExtraFirstSEI()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "linkSeiUidAudienceShrink", "getLinkSeiUidAudienceShrink()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveSeiTimeoutConfig", "getLiveSeiTimeoutConfig()Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevAudienceSeiCheckConfig;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "revLinkSeiBackupOptConfig", "getRevLinkSeiBackupOptConfig()Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkSeiBackupOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "revLinkSeiCheckStop", "getRevLinkSeiCheckStop()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "revLinkSeiUnloadConfig", "getRevLinkSeiUnloadConfig()Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkSeiUnloadConfig;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "loadPkSeiBlackList", "getLoadPkSeiBlackList()[Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePKGuestNotConsumeSeiBackUp", "getLivePKGuestNotConsumeSeiBackUp()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveRevLinkSeiWriteP", "getLiveRevLinkSeiWriteP()Z", 0))};
        a = r0;
        D = new c();
        Boolean r14 = Boolean.TRUE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_mixstream_opt", r14, r15, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_sei_de_duplication_opt_enable", r14, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_sei_load_backup_enable", r14, r15, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_close_load_enable", r14, r15, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        Boolean r5 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_pk_update_enable", r5, r15, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("ignore_mix_stream_check", r14, r15, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_pk_close_sei", r14, r15, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("sei_duplicate_removal_enable", r14, r15, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_player_duplicate_check", r14, r15, false);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_player_block_multi_event", r14, r15, false);
        k = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r13 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("check_sei_valid_by_string", r5, r15, false);
        l = UltraSettingsManager.a().a(r13.a, r13.b, r13.getType(), r13.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_sei_update", r14, r15, false);
        m = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_sort_sei_guest", r14, r15, false);
        n = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_handle_rev_sei_after_reply", r14, r15, false);
        o = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_reply_rtc_sei_timer_repeat_interval", 500, Integer.TYPE, false);
        p = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[14]);
        Class r20 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_reply_rtc_sei_timer_duration", 12L, r20, false);
        q = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_first_frame_threshold", 8500L, r20, false);
        r = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_self_anchor_pause_fix_disable", r5, r15, false);
        s = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_json_switch", r14, r15, false);
        t = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_get_extra_first_sei", r14, r15, false);
        u = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_intimatechat_sei_fields_simplify_uid", r5, r15, false);
        v = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[20]);
        Class r28 = w41.a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r29 = vh7.b.a;
        Object r30 = r29.get(r28);
        if (r30 != null) goto L12;
        r30 = r28.getConstructor(new Class[0]);
        if (r30 == null) goto L11;
        Object r32 = r29.putIfAbsent(r28, r30);
        if (r32 == null) goto L12;
        r30 = r32;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r33 = ((SerializableObjectJsonAdapterBase) ((Constructor) r30).newInstance(new Object[0])).createInstance();
        if (r33 == null) goto L45;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r34 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_timeout_config", (w41.a) r33, w41.a.class, false);
        w = UltraSettingsManager.a().a(r34.a, r34.b, r34.getType(), r34.d, r0[21]);
        Class r35 = w41.c.class.getAnnotation(JsonAdapter.class).value();
        Object r36 = r29.get(r35);
        if (r36 != null) goto L24;
        r36 = r35.getConstructor(new Class[0]);
        if (r36 == null) goto L23;
        Object r37 = r29.putIfAbsent(r35, r36);
        if (r37 == null) goto L24;
        r36 = r37;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r38 = ((SerializableObjectJsonAdapterBase) ((Constructor) r36).newInstance(new Object[0])).createInstance();
        if (r38 == null) goto L43;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r39 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_link_sei_backup_opt", (w41.c) r38, w41.c.class, false);
        x = UltraSettingsManager.a().a(r39.a, r39.b, r39.getType(), r39.d, r0[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r40 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("rev_link_sei_check_stop", r14, r15, false);
        y = UltraSettingsManager.a().a(r40.a, r40.b, r40.getType(), r40.d, r0[23]);
        Class r42 = w41.d.class.getAnnotation(JsonAdapter.class).value();
        Object r43 = r29.get(r42);
        if (r43 != null) goto L36;
        r43 = r42.getConstructor(new Class[0]);
        if (r43 == null) goto L35;
        Object r44 = r29.putIfAbsent(r42, r43);
        if (r44 == null) goto L36;
        r43 = r44;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r45 = ((SerializableObjectJsonAdapterBase) ((Constructor) r43).newInstance(new Object[0])).createInstance();
        if (r45 == null) goto L41;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r46 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_link_sei_unload_config", (w41.d) r45, w41.d.class, false);
        z = UltraSettingsManager.a().a(r46.a, r46.b, r46.getType(), r46.d, r0[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r47 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("load_pk_sei_back_list", new String[0], zn3.a.c, false);
        A = UltraSettingsManager.a().a(r47.a, r47.b, r47.getType(), r47.d, r0[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r48 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_guest_not_consume_sei_backup", r14, r15, false);
        B = UltraSettingsManager.a().a(r48.a, r48.b, r48.getType(), r48.d, r0[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r49 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_sei_write_p", r14, r15, false);
        C = UltraSettingsManager.a().a(r49.a, r49.b, r49.getType(), r49.d, r0[27]);
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.live.model.RevLinkSeiUnloadConfig");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.live.model.RevLinkSeiBackupOptConfig");
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.live.model.RevAudienceSeiCheckConfig");
    }
}
