package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class Utf8Old extends Utf8 {
    private static final ThreadLocal<Cache> CACHE = null;

    public static class Cache {
        final CharsetDecoder decoder;
        final CharsetEncoder encoder;
        CharSequence lastInput;
        ByteBuffer lastOutput;

        public Cache() {
            this.lastInput = null;
            this.lastOutput = null;
            Charset r5 = StandardCharsets.UTF_8;
            this.encoder = r5.newEncoder();
            this.decoder = r5.newDecoder();
        }
    }

    static {
        CACHE = ThreadLocal.withInitial(new a(0));
    }

    public Utf8Old() {
    }

    public static /* synthetic */ Cache a() {
        return lambda$static$0();
    }

    private static /* synthetic */ Cache lambda$static$0() {
        return new Cache();
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer r5, int r10, int r11) {
        CharsetDecoder r12 = CACHE.get().decoder;
        r12.reset();
        ByteBuffer r13 = r5.duplicate();
        r13.position(r10);
        r13.limit(r10 + r11);
        return r12.decode(r13).toString();
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Bad encoding", e);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r5, ByteBuffer r10) {
        Cache r11 = CACHE.get();
        if (r11.lastInput == r5) goto L5;
        encodedLength(r5);
    L5:
        r10.put(r11.lastOutput);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r5) {
        Cache r10 = CACHE.get();
        int r11 = (int) (r10.encoder.maxBytesPerChar() * r5.length());
        ByteBuffer r12 = r10.lastOutput;
        if (r12 != null) goto L5;
    L6:
        r10.lastOutput = ByteBuffer.allocate(Math.max(128, r11));
    L7:
        r10.lastOutput.clear();
        r10.lastInput = r5;
        if ((r5 instanceof CharBuffer) == false) goto L10;
        CharBuffer r13 = (CharBuffer) r5;
    L11:
        CoderResult r14 = r10.encoder.encode(r13, r10.lastOutput, true);
        if (r14.isError() == true) goto L20;
    L18:
        r10.lastOutput.flip();
        return r10.lastOutput.remaining();
    L20:
        r14.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException("bad character encoding", e);
    L10:
        r13 = CharBuffer.wrap(r5);
        goto L11
    L5:
        if (r12.capacity() >= r11) goto L7;
        goto L6
    }
}
