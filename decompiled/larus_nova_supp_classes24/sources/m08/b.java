package m08;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.larksuite.component.universe_design.datepicker.impl.MonthCalendarViewAdapter;
import com.larksuite.component.universe_design.datepicker.impl.MonthViewPager;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;
import o08.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements c {
    public final /* synthetic */ MonthViewPager a;

    @Override // o08.c
    public final void a() {
    }

    @Override // o08.c
    public final void c() {
    }

    public b(MonthViewPager r1) {
        this.a = r1;
    }

    @Override // o08.c
    public final void b(int r4) {
        PagerAdapter r0 = this.a.getAdapter();
        if ((r0 instanceof MonthCalendarViewAdapter) == false) goto L5;
        MonthCalendarViewAdapter r1 = (MonthCalendarViewAdapter) r0;
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L28;
        p08.c r5 = this.a.h;
        if (r5 == null) goto L15;
        CalendarDate r2 = r1.d.getSelectedDate().modifyMonth(-1);
        r2.setMonthDay(1);
        r5.c(r2.moveToDayStart());
    L15:
        p08.c r6 = this.a.h;
        if (r6 == null) goto L25;
        r6.b();
        return;
    L25:
        return;
    L28:
        return;
    L18:
        p08.c r7 = this.a.h;
        if (r7 == null) goto L21;
        CalendarDate r3 = r1.d.getSelectedDate().modifyMonth(1);
        r3.setMonthDay(1);
        r7.c(r3.moveToDayStart());
    L21:
        p08.c r8 = this.a.h;
        if (r8 == null) goto L27;
        r8.a();
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // o08.c
    public final void d(View r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
    }

    @Override // o08.c
    public final void e(View r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
    }
}
