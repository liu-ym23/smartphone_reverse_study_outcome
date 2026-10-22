package com.larksuite.component.universe_design.timepicker.impl.panel;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import com.larksuite.component.universe_design.timepicker.impl.helper.UtcDates;
import com.larksuite.component.universe_design.util.CalendarDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends BaseTimePickerController {
    public static final /* synthetic */ int e = 0;
    public final CalendarDate a;
    public final CalendarDate b;
    public WheelView c;
    public CalendarDate d;

    public static final class a {
        public a() {
        }

        public static d a(Context r10, BaseTimePickerController.PickerPanelDependency r11) {
            int r0 = d.e;
            UtcDates r8 = UtcDates.INSTANCE;
            CalendarDate r1 = new CalendarDate(r8.getCalendar(2010, 1, 1, 0, 0, 0));
            CalendarDate r9 = new CalendarDate(r8.getCalendar(2100, 1, 1, 0, 0, 0));
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "pickerPanelDependency");
            Intrinsics.checkNotNullParameter(r1, "beginCalendar");
            Intrinsics.checkNotNullParameter(r9, "endCalendar");
            if (r9.getJulianDay() >= r1.getJulianDay()) goto L6;
            r1 = new CalendarDate(r8.getCalendar(2010, 1, 1, 0, 0, 0));
            r9 = new CalendarDate(r8.getCalendar(2100, 1, 1, 0, 0, 0));
        L6:
            return new d(r10, r11, r1, r9);
        }
    }

    static {
        new a();
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<PickerBuilder> getPickerBuilderList() {
        ArrayList r0 = new ArrayList();
        int r1 = g18.b.a;
        Context r2 = getContext();
        CalendarDate r3 = this.a;
        CalendarDate r4 = this.b;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "beginCalendar");
        if (r4 == null) goto L5;
        int r5 = r4.getJulianDay();
    L6:
        int r6 = r3.getJulianDay();
        if (r5 <= r6) goto L9;
        int r7 = r5 - r6;
    L10:
        PickerBuilder r8 = new PickerBuilder(new d18.c(r2, r3, r7, r2.getResources().getStringArray(2130903127)));
        r8.setShowTwoFigure(true);
        r0.add(r8);
        return r0;
    L9:
        r7 = 22000;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final List<WheelView> getPickerViewList() {
        ArrayList r0 = new ArrayList();
        WheelView r1 = this.c;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        return r0;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setCurrentDate(Calendar r3) {
        Intrinsics.checkNotNullParameter(r3, "selectedDate");
        CalendarDate r0 = new CalendarDate(r3);
        this.d = r0;
        WheelView r4 = this.c;
        if (r4 == null) goto L6;
        r4.setCurrentItem(r0.getJulianDay() - this.a.getJulianDay());
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemDividerVisibility(boolean r2) {
        if (r2 == false) goto L4;
        WheelView.DividerType r3 = WheelView.DividerType.FILL;
    L5:
        WheelView r0 = this.c;
        if (r0 == null) goto L9;
        r0.setDividerType(r3);
        return;
    L9:
        return;
    L4:
        r3 = WheelView.DividerType.NONE;
        goto L5
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void setItemVisibleNum(int r2) {
        WheelView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setItemVisible(r2 + 2);
    L5:
        WheelView r3 = this.c;
        if (r3 == null) goto L9;
        r3.invalidate();
        return;
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController
    public final void create(Context r2, List<PickerBuilder> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "builderList");
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        PickerBuilder r4 = (PickerBuilder) ListProtector.get(r3, 0);
        this.c = TimePickerHelper.INSTANCE.createWheelView(r2, r4);
        setItemVisibleNum(getPickerPanelDependency().getPanelStyleData().getVisibleItemNum());
        setItemDividerVisibility(getPickerPanelDependency().getPanelStyleData().getItemDividerVisibility());
        e r5 = new e(this);
        WheelView r6 = this.c;
        if (r6 == null) goto L9;
        r6.setOnItemSelectedListener(r5);
        return;
    }

    public d(Context r1, BaseTimePickerController.PickerPanelDependency r2, CalendarDate r3, CalendarDate r4) {
        super(r1, r2);
        this.a = r3;
        this.b = r4;
        this.d = new CalendarDate(r2.getSelectedDate());
    }
}
