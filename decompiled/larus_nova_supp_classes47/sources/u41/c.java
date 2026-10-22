package u41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final c f = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(c.class, "livePkAudienceScoreFilter", "getLivePkAudienceScoreFilter()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkReplyMessageCache", "getLivePkReplyMessageCache()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkInviteTimerInterval", "getLivePkInviteTimerInterval()J", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkInviteMsgAtLeastAvailableTime", "getLivePkInviteMsgAtLeastAvailableTime()J", 0))};
        a = r0;
        f = new c();
        Boolean r6 = Boolean.TRUE;
        Class r7 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_score_message_filter", r6, r7, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_reply_message_cache", r6, r7, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Class r8 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_invite_timer_interval", 25L, r8, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_invite_msg_at_least_available_time", 5L, r8, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
    }

    public c() {
    }
}
