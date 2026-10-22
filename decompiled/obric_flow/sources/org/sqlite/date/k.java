package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21095b;

    public k(int r5, int r10) {
        if (r10 < 3) goto L7;
        this.f21094a = r5;
        this.f21095b = r10;
        return;
    L7:
        throw new IllegalArgumentException();
    }

    @Override // org.sqlite.date.l
    public final int a() {
        return this.f21095b;
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        c(r10, r5.get(this.f21094a));
    }

    @Override // org.sqlite.date.j
    public final void c(StringBuffer r5, int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f21095b) goto L6;
        r5.append('0');
        r11 = r11 + 1;
        goto L4
    L6:
        int r12 = r5.length();
    L7:
        if (r10 <= 0) goto L9;
        r12 = r12 - 1;
        r5.setCharAt(r12, (char) ((r10 % 10) + 48));
        r10 = r10 / 10;
        goto L7
    }
}
