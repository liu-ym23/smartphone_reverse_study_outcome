package com.obric.oui.calendar;

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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes5.dex */
public class MaterialCalendarView extends ViewGroup {
    private boolean A;
    private DayOfWeek B;
    private boolean C;
    private int D;
    private b E;
    private final a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CharSequence f13410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f13411b;
    private final TextView c;
    private final ImageView d;
    private final ImageView e;
    private final CalendarPager f;
    private CalendarPagerAdapter<?> g;
    private CalendarDay h;
    private LinearLayout i;
    private CalendarMode j;
    private boolean k;
    private final ArrayList<d> l;
    private final View.OnClickListener m;
    private final ViewPager.OnPageChangeListener n;
    private CalendarDay o;
    private CalendarDay p;
    private j q;
    private i r;
    private k s;
    private l t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: renamed from: com.obric.oui.calendar.MaterialCalendarView$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13413a = null;

        static {
            int[] r0 = new int[CalendarMode.values().length];
            f13413a = r0;
            r0[CalendarMode.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f13413a[CalendarMode.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

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

        static {
            CREATOR = new AnonymousClass1();
        }

        private SavedState(Parcel r7) {
            super(r7);
            this.showOtherDates = 4;
            boolean r0 = true;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.currentMonth = null;
            this.showOtherDates = r7.readInt();
            if (r7.readByte() == 0) goto L5;
            boolean r1 = true;
        L6:
            this.allowClickDaysOutsideCurrentMonth = r1;
            ClassLoader r2 = CalendarDay.class.getClassLoader();
            this.minDate = (CalendarDay) ZeusTransformUtils.preCheckCast(r7.readParcelable(r2), CalendarDay.class, "com.obric.memorydata.plugin");
            this.maxDate = (CalendarDay) ZeusTransformUtils.preCheckCast(r7.readParcelable(r2), CalendarDay.class, "com.obric.memorydata.plugin");
            r7.readTypedList(this.selectedDates, CalendarDay.CREATOR);
            if (r7.readInt() != 1) goto L9;
            boolean r3 = true;
        L10:
            this.topbarVisible = r3;
            this.selectionMode = r7.readInt();
            if (r7.readInt() != 1) goto L13;
            boolean r4 = true;
        L14:
            this.dynamicHeightEnabled = r4;
            this.currentMonth = (CalendarDay) ZeusTransformUtils.preCheckCast(r7.readParcelable(r2), CalendarDay.class, "com.obric.memorydata.plugin");
            if (r7.readByte() != 0) goto L18;
            r0 = false;
        L18:
            this.cacheCurrentPosition = r0;
            return;
        L13:
            r4 = false;
            goto L14
        L9:
            r3 = false;
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
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
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.showOtherDates);
            r2.writeByte(this.allowClickDaysOutsideCurrentMonth ? 1 : 0);
            r2.writeParcelable(this.minDate, 0);
            r2.writeParcelable(this.maxDate, 0);
            r2.writeTypedList(this.selectedDates);
            r2.writeInt(this.topbarVisible ? 1 : 0);
            r2.writeInt(this.selectionMode);
            r2.writeInt(this.dynamicHeightEnabled ? 1 : 0);
            r2.writeParcelable(this.currentMonth, 0);
            r2.writeByte(this.cacheCurrentPosition ? 1 : 0);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13415b;

        public a() {
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f13416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CalendarMode f13417b;
        private final DayOfWeek c;
        private final CalendarDay d;
        private final CalendarDay e;
        private final boolean f;
        private final boolean g;

        private b(MaterialCalendarView r1, c r2) {
            this.f13416a = r1;
            this.f13417b = c.a(r2);
            this.c = c.b(r2);
            this.d = c.c(r2);
            this.e = c.d(r2);
            this.f = c.e(r2);
            this.g = c.f(r2);
        }

        /* synthetic */ b(MaterialCalendarView r1, c r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ boolean a(b r0) {
            return r0.f;
        }

        static /* synthetic */ CalendarMode b(b r0) {
            return r0.f13417b;
        }

        static /* synthetic */ DayOfWeek c(b r0) {
            return r0.c;
        }

        static /* synthetic */ CalendarDay d(b r0) {
            return r0.d;
        }

        static /* synthetic */ CalendarDay e(b r0) {
            return r0.e;
        }

        static /* synthetic */ boolean f(b r0) {
            return r0.g;
        }

        public c a() {
            return new c(this.f13416a, this, null);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f13418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CalendarMode f13419b;
        private DayOfWeek c;
        private boolean d;
        private CalendarDay e;
        private CalendarDay f;
        private boolean g;

        public c(MaterialCalendarView r4) {
            this.f13418a = r4;
            this.d = false;
            this.e = null;
            this.f = null;
            this.f13419b = CalendarMode.MONTHS;
            this.c = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        private c(MaterialCalendarView r1, b r2) {
            this.f13418a = r1;
            this.d = false;
            this.e = null;
            this.f = null;
            this.f13419b = b.b(r2);
            this.c = b.c(r2);
            this.e = b.d(r2);
            this.f = b.e(r2);
            this.d = b.a(r2);
            this.g = b.f(r2);
        }

        /* synthetic */ c(MaterialCalendarView r1, b r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ CalendarMode a(c r0) {
            return r0.f13419b;
        }

        static /* synthetic */ DayOfWeek b(c r0) {
            return r0.c;
        }

        static /* synthetic */ CalendarDay c(c r0) {
            return r0.e;
        }

        static /* synthetic */ CalendarDay d(c r0) {
            return r0.f;
        }

        static /* synthetic */ boolean e(c r0) {
            return r0.d;
        }

        static /* synthetic */ boolean f(c r0) {
            return r0.g;
        }

        public c a(CalendarDay r1) {
            this.e = r1;
            return this;
        }

        public c a(CalendarMode r1) {
            this.f13419b = r1;
            return this;
        }

        public c a(DayOfWeek r1) {
            this.c = r1;
            return this;
        }

        public c a(boolean r1) {
            this.g = r1;
            return this;
        }

        public void a() {
            MaterialCalendarView.a(this.f13418a, new b(this.f13418a, this, null));
        }

        public c b(CalendarDay r1) {
            this.f = r1;
            return this;
        }

        public c b(boolean r1) {
            this.d = r1;
            return this;
        }
    }

    public MaterialCalendarView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public MaterialCalendarView(Context r17, AttributeSet r18) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r18, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r4, r6);
        this.l = new ArrayList();
        View.OnClickListener r7 = new AnonymousClass1(this);
        this.m = r7;
        ViewPager.OnPageChangeListener r8 = new AnonymousClass2(this);
        this.n = r8;
        this.o = null;
        this.p = null;
        this.u = 0;
        this.v = -10;
        this.w = -10;
        this.x = -10;
        this.y = -10;
        this.z = 1;
        this.A = true;
        this.D = -10;
        this.F = new a();
        if (Build.VERSION.SDK_INT < 19) goto L5;
        setClipToPadding(false);
        setClipChildren(false);
    L6:
        View r9 = ZeusTransformUtils.inflate((LayoutInflater) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("layout_inflater"), LayoutInflater.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.calendar_view, "layout", "calendar_view"), null, false, "com.obric.memorydata.plugin");
        this.i = (LinearLayout) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.header, OaidModel.KEY_ID, "header")), LinearLayout.class, "com.obric.memorydata.plugin");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.previous, OaidModel.KEY_ID, "previous")), ImageView.class, "com.obric.memorydata.plugin");
        this.d = r11;
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.month_name, OaidModel.KEY_ID, "month_name")), TextView.class, "com.obric.memorydata.plugin");
        this.c = r14;
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.next, OaidModel.KEY_ID, "next")), ImageView.class, "com.obric.memorydata.plugin");
        this.e = r10;
        CalendarPager r12 = new CalendarPager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.f = r12;
        r11.setOnClickListener(r7);
        r10.setOnClickListener(r7);
        m r5 = new m(r14);
        this.f13411b = r5;
        r12.setOnPageChangeListener(r8);
        r12.setPageTransformer(false, new AnonymousClass3(this));
        TypedArray r13 = r4.getTheme().obtainStyledAttributes(r6, R.styleable.O_MaterialCalendarView, 0, 0);
        int r15 = r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_calendarMode, "styleable", "O_MaterialCalendarView_o_mcv_calendarMode"), 0);     // Catch: Throwable -> L37 Exception -> L39
        int r16 = r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_firstDayOfWeek, "styleable", "O_MaterialCalendarView_o_mcv_firstDayOfWeek"), -1);     // Catch: Throwable -> L37 Exception -> L39
        r5.a(r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_titleAnimationOrientation, "styleable", "O_MaterialCalendarView_o_mcv_titleAnimationOrientation"), 0));     // Catch: Throwable -> L37 Exception -> L39
        if (r16 >= 1) goto L10;
    L13:
        DayOfWeek r19 = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L37 Exception -> L39
    L12:
        this.B = r19;     // Catch: Throwable -> L37 Exception -> L39
        this.C = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_showWeekDays, "styleable", "O_MaterialCalendarView_o_mcv_showWeekDays"), true);     // Catch: Throwable -> L37 Exception -> L39
        m().a(this.B).a(CalendarMode.values()[r15]).a(this.C).a();     // Catch: Throwable -> L37 Exception -> L39
        setSelectionMode(r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_selectionMode, "styleable", "O_MaterialCalendarView_o_mcv_selectionMode"), 1));     // Catch: Throwable -> L37 Exception -> L39
        int r20 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileSize, "styleable", "O_MaterialCalendarView_o_mcv_tileSize"), -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r20 <= (-10)) goto L17;
        setTileSize(r20);     // Catch: Throwable -> L37 Exception -> L39
    L17:
        int r21 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileWidth, "styleable", "O_MaterialCalendarView_o_mcv_tileWidth"), -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r21 <= (-10)) goto L20;
        setTileWidth(r21);     // Catch: Throwable -> L37 Exception -> L39
    L20:
        int r22 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileHeight, "styleable", "O_MaterialCalendarView_o_mcv_tileHeight"), -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r22 <= (-10)) goto L23;
        setTileHeight(r22);     // Catch: Throwable -> L37 Exception -> L39
    L23:
        int r23 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileHSpacing, "styleable", "O_MaterialCalendarView_o_mcv_tileHSpacing"), -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r23 <= (-10)) goto L26;
        setTileHSpacing(r23);     // Catch: Throwable -> L37 Exception -> L39
    L26:
        int r24 = r13.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_tileVSpacing, "styleable", "O_MaterialCalendarView_o_mcv_tileVSpacing"), -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r24 <= (-10)) goto L29;
        setTileVSpacing(r24);     // Catch: Throwable -> L37 Exception -> L39
    L29:
        setLeftArrow(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_leftArrow, "styleable", "O_MaterialCalendarView_o_mcv_leftArrow"), ZeusTransformUtils.mapRes(R.drawable.o_mcv_action_previous, "drawable", "o_mcv_action_previous")));     // Catch: Throwable -> L37 Exception -> L39
        setRightArrow(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_rightArrow, "styleable", "O_MaterialCalendarView_o_mcv_rightArrow"), ZeusTransformUtils.mapRes(R.drawable.o_mcv_action_next, "drawable", "o_mcv_action_next")));     // Catch: Throwable -> L37 Exception -> L39
        setSelectionColor(r13.getColor(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_selectionColor, "styleable", "O_MaterialCalendarView_o_mcv_selectionColor"), a(r4)));     // Catch: Throwable -> L37 Exception -> L39
        CharSequence[] r0 = r13.getTextArray(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_weekDayLabels, "styleable", "O_MaterialCalendarView_o_mcv_weekDayLabels"));     // Catch: Throwable -> L37 Exception -> L39
        if (r0 == null) goto L32;
        setWeekDayFormatter(new com.obric.oui.calendar.a.a(r0));     // Catch: Throwable -> L37 Exception -> L39
    L32:
        CharSequence[] r1 = r13.getTextArray(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_monthLabels, "styleable", "O_MaterialCalendarView_o_mcv_monthLabels"));     // Catch: Throwable -> L37 Exception -> L39
        if (r1 == null) goto L35;
        setTitleFormatter(new com.obric.oui.calendar.a.f(r1));     // Catch: Throwable -> L37 Exception -> L39
    L35:
        setHeaderTextAppearance(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_headerTextAppearance, "styleable", "O_MaterialCalendarView_o_mcv_headerTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialCalendarWidget_Header, "style", "TextAppearance_MaterialCalendarWidget_Header")));     // Catch: Throwable -> L37 Exception -> L39
        setWeekDayTextAppearance(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_weekDayTextAppearance, "styleable", "O_MaterialCalendarView_o_mcv_weekDayTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialCalendarWidget_WeekDay, "style", "TextAppearance_MaterialCalendarWidget_WeekDay")));     // Catch: Throwable -> L37 Exception -> L39
        setDateTextAppearance(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_dateTextAppearance, "styleable", "O_MaterialCalendarView_o_mcv_dateTextAppearance"), ZeusTransformUtils.mapRes(R.style.TextAppearance_MaterialCalendarWidget_Date, "style", "TextAppearance_MaterialCalendarWidget_Date")));     // Catch: Throwable -> L37 Exception -> L39
        setShowOtherDates(r13.getInteger(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_showOtherDates, "styleable", "O_MaterialCalendarView_o_mcv_showOtherDates"), 4));     // Catch: Throwable -> L37 Exception -> L39
        setAllowClickDaysOutsideCurrentMonth(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.O_MaterialCalendarView_o_mcv_allowClickDaysOutsideCurrentMonth, "styleable", "O_MaterialCalendarView_o_mcv_allowClickDaysOutsideCurrentMonth"), true));     // Catch: Throwable -> L37 Exception -> L39
    L41:
        r13.recycle();
        n();
        CalendarDay r2 = CalendarDay.today();
        this.h = r2;
        setCurrentDate(r2);
        if (isInEditMode() == false) goto L50;
        removeView(this.f);
        h r3 = new h(this, this.h, getFirstDayOfWeek(), true);
        r3.d(getSelectionColor());
        r3.b(this.g.getDateTextAppearance());
        r3.a(this.g.getWeekDayTextAppearance());
        r3.c(getShowOtherDates());
        addView(r3);
        return;
    L50:
        return;
    L10:
        if (r16 > 7) goto L13;
        r19 = DayOfWeek.of(r16);     // Catch: Throwable -> L37 Exception -> L39
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r13.recycle();
        throw th;
    L5:
        setClipChildren(true);
        setClipToPadding(true);
        goto L6
    }

    private static int a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L5;
        int r0 = android.R.attr.colorAccent;
    L6:
        TypedValue r1 = new TypedValue();
        r6.getTheme().resolveAttribute(r0, r1, true);
        return r1.data;
    L5:
        r0 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin"), "colorAccent", "attr", r6.getPackageName(), "com.obric.memorydata.plugin");
        goto L6
    }

    static /* synthetic */ ImageView a(MaterialCalendarView r0) {
        return r0.e;
    }

    static /* synthetic */ CalendarDay a(MaterialCalendarView r0, CalendarDay r1) {
        r0.h = r1;
        return r1;
    }

    private static void a(View r0, boolean r1) {
        r0.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        r0.setAlpha(r2);
        return;
    L5:
        r2 = 0.1f;
        goto L6
    }

    private void a(b r6) {
        if (this.g != null) goto L5;
    L32:
        CalendarDay r0 = null;
    L33:
        this.E = r6;
        this.j = b.b(r6);
        this.B = b.c(r6);
        this.o = b.d(r6);
        this.p = b.e(r6);
        this.C = b.f(r6);
        int r7 = AnonymousClass4.f13413a[this.j.ordinal()];
        if (r7 != 1) goto L36;
        CalendarPagerAdapter<?> r8 = new MonthPagerAdapter(this);
    L41:
        CalendarPagerAdapter<?> r2 = this.g;
        if (r2 == null) goto L45;
        r8 = r2.migrateStateAndReturn(r8);
    L45:
        this.g = r8;
        this.g.setShowWeekDays(this.C);
        this.f.setAdapter(this.g);
        b(this.o, this.p);
        if (this.z == 1) goto L48;
    L50:
        CalendarDay r9 = CalendarDay.today();
    L51:
        setCurrentDate(r9);
        if (r0 == null) goto L54;
        this.f.setCurrentItem(this.g.getIndexForDay(r0));
    L54:
        j();
        o();
        return;
    L48:
        if (this.g.getSelectedDates().isEmpty() == true) goto L50;
        r9 = (CalendarDay) ZeusTransformUtils.preCheckCast(this.g.getSelectedDates().get(0), CalendarDay.class, "com.obric.memorydata.plugin");
        goto L51
    L36:
        if (r7 != 2) goto L39;
        r8 = new WeekPagerAdapter(this);
        goto L41
    L39:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L5:
        if (b.a(r6) == false) goto L32;
        r0 = this.g.getItem(this.f.getCurrentItem());
        if (this.j == b.b(r6)) goto L33;
        CalendarDay r1 = getSelectedDate();
        if (this.j != CalendarMode.MONTHS) goto L19;
        if (r1 == null) goto L19;
        CalendarDay r3 = CalendarDay.from(r0.getDate().plusDays(1));
        if (r1.equals(r0) == false) goto L14;
    L30:
        r0 = r1;
        goto L33
    L14:
        if (r1.isAfter(r0) == false) goto L33;
        if (r1.isBefore(r3) == false) goto L33;
    L19:
        if (this.j != CalendarMode.WEEKS) goto L33;
        CalendarDay r4 = CalendarDay.from(r0.getDate().plusDays(6));
        if (r1 != null) goto L23;
    L31:
        r0 = r4;
        goto L33
    L23:
        if (r1.equals(r0) == true) goto L30;
        if (r1.equals(r4) == true) goto L30;
        if (r1.isAfter(r0) == false) goto L31;
        if (r1.isBefore(r4) == false) goto L31;
        goto L30
    }

    static /* synthetic */ void a(MaterialCalendarView r0, b r1) {
        r0.a(r1);
    }

    public static boolean a(int r1) {
        if ((r1 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    static /* synthetic */ CalendarPager b(MaterialCalendarView r0) {
        return r0.f;
    }

    private void b(CalendarDay r3, CalendarDay r4) {
        CalendarDay r0 = this.h;
        this.g.setRangeDates(r3, r4);
        this.h = r0;
        if (r3 != null) goto L5;
    L9:
        int r5 = this.g.getIndexForDay(r0);
        this.f.setCurrentItem(r5, false);
        o();
        return;
    L5:
        if (r3.isAfter(r0) == true) goto L8;
        r3 = this.h;
    L8:
        this.h = r3;
        goto L9
    }

    public static boolean b(int r0) {
        if ((r0 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ ImageView c(MaterialCalendarView r0) {
        return r0.d;
    }

    public static boolean c(int r0) {
        if ((r0 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int d(int r2) {
        return (int) TypedValue.applyDimension(1, r2, ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics());
    }

    static /* synthetic */ CalendarDay d(MaterialCalendarView r0) {
        return r0.h;
    }

    static /* synthetic */ m e(MaterialCalendarView r0) {
        return r0.f13411b;
    }

    static /* synthetic */ CalendarPagerAdapter f(MaterialCalendarView r0) {
        return r0.g;
    }

    static /* synthetic */ void g(MaterialCalendarView r0) {
        r0.o();
    }

    private void n() {
        addView(this.i);
        this.f.setId(ZeusTransformUtils.mapRes(R.id.mcv_pager, OaidModel.KEY_ID, "mcv_pager"));
        this.f.setOffscreenPageLimit(1);
        addView(this.f);
    }

    private void o() {
        this.f13411b.a(this.h);
        a(this.d, d());
        a(this.e, c());
    }

    public void a() {
        if (d() == false) goto L6;
        CalendarPager r2 = this.f;
        r2.setCurrentItem(r2.getCurrentItem() - 1, true);
        return;
    }

    public void a(CalendarDay r2) {
        k r0 = this.s;
        if (r0 == null) goto L6;
        r0.onMonthChanged(this, r2);
        return;
    }

    public void a(CalendarDay r2, CalendarDay r3) {
        if (r2 == null) goto L11;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r2.isAfter(r3) == false) goto L8;
        this.g.selectRange(r3, r2);
    L9:
        a(this.g.getSelectedDates());
        return;
    L8:
        this.g.selectRange(r2, r3);
        goto L9
    }

    public void a(CalendarDay r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.g.setDateSelected(r1, r2);
    }

    public void a(DayView r7) {
        CalendarDay r0 = getCurrentDate();
        CalendarDay r1 = r7.getDate();
        int r2 = r0.getMonth();
        int r3 = r1.getMonth();
        if (this.j == CalendarMode.MONTHS) goto L5;
    L13:
        d(r7.getDate(), !r7.isChecked());
        return;
    L5:
        if (this.A == false) goto L13;
        if (r2 == r3) goto L13;
        if (r0.isAfter(r1) == false) goto L11;
        a();
        goto L13
    L11:
        if (r0.isBefore(r1) == false) goto L13;
        b();
        goto L13
    }

    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.l.add(r4);
        this.g.setDecorators(this.l);
    }

    public void a(Collection<? extends d> r3) {
        Collection<? extends d> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.l.addAll(r4);
        this.g.setDecorators(this.l);
    }

    public void a(List<CalendarDay> r3) {
        List<CalendarDay> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        l r0 = this.t;
        if (r0 == null) goto L6;
        r0.onRangeSelected(this, r4);
        return;
    }

    public void a(d... r1) {
        a(Arrays.asList(r1));
    }

    public void b() {
        if (c() == false) goto L6;
        CalendarPager r2 = this.f;
        r2.setCurrentItem(r2.getCurrentItem() + 1, true);
        return;
    }

    public void b(CalendarDay r2) {
        c(r2, false);
    }

    public void b(CalendarDay r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r4 = this.g.getIndexForDay(r2);
        this.f.setCurrentItem(r4, r3);
        o();
    }

    public void b(DayView r2) {
        i r0 = this.r;
        if (r0 == null) goto L6;
        r0.onDateLongClick(this, r2.getDate());
        return;
    }

    public void b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.l.remove(r4);
        this.g.setDecorators(this.l);
    }

    public void c(CalendarDay r2, boolean r3) {
        j r0 = this.q;
        if (r0 == null) goto L6;
        r0.onDateSelected(this, r2, r3);
        return;
    }

    public boolean c() {
        if (this.f.getCurrentItem() < (this.g.getCount() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.LayoutParams.class);
    }

    public void d(CalendarDay r4, boolean r5) {
        int r0 = this.z;
        if (r0 != 2) goto L5;
    L21:
        this.g.setDateSelected(r4, r5);
        c(r4, r5);
        return;
    L5:
        if (r0 == 3) goto L7;
        this.g.clearSelections();
        this.g.setDateSelected(r4, true);
        c(r4, true);
        return;
    L7:
        List<CalendarDay> r1 = this.g.getSelectedDates();
        if (r1.size() == 0) goto L21;
        if (r1.size() != 1) goto L20;
        CalendarDay r2 = (CalendarDay) ZeusTransformUtils.preCheckCast(r1.get(0), CalendarDay.class, "com.obric.memorydata.plugin");
        if (r2.equals(r4) == true) goto L21;
        if (r2.isAfter(r4) == false) goto L18;
        this.g.selectRange(r4, r2);
    L19:
        a(this.g.getSelectedDates());
        return;
    L18:
        this.g.selectRange(r2, r4);
        goto L19
    L20:
        this.g.clearSelections();
        goto L21
    }

    public boolean d() {
        if (this.f.getCurrentItem() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r3);
    }

    public void e() {
        List<CalendarDay> r0 = getSelectedDates();
        this.g.clearSelections();
        Iterator<CalendarDay> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        c((CalendarDay) ZeusTransformUtils.preCheckCast(r1.next(), CalendarDay.class, "com.obric.memorydata.plugin"), false);
        goto L4
    }

    public boolean f() {
        return this.A;
    }

    public boolean g() {
        return this.C;
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r0 = this.f13410a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_calendar, TypedValues.Custom.S_STRING, "oui_calendar"));
    }

    public CalendarMode getCalendarMode() {
        return this.j;
    }

    public CalendarDay getCurrentDate() {
        return this.g.getItem(this.f.getCurrentItem());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.B;
    }

    public Drawable getLeftArrow() {
        return this.d.getDrawable();
    }

    public CalendarDay getMaximumDate() {
        return this.p;
    }

    public a getMeasureInfo() {
        return this.F;
    }

    public CalendarDay getMinimumDate() {
        return this.o;
    }

    public Drawable getRightArrow() {
        return this.e.getDrawable();
    }

    public CalendarDay getSelectedDate() {
        List<CalendarDay> r2 = this.g.getSelectedDates();
        if (r2.isEmpty() == false) goto L7;
        return null;
    L7:
        return (CalendarDay) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), CalendarDay.class, "com.obric.memorydata.plugin");
    }

    public List<CalendarDay> getSelectedDates() {
        return this.g.getSelectedDates();
    }

    public int getSelectionColor() {
        return this.u;
    }

    public int getSelectionMode() {
        return this.z;
    }

    public int getShowOtherDates() {
        return this.g.getShowOtherDates();
    }

    public int getTileHSpacing() {
        return this.x;
    }

    public int getTileHeight() {
        return this.v;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.v, this.w);
    }

    public int getTileVSpacing() {
        return this.y;
    }

    public int getTileWidth() {
        return this.w;
    }

    public int getTitleAnimationOrientation() {
        return this.f13411b.a();
    }

    public boolean getTopbarVisible() {
        if (this.i.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getWeekDaysHeight() {
        return this.D;
    }

    public boolean h() {
        return this.k;
    }

    public void i() {
        this.l.clear();
        this.g.setDecorators(this.l);
    }

    public void j() {
        this.g.invalidateDecorators();
    }

    public boolean k() {
        return this.f.isPagingEnabled();
    }

    public b l() {
        return this.E;
    }

    public c m() {
        return new c(this);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = getPaddingLeft();
        int r12 = ((r8 - r6) - r11) - getPaddingRight();
        int r13 = getPaddingTop();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L9;
        View r0 = getChildAt(r14);
        if (r0.getVisibility() == 8) goto L8;
        int r1 = r0.getMeasuredWidth();
        int r3 = ((r12 - r1) / 2) + r11;
        int r2 = r0.getMeasuredHeight() + r13;
        r0.layout(r3, r13, r1 + r3, r2);
        r13 = r2;
    L8:
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r14, int r15) {
        int r0 = View.MeasureSpec.getSize(r14);
        int r16 = View.MeasureSpec.getMode(r14);
        int r1 = View.MeasureSpec.getSize(r15);
        int r17 = View.MeasureSpec.getMode(r15);
        if (this.D != (-10)) goto L5;
        this.D = d(28);
    L5:
        int r2 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r3 = (r1 - getPaddingTop()) - getPaddingBottom();
        int r4 = this.w;
        if (r4 <= 0) goto L8;
        this.F.f13414a = r4;
    L9:
        int r5 = this.v;
        if (r5 <= 0) goto L12;
        this.F.f13415b = r5;
    L13:
        int r6 = 0;
        int r7 = Math.max(getTileHSpacing(), 0);
        int r8 = Math.max(getTileVSpacing(), 0);
        int r9 = getChildCount();
        int r10 = 0;
        int r11 = 0;
    L14:
        if (r6 >= r9) goto L32;
        View r12 = getChildAt(r6);
        if (r12.getVisibility() == 8) goto L31;
        if (r16 != 1073741824) goto L21;
        int r13 = r2;
    L22:
        int r18 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
        if (r17 != 1073741824) goto L25;
        int r19 = r3;
    L30:
        r12.measure(r18, View.MeasureSpec.makeMeasureSpec(r19, 1073741824));
        r10 = Math.max(r10, (r12.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
        r11 = Math.max(r11, (r12.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom());
        goto L31
    L25:
        int r110 = (this.F.f13415b + r8) * 6;
        if (this.C == false) goto L28;
        int r111 = this.D;
    L29:
        r19 = r110 + r111;
        goto L30
    L28:
        r111 = -r8;
        goto L29
    L21:
        r13 = (this.F.f13414a * 7) + (r7 * 6);
    L31:
        r6 = r6 + 1;
        goto L14
    L32:
        setMeasuredDimension(r10, r11);
        return;
    L12:
        this.F.f13415b = d(40);
        goto L13
    L8:
        this.F.f13414a = d(40);
        goto L9
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        SavedState r6 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.memorydata.plugin"), SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r6.getSuperState());
        l().a().a(r6.minDate).b(r6.maxDate).b(r6.cacheCurrentPosition).a();
        setShowOtherDates(r6.showOtherDates);
        setAllowClickDaysOutsideCurrentMonth(r6.allowClickDaysOutsideCurrentMonth);
        e();
        Iterator<CalendarDay> r0 = r6.selectedDates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((CalendarDay) ZeusTransformUtils.preCheckCast(r0.next(), CalendarDay.class, "com.obric.memorydata.plugin"), true);
        goto L4
    L6:
        setTopbarVisible(r6.topbarVisible);
        setSelectionMode(r6.selectionMode);
        setDynamicHeightEnabled(r6.dynamicHeightEnabled);
        setCurrentDate(r6.currentMonth);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.showOtherDates = getShowOtherDates();
        r0.allowClickDaysOutsideCurrentMonth = f();
        r0.minDate = getMinimumDate();
        r0.maxDate = getMaximumDate();
        r0.selectedDates = getSelectedDates();
        r0.selectionMode = getSelectionMode();
        r0.topbarVisible = getTopbarVisible();
        r0.dynamicHeightEnabled = this.k;
        r0.currentMonth = this.h;
        r0.cacheCurrentPosition = b.a(this.E);
        return r0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        return this.f.dispatchTouchEvent(r1);
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.A = r1;
    }

    public void setContentDescriptionArrowFuture(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.e.setContentDescription(r4);
    }

    public void setContentDescriptionArrowPast(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.d.setContentDescription(r4);
    }

    public void setContentDescriptionCalendar(CharSequence r3) {
        this.f13410a = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public void setCurrentDate(CalendarDay r2) {
        b(r2, true);
    }

    public void setCurrentDate(LocalDate r1) {
        setCurrentDate(CalendarDay.from(r1));
    }

    public void setDateTextAppearance(int r1) {
        this.g.setDateTextAppearance(r1);
    }

    public void setDayFormatter(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.memorydata.plugin");
        CalendarPagerAdapter<?> r2 = this.g;
        if (r4 != null) goto L5;
        r4 = com.obric.oui.calendar.a.e.f13433a;
    L5:
        r2.setDayFormatter(r4);
    }

    public void setDayFormatterContentDescription(com.obric.oui.calendar.a.e r3) {
        com.obric.oui.calendar.a.e r4 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.memorydata.plugin");
        this.g.setDayFormatterContentDescription(r4);
    }

    public void setDynamicHeightEnabled(boolean r1) {
        this.k = r1;
    }

    public void setHeaderTextAppearance(int r4) {
        this.c.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    }

    public void setLeftArrow(int r1) {
        this.d.setImageResource(r1);
    }

    public void setOnDateChangedListener(j r3) {
        this.q = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
    }

    public void setOnDateLongClickListener(i r3) {
        this.r = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
    }

    public void setOnMonthChangedListener(k r3) {
        this.s = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
    }

    public void setOnRangeSelectedListener(l r3) {
        this.t = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
    }

    public void setOnTitleClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.c.setOnClickListener(r4);
    }

    public void setPagingEnabled(boolean r2) {
        this.f.setPagingEnabled(r2);
        o();
    }

    public void setRightArrow(int r1) {
        this.e.setImageResource(r1);
    }

    public void setSelectedDate(CalendarDay r2) {
        e();
        if (r2 == null) goto L6;
        a(r2, true);
        return;
    }

    public void setSelectedDate(LocalDate r1) {
        setSelectedDate(CalendarDay.from(r1));
    }

    public void setSelectionColor(int r2) {
        if (r2 == 0) goto L4;
    L7:
        this.u = r2;
        this.g.setSelectionColor(r2);
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r2 = -7829368;
        goto L7
    }

    public void setSelectionMode(int r6) {
        int r0 = this.z;
        this.z = r6;
        boolean r1 = false;
        if (r6 == 1) goto L9;
        if (r6 == 2) goto L14;
        if (r6 == 3) goto L8;
        this.z = 0;
        if (r0 == 0) goto L14;
    L8:
        e();
    L14:
        CalendarPagerAdapter<?> r7 = this.g;
        if (this.z == 0) goto L17;
        r1 = true;
    L17:
        r7.setSelectionEnabled(r1);
        return;
    L9:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L14;
    L12:
        if (getSelectedDates().isEmpty() == true) goto L14;
        setSelectedDate(getSelectedDate());
        goto L14
    }

    public void setShowOtherDates(int r1) {
        this.g.setShowOtherDates(r1);
    }

    public void setTileHSpacing(int r1) {
        this.x = r1;
        requestLayout();
    }

    public void setTileHeight(int r1) {
        this.v = r1;
        requestLayout();
    }

    public void setTileHeightDp(int r1) {
        setTileHeight(d(r1));
    }

    public void setTileSize(int r1) {
        this.w = r1;
        this.v = r1;
        requestLayout();
    }

    public void setTileSizeDp(int r1) {
        setTileSize(d(r1));
    }

    public void setTileVSpacing(int r1) {
        this.y = r1;
        requestLayout();
    }

    public void setTileWidth(int r1) {
        this.w = r1;
        requestLayout();
    }

    public void setTileWidthDp(int r1) {
        setTileWidth(d(r1));
    }

    public void setTitleAnimationOrientation(int r1) {
        this.f13411b.a(r1);
    }

    public void setTitleFormatter(com.obric.oui.calendar.a.g r3) {
        com.obric.oui.calendar.a.g r4 = (com.obric.oui.calendar.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.g.class, "com.obric.memorydata.plugin");
        this.f13411b.a(r4);
        this.g.setTitleFormatter(r4);
        o();
    }

    public void setTitleMonths(int r2) {
        setTitleMonths(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getTextArray(r2));
    }

    public void setTitleMonths(CharSequence[] r2) {
        setTitleFormatter(new com.obric.oui.calendar.a.f(r2));
    }

    public void setTopbarVisible(boolean r2) {
        LinearLayout r0 = this.i;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        requestLayout();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setWeekDayFormatter(com.obric.oui.calendar.a.h r3) {
        com.obric.oui.calendar.a.h r4 = (com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.h.class, "com.obric.memorydata.plugin");
        CalendarPagerAdapter<?> r2 = this.g;
        if (r4 != null) goto L5;
        r4 = com.obric.oui.calendar.a.h.f13436a;
    L5:
        r2.setWeekDayFormatter(r4);
    }

    public void setWeekDayLabels(int r2) {
        setWeekDayLabels(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getTextArray(r2));
    }

    public void setWeekDayLabels(CharSequence[] r2) {
        setWeekDayFormatter(new com.obric.oui.calendar.a.a(r2));
    }

    public void setWeekDayTextAppearance(int r1) {
        this.g.setWeekDayTextAppearance(r1);
    }

    public void setWeekDaysHeight(int r1) {
        this.D = r1;
        requestLayout();
    }

    public void setWeekDaysHeightDp(int r1) {
        setWeekDaysHeight(d(r1));
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
