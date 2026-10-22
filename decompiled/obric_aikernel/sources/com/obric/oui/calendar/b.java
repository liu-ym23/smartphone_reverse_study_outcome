package com.obric.oui.calendar;

import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
abstract class b extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<WeekDayView> f6336c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<f> f6337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final DayOfWeek f6338h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f6339i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaterialCalendarView f6340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CalendarDay f6341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CalendarDay f6342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private CalendarDay f6343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f6344n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Collection<DayView> f6345o;

    protected static class a extends ViewGroup.MarginLayoutParams {
        public a() {
            super(-2, -2);
        }
    }

    public b(@NonNull MaterialCalendarView r10, CalendarDay r11, DayOfWeek r12, boolean r13) {
        super(r10.getContext());
        this.f6336c = new ArrayList();
        this.f6337g = new ArrayList();
        this.f6339i = 4;
        this.f6342l = null;
        this.f6343m = null;
        ArrayList r14 = new ArrayList();
        this.f6345o = r14;
        this.f6340j = r10;
        this.f6341k = r11;
        this.f6338h = r12;
        this.f6344n = r13;
        setClipChildren(false);
        setClipToPadding(false);
        if (r13 == false) goto L5;
        c(k());
    L5:
        b(r14, k());
    }

    private void c(LocalDate r10) {
        int r11 = 0;
    L4:
        if (r11 >= 7) goto L9;
        WeekDayView r12 = new WeekDayView(getContext(), r10.getDayOfWeek());
        if (Build.VERSION.SDK_INT < 16) goto L8;
        r12.setImportantForAccessibility(2);
    L8:
        this.f6336c.add(r12);
        addView(r12);
        r10 = r10.plusDays(1);
        r11 = r11 + 1;
        goto L4
    }

    protected void a(Collection<DayView> r10, LocalDate r11) {
        CalendarDay r12 = CalendarDay.from(r11);
        DayView r13 = new DayView(getContext(), r12);
        r13.setOnClickListener(this);
        r13.setOnLongClickListener(this);
        r10.add(r13);
        addView(r13, new a());
    }

    protected abstract void b(Collection<DayView> r10, LocalDate r11);

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof a;
    }

    protected a d() {
        return new a();
    }

    public a e(AttributeSet r10) {
        return new a();
    }

    protected DayOfWeek f() {
        return this.f6338h;
    }

    protected CalendarDay g() {
        return this.f6341k;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return e(r10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new a();
    }

    protected abstract int h();

    protected void i() {
        e r10 = new e();
        Iterator<DayView> r11 = this.f6345o.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        DayView r12 = r11.next();
        r10.g();
        Iterator<f> r13 = this.f6337g.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        f r14 = r13.next();
        if (r14.f6352a.a(r12.getDate()) == false) goto L7;
        r14.f6353b.a(r10);
        goto L7
    L11:
        r12.applyFacade(r10);
        goto L4
    }

    protected abstract boolean j(CalendarDay r10);

    protected LocalDate k() {
        boolean r10 = true;
        LocalDate r11 = g().getDate().with(WeekFields.of(this.f6338h, 1).dayOfWeek(), 1);
        int r12 = f().getValue() - r11.getDayOfWeek().getValue();
        if (MaterialCalendarView.K(this.f6339i) == false) goto L6;
        if (r12 >= 0) goto L9;
    L8:
        r10 = false;
    L9:
        if (r10 == false) goto L12;
        r12 = r12 - 7;
    L12:
        return r11.plusDays(r12);
    L6:
        if (r12 <= 0) goto L8;
        goto L8
    }

    public void l(int r10) {
        Iterator<DayView> r11 = this.f6345o.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setTextAppearance(getContext(), r10);
        goto L4
    }

    public void m(m9.e r10) {
        Iterator<DayView> r11 = this.f6345o.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setDayFormatter(r10);
        goto L4
    }

    public void n(m9.e r10) {
        Iterator<DayView> r11 = this.f6345o.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setDayFormatterContentDescription(r10);
        goto L4
    }

    void o(List<f> r10) {
        this.f6337g.clear();
        if (r10 == null) goto L5;
        this.f6337g.addAll(r10);
    L5:
        i();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if ((r10 instanceof DayView) == false) goto L6;
        MaterialCalendarView r11 = this.f6340j;
        r11.C((DayView) r10);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(b.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(b.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getWidth();
        int r16 = getChildCount();
        int r17 = r15;
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
    L3:
        if (r18 >= r16) goto L15;
        View r21 = getChildAt(r18);
        int r22 = r21.getMeasuredWidth();
        int r23 = r21.getMeasuredHeight();
        int r24 = r18 % 7;
        if (r24 <= 0) goto L8;
        r19 = r19 + this.f6340j.getTileHSpacing();
        r17 = r17 + this.f6340j.getTileHSpacing();
    L8:
        if (g.a() == false) goto L10;
        int r25 = r17 - r22;
        r21.layout(r25, r20, r17, r20 + r23);
        r17 = r25;
    L12:
        if (r24 != 6) goto L14;
        r20 = (r20 + r23) + this.f6340j.getTileVSpacing();
        r17 = r15;
        r19 = 0;
    L14:
        r18 = r18 + 1;
        goto L3
    L10:
        int r26 = r22 + r19;
        r21.layout(r19, r20, r26, r20 + r23);
        r19 = r26;
        goto L12
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r10) {
        if ((r10 instanceof DayView) == false) goto L6;
        MaterialCalendarView r11 = this.f6340j;
        r11.D((DayView) r10);
        return true;
    L6:
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getSize(r11);
        if (View.MeasureSpec.getMode(r11) == 0) goto L10;
        if (r13 == 0) goto L10;
        int r15 = r12 / 7;
        int r16 = r14 / h();
        int r17 = 0;
        setMeasuredDimension(r12, r14 + (this.f6340j.getTileVSpacing() * Math.max(0, h() - 1)));
        int r18 = getChildCount();
    L6:
        if (r17 >= r18) goto L8;
        getChildAt(r17).measure(View.MeasureSpec.makeMeasureSpec(this.f6340j.getTileWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r16, 1073741824));
        r17 = r17 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    public void p(CalendarDay r10) {
        this.f6343m = r10;
        x();
    }

    public void q(CalendarDay r10) {
        this.f6342l = r10;
        x();
    }

    public void r(Collection<CalendarDay> r10) {
        Iterator<DayView> r11 = this.f6345o.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        DayView r12 = r11.next();
        CalendarDay r13 = r12.getDate();
        if (r10 != null) goto L8;
    L10:
        boolean r14 = false;
    L11:
        r12.setChecked(r14);
        goto L4
    L8:
        if (r10.contains(r13) == false) goto L10;
        r14 = true;
        goto L11
    L12:
        postInvalidate();
    }

    public void s(int r10) {
        Iterator<DayView> r11 = this.f6345o.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setSelectionColor(r10);
        goto L4
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(boolean r10) {
        Iterator<DayView> r11 = this.f6345o.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        DayView r12 = r11.next();
        if (r10 == false) goto L8;
        b r13 = this;
    L9:
        r12.setOnClickListener(r13);
        r12.setClickable(r10);
        goto L4
    L8:
        r13 = null;
        goto L9
    }

    public void u(int r10) {
        this.f6339i = r10;
        x();
    }

    public void v(m9.h r10) {
        Iterator<WeekDayView> r11 = this.f6336c.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setWeekDayFormatter(r10);
        goto L4
    }

    public void w(int r10) {
        Iterator<WeekDayView> r11 = this.f6336c.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setTextAppearance(getContext(), r10);
        goto L4
    }

    protected void x() {
        Iterator<DayView> r10 = this.f6345o.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        DayView r11 = r10.next();
        CalendarDay r12 = r11.getDate();
        r11.setupSelection(this.f6339i, r12.isInRange(this.f6342l, this.f6343m), j(r12));
        goto L4
    L6:
        postInvalidate();
    }
}
