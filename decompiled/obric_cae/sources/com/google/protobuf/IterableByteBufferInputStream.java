package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    public IterableByteBufferInputStream(Iterable<ByteBuffer> r8) {
        this.iterator = r8.iterator();
        this.dataSize = 0;
        Iterator<ByteBuffer> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ByteBuffer r11 = r10.next();
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
        ByteBuffer r8 = this.iterator.next();
        this.currentByteBuffer = r8;
        if (r8.hasRemaining() == false) goto L2;
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

    private void updateCurrentByteBufferPos(int r8) {
        int r10 = this.currentByteBufferPos + r8;
        this.currentByteBufferPos = r10;
        if (r10 != this.currentByteBuffer.limit()) goto L6;
        getNextByteBuffer();
        return;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.currentIndex != this.dataSize) goto L7;
        return -1;
    L7:
        if (this.hasArray == false) goto L11;
        byte r8 = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset];
    L9:
        int r10 = r8 & 255;
        updateCurrentByteBufferPos(1);
        return r10;
    L11:
        r8 = UnsafeUtil.getByte(((long) this.currentByteBufferPos) + this.currentAddress);
        goto L9
    }

    @Override // java.io.InputStream
    public int read(byte[] r8, int r10, int r11) {
        if (this.currentIndex != this.dataSize) goto L6;
        return -1;
    L6:
        int r12 = this.currentByteBuffer.limit();
        int r13 = this.currentByteBufferPos;
        int r14 = r12 - r13;
        if (r11 <= r14) goto L10;
        r11 = r14;
    L10:
        if (this.hasArray == false) goto L12;
        System.arraycopy(this.currentArray, r13 + this.currentArrayOffset, r8, r10, r11);
    L13:
        updateCurrentByteBufferPos(r11);
        return r11;
    L12:
        int r15 = this.currentByteBuffer.position();
        Java8Compatibility.position(this.currentByteBuffer, this.currentByteBufferPos);
        this.currentByteBuffer.get(r8, r10, r11);
        Java8Compatibility.position(this.currentByteBuffer, r15);
        goto L13
    }
}
