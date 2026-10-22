package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class MetadataList extends Table {
    public int listLength() {
        int r0 = __offset(6);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return __vector_len(r0);
    }

    public int version() {
        int r0 = __offset(4);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.bb.getInt(r0 + this.bb_pos);
    }

    public MetadataItem.Vector listVector() {
        return listVector(new MetadataItem.Vector());
    }

    public String sourceSha() {
        int r0 = __offset(8);
        if (r0 != 0) goto L7;
        return null;
    L7:
        return __string(r0 + this.bb_pos);
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public MetadataList() {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static int endMetadataList(FlatBufferBuilder r0) {
        return r0.endTable();
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer r1) {
        return getRootAsMetadataList(r1, new MetadataList());
    }

    public static void startMetadataList(FlatBufferBuilder r1) {
        r1.startTable(3);
    }

    public MetadataItem list(int r2) {
        return list(new MetadataItem(), r2);
    }

    public MetadataItem.Vector listVector(MetadataItem.Vector r4) {
        int r0 = __offset(6);
        if (r0 != 0) goto L7;
        return null;
    L7:
        return r4.__assign(__vector(r0), 4, this.bb);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer r3) {
        return __vector_in_bytebuffer(r3, 8, 1);
    }

    public static /* synthetic */ int access$000(int r0, ByteBuffer r1) {
        return Table.__indirect(r0, r1);
    }

    public static void addList(FlatBufferBuilder r2, int r3) {
        r2.addOffset(1, r3, 0);
    }

    public static void addSourceSha(FlatBufferBuilder r2, int r3) {
        r2.addOffset(2, r3, 0);
    }

    public static void addVersion(FlatBufferBuilder r1, int r2) {
        r1.addInt(0, r2, 0);
    }

    public static int createListVector(FlatBufferBuilder r2, int[] r3) {
        r2.startVector(4, r3.length, 4);
        int r0 = r3.length - 1;
    L3:
        if (r0 < 0) goto L6;
        r2.addOffset(r3[r0]);
        r0 = r0 - 1;
        goto L3
    L6:
        return r2.endVector();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder r0, int r1) {
        r0.finish(r1);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder r0, int r1) {
        r0.finishSizePrefixed(r1);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer r2, MetadataList r3) {
        r2.order(ByteOrder.LITTLE_ENDIAN);
        return r3.__assign(r2.getInt(r2.position()) + r2.position(), r2);
    }

    public static void startListVector(FlatBufferBuilder r1, int r2) {
        r1.startVector(4, r2, 4);
    }

    public MetadataList __assign(int r1, ByteBuffer r2) {
        __init(r1, r2);
        return this;
    }

    public void __init(int r1, ByteBuffer r2) {
        __reset(r1, r2);
    }

    public MetadataItem list(MetadataItem r2, int r3) {
        int r0 = __offset(6);
        if (r0 != 0) goto L7;
        return null;
    L7:
        return r2.__assign(__indirect(__vector(r0) + (r3 * 4)), this.bb);
    }

    public static int createMetadataList(FlatBufferBuilder r1, int r2, int r3, int r4) {
        r1.startTable(3);
        addSourceSha(r1, r4);
        addList(r1, r3);
        addVersion(r1, r2);
        return endMetadataList(r1);
    }
}
