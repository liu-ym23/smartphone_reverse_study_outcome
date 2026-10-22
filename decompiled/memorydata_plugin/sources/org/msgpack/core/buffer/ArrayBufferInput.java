package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.msgpack.core.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
public class ArrayBufferInput implements MessageBufferInput {
    private MessageBuffer buffer;
    private boolean isEmpty;

    public ArrayBufferInput(MessageBuffer r1) {
        this.buffer = r1;
        if (r1 != null) goto L5;
        boolean r2 = true;
    L6:
        this.isEmpty = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public ArrayBufferInput(byte[] r3) {
        this(r3, 0, r3.length);
    }

    public ArrayBufferInput(byte[] r3, int r4, int r5) {
        this(MessageBuffer.wrap((byte[]) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3, "input array is null"), byte[].class, "com.obric.memorydata.plugin"), r4, r5));
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.buffer = null;
        this.isEmpty = true;
    }

    @Override // org.msgpack.core.buffer.MessageBufferInput
    public MessageBuffer next() {
        if (this.isEmpty == false) goto L6;
        return null;
    L6:
        this.isEmpty = true;
        return this.buffer;
    }

    public MessageBuffer reset(MessageBuffer r2) {
        MessageBuffer r0 = this.buffer;
        this.buffer = r2;
        if (r2 != null) goto L5;
        boolean r3 = true;
    L6:
        this.isEmpty = r3;
        return r0;
    L5:
        r3 = false;
        goto L6
    }

    public void reset(byte[] r3) {
        reset(MessageBuffer.wrap((byte[]) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3, "input array is null"), byte[].class, "com.obric.memorydata.plugin")));
    }

    public void reset(byte[] r3, int r4, int r5) {
        reset(MessageBuffer.wrap((byte[]) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3, "input array is null"), byte[].class, "com.obric.memorydata.plugin"), r4, r5));
    }
}
