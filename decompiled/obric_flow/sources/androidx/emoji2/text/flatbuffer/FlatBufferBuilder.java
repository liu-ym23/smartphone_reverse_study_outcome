package androidx.emoji2.text.flatbuffer;

import ai.j0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    ByteBuffer f515bb;
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

    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer r5) {
            this.buf = r5;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.buf.get() & UByte.MAX_VALUE;
        L5:
            return -1;
        }
    }

    public static abstract class ByteBufferFactory {
        public ByteBufferFactory() {
        }

        public abstract ByteBuffer newByteBuffer(int r5);

        public void releaseByteBuffer(ByteBuffer r5) {
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
        public ByteBuffer newByteBuffer(int r5) {
            return ByteBuffer.allocate(r5).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int r5, ByteBufferFactory r10) {
        this(r5, r10, null, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public static ByteBuffer growByteBuffer(ByteBuffer r5, ByteBufferFactory r10) {
        int r11 = r5.capacity();
        if (((-1073741824) & r11) != 0) goto L10;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        r5.position(0);
        ByteBuffer r13 = r10.newByteBuffer(r12);
        r13.position(r13.clear().capacity() - r11);
        r13.put(r5);
        return r13;
    L6:
        r12 = r11 << 1;
        goto L7
    L10:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean isFieldPresent(Table r5, int r10) {
        if (r5.__offset(r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void Nested(int r5) {
        if (r5 != offset()) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: struct must be serialized inline.");
    }

    public void addBoolean(boolean r5) {
        prep(1, 0);
        putBoolean(r5);
    }

    public void addByte(byte r5) {
        prep(1, 0);
        putByte(r5);
    }

    public void addDouble(double r5) {
        prep(8, 0);
        putDouble(r5);
    }

    public void addFloat(float r5) {
        prep(4, 0);
        putFloat(r5);
    }

    public void addInt(int r5) {
        prep(4, 0);
        putInt(r5);
    }

    public void addLong(long r5) {
        prep(8, 0);
        putLong(r5);
    }

    public void addOffset(int r5) {
        prep(4, 0);
        putInt((offset() - r5) + 4);
    }

    public void addShort(short r5) {
        prep(2, 0);
        putShort(r5);
    }

    public void addStruct(int r5, int r10, int r11) {
        if (r10 == r11) goto L5;
        Nested(r10);
        slot(r5);
        return;
    }

    public void clear() {
        this.space = this.f515bb.capacity();
        this.f515bb.clear();
        this.minalign = 1;
    L3:
        int r5 = this.vtable_in_use;
        if (r5 <= 0) goto L6;
        int[] r10 = this.vtable;
        int r11 = r5 - 1;
        this.vtable_in_use = r11;
        r10[r11] = 0;
        goto L3
    L6:
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
    }

    public int createByteVector(byte[] r5) {
        int r10 = r5.length;
        startVector(1, r10, 1);
        ByteBuffer r11 = this.f515bb;
        int r12 = this.space - r10;
        this.space = r12;
        r11.position(r12);
        this.f515bb.put(r5);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T r5, int[] r10) {
        r5.sortTables(r10, this.f515bb);
        return createVectorOfTables(r10);
    }

    public int createString(CharSequence r5) {
        int r10 = this.utf8.encodedLength(r5);
        addByte((byte) 0);
        startVector(1, r10, 1);
        ByteBuffer r11 = this.f515bb;
        int r12 = this.space - r10;
        this.space = r12;
        r11.position(r12);
        this.utf8.encodeUtf8(r5, this.f515bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int r5, int r10, int r11) {
        int r12 = r5 * r10;
        startVector(r5, r10, r11);
        ByteBuffer r13 = this.f515bb;
        int r14 = this.space - r12;
        this.space = r14;
        r13.position(r14);
        ByteBuffer r15 = this.f515bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        r15.limit(r12);
        return r15;
    }

    public int createVectorOfTables(int[] r5) {
        notNested();
        startVector(4, r5.length, 4);
        int r10 = r5.length - 1;
    L3:
        if (r10 < 0) goto L6;
        addOffset(r5[r10]);
        r10 = r10 - 1;
        goto L3
    L6:
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.f515bb;
    }

    public int endTable() {
        if (this.vtable == null) goto L41;
        if (this.nested == false) goto L41;
        addInt(0);
        int r5 = offset();
        int r10 = this.vtable_in_use - 1;
    L7:
        if (r10 < 0) goto L11;
        if (this.vtable[r10] != 0) goto L11;
        r10 = r10 - 1;
    L11:
        int r11 = r10;
    L12:
        if (r11 < 0) goto L18;
        int r12 = this.vtable[r11];
        if (r12 == 0) goto L16;
        int r13 = r5 - r12;
    L17:
        addShort((short) r13);
        r11 = r11 - 1;
        goto L12
    L16:
        r13 = 0;
        goto L17
    L18:
        addShort((short) (r5 - this.object_start));
        addShort((short) ((r10 + 3) * 2));
        int r14 = 0;
    L20:
        if (r14 >= this.num_vtables) goto L31;
        int r15 = this.f515bb.capacity() - this.vtables[r14];
        int r16 = this.space;
        short r17 = this.f515bb.getShort(r15);
        if (r17 != this.f515bb.getShort(r16)) goto L30;
        int r18 = 2;
    L24:
        if (r18 >= r17) goto L29;
        if (this.f515bb.getShort(r15 + r18) != this.f515bb.getShort(r16 + r18)) goto L30;
        r18 = r18 + 2;
        goto L24
    L29:
        int r19 = this.vtables[r14];
    L32:
        if (r19 == 0) goto L34;
        int r20 = this.f515bb.capacity() - r5;
        this.space = r20;
        this.f515bb.putInt(r20, r19 - r5);
    L38:
        this.nested = false;
        return r5;
    L34:
        int r21 = this.num_vtables;
        int[] r22 = this.vtables;
        if (r21 != r22.length) goto L37;
        this.vtables = Arrays.copyOf(r22, r21 * 2);
    L37:
        int[] r23 = this.vtables;
        int r24 = this.num_vtables;
        this.num_vtables = r24 + 1;
        r23[r24] = offset();
        ByteBuffer r25 = this.f515bb;
        r25.putInt(r25.capacity() - r5, offset() - r5);
    L30:
        r14 = r14 + 1;
        goto L20
    L31:
        r19 = 0;
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

    public void finish(int r5, boolean r10) {
        int r11 = this.minalign;
        if (r10 == false) goto L5;
        int r12 = 4;
    L6:
        prep(r11, r12 + 4);
        addOffset(r5);
        if (r10 == false) goto L9;
        addInt(this.f515bb.capacity() - this.space);
    L9:
        this.f515bb.position(this.space);
        this.finished = true;
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public void finishSizePrefixed(int r5) {
        finish(r5, true);
    }

    public void finished() {
        if (this.finished == false) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public FlatBufferBuilder forceDefaults(boolean r5) {
        this.force_defaults = r5;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer r5, ByteBufferFactory r10) {
        this.bb_factory = r10;
        this.f515bb = r5;
        r5.clear();
        this.f515bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.f515bb.capacity();
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
        return this.f515bb.capacity() - this.space;
    }

    public void pad(int r5) {
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        ByteBuffer r11 = this.f515bb;
        int r12 = this.space - 1;
        this.space = r12;
        r11.put(r12, (byte) 0);
        r10 = r10 + 1;
        goto L3
    }

    public void prep(int r5, int r10) {
        if (r5 <= this.minalign) goto L5;
        this.minalign = r5;
    L5:
        int r11 = ((~((this.f515bb.capacity() - this.space) + r10)) + 1) & (r5 - 1);
    L7:
        if (this.space >= ((r11 + r5) + r10)) goto L12;
        int r12 = this.f515bb.capacity();
        ByteBuffer r13 = this.f515bb;
        ByteBuffer r14 = growByteBuffer(r13, this.bb_factory);
        this.f515bb = r14;
        if (r13 == r14) goto L11;
        this.bb_factory.releaseByteBuffer(r13);
    L11:
        this.space = (this.f515bb.capacity() - r12) + this.space;
        goto L7
    L12:
        pad(r11);
    }

    public void putBoolean(boolean r5) {
        ByteBuffer r10 = this.f515bb;
        int r11 = this.space - 1;
        this.space = r11;
        r10.put(r11, r5 ? 1 : 0);
    }

    public void putByte(byte r5) {
        ByteBuffer r10 = this.f515bb;
        int r11 = this.space - 1;
        this.space = r11;
        r10.put(r11, r5);
    }

    public void putDouble(double r5) {
        ByteBuffer r10 = this.f515bb;
        int r11 = this.space - 8;
        this.space = r11;
        r10.putDouble(r11, r5);
    }

    public void putFloat(float r5) {
        ByteBuffer r10 = this.f515bb;
        int r11 = this.space - 4;
        this.space = r11;
        r10.putFloat(r11, r5);
    }

    public void putInt(int r5) {
        ByteBuffer r10 = this.f515bb;
        int r11 = this.space - 4;
        this.space = r11;
        r10.putInt(r11, r5);
    }

    public void putLong(long r5) {
        ByteBuffer r10 = this.f515bb;
        int r11 = this.space - 8;
        this.space = r11;
        r10.putLong(r11, r5);
    }

    public void putShort(short r5) {
        ByteBuffer r10 = this.f515bb;
        int r11 = this.space - 2;
        this.space = r11;
        r10.putShort(r11, r5);
    }

    public void required(int r5, int r10) {
        int r11 = this.f515bb.capacity() - r5;
        int r12 = r11 - this.f515bb.getInt(r11);
        if (this.f515bb.getShort(r12 + r10) == 0) goto L6;
        return;
    L6:
        throw new AssertionError(j0.h(r10, "FlatBuffers: field ", " must be set"));
    }

    public byte[] sizedByteArray(int r5, int r10) {
        finished();
        byte[] r11 = new byte[r10];
        this.f515bb.position(r5);
        this.f515bb.get(r11);
        return r11;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer r5 = this.f515bb.duplicate();
        r5.position(this.space);
        r5.limit(this.f515bb.capacity());
        return new ByteBufferBackedInputStream(r5);
    }

    public void slot(int r5) {
        this.vtable[r5] = offset();
    }

    public void startTable(int r5) {
        notNested();
        int[] r10 = this.vtable;
        if (r10 != null) goto L5;
    L6:
        this.vtable = new int[r5];
    L7:
        this.vtable_in_use = r5;
        Arrays.fill(this.vtable, 0, r5, 0);
        this.nested = true;
        this.object_start = offset();
        return;
    L5:
        if (r10.length >= r5) goto L7;
        goto L6
    }

    public void startVector(int r5, int r10, int r11) {
        notNested();
        this.vector_num_elems = r10;
        int r12 = r5 * r10;
        prep(4, r12);
        prep(r11, r12);
        this.nested = true;
    }

    public FlatBufferBuilder(int r5, ByteBufferFactory r10, ByteBuffer r11, Utf8 r12) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        if (r5 > 0) goto L5;
        r5 = 1;
    L5:
        this.bb_factory = r10;
        if (r11 == null) goto L8;
        this.f515bb = r11;
        r11.clear();
        this.f515bb.order(ByteOrder.LITTLE_ENDIAN);
    L9:
        this.utf8 = r12;
        this.space = this.f515bb.capacity();
        return;
    L8:
        this.f515bb = r10.newByteBuffer(r5);
        goto L9
    }

    public void addBoolean(int r5, boolean r10, boolean r11) {
        if (this.force_defaults == true) goto L5;
        if (r10 != r11) goto L5;
        return;
    L5:
        addBoolean(r10);
        slot(r5);
    }

    public void addByte(int r5, byte r10, int r11) {
        if (this.force_defaults == true) goto L5;
        if (r10 != r11) goto L5;
        return;
    L5:
        addByte(r10);
        slot(r5);
    }

    public void addDouble(int r5, double r10, double r11) {
        if (this.force_defaults == false) goto L5;
    L6:
        addDouble(r10);
        slot(r5);
        return;
    L5:
        if (r10 != r11) goto L6;
    }

    public void addFloat(int r5, float r10, double r11) {
        if (this.force_defaults == false) goto L5;
    L6:
        addFloat(r10);
        slot(r5);
        return;
    L5:
        if (r10 != r11) goto L6;
    }

    public void addInt(int r5, int r10, int r11) {
        if (this.force_defaults == true) goto L5;
        if (r10 != r11) goto L5;
        return;
    L5:
        addInt(r10);
        slot(r5);
    }

    public void addLong(int r5, long r10, long r11) {
        if (this.force_defaults == false) goto L5;
    L6:
        addLong(r10);
        slot(r5);
        return;
    L5:
        if (r10 != r11) goto L6;
    }

    public void addShort(int r5, short r10, int r11) {
        if (this.force_defaults == true) goto L5;
        if (r10 != r11) goto L5;
        return;
    L5:
        addShort(r10);
        slot(r5);
    }

    public void finishSizePrefixed(int r5, String r10) {
        finish(r5, r10, true);
    }

    public void addOffset(int r5, int r10, int r11) {
        if (this.force_defaults == true) goto L5;
        if (r10 != r11) goto L5;
        return;
    L5:
        addOffset(r10);
        slot(r5);
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.f515bb.capacity() - this.space);
    }

    public int createByteVector(byte[] r5, int r10, int r11) {
        startVector(1, r11, 1);
        ByteBuffer r12 = this.f515bb;
        int r13 = this.space - r11;
        this.space = r13;
        r12.position(r13);
        this.f515bb.put(r5, r10, r11);
        return endVector();
    }

    public void finish(int r5) {
        finish(r5, false);
    }

    public int createString(ByteBuffer r5) {
        int r10 = r5.remaining();
        addByte((byte) 0);
        startVector(1, r10, 1);
        ByteBuffer r11 = this.f515bb;
        int r12 = this.space - r10;
        this.space = r12;
        r11.position(r12);
        this.f515bb.put(r5);
        return endVector();
    }

    public void finish(int r5, String r10, boolean r11) {
        int r12 = this.minalign;
        if (r11 == false) goto L5;
        int r13 = 4;
    L6:
        prep(r12, r13 + 8);
        if (r10.length() != 4) goto L14;
        int r14 = 3;
    L9:
        if (r14 < 0) goto L11;
        addByte((byte) r10.charAt(r14));
        r14 = r14 - 1;
        goto L9
    L11:
        finish(r5, r11);
        return;
    L14:
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    L5:
        r13 = 0;
        goto L6
    }

    public int createByteVector(ByteBuffer r5) {
        int r10 = r5.remaining();
        startVector(1, r10, 1);
        ByteBuffer r11 = this.f515bb;
        int r12 = this.space - r10;
        this.space = r12;
        r11.position(r12);
        this.f515bb.put(r5);
        return endVector();
    }

    public void finish(int r5, String r10) {
        finish(r5, r10, false);
    }

    public FlatBufferBuilder(int r5) {
        this(r5, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer r5, ByteBufferFactory r10) {
        this(r5.capacity(), r10, r5, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer r5) {
        this(r5, new HeapByteBufferFactory());
    }
}
