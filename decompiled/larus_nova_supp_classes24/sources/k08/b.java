package k08;

import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.datepicker.impl.data.MonthShowMode;
import com.larksuite.component.universe_design.util.CalendarDate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements p08.b {
    public final /* synthetic */ UDDatePicker a;

    @Override // p08.b
    public final CalendarDate a() {
        return new CalendarDate();
    }

    @Override // p08.b
    public final MonthShowMode b() {
        return this.a.e;
    }

    @Override // p08.b
    public final CalendarDate.DayOfWeek c() {
        return this.a.f;
    }

    @Override // p08.b
    public final CalendarDate getSelectedDate() {
        return this.a.c;
    }

    public b(UDDatePicker r1) {
        this.a = r1;
    }
}
