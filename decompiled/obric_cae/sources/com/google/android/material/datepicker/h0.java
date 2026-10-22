package com.google.android.material.datepicker;

import android.view.View;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class h0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f4682b;

    public h0(i0 r8, int r10) {
        this.f4682b = r8;
        this.f4681a = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        i0 r10 = this.f4682b;
        int r11 = r10.f4703c.f4688p.f4622b;
        Month r12 = Month.t(this.f4681a, r11);
        i<?> r13 = r10.f4703c;
        CalendarConstraints r14 = r13.f4686n;
        Month r15 = r14.f4599a;
        Calendar r16 = r15.f4621a;
        Calendar r17 = r12.f4621a;
        if (r17.compareTo(r16) >= 0) goto L5;
        r12 = r15;
    L8:
        r13.c(r12);
        r13.d(i.e.f4700a);
        return;
    L5:
        Month r18 = r14.f4600b;
        if (r17.compareTo(r18.f4621a) <= 0) goto L8;
        r12 = r18;
        goto L8
    }
}
