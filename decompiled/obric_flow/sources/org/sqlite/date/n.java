package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f21098b;

    public n(int r5, String[] r10) {
        this.f21097a = r5;
        this.f21098b = r10;
    }

    @Override // org.sqlite.date.l
    public final int a() {
        String[] r5 = this.f21098b;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        r10 = r10 - 1;
        if (r10 < 0) goto L8;
        int r12 = r5[r10].length();
        if (r12 <= r11) goto L3;
        r11 = r12;
        goto L3
    L8:
        return r11;
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        int r11 = r5.get(this.f21097a);
        r10.append(this.f21098b[r11]);
    }
}
