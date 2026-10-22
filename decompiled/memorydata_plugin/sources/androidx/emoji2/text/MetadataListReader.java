package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.emoji2.text.flatbuffer.MetadataList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
class MetadataListReader {
    private static final int EMJI_TAG = 1164798569;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 1835365473;

    private static class ByteBufferReader implements OpenTypeReader {
        private final ByteBuffer mByteBuffer;

        ByteBufferReader(ByteBuffer r1) {
            this.mByteBuffer = r1;
            r1.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.mByteBuffer.position();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() {
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() {
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() {
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int r2) {
            ByteBuffer r1 = this.mByteBuffer;
            r1.position(r1.position() + r2);
        }
    }

    private static class InputStreamOpenTypeReader implements OpenTypeReader {
        private final byte[] mByteArray;
        private final ByteBuffer mByteBuffer;
        private final InputStream mInputStream;
        private long mPosition;

        InputStreamOpenTypeReader(InputStream r3) {
            this.mPosition = 0;
            this.mInputStream = r3;
            byte[] r4 = new byte[4];
            this.mByteArray = r4;
            ByteBuffer r5 = ByteBuffer.wrap(r4);
            this.mByteBuffer = r5;
            r5.order(ByteOrder.BIG_ENDIAN);
        }

        private void read(int r5) {
            if (this.mInputStream.read(this.mByteArray, 0, r5) != r5) goto L7;
            this.mPosition += (long) r5;
            return;
        L7:
            throw new IOException("read failed");
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.mPosition;
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() {
            this.mByteBuffer.position(0);
            read(4);
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() {
            this.mByteBuffer.position(0);
            read(4);
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() {
            this.mByteBuffer.position(0);
            read(2);
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int r6) {
        L2:
            if (r6 <= 0) goto L8;
            int r0 = (int) this.mInputStream.skip(r6);
            if (r0 < 1) goto L7;
            r6 = r6 - r0;
            this.mPosition += (long) r0;
            goto L2
        L7:
            throw new IOException("Skip didn't move at least 1 byte forward");
        }
    }

    private static class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        OffsetInfo(long r1, long r3) {
            this.mStartOffset = r1;
            this.mLength = r3;
        }

        long getLength() {
            return this.mLength;
        }

        long getStartOffset() {
            return this.mStartOffset;
        }
    }

    private interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        long getPosition();

        int readTag();

        long readUnsignedInt();

        int readUnsignedShort();

        void skip(int r1);
    }

    private MetadataListReader() {
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader r12) {
        OpenTypeReader r13 = (OpenTypeReader) ZeusTransformUtils.wrapperContextForParams(r12, OpenTypeReader.class, "com.obric.memorydata.plugin");
        r13.skip(4);
        int r1 = r13.readUnsignedShort();
        if (r1 > 100) goto L28;
        r13.skip(6);
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        int r7 = r13.readTag();
        r13.skip(4);
        long r8 = r13.readUnsignedInt();
        r13.skip(4);
        if (META_TABLE_NAME == r7) goto L13;
        r4 = r4 + 1;
    L13:
        if (r8 == (-1)) goto L26;
        r13.skip((int) (r8 - r13.getPosition()));
        r13.skip(12);
        long r0 = r13.readUnsignedInt();
    L16:
        if (r3 >= r0) goto L26;
        int r5 = r13.readTag();
        long r6 = r13.readUnsignedInt();
        long r10 = r13.readUnsignedInt();
        if (EMJI_TAG == r5) goto L24;
        if (EMJI_TAG_DEPRECATED == r5) goto L24;
        r3 = r3 + 1;
    L24:
        return new OffsetInfo(r6 + r8, r10);
    L26:
        throw new IOException("Cannot read metadata.");
    L11:
        r8 = -1;
        goto L13
    L28:
        throw new IOException("Cannot read metadata.");
    }

    static MetadataList read(AssetManager r0, String r1) {
        InputStream r2 = r0.open(r1);
        MetadataList r3 = read(r2);     // Catch: Throwable -> L7
        if (r2 == null) goto L6;
        r2.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        if (r2 != null) goto L14;
    L13:
        throw th;
    L14:
        r2.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    static MetadataList read(InputStream r6) {
        InputStreamOpenTypeReader r0 = new InputStreamOpenTypeReader(r6);
        OffsetInfo r1 = findOffsetInfo(r0);
        r0.skip((int) (r1.getStartOffset() - r0.getPosition()));
        ByteBuffer r2 = ByteBuffer.allocate((int) r1.getLength());
        int r7 = r6.read(r2.array());
        if (r7 != r1.getLength()) goto L7;
        return MetadataList.getRootAsMetadataList(r2);
    L7:
        throw new IOException("Needed " + r1.getLength() + " bytes, got " + r7);
    }

    static MetadataList read(ByteBuffer r2) {
        ByteBuffer r3 = r2.duplicate();
        r3.position((int) findOffsetInfo(new ByteBufferReader(r3)).getStartOffset());
        return MetadataList.getRootAsMetadataList(r3);
    }

    static long toUnsignedInt(int r4) {
        return ((long) r4) & 4294967295L;
    }

    static int toUnsignedShort(short r1) {
        return r1 & UShort.MAX_VALUE;
    }
}
