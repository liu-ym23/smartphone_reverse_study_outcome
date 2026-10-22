package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f21110b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f21111c = null;
    public static final s d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21112a;

    static {
        f21110b = new s(0);
        f21111c = new s(1);
        d = new s(2);
    }

    public /* synthetic */ s(int r5) {
        this.f21112a = r5;
    }

    @Override // org.sqlite.date.l
    public final int a() {
        switch(this.f21112a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return 2;
    L6:
        return 2;
    L8:
        return 2;
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        switch(this.f21112a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        c(r10, r5.get(2) + 1);
        return;
    L6:
        FastDatePrinter.access$000(r10, r5.get(1) % 100);
        return;
    L8:
        FastDatePrinter.access$000(r10, r5.get(2) + 1);
    }

    @Override // org.sqlite.date.j
    public final void c(StringBuffer r5, int r10) {
        switch(this.f21112a) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L5;
        };
    L9:
        FastDatePrinter.access$000(r5, r10);
        return;
    L11:
        FastDatePrinter.access$000(r5, r10);
        return;
    L5:
        if (r10 >= 10) goto L7;
        r5.append((char) (r10 + 48));
        return;
    L7:
        FastDatePrinter.access$000(r5, r10);
    }
}
