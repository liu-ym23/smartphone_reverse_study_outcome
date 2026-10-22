package nu0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_RULE_URL", "getLIVE_FORMAT_VOICE_CHAT_RULE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_RTC_CONFIG", "getLIVE_FORMAT_VOICE_CHAT_RTC_CONFIG()Lcom/bytedance/android/live/profit/format/voicechat/config/VoiceChatRTCConfig;", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_TIMEOUT_INTERVAL", "getLIVE_FORMAT_VOICE_CHAT_TIMEOUT_INTERVAL()J", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_ANIM_DELAY", "getLIVE_FORMAT_VOICE_CHAT_ANIM_DELAY()J", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_USE_PB", "getLIVE_FORMAT_VOICE_CHAT_USE_PB()Z", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_TRACE", "getLIVE_FORMAT_VOICE_CHAT_TRACE()Z", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_THINK_DURATION", "getLIVE_FORMAT_VOICE_CHAT_THINK_DURATION()J", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_BLUETOOTH_PERMISSION_CHECK", "getLIVE_FORMAT_VOICE_CHAT_BLUETOOTH_PERMISSION_CHECK()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_rule_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_privileges_lynx_douyin%2Fpages%2Fai_avatar_skills_rule%2Ftemplate.js&mask_alpha=0.3&show_dim=1&gravity=bottom&type=popup&rate_height=400&horizontal_width=375", String.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_rtc_config", new iu0.a(), iu0.a.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Class r10 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_timeout_interval", 20L, r10, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_anim_delay", 1800L, r10, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        Boolean r5 = Boolean.TRUE;
        Class r6 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_use_pb", r5, r6, false);
        f = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_trace", r5, r6, false);
        g = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_think_duration", 1000L, r10, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_bluetooth_permission_check", r5, r6, false);
        i = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[7]);
    }
}
