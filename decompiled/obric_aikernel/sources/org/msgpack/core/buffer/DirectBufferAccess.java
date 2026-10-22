package org.msgpack.core.buffer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

/* JADX INFO: loaded from: classes3.dex */
class DirectBufferAccess {
    static Constructor<?> byteBufferConstructor;
    static DirectBufferConstructorType directBufferConstructorType;
    static Class<?> directByteBufferClass;
    static Method mClean;
    static Method mCleaner;
    static Method mInvokeCleaner;
    static Method memoryBlockWrapFromJni;

    /* JADX INFO: renamed from: org.msgpack.core.buffer.DirectBufferAccess$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType = null;

        static {
            int[] r10 = new int[DirectBufferConstructorType.values().length];
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType = r10;
            r10[DirectBufferConstructorType.ARGS_LONG_LONG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_LONG_INT_REF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_LONG_INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_INT_INT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_MB_INT_INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static final enum DirectBufferConstructorType extends Enum<DirectBufferConstructorType> {
        private static final /* synthetic */ DirectBufferConstructorType[] $VALUES = null;
        public static final DirectBufferConstructorType ARGS_INT_INT = null;
        public static final DirectBufferConstructorType ARGS_LONG_INT = null;
        public static final DirectBufferConstructorType ARGS_LONG_INT_REF = null;
        public static final DirectBufferConstructorType ARGS_LONG_LONG = null;
        public static final DirectBufferConstructorType ARGS_MB_INT_INT = null;

        static {
            DirectBufferConstructorType r10 = new DirectBufferConstructorType("ARGS_LONG_LONG", 0);
            ARGS_LONG_LONG = r10;
            DirectBufferConstructorType r11 = new DirectBufferConstructorType("ARGS_LONG_INT_REF", 1);
            ARGS_LONG_INT_REF = r11;
            DirectBufferConstructorType r12 = new DirectBufferConstructorType("ARGS_LONG_INT", 2);
            ARGS_LONG_INT = r12;
            DirectBufferConstructorType r13 = new DirectBufferConstructorType("ARGS_INT_INT", 3);
            ARGS_INT_INT = r13;
            DirectBufferConstructorType r14 = new DirectBufferConstructorType("ARGS_MB_INT_INT", 4);
            ARGS_MB_INT_INT = r14;
            $VALUES = new DirectBufferConstructorType[]{r10, r11, r12, r13, r14};
        }

        private DirectBufferConstructorType(String r10, int r11) {
            super(r10, r11);
        }

        public static DirectBufferConstructorType valueOf(String r10) {
            return (DirectBufferConstructorType) Enum.valueOf(DirectBufferConstructorType.class, r10);
        }

        public static DirectBufferConstructorType[] values() {
            return (DirectBufferConstructorType[]) $VALUES.clone();
        }
    }

    static {
        ByteBuffer r10 = ByteBuffer.allocateDirect(1);     // Catch: Exception -> L31
        Class<?> r11 = r10.getClass();     // Catch: Exception -> L31
        directByteBufferClass = r11;     // Catch: Exception -> L31
        Class<?> r12 = Long.TYPE;     // Catch: NoSuchMethodException -> L7 Exception -> L31
        Constructor<?> r13 = r11.getDeclaredConstructor(new Class[]{r12, r12});     // Catch: NoSuchMethodException -> L7 Exception -> L31
        DirectBufferConstructorType r14 = DirectBufferConstructorType.ARGS_LONG_LONG;     // Catch: NoSuchMethodException -> L7 Exception -> L31
        Method r15 = null;
    L15:
        byteBufferConstructor = r13;     // Catch: Exception -> L31
        directBufferConstructorType = r14;     // Catch: Exception -> L31
        memoryBlockWrapFromJni = r15;     // Catch: Exception -> L31
        if (r13 == null) goto L30;
        r13.setAccessible(true);     // Catch: RuntimeException -> L19 Exception -> L31
    L24:
        if (MessageBuffer.javaVersion > 8) goto L26;
        setupCleanerJava6(r10);     // Catch: Exception -> L31
        return;
    L26:
        setupCleanerJava9(r10);     // Catch: Exception -> L31
        return;
    L19:
        e = move-exception;
        if ("java.lang.reflect.InaccessibleObjectException".equals(e.getClass().getName()) == false) goto L28;
        byteBufferConstructor = null;     // Catch: Exception -> L31
        goto L24
    L28:
        throw e;     // Catch: Exception -> L31
    L30:
        throw new RuntimeException("Constructor of DirectByteBuffer is not found");     // Catch: Exception -> L31
    L34:
        Constructor<?> r16 = directByteBufferClass.getDeclaredConstructor(new Class[]{Long.TYPE, Integer.TYPE, Object.class});     // Catch: NoSuchMethodException -> L10 Exception -> L31
        r14 = DirectBufferConstructorType.ARGS_LONG_INT_REF;     // Catch: NoSuchMethodException -> L10 Exception -> L31
    L9:
        r15 = null;
        r13 = r16;
    L10:
        r16 = directByteBufferClass.getDeclaredConstructor(new Class[]{Long.TYPE, Integer.TYPE});     // Catch: NoSuchMethodException -> L12 Exception -> L31
        r14 = DirectBufferConstructorType.ARGS_LONG_INT;     // Catch: NoSuchMethodException -> L12 Exception -> L31
    L12:
        Class<?> r17 = directByteBufferClass;     // Catch: NoSuchMethodException -> L14 Exception -> L31
        Class<?> r18 = Integer.TYPE;     // Catch: NoSuchMethodException -> L14 Exception -> L31
        r16 = r17.getDeclaredConstructor(new Class[]{r18, r18});     // Catch: NoSuchMethodException -> L14 Exception -> L31
        r14 = DirectBufferConstructorType.ARGS_INT_INT;     // Catch: NoSuchMethodException -> L14 Exception -> L31
    L14:
        Class<?> r19 = Class.forName("java.nio.MemoryBlock");     // Catch: Exception -> L31
        Class<?> r20 = Integer.TYPE;     // Catch: Exception -> L31
        r15 = r19.getDeclaredMethod("wrapFromJni", new Class[]{r20, Long.TYPE});     // Catch: Exception -> L31
        r15.setAccessible(true);     // Catch: Exception -> L31
        r13 = directByteBufferClass.getDeclaredConstructor(new Class[]{r19, r20, r20});     // Catch: Exception -> L31
        r14 = DirectBufferConstructorType.ARGS_MB_INT_INT;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private DirectBufferAccess() {
    }

    static /* synthetic */ Object access$000(ByteBuffer r10) {
        return getCleanerMethod(r10);
    }

    static /* synthetic */ Object access$100(ByteBuffer r10, Method r11) {
        return getCleanMethod(r10, r11);
    }

    static /* synthetic */ Object access$200(ByteBuffer r10) {
        return getInvokeCleanerMethod(r10);
    }

    static void clean(Object r10) {
    L7:
        th = move-exception;
        throw new RuntimeException(th);
    L3:
        if (MessageBuffer.javaVersion > 8) goto L5;
        mClean.invoke(mCleaner.invoke(r10, new Object[0]), new Object[0]);     // Catch: Throwable -> L7
        return;
    L5:
        mInvokeCleaner.invoke(MessageBuffer.unsafe, new Object[]{r10});     // Catch: Throwable -> L7
    }

    static long getAddress(Buffer r10) {
        return ((DirectBuffer) r10).address();
    }

    private static Object getCleanMethod(ByteBuffer r10, Method r11) {
        Method r12 = r11.getReturnType().getDeclaredMethod("clean", new Class[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        Object r13 = r11.invoke(r10, new Object[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r12.setAccessible(true);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r12.invoke(r13, new Object[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        return r12;
    L4:
        e = move-exception;
        return e;
    L8:
        e = move-exception;
        return e;
    L6:
        e = move-exception;
        return e;
    }

    private static Object getCleanerMethod(ByteBuffer r10) {
        Method r11 = r10.getClass().getDeclaredMethod("cleaner", new Class[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r11.setAccessible(true);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r11.invoke(r10, new Object[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        return r11;
    L4:
        e = move-exception;
        return e;
    L8:
        e = move-exception;
        return e;
    L6:
        e = move-exception;
        return e;
    }

    private static Object getInvokeCleanerMethod(ByteBuffer r10) {
        Unsafe r11 = MessageBuffer.unsafe;     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        Method r12 = r11.getClass().getDeclaredMethod("invokeCleaner", new Class[]{ByteBuffer.class});     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r12.invoke(r11, new Object[]{r10});     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        return r12;
    L4:
        e = move-exception;
        return e;
    L8:
        e = move-exception;
        return e;
    L6:
        e = move-exception;
        return e;
    }

    static boolean isDirectByteBufferInstance(Object r10) {
        return directByteBufferClass.isInstance(r10);
    }

    static ByteBuffer newByteBuffer(long r10, int r11, int r12, ByteBuffer r13) {
        if (byteBufferConstructor == null) goto L29;
        int r14 = AnonymousClass4.$SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[directBufferConstructorType.ordinal()];     // Catch: Throwable -> L25
        if (r14 == 1) goto L24;
        if (r14 == 2) goto L22;
        if (r14 == 3) goto L20;
        if (r14 == 4) goto L18;
        if (r14 != 5) goto L16;
        return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{memoryBlockWrapFromJni.invoke(null, new Object[]{Long.valueOf(r10 + ((long) r11)), Integer.valueOf(r12)}), Integer.valueOf(r12), 0});
    L16:
        throw new IllegalStateException("Unexpected value");     // Catch: Throwable -> L25
    L18:
        return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{Integer.valueOf(((int) r10) + r11), Integer.valueOf(r12)});
    L20:
        return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{Long.valueOf(r10 + ((long) r11)), Integer.valueOf(r12)});
    L22:
        return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{Long.valueOf(r10 + ((long) r11)), Integer.valueOf(r12), r13});
    L24:
        return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{Long.valueOf(r10 + ((long) r11)), Long.valueOf(r12)});
    L25:
        th = move-exception;
        throw new RuntimeException(th);
    L29:
        throw new IllegalStateException("Can't create a new DirectByteBuffer. In JDK17+, two JVM options needs to be set: --add-opens=java.base/java.nio=ALL-UNNAMED and --add-opens=java.base/sun.nio.ch=ALL-UNNAMED");
    }

    private static void setupCleanerJava6(final ByteBuffer r10) {
        Object r11 = AccessController.doPrivileged(new AnonymousClass1(r10));
        if ((r11 instanceof Throwable) == true) goto L11;
        mCleaner = (Method) r11;
        Object r12 = AccessController.doPrivileged(new AnonymousClass2(r10));
        if ((r12 instanceof Throwable) == true) goto L9;
        mClean = (Method) r12;
        return;
    L9:
        throw new RuntimeException((Throwable) r12);
    L11:
        throw new RuntimeException((Throwable) r11);
    }

    private static void setupCleanerJava9(final ByteBuffer r10) {
        Object r11 = AccessController.doPrivileged(new AnonymousClass3(r10));
        if ((r11 instanceof Throwable) == true) goto L7;
        mInvokeCleaner = (Method) r11;
        return;
    L7:
        throw new RuntimeException((Throwable) r11);
    }
}
