package x41;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.m;
import vh7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final a f = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkSpeedMatchWaitTime", "getLivePkSpeedMatchWaitTime()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveRandomPkTitleConfig", "getLiveRandomPkTitleConfig()Lcom/bytedance/android/live/revlink/impl/config/LiveRandomPkTitleConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveRandomPkRankPopConfig", "getLiveRandomPkRankPopConfig()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveRandomCheckBackground", "getLiveRandomCheckBackground()Ljava/lang/String;", 0))};
        a = r0;
        f = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_speed_match_wait_time", 5, Integer.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r6 = m.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r7 = b.a;
        Object r8 = r7.get(r6);
        if (r8 != null) goto L12;
        r8 = r6.getConstructor(new Class[0]);
        if (r8 == null) goto L11;
        Object r9 = r7.putIfAbsent(r6, r8);
        if (r9 == null) goto L12;
        r8 = r9;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r10 = ((SerializableObjectJsonAdapterBase) ((Constructor) r8).newInstance(new Object[0])).createInstance();
        if (r10 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_automatch_cancel_panel_paperwriter", (m) r10, m.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_random_rank_pop_config", MapsKt.emptyMap(), zn3.a.f, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_random_check_background", "https://lf9-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_img_dialog_plugin_douyin.png", String.class, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LiveRandomPkTitleConfig");
    }

    public a() {
    }
}
