package okio;

import java.util.Arrays;
import kotlin.io.encoding.Base64;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "-Base64")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f12164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f12165b = null;

    static {
        ByteString.a r10 = ByteString.Companion;
        f12164a = r10.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        f12165b = r10.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] a(String r16) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        int r10 = r16.length();
    L4:
        if (r10 <= 0) goto L13;
        char r11 = r16.charAt(r10 - 1);
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
        int r17 = 0;
        int r18 = 0;
    L14:
        boolean r19 = true;
        if (r14 >= r10) goto L62;
        char r110 = r16.charAt(r14);
        if ('A' <= r110) goto L19;
    L21:
        boolean r20 = false;
    L22:
        if (r20 == false) goto L25;
        int r111 = r110 - 'A';
    L58:
        r17 = (r17 << 6) | r111;
        r15 = r15 + 1;
        if ((r15 % 4) != 0) goto L61;
        int r21 = r18 + 1;
        r13[r18] = (byte) (r17 >> 16);
        int r112 = r21 + 1;
        r13[r21] = (byte) (r17 >> 8);
        r13[r112] = (byte) r17;
        r18 = r112 + 1;
    L61:
        r14 = r14 + 1;
        goto L14
    L25:
        if ('a' <= r110) goto L27;
    L29:
        boolean r22 = false;
    L30:
        if (r22 == false) goto L33;
        r111 = r110 - 'G';
        goto L58
    L33:
        if ('0' <= r110) goto L35;
    L37:
        r19 = false;
    L38:
        if (r19 == false) goto L41;
        r111 = r110 + 4;
        goto L58
    L41:
        if (r110 != '+') goto L43;
    L57:
        r111 = 62;
        goto L58
    L43:
        if (r110 == '-') goto L57;
        if (r110 != '/') goto L48;
    L56:
        r111 = 63;
        goto L58
    L48:
        if (r110 == '_') goto L56;
        if (r110 == '\n') goto L61;
        if (r110 == '\r') goto L61;
        if (r110 == ' ') goto L61;
        if (r110 == '\t') goto L61;
        return null;
    L35:
        if (r110 >= ':') goto L37;
    L27:
        if (r110 >= '{') goto L29;
        r22 = true;
        goto L30
    L19:
        if (r110 >= '[') goto L21;
        r20 = true;
        goto L22
    L62:
        int r113 = r15 % 4;
        if (r113 != 1) goto L65;
        return null;
    L65:
        if (r113 != 2) goto L67;
        r13[r18] = (byte) ((r17 << 12) >> 16);
        r18 = r18 + 1;
    L71:
        if (r18 != r12) goto L73;
        return r13;
    L73:
        byte[] r23 = Arrays.copyOf(r13, r18);
        Intrinsics.checkNotNullExpressionValue(r23, "copyOf(this, newSize)");
        return r23;
    L67:
        if (r113 != 3) goto L71;
        int r24 = r17 << 6;
        int r25 = r18 + 1;
        r13[r18] = (byte) (r24 >> 16);
        r18 = r25 + 1;
        r13[r25] = (byte) (r24 >> 8);
        goto L71
    }

    public static final String b(byte[] r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "map");
        byte[] r12 = new byte[((r10.length + 2) / 3) * 4];
        int r13 = r10.length - (r10.length % 3);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        int r16 = r14 + 1;
        byte r17 = r10[r14];
        int r18 = r16 + 1;
        byte r19 = r10[r16];
        int r20 = r18 + 1;
        byte r21 = r10[r18];
        int r22 = r15 + 1;
        r12[r15] = r11[(r17 & 255) >> 2];
        int r23 = r22 + 1;
        r12[r22] = r11[((r17 & 3) << 4) | ((r19 & 255) >> 4)];
        int r24 = r23 + 1;
        r12[r23] = r11[((r19 & 15) << 2) | ((r21 & 255) >> 6)];
        r15 = r24 + 1;
        r12[r24] = r11[r21 & 63];
        r14 = r20;
        goto L3
    L5:
        int r25 = r10.length - r13;
        if (r25 == 1) goto L10;
        if (r25 != 2) goto L12;
        int r26 = r14 + 1;
        byte r27 = r10[r14];
        byte r110 = r10[r26];
        int r28 = r15 + 1;
        r12[r15] = r11[(r27 & 255) >> 2];
        int r29 = r28 + 1;
        r12[r28] = r11[((r27 & 3) << 4) | ((r110 & 255) >> 4)];
        r12[r29] = r11[(r110 & 15) << 2];
        r12[r29 + 1] = Base64.padSymbol;
    L12:
        return j0.c(r12);
    L10:
        byte r111 = r10[r14];
        int r30 = r15 + 1;
        r12[r15] = r11[(r111 & 255) >> 2];
        int r31 = r30 + 1;
        r12[r30] = r11[(r111 & 3) << 4];
        r12[r31] = Base64.padSymbol;
        r12[r31 + 1] = Base64.padSymbol;
        goto L12
    }

    public static /* synthetic */ String c(byte[] r10, byte[] r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = f12164a;
    L6:
        return b(r10, r11);
    }

    public static final byte[] d() {
        return f12165b;
    }
}
