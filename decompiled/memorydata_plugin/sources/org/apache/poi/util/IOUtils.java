package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Locale;
import java.util.zip.CRC32;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.EmptyFileException;

/* JADX INFO: loaded from: classes7.dex */
public final class IOUtils {
    private static int BYTE_ARRAY_MAX_OVERRIDE;
    private static final c LOG = null;
    private static int MAX_BYTE_ARRAY_INIT_SIZE;
    private static byte[] SKIP_BYTE_BUFFER;

    static {
        LOG = b.a(IOUtils.class);
        BYTE_ARRAY_MAX_OVERRIDE = -1;
        MAX_BYTE_ARRAY_INIT_SIZE = -1;
    }

    private IOUtils() {
    }

    static int calculateByteArrayInitLength(boolean r0, int r1, int r2) {
        int r3 = Math.min(r1, r2);
        if (r0 == true) goto L6;
        r3 = Math.min(4096, r3);
    L6:
        int r4 = MAX_BYTE_ARRAY_INIT_SIZE;
        if (r4 <= 0) goto L10;
        if (r3 <= r4) goto L10;
        return r4;
    L10:
        return r3;
    }

    public static long calculateChecksum(InputStream r4) {
        CRC32 r0 = new CRC32();
        byte[] r1 = new byte[4096];
    L3:
        int r2 = r4.read(r1);
        if (r2 == (-1)) goto L8;
        if (r2 <= 0) goto L3;
        r0.update(r1, 0, r2);
        goto L3
    L8:
        return r0.getValue();
    }

    public static long calculateChecksum(byte[] r3) {
        CRC32 r0 = new CRC32();
        r0.update(r3, 0, r3.length);
        return r0.getValue();
    }

    private static void checkByteSizeLimit(int r3) {
        int r0 = BYTE_ARRAY_MAX_OVERRIDE;
        if (r0 == (-1)) goto L7;
        if (r3 <= r0) goto L8;
        throwRFE(r3, r0);
        return;
    L8:
        return;
    }

    private static void checkLength(long r3, int r5) {
        int r0 = BYTE_ARRAY_MAX_OVERRIDE;
        if (r0 <= 0) goto L8;
        if (r3 <= r0) goto L11;
        throwRFE(r3, r0);
        return;
    L11:
        return;
    L8:
        if (r3 <= r5) goto L13;
        throwRFE(r3, r5);
        return;
    }

    public static void closeQuietly(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        r3.close();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        LOG.atError().a(e).a("Unable to close resource");
    }

    public static long copy(InputStream r2, File r3) {
        File r0 = r3.getParentFile();
        if (r0.exists() == false) goto L5;
    L9:
        FileOutputStream r1 = new FileOutputStream(r3);
        long r4 = copy(r2, r1);     // Catch: Throwable -> L13
        r1.close();
        return r4;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    L5:
        if (r0.mkdirs() == true) goto L9;
        throw new RuntimeException("Can't create destination directory: " + r0);
    }

    public static long copy(InputStream r2, OutputStream r3) {
        return copy(r2, r3, -1);
    }

    public static long copy(InputStream r11, OutputStream r12, long r13) {
        byte[] r0 = new byte[4096];
        int r3 = -1;
        long r4 = 0;
    L3:
        long r7 = 4096;
        if (r13 < 0) goto L7;
        r7 = Math.min(r13 - r4, 4096);
    L7:
        int r6 = (int) r7;
        if (r6 <= 0) goto L13;
        int r8 = r11.read(r0, 0, r6);
        if (r8 <= 0) goto L12;
        r12.write(r0, 0, r8);
        r4 = r4 + ((long) r8);
    L12:
        r3 = r8;
    L13:
        if (r3 < 0) goto L18;
        if (r13 == (-1)) goto L3;
        if (r4 < r13) goto L3;
    L18:
        return r4;
    }

    public static byte[] peekFirstNBytes(InputStream r4, int r5) {
        checkByteSizeLimit(r5);
        r4.mark(r5);
        UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream(r5);
        copy(new BoundedInputStream(r4, r5), r0);
        int r1 = r0.size();
        if (r1 == 0) goto L12;
        if (r1 >= r5) goto L6;
        r0.write(new byte[r5 - r1]);
    L6:
        byte[] r6 = r0.toByteArray();
        if (ZeusTransformUtils.instanceOf(r4, PushbackInputStream.class) == false) goto L9;
        ((PushbackInputStream) ZeusTransformUtils.preCheckCast(r4, PushbackInputStream.class, "com.obric.memorydata.plugin")).unread(r6, 0, r1);
    L10:
        return r6;
    L9:
        r4.reset();
        goto L10
    L12:
        throw new EmptyFileException();
    }

    public static int readFully(InputStream r2, byte[] r3) {
        return readFully(r2, r3, 0, r3.length);
    }

    public static int readFully(InputStream r3, byte[] r4, int r5, int r6) {
        int r0 = 0;
    L3:
        int r1 = r3.read(r4, r5 + r0, r6 - r0);
        if (r1 < 0) goto L5;
        r0 = r0 + r1;
        if (r0 != r6) goto L3;
        return r0;
    L5:
        if (r0 != 0) goto L14;
        return -1;
    L14:
        return r0;
    }

    public static int readFully(ReadableByteChannel r3, ByteBuffer r4) {
        ReadableByteChannel r5 = (ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, ReadableByteChannel.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        int r1 = r5.read(r4);
        if (r1 < 0) goto L5;
        r0 = r0 + r1;
        if (r0 == r4.capacity()) goto L12;
        if (r4.position() != r4.capacity()) goto L3;
    L12:
        return r0;
    L5:
        if (r0 != 0) goto L17;
        return -1;
    L17:
        return r0;
    }

    public static byte[] safelyAllocate(long r0, int r2) {
        safelyAllocateCheck(r0, r2);
        int r1 = (int) r0;
        checkByteSizeLimit(r1);
        return new byte[r1];
    }

    public static void safelyAllocateCheck(long r3, int r5) {
        if (r3 < 0) goto L11;
        if (r3 > 2147483647L) goto L9;
        checkLength(r3, r5);
        return;
    L9:
        throw new RecordFormatException("Can't allocate an array > 2147483647");
    L11:
        throw new RecordFormatException("Can't allocate an array of length < 0, but had " + r3 + " and " + r5);
    }

    public static byte[] safelyClone(byte[] r2, int r3, int r4, int r5) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r3 < 0) goto L11;
        if (r4 < 0) goto L11;
        if (r5 < 0) goto L11;
        int r6 = Math.min(r2.length - r3, r4);
        safelyAllocateCheck(r6, r5);
        return Arrays.copyOfRange(r2, r3, r6 + r3);
    L11:
        throw new RecordFormatException("Invalid offset/length specified: offset: " + r3 + ", lenght: " + r4 + ", maxLength: " + r5);
    }

    public static long skipFully(InputStream r8, long r9) {
        if (r9 < 0) goto L23;
        if (r9 != 0) goto L7;
        return 0;
    L7:
        if (SKIP_BYTE_BUFFER != null) goto L9;
        SKIP_BYTE_BUFFER = new byte[2048];
    L9:
        long r2 = r9;
    L11:
        if (r2 <= 0) goto L17;
        long r4 = r8.read(SKIP_BYTE_BUFFER, 0, (int) Math.min(r2, 2048));
        if (r4 < 0) goto L17;
        r2 = r2 - r4;
    L17:
        if (r9 != r2) goto L21;
        return -1;
    L21:
        return r9 - r2;
    L23:
        throw new IllegalArgumentException("Skip count must be non-negative, actual: " + r9);
    }

    private static void throwRFE(long r3, int r5) {
        throw new RecordFormatException(String.format(Locale.ROOT, "Tried to allocate an array of length %,d, but the maximum length for this record type is %,d.\nIf the file is not corrupt and not large, please open an issue on bugzilla to request \nincreasing the maximum allowable size for this record type.\nYou can set a higher override value with IOUtils.setByteArrayMaxOverride()", new Object[]{Long.valueOf(r3), Integer.valueOf(r5)}));
    }

    private static void throwRecordTruncationException(int r4) {
        throw new RecordFormatException(String.format(Locale.ROOT, "Tried to read data but the maximum length for this record type is %,d.\nIf the file is not corrupt and not large, please open an issue on bugzilla to request \nincreasing the maximum allowable size for this record type.\nYou can set a higher override value with IOUtils.setByteArrayMaxOverride()", new Object[]{Integer.valueOf(r4)}));
    }

    public static byte[] toByteArray(InputStream r1, int r2) {
        return toByteArray(r1, r2, Integer.MAX_VALUE);
    }

    public static byte[] toByteArray(InputStream r2, int r3, int r4) {
        if (r3 == Integer.MAX_VALUE) goto L5;
        boolean r1 = true;
    L7:
        return toByteArray(r2, r3, r4, true, r1);
    L5:
        r1 = false;
        goto L7
    }

    private static byte[] toByteArray(InputStream r8, int r9, int r10, boolean r11, boolean r12) {
        if (r9 < 0) goto L44;
        if (r10 < 0) goto L44;
        int r13 = Math.max(r10, BYTE_ARRAY_MAX_OVERRIDE);
        if (r9 != Integer.MAX_VALUE) goto L7;
        if (r13 != Integer.MAX_VALUE) goto L7;
    L8:
        if (r12 == false) goto L10;
        int r1 = Math.min(r9, r13);
    L11:
        UnsynchronizedByteArrayOutputStream r2 = new UnsynchronizedByteArrayOutputStream(calculateByteArrayInitLength(r12, r9, r13));
        byte[] r3 = new byte[4096];     // Catch: Throwable -> L35
        int r5 = 0;
    L13:
        int r6 = r8.read(r3, 0, Math.min(4096, r1 - r5));     // Catch: Throwable -> L35
        r5 = r5 + Math.max(r6, 0);     // Catch: Throwable -> L35
        if (r6 <= 0) goto L16;
        r2.write(r3, 0, r6);     // Catch: Throwable -> L35
    L16:
        checkByteSizeLimit(r5);     // Catch: Throwable -> L35
        if (r5 >= r1) goto L20;
        if (r6 > (-1)) goto L13;
    L20:
        if (BYTE_ARRAY_MAX_OVERRIDE >= 0) goto L26;
        if (r6 <= (-1)) goto L26;
        if (r12 == true) goto L26;
        if (r8.read() < 0) goto L26;
        throwRecordTruncationException(r13);     // Catch: Throwable -> L35
    L26:
        if (r11 == false) goto L32;
        if (r1 == Integer.MAX_VALUE) goto L32;
        if (r5 >= r1) goto L32;
        throw new EOFException("unexpected EOF - expected len: " + r1 + " - actual len: " + r5);     // Catch: Throwable -> L35
    L32:
        byte[] r14 = r2.toByteArray();     // Catch: Throwable -> L35
        r2.close();
        return r14;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L40
    L42:
        throw th;
    L40:
        th = move-exception;
        th.addSuppressed(th);
        goto L42
    L10:
        r1 = r13;
    L7:
        checkLength(r9, r13);
    L44:
        throw new RecordFormatException("Can't allocate an array of length < 0");
    }

    public static byte[] toByteArray(ByteBuffer r1, int r2) {
        if (r1.hasArray() == true) goto L5;
    L8:
        checkByteSizeLimit(r2);
        byte[] r3 = new byte[r2];
        r1.get(r3);
        return r3;
    L5:
        if (r1.arrayOffset() != 0) goto L8;
        return r1.array();
    }

    public static byte[] toByteArrayWithMaxLength(InputStream r1, int r2) {
        return toByteArray(r1, r2, r2, false, false);
    }
}
