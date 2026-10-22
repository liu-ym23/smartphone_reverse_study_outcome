package com.obric.oui.calendar;

import ai.j0;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
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
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendarView extends ViewGroup {
    public static final /* synthetic */ int D = 0;
    public int A;
    public m B;
    public final k C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f12170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f12171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f12172c;
    public final ImageView d;
    public final CalendarPager e;
    public b f;
    public CalendarDay g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f12173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarMode f12174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CalendarDay f12176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CalendarDay f12177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public z f12178m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public y f12179n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a0 f12180o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b0 f12181p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f12182q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12183r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12184t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12185u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12186v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12187w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12188x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DayOfWeek f12189y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12190z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CalendarDay f12193c;
        public CalendarDay d;
        public List e;
        public boolean f;
        public int g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12194h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CalendarDay f12195i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f12196j;

        static {
            CREATOR = new l();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.f12191a);
            r5.writeByte(this.f12192b ? 1 : 0);
            r5.writeParcelable(this.f12193c, 0);
            r5.writeParcelable(this.d, 0);
            r5.writeTypedList(this.e);
            r5.writeInt(this.f ? 1 : 0);
            r5.writeInt(this.g);
            r5.writeInt(this.f12194h ? 1 : 0);
            r5.writeParcelable(this.f12195i, 0);
            r5.writeByte(this.f12196j ? 1 : 0);
        }
    }

    public MaterialCalendarView(Context r5) {
        this(r5, null);
    }

    public final void a() {
        List<CalendarDay> r5 = getSelectedDates();
        b r10 = this.f;
        r10.f12245l.clear();
        r10.e();
        Iterator<CalendarDay> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        b(r11.next(), false);
        goto L4
    }

    public final void b(CalendarDay r5, boolean r10) {
        z r11 = this.f12178m;
        if (r11 == null) goto L9;
        q r12 = (q) r11;
        ODatePickerView r13 = r12.f12292b;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Intrinsics.checkNotNullParameter(this, "widget");
        Intrinsics.checkNotNullParameter(r5, "date");
        String r14 = "setOnDateChangedListener widget:" + this + ",date:" + r5 + ",selected:" + r10;
        Intrinsics.checkNotNullParameter("DatePickerView", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        Log.i("DatePickerView", r14);
        int r15 = r5.f12167a.getYear();
        LocalDate r16 = r5.f12167a;
        int r17 = r16.getMonthValue() - 1;
        int r18 = r16.getDayOfMonth();
        Calendar r19 = r12.f12291a;
        r19.set(r15, r17, r18);
        long r20 = r19.getTimeInMillis();
        r13.f12204o.setText(ODatePickerView.n(r20, r13.D));
        r16.getDayOfMonth();
        r13.f12198i = r16.getYear();
        r13.f12199j = r16.getMonthValue();
        Function1 r21 = r13.F;
        if (r21 == null) goto L10;
        r21.invoke(Long.valueOf(r20));
        return;
    L10:
        return;
    }

    public final void c(List r5) {
        b0 r10 = this.f12181p;
        if (r10 == null) goto L14;
        ODatePickerView r11 = ((r) r10).f12293a;
        Intrinsics.checkNotNullParameter(r11, "this$0");
        Intrinsics.checkNotNullParameter(this, "widget");
        Intrinsics.checkNotNullParameter(r5, "dates");
        Function1 r12 = r11.H;
        if (r12 == null) goto L15;
        ArrayList r13 = new ArrayList(CollectionsKt.h(r5));
        Iterator r14 = r5.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        r13.add(Long.valueOf(ODatePickerView.o((CalendarDay) r14.next())));
        goto L9
    L11:
        r12.invoke(r13);
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return Objects.nonNull(r5);
    }

    public final int d(int r5) {
        return (int) TypedValue.applyDimension(1, r5, getResources().getDisplayMetrics());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray r5) {
        dispatchThawSelfOnly(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray r5) {
        dispatchFreezeSelfOnly(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r5);
    }

    public final void e() {
        CalendarDay r5 = this.g;
        d0 r10 = this.f12170a;
        r10.getClass();
        long r11 = System.currentTimeMillis();
        boolean r12 = true;
        if (r5 != null) goto L6;
    L18:
        CalendarPager r13 = this.e;
        if (r13.getCurrentItem() <= 0) goto L21;
        boolean r14 = true;
    L22:
        ImageView r15 = this.f12172c;
        r15.setEnabled(r14);
        float r16 = 0.1f;
        if (r14 == false) goto L25;
        float r17 = 1.0f;
    L26:
        r15.setAlpha(r17);
        if (r13.getCurrentItem() < (this.f.f12244k.getCount() - 1)) goto L30;
        r12 = false;
    L30:
        ImageView r18 = this.d;
        r18.setEnabled(r12);
        if (r12 == false) goto L33;
        r16 = 1.0f;
    L33:
        r18.setAlpha(r16);
        return;
    L25:
        r17 = 0.1f;
        goto L26
    L21:
        r14 = false;
        goto L22
    L6:
        if (TextUtils.isEmpty(r10.f12261a.getText()) == false) goto L8;
    L9:
        r10.a(r11, r5, false);
    L11:
        if (r5.equals(r10.f12265i) == true) goto L18;
        LocalDate r19 = r5.f12167a;
        if (r19.getMonthValue() == r10.f12265i.f12167a.getMonthValue()) goto L15;
    L17:
        r10.a(r11, r5, true);
        goto L18
    L15:
        if (r19.getYear() != r10.f12265i.f12167a.getYear()) goto L17;
    L8:
        if ((r11 - r10.f12264h) >= r10.f12263c) goto L11;
        goto L9
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r5 = this.f12182q;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return getContext().getString(R$string.oui_calendar);
    }

    public CalendarMode getCalendarMode() {
        return this.f12174i;
    }

    public CalendarDay getCurrentDate() {
        b r5 = this.f;
        int r10 = this.e.getCurrentItem();
        return r5.f12244k.getItem(r10);
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.f12189y;
    }

    public Drawable getLeftArrow() {
        return this.f12172c.getDrawable();
    }

    public CalendarDay getMaximumDate() {
        return this.f12177l;
    }

    public k getMeasureInfo() {
        return this.C;
    }

    public CalendarDay getMinimumDate() {
        return this.f12176k;
    }

    public Drawable getRightArrow() {
        return this.d.getDrawable();
    }

    @Nullable
    public CalendarDay getSelectedDate() {
        List r5 = Collections.unmodifiableList(this.f.f12245l);
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        return (CalendarDay) j0.e(r5, 1);
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        return Collections.unmodifiableList(this.f.f12245l);
    }

    public int getSelectionColor() {
        return this.f12183r;
    }

    public int getSelectionMode() {
        return this.f12187w;
    }

    public int getShowOtherDates() {
        return this.f.f12241h;
    }

    public int getTileHSpacing() {
        return this.f12185u;
    }

    public int getTileHeight() {
        return this.s;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.s, this.f12184t);
    }

    public int getTileVSpacing() {
        return this.f12186v;
    }

    public int getTileWidth() {
        return this.f12184t;
    }

    public int getTitleAnimationOrientation() {
        return this.f12170a.g;
    }

    public boolean getTopbarVisible() {
        if (this.f12173h.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getWeekDaysHeight() {
        return this.A;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        r5.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
        int r15 = getPaddingLeft();
        int r16 = ((r12 - r10) - r15) - getPaddingRight();
        int r17 = getPaddingTop();
        int r18 = 0;
    L3:
        if (r18 >= r14) goto L9;
        View r19 = getChildAt(r18);
        if (r19.getVisibility() == 8) goto L8;
        int r20 = r19.getMeasuredWidth();
        int r21 = r19.getMeasuredHeight();
        int r22 = j0.c(r16, r20, 2, r15);
        int r23 = r21 + r17;
        r19.layout(r22, r17, r20 + r22, r23);
        r17 = r23;
    L8:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.View
    public final void onMeasure(int r17, int r18) {
        int r5 = View.MeasureSpec.getSize(r17);
        int r10 = View.MeasureSpec.getMode(r17);
        int r11 = View.MeasureSpec.getSize(r18);
        int r12 = View.MeasureSpec.getMode(r18);
        if (this.A != (-10)) goto L5;
        this.A = d(28);
    L5:
        int r13 = (r5 - getPaddingLeft()) - getPaddingRight();
        int r14 = (r11 - getPaddingTop()) - getPaddingBottom();
        int r15 = this.f12184t;
        k r16 = this.C;
        if (r15 <= 0) goto L8;
        r16.f12283a = r15;
    L9:
        int r19 = this.s;
        if (r19 <= 0) goto L12;
        r16.f12284b = r19;
    L13:
        int r20 = 0;
        int r21 = Math.max(getTileHSpacing(), 0);
        int r22 = Math.max(getTileVSpacing(), 0);
        int r23 = getChildCount();
        int r110 = 0;
        int r111 = 0;
    L14:
        if (r20 >= r23) goto L32;
        View r112 = getChildAt(r20);
        if (r112.getVisibility() == 8) goto L31;
        int r113 = BasicMeasure.EXACTLY;
        if (r10 != 1073741824) goto L21;
        int r114 = r13;
    L22:
        int r115 = View.MeasureSpec.makeMeasureSpec(r114, BasicMeasure.EXACTLY);
        if (r12 != 1073741824) goto L25;
        int r116 = r14;
    L30:
        r112.measure(r115, View.MeasureSpec.makeMeasureSpec(r116, r113));
        r110 = Math.max(r110, getPaddingRight() + (getPaddingLeft() + r112.getMeasuredWidth()));
        r111 = Math.max(r111, getPaddingBottom() + (getPaddingTop() + r112.getMeasuredHeight()));
        goto L31
    L25:
        int r117 = (r16.f12284b + r22) * 6;
        if (this.f12190z == false) goto L28;
        int r118 = this.A;
    L29:
        r116 = r117 + r118;
        r113 = BasicMeasure.EXACTLY;
        goto L30
    L28:
        r118 = -r22;
        goto L29
    L21:
        r114 = (r21 * 6) + (r16.f12283a * 7);
    L31:
        r20 = r20 + 1;
        goto L14
    L32:
        setMeasuredDimension(r110, r111);
        return;
    L12:
        r16.f12284b = d(40);
        goto L13
    L8:
        r16.f12283a = d(40);
        goto L9
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        m r11 = this.B;
        m r12 = new m(r11.g, r11, false);
        r12.f12287c = r10.f12193c;
        r12.d = r10.d;
        r12.e = r10.f12196j;
        r12.a();
        setShowOtherDates(r10.f12191a);
        setAllowClickDaysOutsideCurrentMonth(r10.f12192b);
        a();
        Iterator r13 = r10.e.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        CalendarDay r14 = (CalendarDay) r13.next();
        if (r14 == null) goto L4;
        this.f.h(r14, true);
        goto L4
    L9:
        setTopbarVisible(r10.f);
        setSelectionMode(r10.g);
        setDynamicHeightEnabled(r10.f12194h);
        setCurrentDate(r10.f12195i);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.f12191a = 4;
        r5.f12192b = true;
        r5.f12193c = null;
        r5.d = null;
        r5.e = new ArrayList();
        r5.f = true;
        r5.g = 1;
        r5.f12194h = false;
        r5.f12195i = null;
        r5.f12191a = getShowOtherDates();
        r5.f12192b = this.f12188x;
        r5.f12193c = getMinimumDate();
        r5.d = getMaximumDate();
        r5.e = getSelectedDates();
        r5.g = getSelectionMode();
        r5.f = getTopbarVisible();
        r5.f12194h = this.f12175j;
        r5.f12195i = this.g;
        r5.f12196j = this.B.e;
        return r5;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        return this.e.dispatchTouchEvent(r5);
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r5) {
        this.f12188x = r5;
    }

    public void setContentDescriptionArrowFuture(CharSequence r5) {
        this.d.setContentDescription(r5);
    }

    public void setContentDescriptionArrowPast(CharSequence r5) {
        this.f12172c.setContentDescription(r5);
    }

    public void setContentDescriptionCalendar(CharSequence r5) {
        this.f12182q = r5;
    }

    public void setCurrentDate(@Nullable LocalDate r5) {
        setCurrentDate(CalendarDay.c(r5));
    }

    public void setDateTextAppearance(int r5) {
        b r10 = this.f;
        if (r5 != 0) goto L5;
        r10.getClass();
        return;
    L5:
        r10.f = Integer.valueOf(r5);
        Iterator r11 = r10.f12238a.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        ((d) r11.next()).f(r5);
        goto L7
    }

    public void setDayFormatter(yq.a r5) {
        b r10 = this.f;
        if (r5 != null) goto L5;
        r5 = yq.a.f23316m1;
    L5:
        yq.a r11 = r10.f12248o;
        if (r11 != r10.f12247n) goto L8;
        r11 = r5;
    L8:
        r10.f12248o = r11;
        r10.f12247n = r5;
        Iterator r12 = r10.f12238a.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        ((d) r12.next()).g(r5);
        goto L10
    }

    public void setDayFormatterContentDescription(yq.a r5) {
        b r10 = this.f;
        r10.f12248o = r5;
        Iterator r11 = r10.f12238a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).h(r5);
        goto L4
    }

    public void setDynamicHeightEnabled(boolean r5) {
        this.f12175j = r5;
    }

    public void setHeaderTextAppearance(int r5) {
        this.f12171b.setTextAppearance(getContext(), r5);
    }

    public void setLeftArrow(@DrawableRes int r5) {
        this.f12172c.setImageResource(r5);
    }

    public void setOnDateChangedListener(z r5) {
        this.f12178m = r5;
    }

    public void setOnDateLongClickListener(y r5) {
        this.f12179n = r5;
    }

    public void setOnMonthChangedListener(a0 r5) {
        this.f12180o = r5;
    }

    public void setOnRangeSelectedListener(b0 r5) {
        this.f12181p = r5;
    }

    public void setOnTitleClickListener(View.OnClickListener r5) {
        this.f12171b.setOnClickListener(r5);
    }

    public void setPagingEnabled(boolean r5) {
        this.e.f12169a = r5;
        e();
    }

    public void setRightArrow(@DrawableRes int r5) {
        this.d.setImageResource(r5);
    }

    public void setSelectedDate(@Nullable LocalDate r5) {
        setSelectedDate(CalendarDay.c(r5));
    }

    public void setSelectionColor(int r5) {
        if (r5 == 0) goto L4;
    L7:
        this.f12183r = r5;
        b r10 = this.f;
        r10.e = Integer.valueOf(r5);
        Iterator r11 = r10.f12238a.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        ((d) r11.next()).k(r5);
        goto L9
    L11:
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r5 = -7829368;
        goto L7
    }

    public void setSelectionMode(int r10) {
        int r5 = this.f12187w;
        this.f12187w = r10;
        boolean r11 = false;
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L9;
        this.f12187w = 0;
        if (r5 == 0) goto L15;
        a();
        goto L15
    L9:
        a();
    L15:
        b r12 = this.f;
        if (this.f12187w == 0) goto L18;
        r11 = true;
    L18:
        r12.f12251r = r11;
        Iterator r13 = r12.f12238a.iterator();
    L20:
        if (r13.hasNext() == false) goto L22;
        ((d) r13.next()).l(r12.f12251r);
        goto L20
    L22:
        return;
    L10:
        if (r5 == 2) goto L13;
        if (r5 != 3) goto L15;
    L13:
        if (getSelectedDates().isEmpty() == true) goto L15;
        setSelectedDate(getSelectedDate());
        goto L15
    }

    public void setShowOtherDates(int r5) {
        b r10 = this.f;
        r10.f12241h = r5;
        Iterator r11 = r10.f12238a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        d r12 = (d) r11.next();
        r12.d = r5;
        r12.o();
        goto L4
    }

    public void setTileHSpacing(int r5) {
        this.f12185u = r5;
        requestLayout();
    }

    public void setTileHeight(int r5) {
        this.s = r5;
        requestLayout();
    }

    public void setTileHeightDp(int r5) {
        setTileHeight(d(r5));
    }

    public void setTileSize(int r5) {
        this.f12184t = r5;
        this.s = r5;
        requestLayout();
    }

    public void setTileSizeDp(int r5) {
        setTileSize(d(r5));
    }

    public void setTileVSpacing(int r5) {
        this.f12186v = r5;
        requestLayout();
    }

    public void setTileWidth(int r5) {
        this.f12184t = r5;
        requestLayout();
    }

    public void setTileWidthDp(int r5) {
        setTileWidth(d(r5));
    }

    public void setTitleAnimationOrientation(int r5) {
        this.f12170a.g = r5;
    }

    public void setTitleFormatter(@Nullable yq.b r5) {
        d0 r10 = this.f12170a;
        if (r5 != null) goto L5;
        r10.getClass();
        yq.b r11 = yq.b.f23317n1;
    L6:
        r10.f12262b = r11;
        b r12 = this.f;
        if (r5 != null) goto L9;
        r12.getClass();
        r5 = yq.b.f23317n1;
    L9:
        r12.d = r5;
        e();
        return;
    L5:
        r11 = r5;
        goto L6
    }

    public void setTitleMonths(CharSequence[] r5) {
        setTitleFormatter(new com.lynx.tasm.behavior.ui.utils.n(r5));
    }

    public void setTopbarVisible(boolean r5) {
        if (r5 == false) goto L4;
        int r10 = 0;
    L5:
        this.f12173h.setVisibility(r10);
        requestLayout();
        return;
    L4:
        r10 = 8;
        goto L5
    }

    public void setWeekDayFormatter(yq.c r5) {
        b r10 = this.f;
        if (r5 != null) goto L5;
        r5 = yq.c.f23318o1;
    L5:
        r10.f12246m = r5;
        Iterator r11 = r10.f12238a.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        ((d) r11.next()).m(r5);
        goto L7
    }

    public void setWeekDayLabels(CharSequence[] r5) {
        setWeekDayFormatter(new zm.c(r5));
    }

    public void setWeekDayTextAppearance(int r5) {
        b r10 = this.f;
        if (r5 != 0) goto L5;
        r10.getClass();
        return;
    L5:
        r10.g = Integer.valueOf(r5);
        Iterator r11 = r10.f12238a.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        ((d) r11.next()).n(r5);
        goto L7
    }

    public void setWeekDaysHeight(int r5) {
        this.A = r5;
        requestLayout();
    }

    public void setWeekDaysHeightDp(int r5) {
        setWeekDaysHeight(d(r5));
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public MaterialCalendarView(Context r11, AttributeSet r12) {
        super(r11, r12);
        new ArrayList();
        g r5 = new g(this);
        h r10 = new h(this);
        this.f12176k = null;
        this.f12177l = null;
        int r13 = 0;
        this.f12183r = 0;
        this.s = -10;
        this.f12184t = -10;
        this.f12185u = -10;
        this.f12186v = -10;
        this.f12187w = 1;
        this.f12188x = true;
        this.A = -10;
        this.C = new k();
        setClipToPadding(false);
        setClipChildren(false);
        View r14 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R$layout.calendar_view, null, false);
        this.f12173h = (LinearLayout) r14.findViewById(R$id.header);
        ImageView r15 = (ImageView) r14.findViewById(R$id.previous);
        this.f12172c = r15;
        TextView r16 = (TextView) r14.findViewById(R$id.month_name);
        this.f12171b = r16;
        ImageView r17 = (ImageView) r14.findViewById(R$id.next);
        this.d = r17;
        CalendarPager r18 = new CalendarPager(getContext());
        r18.f12169a = true;
        this.e = r18;
        r15.setOnClickListener(r5);
        r17.setOnClickListener(r5);
        d0 r19 = new d0(r16);
        this.f12170a = r19;
        r18.setOnPageChangeListener(r10);
        r18.setPageTransformer(false, new i());
        TypedArray r110 = r11.getTheme().obtainStyledAttributes(r12, R$styleable.O_MaterialCalendarView, 0, 0);
        int r20 = r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_calendarMode, 0);     // Catch: Throwable -> L8 Exception -> L10
        int r21 = r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_firstDayOfWeek, -1);     // Catch: Throwable -> L8 Exception -> L10
        r19.g = r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_titleAnimationOrientation, 0);     // Catch: Throwable -> L8 Exception -> L10
        if (r21 >= 1) goto L6;
    L12:
        this.f12189y = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L8 Exception -> L10
    L13:
        this.f12190z = r110.getBoolean(R$styleable.O_MaterialCalendarView_o_mcv_showWeekDays, true);     // Catch: Throwable -> L8 Exception -> L10
        m r22 = new m(this);     // Catch: Throwable -> L8 Exception -> L10
        r22.f12286b = this.f12189y;     // Catch: Throwable -> L8 Exception -> L10
        r22.f12285a = CalendarMode.values()[r20];     // Catch: Throwable -> L8 Exception -> L10
        r22.f = this.f12190z;     // Catch: Throwable -> L8 Exception -> L10
        r22.a();     // Catch: Throwable -> L8 Exception -> L10
        setSelectionMode(r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_selectionMode, 1));     // Catch: Throwable -> L8 Exception -> L10
        int r23 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileSize, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r23 <= (-10)) goto L16;
        setTileSize(r23);     // Catch: Throwable -> L8 Exception -> L10
    L16:
        int r24 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileWidth, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r24 <= (-10)) goto L19;
        setTileWidth(r24);     // Catch: Throwable -> L8 Exception -> L10
    L19:
        int r25 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileHeight, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r25 <= (-10)) goto L22;
        setTileHeight(r25);     // Catch: Throwable -> L8 Exception -> L10
    L22:
        int r26 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileHSpacing, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r26 <= (-10)) goto L25;
        setTileHSpacing(r26);     // Catch: Throwable -> L8 Exception -> L10
    L25:
        int r27 = r110.getLayoutDimension(R$styleable.O_MaterialCalendarView_o_mcv_tileVSpacing, -10);     // Catch: Throwable -> L8 Exception -> L10
        if (r27 <= (-10)) goto L28;
        setTileVSpacing(r27);     // Catch: Throwable -> L8 Exception -> L10
    L28:
        setLeftArrow(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_leftArrow, R$drawable.o_mcv_action_previous));     // Catch: Throwable -> L8 Exception -> L10
        setRightArrow(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_rightArrow, R$drawable.o_mcv_action_next));     // Catch: Throwable -> L8 Exception -> L10
        int r28 = R$styleable.O_MaterialCalendarView_o_mcv_selectionColor;     // Catch: Throwable -> L8 Exception -> L10
        TypedValue r29 = new TypedValue();     // Catch: Throwable -> L8 Exception -> L10
        r11.getTheme().resolveAttribute(R.attr.colorAccent, r29, true);     // Catch: Throwable -> L8 Exception -> L10
        setSelectionColor(r110.getColor(r28, r29.data));     // Catch: Throwable -> L8 Exception -> L10
        CharSequence[] r111 = r110.getTextArray(R$styleable.O_MaterialCalendarView_o_mcv_weekDayLabels);     // Catch: Throwable -> L8 Exception -> L10
        if (r111 == null) goto L31;
        setWeekDayFormatter(new zm.c(r111));     // Catch: Throwable -> L8 Exception -> L10
    L31:
        CharSequence[] r112 = r110.getTextArray(R$styleable.O_MaterialCalendarView_o_mcv_monthLabels);     // Catch: Throwable -> L8 Exception -> L10
        if (r112 == null) goto L34;
        setTitleFormatter(new com.lynx.tasm.behavior.ui.utils.n(r112));     // Catch: Throwable -> L8 Exception -> L10
    L34:
        setHeaderTextAppearance(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_headerTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_Header));     // Catch: Throwable -> L8 Exception -> L10
        setWeekDayTextAppearance(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_weekDayTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_WeekDay));     // Catch: Throwable -> L8 Exception -> L10
        setDateTextAppearance(r110.getResourceId(R$styleable.O_MaterialCalendarView_o_mcv_dateTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_Date));     // Catch: Throwable -> L8 Exception -> L10
        setShowOtherDates(r110.getInteger(R$styleable.O_MaterialCalendarView_o_mcv_showOtherDates, 4));     // Catch: Throwable -> L8 Exception -> L10
        setAllowClickDaysOutsideCurrentMonth(r110.getBoolean(R$styleable.O_MaterialCalendarView_o_mcv_allowClickDaysOutsideCurrentMonth, true));     // Catch: Throwable -> L8 Exception -> L10
    L35:
        r110.recycle();
        addView(this.f12173h);
        int r113 = R$id.mcv_pager;
        CalendarPager r114 = this.e;
        r114.setId(r113);
        r114.setOffscreenPageLimit(1);
        addView(r114);
        CalendarDay r115 = CalendarDay.d();
        this.g = r115;
        setCurrentDate(r115);
        if (isInEditMode() == false) goto L54;
        removeView(this.e);
        o r116 = new o(this, this.g, getFirstDayOfWeek(), true);
        r116.k(getSelectionColor());
        Integer r117 = this.f.f;
        if (r117 != null) goto L43;
        int r118 = 0;
    L44:
        r116.f(r118);
        Integer r119 = this.f.g;
        if (r119 == null) goto L48;
        r13 = r119.intValue();
    L48:
        r116.n(r13);
        r116.d = getShowOtherDates();
        r116.o();
        addView(r116);
        return;
    L43:
        r118 = r117.intValue();
        goto L44
    L54:
        return;
    L6:
        if (r21 > 7) goto L12;
        this.f12189y = DayOfWeek.of(r21);     // Catch: Throwable -> L8 Exception -> L10
    L8:
        th = move-exception;
        r110.recycle();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L35
    }

    public void setCurrentDate(@Nullable CalendarDay r5) {
        if (r5 == null) goto L6;
        int r10 = this.f.c(r5);
        this.e.setCurrentItem(r10, true);
        e();
        return;
    }

    public void setSelectedDate(@Nullable CalendarDay r5) {
        a();
        if (r5 == null) goto L6;
        this.f.h(r5, true);
        return;
    }

    public void setTitleMonths(@ArrayRes int r5) {
        setTitleMonths(getResources().getTextArray(r5));
    }

    public void setWeekDayLabels(@ArrayRes int r5) {
        setWeekDayLabels(getResources().getTextArray(r5));
    }
}
