package com.obric.oui.calendar;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarView f12280a;

    public g(MaterialCalendarView r5) {
        this.f12280a = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        MaterialCalendarView r10 = this.f12280a;
        if (r5 != r10.d) goto L6;
        CalendarPager r11 = r10.e;
        r11.setCurrentItem(r11.getCurrentItem() + 1, true);
        return;
    L6:
        if (r5 != r10.f12172c) goto L10;
        CalendarPager r12 = r10.e;
        r12.setCurrentItem(r12.getCurrentItem() - 1, true);
        return;
    }
}
