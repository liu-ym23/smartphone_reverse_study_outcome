package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class POIFSStream implements Iterable<ByteBuffer> {
    private final BlockStore blockStore;
    private OutputStream outStream;
    private int startBlock;

    protected class StreamBlockByteBuffer extends OutputStream {
        ByteBuffer buffer;
        BlockStore.ChainLoopDetector loopDetector;
        int nextBlock;
        byte[] oneByte;
        int prevBlock;
        final /* synthetic */ POIFSStream this$0;

        StreamBlockByteBuffer(POIFSStream r2) {
            this.this$0 = r2;
            this.oneByte = new byte[1];
            this.loopDetector = POIFSStream.access$000(r2).getChainLoopDetector();
            this.prevBlock = -2;
            this.nextBlock = POIFSStream.access$100(r2);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            POIFSStream.access$200(new POIFSStream(POIFSStream.access$000(this.this$0), this.nextBlock), this.loopDetector);
            if (this.prevBlock == (-2)) goto L6;
            POIFSStream.access$000(this.this$0).setNextBlock(this.prevBlock, -2);
            return;
        }

        void createBlockIfNeeded() {
            ByteBuffer r0 = this.buffer;
            if (r0 != null) goto L5;
        L7:
            int r1 = this.nextBlock;
            if (r1 != (-2)) goto L15;
            r1 = POIFSStream.access$000(this.this$0).getFreeBlock();
            this.loopDetector.claim(r1);
            this.nextBlock = -2;
            if (this.prevBlock == (-2)) goto L12;
            POIFSStream.access$000(this.this$0).setNextBlock(this.prevBlock, r1);
        L12:
            POIFSStream.access$000(this.this$0).setNextBlock(r1, -2);
            if (POIFSStream.access$100(this.this$0) != (-2)) goto L17;
            POIFSStream.access$102(this.this$0, r1);
        L17:
            if (this.buffer == null) goto L19;
            POIFSStream.access$000(this.this$0).releaseBuffer(this.buffer);
        L19:
            this.buffer = POIFSStream.access$000(this.this$0).createBlockIfNeeded(r1);
            this.prevBlock = r1;
            return;
        L15:
            this.loopDetector.claim(r1);
            this.nextBlock = POIFSStream.access$000(this.this$0).getNextBlock(r1);
            goto L17
        L5:
            if (r0.hasRemaining() == false) goto L7;
        }

        @Override // java.io.OutputStream
        public void write(int r3) {
            byte[] r0 = this.oneByte;
            r0[0] = (byte) (r3 & 255);
            write(r0);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r3, int r4, int r5) {
            if (r4 < 0) goto L15;
            if (r4 > r3.length) goto L15;
            if (r5 < 0) goto L15;
            int r0 = r4 + r5;
            if (r0 > r3.length) goto L15;
            if (r0 < 0) goto L15;
            if (r5 != 0) goto L11;
            return;
        L11:
            createBlockIfNeeded();
            int r1 = Math.min(this.buffer.remaining(), r5);
            this.buffer.put(r3, r4, r1);
            r4 = r4 + r1;
            r5 = r5 - r1;
            if (r5 > 0) goto L11;
            return;
        L15:
            throw new IndexOutOfBoundsException();
        }
    }

    private class StreamBlockByteBufferIterator implements Iterator<ByteBuffer> {
        private final BlockStore.ChainLoopDetector loopDetector;
        private int nextBlock;
        final /* synthetic */ POIFSStream this$0;

        StreamBlockByteBufferIterator(POIFSStream r1, int r2) {
            this.this$0 = r1;
            this.nextBlock = r2;
            this.loopDetector = POIFSStream.access$000(r1).getChainLoopDetector();     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextBlock == (-2)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ByteBuffer next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public ByteBuffer next2() {
            if (hasNext() == false) goto L10;
            this.loopDetector.claim(this.nextBlock);     // Catch: IOException -> L6
            ByteBuffer r0 = POIFSStream.access$000(this.this$0).getBlockAt(this.nextBlock);     // Catch: IOException -> L6
            this.nextBlock = POIFSStream.access$000(this.this$0).getNextBlock(this.nextBlock);     // Catch: IOException -> L6
            return r0;
        L6:
            e = move-exception;
            throw new RuntimeException(e);
        L10:
            throw new NoSuchElementException("Can't read past the end of the stream");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class StreamBlockOffsetIterator implements Iterator<Integer> {
        private final BlockStore.ChainLoopDetector loopDetector;
        private int nextBlock;
        final /* synthetic */ POIFSStream this$0;

        StreamBlockOffsetIterator(POIFSStream r1, int r2) {
            this.this$0 = r1;
            this.nextBlock = r2;
            this.loopDetector = POIFSStream.access$000(r1).getChainLoopDetector();     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextBlock == (-2)) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            if (hasNext() == false) goto L7;
            this.loopDetector.claim(this.nextBlock);
            int r0 = this.nextBlock;
            this.nextBlock = POIFSStream.access$000(this.this$0).getNextBlock(this.nextBlock);
            return Integer.valueOf(r0);
        L7:
            throw new NoSuchElementException("Can't read past the end of the stream");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Integer next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public POIFSStream(BlockStore r1) {
        this.blockStore = r1;
        this.startBlock = -2;
    }

    public POIFSStream(BlockStore r1, int r2) {
        this.blockStore = r1;
        this.startBlock = r2;
    }

    static /* synthetic */ BlockStore access$000(POIFSStream r0) {
        return r0.blockStore;
    }

    static /* synthetic */ int access$100(POIFSStream r0) {
        return r0.startBlock;
    }

    static /* synthetic */ int access$102(POIFSStream r0, int r1) {
        r0.startBlock = r1;
        return r1;
    }

    static /* synthetic */ void access$200(POIFSStream r0, BlockStore.ChainLoopDetector r1) {
        r0.free(r1);
    }

    private void free(BlockStore.ChainLoopDetector r5) {
        int r0 = this.startBlock;
    L4:
        if (r0 == (-2)) goto L6;
        r5.claim(r0);
        int r1 = this.blockStore.getNextBlock(r0);
        this.blockStore.setNextBlock(r0, -1);
        r0 = r1;
        goto L4
    L6:
        this.startBlock = -2;
    }

    public void free() {
        free(this.blockStore.getChainLoopDetector());
    }

    Iterator<ByteBuffer> getBlockIterator() {
        if (this.startBlock == (-2)) goto L7;
        return new StreamBlockByteBufferIterator(this, this.startBlock);
    L7:
        throw new IllegalStateException("Can't read from a new stream before it has been written to");
    }

    Iterator<Integer> getBlockOffsetIterator() {
        if (this.startBlock == (-2)) goto L7;
        return new StreamBlockOffsetIterator(this, this.startBlock);
    L7:
        throw new IllegalStateException("Can't read from a new stream before it has been written to");
    }

    public OutputStream getOutputStream() {
        if (this.outStream != null) goto L6;
        this.outStream = new StreamBlockByteBuffer(this);
    L6:
        return this.outStream;
    }

    public int getStartBlock() {
        return this.startBlock;
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return getBlockIterator();
    }
}
