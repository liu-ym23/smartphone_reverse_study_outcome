package okio;

import com.bytedance.crypto.utils.CryptoConst;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\n\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "write", "", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Buffer;", "byteCount", "", "Companion", "jvm"}, k = 1, mv = {1, 1, 11})
public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = null;
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final HashingSink hmacSha1(Sink r2, ByteString r3) {
            Sink r1 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "sink");
            Intrinsics.checkParameterIsNotNull(r3, "key");
            return new HashingSink(r1, r3, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSink hmacSha256(Sink r2, ByteString r3) {
            Sink r1 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "sink");
            Intrinsics.checkParameterIsNotNull(r3, "key");
            return new HashingSink(r1, r3, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSink hmacSha512(Sink r2, ByteString r3) {
            Sink r1 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "sink");
            Intrinsics.checkParameterIsNotNull(r3, "key");
            return new HashingSink(r1, r3, "HmacSHA512");
        }

        @JvmStatic
        public final HashingSink md5(Sink r2) {
            Sink r1 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "sink");
            return new HashingSink(r1, CryptoConst.ALGORITHM_MD5);
        }

        @JvmStatic
        public final HashingSink sha1(Sink r2) {
            Sink r1 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "sink");
            return new HashingSink(r1, "SHA-1");
        }

        @JvmStatic
        public final HashingSink sha256(Sink r2) {
            Sink r1 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "sink");
            return new HashingSink(r1, CryptoConst.ALGORITHM_SHA256);
        }

        @JvmStatic
        public final HashingSink sha512(Sink r2) {
            Sink r1 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, "sink");
            return new HashingSink(r1, "SHA-512");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public HashingSink(Sink r3, String r4) {
        Sink r5 = (Sink) ZeusTransformUtils.wrapperContextForParams(r3, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "sink");
        Intrinsics.checkParameterIsNotNull(r4, "algorithm");
        super(r5);
        this.messageDigest = MessageDigest.getInstance(r4);
        this.mac = (Mac) ZeusTransformUtils.preCheckCast(null, Mac.class, "com.obric.memorydata.plugin");
    }

    public HashingSink(Sink r3, ByteString r4, String r5) {
        Sink r6 = (Sink) ZeusTransformUtils.wrapperContextForParams(r3, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "sink");
        Intrinsics.checkParameterIsNotNull(r4, "key");
        Intrinsics.checkParameterIsNotNull(r5, "algorithm");
        super(r6);
        Mac r7 = Mac.getInstance(r5);     // Catch: InvalidKeyException -> L5
        r7.init((Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r4.toByteArray(), r5), Key.class, "com.obric.memorydata.plugin"));     // Catch: InvalidKeyException -> L5
        this.mac = r7;     // Catch: InvalidKeyException -> L5
        this.messageDigest = (MessageDigest) ZeusTransformUtils.preCheckCast(null, MessageDigest.class, "com.obric.memorydata.plugin");     // Catch: InvalidKeyException -> L5
        return;
    L5:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final HashingSink hmacSha1(Sink r2, ByteString r3) {
        Sink r4 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        return Companion.hmacSha1(r4, r3);
    }

    @JvmStatic
    public static final HashingSink hmacSha256(Sink r2, ByteString r3) {
        Sink r4 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        return Companion.hmacSha256(r4, r3);
    }

    @JvmStatic
    public static final HashingSink hmacSha512(Sink r2, ByteString r3) {
        Sink r4 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        return Companion.hmacSha512(r4, r3);
    }

    @JvmStatic
    public static final HashingSink md5(Sink r2) {
        Sink r3 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        return Companion.md5(r3);
    }

    @JvmStatic
    public static final HashingSink sha1(Sink r2) {
        Sink r3 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        return Companion.sha1(r3);
    }

    @JvmStatic
    public static final HashingSink sha256(Sink r2) {
        Sink r3 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        return Companion.sha256(r3);
    }

    @JvmStatic
    public static final HashingSink sha512(Sink r2) {
        Sink r3 = (Sink) ZeusTransformUtils.wrapperContextForParams(r2, Sink.class, "com.obric.memorydata.plugin");
        return Companion.sha512(r3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m3063deprecated_hash() {
        return hash();
    }

    public final ByteString hash() {
        MessageDigest r0 = this.messageDigest;
        if (r0 == null) goto L5;
        byte[] r2 = r0.digest();
    L9:
        Intrinsics.checkExpressionValueIsNotNull(r2, "result");
        return new ByteString(r2);
    L5:
        Mac r3 = this.mac;
        if (r3 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        r2 = r3.doFinal();
        goto L9
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer r8, long r9) {
        Intrinsics.checkParameterIsNotNull(r8, AILabCheckPermissionTask.KEY_SOURCE);
        Util.checkOffsetAndCount(r8.size(), 0, r9);
        Segment r0 = r8.head;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        long r1 = 0;
    L7:
        if (r1 >= r9) goto L18;
        int r3 = (int) Math.min(r9 - r1, r0.limit - r0.pos);
        MessageDigest r4 = this.messageDigest;
        if (r4 == null) goto L11;
        r4.update(r0.data, r0.pos, r3);
    L15:
        r1 = r1 + ((long) r3);
        r0 = r0.next;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
        goto L7
    L11:
        Mac r5 = this.mac;
        if (r5 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r5.update(r0.data, r0.pos, r3);
        goto L15
    L18:
        super.write(r8, r9);
    }
}
