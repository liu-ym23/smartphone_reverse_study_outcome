package org.apache.commons.compress.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MultiReadOnlySeekableByteChannel implements SeekableByteChannel {
    private final List<SeekableByteChannel> channels;
    private int currentChannelIdx;
    private long globalPosition;

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<SeekableByteChannel> r4 = this.channels.iterator();
        IOException r0 = null;
    L4:
        if (r4.hasNext() == false) goto L11;
        ((SeekableByteChannel) ZeusTransformUtils.preCheckCast(r4.next(), SeekableByteChannel.class, "com.obric.memorydata.plugin")).close();     // Catch: IOException -> L8
    L8:
        e = move-exception;
        if (r0 != null) goto L4;
        r0 = e;
        goto L4
    L11:
        if (r0 != null) goto L14;
        return;
    L14:
        throw new IOException("failed to close wrapped channel", r0);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        Iterator<SeekableByteChannel> r3 = this.channels.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((SeekableByteChannel) ZeusTransformUtils.preCheckCast(r3.next(), SeekableByteChannel.class, "com.obric.memorydata.plugin")).isOpen() == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long position() {
        return this.globalPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long r10) {
        monitor-enter(this);
        if (r10 < 0) goto L26;
        if (isOpen() == false) goto L22;
        this.globalPosition = r10;     // Catch: Throwable -> L23
        int r2 = 0;
    L9:
        if (r2 >= this.channels.size()) goto L19;
        SeekableByteChannel r3 = (SeekableByteChannel) ZeusTransformUtils.preCheckCast(this.channels.get(r2), SeekableByteChannel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        long r4 = r3.size();     // Catch: Throwable -> L23
        long r6 = -1;
        if (r10 != (-1)) goto L14;
        r6 = r10;
        r10 = 0;
    L17:
        r3.position(r10);     // Catch: Throwable -> L23
        r2 = r2 + 1;
        r10 = r6;
        goto L9
    L14:
        if (r10 > r4) goto L16;
        this.currentChannelIdx = r2;     // Catch: Throwable -> L23
        goto L17
    L16:
        r6 = r10 - r4;     // Catch: Throwable -> L23
        r10 = r4;
        goto L17
    L19:
        monitor-exit(this);
        return this;
    L22:
        throw new ClosedChannelException();     // Catch: Throwable -> L23
    L26:
        throw new IOException("Negative position: " + r10);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public synchronized SeekableByteChannel position(long r5, long r7) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (isOpen() == false) goto L13;
        int r0 = 0;
    L7:
        if (r0 >= r5) goto L9;
        r7 = r7 + ((SeekableByteChannel) ZeusTransformUtils.preCheckCast(this.channels.get(r0), SeekableByteChannel.class, "com.obric.memorydata.plugin")).size();     // Catch: Throwable -> L14
        r0 = r0 + 1;     // Catch: Throwable -> L14
        goto L7
    L9:
        SeekableByteChannel r6 = position(r7);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r6;
    L13:
        throw new ClosedChannelException();     // Catch: Throwable -> L14
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer r9) {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (isOpen() == false) goto L28;
        int r1 = 0;
        if (r9.hasRemaining() == true) goto L11;
        monitor-exit(this);
        return 0;
    L11:
        if (r9.hasRemaining() == false) goto L21;
        if (this.currentChannelIdx >= this.channels.size()) goto L21;
        SeekableByteChannel r0 = (SeekableByteChannel) ZeusTransformUtils.preCheckCast(this.channels.get(this.currentChannelIdx), SeekableByteChannel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        int r3 = r0.read(r9);     // Catch: Throwable -> L29
        if (r3 == (-1)) goto L16;
        if (r0.position() < r0.size()) goto L20;
        this.currentChannelIdx++;     // Catch: Throwable -> L29
    L20:
        r1 = r1 + r3;     // Catch: Throwable -> L29
        goto L11
    L16:
        this.currentChannelIdx++;     // Catch: Throwable -> L29
    L21:
        if (r1 <= 0) goto L25;
        this.globalPosition += (long) r1;     // Catch: Throwable -> L29
        monitor-exit(this);
        return r1;
    L25:
        monitor-exit(this);
        return -1;
    L28:
        throw new ClosedChannelException();     // Catch: Throwable -> L29
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        if (isOpen() == false) goto L10;
        long r0 = 0;
        Iterator<SeekableByteChannel> r5 = this.channels.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r0 = r0 + ((SeekableByteChannel) ZeusTransformUtils.preCheckCast(r5.next(), SeekableByteChannel.class, "com.obric.memorydata.plugin")).size();
        goto L6
    L8:
        return r0;
    L10:
        throw new ClosedChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long r1) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r1) {
        throw new NonWritableChannelException();
    }
}
