package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(TextView r1) {
            super(r1);
            this.textView = r1;
        }
    }

    YearGridAdapter(MaterialCalendar<?> r1) {
        this.materialCalendar = r1;
    }

    static /* synthetic */ MaterialCalendar access$000(YearGridAdapter r0) {
        return r0.materialCalendar;
    }

    private View.OnClickListener createYearClickListener(final int r2) {
        return new AnonymousClass1(this, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    int getPositionForYear(int r1) {
        return r1 - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    int getYearForPosition(int r1) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        onBindViewHolder((ViewHolder) ZeusTransformUtils.preCheckCast(r3, ViewHolder.class, "com.obric.memorydata.plugin"), r4);
    }

    public void onBindViewHolder(ViewHolder r9, int r10) {
        int r11 = getYearForPosition(r10);
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.textView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_navigate_to_year_description, TypedValues.Custom.S_STRING, "mtrl_picker_navigate_to_year_description"));
        r9.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r11)}));
        r9.textView.setContentDescription(String.format(r0, new Object[]{Integer.valueOf(r11)}));
        b r1 = this.materialCalendar.getCalendarStyle();
        Calendar r2 = j.b();
        if (r2.get(1) != r11) goto L5;
        a r3 = r1.f;
    L6:
        Iterator<Long> r5 = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        r2.setTimeInMillis(((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r2.get(1) != r11) goto L8;
        r3 = r1.e;
        goto L8
    L12:
        r3.a(r9.textView);
        r9.textView.setOnClickListener(createYearClickListener(r11));
        return;
    L5:
        r3 = r1.d;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new ViewHolder((TextView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.mtrl_calendar_year, "layout", "mtrl_calendar_year"), r4, false, "com.obric.memorydata.plugin"), TextView.class, "com.obric.memorydata.plugin"));
    }
}
