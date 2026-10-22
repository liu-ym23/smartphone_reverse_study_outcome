package androidx.emoji2.text.flatbuffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private final ReadWriteBuf bb;
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

        Value(int r1, int r2, int r3, double r4) {
            this.key = r1;
            this.type = r2;
            this.minBitWidth = r3;
            this.dValue = r4;
            this.iValue = Long.MIN_VALUE;
        }

        Value(int r1, int r2, int r3, long r4) {
            this.key = r1;
            this.type = r2;
            this.minBitWidth = r3;
            this.iValue = r4;
            this.dValue = Double.MIN_VALUE;
        }

        static /* synthetic */ int access$100(int r0, int r1) {
            return paddingBytes(r0, r1);
        }

        static /* synthetic */ int access$200(Value r0, int r1, int r2) {
            return r0.elemWidth(r1, r2);
        }

        static /* synthetic */ byte access$300(Value r0) {
            return r0.storedPackedType();
        }

        static /* synthetic */ byte access$400(Value r0, int r1) {
            return r0.storedPackedType(r1);
        }

        static /* synthetic */ int access$500(int r0, int r1, long r2, int r4, int r5) {
            return elemWidth(r0, r1, r2, r4, r5);
        }

        static Value blob(int r7, int r8, int r9, int r10) {
            return new Value(r7, r9, r10, r8);
        }

        static Value bool(int r7, boolean r8) {
            if (r8 == false) goto L5;
            long r0 = 1;
        L7:
            return new Value(r7, 26, 0, r0);
        L5:
            r0 = 0;
            goto L7
        }

        private int elemWidth(int r7, int r8) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, r7, r8);
        }

        private static int elemWidth(int r4, int r5, long r6, int r8, int r9) {
            if (FlexBuffers.isTypeInline(r4) == false) goto L5;
            return r5;
        L5:
            int r7 = 1;
        L7:
            if (r7 > 32) goto L12;
            int r10 = FlexBuffersBuilder.widthUInBits((int) (((long) ((paddingBytes(r8, r7) + r8) + (r9 * r7))) - r6));
            if ((1 << r10) == r7) goto L10;
            r7 = r7 * 2;
            goto L7
        L10:
            return r10;
        L12:
            return 3;
        }

        static Value float32(int r7, float r8) {
            return new Value(r7, 3, 2, r8);
        }

        static Value float64(int r7, double r8) {
            return new Value(r7, 3, 3, r8);
        }

        static Value int16(int r7, int r8) {
            return new Value(r7, 1, 1, r8);
        }

        static Value int32(int r7, int r8) {
            return new Value(r7, 1, 2, r8);
        }

        static Value int64(int r7, long r8) {
            return new Value(r7, 1, 3, r8);
        }

        static Value int8(int r7, int r8) {
            return new Value(r7, 1, 0, r8);
        }

        private static byte packedType(int r0, int r1) {
            return (byte) (r0 | (r1 << 2));
        }

        private static int paddingBytes(int r0, int r1) {
            return ((~r0) + 1) & (r1 - 1);
        }

        private byte storedPackedType() {
            return storedPackedType(0);
        }

        private byte storedPackedType(int r1) {
            return packedType(storedWidth(r1), this.type);
        }

        private int storedWidth(int r2) {
            boolean r0 = FlexBuffers.isTypeInline(this.type);
            int r1 = this.minBitWidth;
            if (r0 == true) goto L5;
            return r1;
        L5:
            return Math.max(r1, r2);
        }

        static Value uInt16(int r7, int r8) {
            return new Value(r7, 2, 1, r8);
        }

        static Value uInt32(int r7, int r8) {
            return new Value(r7, 2, 2, r8);
        }

        static Value uInt64(int r7, long r8) {
            return new Value(r7, 2, 3, r8);
        }

        static Value uInt8(int r7, int r8) {
            return new Value(r7, 2, 0, r8);
        }
    }

    static {
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    public FlexBuffersBuilder(int r2) {
        this(new ArrayReadWriteBuf(r2), 1);
    }

    public FlexBuffersBuilder(ReadWriteBuf r3, int r4) {
        ReadWriteBuf r5 = (ReadWriteBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadWriteBuf.class, "com.obric.memorydata.plugin");
        this.stack = new ArrayList();
        this.keyPool = new HashMap();
        this.stringPool = new HashMap();
        this.finished = false;
        this.keyComparator = new AnonymousClass1(this);
        this.bb = r5;
        this.flags = r4;
    }

    public FlexBuffersBuilder(ByteBuffer r2) {
        this(r2, 1);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer r2, int r3) {
        this(new ArrayReadWriteBuf(r2.array()), r3);
    }

    static /* synthetic */ ReadWriteBuf access$000(FlexBuffersBuilder r0) {
        return r0.bb;
    }

    private int align(int r4) {
        int r5 = 1 << r4;
        int r0 = Value.access$100(this.bb.writePosition(), r5);
    L3:
        int r1 = r0 - 1;
        if (r0 == 0) goto L6;
        this.bb.put((byte) 0);
        r0 = r1;
        goto L3
    L6:
        return r5;
    }

    private Value createKeyVector(int r14, int r15) {
        long r0 = r15;
        int r6 = Math.max(0, widthUInBits(r0));
        int r16 = r14;
    L4:
        if (r16 >= this.stack.size()) goto L6;
        r16 = r16 + 1;
        r6 = Math.max(r6, Value.access$500(4, 0, ((Value) ZeusTransformUtils.preCheckCast(this.stack.get(r16), Value.class, "com.obric.memorydata.plugin")).key, this.bb.writePosition(), r16));
        goto L4
    L6:
        int r17 = align(r6);
        writeInt(r0, r17);
        int r1 = this.bb.writePosition();
    L8:
        if (r14 >= this.stack.size()) goto L11;
        int r2 = ((Value) ZeusTransformUtils.preCheckCast(this.stack.get(r14), Value.class, "com.obric.memorydata.plugin")).key;
        writeOffset(((Value) ZeusTransformUtils.preCheckCast(this.stack.get(r14), Value.class, "com.obric.memorydata.plugin")).key, r17);
        r14 = r14 + 1;
        goto L8
    L11:
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), r6, r1);
    }

    private Value createVector(int r16, int r17, int r18, boolean r19, boolean r20, Value r21) {
        int r2 = r18;
        long r3 = r2;
        int r5 = Math.max(0, widthUInBits(r3));
        if (r21 == null) goto L5;
        r5 = Math.max(r5, Value.access$200(r21, this.bb.writePosition(), 0));
        int r7 = 3;
    L6:
        int r8 = 4;
        int r12 = r5;
        int r6 = r17;
    L8:
        if (r6 >= this.stack.size()) goto L18;
        r12 = Math.max(r12, Value.access$200((Value) ZeusTransformUtils.preCheckCast(this.stack.get(r6), Value.class, "com.obric.memorydata.plugin"), this.bb.writePosition(), r6 + r7));
        if (r19 == false) goto L17;
        if (r6 != r17) goto L17;
        r8 = ((Value) ZeusTransformUtils.preCheckCast(this.stack.get(r6), Value.class, "com.obric.memorydata.plugin")).type;
        if (FlexBuffers.isTypedVectorElementType(r8) == true) goto L17;
        throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
    L17:
        r6 = r6 + 1;
        goto L8
    L18:
        int r9 = r17;
        int r10 = align(r12);
        if (r21 == null) goto L21;
        writeOffset(r21.iValue, r10);
        writeInt(1 << r21.minBitWidth, r10);
    L21:
        if (r20 == true) goto L23;
        writeInt(r3, r10);
    L23:
        int r4 = this.bb.writePosition();
        int r11 = r9;
    L25:
        if (r11 >= this.stack.size()) goto L27;
        writeAny((Value) ZeusTransformUtils.preCheckCast(this.stack.get(r11), Value.class, "com.obric.memorydata.plugin"), r10);
        r11 = r11 + 1;
        goto L25
    L27:
        if (r19 == true) goto L32;
    L29:
        if (r9 >= this.stack.size()) goto L32;
        this.bb.put(Value.access$400((Value) ZeusTransformUtils.preCheckCast(this.stack.get(r9), Value.class, "com.obric.memorydata.plugin"), r12));
        r9 = r9 + 1;
    L32:
        if (r21 == null) goto L35;
        int r1 = 9;
    L42:
        return new Value(r16, r1, r12, r4);
    L35:
        if (r19 == false) goto L40;
        if (r20 == true) goto L39;
        r2 = 0;
    L39:
        r1 = FlexBuffers.toTypedVector(r8, r2);
        goto L42
    L40:
        r1 = 10;
        goto L42
    L5:
        r7 = 1;
        goto L6
    }

    private int putKey(String r6) {
        if (r6 != null) goto L5;
        return -1;
    L5:
        int r0 = this.bb.writePosition();
        if ((this.flags & 1) == 0) goto L11;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.keyPool.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L14;
        byte[] r2 = r6.getBytes(StandardCharsets.UTF_8);
        this.bb.put(r2, 0, r2.length);
    L12:
        this.bb.put((byte) 0);
        this.keyPool.put(r6, Integer.valueOf(r0));
        return r0;
    L14:
        return r1.intValue();
    L11:
        byte[] r3 = r6.getBytes(StandardCharsets.UTF_8);
        this.bb.put(r3, 0, r3.length);
        goto L12
    }

    private void putUInt(String r3, long r4) {
        int r5 = putKey(r3);
        int r0 = widthUInBits(r4);
        if (r0 != 0) goto L6;
        Value r6 = Value.uInt8(r5, (int) r4);
    L12:
        this.stack.add(r6);
        return;
    L6:
        if (r0 != 1) goto L9;
        r6 = Value.uInt16(r5, (int) r4);
        goto L12
    L9:
        if (r0 != 2) goto L11;
        r6 = Value.uInt32(r5, (int) r4);
        goto L12
    L11:
        r6 = Value.uInt64(r5, r4);
        goto L12
    }

    private void putUInt64(String r2, long r3) {
        this.stack.add(Value.uInt64(putKey(r2), r3));
    }

    static int widthUInBits(long r3) {
        if (r3 > FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) goto L7;
        return 0;
    L7:
        if (r3 > FlexBuffers.Unsigned.shortToUnsignedInt(-1)) goto L11;
        return 1;
    L11:
        if (r3 > FlexBuffers.Unsigned.intToUnsignedLong(-1)) goto L14;
        return 2;
    L14:
        return 3;
    }

    private void writeAny(Value r3, int r4) {
        int r0 = r3.type;
        if (r0 != 0) goto L5;
    L14:
        writeInt(r3.iValue, r4);
        return;
    L5:
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L14;
        if (r0 != 3) goto L11;
        writeDouble(r3.dValue, r4);
        return;
    L11:
        if (r0 == 26) goto L14;
        writeOffset(r3.iValue, r4);
    }

    private Value writeBlob(int r6, byte[] r7, int r8, boolean r9) {
        int r0 = widthUInBits(r7.length);
        writeInt(r7.length, align(r0));
        int r1 = this.bb.writePosition();
        this.bb.put(r7, 0, r7.length);
        if (r9 == false) goto L6;
        this.bb.put((byte) 0);
    L6:
        return Value.blob(r6, r1, r8, r0);
    }

    private void writeDouble(double r2, int r4) {
        if (r4 != 4) goto L6;
        this.bb.putFloat((float) r2);
        return;
    L6:
        if (r4 != 8) goto L10;
        this.bb.putDouble(r2);
        return;
    }

    private void writeInt(long r2, int r4) {
        if (r4 != 1) goto L5;
        this.bb.put((byte) r2);
        return;
    L5:
        if (r4 != 2) goto L7;
        this.bb.putShort((short) r2);
        return;
    L7:
        if (r4 != 4) goto L9;
        this.bb.putInt((int) r2);
        return;
    L9:
        if (r4 != 8) goto L19;
        this.bb.putLong(r2);
        return;
    }

    private void writeOffset(long r3, int r5) {
        writeInt((int) (((long) this.bb.writePosition()) - r3), r5);
    }

    private Value writeString(int r3, String r4) {
        return writeBlob(r3, r4.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String r8, int r9) {
        int r1 = putKey(r8);
        ArrayList<Value> r10 = this.stack;
        Collections.sort(r10.subList(r9, r10.size()), this.keyComparator);
        Value r11 = createVector(r1, r9, this.stack.size() - r9, false, false, createKeyVector(r9, this.stack.size() - r9));
    L4:
        if (this.stack.size() <= r9) goto L6;
        ArrayList<Value> r0 = this.stack;
        r0.remove(r0.size() - 1);
        goto L4
    L6:
        this.stack.add(r11);
        return (int) r11.iValue;
    }

    public int endVector(String r8, int r9, boolean r10, boolean r11) {
        Value r12 = createVector(putKey(r8), r9, this.stack.size() - r9, r10, r11, null);
    L4:
        if (this.stack.size() <= r9) goto L6;
        ArrayList<Value> r13 = this.stack;
        r13.remove(r13.size() - 1);
        goto L4
    L6:
        this.stack.add(r12);
        return (int) r12.iValue;
    }

    public ByteBuffer finish() {
        int r0 = align(Value.access$200((Value) ZeusTransformUtils.preCheckCast(this.stack.get(0), Value.class, "com.obric.memorydata.plugin"), this.bb.writePosition(), 0));
        writeAny((Value) ZeusTransformUtils.preCheckCast(this.stack.get(0), Value.class, "com.obric.memorydata.plugin"), r0);
        this.bb.put(Value.access$300((Value) ZeusTransformUtils.preCheckCast(this.stack.get(0), Value.class, "com.obric.memorydata.plugin")));
        this.bb.put((byte) r0);
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public int putBlob(String r3, byte[] r4) {
        Value r5 = writeBlob(putKey(r3), r4, 25, false);
        this.stack.add(r5);
        return (int) r5.iValue;
    }

    public int putBlob(byte[] r2) {
        return putBlob(null, r2);
    }

    public void putBoolean(String r2, boolean r3) {
        this.stack.add(Value.bool(putKey(r2), r3));
    }

    public void putBoolean(boolean r2) {
        putBoolean(null, r2);
    }

    public void putFloat(double r2) {
        putFloat(null, r2);
    }

    public void putFloat(float r2) {
        putFloat(null, r2);
    }

    public void putFloat(String r2, double r3) {
        this.stack.add(Value.float64(putKey(r2), r3));
    }

    public void putFloat(String r2, float r3) {
        this.stack.add(Value.float32(putKey(r2), r3));
    }

    public void putInt(int r2) {
        putInt(null, r2);
    }

    public void putInt(long r2) {
        putInt(null, r2);
    }

    public void putInt(String r3, int r4) {
        putInt(r3, r4);
    }

    public void putInt(String r3, long r4) {
        int r5 = putKey(r3);
        if ((-128) > r4) goto L9;
        if (r4 > 127) goto L9;
        ArrayList<Value> r2 = this.stack;
        Value r6 = Value.int8(r5, (int) r4);
    L7:
        r2.add(r6);
        return;
    L9:
        if ((-32768) > r4) goto L14;
        if (r4 > 32767) goto L14;
        r2 = this.stack;
        r6 = Value.int16(r5, (int) r4);
    L14:
        if ((-2147483648L) <= r4) goto L16;
    L18:
        r2 = this.stack;
        r6 = Value.int64(r5, r4);
        goto L7
    L16:
        if (r4 > 2147483647L) goto L18;
        r2 = this.stack;
        r6 = Value.int32(r5, (int) r4);
        goto L7
    }

    public int putString(String r2) {
        return putString(null, r2);
    }

    public int putString(String r4, String r5) {
        int r6 = putKey(r4);
        if ((this.flags & 2) == 0) goto L10;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.stringPool.get(r5), Integer.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        Value r7 = writeString(r6, r5);
        this.stringPool.put(r5, Integer.valueOf((int) r7.iValue));
        this.stack.add(r7);
        return (int) r7.iValue;
    L8:
        this.stack.add(Value.blob(r6, r0.intValue(), 5, widthUInBits(r5.length())));
        return r0.intValue();
    L10:
        Value r8 = writeString(r6, r5);
        this.stack.add(r8);
        return (int) r8.iValue;
    }

    public void putUInt(int r3) {
        putUInt(null, r3);
    }

    public void putUInt(long r2) {
        putUInt(null, r2);
    }

    public void putUInt64(BigInteger r3) {
        putUInt64(null, r3.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }
}
