package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
        public Vector() {
        }

        public Vector __assign(int r10, int r11, ByteBuffer r12) {
            __reset(r10, r11, r12);
            return this;
        }

        public MetadataItem get(int r10) {
            return get(new MetadataItem(), r10);
        }

        public MetadataItem get(MetadataItem r10, int r11) {
            return r10.__assign(MetadataItem.access$000(__element(r11), this.f374bb), this.f374bb);
        }
    }

    public MetadataItem() {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    static /* synthetic */ int access$000(int r10, ByteBuffer r11) {
        return Table.__indirect(r10, r11);
    }

    public static void addCodepoints(FlatBufferBuilder r10, int r11) {
        r10.addOffset(6, r11, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder r10, short r11) {
        r10.addShort(3, r11, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder r10, boolean r11) {
        r10.addBoolean(1, r11, false);
    }

    public static void addHeight(FlatBufferBuilder r10, short r11) {
        r10.addShort(5, r11, 0);
    }

    public static void addId(FlatBufferBuilder r10, int r11) {
        r10.addInt(0, r11, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder r10, short r11) {
        r10.addShort(2, r11, 0);
    }

    public static void addWidth(FlatBufferBuilder r10, short r11) {
        r10.addShort(4, r11, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder r10, int[] r11) {
        r10.startVector(4, r11.length, 4);
        int r12 = r11.length - 1;
    L3:
        if (r12 < 0) goto L6;
        r10.addInt(r11[r12]);
        r12 = r12 - 1;
        goto L3
    L6:
        return r10.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder r10, int r11, boolean r12, short r13, short r14, short r15, short r16, int r17) {
        r10.startTable(7);
        addCodepoints(r10, r17);
        addId(r10, r11);
        addHeight(r10, r16);
        addWidth(r10, r15);
        addCompatAdded(r10, r14);
        addSdkAdded(r10, r13);
        addEmojiStyle(r10, r12);
        return endMetadataItem(r10);
    }

    public static int endMetadataItem(FlatBufferBuilder r10) {
        return r10.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer r10) {
        return getRootAsMetadataItem(r10, new MetadataItem());
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer r10, MetadataItem r11) {
        r10.order(ByteOrder.LITTLE_ENDIAN);
        return r11.__assign(r10.getInt(r10.position()) + r10.position(), r10);
    }

    public static void startCodepointsVector(FlatBufferBuilder r10, int r11) {
        r10.startVector(4, r11, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder r10) {
        r10.startTable(7);
    }

    public MetadataItem __assign(int r10, ByteBuffer r11) {
        __init(r10, r11);
        return this;
    }

    public void __init(int r10, ByteBuffer r11) {
        __reset(r10, r11);
    }

    public int codepoints(int r10) {
        int r11 = __offset(16);
        if (r11 != 0) goto L7;
        return 0;
    L7:
        return this.f380bb.getInt(__vector(r11) + (r10 * 4));
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return __vector_as_bytebuffer(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer r10) {
        return __vector_in_bytebuffer(r10, 16, 4);
    }

    public int codepointsLength() {
        int r10 = __offset(16);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return __vector_len(r10);
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public IntVector codepointsVector(IntVector r10) {
        int r11 = __offset(16);
        if (r11 != 0) goto L7;
        return null;
    L7:
        return r10.__assign(__vector(r11), this.f380bb);
    }

    public short compatAdded() {
        int r10 = __offset(10);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f380bb.getShort(r10 + this.bb_pos);
    }

    public boolean emojiStyle() {
        int r10 = __offset(6);
        if (r10 != 0) goto L5;
        return false;
    L5:
        if (this.f380bb.get(r10 + this.bb_pos) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public short height() {
        int r10 = __offset(14);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f380bb.getShort(r10 + this.bb_pos);
    }

    public int id() {
        int r10 = __offset(4);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f380bb.getInt(r10 + this.bb_pos);
    }

    public short sdkAdded() {
        int r10 = __offset(8);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f380bb.getShort(r10 + this.bb_pos);
    }

    public short width() {
        int r10 = __offset(12);
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.f380bb.getShort(r10 + this.bb_pos);
    }
}
