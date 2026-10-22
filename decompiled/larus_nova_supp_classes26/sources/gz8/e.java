package gz8;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final String a(JSONObject r4) {
        Integer r0 = b(r4, "hour");
        if (r0 == null) goto L16;
        int r1 = r0.intValue();
        Integer r5 = b(r4, "minute");
        if (r5 == null) goto L18;
        int r6 = r5.intValue();
        d r2 = d.a;
        Integer r3 = Integer.valueOf(r1);
        Integer r7 = Integer.valueOf(r6);
        r2.getClass();
        Calendar r8 = Calendar.getInstance(Locale.getDefault());
        if (r3 == null) goto L9;
        int r9 = RangesKt.coerceIn(r3.intValue(), 0, 23);
    L10:
        r8.set(11, r9);
        if (r7 == null) goto L13;
        int r10 = RangesKt.coerceIn(r7.intValue(), 0, 59);
    L14:
        r8.set(12, r10);
        r8.set(13, 0);
        r8.set(14, 0);
        Date r11 = r8.getTime();
        return DateFormat.getTimeInstance(3, Locale.getDefault()).format(r11);
    L13:
        r10 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L18:
        return null;
    L16:
        return null;
    }

    public static final Integer b(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L5;
    L7:
        return null;
    L5:
        if (r1.isNull(r2) == true) goto L7;
        return Integer.valueOf(r1.optInt(r2));
    }
}
