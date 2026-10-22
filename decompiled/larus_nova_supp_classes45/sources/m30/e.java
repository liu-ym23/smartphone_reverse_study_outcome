package m30;

import com.bytedance.ies.xbridge.u;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements u {
    public final Iterator<String> a;

    public final boolean hasNextKey() {
        return this.a.hasNext();
    }

    public final String nextKey() {
        return this.a.next();
    }

    public e(Iterator<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.a = r2;
    }
}
