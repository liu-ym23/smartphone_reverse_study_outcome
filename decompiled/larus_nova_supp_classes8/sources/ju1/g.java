package ju1;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends n {
    public final Map<String, Object> c;
    public final List<String> d;

    public g(int r2, boolean r3, Map<String, ? extends Object> r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "statusMap");
        Intrinsics.checkNotNullParameter(r5, "relatedFactors");
        super(Integer.valueOf(r2), r3);
        this.c = r4;
        this.d = r5;
    }
}
