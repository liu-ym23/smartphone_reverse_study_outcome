package org.apache.commons.lang3.time;

import ai.j0;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Locale f20968c;
    public final HashMap d;

    public f(int r5, Calendar r10, Locale r11) {
        this.f20967b = r5;
        this.f20968c = r11;
        StringBuilder r12 = j0.u("((?iu)");
        this.d = FastDateParser.a(r10, r11, r5, r12);
        r12.setLength(r12.length() - 1);
        r12.append(")");
        this.f20973a = Pattern.compile(r12.toString());
    }

    @Override // org.apache.commons.lang3.time.j
    public final void c(String r5, Calendar r10) {
        String r11 = r5.toLowerCase(this.f20968c);
        HashMap r12 = this.d;
        Integer r13 = (Integer) r12.get(r11);
        if (r13 != null) goto L5;
        r13 = (Integer) r12.get(r11 + '.');
    L5:
        r10.set(this.f20967b, r13.intValue());
    }
}
