package com.obric.oui.calendar.a;

import android.text.SpannableStringBuilder;
import com.obric.oui.calendar.CalendarDay;

/* JADX INFO: loaded from: classes5.dex */
public class f implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence[] f13434b;

    public f(CharSequence[] r3) {
        if (r3 == null) goto L11;
        if (r3.length < 12) goto L9;
        this.f13434b = r3;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }

    @Override // com.obric.oui.calendar.a.g
    public CharSequence a(CalendarDay r3) {
        return new SpannableStringBuilder().append(this.f13434b[r3.getMonth() - 1]).append(" ").append(String.valueOf(r3.getYear()));
    }
}
