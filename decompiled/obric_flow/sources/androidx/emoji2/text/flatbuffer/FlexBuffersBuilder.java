package androidx.emoji2.text.flatbuffer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    private final ReadWriteBuf f518bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    public static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        public Value(int r5, int r10, int r11, long r12) {
            this.key = r5;
            this.type = r10;
            this.minBitWidth = r11;
            this.iValue = r12;
            this.dValue = Double.MIN_VALUE;
        }

        public static /* synthetic */ int access$100(int r5, int r10) {
            return paddingBytes(r5, r10);
        }

        public static /* synthetic */ int access$200(Value r5, int r10, int r11) {
            return r5.elemWidth(r10, r11);
        }

        public static /* synthetic */ byte access$300(Value r5) {
            return r5.storedPackedType();
        }

        public static /* synthetic */ byte access$400(Value r5, int r10) {
            return r5.storedPackedType(r10);
        }

        public static /* synthetic */ int access$500(int r5, int r10, long r11, int r12, int r13) {
            return elemWidth(r5, r10, r11, r12, r13);
        }

        public static Value blob(int r10, int r11, int r12, int r13) {
            return new Value(r10, r12, r13, r11);
        }

        public static Value bool(int r10, boolean r11) {
            if (r11 == false) goto L6;
            long r5 = 1;
        L8:
            return new Value(r10, 26, 0, r5);
        L6:
            r5 = 0;
            goto L8
        }

        private int elemWidth(int r10, int r11) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, r10, r11);
        }

        public static Value float32(int r10, float r11) {
            return new Value(r10, 3, 2, r11);
        }

        public static Value float64(int r10, double r11) {
            return new Value(r10, 3, 3, r11);
        }

        public static Value int16(int r10, int r11) {
            return new Value(r10, 1, 1, r11);
        }

        public static Value int32(int r10, int r11) {
            return new Value(r10, 1, 2, r11);
        }

        public static Value int64(int r10, long r11) {
            return new Value(r10, 1, 3, r11);
        }

        public static Value int8(int r10, int r11) {
            return new Value(r10, 1, 0, r11);
        }

        private static byte packedType(int r5, int r10) {
            return (byte) (r5 | (r10 << 2));
        }

        private static int paddingBytes(int r5, int r10) {
            return ((~r5) + 1) & (r10 - 1);
        }

        private byte storedPackedType() {
            return storedPackedType(0);
        }

        private int storedWidth(int r5) {
            if (FlexBuffers.isTypeInline(this.type) == false) goto L7;
            return Math.max(this.minBitWidth, r5);
        L7:
            return this.minBitWidth;
        }

        public static Value uInt16(int r10, int r11) {
            return new Value(r10, 2, 1, r11);
        }

        public static Value uInt32(int r10, int r11) {
            return new Value(r10, 2, 2, r11);
        }

        public static Value uInt64(int r10, long r11) {
            return new Value(r10, 2, 3, r11);
        }

        public static Value uInt8(int r10, int r11) {
            return new Value(r10, 2, 0, r11);
        }

        private static int elemWidth(int r5, int r10, long r11, int r12, int r13) {
            if (FlexBuffers.isTypeInline(r5) == false) goto L5;
            return r10;
        L5:
            int r14 = 1;
        L7:
            if (r14 > 32) goto L12;
            int r15 = FlexBuffersBuilder.widthUInBits((int) (((long) ((r13 * r14) + (paddingBytes(r12, r14) + r12))) - r11));
            if ((1 << r15) == r14) goto L10;
            r14 = r14 * 2;
            goto L7
        L10:
            return r15;
        L12:
            return 3;
        }

        private byte storedPackedType(int r5) {
            return packedType(storedWidth(r5), this.type);
        }

        public Value(int r5, int r10, int r11, double r12) {
            this.key = r5;
            this.type = r10;
            this.minBitWidth = r11;
            this.dValue = r12;
            this.iValue = Long.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder(int r5) {
        this(new ArrayReadWriteBuf(r5), 1);
    }

    public static /* synthetic */ ReadWriteBuf access$000(FlexBuffersBuilder r5) {
        return r5.f518bb;
    }

    private int align(int r5) {
        int r10 = 1 << r5;
        int r11 = Value.access$100(this.f518bb.writePosition(), r10);
    L3:
        int r12 = r11 - 1;
        if (r11 == 0) goto L6;
        this.f518bb.put((byte) 0);
        r11 = r12;
        goto L3
    L6:
        return r10;
    }

    private Value createKeyVector(int r14, int r15) {
        long r5 = r15;
        int r10 = Math.max(0, widthUInBits(r5));
        int r16 = r14;
    L4:
        if (r16 >= this.stack.size()) goto L6;
        r16 = r16 + 1;
        r10 = Math.max(r10, Value.access$500(4, 0, this.stack.get(r16).key, this.f518bb.writePosition(), r16));
        goto L4
    L6:
        int r17 = align(r10);
        writeInt(r5, r17);
        int r11 = this.f518bb.writePosition();
    L8:
        if (r14 >= this.stack.size()) goto L11;
        int r12 = this.stack.get(r14).key;
        writeOffset(this.stack.get(r14).key, r17);
        r14 = r14 + 1;
        goto L8
    L11:
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), r10, r11);
    }

    private Value createVector(int r16, int r17, int r18, boolean r19, boolean r20, Value r21) {
        int r5 = r18;
        long r10 = r5;
        int r11 = Math.max(0, widthUInBits(r10));
        if (r21 == null) goto L5;
        r11 = Math.max(r11, Value.access$200(r21, this.f518bb.writePosition(), 0));
        int r12 = 3;
    L6:
        int r13 = 4;
        int r14 = r11;
        int r15 = r17;
    L8:
        if (r15 >= this.stack.size()) goto L18;
        r14 = Math.max(r14, Value.access$200(this.stack.get(r15), this.f518bb.writePosition(), r15 + r12));
        if (r19 == false) goto L17;
        if (r15 != r17) goto L17;
        r13 = this.stack.get(r15).type;
        if (FlexBuffers.isTypedVectorElementType(r13) == true) goto L17;
        throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
    L17:
        r15 = r15 + 1;
        goto L8
    L18:
        int r22 = r17;
        int r23 = align(r14);
        if (r21 == null) goto L21;
        writeOffset(r21.iValue, r23);
        writeInt(1 << r21.minBitWidth, r23);
    L21:
        if (r20 == true) goto L23;
        writeInt(r10, r23);
    L23:
        int r24 = this.f518bb.writePosition();
        int r25 = r22;
    L25:
        if (r25 >= this.stack.size()) goto L27;
        writeAny(this.stack.get(r25), r23);
        r25 = r25 + 1;
        goto L25
    L27:
        if (r19 == true) goto L32;
    L29:
        if (r22 >= this.stack.size()) goto L32;
        this.f518bb.put(Value.access$400(this.stack.get(r22), r14));
        r22 = r22 + 1;
    L32:
        if (r21 == null) goto L35;
        int r26 = 9;
    L42:
        return new Value(r16, r26, r14, r24);
    L35:
        if (r19 == false) goto L40;
        if (r20 == true) goto L39;
        r5 = 0;
    L39:
        r26 = FlexBuffers.toTypedVector(r13, r5);
        goto L42
    L40:
        r26 = 10;
        goto L42
    L5:
        r12 = 1;
        goto L6
    }

    private int putKey(String r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        int r5 = this.f518bb.writePosition();
        if ((this.flags & 1) == 0) goto L11;
        Integer r11 = this.keyPool.get(r10);
        if (r11 != null) goto L14;
        byte[] r12 = r10.getBytes(StandardCharsets.UTF_8);
        this.f518bb.put(r12, 0, r12.length);
        this.f518bb.put((byte) 0);
        this.keyPool.put(r10, Integer.valueOf(r5));
        return r5;
    L14:
        return r11.intValue();
    L11:
        byte[] r13 = r10.getBytes(StandardCharsets.UTF_8);
        this.f518bb.put(r13, 0, r13.length);
        this.f518bb.put((byte) 0);
        this.keyPool.put(r10, Integer.valueOf(r5));
        return r5;
    }

    public static int widthUInBits(long r5) {
        if (r5 > FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) goto L7;
        return 0;
    L7:
        if (r5 > FlexBuffers.Unsigned.shortToUnsignedInt(-1)) goto L11;
        return 1;
    L11:
        if (r5 > FlexBuffers.Unsigned.intToUnsignedLong(-1)) goto L14;
        return 2;
    L14:
        return 3;
    }

    private void writeAny(Value r5, int r10) {
        int r11 = r5.type;
        if (r11 != 0) goto L5;
    L14:
        writeInt(r5.iValue, r10);
        return;
    L5:
        if (r11 == 1) goto L14;
        if (r11 == 2) goto L14;
        if (r11 != 3) goto L11;
        writeDouble(r5.dValue, r10);
        return;
    L11:
        if (r11 == 26) goto L14;
        writeOffset(r5.iValue, r10);
    }

    private Value writeBlob(int r10, byte[] r11, int r12, boolean r13) {
        int r5 = widthUInBits(r11.length);
        writeInt(r11.length, align(r5));
        int r14 = this.f518bb.writePosition();
        this.f518bb.put(r11, 0, r11.length);
        if (r13 == false) goto L6;
        this.f518bb.put((byte) 0);
    L6:
        return Value.blob(r10, r14, r12, r5);
    }

    private void writeDouble(double r5, int r10) {
        if (r10 != 4) goto L6;
        this.f518bb.putFloat((float) r5);
        return;
    L6:
        if (r10 != 8) goto L10;
        this.f518bb.putDouble(r5);
        return;
    }

    private void writeInt(long r5, int r10) {
        if (r10 != 1) goto L5;
        this.f518bb.put((byte) r5);
        return;
    L5:
        if (r10 != 2) goto L7;
        this.f518bb.putShort((short) r5);
        return;
    L7:
        if (r10 != 4) goto L9;
        this.f518bb.putInt((int) r5);
        return;
    L9:
        if (r10 != 8) goto L19;
        this.f518bb.putLong(r5);
        return;
    }

    private void writeOffset(long r5, int r10) {
        writeInt((int) (((long) this.f518bb.writePosition()) - r5), r10);
    }

    private Value writeString(int r5, String r10) {
        return writeBlob(r5, r10.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String r10, int r11) {
        int r5 = putKey(r10);
        ArrayList<Value> r12 = this.stack;
        Collections.sort(r12.subList(r11, r12.size()), this.keyComparator);
        Value r13 = createVector(r5, r11, this.stack.size() - r11, false, false, createKeyVector(r11, this.stack.size() - r11));
    L4:
        if (this.stack.size() <= r11) goto L6;
        ArrayList<Value> r14 = this.stack;
        r14.remove(r14.size() - 1);
        goto L4
    L6:
        this.stack.add(r13);
        return (int) r13.iValue;
    }

    public int endVector(String r10, int r11, boolean r12, boolean r13) {
        Value r14 = createVector(putKey(r10), r11, this.stack.size() - r11, r12, r13, null);
    L4:
        if (this.stack.size() <= r11) goto L6;
        ArrayList<Value> r15 = this.stack;
        r15.remove(r15.size() - 1);
        goto L4
    L6:
        this.stack.add(r14);
        return (int) r14.iValue;
    }

    public ByteBuffer finish() {
        int r5 = align(Value.access$200(this.stack.get(0), this.f518bb.writePosition(), 0));
        writeAny(this.stack.get(0), r5);
        this.f518bb.put(Value.access$300(this.stack.get(0)));
        this.f518bb.put((byte) r5);
        this.finished = true;
        return ByteBuffer.wrap(this.f518bb.data(), 0, this.f518bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.f518bb;
    }

    public int putBlob(byte[] r5) {
        return putBlob(null, r5);
    }

    public void putBoolean(boolean r5) {
        putBoolean(null, r5);
    }

    public void putFloat(float r5) {
        putFloat(null, r5);
    }

    public void putInt(int r5) {
        putInt(null, r5);
    }

    public int putString(String r5) {
        return putString(null, r5);
    }

    public void putUInt(int r5) {
        putUInt(null, r5);
    }

    public void putUInt64(BigInteger r5) {
        putUInt64(null, r5.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void putUInt64(String r5, long r10) {
        this.stack.add(Value.uInt64(putKey(r5), r10));
    }

    public int putBlob(String r5, byte[] r10) {
        Value r11 = writeBlob(putKey(r5), r10, 25, false);
        this.stack.add(r11);
        return (int) r11.iValue;
    }

    public void putBoolean(String r5, boolean r10) {
        this.stack.add(Value.bool(putKey(r5), r10));
    }

    public void putFloat(String r5, float r10) {
        this.stack.add(Value.float32(putKey(r5), r10));
    }

    public void putInt(String r5, int r10) {
        putInt(r5, r10);
    }

    public int putString(String r5, String r10) {
        int r11 = putKey(r5);
        if ((this.flags & 2) == 0) goto L10;
        Integer r12 = this.stringPool.get(r10);
        if (r12 != null) goto L8;
        Value r13 = writeString(r11, r10);
        this.stringPool.put(r10, Integer.valueOf((int) r13.iValue));
        this.stack.add(r13);
        return (int) r13.iValue;
    L8:
        this.stack.add(Value.blob(r11, r12.intValue(), 5, widthUInBits(r10.length())));
        return r12.intValue();
    L10:
        Value r14 = writeString(r11, r10);
        this.stack.add(r14);
        return (int) r14.iValue;
    }

    public void putUInt(long r5) {
        putUInt(null, r5);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer r5, int r10) {
        this(new ArrayReadWriteBuf(r5.array()), r10);
    }

    private void putUInt(String r5, long r10) {
        int r11 = putKey(r5);
        int r12 = widthUInBits(r10);
        if (r12 != 0) goto L6;
        Value r13 = Value.uInt8(r11, (int) r10);
    L12:
        this.stack.add(r13);
        return;
    L6:
        if (r12 != 1) goto L9;
        r13 = Value.uInt16(r11, (int) r10);
        goto L12
    L9:
        if (r12 != 2) goto L11;
        r13 = Value.uInt32(r11, (int) r10);
        goto L12
    L11:
        r13 = Value.uInt64(r11, r10);
        goto L12
    }

    public void putFloat(double r5) {
        putFloat(null, r5);
    }

    public void putInt(String r5, long r10) {
        int r11 = putKey(r5);
        if ((-128) > r10) goto L8;
        if (r10 > 127) goto L8;
        this.stack.add(Value.int8(r11, (int) r10));
        return;
    L8:
        if ((-32768) > r10) goto L13;
        if (r10 > 32767) goto L13;
        this.stack.add(Value.int16(r11, (int) r10));
        return;
    L13:
        if ((-2147483648L) <= r10) goto L15;
    L17:
        this.stack.add(Value.int64(r11, r10));
        return;
    L15:
        if (r10 > 2147483647L) goto L17;
        this.stack.add(Value.int32(r11, (int) r10));
    }

    public FlexBuffersBuilder(ReadWriteBuf r5, int r10) {
        this.stack = new ArrayList();
        this.keyPool = new HashMap();
        this.stringPool = new HashMap();
        this.finished = false;
        this.keyComparator = new AnonymousClass1(this);
        this.f518bb = r5;
        this.flags = r10;
    }

    public void putFloat(String r5, double r10) {
        this.stack.add(Value.float64(putKey(r5), r10));
    }

    public void putInt(long r5) {
        putInt(null, r5);
    }

    public FlexBuffersBuilder(ByteBuffer r5) {
        this(r5, 1);
    }
}
