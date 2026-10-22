package mla;

import android.text.SpannableStringBuilder;
import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements g {
    public final CharSequence[] b;

    public f(CharSequence[] r3) {
        if (r3 == null) goto L11;
        if (r3.length < 12) goto L9;
        this.b = r3;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }

    @Override // mla.g
    public final CharSequence a(CalendarDay r4) {
        return new SpannableStringBuilder().append(this.b[r4.c() - 1]).append(" ").append(String.valueOf(r4.d()));
    }
}
