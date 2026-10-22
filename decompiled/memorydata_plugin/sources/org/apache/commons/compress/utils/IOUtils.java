package org.apache.commons.compress.utils;

import com.obric.capabilitykit.common.ErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.LinkOption;

/* JADX INFO: loaded from: classes6.dex */
public final class IOUtils {
    public static final LinkOption[] EMPTY_LINK_OPTIONS = null;
    private static final byte[] SKIP_BUF = null;

    static {
        EMPTY_LINK_OPTIONS = new LinkOption[0];
        SKIP_BUF = new byte[4096];
    }

    public static void closeQuietly(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    public static long copyRange(InputStream r1, long r2, OutputStream r4) {
        return copyRange(r1, r2, r4, ErrorCode.EventTask.LOCATION_SELECTED_ID_CONDITION_EMPTY);
    }

    public static long copyRange(InputStream r8, long r9, OutputStream r11, int r12) {
        if (r12 < 1) goto L12;
        int r13 = (int) Math.min(r12, r9);
        byte[] r0 = new byte[r13];
        long r1 = 0;
    L6:
        if (r1 >= r9) goto L10;
        int r4 = r8.read(r0, 0, (int) Math.min(r9 - r1, r13));
        if ((-1) == r4) goto L10;
        r11.write(r0, 0, r4);
        r1 = r1 + ((long) r4);
    L10:
        return r1;
    L12:
        throw new IllegalArgumentException("buffersize must be bigger than 0");
    }

    public static int readFully(InputStream r3, byte[] r4, int r5, int r6) {
        if (r6 < 0) goto L15;
        if (r5 < 0) goto L15;
        int r0 = r6 + r5;
        if (r0 > r4.length) goto L15;
        if (r0 < 0) goto L15;
        int r1 = 0;
    L8:
        if (r1 == r6) goto L13;
        int r2 = r3.read(r4, r5 + r1, r6 - r1);
        if (r2 == (-1)) goto L13;
        r1 = r1 + r2;
    L13:
        return r1;
    L15:
        throw new IndexOutOfBoundsException();
    }

    public static void readFully(ReadableByteChannel r3, ByteBuffer r4) {
        ReadableByteChannel r5 = (ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, ReadableByteChannel.class, "com.obric.memorydata.plugin");
        int r0 = r4.remaining();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r5.read(r4);
        if (r2 <= 0) goto L8;
        r1 = r1 + r2;
    L8:
        if (r1 < r0) goto L11;
        return;
    L11:
        throw new EOFException();
    }

    public static byte[] readRange(InputStream r3, int r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        copyRange(r3, r4, r0);
        return r0.toByteArray();
    }

    public static byte[] readRange(ReadableByteChannel r6, int r7) {
        ReadableByteChannel r8 = (ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r6, ReadableByteChannel.class, "com.obric.memorydata.plugin");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        ByteBuffer r1 = ByteBuffer.allocate(Math.min(r7, ErrorCode.EventTask.LOCATION_SELECTED_ID_CONDITION_EMPTY));
        int r3 = 0;
    L3:
        if (r3 >= r7) goto L9;
        int r4 = r8.read(r1);
        if (r4 <= 0) goto L9;
        r0.write(r1.array(), 0, r4);
        r1.rewind();
        r3 = r3 + r4;
    L9:
        return r0.toByteArray();
    }

    public static long skip(InputStream r8, long r9) {
        long r0 = r9;
    L4:
        if (r0 <= 0) goto L10;
        long r4 = r8.skip(r0);
        if (r4 == 0) goto L10;
        r0 = r0 - r4;
    L10:
        if (r0 <= 0) goto L16;
        int r5 = readFully(r8, SKIP_BUF, 0, (int) Math.min(r0, 4096));
        if (r5 < 1) goto L16;
        r0 = r0 - ((long) r5);
    L16:
        return r9 - r0;
    }
}
