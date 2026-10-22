package m08;

import com.larksuite.component.universe_design.datepicker.impl.MonthCalendarViewAdapter;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;
import p08.d;
import p08.e;
import q08.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements e {
    public final /* synthetic */ MonthCalendarViewAdapter a;

    @Override // p08.e
    public final void b() {
        MonthCalendarViewAdapter r0 = this.a;
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L10;
        c r2 = (c) r0.g(r1);
        if (r2 == null) goto L9;
        r2.setSelectDate(r0.d.getSelectedDate());
        r2.a();
    L9:
        r1 = r1 + 1;
        goto L4
    L10:
        r0.getClass();
    }

    public a(MonthCalendarViewAdapter r1) {
        this.a = r1;
    }

    @Override // p08.e
    public final void a(int r2) {
        d r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // p08.e
    public final void c(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "selectDate");
        d r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
