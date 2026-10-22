package s6;

import android.util.Log;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12041b;
    }

    public static String a(byte[] r8) {
        StringBuilder r10 = new StringBuilder();
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append(String.format("%02x", new Object[]{Byte.valueOf(r8[r12])}));
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }

    public static byte[] b(String r8) {
        if ((r8.length() % 2) == 0) goto L6;
        Log.e("CryptoUtils", "Invalid hex string length:" + r8.length());
        return new byte[0];
    L6:
        int r10 = r8.length() / 2;
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L14;
        int r13 = r12 * 2;
        r11[r12] = (byte) Integer.parseInt(r8.substring(r13, r13 + 2), 16);     // Catch: Exception -> L11
        r12 = r12 + 1;
    L11:
        e = move-exception;
        Log.e("CryptoUtils", "Hex string to byte array failed, error:" + e.getMessage());
        return new byte[0];
    L14:
        return r11;
    }

    public static byte[] c(byte[] r8) {
        if (r8[0] != 48) goto L18;
        int r10 = d(1, r8).f12041b + 1;
        if (r8[r10] != 48) goto L16;
        int r11 = r10 + 1;
        a r12 = d(r11, r8);
        int r13 = (r12.f12041b + r12.f12040a) + r11;
        if (r8[r13] != 3) goto L14;
        int r14 = r13 + 1;
        a r15 = d(r14, r8);
        int r16 = r15.f12040a;
        int r17 = r14 + r15.f12041b;
        if (r8[r17] != 0) goto L12;
        r17 = r17 + 1;
        r16 = r16 - 1;
    L12:
        return Arrays.copyOfRange(r8, r17, r16 + r17);
    L14:
        throw new IllegalArgumentException("Invalid BIT STRING tag");
    L16:
        throw new IllegalArgumentException("Invalid algorithm identifier");
    L18:
        throw new IllegalArgumentException("Invalid ASN.1 SEQUENCE tag");
    }

    public static a d(int r8, byte[] r10) {
        int r11 = r10[r8] & 255;
        a r12 = new a();
        if ((r11 & 128) != 0) goto L5;
        r12.f12040a = r11;
        r12.f12041b = 1;
    L8:
        return r12;
    L5:
        int r13 = r11 & QesdkUtils.LIMITS.INT_8_UPPER;
        r12.f12041b = r13 + 1;
        int r14 = 0;
        r12.f12040a = 0;
    L6:
        if (r14 >= r13) goto L8;
        r12.f12040a = (r12.f12040a << 8) | (r10[(r8 + 1) + r14] & 255);
        r14 = r14 + 1;
        goto L6
    }
}
