package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class o extends b {
    public o(@NonNull MaterialCalendarView r10, CalendarDay r11, DayOfWeek r12, boolean r13) {
        super(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.calendar.b
    protected void b(Collection<DayView> r10, LocalDate r11) {
        int r12 = 0;
    L4:
        if (r12 >= 7) goto L6;
        a(r10, r11);
        r11 = r11.plusDays(1);
        r12 = r12 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.b
    protected int h() {
        if (this.f6344n == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // com.obric.oui.calendar.b
    protected boolean j(CalendarDay r10) {
        return true;
    }
}
