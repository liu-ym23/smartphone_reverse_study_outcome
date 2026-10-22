package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final i f3229c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Long f3230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final TimeZone f3231b;

    static {
        f3229c = new i(null, null);
    }

    private i(@Nullable Long r10, @Nullable TimeZone r11) {
        this.f3230a = r10;
        this.f3231b = r11;
    }

    static i c() {
        return f3229c;
    }

    Calendar a() {
        return b(this.f3231b);
    }

    Calendar b(@Nullable TimeZone r10) {
        if (r10 != null) goto L4;
        Calendar r11 = Calendar.getInstance();
    L5:
        Long r12 = this.f3230a;
        if (r12 == null) goto L8;
        r11.setTimeInMillis(r12.longValue());
    L8:
        return r11;
    L4:
        r11 = Calendar.getInstance(r10);
        goto L5
    }
}
