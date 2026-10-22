package ouc;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonDslMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@JsonDslMarker
public final class e0 {
    public final Map<String, i> a;

    public final d0 a() {
        return new d0(this.a);
    }

    public e0() {
        this.a = new LinkedHashMap();
    }

    public final i b(String r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "element");
        return this.a.put(r2, r3);
    }
}
