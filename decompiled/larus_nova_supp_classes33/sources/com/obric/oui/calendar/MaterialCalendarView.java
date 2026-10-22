package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
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
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.picker.reels.views.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class MaterialCalendarView extends ViewGroup {
    public static final /* synthetic */ int D = 0;
    public int A;
    public f B;
    public final e C;
    public final z a;
    public final TextView b;
    public final ImageView c;
    public final ImageView d;
    public final CalendarPager e;
    public com.obric.oui.calendar.b<?> f;
    public CalendarDay g;
    public final LinearLayout h;
    public CalendarMode i;
    public boolean j;
    public CalendarDay k;
    public CalendarDay l;
    public w m;
    public v n;
    public x o;
    public y p;
    public CharSequence q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public DayOfWeek y;
    public boolean z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int a;
        public boolean b;
        public CalendarDay c;
        public CalendarDay d;
        public List<CalendarDay> e;
        public boolean f;
        public int g;
        public boolean h;
        public CalendarDay i;
        public boolean j;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r2) {
                return new SavedState(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r6) {
            super(r6);
            this.a = 4;
            boolean r0 = true;
            this.b = true;
            this.c = null;
            this.d = null;
            this.e = new ArrayList();
            this.f = true;
            this.g = 1;
            this.h = false;
            this.i = null;
            this.a = r6.readInt();
            if (r6.readByte() == 0) goto L5;
            boolean r1 = true;
        L6:
            this.b = r1;
            ClassLoader r2 = CalendarDay.class.getClassLoader();
            this.c = (CalendarDay) r6.readParcelable(r2);
            this.d = (CalendarDay) r6.readParcelable(r2);
            r6.readTypedList(this.e, CalendarDay.CREATOR);
            if (r6.readInt() != 1) goto L9;
            boolean r3 = true;
        L10:
            this.f = r3;
            this.g = r6.readInt();
            if (r6.readInt() != 1) goto L13;
            boolean r4 = true;
        L14:
            this.h = r4;
            this.i = (CalendarDay) r6.readParcelable(r2);
            if (r6.readByte() != 0) goto L18;
            r0 = false;
        L18:
            this.j = r0;
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

        public SavedState(Parcelable r3) {
            super(r3);
            this.a = 4;
            this.b = true;
            this.c = null;
            this.d = null;
            this.e = new ArrayList();
            this.f = true;
            this.g = 1;
            this.h = false;
            this.i = null;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.a);
            r2.writeByte(this.b ? 1 : 0);
            r2.writeParcelable(this.c, 0);
            r2.writeParcelable(this.d, 0);
            r2.writeTypedList(this.e);
            r2.writeInt(this.f ? 1 : 0);
            r2.writeInt(this.g);
            r2.writeInt(this.h ? 1 : 0);
            r2.writeParcelable(this.i, 0);
            r2.writeByte(this.j ? 1 : 0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectionMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowOtherDates {
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ MaterialCalendarView a;

        public a(MaterialCalendarView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            MaterialCalendarView r0 = this.a;
            if (r4 != r0.d) goto L6;
            CalendarPager r5 = r0.e;
            r5.setCurrentItem(r5.getCurrentItem() + 1, true);
            return;
        L6:
            if (r4 != r0.c) goto L10;
            CalendarPager r6 = r0.e;
            r6.setCurrentItem(r6.getCurrentItem() - 1, true);
            return;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ MaterialCalendarView a;

        public final void onPageScrollStateChanged(int r1) {
        }

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public b(MaterialCalendarView r1) {
            this.a = r1;
        }

        public final void onPageSelected(int r10) {
            MaterialCalendarView r0 = this.a;
            r0.a.i = r0.g;
            r0.g = r0.f.i(r10);
            this.a.e();
            MaterialCalendarView r11 = this.a;
            CalendarDay r1 = r11.g;
            x r2 = r11.o;
            if (r2 == null) goto L34;
            o r3 = (o) r2;
            Calendar r4 = r3.a;
            ODatePickerView r5 = r3.b;
            int r6 = ODatePickerView.C;
            Intrinsics.checkNotNullParameter(r5, "this$0");
            int r7 = pla.b.a;
            pla.b.b("DatePickerView", "setOnMonthChangedListener widget:" + r11 + ",date:" + r1);
            r4.set(r1.d(), r1.c() - 1, 1);
            long r8 = r4.getTimeInMillis();
            r5.i.setText(ODatePickerView.S5(r8, r5.x));
            r5.c = r1.d();
            r5.d = r1.c();
            if (r5.b == false) goto L8;
            r5.h.setSelectedDate(new CalendarDay(r1.d(), r1.c(), 1));
        L8:
            if (r5.u == false) goto L10;
            r5.u = false;
        L29:
            Function1<? super Long, Unit> r12 = r5.y;
            if (r12 == null) goto L35;
            r12.invoke(Long.valueOf(r8));
            return;
        L35:
            return;
        L10:
            gma.a r13 = r5.m;
            if ((r13 instanceof gma.a) == true) goto L14;
            r13 = null;
        L14:
            if (r13 == null) goto L29;
            int r9 = RangesKt.coerceAtLeast(r1.d() - 1900, 0);
            int r14 = RangesKt.coerceIn(r1.c() - 1, 0, 11);
            r5.t = true;
            WheelView r15 = r13.L0(0);
            if (r15 != null) goto L20;
        L22:
            WheelView r16 = r13.L0(1);
            if (r16 != null) goto L26;
        L28:
            r5.t = false;
            goto L29
        L26:
            if (r16.getCurrentIndex() == r14) goto L28;
            r16.i(r14);
            goto L28
        L20:
            if (r15.getCurrentIndex() == r9) goto L22;
            r15.i(r9);
            goto L22
        }
    }

    public class c implements ViewPager.PageTransformer {
        public c() {
        }

        public final void transformPage(View r3, float r4) {
            r3.setAlpha((float) Math.sqrt(1.0f - Math.abs(r4)));
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CalendarMode.values().length];
            a = r0;
            r0[CalendarMode.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[CalendarMode.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class e {
        public int a;
        public int b;

        public e() {
        }
    }

    public class f {
        public final CalendarMode a;
        public final DayOfWeek b;
        public final CalendarDay c;
        public final CalendarDay d;
        public final boolean e;
        public final boolean f;
        public final /* synthetic */ MaterialCalendarView g;

        public f(MaterialCalendarView r1, g r2) {
            this.g = r1;
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.d;
            this.d = r2.e;
            this.e = r2.c;
            this.f = r2.f;
        }
    }

    public class g {
        public CalendarMode a;
        public DayOfWeek b;
        public boolean c;
        public CalendarDay d;
        public CalendarDay e;
        public boolean f;
        public final /* synthetic */ MaterialCalendarView g;

        public final void a() {
            MaterialCalendarView r0 = this.g;
            f r1 = new f(r0, this);
            com.obric.oui.calendar.b<?> r2 = r0.f;
            if (r2 != null) goto L5;
        L32:
            CalendarDay r3 = null;
        L33:
            r0.B = r1;
            CalendarMode r4 = r1.a;
            r0.i = r4;
            r0.y = r1.b;
            r0.k = r1.c;
            r0.l = r1.d;
            r0.z = r1.f;
            int r5 = d.a[r4.ordinal()];
            if (r5 != 1) goto L36;
            com.obric.oui.calendar.b<?> r6 = new i(r0);
        L41:
            com.obric.oui.calendar.b<?> r7 = r0.f;
            if (r7 != null) goto L44;
            r0.f = r6;
        L45:
            com.obric.oui.calendar.b<?> r8 = r0.f;
            r8.s = r0.z;
            r0.e.setAdapter(r8);
            CalendarDay r9 = r0.k;
            CalendarDay r10 = r0.l;
            CalendarDay r11 = r0.g;
            r0.f.p(r9, r10);
            r0.g = r11;
            if (r9 != null) goto L48;
        L52:
            int r12 = r0.f.h(r11);
            r0.e.setCurrentItem(r12, false);
            r0.e();
            if (r0.w == 1) goto L55;
        L57:
            CalendarDay r13 = CalendarDay.e();
        L58:
            r0.setCurrentDate(r13);
            if (r3 == null) goto L61;
            r0.e.setCurrentItem(r0.f.h(r3));
        L61:
            com.obric.oui.calendar.b<?> r14 = r0.f;
            r14.getClass();
            r14.q = new ArrayList();
            Iterator<com.obric.oui.calendar.f> r15 = r14.p.iterator();
        L63:
            if (r15.hasNext() == false) goto L67;
            com.obric.oui.calendar.f r16 = r15.next();
            com.obric.oui.calendar.g r17 = new com.obric.oui.calendar.g();
            r16.a();
            if (r17.a == false) goto L63;
            r14.q.add(new h(r16, r17));
            goto L63
        L67:
            Iterator r18 = r14.a.iterator();
        L69:
            if (r18.hasNext() == false) goto L71;
            ((com.obric.oui.calendar.c) r18.next()).i(r14.q);
            goto L69
        L71:
            r0.e();
            return;
        L55:
            if (r0.f.j().isEmpty() == true) goto L57;
            r13 = (CalendarDay) ListProtector.get(r0.f.j(), 0);
            goto L58
        L48:
            if (r9.a.isAfter(r11.a) == true) goto L51;
            r9 = r0.g;
        L51:
            r0.g = r9;
            goto L52
        L44:
            r6.d = r7.d;
            r6.e = r7.e;
            r6.f = r7.f;
            r6.g = r7.g;
            r6.h = r7.h;
            r6.i = r7.i;
            r6.j = r7.j;
            r6.l = r7.l;
            r6.m = r7.m;
            r6.n = r7.n;
            r6.o = r7.o;
            r6.p = r7.p;
            r6.q = r7.q;
            r6.r = r7.r;
            r0.f = r6;
            goto L45
        L36:
            if (r5 != 2) goto L39;
            r6 = new WeekPagerAdapter(r0);
            goto L41
        L39:
            throw new IllegalArgumentException("Provided display mode which is not yet implemented");
        L5:
            if (r1.e == false) goto L32;
            r3 = r2.i(r0.e.getCurrentItem());
            if (r0.i == r1.a) goto L33;
            CalendarDay r19 = r0.getSelectedDate();
            CalendarMode r20 = r0.i;
            if (r20 != CalendarMode.MONTHS) goto L19;
            if (r19 == null) goto L19;
            CalendarDay r21 = CalendarDay.a(r3.a.plusDays(1));
            if (r19.equals(r3) == false) goto L14;
        L30:
            r3 = r19;
            goto L33
        L14:
            if (r19.a.isAfter(r3.a) == false) goto L33;
            if (r19.a.isBefore(r21.a) == false) goto L33;
        L19:
            if (r20 != CalendarMode.WEEKS) goto L33;
            CalendarDay r22 = CalendarDay.a(r3.a.plusDays(6));
            if (r19 != null) goto L23;
        L31:
            r3 = r22;
            goto L33
        L23:
            if (r19.equals(r3) == true) goto L30;
            if (r19.equals(r22) == true) goto L30;
            if (r19.a.isAfter(r3.a) == false) goto L31;
            if (r19.a.isBefore(r22.a) == false) goto L31;
            goto L30
        }

        public g(MaterialCalendarView r4) {
            this.g = r4;
            this.c = false;
            this.d = null;
            this.e = null;
            this.a = CalendarMode.MONTHS;
            this.b = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        public g(MaterialCalendarView r1, f r2) {
            this.g = r1;
            this.c = false;
            this.d = null;
            this.e = null;
            this.a = r2.a;
            this.b = r2.b;
            this.d = r2.c;
            this.e = r2.d;
            this.c = r2.e;
            this.f = r2.f;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void e() {
        z r0 = this.a;
        CalendarDay r1 = this.g;
        r0.getClass();
        long r2 = System.currentTimeMillis();
        boolean r4 = true;
        if (r1 != null) goto L6;
    L18:
        ImageView r3 = this.c;
        if (this.e.getCurrentItem() <= 0) goto L21;
        boolean r5 = true;
    L22:
        r3.setEnabled(r5);
        float r6 = 1.0f;
        if (r5 == false) goto L25;
        float r7 = 1.0f;
    L26:
        r3.setAlpha(r7);
        ImageView r8 = this.d;
        if (this.e.getCurrentItem() < (this.f.getCount() - 1)) goto L30;
        r4 = false;
    L30:
        r8.setEnabled(r4);
        if (r4 == true) goto L34;
        r6 = 0.1f;
    L34:
        r8.setAlpha(r6);
        return;
    L25:
        r7 = 0.1f;
        goto L26
    L21:
        r5 = false;
        goto L22
    L6:
        if (TextUtils.isEmpty(r0.a.getText()) == false) goto L8;
    L9:
        r0.a(r2, r1, false);
    L11:
        if (r1.equals(r0.i) == true) goto L18;
        if (r1.c() == r0.i.c()) goto L15;
    L17:
        r0.a(r2, r1, true);
        goto L18
    L15:
        if (r1.d() != r0.i.d()) goto L17;
    L8:
        if ((r2 - r0.h) >= r0.c) goto L11;
        goto L9
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r0 = this.q;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getContext().getString(2131912791);
    }

    public CalendarDay getCurrentDate() {
        return this.f.i(this.e.getCurrentItem());
    }

    public Drawable getLeftArrow() {
        return this.c.getDrawable();
    }

    public Drawable getRightArrow() {
        return this.d.getDrawable();
    }

    public CalendarDay getSelectedDate() {
        List<CalendarDay> r0 = this.f.j();
        if (r0.isEmpty() == false) goto L7;
        return null;
    L7:
        return (CalendarDay) ListProtector.get(r0, r0.size() - 1);
    }

    public List<CalendarDay> getSelectedDates() {
        return this.f.j();
    }

    public int getShowOtherDates() {
        return this.f.h;
    }

    public int getTileSize() {
        return Math.max(this.s, this.t);
    }

    public int getTitleAnimationOrientation() {
        return this.a.g;
    }

    public boolean getTopbarVisible() {
        if (this.h.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.a = getShowOtherDates();
        r0.b = this.x;
        r0.c = getMinimumDate();
        r0.d = getMaximumDate();
        r0.e = getSelectedDates();
        r0.g = getSelectionMode();
        r0.f = getTopbarVisible();
        r0.h = this.j;
        r0.i = this.g;
        r0.j = this.B.e;
        return r0;
    }

    public final void a() {
        List<CalendarDay> r0 = getSelectedDates();
        com.obric.oui.calendar.b<?> r1 = this.f;
        r1.l.clear();
        r1.l();
        Iterator<CalendarDay> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        b(r2.next(), false);
        goto L4
    }

    public CalendarMode getCalendarMode() {
        return this.i;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.y;
    }

    public CalendarDay getMaximumDate() {
        return this.l;
    }

    public e getMeasureInfo() {
        return this.C;
    }

    public CalendarDay getMinimumDate() {
        return this.k;
    }

    public int getSelectionColor() {
        return this.r;
    }

    public int getSelectionMode() {
        return this.w;
    }

    public int getTileHSpacing() {
        return this.u;
    }

    public int getTileHeight() {
        return this.s;
    }

    public int getTileVSpacing() {
        return this.v;
    }

    public int getTileWidth() {
        return this.t;
    }

    public int getWeekDaysHeight() {
        return this.A;
    }

    public MaterialCalendarView(Context r2) {
        this(r2, null);
    }

    public final void c(List<CalendarDay> r5) {
        y r0 = this.p;
        if (r0 == null) goto L14;
        ODatePickerView r1 = ((r) r0).a;
        int r2 = ODatePickerView.C;
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(this, "widget");
        Intrinsics.checkNotNullParameter(r5, "dates");
        Function1<? super List<Long>, Unit> r3 = r1.B;
        if (r3 == null) goto L15;
        List<CalendarDay> r6 = r5;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        r4.add(Long.valueOf(ODatePickerView.T5((CalendarDay) r7.next())));
        goto L9
    L11:
        r3.invoke(r4);
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof ViewGroup.LayoutParams;
    }

    public final int d(int r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        SavedState r6 = (SavedState) r5;
        super.onRestoreInstanceState(r6.getSuperState());
        f r0 = this.B;
        r0.getClass();
        g r1 = new g(r0.g, r0);
        r1.d = r6.c;
        r1.e = r6.d;
        r1.c = r6.j;
        r1.a();
        setShowOtherDates(r6.a);
        setAllowClickDaysOutsideCurrentMonth(r6.b);
        a();
        Iterator<CalendarDay> r2 = r6.e.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        CalendarDay r3 = r2.next();
        if (r3 == null) goto L4;
        this.f.o(r3, true);
        goto L4
    L9:
        setTopbarVisible(r6.f);
        setSelectionMode(r6.g);
        setDynamicHeightEnabled(r6.h);
        setCurrentDate(r6.i);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        return this.e.dispatchTouchEvent(r2);
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.x = r1;
    }

    public void setContentDescriptionArrowFuture(CharSequence r2) {
        this.d.setContentDescription(r2);
    }

    public void setContentDescriptionArrowPast(CharSequence r2) {
        this.c.setContentDescription(r2);
    }

    public void setContentDescriptionCalendar(CharSequence r1) {
        this.q = r1;
    }

    public void setCurrentDate(CalendarDay r3) {
        if (r3 == null) goto L6;
        int r4 = this.f.h(r3);
        this.e.setCurrentItem(r4, true);
        e();
        return;
    }

    public void setDateTextAppearance(int r3) {
        com.obric.oui.calendar.b<?> r0 = this.f;
        if (r3 != 0) goto L5;
        r0.getClass();
        return;
    L5:
        r0.f = Integer.valueOf(r3);
        Iterator r1 = r0.a.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        ((com.obric.oui.calendar.c) r1.next()).f(r3);
        goto L7
    }

    public void setDayFormatter(mla.e r4) {
        com.obric.oui.calendar.b<?> r0 = this.f;
        if (r4 != null) goto L5;
        r4 = mla.e.a;
    L5:
        mla.e r1 = r0.o;
        if (r1 != r0.n) goto L8;
        r1 = r4;
    L8:
        r0.o = r1;
        r0.n = r4;
        Iterator r2 = r0.a.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((com.obric.oui.calendar.c) r2.next()).g(r4);
        goto L10
    }

    public void setDayFormatterContentDescription(mla.e r3) {
        com.obric.oui.calendar.b<?> r0 = this.f;
        r0.o = r3;
        Iterator r1 = r0.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.obric.oui.calendar.c) r1.next()).h(r3);
        goto L4
    }

    public void setDynamicHeightEnabled(boolean r1) {
        this.j = r1;
    }

    public void setHeaderTextAppearance(int r3) {
        this.b.setTextAppearance(getContext(), r3);
    }

    public void setLeftArrow(int r2) {
        this.c.setImageResource(r2);
    }

    public void setOnDateChangedListener(w r1) {
        this.m = r1;
    }

    public void setOnDateLongClickListener(v r1) {
        this.n = r1;
    }

    public void setOnMonthChangedListener(x r1) {
        this.o = r1;
    }

    public void setOnRangeSelectedListener(y r1) {
        this.p = r1;
    }

    public void setOnTitleClickListener(View.OnClickListener r2) {
        this.b.setOnClickListener(r2);
    }

    public void setPagingEnabled(boolean r2) {
        this.e.a = r2;
        e();
    }

    public void setRightArrow(int r2) {
        this.d.setImageResource(r2);
    }

    public void setSelectedDate(CalendarDay r3) {
        a();
        if (r3 == null) goto L6;
        this.f.o(r3, true);
        return;
    }

    public void setSelectionColor(int r3) {
        if (r3 == 0) goto L4;
    L7:
        this.r = r3;
        com.obric.oui.calendar.b<?> r0 = this.f;
        r0.e = Integer.valueOf(r3);
        Iterator r1 = r0.a.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        ((com.obric.oui.calendar.c) r1.next()).k(r3);
        goto L9
    L11:
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r3 = -7829368;
        goto L7
    }

    public void setSelectionMode(int r6) {
        int r0 = this.w;
        this.w = r6;
        boolean r1 = false;
        if (r6 == 1) goto L10;
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L9;
        this.w = 0;
        if (r0 == 0) goto L15;
        a();
        goto L15
    L9:
        a();
    L15:
        com.obric.oui.calendar.b<?> r7 = this.f;
        if (this.w == 0) goto L18;
        r1 = true;
    L18:
        r7.r = r1;
        Iterator r2 = r7.a.iterator();
    L20:
        if (r2.hasNext() == false) goto L22;
        ((com.obric.oui.calendar.c) r2.next()).l(r7.r);
        goto L20
    L22:
        return;
    L10:
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L15;
    L13:
        if (getSelectedDates().isEmpty() == true) goto L15;
        setSelectedDate(getSelectedDate());
        goto L15
    }

    public void setShowOtherDates(int r3) {
        com.obric.oui.calendar.b<?> r0 = this.f;
        r0.h = r3;
        Iterator r1 = r0.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        com.obric.oui.calendar.c r2 = (com.obric.oui.calendar.c) r1.next();
        r2.d = r3;
        r2.o();
        goto L4
    }

    public void setTileHSpacing(int r1) {
        this.u = r1;
        requestLayout();
    }

    public void setTileHeight(int r1) {
        this.s = r1;
        requestLayout();
    }

    public void setTileHeightDp(int r1) {
        setTileHeight(d(r1));
    }

    public void setTileSize(int r1) {
        this.t = r1;
        this.s = r1;
        requestLayout();
    }

    public void setTileSizeDp(int r1) {
        setTileSize(d(r1));
    }

    public void setTileVSpacing(int r1) {
        this.v = r1;
        requestLayout();
    }

    public void setTileWidth(int r1) {
        this.t = r1;
        requestLayout();
    }

    public void setTileWidthDp(int r1) {
        setTileWidth(d(r1));
    }

    public void setTitleAnimationOrientation(int r2) {
        this.a.g = r2;
    }

    public void setTitleFormatter(mla.g r3) {
        z r0 = this.a;
        if (r3 != null) goto L5;
        r0.getClass();
        mla.g r1 = mla.g.a;
    L6:
        r0.b = r1;
        com.obric.oui.calendar.b<?> r2 = this.f;
        if (r3 != null) goto L9;
        r2.getClass();
        r3 = mla.g.a;
    L9:
        r2.d = r3;
        e();
        return;
    L5:
        r1 = r3;
        goto L6
    }

    public void setTitleMonths(int r2) {
        setTitleMonths(getResources().getTextArray(r2));
    }

    public void setTopbarVisible(boolean r2) {
        LinearLayout r0 = this.h;
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

    public void setWeekDayFormatter(mla.h r3) {
        com.obric.oui.calendar.b<?> r0 = this.f;
        if (r3 != null) goto L5;
        r3 = mla.h.a;
    L5:
        r0.m = r3;
        Iterator r1 = r0.a.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((com.obric.oui.calendar.c) r1.next()).m(r3);
        goto L7
    }

    public void setWeekDayLabels(int r2) {
        setWeekDayLabels(getResources().getTextArray(r2));
    }

    public void setWeekDayTextAppearance(int r3) {
        com.obric.oui.calendar.b<?> r0 = this.f;
        if (r3 != 0) goto L5;
        r0.getClass();
        return;
    L5:
        r0.g = Integer.valueOf(r3);
        Iterator r1 = r0.a.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        ((com.obric.oui.calendar.c) r1.next()).n(r3);
        goto L7
    }

    public void setWeekDaysHeight(int r1) {
        this.A = r1;
        requestLayout();
    }

    public void setWeekDaysHeightDp(int r1) {
        setWeekDaysHeight(d(r1));
    }

    public void setCurrentDate(LocalDate r1) {
        setCurrentDate(CalendarDay.a(r1));
    }

    public void setSelectedDate(LocalDate r1) {
        setSelectedDate(CalendarDay.a(r1));
    }

    public void setTitleMonths(CharSequence[] r2) {
        setTitleFormatter(new mla.f(r2));
    }

    public void setWeekDayLabels(CharSequence[] r2) {
        setWeekDayFormatter(new mla.a(r2));
    }

    public MaterialCalendarView(Context r11, AttributeSet r12) {
        super(r11, r12);
        new ArrayList();
        a r0 = new a(this);
        b r1 = new b(this);
        this.k = null;
        this.l = null;
        int r3 = 0;
        this.r = 0;
        this.s = -10;
        this.t = -10;
        this.u = -10;
        this.v = -10;
        this.w = 1;
        this.x = true;
        this.A = -10;
        this.C = new e();
        setClipToPadding(false);
        setClipChildren(false);
        View r2 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2131559243, null, false);
        this.h = (LinearLayout) r2.findViewById(2131374270);
        ImageView r6 = (ImageView) r2.findViewById(2131382995);
        this.c = r6;
        TextView r7 = (TextView) r2.findViewById(2131380275);
        this.b = r7;
        ImageView r4 = (ImageView) r2.findViewById(2131380887);
        this.d = r4;
        CalendarPager r8 = new CalendarPager(getContext());
        this.e = r8;
        r6.setOnClickListener(r0);
        r4.setOnClickListener(r0);
        z r5 = new z(r7);
        this.a = r5;
        r8.setOnPageChangeListener(r1);
        r8.setPageTransformer(false, new c());
        TypedArray r13 = r11.getTheme().obtainStyledAttributes(r12, new int[]{2130972874, 2130972875, 2130972876, 2130972877, 2130972878, 2130972879, 2130972880, 2130972881, 2130972882, 2130972883, 2130972884, 2130972885, 2130972886, 2130972887, 2130972888, 2130972889, 2130972890, 2130972891, 2130972892, 2130972893}, 0, 0);
        int r9 = r13.getInteger(1, 0);     // Catch: Throwable -> L31 Exception -> L33
        int r10 = r13.getInteger(3, -1);     // Catch: Throwable -> L31 Exception -> L33
        r5.g = r13.getInteger(17, 0);     // Catch: Throwable -> L31 Exception -> L33
        if (r10 < 1) goto L7;
        if (r10 > 7) goto L7;
        this.y = DayOfWeek.of(r10);     // Catch: Throwable -> L31 Exception -> L33
    L8:
        this.z = r13.getBoolean(11, true);     // Catch: Throwable -> L31 Exception -> L33
        g r14 = new g(this);     // Catch: Throwable -> L31 Exception -> L33
        r14.b = this.y;     // Catch: Throwable -> L31 Exception -> L33
        r14.a = CalendarMode.values()[r9];     // Catch: Throwable -> L31 Exception -> L33
        r14.f = this.z;     // Catch: Throwable -> L31 Exception -> L33
        r14.a();     // Catch: Throwable -> L31 Exception -> L33
        setSelectionMode(r13.getInteger(9, 1));     // Catch: Throwable -> L31 Exception -> L33
        int r15 = r13.getLayoutDimension(14, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r15 <= (-10)) goto L11;
        setTileSize(r15);     // Catch: Throwable -> L31 Exception -> L33
    L11:
        int r16 = r13.getLayoutDimension(16, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r16 <= (-10)) goto L14;
        setTileWidth(r16);     // Catch: Throwable -> L31 Exception -> L33
    L14:
        int r17 = r13.getLayoutDimension(13, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r17 <= (-10)) goto L17;
        setTileHeight(r17);     // Catch: Throwable -> L31 Exception -> L33
    L17:
        int r18 = r13.getLayoutDimension(12, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r18 <= (-10)) goto L20;
        setTileHSpacing(r18);     // Catch: Throwable -> L31 Exception -> L33
    L20:
        int r19 = r13.getLayoutDimension(15, -10);     // Catch: Throwable -> L31 Exception -> L33
        if (r19 <= (-10)) goto L23;
        setTileVSpacing(r19);     // Catch: Throwable -> L31 Exception -> L33
    L23:
        setLeftArrow(r13.getResourceId(5, 2131244245));     // Catch: Throwable -> L31 Exception -> L33
        setRightArrow(r13.getResourceId(7, 2131244244));     // Catch: Throwable -> L31 Exception -> L33
        TypedValue r20 = new TypedValue();     // Catch: Throwable -> L31 Exception -> L33
        r11.getTheme().resolveAttribute(R.attr.colorAccent, r20, true);     // Catch: Throwable -> L31 Exception -> L33
        setSelectionColor(r13.getColor(8, r20.data));     // Catch: Throwable -> L31 Exception -> L33
        CharSequence[] r110 = r13.getTextArray(18);     // Catch: Throwable -> L31 Exception -> L33
        if (r110 == null) goto L26;
        setWeekDayFormatter(new mla.a(r110));     // Catch: Throwable -> L31 Exception -> L33
    L26:
        CharSequence[] r111 = r13.getTextArray(6);     // Catch: Throwable -> L31 Exception -> L33
        if (r111 == null) goto L29;
        setTitleFormatter(new mla.f(r111));     // Catch: Throwable -> L31 Exception -> L33
    L29:
        setHeaderTextAppearance(r13.getResourceId(4, 2131953597));     // Catch: Throwable -> L31 Exception -> L33
        setWeekDayTextAppearance(r13.getResourceId(19, 2131953598));     // Catch: Throwable -> L31 Exception -> L33
        setDateTextAppearance(r13.getResourceId(2, 2131953596));     // Catch: Throwable -> L31 Exception -> L33
        setShowOtherDates(r13.getInteger(10, 4));     // Catch: Throwable -> L31 Exception -> L33
        setAllowClickDaysOutsideCurrentMonth(r13.getBoolean(0, true));     // Catch: Throwable -> L31 Exception -> L33
    L35:
        r13.recycle();
        addView(this.h);
        this.e.setId(2131379728);
        this.e.setOffscreenPageLimit(1);
        addView(this.e);
        CalendarDay r112 = CalendarDay.e();
        this.g = r112;
        setCurrentDate(r112);
        if (isInEditMode() == false) goto L51;
        removeView(this.e);
        j r113 = new j(this, this.g, getFirstDayOfWeek(), true);
        r113.k(getSelectionColor());
        Integer r114 = this.f.f;
        if (r114 != null) goto L40;
        int r115 = 0;
    L41:
        r113.f(r115);
        Integer r116 = this.f.g;
        if (r116 == null) goto L45;
        r3 = r116.intValue();
    L45:
        r113.n(r3);
        r113.d = getShowOtherDates();
        r113.o();
        addView(r113);
        return;
    L40:
        r115 = r114.intValue();
        goto L41
    L51:
        return;
    L7:
        this.y = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L31 Exception -> L33
    L31:
        th = move-exception;
        r13.recycle();
        throw th;
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L31
        goto L35
    }

    public final void b(CalendarDay r5, boolean r6) {
        w r0 = this.m;
        if (r0 == null) goto L9;
        p r1 = (p) r0;
        Calendar r2 = r1.a;
        ODatePickerView r3 = r1.b;
        int r4 = ODatePickerView.C;
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(this, "widget");
        Intrinsics.checkNotNullParameter(r5, "date");
        int r7 = pla.b.a;
        pla.b.b("DatePickerView", "setOnDateChangedListener widget:" + this + ",date:" + r5 + ",selected:" + r6);
        r2.set(r5.d(), r5.c() + (-1), r5.b());
        long r8 = r2.getTimeInMillis();
        r3.i.setText(ODatePickerView.S5(r8, r3.x));
        r5.b();
        r3.c = r5.d();
        r3.d = r5.c();
        Function1<? super Long, Unit> r9 = r3.z;
        if (r9 == null) goto L10;
        r9.invoke(Long.valueOf(r8));
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r14, int r15) {
        int r0 = View.MeasureSpec.getSize(r14);
        int r16 = View.MeasureSpec.getMode(r14);
        int r1 = View.MeasureSpec.getSize(r15);
        int r17 = View.MeasureSpec.getMode(r15);
        if (this.A != (-10)) goto L5;
        this.A = d(28);
    L5:
        int r2 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r3 = (r1 - getPaddingTop()) - getPaddingBottom();
        int r4 = this.t;
        if (r4 <= 0) goto L8;
        this.C.a = r4;
    L9:
        int r5 = this.s;
        if (r5 <= 0) goto L12;
        this.C.b = r5;
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
        int r110 = (this.C.b + r8) * 6;
        if (this.z == false) goto L28;
        int r111 = this.A;
    L29:
        r19 = r110 + r111;
        goto L30
    L28:
        r111 = -r8;
        goto L29
    L21:
        r13 = (this.C.a * 7) + (r7 * 6);
    L31:
        r6 = r6 + 1;
        goto L14
    L32:
        setMeasuredDimension(r10, r11);
        return;
    L12:
        e r20 = this.C;
        r20.b = d(40);
        goto L13
    L8:
        e r21 = this.C;
        r21.a = d(40);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
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
}
