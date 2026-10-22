package androidx.profileinstaller;

import ai.j0;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
    }

    public static int bitsToBytes(int r5) {
        return ((r5 + 7) & (-8)) / 8;
    }

    public static byte[] compress(@NonNull byte[] r5) throws IOException {
        Deflater r10 = new Deflater(1);
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        DeflaterOutputStream r12 = new DeflaterOutputStream(r11, r10);     // Catch: Throwable -> L8
        r12.write(r5);     // Catch: Throwable -> L10
        r12.close();     // Catch: Throwable -> L8
        r10.end();
        return r11.toByteArray();
    L10:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Throwable -> L8
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r10.end();
        throw th;
    }

    @NonNull
    public static RuntimeException error(@Nullable String r5) {
        return new IllegalStateException(r5);
    }

    @NonNull
    public static byte[] read(@NonNull InputStream r5, int r10) throws IOException {
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L9;
        int r13 = r5.read(r11, r12, r10 - r12);
        if (r13 < 0) goto L8;
        r12 = r12 + r13;
        goto L3
    L8:
        throw error(j0.g(r10, "Not enough bytes to read: "));
    L9:
        return r11;
    }

    @NonNull
    public static byte[] readCompressed(@NonNull InputStream r10, int r11, int r12) throws IOException {
        Inflater r5 = new Inflater();
        byte[] r13 = new byte[r12];     // Catch: Throwable -> L15
        byte[] r14 = new byte[2048];     // Catch: Throwable -> L15
        int r15 = 0;
        int r16 = 0;
    L5:
        if (r5.finished() == true) goto L22;
        if (r5.needsDictionary() == true) goto L22;
        if (r15 >= r11) goto L22;
        int r17 = r10.read(r14);     // Catch: Throwable -> L15
        if (r17 < 0) goto L21;
        r5.setInput(r14, 0, r17);     // Catch: Throwable -> L15
        r16 = r16 + r5.inflate(r13, r16, r12 - r16);
        r15 = r15 + r17;
        goto L5
    L17:
        e = move-exception;
        throw error(e.getMessage());     // Catch: Throwable -> L15
    L21:
        throw error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + r11 + " bytes");     // Catch: Throwable -> L15
    L22:
        if (r15 != r11) goto L30;
        if (r5.finished() == false) goto L28;
        r5.end();
        return r13;
    L28:
        throw error("Inflater did not finish");     // Catch: Throwable -> L15
    L30:
        throw error("Didn't read enough bytes during decompression. expected=" + r11 + " actual=" + r15);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r5.end();
        throw th;
    }

    @NonNull
    public static String readString(InputStream r5, int r10) throws IOException {
        return new String(read(r5, r10), StandardCharsets.UTF_8);
    }

    public static long readUInt(@NonNull InputStream r10, int r11) throws IOException {
        byte[] r12 = read(r10, r11);
        long r5 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r5 = r5 + (((long) (r12[r13] & UByte.MAX_VALUE)) << (r13 * 8));
        r13 = r13 + 1;
        goto L3
    L5:
        return r5;
    }

    public static int readUInt16(@NonNull InputStream r5) throws IOException {
        return (int) readUInt(r5, 2);
    }

    public static long readUInt32(@NonNull InputStream r5) throws IOException {
        return readUInt(r5, 4);
    }

    public static int readUInt8(@NonNull InputStream r5) throws IOException {
        return (int) readUInt(r5, 1);
    }

    public static int utf8Length(@NonNull String r5) {
        return r5.getBytes(StandardCharsets.UTF_8).length;
    }

    public static void writeAll(@NonNull InputStream r5, @NonNull OutputStream r10) throws IOException {
        byte[] r11 = new byte[512];
    L3:
        int r12 = r5.read(r11);
        if (r12 <= 0) goto L6;
        r10.write(r11, 0, r12);
        goto L3
    }

    public static void writeCompressed(@NonNull OutputStream r5, byte[] r10) throws IOException {
        writeUInt32(r5, r10.length);
        byte[] r11 = compress(r10);
        writeUInt32(r5, r11.length);
        r5.write(r11);
    }

    public static void writeString(@NonNull OutputStream r5, @NonNull String r10) throws IOException {
        r5.write(r10.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeUInt(@NonNull OutputStream r10, long r11, int r12) throws IOException {
        byte[] r5 = new byte[r12];
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r5[r13] = (byte) ((r11 >> (r13 * 8)) & 255);
        r13 = r13 + 1;
        goto L3
    L5:
        r10.write(r5);
    }

    public static void writeUInt16(@NonNull OutputStream r5, int r10) throws IOException {
        writeUInt(r5, r10, 2);
    }

    public static void writeUInt32(@NonNull OutputStream r5, long r10) throws IOException {
        writeUInt(r5, r10, 4);
    }

    public static void writeUInt8(@NonNull OutputStream r5, int r10) throws IOException {
        writeUInt(r5, r10, 1);
    }
}
