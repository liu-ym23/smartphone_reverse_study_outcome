package yb;

import com.obric.oui.calendar.CalendarDay;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f14107b;

    public c() {
        this.f14107b = DateTimeFormatter.ofPattern("d", Locale.getDefault());
    }

    public final String a(CalendarDay r8) {
        return this.f14107b.format(r8.u());
    }
}
