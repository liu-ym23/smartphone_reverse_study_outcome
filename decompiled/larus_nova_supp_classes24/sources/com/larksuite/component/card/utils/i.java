package com.larksuite.component.card.utils;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static long a(Date r3) {
        Calendar r0 = Calendar.getInstance();
        if (r3 == null) goto L5;
        r0.setTime(r3);
    L5:
        Calendar r4 = Calendar.getInstance();
        r4.set(11, r0.get(11));
        r4.set(12, r0.get(12));
        r4.set(13, 0);
        r4.set(14, 0);
        return r4.getTimeInMillis();
    }
}
