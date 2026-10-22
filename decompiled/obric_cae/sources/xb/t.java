package xb;

import android.annotation.SuppressLint;
import com.obric.oui.calendar.CalendarDay;
import java.util.ArrayList;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public final class t extends e {
    @Override // xb.e
    public final void b(ArrayList r8, LocalDate r10) {
        int r11 = 0;
    L4:
        if (r11 >= 7) goto L6;
        a(r8, r10);
        r10 = r10.plusDays(1);
        r11 = r11 + 1;
        goto L4
    }

    @Override // xb.e
    public final int d() {
        if (this.f13802s == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // xb.e
    public final boolean e(CalendarDay r8) {
        return true;
    }
}
