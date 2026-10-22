package org.msgpack.core;

import java.io.IOException;
import java.util.List;
import org.msgpack.core.buffer.ArrayBufferOutput;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;

/* JADX INFO: loaded from: classes3.dex */
public class MessageBufferPacker extends MessagePacker {
    protected MessageBufferPacker(MessagePack.PackerConfig r10) {
        this(new ArrayBufferOutput(r10.getBufferSize()), r10);
    }

    protected MessageBufferPacker(ArrayBufferOutput r10, MessagePack.PackerConfig r11) {
        super(r10, r11);
    }

    private ArrayBufferOutput getArrayBufferOut() {
        return (ArrayBufferOutput) this.out;
    }

    @Override // org.msgpack.core.MessagePacker
    public void clear() {
        super.clear();
        getArrayBufferOut().clear();
    }

    public int getBufferSize() {
        return getArrayBufferOut().getSize();
    }

    @Override // org.msgpack.core.MessagePacker
    public MessageBufferOutput reset(MessageBufferOutput r10) {
        if ((r10 instanceof ArrayBufferOutput) == false) goto L7;
        return super.reset(r10);
    L7:
        throw new IllegalArgumentException("MessageBufferPacker accepts only ArrayBufferOutput");
    }

    public List<MessageBuffer> toBufferList() {
        flush();     // Catch: IOException -> L5
        return getArrayBufferOut().toBufferList();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public byte[] toByteArray() {
        flush();     // Catch: IOException -> L5
        return getArrayBufferOut().toByteArray();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public MessageBuffer toMessageBuffer() {
        flush();     // Catch: IOException -> L5
        return getArrayBufferOut().toMessageBuffer();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
