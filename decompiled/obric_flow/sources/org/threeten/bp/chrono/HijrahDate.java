package org.threeten.bp.chrono;

import ai.j0;
import androidx.compose.runtime.ComposerKt;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class HijrahDate extends ChronoDateImpl<HijrahDate> implements Serializable {
    public static final Integer[] A = null;
    public static final Integer[] B = null;
    public static final Integer[] C = null;
    public static final Integer[] D = null;
    public static final Integer[] E = null;
    public static final int MAX_VALUE_OF_ERA = 9999;
    public static final int MIN_VALUE_OF_ERA = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f21138i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f21139j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f21140k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f21141l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f21142m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f21143n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f21144o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f21145p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final char f21146q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f21147r = null;
    public static final String s = null;
    private static final long serialVersionUID = -5207853542612002020L;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final HashMap f21148t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final HashMap f21149u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final HashMap f21150v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Long[] f21151w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Integer[] f21152x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Integer[] f21153y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Integer[] f21154z = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient HijrahEra f21155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f21156c;
    public final transient int d;
    public final transient int e;
    public final transient int f;
    public final transient DayOfWeek g;
    private final long gregorianEpochDay;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient boolean f21157h;

    static {
        int r5 = 0;
        int[] r10 = {0, 30, 59, 89, 118, 148, 177, ComposerKt.reuseKey, 236, 266, 295, 325};
        f21138i = r10;
        f21139j = new int[]{0, 30, 59, 89, 118, 148, 177, ComposerKt.reuseKey, 236, 266, 295, 325};
        f21140k = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
        f21141l = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
        f21142m = new int[]{0, 1, 0, 1, 0, 1, 1};
        f21143n = new int[]{1, MAX_VALUE_OF_ERA, 11, 51, 5, 29, 354};
        f21144o = new int[]{1, MAX_VALUE_OF_ERA, 11, 52, 6, 30, 355};
        f21145p = new int[]{0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
        char r11 = File.separatorChar;
        f21146q = r11;
        f21147r = File.pathSeparator;
        s = "org" + r11 + "threeten" + r11 + "bp" + r11 + "chrono";
        f21148t = new HashMap();
        f21149u = new HashMap();
        f21150v = new HashMap();
        A = new Integer[r10.length];
        int r12 = 0;
    L3:
        int[] r13 = f21138i;
        if (r12 >= r13.length) goto L6;
        A[r12] = new Integer(r13[r12]);
        r12 = r12 + 1;
        goto L3
    L6:
        B = new Integer[f21139j.length];
        int r14 = 0;
    L7:
        int[] r15 = f21139j;
        if (r14 >= r15.length) goto L10;
        B[r14] = new Integer(r15[r14]);
        r14 = r14 + 1;
        goto L7
    L10:
        C = new Integer[f21140k.length];
        int r16 = 0;
    L11:
        int[] r17 = f21140k;
        if (r16 >= r17.length) goto L14;
        C[r16] = new Integer(r17[r16]);
        r16 = r16 + 1;
        goto L11
    L14:
        D = new Integer[f21141l.length];
        int r18 = 0;
    L15:
        int[] r19 = f21141l;
        if (r18 >= r19.length) goto L18;
        D[r18] = new Integer(r19[r18]);
        r18 = r18 + 1;
        goto L15
    L18:
        E = new Integer[f21145p.length];
        int r20 = 0;
    L19:
        int[] r21 = f21145p;
        if (r20 >= r21.length) goto L22;
        E[r20] = new Integer(r21[r20]);
        r20 = r20 + 1;
        goto L19
    L22:
        f21151w = new Long[334];
        int r22 = 0;
    L23:
        Long[] r23 = f21151w;
        if (r22 >= r23.length) goto L26;
        r23[r22] = new Long(r22 * 10631);
        r22 = r22 + 1;
        goto L23
    L26:
        f21152x = new Integer[f21142m.length];
        int r24 = 0;
    L27:
        int[] r25 = f21142m;
        if (r24 >= r25.length) goto L30;
        f21152x[r24] = new Integer(r25[r24]);
        r24 = r24 + 1;
        goto L27
    L30:
        f21153y = new Integer[f21143n.length];
        int r26 = 0;
    L31:
        int[] r27 = f21143n;
        if (r26 >= r27.length) goto L34;
        f21153y[r26] = new Integer(r27[r26]);
        r26 = r26 + 1;
        goto L31
    L34:
        f21154z = new Integer[f21144o.length];
    L35:
        int[] r28 = f21144o;
        if (r5 >= r28.length) goto L41;
        f21154z[r5] = new Integer(r28[r5]);
        r5 = r5 + 1;
        goto L35
    L41:
        j();     // Catch: Throwable -> L40
        return;
    }

    public HijrahDate(long r13) {
        Long[] r5 = f21151w;
        long r10 = r13 - (-492148);
        if (r10 < 0) goto L25;
        int r11 = 0;
    L61:
    L13:
        int r12 = ((int) r10) / 10631;
    L62:
        Long r14 = r5[r12];     // Catch: ArrayIndexOutOfBoundsException -> L16
    L17:
        if (r14 != null) goto L19;
        r14 = new Long(r12 * 10631);
    L19:
        int r15 = (int) (r10 - r14.longValue());
        int r16 = h(r12, r15);
        Integer[] r17 = b(r12);
        if (r15 <= 0) goto L22;
        int r18 = r15 - r17[r16].intValue();
    L23:
        int r19 = ((r12 * 30) + r16) + 1;
        int r20 = g(r18, r19);
        int r21 = e(r18, r20, r19) + 1;
        int r22 = HijrahEra.AH.getValue();
    L24:
        int r23 = r21;
        int r24 = r19;
        int r25 = (int) ((r13 - (-492153)) % 7);
        if (r25 > 0) goto L40;
        int r26 = 7;
    L41:
        int[] r27 = {r22, r24, r20 + 1, r23, r18 + 1, r25 + r26};
        int r28 = r27[1];
        if (r28 < 1) goto L60;
        if (r28 > 9999) goto L60;
        int r29 = r27[2];
        if (r29 < 1) goto L58;
        if (r29 > 12) goto L58;
        a(r27[3]);
        int r30 = r27[4];
        if (r30 < 1) goto L56;
        if (r30 > getMaximumDayOfYear()) goto L56;
        this.f21155b = HijrahEra.of(r27[0]);
        int r31 = r27[1];
        this.f21156c = r31;
        this.d = r27[2];
        this.e = r27[3];
        this.f = r27[4];
        this.g = DayOfWeek.of(r27[5]);
        this.gregorianEpochDay = r13;
        this.f21157h = isLeapYear(r31);
        return;
    L56:
        throw new DateTimeException("Invalid day of year of Hijrah date");
    L58:
        throw new DateTimeException("Invalid month of Hijrah date");
    L60:
        throw new DateTimeException("Invalid year of Hijrah Era");
    L40:
        r26 = 0;
        goto L41
    L22:
        r18 = r15 + r17[r16].intValue();
    L16:
        r14 = null;
        goto L17
    L6:
        if (r11 >= r5.length) goto L11;
        if (r10 < r5[r11].longValue()) goto L9;
        r11 = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L13
        goto L61
    L9:
        r12 = r11 - 1;     // Catch: ArrayIndexOutOfBoundsException -> L13
        goto L62
    L11:
        r12 = ((int) r10) / 10631;     // Catch: ArrayIndexOutOfBoundsException -> L13
        goto L62
    L25:
        int r32 = (int) r10;
        int r33 = r32 / 10631;
        int r34 = r32 % 10631;
        if (r34 != 0) goto L28;
        r33 = r33 + 1;
        r34 = -10631;
    L28:
        int r35 = h(r33, r34);
        Integer[] r36 = b(r33);
        if (r34 <= 0) goto L31;
        int r37 = r34 - r36[r35].intValue();
    L32:
        r19 = 1 - ((r33 * 30) - r35);
        if (isLeapYear(r19) == false) goto L35;
        r18 = r37 + 355;
    L36:
        r20 = g(r18, r19);
        r21 = e(r18, r20, r19) + 1;
        r22 = HijrahEra.BEFORE_AH.getValue();
        goto L24
    L35:
        r18 = r37 + 354;
        goto L36
    L31:
        r37 = r34 + r36[r35].intValue();
        goto L32
    }

    public static void a(int r5) {
        if (r5 >= 1) goto L5;
    L7:
        StringBuilder r10 = j0.s(r5, "Invalid day of month of Hijrah date, day ", " greater than ");
        r10.append(getMaximumDayOfMonth());
        r10.append(" or less than 1");
        throw new DateTimeException(r10.toString());
    L5:
        if (r5 > getMaximumDayOfMonth()) goto L7;
    }

    public static Integer[] b(int r5) {
        Integer[] r10 = (Integer[]) f21150v.get(new Integer(r5));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r10 == null) goto L7;
        return r10;
    L7:
        return E;
    L4:
        r10 = null;
        goto L5
    }

    public static Integer[] c(int r5) {
        Integer[] r10 = (Integer[]) f21148t.get(new Integer(r5));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r10 == null) goto L7;
        return r10;
    L7:
        if (isLeapYear(r5) == false) goto L10;
        return B;
    L10:
        return A;
    L4:
        r10 = null;
        goto L5
    }

    public static int e(int r5, int r10, int r11) {
        Integer[] r12 = c(r11);
        if (r5 < 0) goto L9;
        if (r10 <= 0) goto L15;
        int r13 = r12[r10].intValue();
    L7:
        return r5 - r13;
    L15:
        return r5;
    L9:
        if (isLeapYear(r11) == false) goto L11;
        r5 = r5 + 355;
    L12:
        if (r10 <= 0) goto L14;
        r13 = r12[r10].intValue();
        goto L7
    L14:
        return r5;
    L11:
        r5 = r5 + 354;
        goto L12
    }

    public static long f(int r5, int r10, int r11) {
        int r12 = r5 - 1;
        int r13 = r12 / 30;
        int r14 = r12 % 30;
        int r15 = b(r13)[Math.abs(r14)].intValue();
        if (r14 >= 0) goto L12;
        r15 = -r15;
    L12:
        Long r16 = f21151w[r13];     // Catch: ArrayIndexOutOfBoundsException -> L7
    L8:
        if (r16 != null) goto L11;
        r16 = new Long(r13 * 10631);
    L11:
        return (((r16.longValue() + ((long) r15)) - 492149) + ((long) c(r5)[r10 - 1].intValue())) + ((long) r11);
    L7:
        r16 = null;
        goto L8
    }

    public static HijrahDate from(org.threeten.bp.temporal.d r5) {
        return HijrahChronology.INSTANCE.date(r5);
    }

    public static int g(int r5, int r10) {
        Integer[] r11 = c(r10);
        int r12 = 0;
        if (r5 < 0) goto L13;
    L5:
        if (r12 >= r11.length) goto L11;
        if (r5 < r11[r12].intValue()) goto L9;
        r12 = r12 + 1;
        goto L5
    L9:
        return r12 - 1;
    L11:
        return 11;
    L13:
        if (isLeapYear(r10) == false) goto L15;
        int r13 = r5 + 355;
    L17:
        if (r12 >= r11.length) goto L23;
        if (r13 < r11[r12].intValue()) goto L21;
        r12 = r12 + 1;
        goto L17
    L21:
        return r12 - 1;
    L23:
        return 11;
    L15:
        r13 = r5 + 354;
        goto L17
    }

    public static int getMaximumDayOfMonth() {
        return f21154z[5].intValue();
    }

    public static int getMaximumDayOfYear() {
        return f21154z[6].intValue();
    }

    public static int getMonthLength(int r5, int r10) {
        Integer[] r11 = (Integer[]) f21149u.get(new Integer(r10));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r11 != null) goto L11;
        if (isLeapYear(r10) == false) goto L9;
        r11 = D;
        goto L11
    L9:
        r11 = C;
    L11:
        return r11[r5].intValue();
    L4:
        r11 = null;
        goto L5
    }

    public static int getSmallestMaximumDayOfMonth() {
        return f21153y[5].intValue();
    }

    public static int getSmallestMaximumDayOfYear() {
        return f21153y[6].intValue();
    }

    public static int getYearLength(int r5) {
        int r10 = r5 - 1;
        int r11 = r10 / 30;
        Integer[] r12 = (Integer[]) f21150v.get(Integer.valueOf(r11));     // Catch: ArrayIndexOutOfBoundsException -> L5
    L6:
        if (r12 == null) goto L14;
        int r13 = r10 % 30;
        if (r13 != 29) goto L12;
        Long[] r14 = f21151w;
        int r15 = r14[r11 + 1].intValue() - r14[r11].intValue();
        int r16 = r12[r13].intValue();
    L11:
        return r15 - r16;
    L12:
        r15 = r12[r13 + 1].intValue();
        r16 = r12[r13].intValue();
        goto L11
    L14:
        if (isLeapYear(r5) == false) goto L16;
        return 355;
    L16:
        return 354;
    L5:
        r12 = null;
        goto L6
    }

    public static int h(int r5, long r10) {
        Integer[] r11 = b(r5);
        int r12 = 0;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if (r10 > 0) goto L8;
        long r13 = -r10;
    L17:
        if (r12 >= r11.length) goto L23;
        if (r13 <= r11[r12].intValue()) goto L21;
        r12 = r12 + 1;
        goto L17
    L21:
        return r12 - 1;
    L23:
        return 29;
    L8:
        if (r12 >= r11.length) goto L14;
        if (r10 < r11[r12].intValue()) goto L12;
        r12 = r12 + 1;
        goto L8
    L12:
        return r12 - 1;
    L14:
        return 29;
    }

    public static void i(int r24, String r25) {
        StringTokenizer r5 = new StringTokenizer(r25, ";");
    L4:
        if (r5.hasMoreTokens() == false) goto L206;
        String r10 = r5.nextToken();
        int r11 = r10.indexOf(58);
        if (r11 == (-1)) goto L205;
        int r12 = Integer.parseInt(r10.substring(r11 + 1, r10.length()));     // Catch: NumberFormatException -> L202
        int r13 = r10.indexOf(45);
        if (r13 == (-1)) goto L201;
        String r14 = r10.substring(0, r13);
        String r15 = r10.substring(r13 + 1, r11);
        int r16 = r14.indexOf(47);
        int r17 = r15.indexOf(47);
        if (r16 == (-1)) goto L199;
        String r18 = r14.substring(0, r16);
        String r19 = r14.substring(r16 + 1, r14.length());
        int r20 = Integer.parseInt(r18);     // Catch: NumberFormatException -> L196
        int r21 = Integer.parseInt(r19);     // Catch: NumberFormatException -> L194
        if (r17 == (-1)) goto L193;
        String r110 = r15.substring(0, r17);
        String r22 = r15.substring(r17 + 1, r15.length());
        int r23 = Integer.parseInt(r110);     // Catch: NumberFormatException -> L190
        int r26 = Integer.parseInt(r22);     // Catch: NumberFormatException -> L188
        if (r20 == (-1)) goto L187;
        if (r21 == (-1)) goto L187;
        if (r23 == (-1)) goto L187;
        if (r26 == (-1)) goto L187;
        if (r20 < 1) goto L185;
        if (r23 < 1) goto L183;
        if (r21 < 0) goto L181;
        if (r21 > 11) goto L181;
        if (r26 < 0) goto L179;
        if (r26 > 11) goto L179;
        if (r23 > 9999) goto L177;
        if (r23 < r20) goto L175;
        if (r23 != r20) goto L40;
        if (r26 >= r21) goto L40;
        throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
    L40:
        boolean r111 = isLeapYear(r20);
        Integer r112 = new Integer(r20);
        HashMap r113 = f21148t;
        Integer[] r114 = (Integer[]) r113.get(r112);
        int[] r115 = f21138i;
        int[] r116 = f21139j;
        if (r114 != null) goto L51;
        if (r111 == false) goto L47;
        r114 = new Integer[r116.length];
        int r117 = 0;
    L45:
        if (r117 >= r116.length) goto L51;
        r114[r117] = new Integer(r116[r117]);
        r117 = r117 + 1;
        goto L45
    L47:
        r114 = new Integer[r115.length];
        int r27 = 0;
    L49:
        if (r27 >= r115.length) goto L51;
        r114[r27] = new Integer(r115[r27]);
        r27 = r27 + 1;
    L51:
        Integer[] r28 = new Integer[r114.length];
        int r29 = 0;
    L53:
        if (r29 >= 12) goto L58;
        if (r29 <= r21) goto L56;
        r28[r29] = new Integer(r114[r29].intValue() - r12);
    L57:
        r29 = r29 + 1;
        goto L53
    L56:
        r28[r29] = new Integer(r114[r29].intValue());
        goto L57
    L58:
        r113.put(new Integer(r20), r28);
        Integer r30 = new Integer(r20);
        HashMap r31 = f21149u;
        Integer[] r32 = (Integer[]) r31.get(r30);
        int[] r33 = f21140k;
        int[] r118 = f21141l;
        if (r32 != null) goto L65;
        if (r111 == false) goto L66;
        r32 = new Integer[r118.length];
        int r119 = 0;
    L63:
        if (r119 >= r118.length) goto L65;
        r32[r119] = new Integer(r118[r119]);
        r119 = r119 + 1;
        r5 = r5;
        goto L63
    L66:
        StringTokenizer r120 = r5;
        r32 = new Integer[r33.length];
        int r34 = 0;
    L68:
        if (r34 >= r33.length) goto L70;
        r32[r34] = new Integer(r33[r34]);
        r34 = r34 + 1;
    L70:
        Integer[] r35 = new Integer[r32.length];
        int r121 = 12;
        int r122 = 0;
    L71:
        if (r122 >= r121) goto L76;
        if (r122 != r21) goto L74;
        r35[r122] = new Integer(r32[r122].intValue() - r12);
    L75:
        r122 = r122 + 1;
        r121 = 12;
        goto L71
    L74:
        r35[r122] = new Integer(r32[r122].intValue());
        goto L75
    L76:
        r31.put(new Integer(r20), r35);
        if (r20 == r23) goto L113;
        int r36 = r20 - 1;
        int r37 = r36 / 30;
        int r38 = r36 % 30;
        Integer r39 = new Integer(r37);
        HashMap r123 = f21150v;
        Integer[] r40 = (Integer[]) r123.get(r39);
        int[] r124 = f21145p;
        if (r40 != null) goto L85;
        int r41 = r124.length;
        Integer[] r42 = new Integer[r41];
        int r43 = 0;
    L81:
        if (r43 >= r41) goto L83;
        r42[r43] = new Integer(r124[r43]);
        r43 = r43 + 1;
        r41 = r41;
        r33 = r33;
        goto L81
    L83:
        int[] r210 = r33;
        r40 = r42;
    L86:
        int r44 = r38 + 1;
    L88:
        if (r44 >= r124.length) goto L90;
        r40[r44] = new Integer(r40[r44].intValue() - r12);
        r44 = r44 + 1;
        goto L88
    L90:
        r123.put(new Integer(r37), r40);
        int r45 = r23 - 1;
        int r46 = r45 / 30;
        if (r37 == r46) goto L101;
        int r47 = r37 + 1;
    L93:
        Long[] r48 = f21151w;
        if (r47 >= r48.length) goto L96;
        r48[r47] = new Long(r48[r47].longValue() - ((long) r12));
        r47 = r47 + 1;
        r115 = r115;
        r116 = r116;
        goto L93
    L96:
        int[] r49 = r115;
        int[] r211 = r116;
        int r50 = r46 + 1;
    L98:
        if (r50 >= r48.length) goto L100;
        r48[r50] = new Long(r48[r50].longValue() + ((long) r12));
        r50 = r50 + 1;
        r113 = r113;
        r118 = r118;
        goto L98
    L100:
        int[] r212 = r118;
        HashMap r213 = r113;
    L102:
        int r51 = r45 % 30;
        Integer[] r52 = (Integer[]) r123.get(new Integer(r46));
        if (r52 != null) goto L108;
        int r53 = r124.length;
        Integer[] r54 = new Integer[r53];
        int r55 = 0;
    L105:
        if (r55 >= r53) goto L107;
        r54[r55] = new Integer(r124[r55]);
        r55 = r55 + 1;
        goto L105
    L107:
        r52 = r54;
    L108:
        int r56 = r51 + 1;
    L110:
        if (r56 >= r124.length) goto L112;
        r52[r56] = new Integer(r52[r56].intValue() + r12);
        r56 = r56 + 1;
        goto L110
    L112:
        r123.put(new Integer(r46), r52);
    L114:
        boolean r57 = isLeapYear(r23);
        HashMap r58 = r213;
        Integer[] r59 = (Integer[]) r58.get(new Integer(r23));
        if (r59 != null) goto L126;
        if (r57 == false) goto L122;
        int[] r60 = r211;
        Integer[] r61 = new Integer[r60.length];
        int r62 = 0;
    L119:
        if (r62 >= r60.length) goto L121;
        r61[r62] = new Integer(r60[r62]);
        r62 = r62 + 1;
        goto L119
    L121:
        r59 = r61;
        goto L126
    L122:
        r59 = new Integer[r49.length];
        int r63 = 0;
    L124:
        if (r63 >= r49.length) goto L126;
        r59[r63] = new Integer(r49[r63]);
        r63 = r63 + 1;
    L126:
        Integer[] r64 = new Integer[r59.length];
        int r65 = 12;
        int r66 = 0;
    L127:
        if (r66 >= r65) goto L132;
        if (r66 <= r26) goto L130;
        r64[r66] = new Integer(r59[r66].intValue() + r12);
    L131:
        r66 = r66 + 1;
        r65 = 12;
        goto L127
    L130:
        r64[r66] = new Integer(r59[r66].intValue());
        goto L131
    L132:
        r58.put(new Integer(r23), r64);
        Integer[] r67 = (Integer[]) r31.get(new Integer(r23));
        if (r67 != null) goto L143;
        if (r57 == false) goto L139;
        int[] r68 = r212;
        r67 = new Integer[r68.length];
        int r69 = 0;
    L137:
        if (r69 >= r68.length) goto L143;
        r67[r69] = new Integer(r68[r69]);
        r69 = r69 + 1;
        goto L137
    L139:
        int[] r70 = r210;
        r67 = new Integer[r70.length];
        int r71 = 0;
    L141:
        if (r71 >= r70.length) goto L143;
        r67[r71] = new Integer(r70[r71]);
        r71 = r71 + 1;
    L143:
        Integer[] r72 = new Integer[r67.length];
        int r73 = 0;
    L144:
        if (r73 >= 12) goto L149;
        if (r73 != r26) goto L147;
        r72[r73] = new Integer(r67[r73].intValue() + r12);
    L148:
        r73 = r73 + 1;
        goto L144
    L147:
        r72[r73] = new Integer(r67[r73].intValue());
        goto L148
    L149:
        r31.put(new Integer(r23), r72);
        int r74 = r20;
        Integer[] r75 = (Integer[]) r31.get(new Integer(r74));
        Integer[] r76 = (Integer[]) r31.get(new Integer(r23));
        Integer[] r77 = (Integer[]) r58.get(new Integer(r74));
        Integer[] r78 = (Integer[]) r58.get(new Integer(r23));
        int r79 = r75[r21].intValue();
        int r80 = r76[r26].intValue();
        int r81 = r75[11].intValue() + r77[11].intValue();
        int r82 = r76[11].intValue() + r78[11].intValue();
        Integer[] r83 = f21154z;
        int r84 = r83[5].intValue();
        Integer[] r85 = f21153y;
        int r86 = r85[5].intValue();
        if (r84 >= r79) goto L152;
        r84 = r79;
    L152:
        if (r84 >= r80) goto L154;
        r84 = r80;
    L154:
        r83[5] = new Integer(r84);
        if (r86 > r79) goto L158;
        r79 = r86;
    L158:
        if (r79 > r80) goto L161;
        r80 = r79;
    L161:
        r85[5] = new Integer(r80);
        int r87 = r83[6].intValue();
        int r88 = r85[6].intValue();
        if (r87 >= r81) goto L164;
        r87 = r81;
    L164:
        if (r87 >= r82) goto L166;
        r87 = r82;
    L166:
        r83[6] = new Integer(r87);
        if (r88 > r81) goto L170;
        r81 = r88;
    L170:
        if (r81 > r82) goto L173;
        r82 = r81;
    L173:
        r85[6] = new Integer(r82);
        r5 = r120;
        goto L4
    L101:
        r212 = r118;
        r213 = r113;
        r49 = r115;
        r211 = r116;
        goto L102
    L85:
        r210 = r33;
        goto L86
    L113:
        r21 = r21;
        r210 = r33;
        r20 = r20;
        r212 = r118;
        r213 = r113;
        r49 = r115;
        r211 = r116;
    L65:
        r120 = r5;
        goto L70
    L175:
        throw new IllegalArgumentException("startYear > endYear");
    L177:
        throw new IllegalArgumentException("endYear > 9999");
    L179:
        throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
    L181:
        throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
    L183:
        throw new IllegalArgumentException("endYear < 1");
    L185:
        throw new IllegalArgumentException("startYear < 1");
    L187:
        throw new ParseException(j0.h(r24, "Unknown error at line ", "."), r24);
    L189:
        throw new ParseException(j0.h(r24, "End month is not properly set at line ", "."), r24);
    L191:
        throw new ParseException(j0.h(r24, "End year is not properly set at line ", "."), r24);
    L193:
        throw new ParseException(j0.h(r24, "End year/month has incorrect format at line ", "."), r24);
    L195:
        throw new ParseException(j0.h(r24, "Start month is not properly set at line ", "."), r24);
    L197:
        throw new ParseException(j0.h(r24, "Start year is not properly set at line ", "."), r24);
    L199:
        throw new ParseException(j0.h(r24, "Start year/month has incorrect format at line ", "."), r24);
    L201:
        throw new ParseException(j0.h(r24, "Start and end year/month has incorrect format at line ", "."), r24);
    L203:
        throw new ParseException(j0.h(r24, "Offset is not properly set at line ", "."), r24);
    L205:
        throw new ParseException(j0.h(r24, "Offset has incorrect format at line ", "."), r24);
    }

    public static void j() {
        String r5 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (r5 != null) goto L5;
        r5 = "hijrah_deviation.cfg";
    L5:
        String r10 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        BufferedReader r11 = null;
        char r12 = f21146q;
        if (r10 != null) goto L8;
        StringTokenizer r13 = new StringTokenizer(System.getProperty("java.class.path"), f21147r);
    L18:
        if (r13.hasMoreTokens() == false) goto L15;
        String r14 = r13.nextToken();
        File r15 = new File(r14);
        if (r15.exists() == false) goto L18;
        boolean r16 = r15.isDirectory();
        String r17 = s;
        if (r16 == true) goto L24;
        ZipFile r18 = new ZipFile(r15);     // Catch: IOException -> L28
    L29:
        if (r18 == null) goto L18;
        String r19 = androidx.constraintlayout.motion.widget.a.m(r17, r12, r5);
        ZipEntry r20 = r18.getEntry(r19);
        if (r20 == null) goto L33;
    L38:
        if (r20 == null) goto L18;
        InputStream r21 = r18.getInputStream(r20);
    L40:
        if (r21 != null) goto L57;
        return;
    L57:
        BufferedReader r22 = new BufferedReader(new InputStreamReader(r21));     // Catch: Throwable -> L50
        int r23 = 0;
    L55:
        String r24 = r22.readLine();     // Catch: Throwable -> L47
        if (r24 == null) goto L49;
        r23 = r23 + 1;     // Catch: Throwable -> L47
        i(r23, r24.trim());     // Catch: Throwable -> L47
        goto L55
    L49:
        r22.close();
        return;
    L47:
        th = th;
        r11 = r22;
    L51:
        if (r11 == null) goto L53;
        r11.close();
    L53:
        throw th;
    L50:
        th = th;
        goto L51
    L33:
        if (r12 != '/') goto L35;
        r19 = r19.replace('/', '\\');
    L37:
        r20 = r18.getEntry(r19);
        goto L38
    L35:
        if (r12 != '\\') goto L37;
        r19 = r19.replace('\\', '/');
    L28:
        r18 = null;
        goto L29
    L24:
        if (new File(androidx.constraintlayout.motion.widget.a.m(r14, r12, r17), r5).exists() == false) goto L18;
        r21 = new FileInputStream(r14 + r12 + r17 + r12 + r5);
    L15:
        r21 = null;
        goto L40
    L8:
        if (r10.length() == 0) goto L10;
    L11:
        StringBuilder r25 = j0.u(r10);
        r25.append(System.getProperty("file.separator"));
        r10 = r25.toString();
    L12:
        File r26 = new File(androidx.constraintlayout.motion.widget.a.m(r10, r12, r5));
        if (r26.exists() == false) goto L15;
        r21 = new FileInputStream(r26);
        goto L40
    L10:
        if (r10.endsWith(System.getProperty("file.separator")) == true) goto L12;
        goto L11
    }

    public static HijrahDate k(int r5, int r10, int r11) {
        int r12 = c(r5)[r10 - 1].intValue();
        if (r11 <= r12) goto L6;
        r11 = r12;
    L6:
        return of(r5, r10, r11);
    }

    public static HijrahDate now() {
        return now(org.threeten.bp.a.systemDefaultZone());
    }

    public static HijrahDate of(int r5, int r10, int r11) {
        if (r5 < 1) goto L6;
        return of(HijrahEra.AH, r5, r10, r11);
    L6:
        return of(HijrahEra.BEFORE_AH, 1 - r5, r10, r11);
    }

    public static HijrahDate ofEpochDay(long r5) {
        return new HijrahDate(r5);
    }

    public static b readExternal(DataInput r5) throws IOException {
        int r10 = r5.readInt();
        byte r11 = r5.readByte();
        byte r12 = r5.readByte();
        return HijrahChronology.INSTANCE.date(r10, r11, r12);
    }

    private Object readResolve() {
        return new HijrahDate(this.gregorianEpochDay);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b
    public final c atTime(LocalTime r5) {
        return super.atTime(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ i getChronology() {
        return getChronology();
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ j getEra() {
        return getEra();
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r10) {
        if ((r10 instanceof ChronoField) == false) goto L33;
        int r5 = k.f21177a[((ChronoField) r10).ordinal()];
        int r11 = this.f21156c;
        int r12 = this.e;
        int r13 = this.f;
        switch(r5) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r10));
    L9:
        return this.f21155b.getValue();
    L11:
        return r11;
    L13:
        return this.d;
    L15:
        return j0.c(r13, 1, 7, 1);
    L17:
        return toEpochDay();
    L19:
        return ((r13 - 1) % 7) + 1;
    L21:
        return ((r12 - 1) % 7) + 1;
    L23:
        return this.g.getValue();
    L25:
        return r11;
    L27:
        return j0.c(r12, 1, 7, 1);
    L29:
        return r13;
    L31:
        return r12;
    L33:
        return r10.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean isLeapYear() {
        return this.f21157h;
    }

    @Override // org.threeten.bp.chrono.b
    public int lengthOfMonth() {
        return getMonthLength(this.d - 1, this.f21156c);
    }

    @Override // org.threeten.bp.chrono.b
    public int lengthOfYear() {
        return getYearLength(this.f21156c);
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ ChronoDateImpl plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusDays(long r5) {
        return plusDays(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusMonths(long r5) {
        return plusMonths(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusYears(long r5) {
        return plusYears(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L27;
        if (isSupported(r5) == false) goto L25;
        ChronoField r10 = (ChronoField) r5;
        int r11 = k.f21177a[r10.ordinal()];
        if (r11 == 1) goto L23;
        if (r11 == 2) goto L21;
        if (r11 == 3) goto L19;
        if (r11 == 4) goto L17;
        return getChronology().range(r10);
    L17:
        return ValueRange.of(1, 1000);
    L19:
        return ValueRange.of(1, 5);
    L21:
        return ValueRange.of(1, lengthOfYear());
    L23:
        return ValueRange.of(1, lengthOfMonth());
    L25:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L27:
        return r5.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.b
    public long toEpochDay() {
        int r5 = this.d;
        int r10 = this.e;
        return f(this.f21156c, r5, r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        return super.until(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeInt(get(ChronoField.YEAR));
        r5.writeByte(get(ChronoField.MONTH_OF_YEAR));
        r5.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public static boolean isLeapYear(long r5) {
        if (r5 > 0) goto L7;
        r5 = -r5;
    L7:
        if ((((r5 * 11) + 14) % 30) >= 11) goto L9;
        return true;
    L9:
        return false;
    }

    public static HijrahDate now(ZoneId r5) {
        return now(org.threeten.bp.a.system(r5));
    }

    public static HijrahDate of(HijrahEra r5, int r10, int r11, int r12) {
        jm.c.p(r5, "era");
        if (r10 < 1) goto L14;
        if (r10 > 9999) goto L14;
        if (r11 < 1) goto L12;
        if (r11 > 12) goto L12;
        a(r12);
        return new HijrahDate(f(r5.prolepticYear(r10), r11, r12));
    L12:
        throw new DateTimeException("Invalid month of Hijrah date");
    L14:
        throw new DateTimeException("Invalid year of Hijrah Era");
    }

    @Override // org.threeten.bp.chrono.b
    public HijrahChronology getChronology() {
        return HijrahChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.b
    public HijrahEra getEra() {
        return this.f21155b;
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ b minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public HijrahDate plusDays(long r5) {
        return new HijrahDate(this.gregorianEpochDay + r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public HijrahDate plusMonths(long r5) {
        if (r5 != 0) goto L5;
        return this;
    L5:
        int r10 = (this.d - 1) + ((int) r5);
        int r11 = r10 / 12;
        int r12 = r10 % 12;
    L6:
        if (r12 >= 0) goto L8;
        r12 = r12 + 12;
        r11 = jm.c.v(r11, 1);
        goto L6
    L8:
        int r13 = this.e;
        HijrahEra r14 = this.f21155b;
        return of(r14, jm.c.q(this.f21156c, r11), r12 + 1, r13);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public HijrahDate plusYears(long r5) {
        if (r5 != 0) goto L5;
        return this;
    L5:
        int r10 = jm.c.q(this.f21156c, (int) r5);
        int r11 = this.d;
        int r12 = this.e;
        return of(this.f21155b, r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ e until(b r5) {
        return super.until(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static HijrahDate now(org.threeten.bp.a r5) {
        return HijrahChronology.INSTANCE.dateNow(r5);
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ b plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    @Override // org.threeten.bp.chrono.b
    /* JADX INFO: renamed from: minus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1648minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public HijrahDate minus(org.threeten.bp.temporal.f r5) {
        return (HijrahDate) super.minus(r5);
    }

    @Override // org.threeten.bp.chrono.b
    /* JADX INFO: renamed from: plus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1649plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public HijrahDate with(org.threeten.bp.temporal.e r5) {
        return (HijrahDate) super.with(r5);
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public HijrahDate minus(long r5, org.threeten.bp.temporal.j r10) {
        return (HijrahDate) super.minus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public HijrahDate plus(org.threeten.bp.temporal.f r5) {
        return (HijrahDate) super.plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public HijrahDate with(org.threeten.bp.temporal.g r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L36;
        ChronoField r5 = (ChronoField) r10;
        r5.checkValidValue(r11);
        int r12 = (int) r11;
        int r13 = k.f21177a[r5.ordinal()];
        int r14 = this.e;
        int r15 = this.d;
        int r16 = this.f21156c;
        switch(r13) {
            case 1: goto L34;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            default: goto L7;
        };
    L24:
        if (r16 >= 1) goto L28;
        r12 = 1 - r12;
    L28:
        return k(r12, r15, r14);
    L31:
        int r17 = r12 - 1;
        return k(r16, (r17 / 30) + 1, (r17 % 30) + 1);
    L7:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r10));
    L9:
        return k(1 - r16, r15, r14);
    L11:
        return k(r12, r15, r14);
    L13:
        return k(r16, r12, r14);
    L15:
        return plusDays((r11 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
    L17:
        return new HijrahDate(r12);
    L19:
        return plusDays(r11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
    L21:
        return plusDays(r11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
    L23:
        return plusDays(r11 - ((long) this.g.getValue()));
    L30:
        return plusDays((r11 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
    L34:
        return k(r16, r15, r12);
    L36:
        return (HijrahDate) r10.adjustInto(this, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public HijrahDate plus(long r5, org.threeten.bp.temporal.j r10) {
        return (HijrahDate) super.plus(r5, r10);
    }

    public static HijrahDate of(LocalDate r5) {
        return new HijrahDate(r5.toEpochDay());
    }
}
