package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes6.dex */
class CircularBuffer {
    private final byte[] buffer;
    private int readIndex;
    private final int size;
    private int writeIndex;

    CircularBuffer(int r1) {
        this.size = r1;
        this.buffer = new byte[r1];
    }

    public boolean available() {
        if (this.readIndex == this.writeIndex) goto L5;
        return true;
    L5:
        return false;
    }

    public void copy(int r5, int r6) {
        int r0 = this.writeIndex - r5;
        int r7 = r6 + r0;
    L3:
        if (r0 >= r7) goto L5;
        byte[] r8 = this.buffer;
        int r1 = this.writeIndex;
        int r2 = this.size;
        r8[r1] = r8[(r0 + r2) % r2];
        this.writeIndex = (r1 + 1) % r2;
        r0 = r0 + 1;
        goto L3
    }

    public int get() {
        if (available() == false) goto L6;
        byte[] r0 = this.buffer;
        int r1 = this.readIndex;
        byte r2 = r0[r1];
        this.readIndex = (r1 + 1) % this.size;
        return r2 & 255;
    L6:
        return -1;
    }

    public void put(int r3) {
        byte[] r0 = this.buffer;
        int r1 = this.writeIndex;
        r0[r1] = (byte) r3;
        this.writeIndex = (r1 + 1) % this.size;
    }
}
