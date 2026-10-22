package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import com.larksuite.component.universe_design.timepicker.impl.single.YearPicker;
import com.larksuite.component.universe_design.util.CalendarDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends BaseTimePickerController {
    public static final /* synthetic */ int j = 0;
    public final CalendarDate a;
    public final CalendarDate b;
    public CalendarDate c;
    public WheelView d;
    public WheelView e;
    public WheelView f;
    public String[] g;
    public int h;
    public final int i;

    public static final class a {
        public static f a(Context r20, BaseTimePickerController.PickerPanelDependency r21, CalendarDate r22, CalendarDate r23) {
            Intrinsics.checkNotNullParameter(r20, "context");
            Intrinsics.checkNotNullParameter(r21, "pickerPanelDependency");
            Intrinsics.checkNotNullParameter(r22, "beginCalendar");
            Intrinsics.checkNotNullParameter(r23, "endCalendar");
            if (r23.getJulianDay() >= r22.getJulianDay()) goto L5;
            CalendarDate r2 = new CalendarDate(1900, 1, 1, 0, 0, 0);
            CalendarDate r3 = new CalendarDate(2100, 12, 31, 0, 0, 0);
        L7:
            return new f(r20, r21, r2, r3);
        L5:
            r2 = r22;
            r3 = r23;
            goto L7
        }
    }

    static {
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        ArrayList r0 = new ArrayList();
        PickerBuilder r1 = YearPicker.INSTANCE.getPickerBuilder(this.a.getYear(), this.b.getYear(), true);
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        Context r2 = getContext();
        CalendarDate r3 = this.a;
        CalendarDate r4 = this.b;
        int r5 = this.c.getYear();
        int r6 = g18.f.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "startCalendar");
        Intrinsics.checkNotNullParameter(r4, "endCalendar");
        d18.e r7 = g18.f.a(r2, r3, r4, r5);
        if (r7 != null) goto L8;
        PickerBuilder r8 = null;
    L9:
        if (r8 == null) goto L11;
        r0.add(r8);
    L11:
        boolean r12 = getPickerPanelDependency().getPanelStyleData().getShowDayInfo();
        int r9 = g18.e.a;
        Context r10 = getContext();
        CalendarDate r11 = this.c;
        String[] r13 = this.g;
        if (r13 != null) goto L15;
        Context r14 = getContext();
        int r15 = h18.b.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        r13 = r14.getResources().getStringArray(2130903127);
        this.g = r13;
    L15:
        String[] r16 = r13;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "chooseCalendarDate");
        Intrinsics.checkNotNullParameter(r16, "weekArray");
        int r17 = r11.getYear();
        int r19 = r11.getMonth();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "weekArray");
        PickerBuilder r20 = new PickerBuilder(new d18.d(r10, r17, r19, r16, r12));
        r20.setLoop(true);
        r0.add(r20);
        return r0;
    L8:
        PickerBuilder r21 = new PickerBuilder(r7);
        r21.setLoop(true);
        r8 = r21;
        goto L9
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        ArrayList r0 = new ArrayList();
        WheelView r1 = this.d;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        WheelView r2 = this.e;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        WheelView r3 = this.f;
        if (r3 == null) goto L11;
        r0.add(r3);
    L11:
        return r0;
    }

    public static final void a(f r3) {
        WheelView r0 = r3.d;
        if (r0 == null) goto L5;
        r3.c.setYear(r3.a.getYear() + r0.getCurrentItem());
    L5:
        WheelView r1 = r3.e;
        if (r1 == null) goto L8;
        r3.c.setMonth(r3.h + r1.getCurrentItem());
    L8:
        WheelView r2 = r3.f;
        if (r2 == null) goto L12;
        r3.c.setMonthDay(r3.i + r2.getCurrentItem());
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(int r6) {
        WheelView r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = this.h + r0.getCurrentItem();
        d18.e r7 = g18.f.a(getContext(), this.a, this.b, r6);
        if (r7 != null) goto L8;
        return;
    L8:
        this.h = r7.b;
        r0.setAdapter(r7);
        int r2 = r7.getItemsCount() - 1;
        int r3 = this.h;
        if (r1 <= (r2 + r3)) goto L11;
        r1 = r7.getItemsCount() - 1;
    L13:
        r0.setCurrentItem(r1 - this.h);
        return;
    L11:
        if (r1 >= r3) goto L13;
        r1 = r3;
        goto L13
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r5) {
        Intrinsics.checkNotNullParameter(r5, "selectedDate");
        CalendarDate r0 = new CalendarDate(r5);
        int r6 = r0.getJulianDay();
        int r1 = this.a.getJulianDay();
        int r2 = this.b.getJulianDay();
        if (r6 >= r1) goto L5;
        r0.setJulianDay(r1);
    L7:
        this.c = r0;
        int r7 = r0.getYear();
        int r3 = r0.getMonth();
        int r4 = r0.getMonthDay();
        WheelView r8 = this.d;
        if (r8 == null) goto L10;
        r8.setCurrentItem(r7 - this.a.getYear());
    L10:
        b(r7);
        WheelView r9 = this.e;
        if (r9 == null) goto L13;
        r9.setCurrentItem(r3 - this.h);
    L13:
        c(r7, r3);
        WheelView r10 = this.f;
        if (r10 == null) goto L17;
        r10.setCurrentItem(r4 - this.i);
        return;
    L17:
        return;
    L5:
        if (r6 <= r2) goto L7;
        r0.setJulianDay(r2);
        goto L7
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r2) {
        if (r2 == false) goto L4;
        WheelView.DividerType r3 = WheelView.DividerType.FILL;
    L5:
        WheelView r0 = this.d;
        if (r0 == null) goto L8;
        r0.setDividerType(r3);
    L8:
        WheelView r1 = this.e;
        if (r1 == null) goto L11;
        r1.setDividerType(r3);
    L11:
        WheelView r4 = this.f;
        if (r4 == null) goto L15;
        r4.setDividerType(r3);
        return;
    L15:
        return;
    L4:
        r3 = WheelView.DividerType.NONE;
        goto L5
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemVisibleNum(int r3) {
        WheelView r0 = this.d;
        if (r0 == null) goto L5;
        r0.setItemVisible(r3 + 2);
    L5:
        WheelView r1 = this.e;
        if (r1 == null) goto L8;
        r1.setItemVisible(r3 + 2);
    L8:
        WheelView r2 = this.f;
        if (r2 == null) goto L12;
        r2.setItemVisible(r3 + 2);
        return;
    }

    public final void c(int r10, int r11) {
        WheelView r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getCurrentItem();
        boolean r8 = getPickerPanelDependency().getPanelStyleData().getShowDayInfo();
        int r2 = g18.e.a;
        Context r4 = getContext();
        String[] r3 = this.g;
        if (r3 != null) goto L9;
        Context r5 = getContext();
        int r6 = h18.b.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        r3 = r5.getResources().getStringArray(2130903127);
        this.g = r3;
    L9:
        String[] r7 = r3;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "weekArray");
        d18.d r9 = new d18.d(r4, r10, r11, r7, r8);
        r0.setAdapter(r9);
        if (r1 <= (r9.getItemsCount() - 1)) goto L12;
        r1 = r9.getItemsCount() - 1;
    L12:
        r0.setCurrentItem(r1);
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r5, List<PickerBuilder> r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "builderList");
        Iterator<T> r7 = r6.iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L28;
        Object r1 = r7.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        PickerBuilder r3 = (PickerBuilder) r1;
        if (r0 != 0) goto L11;
        this.d = TimePickerHelper.INSTANCE.createWheelView(r5, r3);
    L27:
        r0 = r2;
        goto L4
    L11:
        if (r0 != 1) goto L13;
        WheelView r4 = TimePickerHelper.INSTANCE.createWheelView(r5, r3);
        this.e = r4;
        d18.b r8 = null;
        if (r4 == null) goto L19;
        e18.a<? extends Object> r9 = r4.getAdapter();
    L21:
        if ((r9 instanceof d18.b) == false) goto L23;
        r8 = (d18.b) r9;
    L23:
        if (r8 == null) goto L27;
        this.h = r8.a;
        goto L27
    L19:
        r9 = null;
        goto L21
    L13:
        if (r0 != 2) goto L27;
        this.f = TimePickerHelper.INSTANCE.createWheelView(r5, r3);
        goto L27
    L28:
        WheelView r10 = this.d;
        if (r10 == null) goto L31;
        r10.setLabel(h18.b.a(getContext(), 2131887085, "year", ""));
    L31:
        setItemVisibleNum(getPickerPanelDependency().getPanelStyleData().getVisibleItemNum());
        setItemDividerVisibility(getPickerPanelDependency().getPanelStyleData().getItemDividerVisibility());
        i r11 = new i(this);
        h r12 = new h(this);
        g r13 = new g(this);
        WheelView r14 = this.d;
        if (r14 == null) goto L34;
        r14.setOnItemSelectedListener(r11);
    L34:
        WheelView r15 = this.e;
        if (r15 == null) goto L37;
        r15.setOnItemSelectedListener(r12);
    L37:
        WheelView r16 = this.f;
        if (r16 == null) goto L47;
        r16.setOnItemSelectedListener(r13);
        return;
    }

    public f(Context r1, BaseTimePickerController.PickerPanelDependency r2, CalendarDate r3, CalendarDate r4) {
        super(r1, r2);
        this.a = r3;
        this.b = r4;
        CalendarDate r5 = new CalendarDate(r2.getSelectedDate());
        this.c = r5;
        this.h = 1;
        this.i = 1;
        int r6 = r5.getJulianDay();
        int r7 = r3.getJulianDay();
        int r8 = r4.getJulianDay();
        if (r6 >= r7) goto L5;
        r5.setJulianDay(r7);
        return;
    L5:
        if (r6 <= r8) goto L9;
        r5.setJulianDay(r8);
        return;
    }
}
