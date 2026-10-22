package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
final class InputStreamChannel implements ReadableByteChannel {
    private static final int MAX_TMP_BUFFER_SIZE = 16384;
    private static final int MIN_TMP_BUFFER_SIZE = 4096;
    private final InputStream mInputStream;
    private final AtomicBoolean mIsOpen;

    private InputStreamChannel(InputStream r3) {
        this.mIsOpen = new AtomicBoolean(true);
        this.mInputStream = r3;
    }

    static ReadableByteChannel wrap(InputStream r2) {
        if (ZeusTransformUtils.instanceOf(r2, FileInputStream.class) == false) goto L7;
        return ((FileInputStream) ZeusTransformUtils.preCheckCast(r2, FileInputStream.class, "com.obric.memorydata.plugin")).getChannel();
    L7:
        return new InputStreamChannel(r2);
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
    public int read(ByteBuffer r4) {
        if (r4.hasArray() == false) goto L7;
        int r3 = this.mInputStream.read(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());
        if (r3 <= 0) goto L10;
        r4.position(r4.position() + r3);
    L10:
        return r3;
    L7:
        byte[] r0 = new byte[Math.min(16384, Math.min(Math.max(this.mInputStream.available(), 4096), r4.remaining()))];
        r3 = this.mInputStream.read(r0);
        if (r3 <= 0) goto L10;
        r4.put(r0, 0, r3);
        goto L10
    }
}
