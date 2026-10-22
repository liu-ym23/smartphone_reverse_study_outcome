package com.obric.oui.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0002IJB1\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u00020\u0005\u0012\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0014J0\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0014J\b\u0010\u001e\u001a\u00020\u0002H\u0014R?\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R1\u0010/\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00170\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010$R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00103R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00103R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R?\u0010>\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010$\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(¨\u0006K"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "setDefaultDate", "", "second", "setSecond", "getSecond", "millisecond", "setMillisecond", "getMillisecond", "", "timestamp", "", "format", "formatDate13", "getSelectTimestamp", "selectedTime", "setCurrentTimeMillis", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "onAttachedToWindow", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, OaidModel.KEY_TIME, "onDateChangedListener", "Lkotlin/jvm/functions/Function1;", "getOnDateChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnDateChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "TAG$1", "Ljava/lang/String;", "TAG", "Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "mDatePickerMode", "Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "confirmClickListener", "Lcom/obric/oui/calendar/MaterialCalendarView;", "calendarView", "Lcom/obric/oui/calendar/MaterialCalendarView;", "I", "Landroid/widget/TextView;", "currentDateTextView", "Landroid/widget/TextView;", "currentDayOfMonth", "mSelectTime", "J", "Landroid/widget/ImageView;", "nextBtn", "Landroid/widget/ImageView;", "previousBtn", "onMonthChangedListener", "getOnMonthChangedListener", "setOnMonthChangedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/calendar/ODatePickerView$DatePickerMode;)V", "Companion", "a", "DatePickerMode", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ODatePickerView extends ConstraintLayout {
    public static final a Companion = null;
    private static final double HEIGHT_RATIO = 0.9d;
    private static final String TAG = "DatePickerView";
    private final String TAG$1;
    private MaterialCalendarView calendarView;
    private final Function1<Long, Boolean> confirmClickListener;
    private TextView currentDateTextView;
    private int currentDayOfMonth;
    private DatePickerMode mDatePickerMode;
    private long mSelectTime;
    private int millisecond;
    private ImageView nextBtn;
    private Function1<? super Long, Unit> onDateChangedListener;
    private Function1<? super Long, Unit> onMonthChangedListener;
    private ImageView previousBtn;
    private int second;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "", "<init>", "(Ljava/lang/String;I)V", "BOARD_SHEET", "NARROW_SHEET", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DatePickerMode extends Enum<DatePickerMode> {
        private static final /* synthetic */ DatePickerMode[] $VALUES = null;
        public static final DatePickerMode BOARD_SHEET = null;
        public static final DatePickerMode NARROW_SHEET = null;

        static {
            DatePickerMode r10 = new DatePickerMode("BOARD_SHEET", 0);
            BOARD_SHEET = r10;
            DatePickerMode r11 = new DatePickerMode("NARROW_SHEET", 1);
            NARROW_SHEET = r11;
            $VALUES = new DatePickerMode[]{r10, r11};
        }

        private DatePickerMode(String r10, int r11) {
            super(r10, r11);
        }

        public static DatePickerMode valueOf(String r10) {
            return (DatePickerMode) Enum.valueOf(DatePickerMode.class, r10);
        }

        public static DatePickerMode[] values() {
            return (DatePickerMode[]) $VALUES.clone();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ODatePickerView f6327c;

        b(ODatePickerView r10) {
            this.f6327c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ODatePickerView.access$getCalendarView$p(this.f6327c).y();
        }
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ODatePickerView f6328c;

        c(ODatePickerView r10) {
            this.f6328c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ODatePickerView.access$getCalendarView$p(this.f6328c).x();
        }
    }

    static final class d implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODatePickerView f6329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Calendar f6330b;

        d(ODatePickerView r10, Calendar r11) {
            this.f6329a = r10;
            this.f6330b = r11;
        }

        @Override // com.obric.oui.calendar.l
        public final void a(MaterialCalendarView r10, CalendarDay r11) {
            com.obric.oui.common.util.d.f6398b.d(ODatePickerView.access$getTAG$p(this.f6329a), "setOnMonthChangedListener widget:" + r10 + ",date:" + r11);
            Calendar r12 = this.f6330b;
            Intrinsics.checkNotNullExpressionValue(r11, "date");
            r12.set(r11.getYear(), r11.getMonth() - 1, 1);
            Calendar r13 = this.f6330b;
            Intrinsics.checkNotNullExpressionValue(r13, "calendar");
            long r14 = r13.getTimeInMillis();
            ODatePickerView r15 = this.f6329a;
            String r16 = r15.getResources().getString(u8.j.date_picker_date_format);
            Intrinsics.checkNotNullExpressionValue(r16, "resources.getString(R.st….date_picker_date_format)");
            ODatePickerView.access$getCurrentDateTextView$p(this.f6329a).setText(ODatePickerView.access$formatDate13(r15, r14, r16));
            ODatePickerView.access$getCalendarView$p(this.f6329a).setSelectedDate(CalendarDay.from(r11.getYear(), r11.getMonth(), 1));
            Function1<Long, Unit> r17 = this.f6329a.getOnMonthChangedListener();
            if (r17 == null) goto L6;
            Unit r18 = r17.invoke(Long.valueOf(r14));
            return;
        }
    }

    static final class e implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ODatePickerView f6331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Calendar f6332b;

        e(ODatePickerView r10, Calendar r11) {
            this.f6331a = r10;
            this.f6332b = r11;
        }

        @Override // com.obric.oui.calendar.k
        public final void a(MaterialCalendarView r10, CalendarDay r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "widget");
            Intrinsics.checkNotNullParameter(r11, "date");
            com.obric.oui.common.util.d.f6398b.d(ODatePickerView.access$getTAG$p(this.f6331a), "setOnDateChangedListener widget:" + r10 + ",date:" + r11 + ",selected:" + r12);
            this.f6332b.set(r11.getYear(), r11.getMonth() + (-1), r11.getDay());
            Calendar r13 = this.f6332b;
            Intrinsics.checkNotNullExpressionValue(r13, "calendar");
            long r14 = r13.getTimeInMillis();
            ODatePickerView r15 = this.f6331a;
            String r16 = r15.getResources().getString(u8.j.date_picker_date_format);
            Intrinsics.checkNotNullExpressionValue(r16, "resources.getString(R.st….date_picker_date_format)");
            ODatePickerView.access$getCurrentDateTextView$p(this.f6331a).setText(ODatePickerView.access$formatDate13(r15, r14, r16));
            ODatePickerView.access$setCurrentDayOfMonth$p(this.f6331a, r11.getDay());
            Function1<Long, Unit> r17 = this.f6331a.getOnDateChangedListener();
            if (r17 == null) goto L6;
            Unit r18 = r17.invoke(Long.valueOf(r14));
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    @JvmOverloads
    public ODatePickerView(Context r10) {
        this(r10, null, 0, null, 14, null);
    }

    @JvmOverloads
    public ODatePickerView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, null, 12, null);
    }

    @JvmOverloads
    public ODatePickerView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, null, 8, null);
    }

    @JvmOverloads
    public ODatePickerView(Context r10, AttributeSet r11, int r12, DatePickerMode r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "mDatePickerMode");
        super(r10, r11, r12);
        this.mDatePickerMode = r13;
        this.TAG$1 = TAG;
        CalendarDay r14 = CalendarDay.today();
        Intrinsics.checkNotNullExpressionValue(r14, "CalendarDay.today()");
        this.currentDayOfMonth = r14.getDay();
        this.confirmClickListener = ODatePickerView$confirmClickListener$1.INSTANCE;
        if (this.mDatePickerMode != DatePickerMode.NARROW_SHEET) goto L5;
        int r15 = u8.h.o_date_picker_view_narrow;
    L6:
        ViewGroup.inflate(r10, r15, this);
        View r16 = findViewById(u8.f.calendarView);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.calendarView)");
        this.calendarView = (MaterialCalendarView) r16;
        View r17 = findViewById(u8.f.previousBtn);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.previousBtn)");
        this.previousBtn = (ImageView) r17;
        View r18 = findViewById(u8.f.nextBtn);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.nextBtn)");
        this.nextBtn = (ImageView) r18;
        View r19 = findViewById(u8.f.currentDateTextView);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.currentDateTextView)");
        this.currentDateTextView = (TextView) r19;
        initView();
        return;
    L5:
        r15 = u8.h.o_date_picker_view_default;
        goto L6
    }

    public /* synthetic */ ODatePickerView(Context r10, AttributeSet r11, int r12, DatePickerMode r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = DatePickerMode.BOARD_SHEET;
    L11:
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ String access$formatDate13(ODatePickerView r10, long r11, String r12) {
        return r10.formatDate13(r11, r12);
    }

    public static final /* synthetic */ MaterialCalendarView access$getCalendarView$p(ODatePickerView r10) {
        return r10.calendarView;
    }

    public static final /* synthetic */ TextView access$getCurrentDateTextView$p(ODatePickerView r10) {
        return r10.currentDateTextView;
    }

    public static final /* synthetic */ int access$getCurrentDayOfMonth$p(ODatePickerView r10) {
        return r10.currentDayOfMonth;
    }

    public static final /* synthetic */ String access$getTAG$p(ODatePickerView r10) {
        return r10.TAG$1;
    }

    public static final /* synthetic */ void access$setCalendarView$p(ODatePickerView r10, MaterialCalendarView r11) {
        r10.calendarView = r11;
    }

    public static final /* synthetic */ void access$setCurrentDateTextView$p(ODatePickerView r10, TextView r11) {
        r10.currentDateTextView = r11;
    }

    public static final /* synthetic */ void access$setCurrentDayOfMonth$p(ODatePickerView r10, int r11) {
        r10.currentDayOfMonth = r11;
    }

    private final String formatDate13(long r10, String r11) {
        Date r12 = new Date(r10);
        SimpleDateFormat r13 = new SimpleDateFormat(r11, Locale.getDefault());
        r13.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        String r14 = r13.format(r12);
        Intrinsics.checkNotNullExpressionValue(r14, "formattedData");
        String r15 = r14.substring(0, 4);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String…ing(startIndex, endIndex)");
        String r16 = r14.substring(5, 7);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String…ing(startIndex, endIndex)");
        return r15 + " 年 " + r16 + " 月";
    }

    private final int getMillisecond() {
        return this.millisecond;
    }

    private final int getSecond() {
        return this.second;
    }

    private final void initView() {
        Calendar r10 = Calendar.getInstance();
        this.calendarView.setTopbarVisible(false);
        this.previousBtn.setOnClickListener(new b(this));
        this.nextBtn.setOnClickListener(new c(this));
        this.calendarView.setOnMonthChangedListener(new d(this, r10));
        this.calendarView.setOnDateChangedListener(new e(this, r10));
        setDefaultDate();
    }

    private final void setDefaultDate() {
        Calendar r10 = Calendar.getInstance();
        com.obric.oui.common.util.d r11 = com.obric.oui.common.util.d.f6398b;
        r11.d(this.TAG$1, "默认选中的时间:" + this.mSelectTime + " , mSelectTime:" + this.mSelectTime);
        Intrinsics.checkNotNullExpressionValue(r10, "calendar");
        r10.setTimeInMillis(this.mSelectTime);
        int r12 = r10.get(1);
        int r13 = r10.get(2) + 1;
        int r14 = r10.get(5);
        int r15 = r10.get(11);
        int r16 = r10.get(12);
        int r17 = r10.get(13);
        int r18 = r10.get(14);
        this.currentDayOfMonth = r14;
        r11.d(this.TAG$1, "转化时间year:" + r12 + ",month:" + r13 + ",day:" + r14 + ",hour:" + r15 + ",minute:" + r16 + ", selectDate:" + CalendarDay.from(r12, r13, r14));
        long r19 = this.mSelectTime;
        String r20 = getResources().getString(u8.j.date_picker_date_format);
        Intrinsics.checkNotNullExpressionValue(r20, "resources.getString(R.st….date_picker_date_format)");
        String r21 = formatDate13(r19, r20);
        this.calendarView.setCurrentDate(CalendarDay.from(r12, r13, r14));
        this.calendarView.setSelectedDate(CalendarDay.from(r12, r13, r14));
        this.currentDateTextView.setText(r21);
        setSecond(r17);
        setMillisecond(r18);
    }

    private final void setMillisecond(int r10) {
        this.millisecond = r10;
    }

    private final void setSecond(int r10) {
        this.second = r10;
    }

    public final Function1<Long, Unit> getOnDateChangedListener() {
        return this.onDateChangedListener;
    }

    public final Function1<Long, Unit> getOnMonthChangedListener() {
        return this.onMonthChangedListener;
    }

    public final long getSelectTimestamp() {
        Calendar r10 = Calendar.getInstance();
        CalendarDay r11 = this.calendarView.getSelectedDates().get(0);
        Intrinsics.checkNotNullExpressionValue(r11, "selectDate");
        int r12 = r11.getYear();
        int r13 = r11.getMonth() - 1;
        int r14 = r11.getDay();
        r10.set(13, getSecond());
        r10.set(14, getMillisecond());
        r10.set(r12, r13, r14, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r10, "calendar");
        return r10.getTimeInMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        da.c r10 = da.c.f8520a;
        ViewParent r11 = getParent();
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        ViewGroup r12 = (ViewGroup) r11;
        if ((r12 instanceof OSheetContentFrameLayout) == false) goto L35;
        OSheetContentFrameLayout r13 = (OSheetContentFrameLayout) r12;
        if (r13.getId() != u8.f.content_container) goto L36;
        int r14 = r13.getPaddingLeft();
        int r15 = r13.getPaddingTop();
        int r16 = r13.getPaddingRight();
        int r17 = r13.getPaddingBottom();
        int r18 = i.f6354a[this.mDatePickerMode.ordinal()];
        if (r18 != 1) goto L14;
        float r19 = 16;
        Resources r110 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r110, "Resources.getSystem()");
        if (r14 != MathKt.roundToInt(TypedValue.applyDimension(1, r19, r110.getDisplayMetrics()))) goto L33;
        Resources r111 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r111, "Resources.getSystem()");
        if (r15 != MathKt.roundToInt(TypedValue.applyDimension(1, 6, r111.getDisplayMetrics()))) goto L33;
        Resources r112 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r112, "Resources.getSystem()");
        if (r16 != MathKt.roundToInt(TypedValue.applyDimension(1, r19, r112.getDisplayMetrics()))) goto L33;
        Resources r113 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r113, "Resources.getSystem()");
        if (r17 != MathKt.roundToInt(TypedValue.applyDimension(1, r19, r113.getDisplayMetrics()))) goto L33;
        return;
    L33:
        ea.b.a(this.TAG$1, "onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [" + r14 + ", " + r15 + ", " + r16 + ", " + r17 + ']');
        Resources r114 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r114, "Resources.getSystem()");
        int r115 = MathKt.roundToInt(TypedValue.applyDimension(1, r19, r114.getDisplayMetrics()));
        Resources r20 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r20, "Resources.getSystem()");
        int r21 = MathKt.roundToInt(TypedValue.applyDimension(1, (float) 6, r20.getDisplayMetrics()));
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        int r23 = MathKt.roundToInt(TypedValue.applyDimension(1, r19, r22.getDisplayMetrics()));
        Resources r24 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r24, "Resources.getSystem()");
        r12.setPadding(r115, r21, r23, MathKt.roundToInt(TypedValue.applyDimension(1, r19, r24.getDisplayMetrics())));
        return;
    L14:
        if (r18 != 2) goto L40;
        float r116 = 0;
        Resources r117 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r117, "Resources.getSystem()");
        if (r14 != MathKt.roundToInt(TypedValue.applyDimension(1, r116, r117.getDisplayMetrics()))) goto L24;
        Resources r118 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r118, "Resources.getSystem()");
        if (r15 != MathKt.roundToInt(TypedValue.applyDimension(1, r116, r118.getDisplayMetrics()))) goto L24;
        Resources r119 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r119, "Resources.getSystem()");
        if (r16 != MathKt.roundToInt(TypedValue.applyDimension(1, r116, r119.getDisplayMetrics()))) goto L24;
        Resources r120 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r120, "Resources.getSystem()");
        if (r17 != MathKt.roundToInt(TypedValue.applyDimension(1, r116, r120.getDisplayMetrics()))) goto L24;
        return;
    L24:
        ea.b.a(this.TAG$1, "onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [" + r14 + ", " + r15 + ", " + r16 + ", " + r17 + ']');
        r12.setPadding(0, 0, 0, 0);
        return;
    L40:
        return;
    L36:
        return;
    L35:
        return;
    L6:
        if ((r11 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setCurrentTimeMillis(long r10) {
        this.mSelectTime = r10;
        setDefaultDate();
    }

    public final void setOnDateChangedListener(Function1<? super Long, Unit> r10) {
        this.onDateChangedListener = r10;
    }

    public final void setOnMonthChangedListener(Function1<? super Long, Unit> r10) {
        this.onMonthChangedListener = r10;
    }
}
