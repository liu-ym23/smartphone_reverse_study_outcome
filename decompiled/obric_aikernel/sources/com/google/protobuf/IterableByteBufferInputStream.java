package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    IterableByteBufferInputStream(Iterable<ByteBuffer> r10) {
        this.iterator = r10.iterator();
        this.dataSize = 0;
        Iterator<ByteBuffer> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ByteBuffer r12 = r11.next();
        this.dataSize++;
        goto L4
    L6:
        this.currentIndex = -1;
        if (getNextByteBuffer() == true) goto L11;
        this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
        this.currentIndex = 0;
        this.currentByteBufferPos = 0;
        this.currentAddress = 0;
        return;
    }

    private boolean getNextByteBuffer() {
    L2:
        this.currentIndex++;
        if (this.iterator.hasNext() == false) goto L4;
        ByteBuffer r10 = this.iterator.next();
        this.currentByteBuffer = r10;
        if (r10.hasRemaining() == false) goto L2;
        this.currentByteBufferPos = this.currentByteBuffer.position();
        if (this.currentByteBuffer.hasArray() == false) goto L10;
        this.hasArray = true;
        this.currentArray = this.currentByteBuffer.array();
        this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
    L11:
        return true;
    L10:
        this.hasArray = false;
        this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
        this.currentArray = null;
        goto L11
    L4:
        return false;
    }

    private void updateCurrentByteBufferPos(int r10) {
        int r11 = this.currentByteBufferPos + r10;
        this.currentByteBufferPos = r11;
        if (r11 != this.currentByteBuffer.limit()) goto L6;
        getNextByteBuffer();
        return;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.currentIndex != this.dataSize) goto L7;
        return -1;
    L7:
        if (this.hasArray == false) goto L11;
        byte r10 = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset];
    L9:
        int r11 = r10 & 255;
        updateCurrentByteBufferPos(1);
        return r11;
    L11:
        r10 = UnsafeUtil.getByte(((long) this.currentByteBufferPos) + this.currentAddress);
        goto L9
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        if (this.currentIndex != this.dataSize) goto L6;
        return -1;
    L6:
        int r13 = this.currentByteBuffer.limit();
        int r14 = this.currentByteBufferPos;
        int r15 = r13 - r14;
        if (r12 <= r15) goto L10;
        r12 = r15;
    L10:
        if (this.hasArray == false) goto L12;
        System.arraycopy(this.currentArray, r14 + this.currentArrayOffset, r10, r11, r12);
    L13:
        updateCurrentByteBufferPos(r12);
        return r12;
    L12:
        int r16 = this.currentByteBuffer.position();
        Java8Compatibility.position(this.currentByteBuffer, this.currentByteBufferPos);
        this.currentByteBuffer.get(r10, r11, r12);
        Java8Compatibility.position(this.currentByteBuffer, r16);
        goto L13
    }
}
