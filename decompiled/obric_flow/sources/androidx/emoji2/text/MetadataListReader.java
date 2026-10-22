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

    public static class ByteBufferReader implements OpenTypeReader {

        @NonNull
        private final ByteBuffer mByteBuffer;

        public ByteBufferReader(@NonNull ByteBuffer r5) {
            this.mByteBuffer = r5;
            r5.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.mByteBuffer.position();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() throws IOException {
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() throws IOException {
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int r5) throws IOException {
            ByteBuffer r10 = this.mByteBuffer;
            r10.position(r10.position() + r5);
        }
    }

    public static class InputStreamOpenTypeReader implements OpenTypeReader {

        @NonNull
        private final byte[] mByteArray;

        @NonNull
        private final ByteBuffer mByteBuffer;

        @NonNull
        private final InputStream mInputStream;
        private long mPosition;

        public InputStreamOpenTypeReader(@NonNull InputStream r5) {
            this.mPosition = 0;
            this.mInputStream = r5;
            byte[] r10 = new byte[4];
            this.mByteArray = r10;
            ByteBuffer r11 = ByteBuffer.wrap(r10);
            this.mByteBuffer = r11;
            r11.order(ByteOrder.BIG_ENDIAN);
        }

        private void read(@IntRange(from = 0, to = 4) int r5) throws IOException {
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
        public int readTag() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            this.mByteBuffer.position(0);
            read(2);
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int r10) throws IOException {
        L2:
            if (r10 <= 0) goto L8;
            int r5 = (int) this.mInputStream.skip(r10);
            if (r5 < 1) goto L7;
            r10 = r10 - r5;
            this.mPosition += (long) r5;
            goto L2
        L7:
            throw new IOException("Skip didn't move at least 1 byte forward");
        }
    }

    public static class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        public OffsetInfo(long r5, long r10) {
            this.mStartOffset = r5;
            this.mLength = r10;
        }

        public long getLength() {
            return this.mLength;
        }

        public long getStartOffset() {
            return this.mStartOffset;
        }
    }

    public interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        long getPosition();

        int readTag() throws IOException;

        long readUnsignedInt() throws IOException;

        int readUnsignedShort() throws IOException;

        void skip(int r5) throws IOException;
    }

    private MetadataListReader() {
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader r12) throws IOException {
        r12.skip(4);
        int r5 = r12.readUnsignedShort();
        if (r5 > 100) goto L28;
        r12.skip(6);
        int r10 = 0;
        int r11 = 0;
    L6:
        if (r11 >= r5) goto L11;
        int r13 = r12.readTag();
        r12.skip(4);
        long r14 = r12.readUnsignedInt();
        r12.skip(4);
        if (META_TABLE_NAME == r13) goto L13;
        r11 = r11 + 1;
    L13:
        if (r14 == (-1)) goto L26;
        r12.skip((int) (r14 - r12.getPosition()));
        r12.skip(12);
        long r15 = r12.readUnsignedInt();
    L16:
        if (r10 >= r15) goto L26;
        int r16 = r12.readTag();
        long r17 = r12.readUnsignedInt();
        long r18 = r12.readUnsignedInt();
        if (EMJI_TAG == r16) goto L24;
        if (EMJI_TAG_DEPRECATED == r16) goto L24;
        r10 = r10 + 1;
    L24:
        return new OffsetInfo(r17 + r14, r18);
    L26:
        throw new IOException("Cannot read metadata.");
    L11:
        r14 = -1;
        goto L13
    L28:
        throw new IOException("Cannot read metadata.");
    }

    public static MetadataList read(InputStream r10) throws IOException {
        InputStreamOpenTypeReader r5 = new InputStreamOpenTypeReader(r10);
        OffsetInfo r11 = findOffsetInfo(r5);
        r5.skip((int) (r11.getStartOffset() - r5.getPosition()));
        ByteBuffer r12 = ByteBuffer.allocate((int) r11.getLength());
        int r13 = r10.read(r12.array());
        if (r13 != r11.getLength()) goto L7;
        return MetadataList.getRootAsMetadataList(r12);
    L7:
        throw new IOException("Needed " + r11.getLength() + " bytes, got " + r13);
    }

    public static long toUnsignedInt(int r5) {
        return ((long) r5) & 4294967295L;
    }

    public static int toUnsignedShort(short r5) {
        return r5 & UShort.MAX_VALUE;
    }

    public static MetadataList read(ByteBuffer r5) throws IOException {
        ByteBuffer r10 = r5.duplicate();
        r10.position((int) findOffsetInfo(new ByteBufferReader(r10)).getStartOffset());
        return MetadataList.getRootAsMetadataList(r10);
    }

    public static MetadataList read(AssetManager r5, String r10) throws IOException {
        InputStream r11 = r5.open(r10);
        MetadataList r12 = read(r11);     // Catch: Throwable -> L7
        if (r11 == null) goto L6;
        r11.close();
    L6:
        return r12;
    L7:
        th = move-exception;
        if (r11 != null) goto L14;
    L13:
        throw th;
    L14:
        r11.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
