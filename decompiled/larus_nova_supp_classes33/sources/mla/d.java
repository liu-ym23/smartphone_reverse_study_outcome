package mla;

import com.obric.oui.calendar.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements g {
    public final DateTimeFormatter b;

    public d() {
        DateTimeFormatter r0 = DateTimeFormatter.h;
        DateTimeFormatterBuilder r1 = new DateTimeFormatterBuilder();
        r1.g("LLLL yyyy");
        this.b = r1.p();
    }

    @Override // mla.g
    public final CharSequence a(CalendarDay r2) {
        return this.b.a(r2.a);
    }
}
