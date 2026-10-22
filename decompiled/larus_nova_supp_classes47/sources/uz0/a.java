package uz0;

import com.bytedance.android.live.revenue.platform.network.api.dsl.RequestDSL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RequestDSL
public abstract class a {
    public final Map<String, String> a;
    public final Map<String, String> b;
    public final Map<String, List<String>> c;
    public final List<com.bytedance.android.livesdk.revenue.network.a> d;

    public a() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
    }

    @RequestDSL
    public final void a(com.bytedance.android.livesdk.revenue.network.a r2) {
        Intrinsics.checkNotNullParameter(r2, "middleware");
        ((ArrayList) this.d).add(r2);
    }

    @RequestDSL
    public final void query(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.b.put(r2, r3);
    }

    @RequestDSL
    public final void query(String r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "values");
        this.c.put(r2, r3);
    }
}
