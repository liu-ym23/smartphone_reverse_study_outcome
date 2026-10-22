package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21114b;

    public /* synthetic */ t(int r5, int r10) {
        this.f21113a = r10;
        this.f21114b = r5;
    }

    @Override // org.sqlite.date.l
    public final int a() {
        switch(this.f21113a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return 4;
    L6:
        return 2;
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        switch(this.f21113a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        c(r10, r5.get(this.f21114b));
        return;
    L6:
        c(r10, r5.get(this.f21114b));
    }

    @Override // org.sqlite.date.j
    public final void c(StringBuffer r5, int r10) {
        switch(this.f21113a) {
            case 0: goto L13;
            default: goto L5;
        };
    L5:
        if (r10 >= 10) goto L8;
        r5.append((char) (r10 + 48));
        return;
    L8:
        if (r10 >= 100) goto L10;
        FastDatePrinter.access$000(r5, r10);
        return;
    L10:
        r5.append(r10);
        return;
    L13:
        if (r10 >= 100) goto L15;
        FastDatePrinter.access$000(r5, r10);
        return;
    L15:
        r5.append(r10);
    }
}
