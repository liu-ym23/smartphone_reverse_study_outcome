package com.obric.oui.calendar.a;

import com.obric.oui.calendar.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes5.dex */
public class d implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateTimeFormatter f13432b;

    public d() {
        this(DateTimeFormatter.ofPattern("LLLL yyyy"));
    }

    public d(DateTimeFormatter r1) {
        this.f13432b = r1;
    }

    @Override // com.obric.oui.calendar.a.g
    public CharSequence a(CalendarDay r1) {
        return this.f13432b.format(r1.getDate());
    }
}
