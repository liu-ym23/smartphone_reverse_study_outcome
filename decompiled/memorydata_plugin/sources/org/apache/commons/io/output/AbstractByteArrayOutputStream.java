package org.apache.commons.io.output;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ClosedInputStream;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractByteArrayOutputStream extends OutputStream {
    private final List<byte[]> buffers;
    protected int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;
    private boolean reuseBuffers;

    @FunctionalInterface
    protected interface InputStreamConstructor<T extends InputStream> {
        T construct(byte[] r1, int r2, int r3);
    }

    public AbstractByteArrayOutputStream() {
        this.buffers = new ArrayList();
        this.reuseBuffers = true;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void needNewBuffer(int r3) {
        if (this.currentBufferIndex >= (this.buffers.size() - 1)) goto L5;
        this.filledBufferSum += this.currentBuffer.length;
        int r4 = this.currentBufferIndex + 1;
        this.currentBufferIndex = r4;
        this.currentBuffer = (byte[]) ZeusTransformUtils.preCheckCast(this.buffers.get(r4), byte[].class, "com.obric.memorydata.plugin");
        return;
    L5:
        byte[] r0 = this.currentBuffer;
        if (r0 != null) goto L8;
        int r1 = 0;
    L9:
        this.filledBufferSum = r1;
        this.currentBufferIndex++;
        byte[] r5 = IOUtils.byteArray(r3);
        this.currentBuffer = r5;
        this.buffers.add(r5);
        return;
    L8:
        r3 = Math.max(r0.length << 1, r3 - this.filledBufferSum);
        r1 = this.filledBufferSum + this.currentBuffer.length;
        goto L9
    }

    public void resetImpl() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        if (this.reuseBuffers == false) goto L5;
        this.currentBuffer = (byte[]) ZeusTransformUtils.preCheckCast(this.buffers.get(0), byte[].class, "com.obric.memorydata.plugin");
        return;
    L5:
        this.currentBuffer = null;
        int r0 = ((byte[]) ZeusTransformUtils.preCheckCast(this.buffers.get(0), byte[].class, "com.obric.memorydata.plugin")).length;
        this.buffers.clear();
        needNewBuffer(r0);
        this.reuseBuffers = true;
    }

    public abstract byte[] toByteArray();

    public byte[] toByteArrayImpl() {
        int r0 = this.count;
        if (r0 == 0) goto L5;
        byte[] r1 = IOUtils.byteArray(r0);
        Iterator<byte[]> r7 = this.buffers.iterator();
        int r3 = 0;
    L8:
        if (r7.hasNext() == false) goto L11;
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r7.next(), byte[].class, "com.obric.memorydata.plugin");
        int r5 = Math.min(r4.length, r0);
        System.arraycopy(r4, 0, r1, r3, r5);
        r3 = r3 + r5;
        r0 = r0 - r5;
        if (r0 != 0) goto L8;
    L11:
        return r1;
    L5:
        return IOUtils.EMPTY_BYTE_ARRAY;
    }

    public <T extends InputStream> InputStream toInputStream(InputStreamConstructor<T> r8) {
        InputStreamConstructor r9 = (InputStreamConstructor) ZeusTransformUtils.wrapperContextForParams(r8, InputStreamConstructor.class, "com.obric.memorydata.plugin");
        int r0 = this.count;
        if (r0 == 0) goto L5;
        ArrayList r2 = new ArrayList(this.buffers.size());
        Iterator<byte[]> r3 = this.buffers.iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.next(), byte[].class, "com.obric.memorydata.plugin");
        int r6 = Math.min(r4.length, r0);
        r2.add(r9.construct(r4, 0, r6));
        r0 = r0 - r6;
        if (r0 != 0) goto L8;
    L11:
        this.reuseBuffers = false;
        return new SequenceInputStream(Collections.enumeration(r2));
    L5:
        return ClosedInputStream.CLOSED_INPUT_STREAM;
    }

    @Deprecated
    public String toString() {
        return new String(toByteArray(), Charset.defaultCharset());
    }

    public void writeImpl(int r4) {
        int r0 = this.count;
        int r1 = r0 - this.filledBufferSum;
        if (r1 != this.currentBuffer.length) goto L5;
        needNewBuffer(r0 + 1);
        r1 = 0;
    L5:
        this.currentBuffer[r1] = (byte) r4;
        this.count++;
    }

    public void writeImpl(byte[] r7, int r8, int r9) {
        int r0 = this.count;
        int r1 = r0 + r9;
        int r2 = r0 - this.filledBufferSum;
        int r3 = r9;
    L3:
        if (r3 <= 0) goto L7;
        int r4 = Math.min(r3, this.currentBuffer.length - r2);
        System.arraycopy(r7, (r8 + r9) - r3, this.currentBuffer, r2, r4);
        r3 = r3 - r4;
        if (r3 <= 0) goto L3;
        needNewBuffer(r1);
        r2 = 0;
        goto L3
    L7:
        this.count = r1;
    }

    public void writeToImpl(OutputStream r5) {
        int r0 = this.count;
        Iterator<byte[]> r4 = this.buffers.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(r4.next(), byte[].class, "com.obric.memorydata.plugin");
        int r2 = Math.min(r1.length, r0);
        r5.write(r1, 0, r2);
        r0 = r0 - r2;
        if (r0 != 0) goto L4;
        return;
    }
}
