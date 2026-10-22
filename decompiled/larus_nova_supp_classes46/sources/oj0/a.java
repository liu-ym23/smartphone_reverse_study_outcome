package oj0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final a c = null;

    static {
        KProperty[] r1 = {Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_LOCAL_DEFAULT_THEME_RES", "getLIVE_LOCAL_DEFAULT_THEME_RES()Lcom/bytedance/android/live/liveinteract/theme/util/DefaultVoiceLiveThemeResource;", 0))};
        a = r1;
        c = new a();
        b r3 = new b();
        r3.a = "webcast/audio_bg_3.png";
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_local_default_audio_theme", r3, b.class, true);
        b = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r1[0]);
    }

    public a() {
    }
}
