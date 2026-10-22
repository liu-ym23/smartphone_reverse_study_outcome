package com.google.protobuf;

import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
final class ByteBufferWriter {
    private static final ThreadLocal<SoftReference<byte[]>> BUFFER = null;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final long CHANNEL_FIELD_OFFSET = 0;
    private static final Class<?> FILE_OUTPUT_STREAM_CLASS = null;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;

    static {
        BUFFER = new ThreadLocal();
        Class<?> r10 = safeGetClass("java.io.FileOutputStream");
        FILE_OUTPUT_STREAM_CLASS = r10;
        CHANNEL_FIELD_OFFSET = getChannelFieldOffset(r10);
    }

    private ByteBufferWriter() {
    }

    static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    private static byte[] getBuffer() {
        SoftReference<byte[]> r10 = BUFFER.get();
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.get();
    }

    private static long getChannelFieldOffset(Class<?> r10) {
        if (r10 != null) goto L10;
        return -1;
    L10:
        if (UnsafeUtil.hasUnsafeArrayOperations() == false) goto L12;
        return UnsafeUtil.objectFieldOffset(r10.getDeclaredField("channel"));
    L12:
        return -1;
    L13:
        return -1;
    }

    private static byte[] getOrCreateBuffer(int r10) {
        int r11 = Math.max(r10, 1024);
        byte[] r12 = getBuffer();
        if (r12 != null) goto L5;
    L6:
        r12 = new byte[r11];
        if (r11 > 16384) goto L9;
        setBuffer(r12);
    L9:
        return r12;
    L5:
        if (needToReallocate(r11, r12.length) == false) goto L9;
        goto L6
    }

    private static boolean needToReallocate(int r10, int r11) {
        if (r11 < r10) goto L4;
    L6:
        return false;
    L4:
        if (r11 >= (r10 * 0.5f)) goto L6;
        return true;
    }

    private static Class<?> safeGetClass(String r10) {
        return Class.forName(r10);
    L4:
        return null;
    }

    private static void setBuffer(byte[] r10) {
        BUFFER.set(new SoftReference(r10));
    }

    static void write(ByteBuffer r10, OutputStream r11) {
        int r12 = r10.position();
    L15:
        th = move-exception;
        Java8Compatibility.position(r10, r12);
        throw th;
    L4:
        if (r10.hasArray() == false) goto L7;
        r11.write(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining());     // Catch: Throwable -> L15
    L13:
        Java8Compatibility.position(r10, r12);
        return;
    L7:
        if (writeToChannel(r10, r11) == true) goto L13;
        byte[] r13 = getOrCreateBuffer(r10.remaining());     // Catch: Throwable -> L15
    L10:
        if (r10.hasRemaining() == false) goto L13;
        int r14 = Math.min(r10.remaining(), r13.length);     // Catch: Throwable -> L15
        r10.get(r13, 0, r14);     // Catch: Throwable -> L15
        r11.write(r13, 0, r14);     // Catch: Throwable -> L15
        goto L10
    }

    private static boolean writeToChannel(ByteBuffer r10, OutputStream r11) {
        long r12 = CHANNEL_FIELD_OFFSET;
        if (r12 >= 0) goto L5;
        return false;
    L5:
        if (FILE_OUTPUT_STREAM_CLASS.isInstance(r11) == false) goto L17;
        WritableByteChannel r13 = null;
        r13 = (WritableByteChannel) UnsafeUtil.getObject(r11, r12);     // Catch: ClassCastException -> L14
    L9:
        if (r13 == null) goto L18;
        r13.write(r10);
        return true;
    L18:
        return false;
    L17:
        return false;
    }
}
