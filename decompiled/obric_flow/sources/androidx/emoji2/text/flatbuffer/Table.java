package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Table {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f520bb;
    protected int bb_pos;
    Utf8 utf8;
    private int vtable_size;
    private int vtable_start;

    public Table() {
        this.utf8 = Utf8.getDefault();
    }

    public static boolean __has_identifier(ByteBuffer r5, String r10) {
        if (r10.length() != 4) goto L13;
        int r11 = 0;
    L5:
        if (r11 >= 4) goto L10;
        if (r10.charAt(r11) != ((char) r5.get((r5.position() + 4) + r11))) goto L8;
        r11 = r11 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    L13:
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public static int compareStrings(int r10, int r11, ByteBuffer r12) {
        int r5 = r12.getInt(r10) + r10;
        int r13 = r12.getInt(r11) + r11;
        int r14 = r12.getInt(r5);
        int r15 = r12.getInt(r13);
        int r16 = r5 + 4;
        int r17 = r13 + 4;
        int r18 = Math.min(r14, r15);
        int r19 = 0;
    L3:
        if (r19 >= r18) goto L10;
        int r20 = r19 + r16;
        int r21 = r19 + r17;
        if (r12.get(r20) != r12.get(r21)) goto L7;
        r19 = r19 + 1;
        goto L3
    L7:
        return r12.get(r20) - r12.get(r21);
    L10:
        return r14 - r15;
    }

    public int __indirect(int r5) {
        return this.f520bb.getInt(r5) + r5;
    }

    public int __offset(int r5) {
        if (r5 < this.vtable_size) goto L7;
        return 0;
    L7:
        return this.f520bb.getShort(this.vtable_start + r5);
    }

    public void __reset(int r5, ByteBuffer r10) {
        this.f520bb = r10;
        if (r10 == null) goto L5;
        this.bb_pos = r5;
        int r11 = r5 - r10.getInt(r5);
        this.vtable_start = r11;
        this.vtable_size = this.f520bb.getShort(r11);
        return;
    L5:
        this.bb_pos = 0;
        this.vtable_start = 0;
        this.vtable_size = 0;
    }

    public String __string(int r5) {
        return __string(r5, this.f520bb, this.utf8);
    }

    public Table __union(Table r5, int r10) {
        return __union(r5, r10, this.f520bb);
    }

    public int __vector(int r5) {
        int r10 = r5 + this.bb_pos;
        return (this.f520bb.getInt(r10) + r10) + 4;
    }

    public ByteBuffer __vector_as_bytebuffer(int r5, int r10) {
        int r11 = __offset(r5);
        if (r11 != 0) goto L6;
        return null;
    L6:
        ByteBuffer r12 = this.f520bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int r13 = __vector(r11);
        r12.position(r13);
        r12.limit((__vector_len(r11) * r10) + r13);
        return r12;
    }

    public ByteBuffer __vector_in_bytebuffer(ByteBuffer r5, int r10, int r11) {
        int r12 = __offset(r10);
        if (r12 != 0) goto L6;
        return null;
    L6:
        int r13 = __vector(r12);
        r5.rewind();
        r5.limit((__vector_len(r12) * r11) + r13);
        r5.position(r13);
        return r5;
    }

    public int __vector_len(int r5) {
        int r10 = r5 + this.bb_pos;
        int r11 = this.f520bb.getInt(r10) + r10;
        return this.f520bb.getInt(r11);
    }

    public ByteBuffer getByteBuffer() {
        return this.f520bb;
    }

    public int keysCompare(Integer r5, Integer r10, ByteBuffer r11) {
        return 0;
    }

    public void sortTables(int[] r5, final ByteBuffer r10) {
        Integer[] r11 = new Integer[r5.length];
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r5.length) goto L6;
        r11[r13] = Integer.valueOf(r5[r13]);
        r13 = r13 + 1;
        goto L4
    L6:
        Arrays.sort(r11, new AnonymousClass1(this, r10));
    L8:
        if (r12 >= r5.length) goto L10;
        r5[r12] = r11[r12].intValue();
        r12 = r12 + 1;
        goto L8
    }

    public static int __indirect(int r5, ByteBuffer r10) {
        return r10.getInt(r5) + r5;
    }

    public static int __offset(int r5, int r10, ByteBuffer r11) {
        int r12 = r11.capacity() - r10;
        return r11.getShort((r5 + r12) - r11.getInt(r12)) + r12;
    }

    public static String __string(int r5, ByteBuffer r10, Utf8 r11) {
        int r12 = r10.getInt(r5) + r5;
        int r13 = r10.getInt(r12);
        return r11.decodeUtf8(r10, r12 + 4, r13);
    }

    public static Table __union(Table r5, int r10, ByteBuffer r11) {
        r5.__reset(__indirect(r10, r11), r11);
        return r5;
    }

    public static int compareStrings(int r10, byte[] r11, ByteBuffer r12) {
        int r5 = r12.getInt(r10) + r10;
        int r13 = r12.getInt(r5);
        int r14 = r11.length;
        int r15 = r5 + 4;
        int r16 = Math.min(r13, r14);
        int r17 = 0;
    L3:
        if (r17 >= r16) goto L10;
        int r18 = r17 + r15;
        if (r12.get(r18) != r11[r17]) goto L7;
        r17 = r17 + 1;
        goto L3
    L7:
        return r12.get(r18) - r11[r17];
    L10:
        return r13 - r14;
    }

    public void __reset() {
        __reset(0, null);
    }
}
