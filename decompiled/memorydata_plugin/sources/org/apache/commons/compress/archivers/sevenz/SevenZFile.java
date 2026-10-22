package org.apache.commons.compress.archivers.sevenz;

import java.io.Closeable;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class SevenZFile implements Closeable {
    private static final CharsetEncoder PASSWORD_ENCODER = null;
    static final byte[] sevenZSignature = null;
    private final Archive archive;
    private SeekableByteChannel channel;
    private byte[] password;

    static {
        sevenZSignature = new byte[]{55, 122, -68, -81, 39, 28};
        PASSWORD_ENCODER = StandardCharsets.UTF_16LE.newEncoder();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SeekableByteChannel r0 = this.channel;
        if (r0 != null) goto L17;
        return;
    L17:
        r0.close();     // Catch: Throwable -> L10
        this.channel = null;
        byte[] r1 = this.password;
        if (r1 == null) goto L9;
        Arrays.fill(r1, (byte) 0);
    L9:
        this.password = null;
        return;
    L10:
        th = move-exception;
        this.channel = null;
        byte[] r3 = this.password;
        if (r3 == null) goto L14;
        Arrays.fill(r3, (byte) 0);
    L14:
        this.password = null;
        throw th;
    }

    public String toString() {
        return this.archive.toString();
    }
}
