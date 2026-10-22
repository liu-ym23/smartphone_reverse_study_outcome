package az0;

import cq2.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import wy0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements g {
    public final d a;

    @Override // wy0.g
    public final Map<String, Object> getData() {
        return this.a.getParams();
    }

    @Override // wy0.g
    public final String getName() {
        return this.a.getEventName();
    }

    public c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "originalEvent");
        this.a = r2;
    }
}
