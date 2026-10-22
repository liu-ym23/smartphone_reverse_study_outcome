package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21080b;

    public /* synthetic */ b(int r5, int r10) {
        this.f21080b = r10;
        super(r5);
    }

    @Override // org.sqlite.date.e, org.sqlite.date.f
    public void c(FastDateParser r5, Calendar r10, String r11) {
        switch(this.f21080b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.c(r5, r10, r11);
        return;
    L6:
        int r12 = Integer.parseInt(r11);
        if (r12 >= 100) goto L9;
        r12 = FastDateParser.access$300(r5, r12);
    L9:
        r10.set(1, r12);
    }

    @Override // org.sqlite.date.e
    public int d(int r5) {
        switch(this.f21080b) {
            case 1: goto L14;
            case 2: goto L10;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return r5;
    L6:
        if (r5 != 12) goto L15;
        return 0;
    L15:
        return r5;
    L10:
        if (r5 != 24) goto L16;
        return 0;
    L16:
        return r5;
    L14:
        return r5 - 1;
    }
}
