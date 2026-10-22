package org.sqlite.date;

import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeZone f21099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Locale f21101c;

    public o(TimeZone r5, boolean r10, int r11, Locale r12) {
        this.f21099a = r5;
        if (r10 == false) goto L5;
        this.f21100b = Integer.MIN_VALUE | r11;
    L6:
        this.f21101c = r12;
        return;
    L5:
        this.f21100b = r11;
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == false) goto L16;
        o r10 = (o) r5;
        TimeZone r11 = r10.f21099a;
        if (this.f21099a.equals(r11) == false) goto L15;
        if (this.f21100b != r10.f21100b) goto L15;
        if (this.f21101c.equals(r10.f21101c) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public final int hashCode() {
        int r5 = this.f21100b * 31;
        int r10 = (this.f21101c.hashCode() + r5) * 31;
        return this.f21099a.hashCode() + r10;
    }
}
