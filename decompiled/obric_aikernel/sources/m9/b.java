package m9;

import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements h {
    public b() {
    }

    @Override // m9.h
    public CharSequence a(DayOfWeek r10) {
        return r10.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }
}
