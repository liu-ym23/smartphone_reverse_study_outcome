package com.obric.oui.calendar;

import java.util.ArrayList;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends d {
    @Override // com.obric.oui.calendar.d
    public final void b(ArrayList r5, LocalDate r10) {
        int r11 = 0;
    L4:
        if (r11 >= 7) goto L6;
        a(r5, r10);
        r10 = r10.plusDays(1);
        r11 = r11 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.d
    public final int d() {
        if (this.f12259i == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // com.obric.oui.calendar.d
    public final boolean e(CalendarDay r5) {
        return true;
    }
}
