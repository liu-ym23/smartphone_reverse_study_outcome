package ju1;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r extends n {
    public final int c;
    public final Map<String, Object> d;
    public final List<o> e;

    @Override // ju1.n
    public final Object c() {
        return Integer.valueOf(this.c);
    }

    public r(int r2, boolean r3, Map<String, ? extends Object> r4, List<o> r5) {
        Intrinsics.checkNotNullParameter(r4, "statusMap");
        super(Integer.valueOf(r2), r3);
        this.c = r2;
        this.d = r4;
        this.e = r5;
    }
}
