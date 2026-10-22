package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.cae.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<?> f4703c;

    public static class a extends RecyclerView.c0 {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final TextView f4704t;

        public a(TextView r8) {
            super(r8);
            this.f4704t = r8;
        }
    }

    public i0(i<?> r8) {
        this.f4703c = r8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final int a() {
        return this.f4703c.f4686n.f4604p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void c(RecyclerView.c0 r8, int r10) {
        i<?> r11 = this.f4703c;
        int r12 = r11.f4686n.f4599a.f4623m + r10;
        String r13 = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(r12)});
        TextView r14 = ((a) r8).f4704t;
        r14.setText(r13);
        Context r15 = r14.getContext();
        if (g0.f().get(1) != r12) goto L5;
        String r16 = String.format(r15.getString(R.string.mtrl_picker_navigate_to_current_year_description), new Object[]{Integer.valueOf(r12)});
    L6:
        r14.setContentDescription(r16);
        b r17 = r11.f4690r;
        Calendar r18 = g0.f();
        if (r18.get(1) != r12) goto L9;
        com.google.android.material.datepicker.a r19 = r17.f4649f;
    L10:
        Iterator r20 = r11.f4685m.i().iterator();
    L12:
        if (r20.hasNext() == false) goto L16;
        r18.setTimeInMillis(((Long) r20.next()).longValue());
        if (r18.get(1) != r12) goto L12;
        r19 = r17.f4648e;
        goto L12
    L16:
        r19.b(r14);
        r14.setOnClickListener(new h0(this, r12));
        return;
    L9:
        r19 = r17.f4647d;
        goto L10
    L5:
        r16 = String.format(r15.getString(R.string.mtrl_picker_navigate_to_year_description), new Object[]{Integer.valueOf(r12)});
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final RecyclerView.c0 d(RecyclerView r8) {
        return new a((TextView) LayoutInflater.from(r8.getContext()).inflate(R.layout.mtrl_calendar_year, r8, false));
    }
}
