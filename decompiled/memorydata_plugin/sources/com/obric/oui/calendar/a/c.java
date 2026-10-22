package com.obric.oui.calendar.a;

import com.obric.oui.calendar.CalendarDay;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes5.dex */
public class c implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateTimeFormatter f13431b;

    public c() {
        this(DateTimeFormatter.ofPattern("d", Locale.getDefault()));
    }

    public c(DateTimeFormatter r1) {
        this.f13431b = r1;
    }

    @Override // com.obric.oui.calendar.a.e
    public String a(CalendarDay r1) {
        return this.f13431b.format(r1.getDate());
    }
}
