package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCalendarView extends ViewGroup {
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private DayOfWeek F;
    private boolean G;
    private d H;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f6288c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f6289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f6290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImageView f6291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CalendarPager f6292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CalendarPagerAdapter<?> f6293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CalendarDay f6294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LinearLayout f6295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CalendarMode f6296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f6297o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final View.OnClickListener f6298p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ViewPager.OnPageChangeListener f6299q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CalendarDay f6300r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CalendarDay f6301s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private k f6302t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private j f6303u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private l f6304v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private m f6305w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    CharSequence f6306x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f6307y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f6308z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean allowClickDaysOutsideCurrentMonth;
        boolean cacheCurrentPosition;
        CalendarDay currentMonth;
        boolean dynamicHeightEnabled;
        CalendarDay maxDate;
        CalendarDay minDate;
        List<CalendarDay> selectedDates;
        int selectionMode;
        int showOtherDates;
        boolean topbarVisible;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        private SavedState(Parcel r10) {
            super(r10);
            this.showOtherDates = 4;
            boolean r11 = true;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.currentMonth = null;
            this.showOtherDates = r10.readInt();
            if (r10.readByte() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.allowClickDaysOutsideCurrentMonth = r12;
            ClassLoader r13 = CalendarDay.class.getClassLoader();
            this.minDate = (CalendarDay) r10.readParcelable(r13);
            this.maxDate = (CalendarDay) r10.readParcelable(r13);
            r10.readTypedList(this.selectedDates, CalendarDay.CREATOR);
            if (r10.readInt() != 1) goto L9;
            boolean r14 = true;
        L10:
            this.topbarVisible = r14;
            this.selectionMode = r10.readInt();
            if (r10.readInt() != 1) goto L13;
            boolean r15 = true;
        L14:
            this.dynamicHeightEnabled = r15;
            this.currentMonth = (CalendarDay) r10.readParcelable(r13);
            if (r10.readByte() != 0) goto L18;
            r11 = false;
        L18:
            this.cacheCurrentPosition = r11;
            return;
        L13:
            r15 = false;
            goto L14
        L9:
            r14 = false;
            goto L10
        L5:
            r12 = false;
            goto L6
        }

        /* synthetic */ SavedState(Parcel r10, a r11) {
            this(r10);
        }

        SavedState(Parcelable r10) {
            super(r10);
            this.showOtherDates = 4;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.currentMonth = null;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.showOtherDates);
            r10.writeByte(this.allowClickDaysOutsideCurrentMonth ? 1 : 0);
            r10.writeParcelable(this.minDate, 0);
            r10.writeParcelable(this.maxDate, 0);
            r10.writeTypedList(this.selectedDates);
            r10.writeInt(this.topbarVisible ? 1 : 0);
            r10.writeInt(this.selectionMode);
            r10.writeInt(this.dynamicHeightEnabled ? 1 : 0);
            r10.writeParcelable(this.currentMonth, 0);
            r10.writeByte(this.cacheCurrentPosition ? 1 : 0);
        }
    }

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f6309c;

        a(MaterialCalendarView r10) {
            this.f6309c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            if (r10 != MaterialCalendarView.a(this.f6309c)) goto L7;
            CalendarPager r11 = MaterialCalendarView.b(this.f6309c);
            int r12 = MaterialCalendarView.b(this.f6309c).getCurrentItem() + 1;
        L5:
            r11.setCurrentItem(r12, true);
            return;
        L7:
            if (r10 != MaterialCalendarView.c(this.f6309c)) goto L10;
            r11 = MaterialCalendarView.b(this.f6309c);
            r12 = MaterialCalendarView.b(this.f6309c).getCurrentItem() - 1;
            goto L5
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6310a = null;

        static {
            int[] r10 = new int[CalendarMode.values().length];
            f6310a = r10;
            r10[CalendarMode.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f6310a[CalendarMode.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    protected static class c extends ViewGroup.MarginLayoutParams {
        public c(int r10) {
            super(-1, r10);
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarMode f6311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DayOfWeek f6312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CalendarDay f6313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CalendarDay f6314d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f6315e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f6316f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f6317g;

        private d(MaterialCalendarView r10, e r11) {
            this.f6317g = r10;
            this.f6311a = e.f(r11);
            this.f6312b = e.a(r11);
            this.f6313c = e.b(r11);
            this.f6314d = e.c(r11);
            this.f6315e = e.d(r11);
            this.f6316f = e.e(r11);
        }

        /* synthetic */ d(MaterialCalendarView r10, e r11, a r12) {
            this(r10, r11);
        }

        static /* synthetic */ CalendarMode a(d r10) {
            return r10.f6311a;
        }

        static /* synthetic */ DayOfWeek b(d r10) {
            return r10.f6312b;
        }

        static /* synthetic */ CalendarDay c(d r10) {
            return r10.f6313c;
        }

        static /* synthetic */ CalendarDay d(d r10) {
            return r10.f6314d;
        }

        static /* synthetic */ boolean e(d r10) {
            return r10.f6316f;
        }

        static /* synthetic */ boolean f(d r10) {
            return r10.f6315e;
        }

        public e g() {
            return new e(this.f6317g, this, null);
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CalendarMode f6318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private DayOfWeek f6319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f6320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CalendarDay f6321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CalendarDay f6322e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f6323f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f6324g;

        public e(MaterialCalendarView r10) {
            this.f6324g = r10;
            this.f6320c = false;
            this.f6321d = null;
            this.f6322e = null;
            this.f6318a = CalendarMode.MONTHS;
            this.f6319b = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        private e(MaterialCalendarView r10, d r11) {
            this.f6324g = r10;
            this.f6320c = false;
            this.f6321d = null;
            this.f6322e = null;
            this.f6318a = d.a(r11);
            this.f6319b = d.b(r11);
            this.f6321d = d.c(r11);
            this.f6322e = d.d(r11);
            this.f6320c = d.f(r11);
            this.f6323f = d.e(r11);
        }

        /* synthetic */ e(MaterialCalendarView r10, d r11, a r12) {
            this(r10, r11);
        }

        static /* synthetic */ DayOfWeek a(e r10) {
            return r10.f6319b;
        }

        static /* synthetic */ CalendarDay b(e r10) {
            return r10.f6321d;
        }

        static /* synthetic */ CalendarDay c(e r10) {
            return r10.f6322e;
        }

        static /* synthetic */ boolean d(e r10) {
            return r10.f6320c;
        }

        static /* synthetic */ boolean e(e r10) {
            return r10.f6323f;
        }

        static /* synthetic */ CalendarMode f(e r10) {
            return r10.f6318a;
        }

        public void g() {
            MaterialCalendarView r10 = this.f6324g;
            MaterialCalendarView.d(r10, new d(r10, this, null));
        }

        public e h(boolean r10) {
            this.f6320c = r10;
            return this;
        }

        public e i(CalendarMode r10) {
            this.f6318a = r10;
            return this;
        }

        public e j(DayOfWeek r10) {
            this.f6319b = r10;
            return this;
        }

        public e k(@Nullable CalendarDay r10) {
            this.f6322e = r10;
            return this;
        }

        public e l(@Nullable CalendarDay r10) {
            this.f6321d = r10;
            return this;
        }

        public e m(boolean r10) {
            this.f6323f = r10;
            return this;
        }
    }

    public MaterialCalendarView(Context r10) {
        this(r10, null);
    }

    public MaterialCalendarView(Context r11, AttributeSet r12) {
        super(r11, r12);
        new ArrayList();
        a r10 = new a(this);
        this.f6298p = r10;
        ViewPager.OnPageChangeListener r13 = new AnonymousClass2(this);
        this.f6299q = r13;
        this.f6300r = null;
        this.f6301s = null;
        this.f6307y = 0;
        this.f6308z = -10;
        this.A = -10;
        this.B = -10;
        this.C = -10;
        this.D = 1;
        this.E = true;
        if (Build.VERSION.SDK_INT < 19) goto L5;
        setClipToPadding(false);
        setClipChildren(false);
    L6:
        View r14 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(u8.h.calendar_view, null, false);
        this.f6295m = (LinearLayout) r14.findViewById(u8.f.header);
        ImageView r15 = (ImageView) r14.findViewById(u8.f.previous);
        this.f6290h = r15;
        TextView r16 = (TextView) r14.findViewById(u8.f.month_name);
        this.f6289g = r16;
        ImageView r17 = (ImageView) r14.findViewById(u8.f.next);
        this.f6291i = r17;
        CalendarPager r18 = new CalendarPager(getContext());
        this.f6292j = r18;
        r15.setOnClickListener(r10);
        r17.setOnClickListener(r10);
        n r19 = new n(r16);
        this.f6288c = r19;
        r18.setOnPageChangeListener(r13);
        r18.setPageTransformer(false, new AnonymousClass3(this));
        TypedArray r110 = r11.getTheme().obtainStyledAttributes(r12, u8.l.O_MaterialCalendarView, 0, 0);
        int r20 = r110.getInteger(u8.l.O_MaterialCalendarView_o_mcv_calendarMode, 0);     // Catch: Throwable -> L37 Exception -> L39
        int r21 = r110.getInteger(u8.l.O_MaterialCalendarView_o_mcv_firstDayOfWeek, -1);     // Catch: Throwable -> L37 Exception -> L39
        r19.j(r110.getInteger(u8.l.O_MaterialCalendarView_o_mcv_titleAnimationOrientation, 0));     // Catch: Throwable -> L37 Exception -> L39
        if (r21 >= 1) goto L10;
    L13:
        DayOfWeek r22 = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L37 Exception -> L39
    L12:
        this.F = r22;     // Catch: Throwable -> L37 Exception -> L39
        this.G = r110.getBoolean(u8.l.O_MaterialCalendarView_o_mcv_showWeekDays, true);     // Catch: Throwable -> L37 Exception -> L39
        A().j(this.F).i(CalendarMode.values()[r20]).m(this.G).g();     // Catch: Throwable -> L37 Exception -> L39
        setSelectionMode(r110.getInteger(u8.l.O_MaterialCalendarView_o_mcv_selectionMode, 1));     // Catch: Throwable -> L37 Exception -> L39
        int r23 = r110.getLayoutDimension(u8.l.O_MaterialCalendarView_o_mcv_tileSize, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r23 <= (-10)) goto L17;
        setTileSize(r23);     // Catch: Throwable -> L37 Exception -> L39
    L17:
        int r24 = r110.getLayoutDimension(u8.l.O_MaterialCalendarView_o_mcv_tileWidth, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r24 <= (-10)) goto L20;
        setTileWidth(r24);     // Catch: Throwable -> L37 Exception -> L39
    L20:
        int r25 = r110.getLayoutDimension(u8.l.O_MaterialCalendarView_o_mcv_tileHeight, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r25 <= (-10)) goto L23;
        setTileHeight(r25);     // Catch: Throwable -> L37 Exception -> L39
    L23:
        int r26 = r110.getLayoutDimension(u8.l.O_MaterialCalendarView_o_mcv_tileHSpacing, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r24 <= (-10)) goto L26;
        setTileHSpacing(r26);     // Catch: Throwable -> L37 Exception -> L39
    L26:
        int r27 = r110.getLayoutDimension(u8.l.O_MaterialCalendarView_o_mcv_tileVSpacing, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r24 <= (-10)) goto L29;
        setTileVSpacing(r27);     // Catch: Throwable -> L37 Exception -> L39
    L29:
        setLeftArrow(r110.getResourceId(u8.l.O_MaterialCalendarView_o_mcv_leftArrow, u8.e.o_mcv_action_previous));     // Catch: Throwable -> L37 Exception -> L39
        setRightArrow(r110.getResourceId(u8.l.O_MaterialCalendarView_o_mcv_rightArrow, u8.e.o_mcv_action_next));     // Catch: Throwable -> L37 Exception -> L39
        setSelectionColor(r110.getColor(u8.l.O_MaterialCalendarView_o_mcv_selectionColor, w(r11)));     // Catch: Throwable -> L37 Exception -> L39
        CharSequence[] r111 = r110.getTextArray(u8.l.O_MaterialCalendarView_o_mcv_weekDayLabels);     // Catch: Throwable -> L37 Exception -> L39
        if (r111 == null) goto L32;
        setWeekDayFormatter(new m9.a(r111));     // Catch: Throwable -> L37 Exception -> L39
    L32:
        CharSequence[] r112 = r110.getTextArray(u8.l.O_MaterialCalendarView_o_mcv_monthLabels);     // Catch: Throwable -> L37 Exception -> L39
        if (r112 == null) goto L35;
        setTitleFormatter(new m9.f(r112));     // Catch: Throwable -> L37 Exception -> L39
    L35:
        setHeaderTextAppearance(r110.getResourceId(u8.l.O_MaterialCalendarView_o_mcv_headerTextAppearance, u8.k.TextAppearance_MaterialCalendarWidget_Header));     // Catch: Throwable -> L37 Exception -> L39
        setWeekDayTextAppearance(r110.getResourceId(u8.l.O_MaterialCalendarView_o_mcv_weekDayTextAppearance, u8.k.TextAppearance_MaterialCalendarWidget_WeekDay));     // Catch: Throwable -> L37 Exception -> L39
        setDateTextAppearance(r110.getResourceId(u8.l.O_MaterialCalendarView_o_mcv_dateTextAppearance, u8.k.TextAppearance_MaterialCalendarWidget_Date));     // Catch: Throwable -> L37 Exception -> L39
        setShowOtherDates(r110.getInteger(u8.l.O_MaterialCalendarView_o_mcv_showOtherDates, 4));     // Catch: Throwable -> L37 Exception -> L39
        setAllowClickDaysOutsideCurrentMonth(r110.getBoolean(u8.l.O_MaterialCalendarView_o_mcv_allowClickDaysOutsideCurrentMonth, true));     // Catch: Throwable -> L37 Exception -> L39
    L41:
        r110.recycle();
        I();
        CalendarDay r113 = CalendarDay.today();
        this.f6294l = r113;
        setCurrentDate(r113);
        if (isInEditMode() == false) goto L49;
        removeView(this.f6292j);
        h r114 = new h(this, this.f6294l, getFirstDayOfWeek(), true);
        r114.s(getSelectionColor());
        r114.l(this.f6293k.getDateTextAppearance());
        r114.w(this.f6293k.getWeekDayTextAppearance());
        r114.u(getShowOtherDates());
        addView(r114, new c(this.f6296n.visibleWeeksCount + 1));
        return;
    L49:
        return;
    L10:
        if (r21 > 7) goto L13;
        r22 = DayOfWeek.of(r21);     // Catch: Throwable -> L37 Exception -> L39
    L37:
        th = move-exception;
        r110.recycle();
        throw th;
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
        goto L41
    L5:
        setClipChildren(true);
        setClipToPadding(true);
        goto L6
    }

    private void H(CalendarDay r10, CalendarDay r11) {
        CalendarDay r12 = this.f6294l;
        this.f6293k.setRangeDates(r10, r11);
        this.f6294l = r12;
        if (r10 != null) goto L5;
    L9:
        int r13 = this.f6293k.getIndexForDay(r12);
        this.f6292j.setCurrentItem(r13, false);
        N();
        return;
    L5:
        if (r10.isAfter(r12) == true) goto L8;
        r10 = this.f6294l;
    L8:
        this.f6294l = r10;
        goto L9
    }

    private void I() {
        addView(this.f6295m);
        this.f6292j.setId(u8.f.mcv_pager);
        this.f6292j.setOffscreenPageLimit(1);
        if (this.G == false) goto L5;
        int r10 = this.f6296n.visibleWeeksCount + 1;
    L6:
        addView(this.f6292j, new c(r10));
        return;
    L5:
        r10 = this.f6296n.visibleWeeksCount;
        goto L6
    }

    public static boolean J(int r10) {
        if ((r10 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean K(int r10) {
        if ((r10 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean L(int r10) {
        if ((r10 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void N() {
        this.f6288c.f(this.f6294l);
        t(this.f6290h, k());
        t(this.f6291i, l());
    }

    static /* synthetic */ ImageView a(MaterialCalendarView r10) {
        return r10.f6291i;
    }

    static /* synthetic */ CalendarPager b(MaterialCalendarView r10) {
        return r10.f6292j;
    }

    static /* synthetic */ ImageView c(MaterialCalendarView r10) {
        return r10.f6290h;
    }

    static /* synthetic */ void d(MaterialCalendarView r10, d r11) {
        r10.o(r11);
    }

    static /* synthetic */ CalendarDay e(MaterialCalendarView r10) {
        return r10.f6294l;
    }

    static /* synthetic */ CalendarDay f(MaterialCalendarView r10, CalendarDay r11) {
        r10.f6294l = r11;
        return r11;
    }

    static /* synthetic */ n g(MaterialCalendarView r10) {
        return r10.f6288c;
    }

    private int getWeekCountBasedOnMode() {
        CalendarMode r10 = this.f6296n;
        int r11 = r10.visibleWeeksCount;
        if (r10.equals(CalendarMode.MONTHS) == false) goto L12;
        if (this.f6297o == false) goto L12;
        CalendarPagerAdapter<?> r12 = this.f6293k;
        if (r12 == null) goto L12;
        CalendarPager r13 = this.f6292j;
        if (r13 == null) goto L12;
        LocalDate r14 = r12.getItem(r13.getCurrentItem()).getDate();
        r11 = r14.withDayOfMonth(r14.lengthOfMonth()).get(WeekFields.of(this.F, 1).weekOfMonth());
    L12:
        if (this.G == true) goto L14;
        return r11;
    L14:
        return r11 + 1;
    }

    static /* synthetic */ CalendarPagerAdapter h(MaterialCalendarView r10) {
        return r10.f6293k;
    }

    static /* synthetic */ void i(MaterialCalendarView r10) {
        r10.N();
    }

    private static int m(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        if (r12 == Integer.MIN_VALUE) goto L9;
        if (r12 == 1073741824) goto L7;
        return r10;
    L7:
        return r13;
    L9:
        return Math.min(r10, r13);
    }

    private void o(d r10) {
        if (this.f6293k != null) goto L5;
    L32:
        CalendarDay r11 = null;
    L33:
        this.H = r10;
        this.f6296n = d.a(r10);
        this.F = d.b(r10);
        this.f6300r = d.c(r10);
        this.f6301s = d.d(r10);
        this.G = d.e(r10);
        int r12 = b.f6310a[this.f6296n.ordinal()];
        if (r12 != 1) goto L36;
        CalendarPagerAdapter<?> r13 = new MonthPagerAdapter(this);
    L41:
        CalendarPagerAdapter<?> r14 = this.f6293k;
        if (r14 == null) goto L45;
        r13 = r14.migrateStateAndReturn(r13);
    L45:
        this.f6293k = r13;
        this.f6293k.setShowWeekDays(this.G);
        this.f6292j.setAdapter(this.f6293k);
        H(this.f6300r, this.f6301s);
        if (this.G == false) goto L48;
        int r15 = this.f6296n.visibleWeeksCount + 1;
    L49:
        this.f6292j.setLayoutParams(new c(r15));
        if (this.D == 1) goto L52;
    L54:
        CalendarDay r16 = CalendarDay.today();
    L55:
        setCurrentDate(r16);
        if (r11 == null) goto L58;
        this.f6292j.setCurrentItem(this.f6293k.getIndexForDay(r11));
    L58:
        z();
        N();
        return;
    L52:
        if (this.f6293k.getSelectedDates().isEmpty() == true) goto L54;
        r16 = this.f6293k.getSelectedDates().get(0);
        goto L55
    L48:
        r15 = this.f6296n.visibleWeeksCount;
        goto L49
    L36:
        if (r12 != 2) goto L39;
        r13 = new WeekPagerAdapter(this);
        goto L41
    L39:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L5:
        if (d.f(r10) == false) goto L32;
        r11 = this.f6293k.getItem(this.f6292j.getCurrentItem());
        if (this.f6296n == d.a(r10)) goto L33;
        CalendarDay r17 = getSelectedDate();
        CalendarMode r18 = this.f6296n;
        if (r18 != CalendarMode.MONTHS) goto L19;
        if (r17 == null) goto L19;
        CalendarDay r19 = CalendarDay.from(r11.getDate().plusDays(1));
        if (r17.equals(r11) == false) goto L14;
    L30:
        r11 = r17;
        goto L33
    L14:
        if (r17.isAfter(r11) == false) goto L33;
        if (r17.isBefore(r19) == false) goto L33;
    L19:
        if (r18 != CalendarMode.WEEKS) goto L33;
        CalendarDay r20 = CalendarDay.from(r11.getDate().plusDays(6));
        if (r17 != null) goto L23;
    L31:
        r11 = r20;
        goto L33
    L23:
        if (r17.equals(r11) == true) goto L30;
        if (r17.equals(r20) == true) goto L30;
        if (r17.isAfter(r11) == false) goto L31;
        if (r17.isBefore(r20) == false) goto L31;
        goto L30
    }

    private int s(int r10) {
        return (int) TypedValue.applyDimension(1, r10, getResources().getDisplayMetrics());
    }

    private static void t(View r10, boolean r11) {
        r10.setEnabled(r11);
        if (r11 == false) goto L5;
        float r12 = 1.0f;
    L6:
        r10.setAlpha(r12);
        return;
    L5:
        r12 = 0.1f;
        goto L6
    }

    private static int w(Context r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        int r11 = R.attr.colorAccent;
    L6:
        TypedValue r12 = new TypedValue();
        r10.getTheme().resolveAttribute(r11, r12, true);
        return r12.data;
    L5:
        r11 = r10.getResources().getIdentifier("colorAccent", "attr", r10.getPackageName());
        goto L6
    }

    public e A() {
        return new e(this);
    }

    protected void B(@NonNull CalendarDay r10, boolean r11) {
        int r12 = this.D;
        if (r12 != 2) goto L5;
    L21:
        this.f6293k.setDateSelected(r10, r11);
        p(r10, r11);
        return;
    L5:
        if (r12 == 3) goto L7;
        this.f6293k.clearSelections();
        this.f6293k.setDateSelected(r10, true);
        p(r10, true);
        return;
    L7:
        List<CalendarDay> r13 = this.f6293k.getSelectedDates();
        if (r13.size() == 0) goto L21;
        if (r13.size() != 1) goto L20;
        CalendarDay r14 = r13.get(0);
        if (r14.equals(r10) == true) goto L21;
        if (r14.isAfter(r10) == false) goto L18;
        this.f6293k.selectRange(r10, r14);
    L19:
        r(this.f6293k.getSelectedDates());
        return;
    L18:
        this.f6293k.selectRange(r14, r10);
        goto L19
    L20:
        this.f6293k.clearSelections();
        goto L21
    }

    protected void C(DayView r10) {
        CalendarDay r11 = getCurrentDate();
        CalendarDay r12 = r10.getDate();
        int r13 = r11.getMonth();
        int r14 = r12.getMonth();
        if (this.f6296n == CalendarMode.MONTHS) goto L5;
    L13:
        B(r10.getDate(), !r10.isChecked());
        return;
    L5:
        if (this.E == false) goto L13;
        if (r13 == r14) goto L13;
        if (r11.isAfter(r12) == false) goto L11;
        y();
        goto L13
    L11:
        if (r11.isBefore(r12) == false) goto L13;
        x();
        goto L13
    }

    protected void D(DayView r10) {
        j r11 = this.f6303u;
        if (r11 == null) goto L6;
        r11.a(this, r10.getDate());
        return;
    }

    protected void E(CalendarDay r10) {
        p(r10, false);
    }

    public void F(@Nullable CalendarDay r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = this.f6293k.getIndexForDay(r10);
        this.f6292j.setCurrentItem(r12, r11);
        N();
    }

    public void G(@Nullable CalendarDay r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f6293k.setDateSelected(r10, r11);
    }

    public d M() {
        return this.H;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> r10) {
        dispatchThawSelfOnly(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(@NonNull SparseArray<Parcelable> r10) {
        dispatchFreezeSelfOnly(r10);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return u();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return v(r10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new c(1);
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r10 = this.f6306x;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return getContext().getString(u8.j.oui_calendar);
    }

    public CalendarMode getCalendarMode() {
        return this.f6296n;
    }

    public CalendarDay getCurrentDate() {
        return this.f6293k.getItem(this.f6292j.getCurrentItem());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.F;
    }

    public Drawable getLeftArrow() {
        return this.f6290h.getDrawable();
    }

    public CalendarDay getMaximumDate() {
        return this.f6301s;
    }

    public CalendarDay getMinimumDate() {
        return this.f6300r;
    }

    public Drawable getRightArrow() {
        return this.f6291i.getDrawable();
    }

    @Nullable
    public CalendarDay getSelectedDate() {
        List<CalendarDay> r10 = this.f6293k.getSelectedDates();
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return r10.get(r10.size() - 1);
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        return this.f6293k.getSelectedDates();
    }

    public int getSelectionColor() {
        return this.f6307y;
    }

    public int getSelectionMode() {
        return this.D;
    }

    public int getShowOtherDates() {
        return this.f6293k.getShowOtherDates();
    }

    public int getTileHSpacing() {
        return this.B;
    }

    public int getTileHeight() {
        return this.f6308z;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.f6308z, this.A);
    }

    public int getTileVSpacing() {
        return this.C;
    }

    public int getTileWidth() {
        return this.A;
    }

    public int getTitleAnimationOrientation() {
        return this.f6288c.i();
    }

    public boolean getTopbarVisible() {
        if (this.f6295m.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        return this.E;
    }

    public boolean k() {
        if (this.f6292j.getCurrentItem() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if (this.f6292j.getCurrentItem() < (this.f6293k.getCount() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public void n() {
        List<CalendarDay> r10 = getSelectedDates();
        this.f6293k.clearSelections();
        Iterator<CalendarDay> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        p(r11.next(), false);
        goto L4
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = getPaddingLeft();
        int r17 = ((r13 - r11) - r16) - getPaddingRight();
        int r18 = getPaddingTop();
        int r19 = 0;
    L3:
        if (r19 >= r15) goto L9;
        View r20 = getChildAt(r19);
        if (r20.getVisibility() == 8) goto L8;
        int r21 = r20.getMeasuredWidth();
        int r22 = ((r17 - r21) / 2) + r16;
        int r23 = r20.getMeasuredHeight() + r18;
        r20.layout(r22, r18, r21 + r22, r23);
        r18 = r23;
    L8:
        r19 = r19 + 1;
        goto L3
    }

    @Override // android.view.View
    protected void onMeasure(int r12, int r13) {
        int r10 = View.MeasureSpec.getSize(r12);
        int r11 = View.MeasureSpec.getMode(r12);
        int r14 = View.MeasureSpec.getSize(r13);
        int r15 = View.MeasureSpec.getMode(r13);
        int r16 = (r10 - getPaddingLeft()) - getPaddingRight();
        int r17 = (r14 - getPaddingTop()) - getPaddingBottom();
        int r18 = getWeekCountBasedOnMode();
        if (getTopbarVisible() == false) goto L5;
        r18 = r18 + 1;
    L5:
        int r19 = r16 / 7;
        int r20 = r17 / r18;
        int r21 = this.A;
        int r22 = -1;
        if (r21 == (-10)) goto L8;
    L22:
        if (r21 <= 0) goto L24;
        r19 = r21;
    L24:
        int r23 = this.f6308z;
        if (r23 <= 0) goto L27;
        r20 = r23;
    L27:
        r22 = r19;
        r19 = -1;
    L28:
        if (r19 <= 0) goto L30;
        r20 = r19;
    L39:
        int r24 = 0;
        int r25 = r19 * 7;
        int r26 = ((Math.max(this.C, 0) + r20) * Math.max(0, r18 - 1)) + r20;
        setMeasuredDimension(m((getPaddingLeft() + getPaddingRight()) + r25, r12), m(r26 + (getPaddingTop() + getPaddingBottom()), r13));
        int r110 = getChildCount();
        int r111 = Math.max(this.B, 0);
    L40:
        if (r24 >= r110) goto L42;
        View r27 = getChildAt(r24);
        r27.measure(View.MeasureSpec.makeMeasureSpec((r111 * 6) + r25, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) ((c) r27.getLayoutParams())).height * r20, 1073741824));
        r24 = r24 + 1;
        goto L40
    L42:
        return;
    L30:
        if (r19 <= 0) goto L32;
        r19 = r22;
        goto L39
    L32:
        if (r22 > 0) goto L34;
        int r28 = s(44);
    L35:
        if (r20 > 0) goto L37;
        r20 = s(44);
    L37:
        r19 = r28;
        goto L39
    L34:
        r28 = r22;
        goto L35
    L8:
        if (this.f6308z != (-10)) goto L22;
        if (r11 != 1073741824) goto L12;
    L19:
        if (r15 != 1073741824) goto L21;
        r19 = Math.min(r19, r20);
    L21:
        r20 = -1;
        goto L28
    L12:
        if (r11 == Integer.MIN_VALUE) goto L19;
        if (r15 == 1073741824) goto L18;
        if (r15 == Integer.MIN_VALUE) goto L18;
        r19 = -1;
        r20 = -1;
    L18:
        r19 = r20;
        goto L21
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        M().g().l(r11.minDate).k(r11.maxDate).h(r11.cacheCurrentPosition).g();
        setShowOtherDates(r11.showOtherDates);
        setAllowClickDaysOutsideCurrentMonth(r11.allowClickDaysOutsideCurrentMonth);
        n();
        Iterator<CalendarDay> r12 = r11.selectedDates.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        G(r12.next(), true);
        goto L4
    L6:
        setTopbarVisible(r11.topbarVisible);
        setSelectionMode(r11.selectionMode);
        setDynamicHeightEnabled(r11.dynamicHeightEnabled);
        setCurrentDate(r11.currentMonth);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.showOtherDates = getShowOtherDates();
        r10.allowClickDaysOutsideCurrentMonth = j();
        r10.minDate = getMinimumDate();
        r10.maxDate = getMaximumDate();
        r10.selectedDates = getSelectedDates();
        r10.selectionMode = getSelectionMode();
        r10.topbarVisible = getTopbarVisible();
        r10.dynamicHeightEnabled = this.f6297o;
        r10.currentMonth = this.f6294l;
        r10.cacheCurrentPosition = d.f(this.H);
        return r10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        return this.f6292j.dispatchTouchEvent(r10);
    }

    protected void p(CalendarDay r10, boolean r11) {
        k r12 = this.f6302t;
        if (r12 == null) goto L6;
        r12.a(this, r10, r11);
        return;
    }

    protected void q(CalendarDay r10) {
        l r11 = this.f6304v;
        if (r11 == null) goto L6;
        r11.a(this, r10);
        return;
    }

    protected void r(@NonNull List<CalendarDay> r10) {
        m r11 = this.f6305w;
        if (r11 == null) goto L6;
        r11.a(this, r10);
        return;
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r10) {
        this.E = r10;
    }

    public void setContentDescriptionArrowFuture(CharSequence r10) {
        this.f6291i.setContentDescription(r10);
    }

    public void setContentDescriptionArrowPast(CharSequence r10) {
        this.f6290h.setContentDescription(r10);
    }

    public void setContentDescriptionCalendar(CharSequence r10) {
        this.f6306x = r10;
    }

    public void setCurrentDate(@Nullable CalendarDay r10) {
        F(r10, true);
    }

    public void setCurrentDate(@Nullable LocalDate r10) {
        setCurrentDate(CalendarDay.from(r10));
    }

    public void setDateTextAppearance(int r10) {
        this.f6293k.setDateTextAppearance(r10);
    }

    public void setDayFormatter(m9.e r10) {
        CalendarPagerAdapter<?> r11 = this.f6293k;
        if (r10 != null) goto L5;
        r10 = m9.e.f11059a;
    L5:
        r11.setDayFormatter(r10);
    }

    public void setDayFormatterContentDescription(m9.e r10) {
        this.f6293k.setDayFormatterContentDescription(r10);
    }

    public void setDynamicHeightEnabled(boolean r10) {
        this.f6297o = r10;
    }

    public void setHeaderTextAppearance(int r10) {
        this.f6289g.setTextAppearance(getContext(), r10);
    }

    public void setLeftArrow(@DrawableRes int r10) {
        this.f6290h.setImageResource(r10);
    }

    public void setOnDateChangedListener(k r10) {
        this.f6302t = r10;
    }

    public void setOnDateLongClickListener(j r10) {
        this.f6303u = r10;
    }

    public void setOnMonthChangedListener(l r10) {
        this.f6304v = r10;
    }

    public void setOnRangeSelectedListener(m r10) {
        this.f6305w = r10;
    }

    public void setOnTitleClickListener(View.OnClickListener r10) {
        this.f6289g.setOnClickListener(r10);
    }

    public void setPagingEnabled(boolean r10) {
        this.f6292j.setPagingEnabled(r10);
        N();
    }

    public void setRightArrow(@DrawableRes int r10) {
        this.f6291i.setImageResource(r10);
    }

    public void setSelectedDate(@Nullable CalendarDay r10) {
        n();
        if (r10 == null) goto L6;
        G(r10, true);
        return;
    }

    public void setSelectedDate(@Nullable LocalDate r10) {
        setSelectedDate(CalendarDay.from(r10));
    }

    public void setSelectionColor(int r10) {
        if (r10 == 0) goto L4;
    L7:
        this.f6307y = r10;
        this.f6293k.setSelectionColor(r10);
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r10 = -7829368;
        goto L7
    }

    public void setSelectionMode(int r10) {
        int r11 = this.D;
        this.D = r10;
        boolean r12 = false;
        if (r10 == 1) goto L9;
        if (r10 == 2) goto L14;
        if (r10 == 3) goto L8;
        this.D = 0;
        if (r11 == 0) goto L14;
    L8:
        n();
    L14:
        CalendarPagerAdapter<?> r13 = this.f6293k;
        if (this.D == 0) goto L17;
        r12 = true;
    L17:
        r13.setSelectionEnabled(r12);
        return;
    L9:
        if (r11 == 2) goto L12;
        if (r11 != 3) goto L14;
    L12:
        if (getSelectedDates().isEmpty() == true) goto L14;
        setSelectedDate(getSelectedDate());
        goto L14
    }

    public void setShowOtherDates(int r10) {
        this.f6293k.setShowOtherDates(r10);
    }

    public void setTileHSpacing(int r10) {
        this.B = r10;
        requestLayout();
    }

    public void setTileHeight(int r10) {
        this.f6308z = r10;
        requestLayout();
    }

    public void setTileHeightDp(int r10) {
        setTileHeight(s(r10));
    }

    public void setTileSize(int r10) {
        this.A = r10;
        this.f6308z = r10;
        requestLayout();
    }

    public void setTileSizeDp(int r10) {
        setTileSize(s(r10));
    }

    public void setTileVSpacing(int r10) {
        this.C = r10;
        requestLayout();
    }

    public void setTileWidth(int r10) {
        this.A = r10;
        requestLayout();
    }

    public void setTileWidthDp(int r10) {
        setTileWidth(s(r10));
    }

    public void setTitleAnimationOrientation(int r10) {
        this.f6288c.j(r10);
    }

    public void setTitleFormatter(@Nullable m9.g r10) {
        this.f6288c.l(r10);
        this.f6293k.setTitleFormatter(r10);
        N();
    }

    public void setTitleMonths(@ArrayRes int r10) {
        setTitleMonths(getResources().getTextArray(r10));
    }

    public void setTitleMonths(CharSequence[] r10) {
        setTitleFormatter(new m9.f(r10));
    }

    public void setTopbarVisible(boolean r10) {
        LinearLayout r11 = this.f6295m;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        requestLayout();
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public void setWeekDayFormatter(m9.h r10) {
        CalendarPagerAdapter<?> r11 = this.f6293k;
        if (r10 != null) goto L5;
        r10 = m9.h.f11062a;
    L5:
        r11.setWeekDayFormatter(r10);
    }

    public void setWeekDayLabels(@ArrayRes int r10) {
        setWeekDayLabels(getResources().getTextArray(r10));
    }

    public void setWeekDayLabels(CharSequence[] r10) {
        setWeekDayFormatter(new m9.a(r10));
    }

    public void setWeekDayTextAppearance(int r10) {
        this.f6293k.setWeekDayTextAppearance(r10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected c u() {
        return new c(1);
    }

    public c v(AttributeSet r10) {
        return new c(1);
    }

    public void x() {
        if (l() == false) goto L6;
        CalendarPager r10 = this.f6292j;
        r10.setCurrentItem(r10.getCurrentItem() + 1, true);
        return;
    }

    public void y() {
        if (k() == false) goto L6;
        CalendarPager r10 = this.f6292j;
        r10.setCurrentItem(r10.getCurrentItem() - 1, true);
        return;
    }

    public void z() {
        this.f6293k.invalidateDecorators();
    }
}
