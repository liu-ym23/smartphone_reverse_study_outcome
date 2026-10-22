package hx0;

import com.bytedance.android.livesdk.revenue.log.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a<T> implements d<T> {
    public final Map<String, String> a;

    public abstract void c(Map r1, gx0.a r2);

    public a() {
        this.a = new LinkedHashMap();
    }

    public final void a(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        r2.putAll(this.a);
    }

    public final void b(gx0.a r2) {
        c(this.a, r2);
    }
}
