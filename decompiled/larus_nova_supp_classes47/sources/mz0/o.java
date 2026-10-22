package mz0;

import com.bytedance.android.live.revenue.platform.log.api.LogDSLMaker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@LogDSLMaker
public final class o {
    public final Map<String, String> a;

    public o(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a = r2;
    }

    public final void b(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a.putAll(r2);
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.put(r2, r3);
    }
}
