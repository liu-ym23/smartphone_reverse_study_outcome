package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";

    @VisibleForTesting
    static final Object MONTHS_VIEW_GROUP_TAG = null;

    @VisibleForTesting
    static final Object NAVIGATION_NEXT_TAG = null;

    @VisibleForTesting
    static final Object NAVIGATION_PREV_TAG = null;

    @VisibleForTesting
    static final Object SELECTOR_TOGGLE_TAG = null;
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";

    @Nullable
    private CalendarConstraints calendarConstraints;
    private CalendarSelector calendarSelector;
    private CalendarStyle calendarStyle;

    @Nullable
    private Month current;

    @Nullable
    private DateSelector<S> dateSelector;
    private View dayFrame;

    @Nullable
    private DayViewDecorator dayViewDecorator;
    private View monthNext;
    private View monthPrev;
    private RecyclerView recyclerView;

    @StyleRes
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;

    public static final enum CalendarSelector extends Enum<CalendarSelector> {
        private static final /* synthetic */ CalendarSelector[] $VALUES = null;
        public static final CalendarSelector DAY = null;
        public static final CalendarSelector YEAR = null;

        static {
            CalendarSelector r5 = new CalendarSelector("DAY", 0);
            DAY = r5;
            CalendarSelector r10 = new CalendarSelector("YEAR", 1);
            YEAR = r10;
            $VALUES = new CalendarSelector[]{r5, r10};
        }

        private CalendarSelector(String r5, int r10) {
            super(r5, r10);
        }

        public static CalendarSelector valueOf(String r5) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, r5);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) $VALUES.clone();
        }
    }

    public interface OnDayClickListener {
        void onDayClick(long r5);
    }

    static {
        MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
        NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
        NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
        SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    }

    public MaterialCalendar() {
    }

    public static /* synthetic */ RecyclerView access$000(MaterialCalendar r5) {
        return r5.recyclerView;
    }

    public static /* synthetic */ CalendarConstraints access$100(MaterialCalendar r5) {
        return r5.calendarConstraints;
    }

    public static /* synthetic */ DateSelector access$200(MaterialCalendar r5) {
        return r5.dateSelector;
    }

    public static /* synthetic */ RecyclerView access$300(MaterialCalendar r5) {
        return r5.yearSelector;
    }

    public static /* synthetic */ CalendarStyle access$400(MaterialCalendar r5) {
        return r5.calendarStyle;
    }

    public static /* synthetic */ View access$500(MaterialCalendar r5) {
        return r5.dayFrame;
    }

    public static /* synthetic */ Month access$602(MaterialCalendar r5, Month r10) {
        r5.current = r10;
        return r10;
    }

    private void addActionsToMonthNavigation(@NonNull View r5, @NonNull final MonthsPagerAdapter r10) {
        final MaterialButton r11 = (MaterialButton) r5.findViewById(R.id.month_navigation_fragment_toggle);
        r11.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(r11, new AnonymousClass6(this));
        View r12 = r5.findViewById(R.id.month_navigation_previous);
        this.monthPrev = r12;
        r12.setTag(NAVIGATION_PREV_TAG);
        View r13 = r5.findViewById(R.id.month_navigation_next);
        this.monthNext = r13;
        r13.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = r5.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.dayFrame = r5.findViewById(R.id.mtrl_calendar_day_selector_frame);
        setSelector(CalendarSelector.DAY);
        r11.setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new AnonymousClass7(this, r10, r11));
        r11.setOnClickListener(new AnonymousClass8(this));
        this.monthNext.setOnClickListener(new AnonymousClass9(this, r10));
        this.monthPrev.setOnClickListener(new AnonymousClass10(this, r10));
    }

    @NonNull
    private RecyclerView.ItemDecoration createItemDecoration() {
        return new AnonymousClass5(this);
    }

    @Px
    public static int getDayHeight(@NonNull Context r5) {
        return r5.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    private static int getDialogPickerHeight(@NonNull Context r5) {
        Resources r10 = r5.getResources();
        int r11 = r10.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + (r10.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + r10.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height));
        int r12 = r10.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int r13 = MonthAdapter.MAXIMUM_WEEKS;
        return ((r11 + r12) + ((r10.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (r13 - 1)) + (r10.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * r13))) + r10.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    @NonNull
    public static <T> MaterialCalendar<T> newInstance(@NonNull DateSelector<T> r5, @StyleRes int r10, @NonNull CalendarConstraints r11) {
        return newInstance(r5, r10, r11, null);
    }

    private void postSmoothRecyclerViewScroll(final int r5) {
        this.recyclerView.post(new AnonymousClass11(this, r5));
    }

    private void setUpForAccessibility() {
        ViewCompat.setAccessibilityDelegate(this.recyclerView, new AnonymousClass4(this));
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(@NonNull OnSelectionChangedListener<S> r5) {
        return super.addOnSelectionChangedListener(r5);
    }

    @Nullable
    public CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    public CalendarStyle getCalendarStyle() {
        return this.calendarStyle;
    }

    @Nullable
    public Month getCurrentMonth() {
        return this.current;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    @Nullable
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    @NonNull
    public LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        if (r5 != null) goto L5;
        r5 = getArguments();
    L5:
        this.themeResId = r5.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) r5.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r5.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.dayViewDecorator = (DayViewDecorator) r5.getParcelable(DAY_VIEW_DECORATOR_KEY);
        this.current = (Month) r5.getParcelable(CURRENT_MONTH_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater r12, @Nullable ViewGroup r13, @Nullable Bundle r14) {
        ContextThemeWrapper r10 = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(r10);
        LayoutInflater r5 = r12.cloneInContext(r10);
        Month r11 = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(r10) == false) goto L5;
        int r15 = R.layout.mtrl_calendar_vertical;
        final int r16 = 1;
    L6:
        View r17 = r5.inflate(r15, r13, false);
        r17.setMinimumHeight(getDialogPickerHeight(requireContext()));
        GridView r18 = (GridView) r17.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(r18, new AnonymousClass1(this));
        int r19 = this.calendarConstraints.getFirstDayOfWeek();
        if (r19 <= 0) goto L9;
        DaysOfWeekAdapter r20 = new DaysOfWeekAdapter(r19);
    L10:
        r18.setAdapter(r20);
        r18.setNumColumns(r11.daysInWeek);
        r18.setEnabled(false);
        this.recyclerView = (RecyclerView) r17.findViewById(R.id.mtrl_calendar_months);
        final Context r21 = getContext();
        final boolean r22 = false;
        final int r23 = r16;
        this.recyclerView.setLayoutManager(new AnonymousClass2(this, r21, r23, r22, r16));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        MonthsPagerAdapter r110 = new MonthsPagerAdapter(r10, this.dateSelector, this.calendarConstraints, this.dayViewDecorator, new AnonymousClass3(this));
        this.recyclerView.setAdapter(r110);
        int r24 = r10.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView r25 = (RecyclerView) r17.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = r25;
        if (r25 == null) goto L14;
        r25.setHasFixedSize(true);
        this.yearSelector.setLayoutManager(new GridLayoutManager(r10, r24, 1, false));
        this.yearSelector.setAdapter(new YearGridAdapter(this));
        this.yearSelector.addItemDecoration(createItemDecoration());
    L14:
        if (r17.findViewById(R.id.month_navigation_fragment_toggle) == null) goto L17;
        addActionsToMonthNavigation(r17, r110);
    L17:
        if (MaterialDatePicker.isFullscreen(r10) == true) goto L19;
        new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
    L19:
        this.recyclerView.scrollToPosition(r110.getPosition(this.current));
        setUpForAccessibility();
        return r17;
    L9:
        r20 = new DaysOfWeekAdapter();
        goto L10
    L5:
        r15 = R.layout.mtrl_calendar_horizontal;
        r16 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r5) {
        super.onSaveInstanceState(r5);
        r5.putInt(THEME_RES_ID_KEY, this.themeResId);
        r5.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        r5.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        r5.putParcelable(DAY_VIEW_DECORATOR_KEY, this.dayViewDecorator);
        r5.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    public void setCurrentMonth(Month r10) {
        MonthsPagerAdapter r5 = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int r11 = r5.getPosition(r10);
        int r12 = r11 - r5.getPosition(this.current);
        boolean r13 = false;
        if (Math.abs(r12) <= 3) goto L5;
        boolean r14 = true;
    L6:
        if (r12 <= 0) goto L8;
        r13 = true;
    L8:
        this.current = r10;
        if (r14 == false) goto L12;
        if (r13 == false) goto L12;
        this.recyclerView.scrollToPosition(r11 - 3);
        postSmoothRecyclerViewScroll(r11);
        return;
    L12:
        if (r14 == false) goto L14;
        this.recyclerView.scrollToPosition(r11 + 3);
        postSmoothRecyclerViewScroll(r11);
        return;
    L14:
        postSmoothRecyclerViewScroll(r11);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public void setSelector(CalendarSelector r5) {
        this.calendarSelector = r5;
        if (r5 != CalendarSelector.YEAR) goto L6;
        this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
        this.yearFrame.setVisibility(0);
        this.dayFrame.setVisibility(8);
        this.monthPrev.setVisibility(8);
        this.monthNext.setVisibility(8);
        return;
    L6:
        if (r5 != CalendarSelector.DAY) goto L10;
        this.yearFrame.setVisibility(8);
        this.dayFrame.setVisibility(0);
        this.monthPrev.setVisibility(0);
        this.monthNext.setVisibility(0);
        setCurrentMonth(this.current);
        return;
    }

    public void toggleVisibleSelector() {
        CalendarSelector r5 = this.calendarSelector;
        CalendarSelector r10 = CalendarSelector.YEAR;
        if (r5 != r10) goto L6;
        setSelector(CalendarSelector.DAY);
        return;
    L6:
        if (r5 != CalendarSelector.DAY) goto L10;
        setSelector(r10);
        return;
    }

    @NonNull
    public static <T> MaterialCalendar<T> newInstance(@NonNull DateSelector<T> r5, @StyleRes int r10, @NonNull CalendarConstraints r11, @Nullable DayViewDecorator r12) {
        MaterialCalendar<T> r13 = new MaterialCalendar();
        Bundle r14 = new Bundle();
        r14.putInt(THEME_RES_ID_KEY, r10);
        r14.putParcelable(GRID_SELECTOR_KEY, r5);
        r14.putParcelable(CALENDAR_CONSTRAINTS_KEY, r11);
        r14.putParcelable(DAY_VIEW_DECORATOR_KEY, r12);
        r14.putParcelable(CURRENT_MONTH_KEY, r11.getOpenAt());
        r13.setArguments(r14);
        return r13;
    }
}
