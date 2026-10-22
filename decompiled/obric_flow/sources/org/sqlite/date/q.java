package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f21105c = null;
    public static final q d = null;
    public static final q e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21107b;

    static {
        f21105c = new q(true, false);
        d = new q(false, false);
        e = new q(true, true);
    }

    public q(boolean r5, boolean r10) {
        this.f21106a = r5;
        this.f21107b = r10;
    }

    @Override // org.sqlite.date.l
    public final int a() {
        return 5;
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        if (this.f21107b == true) goto L5;
    L8:
        int r11 = r5.get(15);
        int r12 = r5.get(16) + r11;
        if (r12 >= 0) goto L11;
        r10.append('-');
        r12 = -r12;
    L12:
        int r13 = r12 / 3600000;
        FastDatePrinter.access$000(r10, r13);
        if (this.f21106a == false) goto L15;
        r10.append(':');
    L15:
        FastDatePrinter.access$000(r10, (r12 / 60000) - (r13 * 60));
        return;
    L11:
        r10.append('+');
        goto L12
    L5:
        if (r5.getTimeZone().getID().equals("UTC") == false) goto L8;
        r10.append("Z");
    }
}
