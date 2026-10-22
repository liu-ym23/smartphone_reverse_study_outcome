package jf;

import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Serializable, Comparable<g> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final char[] f8840n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final g f8841o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f8842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f8843b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public transient String f8844m;

    static {
        f8840n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f8841o = g(new byte[0]);
    }

    public g(byte[] r8) {
        this.f8842a = r8;
    }

    public static g b(String r8) {
        if ((r8.length() % 2) != 0) goto L10;
        int r10 = r8.length() / 2;
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L8;
        int r13 = r12 * 2;
        int r14 = c(r8.charAt(r13)) << 4;
        r11[r12] = (byte) (c(r8.charAt(r13 + 1)) + r14);
        r12 = r12 + 1;
        goto L5
    L8:
        return g(r11);
    L10:
        throw new IllegalArgumentException("Unexpected hex string: ".concat(r8));
    }

    public static int c(char r8) {
        if (r8 >= '0') goto L5;
    L8:
        char r10 = 'a';
        if (r8 >= 'a') goto L11;
    L14:
        r10 = 'A';
        if (r8 < 'A') goto L20;
        if (r8 > 'F') goto L20;
    L13:
        return (r8 - r10) + 10;
    L20:
        throw new IllegalArgumentException("Unexpected hex digit: " + r8);
    L11:
        if (r8 > 'f') goto L14;
    L5:
        if (r8 > '9') goto L8;
        return r8 - '0';
    }

    public static g d(String r8) {
        if (r8 == null) goto L6;
        g r10 = new g(r8.getBytes(y.f8885a));
        r10.f8844m = r8;
        return r10;
    L6:
        throw new IllegalArgumentException("s == null");
    }

    public static g g(byte... r8) {
        if (r8 == null) goto L6;
        return new g((byte[]) r8.clone());
    L6:
        throw new IllegalArgumentException("data == null");
    }

    public String a() {
        byte[] r8 = t2.b.f12263w;
        byte[] r10 = this.f8842a;
        byte[] r11 = new byte[((r10.length + 2) / 3) * 4];
        int r12 = r10.length - (r10.length % 3);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        int r15 = r14 + 1;
        r11[r14] = r8[(r10[r13] & 255) >> 2];
        int r16 = r15 + 1;
        int r17 = r13 + 1;
        r11[r15] = r8[((r10[r13] & 3) << 4) | ((r10[r17] & 255) >> 4)];
        int r18 = r16 + 1;
        int r19 = (r10[r17] & 15) << 2;
        int r20 = r13 + 2;
        r11[r16] = r8[r19 | ((r10[r20] & 255) >> 6)];
        r14 = r18 + 1;
        r11[r18] = r8[r10[r20] & 63];
        r13 = r13 + 3;
        goto L3
    L5:
        int r21 = r10.length % 3;
        if (r21 == 1) goto L10;
        if (r21 != 2) goto L16;
        int r22 = r14 + 1;
        r11[r14] = r8[(r10[r12] & 255) >> 2];
        int r23 = r22 + 1;
        int r24 = (r10[r12] & 3) << 4;
        int r25 = r12 + 1;
        r11[r22] = r8[((r10[r25] & 255) >> 4) | r24];
        r11[r23] = r8[(r10[r25] & 15) << 2];
        r11[r23 + 1] = 61;
    L16:
        return new String(r11, "US-ASCII");
    L13:
        e = move-exception;
        throw new AssertionError(e);
    L10:
        int r26 = r14 + 1;
        r11[r14] = r8[(r10[r12] & 255) >> 2];
        int r27 = r26 + 1;
        r11[r26] = r8[(r10[r12] & 3) << 4];
        r11[r27] = 61;
        r11[r27 + 1] = 61;
        goto L16
    }

    @Override // java.lang.Comparable
    public final int compareTo(g r10) {
        g r11 = r10;
        int r8 = l();
        int r12 = r11.l();
        int r13 = Math.min(r8, r12);
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L11;
        int r15 = e(r14) & 255;
        int r16 = r11.e(r14) & 255;
        if (r15 != r16) goto L8;
        r14 = r14 + 1;
        goto L4
    L8:
        if (r15 >= r16) goto L18;
    L15:
        return -1;
    L18:
        return 1;
    L11:
        if (r8 == r12) goto L19;
        if (r8 >= r12) goto L18;
    L19:
        return 0;
    }

    public byte e(int r8) {
        return this.f8842a[r8];
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == false) goto L13;
        g r10 = (g) r8;
        int r11 = r10.l();
        byte[] r12 = this.f8842a;
        if (r11 != r12.length) goto L13;
        if (r10.h(0, r12, 0, r12.length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public String f() {
        byte[] r8 = this.f8842a;
        char[] r10 = new char[r8.length * 2];
        int r11 = r8.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L6;
        byte r14 = r8[r12];
        int r15 = r13 + 1;
        char[] r16 = f8840n;
        r10[r13] = r16[(r14 >> 4) & 15];
        r13 = r15 + 1;
        r10[r15] = r16[r14 & 15];
        r12 = r12 + 1;
        goto L3
    L6:
        return new String(r10);
    }

    public boolean h(int r8, byte[] r10, int r11, int r12) {
        if (r8 < 0) goto L22;
        byte[] r13 = this.f8842a;
        if (r8 > (r13.length - r12)) goto L23;
        if (r11 >= 0) goto L8;
        return false;
    L8:
        if (r11 > (r10.length - r12)) goto L25;
        Charset r14 = y.f8885a;
        int r15 = 0;
    L11:
        if (r15 >= r12) goto L16;
        if (r13[r15 + r8] != r10[r15 + r11]) goto L14;
        r15 = r15 + 1;
        goto L11
    L14:
        boolean r16 = false;
    L17:
        if (r16 == true) goto L19;
        return false;
    L19:
        return true;
    L16:
        r16 = true;
        goto L17
    L25:
        return false;
    L23:
        return false;
    L22:
        return false;
    }

    public int hashCode() {
        int r8 = this.f8843b;
        if (r8 != 0) goto L7;
        int r10 = Arrays.hashCode(this.f8842a);
        this.f8843b = r10;
        return r10;
    L7:
        return r8;
    }

    public boolean i(g r8, int r10) {
        return r8.h(0, this.f8842a, 0, r10);
    }

    public g j() {
        return g(MessageDigest.getInstance("SHA-1").digest(this.f8842a));
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public g k() {
        return g(MessageDigest.getInstance("SHA-256").digest(this.f8842a));
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public int l() {
        return this.f8842a.length;
    }

    public g m() {
        byte[] r8 = this.f8842a;
        if (64 > r8.length) goto L10;
        if (64 != r8.length) goto L7;
        return this;
    L7:
        byte[] r10 = new byte[64];
        System.arraycopy(r8, 0, r10, 0, 64);
        return new g(r10);
    L10:
        throw new IllegalArgumentException(android.aimedia.a.h(new StringBuilder("endIndex > length("), r8.length, ")"));
    }

    public g n() {
        int r8 = 0;
    L3:
        byte[] r10 = this.f8842a;
        if (r8 >= r10.length) goto L22;
        byte r11 = r10[r8];
        if (r11 < 65) goto L21;
        if (r11 > 90) goto L21;
        byte[] r12 = (byte[]) r10.clone();
        int r13 = r8 + 1;
        r12[r8] = (byte) (r11 + BWDLDataStructure.DataLinkParamStructure.BT_SPP);
    L12:
        if (r13 >= r12.length) goto L20;
        byte r14 = r12[r13];
        if (r14 < 65) goto L18;
        if (r14 > 90) goto L18;
        r12[r13] = (byte) (r14 + BWDLDataStructure.DataLinkParamStructure.BT_SPP);
    L18:
        r13 = r13 + 1;
        goto L12
    L20:
        return new g(r12);
    L21:
        r8 = r8 + 1;
        goto L3
    L22:
        return this;
    }

    public byte[] o() {
        return (byte[]) this.f8842a.clone();
    }

    public String p() {
        String r8 = this.f8844m;
        if (r8 != null) goto L7;
        String r10 = new String(this.f8842a, y.f8885a);
        this.f8844m = r10;
        return r10;
    L7:
        return r8;
    }

    public void q(d r8) {
        byte[] r10 = this.f8842a;
        r8.D(0, r10.length, r10);
    }

    public String toString() {
        byte[] r8 = this.f8842a;
        if (r8.length != 0) goto L6;
        return "[size=0]";
    L6:
        String r10 = p();
        int r11 = r10.length();
        int r12 = 0;
        int r13 = 0;
    L8:
        if (r12 >= r11) goto L21;
        if (r13 == 64) goto L23;
        int r14 = r10.codePointAt(r12);
        if (Character.isISOControl(r14) == false) goto L18;
        if (r14 == 10) goto L18;
        if (r14 == 13) goto L18;
    L19:
        r12 = -1;
    L18:
        if (r14 == 65533) goto L19;
        r13 = r13 + 1;
        r12 = r12 + Character.charCount(r14);
    L23:
        if (r12 == (-1)) goto L25;
        String r15 = r10.substring(0, r12).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (r12 >= r10.length()) goto L33;
        return "[size=" + r8.length + " text=" + r15 + "…]";
    L33:
        return defpackage.b.d("[text=", r15, "]");
    L25:
        if (r8.length > 64) goto L28;
        return "[hex=" + f() + "]";
    L28:
        return "[size=" + r8.length + " hex=" + m().f() + "…]";
    L21:
        r12 = r10.length();
        goto L23
    }
}
