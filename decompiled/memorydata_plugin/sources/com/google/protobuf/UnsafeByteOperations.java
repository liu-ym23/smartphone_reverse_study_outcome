package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static ByteString unsafeWrap(ByteBuffer r0) {
        return ByteString.wrap(r0);
    }

    public static ByteString unsafeWrap(byte[] r0) {
        return ByteString.wrap(r0);
    }

    public static ByteString unsafeWrap(byte[] r0, int r1, int r2) {
        return ByteString.wrap(r0, r1, r2);
    }

    public static void unsafeWriteTo(ByteString r0, ByteOutput r1) {
        r0.writeTo(r1);
    }
}
