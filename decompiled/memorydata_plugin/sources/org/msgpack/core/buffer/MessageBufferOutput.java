package org.msgpack.core.buffer;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes7.dex */
public interface MessageBufferOutput extends Closeable, Flushable {
    void add(byte[] r1, int r2, int r3);

    MessageBuffer next(int r1);

    void write(byte[] r1, int r2, int r3);

    void writeBuffer(int r1);
}
