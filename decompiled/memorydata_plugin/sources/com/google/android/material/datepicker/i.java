package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i f3893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f3894b;
    private final TimeZone c;

    static {
        f3893a = new i(null, null);
    }

    private i(Long r1, TimeZone r2) {
        this.f3894b = r1;
        this.c = r2;
    }

    static i a() {
        return f3893a;
    }

    Calendar a(TimeZone r3) {
        if (r3 != null) goto L4;
        Calendar r4 = Calendar.getInstance();
    L5:
        Long r2 = this.f3894b;
        if (r2 == null) goto L8;
        r4.setTimeInMillis(r2.longValue());
    L8:
        return r4;
    L4:
        r4 = Calendar.getInstance(r3);
        goto L5
    }

    Calendar b() {
        return a(this.c);
    }
}
