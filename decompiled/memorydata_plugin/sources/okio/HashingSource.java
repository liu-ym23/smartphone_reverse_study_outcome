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
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R\u0011\u0010\n\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Source;", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "read", "", "sink", "Lokio/Buffer;", "byteCount", "Companion", "jvm"}, k = 1, mv = {1, 1, 11})
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = null;
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lokio/HashingSource$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSource;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Source;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final HashingSource hmacSha1(Source r2, ByteString r3) {
            Source r1 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkParameterIsNotNull(r3, "key");
            return new HashingSource(r1, r3, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSource hmacSha256(Source r2, ByteString r3) {
            Source r1 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkParameterIsNotNull(r3, "key");
            return new HashingSource(r1, r3, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSource hmacSha512(Source r2, ByteString r3) {
            Source r1 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkParameterIsNotNull(r3, "key");
            return new HashingSource(r1, r3, "HmacSHA512");
        }

        @JvmStatic
        public final HashingSource md5(Source r2) {
            Source r1 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, AILabCheckPermissionTask.KEY_SOURCE);
            return new HashingSource(r1, CryptoConst.ALGORITHM_MD5);
        }

        @JvmStatic
        public final HashingSource sha1(Source r2) {
            Source r1 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, AILabCheckPermissionTask.KEY_SOURCE);
            return new HashingSource(r1, "SHA-1");
        }

        @JvmStatic
        public final HashingSource sha256(Source r2) {
            Source r1 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, AILabCheckPermissionTask.KEY_SOURCE);
            return new HashingSource(r1, CryptoConst.ALGORITHM_SHA256);
        }

        @JvmStatic
        public final HashingSource sha512(Source r2) {
            Source r1 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r1, AILabCheckPermissionTask.KEY_SOURCE);
            return new HashingSource(r1, "SHA-512");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public HashingSource(Source r3, String r4) {
        Source r5 = (Source) ZeusTransformUtils.wrapperContextForParams(r3, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r4, "algorithm");
        super(r5);
        this.messageDigest = MessageDigest.getInstance(r4);
        this.mac = (Mac) ZeusTransformUtils.preCheckCast(null, Mac.class, "com.obric.memorydata.plugin");
    }

    public HashingSource(Source r3, ByteString r4, String r5) {
        Source r6 = (Source) ZeusTransformUtils.wrapperContextForParams(r3, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, AILabCheckPermissionTask.KEY_SOURCE);
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
    public static final HashingSource hmacSha1(Source r2, ByteString r3) {
        Source r4 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        return Companion.hmacSha1(r4, r3);
    }

    @JvmStatic
    public static final HashingSource hmacSha256(Source r2, ByteString r3) {
        Source r4 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        return Companion.hmacSha256(r4, r3);
    }

    @JvmStatic
    public static final HashingSource hmacSha512(Source r2, ByteString r3) {
        Source r4 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        return Companion.hmacSha512(r4, r3);
    }

    @JvmStatic
    public static final HashingSource md5(Source r2) {
        Source r3 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        return Companion.md5(r3);
    }

    @JvmStatic
    public static final HashingSource sha1(Source r2) {
        Source r3 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        return Companion.sha1(r3);
    }

    @JvmStatic
    public static final HashingSource sha256(Source r2) {
        Source r3 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        return Companion.sha256(r3);
    }

    @JvmStatic
    public static final HashingSource sha512(Source r2) {
        Source r3 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        return Companion.sha512(r3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m3064deprecated_hash() {
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

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer r8, long r9) {
        Intrinsics.checkParameterIsNotNull(r8, "sink");
        long r10 = super.read(r8, r9);
        if (r10 == (-1)) goto L26;
        long r0 = r8.size() - r10;
        long r2 = r8.size();
        Segment r4 = r8.head;
        if (r4 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        if (r2 <= r0) goto L14;
        r4 = r4.prev;
        if (r4 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        r2 = r2 - ((long) (r4.limit - r4.pos));
    L14:
        if (r2 >= r8.size()) goto L26;
        int r1 = (int) ((((long) r4.pos) + r0) - r2);
        MessageDigest r3 = this.messageDigest;
        if (r3 == null) goto L18;
        r3.update(r4.data, r1, r4.limit - r1);
    L22:
        r2 = r2 + ((long) (r4.limit - r4.pos));
        r4 = r4.next;
        if (r4 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        r0 = r2;
        goto L14
    L18:
        Mac r5 = this.mac;
        if (r5 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        r5.update(r4.data, r1, r4.limit - r1);
    L26:
        return r10;
    }
}
