package okio;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import f4.a;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import nu.j;
import nu.y;
import ou.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u0012J\u001f\u0010#\u001a\u00020\u00012\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010)\u001a\u00020&2\u0006\u0010%\u001a\u00020 H\u0010¢\u0006\u0004\b'\u0010(J\u000f\u0010,\u001a\u00020 H\u0010¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b5\u00106J'\u00105\u001a\u0002042\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0010¢\u0006\u0004\b;\u0010<J/\u0010@\u001a\u00020?2\u0006\u00109\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0016¢\u0006\u0004\b@\u0010AJ/\u0010@\u001a\u00020?2\u0006\u00109\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0016¢\u0006\u0004\b@\u0010BJ\u001f\u0010D\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010C\u001a\u00020 H\u0016¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010C\u001a\u00020 H\u0016¢\u0006\u0004\bF\u0010EJ\u000f\u0010H\u001a\u00020\u0003H\u0010¢\u0006\u0004\bG\u0010.J\u001a\u0010J\u001a\u00020?2\b\u0010=\u001a\u0004\u0018\u00010IH\u0096\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020 H\u0016¢\u0006\u0004\bL\u0010+J\u000f\u0010M\u001a\u00020\u000eH\u0016¢\u0006\u0004\bM\u0010\u0012R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U¨\u0006V"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "", "", "segments", "", "directory", "<init>", "([[B[I)V", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "()Ljava/lang/String;", "hex", "toAsciiLowercase", "()Lokio/ByteString;", "toAsciiUppercase", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", STGroup.DICT_KEY, "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", OpenPageMethod.KEY_POS, "", "internalGet$okio", "(I)B", "internalGet", "getSize$okio", "()I", "getSize", "toByteArray", "()[B", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "", "write", "(Ljava/io/OutputStream;)V", "Lnu/j;", "buffer", "offset", "byteCount", "write$okio", "(Lnu/j;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "fromIndex", "indexOf", "([BI)I", "lastIndexOf", "internalArray$okio", "internalArray", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "c", "[[B", "getSegments$okio", "()[[B", "d", "[I", "getDirectory$okio", "()[I", "okio"}, k = 1, mv = {1, 4, 0})
public final class SegmentedByteString extends ByteString {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient byte[][] f20772c;
    public final transient int[] d;

    public SegmentedByteString(byte[][] r5, int[] r10) {
        Intrinsics.checkNotNullParameter(r5, "segments");
        Intrinsics.checkNotNullParameter(r10, "directory");
        super(ByteString.EMPTY.getData$okio());
        this.f20772c = r5;
        this.d = r10;
    }

    private final Object writeReplace() {
        return a();
    }

    public final ByteString a() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public String base64() {
        return a().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return a().base64Url();
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String r10) {
        Intrinsics.checkNotNullParameter(r10, "algorithm");
        MessageDigest r11 = MessageDigest.getInstance(r10);
        int r5 = getSegments$okio().length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r5) goto L6;
        int r14 = getDirectory$okio()[r5 + r12];
        int r15 = getDirectory$okio()[r12];
        r11.update(getSegments$okio()[r12], r14, r15 - r13);
        r12 = r12 + 1;
        r13 = r15;
        goto L3
    L6:
        return new ByteString(r11.digest());
    }

    @Override // okio.ByteString
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L13;
        ByteString r10 = (ByteString) r5;
        if (r10.size() != size()) goto L13;
        if (rangeEquals(0, r10, 0, size()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.d;
    }

    public final byte[][] getSegments$okio() {
        return this.f20772c;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int r5 = getHashCode$okio();
        if (r5 != 0) goto L15;
        int r10 = getSegments$okio().length;
        int r11 = 0;
        int r12 = 1;
        int r13 = 0;
    L6:
        if (r11 >= r10) goto L11;
        int r14 = getDirectory$okio()[r10 + r11];
        int r15 = getDirectory$okio()[r11];
        byte[] r16 = getSegments$okio()[r11];
        int r17 = (r15 - r13) + r14;
    L8:
        if (r14 >= r17) goto L10;
        r12 = (r12 * 31) + r16[r14];
        r14 = r14 + 1;
        goto L8
    L10:
        r11 = r11 + 1;
        r13 = r15;
        goto L6
    L11:
        setHashCode$okio(r12);
        return r12;
    L15:
        return r5;
    }

    @Override // okio.ByteString
    public String hex() {
        return a().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String r10, ByteString r11) {
        Intrinsics.checkNotNullParameter(r10, "algorithm");
        Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
        Mac r5 = Mac.getInstance(r10);     // Catch: InvalidKeyException -> L6
        r5.init(new SecretKeySpec(r11.toByteArray(), r10));     // Catch: InvalidKeyException -> L6
        int r12 = getSegments$okio().length;     // Catch: InvalidKeyException -> L6
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r12) goto L8;
        int r15 = getDirectory$okio()[r12 + r13];     // Catch: InvalidKeyException -> L6
        int r16 = getDirectory$okio()[r13];     // Catch: InvalidKeyException -> L6
        r5.update(getSegments$okio()[r13], r15, r16 - r14);     // Catch: InvalidKeyException -> L6
        r13 = r13 + 1;     // Catch: InvalidKeyException -> L6
        r14 = r16;
        goto L4
    L8:
        return new ByteString(r5.doFinal());
    L6:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // okio.ByteString
    public int indexOf(byte[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return a().indexOf(r5, r10);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int r10) {
        a.d(getDirectory$okio()[getSegments$okio().length - 1], r10, 1);
        int r5 = b.b(this, r10);
        if (r5 != 0) goto L5;
        int r11 = 0;
    L7:
        return getSegments$okio()[r5][(r10 - r11) + getDirectory$okio()[getSegments$okio().length + r5]];
    L5:
        r11 = getDirectory$okio()[r5 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return a().lastIndexOf(r5, r10);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r10, ByteString r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "other");
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (r10 > (size() - r13)) goto L21;
        int r14 = r13 + r10;
        int r5 = b.b(this, r10);
    L8:
        if (r10 >= r14) goto L16;
        if (r5 != 0) goto L11;
        int r15 = 0;
    L12:
        int r16 = getDirectory$okio()[r5] - r15;
        int r17 = getDirectory$okio()[getSegments$okio().length + r5];
        int r18 = Math.min(r14, r16 + r15) - r10;
        if (r11.rangeEquals(r12, getSegments$okio()[r5], (r10 - r15) + r17, r18) == false) goto L22;
        r12 = r12 + r18;
        r10 = r10 + r18;
        r5 = r5 + 1;
        goto L8
    L22:
        return false;
    L11:
        r15 = getDirectory$okio()[r5 - 1];
        goto L12
    L16:
        return true;
    L21:
        return false;
    }

    @Override // okio.ByteString
    public String string(Charset r5) {
        Intrinsics.checkNotNullParameter(r5, "charset");
        return a().string(r5);
    }

    @Override // okio.ByteString
    public ByteString substring(int r12, int r13) {
        int r5 = 0;
        if (r12 < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L40;
        if (r13 > size()) goto L10;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L37;
        int r14 = r13 - r12;
        if (r14 < 0) goto L16;
        boolean r15 = true;
    L17:
        if (r15 == false) goto L36;
        if (r12 == 0) goto L20;
    L22:
        if (r12 == r13) goto L42;
        int r16 = b.b(this, r12);
        int r17 = b.b(this, r13 - 1);
        byte[][] r18 = (byte[][]) ArraysKt.copyOfRange(getSegments$okio(), r16, r17 + 1);
        int[] r19 = new int[r18.length * 2];
        if (r16 > r17) goto L30;
        int r20 = 0;
        int r21 = r16;
    L27:
        r19[r20] = Math.min(getDirectory$okio()[r21] - r12, r14);
        int r22 = r20 + 1;
        r19[r20 + r18.length] = getDirectory$okio()[getSegments$okio().length + r21];
        if (r21 == r17) goto L30;
        r21 = r21 + 1;
        r20 = r22;
    L30:
        if (r16 == 0) goto L33;
        r5 = getDirectory$okio()[r16 - 1];
    L33:
        int r110 = r18.length;
        r19[r110] = (r12 - r5) + r19[r110];
        return new SegmentedByteString(r18, r19);
    L42:
        return ByteString.EMPTY;
    L20:
        if (r13 != size()) goto L22;
        return this;
    L36:
        throw new IllegalArgumentException(j0.f(r13, r12, "endIndex=", " < beginIndex=").toString());
    L16:
        r15 = false;
        goto L17
    L37:
        StringBuilder r111 = j0.s(r13, "endIndex=", " > length(");
        r111.append(size());
        r111.append(')');
        throw new IllegalArgumentException(r111.toString().toString());
    L10:
        r11 = false;
        goto L12
    L40:
        throw new IllegalArgumentException(j0.h(r12, "beginIndex=", " < 0").toString());
    L5:
        r10 = false;
        goto L6
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] r5 = new byte[size()];
        int r10 = getSegments$okio().length;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r11 >= r10) goto L5;
        int r14 = getDirectory$okio()[r10 + r11];
        int r15 = getDirectory$okio()[r11];
        int r16 = r15 - r12;
        ArraysKt.copyInto(getSegments$okio()[r11], r5, r13, r14, r14 + r16);
        r13 = r13 + r16;
        r11 = r11 + 1;
        r12 = r15;
        goto L3
    L5:
        return r5;
    }

    @Override // okio.ByteString
    public String toString() {
        return a().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "out");
        int r5 = getSegments$okio().length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r5) goto L5;
        int r13 = getDirectory$okio()[r5 + r11];
        int r14 = getDirectory$okio()[r11];
        r10.write(getSegments$okio()[r11], r13, r14 - r12);
        r11 = r11 + 1;
        r12 = r14;
        goto L3
    }

    @Override // okio.ByteString
    public void write$okio(j r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "buffer");
        int r14 = r13 + r12;
        int r5 = b.b(this, r12);
    L3:
        if (r12 >= r14) goto L12;
        if (r5 != 0) goto L6;
        int r10 = 0;
    L7:
        int r15 = getDirectory$okio()[r5] - r10;
        int r16 = getDirectory$okio()[getSegments$okio().length + r5];
        int r17 = Math.min(r14, r15 + r10) - r12;
        int r18 = (r12 - r10) + r16;
        y r19 = new y(getSegments$okio()[r5], r18, r18 + r17, true, false);
        y r20 = r11.f20327a;
        if (r20 != null) goto L10;
        r19.g = r19;
        r19.f = r19;
        r11.f20327a = r19;
    L11:
        r12 = r12 + r17;
        r5 = r5 + 1;
        goto L3
    L10:
        Intrinsics.checkNotNull(r20);
        y r21 = r20.g;
        Intrinsics.checkNotNull(r21);
        r21.b(r19);
        goto L11
    L6:
        r10 = getDirectory$okio()[r5 - 1];
        goto L7
    L12:
        r11.f20328b += (long) size();
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r10, byte[] r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "other");
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (r10 > (size() - r13)) goto L24;
        if (r12 >= 0) goto L8;
        return false;
    L8:
        if (r12 > (r11.length - r13)) goto L26;
        int r14 = r13 + r10;
        int r5 = b.b(this, r10);
    L11:
        if (r10 >= r14) goto L19;
        if (r5 != 0) goto L14;
        int r15 = 0;
    L15:
        int r16 = getDirectory$okio()[r5] - r15;
        int r17 = getDirectory$okio()[getSegments$okio().length + r5];
        int r18 = Math.min(r14, r16 + r15) - r10;
        if (a.c(getSegments$okio()[r5], r11, (r10 - r15) + r17, r12, r18) == false) goto L27;
        r12 = r12 + r18;
        r10 = r10 + r18;
        r5 = r5 + 1;
        goto L11
    L27:
        return false;
    L14:
        r15 = getDirectory$okio()[r5 - 1];
        goto L15
    L19:
        return true;
    L26:
        return false;
    L24:
        return false;
    }
}
