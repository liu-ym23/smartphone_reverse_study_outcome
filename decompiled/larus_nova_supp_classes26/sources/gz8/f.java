package gz8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String c() {
        return b("scheduledTasks_newTask_repeats_custom");
    }

    public static String d() {
        return b("scheduledTasks_newTask_repeats_daily");
    }

    public static String e() {
        return b("scheduledTasks_newTask_repeats_hourly");
    }

    public static String f() {
        return b("scheduledTasks_newTask_repeats_never");
    }

    public static String g() {
        return b("scheduledTasks_newTask_repeats_weekly");
    }

    public static String b(String r1) {
        int r0 = j0.a;
        return j0.e(r1);
    }

    public static String h(List r15) {
        Intrinsics.checkNotNullParameter(r15, "weekdays");
        switch(((ArrayList) r15).size()) {
            case 1: goto L12;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L13;
        };
    L13:
        return g();
    L14:
        return a("scheduledTasks_newTask_repeats_7day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r15, 0)), TuplesKt.to("s_day2", ListProtector.get(r15, 1)), TuplesKt.to("s_day3", ListProtector.get(r15, 2)), TuplesKt.to("s_day4", ListProtector.get(r15, 3)), TuplesKt.to("s_day5", ListProtector.get(r15, 4)), TuplesKt.to("s_day6", ListProtector.get(r15, 5)), TuplesKt.to("s_day7", ListProtector.get(r15, 6))});
    L15:
        return a("scheduledTasks_newTask_repeats_6day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r15, 0)), TuplesKt.to("s_day2", ListProtector.get(r15, 1)), TuplesKt.to("s_day3", ListProtector.get(r15, 2)), TuplesKt.to("s_day4", ListProtector.get(r15, 3)), TuplesKt.to("s_day5", ListProtector.get(r15, 4)), TuplesKt.to("s_day6", ListProtector.get(r15, 5))});
    L16:
        return a("scheduledTasks_newTask_repeats_5day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r15, 0)), TuplesKt.to("s_day2", ListProtector.get(r15, 1)), TuplesKt.to("s_day3", ListProtector.get(r15, 2)), TuplesKt.to("s_day4", ListProtector.get(r15, 3)), TuplesKt.to("s_day5", ListProtector.get(r15, 4))});
    L17:
        return a("scheduledTasks_newTask_repeats_4day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r15, 0)), TuplesKt.to("s_day2", ListProtector.get(r15, 1)), TuplesKt.to("s_day3", ListProtector.get(r15, 2)), TuplesKt.to("s_day4", ListProtector.get(r15, 3))});
    L18:
        return a("scheduledTasks_newTask_repeats_3day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r15, 0)), TuplesKt.to("s_day2", ListProtector.get(r15, 1)), TuplesKt.to("s_day3", ListProtector.get(r15, 2))});
    L19:
        return a("scheduledTasks_newTask_repeats_2day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r15, 0)), TuplesKt.to("s_day2", ListProtector.get(r15, 1))});
    L12:
        return a("scheduledTasks_newTask_repeats_1day", new Pair[]{TuplesKt.to("s_day", ListProtector.get(r15, 0))});
    }

    public static String a(String r11, Pair... r12) {
        String r13 = b(r11);
        int r0 = r12.length;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L9;
        if (StringsKt.contains$default(r13, "{" + ((String) r12[r2].component1()) + '}', false, 2, null) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L14;
        int r4 = r12.length;
        String r5 = r13;
    L12:
        if (r1 >= r4) goto L23;
        Pair r14 = r12[r1];
        String r6 = (String) r14.component1();
        r5 = StringsKt.replace$default(r5, "{" + r6 + '}', (String) r14.component2(), false, 4, null);
        r1 = r1 + 1;
        goto L12
    L23:
        return r5;
    L14:
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        ArrayList r8 = new ArrayList(r12.length);
        int r9 = r12.length;
        int r10 = 0;
    L15:
        if (r10 >= r9) goto L17;
        r8.add((String) r12[r10].getSecond());
        r10 = r10 + 1;
        goto L15
    L17:
        String[] r15 = (String[]) r8.toArray(new String[0]);
        Object[] r16 = Arrays.copyOf(r15, r15.length);
        return String.format(r13, Arrays.copyOf(r16, r16.length));
    L9:
        r3 = false;
        goto L10
    }
}
