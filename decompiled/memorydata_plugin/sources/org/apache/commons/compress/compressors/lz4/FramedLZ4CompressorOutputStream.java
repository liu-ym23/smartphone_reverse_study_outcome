package org.apache.commons.compress.compressors.lz4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class FramedLZ4CompressorOutputStream extends CompressorOutputStream {
    private static final byte[] END_MARK = null;
    private final byte[] blockData;
    private final byte[] blockDependencyBuffer;
    private final XXHash32 blockHash;
    private int collectedBlockDependencyBytes;
    private final XXHash32 contentHash;
    private int currentIndex;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream out;
    private final Parameters params;

    public static final enum BlockSize extends Enum<BlockSize> {
        private static final /* synthetic */ BlockSize[] $VALUES = null;
        public static final BlockSize K256 = null;
        public static final BlockSize K64 = null;
        public static final BlockSize M1 = null;
        public static final BlockSize M4 = null;
        private final int index;
        private final int size;

        static {
            BlockSize r0 = new BlockSize("K64", 0, 65536, 4);
            K64 = r0;
            BlockSize r1 = new BlockSize("K256", 1, 262144, 5);
            K256 = r1;
            BlockSize r3 = new BlockSize("M1", 2, 1048576, 6);
            M1 = r3;
            BlockSize r6 = new BlockSize("M4", 3, 4194304, 7);
            M4 = r6;
            $VALUES = new BlockSize[]{r0, r1, r3, r6};
        }

        private BlockSize(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.size = r3;
            this.index = r4;
        }

        public static BlockSize valueOf(String r2) {
            return (BlockSize) ZeusTransformUtils.preCheckCast(Enum.valueOf(BlockSize.class, r2), BlockSize.class, "com.obric.memorydata.plugin");
        }

        public static BlockSize[] values() {
            return (BlockSize[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BlockSize[].class, "com.obric.memorydata.plugin");
        }

        int getIndex() {
            return this.index;
        }

        int getSize() {
            return this.size;
        }
    }

    public static class Parameters {
        public static final Parameters DEFAULT = null;
        private final BlockSize blockSize;
        private final org.apache.commons.compress.compressors.lz77support.Parameters lz77params;
        private final boolean withBlockChecksum;
        private final boolean withBlockDependency;
        private final boolean withContentChecksum;

        static {
            DEFAULT = new Parameters(BlockSize.M4, true, false, false);
        }

        public Parameters(BlockSize r8, boolean r9, boolean r10, boolean r11) {
            this(r8, r9, r10, r11, BlockLZ4CompressorOutputStream.createParameterBuilder().build());
        }

        public Parameters(BlockSize r1, boolean r2, boolean r3, boolean r4, org.apache.commons.compress.compressors.lz77support.Parameters r5) {
            this.blockSize = r1;
            this.withContentChecksum = r2;
            this.withBlockChecksum = r3;
            this.withBlockDependency = r4;
            this.lz77params = r5;
        }

        static /* synthetic */ boolean access$100(Parameters r0) {
            return r0.withBlockChecksum;
        }

        static /* synthetic */ boolean access$200(Parameters r0) {
            return r0.withBlockDependency;
        }

        static /* synthetic */ boolean access$300(Parameters r0) {
            return r0.withContentChecksum;
        }

        static /* synthetic */ org.apache.commons.compress.compressors.lz77support.Parameters access$400(Parameters r0) {
            return r0.lz77params;
        }

        public String toString() {
            return "LZ4 Parameters with BlockSize " + this.blockSize + ", withContentChecksum " + this.withContentChecksum + ", withBlockChecksum " + this.withBlockChecksum + ", withBlockDependency " + this.withBlockDependency;
        }
    }

    static {
        END_MARK = new byte[4];
    }

    private void appendToBlockDependencyBuffer(byte[] r4, int r5, int r6) {
        int r7 = Math.min(r6, this.blockDependencyBuffer.length);
        if (r7 <= 0) goto L9;
        byte[] r0 = this.blockDependencyBuffer;
        int r1 = r0.length - r7;
        if (r1 <= 0) goto L7;
        System.arraycopy(r0, r7, r0, 0, r1);
    L7:
        System.arraycopy(r4, r5, this.blockDependencyBuffer, r1, r7);
        this.collectedBlockDependencyBytes = Math.min(this.collectedBlockDependencyBytes + r7, this.blockDependencyBuffer.length);
        return;
    }

    private void flushBlock() {
        boolean r0 = Parameters.access$200(this.params);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        BlockLZ4CompressorOutputStream r2 = new BlockLZ4CompressorOutputStream(r1, Parameters.access$400(this.params));
        if (r0 == true) goto L30;
    L5:
        r2.write(this.blockData, 0, this.currentIndex);     // Catch: Throwable -> L22
        r2.close();
        if (r0 == false) goto L9;
        appendToBlockDependencyBuffer(this.blockData, 0, this.currentIndex);
    L9:
        byte[] r3 = r1.toByteArray();
        int r4 = r3.length;
        int r5 = this.currentIndex;
        if (r4 <= r5) goto L14;
        ByteUtils.toLittleEndian(this.out, Integer.MIN_VALUE | r5, 4);
        this.out.write(this.blockData, 0, this.currentIndex);
        if (Parameters.access$100(this.params) == false) goto L18;
        this.blockHash.update(this.blockData, 0, this.currentIndex);
    L18:
        if (Parameters.access$100(this.params) == false) goto L20;
        ByteUtils.toLittleEndian(this.out, this.blockHash.getValue(), 4);
        this.blockHash.reset();
    L20:
        this.currentIndex = 0;
        return;
    L14:
        ByteUtils.toLittleEndian(this.out, r3.length, 4);
        this.out.write(r3);
        if (Parameters.access$100(this.params) == false) goto L18;
        this.blockHash.update(r3, 0, r3.length);
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L27
    L29:
        throw th;
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    L30:
        byte[] r6 = this.blockDependencyBuffer;     // Catch: Throwable -> L22
        int r7 = r6.length;     // Catch: Throwable -> L22
        int r8 = this.collectedBlockDependencyBytes;     // Catch: Throwable -> L22
        r2.prefill(r6, r7 - r8, r8);     // Catch: Throwable -> L22
        goto L5
    }

    private void writeTrailer() {
        this.out.write(END_MARK);
        if (Parameters.access$300(this.params) == false) goto L6;
        ByteUtils.toLittleEndian(this.out, this.contentHash.getValue(), 4);
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        finish();     // Catch: Throwable -> L5
        this.out.close();
        return;
    L5:
        th = move-exception;
        this.out.close();
        throw th;
    }

    public void finish() {
        if (this.finished == false) goto L5;
        return;
    L5:
        if (this.currentIndex <= 0) goto L7;
        flushBlock();
    L7:
        writeTrailer();
        this.finished = true;
    }

    @Override // java.io.OutputStream
    public void write(int r3) {
        byte[] r0 = this.oneByte;
        r0[0] = (byte) (r3 & 255);
        write(r0);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r4, int r5, int r6) {
        if (Parameters.access$300(this.params) == false) goto L5;
        this.contentHash.update(r4, r5, r6);
    L5:
        int r0 = this.blockData.length;
        if ((this.currentIndex + r6) <= r0) goto L10;
    L7:
        flushBlock();
        if (r6 <= r0) goto L10;
        System.arraycopy(r4, r5, this.blockData, 0, r0);
        r5 = r5 + r0;
        r6 = r6 - r0;
        this.currentIndex = r0;
    L10:
        System.arraycopy(r4, r5, this.blockData, this.currentIndex, r6);
        this.currentIndex += r6;
    }
}
