package okio;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
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
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import nu.a;
import nu.j;
import nu.m;
import ou.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 t2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001uB\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007H\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\tJ\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\tJ\u000f\u0010\"\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\"\u0010\u0010J\u000f\u0010#\u001a\u00020\u0000H\u0016¢\u0006\u0004\b#\u0010\u0010J#\u0010'\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$H\u0017¢\u0006\u0004\b'\u0010(J\u0017\u0010-\u001a\u00020*2\u0006\u0010)\u001a\u00020$H\u0010¢\u0006\u0004\b+\u0010,J\u0018\u00100\u001a\u00020*2\u0006\u0010.\u001a\u00020$H\u0087\u0002¢\u0006\u0004\b/\u0010,J\u000f\u00103\u001a\u00020$H\u0010¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u00020\u0003H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u00020\u0003H\u0010¢\u0006\u0004\b6\u00105J\u000f\u00109\u001a\u000208H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b>\u0010?J'\u0010>\u001a\u00020=2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$H\u0010¢\u0006\u0004\bD\u0010EJ/\u0010I\u001a\u00020H2\u0006\u0010B\u001a\u00020$2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020$2\u0006\u0010C\u001a\u00020$H\u0016¢\u0006\u0004\bI\u0010JJ/\u0010I\u001a\u00020H2\u0006\u0010B\u001a\u00020$2\u0006\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020$2\u0006\u0010C\u001a\u00020$H\u0016¢\u0006\u0004\bI\u0010KJ\u0015\u0010M\u001a\u00020H2\u0006\u0010L\u001a\u00020\u0000¢\u0006\u0004\bM\u0010NJ\u0015\u0010M\u001a\u00020H2\u0006\u0010L\u001a\u00020\u0003¢\u0006\u0004\bM\u0010OJ\u0015\u0010Q\u001a\u00020H2\u0006\u0010P\u001a\u00020\u0000¢\u0006\u0004\bQ\u0010NJ\u0015\u0010Q\u001a\u00020H2\u0006\u0010P\u001a\u00020\u0003¢\u0006\u0004\bQ\u0010OJ!\u0010S\u001a\u00020$2\u0006\u0010F\u001a\u00020\u00002\b\b\u0002\u0010R\u001a\u00020$H\u0007¢\u0006\u0004\bS\u0010TJ!\u0010S\u001a\u00020$2\u0006\u0010F\u001a\u00020\u00032\b\b\u0002\u0010R\u001a\u00020$H\u0017¢\u0006\u0004\bS\u0010UJ!\u0010V\u001a\u00020$2\u0006\u0010F\u001a\u00020\u00002\b\b\u0002\u0010R\u001a\u00020$H\u0007¢\u0006\u0004\bV\u0010TJ!\u0010V\u001a\u00020$2\u0006\u0010F\u001a\u00020\u00032\b\b\u0002\u0010R\u001a\u00020$H\u0017¢\u0006\u0004\bV\u0010UJ\u001a\u0010X\u001a\u00020H2\b\u0010F\u001a\u0004\u0018\u00010WH\u0096\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020$H\u0016¢\u0006\u0004\bZ\u00102J\u0018\u0010[\u001a\u00020$2\u0006\u0010F\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0007H\u0016¢\u0006\u0004\b]\u0010\tJ\u0017\u0010/\u001a\u00020*2\u0006\u0010.\u001a\u00020$H\u0007¢\u0006\u0004\b^\u0010,J\u000f\u0010`\u001a\u00020$H\u0007¢\u0006\u0004\b_\u00102J\u0017\u0010c\u001a\u00020=2\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010f\u001a\u00020=2\u0006\u0010<\u001a\u00020eH\u0002¢\u0006\u0004\bf\u0010gR\"\u0010Z\u001a\u00020$8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u00102\"\u0004\bk\u0010lR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010\t\"\u0004\bp\u0010qR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010r\u001a\u0004\bs\u00105R\u0011\u0010`\u001a\u00020$8G¢\u0006\u0006\u001a\u0004\b`\u00102¨\u0006v"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "", "data", "<init>", "([B)V", "", "utf8", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "md5", "()Lokio/ByteString;", "sha1", "sha256", "sha512", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", STGroup.DICT_KEY, "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", OpenPageMethod.KEY_POS, "", "internalGet$okio", "(I)B", "internalGet", "index", "getByte", "get", "getSize$okio", "()I", "getSize", "toByteArray", "()[B", "internalArray$okio", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "", "write", "(Ljava/io/OutputStream;)V", "Lnu/j;", "buffer", "offset", "byteCount", "write$okio", "(Lnu/j;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "prefix", "startsWith", "(Lokio/ByteString;)Z", "([B)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "compareTo", "(Lokio/ByteString;)I", "toString", "-deprecated_getByte", "-deprecated_size", "size", "Ljava/io/ObjectInputStream;", "in", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "a", "I", "getHashCode$okio", "setHashCode$okio", "(I)V", "b", "Ljava/lang/String;", "getUtf8$okio", "setUtf8$okio", "(Ljava/lang/String;)V", "[B", "getData$okio", "Companion", "nu/m", "okio"}, k = 1, mv = {1, 4, 0})
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final m Companion = null;

    @JvmField
    public static final ByteString EMPTY = null;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f20770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f20771b;
    private final byte[] data;

    static {
        Companion = new m();
        EMPTY = new ByteString(new byte[0]);
    }

    public ByteString(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.data = r5;
    }

    @JvmStatic
    public static final ByteString decodeBase64(String r5) {
        Companion.getClass();
        return m.a(r5);
    }

    @JvmStatic
    public static final ByteString decodeHex(String r5) {
        Companion.getClass();
        return m.b(r5);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    public static final ByteString encodeString(String r5, Charset r10) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$encode");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new ByteString(r5.getBytes(r10));
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String r5) {
        Companion.getClass();
        return m.c(r5);
    }

    public static /* synthetic */ int indexOf$default(ByteString r5, ByteString r10, int r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = 0;
    L7:
        return r5.indexOf(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r5, ByteString r10, int r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = r5.size();
    L7:
        return r5.lastIndexOf(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @JvmName(name = "of")
    public static final ByteString of(ByteBuffer r5) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$toByteString");
        byte[] r10 = new byte[r5.remaining()];
        r5.get(r10);
        return new ByteString(r10);
    }

    @JvmStatic
    @JvmName(name = "read")
    public static final ByteString read(InputStream r5, int r10) throws IOException {
        Companion.getClass();
        return m.e(r5, r10);
    }

    private final void readObject(ObjectInputStream r5) throws IOException {
        int r10 = r5.readInt();
        Companion.getClass();
        ByteString r11 = m.e(r5, r10);
        Field r12 = ByteString.class.getDeclaredField("data");
        r12.setAccessible(true);
        r12.set(this, r11.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString r5, int r10, int r11, int r12, Object r13) {
        if (r13 != null) goto L12;
        if ((r12 & 1) == 0) goto L7;
        r10 = 0;
    L7:
        if ((r12 & 2) == 0) goto L10;
        r11 = r5.size();
    L10:
        return r5.substring(r10, r11);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream r5) throws IOException {
        r5.writeInt(this.data.length);
        r5.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m1644deprecated_getByte(int r5) {
        return getByte(r5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m1645deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public String base64() {
        return a.a(getData$okio(), a.f20312a);
    }

    public String base64Url() {
        return a.a(getData$okio(), a.f20313b);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ByteString r5) {
        return compareTo2(r5);
    }

    public ByteString digest$okio(String r5) {
        Intrinsics.checkNotNullParameter(r5, "algorithm");
        return new ByteString(MessageDigest.getInstance(r5).digest(this.data));
    }

    public final boolean endsWith(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "suffix");
        return rangeEquals(size() - r5.size(), r5, 0, r5.size());
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == false) goto L13;
        ByteString r10 = (ByteString) r5;
        if (r10.size() != getData$okio().length) goto L13;
        if (r10.rangeEquals(0, getData$okio(), 0, getData$okio().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int r5) {
        return internalGet$okio(r5);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.f20770a;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.f20771b;
    }

    public int hashCode() {
        int r5 = getHashCode$okio();
        if (r5 != 0) goto L7;
        int r10 = Arrays.hashCode(getData$okio());
        setHashCode$okio(r10);
        return r10;
    L7:
        return r5;
    }

    public String hex() {
        char[] r5 = new char[getData$okio().length * 2];
        byte[] r10 = getData$okio();
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L6;
        byte r14 = r10[r12];
        int r15 = r13 + 1;
        char[] r16 = b.f21307a;
        r5[r13] = r16[(r14 >> 4) & 15];
        r13 = r13 + 2;
        r5[r15] = r16[r14 & 15];
        r12 = r12 + 1;
        goto L3
    L6:
        return new String(r5);
    }

    public ByteString hmac$okio(String r5, ByteString r10) {
        Intrinsics.checkNotNullParameter(r5, "algorithm");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Mac r11 = Mac.getInstance(r5);     // Catch: InvalidKeyException -> L5
        r11.init(new SecretKeySpec(r10.toByteArray(), r5));     // Catch: InvalidKeyException -> L5
        return new ByteString(r11.doFinal(this.data));
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public ByteString hmacSha1(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return hmac$okio("HmacSHA1", r5);
    }

    public ByteString hmacSha256(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return hmac$okio("HmacSHA256", r5);
    }

    public ByteString hmacSha512(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return hmac$okio("HmacSHA512", r5);
    }

    @JvmOverloads
    public final int indexOf(ByteString r5) {
        return indexOf$default(this, r5, 0, 2, null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int r5) {
        return getData$okio()[r5];
    }

    @JvmOverloads
    public final int lastIndexOf(ByteString r5) {
        return lastIndexOf$default(this, r5, 0, 2, null);
    }

    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int r5, ByteString r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return r10.rangeEquals(r11, getData$okio(), r5, r12);
    }

    public final void setHashCode$okio(int r5) {
        this.f20770a = r5;
    }

    public final void setUtf8$okio(String r5) {
        this.f20771b = r5;
    }

    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "prefix");
        return rangeEquals(0, r5, 0, r5.size());
    }

    public String string(Charset r5) {
        Intrinsics.checkNotNullParameter(r5, "charset");
        return new String(this.data, r5);
    }

    @JvmOverloads
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString toAsciiLowercase() {
        int r5 = 0;
    L4:
        if (r5 >= getData$okio().length) goto L30;
        byte r10 = getData$okio()[r5];
        byte r11 = (byte) 65;
        if (r10 < r11) goto L20;
        byte r12 = (byte) 90;
        if (r10 > r12) goto L20;
        byte[] r13 = getData$okio();
        byte[] r14 = Arrays.copyOf(r13, r13.length);
        int r15 = r5 + 1;
        r14[r5] = (byte) (r10 + 32);
    L12:
        if (r15 >= r14.length) goto L21;
        byte r16 = r14[r15];
        if (r16 < r11) goto L18;
        if (r16 > r12) goto L18;
        r14[r15] = (byte) (r16 + 32);
    L18:
        r15 = r15 + 1;
        goto L12
    L21:
        return new ByteString(r14);
    L20:
        r5 = r5 + 1;
        goto L4
    L30:
        return this;
    }

    public ByteString toAsciiUppercase() {
        int r5 = 0;
    L4:
        if (r5 >= getData$okio().length) goto L30;
        byte r10 = getData$okio()[r5];
        byte r11 = (byte) 97;
        if (r10 < r11) goto L20;
        byte r12 = (byte) 122;
        if (r10 > r12) goto L20;
        byte[] r13 = getData$okio();
        byte[] r14 = Arrays.copyOf(r13, r13.length);
        int r15 = r5 + 1;
        r14[r5] = (byte) (r10 - 32);
    L12:
        if (r15 >= r14.length) goto L21;
        byte r16 = r14[r15];
        if (r16 < r11) goto L18;
        if (r16 > r12) goto L18;
        r14[r15] = (byte) (r16 - 32);
    L18:
        r15 = r15 + 1;
        goto L12
    L21:
        return new ByteString(r14);
    L20:
        r5 = r5 + 1;
        goto L4
    L30:
        return this;
    }

    public byte[] toByteArray() {
        byte[] r5 = getData$okio();
        return Arrays.copyOf(r5, r5.length);
    }

    public String toString() {
        if (getData$okio().length != 0) goto L5;
        return "[size=0]";
    L5:
        byte[] r5 = getData$okio();
        int r10 = r5.length;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r11 >= r10) goto L182;
        byte r14 = r5[r11];
        if (r14 >= 0) goto L10;
        if ((r14 >> 5) != (-2)) goto L83;
        int r15 = r11 + 1;
        if (r10 <= r15) goto L52;
        byte r16 = r5[r15];
        if ((r16 & 192) != 128) goto L80;
        int r17 = (r16 ^ ByteCompanionObject.MIN_VALUE) ^ (r14 << 6);
        if (r17 < 128) goto L58;
        int r18 = r13 + 1;
        if (r13 == 64) goto L182;
        if (r17 == 10) goto L72;
        if (r17 == 13) goto L72;
        if (r17 < 0) goto L67;
        if (31 < r17) goto L67;
    L22:
        r12 = -1;
    L67:
        if (127 > r17) goto L72;
        if (159 >= r17) goto L22;
    L72:
        if (r17 == 65533) goto L22;
        if (r17 >= 65536) goto L77;
        int r19 = 1;
    L78:
        r12 = r12 + r19;
        Unit r20 = Unit.INSTANCE;
        r11 = r11 + 2;
    L79:
        r13 = r18;
        goto L7
    L77:
        r19 = 2;
        goto L78
    L58:
        if (r13 != 64) goto L22;
    L80:
        if (r13 != 64) goto L22;
    L52:
        if (r13 != 64) goto L22;
    L83:
        if ((r14 >> 4) != (-2)) goto L128;
        int r21 = r11 + 2;
        if (r10 <= r21) goto L86;
        byte r22 = r5[r11 + 1];
        if ((r22 & 192) != 128) goto L125;
        byte r23 = r5[r21];
        if ((r23 & 192) != 128) goto L123;
        int r24 = ((r22 << 6) ^ (r23 ^ ByteCompanionObject.MIN_VALUE)) ^ (r14 << 12);
        if (r24 < 2048) goto L94;
        if (55296 > r24) goto L101;
        if (57343 < r24) goto L101;
        if (r13 != 64) goto L22;
    L101:
        r18 = r13 + 1;
        if (r13 == 64) goto L182;
        if (r24 == 10) goto L116;
        if (r24 == 13) goto L116;
        if (r24 < 0) goto L110;
        if (31 >= r24) goto L22;
    L110:
        if (127 > r24) goto L116;
        if (159 >= r24) goto L22;
    L116:
        if (r24 == 65533) goto L22;
        if (r24 >= 65536) goto L121;
        int r25 = 1;
    L122:
        r12 = r12 + r25;
        Unit r26 = Unit.INSTANCE;
        r11 = r11 + 3;
        goto L79
    L121:
        r25 = 2;
        goto L122
    L94:
        if (r13 != 64) goto L22;
    L123:
        if (r13 != 64) goto L22;
    L125:
        if (r13 != 64) goto L22;
    L86:
        if (r13 != 64) goto L22;
    L128:
        if ((r14 >> 3) != (-2)) goto L180;
        int r27 = r11 + 3;
        if (r10 <= r27) goto L131;
        byte r28 = r5[r11 + 1];
        if ((r28 & 192) != 128) goto L178;
        byte r110 = r5[r11 + 2];
        if ((r110 & 192) != 128) goto L176;
        byte r29 = r5[r27];
        if ((r29 & 192) != 128) goto L174;
        int r30 = (((r29 ^ ByteCompanionObject.MIN_VALUE) ^ (r110 << 6)) ^ (r28 << 12)) ^ (r14 << 18);
        if (r30 > 1114111) goto L141;
        if (55296 > r30) goto L148;
        if (57343 < r30) goto L148;
        if (r13 != 64) goto L22;
    L148:
        if (r30 < 65536) goto L149;
        r18 = r13 + 1;
        if (r13 == 64) goto L182;
        if (r30 == 10) goto L167;
        if (r30 == 13) goto L167;
        if (r30 < 0) goto L161;
        if (31 >= r30) goto L22;
    L161:
        if (127 > r30) goto L167;
        if (159 >= r30) goto L22;
    L167:
        if (r30 == 65533) goto L22;
        if (r30 >= 65536) goto L172;
        int r31 = 1;
    L173:
        r12 = r12 + r31;
        Unit r32 = Unit.INSTANCE;
        r11 = r11 + 4;
        goto L79
    L172:
        r31 = 2;
        goto L173
    L149:
        if (r13 != 64) goto L22;
    L141:
        if (r13 != 64) goto L22;
    L174:
        if (r13 != 64) goto L22;
    L176:
        if (r13 != 64) goto L22;
    L178:
        if (r13 != 64) goto L22;
    L131:
        if (r13 != 64) goto L22;
    L180:
        if (r13 != 64) goto L22;
    L10:
        int r111 = r13 + 1;
        if (r13 == 64) goto L182;
        if (r14 == 10) goto L21;
        if (r14 == 13) goto L21;
        if (r14 < 0) goto L17;
        if (31 >= r14) goto L22;
    L17:
        if (127 > r14) goto L21;
        if (159 >= r14) goto L22;
    L21:
        if (r14 == 65533) goto L22;
        if (r14 >= 65536) goto L25;
        int r33 = 1;
    L26:
        r12 = r12 + r33;
        r11 = r11 + 1;
    L27:
        r13 = r111;
        if (r11 >= r10) goto L7;
        byte r112 = r5[r11];
        if (r112 < 0) goto L7;
        r11 = r11 + 1;
        r111 = r13 + 1;
        if (r13 == 64) goto L182;
        if (r112 == 10) goto L42;
        if (r112 == 13) goto L42;
        if (r112 < 0) goto L38;
        if (31 >= r112) goto L22;
    L38:
        if (127 > r112) goto L42;
        if (159 >= r112) goto L22;
    L42:
        if (r112 == 65533) goto L22;
        if (r112 >= 65536) goto L46;
        int r34 = 1;
    L47:
        r12 = r12 + r34;
        goto L27
    L46:
        r34 = 2;
        goto L47
    L25:
        r33 = 2;
    L182:
        if (r12 == (-1)) goto L184;
        String r35 = utf8();
        if (r35 == null) goto L203;
        String r36 = StringsKt.F(StringsKt.F(StringsKt.F(r35.substring(0, r12), "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
        if (r12 >= r35.length()) goto L201;
        return "[size=" + getData$okio().length + " text=" + r36 + "…]";
    L201:
        return androidx.room.jarjarred.org.antlr.runtime.a.p("[text=", ']', r36);
    L203:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L184:
        if (getData$okio().length <= 64) goto L250;
        StringBuilder r37 = new StringBuilder("[size=");
        r37.append(getData$okio().length);
        r37.append(" hex=");
        if (64 > getData$okio().length) goto L194;
        if (64 != getData$okio().length) goto L191;
        ByteString r38 = this;
    L192:
        r37.append(r38.hex());
        r37.append("…]");
        return r37.toString();
    L191:
        r38 = new ByteString(ArraysKt.copyOfRange(getData$okio(), 0, 64));
        goto L192
    L194:
        throw new IllegalArgumentException(j0.n(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
    L250:
        return "[hex=" + hex() + ']';
    }

    public String utf8() {
        String r5 = getUtf8$okio();
        if (r5 != null) goto L6;
        byte[] r10 = internalArray$okio();
        Intrinsics.checkNotNullParameter(r10, "$this$toUtf8String");
        String r11 = new String(r10, Charsets.UTF_8);
        setUtf8$okio(r11);
        return r11;
    L6:
        return r5;
    }

    public void write(OutputStream r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.write(this.data);
    }

    public void write$okio(j r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "buffer");
        Intrinsics.checkNotNullParameter(this, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(r5, "buffer");
        r5.S(getData$okio(), r10, r11);
    }

    public static /* synthetic */ int indexOf$default(ByteString r5, byte[] r10, int r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = 0;
    L7:
        return r5.indexOf(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r5, byte[] r10, int r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = r5.size();
    L7:
        return r5.lastIndexOf(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r5 = size();
        int r11 = r10.size();
        int r12 = Math.min(r5, r11);
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L11;
        int r14 = getByte(r13) & UByte.MAX_VALUE;
        int r15 = r10.getByte(r13) & UByte.MAX_VALUE;
        if (r14 != r15) goto L8;
        r13 = r13 + 1;
        goto L4
    L8:
        if (r14 >= r15) goto L18;
    L15:
        return -1;
    L18:
        return 1;
    L11:
        if (r5 == r11) goto L19;
        if (r5 >= r11) goto L18;
    L19:
        return 0;
    }

    public final boolean endsWith(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "suffix");
        return rangeEquals(size() - r5.length, r5, 0, r5.length);
    }

    @JvmOverloads
    public final int indexOf(byte[] r5) {
        return indexOf$default(this, r5, 0, 2, null);
    }

    @JvmOverloads
    public final int lastIndexOf(byte[] r5) {
        return lastIndexOf$default(this, r5, 0, 2, null);
    }

    public boolean rangeEquals(int r5, byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (r5 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r5 > (getData$okio().length - r12)) goto L12;
        if (r11 < 0) goto L12;
        if (r11 > (r10.length - r12)) goto L12;
        if (f4.a.c(getData$okio(), r10, r5, r11, r12) == false) goto L12;
        return true;
    }

    public final boolean startsWith(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "prefix");
        return rangeEquals(0, r5, 0, r5.length);
    }

    @JvmOverloads
    public final ByteString substring(int r5) {
        return substring$default(this, r5, 0, 2, null);
    }

    @JvmOverloads
    public final int indexOf(ByteString r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return indexOf(r5.internalArray$okio(), r10);
    }

    @JvmOverloads
    public final int lastIndexOf(ByteString r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return lastIndexOf(r5.internalArray$okio(), r10);
    }

    @JvmOverloads
    public ByteString substring(int r5, int r10) {
        boolean r11 = false;
        if (r5 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L27;
        if (r10 > getData$okio().length) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L25;
        if ((r10 - r5) < 0) goto L15;
        r11 = true;
    L15:
        if (r11 == false) goto L23;
        if (r5 != 0) goto L21;
        if (r10 != getData$okio().length) goto L21;
        return this;
    L21:
        return new ByteString(ArraysKt.copyOfRange(getData$okio(), r5, r10));
    L23:
        throw new IllegalArgumentException("endIndex < beginIndex");
    L25:
        throw new IllegalArgumentException(j0.n(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
    L10:
        r13 = false;
        goto L11
    L27:
        throw new IllegalArgumentException("beginIndex < 0");
    L5:
        r12 = false;
        goto L6
    }

    @JvmOverloads
    public int indexOf(byte[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        int r11 = getData$okio().length - r5.length;
        int r12 = Math.max(r10, 0);
        if (r12 <= r11) goto L5;
    L9:
        return -1;
    L5:
        if (f4.a.c(getData$okio(), r5, r12, 0, r5.length) == true) goto L13;
        if (r12 == r11) goto L9;
        r12 = r12 + 1;
        goto L5
    L13:
        return r12;
    }

    @JvmOverloads
    public int lastIndexOf(byte[] r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        int r11 = Math.min(r10, getData$okio().length - r5.length);
    L3:
        if (r11 < 0) goto L8;
        if (f4.a.c(getData$okio(), r5, r11, 0, r5.length) == true) goto L12;
        r11 = r11 - 1;
        goto L3
    L12:
        return r11;
    L8:
        return -1;
    }

    @JvmStatic
    public static final ByteString of(byte... r5) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        return new ByteString(Arrays.copyOf(r5, r5.length));
    }

    @JvmStatic
    @JvmName(name = "of")
    public static final ByteString of(byte[] r10, int r11, int r12) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "$this$toByteString");
        f4.a.d(r10.length, r11, r12);
        return new ByteString(ArraysKt.copyOfRange(r10, r11, r12 + r11));
    }
}
