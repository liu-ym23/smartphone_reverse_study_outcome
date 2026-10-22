package com.ttnet.org.chromium.net.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class InputStreamChannel implements ReadableByteChannel {
    private static final int MAX_TMP_BUFFER_SIZE = 16384;
    private static final int MIN_TMP_BUFFER_SIZE = 4096;
    private final InputStream mInputStream;
    private final AtomicBoolean mIsOpen;

    private InputStreamChannel(InputStream r8) {
        this.mIsOpen = new AtomicBoolean(true);
        this.mInputStream = r8;
    }

    public static ReadableByteChannel wrap(InputStream r8) {
        if ((r8 instanceof FileInputStream) == false) goto L7;
        return ((FileInputStream) r8).getChannel();
    L7:
        return new InputStreamChannel(r8);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.mIsOpen.compareAndSet(true, false) == false) goto L6;
        this.mInputStream.close();
        return;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r8) {
        if (r8.hasArray() == false) goto L7;
        InputStream r10 = this.mInputStream;
        byte[] r11 = r8.array();
        int r12 = r8.arrayOffset();
        int r13 = r10.read(r11, r8.position() + r12, r8.remaining());
        if (r13 <= 0) goto L10;
        r8.position(r8.position() + r13);
    L10:
        return r13;
    L7:
        byte[] r14 = new byte[Math.min(16384, Math.min(Math.max(this.mInputStream.available(), 4096), r8.remaining()))];
        r13 = this.mInputStream.read(r14);
        if (r13 <= 0) goto L10;
        r8.put(r14, 0, r13);
        goto L10
    }
}
