package com.larksuite.component.universe_design.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.datepicker.databinding.UdDatepickerDefaultRootBinding;
import com.larksuite.component.universe_design.datepicker.impl.MonthCalendarViewAdapter;
import com.larksuite.component.universe_design.datepicker.impl.MonthViewPager;
import com.larksuite.component.universe_design.datepicker.impl.data.MonthShowMode;
import com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead;
import com.larksuite.component.universe_design.datepicker.impl.week.WeekIndicator;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.util.CalendarDate;
import h18.e;
import java.util.Calendar;
import java.util.TimeZone;
import k08.b;
import k08.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q08.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\"\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\"\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0012H\u0016J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u00102\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/UDDatePicker;", "Landroid/widget/RelativeLayout;", "Lcom/larksuite/component/universe_design/datepicker/api/IDatePickerDelegate;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "monthCalendarViewAdapter", "Lcom/larksuite/component/universe_design/datepicker/impl/MonthCalendarViewAdapter;", "datePickerListener", "Lcom/larksuite/component/universe_design/datepicker/api/IDatePickerDelegate$DatePickerListener;", "selectedDate", "Lcom/larksuite/component/universe_design/util/CalendarDate;", "selectedTimeZone", "Ljava/util/TimeZone;", "monthShowMode", "Lcom/larksuite/component/universe_design/datepicker/impl/data/MonthShowMode;", "firstDayOfWeek", "Lcom/larksuite/component/universe_design/util/CalendarDate$DayOfWeek;", "viewBinding", "Lcom/larksuite/component/universe_design/datepicker/databinding/UdDatepickerDefaultRootBinding;", "initFromAttributes", "", "initData", "initView", "initMonthViewPager", "initViewData", "initWeekIndicator", "updateWeekColorAndText", "initHeader", "setSelectedDate", "date", "updateMonthText", "triggerSelectedDatChanged", "updateViewPagerHeight", "updateHeadViews", "getSelectedCalendar", "Ljava/util/Calendar;", "setMonthPickerListener", "listener", "setSelectedCalendar", "setMonthShowMode", "setFirstDayOfWeek", "getFirstDayOfWeek", "setMonthDateTypeFace", "typeFace", "Landroid/graphics/Typeface;", "setMonthHeadTypeFace", "setMonthHeadTextSize", "textSize", "", "setMonthDateTextSize", "setMonthPageScrollEnable", "scrollEnable", "", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDDatePicker extends RelativeLayout {
    public static final /* synthetic */ int h = 0;
    public MonthCalendarViewAdapter a;
    public l08.a b;
    public CalendarDate c;
    public TimeZone d;
    public MonthShowMode e;
    public CalendarDate.DayOfWeek f;
    public final UdDatepickerDefaultRootBinding g;

    public static final class a {
    }

    static {
    }

    public final void b() {
        l08.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(this.c.getYear(), this.c.getMonth() - 1, this.c.getMonthDay());
        return;
    }

    public final void d() {
        MonthPickerDefaultHead r0 = this.g.b;
        int[] r1 = com.larksuite.component.universe_design.util.a.a;
        CalendarDate r2 = this.c;
        Intrinsics.checkNotNullParameter(r2, "date");
        StringBuilder r3 = new StringBuilder();
        r3.append(r2.getYear());
        r3.append('.');
        r3.append(r2.getMonth());
        r0.setMonthText(r3.toString());
    }

    public final void e() {
        ViewGroup.LayoutParams r0 = this.g.d.getLayoutParams();
        r0.height = this.g.d.getCenterViewHeight();
        this.g.d.setLayoutParams(r0);
    }

    public final void f() {
        CalendarDate r0 = new CalendarDate();
        int r1 = r0.getWeeklyDayIndex(this.f);
        CalendarDate r2 = this.c;
        int[] r3 = com.larksuite.component.universe_design.util.a.a;
        Intrinsics.checkNotNullParameter(r0, "lhs");
        Intrinsics.checkNotNullParameter(r2, "rhs");
        int r5 = 0;
        if (r0.getYear() == r2.getYear()) goto L5;
    L7:
        boolean r4 = false;
    L8:
        WeekIndicator r6 = this.g.c;
        CalendarDate.DayOfWeek r7 = this.f;
        r6.e = r1;
        r6.f = r4;
        if (r7 != null) goto L11;
        int r8 = -1;
    L13:
        if (r8 != 1) goto L15;
    L20:
        if (r5 >= 7) goto L22;
        int r9 = r5 + 1;
        r6.b[r5] = r6.a[r9 % 7];
        r5 = r9;
    L22:
        r6.invalidate();
        return;
    L15:
        if (r8 == 2) goto L18;
    L16:
        if (r5 >= 7) goto L22;
        r6.b[r5] = r6.a[r5];
        r5 = r5 + 1;
    L18:
        if (r5 >= 7) goto L22;
        r6.b[r5] = r6.a[(r5 + 6) % 7];
        r5 = r5 + 1;
        goto L18
    L11:
        r8 = WeekIndicator.a.a[r7.ordinal()];
        goto L13
    L5:
        if (r0.getMonth() != r2.getMonth()) goto L7;
        r4 = true;
        goto L8
    }

    public int getFirstDayOfWeek() {
        return this.f.getValue() + 1;
    }

    public Calendar getSelectedCalendar() {
        int[] r0 = com.larksuite.component.universe_design.util.a.a;
        Calendar r1 = this.c.getCalendar();
        TimeZone r2 = this.d;
        Intrinsics.checkNotNullParameter(r1, "calendar");
        Intrinsics.checkNotNullParameter(r2, "timeZone");
        return new CalendarDate(new CalendarDate(r1), r2).getCalendar();
    }

    public final void c() {
        d();
        f();
    }

    public UDDatePicker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setSelectedDate(CalendarDate r1) {
        this.c = r1;
        c();
        MonthCalendarViewAdapter r2 = this.a;
        if (r2 == null) goto L5;
        r2.i();
    L5:
        invalidate();
        b();
    }

    public void setFirstDayOfWeek(int r3) {
        if (r3 >= 1) goto L5;
        return;
    L5:
        if (r3 > 7) goto L13;
        this.f = CalendarDate.DayOfWeek.valueOf(r3 - 1);
        f();
        MonthCalendarViewAdapter r4 = this.a;
        if (r4 == null) goto L10;
        r4.i();
    L10:
        e();
        return;
    }

    public void setMonthDateTextSize(float r4) {
        MonthCalendarViewAdapter r0 = this.a;
        if (r0 == null) goto L12;
        int r1 = 0;
    L6:
        if (r1 >= 3) goto L16;
        c r2 = (c) r0.g(r1);
        if (r2 == null) goto L11;
        r2.setMonthTextSize(r4);
    L11:
        r1 = r1 + 1;
        goto L6
    L16:
        return;
    }

    public void setMonthDateTypeFace(Typeface r4) {
        Intrinsics.checkNotNullParameter(r4, "typeFace");
        MonthCalendarViewAdapter r1 = this.a;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(r4, "typeFace");
        int r0 = 0;
    L6:
        if (r0 >= 3) goto L16;
        c r2 = (c) r1.g(r0);
        if (r2 == null) goto L11;
        r2.setTypeFace(r4);
    L11:
        r0 = r0 + 1;
        goto L6
    L16:
        return;
    }

    public void setMonthHeadTextSize(float r2) {
        this.g.b.setMonthTextSize(r2);
    }

    public void setMonthHeadTypeFace(Typeface r2) {
        Intrinsics.checkNotNullParameter(r2, "typeFace");
        this.g.b.setTypeFace(r2);
    }

    public void setMonthPageScrollEnable(boolean r2) {
        this.g.d.setPageEnabled(r2);
    }

    public void setMonthPickerListener(l08.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public void setMonthShowMode(MonthShowMode r2) {
        Intrinsics.checkNotNullParameter(r2, "monthShowMode");
        this.e = r2;
        f();
        MonthCalendarViewAdapter r3 = this.a;
        if (r3 == null) goto L5;
        r3.i();
    L5:
        e();
    }

    public void setSelectedCalendar(Calendar r3) {
        Intrinsics.checkNotNullParameter(r3, "date");
        this.d = r3.getTimeZone();
        this.c = new CalendarDate(new CalendarDate(r3));
        c();
        MonthCalendarViewAdapter r4 = this.a;
        if (r4 == null) goto L5;
        r4.i();
    L5:
        this.g.d.setCurrentItem(1, false);
        e();
    }

    public UDDatePicker(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static final /* synthetic */ void a(UDDatePicker r0, CalendarDate r1) {
        r0.setSelectedDate(r1);
    }

    public UDDatePicker(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 0);
        this.c = new CalendarDate();
        this.d = TimeZone.getDefault();
        MonthShowMode r13 = MonthShowMode.AUTO_HEIGHT;
        this.e = r13;
        this.f = CalendarDate.DayOfWeek.SUNDAY;
        LayoutInflater.from(getContext()).inflate(2131568080, this);
        int r1 = 2131380278;
        MonthPickerDefaultHead r2 = (MonthPickerDefaultHead) ViewBindings.findChildViewById(this, 2131380278);
        if (r2 == null) goto L29;
        r1 = 2131380279;
        WeekIndicator r3 = (WeekIndicator) ViewBindings.findChildViewById(this, 2131380279);
        if (r3 == null) goto L29;
        r1 = 2131380284;
        MonthViewPager r4 = (MonthViewPager) ViewBindings.findChildViewById(this, 2131380284);
        if (r4 == null) goto L29;
        this.g = new UdDatepickerDefaultRootBinding(this, r2, r3, r4);
        r2.setMonthPickerActionListener(new k08.a(this));
        d();
        f();
        MonthCalendarViewAdapter r5 = new MonthCalendarViewAdapter(getContext(), new b(this));
        this.a = r5;
        k08.c r6 = new k08.c(this);
        Intrinsics.checkNotNullParameter(r6, "monthViewStateChangeListener");
        r5.e = r6;
        r4.setAdapter(this.a);
        r4.setViewPageListener(new d(this));
        e();
        setBackgroundColor(UDColorUtils.getColor(getContext(), 2131100548));
        int r7 = e.a;
        setMonthDateTypeFace(e.a(getContext()));
        TypedArray r14 = getContext().obtainStyledAttributes(r11, new int[]{2130974866, 2130974867, 2130974868, 2130974869, 2130974870, 2130974871, 2130974872}, r12, 0);
        int r8 = r14.getDimensionPixelSize(1, -1);
        int r9 = r14.getDimensionPixelSize(6, -1);
        int r15 = r14.getDimensionPixelSize(5, -1);
        int r16 = r14.getDimensionPixelSize(0, (int) h18.d.a(getContext(), 16.0f));
        int r17 = r14.getDimensionPixelSize(3, (int) h18.d.a(getContext(), 26.0f));
        int r0 = r14.getInt(4, 0);
        int r19 = r14.getInteger(2, 1);
        r14.recycle();
        if (r8 <= 0) goto L11;
        r2.getLayoutParams().height = r8;
    L11:
        ViewGroup.LayoutParams r110 = r3.getLayoutParams();
        if ((r110 instanceof RelativeLayout.LayoutParams) == false) goto L14;
        RelativeLayout.LayoutParams r111 = (RelativeLayout.LayoutParams) r110;
    L15:
        if (r9 <= 0) goto L18;
        if (r111 == null) goto L18;
        r111.topMargin = r9;
    L18:
        if (r15 <= 0) goto L21;
        if (r111 == null) goto L21;
        r111.bottomMargin = r15;
    L21:
        if (r111 == null) goto L23;
        r3.setLayoutParams(r111);
    L23:
        setMonthDateTextSize(r16);
        setMonthHeadTextSize(r17);
        setFirstDayOfWeek(r19);
        MonthShowMode.Companion.getClass();
        if (r0 != 0) goto L26;
        r13 = MonthShowMode.FIXED_SIX_ROW;
    L26:
        setMonthShowMode(r13);
        return;
    L14:
        r111 = null;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r1)));
    }
}
