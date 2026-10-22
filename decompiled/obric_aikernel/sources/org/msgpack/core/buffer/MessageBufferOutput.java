package org.msgpack.core.buffer;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes3.dex */
public interface MessageBufferOutput extends Closeable, Flushable {
    void add(byte[] r10, int r11, int r12);

    MessageBuffer next(int r10);

    void write(byte[] r10, int r11, int r12);

    void writeBuffer(int r10);
}
