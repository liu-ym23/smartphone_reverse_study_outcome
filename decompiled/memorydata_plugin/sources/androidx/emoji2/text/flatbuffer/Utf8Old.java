package androidx.emoji2.text.flatbuffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        CACHE = ThreadLocal.withInitial($$Lambda$Utf8Old$3aH_IojK_oDyJD2_vEnld_hMZQ.INSTANCE);
    }

    public Utf8Old() {
    }

    static /* synthetic */ Cache lambda$static$0() {
        return new Cache();
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer r3, int r4, int r5) {
        CharsetDecoder r2 = ((Cache) ZeusTransformUtils.preCheckCast(CACHE.get(), Cache.class, "com.obric.memorydata.plugin")).decoder;
        r2.reset();
        ByteBuffer r6 = r3.duplicate();
        r6.position(r4);
        r6.limit(r4 + r5);
        return r2.decode(r6).toString();
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Bad encoding", e);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r4, ByteBuffer r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Cache r0 = (Cache) ZeusTransformUtils.preCheckCast(CACHE.get(), Cache.class, "com.obric.memorydata.plugin");
        if (r0.lastInput == r6) goto L5;
        encodedLength(r6);
    L5:
        r5.put(r0.lastOutput);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r4) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        Cache r5 = (Cache) ZeusTransformUtils.preCheckCast(CACHE.get(), Cache.class, "com.obric.memorydata.plugin");
        int r1 = (int) (r3.length() * r5.encoder.maxBytesPerChar());
        if (r5.lastOutput != null) goto L5;
    L6:
        r5.lastOutput = ByteBuffer.allocate(Math.max(128, r1));
    L7:
        r5.lastOutput.clear();
        r5.lastInput = r3;
        if (ZeusTransformUtils.instanceOf(r3, CharBuffer.class) == false) goto L10;
        CharBuffer r6 = (CharBuffer) ZeusTransformUtils.preCheckCast(r3, CharBuffer.class, "com.obric.memorydata.plugin");
    L11:
        CoderResult r7 = r5.encoder.encode(r6, r5.lastOutput, true);
        if (r7.isError() == true) goto L20;
    L18:
        r5.lastOutput.flip();
        return r5.lastOutput.remaining();
    L20:
        r7.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException("bad character encoding", e);
    L10:
        r6 = CharBuffer.wrap(r3);
        goto L11
    L5:
        if (r5.lastOutput.capacity() >= r1) goto L7;
        goto L6
    }
}
