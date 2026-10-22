package org.msgpack.core.buffer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class InputStreamBufferInput implements MessageBufferInput {
    private final byte[] buffer;
    private InputStream in;

    public InputStreamBufferInput(InputStream r10) {
        this(r10, 8192);
    }

    public InputStreamBufferInput(InputStream r10, int r11) {
        this.in = (InputStream) Preconditions.checkNotNull(r10, "input is null");
        this.buffer = new byte[r11];
    }

    public static MessageBufferInput newBufferInput(InputStream r10) {
        Preconditions.checkNotNull(r10, "InputStream is null");
        if ((r10 instanceof FileInputStream) == false) goto L9;
        FileChannel r11 = ((FileInputStream) r10).getChannel();
        if (r11 == null) goto L9;
        return new ChannelBufferInput(r11);
    L9:
        return new InputStreamBufferInput(r10);
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        int r10 = this.in.read(this.buffer);
        if (r10 != (-1)) goto L7;
        return null;
    L7:
        return MessageBuffer.wrap(this.buffer, 0, r10);
    }

    public InputStream reset(InputStream r10) {
        InputStream r11 = this.in;
        this.in = r10;
        return r11;
    }
}
