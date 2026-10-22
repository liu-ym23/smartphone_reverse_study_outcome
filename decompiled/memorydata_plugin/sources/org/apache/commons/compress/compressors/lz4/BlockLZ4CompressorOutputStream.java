package org.apache.commons.compress.compressors.lz4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BlockLZ4CompressorOutputStream extends CompressorOutputStream {
    private final LZ77Compressor compressor;
    private final Deque<byte[]> expandedBlocks;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream os;
    private final Deque<Pair> pairs;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType = null;

        static {
            int[] r0 = new int[LZ77Compressor.Block.BlockType.values().length];
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType = r0;
            r0[LZ77Compressor.Block.BlockType.LITERAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.BACK_REFERENCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.EOD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static final class Pair {
        private int brLength;
        private int brOffset;
        private final Deque<byte[]> literals;
        private boolean written;

        Pair() {
            this.literals = new LinkedList();
        }

        static /* synthetic */ boolean access$000(Pair r0) {
            return r0.hasBeenWritten();
        }

        static /* synthetic */ void access$100(Pair r0, byte[] r1) {
            r0.prependLiteral(r1);
        }

        static /* synthetic */ int access$200(Pair r0) {
            return r0.backReferenceLength();
        }

        static /* synthetic */ Pair access$300(Pair r0, int r1) {
            return r0.splitWithNewBackReferenceLengthOf(r1);
        }

        static /* synthetic */ void access$400(Pair r0, Pair r1) {
            r0.prependTo(r1);
        }

        private int backReferenceLength() {
            return this.brLength;
        }

        private boolean hasBeenWritten() {
            return this.written;
        }

        private static int lengths(int r3, int r4) {
            int r0 = 15;
            if (r3 < 15) goto L7;
            r3 = 15;
        L7:
            if (r4 >= 4) goto L10;
            r0 = 0;
        L13:
            return (r3 << 4) | r0;
        L10:
            if (r4 >= 19) goto L13;
            r0 = r4 - 4;
            goto L13
        }

        private int literalLength() {
            Iterator<byte[]> r4 = this.literals.iterator();
            int r0 = 0;
        L4:
            if (r4.hasNext() == false) goto L6;
            r0 = r0 + ((byte[]) ZeusTransformUtils.preCheckCast(r4.next(), byte[].class, "com.obric.memorydata.plugin")).length;
            goto L4
        L6:
            return r0;
        }

        private void prependLiteral(byte[] r1) {
            this.literals.addFirst(r1);
        }

        private void prependTo(Pair r4) {
            Iterator<byte[]> r3 = this.literals.descendingIterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r4.prependLiteral((byte[]) ZeusTransformUtils.preCheckCast(r3.next(), byte[].class, "com.obric.memorydata.plugin"));
            goto L4
        }

        private Pair splitWithNewBackReferenceLengthOf(int r4) {
            Pair r0 = new Pair();
            r0.literals.addAll(this.literals);
            r0.brOffset = this.brOffset;
            r0.brLength = r4;
            return r0;
        }

        private static void writeLength(int r1, OutputStream r2) {
        L3:
            if (r1 < 255) goto L5;
            r2.write(255);
            r1 = r1 - 255;
            goto L3
        L5:
            r2.write(r1);
        }

        byte[] addLiteral(LZ77Compressor.LiteralBlock r4) {
            byte[] r5 = Arrays.copyOfRange(r4.getData(), r4.getOffset(), r4.getOffset() + r4.getLength());
            this.literals.add(r5);
            return r5;
        }

        boolean canBeWritten(int r1) {
            if (hasBackReference() == true) goto L5;
        L7:
            return false;
        L5:
            if (r1 < 16) goto L7;
            return true;
        }

        boolean hasBackReference() {
            if (this.brOffset <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        int length() {
            return literalLength() + this.brLength;
        }

        void setBackReference(LZ77Compressor.BackReference r2) {
            if (hasBackReference() == true) goto L7;
            this.brOffset = r2.getOffset();
            this.brLength = r2.getLength();
            return;
        L7:
            throw new IllegalStateException();
        }

        void writeTo(OutputStream r6) {
            int r0 = literalLength();
            r6.write(lengths(r0, this.brLength));
            if (r0 < 15) goto L5;
            writeLength(r0 - 15, r6);
        L5:
            Iterator<byte[]> r1 = this.literals.iterator();
        L7:
            if (r1.hasNext() == false) goto L10;
            r6.write((byte[]) ZeusTransformUtils.preCheckCast(r1.next(), byte[].class, "com.obric.memorydata.plugin"));
            goto L7
        L10:
            if (hasBackReference() == false) goto L14;
            ByteUtils.toLittleEndian(r6, this.brOffset, 2);
            int r2 = this.brLength;
            if ((r2 - 4) < 15) goto L14;
            writeLength((r2 - 4) - 15, r6);
        L14:
            this.written = true;
        }
    }

    public BlockLZ4CompressorOutputStream(OutputStream r2, Parameters r3) {
        this.oneByte = new byte[1];
        this.pairs = new LinkedList();
        this.expandedBlocks = new LinkedList();
        this.os = r2;
        this.compressor = new LZ77Compressor(r3, new $$Lambda$BlockLZ4CompressorOutputStream$yN0uftfpN_6Jpg1XWSFK242RBU(this));
    }

    private void addBackReference(LZ77Compressor.BackReference r2) {
        writeBlocksAndReturnUnfinishedPair(r2.getLength()).setBackReference(r2);
        recordBackReference(r2);
        clearUnusedBlocksAndPairs();
    }

    private void addLiteralBlock(LZ77Compressor.LiteralBlock r2) {
        recordLiteral(writeBlocksAndReturnUnfinishedPair(r2.getLength()).addLiteral(r2));
        clearUnusedBlocksAndPairs();
    }

    private void clearUnusedBlocks() {
        Iterator<byte[]> r0 = this.expandedBlocks.iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L7;
        r1 = r1 + 1;
        r2 = r2 + ((byte[]) ZeusTransformUtils.preCheckCast(r0.next(), byte[].class, "com.obric.memorydata.plugin")).length;
        if (r2 < 65536) goto L4;
    L7:
        int r3 = this.expandedBlocks.size();
    L8:
        if (r1 >= r3) goto L10;
        this.expandedBlocks.removeLast();
        r1 = r1 + 1;
        goto L8
    }

    private void clearUnusedBlocksAndPairs() {
        clearUnusedBlocks();
        clearUnusedPairs();
    }

    private void clearUnusedPairs() {
        Iterator<Pair> r0 = this.pairs.descendingIterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L7;
        r1 = r1 + 1;
        r2 = r2 + ((Pair) ZeusTransformUtils.preCheckCast(r0.next(), Pair.class, "com.obric.memorydata.plugin")).length();
        if (r2 < 65536) goto L4;
    L7:
        int r3 = this.pairs.size();
    L8:
        if (r1 >= r3) goto L13;
        if (Pair.access$000((Pair) ZeusTransformUtils.preCheckCast(this.pairs.peekFirst(), Pair.class, "com.obric.memorydata.plugin")) == false) goto L19;
        this.pairs.removeFirst();
        r1 = r1 + 1;
        goto L8
    L19:
        return;
    }

    public static Parameters.Builder createParameterBuilder() {
        return Parameters.builder(65536).withMinBackReferenceLength(4).withMaxBackReferenceLength(65535).withMaxOffset(65535).withMaxLiteralLength(65535);
    }

    private byte[] expand(int r3, int r4) {
        byte[] r0 = new byte[r4];
        if (r3 != 1) goto L7;
        byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast(this.expandedBlocks.peekFirst(), byte[].class, "com.obric.memorydata.plugin");
        byte r5 = r2[r2.length - 1];
        if (r5 == 0) goto L8;
        Arrays.fill(r0, r5);
    L8:
        return r0;
    L7:
        expandFromList(r0, r3, r4);
        goto L8
    }

    private void expandFromList(byte[] r10, int r11, int r12) {
        int r1 = r11;
        int r2 = 0;
    L3:
        if (r12 <= 0) goto L19;
        byte[] r3 = null;
        if (r1 <= 0) goto L17;
        Iterator<byte[]> r4 = this.expandedBlocks.iterator();
        int r5 = 0;
    L8:
        if (r4.hasNext() == false) goto L13;
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(r4.next(), byte[].class, "com.obric.memorydata.plugin");
        if ((r6.length + r5) >= r1) goto L11;
        r5 = r5 + r6.length;
        goto L8
    L11:
        r3 = r6;
    L13:
        if (r3 == null) goto L16;
        int r7 = (r5 + r3.length) - r1;
        int r8 = Math.min(r12, r3.length - r7);
    L18:
        System.arraycopy(r3, r7, r10, r2, r8);
        r1 = r1 - r8;
        r12 = r12 - r8;
        r2 = r2 + r8;
        goto L3
    L16:
        throw new IllegalStateException("Failed to find a block containing offset " + r11);
    L17:
        r7 = -r1;
        r8 = Math.min(r12, r2 + r1);
        r3 = r10;
        goto L18
    }

    private void recordBackReference(LZ77Compressor.BackReference r3) {
        this.expandedBlocks.addFirst(expand(r3.getOffset(), r3.getLength()));
    }

    private void recordLiteral(byte[] r1) {
        this.expandedBlocks.addFirst(r1);
    }

    private void rewriteLastPairs() {
        LinkedList r0 = new LinkedList();
        LinkedList r1 = new LinkedList();
        Iterator<Pair> r2 = this.pairs.descendingIterator();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");
        if (Pair.access$000(r5) == true) goto L10;
        int r7 = r5.length();
        r1.addFirst(Integer.valueOf(r7));
        r0.addFirst(r5);
        r4 = r4 + r7;
        if (r4 < 12) goto L4;
    L10:
        Iterator r6 = r0.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        this.pairs.remove((Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        int r8 = r0.size();
        int r9 = 1;
        int r10 = 0;
    L15:
        if (r9 >= r8) goto L17;
        r10 = r10 + ((Integer) ZeusTransformUtils.preCheckCast(r1.get(r9), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r9 = r9 + 1;
        goto L15
    L17:
        Pair r11 = new Pair();
        if (r10 <= 0) goto L20;
        Pair.access$100(r11, expand(r10, r10));
    L20:
        Pair r12 = (Pair) ZeusTransformUtils.preCheckCast(r0.get(0), Pair.class, "com.obric.memorydata.plugin");
        int r13 = 12 - r10;
        if (r12.hasBackReference() == false) goto L24;
        r3 = Pair.access$200(r12);
    L24:
        if (r12.hasBackReference() == false) goto L29;
        if (r3 < (r13 + 4)) goto L29;
        Pair.access$100(r11, expand(r10 + r13, r13));
        this.pairs.add(Pair.access$300(r12, r3 - r13));
    L32:
        this.pairs.add(r11);
        return;
    L29:
        if (r12.hasBackReference() == false) goto L31;
        Pair.access$100(r11, expand(r10 + r3, r3));
    L31:
        Pair.access$400(r12, r11);
        goto L32
    }

    private Pair writeBlocksAndReturnUnfinishedPair(int r3) {
        writeWritablePairs(r3);
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(this.pairs.peekLast(), Pair.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L6:
        Pair r5 = new Pair();
        this.pairs.addLast(r5);
        return r5;
    L5:
        if (r4.hasBackReference() == true) goto L6;
        return r4;
    }

    private void writeFinalLiteralBlock() {
        rewriteLastPairs();
        Iterator<Pair> r0 = this.pairs.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r0.next(), Pair.class, "com.obric.memorydata.plugin");
        if (Pair.access$000(r1) == true) goto L4;
        r1.writeTo(this.os);
        goto L4
    L8:
        this.pairs.clear();
    }

    private void writeWritablePairs(int r5) {
        Iterator<Pair> r0 = this.pairs.descendingIterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r0.next(), Pair.class, "com.obric.memorydata.plugin");
        if (Pair.access$000(r1) == true) goto L9;
        r5 = r5 + r1.length();
    L9:
        Iterator<Pair> r2 = this.pairs.iterator();
    L11:
        if (r2.hasNext() == false) goto L19;
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");
        if (Pair.access$000(r3) == true) goto L11;
        r5 = r5 - r3.length();
        if (r3.canBeWritten(r5) == false) goto L28;
        r3.writeTo(this.os);
        goto L11
    L28:
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        finish();     // Catch: Throwable -> L5
        this.os.close();
        return;
    L5:
        th = move-exception;
        this.os.close();
        throw th;
    }

    public void finish() {
        if (this.finished == true) goto L6;
        this.compressor.finish();
        this.finished = true;
        return;
    }

    public /* synthetic */ void lambda$new$0$BlockLZ4CompressorOutputStream(LZ77Compressor.Block r4) {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[r4.getType().ordinal()];
        if (r0 != 1) goto L5;
        addLiteralBlock((LZ77Compressor.LiteralBlock) ZeusTransformUtils.preCheckCast(r4, LZ77Compressor.LiteralBlock.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r0 != 2) goto L7;
        addBackReference((LZ77Compressor.BackReference) ZeusTransformUtils.preCheckCast(r4, LZ77Compressor.BackReference.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        if (r0 != 3) goto L15;
        writeFinalLiteralBlock();
        return;
    }

    public void prefill(byte[] r1, int r2, int r3) {
        if (r3 <= 0) goto L5;
        byte[] r4 = Arrays.copyOfRange(r1, r2, r3 + r2);
        this.compressor.prefill(r4);
        recordLiteral(r4);
        return;
    }

    @Override // java.io.OutputStream
    public void write(int r3) {
        byte[] r0 = this.oneByte;
        r0[0] = (byte) (r3 & 255);
        write(r0);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        this.compressor.compress(r1, r2, r3);
    }
}
