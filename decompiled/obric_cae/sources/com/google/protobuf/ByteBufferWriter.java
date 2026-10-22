package com.google.protobuf;

import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes.dex */
final class ByteBufferWriter {
    private static final ThreadLocal<SoftReference<byte[]>> BUFFER = null;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final long CHANNEL_FIELD_OFFSET = 0;
    private static final Class<?> FILE_OUTPUT_STREAM_CLASS = null;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;

    static {
        BUFFER = new ThreadLocal();
        Class<?> r8 = safeGetClass("java.io.FileOutputStream");
        FILE_OUTPUT_STREAM_CLASS = r8;
        CHANNEL_FIELD_OFFSET = getChannelFieldOffset(r8);
    }

    private ByteBufferWriter() {
    }

    public static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    private static byte[] getBuffer() {
        SoftReference<byte[]> r8 = BUFFER.get();
        if (r8 != null) goto L6;
        return null;
    L6:
        return r8.get();
    }

    private static long getChannelFieldOffset(Class<?> r8) {
        if (r8 != null) goto L10;
        return -1;
    L10:
        if (UnsafeUtil.hasUnsafeArrayOperations() == false) goto L12;
        return UnsafeUtil.objectFieldOffset(r8.getDeclaredField("channel"));
    L12:
        return -1;
    L13:
        return -1;
    }

    private static byte[] getOrCreateBuffer(int r8) {
        int r10 = Math.max(r8, 1024);
        byte[] r11 = getBuffer();
        if (r11 != null) goto L5;
    L6:
        r11 = new byte[r10];
        if (r10 > 16384) goto L9;
        setBuffer(r11);
    L9:
        return r11;
    L5:
        if (needToReallocate(r10, r11.length) == false) goto L9;
        goto L6
    }

    private static boolean needToReallocate(int r8, int r10) {
        if (r10 < r8) goto L4;
    L6:
        return false;
    L4:
        if (r10 >= (r8 * BUFFER_REALLOCATION_THRESHOLD)) goto L6;
        return true;
    }

    private static Class<?> safeGetClass(String r8) {
        return Class.forName(r8);
    L4:
        return null;
    }

    private static void setBuffer(byte[] r8) {
        BUFFER.set(new SoftReference(r8));
    }

    public static void write(ByteBuffer r8, OutputStream r10) {
        int r11 = r8.position();
    L15:
        th = move-exception;
        Java8Compatibility.position(r8, r11);
        throw th;
    L4:
        if (r8.hasArray() == false) goto L7;
        r10.write(r8.array(), r8.arrayOffset() + r8.position(), r8.remaining());     // Catch: Throwable -> L15
    L13:
        Java8Compatibility.position(r8, r11);
        return;
    L7:
        if (writeToChannel(r8, r10) == true) goto L13;
        byte[] r12 = getOrCreateBuffer(r8.remaining());     // Catch: Throwable -> L15
    L10:
        if (r8.hasRemaining() == false) goto L13;
        int r13 = Math.min(r8.remaining(), r12.length);     // Catch: Throwable -> L15
        r8.get(r12, 0, r13);     // Catch: Throwable -> L15
        r10.write(r12, 0, r13);     // Catch: Throwable -> L15
        goto L10
    }

    private static boolean writeToChannel(ByteBuffer r8, OutputStream r10) {
        long r11 = CHANNEL_FIELD_OFFSET;
        if (r11 >= 0) goto L5;
        return false;
    L5:
        if (FILE_OUTPUT_STREAM_CLASS.isInstance(r10) == false) goto L16;
        WritableByteChannel r12 = (WritableByteChannel) UnsafeUtil.getObject(r10, r11);     // Catch: ClassCastException -> L8
    L9:
        if (r12 == null) goto L17;
        r12.write(r8);
        return true;
    L17:
        return false;
    L8:
        r12 = null;
        goto L9
    L16:
        return false;
    }
}
