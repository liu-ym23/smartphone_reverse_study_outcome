package fi;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f16900a = null;

    static {
        f16900a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static char[] a(byte[] r10, char[] r11) {
        int r5 = r10.length;
        char[] r12 = new char[r5 << 1];
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r5) goto L5;
        int r15 = r14 + 1;
        byte r16 = r10[r13];
        r12[r14] = r11[(r16 & 240) >>> 4];
        r14 = r14 + 2;
        r12[r15] = r11[r16 & 15];
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public static String b(byte[] r5) {
        return new String(a(MessageDigest.getInstance("MD5").digest(r5), f16900a));
    L4:
        return null;
    }
}
