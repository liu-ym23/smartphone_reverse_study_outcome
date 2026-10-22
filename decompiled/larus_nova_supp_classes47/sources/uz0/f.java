package uz0;

import com.bytedance.android.live.revenue.platform.network.api.dsl.RequestDSL;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@RequestDSL
public final class f {
    public final Map<String, String> a;

    public f(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        this.a = r2;
    }

    @RequestDSL
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$setTo");
        if (r3 == null) goto L6;
        this.a.put(r2, r3);
        return;
    }
}
