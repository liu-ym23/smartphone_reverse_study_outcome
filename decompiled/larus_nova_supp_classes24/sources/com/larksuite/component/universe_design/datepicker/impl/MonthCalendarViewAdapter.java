package com.larksuite.component.universe_design.datepicker.impl;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.datepicker.impl.infinite.InfinitePagerAdapter;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m08.a;
import p08.b;
import p08.d;
import q08.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/MonthCalendarViewAdapter;", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePagerAdapter;", "context", "Landroid/content/Context;", "monthViewDataFetcher", "Lcom/larksuite/component/universe_design/datepicker/impl/listener/IMonthViewDataFetcher;", "<init>", "(Landroid/content/Context;Lcom/larksuite/component/universe_design/datepicker/impl/listener/IMonthViewDataFetcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "monthViewStateChangeListener", "Lcom/larksuite/component/universe_design/datepicker/impl/listener/IMonthViewStateChangeListener;", "onInstantiateItem", "Landroid/view/View;", "position", "", "initMonthViewDate", "", "monthView", "Lcom/larksuite/component/universe_design/datepicker/impl/monthview/MonthView;", "setMonthViewStateChangeListener", "afterInstantiateItem", "refreshPage", "pageIndex", "updateSelectState", "updateAllViews", "getSelectedDate", "Lcom/larksuite/component/universe_design/util/CalendarDate;", "getPreviousStartDate", "getFollowingStartDate", "setTypeFace", "typeFace", "Landroid/graphics/Typeface;", "setMonthDateTextSize", "textSize", "", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MonthCalendarViewAdapter extends InfinitePagerAdapter {
    public final Context c;
    public final b d;
    public d e;

    @Override // com.larksuite.component.universe_design.datepicker.impl.infinite.InfinitePagerAdapter
    public final void f() {
    }

    public final void i() {
        int r0 = 0;
    L4:
        if (r0 >= 3) goto L17;
        c r1 = (c) g(r0);
        if (r1 == null) goto L16;
        CalendarDate r2 = this.d.getSelectedDate();
        if (r0 <= 0) goto L11;
        int r3 = r0 - 1;
    L12:
        CalendarDate r4 = r2.modifyMonth(r3);
        if (r4 == null) goto L16;
        r4.setMonthDay(1);
        r1.setSeedDate(r4);
        r1.setSelectDate(this.d.getSelectedDate());
        r1.setCurrentDate(this.d.a());
        r1.setFirstWeekDay(this.d.c());
        r1.setMonthShowMode(this.d.b());
        r1.a();
        goto L16
    L11:
        r3 = -1;
    L16:
        r0 = r0 + 1;
        goto L4
    }

    public final Context getContext() {
        return this.c;
    }

    public final View h(int r4) {
        c r0 = new c(this.c);
        CalendarDate r1 = this.d.getSelectedDate();
        if (r4 <= 0) goto L5;
        int r5 = r4 - 1;
    L6:
        CalendarDate r6 = r1.modifyMonth(r5);
        r6.setMonthDay(1);
        Intrinsics.checkNotNull(r6);
        r0.setSeedDate(r6);
        r0.setSelectDate(this.d.getSelectedDate());
        r0.setCurrentDate(this.d.a());
        r0.setFirstWeekDay(this.d.c());
        r0.setMonthShowMode(this.d.b());
        r0.setOnMonthDayViewSelectListener(new a(this));
        r0.a();
        return r0;
    L5:
        r5 = -1;
        goto L6
    }

    public MonthCalendarViewAdapter(Context r7, k08.b r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "monthViewDataFetcher");
        super(r7);
        this.c = r7;
        this.d = r8;
        this.b = new o08.a[]{new o08.a(this.a, h(0)), new o08.a(this.a, h(1)), new o08.a(this.a, h(2))};
    }
}
