package org.apache.commons.lang3.time;

import ai.j0;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
class GmtTimeZone extends TimeZone {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20966b;

    public GmtTimeZone(boolean r5, int r10, int r11) {
        if (r10 >= 24) goto L18;
        if (r11 >= 60) goto L16;
        int r12 = ((r10 * 60) + r11) * 60000;
        if (r5 == false) goto L9;
        r12 = -r12;
    L9:
        this.f20965a = r12;
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.x(9, "GMT");
        if (r5 == false) goto L12;
        char r14 = '-';
    L13:
        r13.append(r14);
        r13.append((char) ((r10 / 10) + 48));
        r13.append((char) ((r10 % 10) + 48));
        r13.append(':');
        r13.append((char) ((r11 / 10) + 48));
        r13.append((char) ((r11 % 10) + 48));
        this.f20966b = r13.toString();
        return;
    L12:
        r14 = '+';
        goto L13
    L16:
        throw new IllegalArgumentException(r11 + " minutes out of range");
    L18:
        throw new IllegalArgumentException(r10 + " hours out of range");
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof GmtTimeZone) == true) goto L6;
        return false;
    L6:
        if (this.f20966b != ((GmtTimeZone) r5).f20966b) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.util.TimeZone
    public final String getID() {
        return this.f20966b;
    }

    @Override // java.util.TimeZone
    public final int getOffset(int r5, int r10, int r11, int r12, int r13, int r14) {
        return this.f20965a;
    }

    @Override // java.util.TimeZone
    public final int getRawOffset() {
        return this.f20965a;
    }

    public final int hashCode() {
        return this.f20965a;
    }

    @Override // java.util.TimeZone
    public final boolean inDaylightTime(Date r5) {
        return false;
    }

    @Override // java.util.TimeZone
    public final void setRawOffset(int r5) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("[GmtTimeZone id=\"");
        r5.append(this.f20966b);
        r5.append("\",offset=");
        return j0.n(r5, this.f20965a, ']');
    }

    @Override // java.util.TimeZone
    public final boolean useDaylightTime() {
        return false;
    }
}
