package z41;

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
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final a51.a c = null;
    public static final b d = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "measureOptConfig", "getMeasureOptConfig()Lcom/bytedance/android/live/revlink/impl/settings/opt/model/PkMeasureOptConfig;", 0))};
        a = r0;
        b r1 = new b();
        d = r1;
        Class r3 = a51.a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r4 = vh7.b.a;
        Object r6 = r4.get(r3);
        if (r6 != null) goto L12;
        r6 = r3.getConstructor(new Class[0]);
        if (r6 == null) goto L11;
        Object r5 = r4.putIfAbsent(r3, r6);
        if (r5 == null) goto L12;
        r6 = r5;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r6).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_measure_opt_config", (a51.a) r7, a51.a.class, false);
        ReadOnlyProperty r8 = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[0]);
        b = r8;
        c = (a51.a) r8.getValue(r1, r0[0]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.opt.model.PkMeasureOptConfig");
    }

    public b() {
    }
}
