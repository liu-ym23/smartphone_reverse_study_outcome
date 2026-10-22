package com.obric.oui.calendar;

import ai.j0;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.text.TextUtilsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f12256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DayOfWeek f12257c;
    public int d;
    public final MaterialCalendarView e;
    public final CalendarDay f;
    public CalendarDay g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CalendarDay f12258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f12259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f12260j;

    public d(MaterialCalendarView r10, CalendarDay r11, DayOfWeek r12, boolean r13) {
        super(r10.getContext());
        this.f12255a = new ArrayList();
        this.f12256b = new ArrayList();
        this.d = 4;
        this.g = null;
        this.f12258h = null;
        this.f12260j = new ArrayList();
        this.e = r10;
        this.f = r11;
        this.f12257c = r12;
        this.f12259i = r13;
        boolean r14 = false;
        setClipChildren(false);
        setClipToPadding(false);
        if (r13 == false) goto L12;
        LocalDate r15 = this.f.f12167a;
        if ((this.d & 1) == 0) goto L7;
        boolean r5 = true;
    L8:
        LocalDate r16 = c(r15, r12, r5);
        int r17 = 0;
    L10:
        if (r17 >= 7) goto L12;
        Context r18 = getContext();
        DayOfWeek r19 = r16.getDayOfWeek();
        e0 r20 = new e0(r18);
        r20.f12266a = yq.c.f23318o1;
        r20.setGravity(17);
        r20.setTextAlignment(4);
        r20.setTextSize(12.0f);
        r20.setTypeface(Typeface.create(Typeface.DEFAULT, 400, false));
        r20.f12267b = r19;
        r20.setText(r20.f12266a.b(r19));
        r20.setImportantForAccessibility(2);
        this.f12255a.add(r20);
        addView(r20);
        r16 = r16.plusDays(1);
        r17 = r17 + 1;
        goto L10
    L7:
        r5 = false;
    L12:
        ArrayList r21 = this.f12260j;
        LocalDate r22 = this.f.f12167a;
        if ((this.d & 1) == 0) goto L15;
        r14 = true;
    L15:
        b(r21, c(r22, this.f12257c, r14));
    }

    public static LocalDate c(LocalDate r5, DayOfWeek r10, boolean r11) {
        LocalDate r12 = r5.with(WeekFields.of(r10, 1).dayOfWeek(), 1);
        int r13 = r10.getValue() - r12.getDayOfWeek().getValue();
        if (r11 == false) goto L6;
        if (r13 < 0) goto L9;
    L7:
        r13 = r13 - 7;
    L9:
        return r12.plusDays(r13);
    L6:
        if (r13 <= 0) goto L9;
        goto L7
    }

    public final void a(ArrayList r5, LocalDate r10) {
        CalendarDay r11 = CalendarDay.c(r10);
        f r12 = new f(getContext(), r11);
        r12.setOnClickListener(this);
        r12.setOnLongClickListener(this);
        r5.add(r12);
        addView(r12, new c());
    }

    public abstract void b(ArrayList r5, LocalDate r10);

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof c;
    }

    public abstract int d();

    public abstract boolean e(CalendarDay r5);

    public final void f(int r5) {
        Iterator r10 = this.f12260j.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((f) r10.next()).setTextAppearance(getContext(), r5);
        goto L4
    }

    public final void g(yq.a r10) {
        Iterator r11 = this.f12260j.iterator();
    L4:
        if (r11.hasNext() == false) goto L22;
        f r5 = (f) r11.next();
        yq.a r12 = r5.f12271h;
        if (r12 != r5.g) goto L8;
        r12 = r10;
    L8:
        r5.f12271h = r12;
        if (r10 != null) goto L11;
        yq.a r13 = yq.a.f23316m1;
    L12:
        r5.g = r13;
        CharSequence r14 = r5.getText();
        if ((r14 instanceof Spanned) == false) goto L15;
        Object[] r15 = ((Spanned) r14).getSpans(0, r14.length(), Object.class);
    L16:
        yq.a r16 = r5.g;
        CalendarDay r17 = r5.f12268a;
        zm.z r18 = (zm.z) r16;
        r18.getClass();
        SpannableString r19 = new SpannableString(((org.threeten.bp.format.b) r18.f23549a).a(r17.f12167a));
        if (r15 == null) goto L21;
        int r20 = r15.length;
        int r21 = 0;
    L19:
        if (r21 >= r20) goto L21;
        r19.setSpan(r15[r21], 0, r19.length(), 33);
        r21 = r21 + 1;
    L21:
        r5.setText(r19);
        goto L4
    L15:
        r15 = null;
        goto L16
    L11:
        r13 = r10;
        goto L12
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new c();
    }

    public final void h(yq.a r5) {
        Iterator r10 = this.f12260j.iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        f r11 = (f) r10.next();
        if (r5 != null) goto L8;
        yq.a r12 = r11.g;
    L9:
        r11.f12271h = r12;
        if (r12 != null) goto L12;
        yq.a r13 = r11.g;
        CalendarDay r14 = r11.f12268a;
        zm.z r15 = (zm.z) r13;
        r15.getClass();
        LocalDate r16 = r14.f12167a;
        String r17 = ((org.threeten.bp.format.b) r15.f23549a).a(r16);
    L13:
        r11.setContentDescription(r17);
        goto L4
    L12:
        LocalDate r18 = r11.f12268a.f12167a;
        r17 = ((org.threeten.bp.format.b) ((zm.z) r12).f23549a).a(r18);
        goto L13
    L8:
        r12 = r5;
        goto L9
    }

    public final void i(ArrayList r10) {
        ArrayList r5 = this.f12256b;
        r5.clear();
        if (r10 == null) goto L5;
        r5.addAll(r10);
    L5:
        LinkedList r11 = new LinkedList();
        Iterator r12 = this.f12260j.iterator();
    L7:
        if (r12.hasNext() == false) goto L20;
        f r13 = (f) r12.next();
        r11.clear();
        Iterator r14 = r5.iterator();
        if (r14.hasNext() == true) goto L18;
        r13.getClass();
        r13.b();
        r13.d = null;
        r13.invalidate();
        r13.e = null;
        r13.a();
        List r15 = Collections.unmodifiableList(r11);
        if (r15.isEmpty() == false) goto L12;
        yq.a r16 = r13.g;
        CalendarDay r17 = r13.f12268a;
        zm.z r18 = (zm.z) r16;
        r18.getClass();
        LocalDate r19 = r17.f12167a;
        r13.setText(((org.threeten.bp.format.b) r18.f23549a).a(r19));
        goto L7
    L12:
        yq.a r20 = r13.g;
        CalendarDay r21 = r13.f12268a;
        zm.z r22 = (zm.z) r20;
        r22.getClass();
        LocalDate r23 = r21.f12167a;
        ((org.threeten.bp.format.b) r22.f23549a).a(r23);
        yq.a r24 = r13.g;
        CalendarDay r25 = r13.f12268a;
        zm.z r26 = (zm.z) r24;
        r26.getClass();
        LocalDate r27 = r25.f12167a;
        SpannableString r28 = new SpannableString(((org.threeten.bp.format.b) r26.f23549a).a(r27));
        Iterator r29 = r15.iterator();
        if (r29.hasNext() == true) goto L16;
        r13.setText(r28);
        goto L7
    L16:
        throw androidx.constraintlayout.motion.widget.a.g(r29);
    L18:
        j0.A(r14.next());
        throw null;
    }

    public final void j(ArrayList r5) {
        Iterator r10 = this.f12260j.iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        f r11 = (f) r10.next();
        CalendarDay r12 = r11.f12268a;
        if (r5 != null) goto L8;
    L10:
        boolean r13 = false;
    L12:
        if (r11.f12274k == false) goto L4;
        r11.setChecked(r13);
        goto L4
    L8:
        if (r5.contains(r12) == false) goto L10;
        r13 = true;
        goto L12
    L14:
        postInvalidate();
    }

    public final void k(int r5) {
        Iterator r10 = this.f12260j.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        f r11 = (f) r10.next();
        r11.f12269b = r5;
        r11.a();
        goto L4
    }

    public final void l(boolean r5) {
        Iterator r10 = this.f12260j.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        f r11 = (f) r10.next();
        if (r5 == false) goto L8;
        d r12 = this;
    L9:
        r11.setOnClickListener(r12);
        r11.setClickable(r5);
        goto L4
    L8:
        r12 = null;
        goto L9
    }

    public final void m(yq.c r5) {
        Iterator r10 = this.f12255a.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        e0 r11 = (e0) r10.next();
        r11.getClass();
        if (r5 != null) goto L8;
        yq.c r12 = yq.c.f23318o1;
    L9:
        r11.f12266a = r12;
        DayOfWeek r13 = r11.f12267b;
        r11.f12267b = r13;
        r11.setText(r12.b(r13));
        goto L4
    L8:
        r12 = r5;
        goto L9
    }

    public final void n(int r5) {
        Iterator r10 = this.f12255a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((e0) r10.next()).setTextAppearance(getContext(), r5);
        goto L4
    }

    public final void o() {
        Iterator r5 = this.f12260j.iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        f r10 = (f) r5.next();
        CalendarDay r11 = r10.f12268a;
        int r12 = this.d;
        CalendarDay r13 = this.g;
        CalendarDay r14 = this.f12258h;
        LocalDate r15 = r11.f12167a;
        if (r13 != null) goto L8;
    L9:
        if (r14 != null) goto L11;
    L14:
        boolean r16 = true;
    L15:
        boolean r17 = e(r11);
        r10.f12277n = r12;
        r10.f12273j = r17;
        r10.f12272i = r16;
        r10.b();
        goto L4
    L11:
        if (r14.f12167a.isBefore(r15) == false) goto L14;
    L13:
        r16 = false;
        goto L15
    L8:
        if (r13.f12167a.isAfter(r15) == true) goto L13;
    L16:
        postInvalidate();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        if ((r10 instanceof f) == false) goto L39;
        f r11 = (f) r10;
        MaterialCalendarView r12 = this.e;
        CalendarDay r5 = r12.getCurrentDate();
        CalendarDay r13 = r11.f12268a;
        int r14 = r5.f12167a.getMonthValue();
        int r15 = r13.f12167a.getMonthValue();
        if (r12.f12174i == CalendarMode.MONTHS) goto L7;
    L19:
        CalendarDay r16 = r11.f12268a;
        boolean r17 = !r11.isChecked();
        int r18 = r12.f12187w;
        if (r18 != 2) goto L22;
        r12.f.h(r16, r17);
        r12.b(r16, r17);
        return;
    L22:
        if (r18 == 3) goto L24;
        b r19 = r12.f;
        r19.f12245l.clear();
        r19.e();
        r12.f.h(r16, true);
        r12.b(r16, true);
        return;
    L24:
        List r20 = Collections.unmodifiableList(r12.f.f12245l);
        if (r20.size() != 0) goto L28;
        r12.f.h(r16, r17);
        r12.b(r16, r17);
        return;
    L28:
        if (r20.size() != 1) goto L36;
        CalendarDay r21 = (CalendarDay) r20.get(0);
        if (r21.equals(r16) == false) goto L33;
        r12.f.h(r16, r17);
        r12.b(r16, r17);
        return;
    L33:
        if (r21.f12167a.isAfter(r16.f12167a) == false) goto L35;
        r12.f.g(r16, r21);
        r12.c(Collections.unmodifiableList(r12.f.f12245l));
        return;
    L35:
        r12.f.g(r21, r16);
        r12.c(Collections.unmodifiableList(r12.f.f12245l));
        return;
    L36:
        b r22 = r12.f;
        r22.f12245l.clear();
        r22.e();
        r12.f.h(r16, r17);
        r12.b(r16, r17);
        return;
    L7:
        if (r12.f12188x == false) goto L19;
        if (r14 == r15) goto L19;
        LocalDate r23 = r5.f12167a;
        LocalDate r24 = r13.f12167a;
        boolean r25 = r23.isAfter(r24);
        CalendarPager r26 = r12.e;
        if (r25 == false) goto L15;
        if (r26.getCurrentItem() <= 0) goto L19;
        r26.setCurrentItem(r26.getCurrentItem() - 1, true);
        goto L19
    L15:
        if (r23.isBefore(r24) == false) goto L19;
        if (r26.getCurrentItem() >= (r12.f.f12244k.getCount() - 1)) goto L19;
        r26.setCurrentItem(r26.getCurrentItem() + 1, true);
        goto L19
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        r5.setClassName(d.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(d.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        int r5 = getWidth();
        int r10 = getChildCount();
        int r11 = getHeight();
        int r12 = d();
        boolean r13 = this.f12259i;
        if (r13 == false) goto L5;
        r12 = Math.max(0, r12 - 1);
    L5:
        MaterialCalendarView r14 = this.e;
        int r15 = r14.getTileHSpacing();
        int r16 = r14.getTileVSpacing();
        if (r15 >= 0) goto L8;
        r15 = (r5 - (r14.getMeasureInfo().f12283a * 7)) / 6;
    L8:
        if (r16 >= 0) goto L17;
        int r22 = r12 - (!r13 ? 1 : 0);
        if (r22 == 0) goto L16;
        int r23 = r11 - (r14.getMeasureInfo().f12284b * r12);
        if (r13 == false) goto L14;
        int r24 = r14.getWeekDaysHeight();
    L15:
        r16 = (r23 - r24) / r22;
        goto L17
    L14:
        r24 = 0;
        goto L15
    L16:
        r16 = 0;
    L17:
        int r25 = r5;
        int r26 = 0;
        int r27 = 0;
        int r28 = 0;
    L18:
        if (r26 >= r10) goto L29;
        View r110 = getChildAt(r26);
        int r111 = r110.getMeasuredWidth();
        int r112 = r110.getMeasuredHeight();
        int r113 = r26 % 7;
        if (r113 <= 0) goto L23;
        r27 = r27 + r15;
        r25 = r25 + r15;
    L23:
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L25;
        int r29 = r25 - r111;
        r110.layout(r29, r28, r25, r28 + r112);
        r25 = r29;
    L26:
        if (r113 != 6) goto L28;
        r28 = (r28 + r112) + r16;
        r25 = r5;
        r27 = 0;
    L28:
        r26 = r26 + 1;
        goto L18
    L25:
        int r114 = r111 + r27;
        r110.layout(r27, r28, r114, r28 + r112);
        r27 = r114;
        goto L26
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        if ((r5 instanceof f) == false) goto L12;
        f r10 = (f) r5;
        MaterialCalendarView r11 = this.e;
        y r12 = r11.f12179n;
        if (r12 == null) goto L14;
        CalendarDay r13 = r10.f12268a;
        ODatePickerView r14 = ((r) r12).f12293a;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        Intrinsics.checkNotNullParameter(r11, "widget");
        Intrinsics.checkNotNullParameter(r13, "date");
        Function1 r15 = r14.G;
        if (r15 == null) goto L15;
        r15.invoke(Long.valueOf(ODatePickerView.o(r13)));
        return true;
    L15:
        return true;
    L14:
        return true;
    L12:
        return false;
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        int r5 = View.MeasureSpec.getSize(r10);
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r11);
        if (View.MeasureSpec.getMode(r11) == 0) goto L16;
        if (r12 == 0) goto L16;
        setMeasuredDimension(r5, r13);
        int r14 = getChildCount();
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L14;
        View r16 = getChildAt(r15);
        MaterialCalendarView r17 = this.e;
        int r18 = View.MeasureSpec.makeMeasureSpec(r17.getMeasureInfo().f12283a, BasicMeasure.EXACTLY);
        if (this.f12259i == true) goto L10;
    L12:
        int r19 = View.MeasureSpec.makeMeasureSpec(r17.getMeasureInfo().f12284b, BasicMeasure.EXACTLY);
    L13:
        r16.measure(r18, r19);
        r15 = r15 + 1;
        goto L6
    L10:
        if (r15 >= 7) goto L12;
        r19 = View.MeasureSpec.makeMeasureSpec(r17.getWeekDaysHeight(), BasicMeasure.EXACTLY);
        goto L13
    L14:
        return;
    L16:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new c();
    }
}
