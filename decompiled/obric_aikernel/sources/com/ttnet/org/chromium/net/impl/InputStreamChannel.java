package com.ttnet.org.chromium.net.impl;

import androidx.annotation.NonNull;
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

    private InputStreamChannel(@NonNull InputStream r10) {
        this.mIsOpen = new AtomicBoolean(true);
        this.mInputStream = r10;
    }

    static ReadableByteChannel wrap(@NonNull InputStream r10) {
        if ((r10 instanceof FileInputStream) == false) goto L7;
        return ((FileInputStream) r10).getChannel();
    L7:
        return new InputStreamChannel(r10);
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
    public int read(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L7;
        int r11 = this.mInputStream.read(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining());
        if (r11 <= 0) goto L10;
        r10.position(r10.position() + r11);
    L10:
        return r11;
    L7:
        byte[] r12 = new byte[Math.min(16384, Math.min(Math.max(this.mInputStream.available(), 4096), r10.remaining()))];
        r11 = this.mInputStream.read(r12);
        if (r11 <= 0) goto L10;
        r10.put(r12, 0, r11);
        goto L10
    }
}
