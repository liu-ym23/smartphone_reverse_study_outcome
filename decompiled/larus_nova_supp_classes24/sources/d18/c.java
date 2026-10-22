package d18;

import android.content.Context;
import com.lark.kmp.pb.calendar.v1.Calendar;
import com.larksuite.component.universe_design.util.CalendarDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements e18.a<a> {
    public final Context a;
    public final int b;
    public final int c;
    public final String[] d;
    public final CalendarDate e;

    public final class a implements e18.c {
        public final int a;
        public final /* synthetic */ c b;

        @Override // e18.c
        public final String a() {
            TimeZone r0 = TimeZone.getTimeZone(Calendar.DEFAULT_DEFAULT_TIMEZONE);
            CalendarDate r1 = new CalendarDate(this.b.e, r0);
            r1.add(5, this.a);
            StringBuilder r2 = new StringBuilder();
            Context r3 = this.b.a;
            Date r4 = r1.getDate();
            Intrinsics.checkNotNull(r0);
            int[] r5 = com.larksuite.component.universe_design.util.a.a;
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "date");
            Intrinsics.checkNotNullParameter(r0, "timeZone");
            String r6 = r3.getResources().getString(2131887026);
            Intrinsics.checkNotNullParameter(r4, "date");
            Intrinsics.checkNotNullParameter(r0, "timeZone");
            Intrinsics.checkNotNullParameter(r6, "format");
            SimpleDateFormat r7 = new SimpleDateFormat(r6, Locale.getDefault());
            r7.setTimeZone(r0);
            String r8 = r7.format(r4);
            if (r8 != null) goto L5;
            r8 = "";
        L5:
            r2.append(r8);
            r2.append(' ');
            r2.append(this.b.d[r1.getWeekDay() - 1]);
            return r2.toString();
        }

        public a(c r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // e18.a
    public final int getItemsCount() {
        return (this.c - this.b) + 1;
    }

    @Override // e18.a
    public final int a(Object r1) {
        return e18.a.C0102a.a(this, r1);
    }

    @Override // e18.a
    public final a getItem(int r2) {
        return new a(this, r2);
    }

    @Override // e18.a
    public final int indexOf(a r2) {
        a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "o");
        return r3.a;
    }

    public c(Context r2, CalendarDate r3, int r4, String[] r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "beginDate");
        Intrinsics.checkNotNullParameter(r5, "weekStringArray");
        this.a = r2;
        this.b = 0;
        this.c = r4;
        this.d = r5;
        this.e = new CalendarDate(r3);
    }
}
