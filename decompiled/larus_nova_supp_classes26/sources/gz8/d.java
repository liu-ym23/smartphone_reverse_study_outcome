package gz8;

import android.text.format.DateFormat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.tips.GuidePriority;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final d a = null;
    public static final Regex b = null;
    public static final Regex c = null;
    public static final Regex d = null;

    public d() {
    }

    static {
        a = new d();
        b = new Regex("[+-]\\d{2}:\\d{2}$");
        c = new Regex("[+-]\\d{4}$");
        d = new Regex("\\.(\\d+)([+-]\\d{4})$");
    }

    public static List b(Locale r6) {
        Intrinsics.checkNotNullParameter(r6, "locale");
        String[] r7 = new DateFormatSymbols(r6).getAmPmStrings();
        String[] r0 = new String[2];
        Intrinsics.checkNotNull(r7);
        boolean r1 = false;
        Object r2 = ArraysKt.getOrNull(r7, 0);
        String r3 = (String) r2;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Object r5 = null;
        if (r4 == false) goto L13;
        r2 = null;
    L13:
        String r8 = (String) r2;
        if (r8 != null) goto L16;
        r8 = "AM";
    L16:
        r0[0] = r8;
        Object r9 = ArraysKt.getOrNull(r7, 1);
        String r10 = (String) r9;
        if (r10 != null) goto L19;
    L20:
        r1 = true;
    L21:
        if (r1 == true) goto L23;
        r5 = r9;
    L23:
        String r11 = (String) r5;
        if (r11 != null) goto L26;
        r11 = "PM";
    L26:
        r0[1] = r11;
        return CollectionsKt.listOf(r0);
    L19:
        if (StringsKt.isBlank(r10) == false) goto L21;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L9
    }

    public static String d(int r4) {
        return f.e() + f.a("scheduledTasks_newTask_repeats_hour_minuteNum", new Pair[]{TuplesKt.to("s_number", String.valueOf(RangesKt.coerceIn(RangesKt.coerceIn(r4, 0, 59), 0, 59)))});
    }

    public static Integer e(int r0) {
        switch(r0) {
            case 0: goto L6;
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L8:
        return Integer.valueOf(r0);
    L6:
        return 7;
    }

    public static Long f(String r8) {
        Intrinsics.checkNotNullParameter(r8, "raw");
        String r9 = StringsKt.trim(r8).toString();
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r3 = null;
        if (r0 == false) goto L9;
        return null;
    L9:
        Long r1 = StringsKt.toLongOrNull(r9);
        if (r1 == null) goto L19;
        long r2 = r1.longValue();
        if (r2 >= 10000000000L) goto L18;
        if (r2 <= (-10000000000L)) goto L18;
        return Long.valueOf(r2 * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY));
    L18:
        return Long.valueOf(r2);
    L19:
        String r10 = StringsKt.trim(r9).toString();
        if (StringsKt.endsWith(r10, 'Z', true) == false) goto L23;
        r10 = StringsKt.dropLast(r10, 1) + "+0000";
    L27:
        MatchResult r4 = Regex.find$default(d, r10, 0, 2, null);
        if (r4 == null) goto L32;
        String r5 = StringsKt.padEnd(StringsKt.take((String) ListProtector.get(r4.getGroupValues(), 1), 3), 3, '0');
        r10 = StringsKt.replaceRange(r10, r4.getRange(), "." + r5 + ((String) ListProtector.get(r4.getGroupValues(), 2))).toString();
    L32:
        if (r10 != null) goto L35;
        return null;
    L35:
        if (StringsKt.contains$default(r10, '.', false, 2, null) == false) goto L37;
        String r6 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    L52:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L44
        SimpleDateFormat r11 = new SimpleDateFormat(r6, Locale.US);     // Catch: Throwable -> L44
        r11.setLenient(false);     // Catch: Throwable -> L44
        Date r12 = r11.parse(r10);     // Catch: Throwable -> L44
        if (r12 == null) goto L41;
        Long r13 = Long.valueOf(r12.getTime());     // Catch: Throwable -> L44
    L42:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L44
    L47:
        if (Result.isFailure-impl(r14) == true) goto L51;
        r3 = r14;
    L51:
        return (Long) r3;
    L41:
        r13 = null;
    L44:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L37:
        r6 = "yyyy-MM-dd'T'HH:mm:ssZ";
        goto L52
    L23:
        if (b.containsMatchIn(r10) == false) goto L26;
        r10 = StringsKt.dropLast(r10, 3) + StringsKt.takeLast(r10, 2);
        goto L27
    L26:
        if (c.containsMatchIn(r10) == true) goto L27;
        r10 = null;
        goto L32
    L5:
        r0 = false;
        goto L6
    }

    public static boolean a(String r7, String... r8) {
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        String r3 = r8[r2];
        if ((!StringsKt.isBlank(r3)) == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    L7:
        if (StringsKt.contains$default(r7, r3, false, 2, null) == false) goto L9;
        r4 = true;
        goto L10
    L16:
        return false;
    }

    public static String c(int r19, int r20) {
        Locale r0 = Locale.getDefault();
        Calendar r1 = Calendar.getInstance(r0);
        int r2 = 0;
        r1.set(11, RangesKt.coerceIn(r19, 0, 23));
        r1.set(12, RangesKt.coerceIn(r20, 0, 59));
        r1.set(13, 0);
        r1.set(14, 0);
        Date r3 = r1.getTime();
        String r4 = DateFormat.getBestDateTimePattern(r0, "ahmm");
        Intrinsics.checkNotNull(r4);
        StringBuilder r5 = new StringBuilder();
        boolean r6 = false;
    L4:
        if (r2 >= r4.length()) goto L22;
        char r7 = r4.charAt(r2);
        if (r7 == '\'') goto L7;
        if (r6 == true) goto L19;
        if (r7 == 'h') goto L13;
        if (r7 != 'K') goto L19;
    L13:
        r5.append(r7);
        r5.append(r7);
    L15:
        if (r2 >= r4.length()) goto L4;
        if (r4.charAt(r2) != r7) goto L4;
        r2 = r2 + 1;
    L19:
        r5.append(r7);
    L20:
        r2 = r2 + 1;
        goto L4
    L7:
        r6 = !r6;
        r5.append(r7);
        goto L20
    L22:
        return new SimpleDateFormat(StringsKt.replace$default(StringsKt.replace$default(r5.toString(), "ah", "a h", false, 4, null), "aK", "a K", false, 4, null), r0).format(r3);
    }
}
