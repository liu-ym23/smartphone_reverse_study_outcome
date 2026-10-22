package v38;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final AtomicInteger a = null;

    static {
        a = new AtomicInteger();
    }

    public static void a() {
    L2:
        AtomicInteger r0 = a;
        int r1 = r0.get();
        if (r1 <= 0) goto L4;
        if (r0.compareAndSet(r1, r1 - 1) == false) goto L2;
        return;
    }
}
