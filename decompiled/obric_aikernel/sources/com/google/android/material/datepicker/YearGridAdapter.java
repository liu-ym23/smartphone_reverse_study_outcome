package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(TextView r10) {
            super(r10);
            this.textView = r10;
        }
    }

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3193c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ YearGridAdapter f3194g;

        a(YearGridAdapter r10, int r11) {
            this.f3194g = r10;
            this.f3193c = r11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            Month r11 = Month.create(this.f3193c, YearGridAdapter.access$000(this.f3194g).getCurrentMonth().month);
            Month r12 = YearGridAdapter.access$000(this.f3194g).getCalendarConstraints().clamp(r11);
            YearGridAdapter.access$000(this.f3194g).setCurrentMonth(r12);
            YearGridAdapter.access$000(this.f3194g).setSelector(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    YearGridAdapter(MaterialCalendar<?> r10) {
        this.materialCalendar = r10;
    }

    static /* synthetic */ MaterialCalendar access$000(YearGridAdapter r10) {
        return r10.materialCalendar;
    }

    @NonNull
    private View.OnClickListener createYearClickListener(int r10) {
        return new a(this, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    int getPositionForYear(int r10) {
        return r10 - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    int getYearForPosition(int r10) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((ViewHolder) r10, r11);
    }

    public void onBindViewHolder(@NonNull ViewHolder r10, int r11) {
        int r12 = getYearForPosition(r11);
        String r13 = r10.textView.getContext().getString(q5.j.mtrl_picker_navigate_to_year_description);
        r10.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r12)}));
        r10.textView.setContentDescription(String.format(r13, new Object[]{Integer.valueOf(r12)}));
        b r14 = this.materialCalendar.getCalendarStyle();
        Calendar r15 = j.o();
        if (r15.get(1) != r12) goto L5;
        com.google.android.material.datepicker.a r16 = r14.f3206f;
    L6:
        Iterator<Long> r17 = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
    L8:
        if (r17.hasNext() == false) goto L12;
        r15.setTimeInMillis(r17.next().longValue());
        if (r15.get(1) != r12) goto L8;
        r16 = r14.f3205e;
        goto L8
    L12:
        r16.d(r10.textView);
        r10.textView.setOnClickListener(createYearClickListener(r12));
        return;
    L5:
        r16 = r14.f3204d;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        return new ViewHolder((TextView) LayoutInflater.from(r10.getContext()).inflate(q5.h.mtrl_calendar_year, r10, false));
    }
}
