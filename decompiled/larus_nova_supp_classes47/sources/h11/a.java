package h11;

import com.bytedance.android.livesdk.config.v01;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
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
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveLinkMicApiFetchUseUplink", "getLiveLinkMicApiFetchUseUplink()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "checkLinkerInterval", "getCheckLinkerInterval()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "checkLinkerEnable", "getCheckLinkerEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "linkRevConnectConfig", "getLinkRevConnectConfig()Lcom/bytedance/android/livesdk/config/LinkRevConnectConfig;", 0))};
        a = r0;
        f = new a();
        Boolean r6 = Boolean.FALSE;
        Class r7 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_linkmic_api_fetch_use_uplink", r6, r7, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_linker_interval", 20, Integer.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_linker_enable", Boolean.TRUE, r7, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Class r4 = v01.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r8 = b.a;
        Object r9 = r8.get(r4);
        if (r9 != null) goto L12;
        r9 = r4.getConstructor(new Class[0]);
        if (r9 == null) goto L11;
        Object r5 = r8.putIfAbsent(r4, r9);
        if (r5 == null) goto L12;
        r9 = r5;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r10 = ((SerializableObjectJsonAdapterBase) ((Constructor) r9).newInstance(new Object[0])).createInstance();
        if (r10 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_rev_connect_config", (v01) r10, v01.class, true);
        e = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[3]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.LinkRevConnectConfig");
    }

    public a() {
    }

    public final v01 a() {
        return (v01) e.getValue(this, a[3]);
    }
}
