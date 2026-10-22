package com.lynx.textra;

import com.obric.aivoice.core.data.NameKeys;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BBufferInputStream {
    private final byte[] buffer;
    private final ByteBuffer byteBuffer;

    public char ReadChar() {
        return this.byteBuffer.getChar();
    }

    public int ReadVarInt32() throws IOException {
        int r0 = this.byteBuffer.get() & 255;
        int r1 = r0 & 127;
        int r3 = 7;
    L4:
        if (r0 <= 127) goto L6;
        r0 = this.byteBuffer.get() & 255;
        r1 = r1 | ((r0 & 127) << r3);
        r3 = r3 + 7;
        goto L4
    L6:
        return r1;
    }

    public int available() {
        return this.byteBuffer.limit() - this.byteBuffer.position();
    }

    public byte readByte() {
        return this.byteBuffer.get();
    }

    public float readFloat() {
        return this.byteBuffer.getFloat();
    }

    public int readInt() {
        return this.byteBuffer.getInt();
    }

    public long readLong() {
        return this.byteBuffer.getLong();
    }

    public short readShort() {
        return this.byteBuffer.getShort();
    }

    public String ReadCString() throws IOException {
        int r0 = readInt();
        if (r0 != 0) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        int r1 = this.byteBuffer.position();
        this.byteBuffer.position(r1 + r0);
        return new String(this.buffer, r1, r0, Charset.defaultCharset());
    }

    public BBufferInputStream(byte[] r3) {
        ByteBuffer r0 = ByteBuffer.wrap(r3);
        this.byteBuffer = r0;
        r0.order(ByteOrder.LITTLE_ENDIAN);
        this.buffer = r3;
    }

    public void read(byte[] r2, int r3, int r4) {
        this.byteBuffer.get(r2, r3, r4);
    }
}
