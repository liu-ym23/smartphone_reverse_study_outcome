package xb;

import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.MaterialCalendarView;
import org.threeten.bp.Period;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends d<l> {

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarDay f13823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13824b;

        public a(CalendarDay r8, CalendarDay r10) {
            this.f13823a = new CalendarDay(r8.x(), r8.w(), 1);
            this.f13824b = a(r10) + 1;
        }

        @Override // xb.f
        public final int a(CalendarDay r8) {
            return (int) Period.between(this.f13823a.u().withDayOfMonth(1), r8.u().withDayOfMonth(1)).toTotalMonths();
        }

        @Override // xb.f
        public final int getCount() {
            return this.f13824b;
        }

        @Override // xb.f
        public final CalendarDay getItem(int r8) {
            return CalendarDay.t(this.f13823a.u().plusMonths(r8));
        }
    }

    @Override // xb.d
    public final f b(CalendarDay r8, CalendarDay r10) {
        return new a(r8, r10);
    }

    @Override // xb.d
    public final e c(int r8) {
        CalendarDay r10 = f(r8);
        MaterialCalendarView r11 = this.f13777d;
        return new l(r11, r10, r11.getFirstDayOfWeek(), this.f13793t);
    }

    @Override // xb.d
    public final int i(e r8) {
        CalendarDay r10 = ((l) r8).f13799p;
        return this.f13785l.a(r10);
    }

    @Override // xb.d
    public final boolean k(e r8) {
        return r8 instanceof l;
    }
}
