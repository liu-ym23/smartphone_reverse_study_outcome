package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public class InputStreamBufferInput implements MessageBufferInput {
    private final byte[] buffer;
    private InputStream in;

    public InputStreamBufferInput(InputStream r2) {
        this(r2, 8192);
    }

    public InputStreamBufferInput(InputStream r3, int r4) {
        this.in = (InputStream) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3, "input is null"), InputStream.class, "com.obric.memorydata.plugin");
        this.buffer = new byte[r4];
    }

    public static MessageBufferInput newBufferInput(InputStream r2) {
        Preconditions.checkNotNull(r2, "InputStream is null");
        if (ZeusTransformUtils.instanceOf(r2, FileInputStream.class) == false) goto L9;
        FileChannel r0 = ((FileInputStream) ZeusTransformUtils.preCheckCast(r2, FileInputStream.class, "com.obric.memorydata.plugin")).getChannel();
        if (r0 == null) goto L9;
        return new ChannelBufferInput(r0);
    L9:
        return new InputStreamBufferInput(r2);
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        int r0 = this.in.read(this.buffer);
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        return MessageBuffer.wrap(this.buffer, 0, r0);
    }

    public InputStream reset(InputStream r2) {
        InputStream r0 = this.in;
        this.in = r2;
        return r0;
    }
}
