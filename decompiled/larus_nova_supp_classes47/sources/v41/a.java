package v41;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
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
    public static final a m = null;

    public a() {
    }

    public final boolean a() {
        return ((Boolean) c.getValue(this, a[1])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveSEIReplyMsgAck", "getLiveSEIReplyMsgAck()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveEnableRtsLogin", "getLiveEnableRtsLogin()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveResetPkTimerByMsg", "getLiveResetPkTimerByMsg()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveInteractMaxTimeout", "getLiveInteractMaxTimeout()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkBusinessTimeoutInterval", "getLivePkBusinessTimeoutInterval()J", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkHandleRepeatInvite", "getLivePkHandleRepeatInvite()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveWaitingListMsgUsers", "getLiveWaitingListMsgUsers()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDisableStartLimit", "getLivePkDisableStartLimit()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkInviteConfig", "getLivePkInviteConfig()Lcom/bytedance/android/live/revlink/impl/config/LivePkInviteConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pkTestTime", "getPkTestTime()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveAnchorLinkPkAutoRefuseFallback", "getLiveAnchorLinkPkAutoRefuseFallback()Z", 0))};
        a = r0;
        m = new a();
        Boolean r13 = Boolean.FALSE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_reply_message_ack", r13, r14, true);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r12 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_rts_login", r12, r14, true);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_reset_pk_timer_by_msg", r12, r14, true);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_connect_timeout_interval", 20, Integer.TYPE, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_business_timeout_interval", 15L, Long.TYPE, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_handle_repeat_invite", r12, r14, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_waiting_list_msg_users", r12, r14, true);
        h = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_disable_start_limit", r12, r14, true);
        i = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[7]);
        Class r9 = l.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r10 = vh7.b.a;
        Object r15 = r10.get(r9);
        if (r15 != null) goto L12;
        r15 = r9.getConstructor(new Class[0]);
        if (r15 == null) goto L11;
        Object r16 = r10.putIfAbsent(r9, r15);
        if (r16 == null) goto L12;
        r15 = r16;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r17 = ((SerializableObjectJsonAdapterBase) ((Constructor) r15).newInstance(new Object[0])).createInstance();
        if (r17 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_frequency_control", (l) r17, l.class, false);
        j = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_test_time", r13, r14, false);
        k = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_pk_auto_refuse_fallback", r13, r14, false);
        l = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[10]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LivePkInviteConfig");
    }
}
