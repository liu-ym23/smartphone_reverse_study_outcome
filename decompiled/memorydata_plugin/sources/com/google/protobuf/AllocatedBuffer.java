package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class AllocatedBuffer {
    AllocatedBuffer() {
    }

    public static AllocatedBuffer wrap(final ByteBuffer r1) {
        Internal.checkNotNull(r1, "buffer");
        return new AnonymousClass1(r1);
    }

    public static AllocatedBuffer wrap(byte[] r2) {
        return wrapNoCheck(r2, 0, r2.length);
    }

    public static AllocatedBuffer wrap(byte[] r3, int r4, int r5) {
        if (r4 < 0) goto L9;
        if (r5 < 0) goto L9;
        if ((r4 + r5) > r3.length) goto L9;
        return wrapNoCheck(r3, r4, r5);
    L9:
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r3.length), Integer.valueOf(r4), Integer.valueOf(r5)}));
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] r1, final int r2, final int r3) {
        return new AnonymousClass2(r1, r2, r3);
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int r1);

    public abstract int remaining();
}
