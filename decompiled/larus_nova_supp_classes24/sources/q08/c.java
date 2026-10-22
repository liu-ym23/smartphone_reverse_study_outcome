package q08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larksuite.component.universe_design.datepicker.impl.data.CalendarAttr;
import com.larksuite.component.universe_design.datepicker.impl.data.MonthShowMode;
import com.larksuite.component.universe_design.util.CalendarDate;
import h18.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p08.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends View {
    public CalendarDate a;
    public CalendarDate.DayOfWeek b;
    public CalendarDate c;
    public CalendarDate d;
    public MonthShowMode e;
    public final n08.b[] f;
    public int g;
    public float h;
    public float i;
    public e j;
    public final int k;
    public p08.a l;

    public static final class a {
    }

    static {
    }

    private final float getCellHeight() {
        return this.l.b();
    }

    public final void a() {
        c r0 = this;
        int r1 = b.a;
        n08.b[] r2 = r0.f;
        CalendarDate r3 = r0.a;
        CalendarDate r4 = r0.c;
        CalendarDate r5 = r0.d;
        CalendarDate.DayOfWeek r6 = r0.b;
        MonthShowMode r7 = r0.e;
        Intrinsics.checkNotNullParameter(r2, "weeks");
        Intrinsics.checkNotNullParameter(r3, "seedDate");
        Intrinsics.checkNotNullParameter(r4, "currentDate");
        Intrinsics.checkNotNullParameter(r5, "selectDate");
        Intrinsics.checkNotNullParameter(r6, "firstWeekDay");
        Intrinsics.checkNotNullParameter(r7, "monthShowMode");
        int r8 = com.larksuite.component.universe_design.util.a.a(r3.getYear(), r3.getMonth() - 1);
        int r9 = com.larksuite.component.universe_design.util.a.a(r3.getYear(), r3.getMonth());
        int r10 = r3.getYear();
        int r11 = r3.getMonth();
        Intrinsics.checkNotNullParameter(r6, "dayOfWeek");
        CalendarDate r12 = new CalendarDate();
        r12.setYear(r10);
        r12.setMonth(r11);
        r12.setMonthDay(1);
        int r13 = r12.getWeeklyDayIndex(r6);
        int r14 = 6;
        if (r7 == MonthShowMode.FIXED_SIX_ROW) goto L6;
        r14 = RangesKt.coerceAtMost(6, (int) Math.ceil(((double) (r13 + r9)) / 7.0d));
    L6:
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r15 >= r14) goto L90;
        int r17 = 0;
    L10:
        if (r17 >= 7) goto L89;
        int r19 = (r15 * 7) + r17;
        n08.a r110 = null;
        if (r19 >= r13) goto L14;
    L39:
        int r111 = r14;
        if (r19 >= r13) goto L64;
        CalendarDate r20 = new CalendarDate(r3.getYear(), r3.getMonth() - 1, r8 - ((r13 - r19) - 1), 0, 0, 0);
        if (r2[r15] != null) goto L44;
        r2[r15] = new n08.b(r15);
    L44:
        n08.b r21 = r2[r15];
        if (r21 == null) goto L49;
        n08.a[] r22 = r21.b;
        if (r22 == null) goto L49;
        r110 = r22[r17];
    L49:
        if (r110 != null) goto L55;
        int r112 = r8;
        n08.a r23 = new n08.a(r15, r17, r20, new CalendarAttr(CalendarAttr.SelectState.UN_SELECT, CalendarAttr.DateState.PAST_DATE, CalendarAttr.MonthState.LAST_MONTH));
        n08.b r24 = r2[r15];
        if (r24 == null) goto L56;
        n08.a[] r25 = r24.b;
        if (r25 == null) goto L56;
        r25[r17] = r23;
    L56:
        n08.b r26 = r2[r15];
        if (r26 == null) goto L88;
        n08.a[] r27 = r26.b;
        if (r27 == null) goto L88;
        n08.a r29 = r27[r17];
        if (r29 == null) goto L88;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r29.c = r20;
        b.b(r29, r20, r5);
        b.a(r29, r20, r4);
        CalendarAttr.MonthState r30 = CalendarAttr.MonthState.LAST_MONTH;
        CalendarAttr r31 = r29.d;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r31.c = r30;
    L88:
        r17 = r17 + 1;
        r8 = r112;
        r14 = r111;
        goto L10
    L55:
        r112 = r8;
        goto L56
    L64:
        r112 = r8;
        if (r19 < (r13 + r9)) goto L88;
        CalendarDate r32 = new CalendarDate(r3.getYear(), r3.getMonth() + 1, ((r19 - r13) - r9) + 1, 0, 0, 0);
        if (r2[r15] != null) goto L69;
        r2[r15] = new n08.b(r15);
    L69:
        n08.b r33 = r2[r15];
        if (r33 == null) goto L74;
        n08.a[] r34 = r33.b;
        if (r34 == null) goto L74;
        r110 = r34[r17];
    L74:
        if (r110 != null) goto L80;
        n08.a r35 = new n08.a(r15, r17, r32, new CalendarAttr(CalendarAttr.SelectState.UN_SELECT, CalendarAttr.DateState.FUTURE_DATE, CalendarAttr.MonthState.NEXT_MONTH));
        n08.b r36 = r2[r15];
        if (r36 == null) goto L80;
        n08.a[] r37 = r36.b;
        if (r37 == null) goto L80;
        r37[r17] = r35;
    L80:
        n08.b r38 = r2[r15];
        if (r38 == null) goto L88;
        n08.a[] r39 = r38.b;
        if (r39 == null) goto L88;
        n08.a r40 = r39[r17];
        if (r40 == null) goto L88;
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r40.c = r32;
        b.b(r40, r32, r5);
        b.a(r40, r32, r4);
        CalendarAttr.MonthState r41 = CalendarAttr.MonthState.NEXT_MONTH;
        CalendarAttr r42 = r40.d;
        r42.getClass();
        Intrinsics.checkNotNullParameter(r41, "<set-?>");
        r42.c = r41;
        goto L88
    L14:
        if (r19 >= (r13 + r9)) goto L39;
        int r113 = r16 + 1;
        CalendarDate r43 = r3.modifyDay(r113);
        if (r2[r15] != null) goto L18;
        r2[r15] = new n08.b(r15);
    L18:
        n08.b r114 = r2[r15];
        if (r114 == null) goto L23;
        n08.a[] r115 = r114.b;
        if (r115 == null) goto L23;
        r110 = r115[r17];
    L23:
        if (r110 != null) goto L29;
        Intrinsics.checkNotNull(r43);
        int r116 = r113;
        r111 = r14;
        n08.a r117 = new n08.a(r15, r17, r43, new CalendarAttr(CalendarAttr.SelectState.UN_SELECT, CalendarAttr.DateState.CURRENT_DATE, CalendarAttr.MonthState.CURRENT_MONTH));
        n08.b r44 = r2[r15];
        if (r44 == null) goto L30;
        n08.a[] r45 = r44.b;
        if (r45 == null) goto L30;
        r45[r17] = r117;
    L30:
        n08.b r46 = r2[r15];
        if (r46 == null) goto L38;
        n08.a[] r47 = r46.b;
        if (r47 == null) goto L38;
        n08.a r48 = r47[r17];
        if (r48 == null) goto L38;
        Intrinsics.checkNotNull(r43);
        Intrinsics.checkNotNullParameter(r43, "<set-?>");
        r48.c = r43;
        b.b(r48, r43, r5);
        b.a(r48, r43, r4);
        CalendarAttr.MonthState r49 = CalendarAttr.MonthState.CURRENT_MONTH;
        CalendarAttr r50 = r48.d;
        r50.getClass();
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        r50.c = r49;
    L38:
        r16 = r116;
        r112 = r8;
        goto L88
    L29:
        r111 = r14;
        r116 = r113;
        goto L30
    L89:
        r15 = r15 + 1;
        r0 = this;
        goto L7
    L90:
        r0.g = r14;
        invalidate();
    }

    public final int getCurrentHeight() {
        if (this.e != MonthShowMode.FIXED_SIX_ROW) goto L6;
        return this.l.b() * 6;
    L6:
        return this.g * this.l.b();
    }

    private final float getCellWidth() {
        return getMeasuredWidth() / 7;
    }

    public final CalendarDate getMCurrentDate() {
        return this.c;
    }

    public final p08.a getMDayRender() {
        return this.l;
    }

    public final CalendarDate.DayOfWeek getMFirstWeekDay() {
        return this.b;
    }

    public final MonthShowMode getMMonthShowMode() {
        return this.e;
    }

    public final CalendarDate getMSeedDate() {
        return this.a;
    }

    public final CalendarDate getMSelectDate() {
        return this.d;
    }

    public final int getRowNum() {
        return this.g;
    }

    public c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = new CalendarDate();
        this.b = CalendarDate.DayOfWeek.SUNDAY;
        this.c = new CalendarDate();
        this.d = new CalendarDate();
        this.e = MonthShowMode.AUTO_HEIGHT;
        this.f = new n08.b[6];
        this.k = ViewConfiguration.get(r3).getScaledTouchSlop();
        this.l = new q08.a(r3, (int) d.a(r3, 42.0f));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        int r1 = 0;
    L4:
        if (r1 >= this.g) goto L15;
        n08.b r2 = this.f[r1];
        if (r2 == null) goto L14;
        int r3 = 0;
    L9:
        if (r3 >= 7) goto L14;
        n08.a r4 = r2.b[r3];
        if (r4 == null) goto L13;
        this.l.a(r7, r4);
    L13:
        r3 = r3 + 1;
    L14:
        r1 = r1 + 1;
        goto L4
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        int r0 = r4.getAction();
        if (r0 == 0) goto L38;
        if (r0 != 1) goto L39;
        float r1 = r4.getX() - this.h;
        float r5 = r4.getY() - this.i;
        if (Math.abs(r1) >= this.k) goto L39;
        if (Math.abs(r5) >= this.k) goto L39;
        int r6 = (int) (this.h / getCellWidth());
        int r2 = (int) (this.i / getCellHeight());
        if (r6 >= 7) goto L39;
        if (r2 >= this.g) goto L39;
        n08.b r3 = this.f[r2];
        if (r3 == null) goto L39;
        n08.a[] r7 = r3.b;
        if (r7 == null) goto L39;
        n08.a r8 = r7[r6];
        if (r8 == null) goto L39;
        CalendarDate r9 = r8.c;
        this.d = r9;
        e r10 = this.j;
        if (r10 == null) goto L25;
        r10.c(r9);
    L25:
        CalendarAttr.MonthState r11 = r8.d.c;
        if (r11 != CalendarAttr.MonthState.LAST_MONTH) goto L31;
        e r12 = this.j;
        if (r12 == null) goto L39;
        r12.a(-1);
        goto L39
    L31:
        if (r11 != CalendarAttr.MonthState.NEXT_MONTH) goto L35;
        e r13 = this.j;
        if (r13 == null) goto L39;
        r13.a(1);
        goto L39
    L35:
        e r14 = this.j;
        if (r14 == null) goto L39;
        r14.b();
    L39:
        return true;
    L38:
        this.h = r4.getX();
        this.i = r4.getY();
        goto L39
    }

    public final void setCurrentDate(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        this.c = r2;
    }

    public final void setFirstWeekDay(CalendarDate.DayOfWeek r2) {
        Intrinsics.checkNotNullParameter(r2, "firstWeekDay");
        this.b = r2;
    }

    public final void setMCurrentDate(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMDayRender(p08.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final void setMFirstWeekDay(CalendarDate.DayOfWeek r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMMonthShowMode(MonthShowMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setMSeedDate(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setMSelectDate(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMonthShowMode(MonthShowMode r2) {
        Intrinsics.checkNotNullParameter(r2, "monthShowMode");
        this.e = r2;
    }

    public final void setMonthTextSize(float r2) {
        this.l.c(r2);
        invalidate();
    }

    public final void setOnMonthDayViewSelectListener(e r2) {
        Intrinsics.checkNotNullParameter(r2, "monthDayViewSelectListener");
        this.j = r2;
    }

    public final void setSeedDate(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        this.a = r2;
    }

    public final void setSelectDate(CalendarDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        this.d = r2;
    }

    public final void setTypeFace(Typeface r2) {
        Intrinsics.checkNotNullParameter(r2, "typeFace");
        this.l.setTypeFace(r2);
        invalidate();
    }
}
