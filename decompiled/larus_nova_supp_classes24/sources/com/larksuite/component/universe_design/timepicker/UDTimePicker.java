package com.larksuite.component.universe_design.timepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PanelStyleData;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import com.larksuite.component.universe_design.timepicker.impl.helper.UtcDates;
import com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController;
import com.larksuite.component.universe_design.timepicker.impl.panel.f;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.apm.impl.protector.RunnableProtector;
import h18.d;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001%\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\"\u0010'\u001a\u00020(2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0010H\u0016J\u001d\u0010.\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0002\b/J\u0010\u00100\u001a\u00020(2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0018H\u0016J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u000bH\u0016J\u0010\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u001aH\u0016J\b\u00107\u001a\u00020\u001aH\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u000bH\u0016J\b\u0010:\u001a\u00020(H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020#H\u0016J\u0012\u0010>\u001a\u00020#2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J(\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000bH\u0014J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000bH\u0002R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&¨\u0006G"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/UDTimePicker;", "Landroid/widget/LinearLayout;", "Lcom/larksuite/component/universe_design/timepicker/api/ITimePickerDelegate;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "baseController", "Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController;", "getBaseController", "()Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController;", "setBaseController", "(Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController;)V", "pickerModel", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerModel;", "timePickerListener", "Lcom/larksuite/component/universe_design/timepicker/api/ITimePickerDelegate$TimePickerListener;", "selectedCalendar", "Ljava/util/Calendar;", "selectedTimeZone", "Ljava/util/TimeZone;", "panelStyleData", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PanelStyleData;", "beginDate", "Lcom/larksuite/component/universe_design/util/CalendarDate;", "endDate", "autoAdjustVisibleNum", "", "pickerPanelListener", "com/larksuite/component/universe_design/timepicker/UDTimePicker$pickerPanelListener$1", "Lcom/larksuite/component/universe_design/timepicker/UDTimePicker$pickerPanelListener$1;", "init", "", "defStyle", "initController", "createView", "setPanelController", "panelController", "setPickerDateRange", "setPickerDateRange$universe_ui_datepicker_release", "setPickerMode", "setDatePickerListener", "listener", "setItemVisibleNum", "visibleItemNum", "setSelectedCalendar", "calendarDate", "getSelectedCalendar", "setMinuteInterval", "minuteInterval", "showItemDivider", "hideItemDivider", "setAutoAdjustItemNum", "autoAdjust", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onSizeChanged", "width", "height", "oldw", "oldh", "getAdjustVisibleItem", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDTimePicker extends LinearLayout {
    private boolean autoAdjustVisibleNum;
    private BaseTimePickerController baseController;
    private CalendarDate beginDate;
    private CalendarDate endDate;
    private PanelStyleData panelStyleData;
    private PickerModel pickerModel;
    private b pickerPanelListener;
    private Calendar selectedCalendar;
    private TimeZone selectedTimeZone;
    private c18.a timePickerListener;

    public static final class a implements Runnable {
        public final /* synthetic */ UDTimePicker a;
        public final /* synthetic */ int b;

        public a(UDTimePicker r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setItemVisibleNum(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements BaseTimePickerController.PickerPanelDependency {
        public final /* synthetic */ UDTimePicker a;

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final PanelStyleData getPanelStyleData() {
            return UDTimePicker.access$getPanelStyleData$p(this.a);
        }

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final Calendar getSelectedDate() {
            return UDTimePicker.access$getSelectedCalendar$p(this.a);
        }

        public b(UDTimePicker r1) {
            this.a = r1;
        }

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final void onSelected(Calendar r8) {
            Intrinsics.checkNotNullParameter(r8, "selectedDate");
            UDTimePicker.access$setSelectedCalendar$p(this.a, r8);
            CalendarDate r0 = new CalendarDate(r8);
            c18.a r1 = UDTimePicker.access$getTimePickerListener$p(this.a);
            if (r1 == null) goto L6;
            r1.a(r0.getYear(), r0.getMonth() - 1, r0.getMonthDay(), r0.getHour(), r0.getMinute());
            return;
        }
    }

    private final void initController() {
        PickerModel r0 = this.pickerModel;
        if (r0 == null) goto L11;
        CalendarDate r1 = this.beginDate;
        CalendarDate r2 = this.endDate;
        if (r0 != PickerModel.YEAR_MONTH_DAY) goto L9;
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        int r3 = f.j;
        setPanelController(f.a.a(getContext(), this.pickerPanelListener, r1, r2));
        return;
    L9:
        setPanelController(TimePickerHelper.INSTANCE.getPanelController(getContext(), r0, this.pickerPanelListener, this.panelStyleData));
        return;
    }

    public Calendar getSelectedCalendar() {
        int[] r0 = com.larksuite.component.universe_design.util.a.a;
        Calendar r1 = this.selectedCalendar;
        TimeZone r2 = this.selectedTimeZone;
        Intrinsics.checkNotNullParameter(r1, "calendar");
        Intrinsics.checkNotNullParameter(r2, "timeZone");
        return new CalendarDate(new CalendarDate(r1), r2).getCalendar();
    }

    public void hideItemDivider() {
        this.panelStyleData.setItemDividerVisibility(false);
        BaseTimePickerController r0 = this.baseController;
        if (r0 == null) goto L5;
        r0.setItemDividerVisibility(false);
    L5:
        invalidate();
    }

    public void showItemDivider() {
        this.panelStyleData.setItemDividerVisibility(true);
        BaseTimePickerController r0 = this.baseController;
        if (r0 == null) goto L5;
        r0.setItemDividerVisibility(true);
    L5:
        invalidate();
    }

    private final void createView() {
        if (getBackground() == null) goto L5;
        setBackgroundColor(UDColorUtils.getColor(getContext(), 2131100548));
    L5:
        initController();
    }

    public final BaseTimePickerController getBaseController() {
        return this.baseController;
    }

    public UDTimePicker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ PanelStyleData access$getPanelStyleData$p(UDTimePicker r0) {
        return r0.panelStyleData;
    }

    public static final /* synthetic */ Calendar access$getSelectedCalendar$p(UDTimePicker r0) {
        return r0.selectedCalendar;
    }

    public static final /* synthetic */ c18.a access$getTimePickerListener$p(UDTimePicker r0) {
        return r0.timePickerListener;
    }

    private final int getAdjustVisibleItem(int r4) {
        return TimePickerHelper.INSTANCE.getValidWheelItemNum((int) (r4 / d.b(getContext(), 48)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(true);
    L6:
        return super.dispatchTouchEvent(r3);
    }

    public void setAutoAdjustItemNum(boolean r2) {
        if (this.autoAdjustVisibleNum != r2) goto L5;
        return;
    L5:
        this.autoAdjustVisibleNum = r2;
        requestLayout();
    }

    public final void setBaseController(BaseTimePickerController r1) {
        this.baseController = r1;
    }

    public void setDatePickerListener(c18.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.timePickerListener = r2;
    }

    public void setItemVisibleNum(int r3) {
        this.panelStyleData.setVisibleItemNum(TimePickerHelper.INSTANCE.getValidWheelItemNum(r3));
        BaseTimePickerController r0 = this.baseController;
        if (r0 == null) goto L6;
        r0.setItemVisibleNum(r3);
        return;
    }

    public void setMinuteInterval(int r2) {
        this.panelStyleData.setMinuteInterval(r2);
        BaseTimePickerController r0 = this.baseController;
        if (r0 == null) goto L5;
        r0.setMinuteWheelInterval(r2);
    L5:
        invalidate();
    }

    public void setPanelController(BaseTimePickerController r3) {
        Intrinsics.checkNotNullParameter(r3, "panelController");
        removeAllViews();
        this.baseController = r3;
        if (r3 == null) goto L5;
        List<PickerBuilder> r4 = r3.getPickerBuilderList();
    L6:
        List<PickerBuilder> r0 = r4;
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L17;
        BaseTimePickerController r2 = this.baseController;
        if (r2 == null) goto L17;
        r2.create(getContext(), r4);
    L17:
        BaseTimePickerController r5 = this.baseController;
        if (r5 == null) goto L28;
        List<WheelView> r6 = r5.getPickerViewList();
        if (r6 == null) goto L28;
        Iterator<T> r7 = r6.iterator();
    L23:
        if (r7.hasNext() == false) goto L28;
        WheelView r8 = (WheelView) r7.next();
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 != null) goto L27;
        r9 = TimePickerHelper.INSTANCE.generalDefaultLayoutParam();
    L27:
        addView(r8, r9);
    L28:
        BaseTimePickerController r10 = this.baseController;
        if (r10 == null) goto L35;
        r10.setCurrentDate(this.selectedCalendar);
        return;
    L35:
        return;
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public void setPickerMode(PickerModel r2) {
        Intrinsics.checkNotNullParameter(r2, "pickerModel");
        this.pickerModel = r2;
        initController();
    }

    public void setSelectedCalendar(Calendar r2) {
        Intrinsics.checkNotNullParameter(r2, "calendarDate");
        this.selectedTimeZone = r2.getTimeZone();
        Calendar r3 = UtcDates.INSTANCE.getUTCCalendarOf(r2);
        this.selectedCalendar = r3;
        BaseTimePickerController r0 = this.baseController;
        if (r0 == null) goto L6;
        r0.setCurrentDate(r3);
        return;
    }

    public UDTimePicker(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static final /* synthetic */ void access$setSelectedCalendar$p(UDTimePicker r0, Calendar r1) {
        r0.selectedCalendar = r1;
    }

    public final void setPickerDateRange$universe_ui_datepicker_release(CalendarDate r2, CalendarDate r3) {
        Intrinsics.checkNotNullParameter(r2, "beginDate");
        Intrinsics.checkNotNullParameter(r3, "endDate");
        this.beginDate = r2;
        this.endDate = r3;
        initController();
    }

    public UDTimePicker(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 0);
    }

    private final void init(AttributeSet r6, int r7, int r8) {
        setOrientation(0);
        setGravity(16);
        TypedArray r9 = getContext().obtainStyledAttributes(r6, new int[]{2130974979, 2130974980, 2130974981, 2130974982, 2130974983, 2130974984}, r7, r8);
        int r1 = r9.getInt(1, 3);
        PickerModel.Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L12;
        if (r1 == 4) goto L11;
        if (r1 == 5) goto L10;
        PickerModel r2 = null;
    L16:
        this.pickerModel = r2;
        this.panelStyleData.setMinuteInterval(r9.getInt(4, 1));
        this.panelStyleData.setItemDividerVisibility(r9.getBoolean(2, true));
        this.panelStyleData.setShowDayInfo(r9.getBoolean(5, true));
        boolean r10 = r9.getBoolean(0, false);
        this.autoAdjustVisibleNum = r10;
        if (r10 == true) goto L19;
        this.panelStyleData.setVisibleItemNum(TimePickerHelper.INSTANCE.getValidWheelItemNum(r9.getInt(3, 3)));
    L19:
        r9.recycle();
        return;
    L10:
        r2 = PickerModel.MONTH_DAY;
        goto L16
    L11:
        r2 = PickerModel.YEAR_MONTH_DAY;
        goto L16
    L12:
        r2 = PickerModel.HOUR_MINUTE_24H;
        goto L16
    L13:
        r2 = PickerModel.HOUR_MINUTE_12H;
        goto L16
    L14:
        r2 = PickerModel.MONTHDAY_HOUR_MINUTE_24H;
        goto L16
    L15:
        r2 = PickerModel.MONTHDAY_HOUR_MINUTE_12H;
        goto L16
    }

    public UDTimePicker(Context r8, AttributeSet r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, r11);
        this.selectedCalendar = UtcDates.INSTANCE.getTodayCalendar();
        this.selectedTimeZone = TimeZone.getDefault();
        this.panelStyleData = new PanelStyleData(0, 0, false, false, 15, null);
        this.pickerPanelListener = new b(this);
        init(r9, r10, r11);
        createView();
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.autoAdjustVisibleNum == true) goto L5;
        return;
    L5:
        if (getLayoutParams().height != (-2)) goto L7;
        int r5 = 3;
    L8:
        post(new a(this, r5));
        return;
    L7:
        r5 = getAdjustVisibleItem(r2);
        goto L8
    }
}
