package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
abstract class AllocatedBuffer {
    AllocatedBuffer() {
    }

    public static AllocatedBuffer wrap(final ByteBuffer r10) {
        Internal.checkNotNull(r10, "buffer");
        return new AnonymousClass1(r10);
    }

    public static AllocatedBuffer wrap(byte[] r10) {
        return wrapNoCheck(r10, 0, r10.length);
    }

    public static AllocatedBuffer wrap(byte[] r10, int r11, int r12) {
        if (r11 < 0) goto L9;
        if (r12 < 0) goto L9;
        if ((r11 + r12) > r10.length) goto L9;
        return wrapNoCheck(r10, r11, r12);
    L9:
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r11), Integer.valueOf(r12)}));
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] r10, final int r11, final int r12) {
        return new AnonymousClass2(r10, r11, r12);
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer position(int r10);

    public abstract int remaining();
}
