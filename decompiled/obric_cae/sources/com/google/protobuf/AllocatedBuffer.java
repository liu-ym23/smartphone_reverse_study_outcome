package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class AllocatedBuffer {
    public AllocatedBuffer() {
    }

    public static AllocatedBuffer wrap(final ByteBuffer r8) {
        Internal.checkNotNull(r8, "buffer");
        return new AnonymousClass1(r8);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] r8, final int r10, final int r11) {
        return new AnonymousClass2(r8, r10, r11);
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer position(int r8);

    public abstract int remaining();

    public static AllocatedBuffer wrap(byte[] r8) {
        return wrapNoCheck(r8, 0, r8.length);
    }

    public static AllocatedBuffer wrap(byte[] r8, int r10, int r11) {
        if (r10 < 0) goto L9;
        if (r11 < 0) goto L9;
        if ((r10 + r11) > r8.length) goto L9;
        return wrapNoCheck(r8, r10, r11);
    L9:
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r8.length), Integer.valueOf(r10), Integer.valueOf(r11)}));
    }
}
