package com.obric.oui.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class WeekDayView extends AppCompatTextView {
    private DayOfWeek dayOfWeek;
    private m9.h formatter;

    public WeekDayView(Context r10, DayOfWeek r11) {
        super(r10);
        this.formatter = m9.h.f11062a;
        setGravity(17);
        if (Build.VERSION.SDK_INT < 17) goto L5;
        setTextAlignment(4);
    L5:
        setDayOfWeek(r11);
    }

    public void setDayOfWeek(DayOfWeek r10) {
        this.dayOfWeek = r10;
        setText(this.formatter.a(r10));
    }

    public void setWeekDayFormatter(@Nullable m9.h r10) {
        if (r10 != null) goto L4;
        r10 = m9.h.f11062a;
    L4:
        this.formatter = r10;
        setDayOfWeek(this.dayOfWeek);
    }
}
