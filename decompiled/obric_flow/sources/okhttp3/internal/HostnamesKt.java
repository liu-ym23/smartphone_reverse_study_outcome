package okhttp3.internal;

import androidx.room.jarjarred.org.antlr.runtime.a;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nu.j;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000f"}, d2 = {"decodeIpv4Suffix", "", "input", "", OpenPageMethod.KEY_POS, "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String r10) {
        int r5 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L14;
        char r12 = r10.charAt(r11);
        if (Intrinsics.compare(r12, 31) <= 0) goto L13;
        if (Intrinsics.compare(r12, 127) >= 0) goto L13;
        if (StringsKt.q(" #%/:?@[\\]", r12, 0, 6) != (-1)) goto L11;
        r11 = r11 + 1;
        goto L3
    L11:
        return true;
    L13:
        return true;
    L14:
        return false;
    }

    private static final boolean decodeIpv4Suffix(String r10, int r11, int r12, byte[] r13, int r14) {
        int r5 = r14;
    L4:
        if (r11 >= r12) goto L32;
        if (r5 == r13.length) goto L7;
        if (r5 != r14) goto L10;
    L13:
        int r15 = r11;
        int r16 = 0;
    L14:
        if (r15 >= r12) goto L28;
        char r17 = r10.charAt(r15);
        if (Intrinsics.compare(r17, 48) < 0) goto L28;
        if (Intrinsics.compare(r17, 57) > 0) goto L28;
        if (r16 != 0) goto L23;
        if (r11 == r15) goto L23;
        return false;
    L23:
        r16 = ((r16 * 10) + r17) - 48;
        if (r16 > 255) goto L25;
        r15 = r15 + 1;
        goto L14
    L25:
        return false;
    L28:
        if ((r15 - r11) == 0) goto L29;
        r13[r5] = (byte) r16;
        r5 = r5 + 1;
        r11 = r15;
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
        if (r5 != (r14 + 4)) goto L44;
        return true;
    L44:
        return false;
    }

    private static final InetAddress decodeIpv6(String r11, int r12, int r13) {
        byte[] r5 = new byte[16];
        int r10 = 0;
        int r14 = -1;
        int r15 = -1;
    L4:
        if (r12 >= r13) goto L42;
        if (r10 == 16) goto L6;
        int r16 = r12 + 2;
        if (r16 <= r13) goto L10;
    L17:
        if (r10 != 0) goto L19;
    L21:
        r15 = r12;
    L29:
        int r17 = 0;
        r12 = r15;
    L30:
        if (r12 >= r13) goto L35;
        int r18 = Util.parseHexDigit(r11.charAt(r12));
        if (r18 == (-1)) goto L35;
        r17 = (r17 << 4) + r18;
        r12 = r12 + 1;
    L35:
        int r19 = r12 - r15;
        if (r19 == 0) goto L41;
        if (r19 > 4) goto L41;
        int r20 = r10 + 1;
        r5[r10] = (byte) ((r17 >>> 8) & 255);
        r10 = r10 + 2;
        r5[r20] = (byte) (r17 & 255);
    L41:
        return null;
    L19:
        if (StringsKt.N(r12, r11, ":") == false) goto L23;
        r12 = r12 + 1;
        goto L21
    L23:
        if (StringsKt.N(r12, r11, ".") == true) goto L25;
        return null;
    L25:
        if (decodeIpv4Suffix(r11, r15, r13, r5, r10 - 2) == true) goto L27;
        return null;
    L27:
        r10 = r10 + 2;
        goto L42
    L10:
        if (StringsKt.N(r12, r11, "::") == false) goto L17;
        if (r14 != (-1)) goto L12;
        r10 = r10 + 2;
        r14 = r10;
        if (r16 == r13) goto L42;
        r15 = r16;
        goto L29
    L12:
        return null;
    L6:
        return null;
    L42:
        if (r10 == 16) goto L47;
        if (r14 != (-1)) goto L45;
        return null;
    L45:
        int r110 = r10 - r14;
        System.arraycopy(r5, r14, r5, 16 - r110, r110);
        Arrays.fill(r5, r14, (16 - r10) + r14, (byte) 0);
    L47:
        return InetAddress.getByAddress(r5);
    }

    private static final String inet6AddressToAscii(byte[] r10) {
        int r5 = -1;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10.length) goto L18;
        int r14 = r12;
    L6:
        if (r14 >= 16) goto L12;
        if (r10[r14] != 0) goto L12;
        if (r10[r14 + 1] != 0) goto L12;
        r14 = r14 + 2;
    L12:
        int r15 = r14 - r12;
        if (r15 <= r13) goto L17;
        if (r15 < 4) goto L17;
        r5 = r12;
        r13 = r15;
    L17:
        r12 = r14 + 2;
        goto L4
    L18:
        j r16 = new j();
    L20:
        if (r11 >= r10.length) goto L30;
        if (r11 == r5) goto L23;
        if (r11 <= 0) goto L28;
        r16.T(58);
    L28:
        r16.V((Util.and(r10[r11], 255) << 8) | Util.and(r10[r11 + 1], 255));
        r11 = r11 + 2;
        goto L20
    L23:
        r16.T(58);
        r11 = r11 + r13;
        if (r11 != 16) goto L20;
        r16.T(58);
        goto L20
    L30:
        return r16.M();
    }

    public static final String toCanonicalHost(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toCanonicalHost");
        if (StringsKt.g(r5, ":") == true) goto L5;
        String r10 = IDN.toASCII(r5);     // Catch: IllegalArgumentException -> L34
        Locale r11 = Locale.US;     // Catch: IllegalArgumentException -> L34
        if (r10 == null) goto L33;
        String r12 = r10.toLowerCase(r11);     // Catch: IllegalArgumentException -> L34
        if (r12.length() != 0) goto L28;
        return null;
    L28:
        if (containsInvalidHostnameAsciiCodes(r12) == false) goto L31;
        return null;
    L31:
        return r12;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: IllegalArgumentException -> L34
    L34:
        return null;
    L5:
        if (StringsKt.P(r5, "[") == true) goto L7;
    L9:
        InetAddress r13 = decodeIpv6(r5, 0, r5.length());
    L10:
        if (r13 == null) goto L21;
        byte[] r14 = r13.getAddress();
        if (r14.length != 16) goto L16;
        return inet6AddressToAscii(r14);
    L16:
        if (r14.length != 4) goto L20;
        return r13.getHostAddress();
    L20:
        throw new AssertionError(a.p("Invalid IPv6 address: '", '\'', r5));
    L21:
        return null;
    L7:
        if (StringsKt.k(r5, "]") == false) goto L9;
        r13 = decodeIpv6(r5, 1, r5.length() - 1);
        goto L10
    }
}
