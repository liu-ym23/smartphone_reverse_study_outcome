package com.obric.oui.calendar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes5.dex */
class h extends b {
    private int c;

    public h(MaterialCalendarView r1, CalendarDay r2, DayOfWeek r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    private int i() {
        return b(h().getDate(), b(), MaterialCalendarView.a(this.f13437a));
    }

    @Override // com.obric.oui.calendar.b
    public boolean a(CalendarDay r1) {
        if (r1.getMonth() != g().getMonth()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.calendar.b
    public void b(Collection<DayView> r6, LocalDate r7) {
        Collection<DayView> r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        this.c = i();
        int r1 = 0;
    L4:
        if (r1 >= this.c) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= 7) goto L9;
        a(r8, r7);
        r7 = r7.plusDays(1);
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.b
    public int f() {
        boolean r0 = this.f13438b;
        int r1 = this.c;
        if (r0 == true) goto L5;
        return r1;
    L5:
        return r1 + 1;
    }

    public CalendarDay h() {
        return g();
    }
}
