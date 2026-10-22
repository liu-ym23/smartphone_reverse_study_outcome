package yb;

import com.obric.oui.calendar.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f14108b;

    public d() {
        this.f14108b = DateTimeFormatter.ofPattern("LLLL yyyy");
    }

    @Override // yb.f
    public final CharSequence a(CalendarDay r8) {
        return this.f14108b.format(r8.u());
    }
}
