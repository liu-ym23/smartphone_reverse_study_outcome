package ob2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ek6.b {
    public final List<String> a;
    public final Integer b;

    public final void a() {
    }

    public final String toString() {
        return "LiveImageResource[" + CollectionsKt.joinToString$default(this.a, null, null, null, 3, null, null, 55, null) + ']';
    }

    public c(List<String> r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "urls");
        this.a = r2;
        this.b = r3;
    }
}
