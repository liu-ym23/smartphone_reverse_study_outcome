package com.google.crypto.tink.subtle;

import com.bytedance.rpc.internal.RpcUtils;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5049a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f5050b = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.a$a, reason: collision with other inner class name */
    static abstract class AbstractC0209a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f5051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5052b;

        AbstractC0209a() {
        }
    }

    static class b extends AbstractC0209a {
        private static final int[] c = null;
        private static final int[] d = null;
        private int e;
        private int f;
        private final int[] g;

        static {
            c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public b(int r1, byte[] r2) {
            this.f5051a = r2;
            if ((r1 & 8) != 0) goto L5;
            int[] r3 = c;
        L6:
            this.g = r3;
            this.e = 0;
            this.f = 0;
            return;
        L5:
            r3 = d;
            goto L6
        }

        public boolean a(byte[] r17, int r18, int r19, boolean r20) {
            int r1 = this.e;
            if (r1 != 6) goto L5;
            return false;
        L5:
            int r4 = r19 + r18;
            int r5 = this.f;
            byte[] r6 = this.f5051a;
            int[] r7 = this.g;
            int r9 = 0;
            int r8 = r5;
            int r10 = r1;
            int r2 = r18;
        L7:
            if (r2 >= r4) goto L60;
            if (r10 != 0) goto L16;
        L9:
            int r14 = r2 + 4;
            if (r14 > r4) goto L14;
            r8 = (((r7[r17[r2] & 255] << 18) | (r7[r17[r2 + 1] & 255] << 12)) | (r7[r17[r2 + 2] & 255] << 6)) | r7[r17[r2 + 3] & 255];
            if (r8 < 0) goto L14;
            r6[r9 + 2] = (byte) r8;
            r6[r9 + 1] = (byte) (r8 >> 8);
            r6[r9] = (byte) (r8 >> 16);
            r9 = r9 + 3;
            r2 = r14;
        L14:
            if (r2 >= r4) goto L60;
        L16:
            int r15 = r2 + 1;
            int r3 = r7[r17[r2] & 255];
            if (r10 == 0) goto L54;
            if (r10 == 1) goto L48;
            if (r10 == 2) goto L41;
            if (r10 == 3) goto L34;
            if (r10 == 4) goto L29;
            if (r10 != 5) goto L59;
            if (r3 == (-1)) goto L59;
        L26:
            this.e = 6;
            return false;
        L59:
            r2 = r15;
            goto L7
        L29:
            if (r3 != (-2)) goto L31;
            r10 = r10 + 1;
            goto L59
        L31:
            if (r3 == (-1)) goto L59;
            this.e = 6;
            return false;
        L34:
            if (r3 < 0) goto L36;
            int r11 = r3 | (r8 << 6);
            r6[r9 + 2] = (byte) r11;
            r6[r9 + 1] = (byte) (r11 >> 8);
            r6[r9] = (byte) (r11 >> 16);
            r9 = r9 + 3;
            r8 = r11;
            r10 = 0;
            goto L59
        L36:
            if (r3 != (-2)) goto L38;
            r6[r9 + 1] = (byte) (r8 >> 2);
            r6[r9] = (byte) (r8 >> 10);
            r9 = r9 + 2;
            r10 = 5;
            goto L59
        L38:
            if (r3 == (-1)) goto L59;
        L39:
            this.e = 6;
            return false;
        L41:
            if (r3 >= 0) goto L49;
            if (r3 != (-2)) goto L45;
            r6[r9] = (byte) (r8 >> 4);
            r9 = r9 + 1;
            r10 = 4;
            goto L59
        L45:
            if (r3 == (-1)) goto L59;
        L49:
            r3 = r3 | (r8 << 6);
        L55:
            r10 = r10 + 1;
            r8 = r3;
            goto L59
        L48:
            if (r3 >= 0) goto L49;
            if (r3 == (-1)) goto L59;
            this.e = 6;
            return false;
        L54:
            if (r3 >= 0) goto L55;
            if (r3 == (-1)) goto L59;
            this.e = 6;
            return false;
        L60:
            if (r20 == true) goto L64;
            this.e = r10;
            this.f = r8;
        L62:
            this.f5052b = r9;
            return true;
        L64:
            if (r10 == 1) goto L39;
            if (r10 == 2) goto L70;
            if (r10 == 3) goto L69;
            if (r10 == 4) goto L39;
        L71:
            this.e = r10;
            goto L62
        L69:
            int r12 = r9 + 1;
            r6[r9] = (byte) (r8 >> 10);
            r9 = r12 + 1;
            r6[r12] = (byte) (r8 >> 2);
            goto L71
        L70:
            r6[r9] = (byte) (r8 >> 4);
            r9 = r9 + 1;
            goto L71
        }
    }

    static {
        f5050b = Charset.forName(RpcUtils.CHARSET_UTF8);
    }

    private a() {
    }

    public static byte[] a(String r1, int r2) {
        return a(r1.getBytes(f5050b), r2);
    }

    public static byte[] a(byte[] r2, int r3) {
        return a(r2, 0, r2.length, r3);
    }

    public static byte[] a(byte[] r2, int r3, int r4, int r5) {
        b r0 = new b(r5, new byte[(r4 * 3) / 4]);
        if (r0.a(r2, r3, r4, true) == false) goto L11;
        if (r0.f5052b == r0.f5051a.length) goto L7;
        byte[] r6 = new byte[r0.f5052b];
        System.arraycopy(r0.f5051a, 0, r6, 0, r0.f5052b);
        return r6;
    L7:
        return r0.f5051a;
    L11:
        throw new IllegalArgumentException("bad base-64");
    }
}
