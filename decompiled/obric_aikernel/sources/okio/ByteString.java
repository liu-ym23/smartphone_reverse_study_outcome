package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crypto.utils.CryptoConst;
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
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 Util.kt\nokio/-SegmentedByteString\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n43#2,7:365\n53#2:372\n56#2:373\n64#2,4:374\n68#2:379\n70#2:381\n76#2,23:382\n104#2,23:405\n131#2,2:428\n133#2,9:431\n145#2:440\n148#2:441\n151#2:442\n154#2:443\n162#2:444\n172#2,3:445\n171#2:448\n185#2,2:449\n190#2:451\n194#2:452\n198#2:453\n202#2:454\n206#2,7:455\n219#2:462\n223#2,8:463\n235#2,4:471\n244#2,5:475\n253#2,6:480\n259#2,9:487\n322#2,8:496\n131#2,2:504\n133#2,9:507\n333#2,9:516\n68#3:378\n74#3:380\n74#3:486\n1#4:430\n1#4:506\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString\n*L\n66#1:365,7\n71#1:372\n108#1:373\n110#1:374,4\n110#1:379\n110#1:381\n112#1:382,23\n114#1:405,23\n118#1:428,2\n118#1:431,9\n120#1:440\n129#1:441\n131#1:442\n133#1:443\n152#1:444\n159#1:445,3\n159#1:448\n166#1:449,2\n168#1:451\n170#1:452\n172#1:453\n174#1:454\n180#1:455,7\n183#1:462\n186#1:463,8\n188#1:471,4\n190#1:475,5\n192#1:480,6\n192#1:487,9\n194#1:496,8\n194#1:504,2\n194#1:507,9\n194#1:516,9\n110#1:378\n110#1:380\n192#1:486\n118#1:430\n194#1:506\n*E\n"})
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final a Companion = null;

    @JvmField
    public static final ByteString EMPTY = null;
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    @SourceDebugExtension({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString$Companion\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n271#2:365\n275#2,3:366\n282#2,3:369\n289#2,2:372\n295#2:374\n297#2,7:376\n1#3:375\n1#3:383\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString$Companion\n*L\n234#1:365\n239#1:366,3\n251#1:369,3\n259#1:372,2\n262#1:374\n262#1:376,7\n262#1:375\n*E\n"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ ByteString h(a r10, byte[] r11, int r12, int r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r12 = 0;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r13 = b.c();
        L9:
            return r10.g(r11, r12, r13);
        }

        @JvmStatic
        public final ByteString a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            byte[] r11 = okio.a.a(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return new ByteString(r11);
        }

        @JvmStatic
        public final ByteString b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            int r11 = 0;
            if ((r10.length() % 2) != 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L13;
            int r13 = r10.length() / 2;
            byte[] r14 = new byte[r13];
        L8:
            if (r11 >= r13) goto L11;
            int r15 = r11 * 2;
            r14[r11] = (byte) ((okio.internal.b.b(r10.charAt(r15)) << 4) + okio.internal.b.b(r10.charAt(r15 + 1)));
            r11 = r11 + 1;
            goto L8
        L11:
            return new ByteString(r14);
        L13:
            throw new IllegalArgumentException(("Unexpected hex string: " + r10).toString());
        L5:
            r12 = false;
            goto L6
        }

        @JvmStatic
        @JvmName(name = "encodeString")
        public final ByteString c(String r10, Charset r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "charset");
            byte[] r12 = r10.getBytes(r11);
            Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).getBytes(charset)");
            return new ByteString(r12);
        }

        @JvmStatic
        public final ByteString d(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            ByteString r11 = new ByteString(j0.a(r10));
            r11.setUtf8$okio(r10);
            return r11;
        }

        @JvmStatic
        @JvmName(name = "of")
        public final ByteString e(ByteBuffer r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            byte[] r11 = new byte[r10.remaining()];
            r10.get(r11);
            return new ByteString(r11);
        }

        @JvmStatic
        public final ByteString f(byte... r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            byte[] r11 = Arrays.copyOf(r10, r10.length);
            Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
            return new ByteString(r11);
        }

        @JvmStatic
        @JvmName(name = "of")
        public final ByteString g(byte[] r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            int r13 = b.e(r10, r12);
            b.b(r10.length, r11, r13);
            return new ByteString(ArraysKt.copyOfRange(r10, r11, r13 + r11));
        }

        @JvmStatic
        @JvmName(name = "read")
        public final ByteString i(InputStream r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            int r12 = 0;
            if (r11 < 0) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L17;
            byte[] r14 = new byte[r11];
        L8:
            if (r12 >= r11) goto L15;
            int r15 = r10.read(r14, r12, r11 - r12);
            if (r15 == (-1)) goto L13;
            r12 = r12 + r15;
            goto L8
        L13:
            throw new EOFException();
        L15:
            return new ByteString(r14);
        L17:
            throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
        L5:
            r13 = false;
            goto L6
        }
    }

    static {
        Companion = new a(null);
        EMPTY = new ByteString(new byte[0]);
    }

    public ByteString(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.data = r10;
    }

    public static /* synthetic */ void copyInto$default(ByteString r10, int r11, byte[] r12, int r13, int r14, int r15, Object r16) {
        if (r16 != null) goto L12;
        if ((r15 & 1) == 0) goto L7;
        r11 = 0;
    L7:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        r10.copyInto(r11, r12, r13, r14);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }

    @JvmStatic
    public static final ByteString decodeBase64(String r10) {
        return Companion.a(r10);
    }

    @JvmStatic
    public static final ByteString decodeHex(String r10) {
        return Companion.b(r10);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    public static final ByteString encodeString(String r10, Charset r11) {
        return Companion.c(r10, r11);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String r10) {
        return Companion.d(r10);
    }

    public static /* synthetic */ int indexOf$default(ByteString r10, ByteString r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        return r10.indexOf(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int indexOf$default(ByteString r10, byte[] r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        return r10.indexOf(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r10, ByteString r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = b.c();
    L7:
        return r10.lastIndexOf(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString r10, byte[] r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = b.c();
    L7:
        return r10.lastIndexOf(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @JvmName(name = "of")
    public static final ByteString of(ByteBuffer r10) {
        return Companion.e(r10);
    }

    @JvmStatic
    public static final ByteString of(byte... r10) {
        return Companion.f(r10);
    }

    @JvmStatic
    @JvmName(name = "of")
    public static final ByteString of(byte[] r10, int r11, int r12) {
        return Companion.g(r10, r11, r12);
    }

    @JvmStatic
    @JvmName(name = "read")
    public static final ByteString read(InputStream r10, int r11) {
        return Companion.i(r10, r11);
    }

    private final void readObject(ObjectInputStream r10) {
        int r11 = r10.readInt();
        ByteString r12 = Companion.i(r10, r11);
        Field r13 = ByteString.class.getDeclaredField("data");
        r13.setAccessible(true);
        r13.set(this, r12.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 1) == 0) goto L7;
        r11 = 0;
    L7:
        if ((r13 & 2) == 0) goto L10;
        r12 = b.c();
    L10:
        return r10.substring(r11, r12);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream r10) {
        r10.writeInt(this.data.length);
        r10.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m1551deprecated_getByte(int r10) {
        return getByte(r10);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m1552deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer r10 = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(r10, "asReadOnlyBuffer(...)");
        return r10;
    }

    public String base64() {
        return okio.a.c(getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return okio.a.b(getData$okio(), okio.a.d());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ByteString r10) {
        return compareTo2(r10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = size();
        int r12 = r10.size();
        int r13 = Math.min(r11, r12);
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L10;
        int r15 = getByte(r14) & 255;
        int r16 = r10.getByte(r14) & 255;
        if (r15 != r16) goto L8;
        r14 = r14 + 1;
        goto L4
    L8:
        if (r15 < r16) goto L18;
    L15:
        return 1;
    L18:
        return -1;
    L10:
        if (r11 == r12) goto L19;
        if (r11 >= r12) goto L15;
    L19:
        return 0;
    }

    public void copyInto(int r10, byte[] r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        ArraysKt.copyInto(getData$okio(), r11, r12, r10, r13 + r10);
    }

    public ByteString digest$okio(String r10) {
        Intrinsics.checkNotNullParameter(r10, "algorithm");
        MessageDigest r11 = MessageDigest.getInstance(r10);
        r11.update(this.data, 0, size());
        byte[] r12 = r11.digest();
        Intrinsics.checkNotNull(r12);
        return new ByteString(r12);
    }

    public final boolean endsWith(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "suffix");
        return rangeEquals(size() - r10.size(), r10, 0, r10.size());
    }

    public final boolean endsWith(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "suffix");
        return rangeEquals(size() - r10.length, r10, 0, r10.length);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ByteString) == false) goto L13;
        ByteString r11 = (ByteString) r10;
        if (r11.size() != getData$okio().length) goto L13;
        if (r11.rangeEquals(0, getData$okio(), 0, getData$okio().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int r10) {
        return internalGet$okio(r10);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int r10 = getHashCode$okio();
        if (r10 != 0) goto L7;
        int r11 = Arrays.hashCode(getData$okio());
        setHashCode$okio(r11);
        return r11;
    L7:
        return r10;
    }

    public String hex() {
        char[] r10 = new char[getData$okio().length * 2];
        byte[] r11 = getData$okio();
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L6;
        byte r15 = r11[r13];
        int r16 = r14 + 1;
        r10[r14] = okio.internal.b.f()[(r15 >> 4) & 15];
        r14 = r16 + 1;
        r10[r16] = okio.internal.b.f()[r15 & 15];
        r13 = r13 + 1;
        goto L3
    L6:
        return StringsKt.concatToString(r10);
    }

    public ByteString hmac$okio(String r10, ByteString r11) {
        Intrinsics.checkNotNullParameter(r10, "algorithm");
        Intrinsics.checkNotNullParameter(r11, "key");
        Mac r12 = Mac.getInstance(r10);     // Catch: InvalidKeyException -> L5
        r12.init(new SecretKeySpec(r11.toByteArray(), r10));     // Catch: InvalidKeyException -> L5
        byte[] r13 = r12.doFinal(this.data);     // Catch: InvalidKeyException -> L5
        Intrinsics.checkNotNullExpressionValue(r13, "doFinal(...)");     // Catch: InvalidKeyException -> L5
        return new ByteString(r13);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public ByteString hmacSha1(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return hmac$okio("HmacSHA1", r10);
    }

    public ByteString hmacSha256(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return hmac$okio("HmacSHA256", r10);
    }

    public ByteString hmacSha512(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return hmac$okio("HmacSHA512", r10);
    }

    @JvmOverloads
    public final int indexOf(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return indexOf$default(this, r10, 0, 2, null);
    }

    @JvmOverloads
    public final int indexOf(ByteString r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return indexOf(r10.internalArray$okio(), r11);
    }

    @JvmOverloads
    public final int indexOf(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return indexOf$default(this, r10, 0, 2, null);
    }

    @JvmOverloads
    public int indexOf(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r12 = getData$okio().length - r10.length;
        int r13 = Math.max(r11, 0);
        if (r13 <= r12) goto L5;
    L9:
        return -1;
    L5:
        if (b.a(getData$okio(), r13, r10, 0, r10.length) == true) goto L13;
        if (r13 == r12) goto L9;
        r13 = r13 + 1;
        goto L5
    L13:
        return r13;
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int r10) {
        return getData$okio()[r10];
    }

    @JvmOverloads
    public final int lastIndexOf(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return lastIndexOf$default(this, r10, 0, 2, null);
    }

    @JvmOverloads
    public final int lastIndexOf(ByteString r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return lastIndexOf(r10.internalArray$okio(), r11);
    }

    @JvmOverloads
    public final int lastIndexOf(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return lastIndexOf$default(this, r10, 0, 2, null);
    }

    @JvmOverloads
    public int lastIndexOf(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r12 = Math.min(b.d(this, r11), getData$okio().length - r10.length);
    L4:
        if ((-1) >= r12) goto L10;
        if (b.a(getData$okio(), r12, r10, 0, r10.length) == true) goto L13;
        r12 = r12 - 1;
        goto L4
    L13:
        return r12;
    L10:
        return -1;
    }

    public final ByteString md5() {
        return digest$okio(CryptoConst.ALGORITHM_MD5);
    }

    public boolean rangeEquals(int r10, ByteString r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "other");
        return r11.rangeEquals(r12, getData$okio(), r10, r13);
    }

    public boolean rangeEquals(int r10, byte[] r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "other");
        if (r10 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r10 > (getData$okio().length - r13)) goto L12;
        if (r12 < 0) goto L12;
        if (r12 > (r11.length - r13)) goto L12;
        if (b.a(getData$okio(), r10, r11, r12, r13) == false) goto L12;
        return true;
    }

    public final void setHashCode$okio(int r10) {
        this.hashCode = r10;
    }

    public final void setUtf8$okio(String r10) {
        this.utf8 = r10;
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio(CryptoConst.ALGORITHM_SHA256);
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "prefix");
        return rangeEquals(0, r10, 0, r10.size());
    }

    public final boolean startsWith(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "prefix");
        return rangeEquals(0, r10, 0, r10.length);
    }

    public String string(Charset r10) {
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new String(this.data, r10);
    }

    @JvmOverloads
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @JvmOverloads
    public final ByteString substring(int r10) {
        return substring$default(this, r10, 0, 2, null);
    }

    @JvmOverloads
    public ByteString substring(int r10, int r11) {
        int r12 = b.d(this, r11);
        boolean r13 = true;
        if (r10 < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L28;
        if (r12 > getData$okio().length) goto L10;
        boolean r15 = true;
    L11:
        if (r15 == false) goto L26;
        if ((r12 - r10) >= 0) goto L16;
        r13 = false;
    L16:
        if (r13 == false) goto L24;
        if (r10 != 0) goto L22;
        if (r12 != getData$okio().length) goto L22;
        return this;
    L22:
        return new ByteString(ArraysKt.copyOfRange(getData$okio(), r10, r12));
    L24:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L26:
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    L10:
        r15 = false;
        goto L11
    L28:
        throw new IllegalArgumentException("beginIndex < 0".toString());
    L5:
        r14 = false;
        goto L6
    }

    public ByteString toAsciiLowercase() {
        int r10 = 0;
    L4:
        if (r10 >= getData$okio().length) goto L30;
        byte r11 = getData$okio()[r10];
        if (r11 < 65) goto L20;
        if (r11 > 90) goto L20;
        byte[] r12 = getData$okio();
        byte[] r13 = Arrays.copyOf(r12, r12.length);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, size)");
        int r14 = r10 + 1;
        r13[r10] = (byte) (r11 + 32);
    L12:
        if (r14 >= r13.length) goto L21;
        byte r15 = r13[r14];
        if (r15 < 65) goto L18;
        if (r15 > 90) goto L18;
        r13[r14] = (byte) (r15 + 32);
    L18:
        r14 = r14 + 1;
        goto L12
    L21:
        return new ByteString(r13);
    L20:
        r10 = r10 + 1;
        goto L4
    L30:
        return this;
    }

    public ByteString toAsciiUppercase() {
        int r10 = 0;
    L4:
        if (r10 >= getData$okio().length) goto L30;
        byte r11 = getData$okio()[r10];
        if (r11 < 97) goto L20;
        if (r11 > 122) goto L20;
        byte[] r12 = getData$okio();
        byte[] r13 = Arrays.copyOf(r12, r12.length);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, size)");
        int r14 = r10 + 1;
        r13[r10] = (byte) (r11 + MessagePack.Code.NEGFIXINT_PREFIX);
    L12:
        if (r14 >= r13.length) goto L21;
        byte r15 = r13[r14];
        if (r15 < 97) goto L18;
        if (r15 > 122) goto L18;
        r13[r14] = (byte) (r15 + MessagePack.Code.NEGFIXINT_PREFIX);
    L18:
        r14 = r14 + 1;
        goto L12
    L21:
        return new ByteString(r13);
    L20:
        r10 = r10 + 1;
        goto L4
    L30:
        return this;
    }

    public byte[] toByteArray() {
        byte[] r10 = getData$okio();
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    public String toString() {
        boolean r10 = true;
        if (getData$okio().length != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        return "[size=0]";
    L8:
        int r12 = okio.internal.b.a(getData$okio(), 64);
        if (r12 == (-1)) goto L11;
        String r13 = utf8();
        String r14 = r13.substring(0, r12);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        String r15 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r14, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r12 >= r13.length()) goto L38;
        StringBuilder r16 = new StringBuilder();
        r16.append("[size=");
        r16.append(getData$okio().length);
        r16.append(" text=");
        r16.append(r15);
    L30:
        r16.append("…]");
    L40:
        return r16.toString();
    L38:
        r16 = new StringBuilder();
        r16.append("[text=");
        r16.append(r15);
    L13:
        r16.append(']');
        goto L40
    L11:
        if (getData$okio().length > 64) goto L15;
        r16 = new StringBuilder();
        r16.append("[hex=");
        r16.append(hex());
        goto L13
    L15:
        r16 = new StringBuilder();
        r16.append("[size=");
        r16.append(getData$okio().length);
        r16.append(" hex=");
        int r17 = b.d(this, 64);
        if (r17 > getData$okio().length) goto L18;
        boolean r18 = true;
    L19:
        if (r18 == false) goto L34;
        if ((r17 + 0) >= 0) goto L24;
        r10 = false;
    L24:
        if (r10 == false) goto L32;
        if (r17 != getData$okio().length) goto L28;
        ByteString r19 = this;
    L29:
        r16.append(r19.hex());
        goto L30
    L28:
        r19 = new ByteString(ArraysKt.copyOfRange(getData$okio(), 0, r17));
        goto L29
    L32:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L34:
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    L18:
        r18 = false;
        goto L19
    L5:
        r11 = false;
        goto L6
    }

    public String utf8() {
        String r10 = getUtf8$okio();
        if (r10 != null) goto L6;
        String r11 = j0.c(internalArray$okio());
        setUtf8$okio(r11);
        return r11;
    L6:
        return r10;
    }

    public void write(OutputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "out");
        r10.write(this.data);
    }

    public void write$okio(d r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        okio.internal.b.d(this, r10, r11, r12);
    }
}
