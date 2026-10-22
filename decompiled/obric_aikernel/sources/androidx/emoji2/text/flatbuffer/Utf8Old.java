package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class Utf8Old extends Utf8 {
    private static final ThreadLocal<Cache> CACHE = null;

    private static class Cache {
        final CharsetDecoder decoder;
        final CharsetEncoder encoder;
        CharSequence lastInput;
        ByteBuffer lastOutput;

        Cache() {
            this.lastInput = null;
            this.lastOutput = null;
            this.encoder = StandardCharsets.UTF_8.newEncoder();
            this.decoder = StandardCharsets.UTF_8.newDecoder();
        }
    }

    static {
        CACHE = ThreadLocal.withInitial(a.f381a);
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
    public String decodeUtf8(ByteBuffer r10, int r11, int r12) {
        CharsetDecoder r13 = CACHE.get().decoder;
        r13.reset();
        ByteBuffer r14 = r10.duplicate();
        r14.position(r11);
        r14.limit(r11 + r12);
        return r13.decode(r14).toString();
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Bad encoding", e);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r10, ByteBuffer r11) {
        Cache r12 = CACHE.get();
        if (r12.lastInput == r10) goto L5;
        encodedLength(r10);
    L5:
        r11.put(r12.lastOutput);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r10) {
        Cache r11 = CACHE.get();
        int r12 = (int) (r10.length() * r11.encoder.maxBytesPerChar());
        ByteBuffer r13 = r11.lastOutput;
        if (r13 != null) goto L5;
    L6:
        r11.lastOutput = ByteBuffer.allocate(Math.max(128, r12));
    L7:
        r11.lastOutput.clear();
        r11.lastInput = r10;
        if ((r10 instanceof CharBuffer) == false) goto L10;
        CharBuffer r14 = (CharBuffer) r10;
    L11:
        CoderResult r15 = r11.encoder.encode(r14, r11.lastOutput, true);
        if (r15.isError() == true) goto L20;
    L18:
        r11.lastOutput.flip();
        return r11.lastOutput.remaining();
    L20:
        r15.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException("bad character encoding", e);
    L10:
        r14 = CharBuffer.wrap(r10);
        goto L11
    L5:
        if (r13.capacity() >= r12) goto L7;
        goto L6
    }
}
