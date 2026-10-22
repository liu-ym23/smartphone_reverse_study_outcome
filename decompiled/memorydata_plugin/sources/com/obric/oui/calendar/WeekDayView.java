package com.obric.oui.calendar;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.appcompat.widget.AppCompatTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes5.dex */
class WeekDayView extends AppCompatTextView {
    private DayOfWeek dayOfWeek;
    private com.obric.oui.calendar.a.h formatter;

    public WeekDayView(Context r3, DayOfWeek r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.formatter = com.obric.oui.calendar.a.h.f13436a;
        setGravity(17);
        if (Build.VERSION.SDK_INT < 17) goto L5;
        setTextAlignment(4);
    L5:
        setTextSize(12.0f);
        setTypeface(Typeface.create(Typeface.DEFAULT, 400, false));
        setDayOfWeek(r4);
    }

    public void setDayOfWeek(DayOfWeek r2) {
        this.dayOfWeek = r2;
        setText(this.formatter.a(r2));
    }

    public void setWeekDayFormatter(com.obric.oui.calendar.a.h r3) {
        com.obric.oui.calendar.a.h r4 = (com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.h.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r4 = com.obric.oui.calendar.a.h.f13436a;
    L5:
        this.formatter = r4;
        setDayOfWeek(this.dayOfWeek);
    }
}
