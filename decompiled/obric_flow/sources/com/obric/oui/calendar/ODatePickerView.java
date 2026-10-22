package com.obric.oui.calendar;

import ai.j0;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0004\u0080\u0001\u0081\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00072\b\b\u0001\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J\u001b\u0010'\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\u0004\b'\u0010(J\u0017\u0010'\u001a\u00020\u00072\b\b\u0001\u0010)\u001a\u00020\u0010¢\u0006\u0004\b'\u0010\u0013J\u0015\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\r\u0010/\u001a\u00020.¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u0004\u0018\u000101¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u000101¢\u0006\u0004\b8\u00104J\u000f\u00109\u001a\u0004\u0018\u000101¢\u0006\u0004\b9\u00106J\u0015\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0010¢\u0006\u0004\b;\u0010\u0013J\r\u0010<\u001a\u00020\u0010¢\u0006\u0004\b<\u0010\u0015J\u0015\u0010>\u001a\u00020\u00072\u0006\u0010=\u001a\u00020*¢\u0006\u0004\b>\u0010-J\u0015\u0010?\u001a\u00020\u00072\u0006\u0010=\u001a\u00020*¢\u0006\u0004\b?\u0010-J\u0015\u0010@\u001a\u00020\u00072\u0006\u0010=\u001a\u00020*¢\u0006\u0004\b@\u0010-J\u0015\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0010¢\u0006\u0004\bB\u0010\u0013J\u0015\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0010¢\u0006\u0004\bD\u0010\u0013J\u0015\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0010¢\u0006\u0004\bF\u0010\u0013J\u0015\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0010¢\u0006\u0004\bH\u0010\u0013J\r\u0010I\u001a\u00020\u0010¢\u0006\u0004\bI\u0010\u0015J\u0015\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0010¢\u0006\u0004\bK\u0010\u0013J\u0015\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0010¢\u0006\u0004\bM\u0010\u0013J\r\u0010N\u001a\u00020\u0010¢\u0006\u0004\bN\u0010\u0015J\u0015\u0010P\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0010¢\u0006\u0004\bP\u0010\u0013J\r\u0010Q\u001a\u00020\u0010¢\u0006\u0004\bQ\u0010\u0015J\u0015\u0010R\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0010¢\u0006\u0004\bR\u0010\u0013J\r\u0010S\u001a\u00020\u0010¢\u0006\u0004\bS\u0010\u0015J\u0015\u0010T\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0010¢\u0006\u0004\bT\u0010\u0013J\u0015\u0010U\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0010¢\u0006\u0004\bU\u0010\u0013J\r\u0010V\u001a\u00020\u0010¢\u0006\u0004\bV\u0010\u0015J\r\u0010W\u001a\u000201¢\u0006\u0004\bW\u00106J\u0017\u0010Y\u001a\u00020\u00072\b\u0010X\u001a\u0004\u0018\u000101¢\u0006\u0004\bY\u00104J\u000f\u0010Z\u001a\u0004\u0018\u000101¢\u0006\u0004\bZ\u00106J\u0013\u0010\\\u001a\b\u0012\u0004\u0012\u0002010[¢\u0006\u0004\b\\\u0010]J\u0017\u0010`\u001a\u00020\u00072\u0006\u0010_\u001a\u00020^H\u0007¢\u0006\u0004\b`\u0010aJ\u0017\u0010c\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0010H\u0002¢\u0006\u0004\bc\u0010\u0013J\u000f\u0010d\u001a\u00020\u0010H\u0002¢\u0006\u0004\bd\u0010\u0015J\u0017\u0010f\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u0010H\u0002¢\u0006\u0004\bf\u0010\u0013J\u000f\u0010g\u001a\u00020\u0010H\u0002¢\u0006\u0004\bg\u0010\u0015R?\u0010r\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0007\u0018\u00010h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR?\u0010v\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0007\u0018\u00010h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010m\u001a\u0004\bt\u0010o\"\u0004\bu\u0010qR?\u0010z\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u0007\u0018\u00010h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010m\u001a\u0004\bx\u0010o\"\u0004\by\u0010qRE\u0010\u007f\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0[¢\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b({\u0012\u0004\u0012\u00020\u0007\u0018\u00010h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010m\u001a\u0004\b}\u0010o\"\u0004\b~\u0010q¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/calendar/MaterialCalendarView;", "getCalendarView", "()Lcom/obric/oui/calendar/MaterialCalendarView;", "Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "visibility", "", "setOutOfMonthVisibility", "(Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;)V", "", "getSelectTimestamp", "()J", "selectedTime", "setCurrentTimeMillis", "(J)V", "", "mode", "setSelectionMode", "(I)V", "getSelectionMode", "()I", "color", "setSelectionColor", "getSelectionColor", "resourceId", "setDateTextAppearance", "setWeekDayTextAppearance", "Lyq/a;", "formatter", "setDayFormatter", "(Lyq/a;)V", "setDayFormatterContentDescription", "Lyq/c;", "setWeekDayFormatter", "(Lyq/c;)V", "", "", "weekDayLabels", "setWeekDayLabels", "([Ljava/lang/CharSequence;)V", "arrayRes", "", "showWeekDays", "setShowWeekDays", "(Z)V", "Lcom/obric/oui/calendar/CalendarMode;", "getCalendarMode", "()Lcom/obric/oui/calendar/CalendarMode;", "Lcom/obric/oui/calendar/CalendarDay;", "minDate", "setMinimumDate", "(Lcom/obric/oui/calendar/CalendarDay;)V", "getMinimumDate", "()Lcom/obric/oui/calendar/CalendarDay;", "maxDate", "setMaximumDate", "getMaximumDate", "showOtherDates", "setShowOtherDates", "getShowOtherDates", "enabled", "setAllowClickDaysOutsideCurrentMonth", "setPagingEnabled", "setDynamicHeightEnabled", "sizePx", "setTileSize", "sizeDp", "setTileSizeDp", "widthPx", "setTileWidth", "widthDp", "setTileWidthDp", "getTileWidth", "heightPx", "setTileHeight", "heightDp", "setTileHeightDp", "getTileHeight", "spacingPx", "setTileHSpacing", "getTileHSpacing", "setTileVSpacing", "getTileVSpacing", "setWeekDaysHeight", "setWeekDaysHeightDp", "getWeekDaysHeight", "getCurrentDate", "date", "setSelectedDate", "getSelectedDate", "", "getSelectedDates", "()Ljava/util/List;", "Ljava/time/DayOfWeek;", "firstDayOfWeek", "setFirstDayOfWeek", "(Ljava/time/DayOfWeek;)V", "second", "setSecond", "getSecond", "millisecond", "setMillisecond", "getMillisecond", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "time", ExifInterface.LONGITUDE_EAST, "Lkotlin/jvm/functions/Function1;", "getOnMonthChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnMonthChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onMonthChangedListener", "F", "getOnDateChangedListener", "setOnDateChangedListener", "onDateChangedListener", "G", "getOnDateLongClickListener", "setOnDateLongClickListener", "onDateLongClickListener", "times", "H", "getOnRangeSelectedListener", "setOnRangeSelectedListener", "onRangeSelectedListener", "DatePickerMode", "OutOfMonthVisibility", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODatePickerView extends ConstraintLayout {
    public static final /* synthetic */ int I = 0;
    public boolean A;
    public OutOfMonthVisibility B;
    public androidx.core.content.res.a C;
    public String D;
    public Function1 E;
    public Function1 F;
    public Function1 G;
    public Function1 H;
    public final DatePickerMode g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MaterialCalendarView f12203n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f12204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f12205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f12206q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FrameLayout f12207r;
    public final OReelPickerMulti s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public jp.d f12208t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12209u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public jp.d f12210v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public jp.d f12211w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ObjectAnimator f12212x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ObjectAnimator f12213y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12214z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "", "BOARD_SHEET", "NARROW_SHEET", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DatePickerMode extends Enum<DatePickerMode> {
        public static final DatePickerMode BOARD_SHEET = null;

        @Deprecated(message = "this mode is deprecated, please use BOARD_SHEET")
        public static final DatePickerMode NARROW_SHEET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DatePickerMode[] f12215a = null;

        static {
            DatePickerMode r5 = new DatePickerMode("BOARD_SHEET", 0);
            BOARD_SHEET = r5;
            DatePickerMode r10 = new DatePickerMode("NARROW_SHEET", 1);
            NARROW_SHEET = r10;
            f12215a = new DatePickerMode[]{r5, r10};
        }

        public static DatePickerMode valueOf(String r5) {
            return (DatePickerMode) Enum.valueOf(DatePickerMode.class, r5);
        }

        public static DatePickerMode[] values() {
            return (DatePickerMode[]) f12215a.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "", "GREY", "HIDE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum OutOfMonthVisibility extends Enum<OutOfMonthVisibility> {
        public static final OutOfMonthVisibility GREY = null;
        public static final OutOfMonthVisibility HIDE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OutOfMonthVisibility[] f12216a = null;

        static {
            OutOfMonthVisibility r5 = new OutOfMonthVisibility("GREY", 0);
            GREY = r5;
            OutOfMonthVisibility r10 = new OutOfMonthVisibility("HIDE", 1);
            HIDE = r10;
            f12216a = new OutOfMonthVisibility[]{r5, r10};
        }

        public static OutOfMonthVisibility valueOf(String r5) {
            return (OutOfMonthVisibility) Enum.valueOf(OutOfMonthVisibility.class, r5);
        }

        public static OutOfMonthVisibility[] values() {
            return (OutOfMonthVisibility[]) f12216a.clone();
        }
    }

    @JvmOverloads
    public ODatePickerView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 30);
    }

    private final int getMillisecond() {
        return this.f12201l;
    }

    private final int getSecond() {
        return this.f12200k;
    }

    public static String n(long r5, String r10) {
        Date r11 = new Date(r5);
        SimpleDateFormat r12 = new SimpleDateFormat(r10, Locale.getDefault());
        r12.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        return r12.format(r11);
    }

    public static long o(CalendarDay r10) {
        Calendar r11 = Calendar.getInstance();
        int r5 = r10.f12167a.getYear();
        LocalDate r12 = r10.f12167a;
        r11.set(r5, r12.getMonthValue() - 1, r12.getDayOfMonth(), 0, 0, 0);
        r11.set(14, 0);
        return r11.getTimeInMillis();
    }

    private final void setMillisecond(int r5) {
        this.f12201l = r5;
    }

    private final void setSecond(int r5) {
        this.f12200k = r5;
    }

    public final void e() {
        int r5 = t.f12295a[this.B.ordinal()];
        boolean r10 = false;
        if (r5 != 1) goto L5;
        int r11 = 0;
    L10:
        MaterialCalendarView r12 = this.f12203n;
        r12.setShowOtherDates(r11);
        if (this.B != OutOfMonthVisibility.GREY) goto L13;
        r10 = true;
    L13:
        r12.setAllowClickDaysOutsideCurrentMonth(r10);
        return;
    L5:
        if (r5 != 2) goto L8;
        r11 = 7;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final CalendarMode getCalendarMode() {
        return this.f12203n.getCalendarMode();
    }

    public final MaterialCalendarView getCalendarView() {
        return this.f12203n;
    }

    public final CalendarDay getCurrentDate() {
        return this.f12203n.getCurrentDate();
    }

    public final CalendarDay getMaximumDate() {
        return this.f12203n.getMaximumDate();
    }

    public final CalendarDay getMinimumDate() {
        return this.f12203n.getMinimumDate();
    }

    public final Function1<Long, Unit> getOnDateChangedListener() {
        return this.F;
    }

    public final Function1<Long, Unit> getOnDateLongClickListener() {
        return this.G;
    }

    public final Function1<Long, Unit> getOnMonthChangedListener() {
        return this.E;
    }

    public final Function1<List<Long>, Unit> getOnRangeSelectedListener() {
        return this.H;
    }

    public final long getSelectTimestamp() {
        Calendar r10 = Calendar.getInstance();
        CalendarDay r5 = this.f12203n.getSelectedDates().get(0);
        int r11 = r5.f12167a.getYear();
        LocalDate r12 = r5.f12167a;
        int r13 = r12.getMonthValue() - 1;
        int r14 = r12.getDayOfMonth();
        r10.set(13, getSecond());
        r10.set(14, getMillisecond());
        r10.set(r11, r13, r14, 0, 0);
        return r10.getTimeInMillis();
    }

    public final CalendarDay getSelectedDate() {
        return this.f12203n.getSelectedDate();
    }

    public final List<CalendarDay> getSelectedDates() {
        return this.f12203n.getSelectedDates();
    }

    @ColorInt
    public final int getSelectionColor() {
        return this.f12203n.getSelectionColor();
    }

    public final int getSelectionMode() {
        return this.f12203n.getSelectionMode();
    }

    public final int getShowOtherDates() {
        return this.f12203n.getShowOtherDates();
    }

    public final int getTileHSpacing() {
        return this.f12203n.getTileHSpacing();
    }

    public final int getTileHeight() {
        return this.f12203n.getTileHeight();
    }

    public final int getTileVSpacing() {
        return this.f12203n.getTileVSpacing();
    }

    public final int getTileWidth() {
        return this.f12203n.getTileWidth();
    }

    public final int getWeekDaysHeight() {
        return this.f12203n.getWeekDaysHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r5 = getParent();
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        ViewGroup r10 = (ViewGroup) r5;
        if ((r10 instanceof OSheetContentFrameLayout) == false) goto L35;
        OSheetContentFrameLayout r11 = (OSheetContentFrameLayout) r10;
        if (r11.getId() != R$id.content_container) goto L36;
        int r12 = r11.getPaddingLeft();
        int r13 = r11.getPaddingTop();
        int r14 = r11.getPaddingRight();
        int r15 = r11.getPaddingBottom();
        int r16 = t.f12297c[this.g.ordinal()];
        if (r16 == 1) goto L26;
        if (r16 == 2) goto L17;
        return;
    L17:
        if (r12 == com.lynx.tasm.utils.a.B(0, this)) goto L19;
    L24:
        StringBuilder r17 = j0.v("onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [", r12, r13, ", ", ", ");
        r17.append(r14);
        r17.append(", ");
        r17.append(r15);
        r17.append(']');
        ps.a.a("DatePickerView", r17.toString());
        r11.setPadding(0, 0, 0, 0);
        return;
    L19:
        if (r13 != com.lynx.tasm.utils.a.B(0, this)) goto L24;
        if (r14 != com.lynx.tasm.utils.a.B(0, this)) goto L24;
        if (r15 != com.lynx.tasm.utils.a.B(0, this)) goto L24;
        return;
    L26:
        if (r12 == com.lynx.tasm.utils.a.B(16, this)) goto L28;
    L33:
        StringBuilder r18 = j0.v("onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [", r12, r13, ", ", ", ");
        r18.append(r14);
        r18.append(", ");
        r18.append(r15);
        r18.append(']');
        ps.a.a("DatePickerView", r18.toString());
        r11.setPadding(com.lynx.tasm.utils.a.B(16, this), com.lynx.tasm.utils.a.B(6, this), com.lynx.tasm.utils.a.B(16, this), com.lynx.tasm.utils.a.B(16, this));
        return;
    L28:
        if (r13 != com.lynx.tasm.utils.a.B(6, this)) goto L33;
        if (r14 != com.lynx.tasm.utils.a.B(16, this)) goto L33;
        if (r15 != com.lynx.tasm.utils.a.B(16, this)) goto L33;
        return;
    L36:
        return;
    L35:
        return;
    L6:
        if ((r5 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.D = getResources().getString(R$string.oui_date_picker_date_format);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.core.content.res.a r5 = this.C;
        if (r5 == null) goto L6;
        removeCallbacks(r5);
    L6:
        this.C = null;
    }

    public final void setAllowClickDaysOutsideCurrentMonth(boolean r5) {
        this.f12203n.setAllowClickDaysOutsideCurrentMonth(r5);
    }

    public final void setCurrentTimeMillis(long r12) {
        this.f12202m = r12;
        Calendar r13 = Calendar.getInstance();
        String r14 = "默认选中的时间:" + this.f12202m + " , mSelectTime:" + this.f12202m;
        Intrinsics.checkNotNullParameter("DatePickerView", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        Log.i("DatePickerView", r14);
        r13.setTimeInMillis(this.f12202m);
        int r5 = r13.get(1);
        int r10 = r13.get(2) + 1;
        int r15 = r13.get(5);
        int r11 = r13.get(11);
        int r16 = r13.get(12);
        int r17 = r13.get(13);
        int r18 = r13.get(14);
        StringBuilder r19 = j0.v("转化时间year:", r5, r10, ",month:", ",day:");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r19, r15, ",hour:", r11, ",minute:");
        r19.append(r16);
        r19.append(", selectDate:");
        r19.append(new CalendarDay(r5, r10, r15));
        String r20 = r19.toString();
        Intrinsics.checkNotNullParameter("DatePickerView", "tag");
        Intrinsics.checkNotNullParameter(r20, "msg");
        Log.i("DatePickerView", r20);
        String r21 = n(this.f12202m, this.D);
        CalendarDay r22 = new CalendarDay(r5, r10, r15);
        MaterialCalendarView r23 = this.f12203n;
        r23.setCurrentDate(r22);
        r23.setSelectedDate(new CalendarDay(r5, r10, r15));
        this.f12204o.setText(r21);
        setSecond(r17);
        setMillisecond(r18);
    }

    public final void setDateTextAppearance(@StyleRes int r5) {
        this.f12203n.setDateTextAppearance(r5);
    }

    public final void setDayFormatter(yq.a r5) {
        this.f12203n.setDayFormatter(r5);
    }

    public final void setDayFormatterContentDescription(yq.a r5) {
        this.f12203n.setDayFormatterContentDescription(r5);
    }

    public final void setDynamicHeightEnabled(boolean r5) {
        this.f12203n.setDynamicHeightEnabled(r5);
    }

    @RequiresApi(30)
    public final void setFirstDayOfWeek(DayOfWeek r5) {
        Intrinsics.checkNotNullParameter(r5, "firstDayOfWeek");
        switch(t.f12296b[r5.ordinal()]) {
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
        org.threeten.bp.DayOfWeek r10 = org.threeten.bp.DayOfWeek.SATURDAY;
    L13:
        m r11 = this.f12203n.B;
        m r12 = new m(r11.g, r11, false);
        r12.f12286b = r10;
        r12.a();
        return;
    L7:
        r10 = org.threeten.bp.DayOfWeek.FRIDAY;
        goto L13
    L8:
        r10 = org.threeten.bp.DayOfWeek.THURSDAY;
        goto L13
    L9:
        r10 = org.threeten.bp.DayOfWeek.WEDNESDAY;
        goto L13
    L10:
        r10 = org.threeten.bp.DayOfWeek.TUESDAY;
        goto L13
    L11:
        r10 = org.threeten.bp.DayOfWeek.MONDAY;
        goto L13
    L12:
        r10 = org.threeten.bp.DayOfWeek.SUNDAY;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void setMaximumDate(CalendarDay r5) {
        m r10 = this.f12203n.B;
        m r11 = new m(r10.g, r10, false);
        r11.d = r5;
        r11.a();
    }

    public final void setMinimumDate(CalendarDay r5) {
        m r10 = this.f12203n.B;
        m r11 = new m(r10.g, r10, false);
        r11.f12287c = r5;
        r11.a();
    }

    public final void setOnDateChangedListener(Function1<? super Long, Unit> r5) {
        this.F = r5;
    }

    public final void setOnDateLongClickListener(Function1<? super Long, Unit> r5) {
        this.G = r5;
    }

    public final void setOnMonthChangedListener(Function1<? super Long, Unit> r5) {
        this.E = r5;
    }

    public final void setOnRangeSelectedListener(Function1<? super List<Long>, Unit> r5) {
        this.H = r5;
    }

    public final void setOutOfMonthVisibility(OutOfMonthVisibility r5) {
        Intrinsics.checkNotNullParameter(r5, "visibility");
        this.B = r5;
        e();
    }

    public final void setPagingEnabled(boolean r5) {
        this.f12203n.setPagingEnabled(r5);
    }

    public final void setSelectedDate(CalendarDay r5) {
        this.f12203n.setSelectedDate(r5);
    }

    public final void setSelectionColor(@ColorInt int r5) {
        this.f12203n.setSelectionColor(r5);
    }

    public final void setSelectionMode(int r5) {
        this.f12203n.setSelectionMode(r5);
    }

    public final void setShowOtherDates(int r5) {
        this.f12203n.setShowOtherDates(r5);
    }

    public final void setShowWeekDays(boolean r5) {
        m r10 = this.f12203n.B;
        m r11 = new m(r10.g, r10, false);
        r11.f = r5;
        r11.a();
    }

    public final void setTileHSpacing(int r5) {
        this.f12203n.setTileHSpacing(r5);
    }

    public final void setTileHeight(int r5) {
        this.f12203n.setTileHeight(r5);
    }

    public final void setTileHeightDp(int r5) {
        this.f12203n.setTileHeightDp(r5);
    }

    public final void setTileSize(int r5) {
        this.f12203n.setTileSize(r5);
    }

    public final void setTileSizeDp(int r5) {
        this.f12203n.setTileSizeDp(r5);
    }

    public final void setTileVSpacing(int r5) {
        this.f12203n.setTileVSpacing(r5);
    }

    public final void setTileWidth(int r5) {
        this.f12203n.setTileWidth(r5);
    }

    public final void setTileWidthDp(int r5) {
        this.f12203n.setTileWidthDp(r5);
    }

    public final void setWeekDayFormatter(yq.c r5) {
        this.f12203n.setWeekDayFormatter(r5);
    }

    public final void setWeekDayLabels(CharSequence[] r5) {
        Intrinsics.checkNotNullParameter(r5, "weekDayLabels");
        this.f12203n.setWeekDayLabels(r5);
    }

    public final void setWeekDayTextAppearance(@StyleRes int r5) {
        this.f12203n.setWeekDayTextAppearance(r5);
    }

    public final void setWeekDaysHeight(int r5) {
        this.f12203n.setWeekDaysHeight(r5);
    }

    public final void setWeekDaysHeightDp(int r5) {
        this.f12203n.setWeekDaysHeightDp(r5);
    }

    @JvmOverloads
    public ODatePickerView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 28);
    }

    public final void setWeekDayLabels(@ArrayRes int r5) {
        this.f12203n.setWeekDayLabels(r5);
    }

    @JvmOverloads
    public ODatePickerView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 24);
    }

    public ODatePickerView(Context r20, AttributeSet r21, int r22, int r23) {
        if ((r23 & 2) == 0) goto L5;
        AttributeSet r5 = null;
    L7:
        if ((r23 & 4) == 0) goto L9;
        int r10 = 0;
    L10:
        DatePickerMode r11 = DatePickerMode.BOARD_SHEET;
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r11, "datePickerMode");
        super(r20, r5, r10);
        this.g = r11;
        this.f12197h = false;
        CalendarDay.d().f12167a.getDayOfMonth();
        this.f12198i = CalendarDay.d().f12167a.getYear();
        this.f12199j = CalendarDay.d().f12167a.getMonthValue();
        this.B = OutOfMonthVisibility.GREY;
        View.inflate(r20, R$layout.o_date_picker_view_default, this);
        this.D = getResources().getString(R$string.oui_date_picker_date_format);
        MaterialCalendarView r12 = (MaterialCalendarView) findViewById(R$id.calendarView);
        this.f12203n = r12;
        ImageView r13 = (ImageView) findViewById(R$id.previousBtn);
        ImageView r14 = (ImageView) findViewById(R$id.nextBtn);
        this.f12204o = (TextView) findViewById(R$id.currentDateTextView);
        this.f12205p = findViewById(R$id.ll_open_year_month);
        this.f12206q = (ImageView) findViewById(R$id.iv_open_year_month);
        this.f12207r = (FrameLayout) findViewById(R$id.fl_calendar_container);
        Calendar r15 = Calendar.getInstance();
        r12.setTopbarVisible(false);
        final int r16 = 0;
        r13.setOnClickListener(new p(this, r16));
        final int r17 = 1;
        r14.setOnClickListener(new p(this, r17));
        r12.setOnMonthChangedListener(new q(r15, this));
        r12.setOnDateChangedListener(new q(r15, this));
        r12.setOnDateLongClickListener(new r(this));
        r12.setOnRangeSelectedListener(new r(this));
        e();
        ug.d r18 = new ug.d(13);
        Context r19 = getContext();
        int r24 = this.f12198i;
        int r25 = com.lynx.tasm.utils.a.B(164, this);
        Intrinsics.checkNotNullParameter(r19, "context");
        String r26 = r19.getString(R$string.oui_reel_picker_year_tag);
        Intrinsics.checkNotNullParameter(r26, "suffix");
        ArrayList r110 = new ArrayList();
        int r111 = 1900;
    L11:
        int r112 = r111 + 1;
        r110.add(Intrinsics.stringPlus(StringsKt.w(2, String.valueOf(r111)), r26));
        if (r111 == 2100) goto L13;
        r111 = r112;
        goto L11
    L13:
        ug.d.j(r18, 1001, r110, Math.max(0, Math.min(r24 - 1900, r110.size() - 1)), Integer.valueOf(r25));
        Context r113 = getContext();
        int r27 = this.f12199j;
        int r114 = com.lynx.tasm.utils.a.B(164, this);
        Intrinsics.checkNotNullParameter(r113, "context");
        Intrinsics.checkNotNullParameter(r113, "context");
        ArrayList r28 = new ArrayList();
        int r29 = 1;
    L14:
        int r30 = r29 + 1;
        switch(r29) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            default: goto L16;
        };
    L16:
        int r115 = R$string.oui_reel_picker_month_def;
    L29:
        r28.add(r113.getString(r115));
        if (r29 == 12) goto L31;
        r29 = r30;
        goto L14
    L31:
        ug.d.j(r18, PointerIconCompat.TYPE_HAND, r28, Math.max(0, Math.min(r27 - 1, 11)), Integer.valueOf(r114));
        Context r31 = getContext();
        Intrinsics.checkNotNullParameter(r31, "$this$getScreenWidth");
        DisplayMetrics r32 = r31.getResources().getDisplayMetrics();
        if (r32 == null) goto L34;
        int r33 = r32.widthPixels;
    L35:
        r18.f22358c = Integer.valueOf(r33);
        r18.d = Integer.valueOf(com.lynx.tasm.utils.a.B(258, this));
        s r34 = new s(this);
        Intrinsics.checkNotNullParameter(r34, "listener");
        r18.f22357b = r34;
        Context r35 = getContext();
        Intrinsics.checkNotNullParameter(r35, "context");
        ArrayList r36 = new ArrayList();
        Integer r37 = (Integer) r18.f22358c;
        if (r37 != null) goto L38;
        int r38 = -1;
    L39:
        Integer r116 = (Integer) r18.d;
        if (r116 != null) goto L42;
        int r117 = -1;
    L43:
        Iterator r39 = ((ArrayList) r18.e).iterator();
    L45:
        if (r39.hasNext() == false) goto L47;
        yr.a r118 = (yr.a) r39.next();
        Intrinsics.checkNotNullParameter(r118, "reel");
        r36.add(r118);
        goto L45
    L47:
        Intrinsics.checkNotNullParameter(r35, "context");
        if (r38 != (-1)) goto L50;
        r38 = com.lynx.tasm.utils.a.p(328, r35);
    L50:
        if (r117 != (-1)) goto L52;
        r117 = com.lynx.tasm.utils.a.p(240, r35);
    L52:
        OReelPickerMulti r40 = new OReelPickerMulti(r35, null, 0);
        r40.setLayoutParams(new LinearLayout.LayoutParams(r38, r117));
        int r119 = r117 - (com.lynx.tasm.utils.a.p(16, r35) * 2);
        r36.size();
        ArrayList r41 = r40.f14039h;
        r41.clear();
        LinearLayout r42 = r40.g;
        r42.removeAllViews();
        Iterator r43 = r36.iterator();
    L54:
        if (r43.hasNext() == false) goto L60;
        Integer r120 = ((yr.a) r43.next()).e;
        if (r120 == null) goto L58;
        LinearLayout.LayoutParams r121 = new LinearLayout.LayoutParams(r120.intValue(), -1);
    L59:
        WheelView r122 = new WheelView(r40.getContext(), null, 6, 0);
        r122.setLayoutParams(r121);
        r122.setMinimumHeight(r119);
        r122.setCyclic(false);
        r42.addView(r122);
        r41.add(r122);
        goto L54
    L58:
        r121 = new LinearLayout.LayoutParams(-2, -1);
        goto L59
    L60:
        Iterator r44 = r36.iterator();
        int r45 = 0;
    L62:
        if (r44.hasNext() == false) goto L87;
        Object r46 = r44.next();
        int r47 = r45 + 1;
        if (r45 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        yr.a r48 = (yr.a) r46;
        Intrinsics.checkNotNullParameter(r48, "reel");
        WheelView r49 = r40.a(r45);
        if (r49 == null) goto L86;
        r49.setItemCount(5);
        String r50 = r48.f23321c;
        if (r50 == null) goto L73;
        r49.setTagText(r50);
    L73:
        Integer r51 = r48.g;
        if (r51 == null) goto L77;
        r49.setTagGap(Integer.valueOf(r51.intValue()));
    L77:
        Integer r52 = r48.f;
        if (r52 == null) goto L81;
        r49.setMinimumWidth(r52.intValue());
    L81:
        r49.setOnWheelChangedListener(new w8.f(r48));
        ArrayList r53 = r48.f23320b;
        int r54 = RangesKt.coerceIn(r48.f23322h, 0, RangesKt.coerceAtLeast(r53.size() - 1, 0));
        ArrayList r55 = new ArrayList(CollectionsKt.h(r53));
        Iterator r56 = r53.iterator();
    L83:
        if (r56.hasNext() == false) goto L85;
        r55.add((String) r56.next());
        goto L83
    L85:
        r49.j(r55, Integer.valueOf(r54));
    L86:
        r45 = r47;
        goto L62
    L87:
        FrameLayout.LayoutParams r57 = new FrameLayout.LayoutParams(-1, r40.getLayoutParams().height);
        r57.gravity = 17;
        r40.setLayoutParams(r57);
        r40.setAlpha(0.0f);
        r40.setVisibility(4);
        this.f12207r.addView(r40);
        this.s = r40;
        final int r58 = 2;
        this.f12205p.setOnClickListener(new p(this, r58));
        return;
    L42:
        r117 = r116.intValue();
        goto L43
    L38:
        r38 = r37.intValue();
        goto L39
    L34:
        r33 = 0;
        goto L35
    L17:
        r115 = R$string.oui_reel_picker_month_dec;
        goto L29
    L18:
        r115 = R$string.oui_reel_picker_month_nov;
        goto L29
    L19:
        r115 = R$string.oui_reel_picker_month_oct;
        goto L29
    L20:
        r115 = R$string.oui_reel_picker_month_sep;
        goto L29
    L21:
        r115 = R$string.oui_reel_picker_month_aug;
        goto L29
    L22:
        r115 = R$string.oui_reel_picker_month_jul;
        goto L29
    L23:
        r115 = R$string.oui_reel_picker_month_jun;
        goto L29
    L24:
        r115 = R$string.oui_reel_picker_month_may;
        goto L29
    L25:
        r115 = R$string.oui_reel_picker_month_apr;
        goto L29
    L26:
        r115 = R$string.oui_reel_picker_month_mar;
        goto L29
    L27:
        r115 = R$string.oui_reel_picker_month_feb;
        goto L29
    L28:
        r115 = R$string.oui_reel_picker_month_jan;
        goto L29
    L9:
        r10 = r22;
        goto L10
    L5:
        r5 = r21;
        goto L7
    }
}
