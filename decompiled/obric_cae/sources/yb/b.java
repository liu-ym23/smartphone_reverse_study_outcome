package yb;

import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements g {
    @Override // yb.g
    public final CharSequence a(DayOfWeek r8) {
        return r8.getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }
}
