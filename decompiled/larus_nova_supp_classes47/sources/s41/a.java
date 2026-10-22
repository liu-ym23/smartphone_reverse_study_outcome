package s41;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final a e = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveSceneGiftSyncConfigSetting", "getLiveSceneGiftSyncConfigSetting()Lcom/bytedance/android/livesdk/configmodel/LiveSceneGiftSyncConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveAiGiftAsyncSortConfig", "getLiveAiGiftAsyncSortConfig()Lcom/bytedance/android/live/revlink/impl/config/LiveGiftAsyncSortConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePostPkUiThread", "getLivePostPkUiThread()Z", 0))};
        a = r0;
        e = new a();
        Class r4 = ys1.b.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r6 = vh7.b.a;
        Object r7 = r6.get(r4);
        if (r7 != null) goto L12;
        r7 = r4.getConstructor(new Class[0]);
        if (r7 == null) goto L11;
        Object r5 = r6.putIfAbsent(r4, r7);
        if (r5 == null) goto L12;
        r7 = r5;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r8 = ((SerializableObjectJsonAdapterBase) ((Constructor) r7).newInstance(new Object[0])).createInstance();
        if (r8 == null) goto L31;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_scene_gift_sync_config_setting", (ys1.b) r8, ys1.b.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r9 = k.class.getAnnotation(JsonAdapter.class).value();
        Object r10 = r6.get(r9);
        if (r10 != null) goto L24;
        r10 = r9.getConstructor(new Class[0]);
        if (r10 == null) goto L23;
        Object r12 = r6.putIfAbsent(r9, r10);
        if (r12 == null) goto L24;
        r10 = r12;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r13 = ((SerializableObjectJsonAdapterBase) ((Constructor) r10).newInstance(new Object[0])).createInstance();
        if (r13 == null) goto L29;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ai_gift_async_sort_config", (k) r13, k.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_post_pk_thread", Boolean.TRUE, Boolean.TYPE, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LiveGiftAsyncSortConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.configmodel.LiveSceneGiftSyncConfig");
    }

    public a() {
    }

    public final k a() {
        return (k) c.getValue(this, a[1]);
    }
}
