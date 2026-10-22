package org.apache.commons.compress.archivers.zip;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import okio.Utf8;

/* JADX INFO: loaded from: classes6.dex */
class NioZipEncoding implements ZipEncoding {
    private static final char[] HEX_CHARS = null;
    private static final byte[] REPLACEMENT_BYTES = null;
    private static final String REPLACEMENT_STRING = null;
    private final Charset charset;
    private final boolean useReplacement;

    static {
        REPLACEMENT_BYTES = new byte[]{Utf8.REPLACEMENT_BYTE};
        REPLACEMENT_STRING = String.valueOf('?');
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    NioZipEncoding(Charset r1, boolean r2) {
        this.charset = r1;
        this.useReplacement = r2;
    }

    private static ByteBuffer encodeFully(CharsetEncoder r1, CharBuffer r2, ByteBuffer r3) {
    L3:
        if (r2.hasRemaining() == false) goto L7;
        if (r1.encode(r2, r3, false).isOverflow() == false) goto L3;
        r3 = ZipEncodingHelper.growBufferBy(r3, estimateIncrementalEncodingSize(r1, r2.remaining()));
        goto L3
    L7:
        return r3;
    }

    private static CharBuffer encodeSurrogate(CharBuffer r2, char r3) {
        r2.position(0).limit(6);
        r2.put('%');
        r2.put('U');
        char[] r0 = HEX_CHARS;
        r2.put(r0[(r3 >> '\f') & 15]);
        r2.put(r0[(r3 >> '\b') & 15]);
        r2.put(r0[(r3 >> 4) & 15]);
        r2.put(r0[r3 & 15]);
        r2.flip();
        return r2;
    }

    private static int estimateIncrementalEncodingSize(CharsetEncoder r0, int r1) {
        return (int) Math.ceil(r1 * r0.averageBytesPerChar());
    }

    private static int estimateInitialBufferSize(CharsetEncoder r1, int r2) {
        return (int) Math.ceil(r1.maxBytesPerChar() + ((r2 - 1) * r1.averageBytesPerChar()));
    }

    private CharsetDecoder newDecoder() {
        boolean r0 = this.useReplacement;
        CharsetDecoder r1 = this.charset.newDecoder();
        if (r0 == true) goto L7;
        return r1.onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    L7:
        return r1.onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(REPLACEMENT_STRING);
    }

    private CharsetEncoder newEncoder() {
        boolean r0 = this.useReplacement;
        CharsetEncoder r1 = this.charset.newEncoder();
        if (r0 == false) goto L7;
        return r1.onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(REPLACEMENT_BYTES);
    L7:
        return r1.onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public boolean canEncode(String r1) {
        return newEncoder().canEncode(r1);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public String decode(byte[] r1) {
        return newDecoder().decode(ByteBuffer.wrap(r1)).toString();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public ByteBuffer encode(String r10) {
        CharsetEncoder r9 = newEncoder();
        CharBuffer r11 = CharBuffer.wrap(r10);
        ByteBuffer r0 = ByteBuffer.allocate(estimateInitialBufferSize(r9, r11.remaining()));
        CharBuffer r1 = null;
    L4:
        if (r11.hasRemaining() == false) goto L34;
        int r2 = 0;
        CoderResult r4 = r9.encode(r11, r0, false);
        if (r4.isUnmappable() == true) goto L19;
        if (r4.isMalformed() == true) goto L19;
        if (r4.isOverflow() == true) goto L12;
        if (r4.isUnderflow() == true) goto L34;
        if (r4.isError() == false) goto L4;
    L12:
        r0 = ZipEncodingHelper.growBufferBy(r0, estimateIncrementalEncodingSize(r9, r11.remaining()));
    L19:
        if (estimateIncrementalEncodingSize(r9, r4.length() * 6) <= r0.remaining()) goto L29;
        int r5 = r11.position();
        int r7 = 0;
    L22:
        if (r5 >= r11.limit()) goto L28;
        if (r9.canEncode(r11.get(r5)) == true) goto L26;
        int r8 = 6;
    L27:
        r7 = r7 + r8;
        r5 = r5 + 1;
        goto L22
    L26:
        r8 = 1;
        goto L27
    L28:
        r0 = ZipEncodingHelper.growBufferBy(r0, estimateIncrementalEncodingSize(r9, r7) - r0.remaining());
    L29:
        if (r1 != null) goto L32;
        r1 = CharBuffer.allocate(6);
    L32:
        if (r2 >= r4.length()) goto L4;
        r0 = encodeFully(r9, encodeSurrogate(r1, r11.get()), r0);
        r2 = r2 + 1;
    L34:
        r9.encode(r11, r0, true);
        r0.limit(r0.position());
        r0.rewind();
        return r0;
    }
}
