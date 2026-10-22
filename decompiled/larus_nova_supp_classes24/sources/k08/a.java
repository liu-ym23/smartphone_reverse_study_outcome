package k08;

import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements MonthPickerDefaultHead.a {
    public final /* synthetic */ UDDatePicker a;

    @Override // com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead.a
    public final void a() {
        CalendarDate r0 = new CalendarDate(this.a.c);
        int[] r1 = com.larksuite.component.universe_design.util.a.a;
        Intrinsics.checkNotNullParameter(r0, "selectDate");
        CalendarDate r2 = r0.modifyMonth(-1);
        r2.setMonthDay(1);
        CalendarDate r3 = r2.moveToDayStart();
        UDDatePicker r4 = this.a;
        r4.c = r3;
        r4.c();
        this.a.b();
        this.a.g.d.h(-1);
    }

    @Override // com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead.a
    public final void b() {
        CalendarDate r0 = new CalendarDate(this.a.c);
        int[] r1 = com.larksuite.component.universe_design.util.a.a;
        Intrinsics.checkNotNullParameter(r0, "selectDate");
        CalendarDate r2 = r0.modifyMonth(1);
        r2.setMonthDay(1);
        CalendarDate r3 = r2.moveToDayStart();
        UDDatePicker r4 = this.a;
        r4.c = r3;
        r4.c();
        this.a.b();
        this.a.g.d.h(1);
    }

    public a(UDDatePicker r1) {
        this.a = r1;
    }
}
