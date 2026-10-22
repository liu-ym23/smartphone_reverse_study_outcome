package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f21091b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f21092c = null;
    public static final i d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21093a;

    static {
        f21091b = new i(3);
        f21092c = new i(5);
        d = new i(6);
    }

    public i(int r5) {
        this.f21093a = r5;
    }

    @Override // org.sqlite.date.l
    public final int a() {
        return this.f21093a;
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        int r11 = r5.get(15);
        if (r11 != 0) goto L6;
        r10.append("Z");
        return;
    L6:
        int r12 = r5.get(16) + r11;
        if (r12 >= 0) goto L9;
        r10.append('-');
        r12 = -r12;
    L10:
        int r13 = r12 / 3600000;
        FastDatePrinter.access$000(r10, r13);
        int r14 = this.f21093a;
        if (r14 >= 5) goto L14;
        return;
    L14:
        if (r14 != 6) goto L16;
        r10.append(':');
    L16:
        FastDatePrinter.access$000(r10, (r12 / 60000) - (r13 * 60));
        return;
    L9:
        r10.append('+');
        goto L10
    }
}
