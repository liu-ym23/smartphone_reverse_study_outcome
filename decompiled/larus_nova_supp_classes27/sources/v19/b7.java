package v19;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b7 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(long r18) {
        long r0 = System.currentTimeMillis() / 1000;
        Application r4 = AppHost.a.getApplication();
        long r1 = RangesKt.coerceAtLeast(r0 - r18, 60);
        if (r1 >= 120) goto L6;
        String r2 = r4.getString(2131900332);
        Intrinsics.checkNotNull(r2);
        return r2;
    L6:
        if (r1 >= 3600) goto L9;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        return String.format(r4.getString(2131908217), Arrays.copyOf(new Object[]{Long.valueOf(r1 / ((long) 60))}, 1));
    L9:
        if (r1 >= 86400) goto L12;
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        return String.format(r4.getString(2131908216), Arrays.copyOf(new Object[]{Long.valueOf(r1 / ((long) 3600))}, 1));
    L12:
        if (r1 >= 604800) goto L14;
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        return String.format(r4.getString(2131908215), Arrays.copyOf(new Object[]{Long.valueOf(r1 / ((long) 86400))}, 1));
    L14:
        Calendar r7 = Calendar.getInstance();
        r7.set(r7.get(1), 0, 1, 0, 0, 0);
        r7.set(14, 0);
        if (r18 < (r7.getTimeInMillis() / 1000)) goto L17;
        Calendar r8 = Calendar.getInstance();
        r8.setTimeInMillis(r18 * 1000);
        String r9 = String.valueOf(r8.get(2) + 1);
        return StringsKt.replace$default(StringsKt.replace$default(r4.getString(2131908218), "%d_month", r9, false, 4, null), "%d_day", String.valueOf(r8.get(5)), false, 4, null);
    L17:
        Calendar r10 = Calendar.getInstance();
        r10.setTimeInMillis(r18 * 1000);
        String r11 = String.valueOf(r10.get(2) + 1);
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r4.getString(2131908219), "%d_year", String.valueOf(r10.get(1)), false, 4, null), "%d_month", r11, false, 4, null), "%d_day", String.valueOf(r10.get(5)), false, 4, null);
    }
}
