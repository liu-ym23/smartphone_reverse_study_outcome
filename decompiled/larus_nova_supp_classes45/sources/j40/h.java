package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h extends SettingKey<com.bytedance.android.livesdk.config.e0> {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
        Class r0 = com.bytedance.android.livesdk.config.e0.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L31;
        com.bytedance.android.livesdk.config.e0 r5 = (com.bytedance.android.livesdk.config.e0) r4;
        Class r6 = com.bytedance.android.livesdk.config.e0.class.getAnnotation(JsonAdapter.class).value();
        Object r7 = r1.get(r6);
        if (r7 != null) goto L24;
        r7 = r6.getConstructor(new Class[0]);
        if (r7 == null) goto L23;
        Object r8 = r1.putIfAbsent(r6, r7);
        if (r8 == null) goto L24;
        r7 = r8;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r9 = ((SerializableObjectJsonAdapterBase) ((Constructor) r7).newInstance(new Object[0])).createInstance();
        if (r9 == null) goto L29;
        super("live_gift_asset_clean_in_room_config", "直播间内手动清理缓存配置", r5, (com.bytedance.android.livesdk.config.e0) r9);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.AssetManualCleanCacheConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.AssetManualCleanCacheConfig");
    }
}
