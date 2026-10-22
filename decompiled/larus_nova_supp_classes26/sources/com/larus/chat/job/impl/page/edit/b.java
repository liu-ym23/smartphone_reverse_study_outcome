package com.larus.chat.job.impl.page.edit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static h b(int r4) {
        Calendar r0 = Calendar.getInstance(Locale.getDefault());
        r0.add(5, r4);
        return a(r0.get(1), r0.get(2) + 1, r0.get(5));
    }

    public static String c(h r8, e0 r9) {
        Intrinsics.checkNotNullParameter(r8, "date");
        Intrinsics.checkNotNullParameter(r9, "time");
        Calendar r0 = Calendar.getInstance(Locale.getDefault());
        r0.set(r8.a, r8.b - 1, r8.c, r9.a, r9.b, 0);
        r0.set(14, 0);
        String r10 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(new Date(r0.getTimeInMillis()));
        StringBuilder r11 = new StringBuilder();
        Intrinsics.checkNotNull(r10);
        r11.append(StringsKt.dropLast(r10, 2));
        r11.append(':');
        r11.append(StringsKt.takeLast(r10, 2));
        return r11.toString();
    }

    public static h a(int r2, int r3, int r4) {
        Calendar r0 = Calendar.getInstance(Locale.getDefault());
        r0.set(r2, r3 - 1, r4);
        switch(r0.get(7)) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        String r1 = ChatJobEditWeekday.SATURDAY.getLabel();
    L12:
        return new h(r2, r3, r4, r1);
    L5:
        r1 = ChatJobEditWeekday.FRIDAY.getLabel();
        goto L12
    L6:
        r1 = ChatJobEditWeekday.THURSDAY.getLabel();
        goto L12
    L7:
        r1 = ChatJobEditWeekday.WEDNESDAY.getLabel();
        goto L12
    L8:
        r1 = ChatJobEditWeekday.TUESDAY.getLabel();
        goto L12
    L9:
        r1 = ChatJobEditWeekday.MONDAY.getLabel();
        goto L12
    L10:
        r1 = ChatJobEditWeekday.SUNDAY.getLabel();
        goto L12
    }
}
