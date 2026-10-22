package org.apache.commons.lang3.time;

import java.text.ParsePosition;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class i extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20972a;

    public i(int r5) {
        this.f20972a = r5;
    }

    @Override // org.apache.commons.lang3.time.k
    public final boolean a() {
        return true;
    }

    @Override // org.apache.commons.lang3.time.k
    public final boolean b(FastDateParser r5, Calendar r10, String r11, ParsePosition r12, int r13) {
        int r14 = r12.getIndex();
        int r15 = r11.length();
        if (r13 != 0) goto L10;
    L4:
        if (r14 >= r15) goto L9;
        if (Character.isWhitespace(r11.charAt(r14)) == false) goto L9;
        r14 = r14 + 1;
    L9:
        r12.setIndex(r14);
    L13:
        if (r14 >= r15) goto L19;
        if (Character.isDigit(r11.charAt(r14)) == false) goto L19;
        r14 = r14 + 1;
    L19:
        if (r12.getIndex() != r14) goto L22;
        r12.setErrorIndex(r14);
        return false;
    L22:
        int r16 = Integer.parseInt(r11.substring(r12.getIndex(), r14));
        r12.setIndex(r14);
        r10.set(this.f20972a, c(r5, r16));
        return true;
    L10:
        int r17 = r13 + r14;
        if (r15 <= r17) goto L13;
        r15 = r17;
        goto L13
    }

    public int c(FastDateParser r5, int r10) {
        return r10;
    }
}
