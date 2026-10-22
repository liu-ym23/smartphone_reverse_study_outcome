package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Table {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f380bb;
    protected int bb_pos;
    Utf8 utf8;
    private int vtable_size;
    private int vtable_start;

    public Table() {
        this.utf8 = Utf8.getDefault();
    }

    protected static boolean __has_identifier(ByteBuffer r10, String r11) {
        if (r11.length() != 4) goto L13;
        int r12 = 0;
    L5:
        if (r12 >= 4) goto L10;
        if (r11.charAt(r12) != ((char) r10.get((r10.position() + 4) + r12))) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    L13:
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    protected static int __indirect(int r10, ByteBuffer r11) {
        return r10 + r11.getInt(r10);
    }

    protected static int __offset(int r10, int r11, ByteBuffer r12) {
        int r13 = r12.capacity() - r11;
        return r12.getShort((r10 + r13) - r12.getInt(r13)) + r13;
    }

    protected static String __string(int r10, ByteBuffer r11, Utf8 r12) {
        int r13 = r10 + r11.getInt(r10);
        int r14 = r11.getInt(r13);
        return r12.decodeUtf8(r11, r13 + 4, r14);
    }

    protected static Table __union(Table r10, int r11, ByteBuffer r12) {
        r10.__reset(__indirect(r11, r12), r12);
        return r10;
    }

    protected static int compareStrings(int r10, int r11, ByteBuffer r12) {
        int r13 = r10 + r12.getInt(r10);
        int r14 = r11 + r12.getInt(r11);
        int r15 = r12.getInt(r13);
        int r16 = r12.getInt(r14);
        int r17 = r13 + 4;
        int r18 = r14 + 4;
        int r19 = Math.min(r15, r16);
        int r20 = 0;
    L3:
        if (r20 >= r19) goto L10;
        int r21 = r20 + r17;
        int r22 = r20 + r18;
        if (r12.get(r21) != r12.get(r22)) goto L7;
        r20 = r20 + 1;
        goto L3
    L7:
        return r12.get(r21) - r12.get(r22);
    L10:
        return r15 - r16;
    }

    protected static int compareStrings(int r10, byte[] r11, ByteBuffer r12) {
        int r13 = r10 + r12.getInt(r10);
        int r14 = r12.getInt(r13);
        int r15 = r11.length;
        int r16 = r13 + 4;
        int r17 = Math.min(r14, r15);
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L10;
        int r19 = r18 + r16;
        if (r12.get(r19) != r11[r18]) goto L7;
        r18 = r18 + 1;
        goto L3
    L7:
        return r12.get(r19) - r11[r18];
    L10:
        return r14 - r15;
    }

    protected int __indirect(int r10) {
        return r10 + this.f380bb.getInt(r10);
    }

    protected int __offset(int r10) {
        if (r10 < this.vtable_size) goto L7;
        return 0;
    L7:
        return this.f380bb.getShort(this.vtable_start + r10);
    }

    public void __reset() {
        __reset(0, null);
    }

    protected void __reset(int r10, ByteBuffer r11) {
        this.f380bb = r11;
        if (r11 == null) goto L5;
        this.bb_pos = r10;
        int r12 = r10 - r11.getInt(r10);
        this.vtable_start = r12;
        short r13 = this.f380bb.getShort(r12);
    L6:
        this.vtable_size = r13;
        return;
    L5:
        r13 = 0;
        this.bb_pos = 0;
        this.vtable_start = 0;
        goto L6
    }

    protected String __string(int r10) {
        return __string(r10, this.f380bb, this.utf8);
    }

    protected Table __union(Table r10, int r11) {
        return __union(r10, r11, this.f380bb);
    }

    protected int __vector(int r10) {
        int r11 = r10 + this.bb_pos;
        return (r11 + this.f380bb.getInt(r11)) + 4;
    }

    protected ByteBuffer __vector_as_bytebuffer(int r10, int r11) {
        int r12 = __offset(r10);
        if (r12 != 0) goto L6;
        return null;
    L6:
        ByteBuffer r13 = this.f380bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int r14 = __vector(r12);
        r13.position(r14);
        r13.limit(r14 + (__vector_len(r12) * r11));
        return r13;
    }

    protected ByteBuffer __vector_in_bytebuffer(ByteBuffer r10, int r11, int r12) {
        int r13 = __offset(r11);
        if (r13 != 0) goto L6;
        return null;
    L6:
        int r14 = __vector(r13);
        r10.rewind();
        r10.limit((__vector_len(r13) * r12) + r14);
        r10.position(r14);
        return r10;
    }

    protected int __vector_len(int r10) {
        int r11 = r10 + this.bb_pos;
        int r12 = r11 + this.f380bb.getInt(r11);
        return this.f380bb.getInt(r12);
    }

    public ByteBuffer getByteBuffer() {
        return this.f380bb;
    }

    protected int keysCompare(Integer r10, Integer r11, ByteBuffer r12) {
        return 0;
    }

    protected void sortTables(int[] r10, final ByteBuffer r11) {
        Integer[] r12 = new Integer[r10.length];
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= r10.length) goto L6;
        r12[r14] = Integer.valueOf(r10[r14]);
        r14 = r14 + 1;
        goto L4
    L6:
        Arrays.sort(r12, new AnonymousClass1(this, r11));
    L8:
        if (r13 >= r10.length) goto L10;
        r10[r13] = r12[r13].intValue();
        r13 = r13 + 1;
        goto L8
    }
}
