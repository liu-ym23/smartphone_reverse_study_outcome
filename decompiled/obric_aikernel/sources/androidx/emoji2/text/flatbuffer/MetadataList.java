package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataList extends Table {

    public static final class Vector extends BaseVector {
        public Vector() {
        }

        public Vector __assign(int r10, int r11, ByteBuffer r12) {
            __reset(r10, r11, r12);
            return this;
        }

        public MetadataList get(int r10) {
            return get(new MetadataList(), r10);
        }

        public MetadataList get(MetadataList r10, int r11) {
            return r10.__assign(MetadataList.access$000(__element(r11), this.f374bb), this.f374bb);
        }
    }

    public MetadataList() {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    static /* synthetic */ int access$000(int r10, ByteBuffer r11) {
        return Table.__indirect(r10, r11);
    }

    public static void addList(FlatBufferBuilder r10, int r11) {
        r10.addOffset(1, r11, 0);
    }

    public static void addSourceSha(FlatBufferBuilder r10, int r11) {
        r10.addOffset(2, r11, 0);
    }

    public static void addVersion(FlatBufferBuilder r10, int r11) {
        r10.addInt(0, r11, 0);
    }

    public static int createListVector(FlatBufferBuilder r10, int[] r11) {
        r10.startVector(4, r11.length, 4);
        int r12 = r11.length - 1;
    L3:
        if (r12 < 0) goto L6;
        r10.addOffset(r11[r12]);
        r12 = r12 - 1;
        goto L3
    L6:
        return r10.endVector();
    }

    public static int createMetadataList(FlatBufferBuilder r10, int r11, int r12, int r13) {
        r10.startTable(3);
        addSourceSha(r10, r13);
        addList(r10, r12);
        addVersion(r10, r11);
        return endMetadataList(r10);
    }

    public static int endMetadataList(FlatBufferBuilder r10) {
        return r10.endTable();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder r10, int r11) {
        r10.finish(r11);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder r10, int r11) {
        r10.finishSizePrefixed(r11);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer r10) {
        return getRootAsMetadataList(r10, new MetadataList());
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer r10, MetadataList r11) {
        r10.order(ByteOrder.LITTLE_ENDIAN);
        return r11.__assign(r10.getInt(r10.position()) + r10.position(), r10);
    }

    public static void startListVector(FlatBufferBuilder r10, int r11) {
        r10.startVector(4, r11, 4);
    }

    public static void startMetadataList(FlatBufferBuilder r10) {
        r10.startTable(3);
    }

    public MetadataList __assign(int r10, ByteBuffer r11) {
        __init(r10, r11);
        return this;
    }

    public void __init(int r10, ByteBuffer r11) {
        __reset(r10, r11);
    }

    public MetadataItem list(int r10) {
        return list(new MetadataItem(), r10);
    }

    public MetadataItem list(MetadataItem r10, int r11) {
        int r12 = __offset(6);
        if (r12 != 0) goto L7;
        return null;
    L7:
        return r10.__assign(__indirect(__vector(r12) + (r11 * 4)), this.f380bb);
    }

    public int listLength() {
        int r10 = __offset(6);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return __vector_len(r10);
    }

    public MetadataItem.Vector listVector() {
        return listVector(new MetadataItem.Vector());
    }

    public MetadataItem.Vector listVector(MetadataItem.Vector r10) {
        int r11 = __offset(6);
        if (r11 != 0) goto L7;
        return null;
    L7:
        return r10.__assign(__vector(r11), 4, this.f380bb);
    }

    public String sourceSha() {
        int r10 = __offset(8);
        if (r10 != 0) goto L7;
        return null;
    L7:
        return __string(r10 + this.bb_pos);
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer r10) {
        return __vector_in_bytebuffer(r10, 8, 1);
    }

    public int version() {
        int r10 = __offset(4);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f380bb.getInt(r10 + this.bb_pos);
    }
}
