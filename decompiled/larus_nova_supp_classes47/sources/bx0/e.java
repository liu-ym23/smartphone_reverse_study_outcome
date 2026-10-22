package bx0;

import com.bytedance.android.live.recharge.platform.core.config.RechargeConfigKey;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import zv0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final HashMap<RechargeConfigKey, Object> a;
    public final ConcurrentHashMap<Class<?>, h> b;

    public e() {
        this.a = new HashMap();
        this.b = new ConcurrentHashMap();
    }

    public final void a(RechargeConfigKey r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.put(r2, r3);
    }
}
