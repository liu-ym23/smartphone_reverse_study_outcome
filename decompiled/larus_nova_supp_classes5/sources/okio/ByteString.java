package okio;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ]2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001]B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J,\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0010H\u0010¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000J\u0013\u0010'\u001a\u00020%2\b\u0010\u001a\u001a\u0004\u0018\u00010(H\u0096\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b,J\u0015\u0010,\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0007¢\u0006\u0002\b-J\r\u0010.\u001a\u00020\tH\u0010¢\u0006\u0002\b/J\b\u0010\b\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\u001d\u00101\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0000H\u0010¢\u0006\u0002\b3J\u0010\u00104\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00106\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\r\u00109\u001a\u00020\u0004H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\tH\u0010¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\u0006\u0010?\u001a\u00020\u0000J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bHJ\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0000J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020MH\u0016J\u001c\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\tH\u0017J\b\u0010Q\u001a\u00020\u0000H\u0016J\b\u0010R\u001a\u00020\u0000H\u0016J\b\u0010S\u001a\u00020\u0004H\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020WH\u0016J%\u0010U\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0010¢\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\\H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006^"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "copyInto", "", "offset", "target", "targetOffset", "byteCount", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", DBDefinition.MD5, "rangeEquals", "otherOffset", "readObject", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final a Companion = null;
    public static final ByteString EMPTY = null;
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ByteString a(String r16) {
            Intrinsics.checkNotNullParameter(r16, "<this>");
            byte[] r2 = okio.a.a;
            Intrinsics.checkNotNullParameter(r16, "<this>");
            int r1 = r16.length();
        L4:
            if (r1 <= 0) goto L13;
            int r6 = r1 - 1;
            char r7 = r16.charAt(r6);
            if (r7 == '=') goto L12;
            if (r7 == '\n') goto L12;
            if (r7 == '\r') goto L12;
            if (r7 == ' ') goto L12;
            if (r7 != '\t') goto L13;
        L12:
            r1 = r6;
        L13:
            int r8 = (int) ((((long) r1) * 6) / 8);
            byte[] r9 = new byte[r8];
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
        L14:
            boolean r14 = true;
            if (r10 >= r1) goto L61;
            char r15 = r16.charAt(r10);
            if ('A' <= r15) goto L19;
        L21:
            boolean r17 = false;
        L22:
            if (r17 == false) goto L25;
            int r18 = r15 - 'A';
        L57:
            r12 = (r12 << 6) | r18;
            r11 = r11 + 1;
            if ((r11 % 4) != 0) goto L60;
            int r19 = r13 + 1;
            r9[r13] = (byte) (r12 >> 16);
            int r110 = r19 + 1;
            r9[r19] = (byte) (r12 >> 8);
            r9[r110] = (byte) r12;
            r13 = r110 + 1;
        L60:
            r10 = r10 + 1;
            goto L14
        L25:
            if ('a' <= r15) goto L27;
        L29:
            boolean r20 = false;
        L30:
            if (r20 == false) goto L33;
            r18 = r15 - 'G';
            goto L57
        L33:
            if ('0' <= r15) goto L35;
        L37:
            r14 = false;
        L38:
            if (r14 == false) goto L41;
            r18 = r15 + 4;
            goto L57
        L41:
            if (r15 != '+') goto L43;
        L56:
            r18 = 62;
            goto L57
        L43:
            if (r15 == '-') goto L56;
            if (r15 != '/') goto L48;
        L55:
            r18 = 63;
            goto L57
        L48:
            if (r15 == '_') goto L55;
            if (r15 == '\n') goto L60;
            if (r15 == '\r') goto L60;
            if (r15 == ' ') goto L60;
            if (r15 == '\t') goto L60;
        L73:
            r9 = null;
        L74:
            if (r9 != null) goto L76;
            return null;
        L76:
            return new ByteString(r9);
        L35:
            if (r15 >= ':') goto L37;
        L27:
            if (r15 >= '{') goto L29;
            r20 = true;
            goto L30
        L19:
            if (r15 >= '[') goto L21;
            r17 = true;
            goto L22
        L61:
            int r111 = r11 % 4;
            if (r111 == 1) goto L73;
            if (r111 != 2) goto L66;
            r9[r13] = (byte) ((r12 << 12) >> 16);
            r13 = r13 + 1;
        L70:
            if (r13 == r8) goto L74;
            r9 = Arrays.copyOf(r9, r13);
            goto L74
        L66:
            if (r111 != 3) goto L70;
            int r0 = r12 << 6;
            int r3 = r13 + 1;
            r9[r13] = (byte) (r0 >> 16);
            r13 = r3 + 1;
            r9[r3] = (byte) (r0 >> 8);
            goto L70
        }

        @JvmStatic
        public static ByteString b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Intrinsics.checkNotNullParameter(r2, "<this>");
            ByteString r1 = new ByteString(r2.getBytes(Charsets.UTF_8));
            r1.setUtf8$okio(r2);
            return r1;
        }

        @JvmStatic
        public static ByteString c(byte... r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            return new ByteString(Arrays.copyOf(r2, r2.length));
        }

        public static /* synthetic */ ByteString e(a r1, byte[] r2) {
            Buffer.a r0 = b.a;
            r1.getClass();
            return d(r2, 0, -1234567890);
        }

        @JvmStatic
        public static ByteString f(InputStream r4, int r5) throws IOException {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            int r0 = 0;
            if (r5 < 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L17;
            byte[] r2 = new byte[r5];
        L8:
            if (r0 >= r5) goto L15;
            int r3 = r4.read(r2, r0, r5 - r0);
            if (r3 == (-1)) goto L13;
            r0 = r0 + r3;
            goto L8
        L13:
            throw new EOFException();
        L15:
            return new ByteString(r2);
        L17:
            throw new IllegalArgumentException(("byteCount < 0: " + r5).toString());
        L5:
            r1 = false;
            goto L6
        }

        @JvmStatic
        public static ByteString d(byte[] r7, int r8, int r9) {
            Intrinsics.checkNotNullParameter(r7, "<this>");
            Buffer.a r1 = b.a;
            Intrinsics.checkNotNullParameter(r7, "<this>");
            if (r9 != (-1234567890)) goto L5;
            r9 = r7.length;
        L5:
            b.b(r7.length, r8, r9);
            return new ByteString(ArraysKt.copyOfRange(r7, r8, r9 + r8));
        }
    }

    @JvmStatic
    public static final ByteString decodeBase64(String r1) {
        Companion.getClass();
        return a.a(r1);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String r1) {
        Companion.getClass();
        return a.b(r1);
    }

    @JvmStatic
    public static final ByteString of(byte... r1) {
        Companion.getClass();
        return a.c(r1);
    }

    @JvmStatic
    public static final ByteString of(byte[] r1, int r2, int r3) {
        Companion.getClass();
        return a.d(r1, r2, r3);
    }

    @JvmStatic
    public static final ByteString read(InputStream r1, int r2) throws IOException {
        Companion.getClass();
        return a.f(r1, r2);
    }

    public final int indexOf(ByteString r4) {
        Intrinsics.checkNotNullParameter(r4, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        return indexOf$default(this, r4, 0, 2, null);
    }

    public final int indexOf(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        return indexOf$default(this, r4, 0, 2, null);
    }

    public final int lastIndexOf(ByteString r4) {
        Intrinsics.checkNotNullParameter(r4, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        return lastIndexOf$default(this, r4, 0, 2, null);
    }

    public final int lastIndexOf(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        return lastIndexOf$default(this, r4, 0, 2, null);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int r4) {
        return substring$default(this, r4, 0, 2, null);
    }

    public ByteString toAsciiLowercase() {
        int r0 = 0;
    L4:
        if (r0 >= getData$okio().length) goto L22;
        byte r1 = getData$okio()[r0];
        if (r1 < 65) goto L20;
        if (r1 > 90) goto L20;
        byte[] r4 = getData$okio();
        byte[] r5 = Arrays.copyOf(r4, r4.length);
        int r6 = r0 + 1;
        r5[r0] = (byte) (r1 + 32);
    L12:
        if (r6 >= r5.length) goto L31;
        byte r2 = r5[r6];
        if (r2 < 65) goto L18;
        if (r2 > 90) goto L18;
        r5[r6] = (byte) (r2 + 32);
    L18:
        r6 = r6 + 1;
        goto L12
    L31:
        return new ByteString(r5);
    L20:
        r0 = r0 + 1;
        goto L4
    L22:
        return this;
    }

    public ByteString toAsciiUppercase() {
        int r0 = 0;
    L4:
        if (r0 >= getData$okio().length) goto L22;
        byte r1 = getData$okio()[r0];
        if (r1 < 97) goto L20;
        if (r1 > 122) goto L20;
        byte[] r4 = getData$okio();
        byte[] r5 = Arrays.copyOf(r4, r4.length);
        int r6 = r0 + 1;
        r5[r0] = (byte) (r1 - 32);
    L12:
        if (r6 >= r5.length) goto L31;
        byte r2 = r5[r6];
        if (r2 < 97) goto L18;
        if (r2 > 122) goto L18;
        r5[r6] = (byte) (r2 - 32);
    L18:
        r6 = r6 + 1;
        goto L12
    L31:
        return new ByteString(r5);
    L20:
        r0 = r0 + 1;
        goto L4
    L22:
        return this;
    }

    static {
        Companion = new a();
        EMPTY = new ByteString(new byte[0]);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m541deprecated_size() {
        return size();
    }

    public String base64() {
        return okio.a.a(getData$okio(), okio.a.a);
    }

    public String base64Url() {
        return okio.a.a(getData$okio(), okio.a.b);
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public int hashCode() {
        int r0 = getHashCode$okio();
        if (r0 != 0) goto L7;
        int r1 = Arrays.hashCode(getData$okio());
        setHashCode$okio(r1);
        return r1;
    L7:
        return r0;
    }

    public String hex() {
        char[] r0 = new char[getData$okio().length * 2];
        byte[] r1 = getData$okio();
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L6;
        byte r5 = r1[r3];
        int r6 = r4 + 1;
        char[] r7 = okio.internal.b.a;
        r0[r4] = r7[(r5 >> 4) & 15];
        r4 = r6 + 1;
        r0[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L3
    L6:
        return StringsKt.concatToString(r0);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public final int size() {
        return getSize$okio();
    }

    public byte[] toByteArray() {
        byte[] r0 = getData$okio();
        return Arrays.copyOf(r0, r0.length);
    }

    public String toString() {
        if (getData$okio().length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        String r1 = "[size=0]";
    L316:
        return r1;
    L9:
        byte[] r2 = getData$okio();
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L11:
        if (r4 >= r3) goto L248;
        byte r9 = r2[r4];
        if (r9 >= 0) goto L14;
        if ((r9 >> 5) != (-2)) goto L113;
        int r7 = r4 + 1;
        if (r3 <= r7) goto L72;
        byte r8 = r2[r7];
        if ((r8 & 192) != 128) goto L77;
        boolean r10 = true;
    L78:
        if (r10 == false) goto L79;
        int r11 = (r8 ^ ByteCompanionObject.MIN_VALUE) ^ (r9 << 6);
        if (r11 < 128) goto L83;
        int r12 = r5 + 1;
        if (r5 == 64) goto L248;
        if (r11 == 10) goto L104;
        if (r11 == 13) goto L104;
        if (r11 < 0) goto L93;
        if (r11 >= 32) goto L93;
        boolean r13 = true;
    L94:
        if (r13 == true) goto L102;
        if (127 > r11) goto L98;
        if (r11 >= 160) goto L98;
        boolean r14 = true;
    L99:
        if (r14 == true) goto L102;
        boolean r15 = false;
    L103:
        if (r15 == false) goto L104;
    L246:
        r6 = -1;
    L98:
        r14 = false;
    L102:
        r15 = true;
    L93:
        r13 = false;
    L104:
        if (r11 == 65533) goto L246;
        if (r11 >= 65536) goto L109;
        int r16 = 1;
    L110:
        r6 = r6 + r16;
        Unit r17 = Unit.INSTANCE;
        r4 = r4 + 2;
    L111:
        r5 = r12;
        goto L11
    L109:
        r16 = 2;
        goto L110
    L83:
        if (r5 != 64) goto L246;
    L79:
        if (r5 != 64) goto L246;
    L77:
        r10 = false;
        goto L78
    L72:
        if (r5 != 64) goto L246;
    L113:
        if ((r9 >> 4) != (-2)) goto L173;
        int r18 = r4 + 2;
        if (r3 <= r18) goto L116;
        byte r19 = r2[r4 + 1];
        if ((r19 & 192) != 128) goto L121;
        boolean r110 = true;
    L122:
        if (r110 == false) goto L123;
        byte r20 = r2[r18];
        if ((r20 & 192) != 128) goto L128;
        boolean r111 = true;
    L129:
        if (r111 == false) goto L130;
        int r21 = ((r20 ^ ByteCompanionObject.MIN_VALUE) ^ (r19 << 6)) ^ (r9 << 12);
        if (r21 < 2048) goto L134;
        if (55296 > r21) goto L139;
        if (r21 >= 57344) goto L139;
        boolean r22 = true;
    L140:
        if (r22 == true) goto L141;
        r12 = r5 + 1;
        if (r5 == 64) goto L248;
        if (r21 == 10) goto L165;
        if (r21 == 13) goto L165;
        if (r21 < 0) goto L151;
        if (r21 >= 32) goto L151;
        boolean r23 = true;
    L152:
        if (r23 == false) goto L154;
    L162:
        boolean r24 = true;
    L163:
        if (r24 == true) goto L246;
    L154:
        if (127 <= r21) goto L156;
    L158:
        boolean r25 = false;
    L159:
        if (r25 == true) goto L162;
        r24 = false;
        goto L163
    L156:
        if (r21 >= 160) goto L158;
        r25 = true;
    L151:
        r23 = false;
    L165:
        if (r21 == 65533) goto L246;
        if (r21 >= 65536) goto L170;
        int r112 = 1;
    L171:
        r6 = r6 + r112;
        Unit r26 = Unit.INSTANCE;
        r4 = r4 + 3;
        goto L111
    L170:
        r112 = 2;
        goto L171
    L141:
        if (r5 != 64) goto L246;
    L139:
        r22 = false;
        goto L140
    L134:
        if (r5 != 64) goto L246;
    L130:
        if (r5 != 64) goto L246;
    L128:
        r111 = false;
        goto L129
    L123:
        if (r5 != 64) goto L246;
    L121:
        r110 = false;
        goto L122
    L116:
        if (r5 != 64) goto L246;
    L173:
        if ((r9 >> 3) != (-2)) goto L244;
        int r27 = r4 + 3;
        if (r3 <= r27) goto L176;
        byte r28 = r2[r4 + 1];
        if ((r28 & 192) != 128) goto L181;
        boolean r113 = true;
    L182:
        if (r113 == false) goto L183;
        byte r114 = r2[r4 + 2];
        if ((r114 & 192) != 128) goto L188;
        boolean r115 = true;
    L189:
        if (r115 == false) goto L190;
        byte r29 = r2[r27];
        if ((r29 & 192) != 128) goto L195;
        boolean r116 = true;
    L196:
        if (r116 == false) goto L197;
        int r30 = (((r29 ^ ByteCompanionObject.MIN_VALUE) ^ (r114 << 6)) ^ (r28 << 12)) ^ (r9 << 18);
        if (r30 > 1114111) goto L201;
        if (55296 > r30) goto L206;
        if (r30 >= 57344) goto L206;
        boolean r31 = true;
    L207:
        if (r31 == true) goto L208;
        if (r30 < 65536) goto L212;
        r12 = r5 + 1;
        if (r5 == 64) goto L248;
        if (r30 == 10) goto L237;
        if (r30 == 13) goto L237;
        if (r30 >= 0) goto L221;
    L223:
        boolean r32 = false;
    L224:
        if (r32 == false) goto L226;
    L234:
        boolean r33 = true;
    L235:
        if (r33 == true) goto L246;
    L226:
        if (127 <= r30) goto L228;
    L230:
        boolean r34 = false;
    L231:
        if (r34 == true) goto L234;
        r33 = false;
        goto L235
    L228:
        if (r30 >= 160) goto L230;
        r34 = true;
        goto L231
    L221:
        if (r30 >= 32) goto L223;
        r32 = true;
    L237:
        if (r30 == 65533) goto L246;
        if (r30 >= 65536) goto L242;
        int r117 = 1;
    L243:
        r6 = r6 + r117;
        Unit r35 = Unit.INSTANCE;
        r4 = r4 + 4;
        goto L111
    L242:
        r117 = 2;
        goto L243
    L212:
        if (r5 != 64) goto L246;
    L208:
        if (r5 != 64) goto L246;
    L206:
        r31 = false;
        goto L207
    L201:
        if (r5 != 64) goto L246;
    L197:
        if (r5 != 64) goto L246;
    L195:
        r116 = false;
        goto L196
    L190:
        if (r5 != 64) goto L246;
    L188:
        r115 = false;
        goto L189
    L183:
        if (r5 != 64) goto L246;
    L181:
        r113 = false;
        goto L182
    L176:
        if (r5 != 64) goto L246;
    L244:
        if (r5 != 64) goto L246;
    L14:
        int r118 = r5 + 1;
        if (r5 == 64) goto L248;
        if (r9 == 10) goto L33;
        if (r9 == 13) goto L33;
        if (r9 < 0) goto L22;
        if (r9 >= 32) goto L22;
        boolean r36 = true;
    L23:
        if (r36 == true) goto L31;
        if (127 > r9) goto L27;
        if (r9 >= 160) goto L27;
        boolean r37 = true;
    L28:
        if (r37 == true) goto L31;
        boolean r38 = false;
    L32:
        if (r38 == true) goto L246;
    L27:
        r37 = false;
    L31:
        r38 = true;
    L22:
        r36 = false;
    L33:
        if (r9 == 65533) goto L246;
        if (r9 >= 65536) goto L37;
        int r39 = 1;
    L38:
        r6 = r6 + r39;
        r4 = r4 + 1;
    L39:
        r5 = r118;
        if (r4 >= r3) goto L11;
        byte r40 = r2[r4];
        if (r40 < 0) goto L11;
        r4 = r4 + 1;
        r118 = r5 + 1;
        if (r5 == 64) goto L248;
        if (r40 == 10) goto L62;
        if (r40 == 13) goto L62;
        if (r40 < 0) goto L51;
        if (r40 >= 32) goto L51;
        boolean r41 = true;
    L52:
        if (r41 == true) goto L60;
        if (127 > r40) goto L56;
        if (r40 >= 160) goto L56;
        boolean r42 = true;
    L57:
        if (r42 == true) goto L60;
        boolean r43 = false;
    L61:
        if (r43 == true) goto L246;
    L56:
        r42 = false;
    L60:
        r43 = true;
    L51:
        r41 = false;
    L62:
        if (r40 == 65533) goto L246;
        if (r40 >= 65536) goto L66;
        int r44 = 1;
    L67:
        r6 = r6 + r44;
        goto L39
    L66:
        r44 = 2;
        goto L67
    L37:
        r39 = 2;
    L248:
        if (r6 == (-1)) goto L250;
        String r45 = utf8();
        String r46 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r45.substring(0, r6), "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r6 >= r45.length()) goto L275;
        return "[size=" + getData$okio().length + " text=" + r46 + "…]";
    L275:
        return "[text=" + r46 + ']';
    L250:
        if (getData$okio().length > 64) goto L252;
        r1 = "[hex=" + hex() + ']';
        goto L316
    L252:
        StringBuilder r47 = new StringBuilder("[size=");
        r47.append(getData$okio().length);
        r47.append(" hex=");
        int r48 = b.c(this, 64);
        if (r48 > getData$okio().length) goto L255;
        boolean r49 = true;
    L256:
        if (r49 == false) goto L270;
        if ((r48 + 0) < 0) goto L260;
        boolean r119 = true;
    L261:
        if (r119 == false) goto L268;
        if (r48 != getData$okio().length) goto L265;
        ByteString r50 = this;
    L266:
        r47.append(r50.hex());
        r47.append("…]");
        return r47.toString();
    L265:
        r50 = new ByteString(ArraysKt.copyOfRange(getData$okio(), 0, r48));
        goto L266
    L268:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L260:
        r119 = false;
        goto L261
    L270:
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    L255:
        r49 = false;
        goto L256
    L5:
        r0 = false;
        goto L6
    }

    public String utf8() {
        String r0 = getUtf8$okio();
        if (r0 != null) goto L6;
        byte[] r1 = internalArray$okio();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = new String(r1, Charsets.UTF_8);
        setUtf8$okio(r2);
        return r2;
    L6:
        return r0;
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public ByteString(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.data = r2;
    }

    @JvmStatic
    public static final ByteString decodeHex(String r6) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int r1 = 0;
        if ((r6.length() % 2) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        int r2 = r6.length() / 2;
        byte[] r3 = new byte[r2];
    L8:
        if (r1 >= r2) goto L11;
        int r4 = r1 * 2;
        r3[r1] = (byte) ((okio.internal.b.a(r6.charAt(r4)) << 4) + okio.internal.b.a(r6.charAt(r4 + 1)));
        r1 = r1 + 1;
        goto L8
    L11:
        return new ByteString(r3);
    L13:
        throw new IllegalArgumentException("Unexpected hex string: ".concat(r6).toString());
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final ByteString of(ByteBuffer r1) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        byte[] r0 = new byte[r1.remaining()];
        r1.get(r0);
        return new ByteString(r0);
    }

    private final void readObject(ObjectInputStream r3) throws IOException {
        int r0 = r3.readInt();
        Companion.getClass();
        ByteString r4 = a.f(r3, r0);
        Field r1 = ByteString.class.getDeclaredField("data");
        r1.setAccessible(true);
        r1.set(this, r4.data);
    }

    private final void writeObject(ObjectOutputStream r2) throws IOException {
        r2.writeInt(this.data.length);
        r2.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m540deprecated_getByte(int r1) {
        return getByte(r1);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        int r0 = size();
        int r1 = r10.size();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L10;
        int r7 = getByte(r4) & UByte.MAX_VALUE;
        int r8 = r10.getByte(r4) & UByte.MAX_VALUE;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 < r8) goto L13;
    L14:
        return 1;
    L13:
        return -1;
    L10:
        if (r0 == r1) goto L19;
        if (r0 >= r1) goto L14;
    L19:
        return 0;
    }

    public ByteString digest$okio(String r4) {
        Intrinsics.checkNotNullParameter(r4, "algorithm");
        MessageDigest r5 = MessageDigest.getInstance(r4);
        r5.update(this.data, 0, size());
        byte[] r6 = r5.digest();
        Intrinsics.checkNotNull(r6);
        return new ByteString(r6);
    }

    public final boolean endsWith(ByteString r4) {
        Intrinsics.checkNotNullParameter(r4, "suffix");
        return rangeEquals(size() - r4.size(), r4, 0, r4.size());
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L12;
        ByteString r6 = (ByteString) r5;
        if (r6.size() != getData$okio().length) goto L12;
        if (r6.rangeEquals(0, getData$okio(), 0, getData$okio().length) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final byte getByte(int r1) {
        return internalGet$okio(r1);
    }

    public ByteString hmacSha1(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac$okio("HmacSHA1", r2);
    }

    public ByteString hmacSha256(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac$okio("HmacSHA256", r2);
    }

    public ByteString hmacSha512(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac$okio("HmacSHA512", r2);
    }

    public byte internalGet$okio(int r2) {
        return getData$okio()[r2];
    }

    public final void setHashCode$okio(int r1) {
        this.hashCode = r1;
    }

    public final void setUtf8$okio(String r1) {
        this.utf8 = r1;
    }

    public final boolean startsWith(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "prefix");
        return rangeEquals(0, r3, 0, r3.size());
    }

    public String string(Charset r3) {
        Intrinsics.checkNotNullParameter(r3, "charset");
        return new String(this.data, r3);
    }

    public void write(OutputStream r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.write(this.data);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ByteString r1) {
        return compareTo2(r1);
    }

    public final boolean endsWith(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "suffix");
        return rangeEquals(size() - r4.length, r4, 0, r4.length);
    }

    public final boolean startsWith(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "prefix");
        return rangeEquals(0, r3, 0, r3.length);
    }

    @JvmStatic
    public static final ByteString encodeString(String r1, Charset r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new ByteString(r1.getBytes(r2));
    }

    public ByteString hmac$okio(String r3, ByteString r4) {
        Intrinsics.checkNotNullParameter(r3, "algorithm");
        Intrinsics.checkNotNullParameter(r4, "key");
        Mac r0 = Mac.getInstance(r3);     // Catch: InvalidKeyException -> L5
        r0.init(new SecretKeySpec(r4.toByteArray(), r3));     // Catch: InvalidKeyException -> L5
        return new ByteString(r0.doFinal(this.data));
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public int indexOf(byte[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        int r0 = getData$okio().length - r5.length;
        int r7 = Math.max(r6, 0);
        if (r7 <= r0) goto L5;
    L9:
        return -1;
    L5:
        if (b.a(getData$okio(), r7, r5, 0, r5.length) == true) goto L13;
        if (r7 == r0) goto L9;
        r7 = r7 + 1;
        goto L5
    L13:
        return r7;
    }

    public int lastIndexOf(byte[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        int r6 = Math.min(b.c(this, r5), getData$okio().length - r4.length);
    L4:
        if ((-1) >= r6) goto L9;
        if (b.a(getData$okio(), r6, r4, 0, r4.length) == true) goto L13;
        r6 = r6 - 1;
        goto L4
    L13:
        return r6;
    L9:
        return -1;
    }

    public ByteString substring(int r4, int r5) {
        int r6 = b.c(this, r5);
        boolean r0 = true;
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L28;
        if (r6 > getData$okio().length) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L26;
        if ((r6 - r4) >= 0) goto L16;
        r0 = false;
    L16:
        if (r0 == false) goto L24;
        if (r4 != 0) goto L22;
        if (r6 != getData$okio().length) goto L22;
        return this;
    L22:
        return new ByteString(ArraysKt.copyOfRange(getData$okio(), r4, r6));
    L24:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L26:
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    L10:
        r3 = false;
        goto L11
    L28:
        throw new IllegalArgumentException("beginIndex < 0".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final int indexOf(ByteString r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        return indexOf(r2.internalArray$okio(), r3);
    }

    public final int lastIndexOf(ByteString r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        return lastIndexOf(r2.internalArray$okio(), r3);
    }

    public void write$okio(Buffer r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "buffer");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "buffer");
        r3.write(getData$okio(), r4, r5);
    }

    public void copyInto(int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "target");
        ArraysKt.copyInto(getData$okio(), r3, r4, r2, r5 + r2);
    }

    public boolean rangeEquals(int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        if (r2 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r2 > (getData$okio().length - r5)) goto L12;
        if (r4 < 0) goto L12;
        if (r4 > (r3.length - r5)) goto L12;
        if (b.a(getData$okio(), r2, r3, r4, r5) == false) goto L12;
        return true;
    }

    public boolean rangeEquals(int r2, ByteString r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        return r3.rangeEquals(r4, getData$okio(), r2, r5);
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

    public static /* synthetic */ int lastIndexOf$default(ByteString r0, ByteString r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        Buffer.a r5 = b.a;
        r2 = -1234567890;
    L7:
        return r0.lastIndexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ ByteString substring$default(ByteString r0, int r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L7;
        r1 = 0;
    L7:
        if ((r3 & 2) == 0) goto L10;
        Buffer.a r5 = b.a;
        r2 = -1234567890;
    L10:
        return r0.substring(r1, r2);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
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

    public static /* synthetic */ int lastIndexOf$default(ByteString r0, byte[] r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        Buffer.a r5 = b.a;
        r2 = -1234567890;
    L7:
        return r0.lastIndexOf(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ void copyInto$default(ByteString r1, int r2, byte[] r3, int r4, int r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        r1.copyInto(r2, r3, r4, r5);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }
}
