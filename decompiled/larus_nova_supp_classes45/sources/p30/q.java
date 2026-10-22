package p30;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q {
    public final String a;
    public final Map<String, Object> b;

    public final String getType() {
        return this.a;
    }

    public q(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a = "";
        this.a = r2;
        this.b = r3;
    }
}
