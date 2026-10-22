package com.larus.common_ui.widget.datepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002TUB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0002J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010-J\"\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0016J\u0010\u00103\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010 J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u000201H\u0002J\u0006\u00107\u001a\u000208J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u000201J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010D\u001a\u000201J\u0010\u0010F\u001a\u00020&2\b\u0010G\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010H\u001a\u00020&2\b\u0010I\u001a\u0004\u0018\u00010\u001cJ$\u0010J\u001a\u00020&2\b\b\u0002\u0010K\u001a\u00020*2\b\b\u0002\u0010L\u001a\u00020*2\b\b\u0002\u0010M\u001a\u00020*J\u000e\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020PJ\u001a\u0010Q\u001a\u00020&2\b\b\u0001\u0010R\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u001cJ\b\u0010S\u001a\u00020&H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u00109\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0011\u0010>\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b?\u0010;¨\u0006V"}, d2 = {"Lcom/larus/common_ui/widget/datepicker/DatePicker;", "Landroid/widget/LinearLayout;", "Lcom/larus/common_ui/widget/datepicker/NumberPicker$OnValueChangeListener;", "Lcom/larus/common_ui/widget/datepicker/IPickerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "yearPicker", "Lcom/larus/common_ui/widget/datepicker/NumberPicker;", "getYearPicker", "()Lcom/larus/common_ui/widget/datepicker/NumberPicker;", "setYearPicker", "(Lcom/larus/common_ui/widget/datepicker/NumberPicker;)V", "monthPicker", "getMonthPicker", "setMonthPicker", "dayOfMonthPicker", "getDayOfMonthPicker", "setDayOfMonthPicker", "container", "getContainer", "()Landroid/widget/LinearLayout;", "setContainer", "(Landroid/widget/LinearLayout;)V", "dpCalendar", "Ljava/util/Calendar;", "dpUpperBoundDate", "dpLowerBoundDate", "dpOnDateChangedListener", "Lcom/larus/common_ui/widget/datepicker/DatePicker$OnDateChangedListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "inflateViewAndInitialize", "", "init", "setNonRecurrentForYear", "isNonRecurrent", "", "setDate", "date", "Ljava/util/Date;", "onValueChange", "picker", "oldVal", "", "newVal", "setOnDateChangedListener", "l", "notifyDateChanged", "which", "getTimestamp", "", "year", "getYear", "()I", "month", "getMonth", "dayOfMonth", "getDayOfMonth", "setTextSize", "textSize", "", "setTextColor", "color", "setBackground", "setUpperBoundDate", "upperBoundDate", "setLowerBoundDate", "lowerBoundDate", "setPickerVisible", "yearVisible", "monthVisible", "dayVisible", "setPickerOrder", "pattern", "", "initDate", "defaultTime", "updateContentDescription", "OnDateChangedListener", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DatePicker extends LinearLayout implements NumberPicker.c {
    public static final /* synthetic */ int j = 0;
    public NumberPicker a;
    public NumberPicker b;
    public NumberPicker c;
    public LinearLayout d;
    public Calendar e;
    public Calendar f;
    public Calendar g;
    public b h;
    public final LayoutInflater i;

    public static final class a {
    }

    public interface b {
        void a();
    }

    static {
    }

    public final int getDayOfMonth() {
        return this.e.get(5);
    }

    public final int getMonth() {
        return this.e.get(2) + 1;
    }

    public final long getTimestamp() {
        return new Date(this.e.getTime().getYear(), this.e.getTime().getMonth(), this.e.getTime().getDate(), 0, 0).getTime();
    }

    public final int getYear() {
        return this.e.get(1);
    }

    public final LinearLayout getContainer() {
        return this.d;
    }

    public final NumberPicker getDayOfMonthPicker() {
        return this.c;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.i;
    }

    public final NumberPicker getMonthPicker() {
        return this.b;
    }

    public final NumberPicker getYearPicker() {
        return this.a;
    }

    public DatePicker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void c(Date r5) {
        this.e.setTime(r5);
        NumberPicker r6 = this.c;
        if (r6 == null) goto L5;
        r6.d(this.e.getActualMaximum(5));
    L5:
        NumberPicker r7 = this.a;
        if (r7 == null) goto L8;
        r7.q = this.e.get(1);
        r7.f();
        r7.c();
        r7.invalidate();
    L8:
        NumberPicker r8 = this.b;
        if (r8 == null) goto L11;
        r8.q = this.e.get(2) + 1;
        r8.f();
        r8.c();
        r8.invalidate();
    L11:
        NumberPicker r9 = this.c;
        if (r9 == null) goto L15;
        r9.q = this.e.get(5);
        r9.f();
        r9.c();
        r9.invalidate();
        return;
    }

    public final void setContainer(LinearLayout r1) {
        this.d = r1;
    }

    public final void setDayOfMonthPicker(NumberPicker r1) {
        this.c = r1;
    }

    public final void setLowerBoundDate(Calendar r5) {
        if (r5 == null) goto L17;
        this.g = r5;
        NumberPicker r0 = this.a;
        if (r0 == null) goto L7;
        r0.e(r5.get(1));
    L7:
        if (this.e.get(1) != r5.get(1)) goto L18;
        NumberPicker r1 = this.b;
        if (r1 == null) goto L12;
        r1.e(r5.get(2) + 1);
    L12:
        if (this.e.get(2) != r5.get(2)) goto L19;
        NumberPicker r2 = this.c;
        if (r2 == null) goto L20;
        r2.e(r5.get(5));
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void setMonthPicker(NumberPicker r1) {
        this.b = r1;
    }

    public final void setNonRecurrentForYear(boolean r2) {
        NumberPicker r0 = this.a;
        if (r0 == null) goto L6;
        r0.setNonRecurrent(r2);
        return;
    }

    public final void setPickerOrder(String r4) {
        Intrinsics.checkNotNullParameter(r4, "pattern");
        if (r4.length() == 3) goto L5;
        return;
    L5:
        LinearLayout r0 = this.d;
        if (r0 == null) goto L8;
        r0.removeView(this.a);
        r0.removeView(this.b);
        r0.removeView(this.c);
    L8:
        int r1 = 0;
    L10:
        if (r1 >= r4.length()) goto L34;
        char r2 = r4.charAt(r1);
        if (r2 != 'D') goto L14;
    L30:
        LinearLayout r3 = this.d;
        if (r3 == null) goto L33;
        r3.addView(this.c);
    L33:
        r1 = r1 + 1;
        goto L10
    L14:
        if (r2 != 'M') goto L16;
    L27:
        LinearLayout r5 = this.d;
        if (r5 == null) goto L33;
        r5.addView(this.b);
        goto L33
    L16:
        if (r2 != 'Y') goto L18;
    L24:
        LinearLayout r6 = this.d;
        if (r6 == null) goto L33;
        r6.addView(this.a);
        goto L33
    L18:
        if (r2 == 'd') goto L30;
        if (r2 == 'm') goto L27;
        if (r2 == 'y') goto L24;
    L34:
        requestLayout();
    }

    public final void setUpperBoundDate(Calendar r4) {
        if (r4 != null) goto L4;
        Calendar r0 = Calendar.getInstance();
    L5:
        this.f = r0;
        if (r4 == null) goto L21;
        NumberPicker r5 = this.a;
        if (r5 == null) goto L11;
        r5.d(r0.get(1));
    L11:
        if (this.e.get(1) != this.f.get(1)) goto L22;
        NumberPicker r6 = this.b;
        if (r6 == null) goto L16;
        r6.d(this.f.get(2) + 1);
    L16:
        if (this.e.get(2) != this.f.get(2)) goto L23;
        NumberPicker r7 = this.c;
        if (r7 == null) goto L24;
        r7.d(this.f.get(5));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L4:
        r0 = r4;
        goto L5
    }

    public final void setYearPicker(NumberPicker r1) {
        this.a = r1;
    }

    public DatePicker(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.e = Calendar.getInstance();
        this.f = Calendar.getInstance();
        Object r5 = r3.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater r6 = (LayoutInflater) r5;
        this.i = r6;
        r6.inflate(2131561803, this, true);
        this.d = (LinearLayout) findViewById(2131381930);
        this.a = (NumberPicker) findViewById(2131393410);
        this.b = (NumberPicker) findViewById(2131380276);
        NumberPicker r7 = (NumberPicker) findViewById(2131368559);
        this.c = r7;
        NumberPicker r8 = this.a;
        if (r8 == null) goto L5;
        r8.O = this;
    L5:
        NumberPicker r1 = this.b;
        if (r1 == null) goto L8;
        r1.O = this;
    L8:
        if (r7 == null) goto L10;
        r7.O = this;
    L10:
        if (r8 == null) goto L15;
        Integer r9 = 1;
        if (r9 == null) goto L15;
        r8.G = ViewConfiguration.get(r8.getContext()).getScaledMaximumFlingVelocity() / r9.intValue();
        r8.V = true;
    L15:
        String[] r10 = getResources().getStringArray(2130903058);
        NumberPicker r11 = this.b;
        if (r11 == null) goto L18;
        r11.S = r10;
        r11.f();
        r11.invalidate();
    L18:
        Calendar r12 = Calendar.getInstance();
        this.e = r12;
        c(r12.getTime());
        NumberPicker r13 = this.a;
        if (r13 == null) goto L21;
        r13.d(this.e.get(1));
    L21:
        NumberPicker r14 = this.a;
        if (r14 == null) goto L24;
        r14.setContentDescription("year");
    L24:
        NumberPicker r15 = this.b;
        if (r15 == null) goto L27;
        r15.setContentDescription("month");
    L27:
        NumberPicker r16 = this.c;
        if (r16 == null) goto L31;
        r16.setContentDescription("day");
        return;
    }

    @Override // com.larus.common_ui.widget.datepicker.NumberPicker.c
    public final void a(NumberPicker r10, int r11) {
        boolean r5 = false;
        if (Intrinsics.areEqual(r10, this.a) == false) goto L76;
        Calendar r12 = this.g;
        if (r12 != null) goto L7;
    L50:
        int r13 = this.e.get(5);
        int r0 = this.e.get(2);
        Calendar r1 = this.f;
        if (r1 != null) goto L53;
    L60:
        NumberPicker r2 = this.b;
        if (r2 == null) goto L63;
        r2.d(this.e.getActualMaximum(2) + 1);
    L63:
        this.e.set(r11, r0, 1);
        int r3 = this.e.getActualMaximum(5);
        Calendar r6 = this.f;
        if (r6 != null) goto L66;
    L70:
        if (r13 <= r3) goto L72;
        r13 = r3;
    L72:
        this.e.set(5, r13);
        NumberPicker r14 = this.c;
        if (r14 == null) goto L120;
        r14.d(r3);
    L120:
        b r15 = this.h;
        if (r15 == null) goto L124;
        getYear();
        getMonth();
        getDayOfMonth();
        r15.a();
        return;
    L124:
        return;
    L66:
        if (r11 != r6.get(1)) goto L70;
        if (r0 != this.f.get(2)) goto L70;
        r3 = this.f.get(5);
        goto L70
    L53:
        if (r11 != r1.get(1)) goto L60;
        if (r0 <= this.f.get(2)) goto L57;
        r0 = this.f.get(2);
    L57:
        NumberPicker r4 = this.b;
        if (r4 == null) goto L63;
        r4.d(this.f.get(2) + 1);
        goto L63
    L7:
        if (r11 != r12.get(1)) goto L9;
        boolean r7 = true;
    L10:
        NumberPicker r8 = this.b;
        if (r8 == null) goto L18;
        if (r7 == true) goto L14;
    L16:
        boolean r9 = false;
    L17:
        r8.setNonRecurrent(r9);
        goto L18
    L14:
        if (r12.get(2) == 0) goto L16;
        r9 = true;
    L18:
        NumberPicker r16 = this.b;
        if (r16 == null) goto L24;
        if (r7 == false) goto L22;
        int r17 = r12.get(2) + 1;
    L23:
        r16.e(r17);
        goto L24
    L22:
        r17 = 1;
    L24:
        if (r7 == true) goto L26;
    L28:
        if (r7 == true) goto L30;
    L32:
        boolean r18 = false;
    L33:
        NumberPicker r20 = this.c;
        if (r20 == null) goto L40;
        if (r18 == true) goto L37;
    L39:
        r20.setNonRecurrent(r5);
        goto L40
    L37:
        if (r12.get(5) <= 20) goto L39;
        r5 = true;
    L40:
        NumberPicker r21 = this.c;
        if (r21 == null) goto L46;
        if (r18 == false) goto L44;
        int r22 = r12.get(5);
    L45:
        r21.e(r22);
        goto L46
    L44:
        r22 = 1;
    L46:
        if (r18 == false) goto L50;
        if (this.e.get(5) >= r12.get(5)) goto L50;
        this.e.set(5, r12.get(5));
        goto L50
    L30:
        if (this.e.get(2) != r12.get(2)) goto L32;
        r18 = true;
        goto L33
    L26:
        if (this.e.get(2) >= r12.get(2)) goto L28;
        int r23 = this.e.get(5);
        this.e.set(5, 1);
        this.e.set(2, r12.get(2));
        this.e.set(5, Math.min(r23, this.e.getActualMaximum(5)));
        goto L28
    L9:
        r7 = false;
        goto L10
    L76:
        if (Intrinsics.areEqual(r10, this.b) == false) goto L118;
        Calendar r110 = this.g;
        if (r110 != null) goto L80;
    L105:
        int r111 = this.e.get(5);
        Calendar r24 = this.e;
        int r112 = r11 - 1;
        r24.set(r24.get(1), r112, 1);
        int r25 = this.e.getActualMaximum(5);
        if (this.f != null) goto L108;
    L112:
        if (r111 <= r25) goto L114;
        r111 = r25;
    L114:
        this.e.set(5, r111);
        NumberPicker r113 = this.c;
        if (r113 == null) goto L120;
        r113.d(r25);
        goto L120
    L108:
        if (this.e.get(1) != this.f.get(1)) goto L112;
        if (r112 != this.f.get(2)) goto L112;
        r25 = this.f.get(5);
        goto L112
    L80:
        if (this.e.get(1) != r110.get(1)) goto L82;
        boolean r26 = true;
    L83:
        if (r26 == true) goto L85;
    L87:
        boolean r27 = false;
    L88:
        NumberPicker r28 = this.c;
        if (r28 == null) goto L95;
        if (r27 == true) goto L92;
    L94:
        r28.setNonRecurrent(r5);
        goto L95
    L92:
        if (r110.get(5) <= 20) goto L94;
        r5 = true;
    L95:
        NumberPicker r30 = this.c;
        if (r30 == null) goto L101;
        if (r27 == false) goto L99;
        int r31 = r110.get(5);
    L100:
        r30.e(r31);
        goto L101
    L99:
        r31 = 1;
    L101:
        if (r27 == false) goto L105;
        if (this.e.get(5) >= r110.get(5)) goto L105;
        this.e.set(5, r110.get(5));
        goto L105
    L85:
        if ((r11 - 1) != r110.get(2)) goto L87;
        r27 = true;
        goto L88
    L82:
        r26 = false;
        goto L83
    L118:
        if (Intrinsics.areEqual(r10, this.c) == false) goto L120;
        this.e.set(5, r11);
        goto L120
    }

    public final void b(Date r2, Calendar r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultTime");
        setNonRecurrentForYear(true);
        c(r2);
        setUpperBoundDate(r3);
    }
}
