package com.obric.oui.calendar;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class c extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    public final ArrayList<a0> a;
    public final ArrayList<h> b;
    public final DayOfWeek c;
    public int d;
    public final MaterialCalendarView e;
    public final CalendarDay f;
    public CalendarDay g;
    public CalendarDay h;
    public final boolean i;
    public final Collection<e> j;

    public static class a extends ViewGroup.MarginLayoutParams {
        public a() {
            super(-2, -2);
        }
    }

    public abstract void b(Collection<e> r1, LocalDate r2);

    public abstract int d();

    public abstract boolean e(CalendarDay r1);

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    public final void o() {
        Iterator r0 = ((ArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        e r1 = (e) r0.next();
        CalendarDay r2 = r1.a;
        int r3 = this.d;
        CalendarDay r4 = this.g;
        CalendarDay r5 = this.h;
        r2.getClass();
        if (r4 != null) goto L8;
    L9:
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        boolean r7 = e(r2);
        r1.o = r3;
        r1.j = r7;
        r1.i = r6;
        r1.c();
        goto L4
    L11:
        if (r5.a.isBefore(r2.a) == false) goto L14;
    L13:
        r6 = false;
        goto L15
    L8:
        if (r4.a.isAfter(r2.a) == true) goto L13;
    L16:
        postInvalidate();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof a;
    }

    public final void f(int r4) {
        Iterator r0 = ((ArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).setTextAppearance(getContext(), r4);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.CheckedTextView, com.obric.oui.calendar.e] */
    public final void g(mla.e r11) {
        Iterator r0 = ((ArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        ?? r1 = (e) r0.next();
        mla.e r2 = r1.h;
        if (r2 != r1.g) goto L8;
        r2 = r11;
    L8:
        r1.h = r2;
        if (r11 != null) goto L11;
        mla.e r3 = mla.e.a;
    L12:
        r1.g = r3;
        CharSequence r4 = r1.getText();
        if ((r4 instanceof Spanned) == false) goto L15;
        Object[] r5 = ((Spanned) r4).getSpans(0, r4.length(), Object.class);
    L16:
        SpannableString r6 = new SpannableString(r1.a());
        if (r5 == null) goto L21;
        int r7 = r5.length;
        int r8 = 0;
    L19:
        if (r8 >= r7) goto L21;
        r6.setSpan(r5[r8], 0, r6.length(), 33);
        r8 = r8 + 1;
    L21:
        r1.setText(r6);
        goto L4
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = r11;
        goto L12
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return new a();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.CheckedTextView, com.obric.oui.calendar.e] */
    public final void h(mla.e r5) {
        Iterator r0 = ((ArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        ?? r1 = (e) r0.next();
        if (r5 != null) goto L8;
        mla.e r2 = r1.g;
    L9:
        r1.h = r2;
        if (r2 != null) goto L12;
        mla.e r3 = r1.g;
        CalendarDay r4 = r1.a;
        String r6 = ((mla.c) r3).b.a(r4.a);
    L13:
        r1.setContentDescription(r6);
        goto L4
    L12:
        CalendarDay r7 = r1.a;
        r6 = ((mla.c) r2).b.a(r7.a);
        goto L13
    L8:
        r2 = r5;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.CheckedTextView, com.obric.oui.calendar.e, java.lang.Object] */
    public final void i(List<h> r12) {
        this.b.clear();
        if (r12 == null) goto L5;
        this.b.addAll(r12);
    L5:
        LinkedList r13 = new LinkedList();
        Iterator r0 = ((ArrayList) this.j).iterator();
    L7:
        if (r0.hasNext() == false) goto L36;
        ?? r1 = (e) r0.next();
        r13.clear();
        Iterator<h> r2 = this.b.iterator();
        Drawable r6 = null;
        Drawable r7 = null;
        boolean r5 = false;
    L10:
        if (r2.hasNext() == false) goto L20;
        h r8 = r2.next();
        f r9 = r8.a;
        CalendarDay r10 = r1.a;
        if (r9.b() == false) goto L10;
        g r11 = r8.b;
        Drawable r14 = r11.c;
        if (r14 == null) goto L16;
        r7 = r14;
    L16:
        Drawable r15 = r11.b;
        if (r15 == null) goto L19;
        r6 = r15;
    L19:
        r13.addAll(r11.d);
        r5 = r11.e;
        goto L10
    L20:
        r1.getClass();
        r1.l = r5;
        r1.c();
        if (r6 != null) goto L23;
        r1.d = null;
    L24:
        r1.invalidate();
        if (r7 != null) goto L27;
        r1.e = null;
    L28:
        r1.b();
        List r3 = Collections.unmodifiableList(r13);
        if (r3.isEmpty() == false) goto L30;
        r1.setText(r1.a());
        goto L7
    L30:
        String r16 = r1.a();
        SpannableString r17 = new SpannableString(r1.a());
        Iterator r4 = r3.iterator();
    L32:
        if (r4.hasNext() == false) goto L34;
        ((g.a) r4.next()).getClass();
        r17.setSpan(null, 0, r16.length(), 33);
        goto L32
    L34:
        r1.setText(r17);
        goto L7
    L27:
        r1.e = r7.getConstantState().newDrawable(r1.getResources());
        goto L28
    L23:
        r1.d = r6.getConstantState().newDrawable(r1.getResources());
        goto L24
    }

    public final void j(Collection<CalendarDay> r5) {
        Iterator r0 = ((ArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        e r1 = (e) r0.next();
        CalendarDay r2 = r1.a;
        if (r5 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r1.k == false) goto L4;
        r1.setChecked(r3);
        goto L4
    L8:
        if (r5.contains(r2) == false) goto L10;
        r3 = true;
        goto L12
    L14:
        postInvalidate();
    }

    public final void k(int r3) {
        Iterator r0 = ((ArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        e r1 = (e) r0.next();
        r1.b = r3;
        r1.b();
        goto L4
    }

    public final void l(boolean r4) {
        Iterator r0 = ((ArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        AppCompatCheckedTextView r1 = (e) r0.next();
        if (r4 == false) goto L8;
        View.OnClickListener r2 = this;
    L9:
        r1.setOnClickListener(r2);
        r1.setClickable(r4);
        goto L4
    L8:
        r2 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.TextView, com.obric.oui.calendar.a0, java.lang.Object] */
    public final void m(mla.h r5) {
        Iterator<a0> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        a0 r1 = r0.next();
        if (r5 != null) goto L8;
        r1.getClass();
        mla.h r2 = mla.h.a;
    L9:
        r1.a = r2;
        DayOfWeek r3 = r1.b;
        r1.b = r3;
        r1.setText(r2.a(r3));
        goto L4
    L8:
        r2 = r5;
        goto L9
    }

    public final void n(int r4) {
        Iterator<a0> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setTextAppearance(getContext(), r4);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.widget.CheckedTextView, com.obric.oui.calendar.e] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        if ((r10 instanceof e) == false) goto L45;
        ?? r11 = (e) r10;
        MaterialCalendarView r0 = this.e;
        CalendarDay r1 = r0.getCurrentDate();
        CalendarDay r2 = r11.a;
        int r3 = r1.c();
        int r4 = r2.c();
        if (r0.i == CalendarMode.MONTHS) goto L7;
    L25:
        CalendarDay r5 = r11.a;
        boolean r12 = !r11.isChecked();
        int r6 = r0.w;
        if (r6 != 2) goto L28;
        r0.f.o(r5, r12);
        r0.b(r5, r12);
        return;
    L28:
        if (r6 == 3) goto L30;
        b<?> r13 = r0.f;
        r13.l.clear();
        r13.l();
        r0.f.o(r5, true);
        r0.b(r5, true);
        return;
    L30:
        List<CalendarDay> r7 = r0.f.j();
        if (r7.size() != 0) goto L34;
        r0.f.o(r5, r12);
        r0.b(r5, r12);
        return;
    L34:
        if (r7.size() != 1) goto L42;
        CalendarDay r8 = (CalendarDay) ListProtector.get(r7, 0);
        if (r8.equals(r5) == false) goto L39;
        r0.f.o(r5, r12);
        r0.b(r5, r12);
        return;
    L39:
        if (r8.a.isAfter(r5.a) == false) goto L41;
        r0.f.n(r5, r8);
        r0.c(r0.f.j());
        return;
    L41:
        r0.f.n(r8, r5);
        r0.c(r0.f.j());
        return;
    L42:
        b<?> r9 = r0.f;
        r9.l.clear();
        r9.l();
        r0.f.o(r5, r12);
        r0.b(r5, r12);
        return;
    L7:
        if (r0.x == false) goto L25;
        if (r3 == r4) goto L25;
        if (r1.a.isAfter(r2.a) == false) goto L18;
        if (r0.e.getCurrentItem() <= 0) goto L14;
        boolean r14 = true;
    L15:
        if (r14 == false) goto L25;
        CalendarPager r15 = r0.e;
        r15.setCurrentItem(r15.getCurrentItem() - 1, true);
        goto L25
    L14:
        r14 = false;
        goto L15
    L18:
        if (r1.a.isBefore(r2.a) == false) goto L25;
        if (r0.e.getCurrentItem() >= (r0.f.getCount() - 1)) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L25;
        CalendarPager r17 = r0.e;
        r17.setCurrentItem(r17.getCurrentItem() + 1, true);
        goto L25
    L22:
        r16 = false;
        goto L23
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName(c.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(c.class.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        if ((r4 instanceof e) == false) goto L12;
        e r5 = (e) r4;
        MaterialCalendarView r0 = this.e;
        v r1 = r0.n;
        if (r1 == null) goto L14;
        CalendarDay r6 = r5.a;
        ODatePickerView r2 = ((q) r1).a;
        int r3 = ODatePickerView.C;
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r0, "widget");
        Intrinsics.checkNotNullParameter(r6, "date");
        Function1<? super Long, Unit> r7 = r2.A;
        if (r7 == null) goto L15;
        r7.invoke(Long.valueOf(ODatePickerView.T5(r6)));
        return true;
    L15:
        return true;
    L14:
        return true;
    L12:
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Collection<e> r3, LocalDate r4) {
        CalendarDay r5 = CalendarDay.a(r4);
        AppCompatCheckedTextView r0 = new e(getContext(), r5);
        r0.setOnClickListener(this);
        r0.setOnLongClickListener(this);
        r3.add(r0);
        addView(r0, new a());
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r5);
        int r7 = View.MeasureSpec.getMode(r5);
        int r1 = View.MeasureSpec.getSize(r6);
        if (View.MeasureSpec.getMode(r6) == 0) goto L16;
        if (r7 == 0) goto L16;
        setMeasuredDimension(r0, r1);
        int r8 = getChildCount();
        int r9 = 0;
    L6:
        if (r9 >= r8) goto L14;
        View r2 = getChildAt(r9);
        int r3 = View.MeasureSpec.makeMeasureSpec(this.e.getMeasureInfo().a, 1073741824);
        if (this.i == true) goto L10;
    L12:
        int r4 = View.MeasureSpec.makeMeasureSpec(this.e.getMeasureInfo().b, 1073741824);
    L13:
        r2.measure(r3, r4);
        r9 = r9 + 1;
        goto L6
    L10:
        if (r9 >= 7) goto L12;
        r4 = View.MeasureSpec.makeMeasureSpec(this.e.getWeekDaysHeight(), 1073741824);
        goto L13
    L14:
        return;
    L16:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    public static LocalDate c(LocalDate r4, DayOfWeek r5, boolean r6) {
        boolean r0 = true;
        LocalDate r7 = r4.with(WeekFields.of(r5, 1).dayOfWeek(), 1);
        int r8 = r5.getValue() - r7.getDayOfWeek().getValue();
        if (r6 == false) goto L6;
        if (r8 >= 0) goto L9;
    L8:
        r0 = false;
    L9:
        if (r0 == false) goto L12;
        r8 = r8 - 7;
    L12:
        return r7.plusDays(r8);
    L6:
        if (r8 <= 0) goto L8;
        goto L8
    }

    public c(MaterialCalendarView r4, CalendarDay r5, DayOfWeek r6, boolean r7) {
        super(r4.getContext());
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = 4;
        this.g = null;
        this.h = null;
        this.j = new ArrayList();
        this.e = r4;
        this.f = r5;
        this.c = r6;
        this.i = r7;
        boolean r8 = false;
        setClipChildren(false);
        setClipToPadding(false);
        if (r7 == false) goto L12;
        LocalDate r9 = r5.a;
        if ((this.d & 1) == 0) goto L7;
        boolean r10 = true;
    L8:
        LocalDate r11 = c(r9, r6, r10);
        int r12 = 0;
    L10:
        if (r12 >= 7) goto L12;
        AppCompatTextView r13 = new a0(getContext(), r11.getDayOfWeek());
        r13.setImportantForAccessibility(2);
        this.a.add((a0) r13);
        addView(r13);
        r11 = r11.plusDays(1);
        r12 = r12 + 1;
        goto L10
    L7:
        r10 = false;
    L12:
        Collection<e> r14 = this.j;
        LocalDate r15 = this.f.a;
        DayOfWeek r16 = this.c;
        if ((this.d & 1) == 0) goto L15;
        r8 = true;
    L15:
        b(r14, c(r15, r16, r8));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        int r1 = getWidth();
        int r2 = getChildCount();
        int r3 = getHeight();
        int r4 = d();
        if (this.i == false) goto L5;
        r4 = Math.max(0, r4 - 1);
    L5:
        int r5 = this.e.getTileHSpacing();
        int r7 = this.e.getTileVSpacing();
        if (r5 >= 0) goto L9;
        r5 = (r1 - (this.e.getMeasureInfo().a * 7)) / 6;
    L9:
        if (r7 >= 0) goto L18;
        int r8 = r4 - (!this.i ? 1 : 0);
        if (r8 == 0) goto L17;
        int r6 = r3 - (this.e.getMeasureInfo().b * r4);
        if (this.i == false) goto L15;
        int r9 = this.e.getWeekDaysHeight();
    L16:
        r7 = (r6 - r9) / r8;
        goto L18
    L15:
        r9 = 0;
        goto L16
    L17:
        r7 = 0;
    L18:
        int r10 = r1;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L19:
        if (r11 >= r2) goto L33;
        View r14 = getChildAt(r11);
        int r15 = r14.getMeasuredWidth();
        int r16 = r14.getMeasuredHeight();
        int r17 = r11 % 7;
        if (r17 <= 0) goto L24;
        r12 = r12 + r5;
        r10 = r10 + r5;
    L24:
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L26;
        boolean r23 = true;
    L27:
        if (r23 == false) goto L29;
        int r24 = r10 - r15;
        r14.layout(r24, r13, r10, r13 + r16);
        r10 = r24;
    L30:
        if (r17 != 6) goto L32;
        r13 = (r13 + r16) + r7;
        r10 = r1;
        r12 = 0;
    L32:
        r11 = r11 + 1;
        goto L19
    L29:
        int r110 = r15 + r12;
        r14.layout(r12, r13, r110, r13 + r16);
        r12 = r110;
        goto L30
    L26:
        r23 = false;
        goto L27
    }
}
