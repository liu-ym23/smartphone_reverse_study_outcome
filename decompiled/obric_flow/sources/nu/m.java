package nu;

import ai.j0;
import java.io.EOFException;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static ByteString a(String r17) {
        Intrinsics.checkNotNullParameter(r17, "$this$decodeBase64");
        byte[] r5 = a.f20312a;
        Intrinsics.checkNotNullParameter(r17, "$this$decodeBase64ToArray");
        int r10 = r17.length();
    L4:
        if (r10 <= 0) goto L13;
        char r11 = r17.charAt(r10 - 1);
        if (r11 == '=') goto L12;
        if (r11 == '\n') goto L12;
        if (r11 == '\r') goto L12;
        if (r11 == ' ') goto L12;
        if (r11 != '\t') goto L13;
    L12:
        r10 = r10 - 1;
    L13:
        int r12 = (int) ((((long) r10) * 6) / 8);
        byte[] r13 = new byte[r12];
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r18 = 0;
    L15:
        if (r14 >= r10) goto L59;
        char r19 = r17.charAt(r14);
        if ('A' > r19) goto L23;
        if ('Z' < r19) goto L23;
        int r20 = r19 - 'A';
    L53:
        int r21 = r20 | (r16 << 6);
        r15 = r15 + 1;
        if ((r15 % 4) != 0) goto L56;
        r13[r18] = (byte) (r21 >> 16);
        int r110 = r18 + 2;
        r13[r18 + 1] = (byte) (r21 >> 8);
        r18 = r18 + 3;
        r13[r110] = (byte) r21;
    L56:
        r16 = r21;
    L58:
        r14 = r14 + 1;
    L23:
        if ('a' > r19) goto L29;
        if ('z' < r19) goto L29;
        r20 = r19 - 'G';
    L29:
        if ('0' > r19) goto L35;
        if ('9' < r19) goto L35;
        r20 = r19 + 4;
    L35:
        if (r19 != '+') goto L37;
    L52:
        r20 = 62;
        goto L53
    L37:
        if (r19 == '-') goto L52;
        if (r19 != '/') goto L42;
    L51:
        r20 = 63;
        goto L53
    L42:
        if (r19 == '_') goto L51;
        if (r19 == '\n') goto L58;
        if (r19 == '\r') goto L58;
        if (r19 == ' ') goto L58;
        if (r19 == '\t') goto L58;
    L49:
        r13 = null;
    L70:
        if (r13 != null) goto L72;
        return null;
    L72:
        return new ByteString(r13);
    L59:
        int r111 = r15 % 4;
        if (r111 == 1) goto L49;
        if (r111 == 2) goto L66;
        if (r111 != 3) goto L67;
        int r22 = r16 << 6;
        int r23 = 1 + r18;
        r13[r18] = (byte) (r22 >> 16);
        r18 = r18 + 2;
        r13[r23] = (byte) (r22 >> 8);
    L67:
        if (r18 == r12) goto L70;
        r13 = Arrays.copyOf(r13, r18);
        goto L70
    L66:
        r13[r18] = (byte) ((r16 << 12) >> 16);
        r18 = 1 + r18;
        goto L67
    }

    public static ByteString b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$decodeHex");
        if ((r5.length() % 2) != 0) goto L10;
        int r10 = r5.length() / 2;
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L8;
        int r13 = r12 * 2;
        int r14 = ou.b.a(r5.charAt(r13)) << 4;
        r11[r12] = (byte) (ou.b.a(r5.charAt(r13 + 1)) + r14);
        r12 = r12 + 1;
        goto L5
    L8:
        return new ByteString(r11);
    L10:
        throw new IllegalArgumentException("Unexpected hex string: ".concat(r5).toString());
    }

    public static ByteString c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$encodeUtf8");
        Intrinsics.checkNotNullParameter(r5, "$this$asUtf8ToByteArray");
        ByteString r10 = new ByteString(r5.getBytes(Charsets.UTF_8));
        r10.setUtf8$okio(r5);
        return r10;
    }

    public static ByteString d(m r10, byte[] r11) {
        int r5 = r11.length;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "$this$toByteString");
        f4.a.d(r11.length, 0, r5);
        return new ByteString(ArraysKt.copyOfRange(r11, 0, r5));
    }

    public static ByteString e(InputStream r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$readByteString");
        if (r10 < 0) goto L14;
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L12;
        int r13 = r5.read(r11, r12, r10 - r12);
        if (r13 == (-1)) goto L10;
        r12 = r12 + r13;
        goto L5
    L10:
        throw new EOFException();
    L12:
        return new ByteString(r11);
    L14:
        throw new IllegalArgumentException(j0.g(r10, "byteCount < 0: ").toString());
    }
}
