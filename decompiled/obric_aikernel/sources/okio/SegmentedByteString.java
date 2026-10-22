package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n+ 2 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n63#2,12:141\n63#2,12:153\n104#2,2:165\n106#2,26:168\n135#2,5:194\n142#2:199\n145#2,3:200\n63#2,8:203\n148#2,8:211\n71#2,4:219\n156#2:223\n63#2,12:224\n160#2:236\n85#2,10:237\n161#2,9:247\n95#2,4:256\n170#2,2:260\n179#2,4:262\n85#2,10:266\n183#2,3:276\n95#2,4:279\n186#2:283\n195#2,8:284\n85#2,10:292\n203#2,3:302\n95#2,4:305\n206#2:309\n215#2,5:310\n85#2,10:315\n220#2,3:325\n95#2,4:328\n223#2:332\n226#2,4:333\n234#2,6:337\n63#2,8:343\n240#2,7:351\n71#2,4:358\n247#2,2:362\n1#3:167\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n*L\n54#1:141,12\n66#1:153,12\n78#1:165,2\n78#1:168,26\n80#1:194,5\n82#1:199\n84#1:200,3\n84#1:203,8\n84#1:211,8\n84#1:219,4\n84#1:223\n90#1:224,12\n96#1:236\n96#1:237,10\n96#1:247,9\n96#1:256,4\n96#1:260,2\n103#1:262,4\n103#1:266,10\n103#1:276,3\n103#1:279,4\n103#1:283\n110#1:284,8\n110#1:292,10\n110#1:302,3\n110#1:305,4\n110#1:309\n117#1:310,5\n117#1:315,10\n117#1:325,3\n117#1:328,4\n117#1:332\n131#1:333,4\n133#1:337,6\n133#1:343,8\n133#1:351,7\n133#1:358,4\n133#1:362,2\n78#1:167\n*E\n"})
public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    public SegmentedByteString(byte[][] r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r10, "segments");
        Intrinsics.checkNotNullParameter(r11, "directory");
        super(ByteString.EMPTY.getData$okio());
        this.segments = r10;
        this.directory = r11;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString r10 = toByteString();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Object");
        return r10;
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer r10 = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(r10, "asReadOnlyBuffer(...)");
        return r10;
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public void copyInto(int r12, byte[] r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, TypedValues.AttributesType.S_TARGET);
        long r10 = r15;
        b.b(size(), r12, r10);
        b.b(r13.length, r14, r10);
        int r16 = r15 + r12;
        int r11 = okio.internal.d.b(this, r12);
    L3:
        if (r12 >= r16) goto L8;
        if (r11 != 0) goto L6;
        int r17 = 0;
    L7:
        int r18 = getDirectory$okio()[r11] - r17;
        int r19 = getDirectory$okio()[getSegments$okio().length + r11];
        int r20 = Math.min(r16, r18 + r17) - r12;
        int r21 = r19 + (r12 - r17);
        ArraysKt.copyInto(getSegments$okio()[r11], r13, r14, r21, r21 + r20);
        r14 = r14 + r20;
        r12 = r12 + r20;
        r11 = r11 + 1;
        goto L3
    L6:
        r17 = getDirectory$okio()[r11 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String r10) {
        Intrinsics.checkNotNullParameter(r10, "algorithm");
        MessageDigest r11 = MessageDigest.getInstance(r10);
        int r12 = getSegments$okio().length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        int r15 = getDirectory$okio()[r12 + r13];
        int r16 = getDirectory$okio()[r13];
        r11.update(getSegments$okio()[r13], r15, r16 - r14);
        r13 = r13 + 1;
        r14 = r16;
        goto L3
    L5:
        byte[] r17 = r11.digest();
        Intrinsics.checkNotNull(r17);
        return new ByteString(r17);
    }

    @Override // okio.ByteString
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ByteString) == false) goto L13;
        ByteString r11 = (ByteString) r10;
        if (r11.size() != size()) goto L13;
        if (rangeEquals(0, r11, 0, size()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int r10 = getHashCode$okio();
        if (r10 != 0) goto L15;
        int r11 = getSegments$okio().length;
        int r12 = 0;
        int r13 = 1;
        int r14 = 0;
    L6:
        if (r12 >= r11) goto L11;
        int r15 = getDirectory$okio()[r11 + r12];
        int r16 = getDirectory$okio()[r12];
        byte[] r17 = getSegments$okio()[r12];
        int r18 = (r16 - r14) + r15;
    L8:
        if (r15 >= r18) goto L10;
        r13 = (r13 * 31) + r17[r15];
        r15 = r15 + 1;
        goto L8
    L10:
        r12 = r12 + 1;
        r14 = r16;
        goto L6
    L11:
        setHashCode$okio(r13);
        return r13;
    L15:
        return r10;
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String r10, ByteString r11) {
        Intrinsics.checkNotNullParameter(r10, "algorithm");
        Intrinsics.checkNotNullParameter(r11, "key");
        Mac r12 = Mac.getInstance(r10);     // Catch: InvalidKeyException -> L8
        r12.init(new SecretKeySpec(r11.toByteArray(), r10));     // Catch: InvalidKeyException -> L8
        int r13 = getSegments$okio().length;     // Catch: InvalidKeyException -> L8
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r13) goto L6;
        int r16 = getDirectory$okio()[r13 + r14];     // Catch: InvalidKeyException -> L8
        int r17 = getDirectory$okio()[r14];     // Catch: InvalidKeyException -> L8
        r12.update(getSegments$okio()[r14], r16, r17 - r15);     // Catch: InvalidKeyException -> L8
        r14 = r14 + 1;     // Catch: InvalidKeyException -> L8
        r15 = r17;
        goto L4
    L6:
        byte[] r18 = r12.doFinal();     // Catch: InvalidKeyException -> L8
        Intrinsics.checkNotNullExpressionValue(r18, "doFinal(...)");     // Catch: InvalidKeyException -> L8
        return new ByteString(r18);
    L8:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // okio.ByteString
    public int indexOf(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return toByteString().indexOf(r10, r11);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int r10) {
        b.b(getDirectory$okio()[getSegments$okio().length - 1], r10, 1);
        int r11 = okio.internal.d.b(this, r10);
        if (r11 != 0) goto L5;
        int r12 = 0;
    L7:
        return getSegments$okio()[r11][(r10 - r12) + getDirectory$okio()[getSegments$okio().length + r11]];
    L5:
        r12 = getDirectory$okio()[r11 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return toByteString().lastIndexOf(r10, r11);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r10, ByteString r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "other");
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (r10 > (size() - r13)) goto L21;
        int r14 = r13 + r10;
        int r15 = okio.internal.d.b(this, r10);
    L8:
        if (r10 >= r14) goto L16;
        if (r15 != 0) goto L11;
        int r16 = 0;
    L12:
        int r17 = getDirectory$okio()[r15] - r16;
        int r18 = getDirectory$okio()[getSegments$okio().length + r15];
        int r19 = Math.min(r14, r17 + r16) - r10;
        if (r11.rangeEquals(r12, getSegments$okio()[r15], r18 + (r10 - r16), r19) == false) goto L22;
        r12 = r12 + r19;
        r10 = r10 + r19;
        r15 = r15 + 1;
        goto L8
    L22:
        return false;
    L11:
        r16 = getDirectory$okio()[r15 - 1];
        goto L12
    L16:
        return true;
    L21:
        return false;
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
        int r15 = okio.internal.d.b(this, r10);
    L11:
        if (r10 >= r14) goto L19;
        if (r15 != 0) goto L14;
        int r16 = 0;
    L15:
        int r17 = getDirectory$okio()[r15] - r16;
        int r18 = getDirectory$okio()[getSegments$okio().length + r15];
        int r19 = Math.min(r14, r17 + r16) - r10;
        if (b.a(getSegments$okio()[r15], r18 + (r10 - r16), r11, r12, r19) == false) goto L27;
        r12 = r12 + r19;
        r10 = r10 + r19;
        r15 = r15 + 1;
        goto L11
    L27:
        return false;
    L14:
        r16 = getDirectory$okio()[r15 - 1];
        goto L15
    L19:
        return true;
    L26:
        return false;
    L24:
        return false;
    }

    @Override // okio.ByteString
    public String string(Charset r10) {
        Intrinsics.checkNotNullParameter(r10, "charset");
        return toByteString().string(r10);
    }

    @Override // okio.ByteString
    public ByteString substring(int r12, int r13) {
        int r14 = b.d(this, r13);
        int r10 = 0;
        if (r12 < 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L40;
        if (r14 > size()) goto L10;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L38;
        int r16 = r14 - r12;
        if (r16 < 0) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == false) goto L36;
        if (r12 == 0) goto L20;
    L22:
        if (r12 == r14) goto L42;
        int r18 = okio.internal.d.b(this, r12);
        int r19 = okio.internal.d.b(this, r14 - 1);
        byte[][] r20 = (byte[][]) ArraysKt.copyOfRange(getSegments$okio(), r18, r19 + 1);
        int[] r21 = new int[r20.length * 2];
        if (r18 > r19) goto L30;
        int r22 = 0;
        int r23 = r18;
    L27:
        r21[r22] = Math.min(getDirectory$okio()[r23] - r12, r16);
        int r24 = r22 + 1;
        r21[r22 + r20.length] = getDirectory$okio()[getSegments$okio().length + r23];
        if (r23 == r19) goto L30;
        r23 = r23 + 1;
        r22 = r24;
    L30:
        if (r18 == 0) goto L33;
        r10 = getDirectory$okio()[r18 - 1];
    L33:
        int r110 = r20.length;
        r21[r110] = r21[r110] + (r12 - r10);
        return new SegmentedByteString(r20, r21);
    L42:
        return ByteString.EMPTY;
    L20:
        if (r14 != size()) goto L22;
        return this;
    L36:
        throw new IllegalArgumentException(("endIndex=" + r14 + " < beginIndex=" + r12).toString());
    L16:
        r17 = false;
        goto L17
    L38:
        throw new IllegalArgumentException(("endIndex=" + r14 + " > length(" + size() + ')').toString());
    L10:
        r15 = false;
        goto L12
    L40:
        throw new IllegalArgumentException(("beginIndex=" + r12 + " < 0").toString());
    L5:
        r11 = false;
        goto L6
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] r10 = new byte[size()];
        int r11 = getSegments$okio().length;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r15 = getDirectory$okio()[r11 + r12];
        int r16 = getDirectory$okio()[r12];
        int r17 = r16 - r13;
        ArraysKt.copyInto(getSegments$okio()[r12], r10, r14, r15, r15 + r17);
        r14 = r14 + r17;
        r12 = r12 + 1;
        r13 = r16;
        goto L3
    L5:
        return r10;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "out");
        int r11 = getSegments$okio().length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r14 = getDirectory$okio()[r11 + r12];
        int r15 = getDirectory$okio()[r12];
        r10.write(getSegments$okio()[r12], r14, r15 - r13);
        r12 = r12 + 1;
        r13 = r15;
        goto L3
    }

    @Override // okio.ByteString
    public void write$okio(d r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "buffer");
        int r10 = r13 + r14;
        int r11 = okio.internal.d.b(this, r13);
    L3:
        if (r13 >= r10) goto L12;
        if (r11 != 0) goto L6;
        int r15 = 0;
    L7:
        int r16 = getDirectory$okio()[r11] - r15;
        int r17 = getDirectory$okio()[getSegments$okio().length + r11];
        int r18 = Math.min(r10, r16 + r15) - r13;
        int r19 = r17 + (r13 - r15);
        b0 r20 = new b0(getSegments$okio()[r11], r19, r19 + r18, true, false);
        b0 r21 = r12.f12197c;
        if (r21 != null) goto L10;
        r20.f12178g = r20;
        r20.f12177f = r20;
        r12.f12197c = r20;
    L11:
        r13 = r13 + r18;
        r11 = r11 + 1;
        goto L3
    L10:
        Intrinsics.checkNotNull(r21);
        b0 r22 = r21.f12178g;
        Intrinsics.checkNotNull(r22);
        r22.c(r20);
        goto L11
    L6:
        r15 = getDirectory$okio()[r11 - 1];
        goto L7
    L12:
        r12.K(r12.M() + ((long) r14));
    }
}
