package okhttp3.internal;

import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000f"}, d2 = {"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", MemoryKeyInfoEntity.KEY_ADDRESS, "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 1, 15})
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String r10) {
        int r0 = r10.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        char r4 = r10.charAt(r2);
        if (r4 <= 31) goto L13;
        if (r4 >= 127) goto L13;
        if (StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(" #%/:?@[\\]", CharSequence.class, "com.obric.memorydata.plugin"), r4, 0, false, 6, null) != (-1)) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    L13:
        return true;
    L14:
        return false;
    }

    private static final boolean decodeIpv4Suffix(String r7, int r8, int r9, byte[] r10, int r11) {
        int r0 = r11;
    L4:
        if (r8 >= r9) goto L32;
        if (r0 == r10.length) goto L7;
        if (r0 != r11) goto L10;
    L13:
        int r2 = r8;
        int r3 = 0;
    L14:
        if (r2 >= r9) goto L28;
        char r4 = r7.charAt(r2);
        if (r4 < '0') goto L28;
        if (r4 > '9') goto L28;
        if (r3 != 0) goto L23;
        if (r8 == r2) goto L23;
        return false;
    L23:
        r3 = ((r3 * 10) + r4) - 48;
        if (r3 > 255) goto L25;
        r2 = r2 + 1;
        goto L14
    L25:
        return false;
    L28:
        if ((r2 - r8) == 0) goto L29;
        r10[r0] = (byte) r3;
        r0 = r0 + 1;
        r8 = r2;
        goto L4
    L29:
        return false;
    L10:
        if (r7.charAt(r8) != '.') goto L11;
        r8 = r8 + 1;
        goto L13
    L11:
        return false;
    L7:
        return false;
    L32:
        if (r0 != (r11 + 4)) goto L44;
        return true;
    L44:
        return false;
    }

    private static final InetAddress decodeIpv6(String r18, int r19, int r20) {
        byte[] r9 = new byte[16];
        int r12 = r19;
        int r14 = -1;
        int r15 = -1;
        int r13 = 0;
    L4:
        if (r12 >= r20) goto L42;
        if (r13 == 16) goto L6;
        int r5 = r12 + 2;
        if (r5 <= r20) goto L10;
    L17:
        if (r13 != 0) goto L19;
    L28:
        r15 = r12;
    L29:
        r12 = r15;
        int r0 = 0;
    L30:
        if (r12 >= r20) goto L35;
        int r1 = Util.parseHexDigit(r18.charAt(r12));
        if (r1 == (-1)) goto L35;
        r0 = (r0 << 4) + r1;
        r12 = r12 + 1;
    L35:
        int r2 = r12 - r15;
        if (r2 == 0) goto L41;
        if (r2 > 4) goto L41;
        int r3 = r13 + 1;
        r9[r13] = (byte) ((r0 >>> 8) & 255);
        r13 = r3 + 1;
        r9[r3] = (byte) (r0 & 255);
    L41:
        return null;
    L19:
        if (StringsKt.startsWith$default(r18, ParameterizedMessage.ERROR_MSG_SEPARATOR, r12, false, 4, null) == false) goto L22;
        r12 = r12 + 1;
        goto L28
    L22:
        if (StringsKt.startsWith$default(r18, ".", r12, false, 4, null) == true) goto L24;
        return null;
    L24:
        if (decodeIpv4Suffix(r18, r15, r20, r9, r13 - 2) == true) goto L26;
        return null;
    L26:
        r13 = r13 + 2;
        goto L42
    L10:
        if (StringsKt.startsWith$default(r18, "::", r12, false, 4, null) == false) goto L17;
        if (r14 != (-1)) goto L12;
        r13 = r13 + 2;
        if (r5 == r20) goto L15;
        r15 = r5;
        r14 = r13;
        goto L29
    L15:
        r14 = r13;
        goto L42
    L12:
        return null;
    L6:
        return null;
    L42:
        if (r13 == 16) goto L47;
        if (r14 != (-1)) goto L45;
        return null;
    L45:
        int r4 = r13 - r14;
        System.arraycopy(r9, r14, r9, 16 - r4, r4);
        Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
    L47:
        return InetAddress.getByAddress(r9);
    }

    private static final String inet6AddressToAscii(byte[] r8) {
        int r0 = 0;
        int r1 = -1;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r8.length) goto L18;
        int r4 = r2;
    L6:
        if (r4 >= 16) goto L12;
        if (r8[r4] != 0) goto L12;
        if (r8[r4 + 1] != 0) goto L12;
        r4 = r4 + 2;
    L12:
        int r5 = r4 - r2;
        if (r5 <= r3) goto L17;
        if (r5 < 4) goto L17;
        r1 = r2;
        r3 = r5;
    L17:
        r2 = r4 + 2;
        goto L4
    L18:
        Buffer r6 = new Buffer();
    L20:
        if (r0 >= r8.length) goto L30;
        if (r0 == r1) goto L23;
        if (r0 <= 0) goto L28;
        r6.writeByte(58);
    L28:
        r6.writeHexadecimalUnsignedLong((Util.and(r8[r0], 255) << 8) | Util.and(r8[r0 + 1], 255));
        r0 = r0 + 2;
        goto L20
    L23:
        r6.writeByte(58);
        r0 = r0 + r3;
        if (r0 != 16) goto L20;
        r6.writeByte(58);
        goto L20
    L30:
        return r6.readUtf8();
    }

    public static final String toCanonicalHost(String r6) {
        Intrinsics.checkParameterIsNotNull(r6, "$this$toCanonicalHost");
        boolean r3 = false;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(ParameterizedMessage.ERROR_MSG_SEPARATOR, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L5;
        String r7 = IDN.toASCII(r6);     // Catch: IllegalArgumentException -> L36
        Intrinsics.checkExpressionValueIsNotNull(r7, "IDN.toASCII(host)");     // Catch: IllegalArgumentException -> L36
        Locale r0 = Locale.US;     // Catch: IllegalArgumentException -> L36
        Intrinsics.checkExpressionValueIsNotNull(r0, "Locale.US");     // Catch: IllegalArgumentException -> L36
        if (r7 == null) goto L35;
        String r8 = r7.toLowerCase(r0);     // Catch: IllegalArgumentException -> L36
        Intrinsics.checkExpressionValueIsNotNull(r8, "(this as java.lang.String).toLowerCase(locale)");     // Catch: IllegalArgumentException -> L36
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L27;
        r3 = true;
    L27:
        if (r3 == false) goto L30;
        return null;
    L30:
        if (containsInvalidHostnameAsciiCodes(r8) == false) goto L33;
        return null;
    L33:
        return r8;
    L35:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: IllegalArgumentException -> L36
    L36:
        return null;
    L5:
        if (StringsKt.startsWith$default(r6, "[", false, 2, null) == true) goto L7;
    L9:
        InetAddress r1 = decodeIpv6(r6, 0, r6.length());
    L10:
        if (r1 == null) goto L21;
        byte[] r2 = r1.getAddress();
        if (r2.length != 16) goto L16;
        Intrinsics.checkExpressionValueIsNotNull(r2, MemoryKeyInfoEntity.KEY_ADDRESS);
        return inet6AddressToAscii(r2);
    L16:
        if (r2.length != 4) goto L20;
        return r1.getHostAddress();
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("Invalid IPv6 address: '" + r6 + '\''), Throwable.class, "com.obric.memorydata.plugin"));
    L21:
        return null;
    L7:
        if (StringsKt.endsWith$default(r6, "]", false, 2, null) == false) goto L9;
        r1 = decodeIpv6(r6, 1, r6.length() - 1);
        goto L10
    }
}
