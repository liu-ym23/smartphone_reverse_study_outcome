package xb;

import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.MaterialCalendarView;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends d<t> {

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarDay f13839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DayOfWeek f13841c;

        public a(CalendarDay r8, CalendarDay r10, DayOfWeek r11) {
            this.f13841c = r11;
            this.f13839a = b(r8);
            this.f13840b = a(r10) + 1;
        }

        @Override // xb.f
        public final int a(CalendarDay r8) {
            WeekFields r10 = WeekFields.of(this.f13841c, 1);
            LocalDate r11 = r8.u().with(r10.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.f13839a.u(), r11);
        }

        public final CalendarDay b(CalendarDay r8) {
            return CalendarDay.t(r8.u().with(WeekFields.of(this.f13841c, 1).dayOfWeek(), 1));
        }

        @Override // xb.f
        public final int getCount() {
            return this.f13840b;
        }

        @Override // xb.f
        public final CalendarDay getItem(int r8) {
            return CalendarDay.t(this.f13839a.u().plusWeeks(r8));
        }
    }

    @Override // xb.d
    public final f b(CalendarDay r8, CalendarDay r10) {
        return new a(r8, r10, this.f13777d.getFirstDayOfWeek());
    }

    @Override // xb.d
    public final e c(int r8) {
        CalendarDay r10 = f(r8);
        MaterialCalendarView r11 = this.f13777d;
        return new t(r11, r10, r11.getFirstDayOfWeek(), this.f13793t);
    }

    @Override // xb.d
    public final int i(e r8) {
        CalendarDay r10 = ((t) r8).f13799p;
        return this.f13785l.a(r10);
    }

    @Override // xb.d
    public final boolean k(e r8) {
        return r8 instanceof t;
    }
}
