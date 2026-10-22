package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static ByteString unsafeWrap(ByteBuffer r8) {
        return ByteString.wrap(r8);
    }

    public static void unsafeWriteTo(ByteString r8, ByteOutput r10) {
        r8.writeTo(r10);
    }

    public static ByteString unsafeWrap(byte[] r8) {
        return ByteString.wrap(r8);
    }

    public static ByteString unsafeWrap(byte[] r8, int r10, int r11) {
        return ByteString.wrap(r8, r10, r11);
    }
}
