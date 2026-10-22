package io.reactivex.parallel;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.a.c;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<T> {
    public abstract int a();

    public abstract void a(c<? super T>[] r1);

    public final boolean b(c<?>[] r5) {
        int r4 = a();
        if (r5.length == r4) goto L8;
        IllegalArgumentException r0 = new IllegalArgumentException("parallelism = " + r4 + ", subscribers = " + r5.length);
        int r6 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r6) goto L7;
        EmptySubscription.error(r0, r5[r2]);
        r2 = r2 + 1;
        goto L5
    L7:
        return false;
    L8:
        return true;
    }
}
