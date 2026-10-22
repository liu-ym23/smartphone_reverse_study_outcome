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
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
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
    private com.google.android.material.datepicker.b calendarStyle;

    @Nullable
    private Month current;

    @Nullable
    private DateSelector<S> dateSelector;
    private View dayFrame;
    private RecyclerView recyclerView;

    @StyleRes
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;

    static final enum CalendarSelector extends Enum<CalendarSelector> {
        private static final /* synthetic */ CalendarSelector[] $VALUES = null;
        public static final CalendarSelector DAY = null;
        public static final CalendarSelector YEAR = null;

        static {
            CalendarSelector r10 = new CalendarSelector("DAY", 0);
            DAY = r10;
            CalendarSelector r11 = new CalendarSelector("YEAR", 1);
            YEAR = r11;
            $VALUES = new CalendarSelector[]{r10, r11};
        }

        private CalendarSelector(String r10, int r11) {
            super(r10, r11);
        }

        public static CalendarSelector valueOf(String r10) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, r10);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) $VALUES.clone();
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3166c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MaterialCalendar f3167g;

        a(MaterialCalendar r10, int r11) {
            this.f3167g = r10;
            this.f3166c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.access$000(this.f3167g).smoothScrollToPosition(this.f3166c);
        }
    }

    class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendar f3168a;

        b(MaterialCalendar r10) {
            this.f3168a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.f
        public void a(long r10) {
            if (MaterialCalendar.access$100(this.f3168a).getDateValidator().isValid(r10) == false) goto L13;
            MaterialCalendar.access$200(this.f3168a).select(r10);
            Iterator<h<S>> r11 = this.f3168a.onSelectionChangedListeners.iterator();
        L6:
            if (r11.hasNext() == false) goto L8;
            r11.next().b(MaterialCalendar.access$200(this.f3168a).getSelection());
            goto L6
        L8:
            MaterialCalendar.access$000(this.f3168a).getAdapter().notifyDataSetChanged();
            if (MaterialCalendar.access$300(this.f3168a) == null) goto L14;
            MaterialCalendar.access$300(this.f3168a).getAdapter().notifyDataSetChanged();
            return;
        L14:
            return;
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialCalendar f3169c;

        c(MaterialCalendar r10) {
            this.f3169c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            this.f3169c.toggleVisibleSelector();
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MonthsPagerAdapter f3170c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MaterialCalendar f3171g;

        d(MaterialCalendar r10, MonthsPagerAdapter r11) {
            this.f3171g = r10;
            this.f3170c = r11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            int r11 = this.f3171g.getLayoutManager().findFirstVisibleItemPosition() + 1;
            if (r11 >= MaterialCalendar.access$000(this.f3171g).getAdapter().getItemCount()) goto L6;
            this.f3171g.setCurrentMonth(this.f3170c.getPageMonth(r11));
            return;
        }
    }

    class e implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MonthsPagerAdapter f3172c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MaterialCalendar f3173g;

        e(MaterialCalendar r10, MonthsPagerAdapter r11) {
            this.f3173g = r10;
            this.f3172c = r11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            int r11 = this.f3173g.getLayoutManager().findLastVisibleItemPosition() - 1;
            if (r11 < 0) goto L6;
            this.f3173g.setCurrentMonth(this.f3172c.getPageMonth(r11));
            return;
        }
    }

    interface f {
        void a(long r10);
    }

    static {
        MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
        NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
        NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
        SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    }

    public MaterialCalendar() {
    }

    static /* synthetic */ RecyclerView access$000(MaterialCalendar r10) {
        return r10.recyclerView;
    }

    static /* synthetic */ CalendarConstraints access$100(MaterialCalendar r10) {
        return r10.calendarConstraints;
    }

    static /* synthetic */ DateSelector access$200(MaterialCalendar r10) {
        return r10.dateSelector;
    }

    static /* synthetic */ RecyclerView access$300(MaterialCalendar r10) {
        return r10.yearSelector;
    }

    static /* synthetic */ com.google.android.material.datepicker.b access$400(MaterialCalendar r10) {
        return r10.calendarStyle;
    }

    static /* synthetic */ View access$500(MaterialCalendar r10) {
        return r10.dayFrame;
    }

    static /* synthetic */ Month access$602(MaterialCalendar r10, Month r11) {
        r10.current = r11;
        return r11;
    }

    private void addActionsToMonthNavigation(@NonNull View r10, @NonNull final MonthsPagerAdapter r11) {
        final MaterialButton r12 = (MaterialButton) r10.findViewById(q5.f.month_navigation_fragment_toggle);
        r12.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(r12, new AnonymousClass5(this));
        MaterialButton r13 = (MaterialButton) r10.findViewById(q5.f.month_navigation_previous);
        r13.setTag(NAVIGATION_PREV_TAG);
        MaterialButton r14 = (MaterialButton) r10.findViewById(q5.f.month_navigation_next);
        r14.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = r10.findViewById(q5.f.mtrl_calendar_year_selector_frame);
        this.dayFrame = r10.findViewById(q5.f.mtrl_calendar_day_selector_frame);
        setSelector(CalendarSelector.DAY);
        r12.setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new AnonymousClass6(this, r11, r12));
        r12.setOnClickListener(new c(this));
        r14.setOnClickListener(new d(this, r11));
        r13.setOnClickListener(new e(this, r11));
    }

    @NonNull
    private RecyclerView.ItemDecoration createItemDecoration() {
        return new AnonymousClass4(this);
    }

    @Px
    static int getDayHeight(@NonNull Context r10) {
        return r10.getResources().getDimensionPixelSize(q5.d.mtrl_calendar_day_height);
    }

    private static int getDialogPickerHeight(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        int r12 = (r11.getDimensionPixelSize(q5.d.mtrl_calendar_navigation_height) + r11.getDimensionPixelOffset(q5.d.mtrl_calendar_navigation_top_padding)) + r11.getDimensionPixelOffset(q5.d.mtrl_calendar_navigation_bottom_padding);
        int r13 = r11.getDimensionPixelSize(q5.d.mtrl_calendar_days_of_week_height);
        int r14 = g.f3223k;
        return ((r12 + r13) + ((r11.getDimensionPixelSize(q5.d.mtrl_calendar_day_height) * r14) + ((r14 - 1) * r11.getDimensionPixelOffset(q5.d.mtrl_calendar_month_vertical_padding)))) + r11.getDimensionPixelOffset(q5.d.mtrl_calendar_bottom_padding);
    }

    @NonNull
    public static <T> MaterialCalendar<T> newInstance(@NonNull DateSelector<T> r10, @StyleRes int r11, @NonNull CalendarConstraints r12) {
        MaterialCalendar<T> r13 = new MaterialCalendar();
        Bundle r14 = new Bundle();
        r14.putInt(THEME_RES_ID_KEY, r11);
        r14.putParcelable(GRID_SELECTOR_KEY, r10);
        r14.putParcelable(CALENDAR_CONSTRAINTS_KEY, r12);
        r14.putParcelable(CURRENT_MONTH_KEY, r12.getOpenAt());
        r13.setArguments(r14);
        return r13;
    }

    private void postSmoothRecyclerViewScroll(int r10) {
        this.recyclerView.post(new a(this, r10));
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(@NonNull h<S> r10) {
        return super.addOnSelectionChangedListener(r10);
    }

    @Nullable
    CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    com.google.android.material.datepicker.b getCalendarStyle() {
        return this.calendarStyle;
    }

    @Nullable
    Month getCurrentMonth() {
        return this.current;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    @Nullable
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    @NonNull
    LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        if (r10 != null) goto L5;
        r10 = getArguments();
    L5:
        this.themeResId = r10.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) r10.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r10.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.current = (Month) r10.getParcelable(CURRENT_MONTH_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater r11, @Nullable ViewGroup r12, @Nullable Bundle r13) {
        ContextThemeWrapper r14 = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new com.google.android.material.datepicker.b(r14);
        LayoutInflater r15 = r11.cloneInContext(r14);
        Month r10 = this.calendarConstraints.getStart();
        if (MaterialDatePicker.isFullscreen(r14) == false) goto L5;
        int r16 = q5.h.mtrl_calendar_vertical;
        final int r17 = 1;
    L6:
        View r18 = r15.inflate(r16, r12, false);
        r18.setMinimumHeight(getDialogPickerHeight(requireContext()));
        GridView r19 = (GridView) r18.findViewById(q5.f.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(r19, new AnonymousClass1(this));
        r19.setAdapter(new com.google.android.material.datepicker.e());
        r19.setNumColumns(r10.daysInWeek);
        r19.setEnabled(false);
        this.recyclerView = (RecyclerView) r18.findViewById(q5.f.mtrl_calendar_months);
        final Context r20 = getContext();
        final boolean r21 = false;
        final int r22 = r17;
        this.recyclerView.setLayoutManager(new AnonymousClass2(this, r20, r22, r21, r17));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        MonthsPagerAdapter r110 = new MonthsPagerAdapter(r14, this.dateSelector, this.calendarConstraints, new b(this));
        this.recyclerView.setAdapter(r110);
        int r23 = r14.getResources().getInteger(q5.g.mtrl_calendar_year_selector_span);
        RecyclerView r24 = (RecyclerView) r18.findViewById(q5.f.mtrl_calendar_year_selector_frame);
        this.yearSelector = r24;
        if (r24 == null) goto L10;
        r24.setHasFixedSize(true);
        this.yearSelector.setLayoutManager(new GridLayoutManager(r14, r23, 1, false));
        this.yearSelector.setAdapter(new YearGridAdapter(this));
        this.yearSelector.addItemDecoration(createItemDecoration());
    L10:
        if (r18.findViewById(q5.f.month_navigation_fragment_toggle) == null) goto L13;
        addActionsToMonthNavigation(r18, r110);
    L13:
        if (MaterialDatePicker.isFullscreen(r14) == true) goto L15;
        new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
    L15:
        this.recyclerView.scrollToPosition(r110.getPosition(this.current));
        return r18;
    L5:
        r16 = q5.h.mtrl_calendar_horizontal;
        r17 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r10) {
        super.onSaveInstanceState(r10);
        r10.putInt(THEME_RES_ID_KEY, this.themeResId);
        r10.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        r10.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        r10.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    void setCurrentMonth(Month r10) {
        MonthsPagerAdapter r11 = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int r12 = r11.getPosition(r10);
        int r13 = r12 - r11.getPosition(this.current);
        boolean r14 = true;
        if (Math.abs(r13) <= 3) goto L5;
        boolean r15 = true;
    L6:
        if (r13 > 0) goto L9;
        r14 = false;
    L9:
        this.current = r10;
        if (r15 == false) goto L13;
        if (r14 == false) goto L13;
        RecyclerView r16 = this.recyclerView;
        int r17 = r12 - 3;
    L15:
        r16.scrollToPosition(r17);
    L16:
        postSmoothRecyclerViewScroll(r12);
        return;
    L13:
        if (r15 == false) goto L16;
        r16 = this.recyclerView;
        r17 = r12 + 3;
        goto L15
    L5:
        r15 = false;
        goto L6
    }

    void setSelector(CalendarSelector r10) {
        this.calendarSelector = r10;
        if (r10 != CalendarSelector.YEAR) goto L6;
        this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
        this.yearFrame.setVisibility(0);
        this.dayFrame.setVisibility(8);
        return;
    L6:
        if (r10 != CalendarSelector.DAY) goto L10;
        this.yearFrame.setVisibility(8);
        this.dayFrame.setVisibility(0);
        setCurrentMonth(this.current);
        return;
    }

    void toggleVisibleSelector() {
        CalendarSelector r10 = this.calendarSelector;
        CalendarSelector r11 = CalendarSelector.YEAR;
        if (r10 != r11) goto L6;
        setSelector(CalendarSelector.DAY);
        return;
    L6:
        if (r10 != CalendarSelector.DAY) goto L10;
        setSelector(r11);
        return;
    }
}
