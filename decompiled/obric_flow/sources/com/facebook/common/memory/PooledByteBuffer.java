package com.facebook.common.memory;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public interface PooledByteBuffer extends Closeable {

    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    byte a(int r5);

    int a(int r5, byte[] r10, int r11, int r12);

    boolean a();

    int size();
}
