package com.bytedance.bmmt.video.memory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BmmtVideoMemory implements BmmtVideoMemoryInterface {
    protected long nativeHandle;
    RefObject refCounted;

    public static /* synthetic */ void a(BmmtVideoMemory r0) {
        r0.lambda$new$0();
    }

    private static native void nativeReleaseVideoMemory(long r0);

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface, com.bytedance.bmmt.base.RefCounted
    public synchronized void release() {
        monitor-enter(this);
        this.refCounted.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface, com.bytedance.bmmt.base.RefCounted
    public synchronized void retain() {
        monitor-enter(this);
        this.refCounted.retain();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        long r0 = this.nativeHandle;
        if (r0 == 0) goto L6;
        nativeReleaseVideoMemory(r0);
        this.nativeHandle = 0;
        return;
    }

    public boolean isNullPointer() {
        if (this.nativeHandle != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    public BmmtVideoMemory(long r1) {
        this.nativeHandle = r1;
        this.refCounted = new RefObject(new a(this));
    }
}
