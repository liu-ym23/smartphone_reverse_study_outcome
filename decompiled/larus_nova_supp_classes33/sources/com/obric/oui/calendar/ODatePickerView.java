package com.obric.oui.calendar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0003rstJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001f\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010!\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010 J\u001b\u0010%\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b%\u0010&J\u0010\u0010%\u001a\u00020\u00042\b\b\u0001\u0010'\u001a\u00020\u0002J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J\u0006\u0010,\u001a\u00020+J\u0010\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-J\b\u00100\u001a\u0004\u0018\u00010-J\u0010\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010-J\b\u00103\u001a\u0004\u0018\u00010-J\u000e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0002J\u0006\u00106\u001a\u00020\u0002J\u000e\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020(J\u000e\u00109\u001a\u00020\u00042\u0006\u00107\u001a\u00020(J\u000e\u0010:\u001a\u00020\u00042\u0006\u00107\u001a\u00020(J\u000e\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0002J\u000e\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0002J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0002J\u000e\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0002J\u0006\u0010C\u001a\u00020\u0002J\u000e\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002J\u000e\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0002J\u0006\u0010H\u001a\u00020\u0002J\u000e\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0002J\u0006\u0010K\u001a\u00020\u0002J\u000e\u0010L\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0002J\u0006\u0010M\u001a\u00020\u0002J\u000e\u0010N\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002J\u000e\u0010O\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0002J\u0006\u0010P\u001a\u00020\u0002J\u0006\u0010Q\u001a\u00020-J\u0010\u0010S\u001a\u00020\u00042\b\u0010R\u001a\u0004\u0018\u00010-J\b\u0010T\u001a\u0004\u0018\u00010-J\f\u0010V\u001a\b\u0012\u0004\u0012\u00020-0UJ\u0010\u0010Y\u001a\u00020\u00042\u0006\u0010X\u001a\u00020WH\u0007R?\u0010d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR?\u0010h\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR?\u0010l\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010_\u001a\u0004\bj\u0010a\"\u0004\bk\u0010cRE\u0010q\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0U¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010_\u001a\u0004\bo\u0010a\"\u0004\bp\u0010c¨\u0006u"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "second", "", "setSecond", "getSecond", "millisecond", "setMillisecond", "getMillisecond", "Lcom/obric/oui/calendar/MaterialCalendarView;", "getCalendarView", "Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "visibility", "setOutOfMonthVisibility", "", "getSelectTimestamp", "selectedTime", "setCurrentTimeMillis", "mode", "setSelectionMode", "getSelectionMode", "color", "setSelectionColor", "getSelectionColor", "resourceId", "setDateTextAppearance", "setWeekDayTextAppearance", "Lmla/e;", "formatter", "setDayFormatter", "setDayFormatterContentDescription", "Lmla/h;", "setWeekDayFormatter", "", "", "weekDayLabels", "setWeekDayLabels", "([Ljava/lang/CharSequence;)V", "arrayRes", "", "showWeekDays", "setShowWeekDays", "Lcom/obric/oui/calendar/CalendarMode;", "getCalendarMode", "Lcom/obric/oui/calendar/CalendarDay;", "minDate", "setMinimumDate", "getMinimumDate", "maxDate", "setMaximumDate", "getMaximumDate", "showOtherDates", "setShowOtherDates", "getShowOtherDates", "enabled", "setAllowClickDaysOutsideCurrentMonth", "setPagingEnabled", "setDynamicHeightEnabled", "sizePx", "setTileSize", "sizeDp", "setTileSizeDp", "widthPx", "setTileWidth", "widthDp", "setTileWidthDp", "getTileWidth", "heightPx", "setTileHeight", "heightDp", "setTileHeightDp", "getTileHeight", "spacingPx", "setTileHSpacing", "getTileHSpacing", "setTileVSpacing", "getTileVSpacing", "setWeekDaysHeight", "setWeekDaysHeightDp", "getWeekDaysHeight", "getCurrentDate", "date", "setSelectedDate", "getSelectedDate", "", "getSelectedDates", "Ljava/time/DayOfWeek;", "firstDayOfWeek", "setFirstDayOfWeek", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "time", "y", "Lkotlin/jvm/functions/Function1;", "getOnMonthChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnMonthChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onMonthChangedListener", "z", "getOnDateChangedListener", "setOnDateChangedListener", "onDateChangedListener", "A", "getOnDateLongClickListener", "setOnDateLongClickListener", "onDateLongClickListener", "times", "B", "getOnRangeSelectedListener", "setOnRangeSelectedListener", "onRangeSelectedListener", "a", "DatePickerMode", "OutOfMonthVisibility", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ODatePickerView extends ConstraintLayout {
    public static final /* synthetic */ int C = 0;
    public Function1<? super Long, Unit> A;
    public Function1<? super List<Long>, Unit> B;
    public final DatePickerMode a;
    public final boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public final MaterialCalendarView h;
    public final TextView i;
    public final View j;
    public final ImageView k;
    public final FrameLayout l;
    public OReelPickerMulti m;
    public fja.d n;
    public boolean o;
    public fja.d p;
    public fja.d q;
    public ObjectAnimator r;
    public ObjectAnimator s;
    public boolean t;
    public boolean u;
    public OutOfMonthVisibility v;
    public s w;
    public String x;
    public Function1<? super Long, Unit> y;
    public Function1<? super Long, Unit> z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "", "BOARD_SHEET", "NARROW_SHEET", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum DatePickerMode extends Enum<DatePickerMode> {
        public static final DatePickerMode BOARD_SHEET = null;

        @Deprecated(message = "this mode is deprecated, please use BOARD_SHEET")
        public static final DatePickerMode NARROW_SHEET = null;
        public static final /* synthetic */ DatePickerMode[] a = null;

        public static DatePickerMode valueOf(String r1) {
            return (DatePickerMode) r27.a.a(DatePickerMode.class, r1);
        }

        public static DatePickerMode[] values() {
            return (DatePickerMode[]) a.clone();
        }

        static {
            DatePickerMode r0 = new DatePickerMode("BOARD_SHEET", 0);
            BOARD_SHEET = r0;
            DatePickerMode r1 = new DatePickerMode("NARROW_SHEET", 1);
            NARROW_SHEET = r1;
            a = new DatePickerMode[]{r0, r1};
        }

        public DatePickerMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "", "GREY", "HIDE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum OutOfMonthVisibility extends Enum<OutOfMonthVisibility> {
        public static final OutOfMonthVisibility GREY = null;
        public static final OutOfMonthVisibility HIDE = null;
        public static final /* synthetic */ OutOfMonthVisibility[] a = null;

        public static OutOfMonthVisibility valueOf(String r1) {
            return (OutOfMonthVisibility) r27.a.a(OutOfMonthVisibility.class, r1);
        }

        public static OutOfMonthVisibility[] values() {
            return (OutOfMonthVisibility[]) a.clone();
        }

        static {
            OutOfMonthVisibility r0 = new OutOfMonthVisibility("GREY", 0);
            GREY = r0;
            OutOfMonthVisibility r1 = new OutOfMonthVisibility("HIDE", 1);
            HIDE = r1;
            a = new OutOfMonthVisibility[]{r0, r1};
        }

        public OutOfMonthVisibility(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[OutOfMonthVisibility.values().length];
            r0[OutOfMonthVisibility.HIDE.ordinal()] = 1;
            r0[OutOfMonthVisibility.GREY.ordinal()] = 2;
            a = r0;
            int[] r1 = new int[DayOfWeek.values().length];
            r1[DayOfWeek.SUNDAY.ordinal()] = 1;
            r1[DayOfWeek.MONDAY.ordinal()] = 2;
            r1[DayOfWeek.TUESDAY.ordinal()] = 3;
            r1[DayOfWeek.WEDNESDAY.ordinal()] = 4;
            r1[DayOfWeek.THURSDAY.ordinal()] = 5;
            r1[DayOfWeek.FRIDAY.ordinal()] = 6;
            r1[DayOfWeek.SATURDAY.ordinal()] = 7;
            b = r1;
            int[] r2 = new int[DatePickerMode.values().length];
            r2[DatePickerMode.BOARD_SHEET.ordinal()] = 1;
            r2[DatePickerMode.NARROW_SHEET.ordinal()] = 2;
            c = r2;
        }
    }

    static {
    }

    public ODatePickerView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, null, 30);
    }

    public ODatePickerView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, null, 28);
    }

    public ODatePickerView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, null, 24);
    }

    public final void R5() {
        OutOfMonthVisibility r0 = this.v;
        int r1 = b.a[r0.ordinal()];
        boolean r2 = false;
        if (r1 != 1) goto L5;
        int r3 = 0;
    L10:
        this.h.setShowOtherDates(r3);
        MaterialCalendarView r4 = this.h;
        if (this.v != OutOfMonthVisibility.GREY) goto L13;
        r2 = true;
    L13:
        r4.setAllowClickDaysOutsideCurrentMonth(r2);
        return;
    L5:
        if (r1 != 2) goto L8;
        r3 = 7;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final CalendarMode getCalendarMode() {
        return this.h.getCalendarMode();
    }

    public final CalendarDay getCurrentDate() {
        return this.h.getCurrentDate();
    }

    public final CalendarDay getMaximumDate() {
        return this.h.getMaximumDate();
    }

    public final CalendarDay getMinimumDate() {
        return this.h.getMinimumDate();
    }

    public final CalendarDay getSelectedDate() {
        return this.h.getSelectedDate();
    }

    public final List<CalendarDay> getSelectedDates() {
        return this.h.getSelectedDates();
    }

    public final int getSelectionColor() {
        return this.h.getSelectionColor();
    }

    public final int getSelectionMode() {
        return this.h.getSelectionMode();
    }

    public final int getShowOtherDates() {
        return this.h.getShowOtherDates();
    }

    public final int getTileHSpacing() {
        return this.h.getTileHSpacing();
    }

    public final int getTileHeight() {
        return this.h.getTileHeight();
    }

    public final int getTileVSpacing() {
        return this.h.getTileVSpacing();
    }

    public final int getTileWidth() {
        return this.h.getTileWidth();
    }

    public final int getWeekDaysHeight() {
        return this.h.getWeekDaysHeight();
    }

    public final long getSelectTimestamp() {
        Calendar r6 = Calendar.getInstance();
        CalendarDay r0 = (CalendarDay) ListProtector.get(this.h.getSelectedDates(), 0);
        int r1 = r0.d();
        int r2 = r0.c() - 1;
        int r3 = r0.b();
        r6.set(13, getSecond());
        r6.set(14, getMillisecond());
        r6.set(r1, r2, r3, 0, 0);
        return r6.getTimeInMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        int r0 = vma.c.a;
        ViewParent r1 = getParent();
        if (r1 != null) goto L6;
    L4:
        r1 = null;
    L7:
        OSheetContentFrameLayout r2 = (ViewGroup) r1;
        if ((r2 instanceof OSheetContentFrameLayout) == false) goto L35;
        OSheetContentFrameLayout r3 = r2;
        if (r3.getId() != 2131367812) goto L36;
        int r4 = r3.getPaddingLeft();
        int r5 = r3.getPaddingTop();
        int r6 = r3.getPaddingRight();
        int r7 = r3.getPaddingBottom();
        int r8 = b.c[this.a.ordinal()];
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L17;
        return;
    L17:
        if (r4 == pla.d.n(this, 0)) goto L19;
    L24:
        wma.b.a("DatePickerView", "onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [" + r4 + ", " + r5 + ", " + r6 + ", " + r7 + ']');
        r3.setPadding(0, 0, 0, 0);
        return;
    L19:
        if (r5 != pla.d.n(this, 0)) goto L24;
        if (r6 != pla.d.n(this, 0)) goto L24;
        if (r7 != pla.d.n(this, 0)) goto L24;
        return;
    L26:
        if (r4 == pla.d.n(this, 16)) goto L28;
    L33:
        wma.b.a("DatePickerView", "onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [" + r4 + ", " + r5 + ", " + r6 + ", " + r7 + ']');
        r3.setPadding(pla.d.n(this, 16), pla.d.n(this, 6), pla.d.n(this, 16), pla.d.n(this, 16));
        return;
    L28:
        if (r5 != pla.d.n(this, 6)) goto L33;
        if (r6 != pla.d.n(this, 16)) goto L33;
        if (r7 != pla.d.n(this, 16)) goto L33;
        return;
    L36:
        return;
    L35:
        return;
    L6:
        if ((r1 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        s r0 = this.w;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.w = null;
    }

    private final int getMillisecond() {
        return this.f;
    }

    private final int getSecond() {
        return this.e;
    }

    public final MaterialCalendarView getCalendarView() {
        return this.h;
    }

    public final Function1<Long, Unit> getOnDateChangedListener() {
        return this.z;
    }

    public final Function1<Long, Unit> getOnDateLongClickListener() {
        return this.A;
    }

    public final Function1<Long, Unit> getOnMonthChangedListener() {
        return this.y;
    }

    public final Function1<List<Long>, Unit> getOnRangeSelectedListener() {
        return this.B;
    }

    public static long T5(CalendarDay r8) {
        Calendar r7 = Calendar.getInstance();
        r7.set(r8.d(), r8.c() - 1, r8.b(), 0, 0, 0);
        r7.set(14, 0);
        return r7.getTimeInMillis();
    }

    private final void setMillisecond(int r1) {
        this.f = r1;
    }

    private final void setSecond(int r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r2) {
        super/*android.view.ViewGroup*/.onConfigurationChanged(r2);
        this.x = getResources().getString(2131912802);
    }

    public final void setAllowClickDaysOutsideCurrentMonth(boolean r2) {
        this.h.setAllowClickDaysOutsideCurrentMonth(r2);
    }

    public final void setCurrentTimeMillis(long r9) {
        this.g = r9;
        Calendar r10 = Calendar.getInstance();
        int r11 = pla.b.a;
        pla.b.b("DatePickerView", "默认选中的时间:" + this.g + " , mSelectTime:" + this.g);
        r10.setTimeInMillis(this.g);
        int r1 = r10.get(1);
        int r2 = r10.get(2) + 1;
        int r12 = r10.get(5);
        int r3 = r10.get(11);
        int r4 = r10.get(12);
        int r5 = r10.get(13);
        int r13 = r10.get(14);
        pla.b.b("DatePickerView", "转化时间year:" + r1 + ",month:" + r2 + ",day:" + r12 + ",hour:" + r3 + ",minute:" + r4 + ", selectDate:" + new CalendarDay(r1, r2, r12));
        String r0 = S5(this.g, this.x);
        this.h.setCurrentDate(new CalendarDay(r1, r2, r12));
        this.h.setSelectedDate(new CalendarDay(r1, r2, r12));
        this.i.setText(r0);
        setSecond(r5);
        setMillisecond(r13);
    }

    public final void setDateTextAppearance(int r2) {
        this.h.setDateTextAppearance(r2);
    }

    public final void setDayFormatter(mla.e r2) {
        this.h.setDayFormatter(r2);
    }

    public final void setDayFormatterContentDescription(mla.e r2) {
        this.h.setDayFormatterContentDescription(r2);
    }

    public final void setDynamicHeightEnabled(boolean r2) {
        this.h.setDynamicHeightEnabled(r2);
    }

    public final void setFirstDayOfWeek(DayOfWeek r4) {
        Intrinsics.checkNotNullParameter(r4, "firstDayOfWeek");
        switch(b.b[r4.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        org.threeten.bp.DayOfWeek r5 = org.threeten.bp.DayOfWeek.SATURDAY;
    L13:
        MaterialCalendarView.f r0 = this.h.B;
        r0.getClass();
        MaterialCalendarView.g r1 = new MaterialCalendarView.g(r0.g, r0);
        r1.b = r5;
        r1.a();
        return;
    L7:
        r5 = org.threeten.bp.DayOfWeek.FRIDAY;
        goto L13
    L8:
        r5 = org.threeten.bp.DayOfWeek.THURSDAY;
        goto L13
    L9:
        r5 = org.threeten.bp.DayOfWeek.WEDNESDAY;
        goto L13
    L10:
        r5 = org.threeten.bp.DayOfWeek.TUESDAY;
        goto L13
    L11:
        r5 = org.threeten.bp.DayOfWeek.MONDAY;
        goto L13
    L12:
        r5 = org.threeten.bp.DayOfWeek.SUNDAY;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void setMaximumDate(CalendarDay r4) {
        MaterialCalendarView.f r0 = this.h.B;
        r0.getClass();
        MaterialCalendarView.g r1 = new MaterialCalendarView.g(r0.g, r0);
        r1.e = r4;
        r1.a();
    }

    public final void setMinimumDate(CalendarDay r4) {
        MaterialCalendarView.f r0 = this.h.B;
        r0.getClass();
        MaterialCalendarView.g r1 = new MaterialCalendarView.g(r0.g, r0);
        r1.d = r4;
        r1.a();
    }

    public final void setOnDateChangedListener(Function1<? super Long, Unit> r1) {
        this.z = r1;
    }

    public final void setOnDateLongClickListener(Function1<? super Long, Unit> r1) {
        this.A = r1;
    }

    public final void setOnMonthChangedListener(Function1<? super Long, Unit> r1) {
        this.y = r1;
    }

    public final void setOnRangeSelectedListener(Function1<? super List<Long>, Unit> r1) {
        this.B = r1;
    }

    public final void setOutOfMonthVisibility(OutOfMonthVisibility r2) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        this.v = r2;
        R5();
    }

    public final void setPagingEnabled(boolean r2) {
        this.h.setPagingEnabled(r2);
    }

    public final void setSelectedDate(CalendarDay r2) {
        this.h.setSelectedDate(r2);
    }

    public final void setSelectionColor(int r2) {
        this.h.setSelectionColor(r2);
    }

    public final void setSelectionMode(int r2) {
        this.h.setSelectionMode(r2);
    }

    public final void setShowOtherDates(int r2) {
        this.h.setShowOtherDates(r2);
    }

    public final void setShowWeekDays(boolean r4) {
        MaterialCalendarView.f r0 = this.h.B;
        r0.getClass();
        MaterialCalendarView.g r1 = new MaterialCalendarView.g(r0.g, r0);
        r1.f = r4;
        r1.a();
    }

    public final void setTileHSpacing(int r2) {
        this.h.setTileHSpacing(r2);
    }

    public final void setTileHeight(int r2) {
        this.h.setTileHeight(r2);
    }

    public final void setTileHeightDp(int r2) {
        this.h.setTileHeightDp(r2);
    }

    public final void setTileSize(int r2) {
        this.h.setTileSize(r2);
    }

    public final void setTileSizeDp(int r2) {
        this.h.setTileSizeDp(r2);
    }

    public final void setTileVSpacing(int r2) {
        this.h.setTileVSpacing(r2);
    }

    public final void setTileWidth(int r2) {
        this.h.setTileWidth(r2);
    }

    public final void setTileWidthDp(int r2) {
        this.h.setTileWidthDp(r2);
    }

    public final void setWeekDayFormatter(mla.h r2) {
        this.h.setWeekDayFormatter(r2);
    }

    public final void setWeekDayLabels(CharSequence[] r2) {
        Intrinsics.checkNotNullParameter(r2, "weekDayLabels");
        this.h.setWeekDayLabels(r2);
    }

    public final void setWeekDayTextAppearance(int r2) {
        this.h.setWeekDayTextAppearance(r2);
    }

    public final void setWeekDaysHeight(int r2) {
        this.h.setWeekDaysHeight(r2);
    }

    public final void setWeekDaysHeightDp(int r2) {
        this.h.setWeekDaysHeightDp(r2);
    }

    public final void setWeekDayLabels(int r2) {
        this.h.setWeekDayLabels(r2);
    }

    public static String S5(long r1, String r3) {
        Date r0 = new Date(r1);
        SimpleDateFormat r2 = new SimpleDateFormat(r3, Locale.getDefault());
        r2.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        return r2.format(r0);
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ODatePickerView(Context r11, AttributeSet r12, int r13, DatePickerMode r14, int r15) {
        View r1 = null;
        if ((r15 & 2) == 0) goto L5;
        r12 = null;
    L5:
        int r2 = 0;
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = DatePickerMode.BOARD_SHEET;
    L11:
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r14, "datePickerMode");
        super(r11, r12, r13);
        this.a = r14;
        this.b = false;
        CalendarDay.e().b();
        this.c = CalendarDay.e().d();
        this.d = CalendarDay.e().c();
        this.v = OutOfMonthVisibility.GREY;
        ViewGroup.inflate(r11, 2131563763, this);
        this.x = getResources().getString(2131912802);
        MaterialCalendarView r16 = (MaterialCalendarView) findViewById(2131365080);
        this.h = r16;
        ImageView r17 = (ImageView) findViewById(2131382996);
        ImageView r18 = (ImageView) findViewById(2131380888);
        this.i = (TextView) findViewById(2131368324);
        View r19 = findViewById(2131378776);
        this.j = r19;
        this.k = (ImageView) findViewById(2131376452);
        FrameLayout r110 = (FrameLayout) findViewById(2131372692);
        this.l = r110;
        Calendar r0 = Calendar.getInstance();
        r16.setTopbarVisible(false);
        r17.setOnClickListener(new m(this));
        r18.setOnClickListener(new n(this));
        r16.setOnMonthChangedListener(new o(r0, this));
        r16.setOnDateChangedListener(new p(r0, this));
        r16.setOnDateLongClickListener(new q(this));
        r16.setOnRangeSelectedListener(new r(this));
        R5();
        hma.c.a r111 = new hma.c.a();
        r111.i(getContext(), 1001, 1900, 2100, Integer.valueOf(this.c), Integer.valueOf(pla.d.n(this, 164)));
        r111.f(getContext(), 1002, Integer.valueOf(this.d), Integer.valueOf(pla.d.n(this, 164)));
        Context r112 = getContext();
        Intrinsics.checkNotNullParameter(r112, "$this$getScreenWidth");
        Resources r113 = r112.getResources();
        DisplayMetrics r114 = WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics());
        if (r114 == null) goto L14;
        r2 = r114.widthPixels;
    L14:
        r111.b = Integer.valueOf(r2);
        r111.c = Integer.valueOf(pla.d.n(this, 258));
        Consumer r115 = new k(this);
        Intrinsics.checkNotNullParameter(r115, "listener");
        r111.a = r115;
        View r116 = ((hma.c) hma.d.a.a(r111, getContext())).a();
        if (r116 == null) goto L18;
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-1, r116.getLayoutParams().height);
        r117.gravity = 17;
        r116.setLayoutParams(r117);
        r116.setAlpha(0.0f);
        r116.setVisibility(4);
        r110.addView(r116);
        r1 = r116;
    L18:
        this.m = r1;
        r19.setOnClickListener(new l(this));
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
