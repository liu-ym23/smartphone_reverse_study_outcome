package v41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
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
    public static final b f = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "anchorLinkExtScoreShowEnable", "getAnchorLinkExtScoreShowEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "anchorLinkProfitInteractionDataFix", "getAnchorLinkProfitInteractionDataFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiAnchorFixProfitInteractContextLifecycle", "getMultiAnchorFixProfitInteractContextLifecycle()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveAnchorLinkScoreRuleLynxUrl", "getLiveAnchorLinkScoreRuleLynxUrl()Ljava/lang/String;", 0))};
        a = r0;
        f = new b();
        Boolean r6 = Boolean.TRUE;
        Class r7 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_link_ext_score_show_enable", r6, r7, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_link_profit_interaction_data_fix", r6, r7, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_profit_interact_context_lifecycle", r6, r7, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_score_rule_lynx_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Flink_score_rule%2Ftemplate.js&gravity=bottom&type=popup&rate_height=271&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", String.class, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
    }

    public b() {
    }

    public final boolean a() {
        return ((Boolean) b.getValue(this, a[0])).booleanValue();
    }
}
