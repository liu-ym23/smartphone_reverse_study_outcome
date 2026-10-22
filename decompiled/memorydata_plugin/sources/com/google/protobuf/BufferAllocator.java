package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = null;

    static {
        UNPOOLED = new AnonymousClass1();
    }

    BufferAllocator() {
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int r1);

    public abstract AllocatedBuffer allocateHeapBuffer(int r1);
}
