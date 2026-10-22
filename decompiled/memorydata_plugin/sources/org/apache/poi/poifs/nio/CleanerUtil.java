package org.apache.poi.poifs.nio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class CleanerUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BufferCleaner CLEANER = null;
    public static final String UNMAP_NOT_SUPPORTED_REASON = null;
    public static final boolean UNMAP_SUPPORTED = false;

    @FunctionalInterface
    public interface BufferCleaner {
        void freeBuffer(ByteBuffer r1);
    }

    static {
        Object r0 = AccessController.doPrivileged($$Lambda$CleanerUtil$7ZdcaVi7W9lWhbS2ExsJq2hbqE.INSTANCE);
        if (ZeusTransformUtils.instanceOf(r0, BufferCleaner.class) == false) goto L5;
        CLEANER = (BufferCleaner) ZeusTransformUtils.preCheckCast(r0, BufferCleaner.class, "com.obric.memorydata.plugin");
        UNMAP_SUPPORTED = true;
        UNMAP_NOT_SUPPORTED_REASON = null;
        return;
    L5:
        CLEANER = null;
        UNMAP_SUPPORTED = false;
        UNMAP_NOT_SUPPORTED_REASON = r0.toString();
    }

    private CleanerUtil() {
    }

    public static BufferCleaner getCleaner() {
        return CLEANER;
    }

    /* JADX INFO: renamed from: lambda$7ZdcaVi7W9lWhbS2E-xsJq2hbqE, reason: not valid java name */
    public static /* synthetic */ Object m3172lambda$7ZdcaVi7W9lWhbS2ExsJq2hbqE() {
        return unmapHackImpl();
    }

    static /* synthetic */ void lambda$newBufferCleaner$1(Class r1, final MethodHandle r2, final ByteBuffer r3) {
        if (r3.isDirect() == false) goto L14;
        if (ZeusTransformUtils.instanceOf(r1, r3) == false) goto L12;
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new $$Lambda$CleanerUtil$KjFiNXcxTUFAXYcXe1sz7AQTS0k(r2, r3)), Throwable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L10;
        return;
    L10:
        throw new IOException("Unable to unmap the mapped buffer", r4);
    L12:
        throw new IllegalArgumentException("buffer is not an instance of " + r1.getName());
    L14:
        throw new IllegalArgumentException("unmapping only works with direct buffers");
    }

    static /* synthetic */ Throwable lambda$null$0(MethodHandle r0, ByteBuffer r1) {
        (void) r0.invokeExact(r1);     // Catch: Throwable -> L5
        return null;
    L5:
        th = move-exception;
        return th;
    }

    private static BufferCleaner newBufferCleaner(final Class<?> r1, final MethodHandle r2) {
        return new $$Lambda$CleanerUtil$N6GZEA0VSta7qW3hfzbetKj3B8g(r1, r2);
    }

    private static Object unmapHackImpl() {
        MethodHandles.Lookup r1 = MethodHandles.lookup();
        Class<?> r4 = ZeusTransformUtils.forName("sun.misc.Unsafe", "com.obric.memorydata.plugin");     // Catch: Throwable -> L5 SecurityException -> L7
        MethodHandle r5 = r1.findVirtual(r4, "invokeCleaner", MethodType.methodType(Void.TYPE, ByteBuffer.class));     // Catch: Throwable -> L5 SecurityException -> L7
        Field r6 = r4.getDeclaredField("theUnsafe");     // Catch: Throwable -> L5 SecurityException -> L7
        r6.setAccessible(true);     // Catch: Throwable -> L5 SecurityException -> L7
        return newBufferCleaner(ByteBuffer.class, r5.bindTo(r6.get(null)));
    L5:
        Class r0 = ZeusTransformUtils.forName("java.nio.DirectByteBuffer", "com.obric.memorydata.plugin");     // Catch: Throwable -> L9 SecurityException -> L13
        Method r7 = r0.getMethod("cleaner", new Class[0]);     // Catch: Throwable -> L9 SecurityException -> L13
        r7.setAccessible(true);     // Catch: Throwable -> L9 SecurityException -> L13
        MethodHandle r8 = r1.unreflect(r7);     // Catch: Throwable -> L9 SecurityException -> L13
        Class<?> r9 = r8.type().returnType();     // Catch: Throwable -> L9 SecurityException -> L13
        MethodHandle r10 = r1.findVirtual(r9, "clean", MethodType.methodType(Void.TYPE));     // Catch: Throwable -> L9 SecurityException -> L13
        return newBufferCleaner(r0, MethodHandles.filterReturnValue(r8, MethodHandles.guardWithTest(r1.findStatic(Objects.class, "nonNull", MethodType.methodType(Boolean.TYPE, Object.class)).asType(MethodType.methodType(Boolean.TYPE, r9)), r10, MethodHandles.dropArguments(MethodHandles.constant(Void.class, null).asType(MethodType.methodType(Void.TYPE)), 0, new Class[]{r9}))).asType(MethodType.methodType(Void.TYPE, ByteBuffer.class)));
    L7:
        e = move-exception;
        throw e;     // Catch: Throwable -> L9 SecurityException -> L13
    L9:
        e = move-exception;
        StringBuilder r2 = new StringBuilder().append("Unmapping is not supported on this platform, because internal Java APIs are not compatible with this Hadoop version: ").append(e);
    L12:
        return r2.toString();
    L13:
        e = move-exception;
        r2 = new StringBuilder().append("Unmapping is not supported, because not all required permissions are given to the Hadoop JAR file: ").append(e).append(" [Please grant at least the following permissions: RuntimePermission(\"accessClassInPackage.sun.misc\")  and ReflectPermission(\"suppressAccessChecks\")]");
        goto L12
    }
}
