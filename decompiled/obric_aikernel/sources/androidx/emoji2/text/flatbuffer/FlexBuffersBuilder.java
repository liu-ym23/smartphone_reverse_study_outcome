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
    private final ReadWriteBuf f378bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    private static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        static {
        }

        Value(int r10, int r11, int r12, double r13) {
            this.key = r10;
            this.type = r11;
            this.minBitWidth = r12;
            this.dValue = r13;
            this.iValue = Long.MIN_VALUE;
        }

        Value(int r10, int r11, int r12, long r13) {
            this.key = r10;
            this.type = r11;
            this.minBitWidth = r12;
            this.iValue = r13;
            this.dValue = Double.MIN_VALUE;
        }

        static /* synthetic */ int access$100(int r10, int r11) {
            return paddingBytes(r10, r11);
        }

        static /* synthetic */ int access$200(Value r10, int r11, int r12) {
            return r10.elemWidth(r11, r12);
        }

        static /* synthetic */ byte access$300(Value r10) {
            return r10.storedPackedType();
        }

        static /* synthetic */ byte access$400(Value r10, int r11) {
            return r10.storedPackedType(r11);
        }

        static /* synthetic */ int access$500(int r10, int r11, long r12, int r13, int r14) {
            return elemWidth(r10, r11, r12, r13, r14);
        }

        static Value blob(int r10, int r11, int r12, int r13) {
            return new Value(r10, r12, r13, r11);
        }

        static Value bool(int r10, boolean r11) {
            if (r11 == false) goto L5;
            long r12 = 1;
        L7:
            return new Value(r10, 26, 0, r12);
        L5:
            r12 = 0;
            goto L7
        }

        private int elemWidth(int r10, int r11) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, r10, r11);
        }

        private static int elemWidth(int r10, int r11, long r12, int r13, int r14) {
            if (FlexBuffers.isTypeInline(r10) == false) goto L5;
            return r11;
        L5:
            int r15 = 1;
        L7:
            if (r15 > 32) goto L12;
            int r16 = FlexBuffersBuilder.widthUInBits((int) (((long) ((paddingBytes(r13, r15) + r13) + (r14 * r15))) - r12));
            if ((1 << r16) == r15) goto L10;
            r15 = r15 * 2;
            goto L7
        L10:
            return r16;
        L12:
            return 3;
        }

        static Value float32(int r10, float r11) {
            return new Value(r10, 3, 2, r11);
        }

        static Value float64(int r10, double r11) {
            return new Value(r10, 3, 3, r11);
        }

        static Value int16(int r10, int r11) {
            return new Value(r10, 1, 1, r11);
        }

        static Value int32(int r10, int r11) {
            return new Value(r10, 1, 2, r11);
        }

        static Value int64(int r10, long r11) {
            return new Value(r10, 1, 3, r11);
        }

        static Value int8(int r10, int r11) {
            return new Value(r10, 1, 0, r11);
        }

        private static byte packedType(int r10, int r11) {
            return (byte) (r10 | (r11 << 2));
        }

        private static int paddingBytes(int r10, int r11) {
            return ((~r10) + 1) & (r11 - 1);
        }

        private byte storedPackedType() {
            return storedPackedType(0);
        }

        private byte storedPackedType(int r10) {
            return packedType(storedWidth(r10), this.type);
        }

        private int storedWidth(int r10) {
            boolean r11 = FlexBuffers.isTypeInline(this.type);
            int r12 = this.minBitWidth;
            if (r11 == true) goto L5;
            return r12;
        L5:
            return Math.max(r12, r10);
        }

        static Value uInt16(int r10, int r11) {
            return new Value(r10, 2, 1, r11);
        }

        static Value uInt32(int r10, int r11) {
            return new Value(r10, 2, 2, r11);
        }

        static Value uInt64(int r10, long r11) {
            return new Value(r10, 2, 3, r11);
        }

        static Value uInt8(int r10, int r11) {
            return new Value(r10, 2, 0, r11);
        }
    }

    static {
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    public FlexBuffersBuilder(int r10) {
        this(new ArrayReadWriteBuf(r10), 1);
    }

    public FlexBuffersBuilder(ReadWriteBuf r10, int r11) {
        this.stack = new ArrayList();
        this.keyPool = new HashMap();
        this.stringPool = new HashMap();
        this.finished = false;
        this.keyComparator = new AnonymousClass1(this);
        this.f378bb = r10;
        this.flags = r11;
    }

    public FlexBuffersBuilder(ByteBuffer r10) {
        this(r10, 1);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer r10, int r11) {
        this(new ArrayReadWriteBuf(r10.array()), r11);
    }

    static /* synthetic */ ReadWriteBuf access$000(FlexBuffersBuilder r10) {
        return r10.f378bb;
    }

    private int align(int r10) {
        int r11 = 1 << r10;
        int r12 = Value.access$100(this.f378bb.writePosition(), r11);
    L3:
        int r13 = r12 - 1;
        if (r12 == 0) goto L6;
        this.f378bb.put((byte) 0);
        r12 = r13;
        goto L3
    L6:
        return r11;
    }

    private Value createKeyVector(int r14, int r15) {
        long r10 = r15;
        int r11 = Math.max(0, widthUInBits(r10));
        int r16 = r14;
    L4:
        if (r16 >= this.stack.size()) goto L6;
        r16 = r16 + 1;
        r11 = Math.max(r11, Value.access$500(4, 0, this.stack.get(r16).key, this.f378bb.writePosition(), r16));
        goto L4
    L6:
        int r17 = align(r11);
        writeInt(r10, r17);
        int r12 = this.f378bb.writePosition();
    L8:
        if (r14 >= this.stack.size()) goto L11;
        int r13 = this.stack.get(r14).key;
        writeOffset(this.stack.get(r14).key, r17);
        r14 = r14 + 1;
        goto L8
    L11:
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), r11, r12);
    }

    private Value createVector(int r16, int r17, int r18, boolean r19, boolean r20, Value r21) {
        int r10 = r18;
        long r11 = r10;
        int r12 = Math.max(0, widthUInBits(r11));
        if (r21 == null) goto L5;
        r12 = Math.max(r12, Value.access$200(r21, this.f378bb.writePosition(), 0));
        int r13 = 3;
    L6:
        int r14 = 4;
        int r15 = r12;
        int r22 = r17;
    L8:
        if (r22 >= this.stack.size()) goto L18;
        r15 = Math.max(r15, Value.access$200(this.stack.get(r22), this.f378bb.writePosition(), r22 + r13));
        if (r19 == false) goto L17;
        if (r22 != r17) goto L17;
        r14 = this.stack.get(r22).type;
        if (FlexBuffers.isTypedVectorElementType(r14) == true) goto L17;
        throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
    L17:
        r22 = r22 + 1;
        goto L8
    L18:
        int r23 = r17;
        int r24 = align(r15);
        if (r21 == null) goto L21;
        writeOffset(r21.iValue, r24);
        writeInt(1 << r21.minBitWidth, r24);
    L21:
        if (r20 == true) goto L23;
        writeInt(r11, r24);
    L23:
        int r25 = this.f378bb.writePosition();
        int r26 = r23;
    L25:
        if (r26 >= this.stack.size()) goto L27;
        writeAny(this.stack.get(r26), r24);
        r26 = r26 + 1;
        goto L25
    L27:
        if (r19 == true) goto L32;
    L29:
        if (r23 >= this.stack.size()) goto L32;
        this.f378bb.put(Value.access$400(this.stack.get(r23), r15));
        r23 = r23 + 1;
    L32:
        if (r21 == null) goto L35;
        int r27 = 9;
    L42:
        return new Value(r16, r27, r15, r25);
    L35:
        if (r19 == false) goto L40;
        if (r20 == true) goto L39;
        r10 = 0;
    L39:
        r27 = FlexBuffers.toTypedVector(r14, r10);
        goto L42
    L40:
        r27 = 10;
        goto L42
    L5:
        r13 = 1;
        goto L6
    }

    private int putKey(String r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        int r11 = this.f378bb.writePosition();
        if ((this.flags & 1) == 0) goto L11;
        Integer r12 = this.keyPool.get(r10);
        if (r12 != null) goto L14;
        byte[] r13 = r10.getBytes(StandardCharsets.UTF_8);
        this.f378bb.put(r13, 0, r13.length);
    L12:
        this.f378bb.put((byte) 0);
        this.keyPool.put(r10, Integer.valueOf(r11));
        return r11;
    L14:
        return r12.intValue();
    L11:
        byte[] r14 = r10.getBytes(StandardCharsets.UTF_8);
        this.f378bb.put(r14, 0, r14.length);
        goto L12
    }

    private void putUInt(String r10, long r11) {
        int r12 = putKey(r10);
        int r13 = widthUInBits(r11);
        if (r13 != 0) goto L6;
        Value r14 = Value.uInt8(r12, (int) r11);
    L12:
        this.stack.add(r14);
        return;
    L6:
        if (r13 != 1) goto L9;
        r14 = Value.uInt16(r12, (int) r11);
        goto L12
    L9:
        if (r13 != 2) goto L11;
        r14 = Value.uInt32(r12, (int) r11);
        goto L12
    L11:
        r14 = Value.uInt64(r12, r11);
        goto L12
    }

    private void putUInt64(String r10, long r11) {
        this.stack.add(Value.uInt64(putKey(r10), r11));
    }

    static int widthUInBits(long r10) {
        if (r10 > FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) goto L7;
        return 0;
    L7:
        if (r10 > FlexBuffers.Unsigned.shortToUnsignedInt(-1)) goto L11;
        return 1;
    L11:
        if (r10 > FlexBuffers.Unsigned.intToUnsignedLong(-1)) goto L14;
        return 2;
    L14:
        return 3;
    }

    private void writeAny(Value r10, int r11) {
        int r12 = r10.type;
        if (r12 != 0) goto L5;
    L14:
        writeInt(r10.iValue, r11);
        return;
    L5:
        if (r12 == 1) goto L14;
        if (r12 == 2) goto L14;
        if (r12 != 3) goto L11;
        writeDouble(r10.dValue, r11);
        return;
    L11:
        if (r12 == 26) goto L14;
        writeOffset(r10.iValue, r11);
    }

    private Value writeBlob(int r10, byte[] r11, int r12, boolean r13) {
        int r14 = widthUInBits(r11.length);
        writeInt(r11.length, align(r14));
        int r15 = this.f378bb.writePosition();
        this.f378bb.put(r11, 0, r11.length);
        if (r13 == false) goto L6;
        this.f378bb.put((byte) 0);
    L6:
        return Value.blob(r10, r15, r12, r14);
    }

    private void writeDouble(double r10, int r11) {
        if (r11 != 4) goto L6;
        this.f378bb.putFloat((float) r10);
        return;
    L6:
        if (r11 != 8) goto L10;
        this.f378bb.putDouble(r10);
        return;
    }

    private void writeInt(long r10, int r11) {
        if (r11 != 1) goto L5;
        this.f378bb.put((byte) r10);
        return;
    L5:
        if (r11 != 2) goto L7;
        this.f378bb.putShort((short) r10);
        return;
    L7:
        if (r11 != 4) goto L9;
        this.f378bb.putInt((int) r10);
        return;
    L9:
        if (r11 != 8) goto L19;
        this.f378bb.putLong(r10);
        return;
    }

    private void writeOffset(long r10, int r11) {
        writeInt((int) (((long) this.f378bb.writePosition()) - r10), r11);
    }

    private Value writeString(int r10, String r11) {
        return writeBlob(r10, r11.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String r10, int r11) {
        int r12 = putKey(r10);
        ArrayList<Value> r13 = this.stack;
        Collections.sort(r13.subList(r11, r13.size()), this.keyComparator);
        Value r14 = createVector(r12, r11, this.stack.size() - r11, false, false, createKeyVector(r11, this.stack.size() - r11));
    L4:
        if (this.stack.size() <= r11) goto L6;
        ArrayList<Value> r15 = this.stack;
        r15.remove(r15.size() - 1);
        goto L4
    L6:
        this.stack.add(r14);
        return (int) r14.iValue;
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
        int r10 = align(Value.access$200(this.stack.get(0), this.f378bb.writePosition(), 0));
        writeAny(this.stack.get(0), r10);
        this.f378bb.put(Value.access$300(this.stack.get(0)));
        this.f378bb.put((byte) r10);
        this.finished = true;
        return ByteBuffer.wrap(this.f378bb.data(), 0, this.f378bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.f378bb;
    }

    public int putBlob(String r10, byte[] r11) {
        Value r12 = writeBlob(putKey(r10), r11, 25, false);
        this.stack.add(r12);
        return (int) r12.iValue;
    }

    public int putBlob(byte[] r10) {
        return putBlob(null, r10);
    }

    public void putBoolean(String r10, boolean r11) {
        this.stack.add(Value.bool(putKey(r10), r11));
    }

    public void putBoolean(boolean r10) {
        putBoolean(null, r10);
    }

    public void putFloat(double r10) {
        putFloat(null, r10);
    }

    public void putFloat(float r10) {
        putFloat(null, r10);
    }

    public void putFloat(String r10, double r11) {
        this.stack.add(Value.float64(putKey(r10), r11));
    }

    public void putFloat(String r10, float r11) {
        this.stack.add(Value.float32(putKey(r10), r11));
    }

    public void putInt(int r10) {
        putInt(null, r10);
    }

    public void putInt(long r10) {
        putInt(null, r10);
    }

    public void putInt(String r10, int r11) {
        putInt(r10, r11);
    }

    public void putInt(String r10, long r11) {
        int r12 = putKey(r10);
        if ((-128) > r11) goto L9;
        if (r11 > 127) goto L9;
        ArrayList<Value> r13 = this.stack;
        Value r14 = Value.int8(r12, (int) r11);
    L7:
        r13.add(r14);
        return;
    L9:
        if ((-32768) > r11) goto L14;
        if (r11 > 32767) goto L14;
        r13 = this.stack;
        r14 = Value.int16(r12, (int) r11);
    L14:
        if ((-2147483648L) <= r11) goto L16;
    L18:
        r13 = this.stack;
        r14 = Value.int64(r12, r11);
        goto L7
    L16:
        if (r11 > 2147483647L) goto L18;
        r13 = this.stack;
        r14 = Value.int32(r12, (int) r11);
        goto L7
    }

    public int putString(String r10) {
        return putString(null, r10);
    }

    public int putString(String r10, String r11) {
        int r12 = putKey(r10);
        if ((this.flags & 2) == 0) goto L10;
        Integer r13 = this.stringPool.get(r11);
        if (r13 != null) goto L8;
        Value r14 = writeString(r12, r11);
        this.stringPool.put(r11, Integer.valueOf((int) r14.iValue));
        this.stack.add(r14);
        return (int) r14.iValue;
    L8:
        this.stack.add(Value.blob(r12, r13.intValue(), 5, widthUInBits(r11.length())));
        return r13.intValue();
    L10:
        Value r15 = writeString(r12, r11);
        this.stack.add(r15);
        return (int) r15.iValue;
    }

    public void putUInt(int r10) {
        putUInt(null, r10);
    }

    public void putUInt(long r10) {
        putUInt(null, r10);
    }

    public void putUInt64(BigInteger r10) {
        putUInt64(null, r10.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }
}
