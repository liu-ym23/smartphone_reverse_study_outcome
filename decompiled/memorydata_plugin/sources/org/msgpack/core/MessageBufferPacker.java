package org.msgpack.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;
import org.msgpack.core.buffer.ArrayBufferOutput;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;

/* JADX INFO: loaded from: classes7.dex */
public class MessageBufferPacker extends MessagePacker {
    public MessageBufferPacker(MessagePack.PackerConfig r3) {
        this(new ArrayBufferOutput(r3.getBufferSize()), r3);
    }

    public MessageBufferPacker(ArrayBufferOutput r1, MessagePack.PackerConfig r2) {
        super(r1, r2);
    }

    private ArrayBufferOutput getArrayBufferOut() {
        return (ArrayBufferOutput) ZeusTransformUtils.preCheckCast(this.out, ArrayBufferOutput.class, "com.obric.memorydata.plugin");
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
    public MessageBufferOutput reset(MessageBufferOutput r3) {
        MessageBufferOutput r4 = (MessageBufferOutput) ZeusTransformUtils.wrapperContextForParams(r3, MessageBufferOutput.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ArrayBufferOutput.class) == false) goto L7;
        return super.reset(r4);
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
