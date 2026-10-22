package org.msgpack.core.buffer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.msgpack.core.Preconditions;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
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
        String r10 = BIGENDIAN_MESSAGE_BUFFER;
        String r11 = UNIVERSAL_MESSAGE_BUFFER;
        javaVersion = getJavaVersion();
        int r12 = 16;
        Class.forName("sun.misc.Unsafe");     // Catch: Throwable -> L5 Exception -> L7
        boolean r13 = true;
    L90:
        boolean r14 = System.getProperty("java.runtime.name", "").toLowerCase().contains("android");     // Catch: Throwable -> L5 Exception -> L58
        if (System.getProperty("com.google.appengine.runtime.version") == null) goto L11;
        boolean r15 = true;
    L13:
        if (Boolean.parseBoolean(System.getProperty("msgpack.universal-buffer", "false")) == true) goto L22;
        if (r14 == true) goto L22;
        if (r15 == true) goto L22;
    L18:
        if (javaVersion < 7) goto L22;
        if (r13 == false) goto L22;
        boolean r16 = false;
    L23:
        if (r16 == false) goto L99;
        Unsafe r17 = null;
    L40:
        unsafe = r17;
        ARRAY_BYTE_BASE_OFFSET = r12;
        isUniversalBuffer = r16;
        if (r16 == true) goto L51;
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) goto L46;
        boolean r18 = true;
    L47:
        if (r18 == false) goto L49;
        r10 = DEFAULT_MESSAGE_BUFFER;
    L49:
        r11 = r10;
        goto L51
    L46:
        r18 = false;
    L51:
        if (DEFAULT_MESSAGE_BUFFER.equals(r11) == false) goto L96;
    L52:
        mbArrConstructor = null;
        mbBBConstructor = null;
        return;
    L96:
        Class<?> r19 = Class.forName(r11);     // Catch: Exception -> L55
        Class<?> r20 = Integer.TYPE;     // Catch: Exception -> L55
        Constructor<?> r21 = r19.getDeclaredConstructor(new Class[]{byte[].class, r20, r20});     // Catch: Exception -> L55
        r21.setAccessible(true);     // Catch: Exception -> L55
        mbArrConstructor = r21;     // Catch: Exception -> L55
        Constructor<?> r22 = r19.getDeclaredConstructor(new Class[]{ByteBuffer.class});     // Catch: Exception -> L55
        r22.setAccessible(true);     // Catch: Exception -> L55
        mbBBConstructor = r22;     // Catch: Exception -> L55
        return;
    L55:
        e = move-exception;
        e.printStackTrace(System.err);
        throw new RuntimeException(e);
    L99:
        Field r23 = Unsafe.class.getDeclaredField("theUnsafe");     // Catch: Throwable -> L35 Exception -> L37
        r23.setAccessible(true);     // Catch: Throwable -> L35 Exception -> L37
        r17 = (Unsafe) r23.get(null);     // Catch: Throwable -> L35 Exception -> L37
        if (r17 == null) goto L32;
        r12 = r17.arrayBaseOffset(byte[].class);     // Catch: Exception -> L33 Throwable -> L69
        int r24 = r17.arrayIndexScale(byte[].class);     // Catch: Exception -> L33 Throwable -> L69
        if (r24 == 1) goto L40;
        throw new IllegalStateException("Byte array index scale must be 1, but is " + r24);     // Catch: Exception -> L33 Throwable -> L69
    L32:
        throw new RuntimeException("Unsafe is unavailable");     // Catch: Exception -> L33 Throwable -> L69
    L33:
        e = e;
    L60:
        e.printStackTrace(System.err);     // Catch: Throwable -> L69
        unsafe = r17;
        ARRAY_BYTE_BASE_OFFSET = 16;
        isUniversalBuffer = true;
        if (DEFAULT_MESSAGE_BUFFER.equals(UNIVERSAL_MESSAGE_BUFFER) == true) goto L52;
        Class<?> r25 = Class.forName(UNIVERSAL_MESSAGE_BUFFER);     // Catch: Exception -> L66
        Class<?> r26 = Integer.TYPE;     // Catch: Exception -> L66
        Constructor<?> r27 = r25.getDeclaredConstructor(new Class[]{byte[].class, r26, r26});     // Catch: Exception -> L66
        r27.setAccessible(true);     // Catch: Exception -> L66
        mbArrConstructor = r27;     // Catch: Exception -> L66
        Constructor<?> r28 = r25.getDeclaredConstructor(new Class[]{ByteBuffer.class});     // Catch: Exception -> L66
        r28.setAccessible(true);     // Catch: Exception -> L66
        mbBBConstructor = r28;     // Catch: Exception -> L66
        return;
    L66:
        e = move-exception;
        e.printStackTrace(System.err);
        throw new RuntimeException(e);
    L37:
        e = e;
        r17 = null;
    L35:
        th = th;
    L70:
        unsafe = 0;
        ARRAY_BYTE_BASE_OFFSET = 16;
        isUniversalBuffer = r16;
        if (r16 == true) goto L81;
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) goto L76;
        boolean r29 = true;
    L77:
        if (r29 == false) goto L79;
        r10 = DEFAULT_MESSAGE_BUFFER;
    L79:
        r11 = r10;
        goto L81
    L76:
        r29 = false;
    L81:
        if (DEFAULT_MESSAGE_BUFFER.equals(r11) == false) goto L88;
        mbArrConstructor = null;
        mbBBConstructor = null;
    L84:
        throw th;
    L88:
        Class<?> r30 = Class.forName(r11);     // Catch: Exception -> L85
        Class<?> r31 = Integer.TYPE;     // Catch: Exception -> L85
        Constructor<?> r32 = r30.getDeclaredConstructor(new Class[]{byte[].class, r31, r31});     // Catch: Exception -> L85
        r32.setAccessible(true);     // Catch: Exception -> L85
        mbArrConstructor = r32;     // Catch: Exception -> L85
        Constructor<?> r33 = r30.getDeclaredConstructor(new Class[]{ByteBuffer.class});     // Catch: Exception -> L85
        r33.setAccessible(true);     // Catch: Exception -> L85
        mbBBConstructor = r33;     // Catch: Exception -> L85
    L85:
        e = move-exception;
        e.printStackTrace(System.err);
        throw new RuntimeException(e);
    L22:
        r16 = true;
        goto L23
    L11:
        r15 = false;
    L58:
        e = e;
        r17 = null;
    L69:
        th = th;
    L5:
        th = th;
        r16 = false;
    L7:
        r13 = false;
        goto L90
    }

    protected MessageBuffer(Object r10, long r11, int r12) {
        this.base = r10;
        this.address = r11;
        this.size = r12;
        this.reference = null;
    }

    MessageBuffer(ByteBuffer r10) {
        if (r10.isDirect() == false) goto L10;
        boolean r11 = isUniversalBuffer;
        this.base = null;
        if (r11 == false) goto L8;
        this.address = 0;
        this.size = r10.remaining();
        this.reference = null;
        return;
    L8:
        this.address = DirectBufferAccess.getAddress(r10) + ((long) r10.position());
        this.size = r10.remaining();
        this.reference = r10;
        return;
    L10:
        if (r10.hasArray() == false) goto L14;
        this.base = r10.array();
        this.address = (ARRAY_BYTE_BASE_OFFSET + r10.arrayOffset()) + r10.position();
        this.size = r10.remaining();
        this.reference = null;
        return;
    L14:
        throw new IllegalArgumentException("Only the array-backed ByteBuffer or DirectBuffer is supported");
    }

    MessageBuffer(byte[] r10, int r11, int r12) {
        this.base = r10;
        this.address = ARRAY_BYTE_BASE_OFFSET + r11;
        this.size = r12;
        this.reference = null;
    }

    public static MessageBuffer allocate(int r10) {
        if (r10 < 0) goto L6;
        return wrap(new byte[r10]);
    L6:
        throw new IllegalArgumentException("size must not be negative");
    }

    private static int getJavaVersion() {
        String r10 = System.getProperty("java.specification.version", "");
        int r11 = r10.indexOf(46);
        if (r11 == (-1)) goto L11;
        int r12 = Integer.parseInt(r10.substring(0, r11));     // Catch: NumberFormatException -> L12
        int r13 = Integer.parseInt(r10.substring(r11 + 1));     // Catch: NumberFormatException -> L12
        if (r12 <= 1) goto L9;
        return r12;
    L9:
        return r13;
    L11:
        return Integer.parseInt(r10);
    L12:
        e = move-exception;
        e.printStackTrace(System.err);
        return 6;
    }

    private static MessageBuffer newInstance(Constructor<?> r10, Object... r11) {
        return (MessageBuffer) r10.newInstance(r11);
    L15:
        e = move-exception;
        throw new IllegalStateException(e);
    L18:
        e = move-exception;
        throw new IllegalStateException(e);
    L4:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == true) goto L14;
        if ((e.getCause() instanceof Error) == false) goto L12;
        throw ((Error) e.getCause());
    L12:
        throw new IllegalStateException(e.getCause());
    L14:
        throw ((RuntimeException) e.getCause());
    }

    private static MessageBuffer newMessageBuffer(ByteBuffer r10) {
        Preconditions.checkNotNull(r10);
        Constructor<?> r11 = mbBBConstructor;
        if (r11 == null) goto L7;
        return newInstance(r11, new Object[]{r10});
    L7:
        return new MessageBuffer(r10);
    }

    private static MessageBuffer newMessageBuffer(byte[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Constructor<?> r13 = mbArrConstructor;
        if (r13 == null) goto L7;
        return newInstance(r13, new Object[]{r10, Integer.valueOf(r11), Integer.valueOf(r12)});
    L7:
        return new MessageBuffer(r10, r11, r12);
    }

    public static void releaseBuffer(MessageBuffer r10) {
        if (isUniversalBuffer == false) goto L5;
        return;
    L5:
        if (r10.hasArray() == false) goto L8;
        return;
    L8:
        if (DirectBufferAccess.isDirectByteBufferInstance(r10.reference) == false) goto L10;
        DirectBufferAccess.clean(r10.reference);
        return;
    L10:
        unsafe.freeMemory(r10.address);
    }

    public static MessageBuffer wrap(ByteBuffer r10) {
        return newMessageBuffer(r10);
    }

    public static MessageBuffer wrap(byte[] r10) {
        return newMessageBuffer(r10, 0, r10.length);
    }

    public static MessageBuffer wrap(byte[] r10, int r11, int r12) {
        return newMessageBuffer(r10, r11, r12);
    }

    public byte[] array() {
        return (byte[]) this.base;
    }

    public int arrayOffset() {
        return ((int) this.address) - ARRAY_BYTE_BASE_OFFSET;
    }

    public void copyTo(int r10, MessageBuffer r11, int r12, int r13) {
        unsafe.copyMemory(this.base, this.address + ((long) r10), r11.base, r11.address + ((long) r12), r13);
    }

    public boolean getBoolean(int r10) {
        return unsafe.getBoolean(this.base, this.address + ((long) r10));
    }

    public byte getByte(int r10) {
        return unsafe.getByte(this.base, this.address + ((long) r10));
    }

    public void getBytes(int r10, int r11, ByteBuffer r12) {
        if (r12.remaining() < r11) goto L7;
        r12.put(sliceAsByteBuffer(r10, r11));
        return;
    L7:
        throw new BufferOverflowException();
    }

    public void getBytes(int r10, byte[] r11, int r12, int r13) {
        unsafe.copyMemory(this.base, this.address + ((long) r10), r11, ARRAY_BYTE_BASE_OFFSET + r12, r13);
    }

    public double getDouble(int r10) {
        return Double.longBitsToDouble(getLong(r10));
    }

    public float getFloat(int r10) {
        return Float.intBitsToFloat(getInt(r10));
    }

    public int getInt(int r10) {
        return Integer.reverseBytes(unsafe.getInt(this.base, this.address + ((long) r10)));
    }

    public long getLong(int r10) {
        return Long.reverseBytes(unsafe.getLong(this.base, this.address + ((long) r10)));
    }

    public short getShort(int r10) {
        return Short.reverseBytes(unsafe.getShort(this.base, this.address + ((long) r10)));
    }

    public boolean hasArray() {
        if (this.base == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void putBoolean(int r10, boolean r11) {
        unsafe.putBoolean(this.base, this.address + ((long) r10), r11);
    }

    public void putByte(int r10, byte r11) {
        unsafe.putByte(this.base, this.address + ((long) r10), r11);
    }

    public void putByteBuffer(int r11, ByteBuffer r12, int r13) {
        if (r12.isDirect() == false) goto L7;
        Unsafe r10 = unsafe;
        byte[] r14 = null;
        long r15 = DirectBufferAccess.getAddress(r12) + ((long) r12.position());
    L5:
        r10.copyMemory(r14, r15, this.base, this.address + ((long) r11), r13);
        r12.position(r12.position() + r13);
        return;
    L7:
        if (r12.hasArray() == false) goto L10;
        r14 = r12.array();
        r10 = unsafe;
        r15 = ARRAY_BYTE_BASE_OFFSET + r12.position();
        goto L5
    L10:
        if (hasArray() == false) goto L12;
        r12.get((byte[]) this.base, r11, r13);
        return;
    L12:
        int r16 = 0;
    L13:
        if (r16 >= r13) goto L18;
        unsafe.putByte(this.base, this.address + ((long) r11), r12.get());
        r16 = r16 + 1;
        goto L13
    }

    public void putBytes(int r10, byte[] r11, int r12, int r13) {
        unsafe.copyMemory(r11, ARRAY_BYTE_BASE_OFFSET + r12, this.base, this.address + ((long) r10), r13);
    }

    public void putDouble(int r10, double r11) {
        putLong(r10, Double.doubleToRawLongBits(r11));
    }

    public void putFloat(int r10, float r11) {
        putInt(r10, Float.floatToRawIntBits(r11));
    }

    public void putInt(int r10, int r11) {
        int r12 = Integer.reverseBytes(r11);
        unsafe.putInt(this.base, this.address + ((long) r10), r12);
    }

    public void putLong(int r10, long r11) {
        long r12 = Long.reverseBytes(r11);
        unsafe.putLong(this.base, this.address + ((long) r10), r12);
    }

    public void putMessageBuffer(int r10, MessageBuffer r11, int r12, int r13) {
        unsafe.copyMemory(r11.base, r11.address + ((long) r12), this.base, this.address + ((long) r10), r13);
    }

    public void putShort(int r10, short r11) {
        short r12 = Short.reverseBytes(r11);
        unsafe.putShort(this.base, this.address + ((long) r10), r12);
    }

    public int size() {
        return this.size;
    }

    public MessageBuffer slice(int r10, int r11) {
        if (r10 != 0) goto L7;
        if (r11 != size()) goto L7;
        return this;
    L7:
        if ((r10 + r11) > size()) goto L9;
        boolean r12 = true;
    L10:
        Preconditions.checkArgument(r12);
        return new MessageBuffer(this.base, this.address + ((long) r10), r11);
    L9:
        r12 = false;
        goto L10
    }

    public ByteBuffer sliceAsByteBuffer() {
        return sliceAsByteBuffer(0, size());
    }

    public ByteBuffer sliceAsByteBuffer(int r10, int r11) {
        if (hasArray() == false) goto L7;
        return ByteBuffer.wrap((byte[]) this.base, (int) ((this.address - ((long) ARRAY_BYTE_BASE_OFFSET)) + ((long) r10)), r11);
    L7:
        return DirectBufferAccess.newByteBuffer(this.address, r10, r11, this.reference);
    }

    public byte[] toByteArray() {
        byte[] r10 = new byte[size()];
        unsafe.copyMemory(this.base, this.address, r10, ARRAY_BYTE_BASE_OFFSET, size());
        return r10;
    }

    public String toHexString(int r10, int r11) {
        StringBuilder r12 = new StringBuilder();
        int r13 = r10;
    L3:
        if (r13 >= r11) goto L8;
        if (r13 == r10) goto L6;
        r12.append(" ");
    L6:
        r12.append(String.format("%02x", new Object[]{Byte.valueOf(getByte(r13))}));
        r13 = r13 + 1;
        goto L3
    L8:
        return r12.toString();
    }
}
