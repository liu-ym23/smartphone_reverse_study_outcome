package com.larksuite.component.universe_design.timepicker.impl.helper;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.util.CalendarDate;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/helper/UtcDates;", "", "<init>", "()V", "UTC", "", "getTimeZone", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "getCalendar", "Ljava/util/Calendar;", "year", "", "month", "monthDay", "hour", "minute", "second", "getUTCCalendarOf", "calendar", "getTodayCalendar", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UtcDates {
    public static final UtcDates INSTANCE = null;
    private static final String UTC = "UTC";

    static {
        INSTANCE = new UtcDates();
    }

    private UtcDates() {
    }

    public final TimeZone getTimeZone() {
        return TimeZone.getTimeZone("UTC");
    }

    public final Calendar getTodayCalendar() {
        return getUTCCalendarOf(Calendar.getInstance());
    }

    public final Calendar getUTCCalendarOf(Calendar r3) {
        Intrinsics.checkNotNullParameter(r3, "calendar");
        return new CalendarDate(new CalendarDate(r3), TimeZone.getTimeZone("UTC")).getCalendar();
    }

    public final Calendar getCalendar(int r3, int r4) {
        Calendar r0 = Calendar.getInstance(getTimeZone());
        r0.set(11, r3);
        r0.set(12, r4);
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final Calendar getCalendar(int r3, int r4, int r5) {
        Calendar r0 = Calendar.getInstance(getTimeZone());
        r0.set(1, r3);
        r0.set(2, r4 - 1);
        r0.set(5, r5);
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final Calendar getCalendar(int r3, int r4, int r5, int r6, int r7, int r8) {
        Calendar r0 = Calendar.getInstance(getTimeZone());
        r0.set(1, r3);
        r0.set(2, r4 - 1);
        r0.set(5, r5);
        r0.set(11, r6);
        r0.set(12, r7);
        r0.set(13, r8);
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
