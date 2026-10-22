package ay0;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(f.class, "revenueFoldFixConfig", "getRevenueFoldFixConfig()Lcom/bytedance/android/live/revenue/common/settings/RevenueFoldFixConfig;", 1))};
        a = r1;
        Class r3 = e.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r4 = vh7.b.a;
        Object r5 = r4.get(r3);
        if (r5 != null) goto L12;
        r5 = r3.getConstructor(new Class[0]);
        if (r5 == null) goto L11;
        Object r6 = r4.putIfAbsent(r3, r5);
        if (r6 == null) goto L12;
        r5 = r6;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r5).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_fold_fix_config", (e) r7, e.class, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.common.settings.RevenueFoldFixConfig");
    }
}
