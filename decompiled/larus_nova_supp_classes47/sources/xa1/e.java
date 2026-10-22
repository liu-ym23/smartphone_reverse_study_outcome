package xa1;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final e c = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(e.class, "LIVE_LYNX_ENTER_EFFECT_OPT_CONFIG", "getLIVE_LYNX_ENTER_EFFECT_OPT_CONFIG()Lcom/bytedance/android/live/settings/LynxEnterEffectOptConfig;", 0))};
        a = r0;
        c = new e();
        Class r2 = d.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r3 = vh7.b.a;
        Object r4 = r3.get(r2);
        if (r4 != null) goto L12;
        r4 = r2.getConstructor(new Class[0]);
        if (r4 == null) goto L11;
        Object r5 = r3.putIfAbsent(r2, r4);
        if (r5 == null) goto L12;
        r4 = r5;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r6 = ((SerializableObjectJsonAdapterBase) ((Constructor) r4).newInstance(new Object[0])).createInstance();
        if (r6 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_enter_effect_opt_config", (d) r6, d.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.settings.LynxEnterEffectOptConfig");
    }

    public e() {
    }

    public final d a() {
        return (d) b.getValue(this, a[0]);
    }
}
