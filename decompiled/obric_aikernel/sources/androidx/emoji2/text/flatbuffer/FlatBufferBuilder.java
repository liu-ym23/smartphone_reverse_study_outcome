package androidx.emoji2.text.flatbuffer;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    ByteBuffer f375bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer r10) {
            this.buf = r10;
        }

        @Override // java.io.InputStream
        public int read() {
            return this.buf.get() & 255;
        L5:
            return -1;
        }
    }

    public static abstract class ByteBufferFactory {
        public ByteBufferFactory() {
        }

        public abstract ByteBuffer newByteBuffer(int r10);

        public void releaseByteBuffer(ByteBuffer r10) {
        }
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = null;

        static {
            INSTANCE = new HeapByteBufferFactory();
        }

        public HeapByteBufferFactory() {
        }

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int r10) {
            return ByteBuffer.allocate(r10).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    static {
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(int r10) {
        this(r10, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int r10, ByteBufferFactory r11) {
        this(r10, r11, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int r10, ByteBufferFactory r11, ByteBuffer r12, Utf8 r13) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        if (r10 > 0) goto L5;
        r10 = 1;
    L5:
        this.bb_factory = r11;
        if (r12 == null) goto L8;
        this.f375bb = r12;
        r12.clear();
        this.f375bb.order(ByteOrder.LITTLE_ENDIAN);
    L9:
        this.utf8 = r13;
        this.space = this.f375bb.capacity();
        return;
    L8:
        this.f375bb = r11.newByteBuffer(r10);
        goto L9
    }

    public FlatBufferBuilder(ByteBuffer r10) {
        this(r10, new HeapByteBufferFactory());
    }

    public FlatBufferBuilder(ByteBuffer r10, ByteBufferFactory r11) {
        this(r10.capacity(), r11, r10, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    static ByteBuffer growByteBuffer(ByteBuffer r10, ByteBufferFactory r11) {
        int r12 = r10.capacity();
        if (((-1073741824) & r12) != 0) goto L10;
        if (r12 != 0) goto L6;
        int r13 = 1;
    L7:
        r10.position(0);
        ByteBuffer r14 = r11.newByteBuffer(r13);
        r14.position(r14.clear().capacity() - r12);
        r14.put(r10);
        return r14;
    L6:
        r13 = r12 << 1;
        goto L7
    L10:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean isFieldPresent(Table r10, int r11) {
        if (r10.__offset(r11) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void Nested(int r10) {
        if (r10 != offset()) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: struct must be serialized inline.");
    }

    public void addBoolean(int r10, boolean r11, boolean r12) {
        if (this.force_defaults == true) goto L5;
        if (r11 != r12) goto L5;
        return;
    L5:
        addBoolean(r11);
        slot(r10);
    }

    public void addBoolean(boolean r10) {
        prep(1, 0);
        putBoolean(r10);
    }

    public void addByte(byte r10) {
        prep(1, 0);
        putByte(r10);
    }

    public void addByte(int r10, byte r11, int r12) {
        if (this.force_defaults == true) goto L5;
        if (r11 != r12) goto L5;
        return;
    L5:
        addByte(r11);
        slot(r10);
    }

    public void addDouble(double r10) {
        prep(8, 0);
        putDouble(r10);
    }

    public void addDouble(int r10, double r11, double r12) {
        if (this.force_defaults == false) goto L5;
    L6:
        addDouble(r11);
        slot(r10);
        return;
    L5:
        if (r11 != r12) goto L6;
    }

    public void addFloat(float r10) {
        prep(4, 0);
        putFloat(r10);
    }

    public void addFloat(int r10, float r11, double r12) {
        if (this.force_defaults == false) goto L5;
    L6:
        addFloat(r11);
        slot(r10);
        return;
    L5:
        if (r11 != r12) goto L6;
    }

    public void addInt(int r10) {
        prep(4, 0);
        putInt(r10);
    }

    public void addInt(int r10, int r11, int r12) {
        if (this.force_defaults == true) goto L5;
        if (r11 != r12) goto L5;
        return;
    L5:
        addInt(r11);
        slot(r10);
    }

    public void addLong(int r10, long r11, long r12) {
        if (this.force_defaults == false) goto L5;
    L6:
        addLong(r11);
        slot(r10);
        return;
    L5:
        if (r11 != r12) goto L6;
    }

    public void addLong(long r10) {
        prep(8, 0);
        putLong(r10);
    }

    public void addOffset(int r10) {
        prep(4, 0);
        putInt((offset() - r10) + 4);
    }

    public void addOffset(int r10, int r11, int r12) {
        if (this.force_defaults == true) goto L5;
        if (r11 != r12) goto L5;
        return;
    L5:
        addOffset(r11);
        slot(r10);
    }

    public void addShort(int r10, short r11, int r12) {
        if (this.force_defaults == true) goto L5;
        if (r11 != r12) goto L5;
        return;
    L5:
        addShort(r11);
        slot(r10);
    }

    public void addShort(short r10) {
        prep(2, 0);
        putShort(r10);
    }

    public void addStruct(int r10, int r11, int r12) {
        if (r11 == r12) goto L5;
        Nested(r11);
        slot(r10);
        return;
    }

    public void clear() {
        this.space = this.f375bb.capacity();
        this.f375bb.clear();
        this.minalign = 1;
    L3:
        int r10 = this.vtable_in_use;
        if (r10 <= 0) goto L6;
        int[] r11 = this.vtable;
        int r12 = r10 - 1;
        this.vtable_in_use = r12;
        r11[r12] = 0;
        goto L3
    L6:
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
    }

    public int createByteVector(ByteBuffer r10) {
        int r11 = r10.remaining();
        startVector(1, r11, 1);
        ByteBuffer r12 = this.f375bb;
        int r13 = this.space - r11;
        this.space = r13;
        r12.position(r13);
        this.f375bb.put(r10);
        return endVector();
    }

    public int createByteVector(byte[] r10) {
        int r11 = r10.length;
        startVector(1, r11, 1);
        ByteBuffer r12 = this.f375bb;
        int r13 = this.space - r11;
        this.space = r13;
        r12.position(r13);
        this.f375bb.put(r10);
        return endVector();
    }

    public int createByteVector(byte[] r10, int r11, int r12) {
        startVector(1, r12, 1);
        ByteBuffer r13 = this.f375bb;
        int r14 = this.space - r12;
        this.space = r14;
        r13.position(r14);
        this.f375bb.put(r10, r11, r12);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T r10, int[] r11) {
        r10.sortTables(r11, this.f375bb);
        return createVectorOfTables(r11);
    }

    public int createString(CharSequence r10) {
        int r11 = this.utf8.encodedLength(r10);
        addByte((byte) 0);
        startVector(1, r11, 1);
        ByteBuffer r12 = this.f375bb;
        int r13 = this.space - r11;
        this.space = r13;
        r12.position(r13);
        this.utf8.encodeUtf8(r10, this.f375bb);
        return endVector();
    }

    public int createString(ByteBuffer r10) {
        int r11 = r10.remaining();
        addByte((byte) 0);
        startVector(1, r11, 1);
        ByteBuffer r12 = this.f375bb;
        int r13 = this.space - r11;
        this.space = r13;
        r12.position(r13);
        this.f375bb.put(r10);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int r10, int r11, int r12) {
        int r13 = r10 * r11;
        startVector(r10, r11, r12);
        ByteBuffer r14 = this.f375bb;
        int r15 = this.space - r13;
        this.space = r15;
        r14.position(r15);
        ByteBuffer r16 = this.f375bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        r16.limit(r13);
        return r16;
    }

    public int createVectorOfTables(int[] r10) {
        notNested();
        startVector(4, r10.length, 4);
        int r11 = r10.length - 1;
    L3:
        if (r11 < 0) goto L6;
        addOffset(r10[r11]);
        r11 = r11 - 1;
        goto L3
    L6:
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f375bb;
    }

    public int endTable() {
        if (this.vtable == null) goto L41;
        if (this.nested == false) goto L41;
        addInt(0);
        int r10 = offset();
        int r11 = this.vtable_in_use - 1;
    L7:
        if (r11 < 0) goto L11;
        if (this.vtable[r11] != 0) goto L11;
        r11 = r11 - 1;
    L11:
        int r12 = r11 + 1;
    L12:
        if (r11 < 0) goto L18;
        int[] r13 = this.vtable;
        if (r13[r11] == 0) goto L16;
        int r14 = r10 - r13[r11];
    L17:
        addShort((short) r14);
        r11 = r11 - 1;
        goto L12
    L16:
        r14 = 0;
        goto L17
    L18:
        addShort((short) (r10 - this.object_start));
        addShort((short) ((r12 + 2) * 2));
        int r15 = 0;
    L20:
        if (r15 >= this.num_vtables) goto L31;
        int r16 = this.f375bb.capacity() - this.vtables[r15];
        int r17 = this.space;
        short r18 = this.f375bb.getShort(r16);
        if (r18 != this.f375bb.getShort(r17)) goto L30;
        int r19 = 2;
    L24:
        if (r19 >= r18) goto L29;
        if (this.f375bb.getShort(r16 + r19) != this.f375bb.getShort(r17 + r19)) goto L30;
        r19 = r19 + 2;
        goto L24
    L29:
        int r20 = this.vtables[r15];
    L32:
        if (r20 == 0) goto L34;
        int r21 = this.f375bb.capacity() - r10;
        this.space = r21;
        this.f375bb.putInt(r21, r20 - r10);
    L38:
        this.nested = false;
        return r10;
    L34:
        int r22 = this.num_vtables;
        int[] r23 = this.vtables;
        if (r22 != r23.length) goto L37;
        this.vtables = Arrays.copyOf(r23, r22 * 2);
    L37:
        int[] r24 = this.vtables;
        int r25 = this.num_vtables;
        this.num_vtables = r25 + 1;
        r24[r25] = offset();
        ByteBuffer r26 = this.f375bb;
        r26.putInt(r26.capacity() - r10, offset() - r10);
    L30:
        r15 = r15 + 1;
        goto L20
    L31:
        r20 = 0;
    L41:
        throw new AssertionError("FlatBuffers: endTable called without startTable");
    }

    public int endVector() {
        if (this.nested == false) goto L7;
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    L7:
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void finish(int r10) {
        finish(r10, false);
    }

    public void finish(int r10, String r11) {
        finish(r10, r11, false);
    }

    protected void finish(int r10, String r11, boolean r12) {
        int r13 = this.minalign;
        if (r12 == false) goto L5;
        int r14 = 4;
    L6:
        prep(r13, r14 + 8);
        if (r11.length() != 4) goto L14;
        int r15 = 3;
    L9:
        if (r15 < 0) goto L11;
        addByte((byte) r11.charAt(r15));
        r15 = r15 - 1;
        goto L9
    L11:
        finish(r10, r12);
        return;
    L14:
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    L5:
        r14 = 0;
        goto L6
    }

    protected void finish(int r10, boolean r11) {
        int r12 = this.minalign;
        if (r11 == false) goto L5;
        int r13 = 4;
    L6:
        prep(r12, r13 + 4);
        addOffset(r10);
        if (r11 == false) goto L9;
        addInt(this.f375bb.capacity() - this.space);
    L9:
        this.f375bb.position(this.space);
        this.finished = true;
        return;
    L5:
        r13 = 0;
        goto L6
    }

    public void finishSizePrefixed(int r10) {
        finish(r10, true);
    }

    public void finishSizePrefixed(int r10, String r11) {
        finish(r10, r11, true);
    }

    public void finished() {
        if (this.finished == false) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public FlatBufferBuilder forceDefaults(boolean r10) {
        this.force_defaults = r10;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer r10, ByteBufferFactory r11) {
        this.bb_factory = r11;
        this.f375bb = r10;
        r10.clear();
        this.f375bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.f375bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested == true) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public int offset() {
        return this.f375bb.capacity() - this.space;
    }

    public void pad(int r10) {
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ByteBuffer r12 = this.f375bb;
        int r13 = this.space - 1;
        this.space = r13;
        r12.put(r13, (byte) 0);
        r11 = r11 + 1;
        goto L3
    }

    public void prep(int r10, int r11) {
        if (r10 <= this.minalign) goto L5;
        this.minalign = r10;
    L5:
        int r12 = ((~((this.f375bb.capacity() - this.space) + r11)) + 1) & (r10 - 1);
    L7:
        if (this.space >= ((r12 + r10) + r11)) goto L12;
        int r13 = this.f375bb.capacity();
        ByteBuffer r14 = this.f375bb;
        ByteBuffer r15 = growByteBuffer(r14, this.bb_factory);
        this.f375bb = r15;
        if (r14 == r15) goto L11;
        this.bb_factory.releaseByteBuffer(r14);
    L11:
        this.space += this.f375bb.capacity() - r13;
        goto L7
    L12:
        pad(r12);
    }

    public void putBoolean(boolean r10) {
        ByteBuffer r11 = this.f375bb;
        int r12 = this.space - 1;
        this.space = r12;
        r11.put(r12, r10 ? 1 : 0);
    }

    public void putByte(byte r10) {
        ByteBuffer r11 = this.f375bb;
        int r12 = this.space - 1;
        this.space = r12;
        r11.put(r12, r10);
    }

    public void putDouble(double r10) {
        ByteBuffer r11 = this.f375bb;
        int r12 = this.space - 8;
        this.space = r12;
        r11.putDouble(r12, r10);
    }

    public void putFloat(float r10) {
        ByteBuffer r11 = this.f375bb;
        int r12 = this.space - 4;
        this.space = r12;
        r11.putFloat(r12, r10);
    }

    public void putInt(int r10) {
        ByteBuffer r11 = this.f375bb;
        int r12 = this.space - 4;
        this.space = r12;
        r11.putInt(r12, r10);
    }

    public void putLong(long r10) {
        ByteBuffer r11 = this.f375bb;
        int r12 = this.space - 8;
        this.space = r12;
        r11.putLong(r12, r10);
    }

    public void putShort(short r10) {
        ByteBuffer r11 = this.f375bb;
        int r12 = this.space - 2;
        this.space = r12;
        r11.putShort(r12, r10);
    }

    public void required(int r10, int r11) {
        int r12 = this.f375bb.capacity() - r10;
        if (this.f375bb.getShort((r12 - this.f375bb.getInt(r12)) + r11) == 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L9;
        return;
    L9:
        throw new AssertionError("FlatBuffers: field " + r11 + " must be set");
    L5:
        r13 = false;
        goto L6
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.f375bb.capacity() - this.space);
    }

    public byte[] sizedByteArray(int r10, int r11) {
        finished();
        byte[] r12 = new byte[r11];
        this.f375bb.position(r10);
        this.f375bb.get(r12);
        return r12;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer r10 = this.f375bb.duplicate();
        r10.position(this.space);
        r10.limit(this.f375bb.capacity());
        return new ByteBufferBackedInputStream(r10);
    }

    public void slot(int r10) {
        this.vtable[r10] = offset();
    }

    public void startTable(int r10) {
        notNested();
        int[] r11 = this.vtable;
        if (r11 != null) goto L5;
    L6:
        this.vtable = new int[r10];
    L7:
        this.vtable_in_use = r10;
        Arrays.fill(this.vtable, 0, r10, 0);
        this.nested = true;
        this.object_start = offset();
        return;
    L5:
        if (r11.length >= r10) goto L7;
        goto L6
    }

    public void startVector(int r10, int r11, int r12) {
        notNested();
        this.vector_num_elems = r11;
        int r13 = r10 * r11;
        prep(4, r13);
        prep(r12, r13);
        this.nested = true;
    }
}
