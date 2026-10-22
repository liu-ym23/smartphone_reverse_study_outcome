package e51;

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
    public static final c d = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(c.class, "liveSpecifyGiftPkTopLynxUrl", "getLiveSpecifyGiftPkTopLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveBattleInviteDialogLynxUrl", "getLiveBattleInviteDialogLynxUrl()Ljava/lang/String;", 0))};
        a = r0;
        d = new c();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_designated_gift_activity_lynx_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_douyin/pages/designated_gift_pk_activity/template.js", String.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_battle_invite_dialog_lynx_url", j51.a.a("sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Fbattle_invite_dialog%2Ftemplate.js&gravity=bottom&type=popup&rate_height=258&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Fbattle_invite_dialog%2Ftemplate.js&gravity=bottom&type=popup&rate_height=258&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_saas%2Fpages%2Fbattle_invite_dialog%2Ftemplate.js&gravity=bottom&type=popup&rate_height=258&radius=8&pull_down_close=1&pull_down_indicator_not_show=1"), String.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }

    public c() {
    }
}
