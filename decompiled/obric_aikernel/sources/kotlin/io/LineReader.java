package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nConsole.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Console.kt\nkotlin/io/LineReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,299:1\n1#2:300\n*E\n"})
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    public static final LineReader INSTANCE = null;
    private static final ByteBuffer byteBuf = null;
    private static final byte[] bytes = null;
    private static final CharBuffer charBuf = null;
    private static final char[] chars = null;
    private static CharsetDecoder decoder;
    private static boolean directEOL;

    /* JADX INFO: renamed from: sb, reason: collision with root package name */
    private static final StringBuilder f10200sb = null;

    static {
        INSTANCE = new LineReader();
        byte[] r10 = new byte[32];
        bytes = r10;
        char[] r11 = new char[32];
        chars = r11;
        ByteBuffer r12 = ByteBuffer.wrap(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "wrap(bytes)");
        byteBuf = r12;
        CharBuffer r13 = CharBuffer.wrap(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "wrap(chars)");
        charBuf = r13;
        f10200sb = new StringBuilder();
    }

    private LineReader() {
    }

    private final int compactBytes() {
        ByteBuffer r10 = byteBuf;
        r10.compact();
        int r11 = r10.position();
        r10.position(0);
        return r11;
    }

    private final int decode(boolean r10) {
    L2:
        CharsetDecoder r11 = decoder;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r11 = null;
    L5:
        ByteBuffer r12 = byteBuf;
        CharBuffer r13 = charBuf;
        CoderResult r14 = r11.decode(r12, r13, r10);
        Intrinsics.checkNotNullExpressionValue(r14, "decoder.decode(byteBuf, charBuf, endOfInput)");
        if (r14.isError() == false) goto L8;
        resetAll();
        r14.throwException();
    L8:
        int r15 = r13.position();
        if (r14.isOverflow() == false) goto L10;
        StringBuilder r16 = f10200sb;
        char[] r17 = chars;
        int r18 = r15 - 1;
        r16.append(r17, 0, r18);
        r13.position(0);
        r13.limit(32);
        r13.put(r17[r18]);
        goto L2
    L10:
        return r15;
    }

    private final int decodeEndOfInput(int r10, int r11) {
        ByteBuffer r12 = byteBuf;
        r12.limit(r10);
        charBuf.position(r11);
        int r13 = decode(true);
        CharsetDecoder r14 = decoder;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r14 = null;
    L5:
        r14.reset();
        r12.position(0);
        return r13;
    }

    private final void resetAll() {
        CharsetDecoder r10 = decoder;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r10 = null;
    L5:
        r10.reset();
        byteBuf.position(0);
        f10200sb.setLength(0);
    }

    private final void trimStringBuilder() {
        StringBuilder r10 = f10200sb;
        r10.setLength(32);
        r10.trimToSize();
    }

    private final void updateCharset(Charset r10) {
        CharsetDecoder r11 = r10.newDecoder();
        Intrinsics.checkNotNullExpressionValue(r11, "charset.newDecoder()");
        decoder = r11;
        ByteBuffer r12 = byteBuf;
        r12.clear();
        CharBuffer r13 = charBuf;
        r13.clear();
        r12.put((byte) 10);
        r12.flip();
        CharsetDecoder r14 = decoder;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r14 = null;
    L5:
        boolean r15 = false;
        r14.decode(r12, r13, false);
        if (r13.position() == 1) goto L8;
    L10:
        directEOL = r15;
        resetAll();
        return;
    L8:
        if (r13.get(0) != '\n') goto L10;
        r15 = true;
        goto L10
    }

    public final synchronized String readLine(InputStream r11, Charset r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "inputStream");     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r12, "charset");     // Catch: Throwable -> L59
        CharsetDecoder r10 = decoder;     // Catch: Throwable -> L59
        if (r10 == null) goto L9;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");     // Catch: Throwable -> L59
        r10 = null;
    L8:
        if (Intrinsics.areEqual(r10.charset(), r12) == false) goto L9;
    L10:
        int r13 = 0;
        int r14 = 0;
    L11:
        int r15 = r11.read();     // Catch: Throwable -> L59
        boolean r16 = true;
        if (r15 == (-1)) goto L14;
        int r17 = r13 + 1;     // Catch: Throwable -> L59
        bytes[r13] = (byte) r15;     // Catch: Throwable -> L59
        if (r15 == 10) goto L30;
        if (r17 == 32) goto L30;
        if (directEOL == false) goto L30;
        r13 = r17;
    L30:
        ByteBuffer r18 = byteBuf;     // Catch: Throwable -> L59
        r18.limit(r17);     // Catch: Throwable -> L59
        charBuf.position(r14);     // Catch: Throwable -> L59
        r14 = decode(false);     // Catch: Throwable -> L59
        if (r14 > 0) goto L33;
    L57:
        r13 = compactBytes();     // Catch: Throwable -> L59
        goto L11
    L33:
        if (chars[r14 - 1] != '\n') goto L57;
        r18.position(0);     // Catch: Throwable -> L59
        int r19 = r14;
    L35:
        if (r19 <= 0) goto L43;
        char[] r20 = chars;     // Catch: Throwable -> L59
        if (r20[r19 - 1] != '\n') goto L43;
        r19 = r19 - 1;     // Catch: Throwable -> L59
        if (r19 <= 0) goto L43;
        if (r20[r19 - 1] != '\r') goto L43;
        r19 = r19 - 1;     // Catch: Throwable -> L59
    L43:
        StringBuilder r21 = f10200sb;     // Catch: Throwable -> L59
        if (r21.length() == 0) goto L47;
        r16 = false;
    L47:
        if (r16 == false) goto L51;
        String r22 = new String(chars, 0, r19);     // Catch: Throwable -> L59
        monitor-exit(this);
        return r22;
    L51:
        r21.append(chars, 0, r19);     // Catch: Throwable -> L59
        String r110 = r21.toString();     // Catch: Throwable -> L59
        Intrinsics.checkNotNullExpressionValue(r110, "sb.toString()");     // Catch: Throwable -> L59
        if (r21.length() <= 32) goto L54;
        trimStringBuilder();     // Catch: Throwable -> L59
    L54:
        r21.setLength(0);     // Catch: Throwable -> L59
        monitor-exit(this);
        return r110;
    L14:
        if (f10200sb.length() != 0) goto L16;
        boolean r111 = true;
    L17:
        if (r111 == false) goto L22;
        if (r13 != 0) goto L22;
        if (r14 != 0) goto L22;
        monitor-exit(this);
        return null;
    L22:
        r19 = decodeEndOfInput(r13, r14);     // Catch: Throwable -> L59
        goto L35
    L16:
        r111 = false;
    L9:
        updateCharset(r12);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    }
}
