package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    static final class a extends Thread implements f {
        a(Runnable r10, String r11) {
            super(r10, r11);
        }
    }

    public RxThreadFactory(String r10) {
        this(r10, 5, false);
    }

    public RxThreadFactory(String r10, int r11) {
        this(r10, r11, false);
    }

    public RxThreadFactory(String r10, int r11, boolean r12) {
        this.prefix = r10;
        this.priority = r11;
        this.nonBlocking = r12;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        String r11 = this.prefix + '-' + incrementAndGet();
        if (this.nonBlocking == false) goto L5;
        Thread r12 = new a(r10, r11);
    L6:
        r12.setPriority(this.priority);
        r12.setDaemon(true);
        return r12;
    L5:
        r12 = new Thread(r10, r11);
        goto L6
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }
}
