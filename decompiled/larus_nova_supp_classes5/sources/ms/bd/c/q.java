package ms.bd.c;

import java.util.Arrays;
import kotlin.KotlinVersion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class q {
    public static final String a = null;
    public static final String b = null;

    static {
        a = (String) p2.a(16777217, 0, 0, "4e3009", new byte[]{4, 69, 99, 96, 42, 8, 16, 108, 75, 74, 14, 75, 109, 106, 32, 30, 6, 118, 81, 84, 16, 81, 119, 124, 54, 20, 54, 70, 97, 100, 32, 97, 71, 76, 6, 36, 60, 72, 111, 110, 42, 119, 81, 86, 28, 58, 34, 82, 117, 120, 60, 125, 16, 21, 93, 125, 99, 17, 52, 55, 125, 62, 11, 11});
        b = (String) p2.a(16777217, 0, 0, "11f351", new byte[]{125});
    }

    public static String a(String r9) {
        if (r9 != null) goto L4;
        return r9;
    L4:
        if (r9.length() > 0) goto L7;
        return r9;
    L7:
        return r9.replaceAll((String) p2.a(16777217, 0, 0, "1986be", new byte[]{28, 112}), (String) p2.a(16777217, 0, 0, "b3e506", new byte[]{62})).replaceAll((String) p2.a(16777217, 0, 0, "d3fe47", new byte[]{58}), (String) p2.a(16777217, 0, 0, "d053ad", new byte[]{74})).replaceAll(b, "");
    }

    public static byte[] b(String r12) {
        int r1 = (r12.length() * 3) / 4;     // Catch: Throwable -> L16
        byte[] r2 = new byte[r1];     // Catch: Throwable -> L16
        int r3 = r12.length();     // Catch: Throwable -> L16
        String r4 = "";
        int r5 = 0;
    L5:
        if (r5 >= 2) goto L10;
        if (r12.charAt((r3 - 1) - r5) != b.charAt(0)) goto L9;
        r4 = r4 + a.charAt(0);     // Catch: Throwable -> L16
    L9:
        r5 = r5 + 1;     // Catch: Throwable -> L16
        goto L5
    L10:
        String r13 = r12.substring(0, r3 - r4.length()) + r4;     // Catch: Throwable -> L16
        int r6 = 0;
        int r7 = 0;
    L12:
        if (r6 >= r13.length()) goto L14;
        String r8 = a;     // Catch: Throwable -> L16
        int r9 = r8.indexOf(r13.charAt(r6));     // Catch: Throwable -> L16
        int r10 = r8.indexOf(r13.charAt(r6 + 1));     // Catch: Throwable -> L16
        int r11 = r8.indexOf(r13.charAt(r6 + 2));     // Catch: Throwable -> L16
        int r14 = r8.indexOf(r13.charAt(r6 + 3));     // Catch: Throwable -> L16
        int r15 = ((r9 << 2) | (r10 >> 4)) & KotlinVersion.MAX_COMPONENT_VALUE;     // Catch: Throwable -> L16
        int r16 = ((r10 << 4) | (r11 >> 2)) & KotlinVersion.MAX_COMPONENT_VALUE;     // Catch: Throwable -> L16
        int r17 = (r14 | (r11 << 6)) & KotlinVersion.MAX_COMPONENT_VALUE;     // Catch: Throwable -> L16
        r2[r7] = (byte) r15;     // Catch: Throwable -> L16
        r2[r7 + 1] = (byte) r16;     // Catch: Throwable -> L16
        r2[r7 + 2] = (byte) r17;     // Catch: Throwable -> L16
        r6 = r6 + 4;     // Catch: Throwable -> L16
        r7 = r7 + 3;     // Catch: Throwable -> L16
        goto L12
    L14:
        return Arrays.copyOfRange(r2, 0, r1 - r4.length());
    L17:
        return new byte[0];
    }
}
