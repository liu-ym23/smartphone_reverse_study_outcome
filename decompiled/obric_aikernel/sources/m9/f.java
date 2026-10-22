package m9;

import android.text.SpannableStringBuilder;
import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: classes2.dex */
public class f implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence[] f11060b;

    public f(CharSequence[] r10) {
        if (r10 == null) goto L11;
        if (r10.length < 12) goto L9;
        this.f11060b = r10;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }

    @Override // m9.g
    public CharSequence a(CalendarDay r10) {
        return new SpannableStringBuilder().append(this.f11060b[r10.getMonth() - 1]).append(" ").append(String.valueOf(r10.getYear()));
    }
}
