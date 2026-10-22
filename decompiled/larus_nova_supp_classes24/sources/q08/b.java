package q08;

import com.larksuite.component.universe_design.datepicker.impl.data.CalendarAttr;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(n08.a r2, CalendarDate r3, CalendarDate r4) {
        if (r3.sameDay(r4) == false) goto L6;
        CalendarAttr r5 = r2.d;
        CalendarAttr.DateState r6 = CalendarAttr.DateState.CURRENT_DATE;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.b = r6;
        return;
    L6:
        if (r3.beforeDay(r4) == false) goto L8;
        CalendarAttr r7 = r2.d;
        CalendarAttr.DateState r8 = CalendarAttr.DateState.PAST_DATE;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.b = r8;
        return;
    L8:
        CalendarAttr r9 = r2.d;
        CalendarAttr.DateState r10 = CalendarAttr.DateState.FUTURE_DATE;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.b = r10;
    }

    public static void b(n08.a r0, CalendarDate r1, CalendarDate r2) {
        if (r1.sameDay(r2) == false) goto L5;
        CalendarAttr r3 = r0.d;
        CalendarAttr.SelectState r4 = CalendarAttr.SelectState.SELECT;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.a = r4;
        return;
    L5:
        CalendarAttr r5 = r0.d;
        CalendarAttr.SelectState r6 = CalendarAttr.SelectState.UN_SELECT;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.a = r6;
    }
}
