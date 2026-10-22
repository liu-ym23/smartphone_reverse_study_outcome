package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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
import kotlin.text.Charsets;
import okio.internal.ByteStringKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 Z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001ZB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0000J\u0013\u0010!\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\"H\u0096\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b&J\u0015\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0007¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\tH\u0010¢\u0006\u0002\b)J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u001d\u0010+\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0000H\u0010¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\r\u00103\u001a\u00020\u0004H\u0010¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\tH\u0010¢\u0006\u0002\b7J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\b\u00109\u001a\u00020\u0000H\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020\u0000H\u0016J\b\u0010C\u001a\u00020\u0000H\u0016J\b\u0010D\u001a\u00020\u0000H\u0016J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bEJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016J\u001c\u0010K\u001a\u00020\u00002\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\tH\u0017J\b\u0010N\u001a\u00020\u0000H\u0016J\b\u0010O\u001a\u00020\u0000H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020TH\u0016J\u0015\u0010R\u001a\u00020?2\u0006\u0010U\u001a\u00020VH\u0010¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020?2\u0006\u0010S\u001a\u00020YH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006["}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$jvm", "()[B", "hashCode", "", "getHashCode$jvm", "()I", "setHashCode$jvm", "(I)V", "size", "utf8", "", "getUtf8$jvm", "()Ljava/lang/String;", "setUtf8$jvm", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "digest", "algorithm", "digest$jvm", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$jvm", "hex", "hmac", "key", "hmac$jvm", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$jvm", "internalGet", "pos", "internalGet$jvm", "lastIndexOf", "md5", "rangeEquals", TypedValues.CycleType.S_WAVE_OFFSET, "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", TypedValues.Custom.S_STRING, "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$jvm", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "jvm"}, k = 1, mv = {1, 1, 11})
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = null;
    public static final ByteString EMPTY = null;
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", TypedValues.Custom.S_STRING, "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", TypedValues.CycleType.S_WAVE_OFFSET, "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ ByteString encodeString$default(Companion r0, String r1, Charset r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = Charsets.UTF_8;
        L6:
            return r0.encodeString(r1, r2);
        }

        @JvmStatic
        public static /* synthetic */ ByteString of$default(Companion r0, byte[] r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r1.length;
        L9:
            return r0.of(r1, r2, r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        /* JADX INFO: renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m3052deprecated_decodeBase64(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, TypedValues.Custom.S_STRING);
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).decodeBase64(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        /* JADX INFO: renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m3053deprecated_decodeHex(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, TypedValues.Custom.S_STRING);
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).decodeHex(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        /* JADX INFO: renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m3054deprecated_encodeString(String r3, Charset r4) {
            Intrinsics.checkParameterIsNotNull(r3, TypedValues.Custom.S_STRING);
            Intrinsics.checkParameterIsNotNull(r4, "charset");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).encodeString(r3, r4);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        /* JADX INFO: renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m3055deprecated_encodeUtf8(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, TypedValues.Custom.S_STRING);
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).encodeUtf8(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m3056deprecated_of(ByteBuffer r3) {
            Intrinsics.checkParameterIsNotNull(r3, "buffer");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).of(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m3057deprecated_of(byte[] r3, int r4, int r5) {
            Intrinsics.checkParameterIsNotNull(r3, "array");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).of(r3, r4, r5);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m3058deprecated_read(InputStream r3, int r4) {
            Intrinsics.checkParameterIsNotNull(r3, "inputstream");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).read(r3, r4);
        }

        @JvmStatic
        public final ByteString decodeBase64(String r1) {
            Intrinsics.checkParameterIsNotNull(r1, "$receiver");
            return ByteStringKt.commonDecodeBase64(r1);
        }

        @JvmStatic
        public final ByteString decodeHex(String r1) {
            Intrinsics.checkParameterIsNotNull(r1, "$receiver");
            return ByteStringKt.commonDecodeHex(r1);
        }

        @JvmStatic
        public final ByteString encodeString(String r1, Charset r2) {
            Intrinsics.checkParameterIsNotNull(r1, "$receiver");
            Intrinsics.checkParameterIsNotNull(r2, "charset");
            byte[] r3 = r1.getBytes(r2);
            Intrinsics.checkExpressionValueIsNotNull(r3, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(r3);
        }

        @JvmStatic
        public final ByteString encodeUtf8(String r1) {
            Intrinsics.checkParameterIsNotNull(r1, "$receiver");
            return ByteStringKt.commonEncodeUtf8(r1);
        }

        @JvmStatic
        public final ByteString of(ByteBuffer r1) {
            Intrinsics.checkParameterIsNotNull(r1, "$receiver");
            byte[] r0 = new byte[r1.remaining()];
            r1.get(r0);
            return new ByteString(r0);
        }

        @JvmStatic
        public final ByteString of(byte... r1) {
            Intrinsics.checkParameterIsNotNull(r1, "data");
            return ByteStringKt.commonOf(r1);
        }

        @JvmStatic
        public final ByteString of(byte[] r7, int r8, int r9) {
            Intrinsics.checkParameterIsNotNull(r7, "$receiver");
            Util.checkOffsetAndCount(r7.length, r8, r9);
            byte[] r6 = new byte[r9];
            Platform.arraycopy(r7, r8, r6, 0, r9);
            return new ByteString(r6);
        }

        @JvmStatic
        public final ByteString read(InputStream r5, int r6) {
            Intrinsics.checkParameterIsNotNull(r5, "$receiver");
            int r4 = 0;
            if (r6 < 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L18;
            byte[] r1 = new byte[r6];
        L9:
            if (r4 >= r6) goto L16;
            int r2 = r5.read(r1, r4, r6 - r4);
            if (r2 == (-1)) goto L14;
            r4 = r4 + r2;
            goto L9
        L14:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
        L16:
            return new ByteString(r1);
        L18:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r0 = false;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = ByteStringKt.getCOMMON_EMPTY();
    }

    public ByteString(byte[] r2) {
        Intrinsics.checkParameterIsNotNull(r2, "data");
        this.data = r2;
    }

    @JvmStatic
    public static final ByteString decodeBase64(String r1) {
        return Companion.decodeBase64(r1);
    }

    @JvmStatic
    public static final ByteString decodeHex(String r1) {
        return Companion.decodeHex(r1);
    }

    @JvmStatic
    public static final ByteString encodeString(String r1, Charset r2) {
        return Companion.encodeString(r1, r2);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String r1) {
        return Companion.encodeUtf8(r1);
    }

    public static /* synthetic */ int indexOf$default(ByteString r0, ByteString r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        return r0.indexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int indexOf$default(ByteString r0, byte[] r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = 0;
    L7:
        return r0.indexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r0, ByteString r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = r0.size();
    L7:
        return r0.lastIndexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r0, byte[] r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = r0.size();
    L7:
        return r0.lastIndexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    public static final ByteString of(ByteBuffer r1) {
        return Companion.of(r1);
    }

    @JvmStatic
    public static final ByteString of(byte... r1) {
        return Companion.of(r1);
    }

    @JvmStatic
    public static final ByteString of(byte[] r1, int r2, int r3) {
        return Companion.of(r1, r2, r3);
    }

    @JvmStatic
    public static final ByteString read(InputStream r1, int r2) {
        return Companion.read(r1, r2);
    }

    private final void readObject(ObjectInputStream r5) {
        int r0 = r5.readInt();
        ByteString r6 = Companion.read((InputStream) ZeusTransformUtils.preCheckCast(r5, InputStream.class, "com.obric.memorydata.plugin"), r0);
        Field r1 = ByteString.class.getDeclaredField("data");
        Intrinsics.checkExpressionValueIsNotNull(r1, "field");
        r1.setAccessible(true);
        r1.set(this, r6.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString r0, int r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L7;
        r1 = 0;
    L7:
        if ((r3 & 2) == 0) goto L10;
        r2 = r0.size();
    L10:
        return r0.substring(r1, r2);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream r2) {
        r2.writeInt(this.data.length);
        r2.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m3050deprecated_getByte(int r1) {
        return getByte(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m3051deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer r1 = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkExpressionValueIsNotNull(r1, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return r1;
    }

    public String base64() {
        return ByteStringKt.commonBase64(this);
    }

    public String base64Url() {
        return ByteStringKt.commonBase64Url(this);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ByteString r3) {
        return compareTo2((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return ByteStringKt.commonCompareTo(this, r2);
    }

    public ByteString digest$jvm(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "algorithm");
        byte[] r1 = MessageDigest.getInstance(r2).digest(this.data);
        Intrinsics.checkExpressionValueIsNotNull(r1, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(r1);
    }

    public final boolean endsWith(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "suffix");
        return ByteStringKt.commonEndsWith(this, r2);
    }

    public final boolean endsWith(byte[] r2) {
        Intrinsics.checkParameterIsNotNull(r2, "suffix");
        return ByteStringKt.commonEndsWith(this, r2);
    }

    public boolean equals(Object r1) {
        return ByteStringKt.commonEquals(this, r1);
    }

    public final byte getByte(int r1) {
        return internalGet$jvm(r1);
    }

    public final byte[] getData$jvm() {
        return this.data;
    }

    public final int getHashCode$jvm() {
        return this.hashCode;
    }

    public int getSize$jvm() {
        return ByteStringKt.commonGetSize(this);
    }

    public final String getUtf8$jvm() {
        return this.utf8;
    }

    public int hashCode() {
        return ByteStringKt.commonHashCode(this);
    }

    public String hex() {
        return ByteStringKt.commonHex(this);
    }

    public ByteString hmac$jvm(String r4, ByteString r5) {
        Intrinsics.checkParameterIsNotNull(r4, "algorithm");
        Intrinsics.checkParameterIsNotNull(r5, "key");
        Mac r1 = Mac.getInstance(r4);     // Catch: InvalidKeyException -> L5
        r1.init((Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r5.toByteArray(), r4), Key.class, "com.obric.memorydata.plugin"));     // Catch: InvalidKeyException -> L5
        byte[] r3 = r1.doFinal(this.data);     // Catch: InvalidKeyException -> L5
        Intrinsics.checkExpressionValueIsNotNull(r3, "mac.doFinal(data)");     // Catch: InvalidKeyException -> L5
        return new ByteString(r3);
    L5:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public ByteString hmacSha1(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "key");
        return hmac$jvm("HmacSHA1", r2);
    }

    public ByteString hmacSha256(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "key");
        return hmac$jvm("HmacSHA256", r2);
    }

    public ByteString hmacSha512(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "key");
        return hmac$jvm("HmacSHA512", r2);
    }

    public final int indexOf(ByteString r4) {
        return indexOf$default(this, r4, 0, 2, null);
    }

    public final int indexOf(ByteString r2, int r3) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return indexOf(r2.internalArray$jvm(), r3);
    }

    public int indexOf(byte[] r4) {
        return indexOf$default(this, r4, 0, 2, null);
    }

    public int indexOf(byte[] r2, int r3) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return ByteStringKt.commonIndexOf(this, r2, r3);
    }

    public byte[] internalArray$jvm() {
        return ByteStringKt.commonInternalArray(this);
    }

    public byte internalGet$jvm(int r1) {
        return ByteStringKt.commonGetByte(this, r1);
    }

    public final int lastIndexOf(ByteString r4) {
        return lastIndexOf$default(this, r4, 0, 2, null);
    }

    public final int lastIndexOf(ByteString r2, int r3) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return lastIndexOf(r2.internalArray$jvm(), r3);
    }

    public int lastIndexOf(byte[] r4) {
        return lastIndexOf$default(this, r4, 0, 2, null);
    }

    public int lastIndexOf(byte[] r2, int r3) {
        Intrinsics.checkParameterIsNotNull(r2, "other");
        return ByteStringKt.commonLastIndexOf(this, r2, r3);
    }

    public ByteString md5() {
        return digest$jvm(CryptoConst.ALGORITHM_MD5);
    }

    public boolean rangeEquals(int r2, ByteString r3, int r4, int r5) {
        Intrinsics.checkParameterIsNotNull(r3, "other");
        return ByteStringKt.commonRangeEquals(this, r2, r3, r4, r5);
    }

    public boolean rangeEquals(int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkParameterIsNotNull(r3, "other");
        return ByteStringKt.commonRangeEquals(this, r2, r3, r4, r5);
    }

    public final void setHashCode$jvm(int r1) {
        this.hashCode = r1;
    }

    public final void setUtf8$jvm(String r1) {
        this.utf8 = r1;
    }

    public ByteString sha1() {
        return digest$jvm("SHA-1");
    }

    public ByteString sha256() {
        return digest$jvm(CryptoConst.ALGORITHM_SHA256);
    }

    public ByteString sha512() {
        return digest$jvm("SHA-512");
    }

    public final int size() {
        return getSize$jvm();
    }

    public final boolean startsWith(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "prefix");
        return ByteStringKt.commonStartsWith(this, r2);
    }

    public final boolean startsWith(byte[] r2) {
        Intrinsics.checkParameterIsNotNull(r2, "prefix");
        return ByteStringKt.commonStartsWith(this, r2);
    }

    public String string(Charset r2) {
        Intrinsics.checkParameterIsNotNull(r2, "charset");
        return new String(this.data, r2);
    }

    public ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString substring(int r4) {
        return substring$default(this, r4, 0, 2, null);
    }

    public ByteString substring(int r1, int r2) {
        return ByteStringKt.commonSubstring(this, r1, r2);
    }

    public ByteString toAsciiLowercase() {
        return ByteStringKt.commonToAsciiLowercase(this);
    }

    public ByteString toAsciiUppercase() {
        return ByteStringKt.commonToAsciiUppercase(this);
    }

    public byte[] toByteArray() {
        return ByteStringKt.commonToByteArray(this);
    }

    public String toString() {
        return ByteStringKt.commonToString(this);
    }

    public String utf8() {
        return ByteStringKt.commonUtf8(this);
    }

    public void write(OutputStream r2) {
        Intrinsics.checkParameterIsNotNull(r2, "out");
        r2.write(this.data);
    }

    public void write$jvm(Buffer r3) {
        Intrinsics.checkParameterIsNotNull(r3, "buffer");
        byte[] r2 = this.data;
        r3.write(r2, 0, r2.length);
    }
}
