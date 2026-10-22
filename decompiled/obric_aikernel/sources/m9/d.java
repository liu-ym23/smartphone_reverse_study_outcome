package m9;

import com.obric.oui.calendar.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes2.dex */
public class d implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateTimeFormatter f11058b;

    public d() {
        this(DateTimeFormatter.ofPattern("LLLL yyyy"));
    }

    public d(DateTimeFormatter r10) {
        this.f11058b = r10;
    }

    @Override // m9.g
    public CharSequence a(CalendarDay r10) {
        return this.f11058b.format(r10.getDate());
    }
}
