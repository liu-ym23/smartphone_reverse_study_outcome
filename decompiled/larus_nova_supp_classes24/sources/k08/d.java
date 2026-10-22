package k08;

import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements p08.c {
    public final /* synthetic */ UDDatePicker a;

    @Override // p08.c
    public final void a() {
        UDDatePicker r0 = this.a;
        int r1 = UDDatePicker.h;
        r0.e();
    }

    @Override // p08.c
    public final void b() {
        UDDatePicker r0 = this.a;
        int r1 = UDDatePicker.h;
        r0.e();
    }

    public d(UDDatePicker r1) {
        this.a = r1;
    }

    @Override // p08.c
    public final void c(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "selectDate");
        UDDatePicker.a(this.a, r2);
    }
}
