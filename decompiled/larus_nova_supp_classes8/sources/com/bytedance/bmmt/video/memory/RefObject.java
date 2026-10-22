package com.bytedance.bmmt.video.memory;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RefObject {
    private final AtomicInteger refCount;
    private final Runnable releaseCallback;

    public boolean hasReleaseCallback() {
        if (this.releaseCallback == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void release() {
        if (this.refCount.decrementAndGet() != 0) goto L8;
        Runnable r0 = this.releaseCallback;
        if (r0 == null) goto L9;
        r0.run();
        return;
    L9:
        return;
    }

    public void retain() {
        this.refCount.incrementAndGet();
    }

    public RefObject(Runnable r3) {
        this.refCount = new AtomicInteger(1);
        this.releaseCallback = r3;
    }
}
