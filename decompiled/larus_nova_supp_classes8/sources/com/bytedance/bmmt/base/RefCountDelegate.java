package com.bytedance.bmmt.base;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RefCountDelegate implements RefCounted {
    private final AtomicInteger refCount;
    private final Runnable releaseCallback;

    @Override // com.bytedance.bmmt.base.RefCounted
    public void release() {
        if (this.refCount.decrementAndGet() != 0) goto L8;
        Runnable r0 = this.releaseCallback;
        if (r0 == null) goto L9;
        r0.run();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.bmmt.base.RefCounted
    public void retain() {
        this.refCount.incrementAndGet();
    }

    public RefCountDelegate(Runnable r3) {
        this.refCount = new AtomicInteger(1);
        this.releaseCallback = r3;
    }
}
