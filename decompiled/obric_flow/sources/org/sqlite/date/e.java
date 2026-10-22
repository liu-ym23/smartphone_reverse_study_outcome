package org.sqlite.date;

import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21087a;

    public e(int r5) {
        this.f21087a = r5;
    }

    @Override // org.sqlite.date.f
    public final boolean a(FastDateParser r5, StringBuilder r10) {
        if (r5.isNextNumber() == false) goto L5;
        r10.append("(\\p{Nd}{");
        r10.append(r5.getFieldWidth());
        r10.append("}+)");
        return true;
    L5:
        r10.append("(\\p{Nd}++)");
        return true;
    }

    @Override // org.sqlite.date.f
    public final boolean b() {
        return true;
    }

    @Override // org.sqlite.date.f
    public void c(FastDateParser r5, Calendar r10, String r11) {
        int r12 = d(Integer.parseInt(r11));
        r10.set(this.f21087a, r12);
    }

    public int d(int r5) {
        return r5;
    }
}
