package androidx.room.jarjarred.org.antlr.v4.runtime;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/* JADX INFO: loaded from: classes.dex */
public final class CharStreams {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    private CharStreams() {
    }

    public static CharStream fromChannel(ReadableByteChannel r5) throws IOException {
        return fromChannel(r5, StandardCharsets.UTF_8);
    }

    public static CharStream fromFileName(String r5) throws IOException {
        return fromPath(Paths.get(r5, new String[0]), StandardCharsets.UTF_8);
    }

    public static CharStream fromPath(Path r5) throws IOException {
        return fromPath(r5, StandardCharsets.UTF_8);
    }

    public static CodePointCharStream fromReader(Reader r5) throws IOException {
        return fromReader(r5, IntStream.UNKNOWN_SOURCE_NAME);
    }

    public static CharStream fromStream(InputStream r5) throws IOException {
        return fromStream(r5, StandardCharsets.UTF_8);
    }

    public static CodePointCharStream fromString(String r5) {
        return fromString(r5, IntStream.UNKNOWN_SOURCE_NAME);
    }

    public static CharStream fromChannel(ReadableByteChannel r5, Charset r10) throws IOException {
        return fromChannel(r5, 4096, CodingErrorAction.REPLACE, IntStream.UNKNOWN_SOURCE_NAME);
    }

    public static CharStream fromFileName(String r5, Charset r10) throws IOException {
        return fromPath(Paths.get(r5, new String[0]), r10);
    }

    public static CharStream fromPath(Path r10, Charset r11) throws IOException {
        long r5 = Files.size(r10);
        SeekableByteChannel r12 = Files.newByteChannel(r10, new OpenOption[0]);
        CodePointCharStream r13 = fromChannel(r12, r11, 4096, CodingErrorAction.REPLACE, r10.toString(), r5);     // Catch: Throwable -> L7
        if (r12 == null) goto L6;
        r12.close();
    L6:
        return r13;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r12 != null) goto L18;
    L15:
        throw th;
    L18:
        r12.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public static CodePointCharStream fromReader(Reader r5, String r10) throws IOException {
        CodePointBuffer.Builder r11 = CodePointBuffer.builder(4096);     // Catch: Throwable -> L7
        CharBuffer r12 = CharBuffer.allocate(4096);     // Catch: Throwable -> L7
    L5:
        if (r5.read(r12) == (-1)) goto L9;
        r12.flip();     // Catch: Throwable -> L7
        r11.append(r12);     // Catch: Throwable -> L7
        r12.compact();     // Catch: Throwable -> L7
        goto L5
    L9:
        CodePointCharStream r13 = CodePointCharStream.fromBuffer(r11.build(), r10);     // Catch: Throwable -> L7
        r5.close();
        return r13;
    L7:
        th = move-exception;
        r5.close();
        throw th;
    }

    public static CharStream fromStream(InputStream r5, Charset r10) throws IOException {
        return fromStream(r5, r10, -1);
    }

    public static CodePointCharStream fromString(String r5, String r10) {
        CodePointBuffer.Builder r11 = CodePointBuffer.builder(r5.length());
        CharBuffer r12 = CharBuffer.allocate(r5.length());
        r12.put(r5);
        r12.flip();
        r11.append(r12);
        return CodePointCharStream.fromBuffer(r11.build(), r10);
    }

    public static CodePointCharStream fromChannel(ReadableByteChannel r10, int r11, CodingErrorAction r12, String r13) throws IOException {
        return fromChannel(r10, StandardCharsets.UTF_8, r11, r12, r13, -1);
    }

    public static CharStream fromStream(InputStream r10, Charset r11, long r12) throws IOException {
        ReadableByteChannel r13 = Channels.newChannel(r10);
        CodePointCharStream r14 = fromChannel(r13, r11, 4096, CodingErrorAction.REPLACE, IntStream.UNKNOWN_SOURCE_NAME, r12);     // Catch: Throwable -> L7
        if (r13 == null) goto L6;
        r13.close();
    L6:
        return r14;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r13 != null) goto L16;
    L15:
        throw th;
    L16:
        r13.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public static CodePointCharStream fromChannel(ReadableByteChannel r5, Charset r10, int r11, CodingErrorAction r12, String r13, long r14) throws IOException {
        ByteBuffer r15 = ByteBuffer.allocate(r11);     // Catch: Throwable -> L18
        CharBuffer r16 = CharBuffer.allocate(r11);     // Catch: Throwable -> L18
        if (r14 != (-1)) goto L6;
        r14 = r11;
    L7:
        CodePointBuffer.Builder r17 = CodePointBuffer.builder((int) r14);     // Catch: Throwable -> L18
        CharsetDecoder r18 = r10.newDecoder().onMalformedInput(r12).onUnmappableCharacter(r12);     // Catch: Throwable -> L18
        boolean r19 = false;
    L8:
        if (r19 == true) goto L21;
        if (r5.read(r15) != (-1)) goto L12;
        r19 = true;
    L13:
        r15.flip();     // Catch: Throwable -> L18
        CoderResult r20 = r18.decode(r15, r16, r19);     // Catch: Throwable -> L18
        if (r20.isError() == false) goto L20;
        if (r12.equals(CodingErrorAction.REPORT) == false) goto L20;
        r20.throwException();     // Catch: Throwable -> L18
    L20:
        r16.flip();     // Catch: Throwable -> L18
        r17.append(r16);     // Catch: Throwable -> L18
        r15.compact();     // Catch: Throwable -> L18
        r16.compact();     // Catch: Throwable -> L18
        goto L8
    L12:
        r19 = false;
        goto L13
    L21:
        CoderResult r21 = r18.flush(r16);     // Catch: Throwable -> L18
        if (r21.isError() == true) goto L24;
    L26:
        r16.flip();     // Catch: Throwable -> L18
        r17.append(r16);     // Catch: Throwable -> L18
        CodePointCharStream r22 = CodePointCharStream.fromBuffer(r17.build(), r13);     // Catch: Throwable -> L18
        r5.close();
        return r22;
    L24:
        if (r12.equals(CodingErrorAction.REPORT) == false) goto L26;
        r21.throwException();     // Catch: Throwable -> L18
        goto L26
    L6:
        if (r14 <= 2147483647L) goto L7;
        throw new IOException(String.format("inputSize %d larger than max %d", new Object[]{Long.valueOf(r14), Integer.MAX_VALUE}));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r5.close();
        throw th;
    }
}
