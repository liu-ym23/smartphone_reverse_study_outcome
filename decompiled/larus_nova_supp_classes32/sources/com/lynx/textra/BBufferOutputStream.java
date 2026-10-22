package com.lynx.textra;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BBufferOutputStream {
    private final ByteBuffer byteBuffer;

    public byte[] getByteArray() {
        return this.byteBuffer.array();
    }

    public BBufferOutputStream(int r2) {
        ByteBuffer r3 = ByteBuffer.allocate(r2);
        this.byteBuffer = r3;
        r3.order(ByteOrder.LITTLE_ENDIAN);
    }

    public BBufferOutputStream writeByte(byte r2) {
        this.byteBuffer.put(r2);
        return this;
    }

    public BBufferOutputStream writeFloat(float r2) {
        this.byteBuffer.putFloat(r2);
        return this;
    }

    public BBufferOutputStream writeInt(int r2) {
        this.byteBuffer.putInt(r2);
        return this;
    }

    public BBufferOutputStream writeLong(long r2) {
        this.byteBuffer.putLong(r2);
        return this;
    }

    public BBufferOutputStream writeShort(short r2) {
        this.byteBuffer.putShort(r2);
        return this;
    }
}
