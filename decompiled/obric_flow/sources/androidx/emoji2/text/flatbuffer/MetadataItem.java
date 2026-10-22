package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
        public Vector() {
        }

        public Vector __assign(int r5, int r10, ByteBuffer r11) {
            __reset(r5, r10, r11);
            return this;
        }

        public MetadataItem get(int r5) {
            return get(new MetadataItem(), r5);
        }

        public MetadataItem get(MetadataItem r5, int r10) {
            return r5.__assign(MetadataItem.access$000(__element(r10), this.f514bb), this.f514bb);
        }
    }

    public MetadataItem() {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static /* synthetic */ int access$000(int r5, ByteBuffer r10) {
        return Table.__indirect(r5, r10);
    }

    public static void addCodepoints(FlatBufferBuilder r5, int r10) {
        r5.addOffset(6, r10, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder r5, short r10) {
        r5.addShort(3, r10, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder r5, boolean r10) {
        r5.addBoolean(1, r10, false);
    }

    public static void addHeight(FlatBufferBuilder r5, short r10) {
        r5.addShort(5, r10, 0);
    }

    public static void addId(FlatBufferBuilder r5, int r10) {
        r5.addInt(0, r10, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder r5, short r10) {
        r5.addShort(2, r10, 0);
    }

    public static void addWidth(FlatBufferBuilder r5, short r10) {
        r5.addShort(4, r10, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder r5, int[] r10) {
        r5.startVector(4, r10.length, 4);
        int r11 = r10.length - 1;
    L3:
        if (r11 < 0) goto L6;
        r5.addInt(r10[r11]);
        r11 = r11 - 1;
        goto L3
    L6:
        return r5.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder r5, int r10, boolean r11, short r12, short r13, short r14, short r15, int r16) {
        r5.startTable(7);
        addCodepoints(r5, r16);
        addId(r5, r10);
        addHeight(r5, r15);
        addWidth(r5, r14);
        addCompatAdded(r5, r13);
        addSdkAdded(r5, r12);
        addEmojiStyle(r5, r11);
        return endMetadataItem(r5);
    }

    public static int endMetadataItem(FlatBufferBuilder r5) {
        return r5.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer r5) {
        return getRootAsMetadataItem(r5, new MetadataItem());
    }

    public static void startCodepointsVector(FlatBufferBuilder r5, int r10) {
        r5.startVector(4, r10, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder r5) {
        r5.startTable(7);
    }

    public MetadataItem __assign(int r5, ByteBuffer r10) {
        __init(r5, r10);
        return this;
    }

    public void __init(int r5, ByteBuffer r10) {
        __reset(r5, r10);
    }

    public int codepoints(int r5) {
        int r10 = __offset(16);
        if (r10 == 0) goto L5;
        int r11 = r5 * 4;
        return this.f520bb.getInt(r11 + __vector(r10));
    L5:
        return 0;
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return __vector_as_bytebuffer(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer r5) {
        return __vector_in_bytebuffer(r5, 16, 4);
    }

    public int codepointsLength() {
        int r5 = __offset(16);
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return __vector_len(r5);
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public short compatAdded() {
        int r5 = __offset(10);
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return this.f520bb.getShort(r5 + this.bb_pos);
    }

    public boolean emojiStyle() {
        int r5 = __offset(6);
        if (r5 != 0) goto L5;
        return false;
    L5:
        if (this.f520bb.get(r5 + this.bb_pos) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public short height() {
        int r5 = __offset(14);
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return this.f520bb.getShort(r5 + this.bb_pos);
    }

    public int id() {
        int r5 = __offset(4);
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return this.f520bb.getInt(r5 + this.bb_pos);
    }

    public short sdkAdded() {
        int r5 = __offset(8);
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return this.f520bb.getShort(r5 + this.bb_pos);
    }

    public short width() {
        int r5 = __offset(12);
        if (r5 != 0) goto L7;
        return 0;
    L7:
        return this.f520bb.getShort(r5 + this.bb_pos);
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer r5, MetadataItem r10) {
        r5.order(ByteOrder.LITTLE_ENDIAN);
        int r11 = r5.getInt(r5.position());
        return r10.__assign(r5.position() + r11, r5);
    }

    public IntVector codepointsVector(IntVector r5) {
        int r10 = __offset(16);
        if (r10 != 0) goto L7;
        return null;
    L7:
        return r5.__assign(__vector(r10), this.f520bb);
    }
}
