package org.msgpack.core.buffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import sun.nio.ch.DirectBuffer;

/* JADX INFO: loaded from: classes7.dex */
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
            int[] r0 = new int[DirectBufferConstructorType.values().length];
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType = r0;
            r0[DirectBufferConstructorType.ARGS_LONG_LONG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
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
            DirectBufferConstructorType r0 = new DirectBufferConstructorType("ARGS_LONG_LONG", 0);
            ARGS_LONG_LONG = r0;
            DirectBufferConstructorType r1 = new DirectBufferConstructorType("ARGS_LONG_INT_REF", 1);
            ARGS_LONG_INT_REF = r1;
            DirectBufferConstructorType r3 = new DirectBufferConstructorType("ARGS_LONG_INT", 2);
            ARGS_LONG_INT = r3;
            DirectBufferConstructorType r5 = new DirectBufferConstructorType("ARGS_INT_INT", 3);
            ARGS_INT_INT = r5;
            DirectBufferConstructorType r7 = new DirectBufferConstructorType("ARGS_MB_INT_INT", 4);
            ARGS_MB_INT_INT = r7;
            $VALUES = new DirectBufferConstructorType[]{r0, r1, r3, r5, r7};
        }

        private DirectBufferConstructorType(String r1, int r2) {
            super(r1, r2);
        }

        public static DirectBufferConstructorType valueOf(String r2) {
            return (DirectBufferConstructorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DirectBufferConstructorType.class, r2), DirectBufferConstructorType.class, "com.obric.memorydata.plugin");
        }

        public static DirectBufferConstructorType[] values() {
            return (DirectBufferConstructorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DirectBufferConstructorType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        ByteBuffer r1 = ByteBuffer.allocateDirect(1);     // Catch: Exception -> L31
        Class<?> r2 = r1.getClass();     // Catch: Exception -> L31
        directByteBufferClass = r2;     // Catch: Exception -> L31
        Constructor<?> r3 = r2.getDeclaredConstructor(new Class[]{Long.TYPE, Long.TYPE});     // Catch: NoSuchMethodException -> L7 Exception -> L31
        DirectBufferConstructorType r4 = DirectBufferConstructorType.ARGS_LONG_LONG;     // Catch: NoSuchMethodException -> L7 Exception -> L31
        Method r7 = null;
    L15:
        byteBufferConstructor = r3;     // Catch: Exception -> L31
        directBufferConstructorType = r4;     // Catch: Exception -> L31
        memoryBlockWrapFromJni = r7;     // Catch: Exception -> L31
        if (r3 == null) goto L30;
        r3.setAccessible(true);     // Catch: RuntimeException -> L19 Exception -> L31
    L24:
        if (MessageBuffer.javaVersion > 8) goto L26;
        setupCleanerJava6(r1);     // Catch: Exception -> L31
        return;
    L26:
        setupCleanerJava9(r1);     // Catch: Exception -> L31
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
        Constructor<?> r6 = directByteBufferClass.getDeclaredConstructor(new Class[]{Long.TYPE, Integer.TYPE, Object.class});     // Catch: NoSuchMethodException -> L10 Exception -> L31
        r4 = DirectBufferConstructorType.ARGS_LONG_INT_REF;     // Catch: NoSuchMethodException -> L10 Exception -> L31
    L9:
        r7 = null;
        r3 = r6;
    L10:
        r6 = directByteBufferClass.getDeclaredConstructor(new Class[]{Long.TYPE, Integer.TYPE});     // Catch: NoSuchMethodException -> L12 Exception -> L31
        r4 = DirectBufferConstructorType.ARGS_LONG_INT;     // Catch: NoSuchMethodException -> L12 Exception -> L31
    L12:
        r6 = directByteBufferClass.getDeclaredConstructor(new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: NoSuchMethodException -> L14 Exception -> L31
        r4 = DirectBufferConstructorType.ARGS_INT_INT;     // Catch: NoSuchMethodException -> L14 Exception -> L31
    L14:
        Class<?> r8 = ZeusTransformUtils.forName("java.nio.MemoryBlock", "com.obric.memorydata.plugin");     // Catch: Exception -> L31
        r7 = r8.getDeclaredMethod("wrapFromJni", new Class[]{Integer.TYPE, Long.TYPE});     // Catch: Exception -> L31
        r7.setAccessible(true);     // Catch: Exception -> L31
        r3 = directByteBufferClass.getDeclaredConstructor(new Class[]{r8, Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L31
        r4 = DirectBufferConstructorType.ARGS_MB_INT_INT;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private DirectBufferAccess() {
    }

    static /* synthetic */ Object access$000(ByteBuffer r0) {
        return getCleanerMethod(r0);
    }

    static /* synthetic */ Object access$100(ByteBuffer r0, Method r1) {
        return getCleanMethod(r0, r1);
    }

    static /* synthetic */ Object access$200(ByteBuffer r0) {
        return getInvokeCleanerMethod(r0);
    }

    static void clean(Object r4) {
    L7:
        th = move-exception;
        throw new RuntimeException(th);
    L3:
        if (MessageBuffer.javaVersion > 8) goto L5;
        mClean.invoke(mCleaner.invoke(r4, new Object[0]), new Object[0]);     // Catch: Throwable -> L7
        return;
    L5:
        mInvokeCleaner.invoke(MessageBuffer.unsafe, new Object[]{r4});     // Catch: Throwable -> L7
    }

    static long getAddress(Buffer r2) {
        return ((DirectBuffer) ZeusTransformUtils.preCheckCast(r2, DirectBuffer.class, "com.obric.memorydata.plugin")).address();
    }

    private static Object getCleanMethod(ByteBuffer r4, Method r5) {
        Method r0 = r5.getReturnType().getDeclaredMethod("clean", new Class[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        Object r6 = r5.invoke(r4, new Object[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r0.invoke(r6, new Object[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        return r0;
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

    private static Object getCleanerMethod(ByteBuffer r4) {
        Method r0 = r4.getClass().getDeclaredMethod("cleaner", new Class[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r0.invoke(r4, new Object[0]);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        return r0;
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

    private static Object getInvokeCleanerMethod(ByteBuffer r6) {
        Method r0 = MessageBuffer.unsafe.getClass().getDeclaredMethod("invokeCleaner", new Class[]{ByteBuffer.class});     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r0.invoke(MessageBuffer.unsafe, new Object[]{r6});     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        return r0;
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

    static boolean isDirectByteBufferInstance(Object r1) {
        return ZeusTransformUtils.instanceOf(directByteBufferClass, r1);
    }

    static ByteBuffer newByteBuffer(long r10, int r12, int r13, ByteBuffer r14) {
        if (byteBufferConstructor == null) goto L30;
        int r0 = AnonymousClass4.$SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[directBufferConstructorType.ordinal()];     // Catch: Throwable -> L26
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L21;
        if (r0 == 4) goto L19;
        if (r0 != 5) goto L17;
        return (ByteBuffer) ZeusTransformUtils.preCheckCast(byteBufferConstructor.newInstance(new Object[]{memoryBlockWrapFromJni.invoke(null, new Object[]{Long.valueOf(r10 + ((long) r12)), Integer.valueOf(r13)}), Integer.valueOf(r13), 0}), ByteBuffer.class, "com.obric.memorydata.plugin");
    L17:
        throw new IllegalStateException("Unexpected value");     // Catch: Throwable -> L26
    L19:
        return (ByteBuffer) ZeusTransformUtils.preCheckCast(byteBufferConstructor.newInstance(new Object[]{Integer.valueOf(((int) r10) + r12), Integer.valueOf(r13)}), ByteBuffer.class, "com.obric.memorydata.plugin");
    L21:
        return (ByteBuffer) ZeusTransformUtils.preCheckCast(byteBufferConstructor.newInstance(new Object[]{Long.valueOf(r10 + ((long) r12)), Integer.valueOf(r13)}), ByteBuffer.class, "com.obric.memorydata.plugin");
    L23:
        return (ByteBuffer) ZeusTransformUtils.preCheckCast(byteBufferConstructor.newInstance(new Object[]{Long.valueOf(r10 + ((long) r12)), Integer.valueOf(r13), r14}), ByteBuffer.class, "com.obric.memorydata.plugin");
    L25:
        return (ByteBuffer) ZeusTransformUtils.preCheckCast(byteBufferConstructor.newInstance(new Object[]{Long.valueOf(r10 + ((long) r12)), Long.valueOf(r13)}), ByteBuffer.class, "com.obric.memorydata.plugin");
    L26:
        th = move-exception;
        throw new RuntimeException(th);
    L30:
        throw new IllegalStateException("Can't create a new DirectByteBuffer. In JDK17+, two JVM options needs to be set: --add-opens=java.base/java.nio=ALL-UNNAMED and --add-opens=java.base/sun.nio.ch=ALL-UNNAMED");
    }

    private static void setupCleanerJava6(final ByteBuffer r3) {
        Object r0 = AccessController.doPrivileged(new AnonymousClass1(r3));
        if (ZeusTransformUtils.instanceOf(r0, Throwable.class) == true) goto L11;
        mCleaner = (Method) ZeusTransformUtils.preCheckCast(r0, Method.class, "com.obric.memorydata.plugin");
        Object r4 = AccessController.doPrivileged(new AnonymousClass2(r3));
        if (ZeusTransformUtils.instanceOf(r4, Throwable.class) == true) goto L9;
        mClean = (Method) ZeusTransformUtils.preCheckCast(r4, Method.class, "com.obric.memorydata.plugin");
        return;
    L9:
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static void setupCleanerJava9(final ByteBuffer r3) {
        Object r4 = AccessController.doPrivileged(new AnonymousClass3(r3));
        if (ZeusTransformUtils.instanceOf(r4, Throwable.class) == true) goto L7;
        mInvokeCleaner = (Method) ZeusTransformUtils.preCheckCast(r4, Method.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
