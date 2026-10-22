package org.threeten.bp.format;

import androidx.room.writer.DaoWriter;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f21220c = null;
    public static final k d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21222b;

    static {
        f21220c = new String[]{"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        d = new k("Z", "+HH:MM:ss");
    }

    public k(String r5, String r10) {
        jm.c.p(r10, "pattern");
        this.f21221a = r5;
        int r11 = 0;
    L3:
        String[] r12 = f21220c;
        if (r11 >= 9) goto L11;
        if (r12[r11].equals(r10) == true) goto L7;
        r11 = r11 + 1;
        goto L3
    L7:
        this.f21222b = r11;
        return;
    L11:
        throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(r10));
    }

    public final boolean a(int[] r5, int r10, CharSequence r11, boolean r12) {
        int r13 = this.f21222b;
        if (((r13 + 3) / 2) >= r10) goto L5;
        return false;
    L5:
        int r14 = r5[0];
        if ((r13 % 2) == 0) goto L8;
    L16:
        int r15 = r14 + 2;
        if (r15 <= r11.length()) goto L19;
        return r12;
    L19:
        int r16 = r14 + 1;
        char r17 = r11.charAt(r14);
        char r18 = r11.charAt(r16);
        if (r17 >= '0') goto L22;
    L33:
        return r12;
    L22:
        if (r17 > '9') goto L33;
        if (r18 < '0') goto L33;
        if (r18 > '9') goto L33;
        int r19 = r18 - '0';
        int r20 = r19 + ((r17 - '0') * 10);
        if (r20 < 0) goto L33;
        if (r20 > 59) goto L33;
        r5[r10] = r20;
        r5[0] = r15;
        return false;
    L8:
        if (r10 <= 1) goto L16;
        int r21 = r14 + 1;
        if (r21 <= r11.length()) goto L12;
    L15:
        return r12;
    L12:
        if (r11.charAt(r14) != ':') goto L15;
        r14 = r21;
        goto L16
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r16, CharSequence r17, int r18) {
        int r5 = r17.length();
        int r10 = this.f21221a.length();
        if (r10 != 0) goto L7;
        if (r18 == r5) goto L6;
    L14:
        char r11 = r17.charAt(r18);
        if (r11 == '+') goto L18;
        if (r11 == '-') goto L18;
    L34:
        if (r10 != 0) goto L38;
        return r16.e(ChronoField.OFFSET_SECONDS, 0, r18, r18 + r10);
    L38:
        return ~r18;
    L18:
        if (r11 != '-') goto L20;
        int r12 = -1;
    L21:
        int[] r13 = new int[4];
        r13[0] = r18 + 1;
        if (a(r13, 1, r17, true) == true) goto L34;
        if (this.f21222b < 3) goto L26;
        boolean r14 = true;
    L28:
        if (a(r13, 2, r17, r14) == true) goto L34;
        if (a(r13, 3, r17, false) == true) goto L34;
        return r16.e(ChronoField.OFFSET_SECONDS, (((((long) r13[2]) * 60) + (((long) r13[1]) * 3600)) + ((long) r13[3])) * ((long) r12), r18, r13[0]);
    L26:
        r14 = false;
        goto L28
    L20:
        r12 = 1;
        goto L21
    L6:
        return r16.e(ChronoField.OFFSET_SECONDS, 0, r18, r18);
    L7:
        if (r18 != r5) goto L11;
        return ~r18;
    L11:
        if (r16.f(r17, r18, this.f21221a, 0, r10) == false) goto L14;
        return r16.e(ChronoField.OFFSET_SECONDS, 0, r18, r18 + r10);
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r10, StringBuilder r11) {
        Long r12 = r10.a(ChronoField.OFFSET_SECONDS);
        if (r12 != null) goto L6;
        return false;
    L6:
        int r13 = jm.c.x(r12.longValue());
        String r5 = this.f21221a;
        if (r13 != 0) goto L9;
        r11.append(r5);
    L31:
        return true;
    L9:
        int r14 = Math.abs((r13 / 3600) % 100);
        int r15 = Math.abs((r13 / 60) % 60);
        int r16 = Math.abs(r13 % 60);
        int r17 = r11.length();
        if (r13 >= 0) goto L12;
        String r18 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
    L13:
        r11.append(r18);
        r11.append((char) ((r14 / 10) + 48));
        r11.append((char) ((r14 % 10) + 48));
        int r19 = this.f21222b;
        if (r19 >= 3) goto L17;
        if (r19 < 1) goto L29;
        if (r15 > 0) goto L17;
    L29:
        if (r14 != 0) goto L31;
        r11.setLength(r17);
        r11.append(r5);
    L17:
        int r110 = r19 % 2;
        String r20 = "";
        if (r110 != 0) goto L20;
        String r21 = ":";
    L21:
        r11.append(r21);
        r11.append((char) ((r15 / 10) + 48));
        r11.append((char) ((r15 % 10) + 48));
        r14 = r14 + r15;
        if (r19 < 7) goto L24;
    L26:
        if (r110 != 0) goto L28;
        r20 = ":";
    L28:
        r11.append(r20);
        r11.append((char) ((r16 / 10) + 48));
        r11.append((char) ((r16 % 10) + 48));
        r14 = r14 + r16;
        goto L29
    L24:
        if (r19 < 5) goto L29;
        if (r16 <= 0) goto L29;
    L20:
        r21 = "";
        goto L21
    L12:
        r18 = "+";
        goto L13
    }

    public final String toString() {
        String r5 = this.f21221a.replace("'", "''");
        return androidx.constraintlayout.motion.widget.a.u(new StringBuilder("Offset("), f21220c[this.f21222b], ",'", r5, "')");
    }
}
