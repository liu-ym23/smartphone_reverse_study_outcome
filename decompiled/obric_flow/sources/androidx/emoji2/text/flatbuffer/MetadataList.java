package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataList extends Table {

    public static final class Vector extends BaseVector {
        public Vector() {
        }

        public Vector __assign(int r5, int r10, ByteBuffer r11) {
            __reset(r5, r10, r11);
            return this;
        }

        public MetadataList get(int r5) {
            return get(new MetadataList(), r5);
        }

        public MetadataList get(MetadataList r5, int r10) {
            return r5.__assign(MetadataList.access$000(__element(r10), this.f514bb), this.f514bb);
        }
    }

    public MetadataList() {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static /* synthetic */ int access$000(int r5, ByteBuffer r10) {
        return Table.__indirect(r5, r10);
    }

    public static void addList(FlatBufferBuilder r5, int r10) {
        r5.addOffset(1, r10, 0);
    }

    public static void addSourceSha(FlatBufferBuilder r5, int r10) {
        r5.addOffset(2, r10, 0);
    }

    public static void addVersion(FlatBufferBuilder r5, int r10) {
        r5.addInt(0, r10, 0);
    }

    public static int createListVector(FlatBufferBuilder r5, int[] r10) {
        r5.startVector(4, r10.length, 4);
        int r11 = r10.length - 1;
    L3:
        if (r11 < 0) goto L6;
        r5.addOffset(r10[r11]);
        r11 = r11 - 1;
        goto L3
    L6:
        return r5.endVector();
    }

    public static int createMetadataList(FlatBufferBuilder r5, int r10, int r11, int r12) {
        r5.startTable(3);
        addSourceSha(r5, r12);
        addList(r5, r11);
        addVersion(r5, r10);
        return endMetadataList(r5);
    }

    public static int endMetadataList(FlatBufferBuilder r5) {
        return r5.endTable();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder r5, int r10) {
        r5.finish(r10);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder r5, int r10) {
        r5.finishSizePrefixed(r10);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer r5) {
        return getRootAsMetadataList(r5, new MetadataList());
    }

    public static void startListVector(FlatBufferBuilder r5, int r10) {
        r5.startVector(4, r10, 4);
    }

    public static void startMetadataList(FlatBufferBuilder r5) {
        r5.startTable(3);
    }

    public MetadataList __assign(int r5, ByteBuffer r10) {
        __init(r5, r10);
        return this;
    }

    public void __init(int r5, ByteBuffer r10) {
        __reset(r5, r10);
    }

    public MetadataItem list(int r5) {
        return list(new MetadataItem(), r5);
    }

    public int listLength() {
        int r5 = __offset(6);
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return __vector_len(r5);
    }

    public MetadataItem.Vector listVector() {
        return listVector(new MetadataItem.Vector());
    }

    public String sourceSha() {
        int r5 = __offset(8);
        if (r5 != 0) goto L7;
        return null;
    L7:
        return __string(r5 + this.bb_pos);
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer r5) {
        return __vector_in_bytebuffer(r5, 8, 1);
    }

    public int version() {
        int r5 = __offset(4);
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return this.f520bb.getInt(r5 + this.bb_pos);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer r5, MetadataList r10) {
        r5.order(ByteOrder.LITTLE_ENDIAN);
        int r11 = r5.getInt(r5.position());
        return r10.__assign(r5.position() + r11, r5);
    }

    public MetadataItem list(MetadataItem r5, int r10) {
        int r11 = __offset(6);
        if (r11 == 0) goto L5;
        int r12 = r10 * 4;
        return r5.__assign(__indirect(r12 + __vector(r11)), this.f520bb);
    L5:
        return null;
    }

    public MetadataItem.Vector listVector(MetadataItem.Vector r5) {
        int r10 = __offset(6);
        if (r10 != 0) goto L7;
        return null;
    L7:
        return r5.__assign(__vector(r10), 4, this.f520bb);
    }
}
