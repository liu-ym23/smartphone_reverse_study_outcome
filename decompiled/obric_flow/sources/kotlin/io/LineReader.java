package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    private static final StringBuilder f18736sb = null;

    static {
        INSTANCE = new LineReader();
        byte[] r5 = new byte[32];
        bytes = r5;
        char[] r10 = new char[32];
        chars = r10;
        byteBuf = ByteBuffer.wrap(r5);
        charBuf = CharBuffer.wrap(r10);
        f18736sb = new StringBuilder();
    }

    private LineReader() {
    }

    private final int compactBytes() {
        ByteBuffer r5 = byteBuf;
        r5.compact();
        int r10 = r5.position();
        r5.position(0);
        return r10;
    }

    private final int decode(boolean r10) {
    L2:
        CharsetDecoder r5 = decoder;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r5 = null;
    L5:
        ByteBuffer r11 = byteBuf;
        CharBuffer r12 = charBuf;
        CoderResult r13 = r5.decode(r11, r12, r10);
        if (r13.isError() == false) goto L8;
        resetAll();
        r13.throwException();
    L8:
        int r14 = r12.position();
        if (r13.isOverflow() == false) goto L10;
        StringBuilder r15 = f18736sb;
        char[] r16 = chars;
        int r17 = r14 - 1;
        r15.append(r16, 0, r17);
        r12.position(0);
        r12.limit(32);
        r12.put(r16[r17]);
        goto L2
    L10:
        return r14;
    }

    private final int decodeEndOfInput(int r5, int r10) {
        ByteBuffer r11 = byteBuf;
        r11.limit(r5);
        charBuf.position(r10);
        int r12 = decode(true);
        CharsetDecoder r13 = decoder;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r13 = null;
    L5:
        r13.reset();
        r11.position(0);
        return r12;
    }

    private final void resetAll() {
        CharsetDecoder r5 = decoder;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r5 = null;
    L5:
        r5.reset();
        byteBuf.position(0);
        f18736sb.setLength(0);
    }

    private final void trimStringBuilder() {
        StringBuilder r5 = f18736sb;
        r5.setLength(32);
        r5.trimToSize();
    }

    private final void updateCharset(Charset r5) {
        decoder = r5.newDecoder();
        ByteBuffer r10 = byteBuf;
        r10.clear();
        CharBuffer r11 = charBuf;
        r11.clear();
        r10.put((byte) 10);
        r10.flip();
        CharsetDecoder r12 = decoder;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r12 = null;
    L5:
        boolean r13 = false;
        r12.decode(r10, r11, false);
        if (r11.position() == 1) goto L8;
    L10:
        directEOL = r13;
        resetAll();
        return;
    L8:
        if (r11.get(0) != '\n') goto L10;
        r13 = true;
        goto L10
    }

    public final synchronized String readLine(InputStream r10, Charset r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "inputStream");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r11, "charset");     // Catch: Throwable -> L7
        CharsetDecoder r5 = decoder;     // Catch: Throwable -> L7
        if (r5 == null) goto L11;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");     // Catch: Throwable -> L7
        r5 = null;
    L10:
        if (Intrinsics.areEqual(r5.charset(), r11) == false) goto L11;
    L12:
        int r12 = 0;
        int r13 = 0;
    L13:
        int r14 = r10.read();     // Catch: Throwable -> L7
        if (r14 == (-1)) goto L16;
        int r15 = r12 + 1;     // Catch: Throwable -> L7
        bytes[r12] = (byte) r14;     // Catch: Throwable -> L7
        if (r14 == 10) goto L29;
        if (r15 == 32) goto L29;
        if (directEOL == false) goto L29;
        r12 = r15;
    L29:
        ByteBuffer r16 = byteBuf;     // Catch: Throwable -> L7
        r16.limit(r15);     // Catch: Throwable -> L7
        charBuf.position(r13);     // Catch: Throwable -> L7
        r13 = decode(false);     // Catch: Throwable -> L7
        if (r13 > 0) goto L32;
    L54:
        r12 = compactBytes();     // Catch: Throwable -> L7
        goto L13
    L32:
        if (chars[r13 - 1] != '\n') goto L54;
        r16.position(0);     // Catch: Throwable -> L7
        int r17 = r13;
    L34:
        if (r17 <= 0) goto L43;
        char[] r18 = chars;     // Catch: Throwable -> L7
        if (r18[r17 - 1] != '\n') goto L43;
        int r19 = r17 - 1;     // Catch: Throwable -> L7
        if (r19 > 0) goto L40;
    L42:
        r17 = r19;
        goto L43
    L40:
        if (r18[r17 - 2] != '\r') goto L42;
        r17 = r17 - 2;     // Catch: Throwable -> L7
    L43:
        StringBuilder r20 = f18736sb;     // Catch: Throwable -> L7
        if (r20.length() != 0) goto L48;
        String r21 = new String(chars, 0, r17);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r21;
    L48:
        r20.append(chars, 0, r17);     // Catch: Throwable -> L7
        String r110 = r20.toString();     // Catch: Throwable -> L7
        if (r20.length() <= 32) goto L51;
        trimStringBuilder();     // Catch: Throwable -> L7
    L51:
        r20.setLength(0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r110;
    L16:
        if (f18736sb.length() != 0) goto L21;
        if (r12 != 0) goto L21;
        if (r13 != 0) goto L21;
        monitor-exit(this);
        return null;
    L21:
        r17 = decodeEndOfInput(r12, r13);     // Catch: Throwable -> L7
    L11:
        updateCharset(r11);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
