package qu0;

import com.bytedance.android.live.revenue.common.p;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final b c = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "config", "getConfig()Lcom/bytedance/android/live/profit/livepet/config/LivePetConfig;", 0))};
        a = r0;
        c = new b();
        Class r2 = a.class.getAnnotation(JsonAdapter.class).value();
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
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pet_config", (a) r6, a.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.livepet.config.LivePetConfig");
    }

    public b() {
    }

    public final a a() {
        return (a) b.getValue(this, a[0]);
    }

    public final a.c b(long r4) {
        JsonObject r0 = a().D5().get("default");
        a.c r1 = null;
        if (r0 == null) goto L5;
        a.c r2 = new a.c(r0);
    L6:
        JsonObject r5 = a().D5().get(String.valueOf(r4));
        if (r5 == null) goto L9;
        r1 = new a.c(r5);
    L9:
        if (r1 != null) goto L11;
        return r2;
    L11:
        if (r2 != null) goto L14;
        return r1;
    L14:
        return new a.c(c(r2, r1));
    L5:
        r2 = null;
        goto L6
    }

    public static JsonObject c(p r2, p r3) {
        JsonObject r4 = r2.a;
        JsonObject r5 = r3.a;
        JsonObject r6 = r4.deepCopy();
        Iterator r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r7.next();
        r6.add((String) r0.getKey(), (JsonElement) r0.getValue());
        goto L4
    L6:
        return r6;
    }
}
