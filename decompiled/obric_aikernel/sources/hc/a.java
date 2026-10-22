package hc;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final boolean a(String r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        char r13 = r10.charAt(r12);
        if (Intrinsics.compare(r13, 31) <= 0) goto L13;
        if (Intrinsics.compare(r13, 127) >= 0) goto L13;
        if (StringsKt.indexOf$default(" #%/:?@[\\]", r13, 0, false, 6, null) != (-1)) goto L11;
        r12 = r12 + 1;
        goto L3
    L11:
        return true;
    L13:
        return true;
    L14:
        return false;
    }

    private static final boolean b(String r10, int r11, int r12, byte[] r13, int r14) {
        int r15 = r14;
    L4:
        if (r11 >= r12) goto L32;
        if (r15 == r13.length) goto L7;
        if (r15 != r14) goto L10;
    L13:
        int r16 = r11;
        int r17 = 0;
    L14:
        if (r16 >= r12) goto L28;
        char r18 = r10.charAt(r16);
        if (Intrinsics.compare(r18, 48) < 0) goto L28;
        if (Intrinsics.compare(r18, 57) > 0) goto L28;
        if (r17 != 0) goto L23;
        if (r11 == r16) goto L23;
        return false;
    L23:
        r17 = ((r17 * 10) + r18) - 48;
        if (r17 > 255) goto L25;
        r16 = r16 + 1;
        goto L14
    L25:
        return false;
    L28:
        if ((r16 - r11) == 0) goto L29;
        r13[r15] = (byte) r17;
        r15 = r15 + 1;
        r11 = r16;
        goto L4
    L29:
        return false;
    L10:
        if (r10.charAt(r11) != '.') goto L11;
        r11 = r11 + 1;
        goto L13
    L11:
        return false;
    L7:
        return false;
    L32:
        if (r15 != (r14 + 4)) goto L44;
        return true;
    L44:
        return false;
    }

    private static final InetAddress c(String r18, int r19, int r20) {
        byte[] r10 = new byte[16];
        int r12 = r19;
        int r14 = -1;
        int r15 = -1;
        int r13 = 0;
    L4:
        if (r12 >= r20) goto L41;
        if (r13 == 16) goto L6;
        int r11 = r12 + 2;
        if (r11 <= r20) goto L10;
    L17:
        if (r13 != 0) goto L19;
    L28:
        r15 = r12;
    L29:
        r12 = r15;
        int r16 = 0;
    L30:
        if (r12 >= r20) goto L34;
        int r17 = e.H(r18.charAt(r12));
        if (r17 == (-1)) goto L34;
        r16 = (r16 << 4) + r17;
        r12 = r12 + 1;
    L34:
        int r21 = r12 - r15;
        if (r21 == 0) goto L40;
        if (r21 > 4) goto L40;
        int r22 = r13 + 1;
        r10[r13] = (byte) ((r16 >>> 8) & 255);
        r13 = r22 + 1;
        r10[r22] = (byte) (r16 & 255);
    L40:
        return null;
    L19:
        if (StringsKt.startsWith$default(r18, ":", r12, false, 4, null) == false) goto L22;
        r12 = r12 + 1;
        goto L28
    L22:
        if (StringsKt.startsWith$default(r18, ".", r12, false, 4, null) == true) goto L24;
        return null;
    L24:
        if (b(r18, r15, r20, r10, r13 - 2) == true) goto L26;
        return null;
    L26:
        r13 = r13 + 2;
        goto L41
    L10:
        if (StringsKt.startsWith$default(r18, "::", r12, false, 4, null) == false) goto L17;
        if (r14 != (-1)) goto L12;
        r13 = r13 + 2;
        if (r11 == r20) goto L15;
        r15 = r11;
        r14 = r13;
        goto L29
    L15:
        r14 = r13;
        goto L41
    L12:
        return null;
    L6:
        return null;
    L41:
        if (r13 == 16) goto L46;
        if (r14 != (-1)) goto L44;
        return null;
    L44:
        int r23 = r13 - r14;
        System.arraycopy(r10, r14, r10, 16 - r23, r23);
        Arrays.fill(r10, r14, (16 - r13) + r14, (byte) 0);
    L46:
        return InetAddress.getByAddress(r10);
    }

    private static final String d(byte[] r10) {
        int r11 = 0;
        int r12 = -1;
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length) goto L18;
        int r15 = r13;
    L6:
        if (r15 >= 16) goto L12;
        if (r10[r15] != 0) goto L12;
        if (r10[r15 + 1] != 0) goto L12;
        r15 = r15 + 2;
    L12:
        int r16 = r15 - r13;
        if (r16 <= r14) goto L17;
        if (r16 < 4) goto L17;
        r12 = r13;
        r14 = r16;
    L17:
        r13 = r15 + 2;
        goto L4
    L18:
        okio.d r17 = new okio.d();
    L20:
        if (r11 >= r10.length) goto L30;
        if (r11 == r12) goto L23;
        if (r11 <= 0) goto L28;
        r17.c0(58);
    L28:
        r17.e0((e.d(r10[r11], 255) << 8) | e.d(r10[r11 + 1], 255));
        r11 = r11 + 2;
        goto L20
    L23:
        r17.c0(58);
        r11 = r11 + r14;
        if (r11 != 16) goto L20;
        r17.c0(58);
        goto L20
    L30:
        return r17.J();
    }

    public static final String e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        boolean r11 = false;
        if (StringsKt.contains$default(r10, ":", false, 2, null) == true) goto L5;
        String r12 = IDN.toASCII(r10);     // Catch: IllegalArgumentException -> L32
        Intrinsics.checkNotNullExpressionValue(r12, "toASCII(host)");     // Catch: IllegalArgumentException -> L32
        Locale r13 = Locale.US;     // Catch: IllegalArgumentException -> L32
        Intrinsics.checkNotNullExpressionValue(r13, "US");     // Catch: IllegalArgumentException -> L32
        String r14 = r12.toLowerCase(r13);     // Catch: IllegalArgumentException -> L32
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: IllegalArgumentException -> L32
        if (r14.length() != 0) goto L25;
        r11 = true;
    L25:
        if (r11 == false) goto L27;
        return null;
    L27:
        if (a(r14) == false) goto L31;
        return null;
    L31:
        return r14;
    L36:
        return null;
    L5:
        if (StringsKt.startsWith$default(r10, "[", false, 2, null) == true) goto L7;
    L9:
        InetAddress r15 = c(r10, 0, r10.length());
    L10:
        if (r15 != null) goto L12;
        return null;
    L12:
        byte[] r16 = r15.getAddress();
        if (r16.length != 16) goto L17;
        Intrinsics.checkNotNullExpressionValue(r16, "address");
        return d(r16);
    L17:
        if (r16.length != 4) goto L21;
        return r15.getHostAddress();
    L21:
        throw new AssertionError("Invalid IPv6 address: '" + r10 + '\'');
    L7:
        if (StringsKt.endsWith$default(r10, "]", false, 2, null) == false) goto L9;
        r15 = c(r10, 1, r10.length() - 1);
        goto L10
    }
}
