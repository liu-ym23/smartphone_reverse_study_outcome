package com.google.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET = 0;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE = 0;
    private static final long BUFFER_ADDRESS_OFFSET = 0;
    private static final int BYTE_ARRAY_ALIGNMENT = 0;
    static final long BYTE_ARRAY_BASE_OFFSET = 0;
    private static final long DOUBLE_ARRAY_BASE_OFFSET = 0;
    private static final long DOUBLE_ARRAY_INDEX_SCALE = 0;
    private static final long FLOAT_ARRAY_BASE_OFFSET = 0;
    private static final long FLOAT_ARRAY_INDEX_SCALE = 0;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = false;
    private static final long INT_ARRAY_BASE_OFFSET = 0;
    private static final long INT_ARRAY_INDEX_SCALE = 0;
    private static final boolean IS_ANDROID_32 = false;
    private static final boolean IS_ANDROID_64 = false;
    static final boolean IS_BIG_ENDIAN = false;
    private static final long LONG_ARRAY_BASE_OFFSET = 0;
    private static final long LONG_ARRAY_INDEX_SCALE = 0;
    private static final MemoryAccessor MEMORY_ACCESSOR = null;
    private static final Class<?> MEMORY_CLASS = null;
    private static final long OBJECT_ARRAY_BASE_OFFSET = 0;
    private static final long OBJECT_ARRAY_INDEX_SCALE = 0;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = null;

    private static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        Android32MemoryAccessor(Unsafe r10) {
            super(r10);
        }

        private static int smallAddress(long r10) {
            return (int) (r10 & (-1));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r10, byte[] r11, long r12, long r13) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r10, long r11, long r12, long r13) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r10, long r11) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(r10, r11);
        L7:
            return UnsafeUtil.access$700(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r10, long r11) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(r10, r11);
        L7:
            return UnsafeUtil.access$300(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r10, long r11) {
            return Double.longBitsToDouble(getLong(r10, r11));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r10, long r11) {
            return Float.intBitsToFloat(getInt(r10, r11));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r10) {
            return r10.get(null);
        L8:
            return null;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r10, long r11, boolean r12) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(r10, r11, r12);
            return;
        L5:
            UnsafeUtil.access$900(r10, r11, r12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r10, byte r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r10, long r11, byte r12) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(r10, r11, r12);
            return;
        L5:
            UnsafeUtil.access$500(r10, r11, r12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r10, long r11, double r12) {
            putLong(r10, r11, Double.doubleToLongBits(r12));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r10, long r11, float r12) {
            putInt(r10, r11, Float.floatToIntBits(r12));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r10, int r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r10, long r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe r10) {
            super(r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r10, byte[] r11, long r12, long r13) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r10, long r11, long r12, long r13) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r10, long r11) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(r10, r11);
        L7:
            return UnsafeUtil.access$700(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r10, long r11) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(r10, r11);
        L7:
            return UnsafeUtil.access$300(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r10, long r11) {
            return Double.longBitsToDouble(getLong(r10, r11));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r10, long r11) {
            return Float.intBitsToFloat(getInt(r10, r11));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r10) {
            return r10.get(null);
        L8:
            return null;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r10, long r11, boolean r12) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(r10, r11, r12);
            return;
        L5:
            UnsafeUtil.access$900(r10, r11, r12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r10, byte r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r10, long r11, byte r12) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(r10, r11, r12);
            return;
        L5:
            UnsafeUtil.access$500(r10, r11, r12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r10, long r11, double r12) {
            putLong(r10, r11, Double.doubleToLongBits(r12));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r10, long r11, float r12) {
            putInt(r10, r11, Float.floatToIntBits(r12));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r10, int r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r10, long r11) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe r10) {
            super(r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r10, byte[] r12, long r13, long r15) {
            this.unsafe.copyMemory(null, r10, r12, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r13, r15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r10, long r11, long r13, long r15) {
            this.unsafe.copyMemory(r10, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r11, null, r13, r15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r10, long r11) {
            return this.unsafe.getBoolean(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r10) {
            return this.unsafe.getByte(r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r10, long r11) {
            return this.unsafe.getByte(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r10, long r11) {
            return this.unsafe.getDouble(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r10, long r11) {
            return this.unsafe.getFloat(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r10) {
            return this.unsafe.getInt(r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r10) {
            return this.unsafe.getLong(r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r10) {
            return getObject(this.unsafe.staticFieldBase(r10), this.unsafe.staticFieldOffset(r10));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r10, long r11, boolean r12) {
            this.unsafe.putBoolean(r10, r11, r12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r10, byte r11) {
            this.unsafe.putByte(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r10, long r11, byte r12) {
            this.unsafe.putByte(r10, r11, r12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r10, long r11, double r12) {
            this.unsafe.putDouble(r10, r11, r12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r10, long r11, float r12) {
            this.unsafe.putFloat(r10, r11, r12);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r10, int r11) {
            this.unsafe.putInt(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r10, long r11) {
            this.unsafe.putLong(r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            if (super.supportsUnsafeArrayOperations() == true) goto L10;
            return false;
        L10:
            Class<?> r10 = this.unsafe.getClass();     // Catch: Throwable -> L7
            Class<?> r11 = Long.TYPE;     // Catch: Throwable -> L7
            r10.getMethod("getByte", new Class[]{Object.class, r11});     // Catch: Throwable -> L7
            r10.getMethod("putByte", new Class[]{Object.class, r11, Byte.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getBoolean", new Class[]{Object.class, r11});     // Catch: Throwable -> L7
            r10.getMethod("putBoolean", new Class[]{Object.class, r11, Boolean.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getFloat", new Class[]{Object.class, r11});     // Catch: Throwable -> L7
            r10.getMethod("putFloat", new Class[]{Object.class, r11, Float.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getDouble", new Class[]{Object.class, r11});     // Catch: Throwable -> L7
            r10.getMethod("putDouble", new Class[]{Object.class, r11, Double.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            if (super.supportsUnsafeByteBufferOperations() == true) goto L10;
            return false;
        L10:
            Class<?> r10 = this.unsafe.getClass();     // Catch: Throwable -> L7
            Class<?> r11 = Long.TYPE;     // Catch: Throwable -> L7
            r10.getMethod("getByte", new Class[]{r11});     // Catch: Throwable -> L7
            r10.getMethod("putByte", new Class[]{r11, Byte.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getInt", new Class[]{r11});     // Catch: Throwable -> L7
            r10.getMethod("putInt", new Class[]{r11, Integer.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getLong", new Class[]{r11});     // Catch: Throwable -> L7
            r10.getMethod("putLong", new Class[]{r11, r11});     // Catch: Throwable -> L7
            r10.getMethod("copyMemory", new Class[]{r11, r11, r11});     // Catch: Throwable -> L7
            r10.getMethod("copyMemory", new Class[]{Object.class, r11, Object.class, r11, r11});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }
    }

    private static abstract class MemoryAccessor {
        Unsafe unsafe;

        MemoryAccessor(Unsafe r10) {
            this.unsafe = r10;
        }

        public final int arrayBaseOffset(Class<?> r10) {
            return this.unsafe.arrayBaseOffset(r10);
        }

        public final int arrayIndexScale(Class<?> r10) {
            return this.unsafe.arrayIndexScale(r10);
        }

        public abstract void copyMemory(long r10, byte[] r11, long r12, long r13);

        public abstract void copyMemory(byte[] r10, long r11, long r12, long r13);

        public abstract boolean getBoolean(Object r10, long r11);

        public abstract byte getByte(long r10);

        public abstract byte getByte(Object r10, long r11);

        public abstract double getDouble(Object r10, long r11);

        public abstract float getFloat(Object r10, long r11);

        public abstract int getInt(long r10);

        public final int getInt(Object r10, long r11) {
            return this.unsafe.getInt(r10, r11);
        }

        public abstract long getLong(long r10);

        public final long getLong(Object r10, long r11) {
            return this.unsafe.getLong(r10, r11);
        }

        public final Object getObject(Object r10, long r11) {
            return this.unsafe.getObject(r10, r11);
        }

        public abstract Object getStaticObject(java.lang.reflect.Field r10);

        public final long objectFieldOffset(java.lang.reflect.Field r10) {
            return this.unsafe.objectFieldOffset(r10);
        }

        public abstract void putBoolean(Object r10, long r11, boolean r12);

        public abstract void putByte(long r10, byte r11);

        public abstract void putByte(Object r10, long r11, byte r12);

        public abstract void putDouble(Object r10, long r11, double r12);

        public abstract void putFloat(Object r10, long r11, float r12);

        public abstract void putInt(long r10, int r11);

        public final void putInt(Object r10, long r11, int r12) {
            this.unsafe.putInt(r10, r11, r12);
        }

        public abstract void putLong(long r10, long r11);

        public final void putLong(Object r10, long r11, long r12) {
            this.unsafe.putLong(r10, r11, r12);
        }

        public final void putObject(Object r10, long r11, Object r12) {
            this.unsafe.putObject(r10, r11, r12);
        }

        public boolean supportsUnsafeArrayOperations() {
            Unsafe r10 = this.unsafe;
            if (r10 != null) goto L10;
            return false;
        L10:
            Class<?> r11 = r10.getClass();     // Catch: Throwable -> L7
            r11.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L7
            r11.getMethod("arrayBaseOffset", new Class[]{Class.class});     // Catch: Throwable -> L7
            r11.getMethod("arrayIndexScale", new Class[]{Class.class});     // Catch: Throwable -> L7
            Class<?> r12 = Long.TYPE;     // Catch: Throwable -> L7
            r11.getMethod("getInt", new Class[]{Object.class, r12});     // Catch: Throwable -> L7
            r11.getMethod("putInt", new Class[]{Object.class, r12, Integer.TYPE});     // Catch: Throwable -> L7
            r11.getMethod("getLong", new Class[]{Object.class, r12});     // Catch: Throwable -> L7
            r11.getMethod("putLong", new Class[]{Object.class, r12, r12});     // Catch: Throwable -> L7
            r11.getMethod("getObject", new Class[]{Object.class, r12});     // Catch: Throwable -> L7
            r11.getMethod("putObject", new Class[]{Object.class, r12, Object.class});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe r10 = this.unsafe;
            if (r10 != null) goto L12;
            return false;
        L12:
            Class<?> r11 = r10.getClass();     // Catch: Throwable -> L9
            r11.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L9
            r11.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L9
            if (UnsafeUtil.access$100() != null) goto L8;
            return false;
        L8:
            return true;
        L9:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }
    }

    static {
        UNSAFE = getUnsafe();
        MEMORY_CLASS = Android.getMemoryClass();
        IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
        IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
        MEMORY_ACCESSOR = getMemoryAccessor();
        HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
        HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
        long r10 = arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = r10;
        BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
        BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
        INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
        INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
        LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
        LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
        FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
        FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
        DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
        DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
        OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
        OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
        BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
        BYTE_ARRAY_ALIGNMENT = (int) (7 & r10);
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) goto L5;
        boolean r11 = true;
    L6:
        IS_BIG_ENDIAN = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }

    private UnsafeUtil() {
    }

    static /* synthetic */ void access$000(Throwable r10) {
        logMissingMethod(r10);
    }

    static /* synthetic */ java.lang.reflect.Field access$100() {
        return bufferAddressField();
    }

    static /* synthetic */ byte access$200(Object r10, long r11) {
        return getByteBigEndian(r10, r11);
    }

    static /* synthetic */ byte access$300(Object r10, long r11) {
        return getByteLittleEndian(r10, r11);
    }

    static /* synthetic */ void access$400(Object r10, long r11, byte r12) {
        putByteBigEndian(r10, r11, r12);
    }

    static /* synthetic */ void access$500(Object r10, long r11, byte r12) {
        putByteLittleEndian(r10, r11, r12);
    }

    static /* synthetic */ boolean access$600(Object r10, long r11) {
        return getBooleanBigEndian(r10, r11);
    }

    static /* synthetic */ boolean access$700(Object r10, long r11) {
        return getBooleanLittleEndian(r10, r11);
    }

    static /* synthetic */ void access$800(Object r10, long r11, boolean r12) {
        putBooleanBigEndian(r10, r11, r12);
    }

    static /* synthetic */ void access$900(Object r10, long r11, boolean r12) {
        putBooleanLittleEndian(r10, r11, r12);
    }

    static long addressOffset(ByteBuffer r10) {
        return MEMORY_ACCESSOR.getLong(r10, BUFFER_ADDRESS_OFFSET);
    }

    static <T> T allocateInstance(Class<T> r10) {
        return (T) UNSAFE.allocateInstance(r10);
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static int arrayBaseOffset(Class<?> r10) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayBaseOffset(r10);
    }

    private static int arrayIndexScale(Class<?> r10) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayIndexScale(r10);
    }

    private static java.lang.reflect.Field bufferAddressField() {
        if (Android.isOnAndroidDevice() == false) goto L7;
        java.lang.reflect.Field r10 = field(Buffer.class, "effectiveDirectAddress");
        if (r10 == null) goto L7;
        return r10;
    L7:
        java.lang.reflect.Field r11 = field(Buffer.class, "address");
        if (r11 != null) goto L10;
    L12:
        return null;
    L10:
        if (r11.getType() != Long.TYPE) goto L12;
        return r11;
    }

    static void copyMemory(long r10, byte[] r11, long r12, long r13) {
        MEMORY_ACCESSOR.copyMemory(r10, r11, r12, r13);
    }

    static void copyMemory(byte[] r10, long r11, long r12, long r13) {
        MEMORY_ACCESSOR.copyMemory(r10, r11, r12, r13);
    }

    static void copyMemory(byte[] r10, long r11, byte[] r12, long r13, long r14) {
        System.arraycopy(r10, (int) r11, r12, (int) r13, (int) r14);
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> r10) {
        if (Android.isOnAndroidDevice() == true) goto L8;
        return false;
    L8:
        Class<?> r11 = MEMORY_CLASS;     // Catch: Throwable -> L7
        Class<?> r12 = Boolean.TYPE;     // Catch: Throwable -> L7
        r11.getMethod("peekLong", new Class[]{r10, r12});     // Catch: Throwable -> L7
        r11.getMethod("pokeLong", new Class[]{r10, Long.TYPE, r12});     // Catch: Throwable -> L7
        Class<?> r13 = Integer.TYPE;     // Catch: Throwable -> L7
        r11.getMethod("pokeInt", new Class[]{r10, r13, r12});     // Catch: Throwable -> L7
        r11.getMethod("peekInt", new Class[]{r10, r12});     // Catch: Throwable -> L7
        r11.getMethod("pokeByte", new Class[]{r10, Byte.TYPE});     // Catch: Throwable -> L7
        r11.getMethod("peekByte", new Class[]{r10});     // Catch: Throwable -> L7
        r11.getMethod("pokeByteArray", new Class[]{r10, byte[].class, r13, r13});     // Catch: Throwable -> L7
        r11.getMethod("peekByteArray", new Class[]{r10, byte[].class, r13, r13});     // Catch: Throwable -> L7
        return true;
    L7:
        return false;
    }

    private static java.lang.reflect.Field field(Class<?> r10, String r11) {
        return r10.getDeclaredField(r11);
    L4:
        return null;
    }

    private static long fieldOffset(java.lang.reflect.Field r10) {
        if (r10 == null) goto L7;
        MemoryAccessor r11 = MEMORY_ACCESSOR;
        if (r11 == null) goto L7;
        return r11.objectFieldOffset(r10);
    L7:
        return -1;
    }

    private static int firstDifferingByteIndexNativeEndian(long r10, long r11) {
        long r12 = r10 ^ r11;
        if (IS_BIG_ENDIAN == false) goto L5;
        int r13 = Long.numberOfLeadingZeros(r12);
    L7:
        return r13 >> 3;
    L5:
        r13 = Long.numberOfTrailingZeros(r12);
        goto L7
    }

    static boolean getBoolean(Object r10, long r11) {
        return MEMORY_ACCESSOR.getBoolean(r10, r11);
    }

    static boolean getBoolean(boolean[] r10, long r11) {
        return MEMORY_ACCESSOR.getBoolean(r10, BOOLEAN_ARRAY_BASE_OFFSET + (r11 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    private static boolean getBooleanBigEndian(Object r10, long r11) {
        if (getByteBigEndian(r10, r11) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean getBooleanLittleEndian(Object r10, long r11) {
        if (getByteLittleEndian(r10, r11) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static byte getByte(long r10) {
        return MEMORY_ACCESSOR.getByte(r10);
    }

    static byte getByte(Object r10, long r11) {
        return MEMORY_ACCESSOR.getByte(r10, r11);
    }

    static byte getByte(byte[] r10, long r11) {
        return MEMORY_ACCESSOR.getByte(r10, BYTE_ARRAY_BASE_OFFSET + r11);
    }

    private static byte getByteBigEndian(Object r10, long r11) {
        return (byte) ((getInt(r10, (-4) & r11) >>> ((int) (((~r11) & 3) << 3))) & 255);
    }

    private static byte getByteLittleEndian(Object r10, long r11) {
        return (byte) ((getInt(r10, (-4) & r11) >>> ((int) ((r11 & 3) << 3))) & 255);
    }

    static double getDouble(Object r10, long r11) {
        return MEMORY_ACCESSOR.getDouble(r10, r11);
    }

    static double getDouble(double[] r10, long r11) {
        return MEMORY_ACCESSOR.getDouble(r10, DOUBLE_ARRAY_BASE_OFFSET + (r11 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static float getFloat(Object r10, long r11) {
        return MEMORY_ACCESSOR.getFloat(r10, r11);
    }

    static float getFloat(float[] r10, long r11) {
        return MEMORY_ACCESSOR.getFloat(r10, FLOAT_ARRAY_BASE_OFFSET + (r11 * FLOAT_ARRAY_INDEX_SCALE));
    }

    static int getInt(long r10) {
        return MEMORY_ACCESSOR.getInt(r10);
    }

    static int getInt(Object r10, long r11) {
        return MEMORY_ACCESSOR.getInt(r10, r11);
    }

    static int getInt(int[] r10, long r11) {
        return MEMORY_ACCESSOR.getInt(r10, INT_ARRAY_BASE_OFFSET + (r11 * INT_ARRAY_INDEX_SCALE));
    }

    static long getLong(long r10) {
        return MEMORY_ACCESSOR.getLong(r10);
    }

    static long getLong(Object r10, long r11) {
        return MEMORY_ACCESSOR.getLong(r10, r11);
    }

    static long getLong(long[] r10, long r11) {
        return MEMORY_ACCESSOR.getLong(r10, LONG_ARRAY_BASE_OFFSET + (r11 * LONG_ARRAY_INDEX_SCALE));
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe r10 = UNSAFE;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (Android.isOnAndroidDevice() == false) goto L16;
        if (IS_ANDROID_64 == false) goto L12;
        return new Android64MemoryAccessor(r10);
    L12:
        if (IS_ANDROID_32 == true) goto L14;
        return null;
    L14:
        return new Android32MemoryAccessor(r10);
    L16:
        return new JvmMemoryAccessor(r10);
    }

    static Object getObject(Object r10, long r11) {
        return MEMORY_ACCESSOR.getObject(r10, r11);
    }

    static Object getObject(Object[] r10, long r11) {
        return MEMORY_ACCESSOR.getObject(r10, OBJECT_ARRAY_BASE_OFFSET + (r11 * OBJECT_ARRAY_INDEX_SCALE));
    }

    static Object getStaticObject(java.lang.reflect.Field r10) {
        return MEMORY_ACCESSOR.getStaticObject(r10);
    }

    static Unsafe getUnsafe() {
        return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
    L4:
        return null;
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    private static void logMissingMethod(Throwable r10) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + r10);
    }

    static int mismatch(byte[] r10, int r11, byte[] r12, int r13, int r14) {
        if (r11 < 0) goto L34;
        if (r13 < 0) goto L34;
        if (r14 < 0) goto L34;
        if ((r11 + r14) > r10.length) goto L34;
        if ((r13 + r14) > r12.length) goto L34;
        int r15 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS == false) goto L26;
        int r16 = (BYTE_ARRAY_ALIGNMENT + r11) & 7;
    L12:
        if (r15 >= r14) goto L19;
        if ((r16 & 7) == 0) goto L19;
        if (r10[r11 + r15] != r12[r13 + r15]) goto L17;
        r15 = r15 + 1;
        r16 = r16 + 1;
        goto L12
    L17:
        return r15;
    L19:
        int r17 = ((r14 - r15) & (-8)) + r15;
    L20:
        if (r15 >= r17) goto L26;
        long r18 = BYTE_ARRAY_BASE_OFFSET;
        long r19 = r15;
        long r20 = getLong(r10, (((long) r11) + r18) + r19);
        long r21 = getLong(r12, (r18 + ((long) r13)) + r19);
        if (r20 != r21) goto L24;
        r15 = r15 + 8;
        goto L20
    L24:
        return r15 + firstDifferingByteIndexNativeEndian(r20, r21);
    L26:
        if (r15 >= r14) goto L31;
        if (r10[r11 + r15] != r12[r13 + r15]) goto L29;
        r15 = r15 + 1;
        goto L26
    L29:
        return r15;
    L31:
        return -1;
    L34:
        throw new IndexOutOfBoundsException();
    }

    static long objectFieldOffset(java.lang.reflect.Field r10) {
        return MEMORY_ACCESSOR.objectFieldOffset(r10);
    }

    static void putBoolean(Object r10, long r11, boolean r12) {
        MEMORY_ACCESSOR.putBoolean(r10, r11, r12);
    }

    static void putBoolean(boolean[] r10, long r11, boolean r12) {
        MEMORY_ACCESSOR.putBoolean(r10, BOOLEAN_ARRAY_BASE_OFFSET + (r11 * BOOLEAN_ARRAY_INDEX_SCALE), r12);
    }

    private static void putBooleanBigEndian(Object r10, long r11, boolean r12) {
        putByteBigEndian(r10, r11, r12 ? 1 : 0);
    }

    private static void putBooleanLittleEndian(Object r10, long r11, boolean r12) {
        putByteLittleEndian(r10, r11, r12 ? 1 : 0);
    }

    static void putByte(long r10, byte r11) {
        MEMORY_ACCESSOR.putByte(r10, r11);
    }

    static void putByte(Object r10, long r11, byte r12) {
        MEMORY_ACCESSOR.putByte(r10, r11, r12);
    }

    static void putByte(byte[] r10, long r11, byte r12) {
        MEMORY_ACCESSOR.putByte(r10, BYTE_ARRAY_BASE_OFFSET + r11, r12);
    }

    private static void putByteBigEndian(Object r10, long r11, byte r12) {
        long r13 = (-4) & r11;
        int r14 = getInt(r10, r13);
        int r15 = ((~((int) r11)) & 3) << 3;
        int r16 = r14 & (~(255 << r15));
        putInt(r10, r13, ((255 & r12) << r15) | r16);
    }

    private static void putByteLittleEndian(Object r10, long r11, byte r12) {
        long r13 = (-4) & r11;
        int r14 = (((int) r11) & 3) << 3;
        int r15 = getInt(r10, r13) & (~(255 << r14));
        putInt(r10, r13, ((255 & r12) << r14) | r15);
    }

    static void putDouble(Object r10, long r11, double r12) {
        MEMORY_ACCESSOR.putDouble(r10, r11, r12);
    }

    static void putDouble(double[] r10, long r11, double r12) {
        MEMORY_ACCESSOR.putDouble(r10, DOUBLE_ARRAY_BASE_OFFSET + (r11 * DOUBLE_ARRAY_INDEX_SCALE), r12);
    }

    static void putFloat(Object r10, long r11, float r12) {
        MEMORY_ACCESSOR.putFloat(r10, r11, r12);
    }

    static void putFloat(float[] r10, long r11, float r12) {
        MEMORY_ACCESSOR.putFloat(r10, FLOAT_ARRAY_BASE_OFFSET + (r11 * FLOAT_ARRAY_INDEX_SCALE), r12);
    }

    static void putInt(long r10, int r11) {
        MEMORY_ACCESSOR.putInt(r10, r11);
    }

    static void putInt(Object r10, long r11, int r12) {
        MEMORY_ACCESSOR.putInt(r10, r11, r12);
    }

    static void putInt(int[] r10, long r11, int r12) {
        MEMORY_ACCESSOR.putInt(r10, INT_ARRAY_BASE_OFFSET + (r11 * INT_ARRAY_INDEX_SCALE), r12);
    }

    static void putLong(long r10, long r11) {
        MEMORY_ACCESSOR.putLong(r10, r11);
    }

    static void putLong(Object r10, long r11, long r12) {
        MEMORY_ACCESSOR.putLong(r10, r11, r12);
    }

    static void putLong(long[] r10, long r11, long r12) {
        MEMORY_ACCESSOR.putLong(r10, LONG_ARRAY_BASE_OFFSET + (r11 * LONG_ARRAY_INDEX_SCALE), r12);
    }

    static void putObject(Object r10, long r11, Object r12) {
        MEMORY_ACCESSOR.putObject(r10, r11, r12);
    }

    static void putObject(Object[] r10, long r11, Object r12) {
        MEMORY_ACCESSOR.putObject(r10, OBJECT_ARRAY_BASE_OFFSET + (r11 * OBJECT_ARRAY_INDEX_SCALE), r12);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor r10 = MEMORY_ACCESSOR;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor r10 = MEMORY_ACCESSOR;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.supportsUnsafeByteBufferOperations();
    }
}
