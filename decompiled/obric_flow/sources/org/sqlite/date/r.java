package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f21109b;

    public /* synthetic */ r(j r5, int r10) {
        this.f21108a = r10;
        this.f21109b = r5;
    }

    @Override // org.sqlite.date.l
    public final int a() {
        switch(this.f21108a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f21109b.a();
    L7:
        return this.f21109b.a();
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        switch(this.f21108a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        int r11 = r5.get(11);
        if (r11 != 0) goto L7;
        r11 = r5.getMaximum(11) + 1;
    L7:
        this.f21109b.c(r10, r11);
        return;
    L9:
        int r12 = r5.get(10);
        if (r12 != 0) goto L12;
        r12 = r5.getLeastMaximum(10) + 1;
    L12:
        this.f21109b.c(r10, r12);
    }

    @Override // org.sqlite.date.j
    public final void c(StringBuffer r5, int r10) {
        switch(this.f21108a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f21109b.c(r5, r10);
        return;
    L6:
        this.f21109b.c(r5, r10);
    }
}
