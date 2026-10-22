package org.apache.poi.poifs.nio;

import java.nio.ByteBuffer;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ByteArrayBackedDataSource extends DataSource {
    private byte[] buffer;
    private long size;

    public ByteArrayBackedDataSource(byte[] r2) {
        this(r2, r2.length);
    }

    public ByteArrayBackedDataSource(byte[] r1, int r2) {
        this.buffer = r1;
        this.size = r2;
    }

    private void extend(long r8) {
        byte[] r0 = this.buffer;
        long r9 = r8 - ((long) r0.length);
        if (r9 >= (((double) r0.length) * 0.25d)) goto L6;
        r9 = (long) (((double) r0.length) * 0.25d);
    L6:
        if (r9 >= 4096) goto L8;
        r9 = 4096;
    L8:
        byte[] r10 = IOUtils.safelyAllocate(r9 + ((long) r0.length), Integer.MAX_VALUE);
        System.arraycopy(this.buffer, 0, r10, 0, (int) this.size);
        this.buffer = r10;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void close() {
        this.buffer = null;
        this.size = -1;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public ByteBuffer read(int r5, long r6) {
        long r0 = this.size;
        if (r6 >= r0) goto L7;
        return ByteBuffer.wrap(this.buffer, (int) r6, (int) Math.min(r5, r0 - r6));
    L7:
        throw new IndexOutOfBoundsException("Unable to read " + r5 + " bytes from " + r6 + " in stream of length " + this.size);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public long size() {
        return this.size;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void write(ByteBuffer r5, long r6) {
        long r0 = ((long) r5.capacity()) + r6;
        if (r0 <= this.buffer.length) goto L5;
        extend(r0);
    L5:
        r5.get(this.buffer, (int) r6, r5.capacity());
        if (r0 <= this.size) goto L9;
        this.size = r0;
        return;
    }
}
