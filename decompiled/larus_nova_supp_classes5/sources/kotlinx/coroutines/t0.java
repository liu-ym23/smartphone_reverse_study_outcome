package kotlinx.coroutines;

import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class t0 {
    public static final b0 a = null;
    public static final b0 b = null;

    public static final long a(long r3) {
        if (r3 > 0) goto L6;
        return 0;
    L6:
        if (r3 < 9223372036854L) goto L9;
        return LongCompanionObject.MAX_VALUE;
    L9:
        return 1000000 * r3;
    }

    static {
        a = new b0("REMOVED_TASK");
        b = new b0("CLOSED_EMPTY");
    }
}
