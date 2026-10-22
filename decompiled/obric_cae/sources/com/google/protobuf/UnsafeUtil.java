package com.google.protobuf;

import com.obric.cae.location.database.StarLocationDbManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
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

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        public Android32MemoryAccessor(Unsafe r8) {
            super(r8);
        }

        private static int smallAddress(long r8) {
            return (int) (r8 & (-1));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r8, byte[] r10, long r11, long r12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r8, long r10) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(r8, r10);
        L7:
            return UnsafeUtil.access$700(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r8, long r10) {
            return Double.longBitsToDouble(getLong(r8, r10));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r8, long r10) {
            return Float.intBitsToFloat(getInt(r8, r10));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r8) {
            return r8.get(null);
        L8:
            return null;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r8, long r10, boolean r11) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(r8, r10, r11);
            return;
        L5:
            UnsafeUtil.access$900(r8, r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r8, byte r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r8, long r10, double r11) {
            putLong(r8, r10, Double.doubleToLongBits(r11));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r8, long r10, float r11) {
            putInt(r8, r10, Float.floatToIntBits(r11));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r8, int r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r8, long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r8, long r10, long r11, long r12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r8, long r10) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(r8, r10);
        L7:
            return UnsafeUtil.access$300(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r8, long r10, byte r11) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(r8, r10, r11);
            return;
        L5:
            UnsafeUtil.access$500(r8, r10, r11);
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe r8) {
            super(r8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r8, byte[] r10, long r11, long r12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r8, long r10) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(r8, r10);
        L7:
            return UnsafeUtil.access$700(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r8, long r10) {
            return Double.longBitsToDouble(getLong(r8, r10));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r8, long r10) {
            return Float.intBitsToFloat(getInt(r8, r10));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r8) {
            return r8.get(null);
        L8:
            return null;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r8, long r10, boolean r11) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(r8, r10, r11);
            return;
        L5:
            UnsafeUtil.access$900(r8, r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r8, byte r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r8, long r10, double r11) {
            putLong(r8, r10, Double.doubleToLongBits(r11));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r8, long r10, float r11) {
            putInt(r8, r10, Float.floatToIntBits(r11));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r8, int r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r8, long r10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r8, long r10, long r11, long r12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r8, long r10) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(r8, r10);
        L7:
            return UnsafeUtil.access$300(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r8, long r10, byte r11) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(r8, r10, r11);
            return;
        L5:
            UnsafeUtil.access$500(r8, r10, r11);
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe r8) {
            super(r8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r10, byte[] r12, long r13, long r15) {
            this.unsafe.copyMemory(null, r10, r12, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r13, r15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r8, long r10) {
            return this.unsafe.getBoolean(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r8) {
            return this.unsafe.getByte(r8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r8, long r10) {
            return this.unsafe.getDouble(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r8, long r10) {
            return this.unsafe.getFloat(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r8) {
            return this.unsafe.getInt(r8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r8) {
            return this.unsafe.getLong(r8);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r8) {
            return getObject(this.unsafe.staticFieldBase(r8), this.unsafe.staticFieldOffset(r8));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r8, long r10, boolean r11) {
            this.unsafe.putBoolean(r8, r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r8, byte r10) {
            this.unsafe.putByte(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r8, long r10, double r11) {
            this.unsafe.putDouble(r8, r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r8, long r10, float r11) {
            this.unsafe.putFloat(r8, r10, r11);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r8, int r10) {
            this.unsafe.putInt(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r8, long r10) {
            this.unsafe.putLong(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            if (super.supportsUnsafeArrayOperations() == true) goto L10;
            return false;
        L10:
            Class<?> r10 = this.unsafe.getClass();     // Catch: Throwable -> L7
            Class<?> r8 = Long.TYPE;     // Catch: Throwable -> L7
            r10.getMethod("getByte", new Class[]{Object.class, r8});     // Catch: Throwable -> L7
            r10.getMethod("putByte", new Class[]{Object.class, r8, Byte.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getBoolean", new Class[]{Object.class, r8});     // Catch: Throwable -> L7
            r10.getMethod("putBoolean", new Class[]{Object.class, r8, Boolean.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getFloat", new Class[]{Object.class, r8});     // Catch: Throwable -> L7
            r10.getMethod("putFloat", new Class[]{Object.class, r8, Float.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getDouble", new Class[]{Object.class, r8});     // Catch: Throwable -> L7
            r10.getMethod("putDouble", new Class[]{Object.class, r8, Double.TYPE});     // Catch: Throwable -> L7
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
            Class<?> r8 = Long.TYPE;     // Catch: Throwable -> L7
            r10.getMethod("getByte", new Class[]{r8});     // Catch: Throwable -> L7
            r10.getMethod("putByte", new Class[]{r8, Byte.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getInt", new Class[]{r8});     // Catch: Throwable -> L7
            r10.getMethod("putInt", new Class[]{r8, Integer.TYPE});     // Catch: Throwable -> L7
            r10.getMethod("getLong", new Class[]{r8});     // Catch: Throwable -> L7
            r10.getMethod("putLong", new Class[]{r8, r8});     // Catch: Throwable -> L7
            r10.getMethod("copyMemory", new Class[]{r8, r8, r8});     // Catch: Throwable -> L7
            r10.getMethod("copyMemory", new Class[]{Object.class, r8, Object.class, r8, r8});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r10, long r11, long r13, long r15) {
            this.unsafe.copyMemory(r10, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r11, null, r13, r15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r8, long r10) {
            return this.unsafe.getByte(r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r8, long r10, byte r11) {
            this.unsafe.putByte(r8, r10, r11);
        }
    }

    public static abstract class MemoryAccessor {
        Unsafe unsafe;

        public MemoryAccessor(Unsafe r8) {
            this.unsafe = r8;
        }

        public final int arrayBaseOffset(Class<?> r8) {
            return this.unsafe.arrayBaseOffset(r8);
        }

        public final int arrayIndexScale(Class<?> r8) {
            return this.unsafe.arrayIndexScale(r8);
        }

        public abstract void copyMemory(long r8, byte[] r10, long r11, long r12);

        public abstract void copyMemory(byte[] r8, long r10, long r11, long r12);

        public abstract boolean getBoolean(Object r8, long r10);

        public abstract byte getByte(long r8);

        public abstract byte getByte(Object r8, long r10);

        public abstract double getDouble(Object r8, long r10);

        public abstract float getFloat(Object r8, long r10);

        public abstract int getInt(long r8);

        public final int getInt(Object r8, long r10) {
            return this.unsafe.getInt(r8, r10);
        }

        public abstract long getLong(long r8);

        public final long getLong(Object r8, long r10) {
            return this.unsafe.getLong(r8, r10);
        }

        public final Object getObject(Object r8, long r10) {
            return this.unsafe.getObject(r8, r10);
        }

        public abstract Object getStaticObject(java.lang.reflect.Field r8);

        public final long objectFieldOffset(java.lang.reflect.Field r8) {
            return this.unsafe.objectFieldOffset(r8);
        }

        public abstract void putBoolean(Object r8, long r10, boolean r11);

        public abstract void putByte(long r8, byte r10);

        public abstract void putByte(Object r8, long r10, byte r11);

        public abstract void putDouble(Object r8, long r10, double r11);

        public abstract void putFloat(Object r8, long r10, float r11);

        public abstract void putInt(long r8, int r10);

        public final void putInt(Object r8, long r10, int r11) {
            this.unsafe.putInt(r8, r10, r11);
        }

        public abstract void putLong(long r8, long r10);

        public final void putLong(Object r8, long r10, long r11) {
            this.unsafe.putLong(r8, r10, r11);
        }

        public final void putObject(Object r8, long r10, Object r11) {
            this.unsafe.putObject(r8, r10, r11);
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
            Class<?> r8 = Long.TYPE;     // Catch: Throwable -> L7
            r11.getMethod("getInt", new Class[]{Object.class, r8});     // Catch: Throwable -> L7
            r11.getMethod("putInt", new Class[]{Object.class, r8, Integer.TYPE});     // Catch: Throwable -> L7
            r11.getMethod("getLong", new Class[]{Object.class, r8});     // Catch: Throwable -> L7
            r11.getMethod("putLong", new Class[]{Object.class, r8, r8});     // Catch: Throwable -> L7
            r11.getMethod("getObject", new Class[]{Object.class, r8});     // Catch: Throwable -> L7
            r11.getMethod("putObject", new Class[]{Object.class, r8, Object.class});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe r8 = this.unsafe;
            if (r8 != null) goto L12;
            return false;
        L12:
            Class<?> r10 = r8.getClass();     // Catch: Throwable -> L9
            r10.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L9
            r10.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L9
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
        long r8 = arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = r8;
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
        BYTE_ARRAY_ALIGNMENT = (int) (r8 & 7);
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) goto L5;
        boolean r10 = true;
    L6:
        IS_BIG_ENDIAN = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    private UnsafeUtil() {
    }

    public static /* synthetic */ void access$000(Throwable r8) {
        logMissingMethod(r8);
    }

    public static /* synthetic */ java.lang.reflect.Field access$100() {
        return bufferAddressField();
    }

    public static /* synthetic */ byte access$200(Object r8, long r10) {
        return getByteBigEndian(r8, r10);
    }

    public static /* synthetic */ byte access$300(Object r8, long r10) {
        return getByteLittleEndian(r8, r10);
    }

    public static /* synthetic */ void access$400(Object r8, long r10, byte r11) {
        putByteBigEndian(r8, r10, r11);
    }

    public static /* synthetic */ void access$500(Object r8, long r10, byte r11) {
        putByteLittleEndian(r8, r10, r11);
    }

    public static /* synthetic */ boolean access$600(Object r8, long r10) {
        return getBooleanBigEndian(r8, r10);
    }

    public static /* synthetic */ boolean access$700(Object r8, long r10) {
        return getBooleanLittleEndian(r8, r10);
    }

    public static /* synthetic */ void access$800(Object r8, long r10, boolean r11) {
        putBooleanBigEndian(r8, r10, r11);
    }

    public static /* synthetic */ void access$900(Object r8, long r10, boolean r11) {
        putBooleanLittleEndian(r8, r10, r11);
    }

    public static long addressOffset(ByteBuffer r8) {
        return MEMORY_ACCESSOR.getLong(r8, BUFFER_ADDRESS_OFFSET);
    }

    public static <T> T allocateInstance(Class<T> r8) {
        return (T) UNSAFE.allocateInstance(r8);
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static int arrayBaseOffset(Class<?> r8) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayBaseOffset(r8);
    }

    private static int arrayIndexScale(Class<?> r8) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayIndexScale(r8);
    }

    private static java.lang.reflect.Field bufferAddressField() {
        if (Android.isOnAndroidDevice() == false) goto L7;
        java.lang.reflect.Field r8 = field(Buffer.class, "effectiveDirectAddress");
        if (r8 == null) goto L7;
        return r8;
    L7:
        java.lang.reflect.Field r10 = field(Buffer.class, StarLocationDbManager.GeofenceEntry.ADDRESS);
        if (r10 != null) goto L10;
    L12:
        return null;
    L10:
        if (r10.getType() != Long.TYPE) goto L12;
        return r10;
    }

    public static void copyMemory(long r8, byte[] r10, long r11, long r13) {
        MEMORY_ACCESSOR.copyMemory(r8, r10, r11, r13);
    }

    public static boolean determineAndroidSupportByAddressSize(Class<?> r10) {
        if (Android.isOnAndroidDevice() == true) goto L8;
        return false;
    L8:
        Class<?> r8 = MEMORY_CLASS;     // Catch: Throwable -> L7
        Class<?> r11 = Boolean.TYPE;     // Catch: Throwable -> L7
        r8.getMethod("peekLong", new Class[]{r10, r11});     // Catch: Throwable -> L7
        r8.getMethod("pokeLong", new Class[]{r10, Long.TYPE, r11});     // Catch: Throwable -> L7
        Class<?> r12 = Integer.TYPE;     // Catch: Throwable -> L7
        r8.getMethod("pokeInt", new Class[]{r10, r12, r11});     // Catch: Throwable -> L7
        r8.getMethod("peekInt", new Class[]{r10, r11});     // Catch: Throwable -> L7
        r8.getMethod("pokeByte", new Class[]{r10, Byte.TYPE});     // Catch: Throwable -> L7
        r8.getMethod("peekByte", new Class[]{r10});     // Catch: Throwable -> L7
        r8.getMethod("pokeByteArray", new Class[]{r10, byte[].class, r12, r12});     // Catch: Throwable -> L7
        r8.getMethod("peekByteArray", new Class[]{r10, byte[].class, r12, r12});     // Catch: Throwable -> L7
        return true;
    L7:
        return false;
    }

    private static java.lang.reflect.Field field(Class<?> r8, String r10) {
        return r8.getDeclaredField(r10);
    L4:
        return null;
    }

    private static long fieldOffset(java.lang.reflect.Field r8) {
        if (r8 == null) goto L7;
        MemoryAccessor r10 = MEMORY_ACCESSOR;
        if (r10 == null) goto L7;
        return r10.objectFieldOffset(r8);
    L7:
        return -1;
    }

    private static int firstDifferingByteIndexNativeEndian(long r8, long r10) {
        long r11 = r8 ^ r10;
        if (IS_BIG_ENDIAN == false) goto L5;
        int r12 = Long.numberOfLeadingZeros(r11);
    L7:
        return r12 >> 3;
    L5:
        r12 = Long.numberOfTrailingZeros(r11);
        goto L7
    }

    public static boolean getBoolean(Object r8, long r10) {
        return MEMORY_ACCESSOR.getBoolean(r8, r10);
    }

    private static boolean getBooleanBigEndian(Object r8, long r10) {
        if (getByteBigEndian(r8, r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean getBooleanLittleEndian(Object r8, long r10) {
        if (getByteLittleEndian(r8, r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static byte getByte(long r8) {
        return MEMORY_ACCESSOR.getByte(r8);
    }

    private static byte getByteBigEndian(Object r8, long r10) {
        return (byte) ((getInt(r8, (-4) & r10) >>> ((int) (((~r10) & 3) << 3))) & 255);
    }

    private static byte getByteLittleEndian(Object r8, long r10) {
        return (byte) ((getInt(r8, (-4) & r10) >>> ((int) ((r10 & 3) << 3))) & 255);
    }

    public static double getDouble(Object r8, long r10) {
        return MEMORY_ACCESSOR.getDouble(r8, r10);
    }

    public static float getFloat(Object r8, long r10) {
        return MEMORY_ACCESSOR.getFloat(r8, r10);
    }

    public static int getInt(long r8) {
        return MEMORY_ACCESSOR.getInt(r8);
    }

    public static long getLong(long r8) {
        return MEMORY_ACCESSOR.getLong(r8);
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe r8 = UNSAFE;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (Android.isOnAndroidDevice() == false) goto L16;
        if (IS_ANDROID_64 == false) goto L12;
        return new Android64MemoryAccessor(r8);
    L12:
        if (IS_ANDROID_32 == true) goto L14;
        return null;
    L14:
        return new Android32MemoryAccessor(r8);
    L16:
        return new JvmMemoryAccessor(r8);
    }

    public static Object getObject(Object r8, long r10) {
        return MEMORY_ACCESSOR.getObject(r8, r10);
    }

    public static Object getStaticObject(java.lang.reflect.Field r8) {
        return MEMORY_ACCESSOR.getStaticObject(r8);
    }

    public static Unsafe getUnsafe() {
        return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
    L4:
        return null;
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    private static void logMissingMethod(Throwable r8) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + r8);
    }

    public static int mismatch(byte[] r10, int r11, byte[] r12, int r13, int r14) {
        if (r11 < 0) goto L34;
        if (r13 < 0) goto L34;
        if (r14 < 0) goto L34;
        if ((r11 + r14) > r10.length) goto L34;
        if ((r13 + r14) > r12.length) goto L34;
        int r8 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS == false) goto L26;
        int r15 = (BYTE_ARRAY_ALIGNMENT + r11) & 7;
    L12:
        if (r8 >= r14) goto L19;
        if ((r15 & 7) == 0) goto L19;
        if (r10[r11 + r8] != r12[r13 + r8]) goto L17;
        r8 = r8 + 1;
        r15 = r15 + 1;
        goto L12
    L17:
        return r8;
    L19:
        int r16 = ((r14 - r8) & (-8)) + r8;
    L20:
        if (r8 >= r16) goto L26;
        long r17 = BYTE_ARRAY_BASE_OFFSET;
        long r18 = r8;
        long r19 = getLong(r10, (((long) r11) + r17) + r18);
        long r20 = getLong(r12, (r17 + ((long) r13)) + r18);
        if (r19 != r20) goto L24;
        r8 = r8 + 8;
        goto L20
    L24:
        return r8 + firstDifferingByteIndexNativeEndian(r19, r20);
    L26:
        if (r8 >= r14) goto L31;
        if (r10[r11 + r8] != r12[r13 + r8]) goto L29;
        r8 = r8 + 1;
        goto L26
    L29:
        return r8;
    L31:
        return -1;
    L34:
        throw new IndexOutOfBoundsException();
    }

    public static long objectFieldOffset(java.lang.reflect.Field r8) {
        return MEMORY_ACCESSOR.objectFieldOffset(r8);
    }

    public static void putBoolean(Object r8, long r10, boolean r11) {
        MEMORY_ACCESSOR.putBoolean(r8, r10, r11);
    }

    private static void putBooleanBigEndian(Object r8, long r10, boolean r11) {
        putByteBigEndian(r8, r10, r11 ? 1 : 0);
    }

    private static void putBooleanLittleEndian(Object r8, long r10, boolean r11) {
        putByteLittleEndian(r8, r10, r11 ? 1 : 0);
    }

    public static void putByte(long r8, byte r10) {
        MEMORY_ACCESSOR.putByte(r8, r10);
    }

    private static void putByteBigEndian(Object r8, long r10, byte r11) {
        long r12 = (-4) & r10;
        int r13 = getInt(r8, r12);
        int r14 = ((~((int) r10)) & 3) << 3;
        int r15 = r13 & (~(255 << r14));
        putInt(r8, r12, ((255 & r11) << r14) | r15);
    }

    private static void putByteLittleEndian(Object r8, long r10, byte r11) {
        long r12 = (-4) & r10;
        int r13 = (((int) r10) & 3) << 3;
        int r14 = getInt(r8, r12) & (~(255 << r13));
        putInt(r8, r12, ((255 & r11) << r13) | r14);
    }

    public static void putDouble(Object r8, long r10, double r11) {
        MEMORY_ACCESSOR.putDouble(r8, r10, r11);
    }

    public static void putFloat(Object r8, long r10, float r11) {
        MEMORY_ACCESSOR.putFloat(r8, r10, r11);
    }

    public static void putInt(long r8, int r10) {
        MEMORY_ACCESSOR.putInt(r8, r10);
    }

    public static void putLong(long r8, long r10) {
        MEMORY_ACCESSOR.putLong(r8, r10);
    }

    public static void putObject(Object r8, long r10, Object r11) {
        MEMORY_ACCESSOR.putObject(r8, r10, r11);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor r8 = MEMORY_ACCESSOR;
        if (r8 != null) goto L7;
        return false;
    L7:
        return r8.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor r8 = MEMORY_ACCESSOR;
        if (r8 != null) goto L7;
        return false;
    L7:
        return r8.supportsUnsafeByteBufferOperations();
    }

    public static void copyMemory(byte[] r8, long r10, long r11, long r13) {
        MEMORY_ACCESSOR.copyMemory(r8, r10, r11, r13);
    }

    public static boolean getBoolean(boolean[] r8, long r10) {
        MemoryAccessor r11 = MEMORY_ACCESSOR;
        long r12 = BOOLEAN_ARRAY_BASE_OFFSET;
        return r11.getBoolean(r8, (r10 * BOOLEAN_ARRAY_INDEX_SCALE) + r12);
    }

    public static byte getByte(Object r8, long r10) {
        return MEMORY_ACCESSOR.getByte(r8, r10);
    }

    public static double getDouble(double[] r8, long r10) {
        MemoryAccessor r11 = MEMORY_ACCESSOR;
        long r12 = DOUBLE_ARRAY_BASE_OFFSET;
        return r11.getDouble(r8, (r10 * DOUBLE_ARRAY_INDEX_SCALE) + r12);
    }

    public static float getFloat(float[] r8, long r10) {
        MemoryAccessor r11 = MEMORY_ACCESSOR;
        long r12 = FLOAT_ARRAY_BASE_OFFSET;
        return r11.getFloat(r8, (r10 * FLOAT_ARRAY_INDEX_SCALE) + r12);
    }

    public static int getInt(Object r8, long r10) {
        return MEMORY_ACCESSOR.getInt(r8, r10);
    }

    public static long getLong(Object r8, long r10) {
        return MEMORY_ACCESSOR.getLong(r8, r10);
    }

    public static Object getObject(Object[] r8, long r10) {
        MemoryAccessor r11 = MEMORY_ACCESSOR;
        long r12 = OBJECT_ARRAY_BASE_OFFSET;
        return r11.getObject(r8, (r10 * OBJECT_ARRAY_INDEX_SCALE) + r12);
    }

    public static void putBoolean(boolean[] r8, long r10, boolean r11) {
        MemoryAccessor r12 = MEMORY_ACCESSOR;
        long r13 = BOOLEAN_ARRAY_BASE_OFFSET;
        r12.putBoolean(r8, (r10 * BOOLEAN_ARRAY_INDEX_SCALE) + r13, r11);
    }

    public static void putByte(Object r8, long r10, byte r11) {
        MEMORY_ACCESSOR.putByte(r8, r10, r11);
    }

    public static void putDouble(double[] r8, long r10, double r11) {
        MemoryAccessor r12 = MEMORY_ACCESSOR;
        long r13 = DOUBLE_ARRAY_BASE_OFFSET;
        r12.putDouble(r8, (r10 * DOUBLE_ARRAY_INDEX_SCALE) + r13, r11);
    }

    public static void putFloat(float[] r8, long r10, float r11) {
        MemoryAccessor r12 = MEMORY_ACCESSOR;
        long r13 = FLOAT_ARRAY_BASE_OFFSET;
        r12.putFloat(r8, (r10 * FLOAT_ARRAY_INDEX_SCALE) + r13, r11);
    }

    public static void putInt(Object r8, long r10, int r11) {
        MEMORY_ACCESSOR.putInt(r8, r10, r11);
    }

    public static void putLong(Object r8, long r10, long r11) {
        MEMORY_ACCESSOR.putLong(r8, r10, r11);
    }

    public static void putObject(Object[] r8, long r10, Object r11) {
        MemoryAccessor r12 = MEMORY_ACCESSOR;
        long r13 = OBJECT_ARRAY_BASE_OFFSET;
        r12.putObject(r8, (r10 * OBJECT_ARRAY_INDEX_SCALE) + r13, r11);
    }

    public static void copyMemory(byte[] r8, long r10, byte[] r11, long r12, long r13) {
        System.arraycopy(r8, (int) r10, r11, (int) r12, (int) r13);
    }

    public static byte getByte(byte[] r8, long r10) {
        return MEMORY_ACCESSOR.getByte(r8, BYTE_ARRAY_BASE_OFFSET + r10);
    }

    public static int getInt(int[] r8, long r10) {
        MemoryAccessor r11 = MEMORY_ACCESSOR;
        long r12 = INT_ARRAY_BASE_OFFSET;
        return r11.getInt(r8, (r10 * INT_ARRAY_INDEX_SCALE) + r12);
    }

    public static long getLong(long[] r8, long r10) {
        MemoryAccessor r11 = MEMORY_ACCESSOR;
        long r12 = LONG_ARRAY_BASE_OFFSET;
        return r11.getLong(r8, (r10 * LONG_ARRAY_INDEX_SCALE) + r12);
    }

    public static void putByte(byte[] r8, long r10, byte r11) {
        MEMORY_ACCESSOR.putByte(r8, BYTE_ARRAY_BASE_OFFSET + r10, r11);
    }

    public static void putInt(int[] r8, long r10, int r11) {
        MemoryAccessor r12 = MEMORY_ACCESSOR;
        long r13 = INT_ARRAY_BASE_OFFSET;
        r12.putInt(r8, (r10 * INT_ARRAY_INDEX_SCALE) + r13, r11);
    }

    public static void putLong(long[] r8, long r10, long r11) {
        MemoryAccessor r12 = MEMORY_ACCESSOR;
        long r13 = LONG_ARRAY_BASE_OFFSET;
        r12.putLong(r8, (r10 * LONG_ARRAY_INDEX_SCALE) + r13, r11);
    }
}
