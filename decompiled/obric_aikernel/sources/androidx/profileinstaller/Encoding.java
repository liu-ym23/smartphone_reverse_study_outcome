package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
    }

    static int bitsToBytes(int r10) {
        return (((r10 + 8) - 1) & (-8)) / 8;
    }

    static byte[] compress(@NonNull byte[] r10) {
        Deflater r11 = new Deflater(1);
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        DeflaterOutputStream r13 = new DeflaterOutputStream(r12, r11);     // Catch: Throwable -> L14
        r13.write(r10);     // Catch: Throwable -> L8
        r13.close();     // Catch: Throwable -> L14
        r11.end();
        return r12.toByteArray();
    L8:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r11.end();
        throw th;
    }

    @NonNull
    static RuntimeException error(@Nullable String r10) {
        return new IllegalStateException(r10);
    }

    @NonNull
    static byte[] read(@NonNull InputStream r10, int r11) {
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L9;
        int r14 = r10.read(r12, r13, r11 - r13);
        if (r14 < 0) goto L8;
        r13 = r13 + r14;
        goto L3
    L8:
        throw error("Not enough bytes to read: " + r11);
    L9:
        return r12;
    }

    @NonNull
    static byte[] readCompressed(@NonNull InputStream r10, int r11, int r12) {
        Inflater r13 = new Inflater();
        byte[] r14 = new byte[r12];     // Catch: Throwable -> L29
        byte[] r15 = new byte[2048];     // Catch: Throwable -> L29
        int r16 = 0;
        int r17 = 0;
    L5:
        if (r13.finished() == true) goto L20;
        if (r13.needsDictionary() == true) goto L20;
        if (r16 >= r11) goto L20;
        int r18 = r10.read(r15);     // Catch: Throwable -> L29
        if (r18 < 0) goto L19;
        r13.setInput(r15, 0, r18);     // Catch: Throwable -> L29
        r17 = r17 + r13.inflate(r14, r17, r12 - r17);
        r16 = r16 + r18;
        goto L5
    L15:
        e = move-exception;
        throw error(e.getMessage());     // Catch: Throwable -> L29
    L19:
        throw error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + r11 + " bytes");     // Catch: Throwable -> L29
    L20:
        if (r16 != r11) goto L28;
        if (r13.finished() == false) goto L26;
        r13.end();
        return r14;
    L26:
        throw error("Inflater did not finish");     // Catch: Throwable -> L29
    L28:
        throw error("Didn't read enough bytes during decompression. expected=" + r11 + " actual=" + r16);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r13.end();
        throw th;
    }

    @NonNull
    static String readString(InputStream r10, int r11) {
        return new String(read(r10, r11), StandardCharsets.UTF_8);
    }

    static long readUInt(@NonNull InputStream r10, int r11) {
        byte[] r12 = read(r10, r11);
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13 = r13 + (((long) (r12[r14] & 255)) << (r14 * 8));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    static int readUInt16(@NonNull InputStream r10) {
        return (int) readUInt(r10, 2);
    }

    static long readUInt32(@NonNull InputStream r10) {
        return readUInt(r10, 4);
    }

    static int readUInt8(@NonNull InputStream r10) {
        return (int) readUInt(r10, 1);
    }

    static int utf8Length(@NonNull String r10) {
        return r10.getBytes(StandardCharsets.UTF_8).length;
    }

    static void writeAll(@NonNull InputStream r10, @NonNull OutputStream r11) {
        byte[] r12 = new byte[512];
    L3:
        int r13 = r10.read(r12);
        if (r13 <= 0) goto L6;
        r11.write(r12, 0, r13);
        goto L3
    }

    static void writeCompressed(@NonNull OutputStream r10, byte[] r11) {
        writeUInt32(r10, r11.length);
        byte[] r12 = compress(r11);
        writeUInt32(r10, r12.length);
        r10.write(r12);
    }

    static void writeString(@NonNull OutputStream r10, @NonNull String r11) {
        r10.write(r11.getBytes(StandardCharsets.UTF_8));
    }

    static void writeUInt(@NonNull OutputStream r10, long r11, int r12) {
        byte[] r13 = new byte[r12];
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13[r14] = (byte) ((r11 >> (r14 * 8)) & 255);
        r14 = r14 + 1;
        goto L3
    L5:
        r10.write(r13);
    }

    static void writeUInt16(@NonNull OutputStream r10, int r11) {
        writeUInt(r10, r11, 2);
    }

    static void writeUInt32(@NonNull OutputStream r10, long r11) {
        writeUInt(r10, r11, 4);
    }

    static void writeUInt8(@NonNull OutputStream r10, int r11) {
        writeUInt(r10, r11, 1);
    }
}
