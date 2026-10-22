package h51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final a e = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkTaskScoreWebp", "getLivePkTaskScoreWebp()Ljava/util/HashMap;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkTeamTaskOptType", "getLivePkTeamTaskOptType()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkTeamTaskReset", "getLivePkTeamTaskReset()Z", 0))};
        a = r0;
        e = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_task_score_webp", new HashMap(), zn3.a.a, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_team_task_opt_type", 0, Integer.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_team_task_reset", Boolean.TRUE, Boolean.TYPE, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
    }

    public a() {
    }
}
