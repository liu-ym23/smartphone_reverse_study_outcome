package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static ByteString unsafeWrap(ByteBuffer r10) {
        return ByteString.wrap(r10);
    }

    public static ByteString unsafeWrap(byte[] r10) {
        return ByteString.wrap(r10);
    }

    public static ByteString unsafeWrap(byte[] r10, int r11, int r12) {
        return ByteString.wrap(r10, r11, r12);
    }

    public static void unsafeWriteTo(ByteString r10, ByteOutput r11) {
        r10.writeTo(r11);
    }
}
