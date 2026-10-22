package m9;

import androidx.annotation.NonNull;
import com.obric.oui.calendar.CalendarDay;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

/* JADX INFO: loaded from: classes2.dex */
public class c implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateTimeFormatter f11057b;

    public c() {
        this(DateTimeFormatter.ofPattern("d", Locale.getDefault()));
    }

    public c(@NonNull DateTimeFormatter r10) {
        this.f11057b = r10;
    }

    @Override // m9.e
    @NonNull
    public String a(@NonNull CalendarDay r10) {
        return this.f11057b.format(r10.getDate());
    }
}
