package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0007*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\n"}, d2 = {"BASE64", "", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "jvm"}, k = 2, mv = {1, 1, 11})
public final class Base64 {
    private static final byte[] BASE64 = null;
    private static final byte[] BASE64_URL_SAFE = null;

    static {
        BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$jvm();
        BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$jvm();
    }

    public static final byte[] decodeBase64ToArray(String r16) {
        Intrinsics.checkParameterIsNotNull(r16, "$receiver");
        int r1 = r16.length();
    L4:
        if (r1 <= 0) goto L13;
        char r6 = r16.charAt(r1 - 1);
        if (r6 == '=') goto L12;
        if (r6 == '\n') goto L12;
        if (r6 == '\r') goto L12;
        if (r6 == ' ') goto L12;
        if (r6 != '\t') goto L13;
    L12:
        r1 = r1 - 1;
    L13:
        int r7 = (int) ((((long) r1) * 6) / 8);
        byte[] r8 = new byte[r7];
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L15:
        if (r9 >= r1) goto L53;
        char r14 = r16.charAt(r9);
        if ('A' > r14) goto L22;
        if ('Z' < r14) goto L22;
        int r15 = r14 - 'A';
    L49:
        r11 = (r11 << 6) | r15;
        r10 = r10 + 1;
        if ((r10 % 4) != 0) goto L52;
        int r13 = r12 + 1;
        r8[r12] = (byte) (r11 >> 16);
        int r17 = r13 + 1;
        r8[r13] = (byte) (r11 >> 8);
        r8[r17] = (byte) r11;
        r12 = r17 + 1;
    L52:
        r9 = r9 + 1;
    L22:
        if ('a' > r14) goto L27;
        if ('z' < r14) goto L27;
        r15 = r14 - 'G';
    L27:
        if ('0' > r14) goto L32;
        if ('9' < r14) goto L32;
        r15 = r14 + 4;
    L32:
        if (r14 != '+') goto L34;
    L48:
        r15 = 62;
        goto L49
    L34:
        if (r14 == '-') goto L48;
        if (r14 != '/') goto L39;
    L47:
        r15 = 63;
        goto L49
    L39:
        if (r14 == '_') goto L47;
        if (r14 == '\n') goto L52;
        if (r14 == '\r') goto L52;
        if (r14 == ' ') goto L52;
        if (r14 == '\t') goto L52;
        return null;
    L53:
        int r18 = r10 % 4;
        if (r18 != 1) goto L56;
        return null;
    L56:
        if (r18 != 2) goto L58;
        r8[r12] = (byte) ((r11 << 12) >> 16);
        r12 = r12 + 1;
    L62:
        if (r12 != r7) goto L64;
        return r8;
    L64:
        byte[] r0 = new byte[r12];
        Platform.arraycopy(r8, 0, r0, 0, r12);
        return r0;
    L58:
        if (r18 != 3) goto L62;
        int r2 = r11 << 6;
        int r3 = r12 + 1;
        r8[r12] = (byte) (r2 >> 16);
        r12 = r3 + 1;
        r8[r3] = (byte) (r2 >> 8);
        goto L62
    }

    public static final String encodeBase64(byte[] r10, byte[] r11) {
        Intrinsics.checkParameterIsNotNull(r10, "$receiver");
        Intrinsics.checkParameterIsNotNull(r11, "map");
        byte[] r0 = new byte[((r10.length + 2) / 3) * 4];
        int r2 = r10.length - (r10.length % 3);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int r5 = r3 + 1;
        byte r6 = r10[r3];
        int r7 = r5 + 1;
        byte r8 = r10[r5];
        int r9 = r7 + 1;
        byte r12 = r10[r7];
        int r13 = r4 + 1;
        r0[r4] = r11[(r6 & 255) >> 2];
        int r14 = r13 + 1;
        r0[r13] = r11[((r6 & 3) << 4) | ((r8 & 255) >> 4)];
        int r15 = r14 + 1;
        r0[r14] = r11[((r8 & 15) << 2) | ((r12 & 255) >> 6)];
        r4 = r15 + 1;
        r0[r15] = r11[r12 & Utf8.REPLACEMENT_BYTE];
        r3 = r9;
        goto L3
    L5:
        int r16 = r10.length - r2;
        if (r16 == 1) goto L10;
        if (r16 != 2) goto L12;
        int r17 = r3 + 1;
        byte r18 = r10[r3];
        byte r19 = r10[r17];
        int r20 = r4 + 1;
        r0[r4] = r11[(r18 & 255) >> 2];
        int r21 = r20 + 1;
        r0[r20] = r11[((r18 & 3) << 4) | ((r19 & 255) >> 4)];
        r0[r21] = r11[(r19 & 15) << 2];
        r0[r21 + 1] = (byte) 61;
    L12:
        return Platform.toUtf8String(r0);
    L10:
        byte r110 = r10[r3];
        int r22 = r4 + 1;
        r0[r4] = r11[(r110 & 255) >> 2];
        int r1 = r22 + 1;
        r0[r22] = r11[(r110 & 3) << 4];
        byte r111 = (byte) 61;
        r0[r1] = r111;
        r0[r1 + 1] = r111;
        goto L12
    }

    public static /* synthetic */ String encodeBase64$default(byte[] r0, byte[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = BASE64;
    L6:
        return encodeBase64(r0, r1);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
