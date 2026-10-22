package org.threeten.bp.format;

import com.bytedance.keva.KevaImpl;
import java.math.BigInteger;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;
import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes3.dex */
public class j implements g {
    public static final int[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.threeten.bp.temporal.g f21217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21219c;
    public final SignStyle d;
    public final int e;

    static {
        f = new int[]{0, 10, 100, 1000, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 100000, DurationKt.NANOS_IN_MILLIS, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};
    }

    public j(org.threeten.bp.temporal.g r5, int r10, int r11, SignStyle r12) {
        this.f21217a = r5;
        this.f21218b = r10;
        this.f21219c = r11;
        this.d = r12;
        this.e = 0;
    }

    public long a(w r5, long r10) {
        return r10;
    }

    public boolean b(u r5) {
        int r10 = this.e;
        if (r10 == (-1)) goto L11;
        if (r10 > 0) goto L6;
    L10:
        return false;
    L6:
        if (this.f21218b != this.f21219c) goto L10;
        if (this.d != SignStyle.NOT_NEGATIVE) goto L10;
    L11:
        return true;
    }

    public int c(u r10, long r11, int r12, int r13) {
        return r10.e(this.f21217a, r11, r12, r13);
    }

    public j d() {
        if (this.e != (-1)) goto L5;
        return this;
    L5:
        SignStyle r10 = this.d;
        return new j(this.f21217a, this.f21218b, this.f21219c, r10, -1);
    }

    public j e(int r10) {
        int r5 = this.e + r10;
        int r11 = this.f21219c;
        SignStyle r12 = this.d;
        return new j(this.f21217a, this.f21218b, r11, r12, r5);
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r26, CharSequence r27, int r28) {
        int r5 = r27.length();
        if (r28 == r5) goto L5;
        char r10 = r27.charAt(r28);
        r26.f21251b.getClass();
        z r11 = r26.f21251b;
        int r12 = this.f21219c;
        SignStyle r13 = this.d;
        int r14 = this.f21218b;
        int r15 = 0;
        if (r10 != '+') goto L17;
        boolean r16 = r26.e;
        if (r14 != r12) goto L11;
        boolean r17 = true;
    L13:
        if (r13.parse(true, r16, r17) == false) goto L15;
        int r18 = r28 + 1;
        boolean r19 = true;
        boolean r20 = false;
    L36:
        if (r26.e == false) goto L38;
    L41:
        int r110 = r14;
    L42:
        int r111 = r18 + r110;
        if (r111 <= r5) goto L47;
        return ~r18;
    L47:
        if (r26.e == false) goto L49;
    L52:
        int r112 = this.e;
        int r113 = Math.max(r112, 0) + r12;
    L53:
        BigInteger r114 = null;
        if (r15 >= 2) goto L78;
        int r21 = Math.min(r18 + r113, r5);
        int r22 = r18;
        long r23 = 0;
    L56:
        if (r22 >= r21) goto L73;
        int r24 = r22 + 1;
        char r25 = r27.charAt(r22);
        r11.getClass();
        int r29 = r25 - '0';
        int r210 = r5;
        if (r29 < 0) goto L61;
        if (r29 > 9) goto L61;
    L62:
        if (r29 < 0) goto L63;
        if ((r24 - r18) <= 18) goto L71;
        if (r114 != null) goto L70;
        r114 = BigInteger.valueOf(r23);
    L70:
        r114 = r114.multiply(BigInteger.TEN).add(BigInteger.valueOf(r29));
    L72:
        r22 = r24;
        r5 = r210;
        r21 = r21;
        goto L56
    L71:
        r23 = (r23 * 10) + ((long) r29);
        goto L72
    L63:
        if (r22 < r111) goto L65;
    L74:
        if (r112 <= 0) goto L77;
        if (r15 != 0) goto L77;
        r15 = r15 + 1;
        r113 = Math.max(r110, (r22 - r18) - r112);
        r5 = r210;
    L77:
        int r30 = r22;
        BigInteger r31 = r114;
        long r32 = r23;
    L79:
        if (r20 == false) goto L97;
        if (r31 == null) goto L90;
        if (r31.equals(BigInteger.ZERO) == true) goto L84;
    L87:
        r31 = r31.negate();
    L88:
        long r33 = r32;
    L108:
        if (r31 == null) goto L115;
        if (r31.bitLength() <= 63) goto L113;
        r31 = r31.divide(BigInteger.TEN);
        r30 = r30 - 1;
    L113:
        return c(r26, r31.longValue(), r18, r30);
    L115:
        return c(r26, r33, r18, r30);
    L84:
        if (r26.e == false) goto L87;
        return ~(r18 - 1);
    L90:
        if (r32 == 0) goto L92;
    L95:
        r33 = -r32;
        goto L108
    L92:
        if (r26.e == false) goto L95;
        return ~(r18 - 1);
    L97:
        if (r13 != SignStyle.EXCEEDS_PAD) goto L88;
        if (r26.e == false) goto L88;
        int r34 = r30 - r18;
        if (r19 == false) goto L105;
        if (r34 > r14) goto L88;
        return ~(r18 - 1);
    L105:
        if (r34 <= r14) goto L88;
        return ~r18;
    L65:
        return ~r18;
    L61:
        r29 = -1;
        goto L62
    L73:
        r210 = r5;
        goto L74
    L78:
        r30 = r18;
        r32 = 0;
        r31 = null;
        goto L79
    L49:
        if (b(r26) == true) goto L52;
        r12 = 9;
        goto L52
    L38:
        if (b(r26) == true) goto L41;
        r110 = 1;
        goto L42
    L15:
        return ~r28;
    L11:
        r17 = false;
        goto L13
    L17:
        r11.getClass();
        if (r10 != '-') goto L29;
        boolean r35 = r26.e;
        if (r14 != r12) goto L22;
        boolean r36 = true;
    L24:
        if (r13.parse(false, r35, r36) == false) goto L26;
        r18 = r28 + 1;
        r20 = true;
        r19 = false;
        goto L36
    L26:
        return ~r28;
    L22:
        r36 = false;
        goto L24
    L29:
        if (r13 == SignStyle.ALWAYS) goto L31;
    L34:
        r18 = r28;
        r20 = false;
        r19 = false;
        goto L36
    L31:
        if (r26.e == false) goto L34;
        return ~r28;
    L5:
        return ~r28;
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r11, StringBuilder r12) {
        org.threeten.bp.temporal.g r5 = this.f21217a;
        Long r10 = r11.a(r5);
        int r13 = 0;
        if (r10 != null) goto L5;
        return false;
    L5:
        long r14 = a(r11, r10.longValue());
        if (r14 != Long.MIN_VALUE) goto L8;
        String r15 = "9223372036854775808";
    L9:
        int r16 = r15.length();
        int r17 = this.f21219c;
        if (r16 > r17) goto L40;
        r11.f21258c.getClass();
        int r18 = this.f21218b;
        SignStyle r19 = this.d;
        if (r14 < 0) goto L23;
        int r110 = d.f21210a[r19.ordinal()];
        if (r110 == 1) goto L19;
        if (r110 != 2) goto L35;
        r12.append('+');
    L35:
        if (r13 >= (r18 - r15.length())) goto L37;
        r12.append('0');
        r13 = r13 + 1;
        goto L35
    L37:
        r12.append(r15);
        return true;
    L19:
        if (r18 >= 19) goto L35;
        if (r14 < f[r18]) goto L35;
        r12.append('+');
        goto L35
    L23:
        int r111 = d.f21210a[r19.ordinal()];
        if (r111 == 1) goto L33;
        if (r111 == 2) goto L33;
        if (r111 == 3) goto L33;
        if (r111 != 4) goto L35;
        throw new DateTimeException("Field " + r5 + " cannot be printed as the value " + r14 + " cannot be negative according to the SignStyle");
    L33:
        r12.append('-');
        goto L35
    L40:
        throw new DateTimeException("Field " + r5 + " cannot be printed as the value " + r14 + " exceeds the maximum print width of " + r17);
    L8:
        r15 = Long.toString(Math.abs(r14));
        goto L9
    }

    public String toString() {
        org.threeten.bp.temporal.g r5 = this.f21217a;
        SignStyle r10 = this.d;
        int r11 = this.f21219c;
        int r12 = this.f21218b;
        if (r12 != 1) goto L11;
        if (r11 != 19) goto L11;
        if (r10 != SignStyle.NORMAL) goto L11;
        return "Value(" + r5 + ")";
    L11:
        if (r12 != r11) goto L17;
        if (r10 != SignStyle.NOT_NEGATIVE) goto L17;
        return "Value(" + r5 + "," + r12 + ")";
    L17:
        return "Value(" + r5 + "," + r12 + "," + r11 + "," + r10 + ")";
    }

    public j(org.threeten.bp.temporal.g r5, int r10, int r11, SignStyle r12, int r13) {
        this.f21217a = r5;
        this.f21218b = r10;
        this.f21219c = r11;
        this.d = r12;
        this.e = r13;
    }
}
