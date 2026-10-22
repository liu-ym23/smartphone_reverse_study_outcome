package f2;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final AtomicBoolean a = null;
    public static final CompletableDeferred<Unit> b = null;
    public static h2.a c;

    static {
        a = new AtomicBoolean(false);
        b = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    public static boolean a() {
        if (a.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (c == null) goto L7;
        return true;
    }
}
