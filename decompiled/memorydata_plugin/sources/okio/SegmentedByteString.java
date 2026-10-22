package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 J2\u00020\u0001:\u0001JB\u001d\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0011H\u0010¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002JV\u0010\u001a\u001a\u00020\u001b2K\u0010\u001c\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001b0\u001dH\u0082\bJf\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!2K\u0010\u001c\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001b0\u001dH\u0082\bJ\r\u0010&\u001a\u00020!H\u0010¢\u0006\u0002\b'J\b\u0010(\u001a\u00020!H\u0016J\b\u0010)\u001a\u00020\u0011H\u0016J\u001d\u0010*\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0001H\u0010¢\u0006\u0002\b,J\u0018\u0010-\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010.\u001a\u00020!H\u0016J\r\u0010/\u001a\u00020\u0004H\u0010¢\u0006\u0002\b0J\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u00020!H\u0010¢\u0006\u0002\b4J\u0018\u00105\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010.\u001a\u00020!H\u0016J(\u00106\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u00107\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016J(\u00106\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u00107\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016J\u0010\u00108\u001a\u00020!2\u0006\u00103\u001a\u00020!H\u0002J\u0010\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020;H\u0016J\u0018\u0010<\u001a\u00020\u00012\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0016J\b\u0010=\u001a\u00020\u0001H\u0016J\b\u0010>\u001a\u00020\u0001H\u0016J\b\u0010?\u001a\u00020\u0004H\u0016J\b\u0010@\u001a\u00020\u0001H\u0002J\b\u0010A\u001a\u00020\u0011H\u0016J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0016J\u0015\u0010B\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020FH\u0010¢\u0006\u0002\bGJ\b\u0010H\u001a\u00020IH\u0002R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006K"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "([[B[I)V", "getDirectory", "()[I", "getSegments", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "base64", "", "base64Url", "digest", "algorithm", "digest$jvm", "equals", "", "other", "", "forEachSegment", "", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "data", "", TypedValues.CycleType.S_WAVE_OFFSET, "byteCount", "beginIndex", "endIndex", "getSize", "getSize$jvm", "hashCode", "hex", "hmac", "key", "hmac$jvm", "indexOf", "fromIndex", "internalArray", "internalArray$jvm", "internalGet", "", "pos", "internalGet$jvm", "lastIndexOf", "rangeEquals", "otherOffset", "segment", TypedValues.Custom.S_STRING, "charset", "Ljava/nio/charset/Charset;", "substring", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$jvm", "writeReplace", "Ljava/lang/Object;", "Companion", "jvm"}, k = 1, mv = {1, 1, 11})
public final class SegmentedByteString extends ByteString {
    public static final Companion Companion = null;
    private final transient int[] directory;
    private final transient byte[][] segments;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lokio/SegmentedByteString$Companion;", "", "()V", "of", "Lokio/ByteString;", "buffer", "Lokio/Buffer;", "byteCount", "", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ByteString of(Buffer r7, int r8) {
            Intrinsics.checkParameterIsNotNull(r7, "buffer");
            Util.checkOffsetAndCount(r7.size(), 0, r8);
            Segment r6 = r7.head;
            int r0 = 0;
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r1 >= r8) goto L12;
            if (r6 != null) goto L8;
            Intrinsics.throwNpe();
        L8:
            if (r6.limit == r6.pos) goto L11;
            r1 = r1 + (r6.limit - r6.pos);
            r2 = r2 + 1;
            r6 = r6.next;
            goto L4
        L11:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("s.limit == s.pos"), Throwable.class, "com.obric.memorydata.plugin"));
        L12:
            byte[][] r9 = new byte[r2][];
            int[] r3 = new int[r2 * 2];
            Segment r10 = r7.head;
            int r4 = 0;
        L13:
            if (r0 >= r8) goto L18;
            if (r10 != null) goto L16;
            Intrinsics.throwNpe();
        L16:
            r9[r4] = r10.data;
            r0 = r0 + (r10.limit - r10.pos);
            r3[r4] = Math.min(r0, r8);
            r3[((Object[]) ZeusTransformUtils.preCheckCast(r9, Object[].class, "com.obric.memorydata.plugin")).length + r4] = r10.pos;
            r10.shared = true;
            r4 = r4 + 1;
            r10 = r10.next;
            goto L13
        L18:
            return (ByteString) ZeusTransformUtils.preCheckCast(new SegmentedByteString((byte[][]) ZeusTransformUtils.preCheckCast(r9, byte[][].class, "com.obric.memorydata.plugin"), r3, null), ByteString.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new Companion(null);
    }

    private SegmentedByteString(byte[][] r2, int[] r3) {
        super(ByteString.EMPTY.getData$jvm());
        this.segments = r2;
        this.directory = r3;
    }

    public /* synthetic */ SegmentedByteString(byte[][] r1, int[] r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public static final /* synthetic */ int access$segment(SegmentedByteString r0, int r1) {
        return r0.segment(r1);
    }

    private final void forEachSegment(int r8, int r9, Function3<? super byte[], ? super Integer, ? super Integer, Unit> r10) {
        Function3 r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r10, Function3.class, "com.obric.memorydata.plugin");
        int r0 = access$segment(this, r8);
    L3:
        if (r8 >= r9) goto L8;
        if (r0 != 0) goto L6;
        int r2 = 0;
    L7:
        int r3 = getDirectory()[r0] - r2;
        int r4 = getDirectory()[((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length + r0];
        int r5 = Math.min(r9, r3 + r2) - r8;
        r11.invoke(getSegments()[r0], Integer.valueOf(r4 + (r8 - r2)), Integer.valueOf(r5));
        r8 = r8 + r5;
        r0 = r0 + 1;
        goto L3
    L6:
        r2 = getDirectory()[r0 - 1];
        goto L7
    }

    private final void forEachSegment(Function3<? super byte[], ? super Integer, ? super Integer, Unit> r7) {
        Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
        int r0 = ((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = getDirectory()[r0 + r1];
        int r4 = getDirectory()[r1];
        r8.invoke(getSegments()[r1], Integer.valueOf(r3), Integer.valueOf(r4 - r2));
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    }

    private final int segment(int r4) {
        int r3 = Arrays.binarySearch(this.directory, 0, ((Object[]) ZeusTransformUtils.preCheckCast(this.segments, Object[].class, "com.obric.memorydata.plugin")).length, r4 + 1);
        if (r3 < 0) goto L6;
        return r3;
    L6:
        return ~r3;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString r2 = toByteString();
        if (r2 == null) goto L7;
        return ZeusTransformUtils.preCheckCast(r2, Object.class, "com.obric.memorydata.plugin");
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
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
    public ByteString digest$jvm(String r7) {
        Intrinsics.checkParameterIsNotNull(r7, "algorithm");
        MessageDigest r8 = MessageDigest.getInstance(r7);
        int r0 = ((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = getDirectory()[r0 + r1];
        int r4 = getDirectory()[r1];
        r8.update(getSegments()[r1], r3, r4 - r2);
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    L5:
        byte[] r9 = r8.digest();
        Intrinsics.checkExpressionValueIsNotNull(r9, "digest.digest()");
        return new ByteString(r9);
    }

    @Override // okio.ByteString
    public boolean equals(Object r6) {
        if (r6 != ((SegmentedByteString) ZeusTransformUtils.preCheckCast(this, SegmentedByteString.class, "com.obric.memorydata.plugin"))) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ByteString.class) == false) goto L13;
        if (((ByteString) ZeusTransformUtils.preCheckCast(r6, ByteString.class, "com.obric.memorydata.plugin")).size() != size()) goto L13;
        if (rangeEquals(0, (ByteString) ZeusTransformUtils.preCheckCast(r6, ByteString.class, "com.obric.memorydata.plugin"), 0, size()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final int[] getDirectory() {
        return this.directory;
    }

    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$jvm() {
        return this.directory[((Object[]) ZeusTransformUtils.preCheckCast(this.segments, Object[].class, "com.obric.memorydata.plugin")).length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int r0 = getHashCode$jvm();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = ((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length;
        int r2 = 0;
        int r3 = 1;
        int r4 = 0;
    L6:
        if (r2 >= r1) goto L11;
        int r5 = getDirectory()[r1 + r2];
        int r6 = getDirectory()[r2];
        byte[] r7 = getSegments()[r2];
        int r8 = (r6 - r4) + r5;
    L8:
        if (r5 >= r8) goto L10;
        r3 = (r3 * 31) + r7[r5];
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        r4 = r6;
        goto L6
    L11:
        setHashCode$jvm(r3);
        return r3;
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$jvm(String r7, ByteString r8) {
        Intrinsics.checkParameterIsNotNull(r7, "algorithm");
        Intrinsics.checkParameterIsNotNull(r8, "key");
        Mac r1 = Mac.getInstance(r7);     // Catch: InvalidKeyException -> L8
        r1.init((Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r8.toByteArray(), r7), Key.class, "com.obric.memorydata.plugin"));     // Catch: InvalidKeyException -> L8
        int r9 = ((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length;     // Catch: InvalidKeyException -> L8
        int r10 = 0;
        int r2 = 0;
    L4:
        if (r10 >= r9) goto L6;
        int r3 = getDirectory()[r9 + r10];     // Catch: InvalidKeyException -> L8
        int r4 = getDirectory()[r10];     // Catch: InvalidKeyException -> L8
        r1.update(getSegments()[r10], r3, r4 - r2);     // Catch: InvalidKeyException -> L8
        r10 = r10 + 1;     // Catch: InvalidKeyException -> L8
        r2 = r4;
        goto L4
    L6:
        byte[] r11 = r1.doFinal();     // Catch: InvalidKeyException -> L8
        Intrinsics.checkExpressionValueIsNotNull(r11, "mac.doFinal()");     // Catch: InvalidKeyException -> L8
        return new ByteString(r11);
    L8:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.ByteString
    public int indexOf(byte[] r2, int r3) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return toByteString().indexOf(r2, r3);
    }

    @Override // okio.ByteString
    public byte[] internalArray$jvm() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$jvm(int r11) {
        Util.checkOffsetAndCount(this.directory[((Object[]) ZeusTransformUtils.preCheckCast(this.segments, Object[].class, "com.obric.memorydata.plugin")).length - 1], r11, 1);
        int r0 = segment(r11);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L7:
        return this.segments[r0][(r11 - r1) + this.directory[((Object[]) ZeusTransformUtils.preCheckCast(this.segments, Object[].class, "com.obric.memorydata.plugin")).length + r0]];
    L5:
        r1 = this.directory[r0 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] r2, int r3) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return toByteString().lastIndexOf(r2, r3);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r9, ByteString r10, int r11, int r12) {
        Intrinsics.checkParameterIsNotNull(r10, "other");
        if (r9 >= 0) goto L5;
    L18:
        return false;
    L5:
        if (r9 > (size() - r12)) goto L18;
        int r13 = r12 + r9;
        int r1 = access$segment(this, r9);
    L8:
        if (r9 >= r13) goto L16;
        if (r1 != 0) goto L11;
        int r2 = 0;
    L12:
        int r3 = getDirectory()[r1] - r2;
        int r4 = getDirectory()[((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length + r1];
        int r5 = Math.min(r13, r3 + r2) - r9;
        if (r10.rangeEquals(r11, getSegments()[r1], r4 + (r9 - r2), r5) == false) goto L14;
        r11 = r11 + r5;
        r9 = r9 + r5;
        r1 = r1 + 1;
        goto L8
    L14:
        return false;
    L11:
        r2 = getDirectory()[r1 - 1];
        goto L12
    L16:
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r9, byte[] r10, int r11, int r12) {
        Intrinsics.checkParameterIsNotNull(r10, "other");
        if (r9 >= 0) goto L5;
    L21:
        return false;
    L5:
        if (r9 > (size() - r12)) goto L21;
        if (r11 < 0) goto L21;
        if (r11 > (r10.length - r12)) goto L21;
        int r13 = r12 + r9;
        int r1 = access$segment(this, r9);
    L11:
        if (r9 >= r13) goto L19;
        if (r1 != 0) goto L14;
        int r2 = 0;
    L15:
        int r3 = getDirectory()[r1] - r2;
        int r4 = getDirectory()[((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length + r1];
        int r5 = Math.min(r13, r3 + r2) - r9;
        if (Util.arrayRangeEquals(getSegments()[r1], r4 + (r9 - r2), r10, r11, r5) == false) goto L17;
        r11 = r11 + r5;
        r9 = r9 + r5;
        r1 = r1 + 1;
        goto L11
    L17:
        return false;
    L14:
        r2 = getDirectory()[r1 - 1];
        goto L15
    L19:
        return true;
    }

    @Override // okio.ByteString
    public String string(Charset r2) {
        Intrinsics.checkParameterIsNotNull(r2, "charset");
        return toByteString().string(r2);
    }

    @Override // okio.ByteString
    public ByteString substring(int r14, int r15) {
        int r0 = 0;
        if (r14 < 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L42;
        if (r15 > size()) goto L11;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L40;
        int r4 = r15 - r14;
        if (r4 < 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L38;
        if (r14 == 0) goto L21;
    L24:
        if (r14 == r15) goto L26;
        int r6 = segment(r14);
        int r16 = segment(r15 - 1);
        Object[] r7 = Arrays.copyOfRange((Object[]) ZeusTransformUtils.preCheckCast(this.segments, Object[].class, "com.obric.memorydata.plugin"), r6, r16 + 1);
        Intrinsics.checkExpressionValueIsNotNull(r7, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        byte[][] r8 = (byte[][]) ZeusTransformUtils.preCheckCast(r7, byte[][].class, "com.obric.memorydata.plugin");
        int[] r9 = new int[((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin")).length * 2];
        if (r6 > r16) goto L33;
        int r10 = 0;
        int r11 = r6;
    L30:
        r9[r10] = Math.min(this.directory[r11] - r14, r4);
        int r12 = r10 + 1;
        r9[r10 + ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin")).length] = this.directory[((Object[]) ZeusTransformUtils.preCheckCast(this.segments, Object[].class, "com.obric.memorydata.plugin")).length + r11];
        if (r11 == r16) goto L33;
        r11 = r11 + 1;
        r10 = r12;
    L33:
        if (r6 == 0) goto L36;
        r0 = this.directory[r6 - 1];
    L36:
        int r13 = ((Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin")).length;
        r9[r13] = r9[r13] + (r14 - r0);
        SegmentedByteString this = new SegmentedByteString(r8, r9);
    L23:
        return (ByteString) ZeusTransformUtils.preCheckCast(this, ByteString.class, "com.obric.memorydata.plugin");
    L26:
        return ByteString.EMPTY;
    L21:
        if (r15 != size()) goto L24;
    L38:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex=" + r15 + " < beginIndex=" + r14).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L17:
        r5 = false;
        goto L18
    L40:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex=" + r15 + " > length(" + size() + ')').toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        r3 = false;
        goto L13
    L42:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("beginIndex=" + r14 + " < 0").toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L7
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
        byte[] r0 = new byte[size()];
        int r1 = ((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r5 = getDirectory()[r1 + r2];
        int r6 = getDirectory()[r2];
        int r7 = r6 - r3;
        Platform.arraycopy(getSegments()[r2], r5, r0, r4, r7);
        r4 = r4 + r7;
        r2 = r2 + 1;
        r3 = r6;
        goto L3
    L5:
        return r0;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream r7) {
        Intrinsics.checkParameterIsNotNull(r7, "out");
        int r0 = ((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = getDirectory()[r0 + r1];
        int r4 = getDirectory()[r1];
        r7.write(getSegments()[r1], r3, r4 - r2);
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    }

    @Override // okio.ByteString
    public void write$jvm(Buffer r12) {
        Intrinsics.checkParameterIsNotNull(r12, "buffer");
        int r0 = ((Object[]) ZeusTransformUtils.preCheckCast(getSegments(), Object[].class, "com.obric.memorydata.plugin")).length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L15;
        int r7 = getDirectory()[r0 + r1];
        int r3 = getDirectory()[r1];
        Segment r4 = new Segment(getSegments()[r1], r7, r7 + (r3 - r2), true, false);
        if (r12.head != null) goto L7;
        r4.prev = r4;
        r4.next = r4.prev;
        r12.head = r4.next;
    L14:
        r1 = r1 + 1;
        r2 = r3;
        goto L3
    L7:
        Segment r5 = r12.head;
        if (r5 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        Segment r6 = r5.prev;
        if (r6 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        r6.push(r4);
        goto L14
    L15:
        r12.setSize$jvm(r12.size() + ((long) size()));
    }
}
