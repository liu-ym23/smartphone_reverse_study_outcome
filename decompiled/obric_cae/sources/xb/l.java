package xb;

import android.annotation.SuppressLint;
import com.obric.oui.calendar.CalendarDay;
import java.util.ArrayList;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public final class l extends e {
    @Override // xb.e
    public final void b(ArrayList r8, LocalDate r10) {
        int r11 = 0;
    L4:
        if (r11 >= 6) goto L10;
        int r12 = 0;
    L7:
        if (r12 >= 7) goto L9;
        a(r8, r10);
        r10 = r10.plusDays(1);
        r12 = r12 + 1;
        goto L7
    L9:
        r11 = r11 + 1;
        goto L4
    }

    @Override // xb.e
    public final int d() {
        if (this.f13802s == false) goto L5;
        return 7;
    L5:
        return 6;
    }

    @Override // xb.e
    public final boolean e(CalendarDay r8) {
        if (r8.w() != this.f13799p.w()) goto L5;
        return true;
    L5:
        return false;
    }
}
