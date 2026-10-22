package k08;

import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements p08.d {
    public final /* synthetic */ UDDatePicker a;

    public c(UDDatePicker r1) {
        this.a = r1;
    }

    @Override // p08.d
    public final void a(int r2) {
        this.a.g.d.h(r2);
    }

    @Override // p08.d
    public final void b(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "selectDate");
        UDDatePicker r0 = this.a;
        r0.c = r2;
        r0.c();
        this.a.b();
    }
}
