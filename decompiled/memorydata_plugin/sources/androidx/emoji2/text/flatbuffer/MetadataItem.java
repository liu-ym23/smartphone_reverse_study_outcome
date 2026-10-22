package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
        public Vector() {
        }

        public Vector __assign(int r1, int r2, ByteBuffer r3) {
            __reset(r1, r2, r3);
            return this;
        }

        public MetadataItem get(int r2) {
            return get(new MetadataItem(), r2);
        }

        public MetadataItem get(MetadataItem r2, int r3) {
            return r2.__assign(MetadataItem.access$000(__element(r3), this.bb), this.bb);
        }
    }

    public MetadataItem() {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    static /* synthetic */ int access$000(int r0, ByteBuffer r1) {
        return __indirect(r0, r1);
    }

    public static void addCodepoints(FlatBufferBuilder r2, int r3) {
        r2.addOffset(6, r3, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder r2, short r3) {
        r2.addShort(3, r3, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder r2, boolean r3) {
        r2.addBoolean(1, r3, false);
    }

    public static void addHeight(FlatBufferBuilder r2, short r3) {
        r2.addShort(5, r3, 0);
    }

    public static void addId(FlatBufferBuilder r1, int r2) {
        r1.addInt(0, r2, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder r2, short r3) {
        r2.addShort(2, r3, 0);
    }

    public static void addWidth(FlatBufferBuilder r2, short r3) {
        r2.addShort(4, r3, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder r2, int[] r3) {
        r2.startVector(4, r3.length, 4);
        int r0 = r3.length - 1;
    L3:
        if (r0 < 0) goto L6;
        r2.addInt(r3[r0]);
        r0 = r0 - 1;
        goto L3
    L6:
        return r2.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder r1, int r2, boolean r3, short r4, short r5, short r6, short r7, int r8) {
        r1.startTable(7);
        addCodepoints(r1, r8);
        addId(r1, r2);
        addHeight(r1, r7);
        addWidth(r1, r6);
        addCompatAdded(r1, r5);
        addSdkAdded(r1, r4);
        addEmojiStyle(r1, r3);
        return endMetadataItem(r1);
    }

    public static int endMetadataItem(FlatBufferBuilder r0) {
        return r0.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer r1) {
        return getRootAsMetadataItem(r1, new MetadataItem());
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer r2, MetadataItem r3) {
        r2.order(ByteOrder.LITTLE_ENDIAN);
        return r3.__assign(r2.getInt(r2.position()) + r2.position(), r2);
    }

    public static void startCodepointsVector(FlatBufferBuilder r1, int r2) {
        r1.startVector(4, r2, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder r1) {
        r1.startTable(7);
    }

    public MetadataItem __assign(int r1, ByteBuffer r2) {
        __init(r1, r2);
        return this;
    }

    public void __init(int r1, ByteBuffer r2) {
        __reset(r1, r2);
    }

    public int codepoints(int r3) {
        int r0 = __offset(16);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.bb.getInt(__vector(r0) + (r3 * 4));
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return __vector_as_bytebuffer(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer r3) {
        return __vector_in_bytebuffer(r3, 16, 4);
    }

    public int codepointsLength() {
        int r0 = __offset(16);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return __vector_len(r0);
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public IntVector codepointsVector(IntVector r2) {
        int r0 = __offset(16);
        if (r0 != 0) goto L7;
        return null;
    L7:
        return r2.__assign(__vector(r0), this.bb);
    }

    public short compatAdded() {
        int r0 = __offset(10);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.bb.getShort(r0 + this.bb_pos);
    }

    public boolean emojiStyle() {
        int r0 = __offset(6);
        if (r0 != 0) goto L5;
        return false;
    L5:
        if (this.bb.get(r0 + this.bb_pos) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public short height() {
        int r0 = __offset(14);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.bb.getShort(r0 + this.bb_pos);
    }

    public int id() {
        int r0 = __offset(4);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.bb.getInt(r0 + this.bb_pos);
    }

    public short sdkAdded() {
        int r0 = __offset(8);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.bb.getShort(r0 + this.bb_pos);
    }

    public short width() {
        int r0 = __offset(12);
        if (r0 != 0) goto L7;
        return 0;
    L7:
        return this.bb.getShort(r0 + this.bb_pos);
    }
}
