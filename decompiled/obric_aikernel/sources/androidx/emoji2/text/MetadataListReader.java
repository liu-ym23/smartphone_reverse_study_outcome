package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class MetadataListReader {
    private static final int EMJI_TAG = 1164798569;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 1835365473;

    private static class ByteBufferReader implements OpenTypeReader {

        @NonNull
        private final ByteBuffer mByteBuffer;

        ByteBufferReader(@NonNull ByteBuffer r10) {
            this.mByteBuffer = r10;
            r10.order(ByteOrder.BIG_ENDIAN);
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
        public void skip(int r10) {
            ByteBuffer r11 = this.mByteBuffer;
            r11.position(r11.position() + r10);
        }
    }

    private static class InputStreamOpenTypeReader implements OpenTypeReader {

        @NonNull
        private final byte[] mByteArray;

        @NonNull
        private final ByteBuffer mByteBuffer;

        @NonNull
        private final InputStream mInputStream;
        private long mPosition;

        InputStreamOpenTypeReader(@NonNull InputStream r10) {
            this.mPosition = 0;
            this.mInputStream = r10;
            byte[] r11 = new byte[4];
            this.mByteArray = r11;
            ByteBuffer r12 = ByteBuffer.wrap(r11);
            this.mByteBuffer = r12;
            r12.order(ByteOrder.BIG_ENDIAN);
        }

        private void read(@IntRange(from = 0, to = 4) int r10) {
            if (this.mInputStream.read(this.mByteArray, 0, r10) != r10) goto L7;
            this.mPosition += (long) r10;
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
        public void skip(int r10) {
        L2:
            if (r10 <= 0) goto L8;
            int r11 = (int) this.mInputStream.skip(r10);
            if (r11 < 1) goto L7;
            r10 = r10 - r11;
            this.mPosition += (long) r11;
            goto L2
        L7:
            throw new IOException("Skip didn't move at least 1 byte forward");
        }
    }

    private static class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        OffsetInfo(long r10, long r11) {
            this.mStartOffset = r10;
            this.mLength = r11;
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

        void skip(int r10);
    }

    private MetadataListReader() {
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader r12) {
        r12.skip(4);
        int r10 = r12.readUnsignedShort();
        if (r10 > 100) goto L28;
        r12.skip(6);
        int r11 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L11;
        int r14 = r12.readTag();
        r12.skip(4);
        long r15 = r12.readUnsignedInt();
        r12.skip(4);
        if (META_TABLE_NAME == r14) goto L13;
        r13 = r13 + 1;
    L13:
        if (r15 == (-1)) goto L26;
        r12.skip((int) (r15 - r12.getPosition()));
        r12.skip(12);
        long r16 = r12.readUnsignedInt();
    L16:
        if (r11 >= r16) goto L26;
        int r17 = r12.readTag();
        long r18 = r12.readUnsignedInt();
        long r19 = r12.readUnsignedInt();
        if (EMJI_TAG == r17) goto L24;
        if (EMJI_TAG_DEPRECATED == r17) goto L24;
        r11 = r11 + 1;
    L24:
        return new OffsetInfo(r18 + r15, r19);
    L26:
        throw new IOException("Cannot read metadata.");
    L11:
        r15 = -1;
        goto L13
    L28:
        throw new IOException("Cannot read metadata.");
    }

    static MetadataList read(AssetManager r10, String r11) {
        InputStream r12 = r10.open(r11);
        MetadataList r13 = read(r12);     // Catch: Throwable -> L7
        if (r12 == null) goto L6;
        r12.close();
    L6:
        return r13;
    L7:
        th = move-exception;
        if (r12 != null) goto L14;
    L13:
        throw th;
    L14:
        r12.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    static MetadataList read(InputStream r10) {
        InputStreamOpenTypeReader r11 = new InputStreamOpenTypeReader(r10);
        OffsetInfo r12 = findOffsetInfo(r11);
        r11.skip((int) (r12.getStartOffset() - r11.getPosition()));
        ByteBuffer r13 = ByteBuffer.allocate((int) r12.getLength());
        int r14 = r10.read(r13.array());
        if (r14 != r12.getLength()) goto L7;
        return MetadataList.getRootAsMetadataList(r13);
    L7:
        throw new IOException("Needed " + r12.getLength() + " bytes, got " + r14);
    }

    static MetadataList read(ByteBuffer r10) {
        ByteBuffer r11 = r10.duplicate();
        r11.position((int) findOffsetInfo(new ByteBufferReader(r11)).getStartOffset());
        return MetadataList.getRootAsMetadataList(r11);
    }

    static long toUnsignedInt(int r10) {
        return ((long) r10) & 4294967295L;
    }

    static int toUnsignedShort(short r10) {
        return r10 & UShort.MAX_VALUE;
    }
}
