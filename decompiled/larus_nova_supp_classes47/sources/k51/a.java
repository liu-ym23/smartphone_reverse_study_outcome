package k51;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.c;
import vh7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final a h = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveAnchorInteractVoteScoreRatio", "getLiveAnchorInteractVoteScoreRatio()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveInteractVoteRuleLynxUrl", "getLiveInteractVoteRuleLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pkVoteTestTime", "getPkVoteTestTime()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveVoteSupportMulti", "getLiveVoteSupportMulti()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveInteractVoteConfig", "getLiveInteractVoteConfig()Lcom/bytedance/android/live/revlink/impl/config/InteractVoteConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiVoteTopicLynx", "getLiveMultiVoteTopicLynx()Ljava/lang/String;", 0))};
        a = r0;
        h = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_interact_vote_score_ratio", 30, Integer.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_vote_rule_lynx_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Frevenue_pk_hybrid_douyin%2Fpages%2Fpk_vote_rule%2Ftemplate.js&gravity=bottom&type=popup&rate_height=305&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", String.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r3 = Boolean.FALSE;
        Class r8 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_vote_test_time_enable", r3, r8, false);
        d = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vote_support_multi", Boolean.TRUE, r8, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        Class r6 = c.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r7 = b.a;
        Object r9 = r7.get(r6);
        if (r9 != null) goto L12;
        r9 = r6.getConstructor(new Class[0]);
        if (r9 == null) goto L11;
        Object r10 = r7.putIfAbsent(r6, r9);
        if (r10 == null) goto L12;
        r9 = r10;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r12 = ((SerializableObjectJsonAdapterBase) ((Constructor) r9).newInstance(new Object[0])).createInstance();
        if (r12 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r13 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_vote_config", (c) r12, c.class, false);
        f = UltraSettingsManager.a().a(r13.a, r13.b, r13.getType(), r13.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r14 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_vote_topic_lynx", j51.a.a("sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_contribution_lynx_douyin%2Fpages%2Fvote%2Ftemplate.js&gravity=bottom&type=popup&rate_height=363", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_contribution_lynx_huoshan%2Fpages%2Fvote%2Ftemplate.js&gravity=bottom&type=popup&rate_height=363", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_contribution_lynx_saas%2Fpages%2Fvote%2Ftemplate.js&gravity=bottom&type=popup&rate_height=363"), String.class, false);
        g = UltraSettingsManager.a().a(r14.a, r14.b, r14.getType(), r14.d, r0[5]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.InteractVoteConfig");
    }

    public a() {
    }
}
