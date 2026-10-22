package nu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static e a() {
        e r5 = e.access$getHead$cp();
        Intrinsics.checkNotNull(r5);
        e r10 = e.access$getNext$p(r5);
        if (r10 != null) goto L10;
        long r11 = System.nanoTime();
        e.class.wait(e.access$getIDLE_TIMEOUT_MILLIS$cp());
        e r12 = e.access$getHead$cp();
        Intrinsics.checkNotNull(r12);
        if (e.access$getNext$p(r12) == null) goto L7;
        return null;
    L7:
        if ((System.nanoTime() - r11) >= e.access$getIDLE_TIMEOUT_NANOS$cp()) goto L9;
        return null;
    L9:
        return e.access$getHead$cp();
    L10:
        long r13 = e.access$remainingNanos(r10, System.nanoTime());
        if (r13 <= 0) goto L14;
        long r14 = r13 / 1000000;
        e.class.wait(r14, (int) (r13 - (1000000 * r14)));
        return null;
    L14:
        e r15 = e.access$getHead$cp();
        Intrinsics.checkNotNull(r15);
        e.access$setNext$p(r15, e.access$getNext$p(r10));
        e.access$setNext$p(r10, null);
        return r10;
    }
}
