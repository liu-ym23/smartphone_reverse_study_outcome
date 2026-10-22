package androidx.profileinstaller;

import com.obric.sva.sdk.data.ISmModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
    }

    public static int bitsToBytes(int r0) {
        return (((r0 + 8) - 1) & (-8)) / 8;
    }

    public static byte[] compress(byte[] r3) throws IOException {
        Deflater r0 = new Deflater(1);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        DeflaterOutputStream r2 = new DeflaterOutputStream(r1, r0);     // Catch: Throwable -> L14
        r2.write(r3);     // Catch: Throwable -> L8
        r2.close();     // Catch: Throwable -> L14
        r0.end();
        return r1.toByteArray();
    L8:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r0.end();
        throw th;
    }

    public static RuntimeException error(String r1) {
        return new IllegalStateException(r1);
    }

    public static int readUInt16(InputStream r2) throws IOException {
        return (int) readUInt(r2, 2);
    }

    public static long readUInt32(InputStream r2) throws IOException {
        return readUInt(r2, 4);
    }

    public static int readUInt8(InputStream r2) throws IOException {
        return (int) readUInt(r2, 1);
    }

    public static int utf8Length(String r1) {
        return r1.getBytes(StandardCharsets.UTF_8).length;
    }

    public static byte[] read(InputStream r3, int r4) throws IOException {
        byte[] r0 = new byte[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L9;
        int r2 = r3.read(r0, r1, r4 - r1);
        if (r2 < 0) goto L8;
        r1 = r1 + r2;
        goto L3
    L8:
        throw error("Not enough bytes to read: " + r4);
    L9:
        return r0;
    }

    public static String readString(InputStream r1, int r2) throws IOException {
        return new String(read(r1, r2), StandardCharsets.UTF_8);
    }

    public static long readUInt(InputStream r6, int r7) throws IOException {
        byte[] r8 = read(r6, r7);
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L5;
        r0 = r0 + (((long) (r8[r2] & 255)) << (r2 * 8));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static void writeCompressed(OutputStream r2, byte[] r3) throws IOException {
        writeUInt32(r2, r3.length);
        byte[] r4 = compress(r3);
        writeUInt32(r2, r4.length);
        r2.write(r4);
    }

    public static void writeString(OutputStream r1, String r2) throws IOException {
        r1.write(r2.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeUInt16(OutputStream r2, int r3) throws IOException {
        writeUInt(r2, r3, 2);
    }

    public static void writeUInt32(OutputStream r1, long r2) throws IOException {
        writeUInt(r1, r2, 4);
    }

    public static void writeUInt8(OutputStream r2, int r3) throws IOException {
        writeUInt(r2, r3, 1);
    }

    public static byte[] readCompressed(InputStream r8, int r9, int r10) throws IOException {
        Inflater r0 = new Inflater();
        byte[] r1 = new byte[r10];     // Catch: Throwable -> L29
        byte[] r2 = new byte[2048];     // Catch: Throwable -> L29
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r0.finished() == true) goto L20;
        if (r0.needsDictionary() == true) goto L20;
        if (r4 >= r9) goto L20;
        int r6 = r8.read(r2);     // Catch: Throwable -> L29
        if (r6 < 0) goto L19;
        r0.setInput(r2, 0, r6);     // Catch: Throwable -> L29
        r5 = r5 + r0.inflate(r1, r5, r10 - r5);
        r4 = r4 + r6;
        goto L5
    L15:
        e = move-exception;
        throw error(e.getMessage());     // Catch: Throwable -> L29
    L19:
        throw error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + r9 + " bytes");     // Catch: Throwable -> L29
    L20:
        if (r4 != r9) goto L28;
        if (r0.finished() == false) goto L26;
        r0.end();
        return r1;
    L26:
        throw error("Inflater did not finish");     // Catch: Throwable -> L29
    L28:
        throw error("Didn't read enough bytes during decompression. expected=" + r9 + " actual=" + r4);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r0.end();
        throw th;
    }

    public static void writeAll(InputStream r2, OutputStream r3, FileLock r4) throws IOException {
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L15;
        byte[] r6 = new byte[ISmModel.VERSION_0200];
    L10:
        int r1 = r2.read(r6);
        if (r1 <= 0) goto L13;
        r3.write(r6, 0, r1);
        goto L10
    L13:
        return;
    L15:
        throw new IOException("Unable to acquire a lock on the underlying file channel.");
    L5:
        if (r4.isValid() == false) goto L7;
        r5 = true;
        goto L8
    }

    public static void writeUInt(OutputStream r6, long r7, int r9) throws IOException {
        byte[] r0 = new byte[r9];
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L5;
        r0[r1] = (byte) ((r7 >> (r1 * 8)) & 255);
        r1 = r1 + 1;
        goto L3
    L5:
        r6.write(r0);
    }
}
