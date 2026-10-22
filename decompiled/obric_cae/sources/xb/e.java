package xb;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.oui.calendar.CalendarDay;
import com.obric.oui.calendar.MaterialCalendarView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<r> f13794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<j> f13795b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DayOfWeek f13796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MaterialCalendarView f13798o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CalendarDay f13799p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CalendarDay f13800q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CalendarDay f13801r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f13802s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f13803t;

    public static class a extends ViewGroup.MarginLayoutParams {
        public a() {
            super(-2, -2);
        }
    }

    public e(MaterialCalendarView r8, CalendarDay r10, DayOfWeek r11, boolean r12) {
        super(r8.getContext());
        this.f13794a = new ArrayList();
        this.f13795b = new ArrayList();
        this.f13797n = 4;
        this.f13800q = null;
        this.f13801r = null;
        ArrayList r13 = new ArrayList();
        this.f13803t = r13;
        this.f13798o = r8;
        this.f13799p = r10;
        this.f13796m = r11;
        this.f13802s = r12;
        setClipChildren(false);
        setClipToPadding(false);
        if (r12 == false) goto L5;
        c(f());
    L5:
        b(r13, f());
    }

    public final void a(ArrayList r8, LocalDate r10) {
        CalendarDay r11 = CalendarDay.t(r10);
        g r12 = new g(getContext(), r11);
        r12.setOnClickListener(this);
        r12.setOnLongClickListener(this);
        r8.add(r12);
        addView(r12, new a());
    }

    public abstract void b(ArrayList r8, LocalDate r10);

    public final void c(LocalDate r8) {
        int r10 = 0;
    L4:
        if (r10 >= 7) goto L6;
        r r11 = new r(getContext(), r8.getDayOfWeek());
        r11.setImportantForAccessibility(2);
        this.f13794a.add(r11);
        addView(r11);
        r8 = r8.plusDays(1);
        r10 = r10 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        return r8 instanceof a;
    }

    public abstract int d();

    public abstract boolean e(CalendarDay r8);

    public final LocalDate f() {
        DayOfWeek r8 = this.f13796m;
        boolean r10 = true;
        LocalDate r11 = this.f13799p.u().with(WeekFields.of(r8, 1).dayOfWeek(), 1);
        int r12 = r8.getValue() - r11.getDayOfWeek().getValue();
        if (MaterialCalendarView.d(this.f13797n) == false) goto L6;
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

    public final void g(int r8) {
        Iterator r10 = this.f13803t.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((g) r10.next()).setTextAppearance(getContext(), r8);
        goto L4
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new a();
    }

    public final void h(yb.e r10) {
        Iterator r11 = this.f13803t.iterator();
    L4:
        if (r11.hasNext() == false) goto L22;
        g r8 = (g) r11.next();
        yb.e r12 = r8.f13810u;
        if (r12 != r8.f13809t) goto L8;
        r12 = r10;
    L8:
        r8.f13810u = r12;
        if (r10 != null) goto L11;
        yb.e r13 = yb.e.f14109a;
    L12:
        r8.f13809t = r13;
        CharSequence r14 = r8.getText();
        if ((r14 instanceof Spanned) == false) goto L15;
        Object[] r15 = ((Spanned) r14).getSpans(0, r14.length(), Object.class);
    L16:
        SpannableString r16 = new SpannableString(r8.b());
        if (r15 == null) goto L21;
        int r17 = r15.length;
        int r18 = 0;
    L19:
        if (r18 >= r17) goto L21;
        r16.setSpan(r15[r18], 0, r16.length(), 33);
        r18 = r18 + 1;
    L21:
        r8.setText(r16);
        goto L4
    L15:
        r15 = null;
        goto L16
    L11:
        r13 = r10;
        goto L12
    }

    public final void i(yb.e r8) {
        Iterator r10 = this.f13803t.iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        g r11 = (g) r10.next();
        if (r8 != null) goto L8;
        yb.e r12 = r11.f13809t;
    L9:
        r11.f13810u = r12;
        if (r12 != null) goto L12;
        r12 = r11.f13809t;
    L12:
        yb.c r13 = (yb.c) r12;
        r11.setContentDescription(r13.a(r11.f13804o));
        goto L4
    L8:
        r12 = r8;
        goto L9
    }

    public final void j(List<j> r10) {
        ArrayList<j> r8 = this.f13795b;
        r8.clear();
        if (r10 == null) goto L5;
        r8.addAll(r10);
    L5:
        i r11 = new i();
        Iterator r12 = this.f13803t.iterator();
    L7:
        if (r12.hasNext() == false) goto L36;
        g r13 = (g) r12.next();
        r11.f13817b = null;
        r11.f13818c = null;
        LinkedList<i.a> r14 = r11.f13819d;
        r14.clear();
        r11.f13816a = false;
        r11.f13820e = false;
        Iterator<j> r15 = r8.iterator();
    L10:
        if (r15.hasNext() == false) goto L20;
        j r16 = r15.next();
        h r17 = r16.f13821a;
        CalendarDay r18 = r13.f13804o;
        if (r17.b() == false) goto L10;
        i r19 = r16.f13822b;
        Drawable r20 = r19.f13818c;
        if (r20 == null) goto L16;
        r11.f13818c = r20;
        r11.f13816a = true;
    L16:
        Drawable r21 = r19.f13817b;
        if (r21 == null) goto L19;
        r11.f13817b = r21;
        r11.f13816a = true;
    L19:
        r14.addAll(r19.f13819d);
        r11.f13816a |= r19.f13816a;
        r11.f13820e = r19.f13820e;
        goto L10
    L20:
        r13.getClass();
        r13.f13814y = r11.f13820e;
        r13.d();
        Drawable r22 = r11.f13817b;
        if (r22 != null) goto L23;
        Drawable r23 = null;
    L24:
        r13.f13806q = r23;
        r13.invalidate();
        Drawable r24 = r11.f13818c;
        if (r24 != null) goto L27;
        Drawable r25 = null;
    L28:
        r13.f13807r = r25;
        r13.c();
        List r26 = Collections.unmodifiableList(r14);
        if (r26.isEmpty() == false) goto L30;
        r13.setText(r13.b());
        goto L7
    L30:
        String r27 = r13.b();
        SpannableString r28 = new SpannableString(r13.b());
        Iterator r29 = r26.iterator();
    L32:
        if (r29.hasNext() == false) goto L34;
        ((i.a) r29.next()).getClass();
        r28.setSpan(null, 0, r27.length(), 33);
        goto L32
    L34:
        r13.setText(r28);
        goto L7
    L27:
        r25 = r24.getConstantState().newDrawable(r13.getResources());
        goto L28
    L23:
        r23 = r22.getConstantState().newDrawable(r13.getResources());
        goto L24
    }

    public final void k(List r8) {
        Iterator r10 = this.f13803t.iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        g r11 = (g) r10.next();
        CalendarDay r12 = r11.f13804o;
        if (r8 != null) goto L8;
    L10:
        boolean r13 = false;
    L12:
        if (r11.f13813x == false) goto L4;
        r11.setChecked(r13);
        goto L4
    L8:
        if (r8.contains(r12) == false) goto L10;
        r13 = true;
        goto L12
    L14:
        postInvalidate();
    }

    public final void l(int r8) {
        Iterator r10 = this.f13803t.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        g r11 = (g) r10.next();
        r11.f13805p = r8;
        r11.c();
        goto L4
    }

    public final void m(boolean r8) {
        Iterator r10 = this.f13803t.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        g r11 = (g) r10.next();
        if (r8 == false) goto L8;
        e r12 = this;
    L9:
        r11.setOnClickListener(r12);
        r11.setClickable(r8);
        goto L4
    L8:
        r12 = null;
        goto L9
    }

    public final void n(int r8) {
        this.f13797n = r8;
        q();
    }

    public final void o(yb.g r8) {
        Iterator<r> r10 = this.f13794a.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        r r11 = r10.next();
        r11.getClass();
        if (r8 != null) goto L8;
        yb.g r12 = yb.g.f14111a;
    L9:
        r11.f13837q = r12;
        DayOfWeek r13 = r11.f13838r;
        r11.f13838r = r13;
        r11.setText(r12.a(r13));
        goto L4
    L8:
        r12 = r8;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        if ((r10 instanceof g) == false) goto L46;
        g r11 = (g) r10;
        MaterialCalendarView r8 = this.f13798o;
        CalendarDay r12 = r8.getCurrentDate();
        CalendarDay r13 = r11.f13804o;
        int r14 = r12.w();
        int r15 = r13.w();
        if (r8.f6219s == b.f13771b) goto L7;
    L25:
        CalendarDay r16 = r11.f13804o;
        boolean r17 = !r11.isChecked();
        int r18 = r8.C;
        if (r18 != 2) goto L28;
    L44:
        r8.f6216p.n(r16, r17);
        return;
    L28:
        if (r18 == 3) goto L30;
        d<?> r19 = r8.f6216p;
        r19.f13786m.clear();
        r19.j();
        r8.f6216p.n(r16, true);
        return;
    L30:
        List<CalendarDay> r20 = r8.f6216p.g();
        if (r20.size() == 0) goto L44;
        if (r20.size() != 1) goto L43;
        CalendarDay r21 = r20.get(0);
        if (r21.equals(r16) == true) goto L44;
        if (r21.y(r16) == false) goto L41;
        r8.f6216p.m(r16, r21);
    L42:
        r8.f6216p.g();
        return;
    L41:
        r8.f6216p.m(r21, r16);
        goto L42
    L43:
        d<?> r22 = r8.f6216p;
        r22.f13786m.clear();
        r22.j();
        goto L44
    L7:
        if (r8.D == false) goto L25;
        if (r14 == r15) goto L25;
        boolean r23 = r12.y(r13);
        c r24 = r8.f6215o;
        if (r23 == false) goto L18;
        if (r24.getCurrentItem() <= 0) goto L14;
        boolean r25 = true;
    L15:
        if (r25 == false) goto L25;
        r24.t(r24.getCurrentItem() - 1, true);
        goto L25
    L14:
        r25 = false;
        goto L15
    L18:
        if (r12.z(r13) == false) goto L25;
        if (r24.getCurrentItem() >= (r8.f6216p.a() - 1)) goto L22;
        boolean r26 = true;
    L23:
        if (r26 == false) goto L25;
        r24.t(r24.getCurrentItem() + 1, true);
        goto L25
    L22:
        r26 = false;
        goto L23
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r8) {
        super.onInitializeAccessibilityEvent(r8);
        r8.setClassName(e.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        r8.setClassName(e.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getWidth();
        int r16 = getChildCount();
        int r8 = r15;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
    L3:
        if (r17 >= r16) goto L18;
        View r20 = getChildAt(r17);
        int r21 = r20.getMeasuredWidth();
        int r22 = r20.getMeasuredHeight();
        int r23 = r17 % 7;
        MaterialCalendarView r24 = this.f13798o;
        if (r23 <= 0) goto L7;
        r18 = r18 + r24.getTileHSpacing();
        r8 = r8 + r24.getTileHSpacing();
    L7:
        Locale r25 = Locale.getDefault();
        int r26 = h0.f.f7891a;
        boolean r27 = true;
        if (h0.f.a.a(r25) == 1) goto L11;
        r27 = false;
    L11:
        if (r27 == false) goto L13;
        int r28 = r8 - r21;
        r20.layout(r28, r19, r8, r19 + r22);
        r8 = r28;
    L15:
        if (r23 != 6) goto L17;
        r19 = (r19 + r22) + r24.getTileVSpacing();
        r8 = r15;
        r18 = 0;
    L17:
        r17 = r17 + 1;
        goto L3
    L13:
        int r29 = r21 + r18;
        r20.layout(r18, r19, r29, r19 + r22);
        r18 = r29;
        goto L15
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r8) {
        if ((r8 instanceof g) == false) goto L6;
        g r10 = (g) r8;
        this.f13798o.getClass();
        return true;
    L6:
        return false;
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r10) {
        int r11 = View.MeasureSpec.getSize(r8);
        int r12 = View.MeasureSpec.getMode(r8);
        int r13 = View.MeasureSpec.getSize(r10);
        if (View.MeasureSpec.getMode(r10) == 0) goto L10;
        if (r12 == 0) goto L10;
        int r14 = r11 / 7;
        int r15 = r13 / d();
        int r16 = 0;
        int r17 = Math.max(0, d() - 1);
        MaterialCalendarView r18 = this.f13798o;
        setMeasuredDimension(r11, (r18.getTileVSpacing() * r17) + r13);
        int r19 = getChildCount();
    L6:
        if (r16 >= r19) goto L8;
        getChildAt(r16).measure(View.MeasureSpec.makeMeasureSpec(r18.getTileWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r15, 1073741824));
        r16 = r16 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    public final void p(int r8) {
        Iterator<r> r10 = this.f13794a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().setTextAppearance(getContext(), r8);
        goto L4
    }

    public final void q() {
        Iterator r8 = this.f13803t.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        g r10 = (g) r8.next();
        CalendarDay r11 = r10.f13804o;
        int r12 = this.f13797n;
        CalendarDay r13 = this.f13800q;
        CalendarDay r14 = this.f13801r;
        r11.getClass();
        if (r13 != null) goto L8;
    L9:
        if (r14 != null) goto L11;
    L14:
        boolean r15 = true;
    L15:
        boolean r16 = e(r11);
        r10.f13815z = r12;
        r10.f13812w = r16;
        r10.f13811v = r15;
        r10.d();
        goto L4
    L11:
        if (r14.z(r11) == false) goto L14;
    L13:
        r15 = false;
        goto L15
    L8:
        if (r13.y(r11) == true) goto L13;
    L16:
        postInvalidate();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return new a();
    }
}
