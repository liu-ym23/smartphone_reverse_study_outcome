package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.msgpack.core.Preconditions;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes7.dex */
public class MessageBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ARRAY_BYTE_BASE_OFFSET = 0;
    private static final String BIGENDIAN_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBufferBE";
    private static final String DEFAULT_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBuffer";
    private static final String UNIVERSAL_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBufferU";
    static final boolean isUniversalBuffer = false;
    static final int javaVersion = 0;
    private static final Constructor<?> mbArrConstructor = null;
    private static final Constructor<?> mbBBConstructor = null;
    static final Unsafe unsafe = null;
    protected final long address;
    protected final Object base;
    protected final ByteBuffer reference;
    protected final int size;

    static {
        String r1 = BIGENDIAN_MESSAGE_BUFFER;
        String r2 = UNIVERSAL_MESSAGE_BUFFER;
        javaVersion = getJavaVersion();
        int r6 = 16;
        if (ZeusTransformUtils.forName("sun.misc.Unsafe", "com.obric.memorydata.plugin") == null) goto L8;
        boolean r0 = true;
    L92:
        boolean r12 = System.getProperty("java.runtime.name", "").toLowerCase().contains("android");     // Catch: Throwable -> L6 Exception -> L59
        if (System.getProperty("com.google.appengine.runtime.version") == null) goto L12;
        boolean r13 = true;
    L14:
        if (Boolean.parseBoolean(System.getProperty("msgpack.universal-buffer", "false")) == true) goto L23;
        if (r12 == true) goto L23;
        if (r13 == true) goto L23;
    L19:
        if (javaVersion < 7) goto L23;
        if (r0 == false) goto L23;
        boolean r14 = false;
    L24:
        if (r14 == false) goto L101;
        Unsafe r15 = null;
    L41:
        unsafe = r15;
        ARRAY_BYTE_BASE_OFFSET = r6;
        isUniversalBuffer = r14;
        if (r14 == true) goto L52;
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) goto L47;
        boolean r3 = true;
    L48:
        if (r3 == false) goto L50;
        r1 = DEFAULT_MESSAGE_BUFFER;
    L50:
        r2 = r1;
        goto L52
    L47:
        r3 = false;
    L52:
        if (DEFAULT_MESSAGE_BUFFER.equals(r2) == false) goto L99;
    L53:
        mbArrConstructor = null;
        mbBBConstructor = null;
        return;
    L99:
        Class r4 = ZeusTransformUtils.forName(r2, "com.obric.memorydata.plugin");     // Catch: Exception -> L56
        Constructor<?> r5 = r4.getDeclaredConstructor(new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L56
        r5.setAccessible(true);     // Catch: Exception -> L56
        mbArrConstructor = r5;     // Catch: Exception -> L56
        Constructor<?> r7 = r4.getDeclaredConstructor(new Class[]{ByteBuffer.class});     // Catch: Exception -> L56
        r7.setAccessible(true);     // Catch: Exception -> L56
        mbBBConstructor = r7;     // Catch: Exception -> L56
        return;
    L56:
        e = move-exception;
        e.printStackTrace(System.err);
        throw new RuntimeException(e);
    L101:
        Field r8 = Unsafe.class.getDeclaredField("theUnsafe");     // Catch: Throwable -> L36 Exception -> L38
        r8.setAccessible(true);     // Catch: Throwable -> L36 Exception -> L38
        r15 = (Unsafe) ZeusTransformUtils.preCheckCast(r8.get(null), Unsafe.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36 Exception -> L38
        if (r15 == null) goto L33;
        r6 = r15.arrayBaseOffset(byte[].class);     // Catch: Exception -> L34 Throwable -> L70
        int r9 = r15.arrayIndexScale(byte[].class);     // Catch: Exception -> L34 Throwable -> L70
        if (r9 == 1) goto L41;
        throw new IllegalStateException("Byte array index scale must be 1, but is " + r9);     // Catch: Exception -> L34 Throwable -> L70
    L33:
        throw new RuntimeException("Unsafe is unavailable");     // Catch: Exception -> L34 Throwable -> L70
    L34:
        e = e;
    L61:
        e.printStackTrace(System.err);     // Catch: Throwable -> L70
        unsafe = r15;
        ARRAY_BYTE_BASE_OFFSET = 16;
        isUniversalBuffer = true;
        if (DEFAULT_MESSAGE_BUFFER.equals(UNIVERSAL_MESSAGE_BUFFER) == true) goto L53;
        Class r10 = ZeusTransformUtils.forName(UNIVERSAL_MESSAGE_BUFFER, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
        Constructor<?> r11 = r10.getDeclaredConstructor(new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L67
        r11.setAccessible(true);     // Catch: Exception -> L67
        mbArrConstructor = r11;     // Catch: Exception -> L67
        Constructor<?> r16 = r10.getDeclaredConstructor(new Class[]{ByteBuffer.class});     // Catch: Exception -> L67
        r16.setAccessible(true);     // Catch: Exception -> L67
        mbBBConstructor = r16;     // Catch: Exception -> L67
        return;
    L67:
        e = move-exception;
        e.printStackTrace(System.err);
        throw new RuntimeException(e);
    L38:
        e = e;
        r15 = null;
    L36:
        th = th;
    L71:
        unsafe = 0;
        ARRAY_BYTE_BASE_OFFSET = 16;
        isUniversalBuffer = r14;
        if (r14 == true) goto L82;
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) goto L77;
        boolean r17 = true;
    L78:
        if (r17 == false) goto L80;
        r1 = DEFAULT_MESSAGE_BUFFER;
    L80:
        r2 = r1;
        goto L82
    L77:
        r17 = false;
    L82:
        if (DEFAULT_MESSAGE_BUFFER.equals(r2) == false) goto L96;
        mbArrConstructor = null;
        mbBBConstructor = null;
    L85:
        throw th;
    L96:
        Class r18 = ZeusTransformUtils.forName(r2, "com.obric.memorydata.plugin");     // Catch: Exception -> L86
        Constructor<?> r19 = r18.getDeclaredConstructor(new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L86
        r19.setAccessible(true);     // Catch: Exception -> L86
        mbArrConstructor = r19;     // Catch: Exception -> L86
        Constructor<?> r20 = r18.getDeclaredConstructor(new Class[]{ByteBuffer.class});     // Catch: Exception -> L86
        r20.setAccessible(true);     // Catch: Exception -> L86
        mbBBConstructor = r20;     // Catch: Exception -> L86
    L86:
        e = move-exception;
        e.printStackTrace(System.err);
        throw new RuntimeException(e);
    L23:
        r14 = true;
        goto L24
    L12:
        r13 = false;
    L59:
        e = e;
        r15 = null;
    L70:
        th = th;
    L6:
        th = th;
        r14 = false;
    L8:
        r0 = false;
        goto L92
    }

    public MessageBuffer(Object r1, long r2, int r4) {
        this.base = r1;
        this.address = r2;
        this.size = r4;
        this.reference = null;
    }

    MessageBuffer(ByteBuffer r5) {
        if (r5.isDirect() == false) goto L10;
        boolean r0 = isUniversalBuffer;
        this.base = null;
        if (r0 == false) goto L8;
        this.address = 0;
        this.size = r5.remaining();
        this.reference = null;
        return;
    L8:
        this.address = DirectBufferAccess.getAddress(r5) + ((long) r5.position());
        this.size = r5.remaining();
        this.reference = r5;
        return;
    L10:
        if (r5.hasArray() == false) goto L14;
        this.base = r5.array();
        this.address = (ARRAY_BYTE_BASE_OFFSET + r5.arrayOffset()) + r5.position();
        this.size = r5.remaining();
        this.reference = null;
        return;
    L14:
        throw new IllegalArgumentException("Only the array-backed ByteBuffer or DirectBuffer is supported");
    }

    MessageBuffer(byte[] r1, int r2, int r3) {
        this.base = r1;
        this.address = ARRAY_BYTE_BASE_OFFSET + r2;
        this.size = r3;
        this.reference = null;
    }

    public static MessageBuffer allocate(int r1) {
        if (r1 < 0) goto L6;
        return wrap(new byte[r1]);
    L6:
        throw new IllegalArgumentException("size must not be negative");
    }

    private static int getJavaVersion() {
        String r0 = System.getProperty("java.specification.version", "");
        int r1 = r0.indexOf(46);
        if (r1 == (-1)) goto L11;
        int r2 = Integer.parseInt(r0.substring(0, r1));     // Catch: NumberFormatException -> L12
        int r3 = Integer.parseInt(r0.substring(r1 + 1));     // Catch: NumberFormatException -> L12
        if (r2 <= 1) goto L9;
        return r2;
    L9:
        return r3;
    L11:
        return Integer.parseInt(r0);
    L12:
        e = move-exception;
        e.printStackTrace(System.err);
        return 6;
    }

    private static MessageBuffer newInstance(Constructor<?> r2, Object... r3) {
        return (MessageBuffer) ZeusTransformUtils.preCheckCast(r2.newInstance(r3), MessageBuffer.class, "com.obric.memorydata.plugin");
    L16:
        e = move-exception;
        throw new IllegalStateException(e);
    L19:
        e = move-exception;
        throw new IllegalStateException(e);
    L5:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), RuntimeException.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(e.getCause(), Error.class) == false) goto L13;
        throw ((Error) ZeusTransformUtils.preCheckCast(e.getCause(), Error.class, "com.obric.memorydata.plugin"));
    L13:
        throw new IllegalStateException(e.getCause());
    L15:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(e.getCause(), RuntimeException.class, "com.obric.memorydata.plugin"));
    }

    private static MessageBuffer newMessageBuffer(ByteBuffer r3) {
        Preconditions.checkNotNull(r3);
        Constructor<?> r0 = mbBBConstructor;
        if (r0 == null) goto L7;
        return newInstance(r0, new Object[]{r3});
    L7:
        return new MessageBuffer(r3);
    }

    private static MessageBuffer newMessageBuffer(byte[] r3, int r4, int r5) {
        Preconditions.checkNotNull(r3);
        Constructor<?> r0 = mbArrConstructor;
        if (r0 == null) goto L7;
        return newInstance(r0, new Object[]{r3, Integer.valueOf(r4), Integer.valueOf(r5)});
    L7:
        return new MessageBuffer(r3, r4, r5);
    }

    public static void releaseBuffer(MessageBuffer r3) {
        if (isUniversalBuffer == false) goto L5;
        return;
    L5:
        if (r3.hasArray() == false) goto L8;
        return;
    L8:
        if (DirectBufferAccess.isDirectByteBufferInstance(r3.reference) == false) goto L10;
        DirectBufferAccess.clean(r3.reference);
        return;
    L10:
        unsafe.freeMemory(r3.address);
    }

    public static MessageBuffer wrap(ByteBuffer r0) {
        return newMessageBuffer(r0);
    }

    public static MessageBuffer wrap(byte[] r2) {
        return newMessageBuffer(r2, 0, r2.length);
    }

    public static MessageBuffer wrap(byte[] r0, int r1, int r2) {
        return newMessageBuffer(r0, r1, r2);
    }

    public byte[] array() {
        return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this.base, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
    }

    public int arrayOffset() {
        return ((int) this.address) - ARRAY_BYTE_BASE_OFFSET;
    }

    public void copyTo(int r10, MessageBuffer r11, int r12, int r13) {
        unsafe.copyMemory(this.base, this.address + ((long) r10), r11.base, r11.address + ((long) r12), r13);
    }

    public boolean getBoolean(int r5) {
        return unsafe.getBoolean(this.base, this.address + ((long) r5));
    }

    public byte getByte(int r5) {
        return unsafe.getByte(this.base, this.address + ((long) r5));
    }

    public void getBytes(int r2, int r3, ByteBuffer r4) {
        if (r4.remaining() < r3) goto L7;
        r4.put(sliceAsByteBuffer(r2, r3));
        return;
    L7:
        throw new BufferOverflowException();
    }

    public void getBytes(int r10, byte[] r11, int r12, int r13) {
        unsafe.copyMemory(this.base, this.address + ((long) r10), r11, ARRAY_BYTE_BASE_OFFSET + r12, r13);
    }

    public double getDouble(int r1) {
        return Double.longBitsToDouble(getLong(r1));
    }

    public float getFloat(int r1) {
        return Float.intBitsToFloat(getInt(r1));
    }

    public int getInt(int r5) {
        return Integer.reverseBytes(unsafe.getInt(this.base, this.address + ((long) r5)));
    }

    public long getLong(int r5) {
        return Long.reverseBytes(unsafe.getLong(this.base, this.address + ((long) r5)));
    }

    public short getShort(int r5) {
        return Short.reverseBytes(unsafe.getShort(this.base, this.address + ((long) r5)));
    }

    public boolean hasArray() {
        if (this.base == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void putBoolean(int r5, boolean r6) {
        unsafe.putBoolean(this.base, this.address + ((long) r5), r6);
    }

    public void putByte(int r5, byte r6) {
        unsafe.putByte(this.base, this.address + ((long) r5), r6);
    }

    public void putByteBuffer(int r12, ByteBuffer r13, int r14) {
        if (r13.isDirect() == false) goto L7;
        Unsafe r2 = unsafe;
        byte[] r3 = null;
        long r4 = ((long) r13.position()) + DirectBufferAccess.getAddress(r13);
    L5:
        r2.copyMemory(r3, r4, this.base, this.address + ((long) r12), r14);
        r13.position(r13.position() + r14);
        return;
    L7:
        if (r13.hasArray() == false) goto L10;
        r3 = r13.array();
        r2 = unsafe;
        r4 = ARRAY_BYTE_BASE_OFFSET + r13.position();
        goto L5
    L10:
        if (hasArray() == false) goto L12;
        r13.get((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this.base, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"), r12, r14);
        return;
    L12:
        int r0 = 0;
    L13:
        if (r0 >= r14) goto L18;
        unsafe.putByte(this.base, this.address + ((long) r12), r13.get());
        r0 = r0 + 1;
        goto L13
    }

    public void putBytes(int r10, byte[] r11, int r12, int r13) {
        unsafe.copyMemory(r11, ARRAY_BYTE_BASE_OFFSET + r12, this.base, this.address + ((long) r10), r13);
    }

    public void putDouble(int r1, double r2) {
        putLong(r1, Double.doubleToRawLongBits(r2));
    }

    public void putFloat(int r1, float r2) {
        putInt(r1, Float.floatToRawIntBits(r2));
    }

    public void putInt(int r5, int r6) {
        int r7 = Integer.reverseBytes(r6);
        unsafe.putInt(this.base, this.address + ((long) r5), r7);
    }

    public void putLong(int r7, long r8) {
        long r4 = Long.reverseBytes(r8);
        unsafe.putLong(this.base, this.address + ((long) r7), r4);
    }

    public void putMessageBuffer(int r10, MessageBuffer r11, int r12, int r13) {
        unsafe.copyMemory(r11.base, r11.address + ((long) r12), this.base, this.address + ((long) r10), r13);
    }

    public void putShort(int r5, short r6) {
        short r7 = Short.reverseBytes(r6);
        unsafe.putShort(this.base, this.address + ((long) r5), r7);
    }

    public int size() {
        return this.size;
    }

    public MessageBuffer slice(int r5, int r6) {
        if (r5 != 0) goto L7;
        if (r6 != size()) goto L7;
        return this;
    L7:
        if ((r5 + r6) > size()) goto L9;
        boolean r0 = true;
    L10:
        Preconditions.checkArgument(r0);
        return new MessageBuffer(this.base, this.address + ((long) r5), r6);
    L9:
        r0 = false;
        goto L10
    }

    public ByteBuffer sliceAsByteBuffer() {
        return sliceAsByteBuffer(0, size());
    }

    public ByteBuffer sliceAsByteBuffer(int r6, int r7) {
        if (hasArray() == false) goto L7;
        return ByteBuffer.wrap((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this.base, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"), (int) ((this.address - ((long) ARRAY_BYTE_BASE_OFFSET)) + ((long) r6)), r7);
    L7:
        return DirectBufferAccess.newByteBuffer(this.address, r6, r7, this.reference);
    }

    public byte[] toByteArray() {
        byte[] r0 = new byte[size()];
        unsafe.copyMemory(this.base, this.address, r0, ARRAY_BYTE_BASE_OFFSET, size());
        return r0;
    }

    public String toHexString(int r6, int r7) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6;
    L3:
        if (r1 >= r7) goto L8;
        if (r1 == r6) goto L6;
        r0.append(" ");
    L6:
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(getByte(r1))}));
        r1 = r1 + 1;
        goto L3
    L8:
        return r0.toString();
    }
}
