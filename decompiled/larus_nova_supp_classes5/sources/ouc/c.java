package ouc;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonDslMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@JsonDslMarker
public final class c {
    public final List<i> a;

    public c() {
        this.a = new ArrayList();
    }

    public final void a(i r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        ((ArrayList) this.a).add(r2);
    }
}
