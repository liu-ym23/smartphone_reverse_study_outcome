package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final CalendarConstraints calendarConstraints;
    private final DateSelector<?> dateSelector;
    private final int itemHeight;
    private final MaterialCalendar.a onDayClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        ViewHolder(LinearLayout r6, boolean r7) {
            super(r6);
            TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.month_title, OaidModel.KEY_ID, "month_title")), TextView.class, "com.obric.memorydata.plugin");
            this.monthTitle = r0;
            ViewCompat.setAccessibilityHeading(r0, true);
            this.monthGrid = (MaterialCalendarGridView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.month_grid, OaidModel.KEY_ID, "month_grid")), MaterialCalendarGridView.class, "com.obric.memorydata.plugin");
            if (r7 == true) goto L6;
            r0.setVisibility(8);
            return;
        }
    }

    MonthsPagerAdapter(Context r4, DateSelector<?> r5, CalendarConstraints r6, MaterialCalendar.a r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        DateSelector<?> r9 = (DateSelector) ZeusTransformUtils.wrapperContextForParams(r5, DateSelector.class, "com.obric.memorydata.plugin");
        MaterialCalendar.a r10 = (MaterialCalendar.a) ZeusTransformUtils.wrapperContextForParams(r7, MaterialCalendar.a.class, "com.obric.memorydata.plugin");
        Month r0 = r6.getStart();
        Month r1 = r6.getEnd();
        Month r2 = r6.getOpenAt();
        if (r0.compareTo2(r2) > 0) goto L15;
        if (r2.compareTo2(r1) > 0) goto L13;
        int r3 = g.f3891a * MaterialCalendar.getDayHeight(r8);
        if (MaterialDatePicker.isFullscreen(r8) == false) goto L9;
        int r11 = MaterialCalendar.getDayHeight(r8);
    L10:
        this.itemHeight = r3 + r11;
        this.calendarConstraints = r6;
        this.dateSelector = r9;
        this.onDayClickListener = r10;
        setHasStableIds(true);
        return;
    L9:
        r11 = 0;
        goto L10
    L13:
        throw new IllegalArgumentException("currentPage cannot be after lastPage");
    L15:
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    static /* synthetic */ MaterialCalendar.a access$000(MonthsPagerAdapter r0) {
        return r0.onDayClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r1) {
        return this.calendarConstraints.getStart().monthsLater(r1).getStableId();
    }

    Month getPageMonth(int r1) {
        return this.calendarConstraints.getStart().monthsLater(r1);
    }

    CharSequence getPageTitle(int r1) {
        return getPageMonth(r1).getLongName();
    }

    int getPosition(Month r1) {
        return this.calendarConstraints.getStart().monthsUntil(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        onBindViewHolder((ViewHolder) ZeusTransformUtils.preCheckCast(r3, ViewHolder.class, "com.obric.memorydata.plugin"), r4);
    }

    public void onBindViewHolder(ViewHolder r4, int r5) {
        Month r6 = this.calendarConstraints.getStart().monthsLater(r5);
        r4.monthTitle.setText(r6.getLongName());
        final MaterialCalendarGridView r7 = (MaterialCalendarGridView) ZeusTransformUtils.preCheckCast(r4.monthGrid.findViewById(ZeusTransformUtils.mapRes(R.id.month_grid, OaidModel.KEY_ID, "month_grid")), MaterialCalendarGridView.class, "com.obric.memorydata.plugin");
        if (r7.a() != null) goto L5;
    L7:
        g r0 = new g(r6, this.dateSelector, this.calendarConstraints);
        r7.setNumColumns(r6.daysInWeek);
        r7.setAdapter(r0);
    L8:
        r7.setOnItemClickListener(new AnonymousClass1(this, r7));
        return;
    L5:
        if (r6.equals(r7.a().f3892b) == false) goto L7;
        r7.invalidate();
        r7.a().a(r7);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_month_labeled, "layout", "mtrl_calendar_month_labeled"), r5, false, "com.obric.memorydata.plugin"), LinearLayout.class, "com.obric.memorydata.plugin");
        if (MaterialDatePicker.isFullscreen((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L7;
        r7.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(r7, true);
    L7:
        return new ViewHolder(r7, false);
    }
}
