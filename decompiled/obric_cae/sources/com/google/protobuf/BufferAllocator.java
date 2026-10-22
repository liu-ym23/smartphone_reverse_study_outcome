package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = null;

    static {
        UNPOOLED = new AnonymousClass1();
    }

    public BufferAllocator() {
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int r8);

    public abstract AllocatedBuffer allocateHeapBuffer(int r8);
}
