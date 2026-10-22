package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    static final class a extends Thread implements g {
        a(Runnable r3, String r4) {
            super((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    public RxThreadFactory(String r3) {
        this(r3, 5, false);
    }

    public RxThreadFactory(String r2, int r3) {
        this(r2, r3, false);
    }

    public RxThreadFactory(String r1, int r2, boolean r3) {
        this.prefix = r1;
        this.priority = r2;
        this.nonBlocking = r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        String r0 = this.prefix + '-' + incrementAndGet();
        if (this.nonBlocking == false) goto L5;
        Thread r1 = new a(r5, r0);
    L6:
        r1.setPriority(this.priority);
        r1.setDaemon(true);
        return r1;
    L5:
        r1 = new Thread(r5, r0);
        goto L6
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }
}
