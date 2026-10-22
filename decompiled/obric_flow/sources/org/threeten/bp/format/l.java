package org.threeten.bp.format;

import ai.j0;
import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f21223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char f21225c;

    public l(g r5, int r10, char r11) {
        this.f21223a = r5;
        this.f21224b = r10;
        this.f21225c = r11;
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r10, CharSequence r11, int r12) {
        boolean r5 = r10.e;
        boolean r13 = r10.d;
        if (r12 > r11.length()) goto L29;
        if (r12 == r11.length()) goto L7;
        int r14 = this.f21224b + r12;
        if (r14 <= r11.length()) goto L14;
        if (r5 == true) goto L12;
        r14 = r11.length();
        goto L14
    L12:
        return ~r12;
    L14:
        int r15 = r12;
    L15:
        if (r15 >= r14) goto L23;
        char r16 = this.f21225c;
        char r17 = r11.charAt(r15);
        if (r13 == false) goto L21;
        if (r17 != r16) goto L23;
    L22:
        r15 = r15 + 1;
        goto L15
    L21:
        if (r10.a(r17, r16) == true) goto L22;
    L23:
        CharSequence r18 = r11.subSequence(0, r14);
        int r19 = this.f21223a.parse(r10, r18, r15);
        if (r19 == r14) goto L35;
        if (r5 == true) goto L27;
        return r19;
    L27:
        return ~(r12 + r15);
    L35:
        return r19;
    L7:
        return ~r12;
    L29:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r5, StringBuilder r10) {
        int r11 = r10.length();
        int r12 = 0;
        if (this.f21223a.print(r5, r10) == true) goto L5;
        return false;
    L5:
        int r13 = r10.length() - r11;
        int r14 = this.f21224b;
        if (r13 > r14) goto L13;
    L8:
        if (r12 >= (r14 - r13)) goto L10;
        r10.insert(r11, this.f21225c);
        r12 = r12 + 1;
        goto L8
    L10:
        return true;
    L13:
        throw new DateTimeException(j0.f(r13, r14, "Cannot print as output of ", " characters exceeds pad width of "));
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Pad(");
        r5.append(this.f21223a);
        r5.append(",");
        r5.append(this.f21224b);
        char r10 = this.f21225c;
        if (r10 != ' ') goto L5;
        String r11 = ")";
    L6:
        r5.append(r11);
        return r5.toString();
    L5:
        r11 = ",'" + r10 + "')";
        goto L6
    }
}
