package io.reactivex.internal.schedulers;

import ai.j0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    public RxThreadFactory(String r5) {
        this(r5, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r5) {
        String r10 = this.prefix + '-' + incrementAndGet();
        if (this.nonBlocking == false) goto L5;
        Thread r11 = new am.a(r5, r10, 3);
    L6:
        r11.setPriority(this.priority);
        r11.setDaemon(true);
        return r11;
    L5:
        r11 = new Thread(r5, r10);
        goto L6
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return j0.q(new StringBuilder("RxThreadFactory["), this.prefix, "]");
    }

    public RxThreadFactory(String r5, int r10) {
        this(r5, r10, false);
    }

    public RxThreadFactory(String r5, int r10, boolean r11) {
        this.prefix = r5;
        this.priority = r10;
        this.nonBlocking = r11;
    }
}
