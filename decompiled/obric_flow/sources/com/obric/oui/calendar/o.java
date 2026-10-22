package com.obric.oui.calendar;

import java.util.ArrayList;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12288k;

    @Override // com.obric.oui.calendar.d
    public final void b(ArrayList r10, LocalDate r11) {
        LocalDate r5 = this.f.f12167a;
        boolean r12 = true;
        if ((this.d & 1) != 0) goto L6;
        r12 = false;
    L6:
        this.f12288k = (int) ((ChronoUnit.DAYS.between(d.c(r5, this.f12257c, r12), r5.withDayOfMonth(r5.lengthOfMonth())) + 7) / 7);
        int r13 = 0;
    L8:
        if (r13 >= this.f12288k) goto L14;
        int r14 = 0;
    L11:
        if (r14 >= 7) goto L13;
        a(r10, r11);
        r11 = r11.plusDays(1);
        r14 = r14 + 1;
        goto L11
    L13:
        r13 = r13 + 1;
        goto L8
    }

    @Override // com.obric.oui.calendar.d
    public final int d() {
        boolean r5 = this.f12259i;
        int r10 = this.f12288k;
        if (r5 == true) goto L5;
        return r10;
    L5:
        return r10 + 1;
    }

    @Override // com.obric.oui.calendar.d
    public final boolean e(CalendarDay r5) {
        if (r5.f12167a.getMonthValue() != this.f.f12167a.getMonthValue()) goto L5;
        return true;
    L5:
        return false;
    }
}
